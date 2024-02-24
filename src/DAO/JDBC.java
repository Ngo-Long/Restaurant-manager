package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JDBC {

    private static final String DATABASE_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static final String DATABASE_URL = "jdbc:sqlserver://localhost:1433;databaseName=RestaurantManager;encrypt=false;trustServerCertificate=true;";
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

    // Chuẩn bị một PreparedStatement dựa trên câu SQL và các tham số truyền vào.
    public static PreparedStatement prepareStatement(String sql, Object... args) throws SQLException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = sql.trim().startsWith("{") ? connection.prepareCall(sql) : connection.prepareStatement(sql);

        // Set parameters
        for (int i = 0; i < args.length; i++) {
            preparedStatement.setObject(i + 1, args[i]);
        }

        return preparedStatement;
    }

    // Thực hiện các câu lệnh SQL UPDATE hoặc DELETE.
    public static void executeUpdate(String sql, Object... args) {
        try (PreparedStatement stmt = prepareStatement(sql, args)) {
            stmt.executeUpdate();
        } catch (SQLException e) {
            handleSQLException(e);
        }
    }

    // Thực hiện các câu lệnh SQL SELECT và trả về một ResultSet.
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
}
