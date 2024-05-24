package restaurant.utils;

import java.awt.Component;
import javax.swing.JOptionPane;

public class Dialog {

    // Hiển thị thông báo
    public static void alert(Component parent, String message) {
        JOptionPane.showMessageDialog(parent, message, "Hệ thống quản lý nhà hàng",
                JOptionPane.INFORMATION_MESSAGE);
    }

    // Hiển thị thông báo và yêu cầu xác nhận Yes/No
    public static boolean confirm(Component parent, String message) {
        int result = JOptionPane.showConfirmDialog(parent, message, "Cảnh báo",
                JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        return result == JOptionPane.YES_OPTION;
    }

    // Hiển thị thông báo yêu cầu nhập dữ liệu
    public static String prompt(Component parent, String message) {
        return JOptionPane.showInputDialog(parent, message, "Hệ thống quản lý nhà hàng", JOptionPane.INFORMATION_MESSAGE);
    }

    // Hiển thị cảnh báo
    public static void warning(Component parent, String message) {
        JOptionPane.showMessageDialog(parent, message, "Cảnh báo",
                JOptionPane.WARNING_MESSAGE);
    }

    // Hiển thị lỗi
    public static void error(Component parent, String message) {
        JOptionPane.showMessageDialog(parent, message, "Lỗi",
                JOptionPane.ERROR_MESSAGE);
    }

    // Hiển thị thông báo thành công
    public static void success(Component parent, String message) {
        JOptionPane.showMessageDialog(parent, message, "Thành công",
                JOptionPane.INFORMATION_MESSAGE);
    }

}
