package restaurant.dao;

import java.util.List;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
import restaurant.utils.XJdbc;
import restaurant.entity.ReceiptDetail;

public class ReceiptDetailDAO extends RestaurantDAO<ReceiptDetail, Integer> {

    final String INSERT_SQL = "INSERT INTO ReceiptDetail (ReceiptID, GoodsID, "
            + "Quantity, UnitPrice) VALUES (?, ?, ?, ?)";
    final String UPDATE_SQL = "UPDATE ReceiptDetail SET ReceiptID=?, GoodsID=?, "
            + "Quantity=?, UnitPrice=? WHERE ReceiptDetailID=?";
    final String DELETE_SQL = "DELETE FROM ReceiptDetail WHERE ReceiptDetailID =?";
    final String IS_EXISTS_SQL = "SELECT COUNT(*) FROM ReceiptDetail WHERE ReceiptDetailID = ?";
    final String SELECT_ALL_SQL = "SELECT * FROM ReceiptDetail";
    final String SELECT_BY_ID_SQL = "SELECT * FROM ReceiptDetail WHERE ReceiptDetailID=?";

    @Override
    public void insert(ReceiptDetail entity) {
        XJdbc.executeUpdate(INSERT_SQL,
                entity.getReceiptID(),
                entity.getGoodsID(),
                entity.getQuantity(),
                entity.getUnitPrice()
        );
    }

    @Override
    public void update(ReceiptDetail entity) {
        XJdbc.executeUpdate(UPDATE_SQL,
                entity.getReceiptID(),
                entity.getGoodsID(),
                entity.getQuantity(),
                entity.getUnitPrice(),
                entity.getReceiptDetailID()
        );
    }

    @Override
    public void delete(Integer id) {
        XJdbc.executeUpdate(DELETE_SQL, id);
    }

    @Override
    public ReceiptDetail getByID(Integer id) {
        List<ReceiptDetail> list = fetchByQuery(SELECT_BY_ID_SQL, id);
        return list.isEmpty() ? null : list.get(0);
    }

    @Override
    public List<ReceiptDetail> getAll() {
        return fetchByQuery(SELECT_ALL_SQL);
    }

    public boolean isIdExists(Integer id) {
        try (ResultSet rs = XJdbc.executeQuery(IS_EXISTS_SQL, id)) {
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    protected List<ReceiptDetail> fetchByQuery(String sql, Object... args) {
        List<ReceiptDetail> list = new ArrayList<>();

        try (ResultSet rs = XJdbc.executeQuery(sql, args)) {
            while (rs.next()) {
                ReceiptDetail model = readFromResultSet(rs);
                list.add(model);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        return list;
    }

    private ReceiptDetail readFromResultSet(ResultSet rs) throws SQLException {
        ReceiptDetail model = new ReceiptDetail();
        model.setReceiptDetailID(rs.getInt("ReceiptDetailID"));
        model.setReceiptID(rs.getString("ReceiptID"));
        model.setGoodsID(rs.getString("GoodsID"));
        model.setQuantity(rs.getInt("Quantity"));
        model.setUnitPrice(rs.getLong("UnitPrice"));
        return model;
    }
}
