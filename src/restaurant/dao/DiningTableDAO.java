package restaurant.dao;

import java.util.List;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
import restaurant.utils.JDBC;
import restaurant.entity.DiningTableEntity;

public class DiningTableDAO extends RestaurantDAO<DiningTableEntity, String> {

    final String INSERT_SQL = "INSERT INTO DiningTable (TableID, Name, Location, Capacity, "
            + "Status, Description, Activity) VALUES (?, ?, ?, ?, ?, ?, ?)";
    final String UPDATE_SQL = "UPDATE DiningTable SET Name=?, Location=?, Capacity=?, "
            + "Status=?, Description=?, Activity=? WHERE TableID=?";
    final String DELETE_SQL = "DELETE FROM DiningTable WHERE TableID = ?";
    final String SELECT_ALL_SQL = "SELECT * FROM DiningTable"
            + " ORDER BY TRY_CAST(SUBSTRING(Name, PATINDEX('%[0-9]%', Name), LEN(Name)) AS INT)";
    final String SELECT_BY_ID_SQL = "SELECT * FROM DiningTable WHERE TableID=?";
    final String SELECT_BY_ORDER_ID_SQL = "SELECT dt.* FROM [Order] o"
            + " JOIN OrderTable ot ON o.OrderID = ot.OrderID"
            + " JOIN DiningTable dt ON ot.TableID = dt.TableID"
            + " WHERE o.OrderID = ?";

    final String SELECT_BY_CRITERIA = "SELECT * FROM DiningTable WHERE Name LIKE ? "
            + "AND Location LIKE ? AND Activity LIKE ?";
    final String CHECK_DUPLICATED_ID_SQL = "SELECT COUNT(*) FROM DiningTable WHERE TableID=?";
    final String CHECK_DUPLICATED_NAME_SQL = "SELECT COUNT(*) FROM DiningTable WHERE Name = ?";

    @Override
    public void insert(DiningTableEntity entity) {
        JDBC.executeUpdate(INSERT_SQL,
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
    public void update(DiningTableEntity entity) {
        JDBC.executeUpdate(UPDATE_SQL,
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
        JDBC.executeUpdate(DELETE_SQL, id);
    }

    @Override
    public List<DiningTableEntity> getAll() {
        return fetchByQuery(SELECT_ALL_SQL);
    }

    @Override
    public DiningTableEntity getById(String id) {
        List<DiningTableEntity> list = fetchByQuery(SELECT_BY_ID_SQL, id);
        return list.isEmpty() ? null : list.get(0);
    }

    public DiningTableEntity getByOrderID(int id) {
        List<DiningTableEntity> list = fetchByQuery(SELECT_BY_ORDER_ID_SQL, id);
        return list.isEmpty() ? null : list.get(0);
    }

    public String getIdByName(String tableName) {
        try (ResultSet rs = JDBC.executeQuery("SELECT TableID FROM DiningTable WHERE Name = ?", tableName)) {
            if (rs.next()) {
                return rs.getString("TableID");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public List<DiningTableEntity> searchByCriteria(String name, String location, String activity) {
        String nameTerm = "%" + name + "%";
        String locationTerm = "%" + location + "%";
        String activityTerm = "%" + activity + "%";

        return this.fetchByQuery(SELECT_BY_CRITERIA, nameTerm, locationTerm, activityTerm);
    }

    public boolean isIdDuplicated(String id) {
        try (ResultSet rs = JDBC.executeQuery(CHECK_DUPLICATED_ID_SQL, id)) {
            if (rs.next()) {
                int count = rs.getInt(1);
                return count > 0;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return false;
    }

    public boolean isDuplicateName(String name) {
        try (ResultSet rs = JDBC.executeQuery(CHECK_DUPLICATED_NAME_SQL, name)) {
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
    protected List<DiningTableEntity> fetchByQuery(String sql, Object... args) {
        List<DiningTableEntity> list = new ArrayList<>();

        try (ResultSet rs = JDBC.executeQuery(sql, args)) {
            while (rs.next()) {
                DiningTableEntity model = readFromResultSet(rs);
                list.add(model);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        return list;
    }

    private DiningTableEntity readFromResultSet(ResultSet rs) throws SQLException {
        DiningTableEntity model = new DiningTableEntity();
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
