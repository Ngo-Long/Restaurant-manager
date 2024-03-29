package restaurant.dao;

import restaurant.entity.DiningTableEntity;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

public class DiningTableDAO {

    public static final String INSERT_SQL = "INSERT INTO BanAn (idBanAn, tenBanAn, khuVuc, soChoNgoi, phuThu, trangThai, moTa) VALUES (?, ?, ?, ?, ?, ?, ?)";
    public static final String UPDATE_SQL = "UPDATE BanAn SET tenBanAn=?, khuVuc=?, soChoNgoi=?, phuThu=?, trangThai=?, ngayCapNhat=GETDATE(), moTa=? WHERE idBanAn=?";
    public static final String DELETE_SQL = "DELETE FROM BanAn WHERE idBanAn =?";
    public static final String SELECT_ALL_SQL = "SELECT * FROM BanAn";
    public static final String SELECT_ALL_AREA_SQL = "SELECT * FROM BanAn WHERE khuVuc = ?";
    public static final String SELECT_BY_ID_SQL = "SELECT * FROM BanAn WHERE idBanAn=?";
    public static final String CHECK_DUPLICATED_ID_SQL = "SELECT COUNT(*) FROM BanAn WHERE idBanAn=?";

    public List<DiningTableEntity> getAll() {
        return fetchByQuery(SELECT_ALL_SQL);
    }

    public List<DiningTableEntity> getAllByArea(String area) {
        return fetchByQuery(SELECT_ALL_AREA_SQL, area);
    }

    public DiningTableEntity getById(String id) {
        List<DiningTableEntity> list = fetchByQuery(SELECT_BY_ID_SQL, id);
        return list.isEmpty() ? null : list.get(0);
    }

    public void insert(DiningTableEntity entity) {
        JDBC.executeUpdate(INSERT_SQL,
                entity.getIdBanAn(),
                entity.getTenBanAn(),
                entity.getKhuVuc(),
                entity.getSoChoNgoi(),
                entity.getPhuThu(),
                entity.getTrangThai(),
                entity.getMoTa()
        );
    }

    public void update(DiningTableEntity entity) {
        JDBC.executeUpdate(UPDATE_SQL,
                entity.getTenBanAn(),
                entity.getKhuVuc(),
                entity.getSoChoNgoi(),
                entity.getPhuThu(),
                entity.getTrangThai(),
                entity.getMoTa(),
                entity.getIdBanAn()
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

    private List<DiningTableEntity> fetchByQuery(String sql, Object... args) {
        List<DiningTableEntity> list = new ArrayList<>();

        try (ResultSet rs = JDBC.executeQuery(sql, args)) {
            while (rs.next()) {
                DiningTableEntity model = readFromResultSet(rs);
                list.add(model);
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Error while fetching data from database.", ex);
        }

        return list;
    }

    private DiningTableEntity readFromResultSet(ResultSet rs) throws SQLException {
        DiningTableEntity model = new DiningTableEntity();
        model.setIdBanAn(rs.getString("idBanAn"));
        model.setTenBanAn(rs.getString("tenBanAn"));
        model.setSoChoNgoi(rs.getInt("soChoNgoi"));
        model.setPhuThu(rs.getDouble("phuThu"));
        model.setTrangThai(rs.getString("trangThai"));
        model.setKhuVuc(rs.getString("khuVuc"));
        model.setNgayCapNhat(rs.getTimestamp("ngayCapNhat"));
        model.setMoTa(rs.getString("moTa"));
        return model;
    }

}
