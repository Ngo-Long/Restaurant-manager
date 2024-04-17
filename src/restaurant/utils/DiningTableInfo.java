package restaurant.utils;

import restaurant.entity.DiningTableEntity;

public class DiningTableInfo {

    // Đối tượng này chứa thông tin bàn 
    public static DiningTableEntity table = null;

    // Xóa thông tin bàn
    public static void clear() {
        DiningTableInfo.table = null;
    }

    // Thiết lập thông tin bàn
    public static void setTable(DiningTableEntity table) {
        DiningTableInfo.table = table;
    }

    // Truy xuất thông tin bàn
    public static DiningTableEntity getTable() {
        return DiningTableInfo.table;
    }

}
