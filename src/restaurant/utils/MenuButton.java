package restaurant.utils;

import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;

public class MenuButton extends JButton {

    private JPopupMenu popupMenu;

    public MenuButton(String text) {
        super(text);
        setPreferredSize(new Dimension(120, 40));

        // Thiết lập sự kiện khi hover vào JButton
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                // Hiển thị JPopupMenu khi hover vào JButton
                showPopupMenu(e.getX(), e.getY() + getHeight());
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // Ẩn JPopupMenu khi rời chuột ra khỏi JButton
                hidePopupMenu();
            }
        });
    }

    public  void showPopupMenu(int x, int y) {
        if (popupMenu == null) {
            popupMenu = new JPopupMenu();

            // Thêm các JMenuItem vào JPopupMenu
            JMenuItem item1 = new JMenuItem("Menu Item 1");
            JMenuItem item2 = new JMenuItem("Menu Item 2");
            JMenuItem item3 = new JMenuItem("Menu Item 3");

            popupMenu.add(item1);
            popupMenu.add(item2);
            popupMenu.add(item3);
        }

        popupMenu.show(this, x, y);
    }

    private void hidePopupMenu() {
        if (popupMenu != null) {
            popupMenu.setVisible(false);
        }
    }
}
