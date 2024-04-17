package restaurant.entity;

public class OrderDetailEntity {

    private int idChiTietDatHang;
    private int idDatHang;
    private String idMonAn;
    private int soLuongMonAn;
    private String trangThaiMonAn;
    private String moTa;

    public int getOrderDetailId() {
        return idChiTietDatHang;
    }

    public void setOrderDetailId(int idChiTietDatHang) {
        this.idChiTietDatHang = idChiTietDatHang;
    }

    public int getOrderId() {
        return idDatHang;
    }

    public void setOrderId(int idDatHang) {
        this.idDatHang = idDatHang;
    }

    public String getDishId() {
        return idMonAn;
    }

    public void setDishId(String idMonAn) {
        this.idMonAn = idMonAn;
    }

    public int getDishQuantity() {
        return soLuongMonAn;
    }

    public void setDishQuantity(int soLuongMonAn) {
        this.soLuongMonAn = soLuongMonAn;
    }

    public String getDishStatus() {
        return trangThaiMonAn;
    }

    public void setDishStatus(String trangThaiMonAn) {
        this.trangThaiMonAn = trangThaiMonAn;
    }

    public String getDishDesc() {
        return moTa;
    }

    public void setDishDesc(String moTa) {
        this.moTa = moTa;
    }
}
