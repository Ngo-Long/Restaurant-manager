package restaurant.dao;

import restaurant.entity.OrderEntity;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO {

    public static final String INSERT_SQL = "INSERT INTO DatHang (idBanAn, trangThai, thoiGian) VALUES (?, ?, GETDATE())";
    public static final String UPDATE_SQL = "UPDATE DatHang SET idBanAn=?, trangThai=?, thoiGian=GETDATE() WHERE idDatHang=?";
    public static final String DELETE_SQL = "DELETE FROM DatHang WHERE idDatHang=?";
    public static final String SELECT_ALL_SQL = "SELECT * FROM DatHang";

    public List<OrderEntity> getAll() {
        return fetchByQuery(SELECT_ALL_SQL);
    }

    public void insert(OrderEntity model) {
        JDBC.executeUpdate(INSERT_SQL,
                model.getDiningTableId(),
                model.getStatus()
        );
    }

    public void update(OrderEntity model) {
        JDBC.executeUpdate(UPDATE_SQL,
                model.getDiningTableId(),
                model.getStatus(),
                model.getOrderId()
        );
    }

    public void delete(int id) {
        JDBC.executeUpdate(DELETE_SQL, id);
    }

    public OrderEntity getOrderByDiningTableId(String diningTableId) {
        String sql = "SELECT * FROM DatHang WHERE idBanAn = ?";
        List<OrderEntity> orders = fetchByQuery(sql, diningTableId);
        return orders.isEmpty() ? null : orders.get(0);
    }

    private List<OrderEntity> fetchByQuery(String sql, Object... args) {
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
        model.setOrderId(rs.getInt("idDatHang"));
        model.setDiningTableId(rs.getString("idBanAn"));
        model.setStatus(rs.getString("trangThai"));
        return model;
    }
}
