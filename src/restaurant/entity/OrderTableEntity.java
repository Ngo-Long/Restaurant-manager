package restaurant.entity;

public class OrderTableEntity {

    private int orderTableID;
    private int orderID;
    private String tableID;
    private String status;

    public int getOrderTableID() {
        return orderTableID;
    }

    public void setOrderTableID(int orderTableID) {
        this.orderTableID = orderTableID;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public String getTableID() {
        return tableID;
    }

    public void setTableID(String tableID) {
        this.tableID = tableID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
