package restaurant.dao;

import restaurant.entity.OrderDetailEntity;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

public class OrderDetailDAO {

    public static final String INSERT_SQL = "INSERT INTO ChiTietDatHang (idDatHang, idMonAn, soLuongMonAn, trangThaiMonAn, moTa) VALUES (?, ?, ?, ?, ?)";
    public static final String UPDATE_SQL = "UPDATE ChiTietDatHang SET idDatHang=?, idMonAn=?, soLuongMonAn=?, trangThaiMonAn=?, moTa=? WHERE idChiTietDatHang=?";
    public static final String DELETE_SQL = "DELETE FROM ChiTietDatHang WHERE idChiTietDatHang =?";
    public static final String SELECT_ALL_SQL = "SELECT * FROM ChiTietDatHang";
    public static final String SELECT_BY_ID_SQL = "SELECT * FROM ChiTietDatHang WHERE idChiTietDatHang=?";

    public void insert(OrderDetailEntity entity) {
        JDBC.executeUpdate(INSERT_SQL,
                entity.getOrderId(),
                entity.getDishId(),
                entity.getDishQuantity(),
                entity.getDishStatus(),
                entity.getDishDesc()
        );
    }

    public void update(OrderDetailEntity entity) {
        JDBC.executeUpdate(UPDATE_SQL,
                entity.getOrderId(),
                entity.getDishId(),
                entity.getDishQuantity(),
                entity.getDishStatus(),
                entity.getDishDesc(),
                entity.getOrderDetailId()
        );
    }

    public void delete(int id) {
        JDBC.executeUpdate(DELETE_SQL, id);
    }

    public OrderDetailEntity getById(int id) {
        List<OrderDetailEntity> list = fetchByQuery(SELECT_BY_ID_SQL, id);
        return list.isEmpty() ? null : list.get(0);
    }

    private List<OrderDetailEntity> fetchByQuery(String sql, Object... args) {
        List<OrderDetailEntity> list = new ArrayList<>();

        try (ResultSet rs = JDBC.executeQuery(sql, args)) {
            while (rs.next()) {
                OrderDetailEntity model = readFromResultSet(rs);
                list.add(model);
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Error while fetching data from database.", ex);
        }

        return list;
    }

    private OrderDetailEntity readFromResultSet(ResultSet rs) throws SQLException {
        OrderDetailEntity model = new OrderDetailEntity();
        model.setOrderDetailId(rs.getInt("idChiTietDatHang"));
        model.setOrderId(rs.getInt("idDatHang"));
        model.setDishId(rs.getString("idMonAn"));
        model.setDishQuantity(rs.getInt("soLuongMonAn"));
        model.setDishStatus(rs.getString("trangThaiMonAn"));
        model.setDishDesc(rs.getString("moTa"));
        return model;
    }
}
