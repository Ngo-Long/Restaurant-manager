package restaurant.entity;

public class OrderEntity {

    private int idDatHang;
    private String idBanAn;
    private String trangThai;

    public int getOrderId() {
        return idDatHang;
    }

    public void setOrderId(int idDatHang) {
        this.idDatHang = idDatHang;
    }

    public String getDiningTableId() {
        return idBanAn;
    }

    public void setDiningTableId(String idBanAn) {
        this.idBanAn = idBanAn;
    }

    public String getStatus() {
        return trangThai;
    }

    public void setStatus(String trangThai) {
        this.trangThai = trangThai;
    }
}
