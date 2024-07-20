package restaurant.dao;

import java.util.List;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
import restaurant.utils.XJdbc;
import restaurant.entity.DiningTable;

public class DiningTableDAO extends RestaurantDAO<DiningTable, String> {

    final String INSERT_SQL = "INSERT INTO DiningTable (TableID, Name, Location, Capacity, "
            + "Status, Description, Activity) VALUES (?, ?, ?, ?, ?, ?, ?)";
    final String UPDATE_SQL = "UPDATE DiningTable SET Name=?, Location=?, Capacity=?, "
            + "Status=?, Description=?, Activity=? WHERE TableID=?";
    final String DELETE_SQL = "DELETE FROM DiningTable WHERE TableID = ?";
    final String SELECT_ALL_SQL = "SELECT * FROM DiningTable ORDER BY Name";
    final String SELECT_BY_ID_SQL = "SELECT * FROM DiningTable WHERE TableID=? ";

    final String SELECT_BY_ORDER_ID_SQL = "SELECT dt.* FROM [Order] o "
            + "JOIN OrderTable ot ON o.OrderID = ot.OrderID "
            + "JOIN DiningTable dt ON ot.TableID = dt.TableID "
            + "WHERE o.OrderID = ? ";

    final String SELECT_BY_INVOICE_ID_SQL = "SELECT dt.* FROM DiningTable dt "
            + "INNER JOIN OrderTable ot ON dt.TableID = ot.TableID "
            + "INNER JOIN [Order] o ON ot.OrderID = o.OrderID "
            + "WHERE o.InvoiceID = ?";

    final String SELECT_BY_CRITERIA = "SELECT * FROM DiningTable WHERE Name LIKE ? "
            + "AND Location LIKE ? AND Activity LIKE ?";

    final String CHECK_DUPLICATED_ID_SQL = "SELECT COUNT(*) FROM DiningTable WHERE TableID=?";
    final String CHECK_DUPLICATED_NAME_SQL = "SELECT COUNT(*) FROM DiningTable WHERE Name = ?";

    @Override
    public void insert(DiningTable entity) {
        XJdbc.executeUpdate(INSERT_SQL,
                entity.getTableID(),
                entity.getName(),
                entity.getLocation(),
                entity.getCapacity(),
                entity.getStatus(),
                entity.getDescription(),
                entity.getActivity()
        );
    }

    @Override
    public void update(DiningTable entity) {
        XJdbc.executeUpdate(UPDATE_SQL,
                entity.getName(),
                entity.getLocation(),
                entity.getCapacity(),
                entity.getStatus(),
                entity.getDescription(),
                entity.getActivity(),
                entity.getTableID()
        );
    }

    @Override
    public void delete(String id) {
        XJdbc.executeUpdate(DELETE_SQL, id);
    }

    @Override
    public List<DiningTable> getAll() {
        return this.fetchByQuery(SELECT_ALL_SQL);
    }

    public List<DiningTable> getByInvoicesID(int id) {
        return this.fetchByQuery(SELECT_BY_INVOICE_ID_SQL, id);
    }

    @Override
    public DiningTable getByID(String id) {
        List<DiningTable> list = fetchByQuery(SELECT_BY_ID_SQL, id);
        return list.isEmpty() ? null : list.get(0);
    }

    public DiningTable getByOrderID(int id) {
        List<DiningTable> list = fetchByQuery(SELECT_BY_ORDER_ID_SQL, id);
        return list.isEmpty() ? null : list.get(0);
    }

    public String getIdByName(String tableName) {
        try (ResultSet rs = XJdbc.executeQuery("SELECT TableID FROM DiningTable WHERE Name = ?", tableName)) {
            if (rs.next()) {
                return rs.getString("TableID");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public List<DiningTable> searchByCriteria(String name, String location, String activity) {
        String nameTerm = "%" + name + "%";
        String locationTerm = "%" + location + "%";
        String activityTerm = "%" + activity + "%";

        return this.fetchByQuery(SELECT_BY_CRITERIA, nameTerm, locationTerm, activityTerm);
    }

    public boolean isIDExists(String id) {
        try (ResultSet rs = XJdbc.executeQuery(CHECK_DUPLICATED_ID_SQL, id)) {
            if (rs.next()) {
                int count = rs.getInt(1);
                return count > 0;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return false;
    }

    public boolean isNameExists(String name) {
        try (ResultSet rs = XJdbc.executeQuery(CHECK_DUPLICATED_NAME_SQL, name)) {
            if (rs.next()) {
                int count = rs.getInt(1);
                return count > 0;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    protected List<DiningTable> fetchByQuery(String sql, Object... args) {
        List<DiningTable> list = new ArrayList<>();

        try (ResultSet rs = XJdbc.executeQuery(sql, args)) {
            while (rs.next()) {
                DiningTable model = readFromResultSet(rs);
                list.add(model);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        return list;
    }

    private DiningTable readFromResultSet(ResultSet rs) throws SQLException {
        DiningTable model = new DiningTable();
        model.setTableID(rs.getString("TableID"));
        model.setName(rs.getString("Name"));
        model.setLocation(rs.getString("Location"));
        model.setCapacity(rs.getInt("Capacity"));
        model.setStatus(rs.getString("Status"));
        model.setDescription(rs.getString("Description"));
        model.setActivity(rs.getString("Activity"));
        return model;
    }
}
