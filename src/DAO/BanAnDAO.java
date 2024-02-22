package DAO;

import Entity.BanAnEntity;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class BanAnDAO {

    private static final String DATABASE_URL = "jdbc:sqlserver://localhost:1433;user=sa;password=songlong;databaseName=RestaurantManager;encrypt=false";
    private static final String DATABASE_USERNAME = "sa";
    private static final String DATABASE_PASSWORD = "songlong";

    public static Connection getConnection() throws SQLException {
        Connection conn = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return conn;
    }

    public static List<BanAnEntity> getDiningTableList() {
        List<BanAnEntity> listDiningTable = new ArrayList<>();

        try (Connection connection = getConnection()) {
            String sql = "SELECT * FROM BanAn";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    BanAnEntity diningTable = new BanAnEntity(
                            resultSet.getString("idBanAn"),
                            resultSet.getString("tenBanAn"),
                            resultSet.getInt("soChoNgoi"),
                            resultSet.getDouble("phuThu"),
                            resultSet.getString("trangThai"),
                            resultSet.getTimestamp("ngayThem"),
                            resultSet.getTimestamp("ngayCapNhat"),
                            resultSet.getString("moTa")
                    );

                    listDiningTable.add(diningTable);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listDiningTable;
    }

    public static void insertBanAn(String idBanAn, String tenBanAn, int soChoNgoi, double phuThu, String trangThai, String moTa) throws SQLException {
        if (isBanAnIdExists(idBanAn)) {
            JOptionPane.showMessageDialog(null, "Mã bàn đã tồn tại. Vui lòng chọn mã bàn khác.", "Thông báo", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String sql = "INSERT INTO BanAn (idBanAn, tenBanAn, soChoNgoi, phuThu, trangThai, ngayThem, ngayCapNhat, moTa) VALUES (?, ?, ?, ?, ?, GETDATE(), GETDATE(), ?)";

        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, idBanAn);
            preparedStatement.setString(2, tenBanAn);
            preparedStatement.setInt(3, soChoNgoi);
            preparedStatement.setDouble(4, phuThu);
            preparedStatement.setString(5, trangThai);
            preparedStatement.setString(6, moTa);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Thêm bàn thành công.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Thêm bàn không thành công.", "Thông báo", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static boolean isBanAnIdExists(String idBanAn) throws SQLException {
        String sql = "SELECT COUNT(*) FROM BanAn WHERE idBanAn = ?";
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, idBanAn);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    int count = resultSet.getInt(1);
                    return count > 0; // Trả về true nếu mã bàn đã tồn tại
                }
            }
        }
        return false;
    }

    public static void updateBanAn(String idBanAn, String tenBanAn, int soChoNgoi, double phuThu, String trangThai, String moTa) {
        try (Connection connection = getConnection()) {
            String sql = "UPDATE BanAn SET tenBanAn = ?, soChoNgoi = ?, phuThu = ?, trangThai = ?, moTa = ?, ngayCapNhat = GETDATE() WHERE idBanAn = ?";

            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, tenBanAn);
                preparedStatement.setInt(2, soChoNgoi);
                preparedStatement.setDouble(3, phuThu);
                preparedStatement.setString(4, trangThai);
                preparedStatement.setString(5, moTa);
                preparedStatement.setString(6, idBanAn);

                int rowsAffected = preparedStatement.executeUpdate();

                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(null, "Sửa thông tin nhân viên thành công!", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Sửa thông tin nhân viên thất bại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (SQLIntegrityConstraintViolationException e) {
            JOptionPane.showMessageDialog(null, "Lỗi: Ràng buộc dữ liệu bị vi phạm. Kiểm tra giá trị cập nhật.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi khi cập nhật thông tin nhân viên.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void deleteBanAnById(String idBanAn) throws SQLException {
        if (!isBanAnIdExists(idBanAn)) {
            JOptionPane.showMessageDialog(null, "Mã bàn không tồn tại. Vui lòng nhập lại mã bàn.", "Thông báo", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Hiển thị hộp thoại xác nhận
        int dialogResult = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn xóa bàn có mã: " + idBanAn + " không?", "Xác nhận xóa", JOptionPane.YES_NO_OPTION);

        // Kiểm tra xác nhận của người dùng
        if (dialogResult == JOptionPane.YES_OPTION) {
            String sql = "DELETE FROM BanAn WHERE idBanAn = ?";
            try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, idBanAn);

                int rowsAffected = preparedStatement.executeUpdate();

                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(null, "Xóa bàn thành công.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Xóa bàn không thành công.", "Thông báo", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

}
