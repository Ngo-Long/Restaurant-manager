package restaurant.utils;

import restaurant.entity.TablesEntity;

public class DiningTableInfo {

    // Đối tượng này chứa thông tin bàn 
    public static TablesEntity table = null;

    // Xóa thông tin bàn
    public static void clear() {
        DiningTableInfo.table = null;
    }

    // Thiết lập thông tin bàn
    public static void setTable(TablesEntity table) {
        DiningTableInfo.table = table;
    }

    // Truy xuất thông tin bàn
    public static TablesEntity getTable() {
        return DiningTableInfo.table;
    }

}
