package restaurant.utils;

import restaurant.entity.EmployeeEntity;
import restaurant.entity.TablesEntity;

public class Auth {

    /**
     * Đối tượng tĩnh
     */
    public static int orderCount = 0;// Chứa số đơn hàng của bàn gần nhất
    public static String totalAmount = null; // Chứa tổng tiền của bàn gần nhất

    public static TablesEntity table = null; // Chứa thông tin bàn gần nhất
    public static EmployeeEntity user = null; // chứa thông tin người sử dụng sau khi đăng nhập

    /**
     * Xóa thông tin của người sử dụng khi có yêu cầu đăng xuất
     */
    public static void clear() {
        Auth.user = null;
    }

    /**
     * Kiểm tra xem đăng nhập hay chưa
     */
    public static boolean isLogin() {
        return Auth.user != null;
    }

    /**
     * Kiểm tra xem có phải là quản lý hay không
     */
    public static boolean isManager() {
        return Auth.isLogin() && "Quản Lý".equals(user.getPosition());
    }
}
