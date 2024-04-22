package restaurant.dao;

import java.util.List;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
import restaurant.entity.OrderDetailsEntity;

public class OrderDetailsDAO {

    public static final String INSERT_SQL = "INSERT INTO OrderDetails (OrderID, ProductID, ProductQuantity, ProductStatus, ProductDesc, StartTime) VALUES (?, ?, ?, ?, ?, GETDATE())";
    public static final String UPDATE_SQL = "UPDATE OrderDetails SET OrderID=?, ProductID=?, ProductQuantity=?, ProductStatus=?, ProductDesc=?, EndTime=GETDATE() WHERE OrderDetailID=?";
    public static final String DELETE_SQL = "DELETE FROM OrderDetails WHERE OrderDetailID=?";
    public static final String SELECT_ALL_SQL = "SELECT * FROM OrderDetails";
    public static final String SELECT_BY_ORDER_ID_SQL = "SELECT * FROM OrderDetails WHERE OrderID = ?";
    public static final String SELECT_PENDING_PRODUCTS_SQL = "SELECT * FROM OrderDetails WHERE ProductStatus = N'Chưa xử lý'";
    public static final String SELECT_ORDERED_BY_TABLE_ID_SQL = "SELECT od.* "
            + "FROM OrderDetails od "
            + "JOIN Orders o ON od.OrderID = o.OrderID "
            + "JOIN DiningTables dt ON o.TableID = dt.TableID "
            + "WHERE dt.TableID = ? AND o.Status = N'Chờ thanh toán'";

    public void insert(OrderDetailsEntity model) {
        JDBC.executeUpdate(INSERT_SQL,
                model.getOrderID(),
                model.getProductID(),
                model.getProductQuantity(),
                model.getProductStatus(),
                model.getProductDesc()
        );
    }

    public void update(OrderDetailsEntity model) {
        JDBC.executeUpdate(UPDATE_SQL,
                model.getOrderID(),
                model.getProductID(),
                model.getProductQuantity(),
                model.getProductStatus(),
                model.getProductDesc(),
                model.getOrderDetailID()
        );
    }

    public void delete(int id) {
        JDBC.executeUpdate(DELETE_SQL, id);
    }

    public List<OrderDetailsEntity> getAll() {
        return fetchByQuery(SELECT_ALL_SQL);
    }

    public List<OrderDetailsEntity> getPendingProducts() {
        return fetchByQuery(SELECT_PENDING_PRODUCTS_SQL);
    }

    public List<OrderDetailsEntity> getByOrderId(int orderId) {
        return fetchByQuery(SELECT_BY_ORDER_ID_SQL, orderId);
    }

    public List<OrderDetailsEntity> getByTableId(String tableId) {
        return fetchByQuery(SELECT_ORDERED_BY_TABLE_ID_SQL, tableId);
    }

    private List<OrderDetailsEntity> fetchByQuery(String sql, Object... args) {
        List<OrderDetailsEntity> list = new ArrayList<>();

        try (ResultSet rs = JDBC.executeQuery(sql, args)) {
            while (rs.next()) {
                OrderDetailsEntity model = readFromResultSet(rs);
                list.add(model);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        return list;
    }

    private OrderDetailsEntity readFromResultSet(ResultSet rs) throws SQLException {
        OrderDetailsEntity model = new OrderDetailsEntity();
        model.setOrderDetailID(rs.getInt("OrderDetailID"));
        model.setOrderID(rs.getInt("OrderID"));
        model.setProductID(rs.getString("ProductID"));
        model.setProductQuantity(rs.getInt("ProductQuantity"));
        model.setProductStatus(rs.getString("ProductStatus"));
        model.setProductDesc(rs.getString("ProductDesc"));
        model.setStartTime(rs.getTimestamp("StartTime"));
        model.setEndTime(rs.getTimestamp("EndTime"));
        return model;
    }
}
