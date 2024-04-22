package restaurant.dao;

import restaurant.entity.ProductsEntity;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductsDAO {

    public static final String INSERT_SQL = "INSERT INTO Products (ProductID, ProductName, Price, Description, ImageURL, Category, KitchenArea, Status, DateAdded, LastUpdated) VALUES (?, ?, ?, ?, ?, ?, ?, ?, GETDATE(), GETDATE())";
    public static final String UPDATE_SQL = "UPDATE Products SET ProductName=?, Price=?, Description=?, ImageURL=?, Category=?, KitchenArea=?, Status=?, LastUpdated=GETDATE() WHERE ProductID=?";
    public static final String DELETE_SQL = "DELETE FROM Products WHERE ProductID=?";
    public static final String SELECT_ALL_SQL = "SELECT * FROM Products";
    public static final String SELECT_BY_ID_SQL = "SELECT * FROM Products WHERE ProductID=?";
    public static final String CHECK_DUPLICATED_ID_SQL = "SELECT COUNT(*) FROM Products WHERE ProductID=?";
    public static final String CHECK_DUPLICATED_NAME_SQL = "SELECT COUNT(*) FROM Products WHERE ProductName = ?";
    public static final String SELECT_ID_BY_NAME_SQL = "SELECT ProductID FROM Products WHERE ProductName=?";

    public List<ProductsEntity> getAll() {
        return fetchByQuery(SELECT_ALL_SQL);
    }

    public ProductsEntity getById(String id) {
        List<ProductsEntity> list = fetchByQuery(SELECT_BY_ID_SQL, id);
        return list.isEmpty() ? null : list.get(0);
    }

    public void insert(ProductsEntity model) {
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

    public void update(ProductsEntity model) {
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

    private List<ProductsEntity> fetchByQuery(String sql, Object... args) {
        List<ProductsEntity> list = new ArrayList<>();

        try (ResultSet rs = JDBC.executeQuery(sql, args)) {
            while (rs.next()) {
                ProductsEntity model = readFromResultSet(rs);
                list.add(model);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        return list;
    }

    private ProductsEntity readFromResultSet(ResultSet rs) throws SQLException {
        ProductsEntity model = new ProductsEntity();
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
