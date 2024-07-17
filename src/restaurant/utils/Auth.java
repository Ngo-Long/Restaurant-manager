package restaurant.utils;

import java.util.List;
import restaurant.entity.Order;
import restaurant.entity.Goods;
import restaurant.entity.Invoice;
import restaurant.entity.Product;
import restaurant.entity.Supplier;
import restaurant.entity.Employee;
import restaurant.entity.DiningTable;
import restaurant.entity.OrderDetail;

public class Auth {

    /**
     * Đối tượng tĩnh
     */
    public static Order order = null; // Chứa thông tin hóa đơn
    public static Goods goods = null; // Chứa thông tin hàng hóa
    public static Employee user = null; // chứa thông tin người dùng
    public static Product product = null; // Chứa thông tin sản phẩm
    public static Invoice invoice = null; // Chứa thông tin hóa đơn
    public static DiningTable table = null; // Chứa thông tin bàn 
    public static Supplier supplier = null; // Chứa thông tin nhà cung cấp
    public static List<OrderDetail> orderDetails = null; // Chứa thông tin các món ăn đã đặt

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
