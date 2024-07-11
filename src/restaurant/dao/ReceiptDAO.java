package restaurant.dao;

import java.util.List;
import java.util.ArrayList;

import java.sql.ResultSet;
import java.sql.SQLException;

import restaurant.utils.JDBC;
import restaurant.entity.ReceiptEntity;

public class ReceiptDAO extends RestaurantDAO<ReceiptEntity, String> {

    final String INSERT_SQL = "INSERT INTO Receipt (ReceiptID, SupplierID, EmployeeID, "
            + "TransactionType, ReceiptDate, TotalAmount, Note, Status) "
            + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    final String UPDATE_SQL = "UPDATE Receipt SET SupplierID=?, EmployeeID=?, TransactionType=?, "
            + "ReceiptDate=?, TotalAmount=?, Note=?, Status=? WHERE ReceiptID=?";
    final String DELETE_SQL = "DELETE FROM Receipt WHERE ReceiptID =?";
    final String IS_EXISTS_SQL = "SELECT COUNT(*) FROM Receipt WHERE ReceiptID = ?";
    final String SELECT_ALL_SQL = "SELECT * FROM Receipt";
    final String SELECT_BY_ID_SQL = "SELECT * FROM Receipt WHERE ReceiptID=?";
    final String SELECT_BY_CRITERIA = "SELECT TOP (1000) [ReceiptID], [SupplierID], [EmployeeID], "
            + "[TransactionType], [ReceiptDate], [TotalAmount], [Note], [Status] "
            + "FROM [RestaurantManager].[dbo].[Receipt] "
            + "WHERE [ReceiptDate] >= ? AND [ReceiptDate] <= ?"
            + "(ReceiptID LIKE ? OR SupplierID LIKE ? OR EmployeeID LIKE ?) "
            + "AND [TransactionType] LIKE ? AND [Status] LIKE ?";

    @Override
    public void insert(ReceiptEntity entity) {
        JDBC.executeUpdate(INSERT_SQL,
                entity.getReceiptID(),
                entity.getSupplierID(),
                entity.getEmployeeID(),
                entity.getTransactionType(),
                entity.getReceiptDate(),
                entity.getTotalAmount(),
                entity.getNote(),
                entity.getStatus()
        );
    }

    @Override
    public void update(ReceiptEntity entity) {
        JDBC.executeUpdate(UPDATE_SQL,
                entity.getSupplierID(),
                entity.getEmployeeID(),
                entity.getTransactionType(),
                entity.getReceiptDate(),
                entity.getTotalAmount(),
                entity.getNote(),
                entity.getStatus(),
                entity.getReceiptID()
        );
    }

    @Override
    public void delete(String id) {
        JDBC.executeUpdate(DELETE_SQL, id);
    }

    @Override
    public ReceiptEntity getByID(String id) {
        List<ReceiptEntity> list = fetchByQuery(SELECT_BY_ID_SQL, id);
        return list.isEmpty() ? null : list.get(0);
    }

    @Override
    public List<ReceiptEntity> getAll() {
        return fetchByQuery(SELECT_ALL_SQL);
    }

    public List<ReceiptEntity> searchByCriteria(String id, String supplierID, String employeeID, String transactionType, String status) {
        String idTerm = "%" + id + "%";
        String supplierIDTerm = "%" + supplierID + "%";
        String employeeIDTerm = "%" + employeeID + "%";
        String transactionTypeTerm = "%" + transactionType + "%";
        String statusTerm = "%" + status + "%";

        return fetchByQuery(SELECT_BY_CRITERIA, idTerm, supplierIDTerm, employeeIDTerm, transactionTypeTerm, statusTerm);
    }

    public boolean isIdExists(String id) {
        try (ResultSet rs = JDBC.executeQuery(IS_EXISTS_SQL, id)) {
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    protected List<ReceiptEntity> fetchByQuery(String sql, Object... args) {
        List<ReceiptEntity> list = new ArrayList<>();

        try (ResultSet rs = JDBC.executeQuery(sql, args)) {
            while (rs.next()) {
                ReceiptEntity model = readFromResultSet(rs);
                list.add(model);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        return list;
    }

    private ReceiptEntity readFromResultSet(ResultSet rs) throws SQLException {
        ReceiptEntity model = new ReceiptEntity();
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
