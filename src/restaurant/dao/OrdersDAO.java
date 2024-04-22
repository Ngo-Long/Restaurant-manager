package restaurant.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import restaurant.entity.OrdersEntity;

public class OrdersDAO {

    public static final String INSERT_SQL = "INSERT INTO Orders (TableID, Status, Method, CreatedDate) VALUES (?, ?, ?, GETDATE())";
    public static final String UPDATE_SQL = "UPDATE Orders SET TableID=?, Status=?, Method=? WHERE OrderID=?";
    public static final String DELETE_SQL = "DELETE FROM Orders WHERE OrderID=?";
    public static final String SELECT_ALL_SQL = "SELECT * FROM Orders";
    public static final String SELECT_ORDER_BY_TABLE_ID = "SELECT * FROM Orders WHERE TableID = ?";
    public static final String SELECT_ORDER_BY_ORDER_ID = "SELECT * FROM Orders WHERE OrderID = ?";
    public static final String IS_TABLE_PAID = "SELECT COUNT(*) FROM Orders WHERE TableID = ? AND Status = 'Đã thanh toán'";

    public List<OrdersEntity> getAll() {
        return fetchByQuery(SELECT_ALL_SQL);
    }

    public void insert(OrdersEntity model) {
        JDBC.executeUpdate(INSERT_SQL,
                model.getTableId(),
                model.getStatus(),
                model.getMethod()
        );
    }

    public void update(OrdersEntity model) {
        JDBC.executeUpdate(UPDATE_SQL,
                model.getTableId(),
                model.getStatus(),
                model.getMethod(),
                model.getOrderId()
        );
    }

    public void delete(int id) {
        JDBC.executeUpdate(DELETE_SQL, id);
    }

    public String getTableNameByOrderId(int orderId) {
        OrdersEntity order = getOrderByOrderId(orderId);
        return (order != null) ? new TablesDAO().getById(order.getTableId()).getTableName() : null;
    }

    public OrdersEntity getOrderByTableId(String tableId) {
        List<OrdersEntity> orders = fetchByQuery(SELECT_ORDER_BY_TABLE_ID, tableId);
        return orders.isEmpty() ? null : orders.get(0);
    }

    public OrdersEntity getOrderByOrderId(int orderId) {
        List<OrdersEntity> orders = fetchByQuery(SELECT_ORDER_BY_ORDER_ID, orderId);
        return orders.isEmpty() ? null : orders.get(0);
    }

    public boolean isTablePaid(String tableId) {
        try (ResultSet rs = JDBC.executeQuery(IS_TABLE_PAID, tableId)) {
            if (rs.next()) {
                int count = rs.getInt(1);
                return count > 0;
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return false;
    }

    private List<OrdersEntity> fetchByQuery(String sql, Object... args) {
        List<OrdersEntity> list = new ArrayList<>();

        try (ResultSet rs = JDBC.executeQuery(sql, args)) {
            while (rs.next()) {
                OrdersEntity model = readFromResultSet(rs);
                list.add(model);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        return list;
    }

    private OrdersEntity readFromResultSet(ResultSet rs) throws SQLException {
        OrdersEntity model = new OrdersEntity();
        model.setOrderId(rs.getInt("OrderID"));
        model.setTableId(rs.getString("TableID"));
        model.setStatus(rs.getString("Status"));
        model.setMethod(rs.getString("Method"));
        model.setCreatedDate(rs.getTimestamp("CreatedDate"));
        return model;
    }
}
