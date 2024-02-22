package UI;

import javax.swing.ImageIcon;
import java.awt.Image;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class CommonUtils {

    private static Map<String, String> userInfo;

    private CommonUtils() {
    }

    public static Map<String, String> getUserInfo() {
        if (userInfo == null) {
            userInfo = new HashMap<>();
        }
        return userInfo;
    }

    public static void setUserInfo(Map<String, String> newUserInfo) {
        userInfo = newUserInfo;
    }

    public static void displayUserInfoBar(Map<String, String> userInfo, JLabel labelAccount, JLabel labelPosition) {
        if (userInfo != null && userInfo.containsKey("hoTen") && userInfo.containsKey("chucVu")) {
            String hoTen = userInfo.get("hoTen");
            String chucVu = userInfo.get("chucVu");

            labelAccount.setText("Tài khoản: " + hoTen);
            labelPosition.setText("Chức vụ: " + chucVu);
        }
    }

    public static void displayUserName(Map<String, String> userInfo, JLabel name) {
        if (userInfo != null && userInfo.containsKey("hoTen") && userInfo.containsKey("chucVu")) {
            String hoTen = userInfo.get("hoTen");
            name.setText(hoTen);
        }
    }

    public static void initClock(JLabel labelHouse) {
        Timer timer = new Timer(1000, e -> updateClock(labelHouse));
        timer.start();
    }

    private static void updateClock(JLabel labelHouse) {
        LocalTime currentTime = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String formattedTime = currentTime.format(formatter);

        labelHouse.setText(formattedTime);
    }

    public static void openFullScreenWindow(JFrame currentWindow, JFrame newWindow) {
        newWindow.setExtendedState(JFrame.MAXIMIZED_BOTH);
        newWindow.setVisible(true);
        currentWindow.dispose();
    }

    public static void setImage(String imagePath, JLabel labelLogo) {
        ImageIcon icon = new ImageIcon(imagePath);

        int width = labelLogo.getWidth();
        int height = labelLogo.getHeight();

        Image image = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);

        ImageIcon scaledIcon = new ImageIcon(image);

        labelLogo.setIcon(scaledIcon);
    }

    public static void openFullScreenWindow(JFrame window) {
        window.setExtendedState(JFrame.MAXIMIZED_BOTH);
        window.setVisible(true);
        window.dispose();
    }
}
