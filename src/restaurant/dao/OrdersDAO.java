package restaurant.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import restaurant.entity.OrdersEntity;
import restaurant.utils.JDBC;

public class OrdersDAO extends RestaurantDAO<OrdersEntity, Integer> {

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
    public List<OrdersEntity> getAll() {
        return fetchByQuery(SELECT_ALL_SQL);
    }

    @Override
    public void insert(OrdersEntity model) {
        JDBC.executeUpdate(INSERT_SQL,
                model.getInvoiceID(),
                model.getTableId(),
                model.getStatus(),
                model.getMethod()
        );
    }

    @Override
    public void update(OrdersEntity model) {
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
    public OrdersEntity getById(Integer id) {
        List<OrdersEntity> orders = fetchByQuery(SELECT_BY_ID, id);
        return orders.isEmpty() ? null : orders.get(0);
    }

    public String getTableNameByOrderId(int id) {
        OrdersEntity order = getById(id);
        return (order != null) ? new TablesDAO().getById(order.getTableId()).getTableName() : null;
    }

    public OrdersEntity getByTableId(String id) {
        List<OrdersEntity> orders = fetchByQuery(SELECT_BY_TABLE_ID, id);
        return orders.isEmpty() ? null : orders.get(0);
    }

    public OrdersEntity getPendingOrderByTableId(String id) {
        List<OrdersEntity> orders = fetchByQuery(SELECT_PENDING_ORDERS_BY_TABLE_ID, id);
        return orders.isEmpty() ? null : orders.get(0);
    }

    public OrdersEntity getByInvoiceId(int id) {
        List<OrdersEntity> orders = fetchByQuery(SELECT_BY_INVOICE_ID, id);
        return orders.isEmpty() ? null : orders.get(0);
    }

    @Override
    protected List<OrdersEntity> fetchByQuery(String sql, Object... args) {
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
        model.setTotal(rs.getLong("Total"));
        model.setMethod(rs.getString("Method"));
        model.setCreatedDate(rs.getTimestamp("CreatedDate"));
        return model;
    }

}
