package restaurant.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import restaurant.entity.OrderEntity;
import restaurant.utils.Dialog;
import restaurant.utils.JDBC;

public class OrderDAO extends RestaurantDAO<OrderEntity, Integer> {

    final String INSERT_SQL = "INSERT INTO [Order] (InvoiceID, Status, Method, CreatedDate)"
            + " VALUES (?, ?, ?, GETDATE())";
    final String UPDATE_SQL = "UPDATE [Order] SET Note=?, Method=?, Total=?, Status=?  WHERE OrderID=?";
    final String DELETE_SQL = "DELETE FROM [Order] WHERE OrderID=?";
    final String SELECT_ALL_SQL = "SELECT * FROM [Order]";
    final String SELECT_BY_ID = "SELECT * FROM [Order] WHERE OrderID = ?";
    final String SELECT_BY_TABLE_ID = "SELECT o.* FROM [Order] o"
            + " JOIN OrderTable ot ON o.OrderID = ot.OrderID"
            + " WHERE ot.Status = N'Đang hoạt động' AND ot.TableID = ?";
    final String SELECT_BY_INVOICE_ID = "SELECT * FROM [Order] WHERE InvoiceID = ?";
    final String SELECT_LATEST_ID_SQL = "SELECT TOP 1 OrderID FROM [Order] ORDER BY OrderID DESC";

    @Override
    public void insert(OrderEntity model) {
        JDBC.executeUpdate(INSERT_SQL,
                model.getInvoiceID(),
                model.getStatus(),
                model.getMethod()
        );
    }

    public int insert(int invoiceId, String method, String status) {
        JDBC.executeUpdate(INSERT_SQL, invoiceId, method, status);

        int latestID = 0;
        try (ResultSet rs = JDBC.executeQuery(SELECT_LATEST_ID_SQL)) {
            if (rs.next()) {
                latestID = rs.getInt("OrderID");
            }
        } catch (SQLException ex) {
            Dialog.error(null, "Tạo đơn hàng thất bại!");
            throw new RuntimeException(ex);
        }

        return latestID;
    }

    @Override
    public void update(OrderEntity model) {
        JDBC.executeUpdate(UPDATE_SQL,
                model.getNote(),
                model.getMethod(),
                model.getTotal(),
                model.getStatus(),
                model.getOrderId()
        );
    }

    @Override
    public void delete(Integer id) {
        JDBC.executeUpdate(DELETE_SQL, id);
    }

    @Override
    public List<OrderEntity> getAll() {
        return fetchByQuery(SELECT_ALL_SQL);
    }

    @Override
    public OrderEntity getById(Integer id) {
        List<OrderEntity> orders = fetchByQuery(SELECT_BY_ID, id);
        return orders.isEmpty() ? null : orders.get(0);
    }

    public OrderEntity getByTableId(String id) {
        List<OrderEntity> orders = fetchByQuery(SELECT_BY_TABLE_ID, id);
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
        model.setInvoiceID(rs.getInt("InvoiceID"));
        model.setNote(rs.getString("Note"));
        model.setMethod(rs.getString("Method"));
        model.setTotal(rs.getLong("Total"));
        model.setStatus(rs.getString("Status"));
        model.setCreatedDate(rs.getTimestamp("CreatedDate"));
        return model;
    }

}
