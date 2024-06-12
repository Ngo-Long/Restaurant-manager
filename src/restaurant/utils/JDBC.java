package restaurant.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JDBC {

    public static Connection conn = null; // Kết nối với sql
    public static PreparedStatement ps = null; // Câu lệnh SQL được biên dịch trước
    public static ResultSet rs = null; // Trả về kết quả truy vấn
    private static final String DATABASE_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static final String DATABASE_URL = "jdbc:sqlserver://localhost:1433;databaseName=RestaurantManager;encrypt=true;trustServerCertificate=true;";
    private static final String DATABASE_USERNAME = "sa";
    private static final String DATABASE_PASSWORD = "songlong";

    // Khối static chạy khi lớp được tải vào bộ nhớ. Đăng ký driver JDBC.
    static {
        try {
            Class.forName(DATABASE_DRIVER);
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
    }

    /**
     * Xây dựng PreparedStatement
     *
     * @param sql là câu lệnh SQL chứa có thể chứa tham số. Nó có thể là một lời
     * gọi thủ tục lưu
     * @param args là danh sách các giá trị được cung cấp cho các tham số trong
     * câu lệnh sql
     * @return PreparedStatement tạo được
     * @throws java.sql.SQLException lỗi sai cú pháp
     */
    public static PreparedStatement prepareStatement(String sql, Object... args) throws SQLException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = sql.trim().startsWith("{") ? connection.prepareCall(sql) : connection.prepareStatement(sql);

        // Set parameters
        for (int i = 0; i < args.length; i++) {
            preparedStatement.setObject(i + 1, args[i]);
        }

        return preparedStatement;
    }

    /**
     * Thực hiện câu lệnh SQL thao tác (INSERT, UPDATE, DELETE) hoặc thủ tục lưu
     * thao tác dữ liệu
     *
     * @param sql là câu lệnh SQL chứa có thể chứa tham số. Nó có thể là một lời
     * gọi thủ tục lưu
     * @param args là danh sách các giá trị được cung cấp cho các tham số trong
     * câu lệnh sql
     */
    public static void executeUpdate(String sql, Object... args) {
        try (PreparedStatement stmt = prepareStatement(sql, args)) {
            stmt.executeUpdate();
        } catch (SQLException e) {
            handleSQLException(e);
        }
    }

    /**
     * Thực hiện câu lệnh SQL truy vấn (SELECT) hoặc thủ tục lưu truy vấn dữ
     * liệu
     *
     * @param sql là câu lệnh SQL chứa có thể chứa tham số. Nó có thể là một lời
     * gọi thủ tục lưu
     * @param args là danh sách các giá trị được cung cấp cho các tham số trong
     * câu lệnh sql
     */
    public static ResultSet executeQuery(String sql, Object... args) {
        try {
            PreparedStatement stmt = prepareStatement(sql, args);
            return stmt.executeQuery();
        } catch (SQLException e) {
            handleSQLException(e);
            return null;
        }
    }

    // Đóng tài nguyên (AutoCloseable) như Connection, PreparedStatement, ResultSet.
    public static void close(AutoCloseable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception e) {
                handleException(e);
            }
        }
    }

    private static void handleSQLException(SQLException e) {
        Logger.getLogger(JDBC.class.getName()).log(Level.SEVERE, null, e); // Xử lý hoặc log thông báo lỗi
        throw new RuntimeException(e); // Ném lại RuntimeException để chương trình dừng lại.
    }

    private static void handleException(Exception e) {
        Logger.getLogger(JDBC.class.getName()).log(Level.SEVERE, null, e); // Xử lý hoặc log thông báo lỗi
        throw new RuntimeException(e); // Ném lại RuntimeException để chương trình dừng lại.
    }

    public static long getLastInsertId() throws SQLException {
        String sql = "SELECT SCOPE_IDENTITY()"; // Get last identity value
        try (PreparedStatement stmt = prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1); // Retrieve and return the ID
            } else {
                throw new SQLException("Failed to retrieve last inserted ID");
            }
        }
    }

}
