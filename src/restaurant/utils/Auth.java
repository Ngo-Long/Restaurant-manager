package restaurant.utils;

import java.util.List;
import restaurant.entity.EmployeeEntity;
import restaurant.entity.InvoiceEntity;
import restaurant.entity.OrderDetailEntity;
import restaurant.entity.OrderEntity;
import restaurant.entity.DiningTableEntity;

public class Auth {

    /**
     * Đối tượng tĩnh
     */
    public static int orderCount = 0;// Chứa số đơn hàng của bàn gần nhất
    public static String totalAmount = null; // Chứa tổng tiền của bàn gần nhất

    public static OrderEntity order = null; // Chứa thông tin hóa đơn
    public static DiningTableEntity table = null; // Chứa thông tin bàn 
    public static EmployeeEntity user = null; // chứa thông tin người dùng
    public static InvoiceEntity invoice = null; // Chứa thông tin hóa đơn
    public static List<OrderDetailEntity> orderDetails = null; // Chứa thông tin các món ăn đã đặt

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
