package restaurant.dao;

import java.util.List;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
import restaurant.utils.XJdbc;
import restaurant.entity.OrderTable;

public class OrderTableDAO extends RestaurantDAO<OrderTable, Integer> {

    private static final String INSERT_SQL = "INSERT INTO OrderTable (OrderID, TableID, Status) VALUES (?, ?, ?)";
    private static final String UPDATE_SQL = "UPDATE OrderTable SET OrderID=?, TableID=?, Status=? WHERE OrderTableID=?";
    private static final String DELETE_SQL = "DELETE FROM OrderTable WHERE OrderTableID=?";
    private static final String SELECT_ALL_SQL = "SELECT * FROM OrderTable";
    private static final String SELECT_BY_ID_SQL = "SELECT * FROM OrderTable WHERE OrderTableID=?";

    @Override
    public void insert(OrderTable orderTable) {
        XJdbc.executeUpdate(INSERT_SQL,
                orderTable.getOrderID(),
                orderTable.getTableID(),
                orderTable.getStatus()
        );
    }

    @Override
    public void update(OrderTable orderTable) {
        XJdbc.executeUpdate(UPDATE_SQL,
                orderTable.getOrderID(),
                orderTable.getTableID(),
                orderTable.getStatus(),
                orderTable.getOrderTableID()
        );
    }

    @Override
    public void delete(Integer orderTableID) {
        XJdbc.executeUpdate(DELETE_SQL, orderTableID);
    }

    @Override
    public List<OrderTable> getAll() {
        return fetchByQuery(SELECT_ALL_SQL);
    }

    @Override
    public OrderTable getByID(Integer orderTableID) {
        List<OrderTable> result = fetchByQuery(SELECT_BY_ID_SQL, orderTableID);
        return result.isEmpty() ? null : result.get(0);
    }

    @Override
    protected List<OrderTable> fetchByQuery(String sql, Object... args) {
        List<OrderTable> list = new ArrayList<>();

        try (ResultSet rs = XJdbc.executeQuery(sql, args)) {
            while (rs.next()) {
                OrderTable model = readFromResultSet(rs);
                list.add(model);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        return list;
    }

    private OrderTable readFromResultSet(ResultSet rs) throws SQLException {
        OrderTable model = new OrderTable();
        model.setOrderTableID(rs.getInt("OrderTableID"));
        model.setOrderID(rs.getInt("OrderID"));
        model.setTableID(rs.getString("TableID"));
        model.setStatus(rs.getString("Status"));
        return model;
    }

}
