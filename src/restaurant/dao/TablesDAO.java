package restaurant.dao;

import restaurant.entity.TablesEntity;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import restaurant.utils.JDBC;

public class TablesDAO {

    public static final String INSERT_SQL = "INSERT INTO DiningTables (TableID, TableName, Area, SeatingCapacity, "
            + "Surcharge, Status, Description) VALUES (?, ?, ?, ?, ?, ?, ?)";
    public static final String UPDATE_SQL = "UPDATE DiningTables SET TableName=?, Area=?, SeatingCapacity=?, Surcharge=?, "
            + "Status=?, Description=? WHERE TableID=?";
    public static final String DELETE_SQL = "DELETE FROM DiningTables WHERE TableID =?";
    public static final String SELECT_ALL_SQL = "SELECT * FROM DiningTables";
    public static final String SELECT_BY_ID_SQL = "SELECT * FROM DiningTables WHERE TableID=?";
    
    public static final String SELECT_NAME_BY_ID_SQL = "SELECT TableID FROM DiningTables WHERE TableName = ?";
    public static final String SELECT_NAME_BY_INVOICE_ID_SQL = "SELECT dt.TableName FROM DiningTables dt "
            + "JOIN Orders o ON dt.TableID = o.TableID "
            + "JOIN Invoices i ON o.InvoiceID = i.InvoiceID "
            + "WHERE i.InvoiceID = ?;";
    public static final String CHECK_DUPLICATED_ID_SQL = "SELECT COUNT(*) FROM DiningTables WHERE TableID=?";
    public static final String SELECT_ORDER_COUNT_BY_TABLE_ID_SQL = "SELECT COUNT(*) AS NumberOfOrders FROM Orders "
            + "WHERE Status = N'Đang đặt hàng' AND TableID = ?";

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

    public List<TablesEntity> searchByArea(String area) {
        String sql = "SELECT * FROM DiningTables WHERE Area LIKE ?";
        String areaTerm = "%" + area + "%";

        return fetchByQuery(sql, areaTerm);
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

    public int getOrderCountByTableId(String tableId) {
        try (ResultSet rs = JDBC.executeQuery(SELECT_ORDER_COUNT_BY_TABLE_ID_SQL, tableId)) {
            return rs.next() ? rs.getInt(1) : 0;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public String getIdByName(String tableName) {
        try (ResultSet rs = JDBC.executeQuery("SELECT TableID FROM DiningTables WHERE TableName = ?", tableName)) {
            if (rs.next()) {
                return rs.getString("TableID");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public List<String> getTableNamesByInvoiceId(int invoiceId) {
        List<String> tableNames = new ArrayList<>();

        try (ResultSet rs = JDBC.executeQuery(SELECT_NAME_BY_INVOICE_ID_SQL, invoiceId)) {
            while (rs.next()) {
                String tableName = rs.getString("TableName");
                tableNames.add(tableName);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        return tableNames;
    }

    private List<TablesEntity> fetchByQuery(String sql, Object... args) {
        List<TablesEntity> list = new ArrayList<>();

        try (ResultSet rs = JDBC.executeQuery(sql, args)) {
            while (rs.next()) {
                TablesEntity model = readFromResultSet(rs);
                list.add(model);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
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
