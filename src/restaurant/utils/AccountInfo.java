package restaurant.utils;

import restaurant.entity.AccountEntity;

public class AccountInfo {

    // Đối tượng này chứa thông tin người sử dụng sau khi đăng nhập
    public static AccountEntity account = null;

    // Xóa thông tin của người sử dụng khi có yêu cầu đăng xuất
    public static void clear() {
        AccountInfo.account = null;
    }

    // Kiểm tra xem đã đăng nhập hay chưa
    public static boolean isLogin() {
        return AccountInfo.account != null;
    }

    // Kiểm tra xem có phải là quản lý hay không
//    public static boolean isManager() {
//        // Kiểm tra chức vụ của nhân viên có phải là Quản Lý hay không
//        return AccountInfo.isLogin() && account.getChucVu().equals("Quản Lý");
//    }
}
