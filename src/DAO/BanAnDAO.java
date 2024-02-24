package DAO;

import Entity.BanAnEntity;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

public class BanAnDAO {

    public List<BanAnEntity> getAll() {
        String sql = "SELECT * FROM BanAn";
        return getAll(sql);
    }

    public BanAnEntity getById(String id) {
        String sql = "SELECT * FROM BanAn WHERE idBanAn=?";
        List<BanAnEntity> list = getAll(sql, id);
        return list.isEmpty() ? null : list.get(0);
    }

    public void insert(BanAnEntity model) {
        String sql = "INSERT INTO BanAn (idBanAn, tenBanAn, soChoNgoi, phuThu, trangThai, moTa, ngayThem, ngayCapNhat) VALUES (?, ?, ?, ?, ?, ?, GETDATE(), GETDATE())";
        JDBC.executeUpdate(sql,
                model.getIdBanAn(),
                model.getTenBanAn(),
                model.getSoChoNgoi(),
                model.getPhuThu(),
                model.getTrangThai(),
                model.getMoTa()
        );
    }

    public void update(BanAnEntity model) {
        String sql = "UPDATE BanAn SET tenBanAn=?, soChoNgoi=?, phuThu=?, trangThai=?, moTa=?, ngayCapNhat=GETDATE() WHERE idBanAn=?";
        JDBC.executeUpdate(sql,
                model.getTenBanAn(),
                model.getSoChoNgoi(),
                model.getPhuThu(),
                model.getTrangThai(),
                model.getMoTa(),
                model.getIdBanAn()
        );
    }

    public void delete(String id) {
        String sql = "DELETE FROM BanAn WHERE idBanAn =?";
        JDBC.executeUpdate(sql, id);
    }

    public boolean isIdDuplicated(String id) {
        String sql = "SELECT COUNT(*) FROM BanAn WHERE idBanAn=?";

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

    private List<BanAnEntity> getAll(String sql, Object... args) {
        List<BanAnEntity> list = new ArrayList<>();

        try (ResultSet rs = JDBC.executeQuery(sql, args)) {
            while (rs.next()) {
                BanAnEntity model = readFromResultSet(rs);
                list.add(model);
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Error while fetching data from database.", ex);
        }

        return list;
    }

    private BanAnEntity readFromResultSet(ResultSet rs) throws SQLException {
        BanAnEntity model = new BanAnEntity();
        model.setIdBanAn(rs.getString("idBanAn"));
        model.setTenBanAn(rs.getString("tenBanAn"));
        model.setSoChoNgoi(rs.getInt("soChoNgoi"));
        model.setPhuThu(rs.getDouble("phuThu"));
        model.setTrangThai(rs.getString("trangThai"));
        model.setNgayThem(rs.getTimestamp("ngayThem"));
        model.setNgayCapNhat(rs.getTimestamp("ngayCapNhat"));
        model.setMoTa(rs.getString("moTa"));
        return model;
    }

}
