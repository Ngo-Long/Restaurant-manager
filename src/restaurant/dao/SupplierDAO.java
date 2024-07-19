package restaurant.dao;

import restaurant.utils.XJdbc;
import restaurant.entity.Supplier;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

public class SupplierDAO extends RestaurantDAO<Supplier, String> {

    final String INSERT_SQL = "INSERT INTO Supplier (SupplierName, "
            + "Address, Phone, Email, Description, Status) "
            + "VALUES (?, ?, ?, ?, ?, ?)";
    final String UPDATE_SQL = "UPDATE Supplier SET SupplierName=?, Address=?, "
            + "Phone=?, Email=?, Description=?, Status=? WHERE SupplierID=?";
    final String DELETE_SQL = "DELETE FROM Supplier WHERE SupplierID=?";
    final String SELECT_ALL_SQL = "SELECT * FROM Supplier";
    final String SELECT_BY_ID_SQL = "SELECT * FROM Supplier WHERE SupplierID=?";
    final String SELECT_ID_BY_NAME_SQL = "SELECT SupplierID FROM Supplier WHERE SupplierName=?";

    final String IS_EXISTS_SQL = "SELECT COUNT(*) FROM Supplier WHERE SupplierID = ?";
    final String NAME_EXISTS_SQL = "SELECT COUNT(*) FROM Supplier WHERE SupplierName = ?";

    final String SELECT_BY_CRITERIA = "SELECT TOP (1000) [SupplierID], [SupplierName], [OutstandingDebt], "
            + "[TotalSales], [Address], [Phone], [Email], [Description], [Status] FROM [Supplier] "
            + "WHERE (SupplierID LIKE ? OR [SupplierName] LIKE ? OR [Phone] LIKE ?) AND [Status] LIKE ?";

    @Override
    public void insert(Supplier entity) {
        XJdbc.executeUpdate(INSERT_SQL,
                entity.getSupplierName(),
                entity.getAddress(),
                entity.getPhone(),
                entity.getEmail(),
                entity.getDescription(),
                entity.getStatus()
        );
    }

    @Override
    public void update(Supplier entity) {
        XJdbc.executeUpdate(UPDATE_SQL,
                entity.getSupplierName(),
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
        XJdbc.executeUpdate(DELETE_SQL, id);
    }

    @Override
    public Supplier getByID(String id) {
        List<Supplier> list = fetchByQuery(SELECT_BY_ID_SQL, id);
        return list.isEmpty() ? null : list.get(0);
    }

    @Override
    public List<Supplier> getAll() {
        return fetchByQuery(SELECT_ALL_SQL);
    }

    public String getIdByName(String dishName) {
        try (ResultSet resultSet = XJdbc.executeQuery(SELECT_ID_BY_NAME_SQL, dishName)) {
            return resultSet.next() ? resultSet.getString("SupplierID") : null;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public boolean isNameExists(String name) {
        try (ResultSet rs = XJdbc.executeQuery(NAME_EXISTS_SQL, name)) {
            if (rs.next()) {
                int count = rs.getInt(1);
                return count > 0;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public List<Supplier> searchByCriteria(String id, String name, String phone, String status) {
        String idTerm = "%" + id + "%";
        String nameTerm = "%" + name + "%";
        String phoneTerm = "%" + phone + "%";
        String statusTerm = "%" + status + "%";

        return fetchByQuery(SELECT_BY_CRITERIA, idTerm, nameTerm, phoneTerm, statusTerm);
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
    protected List<Supplier> fetchByQuery(String sql, Object... args) {
        List<Supplier> list = new ArrayList<>();

        try (ResultSet rs = XJdbc.executeQuery(sql, args)) {
            while (rs.next()) {
                Supplier model = readFromResultSet(rs);
                list.add(model);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        return list;
    }

    private Supplier readFromResultSet(ResultSet rs) throws SQLException {
        Supplier model = new Supplier();
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
