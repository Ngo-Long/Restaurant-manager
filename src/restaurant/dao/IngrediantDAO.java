package restaurant.dao;

import restaurant.entity.IngrediantEntity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import restaurant.utils.JDBC;

public class IngrediantDAO {

    public List<IngrediantEntity> getAll() {
        String sql = "SELECT * FROM NguyenLieu";
        return getAll(sql);
    }

    public IngrediantEntity getById(String id) {
        String sql = "SELECT * FROM NguyenLieu WHERE idNguyenLieu=?";
        List<IngrediantEntity> list = getAll(sql, id);
        return list.isEmpty() ? null : list.get(0);
    }

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

//    public static void searchAndClassifyIngredient(String keyword, String trangThai, DefaultTableModel model) {
//        String sql = "SELECT * FROM NguyenLieu WHERE (? IS NULL OR trangThai LIKE ?)"
//                + "AND (tenNguyenLieu LIKE ? OR idNguyenLieu LIKE ?)";
//        keyword = "%" + keyword + "%"; // Adding wildcards to search for partial matches
//
//        try (ResultSet rs = JDBC.executeQuery(sql, keyword, trangThai)) {
//            model.setRowCount(0); // Clear existing rows in the table model
//
//            while (rs.next()) {
//                NguyenLieuEntity ingredient = readFromResultSet(rs);
//
//                model.addRow(new Object[]{
//                    ingredient.getIdNguyenLieu(),
//                    ingredient.getTenNguyenLieu(),
//                    ingredient.getSoLuongBanDau(),
//                    ingredient.getSoLuongToiThieu(),
//                    ingredient.getDonGia(),
//                    ingredient.getNgaySanXuat(),
//                    ingredient.getNgayHetHan(),
//                    ingredient.getTrangThai()
//                });
//            }
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//    }
    public static void searchAndClassifyIngredient(String keyword, String trangThai, DefaultTableModel model) {
        try (Connection connection = JDBC.getConnection()) {
            String sql = "SELECT * FROM NguyenLieu WHERE (? IS NULL OR trangThai LIKE ?) AND (tenNguyenLieu LIKE ? OR idNguyenLieu LIKE ?)";

            trangThai = ("Trạng thái".equals(trangThai)) ? null : trangThai;
            keyword = "%" + keyword + "%";

            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, trangThai);
                preparedStatement.setString(2, (trangThai != null) ? "%" + trangThai + "%" : "%");
                preparedStatement.setString(3, keyword);
                preparedStatement.setString(4, keyword);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    model.setRowCount(0);

                    while (resultSet.next()) {
                        Object[] row = {
                            resultSet.getString("idNguyenLieu"),
                            resultSet.getString("tenNguyenLieu"),
                            resultSet.getString("soLuongBanDau"),
                            resultSet.getString("soLuongToiThieu"),
                            resultSet.getInt("donGia"),
                            resultSet.getString("trangThai")
                        };
                        model.addRow(row);
                    }
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
}
