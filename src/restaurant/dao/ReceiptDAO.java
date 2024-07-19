package restaurant.dao;

import java.util.List;
import java.util.ArrayList;

import java.sql.ResultSet;
import java.sql.SQLException;

import restaurant.utils.XJdbc;
import restaurant.entity.Receipt;

public class ReceiptDAO extends RestaurantDAO<Receipt, String> {

    final String INSERT_SQL = "INSERT INTO Receipt (ReceiptID, SupplierID, EmployeeID, "
            + "TransactionType, ReceiptDate, TotalAmount, Note, Status) "
            + "VALUES (?, ?, ?, ?, GETDATE(), ?, ?, ?)";
    final String UPDATE_SQL = "UPDATE Receipt SET SupplierID=?, EmployeeID=?, "
            + "TransactionType=?, TotalAmount=?, Note=?, Status=? WHERE ReceiptID=?";
    final String DELETE_SQL = "DELETE FROM Receipt WHERE ReceiptID =?";

    final String IS_EXISTS_SQL = "SELECT COUNT(*) FROM Receipt WHERE ReceiptID = ?";
    final String SELECT_LATEST_ID_SQL = "SELECT TOP 1 ReceiptID FROM Receipt ORDER BY ReceiptID DESC";

    final String SELECT_ALL_SQL = "SELECT * FROM Receipt";
    final String SELECT_BY_ID_SQL = "SELECT * FROM Receipt WHERE ReceiptID=?";

    final String SELECT_BY_CRITERIA = "SELECT TOP (1000) r.[ReceiptID], r.[SupplierID], "
            + "r.[EmployeeID], r.[TransactionType], r.[ReceiptDate], "
            + "r.[TotalAmount], r.[Note], r.[Status] "
            + "FROM [RestaurantManager].[dbo].[Receipt] r "
            + "INNER JOIN [RestaurantManager].[dbo].[Supplier] s "
            + "ON r.[SupplierID] = s.[SupplierID] "
            + "WHERE (s.[SupplierName] LIKE ? OR r.[ReceiptID] LIKE ?) "
            + "AND r.[TransactionType] LIKE ? "
            + "AND r.[Status] LIKE ? ";

    @Override
    public void insert(Receipt entity) {
        XJdbc.executeUpdate(INSERT_SQL,
                entity.getReceiptID(),
                entity.getSupplierID(),
                entity.getEmployeeID(),
                entity.getTransactionType(),
                entity.getTotalAmount(),
                entity.getNote(),
                entity.getStatus()
        );
    }

    public String insert() {
        XJdbc.executeUpdate(INSERT_SQL);

        String latestReceiptID = null;
        try (ResultSet rs = XJdbc.executeQuery(SELECT_LATEST_ID_SQL)) {
            if (rs.next()) {
                latestReceiptID = rs.getString("ReceiptID");
            }
        } catch (SQLException ex) {
        }

        return latestReceiptID;
    }

    @Override
    public void update(Receipt entity) {
        XJdbc.executeUpdate(UPDATE_SQL,
                entity.getSupplierID(),
                entity.getEmployeeID(),
                entity.getTransactionType(),
                entity.getTotalAmount(),
                entity.getNote(),
                entity.getStatus(),
                entity.getReceiptID()
        );
    }

    @Override
    public void delete(String id) {
        XJdbc.executeUpdate(DELETE_SQL, id);
    }

    @Override
    public Receipt getByID(String id) {
        List<Receipt> list = fetchByQuery(SELECT_BY_ID_SQL, id);
        return list.isEmpty() ? null : list.get(0);
    }

    @Override
    public List<Receipt> getAll() {
        return fetchByQuery(SELECT_ALL_SQL);
    }

    public String getLatestReceiptID() {
        String latestReceiptID = null;
        try (ResultSet rs = XJdbc.executeQuery(SELECT_LATEST_ID_SQL)) {
            if (rs.next()) {
                latestReceiptID = rs.getString("ReceiptID");
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        return latestReceiptID;
    }

    public List<Receipt> searchByCriteria(String supplierName, String receiptID, String type, String status) {
        String supplierNameTerm = "%" + supplierName + "%";
        String receiptIDTerm = "%" + receiptID + "%";
        String typeTerm = "%" + type + "%";
        String statusTerm = "%" + status + "%";

        return fetchByQuery(SELECT_BY_CRITERIA, supplierNameTerm, receiptIDTerm, typeTerm, statusTerm);
    }

    public boolean isIdExists(String id) {
        try (ResultSet rs = XJdbc.executeQuery(IS_EXISTS_SQL, id)) {
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    protected List<Receipt> fetchByQuery(String sql, Object... args) {
        List<Receipt> list = new ArrayList<>();

        try (ResultSet rs = XJdbc.executeQuery(sql, args)) {
            while (rs.next()) {
                Receipt model = readFromResultSet(rs);
                list.add(model);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        return list;
    }

    private Receipt readFromResultSet(ResultSet rs) throws SQLException {
        Receipt model = new Receipt();
        model.setReceiptID(rs.getString("ReceiptID"));
        model.setSupplierID(rs.getString("SupplierID"));
        model.setEmployeeID(rs.getString("EmployeeID"));
        model.setTransactionType(rs.getString("TransactionType"));
        model.setReceiptDate(rs.getTimestamp("ReceiptDate"));
        model.setTotalAmount(rs.getLong("TotalAmount"));
        model.setNote(rs.getString("Note"));
        model.setStatus(rs.getString("Status"));
        return model;
    }

}
