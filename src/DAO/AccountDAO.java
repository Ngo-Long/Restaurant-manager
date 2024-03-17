package DAO;

import Entity.AccountEntity;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class AccountDAO {

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

    // Kiểm tra sự tồn tại của idNhanVien trước khi thêm tài khoản
    public static boolean isIdNhanVienExists(String idNhanVien) {
        try (Connection connection = getConnection()) {
            String sql = "SELECT COUNT(*) FROM NhanVien WHERE idNhanVien = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, idNhanVien);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        int count = resultSet.getInt(1);
                        return count > 0;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Thêm tài khoản với kiểm tra sự tồn tại của idNhanVien
    public static void insertAccount(String idTaiKhoan, String idNhanVien, String taiKhoan, String matKhau) {
        try {
            if (!isIdNhanVienExists(idNhanVien)) {
                JOptionPane.showMessageDialog(null, "ID Nhân viên không tồn tại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }

            try (Connection connection = getConnection()) {
                String sql = "INSERT INTO TaiKhoan (idTaiKhoan, idNhanVien, taiKhoan, matKhau) VALUES (?, ?, ?, ?)";
                try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                    preparedStatement.setString(1, idTaiKhoan);
                    preparedStatement.setString(2, idNhanVien);
                    preparedStatement.setString(3, taiKhoan);
                    preparedStatement.setString(4, matKhau);

                    int rowsAffected = preparedStatement.executeUpdate();

                    if (rowsAffected > 0) {
                        JOptionPane.showMessageDialog(null, "Thêm tài khoản thành công!", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Thêm tài khoản thất bại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi khi thêm mới tài khoản.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    // Update user account information
    public static void updateAccount(String idTaiKhoan, String newTaiKhoan, String newMatKhau) {
        try (Connection connection = getConnection()) {
            String sql = "UPDATE TaiKhoan SET taiKhoan = ?, matKhau = ? WHERE idTaiKhoan = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, newTaiKhoan);
                preparedStatement.setString(2, newMatKhau);
                preparedStatement.setString(3, idTaiKhoan);

                int rowsAffected = preparedStatement.executeUpdate();

                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(null, "Sửa thông tin tài khoản thành công!", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Sửa thông tin tài khoản thất bại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (SQLIntegrityConstraintViolationException e) {
            JOptionPane.showMessageDialog(null, "Lỗi: Ràng buộc dữ liệu bị vi phạm. Kiểm tra giá trị cập nhật.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi khi cập nhật thông tin tài khoản.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    // Delete user account
    public static void deleteAccount(String idTaiKhoan) {
        try (Connection connection = getConnection()) {
            String sql = "DELETE FROM TaiKhoan WHERE idTaiKhoan = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, idTaiKhoan);

                int rowsAffected = preparedStatement.executeUpdate();

                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(null, "Xóa tài khoản thành công!", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Xóa tài khoản thất bại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi khi xóa tài khoản.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    // Load user accounts into a table model
    public static void loadAccountIntoTable(DefaultTableModel model) {
        try (Connection connection = getConnection()) {
            String sql = "SELECT * FROM TaiKhoan";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql); ResultSet resultSet = preparedStatement.executeQuery()) {

                model.setRowCount(0);

                while (resultSet.next()) {
                    Object[] row = {
                        resultSet.getString("idTaiKhoan"),
                        resultSet.getString("idNhanVien"),
                        resultSet.getString("taiKhoan"),
                        resultSet.getString("matKhau"),
                        resultSet.getString("chucVu")
                    };
                    model.addRow(row);
                }

                // Check if any rows were added to the table
                if (model.getRowCount() > 0) {
                    JOptionPane.showMessageDialog(null, "Tải tài khoản thành công!", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Không có tài khoản nào được tải!", "Thông Báo", JOptionPane.WARNING_MESSAGE);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi khi tải tài khoản.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    public static List<AccountEntity> getAllAccount() {
        List<AccountEntity> taiKhoanList = new ArrayList<>();

        try (Connection connection = getConnection()) {
            String sql = "SELECT * FROM TaiKhoan";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql); ResultSet resultSet = preparedStatement.executeQuery()) {

                while (resultSet.next()) {
                    AccountEntity taiKhoan = new AccountEntity(
                            resultSet.getString("idTaiKhoan"),
                            resultSet.getString("idNhanVien"),
                            resultSet.getString("taiKhoan"),
                            resultSet.getString("matKhau"),
                            resultSet.getString("ngayTao")
                    );

                    taiKhoanList.add(taiKhoan);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi khi tải tài khoản.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }

        return taiKhoanList;
    }

    public static void searchAndClassifyEmployee(String keyword, String chucVu, String idCa, DefaultTableModel model) {
        try (Connection connection = getConnection()) {
            String sql = "SELECT N.*, TK.taiKhoan, TK.matKhau, TK.ngayTao "
                    + "FROM NhanVien N LEFT JOIN TaiKhoan TK ON N.idNhanVien = TK.idNhanVien "
                    + "WHERE (? IS NULL OR N.chucVu LIKE ?) AND (? IS NULL OR N.idCa LIKE ?) "
                    + "AND (N.hoTen LIKE ? OR N.idNhanVien LIKE ?)";

            if ("Tất Cả CV".equals(chucVu)) {
                chucVu = null;
            }

            if ("Tất Cả Ca".equals(idCa)) {
                idCa = null;
            }

            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, chucVu);
                preparedStatement.setString(2, chucVu != null ? "%" + chucVu + "%" : "%");
                preparedStatement.setString(3, idCa);
                preparedStatement.setString(4, idCa != null ? "%" + idCa + "%" : "%");
                preparedStatement.setString(5, "%" + keyword + "%");
                preparedStatement.setString(6, "%" + keyword + "%");

                ResultSet resultSet = preparedStatement.executeQuery();

                model.setRowCount(0);

                while (resultSet.next()) {
                    Object[] row = {
                        resultSet.getString("idNhanVien"),
                        resultSet.getString("hoTen"),
                        resultSet.getString("chucVu"),
                        resultSet.getString("taiKhoan"),
                        resultSet.getString("matKhau"),
                        resultSet.getString("ngayTao")
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
