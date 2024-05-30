package restaurant.utils;

import java.util.List;
import restaurant.entity.EmployeeEntity;
import restaurant.entity.InvoicesEntity;
import restaurant.entity.OrderDetailsEntity;
import restaurant.entity.OrdersEntity;
import restaurant.entity.TablesEntity;

public class Auth {

    /**
     * Đối tượng tĩnh
     */
    public static int orderCount = 0;// Chứa số đơn hàng của bàn gần nhất
    public static String totalAmount = null; // Chứa tổng tiền của bàn gần nhất

    public static OrdersEntity order = null; // Chứa thông tin hóa đơn
    public static TablesEntity table = null; // Chứa thông tin bàn 
    public static EmployeeEntity user = null; // chứa thông tin người dùng
    public static InvoicesEntity invoice = null; // Chứa thông tin hóa đơn
    public static List<OrderDetailsEntity> orderDetails = null; // Chứa thông tin các món ăn đã đặt

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
