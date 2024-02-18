package DAO;

import Entity.NguyenLieuEntity;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class NguyenLieuDAO {

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

    public static List<NguyenLieuEntity> getIngredientList() {
        List<NguyenLieuEntity> listNguyenLieu = new ArrayList<>();

        try (Connection connection = getConnection()) {
            String sql = "SELECT * FROM NguyenLieu";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    NguyenLieuEntity nguyenLieu = new NguyenLieuEntity();
                    nguyenLieu.setIdNguyenLieu(resultSet.getString("idNguyenLieu"));
                    nguyenLieu.setTenNguyenLieu(resultSet.getString("tenNguyenLieu"));
                    nguyenLieu.setSoLuongBanDau(resultSet.getInt("soLuongBanDau"));
                    nguyenLieu.setSoLuongToiThieu(resultSet.getInt("soLuongToiThieu"));
                    nguyenLieu.setDonGia(resultSet.getInt("donGia"));
                    nguyenLieu.setNgaySanXuat(resultSet.getDate("ngaySanXuat"));
                    nguyenLieu.setNgayHetHan(resultSet.getDate("ngayHetHan"));
                    nguyenLieu.setTrangThai(resultSet.getString("trangThai"));
                    listNguyenLieu.add(nguyenLieu);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listNguyenLieu;
    }

    private static boolean isIdIngredientExists(String idNguyenLieu) {
        String query = "SELECT COUNT(*) FROM NguyenLieu WHERE idNguyenLieu = ?";

        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, idNguyenLieu);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    int count = resultSet.getInt(1);
                    return count > 0;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public static void insertIngredient(String idNguyenLieu, String tenNguyenLieu, int soLuongBanDau, int soLuongToiThieu, double donGia, String trangThai) throws SQLException {
        // Check if the ID already exists
        if (isIdIngredientExists(idNguyenLieu)) {
            JOptionPane.showMessageDialog(null, "Mã nguyên liệu đã tồn tại. Vui lòng chọn mã khác.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Validate inputs
        if (idNguyenLieu == null || idNguyenLieu.isEmpty()
                || tenNguyenLieu == null || tenNguyenLieu.isEmpty()
                || soLuongBanDau < 0 || soLuongToiThieu < 0 || donGia < 0) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin và giá trị không âm.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String sql = "INSERT INTO NguyenLieu (idNguyenLieu, tenNguyenLieu, soLuongBanDau, soLuongToiThieu, donGia, trangThai) "
                + "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, idNguyenLieu);
            preparedStatement.setString(2, tenNguyenLieu);
            preparedStatement.setInt(3, soLuongBanDau);
            preparedStatement.setInt(4, soLuongToiThieu);
            preparedStatement.setDouble(5, donGia);
            preparedStatement.setString(6, trangThai);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Thêm nguyên liệu thành công.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Thêm nguyên liệu không thành công.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void updateIngredient(String idNguyenLieu, String tenNguyenLieu, int soLuongBanDau, int soLuongToiThieu, double donGia, String trangThai) throws SQLException {
        // Check if the ID already exists
        if (!isIdIngredientExists(idNguyenLieu)) {
            JOptionPane.showMessageDialog(null, "Mã nguyên liệu không tồn tại. Vui lòng nhập lại mã.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Validate inputs
        if (idNguyenLieu == null || idNguyenLieu.isEmpty()
                || tenNguyenLieu == null || tenNguyenLieu.isEmpty()
                || soLuongBanDau < 0 || soLuongToiThieu < 0 || donGia < 0) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin và giá trị không âm.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String sql = "UPDATE NguyenLieu SET tenNguyenLieu = ?, soLuongBanDau = ?, soLuongToiThieu = ?, donGia = ?, trangThai = ? WHERE idNguyenLieu = ?";

        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, tenNguyenLieu);
            preparedStatement.setInt(2, soLuongBanDau);
            preparedStatement.setInt(3, soLuongToiThieu);
            preparedStatement.setDouble(4, donGia);
            preparedStatement.setString(5, trangThai);
            preparedStatement.setString(6, idNguyenLieu);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Cập nhật nguyên liệu thành công.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Cập nhật nguyên liệu không thành công.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void deleteIngredient(String idNguyenLieu) throws SQLException {
        // Check if the ID already exists
        if (!isIdIngredientExists(idNguyenLieu)) {
            JOptionPane.showMessageDialog(null, "Mã nguyên liệu không tồn tại. Vui lòng nhập lại mã.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String sql = "DELETE FROM NguyenLieu WHERE idNguyenLieu = ?";

        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, idNguyenLieu);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Xóa nguyên liệu thành công.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Xóa nguyên liệu không thành công.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void searchAndClassifyIngredient(String keyword, String trangThai, DefaultTableModel model) {
        try (Connection connection = getConnection()) {
            String sql = "SELECT * FROM NguyenLieu WHERE (? IS NULL OR trangThai LIKE ?)"
                    + "AND (tenNguyenLieu LIKE ? OR idNguyenLieu LIKE ?)";

            if ("Trạng thái".equals(trangThai)) {
                trangThai = null;
            }

            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, trangThai);
                preparedStatement.setString(2, trangThai != null ? "%" + trangThai + "%" : "%");
                preparedStatement.setString(3, "%" + keyword + "%");
                preparedStatement.setString(4, "%" + keyword + "%");

                ResultSet resultSet = preparedStatement.executeQuery();

                model.setRowCount(0);

                while (resultSet.next()) {
                    Object[] row = {
                        resultSet.getString("idNguyenLieu"),
                        resultSet.getString("tenNguyenLieu"),
                        resultSet.getString("soLuongBanDau"),
                        resultSet.getString("soLuongToiThieu"),
                        resultSet.getInt("donGia"),
                        resultSet.getString("trangThai")
                    };
                    model.addRow(row);
                }

                if (model.getRowCount() > 0) {
                    JOptionPane.showMessageDialog(null, "Tìm kiếm và phân loại thành công!", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Không tìm thấy kết quả nào!", "Thông Báo", JOptionPane.WARNING_MESSAGE);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi khi tìm kiếm và phân loại nhân viên.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
}
