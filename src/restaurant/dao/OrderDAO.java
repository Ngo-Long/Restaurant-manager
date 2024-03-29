package restaurant.dao;

import static restaurant.dao.EmployeeDAO.getConnection;
import restaurant.entity.EmployeeEntity;
import restaurant.entity.OrderEntity;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class OrderDAO {

    private static final String DATABASE_URL = "jdbc:sqlserver://localhost:1433;user=sa;password=123;databaseName=QuanLyNhaHang;encrypt=true;trustServerCertificate=true;";
    private static final String DATABASE_USERNAME = "sa";
    private static final String DATABASE_PASSWORD = "123";

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

    public static List<OrderEntity> getOrderList() {
        List<OrderEntity> orderList = new ArrayList<>();

        try (Connection connection = getConnection()) {
            String sql = "SELECT * FROM DatHang";

            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    OrderEntity order = new OrderEntity(
                            resultSet.getInt("idDatHang"),
                            resultSet.getString("idBanAn"),
                            resultSet.getString("idMonAn"),
                            resultSet.getString("idKhachHang"),
                            resultSet.getInt("soLuongMonAn"),
                            resultSet.getString("trangThaiMonAn"),
                            resultSet.getTimestamp("thoiGianDatHang"),
                            resultSet.getString("ghiChu")
                    );

                    orderList.add(order);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return orderList;
        
//        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM DatHang"); ResultSet resultSet = preparedStatement.executeQuery()) {
//
//            while (resultSet.next()) {
//                OrderEntity order = new OrderEntity(
//                        resultSet.getInt("idDatHang"),
//                        resultSet.getString("idBanAn"),
//                        resultSet.getString("idMonAn"),
//                        resultSet.getString("idKhachHang"),
//                        resultSet.getInt("soLuongMonAn"),
//                        resultSet.getString("trangThaiMonAn"),
//                        resultSet.getTimestamp("thoiGianDatHang"),
//                        resultSet.getString("ghiChu")
//                );
//
//                orderList.add(order);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return orderList;
    }

    // Phương thức để thêm đơn hàng mới
    public static void insertOrder(String idBanAn, String idMonAn, String idKhachHang, int soLuongMonAn, String trangThaiMonAn, String ghiChu) throws SQLException {
        try (Connection connection = getConnection()) {
            String sql = "INSERT INTO DatHang (idBanAn, idMonAn, idKhachHang, soLuongMonAn, trangThaiMonAn, ghiChu, thoiGianDatHang) VALUES (?, ?, ?, ?, ?, ?, GETDATE())";

            try (PreparedStatement preparedStatement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
                preparedStatement.setString(1, idBanAn);
                preparedStatement.setString(2, idMonAn);
                preparedStatement.setString(3, idKhachHang);
                preparedStatement.setInt(4, soLuongMonAn);
                preparedStatement.setString(5, trangThaiMonAn);
                preparedStatement.setString(6, ghiChu);

                int rowsAffected = preparedStatement.executeUpdate();

                if (rowsAffected > 0) {
                    ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
                    if (generatedKeys.next()) {
                        int idDatHang = generatedKeys.getInt(1);
                        JOptionPane.showMessageDialog(null, "Thêm đơn hàng thành công! ID Đơn hàng: " + idDatHang, "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Thêm đơn hàng không thành công.", "Thông báo", JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Lỗi khi thêm đơn hàng. Chi tiết lỗi: " + e.getMessage(), "Thông báo lỗi", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    // Phương thức để cập nhật lại đơn hàng
    public static void updateOrder(int idDatHang, String idBanAn, String idMonAn, String idKhachHang, int soLuongMonAn, String trangThaiMonAn, String ghiChu) throws SQLException {
        try (Connection connection = getConnection()) {
            String sql = "UPDATE DatHang SET idBanAn = ?, idMonAn = ?, idKhachHang = ?, soLuongMonAn = ?, trangThaiMonAn = ?, ghiChu = ? WHERE idDatHang = ?";

            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, idBanAn);
                preparedStatement.setString(2, idMonAn);
                preparedStatement.setString(3, idKhachHang);
                preparedStatement.setInt(4, soLuongMonAn);
                preparedStatement.setString(5, trangThaiMonAn);
                preparedStatement.setString(6, ghiChu);
                preparedStatement.setInt(7, idDatHang);

                int rowsAffected = preparedStatement.executeUpdate();

                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(null, "Cập nhật đơn hàng thành công! ID Đơn hàng: " + idDatHang, "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Cập nhật đơn hàng không thành công. Đơn hàng không tồn tại.", "Thông báo", JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Lỗi khi cập nhật đơn hàng. Chi tiết lỗi: " + e.getMessage(), "Thông báo lỗi", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    // Phương thức để thêm món ăn vào đơn hàng đã có sẵn
    public static void addFoodToOrder(int idDatHang, String idMonAn, int soLuongThem, String ghiChu) throws SQLException {
        try (Connection connection = getConnection()) {
            // Kiểm tra xem món ăn đã có trong đơn hàng chưa
            String checkFoodExistQuery = "SELECT COUNT(*) FROM DatHang WHERE idDatHang = ? AND idMonAn = ?";
            try (PreparedStatement checkStatement = connection.prepareStatement(checkFoodExistQuery)) {
                checkStatement.setInt(1, idDatHang);
                checkStatement.setString(2, idMonAn);

                try (ResultSet resultSet = checkStatement.executeQuery()) {
                    resultSet.next();
                    int existingCount = resultSet.getInt(1);

                    if (existingCount > 0) {
                        // Nếu món ăn đã có, thực hiện cập nhật số lượng và ghi chú
                        String updateFoodQuery = "UPDATE DatHang SET soLuongMonAn = soLuongMonAn + ?, ghiChu = ? WHERE idDatHang = ? AND idMonAn = ?";
                        try (PreparedStatement updateStatement = connection.prepareStatement(updateFoodQuery)) {
                            updateStatement.setInt(1, soLuongThem);
                            updateStatement.setString(2, ghiChu);
                            updateStatement.setInt(3, idDatHang);
                            updateStatement.setString(4, idMonAn);

                            int rowsAffected = updateStatement.executeUpdate();

                            if (rowsAffected > 0) {
                                JOptionPane.showMessageDialog(null, "Thêm món ăn vào đơn hàng thành công! ID Đơn hàng: " + idDatHang, "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                            } else {
                                JOptionPane.showMessageDialog(null, "Cập nhật món ăn vào đơn hàng không thành công.", "Thông báo", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    } else {
                        // Nếu món ăn chưa có, thực hiện thêm mới
                        String insertFoodQuery = "INSERT INTO DatHang (idDatHang, idMonAn, soLuongMonAn, ghiChu) VALUES (?, ?, ?, ?)";
                        try (PreparedStatement insertStatement = connection.prepareStatement(insertFoodQuery)) {
                            insertStatement.setInt(1, idDatHang);
                            insertStatement.setString(2, idMonAn);
                            insertStatement.setInt(3, soLuongThem);
                            insertStatement.setString(4, ghiChu);

                            int rowsAffected = insertStatement.executeUpdate();

                            if (rowsAffected > 0) {
                                JOptionPane.showMessageDialog(null, "Thêm món ăn vào đơn hàng thành công! ID Đơn hàng: " + idDatHang, "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                            } else {
                                JOptionPane.showMessageDialog(null, "Thêm món ăn vào đơn hàng không thành công.", "Thông báo", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Lỗi khi kiểm tra hoặc thêm món ăn vào đơn hàng. Chi tiết lỗi: " + e.getMessage(), "Thông báo lỗi", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    // Phương thức để xóa món ăn khỏi đơn hàng
    public static void removeFoodFromOrder(int idDatHang, String idMonAn) throws SQLException {
        try (Connection connection = getConnection()) {
            // Kiểm tra xem món ăn có trong đơn hàng không
            String checkFoodExistQuery = "SELECT COUNT(*) FROM DatHang WHERE idDatHang = ? AND idMonAn = ?";
            try (PreparedStatement checkStatement = connection.prepareStatement(checkFoodExistQuery)) {
                checkStatement.setInt(1, idDatHang);
                checkStatement.setString(2, idMonAn);

                try (ResultSet resultSet = checkStatement.executeQuery()) {
                    resultSet.next();
                    int existingCount = resultSet.getInt(1);

                    if (existingCount > 0) {
                        // Nếu món ăn có trong đơn hàng, thực hiện xóa
                        String removeFoodQuery = "DELETE FROM DatHang WHERE idDatHang = ? AND idMonAn = ?";
                        try (PreparedStatement removeStatement = connection.prepareStatement(removeFoodQuery)) {
                            removeStatement.setInt(1, idDatHang);
                            removeStatement.setString(2, idMonAn);

                            int rowsAffected = removeStatement.executeUpdate();

                            if (rowsAffected > 0) {
                                JOptionPane.showMessageDialog(null, "Xóa món ăn khỏi đơn hàng thành công! ID Đơn hàng: " + idDatHang, "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                            } else {
                                JOptionPane.showMessageDialog(null, "Xóa món ăn khỏi đơn hàng không thành công.", "Thông báo", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Món ăn không tồn tại trong đơn hàng.", "Thông báo", JOptionPane.ERROR_MESSAGE);
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Lỗi khi kiểm tra hoặc xóa món ăn khỏi đơn hàng. Chi tiết lỗi: " + e.getMessage(), "Thông báo lỗi", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    // Thêm bàn vào đơn hàng
    public static void addTableToOrder(int idDatHang, String idBan, String ghiChu) throws SQLException {
        try (Connection connection = getConnection()) {
            // Kiểm tra xem bàn đã có trong đơn hàng chưa
            String checkTableExistQuery = "SELECT COUNT(*) FROM DatHang WHERE idDatHang = ? AND idBan = ?";
            try (PreparedStatement checkStatement = connection.prepareStatement(checkTableExistQuery)) {
                checkStatement.setInt(1, idDatHang);
                checkStatement.setString(2, idBan);

                try (ResultSet resultSet = checkStatement.executeQuery()) {
                    resultSet.next();
                    int existingCount = resultSet.getInt(1);

                    if (existingCount > 0) {
                        // Nếu bàn đã có, thực hiện cập nhật ghi chú
                        String updateTableQuery = "UPDATE DatHang SET ghiChuBan = ? WHERE idDatHang = ? AND idBan = ?";
                        try (PreparedStatement updateStatement = connection.prepareStatement(updateTableQuery)) {
                            updateStatement.setString(1, ghiChu);
                            updateStatement.setInt(2, idDatHang);
                            updateStatement.setString(3, idBan);

                            int rowsAffected = updateStatement.executeUpdate();

                            if (rowsAffected > 0) {
                                JOptionPane.showMessageDialog(null, "Thêm bàn vào đơn hàng thành công! ID Đơn hàng: " + idDatHang, "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                            } else {
                                JOptionPane.showMessageDialog(null, "Cập nhật bàn vào đơn hàng không thành công.", "Thông báo", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    } else {
                        // Nếu bàn chưa có, thực hiện thêm mới
                        String insertTableQuery = "INSERT INTO DatHang (idDatHang, idBan, ghiChuBan) VALUES (?, ?, ?)";
                        try (PreparedStatement insertStatement = connection.prepareStatement(insertTableQuery)) {
                            insertStatement.setInt(1, idDatHang);
                            insertStatement.setString(2, idBan);
                            insertStatement.setString(3, ghiChu);

                            int rowsAffected = insertStatement.executeUpdate();

                            if (rowsAffected > 0) {
                                JOptionPane.showMessageDialog(null, "Thêm bàn vào đơn hàng thành công! ID Đơn hàng: " + idDatHang, "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                            } else {
                                JOptionPane.showMessageDialog(null, "Thêm bàn vào đơn hàng không thành công.", "Thông báo", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Lỗi khi kiểm tra hoặc thêm bàn vào đơn hàng. Chi tiết lỗi: " + e.getMessage(), "Thông báo lỗi", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    // Xóa bàn trong đơn hàng nhưng nếu có 1 bàn thì ko đc xóa
    public static void deleteTableFromOrder(int idDatHang, String idBan) throws SQLException {
        try (Connection connection = getConnection()) {
            // Kiểm tra số lượng bàn trong đơn hàng
            String countTablesQuery = "SELECT COUNT(*) FROM DatHang WHERE idDatHang = ?";
            try (PreparedStatement countStatement = connection.prepareStatement(countTablesQuery)) {
                countStatement.setInt(1, idDatHang);

                try (ResultSet resultSet = countStatement.executeQuery()) {
                    resultSet.next();
                    int tableCount = resultSet.getInt(1);

                    if (tableCount > 1) {
                        // Nếu có nhiều hơn một bàn, thực hiện xóa
                        String deleteTableQuery = "DELETE FROM DatHang WHERE idDatHang = ? AND idBan = ?";
                        try (PreparedStatement deleteStatement = connection.prepareStatement(deleteTableQuery)) {
                            deleteStatement.setInt(1, idDatHang);
                            deleteStatement.setString(2, idBan);

                            int rowsAffected = deleteStatement.executeUpdate();

                            if (rowsAffected > 0) {
                                JOptionPane.showMessageDialog(null, "Xóa bàn khỏi đơn hàng thành công! ID Đơn hàng: " + idDatHang, "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                            } else {
                                JOptionPane.showMessageDialog(null, "Xóa bàn khỏi đơn hàng không thành công.", "Thông báo", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    } else {
                        // Nếu chỉ còn một bàn, thông báo không cho phép xóa
                        JOptionPane.showMessageDialog(null, "Không thể xóa bàn khi chỉ còn một bàn trong đơn hàng.", "Thông báo", JOptionPane.ERROR_MESSAGE);
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Lỗi khi kiểm tra hoặc xóa bàn khỏi đơn hàng. Chi tiết lỗi: " + e.getMessage(), "Thông báo lỗi", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
//        OrderDAO orderDAO = new OrderDAO();
//
//        // Kiểm thử phương thức getOrderList
//        List<OrderEntity> orderList = orderDAO.getOrderList();
//
//        System.out.println("Danh sách đơn hàng:");
//        for (OrderEntity order : orderList) {
//            System.out.println("ID đơn hàng: " + order.getIdDatHang());
//            System.out.println("ID bàn ăn: " + order.getIdBanAn());
//            System.out.println("ID món ăn: " + order.getIdMonAn());
//            System.out.println("ID khách hàng: " + order.getIdKhachHang());
//            System.out.println("Số lượng món ăn: " + order.getSoLuongMonAn());
//            System.out.println("Trạng thái: " + order.getTrangThaiMonAn());
//            System.out.println("Thời gian: " + order.getThoiGianDatHang());
//            System.out.println("Ghi chú: " + order.getGhiChu());
//        }

        // Thêm một đơn hàng mới
//        try {
//            insertOrder("BA001", "MA002", null, 3, "Chưa làm xong", "");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        // Cập nhật đơn hàng mới
//        try {
//            updateOrder(1, "BA001", "MA003", null, 1, "Chưa làm xong", "");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        // Thêm món ăn vào đơn hàng
//        try {
//            addFoodToOrder(1, "MA003", 2, "");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}
