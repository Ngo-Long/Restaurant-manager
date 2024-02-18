package Entity;

import java.text.DecimalFormat;
import java.util.Date;

public class NguyenLieuEntity {

    private String idNguyenLieu;
    private String tenNguyenLieu;
    private int soLuongBanDau;
    private int soLuongToiThieu;
    private int donGia;
    private Date ngaySanXuat;
    private Date ngayHetHan;
    private String trangThai;

    public String getIdNguyenLieu() {
        return idNguyenLieu;
    }

    public void setIdNguyenLieu(String idNguyenLieu) {
        this.idNguyenLieu = idNguyenLieu;
    }

    public String getTenNguyenLieu() {
        return tenNguyenLieu;
    }

    public void setTenNguyenLieu(String tenNguyenLieu) {
        this.tenNguyenLieu = tenNguyenLieu;
    }

    public int getSoLuongBanDau() {
        return soLuongBanDau;
    }

    public void setSoLuongBanDau(int soLuongBanDau) {
        this.soLuongBanDau = soLuongBanDau;
    }

    public int getSoLuongToiThieu() {
        return soLuongToiThieu;
    }

    public void setSoLuongToiThieu(int soLuongToiThieu) {
        this.soLuongToiThieu = soLuongToiThieu;
    }

    public int getDonGia() {
        return donGia;
    }

    public void setDonGia(int donGia) {
        this.donGia = donGia;
    }

    public Date getNgaySanXuat() {
        return ngaySanXuat;
    }

    public void setNgaySanXuat(Date ngaySanXuat) {
        this.ngaySanXuat = ngaySanXuat;
    }

    public Date getNgayHetHan() {
        return ngayHetHan;
    }

    public void setNgayHetHan(Date ngayHetHan) {
        this.ngayHetHan = ngayHetHan;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
}
