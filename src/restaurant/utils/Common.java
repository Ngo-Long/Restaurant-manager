package restaurant.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.Timer;
import javax.swing.plaf.basic.BasicScrollBarUI;

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

    public static void customizeScrollBar(JScrollPane scrollPane, Color trackColor) {
        scrollPane.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
            @Override
            protected void paintTrack(Graphics g, JComponent c, Rectangle trackBounds) {
                g.setColor(trackColor);
                g.fillRect(trackBounds.x, trackBounds.y, trackBounds.width, trackBounds.height);
            }

            @Override
            protected void paintThumb(Graphics g, JComponent c, Rectangle thumbBounds) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(Color.GRAY);
                g2.fillRoundRect(thumbBounds.x, thumbBounds.y, thumbBounds.width, thumbBounds.height, 10, 10);
                g2.dispose();
            }

            @Override
            protected JButton createDecreaseButton(int orientation) {
                return createZeroButton();
            }

            @Override
            protected JButton createIncreaseButton(int orientation) {
                return createZeroButton();
            }

            private JButton createZeroButton() {
                JButton button = new JButton();
                button.setPreferredSize(new Dimension(0, 0));
                button.setMinimumSize(new Dimension(0, 0));
                button.setMaximumSize(new Dimension(0, 0));
                return button;
            }
        });

        scrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(5, 0));
    }
}
