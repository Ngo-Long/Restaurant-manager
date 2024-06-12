package restaurant.dao;

import java.util.List;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
import restaurant.utils.JDBC;
import restaurant.entity.InvoiceEntity;
import restaurant.utils.Dialog;

public class InvoiceDAO {

    public static final String INSERT_SQL = "INSERT INTO Invoices (Status) VALUES (N'Chờ thanh toán');";
    public static final String UPDATE_SQL = "UPDATE Invoices SET EmployeeID=?, Tax=?, Discount=?, PaymentMethod=?, Note=?, "
            + "TotalAmount=?, Status=?, PaymentTime=GETDATE() WHERE InvoiceID=?";
    public static final String SELECT_ALL_SQL = "SELECT * FROM Invoices;";
    public static final String SELECT_ALL_UNPAID_SQL = "SELECT * FROM Invoices WHERE Status = N'Chờ thanh toán';";
    public static final String SELECT_BY_ID_SQL = "SELECT * FROM Invoices WHERE InvoiceID = ?";
    public static final String SELECT_ID_BY_TABLE_ID_SQL = "SELECT InvoiceID FROM Orders WHERE TableID = ? AND InvoiceID IN "
            + "(SELECT InvoiceID FROM Invoices WHERE Status != N'Đã thanh toán')";
    public static final String SELECT_LATEST_ID_SQL = "SELECT TOP 1 InvoiceID FROM Invoices ORDER BY InvoiceID DESC";

    public int insert() {
        JDBC.executeUpdate(INSERT_SQL);

        int latestInvoiceID = 0;
        try (ResultSet rs = JDBC.executeQuery(SELECT_LATEST_ID_SQL)) {
            if (rs.next()) {
                latestInvoiceID = rs.getInt("InvoiceID");
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        return latestInvoiceID;
    }

    public void update(InvoiceEntity model) {
        JDBC.executeUpdate(UPDATE_SQL,
                model.getEmployeeID(),
                model.getTax(),
                model.getDiscount(),
                model.getPaymentMethod(),
                model.getNote(),
                model.getTotalAmount(),
                model.getStatus(),
                model.getInvoiceID()
        );
    }

    public List<InvoiceEntity> getAll() {
        return fetchByQuery(SELECT_ALL_SQL);
    }

    public List<InvoiceEntity> getAllUnPaid() {
        return fetchByQuery(SELECT_ALL_UNPAID_SQL);
    }

    public int getIdByTableId(String tableId) {
        try (ResultSet rs = JDBC.executeQuery(SELECT_ID_BY_TABLE_ID_SQL, tableId)) {
            return rs.next() ? rs.getInt("InvoiceID") : 0;
        } catch (SQLException ex) {
            Dialog.error(null, "Lỗi dữ liệu!");
            throw new RuntimeException(ex);
        }
    }

    private List<InvoiceEntity> fetchByQuery(String sql, Object... args) {
        List<InvoiceEntity> list = new ArrayList<>();

        try (ResultSet rs = JDBC.executeQuery(sql, args)) {
            while (rs.next()) {
                InvoiceEntity model = readFromResultSet(rs);
                list.add(model);
            }
        } catch (SQLException ex) {
            Dialog.error(null, "Lỗi dữ liệu!");
            throw new RuntimeException(ex);
        }

        return list;
    }

    private InvoiceEntity readFromResultSet(ResultSet rs) throws SQLException {
        InvoiceEntity model = new InvoiceEntity();
        model.setInvoiceID(rs.getInt("InvoiceID"));
        model.setEmployeeID(rs.getString("EmployeeID"));
        model.setTax(rs.getInt("Tax"));
        model.setDiscount(rs.getInt("Discount"));
        model.setPaymentMethod(rs.getString("PaymentMethod"));
        model.setPaymentTime(rs.getTimestamp("PaymentTime"));
        model.setStatus(rs.getString("Status"));
        model.setNote(rs.getString("Note"));
        model.setTotalAmount(rs.getInt("TotalAmount"));
        return model;
    }
}
