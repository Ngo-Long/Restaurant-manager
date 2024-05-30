package restaurant.dao;

import restaurant.entity.IngrediantEntity;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import restaurant.utils.JDBC;

public class IngrediantDAO extends RestaurantDAO<IngrediantEntity, String> {

    @Override
    public List<IngrediantEntity> getAll() {
        String sql = "SELECT * FROM NguyenLieu";
        return getAll(sql);
    }

    @Override
    public IngrediantEntity getById(String id) {
        String sql = "SELECT * FROM NguyenLieu WHERE idNguyenLieu=?";
        List<IngrediantEntity> list = getAll(sql, id);
        return list.isEmpty() ? null : list.get(0);
    }

    @Override
    public void insert(IngrediantEntity model) {
        String sql = "INSERT INTO NguyenLieu (idNguyenLieu, tenNguyenLieu, soLuongBanDau, soLuongToiThieu, donGia, ngaySanXuat, ngayHetHan, trangThai) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        JDBC.executeUpdate(sql,
                model.getIdNguyenLieu(),
                model.getTenNguyenLieu(),
                model.getSoLuongBanDau(),
                model.getSoLuongToiThieu(),
                model.getDonGia(),
                model.getNgaySanXuat(),
                model.getNgayHetHan(),
                model.getTrangThai()
        );
    }

    @Override
    public void update(IngrediantEntity model) {
        String sql = "UPDATE NguyenLieu SET tenNguyenLieu=?, soLuongBanDau=?, soLuongToiThieu=?, donGia=?, ngaySanXuat=?, ngayHetHan=?, trangThai=? WHERE idNguyenLieu=?";
        JDBC.executeUpdate(sql,
                model.getIdNguyenLieu(),
                model.getTenNguyenLieu(),
                model.getSoLuongBanDau(),
                model.getSoLuongToiThieu(),
                model.getDonGia(),
                model.getNgaySanXuat(),
                model.getNgayHetHan(),
                model.getTrangThai()
        );
    }

    @Override
    public void delete(String id) {
        String sql = "DELETE FROM NguyenLieu WHERE idNguyenLieu=?";
        JDBC.executeUpdate(sql, id);
    }

    public boolean isIdDuplicated(String id) {
        String sql = "SELECT COUNT(*) FROM NguyenLieu WHERE idNguyenLieu=?";

        try (ResultSet rs = JDBC.executeQuery(sql, id)) {
            if (rs.next()) {
                int count = rs.getInt(1);
                return count > 0;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return false;
    }

    private List<IngrediantEntity> getAll(String sql, Object... args) {
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
        model.setIdNguyenLieu(rs.getString("idNguyenLieu"));
        model.setTenNguyenLieu(rs.getString("tenNguyenLieu"));
        model.setSoLuongBanDau(rs.getInt("soLuongBanDau"));
        model.setSoLuongToiThieu(rs.getInt("soLuongToiThieu"));
        model.setDonGia(rs.getInt("donGia"));
        model.setNgaySanXuat(rs.getDate("ngaySanXuat"));
        model.setNgayHetHan(rs.getDate("ngayHetHan"));
        model.setTrangThai(rs.getString("trangThai"));
        return model;
    }

    @Override
    protected List<IngrediantEntity> fetchByQuery(String sql, Object... args) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
