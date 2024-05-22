package restaurant.dao;

import java.util.List;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
import restaurant.entity.OrderDetailsEntity;
import restaurant.utils.JDBC;

public class OrderDetailsDAO {

    public static final String INSERT_SQL = "INSERT INTO OrderDetails (OrderID, ProductID, ProductQuantity, ProductStatus, ProductDesc, OrderNote, StartTime) VALUES (?, ?, ?, N'Chưa xử lý', ?, N'', GETDATE())";
    public static final String DELETE_SQL = "DELETE FROM OrderDetails WHERE OrderDetailID=?";
    public static final String SELECT_ALL_SQL = "SELECT * FROM OrderDetails";
    public static final String UPDATE_FINISHED_PRODUCT_SQL = "UPDATE OrderDetails SET ProductStatus=N'Đã hoàn thành', OrderNote='', EndTime=GETDATE() WHERE OrderDetailID=?";
    public static final String UPDATE_REMOVE_PRODUCT_SQL = "UPDATE OrderDetails SET ProductStatus=N'Đã xóa', OrderNote=?, EndTime=GETDATE() WHERE OrderDetailID=?";
    public static final String SELECT_BY_ORDER_ID_SQL = "SELECT * FROM OrderDetails WHERE OrderID = ?";
    public static final String SELECT_PENDING_PRODUCTS_SQL = "SELECT * FROM OrderDetails WHERE ProductStatus = N'Chưa xử lý'";
    public static final String SELECT_CONFIRMED_PRODUCTS_SQL = "SELECT * FROM OrderDetails WHERE ProductStatus != N'Chưa xử lý'";
    public static final String SELECT_ORDERED_BY_TABLE_ID_SQL = "SELECT od.* FROM OrderDetails od "
            + "JOIN Orders o ON od.OrderID = o.OrderID "
            + "JOIN DiningTables t ON o.TableID = t.TableID "
            + "JOIN Invoices i ON o.InvoiceID = i.InvoiceID "
            + "WHERE od.ProductStatus != N'Đã xóa' AND i.Status = N'Chờ thanh toán' AND t.TableID = ?";
    public static final String SELECT_TOTAL_AMOUNT_SQL = "SELECT SUM(od.ProductQuantity * p.Price) AS TotalAmount "
            + "FROM OrderDetails od "
            + "JOIN Products p ON od.ProductID = p.ProductID "
            + "JOIN Orders o ON od.OrderID = o.OrderID "
            + "JOIN Invoices i ON o.InvoiceID = i.InvoiceID "
            + "WHERE i.InvoiceID = ?";

    public void insert(OrderDetailsEntity model) {
        JDBC.executeUpdate(INSERT_SQL,
                model.getOrderID(),
                model.getProductID(),
                model.getProductQuantity(),
                model.getProductDesc()
        );
    }

    public void delete(int id) {
        JDBC.executeUpdate(DELETE_SQL, id);
    }

    public List<OrderDetailsEntity> getAll() {
        return fetchByQuery(SELECT_ALL_SQL);
    }

    public void updateProductFinished(int detailID) {
        JDBC.executeUpdate(UPDATE_FINISHED_PRODUCT_SQL, detailID);
    }

    public void updateProductRemove(int detailID, String selectedReason) {
        JDBC.executeUpdate(UPDATE_REMOVE_PRODUCT_SQL, selectedReason, detailID);
    }

    public List<OrderDetailsEntity> getPendingProducts() {
        return fetchByQuery(SELECT_PENDING_PRODUCTS_SQL);
    }

    public List<OrderDetailsEntity> getConfirmedProducts() {
        return fetchByQuery(SELECT_CONFIRMED_PRODUCTS_SQL);
    }

    public List<OrderDetailsEntity> getByOrderId(int orderId) {
        return fetchByQuery(SELECT_BY_ORDER_ID_SQL, orderId);
    }

    public List<OrderDetailsEntity> getOrderdByTableId(String tableId) {
        return fetchByQuery(SELECT_ORDERED_BY_TABLE_ID_SQL, tableId);
    }

    public int getTotalAmountByInvoiceID(int invoiceID) {
        try (ResultSet rs = JDBC.executeQuery(SELECT_TOTAL_AMOUNT_SQL, invoiceID)) {
            if (rs.next()) {
                return rs.getInt("TotalAmount");
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        return 0;
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
