package restaurant.utils;

import restaurant.entity.EmployeeEntity;
import restaurant.entity.TablesEntity;

public class Auth {

    /**
     * Đối tượng này chứa thông tin người sử dụng sau khi đăng nhập
     */
    public static EmployeeEntity user = null;

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
    
    /**
     * Đối tượng này chứa thông tin bàn ăn được chọn gần nhất
     */
    public static TablesEntity table = null;
}
