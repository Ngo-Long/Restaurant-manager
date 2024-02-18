package Entity;

import java.util.Date;

public class MonAnEntity {

    private String idMonAn;
    private String ten;
    private int gia;
    private String moTa;
    private String hinhAnh;
    private String phanLoai;
    private String trangThai;
    private Date ngayThem;
    private Date ngayCapNhat;

    public MonAnEntity(String idMonAn, String ten, int gia, String moTa, String hinhAnh, String phanLoai, String trangThai, Date ngayThem, Date ngayCapNhat) {
        this.idMonAn = idMonAn;
        this.ten = ten;
        this.gia = gia;
        this.moTa = moTa;
        this.hinhAnh = hinhAnh;
        this.phanLoai = phanLoai;
        this.trangThai = trangThai;
        this.ngayThem = ngayThem;
        this.ngayCapNhat = ngayCapNhat;
    }

    public String getIdMonAn() {
        return idMonAn;
    }

    public void setIdMonAn(String idMonAn) {
        this.idMonAn = idMonAn;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public String getPhanLoai() {
        return phanLoai;
    }

    public void setPhanLoai(String phanLoai) {
        this.phanLoai = phanLoai;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public Date getNgayThem() {
        return ngayThem;
    }

    public void setNgayThem(Date ngayThem) {
        this.ngayThem = ngayThem;
    }

    public Date getNgayCapNhat() {
        return ngayCapNhat;
    }

    public void setNgayCapNhat(Date ngayCapNhat) {
        this.ngayCapNhat = ngayCapNhat;
    }
}
