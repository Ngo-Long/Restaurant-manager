package restaurant.dao;

import java.util.List;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
import restaurant.entity.OrderDetailEntity;
import restaurant.utils.JDBC;

public class OrderDetailDAO extends RestaurantDAO<OrderDetailEntity, Integer> {

    final String INSERT_SQL = "INSERT INTO OrderDetails (OrderID, ProductID, ProductQuantity, ProductStatus,"
            + " ProductDesc, Note, StartTime) VALUES (?, ?, ?, N'Chưa xử lý', ?, N'', GETDATE())";
    final String UPDATE_SQL = "UPDATE OrderDetails SET OrderID = ?, ProductID = ?, ProductQuantity = ?,"
            + " ProductStatus = ?, ProductDesc = ?, Note = ?, EndTime = GETDATE() WHERE OrderDetailID = ?";
    final String DELETE_SQL = "DELETE FROM OrderDetails WHERE OrderDetailID=?";
    final String SELECT_ALL_SQL = "SELECT * FROM OrderDetails";

    final String SELECT_BY_ID_SQL = "SELECT * FROM OrderDetails WHERE OrderDetailID=?";
    final String SELECT_BY_ORDER_ID_SQL = "SELECT * FROM OrderDetails WHERE OrderID = ?";
    final String SELECT_BY_TABLE_ID_SQL = "SELECT od.* FROM OrderDetails od "
            + "JOIN Orders o ON od.OrderID = o.OrderID "
            + "JOIN DiningTables t ON o.TableID = t.TableID "
            + "JOIN Invoices i ON o.InvoiceID = i.InvoiceID "
            + "WHERE od.ProductStatus != N'Đã xóa' AND i.Status = N'Chờ thanh toán' AND t.TableID = ?";

    final String SELECT_PENDING_PRODUCTS_SQL = "SELECT * FROM OrderDetails WHERE ProductStatus = N'Chưa xử lý'";
    final String SELECT_CONFIRMED_PRODUCTS_SQL = "SELECT * FROM OrderDetails WHERE ProductStatus != N'Chưa xử lý'";

    final String SELECT_TOTAL_AMOUNT_SQL = "SELECT SUM(od.ProductQuantity * p.Price) AS TotalAmount "
            + "FROM OrderDetails od "
            + "JOIN Products p ON od.ProductID = p.ProductID "
            + "JOIN Orders o ON od.OrderID = o.OrderID "
            + "JOIN Invoices i ON o.InvoiceID = i.InvoiceID "
            + "WHERE i.InvoiceID = ?";

    @Override
    public void insert(OrderDetailEntity model) {
        JDBC.executeUpdate(INSERT_SQL,
                model.getOrderID(),
                model.getProductID(),
                model.getProductQuantity(),
                model.getProductDesc()
        );
    }

    @Override
    public void update(OrderDetailEntity model) {
        JDBC.executeUpdate(UPDATE_SQL,
                model.getOrderID(),
                model.getProductID(),
                model.getProductQuantity(),
                model.getProductStatus(),
                model.getProductDesc(),
                model.getNote(),
                model.getOrderDetailID()
        );
    }

    @Override
    public void delete(Integer id) {
        JDBC.executeUpdate(DELETE_SQL, id);
    }

    @Override
    public OrderDetailEntity getById(Integer id) {
        List<OrderDetailEntity> list = fetchByQuery(SELECT_BY_ID_SQL, id);
        return list.isEmpty() ? null : list.get(0);
    }

    @Override
    public List<OrderDetailEntity> getAll() {
        return fetchByQuery(SELECT_ALL_SQL);
    }

    public List<OrderDetailEntity> getPendingProducts() {
        return fetchByQuery(SELECT_PENDING_PRODUCTS_SQL);
    }

    public List<OrderDetailEntity> getConfirmedProducts() {
        return fetchByQuery(SELECT_CONFIRMED_PRODUCTS_SQL);
    }

    public List<OrderDetailEntity> getByOrderId(int orderId) {
        return fetchByQuery(SELECT_BY_ORDER_ID_SQL, orderId);
    }

    public List<OrderDetailEntity> getByTableId(String tableId) {
        return fetchByQuery(SELECT_BY_TABLE_ID_SQL, tableId);
    }

    public List<OrderDetailEntity> calculateOrderItemTotals(int orderId) {
        String calculateOrderTotalSQL = "SELECT p.ProductName, od.ProductDesc, od.ProductQuantity, p.Price AS UnitPrice, "
                + "(od.ProductQuantity * p.Price) AS TotalPrice "
                + "FROM OrderDetails od "
                + "JOIN Products p ON od.ProductID = p.ProductID "
                + "WHERE od.OrderID = ?";

        return fetchByQuery(calculateOrderTotalSQL, orderId);
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

    @Override
    protected List<OrderDetailEntity> fetchByQuery(String sql, Object... args) {
        List<OrderDetailEntity> list = new ArrayList<>();

        try (ResultSet rs = JDBC.executeQuery(sql, args)) {
            while (rs.next()) {
                OrderDetailEntity model = readFromResultSet(rs);
                list.add(model);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        return list;
    }

    private OrderDetailEntity readFromResultSet(ResultSet rs) throws SQLException {
        OrderDetailEntity model = new OrderDetailEntity();
        model.setOrderDetailID(rs.getInt("OrderDetailID"));
        model.setOrderID(rs.getInt("OrderID"));
        model.setProductID(rs.getString("ProductID"));
        model.setProductQuantity(rs.getInt("ProductQuantity"));
        model.setProductStatus(rs.getString("ProductStatus"));
        model.setProductDesc(rs.getString("ProductDesc"));
        model.setNote(rs.getString("Note"));
        model.setStartTime(rs.getDate("StartTime"));
        model.setEndTime(rs.getDate("EndTime"));
        return model;
    }

}
