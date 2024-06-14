package restaurant.dao;

import java.util.List;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
import restaurant.utils.JDBC;
import restaurant.entity.DiningTableEntity;

public class DiningTableDAO extends RestaurantDAO<DiningTableEntity, String> {

    final String INSERT_SQL = "INSERT INTO DiningTables (TableID, Name, Location, Capacity, "
            + "Status, Description, Activity) VALUES (?, ?, ?, ?, ?, ?, ?)";
    final String UPDATE_SQL = "UPDATE DiningTables SET Name=?, Location=?, Capacity=?, "
            + "Status=?, Description=?, Activity=? WHERE TableID=?";
    final String DELETE_SQL = "DELETE FROM DiningTables WHERE TableID = ?";
    final String SELECT_ALL_SQL = "SELECT TableID, Name, Location, Capacity, Status, Description, Activity FROM DiningTables "
            + "ORDER BY TRY_CAST(SUBSTRING(Name, PATINDEX('%[0-9]%', Name), LEN(Name)) AS INT)";
    final String SELECT_BY_ID_SQL = "SELECT TableID, Name, Location, Capacity, Status, Description, Activity "
            + "FROM DiningTables WHERE TableID=?";
    final String CHECK_DUPLICATED_ID_SQL = "SELECT COUNT(*) FROM DiningTables WHERE TableID=?";
    final String CHECK_DUPLICATED_NAME_SQL = "SELECT COUNT(*) FROM DiningTables WHERE Name = ?";

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
    public DiningTableEntity getById(String id) {
        List<DiningTableEntity> list = fetchByQuery(SELECT_BY_ID_SQL, id);
        return list.isEmpty() ? null : list.get(0);
    }

    @Override
    public List<DiningTableEntity> getAll() {
        return fetchByQuery(SELECT_ALL_SQL);
    }

    public String getIdByName(String tableName) {
        try (ResultSet rs = JDBC.executeQuery("SELECT TableID FROM DiningTables WHERE Name = ?", tableName)) {
            if (rs.next()) {
                return rs.getString("TableID");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public List<DiningTableEntity> searchByAreaAndName(String area, String name) {
        String sql = "SELECT TableID, Name, Location, Capacity, Status, Description, Activity "
                + "FROM DiningTables WHERE Location LIKE ? AND Name LIKE ?";
        String areaTerm = "%" + area + "%";
        String nameTerm = "%" + name + "%";

        return fetchByQuery(sql, areaTerm, nameTerm);
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
