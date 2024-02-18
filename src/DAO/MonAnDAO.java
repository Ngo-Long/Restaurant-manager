package DAO;

import Entity.MonAnEntity;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MonAnDAO {

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

    public static List<MonAnEntity> getMenuItems() {
        List<MonAnEntity> menuList = new ArrayList<>();

        try (Connection connection = getConnection()) {
            String sql = "SELECT * FROM MonAn";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        MonAnEntity menuItem = new MonAnEntity(
                                resultSet.getString("idMonAn"),
                                resultSet.getString("ten"),
                                resultSet.getInt("gia"),
                                resultSet.getString("moTa"),
                                resultSet.getString("hinhAnh"),
                                resultSet.getString("phanLoai"),
                                resultSet.getString("trangThai"),
                                resultSet.getDate("ngayThem"),
                                resultSet.getDate("ngayCapNhat")
                        );

                        menuList.add(menuItem);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return menuList;
    }

    // Hàm kiểm tra ID tồn tại
    public static boolean isIdExists(String idMonAn) {
        try (Connection connection = getConnection()) {
            String sql = "SELECT COUNT(*) FROM MonAn WHERE idMonAn = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, idMonAn);

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

    // Thêm một món ăn mới vào CSDL
    public static void insertMenuItem(String idMonAn, String tenMonAn, int giaMonAn, String moTaMonAn, String hinhAnhMonAn, String phanLoaiMonAn, String trangThaiMonAn) {
        try (Connection connection = getConnection()) {
            // Kiểm tra ID tồn tại
            if (isIdExists(idMonAn)) {
                System.out.println("Lỗi: ID đã tồn tại!");
                return;
            }

            // Kiểm tra các ô khác có bỏ trống không
            if (idMonAn.isEmpty() || tenMonAn.isEmpty() || giaMonAn <= 0) {
                System.out.println("Lỗi: Vui lòng nhập đầy đủ thông tin!");
                return;
            }

            String sql = "INSERT INTO MonAn (idMonAn, ten, gia, moTa, hinhAnh, phanLoai, trangThai, ngayThem, ngayCapNhat) VALUES (?, ?, ?, ?, ?, ?, ?, GETDATE(), GETDATE())";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, idMonAn);
                preparedStatement.setString(2, tenMonAn);
                preparedStatement.setInt(3, giaMonAn);
                preparedStatement.setString(4, moTaMonAn);
                preparedStatement.setString(5, hinhAnhMonAn);
                preparedStatement.setString(6, phanLoaiMonAn);
                preparedStatement.setString(7, trangThaiMonAn);

                int rowsAffected = preparedStatement.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("Thêm món ăn thành công!");
                } else {
                    System.out.println("Thêm món ăn thất bại!");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Xóa một món ăn từ CSDL
    public static void deleteMenuItem(String idMonAn) {
        try (Connection connection = getConnection()) {
            String sql = "DELETE FROM MonAn WHERE idMonAn = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, idMonAn);

                int rowsAffected = preparedStatement.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("Xóa món ăn thành công!");
                } else {
                    System.out.println("Xóa món ăn thất bại!");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Sửa thông tin của một món ăn trong CSDL
    public static void updateMenuItem(String idMonAn, String tenMonAnMoi, int giaMonAnMoi, String moTa, String hinhAnh, String phanLoai, String trangThai) {
        try (Connection connection = getConnection()) {
            String sql = "UPDATE MonAn SET ten = ?, gia = ?, moTa = ?, hinhAnh = ?, phanLoai = ?, trangThai = ?, ngayCapNhat = GETDATE() WHERE idMonAn = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, tenMonAnMoi);
                preparedStatement.setInt(2, giaMonAnMoi);
                preparedStatement.setString(3, moTa);
                preparedStatement.setString(4, hinhAnh);
                preparedStatement.setString(5, phanLoai);
                preparedStatement.setString(6, trangThai);
                preparedStatement.setString(7, idMonAn);

                int rowsAffected = preparedStatement.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("Sửa thông tin món ăn thành công!");
                } else {
                    System.out.println("Sửa thông tin món ăn thất bại!");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Xem chi tiết một món ăn và các nguyên liệu sử dụng
    public static void viewMenuItemDetails(String idMonAn) {
        try (Connection connection = getConnection()) {
            // Lấy thông tin chi tiết của món ăn
            String sqlMonAn = "SELECT * FROM MonAn WHERE idMonAn = ?";
            try (PreparedStatement preparedStatementMonAn = connection.prepareStatement(sqlMonAn)) {
                preparedStatementMonAn.setString(1, idMonAn);
                ResultSet resultSetMonAn = preparedStatementMonAn.executeQuery();

                while (resultSetMonAn.next()) {
                    System.out.println("Thông tin chi tiết món ăn:");
                    System.out.println("ID Món ăn: " + resultSetMonAn.getString("idMonAn"));
                    System.out.println("Tên món ăn: " + resultSetMonAn.getString("ten"));
                    System.out.println("Giá món ăn: " + resultSetMonAn.getDouble("gia")); // Sửa đây
                }
            }

            // Lấy thông tin các nguyên liệu sử dụng trong món ăn
            String sqlNguyenLieu = "SELECT NL.* FROM NghienLieu NL "
                    + "JOIN MonAn_NghienLieu MNL ON NL.idNghienLieu = MNL.idNghienLieu "
                    + "WHERE MNL.idMonAn = ?";
            try (PreparedStatement preparedStatementNguyenLieu = connection.prepareStatement(sqlNguyenLieu)) {
                preparedStatementNguyenLieu.setString(1, idMonAn);
                ResultSet resultSetNguyenLieu = preparedStatementNguyenLieu.executeQuery();

                System.out.println("\nNguyên liệu sử dụng trong món ăn:");

                while (resultSetNguyenLieu.next()) {
                    System.out.println("ID Nguyên liệu: " + resultSetNguyenLieu.getString("idNghienLieu"));
                    System.out.println("Tên nguyên liệu: " + resultSetNguyenLieu.getString("ten"));
                    System.out.println("Đơn giá nguyên liệu: " + resultSetNguyenLieu.getDouble("donGia"));
                    System.out.println("Số lượng: " + resultSetNguyenLieu.getInt("soLuong"));
                    System.out.println("Ngày sản xuất: " + resultSetNguyenLieu.getTimestamp("ngaySanXuat"));
                    System.out.println("Ngày hết hạn: " + resultSetNguyenLieu.getTimestamp("ngayHetHan"));
                    System.out.println("------------------------------");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

//
//        // Thêm một món ăn mới
//        insertMenuItem("MA006", "Mì cay hải sản", 35000);
//
//        // Xóa một món ăn
//        deleteMenuItem("MA006");
//
//        // Sửa thông tin của một món ăn
//        updateMenuItem("MA001", "Mì cay bò cấp 7", 55000, "Mô tả mới", "D:\\FPT Polytechnic\\KiThuatPhanMem\\KTLT\\KTLT\\src\\icon\\logo.jpg", "Mì cay", "Bật hoạt động");
//
//        // Xem chi tiết một món ăn và các nguyên liệu sử dụng
//        viewMenuItemDetails("MA001");
        // Kết nối CSDL và lấy danh sách món ăn
//        getMenuItems();
    }
}
