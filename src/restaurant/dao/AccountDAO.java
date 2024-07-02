package restaurant.dao;

import java.util.List;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
import restaurant.utils.JDBC;
import restaurant.entity.AccountEntity;

public class AccountDAO extends RestaurantDAO<AccountEntity, String> {

    final String INSERT_SQL = "INSERT INTO Account (AccountID, EmployeeID, Username, Password, CreatedDate) VALUES (?, ?, ?, ?, ?)";
    final String UPDATE_SQL = "UPDATE Account SET EmployeeID=?, Username=?, Password=?, CreatedDate=? WHERE AccountID=?";
    final String DELETE_SQL = "DELETE FROM Account WHERE AccountID=?";
    final String SELECT_ALL_SQL = "SELECT * FROM Account";
    final String SELECT_BY_ID_SQL = "SELECT * FROM Account WHERE AccountID=?";

    @Override
    public void insert(AccountEntity entity) {
        JDBC.executeUpdate(INSERT_SQL,
                entity.getAccountID(),
                entity.getEmployeeID(),
                entity.getUsername(),
                entity.getPassword(),
                entity.getCreatedDate()
        );
    }

    @Override
    public void update(AccountEntity entity) {
        JDBC.executeUpdate(UPDATE_SQL,
                entity.getEmployeeID(),
                entity.getUsername(),
                entity.getPassword(),
                entity.getCreatedDate(),
                entity.getAccountID()
        );
    }

    @Override
    public void delete(String id) {
        JDBC.executeUpdate(DELETE_SQL, id);
    }

    @Override
    public AccountEntity getByID(String id) {
        List<AccountEntity> list = fetchByQuery(SELECT_BY_ID_SQL, id);
        return list.isEmpty() ? null : list.get(0);
    }

    @Override
    public List<AccountEntity> getAll() {
        return fetchByQuery(SELECT_ALL_SQL);
    }

    public boolean checkLogin(String username, String password) {
        String sql = "SELECT COUNT(*) FROM Account WHERE Username = ? AND Password = ?";
        try (ResultSet rs = JDBC.executeQuery(sql, username, password)) {
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public String findEmployeeIDByAccount(String username, String password) {
        String sql = "SELECT EmployeeID FROM Account WHERE Username = ? AND Password = ?";
        try (ResultSet rs = JDBC.executeQuery(sql, username, password)) {
            if (rs.next()) {
                return rs.getString("EmployeeID");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    protected List<AccountEntity> fetchByQuery(String sql, Object... args) {
        List<AccountEntity> list = new ArrayList<>();

        try (ResultSet rs = JDBC.executeQuery(sql, args)) {
            while (rs.next()) {
                AccountEntity model = readFromResultSet(rs);
                list.add(model);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        return list;
    }

    private AccountEntity readFromResultSet(ResultSet rs) throws SQLException {
        AccountEntity model = new AccountEntity();
        model.setAccountID(rs.getString("AccountID"));
        model.setEmployeeID(rs.getString("EmployeeID"));
        model.setUsername(rs.getString("Username"));
        model.setPassword(rs.getString("Password"));
        model.setCreatedDate(rs.getString("CreatedDate"));
        return model;
    }

}
