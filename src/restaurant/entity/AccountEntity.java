package restaurant.entity;

public class AccountEntity {

    private String idTaiKhoan;
    private String idNhanVien;
    private String taiKhoan;
    private String matKhau;
    private String ngayTao;

    public AccountEntity(String idTaiKhoan, String idNhanVien, String taiKhoan, String matKhau, String ngayTao) {
        this.idTaiKhoan = idTaiKhoan;
        this.idNhanVien = idNhanVien;
        this.taiKhoan = taiKhoan;
        this.matKhau = matKhau;
        this.ngayTao = ngayTao;
    }

    public String getIdTaiKhoan() {
        return idTaiKhoan;
    }

    public void setIdTaiKhoan(String idTaiKhoan) {
        this.idTaiKhoan = idTaiKhoan;
    }

    public String getIdNhanVien() {
        return idNhanVien;
    }

    public void setIdNhanVien(String idNhanVien) {
        this.idNhanVien = idNhanVien;
    }

    public String getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(String taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(String ngayTao) {
        this.ngayTao = ngayTao;
    }
}
