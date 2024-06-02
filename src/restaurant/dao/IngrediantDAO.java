package restaurant.dao;

import restaurant.utils.JDBC;
import restaurant.entity.IngrediantEntity;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

public class IngrediantDAO extends RestaurantDAO<IngrediantEntity, String> {

    public static final String INSERT_SQL = "INSERT INTO Ingredients (IngredientID, IngredientName, InitialQuantity, MinimumQuantity, UnitPrice, ProductionDate, ExpirationDate, Status) "
            + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    public static final String UPDATE_SQL = "UPDATE Ingredients SET IngredientName=?, InitialQuantity=?, MinimumQuantity=?, UnitPrice=?, ProductionDate=?, ExpirationDate=?, Status=? WHERE IngredientID=?";
    public static final String DELETE_SQL = "DELETE FROM Ingredients WHERE IngredientID =?";
    public static final String IS_EXISTS_SQL = "SELECT COUNT(*) FROM Ingredients WHERE IngredientID = ?";
    public static final String SELECT_ALL_SQL = "SELECT * FROM Ingredients";
    public static final String SELECT_BY_ID_SQL = "SELECT * FROM Ingredients WHERE IngredientID=?";

    @Override
    public void insert(IngrediantEntity entity) {
        JDBC.executeUpdate(INSERT_SQL,
                entity.getIngredientID(),
                entity.getIngredientName(),
                entity.getInitialQuantity(),
                entity.getMinimumQuantity(),
                entity.getUnitPrice(),
                entity.getProductionDate(),
                entity.getExpirationDate(),
                entity.getStatus()
        );
    }

    @Override
    public void update(IngrediantEntity entity) {
        JDBC.executeUpdate(UPDATE_SQL,
                entity.getIngredientName(),
                entity.getInitialQuantity(),
                entity.getMinimumQuantity(),
                entity.getUnitPrice(),
                entity.getProductionDate(),
                entity.getExpirationDate(),
                entity.getStatus(),
                entity.getIngredientID()
        );
    }

    @Override
    public void delete(String id) {
        JDBC.executeUpdate(DELETE_SQL, id);
    }

    @Override
    public IngrediantEntity getById(String id) {
        List<IngrediantEntity> list = fetchByQuery(SELECT_BY_ID_SQL, id);
        return list.isEmpty() ? null : list.get(0);
    }

    @Override
    public List<IngrediantEntity> getAll() {
        return fetchByQuery(SELECT_ALL_SQL);
    }

    public boolean isIdExists(String ingredientID) {
        try (ResultSet rs = JDBC.executeQuery(IS_EXISTS_SQL, ingredientID)) {
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    protected List<IngrediantEntity> fetchByQuery(String sql, Object... args) {
        List<IngrediantEntity> list = new ArrayList<>();

        try (ResultSet rs = JDBC.executeQuery(sql, args)) {
            while (rs.next()) {
                IngrediantEntity model = readFromResultSet(rs);
                list.add(model);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        return list;
    }

    private IngrediantEntity readFromResultSet(ResultSet rs) throws SQLException {
        IngrediantEntity model = new IngrediantEntity();
        model.setIngredientID(rs.getString("IngredientID"));
        model.setIngredientName(rs.getString("IngredientName"));
        model.setInitialQuantity(rs.getInt("InitialQuantity"));
        model.setMinimumQuantity(rs.getInt("MinimumQuantity"));
        model.setUnitPrice(rs.getLong("UnitPrice"));
        model.setProductionDate(rs.getDate("ProductionDate"));
        model.setExpirationDate(rs.getDate("ExpirationDate"));
        model.setStatus(rs.getString("Status"));
        return model;
    }
}
