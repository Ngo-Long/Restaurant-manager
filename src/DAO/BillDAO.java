package DAO;

import static DAO.BanAnDAO.getConnection;
import static DAO.BanAnDAO.isBanAnIdExists;
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
import Entity.BillEntity;
import java.beans.Statement;
import java.math.BigDecimal;
import java.security.Timestamp;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class BillDAO {

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

    // Phương thức để lấy danh sách hóa đơn
    public static List<BillEntity> getAllBills() {
        List<BillEntity> billList = new ArrayList<>();
        try (Connection conn = getConnection()) {
            String sql = "SELECT * FROM HoaDon";
            try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                ResultSet rs = preparedStatement.executeQuery();

                while (rs.next()) {
                    BillEntity bill = new BillEntity();
                    bill.setIdHoaDon(rs.getInt("idHoaDon"));
                    bill.setIdDatHang(rs.getString("idDatHang"));
                    bill.setIdNhanVien(rs.getString("idNhanVien"));
                    bill.setThue(rs.getBigDecimal("thue"));
                    bill.setGiamGia(rs.getBigDecimal("giamGia"));
                    bill.setPhuongThucTT(rs.getString("phuongThucTT"));
                    bill.setThoiGianTT(rs.getTimestamp("thoiGianTT"));
                    bill.setTrangThai(rs.getString("trangThai"));
                    bill.setGhiChu(rs.getString("ghiChu"));
                    bill.setTongTien(rs.getBigDecimal("tongTien"));

                    billList.add(bill);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return billList;
    }

    // Phương thức để thêm hóa đơn
    public static void insertBill(String idDatHang, String idNhanVien, BigDecimal thue, BigDecimal giamGia,
            String phuongThucTT, String trangThai, String ghiChu, BigDecimal tongTien) throws SQLException {
        String sql = "INSERT INTO HoaDon (idDatHang, idNhanVien, thue, giamGia, phuongThucTT, trangThai, ghiChu, tongTien, thoiGianTT) VALUES (?, ?, ?, ?, ?, ?, ?, ?, GETDATE())";

        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, idDatHang);
            preparedStatement.setString(2, idNhanVien);
            preparedStatement.setBigDecimal(3, thue);
            preparedStatement.setBigDecimal(4, giamGia);
            preparedStatement.setString(5, phuongThucTT);
            preparedStatement.setString(6, trangThai);
            preparedStatement.setString(7, ghiChu);
            preparedStatement.setBigDecimal(8, tongTien);

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Hóa đơn đã được thêm thành công!");
            } else {
                System.out.println("Không thể thêm hóa đơn.");
            }
        }
    }

    public static void main(String[] args) {
        List<BillEntity> billList = BillDAO.getAllBills();

        System.out.println("Danh sách hóa đơn:");
        for (BillEntity bill : billList) {
            System.out.println("ID Hóa đơn: " + bill.getIdHoaDon());
            System.out.println("ID Đặt hàng: " + bill.getIdDatHang());
            System.out.println("ID Nhân viên: " + bill.getIdNhanVien());

            DecimalFormat percentFormat = new DecimalFormat("#,##0.00");
            System.out.println("Thuế: " + percentFormat.format(bill.getThue()));
            System.out.println("Giảm giá: " + percentFormat.format(bill.getGiamGia()));
            System.out.println("Phương thức thanh toán: " + bill.getPhuongThucTT());
            System.out.println("Thời gian thanh toán: " + bill.getThoiGianTT());
            System.out.println("Trạng thái: " + bill.getTrangThai());
            System.out.println("Ghi chú: " + bill.getGhiChu());

            DecimalFormat decimalFormat = new DecimalFormat("#,##0");
            System.out.println("Tổng tiền: " + decimalFormat.format(bill.getTongTien()));

            System.out.println("----------------------------------------");
        }

        
    }
}
