package restaurant.dao;

import java.security.Timestamp;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import restaurant.entity.OrdersEntity;
import restaurant.utils.JDBC;

public class OrdersDAO {

    public static final String INSERT_SQL = "INSERT INTO Orders (InvoiceID, TableID, Status, Method, CreatedDate) "
            + "VALUES (?, ?, ?, ?, GETDATE())";
    public static final String DELETE_SQL = "DELETE FROM Orders WHERE OrderID=?";
    public static final String UPDATE_SQL = "UPDATE Orders SET TableID=?, Status=?, Method=? WHERE OrderID=?";
    public static final String UPDATE_STATUS_BY_INVOICE_ID = "UPDATE Orders SET Status=N'Đơn hàng hoàn thành' "
            + "WHERE OrderID = (SELECT OrderID FROM Orders WHERE InvoiceID = ?)";
    public static final String SELECT_ALL_SQL = "SELECT * FROM Orders";
    public static final String GET_BY_ID = "SELECT * FROM Orders WHERE OrderID = ?";
    public static final String SELECT_CREATE_DATE_BY_INVOICE_ID = "SELECT o.CreatedDate FROM Orders o "
            + "JOIN Invoices i ON o.InvoiceID = i.InvoiceID WHERE i.InvoiceID = ?;";
    public static final String SELECT_ORDER_BY_TABLE_ID = "SELECT * FROM Orders WHERE Status = N'Đang đặt hàng' and TableID = ?";
    public static final String SELECT_ORDER_BY_ORDER_ID = "SELECT * FROM Orders WHERE InvoiceID = ?";

    public List<OrdersEntity> getAll() {
        return fetchByQuery(SELECT_ALL_SQL);
    }

    public void insert(OrdersEntity model) {
        JDBC.executeUpdate(INSERT_SQL,
                model.getInvoiceID(),
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

    public OrdersEntity getById(int id) {
        List<OrdersEntity> orders = fetchByQuery(GET_BY_ID, id);
        return orders.isEmpty() ? null : orders.get(0);
    }

    public String getTableNameByOrderId(int id) {
        OrdersEntity order = getById(id);
        return (order != null) ? new TablesDAO().getById(order.getTableId()).getTableName() : null;
    }

    public OrdersEntity getOrderByTableId(String id) {
        List<OrdersEntity> orders = fetchByQuery(SELECT_ORDER_BY_TABLE_ID, id);
        return orders.isEmpty() ? null : orders.get(0);
    }

    public OrdersEntity getOrderByOrderId(int id) {
        List<OrdersEntity> orders = fetchByQuery(SELECT_ORDER_BY_ORDER_ID, id);
        return orders.isEmpty() ? null : orders.get(0);
    }

    public void updateStatusByInvoiceId(int id) {
        JDBC.executeUpdate(UPDATE_STATUS_BY_INVOICE_ID, id);
    }

    public java.sql.Timestamp getCreateDateByInvoiceId(int id) {
        try (ResultSet rs = JDBC.executeQuery(SELECT_CREATE_DATE_BY_INVOICE_ID, id)) {
            if (rs.next()) {
                return rs.getTimestamp(1);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return null;
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
