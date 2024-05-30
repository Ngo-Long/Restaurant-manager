package restaurant.dao;

import java.util.List;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
import restaurant.utils.JDBC;
import restaurant.entity.AccountEntity;

public class AccountDAO extends RestaurantDAO<AccountEntity, String> {

    final String INSERT_SQL = "INSERT INTO Accounts (AccountID, EmployeeID, Username, Password, CreatedDate) VALUES (?, ?, ?, ?, ?)";
    final String UPDATE_SQL = "UPDATE Accounts SET EmployeeID=?, Username=?, Password=?, CreatedDate=? WHERE AccountID=?";
    final String DELETE_SQL = "DELETE FROM Accounts WHERE AccountID=?";
    final String SELECT_ALL_SQL = "SELECT * FROM Accounts";
    final String SELECT_BY_ID_SQL = "SELECT * FROM Accounts WHERE AccountID=?";

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
    public AccountEntity getById(String id) {
        List<AccountEntity> list = fetchByQuery(SELECT_BY_ID_SQL, id);
        return list.isEmpty() ? null : list.get(0);
    }

    @Override
    public List<AccountEntity> getAll() {
        return fetchByQuery(SELECT_ALL_SQL);
    }

    public boolean checkLogin(String username, String password) {
        String sql = "SELECT COUNT(*) FROM Accounts WHERE Username = ? AND Password = ?";
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
        String sql = "SELECT EmployeeID FROM Accounts WHERE Username = ? AND Password = ?";
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

//    public static void searchAndClassifyEmployee(String keyword, String chucVu, String idCa, DefaultTableModel model) {
//        try (Connection connection = getConnection()) {
//            String sql = "SELECT N.*, TK.taiKhoan, TK.matKhau, TK.ngayTao "
//                    + "FROM NhanVien N LEFT JOIN TaiKhoan TK ON N.idNhanVien = TK.idNhanVien "
//                    + "WHERE (? IS NULL OR N.chucVu LIKE ?) AND (? IS NULL OR N.idCa LIKE ?) "
//                    + "AND (N.hoTen LIKE ? OR N.idNhanVien LIKE ?)";
//
//            if ("Tất Cả CV".equals(chucVu)) {
//                chucVu = null;
//            }
//
//            if ("Tất Cả Ca".equals(idCa)) {
//                idCa = null;
//            }
//
//            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
//                preparedStatement.setString(1, chucVu);
//                preparedStatement.setString(2, chucVu != null ? "%" + chucVu + "%" : "%");
//                preparedStatement.setString(3, idCa);
//                preparedStatement.setString(4, idCa != null ? "%" + idCa + "%" : "%");
//                preparedStatement.setString(5, "%" + keyword + "%");
//                preparedStatement.setString(6, "%" + keyword + "%");
//
//                ResultSet resultSet = preparedStatement.executeQuery();
//
//                model.setRowCount(0);
//
//                while (resultSet.next()) {
//                    Object[] row = {
//                        resultSet.getString("idNhanVien"),
//                        resultSet.getString("hoTen"),
//                        resultSet.getString("chucVu"),
//                        resultSet.getString("taiKhoan"),
//                        resultSet.getString("matKhau"),
//                        resultSet.getString("ngayTao")
//                    };
//                    model.addRow(row);
//                }
//
//                if (model.getRowCount() > 0) {
//                    JOptionPane.showMessageDialog(null, "Tìm kiếm và phân loại thành công!", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
//                } else {
//                    JOptionPane.showMessageDialog(null, "Không tìm thấy kết quả nào!", "Thông Báo", JOptionPane.WARNING_MESSAGE);
//                }
//            }
//        } catch (SQLException e) {
//            JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi khi tìm kiếm và phân loại nhân viên.", "Lỗi", JOptionPane.ERROR_MESSAGE);
//            e.printStackTrace();
//        }
//    }
}
