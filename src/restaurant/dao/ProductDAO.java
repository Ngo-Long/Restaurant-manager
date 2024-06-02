package restaurant.dao;

import restaurant.entity.ProductEntity;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import restaurant.utils.JDBC;

public class ProductDAO {

    final String INSERT_SQL = "INSERT INTO Products (ProductID, ProductName, Price, Description, ImageURL, "
            + "Category, KitchenArea, Status, DateAdded, LastUpdated) VALUES (?, ?, ?, ?, ?, ?, ?, ?, GETDATE(), GETDATE())";
    final String UPDATE_SQL = "UPDATE Products SET ProductName=?, Price=?, Description=?, ImageURL=?, "
            + "Category=?, KitchenArea=?, Status=?, LastUpdated=GETDATE() WHERE ProductID=?";
    final String DELETE_SQL = "DELETE FROM Products WHERE ProductID=?";

    final String SELECT_ALL_SQL = "SELECT * FROM Products ORDER BY ProductName";
    final String SELECT_ALL_BY_CATEGORY_SQL = "SELECT * FROM Products WHERE Category=? ORDER BY ProductName";

    final String SELECT_BY_ID_SQL = "SELECT * FROM Products WHERE ProductID=?";
    static final String SELECT_ID_BY_NAME_SQL = "SELECT ProductID FROM Products WHERE ProductName=?";

    final String CHECK_DUPLICATED_ID_SQL = "SELECT COUNT(*) FROM Products WHERE ProductID=?";
    final String CHECK_DUPLICATED_NAME_SQL = "SELECT COUNT(*) FROM Products WHERE ProductName = ?";

    public void insert(ProductEntity model) {
        JDBC.executeUpdate(INSERT_SQL,
                model.getProductID(),
                model.getProductName(),
                model.getPrice(),
                model.getDescription(),
                model.getImageURL(),
                model.getCategory(),
                model.getKitchenArea(),
                model.getStatus()
        );
    }

    public void update(ProductEntity model) {
        JDBC.executeUpdate(UPDATE_SQL,
                model.getProductName(),
                model.getPrice(),
                model.getDescription(),
                model.getImageURL(),
                model.getCategory(),
                model.getKitchenArea(),
                model.getStatus(),
                model.getProductID()
        );
    }

    public void delete(String id) {
        JDBC.executeUpdate(DELETE_SQL, id);
    }

    public List<ProductEntity> getAll() {
        return fetchByQuery(SELECT_ALL_SQL);
    }

    public List<ProductEntity> getAllByCategory(String category) {
        return fetchByQuery(SELECT_ALL_BY_CATEGORY_SQL, category);
    }

    public ProductEntity getById(String id) {
        List<ProductEntity> list = fetchByQuery(SELECT_BY_ID_SQL, id);
        return list.isEmpty() ? null : list.get(0);
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

    public List<ProductEntity> searchByNameInCategory(String keyword, String category) {
        String sql = "SELECT * FROM Products WHERE ProductName LIKE ? AND Category LIKE ?";
        String searchTerm = "%" + keyword + "%";
        String categoryTerm = "%" + category + "%";

        return fetchByQuery(sql, searchTerm, categoryTerm);
    }

    private List<ProductEntity> fetchByQuery(String sql, Object... args) {
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
        model.setPrice(rs.getInt("Price"));
        model.setDescription(rs.getString("Description"));
        model.setImageURL(rs.getString("ImageURL"));
        model.setCategory(rs.getString("Category"));
        model.setKitchenArea(rs.getString("KitchenArea"));
        model.setStatus(rs.getString("Status"));
        model.setDateAdded(rs.getTimestamp("DateAdded"));
        model.setLastUpdated(rs.getTimestamp("LastUpdated"));
        return model;
    }
}
