package restaurant.dao;

import restaurant.utils.JDBC;
import restaurant.entity.GoodsEntity;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

public class GoodsDAO extends RestaurantDAO<GoodsEntity, String> {

    final String INSERT_SQL = "INSERT INTO Goods (GoodsID, GoodsName, UnitPrice, Unit, "
            + "ImageURL, Category, InitialQuantity, MinimumQuantity, Status, Note, Activity) "
            + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    final String UPDATE_SQL = "UPDATE Goods SET GoodsName=?, UnitPrice=?, Unit=?, ImageURL=?, Category=?, "
            + "InitialQuantity=?, MinimumQuantity=?, Status=?, Note=?, Activity=? WHERE GoodsID=?";
    final String DELETE_SQL = "DELETE FROM Goods WHERE GoodsID =?";
    final String IS_EXISTS_SQL = "SELECT COUNT(*) FROM Goods WHERE GoodsID = ?";
    final String SELECT_ALL_SQL = "SELECT * FROM Goods";
    final String SELECT_BY_ID_SQL = "SELECT * FROM Goods WHERE GoodsID=?";
    final String SELECT_BY_CRITERIA = "SELECT TOP (1000) [GoodsID], [GoodsName], [UnitPrice], [Unit], "
            + "[ImageURL], [Category], [InitialQuantity], [MinimumQuantity], [Status], [Note], [Activity] "
            + "FROM [RestaurantManager].[dbo].[Goods] "
            + "WHERE ( GoodsID LIKE ? OR [GoodsName] LIKE ? ) "
            + "AND [Category] LIKE ? AND [Status] LIKE ?";

    @Override
    public void insert(GoodsEntity entity) {
        JDBC.executeUpdate(INSERT_SQL,
                entity.getGoodsID(),
                entity.getGoodsName(),
                entity.getUnitPrice(),
                entity.getUnit(),
                entity.getImageURL(),
                entity.getCategory(),
                entity.getInitialQuantity(),
                entity.getMinimumQuantity(),
                entity.getStatus(),
                entity.getNote(),
                entity.getActivity()
        );
    }

    @Override
    public void update(GoodsEntity entity) {
        JDBC.executeUpdate(UPDATE_SQL,
                entity.getGoodsName(),
                entity.getUnitPrice(),
                entity.getUnit(),
                entity.getImageURL(),
                entity.getCategory(),
                entity.getInitialQuantity(),
                entity.getMinimumQuantity(),
                entity.getStatus(),
                entity.getNote(),
                entity.getActivity(),
                entity.getGoodsID()
        );
    }

    @Override
    public void delete(String id) {
        JDBC.executeUpdate(DELETE_SQL, id);
    }

    @Override
    public GoodsEntity getByID(String id) {
        List<GoodsEntity> list = fetchByQuery(SELECT_BY_ID_SQL, id);
        return list.isEmpty() ? null : list.get(0);
    }

    @Override
    public List<GoodsEntity> getAll() {
        return fetchByQuery(SELECT_ALL_SQL);
    }

    public List<GoodsEntity> searchByCriteria(String id, String name, String category, String status) {
        String idTerm = "%" + id + "%";
        String nameTerm = "%" + name + "%";
        String categoryTerm = "%" + category + "%";
        String statusTerm = "%" + status + "%";

        return fetchByQuery(SELECT_BY_CRITERIA, idTerm, nameTerm, categoryTerm, statusTerm);
    }

    public boolean isIdExists(String id) {
        try (ResultSet rs = JDBC.executeQuery(IS_EXISTS_SQL, id)) {
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    protected List<GoodsEntity> fetchByQuery(String sql, Object... args) {
        List<GoodsEntity> list = new ArrayList<>();

        try (ResultSet rs = JDBC.executeQuery(sql, args)) {
            while (rs.next()) {
                GoodsEntity model = readFromResultSet(rs);
                list.add(model);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        return list;
    }

    private GoodsEntity readFromResultSet(ResultSet rs) throws SQLException {
        GoodsEntity model = new GoodsEntity();
        model.setGoodsID(rs.getString("GoodsID"));
        model.setGoodsName(rs.getString("GoodsName"));
        model.setUnitPrice(rs.getLong("UnitPrice"));
        model.setUnit(rs.getString("Unit"));
        model.setImageURL(rs.getString("ImageURL"));
        model.setCategory(rs.getString("Category"));
        model.setInitialQuantity(rs.getInt("InitialQuantity"));
        model.setMinimumQuantity(rs.getInt("MinimumQuantity"));
        model.setStatus(rs.getString("Status"));
        model.setNote(rs.getString("Note"));
        model.setActivity(rs.getString("Activity"));
        return model;
    }
}
