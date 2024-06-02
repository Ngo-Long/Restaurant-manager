package restaurant.dao;

import restaurant.entity.DiningTableEntity;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import restaurant.utils.JDBC;

public class DiningTableDAO {

    final String INSERT_SQL = "INSERT INTO DiningTables (TableID, TableName, Area, SeatingCapacity, "
            + "Surcharge, Status, Description) VALUES (?, ?, ?, ?, ?, ?, ?)";
    final String UPDATE_SQL = "UPDATE DiningTables SET TableName=?, Area=?, SeatingCapacity=?, Surcharge=?, "
            + "Status=?, Description=? WHERE TableID=?";
    final String DELETE_SQL = "DELETE FROM DiningTables WHERE TableID =?";
    final String SELECT_ALL_SQL = "SELECT * FROM DiningTables ORDER BY TRY_CAST(SUBSTRING(TableName, "
            + "PATINDEX('%[0-9]%', TableName), LEN(TableName)) AS INT);";
    final String SELECT_BY_ID_SQL = "SELECT * FROM DiningTables WHERE TableID=?";

    final String CHECK_DUPLICATED_ID_SQL = "SELECT COUNT(*) FROM DiningTables WHERE TableID=?";
    final String CHECK_DUPLICATED_NAME_SQL = "SELECT COUNT(*) FROM DiningTables WHERE TableName = ?";

    final String SELECT_BY_INVOICE_ID_SQL = "SELECT dt.* FROM DiningTables dt "
            + "JOIN Orders o ON dt.TableID = o.TableID "
            + "JOIN Invoices i ON o.InvoiceID = i.InvoiceID "
            + "WHERE i.InvoiceID = ?;";

    final String SELECT_ORDER_COUNT_BY_TABLE_ID_SQL = "SELECT COUNT(*) AS NumberOfOrders FROM Orders "
            + "WHERE Status = N'Đang đặt hàng' AND TableID = ?";

    public void insert(DiningTableEntity entity) {
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

    public void update(DiningTableEntity entity) {
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

    public DiningTableEntity getById(String id) {
        List<DiningTableEntity> list = fetchByQuery(SELECT_BY_ID_SQL, id);
        return list.isEmpty() ? null : list.get(0);
    }

    public List<DiningTableEntity> getAll() {
        return fetchByQuery(SELECT_ALL_SQL);
    }

    public List<DiningTableEntity> searchByAreaAndName(String area, String name) {
        String sql = "SELECT * FROM DiningTables WHERE Area LIKE ? AND TableName LIKE ?";
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

    public DiningTableEntity getByInvoiceId(int invoiceId) {
        List<DiningTableEntity> list = fetchByQuery(SELECT_BY_INVOICE_ID_SQL, invoiceId);
        return list.isEmpty() ? null : list.get(0);
    }

    private List<DiningTableEntity> fetchByQuery(String sql, Object... args) {
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
        model.setTableName(rs.getString("TableName"));
        model.setSeatingCapacity(rs.getInt("SeatingCapacity"));
        model.setSurcharge(rs.getInt("Surcharge"));
        model.setStatus(rs.getString("Status"));
        model.setArea(rs.getString("Area"));
        model.setDescription(rs.getString("Description"));
        return model;
    }
}
