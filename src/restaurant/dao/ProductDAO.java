package restaurant.dao;

import java.util.List;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
import restaurant.utils.JDBC;
import restaurant.entity.ProductEntity;

public class ProductDAO extends RestaurantDAO<ProductEntity, String> {

    final String INSERT_SQL = "INSERT INTO Product (ProductID, ProductName, CostPrice, Price, Unit, ImageURL, "
            + "Category, KitchenArea, Description, Status) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    final String UPDATE_SQL = "UPDATE Product SET ProductName=?, CostPrice=?, Price=?, Unit=?, ImageURL=?, "
            + "Category=?, KitchenArea=?, Description=?, Status=? WHERE ProductID=?";
    final String DELETE_SQL = "DELETE FROM Product WHERE ProductID=?";
    final String SELECT_ALL_SQL = "SELECT * FROM Product ORDER BY ProductName";
    final String SELECT_ALL_BY_CATEGORY_SQL = "SELECT * FROM Product WHERE Category=? ORDER BY ProductName";

    final String SELECT_BY_ID_SQL = "SELECT * FROM Product WHERE ProductID=?";
    static final String SELECT_ID_BY_NAME_SQL = "SELECT ProductID FROM Product WHERE ProductName=?";

    final String SELECT_BY_CRITERIA_SQL = "SELECT TOP 1000 ProductID, ProductName, CostPrice, Price, Unit, "
            + "ImageURL, Category, KitchenArea, Description, Status FROM Product "
            + "WHERE ProductName LIKE ? "
            + "AND Category LIKE ? "
            + "AND Status LIKE ? "
            + "ORDER BY ProductName";

    final String CHECK_DUPLICATED_ID_SQL = "SELECT COUNT(*) FROM Product WHERE ProductID=?";
    final String CHECK_DUPLICATED_NAME_SQL = "SELECT COUNT(*) FROM Product WHERE ProductName = ?";

    @Override
    public void insert(ProductEntity model) {
        JDBC.executeUpdate(INSERT_SQL,
                model.getProductID(),
                model.getProductName(),
                model.getCostPrice(),
                model.getPrice(),
                model.getUnit(),
                model.getImageURL(),
                model.getCategory(),
                model.getKitchenArea(),
                model.getDescription(),
                model.getStatus()
        );
    }

    @Override
    public void update(ProductEntity model) {
        JDBC.executeUpdate(UPDATE_SQL,
                model.getProductName(),
                model.getCostPrice(),
                model.getPrice(),
                model.getUnit(),
                model.getImageURL(),
                model.getCategory(),
                model.getKitchenArea(),
                model.getDescription(),
                model.getStatus(),
                model.getProductID()
        );
    }

    @Override
    public void delete(String id) {
        JDBC.executeUpdate(DELETE_SQL, id);
    }

    @Override
    public ProductEntity getByID(String id) {
        List<ProductEntity> list = fetchByQuery(SELECT_BY_ID_SQL, id);
        return list.isEmpty() ? null : list.get(0);
    }

    @Override
    public List<ProductEntity> getAll() {
        return fetchByQuery(SELECT_ALL_SQL);
    }

    public List<ProductEntity> getAllByCategory(String category) {
        return fetchByQuery(SELECT_ALL_BY_CATEGORY_SQL, category);
    }

    public boolean isDuplicatedId(String id) {
        try (ResultSet rs = JDBC.executeQuery(CHECK_DUPLICATED_ID_SQL, id)) {
            if (rs.next()) {
                int count = rs.getInt(1);
                return count > 0;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return false;
    }

    public boolean isDuplicateName(String name) {
        try (ResultSet rs = JDBC.executeQuery(CHECK_DUPLICATED_NAME_SQL, name)) {
            if (rs.next()) {
                int count = rs.getInt(1);
                return count > 0;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public static String getIdDishFromName(String dishName) {
        try (ResultSet resultSet = JDBC.executeQuery(SELECT_ID_BY_NAME_SQL, dishName)) {
            return resultSet.next() ? resultSet.getString("ProductID") : null;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public List<ProductEntity> searchByCriteria(String name, String category, String status) {
        String nameTerm = "%" + name + "%";
        String categoryTerm = "%" + category + "%";
        String statusTerm = "%" + status + "%";

        return this.fetchByQuery(SELECT_BY_CRITERIA_SQL, nameTerm, categoryTerm, statusTerm);
    }

    @Override
    protected List<ProductEntity> fetchByQuery(String sql, Object... args) {
        List<ProductEntity> list = new ArrayList<>();

        try (ResultSet rs = JDBC.executeQuery(sql, args)) {
            while (rs.next()) {
                ProductEntity model = readFromResultSet(rs);
                list.add(model);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        return list;
    }

    private ProductEntity readFromResultSet(ResultSet rs) throws SQLException {
        ProductEntity model = new ProductEntity();
        model.setProductID(rs.getString("ProductID"));
        model.setProductName(rs.getString("ProductName"));
        model.setCostPrice(rs.getLong("CostPrice"));
        model.setPrice(rs.getLong("Price"));
        model.setUnit(rs.getString("Unit"));
        model.setImageURL(rs.getString("ImageURL"));
        model.setCategory(rs.getString("Category"));
        model.setKitchenArea(rs.getString("KitchenArea"));
        model.setDescription(rs.getString("Description"));
        model.setStatus(rs.getString("Status"));
        return model;
    }
}
