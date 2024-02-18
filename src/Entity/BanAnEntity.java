package Entity;

import java.sql.Timestamp;

public class BanAnEntity {

    private String idBanAn;
    private String tenBanAn;
    private int soChoNgoi;
    private double phuThu;
    private String trangThai;
    private Timestamp ngayThem;
    private Timestamp ngayCapNhat;
    private String moTa;

    public BanAnEntity(String idBanAn, String tenBanAn, int soChoNgoi, double phuThu, String trangThai,
            Timestamp ngayThem, Timestamp ngayCapNhat, String moTa) {
        this.idBanAn = idBanAn;
        this.tenBanAn = tenBanAn;
        this.soChoNgoi = soChoNgoi;
        this.phuThu = phuThu;
        this.trangThai = trangThai;
        this.ngayThem = ngayThem;
        this.ngayCapNhat = ngayCapNhat;
        this.moTa = moTa;
    }

    public String getIdBanAn() {
        return idBanAn;
    }

    public void setIdBanAn(String idBanAn) {
        this.idBanAn = idBanAn;
    }

    public String getTenBanAn() {
        return tenBanAn;
    }

    public void setTenBanAn(String tenBanAn) {
        this.tenBanAn = tenBanAn;
    }

    public int getSoChoNgoi() {
        return soChoNgoi;
    }

    public void setSoChoNgoi(int soChoNgoi) {
        this.soChoNgoi = soChoNgoi;
    }

    public double getPhuThu() {
        return phuThu;
    }

    public void setPhuThu(double phuThu) {
        this.phuThu = phuThu;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public Timestamp getNgayThem() {
        return ngayThem;
    }

    public void setNgayThem(Timestamp ngayThem) {
        this.ngayThem = ngayThem;
    }

    public Timestamp getNgayCapNhat() {
        return ngayCapNhat;
    }

    public void setNgayCapNhat(Timestamp ngayCapNhat) {
        this.ngayCapNhat = ngayCapNhat;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }
}
