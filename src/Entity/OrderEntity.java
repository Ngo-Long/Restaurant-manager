package Entity;

import java.sql.Timestamp;
import java.util.List;

public class OrderEntity {

    private int idDatHang;
    private String idBanAn;
    private String idMonAn;
    private String idKhachHang;
    private int soLuongMonAn;
    private String trangThaiMonAn;
    private Timestamp thoiGianDatHang;
    private String ghiChu;

    // Constructors
    public OrderEntity(int idDatHang, String idBanAn, String idMonAn, String idKhachHang, int soLuongMonAn, String trangThaiMonAn, Timestamp thoiGianDatHang, String ghiChu) {
        this.idDatHang = idDatHang;
        this.idBanAn = idBanAn;
        this.idMonAn = idMonAn;
        this.idKhachHang = idKhachHang;
        this.soLuongMonAn = soLuongMonAn;
        this.trangThaiMonAn = trangThaiMonAn;
        this.thoiGianDatHang = thoiGianDatHang;
        this.ghiChu = ghiChu;
    }


    // Getter và Setter cho từng thuộc tính
    public int getIdDatHang() {
        return idDatHang;
    }

    public void setIdDatHang(int idDatHang) {
        this.idDatHang = idDatHang;
    }

    public String getIdBanAn() {
        return idBanAn;
    }

    public void setIdBanAn(String idBanAn) {
        this.idBanAn = idBanAn;
    }

    public String getIdMonAn() {
        return idMonAn;
    }

    public void setIdMonAn(String idMonAn) {
        this.idMonAn = idMonAn;
    }

    public String getIdKhachHang() {
        return idKhachHang;
    }

    public void setIdKhachHang(String idKhachHang) {
        this.idKhachHang = idKhachHang;
    }

    public int getSoLuongMonAn() {
        return soLuongMonAn;
    }

    public void setSoLuongMonAn(int soLuongMonAn) {
        this.soLuongMonAn = soLuongMonAn;
    }

    public String getTrangThaiMonAn() {
        return trangThaiMonAn;
    }

    public void setTrangThaiMonAn(String trangThaiMonAn) {
        this.trangThaiMonAn = trangThaiMonAn;
    }

    public Timestamp getThoiGianDatHang() {
        return thoiGianDatHang;
    }

    public void setThoiGianDatHang(Timestamp thoiGianDatHang) {
        this.thoiGianDatHang = thoiGianDatHang;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }
}