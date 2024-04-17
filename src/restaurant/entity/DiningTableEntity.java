package restaurant.entity;

public class DiningTableEntity {

    private String idBanAn;
    private String tenBanAn;
    private int soChoNgoi;
    private int phuThu;
    private String trangThai;
    private String khuVuc;
    private String moTa;

    public String getDiningTableId() {
        return idBanAn;
    }

    public void setDiningTableId(String idBanAn) {
        this.idBanAn = idBanAn;
    }

    public String getDiningTableName() {
        return tenBanAn;
    }

    public void setDiningTableName(String tenBanAn) {
        this.tenBanAn = tenBanAn;
    }

    public int getNumberOfSeats() {
        return soChoNgoi;
    }

    public void setNumberOfSeats(int soChoNgoi) {
        this.soChoNgoi = soChoNgoi;
    }

    public int getSurcharge() {
        return phuThu;
    }

    public void setSurcharge(int phuThu) {
        this.phuThu = phuThu;
    }

    public String getStatus() {
        return trangThai;
    }

    public void setStatus(String trangThai) {
        this.trangThai = trangThai;
    }

    public String getArea() {
        return khuVuc;
    }

    public void setArea(String khuVuc) {
        this.khuVuc = khuVuc;
    }

    public String getDesc() {
        return moTa;
    }

    public void setDesc(String moTa) {
        this.moTa = moTa;
    }
}
