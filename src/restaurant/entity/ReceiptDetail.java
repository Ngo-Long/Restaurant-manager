package restaurant.entity;

public class ReceiptDetail {

    private int receiptDetailID;
    private String receiptID;
    private String goodsID;
    private int quantity;
    private long unitPrice;
    private long totalPrice;

    public int getReceiptDetailID() {
        return receiptDetailID;
    }

    public void setReceiptDetailID(int receiptDetailID) {
        this.receiptDetailID = receiptDetailID;
    }

    public String getReceiptID() {
        return receiptID;
    }

    public void setReceiptID(String receiptID) {
        this.receiptID = receiptID;
    }

    public String getGoodsID() {
        return goodsID;
    }

    public void setGoodsID(String goodsID) {
        this.goodsID = goodsID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
        updateTotalPrice();
    }

    public long getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(long unitPrice) {
        this.unitPrice = unitPrice;
        updateTotalPrice();
    }

    public long getTotalPrice() {
        return totalPrice;
    }

    private void updateTotalPrice() {
        this.totalPrice = this.quantity * this.unitPrice;
    }
}
