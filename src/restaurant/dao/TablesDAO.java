package restaurant.dao;

import restaurant.entity.TablesEntity;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

public class TablesDAO {

    public static final String INSERT_SQL = "INSERT INTO DiningTables (TableID, TableName, Area, SeatingCapacity, Surcharge, Status, Description) VALUES (?, ?, ?, ?, ?, ?, ?)";
    public static final String UPDATE_SQL = "UPDATE DiningTables SET TableName=?, Area=?, SeatingCapacity=?, Surcharge=?, Status=?, Description=? WHERE TableID=?";
    public static final String DELETE_SQL = "DELETE FROM DiningTables WHERE TableID =?";
    public static final String SELECT_ALL_SQL = "SELECT * FROM DiningTables";
    public static final String SELECT_ALL_AREA_SQL = "SELECT * FROM DiningTables WHERE Area = ?";
    public static final String SELECT_BY_ID_SQL = "SELECT * FROM DiningTables WHERE TableID=?";
    public static final String CHECK_DUPLICATED_ID_SQL = "SELECT COUNT(*) FROM DiningTables WHERE TableID=?";

    public void insert(TablesEntity entity) {
        JDBC.executeUpdate(INSERT_SQL,
                entity.getTableID(),
                entity.getTableName(),
                entity.getArea(),
                entity.getSeatingCapacity(),
                entity.getSurcharge(),
                entity.getStatus(),
                entity.getDescription()
        );
    }

    public void update(TablesEntity entity) {
        JDBC.executeUpdate(UPDATE_SQL,
                entity.getTableName(),
                entity.getArea(),
                entity.getSeatingCapacity(),
                entity.getSurcharge(),
                entity.getStatus(),
                entity.getDescription(),
                entity.getTableID()
        );
    }

    public void delete(String id) {
        JDBC.executeUpdate(DELETE_SQL, id);
    }

    public TablesEntity getById(String id) {
        List<TablesEntity> list = fetchByQuery(SELECT_BY_ID_SQL, id);
        return list.isEmpty() ? null : list.get(0);
    }

    public List<TablesEntity> getAll() {
        return fetchByQuery(SELECT_ALL_SQL);
    }

    public List<TablesEntity> getAllByArea(String area) {
        return fetchByQuery(SELECT_ALL_AREA_SQL, area);
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

    private List<TablesEntity> fetchByQuery(String sql, Object... args) {
        List<TablesEntity> list = new ArrayList<>();

        try (ResultSet rs = JDBC.executeQuery(sql, args)) {
            while (rs.next()) {
                TablesEntity model = readFromResultSet(rs);
                list.add(model);
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Error while fetching data from database.", ex);
        }

        return list;
    }

    private TablesEntity readFromResultSet(ResultSet rs) throws SQLException {
        TablesEntity model = new TablesEntity();
        model.setTableID(rs.getString("TableID"));
        model.setTableName(rs.getString("TableName"));
        model.setSeatingCapacity(rs.getInt("SeatingCapacity"));
        model.setSurcharge(rs.getInt("Surcharge"));
        model.setStatus(rs.getString("Status"));
        model.setArea(rs.getString("Area"));
        model.setDescription(rs.getString("Description"));
        return model;
    }
}
