package restaurant.dao;

import restaurant.utils.JDBC;
import restaurant.entity.EmployeeEntity;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

public class EmployeeDAO extends RestaurantDAO<EmployeeEntity, String> {

    final String INSERT_SQL = "INSERT INTO Employee (EmployeeID, ShiftID, FullName, Gender, "
            + "Phone, DateOfBirth, IDCard, Email, Address, UrlImage, Position, Status, Salary, "
            + "Description, Bank, AccountNumber, HireDate) "
            + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    final String UPDATE_SQL = "UPDATE Employee SET ShiftID=?, FullName=?, Gender=?, Phone=?, "
            + "DateOfBirth=?, IDCard=?, Email=?, Address=?, UrlImage=?, Position=?, Status=?, "
            + "Salary=?, Description=?, Bank=?, AccountNumber=?, HireDate=? WHERE EmployeeID=?";
    final String DELETE_SQL = "DELETE FROM Employee WHERE EmployeeID =?";
    final String IS_EXISTS_SQL = "SELECT COUNT(*) FROM Employee WHERE EmployeeID = ?";
    final String SELECT_ALL_SQL = "SELECT * FROM Employee";
    final String SELECT_BY_ID_SQL = "SELECT * FROM Employee WHERE EmployeeID=?";

    final String SELECT_BY_CRITERIA = "SELECT TOP (1000) [EmployeeID], [ShiftID], [FullName], "
            + "[Gender], [Phone], [DateOfBirth], [IDCard], [Email], [Address], [UrlImage], "
            + "[Position], [Status], [Salary], [Description], [Bank], [AccountNumber], [HireDate] "
            + "FROM [RestaurantManager].[dbo].[Employee] "
            + "WHERE ( [EmployeeID] LIKE ? OR [FullName] LIKE ? ) "
            + "AND [Position] LIKE ? "
            + "AND [Status] LIKE ? ";

    public List<EmployeeEntity> searchByCriteria(String id, String name, String position, String status) {
        String idTerm = "%" + id + "%";
        String nameTerm = "%" + name + "%";
        String positionTerm = "%" + position + "%";
        String statusTerm = "%" + status + "%";

        return fetchByQuery(SELECT_BY_CRITERIA, idTerm, nameTerm, positionTerm, statusTerm);
    }

    @Override
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

    @Override
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

    @Override
    public void delete(String id) {
        JDBC.executeUpdate(DELETE_SQL, id);
    }

    @Override
    public EmployeeEntity getByID(String id) {
        List<EmployeeEntity> list = fetchByQuery(SELECT_BY_ID_SQL, id);
        return list.isEmpty() ? null : list.get(0);
    }

    @Override
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
        JDBC.executeUpdate("UPDATE Employee SET Status = 'Nghỉ việc' WHERE EmployeeID = ?", employeeID);
    }

    @Override
    protected List<EmployeeEntity> fetchByQuery(String sql, Object... args) {
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
