package Entity;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class BillEntity {
    private int idHoaDon; 
    private String idDatHang;
    private String idNhanVien;
    private BigDecimal  thue;
    private BigDecimal  giamGia;
    private String phuongThucTT;
    private Timestamp thoiGianTT; 
    private String trangThai;
    private String ghiChu;
    private BigDecimal  tongTien;

    public int getIdHoaDon() {
        return idHoaDon;
    }

    public void setIdHoaDon(int idHoaDon) {
        this.idHoaDon = idHoaDon;
    }

    public String getIdDatHang() {
        return idDatHang;
    }

    public void setIdDatHang(String idDatHang) {
        this.idDatHang = idDatHang;
    }

    public String getIdNhanVien() {
        return idNhanVien;
    }

    public void setIdNhanVien(String idNhanVien) {
        this.idNhanVien = idNhanVien;
    }

    public BigDecimal getThue() {
        return thue;
    }

    public void setThue(BigDecimal thue) {
        this.thue = thue;
    }

    public BigDecimal getGiamGia() {
        return giamGia;
    }

    public void setGiamGia(BigDecimal giamGia) {
        this.giamGia = giamGia;
    }

    public String getPhuongThucTT() {
        return phuongThucTT;
    }

    public void setPhuongThucTT(String phuongThucTT) {
        this.phuongThucTT = phuongThucTT;
    }

    public Timestamp getThoiGianTT() {
        return thoiGianTT;
    }

    public void setThoiGianTT(Timestamp thoiGianTT) {
        this.thoiGianTT = thoiGianTT;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public BigDecimal getTongTien() {
        return tongTien;
    }

    public void setTongTien(BigDecimal tongTien) {
        this.tongTien = tongTien;
    }
}
