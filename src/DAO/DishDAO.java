package DAO;

import Entity.DishEntity;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DishDAO {

    public List<DishEntity> getAll() {
        String sql = "SELECT * FROM MonAn";
        return getAll(sql);
    }

    public DishEntity getById(String id) {
        String sql = "SELECT * FROM MonAn WHERE idMonAn=?";
        List<DishEntity> list = getAll(sql, id);
        return list.isEmpty() ? null : list.get(0);
    }

    public void insert(DishEntity model) {
        String sql = "INSERT INTO MonAn (idMonAn, ten, gia, moTa, hinhAnh, phanLoai, trangThai, ngayThem, ngayCapNhat) VALUES (?, ?, ?, ?, ?, ?, ?, GETDATE(), GETDATE())";
        JDBC.executeUpdate(sql,
                model.getIdMonAn(),
                model.getTen(),
                model.getGia(),
                model.getMoTa(),
                model.getHinhAnh(),
                model.getPhanLoai(),
                model.getTrangThai()
        );
    }

    public void update(DishEntity model) {
        String sql = "UPDATE MonAn SET ten=?, gia=?, moTa=?, hinhAnh=?, phanLoai=?, trangThai=?, ngayCapNhat=GETDATE() WHERE idMonAn=?";
        JDBC.executeUpdate(sql,
                model.getTen(),
                model.getGia(),
                model.getMoTa(),
                model.getHinhAnh(),
                model.getPhanLoai(),
                model.getTrangThai(),
                model.getIdMonAn()
        );
    }

    public void delete(String id) {
        String sql = "DELETE FROM MonAn WHERE idMonAn =?";
        JDBC.executeUpdate(sql, id);
    }

    public boolean isIdDuplicated(String id) {
        String sql = "SELECT COUNT(*) FROM MonAn WHERE idMonAn=?";

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

    private List<DishEntity> getAll(String sql, Object... args) {
        List<DishEntity> list = new ArrayList<>();

        try (ResultSet rs = JDBC.executeQuery(sql, args)) {
            while (rs.next()) {
                DishEntity model = readFromResultSet(rs);
                list.add(model);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        return list;
    }

    private DishEntity readFromResultSet(ResultSet rs) throws SQLException {
        DishEntity model = new DishEntity();
        model.setIdMonAn(rs.getString("idMonAn"));
        model.setTen(rs.getString("ten"));
        model.setGia(rs.getInt("gia"));
        model.setMoTa(rs.getString("moTa"));
        model.setHinhAnh(rs.getString("hinhAnh"));
        model.setPhanLoai(rs.getString("phanLoai"));
        model.setTrangThai(rs.getString("trangThai"));
        model.setNgayThem(rs.getTimestamp("ngayThem"));
        model.setNgayCapNhat(rs.getTimestamp("ngayCapNhat"));
        return model;
    }

    public static void getIngredientsForFood(String idMonAn) {
        String sql = "SELECT NL.* FROM NghienLieu NL "
                + "JOIN MonAn_NghienLieu MNL ON NL.idNghienLieu = MNL.idNghienLieu "
                + "WHERE MNL.idMonAn = ?";

        try (ResultSet resultSetNguyenLieu = JDBC.executeQuery(sql, idMonAn)) {
            System.out.println("\nNguyên liệu sử dụng trong món ăn:");

            while (resultSetNguyenLieu.next()) {
                System.out.println("ID Nguyên liệu: " + resultSetNguyenLieu.getString("idNghienLieu"));
                System.out.println("Tên nguyên liệu: " + resultSetNguyenLieu.getString("ten"));
                System.out.println("Đơn giá nguyên liệu: " + resultSetNguyenLieu.getDouble("donGia"));
                System.out.println("Số lượng: " + resultSetNguyenLieu.getInt("soLuong"));
                System.out.println("Ngày sản xuất: " + resultSetNguyenLieu.getTimestamp("ngaySanXuat"));
                System.out.println("Ngày hết hạn: " + resultSetNguyenLieu.getTimestamp("ngayHetHan"));
                System.out.println("------------------------------");
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public static String getNameFoodFromId(String idMonAn) {
        String sql = "SELECT ten FROM MonAn WHERE idMonAn = ?";

        try (ResultSet resultSet = JDBC.executeQuery(sql, idMonAn)) {
            return resultSet.next() ? resultSet.getString("ten") : null;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}
