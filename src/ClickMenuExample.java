import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClickMenuExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Click Menu Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JButton button = new JButton("Click me");

        // Tạo JPopupMenu
        JPopupMenu popupMenu = new JPopupMenu();
        JMenuItem item1 = new JMenuItem("Option 1");
        JMenuItem item2 = new JMenuItem("Option 2");
        JMenuItem item3 = new JMenuItem("Option 3");

        // Thêm các mục vào JPopupMenu
        popupMenu.add(item1);
        popupMenu.add(item2);
        popupMenu.add(item3);

        // ActionListener để xử lý sự kiện click
        button.addActionListener(new ActionListener() {
            private boolean isPopupVisible = false;  // Trạng thái của popup menu

            @Override
            public void actionPerformed(ActionEvent e) {
                if (isPopupVisible) {
                    popupMenu.setVisible(false);  // Ẩn popup nếu đang hiển thị
                } else {
                    // Lấy kích thước của nút
                    Dimension buttonSize = button.getSize();
                    // Lấy kích thước của popup menu
                    Dimension popupSize = popupMenu.getPreferredSize();
                    // Hiển thị popup ngay phía dưới nút, canh top-right
                    int x = buttonSize.width - popupSize.width;
                    int y = buttonSize.height;
                    popupMenu.show(button, x, y);
                }
                isPopupVisible = !isPopupVisible;  // Đổi trạng thái của popup menu
            }
        });

        frame.setLayout(new FlowLayout());
        frame.add(button);
        frame.setVisible(true);
    }
}
