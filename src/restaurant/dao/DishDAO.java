package restaurant.dao;

import restaurant.entity.DishEntity;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DishDAO {

    public static final String INSERT_SQL = "INSERT INTO MonAn (idMonAn, ten, gia, moTa, hinhAnh, phanLoai, trangThai, ngayThem, ngayCapNhat) VALUES (?, ?, ?, ?, ?, ?, ?, GETDATE(), GETDATE())";
    public static final String UPDATE_SQL = "UPDATE MonAn SET ten=?, gia=?, moTa=?, hinhAnh=?, phanLoai=?, trangThai=?, ngayCapNhat=GETDATE() WHERE idMonAn=?";
    public static final String DELETE_SQL = "DELETE FROM MonAn WHERE idMonAn =?";
    public static final String SELECT_ALL_SQL = "SELECT * FROM MonAn";
    public static final String SELECT_ALL_AREA_SQL = "SELECT * FROM BanAn WHERE khuVuc = ?";
    public static final String SELECT_BY_ID_SQL = "SELECT * FROM MonAn WHERE idMonAn=?";
    public static final String SELECT_NAME_BY_ID_SQL = "SELECT ten FROM MonAn WHERE idMonAn = ?";
    public static final String CHECK_DUPLICATED_ID_SQL = "SELECT COUNT(*) FROM MonAn WHERE idMonAn=?";

    public List<DishEntity> getAll() {
        return fetchByQuery(SELECT_ALL_SQL);
    }

    public DishEntity getById(String id) {
        List<DishEntity> list = fetchByQuery(SELECT_BY_ID_SQL, id);
        return list.isEmpty() ? null : list.get(0);
    }

    public void insert(DishEntity model) {
        JDBC.executeUpdate(INSERT_SQL,
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
        JDBC.executeUpdate(UPDATE_SQL,
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
        JDBC.executeUpdate(DELETE_SQL, id);
    }

    public boolean isIdDuplicated(String id) {
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

    public static String getNameFoodFromId(String idMonAn) {
        try (ResultSet resultSet = JDBC.executeQuery(SELECT_NAME_BY_ID_SQL, idMonAn)) {
            return resultSet.next() ? resultSet.getString("ten") : null;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    private List<DishEntity> fetchByQuery(String sql, Object... args) {
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

//    public static void getIngredientsForFood(String idMonAn) {
//        String sql = "SELECT NL.* FROM NghienLieu NL "
//                + "JOIN MonAn_NghienLieu MNL ON NL.idNghienLieu = MNL.idNghienLieu "
//                + "WHERE MNL.idMonAn = ?";
//
//        try (ResultSet resultSetNguyenLieu = JDBC.executeQuery(sql, idMonAn)) {
//            System.out.println("\nNguyên liệu sử dụng trong món ăn:");
//
//            while (resultSetNguyenLieu.next()) {
//                System.out.println("ID Nguyên liệu: " + resultSetNguyenLieu.getString("idNghienLieu"));
//                System.out.println("Tên nguyên liệu: " + resultSetNguyenLieu.getString("ten"));
//                System.out.println("Đơn giá nguyên liệu: " + resultSetNguyenLieu.getDouble("donGia"));
//                System.out.println("Số lượng: " + resultSetNguyenLieu.getInt("soLuong"));
//                System.out.println("Ngày sản xuất: " + resultSetNguyenLieu.getTimestamp("ngaySanXuat"));
//                System.out.println("Ngày hết hạn: " + resultSetNguyenLieu.getTimestamp("ngayHetHan"));
//                System.out.println("------------------------------");
//            }
//        } catch (SQLException ex) {
//            throw new RuntimeException(ex);
//        }
//    }
//
}
