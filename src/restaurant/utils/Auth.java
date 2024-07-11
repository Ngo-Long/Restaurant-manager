package restaurant.utils;

import java.util.List;
import restaurant.entity.OrderEntity;
import restaurant.entity.GoodsEntity;
import restaurant.entity.InvoiceEntity;
import restaurant.entity.ProductEntity;
import restaurant.entity.SupplierEntity;
import restaurant.entity.EmployeeEntity;
import restaurant.entity.DiningTableEntity;
import restaurant.entity.OrderDetailEntity;

public class Auth {

    /**
     * Đối tượng tĩnh
     */
    public static OrderEntity order = null; // Chứa thông tin hóa đơn
    public static GoodsEntity goods = null; // Chứa thông tin hàng hóa
    public static EmployeeEntity user = null; // chứa thông tin người dùng
    public static ProductEntity product = null; // Chứa thông tin sản phẩm
    public static InvoiceEntity invoice = null; // Chứa thông tin hóa đơn
    public static DiningTableEntity table = null; // Chứa thông tin bàn 
    public static SupplierEntity supplier = null; // Chứa thông tin nhà cung cấp
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
