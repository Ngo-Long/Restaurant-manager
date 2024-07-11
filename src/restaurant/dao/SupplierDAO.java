package restaurant.dao;

import restaurant.utils.JDBC;
import restaurant.entity.SupplierEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

public class SupplierDAO extends RestaurantDAO<SupplierEntity, String> {

    final String INSERT_SQL = "INSERT INTO Supplier (SupplierID, SupplierName, "
            + "OutstandingDebt, TotalSales, Address, Phone, Email, Description, Status) "
            + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    final String UPDATE_SQL = "UPDATE Supplier SET SupplierName=?, "
            + "OutstandingDebt=?, TotalSales=?, Address=?, Phone=?, Email=?, Description=?, "
            + "Status=? WHERE SupplierID=?";
    final String DELETE_SQL = "DELETE FROM Supplier WHERE SupplierID=?";
    final String SELECT_ALL_SQL = "SELECT * FROM Supplier";
    final String SELECT_BY_ID_SQL = "SELECT * FROM Supplier WHERE SupplierID=?";
    final String IS_EXISTS_SQL = "SELECT COUNT(*) FROM Supplier WHERE SupplierID = ?";
    final String SELECT_BY_CRITERIA = "SELECT TOP (1000) [SupplierID], [SupplierName], [OutstandingDebt], "
            + "[TotalSales], [Address], [Phone], [Email], [Description], [Status] FROM [Supplier] "
            + "WHERE (SupplierID LIKE ? OR [SupplierName] LIKE ? OR [Phone] LIKE ?) AND [Status] LIKE ?";

    @Override
    public void insert(SupplierEntity entity) {
        JDBC.executeUpdate(INSERT_SQL,
                entity.getSupplierID(),
                entity.getSupplierName(),
                entity.getOutstandingDebt(),
                entity.getTotalSales(),
                entity.getAddress(),
                entity.getPhone(),
                entity.getEmail(),
                entity.getDescription(),
                entity.getStatus()
        );
    }

    @Override
    public void update(SupplierEntity entity) {
        JDBC.executeUpdate(UPDATE_SQL,
                entity.getSupplierName(),
                entity.getOutstandingDebt(),
                entity.getTotalSales(),
                entity.getAddress(),
                entity.getPhone(),
                entity.getEmail(),
                entity.getDescription(),
                entity.getStatus(),
                entity.getSupplierID()
        );
    }

    @Override
    public void delete(String id) {
        JDBC.executeUpdate(DELETE_SQL, id);
    }

    @Override
    public SupplierEntity getByID(String id) {
        List<SupplierEntity> list = fetchByQuery(SELECT_BY_ID_SQL, id);
        return list.isEmpty() ? null : list.get(0);
    }

    @Override
    public List<SupplierEntity> getAll() {
        return fetchByQuery(SELECT_ALL_SQL);
    }

    public List<SupplierEntity> searchByCriteria(String id, String name, String phone, String status) {
        String idTerm = "%" + id + "%";
        String nameTerm = "%" + name + "%";
        String phoneTerm = "%" + phone + "%";
        String statusTerm = "%" + status + "%";

        return fetchByQuery(SELECT_BY_CRITERIA, idTerm, nameTerm, phoneTerm, statusTerm);
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
    protected List<SupplierEntity> fetchByQuery(String sql, Object... args) {
        List<SupplierEntity> list = new ArrayList<>();

        try (ResultSet rs = JDBC.executeQuery(sql, args)) {
            while (rs.next()) {
                SupplierEntity model = readFromResultSet(rs);
                list.add(model);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        return list;
    }

    private SupplierEntity readFromResultSet(ResultSet rs) throws SQLException {
        SupplierEntity model = new SupplierEntity();
        model.setSupplierID(rs.getString("SupplierID"));
        model.setSupplierName(rs.getString("SupplierName"));
        model.setOutstandingDebt(rs.getLong("OutstandingDebt"));
        model.setTotalSales(rs.getLong("TotalSales"));
        model.setAddress(rs.getString("Address"));
        model.setPhone(rs.getString("Phone"));
        model.setEmail(rs.getString("Email"));
        model.setDescription(rs.getString("Description"));
        model.setStatus(rs.getString("Status"));
        return model;
    }
}
