package restaurant.dao;

import restaurant.utils.JDBC;
import restaurant.entity.EmployeeEntity;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;

import java.util.List;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static restaurant.utils.JDBC.getConnection;

public class EmployeeDAO {

    public static final String INSERT_SQL = "INSERT INTO Employees (EmployeeID, ShiftID, FullName, Gender, Phone, DateOfBirth, IDCard, Email, Address, UrlImage, Position, Status, Salary, Description, Bank, AccountNumber, HireDate) "
            + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    public static final String UPDATE_SQL = "UPDATE Employees SET ShiftID=?, FullName=?, Gender=?, Phone=?, DateOfBirth=?, IDCard=?, Email=?, Address=?, UrlImage=?, Position=?, Status=?, Salary=?, Description=?, Bank=?, AccountNumber=?, HireDate=? WHERE EmployeeID=?";
    public static final String DELETE_SQL = "DELETE FROM Employees WHERE EmployeeID =?";
    public static final String IS_EXISTS_SQL = "SELECT COUNT(*) FROM Employees WHERE EmployeeID = ?";
    public static final String SELECT_ALL_SQL = "SELECT * FROM Employees";
    public static final String SELECT_BY_ID_SQL = "SELECT * FROM Employees WHERE EmployeeID=?";

    public void insert(EmployeeEntity entity) {
        JDBC.executeUpdate(INSERT_SQL,
                entity.getEmployeeID(),
                entity.getShiftID(),
                entity.getFullName(),
                entity.getGender(),
                entity.getPhone(),
                entity.getDateOfBirth(),
                entity.getIdCard(),
                entity.getEmail(),
                entity.getAddress(),
                entity.getUrlImage(),
                entity.getPosition(),
                entity.getStatus(),
                entity.getSalary(),
                entity.getDescription(),
                entity.getBank(),
                entity.getAccountNumber(),
                entity.getHireDate()
        );
    }

    public void update(EmployeeEntity entity) {
        JDBC.executeUpdate(UPDATE_SQL,
                entity.getShiftID(),
                entity.getFullName(),
                entity.getGender(),
                entity.getPhone(),
                entity.getDateOfBirth(),
                entity.getIdCard(),
                entity.getEmail(),
                entity.getAddress(),
                entity.getUrlImage(),
                entity.getPosition(),
                entity.getStatus(),
                entity.getSalary(),
                entity.getDescription(),
                entity.getBank(),
                entity.getAccountNumber(),
                entity.getHireDate(),
                entity.getEmployeeID()
        );
    }

    public void delete(String id) {
        JDBC.executeUpdate(DELETE_SQL, id);
    }

    public EmployeeEntity getById(String id) {
        List<EmployeeEntity> list = fetchByQuery(SELECT_BY_ID_SQL, id);
        return list.isEmpty() ? null : list.get(0);
    }

    public List<EmployeeEntity> getAll() {
        return fetchByQuery(SELECT_ALL_SQL);
    }

    public boolean isIdExists(String employeeID) {
        try (ResultSet rs = JDBC.executeQuery(IS_EXISTS_SQL, employeeID)) {
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public void updateStatusToResigned(String employeeID) {
        JDBC.executeUpdate("UPDATE Employees SET Status = 'Nghỉ việc' WHERE EmployeeID = ?", employeeID);
    }

    public static void searchAndClassifyEmployee(String keyword, String chucVu, String idCa, DefaultTableModel model) {
        try (Connection connection = getConnection()) {
            String sql = "SELECT * FROM NhanVien WHERE (? IS NULL OR chucVu LIKE ?) AND (? IS NULL OR idCa LIKE ?) "
                    + "AND (hoTen LIKE ? OR idNhanVien LIKE ?)";

            if ("Tất Cả CV".equals(chucVu)) {
                chucVu = null;
            }
            if ("Tất Cả Ca".equals(idCa)) {
                idCa = null;
            }

            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, chucVu);
                preparedStatement.setString(2, chucVu != null ? "%" + chucVu + "%" : "%");
                preparedStatement.setString(3, idCa);
                preparedStatement.setString(4, idCa != null ? "%" + idCa + "%" : "%");
                preparedStatement.setString(5, "%" + keyword + "%");
                preparedStatement.setString(6, "%" + keyword + "%");

                ResultSet resultSet = preparedStatement.executeQuery();

                model.setRowCount(0);
                while (resultSet.next()) {
                    Object[] row = {
                        resultSet.getString("idNhanVien"),
                        resultSet.getString("hoTen"),
                        resultSet.getString("gioiTinh"),
                        resultSet.getString("ngaySinh"),
                        resultSet.getString("chucVu"),
                        resultSet.getString("idCa"),
                        resultSet.getDouble("luong"),
                        resultSet.getString("trangThai")
                    };
                    model.addRow(row);
                }

                if (model.getRowCount() > 0) {
                    JOptionPane.showMessageDialog(null, "Tìm kiếm và phân loại thành công!", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Không tìm thấy kết quả nào!", "Thông Báo", JOptionPane.WARNING_MESSAGE);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi khi tìm kiếm và phân loại nhân viên.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    private List<EmployeeEntity> fetchByQuery(String sql, Object... args) {
        List<EmployeeEntity> list = new ArrayList<>();

        try (ResultSet rs = JDBC.executeQuery(sql, args)) {
            while (rs.next()) {
                EmployeeEntity model = readFromResultSet(rs);
                list.add(model);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        return list;
    }

    private EmployeeEntity readFromResultSet(ResultSet rs) throws SQLException {
        EmployeeEntity model = new EmployeeEntity();
        model.setEmployeeID(rs.getString("EmployeeID"));
        model.setShiftID(rs.getString("ShiftID"));
        model.setFullName(rs.getString("FullName"));
        model.setGender(rs.getString("Gender"));
        model.setPhone(rs.getString("Phone"));
        model.setDateOfBirth(rs.getDate("DateOfBirth"));
        model.setIdCard(rs.getString("IDCard"));
        model.setEmail(rs.getString("Email"));
        model.setAddress(rs.getString("Address"));
        model.setUrlImage(rs.getString("UrlImage"));
        model.setPosition(rs.getString("Position"));
        model.setStatus(rs.getString("Status"));
        model.setSalary(rs.getLong("Salary"));
        model.setDescription(rs.getString("Description"));
        model.setBank(rs.getString("Bank"));
        model.setAccountNumber(rs.getString("AccountNumber"));
        model.setHireDate(rs.getDate("HireDate"));
        return model;
    }
}
