package DAO;

import Entity.NhanVienEntity;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class NhanVienDAO {

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

    // Check if an employee ID already exists
    public static boolean isIdExists(String idNhanVien) {
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

    // Create a new employee
    public static void insertEmployee(String idNhanVien, String idCa, String hoTen, String gioiTinh, String sdt,
            String ngaySinh, String cmnd, String email, String diaChi, String hinhAnh, String chucVu,
            String trangThai, double luong, String moTa, String nganHang, String soTaiKhoan) throws ParseException {
        try (Connection connection = getConnection()) {
            String sql = "INSERT INTO NhanVien (idNhanVien, idCa, hoTen, gioiTinh, sdt, ngaySinh, cmnd, email, diaChi, hinhAnh, chucVu, trangThai, luong, moTa, nganHang, soTaiKhoan) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, idNhanVien);
                preparedStatement.setString(2, idCa);
                preparedStatement.setString(3, hoTen);
                preparedStatement.setString(4, gioiTinh);
                preparedStatement.setString(5, sdt);

//                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//                Date parsedDate = dateFormat.parse(ngaySinh);
//                preparedStatement.setDate(6, new java.sql.Date(parsedDate.getTime()));
                
                preparedStatement.setString(6, ngaySinh);
                preparedStatement.setString(7, cmnd);
                preparedStatement.setString(8, email);
                preparedStatement.setString(9, diaChi);
                preparedStatement.setString(10, hinhAnh);
                preparedStatement.setString(11, chucVu);
                preparedStatement.setString(12, trangThai);
                preparedStatement.setDouble(13, luong);
                preparedStatement.setString(14, moTa);
                preparedStatement.setString(15, nganHang);
                preparedStatement.setString(16, soTaiKhoan);

                int rowsAffected = preparedStatement.executeUpdate();

                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(null, "Thêm nhân viên thành công!", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Thêm nhân viên thất bại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi khi thêm mới nhân viên.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    // Read employee details
    public static NhanVienEntity viewEmployeeDetails(String idNhanVien) {
        NhanVienEntity employee = null;

        try (Connection connection = getConnection()) {
            String sql = "SELECT * FROM NhanVien WHERE idNhanVien = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, idNhanVien);
                ResultSet resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    employee = new NhanVienEntity(
                            resultSet.getString("idNhanVien"),
                            resultSet.getString("idCa"),
                            resultSet.getString("hoTen"),
                            resultSet.getString("gioiTinh"),
                            resultSet.getString("sdt"),
                            resultSet.getDate("ngaySinh"),
                            resultSet.getString("cmnd"),
                            resultSet.getString("email"),
                            resultSet.getString("diaChi"),
                            resultSet.getString("hinhAnh"),
                            resultSet.getString("chucVu"),
                            resultSet.getString("trangThai"),
                            resultSet.getDouble("luong"),
                            resultSet.getString("moTa"),
                            resultSet.getString("nganHang"),
                            resultSet.getString("soTaiKhoan"),
                            resultSet.getTimestamp("ngayVaoLam")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return employee;
    }

    // Update employee information
    public static void updateEmployee(String idNhanVien, String idCa, String newHoTen, String newChucVu, double newLuong,
            String newGioiTinh, String newSdt, String newNgaySinh, String newCmnd, String newEmail, String newDiaChi,
            String newHinhAnhPath, String newMoTa, String newNganHang, String newSoTaiKhoan, String newTrangThai) {

        try (Connection connection = getConnection()) {
            String sql = "UPDATE NhanVien SET hoTen = ?, chucVu = ?, luong = ?, gioiTinh = ?, sdt = ?, ngaySinh = ?, cmnd = ?, "
                    + "email = ?, diaChi = ?, hinhAnh = ?, moTa = ?, nganHang = ?, soTaiKhoan = ?, trangThai = ?, idCa = ? WHERE idNhanVien = ?";

            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, newHoTen);
                preparedStatement.setString(2, newChucVu);
                preparedStatement.setDouble(3, newLuong);
                preparedStatement.setString(4, newGioiTinh);
                preparedStatement.setString(5, newSdt);
                preparedStatement.setString(6, newNgaySinh);
                preparedStatement.setString(7, newCmnd);
                preparedStatement.setString(8, newEmail);
                preparedStatement.setString(9, newDiaChi);
                preparedStatement.setString(10, newHinhAnhPath);
                preparedStatement.setString(11, newMoTa);
                preparedStatement.setString(12, newNganHang);
                preparedStatement.setString(13, newSoTaiKhoan);
                preparedStatement.setString(14, newTrangThai);
                preparedStatement.setString(15, idCa);
                preparedStatement.setString(16, idNhanVien);

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

    // Update employee status to "Nghỉ Việc"
    public static void updateEmployeeStatus(String idNhanVien, String newStatus) {
        try (Connection connection = getConnection()) {
            String sql = "UPDATE NhanVien SET trangThai = ? WHERE idNhanVien = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, newStatus);
                preparedStatement.setString(2, idNhanVien);

                int rowsAffected = preparedStatement.executeUpdate();

                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(null, "Cập nhật trạng thái nhân viên thành công!", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Cập nhật trạng thái nhân viên thất bại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi khi cập nhật trạng thái nhân viên.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    public static void searchAndClassifyEmployee(String keyword, String chucVu, String idCa, DefaultTableModel model) {
        try (Connection connection = getConnection()) {
            String sql = "SELECT * FROM NhanVien WHERE (? IS NULL OR chucVu LIKE ?) AND (? IS NULL OR idCa LIKE ?) "
                    + "AND (hoTen LIKE ? OR idNhanVien LIKE ?)";

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
                        resultSet.getString("gioiTinh"),
                        resultSet.getString("ngaySinh"),
                        resultSet.getString("chucVu"),
                        resultSet.getString("idCa"),
                        resultSet.getDouble("luong"),
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

    public static List<NhanVienEntity> getAllEmployees() {
        List<NhanVienEntity> employeeList = new ArrayList<>();

        try (Connection connection = getConnection()) {
            String sql = "SELECT * FROM NhanVien";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    NhanVienEntity employee = new NhanVienEntity(
                            resultSet.getString("idNhanVien"),
                            resultSet.getString("idCa"),
                            resultSet.getString("hoTen"),
                            resultSet.getString("gioiTinh"),
                            resultSet.getString("sdt"),
                            resultSet.getDate("ngaySinh"),
                            resultSet.getString("cmnd"),
                            resultSet.getString("email"),
                            resultSet.getString("diaChi"),
                            resultSet.getString("hinhAnh"),
                            resultSet.getString("chucVu"),
                            resultSet.getString("trangThai"),
                            resultSet.getDouble("luong"),
                            resultSet.getString("moTa"),
                            resultSet.getString("nganHang"),
                            resultSet.getString("soTaiKhoan"),
                            resultSet.getTimestamp("ngayVaoLam")
                    );

                    employeeList.add(employee);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return employeeList;
    }

}
