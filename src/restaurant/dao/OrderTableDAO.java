package restaurant.dao;

import java.util.List;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
import restaurant.utils.JDBC;
import restaurant.entity.OrderTableEntity;

public class OrderTableDAO extends RestaurantDAO<OrderTableEntity, Integer> {

    private static final String INSERT_SQL = "INSERT INTO OrderTable (OrderID, TableID, Status) VALUES (?, ?, ?)";
    private static final String UPDATE_SQL = "UPDATE OrderTable SET OrderID=?, TableID=?, Status=? WHERE OrderTableID=?";
    private static final String DELETE_SQL = "DELETE FROM OrderTable WHERE OrderTableID=?";
    private static final String SELECT_ALL_SQL = "SELECT * FROM OrderTable";
    private static final String SELECT_BY_ID_SQL = "SELECT * FROM OrderTable WHERE OrderTableID=?";

    @Override
    public void insert(OrderTableEntity orderTable) {
        JDBC.executeUpdate(INSERT_SQL,
                orderTable.getOrderID(),
                orderTable.getTableID(),
                orderTable.getStatus()
        );
    }

    @Override
    public void update(OrderTableEntity orderTable) {
        JDBC.executeUpdate(UPDATE_SQL,
                orderTable.getOrderID(),
                orderTable.getTableID(),
                orderTable.getStatus(),
                orderTable.getOrderTableID()
        );
    }

    @Override
    public void delete(Integer orderTableID) {
        JDBC.executeUpdate(DELETE_SQL, orderTableID);
    }

    @Override
    public List<OrderTableEntity> getAll() {
        return fetchByQuery(SELECT_ALL_SQL);
    }

    @Override
    public OrderTableEntity getById(Integer orderTableID) {
        List<OrderTableEntity> result = fetchByQuery(SELECT_BY_ID_SQL, orderTableID);
        return result.isEmpty() ? null : result.get(0);
    }

    @Override
    protected List<OrderTableEntity> fetchByQuery(String sql, Object... args) {
        List<OrderTableEntity> list = new ArrayList<>();

        try (ResultSet rs = JDBC.executeQuery(sql, args)) {
            while (rs.next()) {
                OrderTableEntity model = readFromResultSet(rs);
                list.add(model);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        return list;
    }

    private OrderTableEntity readFromResultSet(ResultSet rs) throws SQLException {
        OrderTableEntity model = new OrderTableEntity();
        model.setOrderTableID(rs.getInt("OrderTableID"));
        model.setOrderID(rs.getInt("OrderID"));
        model.setTableID(rs.getString("TableID"));
        model.setStatus(rs.getString("Status"));
        return model;
    }

}
