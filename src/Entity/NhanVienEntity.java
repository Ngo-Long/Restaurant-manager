package Entity;

import java.util.Date;

public class NhanVienEntity {

    private String idNhanVien;
    private String idCa;
    private String hoTen;
    private String gioiTinh;
    private String sdt;
    private Date ngaySinh;
    private String cmnd;
    private String email;
    private String diaChi;
    private String hinhAnh;
    private String chucVu;
    private String trangThai;
    private double luong;
    private String moTa;
    private String nganHang;
    private String soTaiKhoan;
    private Date ngayVaoLam;

    private TaiKhoanEntity taiKhoanEntity;

    public NhanVienEntity(String idNhanVien, String hoTen, String chucVu) {
        this.idNhanVien = idNhanVien;
        this.hoTen = hoTen;
        this.chucVu = chucVu;
    }

    public NhanVienEntity(String idNhanVien, String idCa, String hoTen, String gioiTinh, String sdt, Date ngaySinh, String cmnd, String email, String diaChi, String hinhAnh, String chucVu, String trangThai, double luong, String moTa, String nganHang, String soTaiKhoan, Date ngayVaoLam) {
        this.idNhanVien = idNhanVien;
        this.idCa = idCa;
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.sdt = sdt;
        this.ngaySinh = ngaySinh;
        this.cmnd = cmnd;
        this.email = email;
        this.diaChi = diaChi;
        this.hinhAnh = hinhAnh;
        this.chucVu = chucVu;
        this.trangThai = trangThai;
        this.luong = luong;
        this.moTa = moTa;
        this.nganHang = nganHang;
        this.soTaiKhoan = soTaiKhoan;
        this.ngayVaoLam = ngayVaoLam;
    }

    public String getAvatarPath() {
        return hinhAnh;
    }

    public void setAvatarPath(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public String getIdNhanVien() {
        return idNhanVien;
    }

    public void setIdNhanVien(String idNhanVien) {
        this.idNhanVien = idNhanVien;
    }

    public String getIdCa() {
        return idCa;
    }

    public void setIdCa(String idCa) {
        this.idCa = idCa;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getChucVu() {
        return chucVu;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public double getLuong() {
        return luong;
    }

    public void setLuong(double luong) {
        this.luong = luong;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getNganHang() {
        return nganHang;
    }

    public void setNganHang(String nganHang) {
        this.nganHang = nganHang;
    }

    public String getSoTaiKhoan() {
        return soTaiKhoan;
    }

    public void setSoTaiKhoan(String soTaiKhoan) {
        this.soTaiKhoan = soTaiKhoan;
    }

    public Date getNgayVaoLam() {
        return ngayVaoLam;
    }

    public void setNgayVaoLam(Date ngayVaoLam) {
        this.ngayVaoLam = ngayVaoLam;
    }

    public TaiKhoanEntity getTaiKhoanEntity() {
        return taiKhoanEntity;
    }

    public void setTaiKhoanEntity(TaiKhoanEntity taiKhoanEntity) {
        this.taiKhoanEntity = taiKhoanEntity;
    }

    @Override
    public String toString() {
        return "NhanVien{"
                + "idNhanVien='" + idNhanVien + '\''
                + ", idCa='" + idCa + '\''
                + ", hoTen='" + hoTen + '\''
                + ", gioiTinh='" + gioiTinh + '\''
                + ", sdt=" + sdt
                + ", ngaySinh=" + ngaySinh
                + ", cmnd='" + cmnd + '\''
                + ", email='" + email + '\''
                + ", diaChi='" + diaChi + '\''
                + ", hinhAnh='" + hinhAnh + '\''
                + ", chucVu='" + chucVu + '\''
                + ", trangThai='" + trangThai + '\''
                + ", luong=" + luong
                + ", moTa='" + moTa + '\''
                + ", nganHang='" + nganHang + '\''
                + ", soTaiKhoan='" + soTaiKhoan + '\''
                + ", ngayVaoLam=" + ngayVaoLam
                + '}';
    }
}
