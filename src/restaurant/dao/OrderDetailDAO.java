package restaurant.dao;

import java.util.List;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
import restaurant.entity.OrderDetailEntity;
import restaurant.utils.JDBC;

public class OrderDetailDAO extends RestaurantDAO<OrderDetailEntity, Integer> {

    final String INSERT_SQL = "INSERT INTO OrderDetail (OrderID, ProductID, ProductQuantity, ProductStatus,"
            + " ProductDesc, Note, StartTime) VALUES (?, ?, ?, ?, ?, N'', GETDATE())";
    final String UPDATE_SQL = "UPDATE OrderDetail SET OrderID = ?, ProductID = ?, ProductQuantity = ?,"
            + " ProductStatus = ?, ProductDesc = ?, Note = ?, EndTime = GETDATE() WHERE OrderDetailID = ?";
    final String DELETE_SQL = "DELETE FROM OrderDetail WHERE OrderDetailID=?";
    final String SELECT_ALL_SQL = "SELECT * FROM OrderDetail";
    final String SELECT_BY_ID_SQL = "SELECT * FROM OrderDetail WHERE OrderDetailID=?";

    final String SELECT_BY_ORDER_ID_SQL = "SELECT od.* FROM OrderDetail od "
            + "JOIN [Order] o ON od.OrderID = o.OrderID "
            + "JOIN Invoice i ON o.InvoiceID = i.InvoiceID "
            + "WHERE od.ProductStatus != N'Đã hủy' AND od.OrderID = ?";

    final String SELECT_BY_CRITERIA = "SELECT TOP (1000) od.[OrderDetailID], od.[OrderID], "
            + "od.[ProductID], od.[ProductQuantity], od.[ProductStatus], od.[ProductDesc], "
            + "od.[Note], od.[StartTime], od.[EndTime] "
            + "FROM [RestaurantManager].[dbo].[OrderDetail] od "
            + "JOIN [RestaurantManager].[dbo].[Product] p ON od.[ProductID] = p.[ProductID] "
            + "WHERE od.[StartTime] >= ? "
            + "AND od.[EndTime] <= ? "
            + "AND od.[ProductStatus] != N'Chưa xử lý' "
            + "AND od.[ProductStatus] LIKE ? "
            + "AND p.[KitchenArea] LIKE ? "
            + "AND p.[ProductName] LIKE ? ";

    final String SELECT_PENDING_PRODUCTS_SQL = "SELECT * FROM OrderDetail WHERE ProductStatus = N'Chưa xử lý'";

    @Override
    public void insert(OrderDetailEntity model) {
        JDBC.executeUpdate(INSERT_SQL,
                model.getOrderID(),
                model.getProductID(),
                model.getProductQuantity(),
                model.getProductStatus(),
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
    public OrderDetailEntity getByID(Integer id) {
        List<OrderDetailEntity> list = fetchByQuery(SELECT_BY_ID_SQL, id);
        return list.isEmpty() ? null : list.get(0);
    }

    @Override
    public List<OrderDetailEntity> getAll() {
        return fetchByQuery(SELECT_ALL_SQL);
    }

    public List<OrderDetailEntity> searchByCriteria(String status, String kitchen,
            String name, String startDate, String endDate) {

        String statusTerm = "%" + status + "%";
        String kitchenTerm = "%" + kitchen + "%";
        String nameTerm = "%" + name + "%";
        String startDayTerm = startDate + " 00:00:00";
        String endDayTerm = endDate + " 23:59:59";

        return fetchByQuery(SELECT_BY_CRITERIA, startDayTerm, endDayTerm, statusTerm, kitchenTerm, nameTerm);
    }

    public List<OrderDetailEntity> getPendingProducts() {
        return fetchByQuery(SELECT_PENDING_PRODUCTS_SQL);
    }

    public List<OrderDetailEntity> getByOrderID(int orderID) {
        return fetchByQuery(SELECT_BY_ORDER_ID_SQL, orderID);
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
        model.setStartTime(rs.getTimestamp("StartTime"));
        model.setEndTime(rs.getTimestamp("EndTime"));
        return model;
    }
}
