package restaurant.dao;

import java.util.List;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
import restaurant.utils.XJdbc;
import restaurant.utils.Dialog;
import restaurant.entity.Invoice;

public class InvoiceDAO extends RestaurantDAO<Invoice, Integer> {

    final String INSERT_SQL = "INSERT INTO Invoice (Status) VALUES (N'Chờ thanh toán');";
    final String UPDATE_SQL = "UPDATE Invoice SET EmployeeID=?, Tax=?, Discount=?, PaymentMethod=?, "
            + "Note=?, TotalAmount=?, Status=?, PaymentTime=GETDATE() WHERE InvoiceID=?";
    final String SELECT_ALL_SQL = "SELECT * FROM Invoice";
    final String SELECT_BY_ID_SQL = "SELECT * FROM [Invoice] WHERE [InvoiceID] = ?";
    final String SELECT_LATEST_ID_SQL = "SELECT TOP 1 InvoiceID FROM Invoice ORDER BY InvoiceID DESC";

    final String SELECT_BY_TABLE_ID_SQL = "SELECT DISTINCT I.* FROM DiningTable DT "
            + "INNER JOIN OrderTable OT ON DT.TableID = OT.TableID "
            + "INNER JOIN [Order] O ON OT.OrderID = O.OrderID "
            + "INNER JOIN Invoice I ON O.InvoiceID = I.InvoiceID "
            + "WHERE I.Status != N'Đã thanh toán' AND DT.TableID = ?";

    final String SELECT_BY_CRITERIA = "SELECT TOP (1000) i.[InvoiceID], i.[EmployeeID], i.[Tax], "
            + "i.[Discount], i.[PaymentMethod], i.[PaymentTime], i.[Note], i.[TotalAmount], i.[Status] "
            + "FROM [RestaurantManager].[dbo].[Invoice] i "
            + "JOIN [RestaurantManager].[dbo].[Order] o ON i.[InvoiceID] = o.[InvoiceID] "
            + "WHERE i.[PaymentTime] >= ? "
            + "AND i.[PaymentTime] <= ? "
            + "AND i.[InvoiceID] LIKE ? "
            + "AND i.[Status] LIKE ? ";

    @Override
    public void insert(Invoice entity) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public int insert() {
        XJdbc.executeUpdate(INSERT_SQL);

        int latestInvoiceID = 0;
        try (ResultSet rs = XJdbc.executeQuery(SELECT_LATEST_ID_SQL)) {
            if (rs.next()) {
                latestInvoiceID = rs.getInt("InvoiceID");
            }
        } catch (SQLException ex) {
            Dialog.error(null, "Tạo hóa đơn thất bại!");
            throw new RuntimeException(ex);
        }

        return latestInvoiceID;
    }

    @Override
    public void update(Invoice model) {
        XJdbc.executeUpdate(UPDATE_SQL,
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

    @Override
    public Invoice getByID(Integer id) {
        List<Invoice> list = fetchByQuery(SELECT_BY_ID_SQL, id);
        return list.isEmpty() ? null : list.get(0);
    }

    public Invoice getByTableID(String id) {
        List<Invoice> list = fetchByQuery(SELECT_BY_TABLE_ID_SQL, id);
        return list.isEmpty() ? null : list.get(0);
    }

    @Override
    public List<Invoice> getAll() {
        return fetchByQuery(SELECT_ALL_SQL);
    }

    public List<Invoice> searchByCriteria(String startDate, String endDate, String id, String status) {
        String startDayTerm = startDate + " 00:00:00";
        String endDayTerm = endDate + " 23:59:59";
        String idTerm = "%" + id + "%";
        String statusTerm = "%" + status + "%";

        return fetchByQuery(SELECT_BY_CRITERIA, startDayTerm, endDayTerm, idTerm, statusTerm);
    }

    @Override
    protected List<Invoice> fetchByQuery(String sql, Object... args) {
        List<Invoice> list = new ArrayList<>();

        try (ResultSet rs = XJdbc.executeQuery(sql, args)) {
            while (rs.next()) {
                Invoice model = readFromResultSet(rs);
                list.add(model);
            }
        } catch (SQLException ex) {
            Dialog.error(null, "Lỗi dữ liệu!");
            throw new RuntimeException(ex);
        }

        return list;
    }

    private Invoice readFromResultSet(ResultSet rs) throws SQLException {
        Invoice model = new Invoice();
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
