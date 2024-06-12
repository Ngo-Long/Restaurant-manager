package restaurant.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import restaurant.entity.OrderEntity;
import restaurant.utils.JDBC;

public class OrdersDAO extends RestaurantDAO<OrderEntity, Integer> {

    public static final String INSERT_SQL = "INSERT INTO Orders (InvoiceID, TableID, Status, Method,"
            + " CreatedDate) VALUES (?, ?, ?, ?, GETDATE())";
    public static final String DELETE_SQL = "DELETE FROM Orders WHERE OrderID=?";
    public static final String UPDATE_SQL = "UPDATE Orders SET TableID=?, Status=?, Total=?, Method=? WHERE OrderID=?";
    public static final String SELECT_ALL_SQL = "SELECT * FROM Orders";
    public static final String SELECT_BY_ID = "SELECT * FROM Orders WHERE OrderID = ?";
    public static final String SELECT_BY_INVOICE_ID = "SELECT * FROM Orders WHERE InvoiceID = ?";
    public static final String SELECT_BY_TABLE_ID = "SELECT * FROM Orders WHERE TableID = ?";
    public static final String SELECT_PENDING_ORDERS_BY_TABLE_ID = "SELECT * FROM Orders WHERE Status = N'Đang đặt hàng' AND TableID = ?";

    @Override
    public List<OrderEntity> getAll() {
        return fetchByQuery(SELECT_ALL_SQL);
    }

    @Override
    public void insert(OrderEntity model) {
        JDBC.executeUpdate(INSERT_SQL,
                model.getInvoiceID(),
                model.getTableId(),
                model.getStatus(),
                model.getMethod()
        );
    }

    @Override
    public void update(OrderEntity model) {
        JDBC.executeUpdate(UPDATE_SQL,
                model.getTableId(),
                model.getStatus(),
                model.getTotal(),
                model.getMethod(),
                model.getOrderId()
        );
    }

    @Override
    public void delete(Integer id) {
        JDBC.executeUpdate(DELETE_SQL, id);
    }

    @Override
    public OrderEntity getById(Integer id) {
        List<OrderEntity> orders = fetchByQuery(SELECT_BY_ID, id);
        return orders.isEmpty() ? null : orders.get(0);
    }

    public String getTableNameByOrderId(int id) {
        OrderEntity order = getById(id);
        return (order != null) ? new DiningTableDAO().getById(order.getTableId()).getTableName() : null;
    }

    public OrderEntity getByTableId(String id) {
        List<OrderEntity> orders = fetchByQuery(SELECT_BY_TABLE_ID, id);
        return orders.isEmpty() ? null : orders.get(0);
    }

    public OrderEntity getPendingByTableId(String id) {
        List<OrderEntity> orders = fetchByQuery(SELECT_PENDING_ORDERS_BY_TABLE_ID, id);
        return orders.isEmpty() ? null : orders.get(0);
    }

    public OrderEntity getByInvoiceId(int id) {
        List<OrderEntity> orders = fetchByQuery(SELECT_BY_INVOICE_ID, id);
        return orders.isEmpty() ? null : orders.get(0);
    }

    @Override
    protected List<OrderEntity> fetchByQuery(String sql, Object... args) {
        List<OrderEntity> list = new ArrayList<>();

        try (ResultSet rs = JDBC.executeQuery(sql, args)) {
            while (rs.next()) {
                OrderEntity model = readFromResultSet(rs);
                list.add(model);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        return list;
    }

    private OrderEntity readFromResultSet(ResultSet rs) throws SQLException {
        OrderEntity model = new OrderEntity();
        model.setOrderId(rs.getInt("OrderID"));
        model.setTableId(rs.getString("TableID"));
        model.setStatus(rs.getString("Status"));
        model.setTotal(rs.getLong("Total"));
        model.setMethod(rs.getString("Method"));
        model.setCreatedDate(rs.getTimestamp("CreatedDate"));
        return model;
    }

}
