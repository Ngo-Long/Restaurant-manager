package restaurant.utils;

import java.awt.Font;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.util.function.Consumer;

import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.BorderFactory;

public class PopupMenu {

    /**
     * Sets up a popup menu for a JButton.
     *
     * @param button The JButton to attach the popup menu to.
     * @param menuList An array of strings representing menu item labels.
     * @param handlerMenuItem A consumer function to handle menu item selection.
     */
    public static void addDropdownMenu(JButton button, String[] menuList, Consumer<Integer> handlerMenuItem) {
        // Create popup menu
        JPopupMenu popupMenu = new JPopupMenu();

        // Create menu items
        for (int i = 0; i < menuList.length; i++) {
            final int index = i; // Make index final for lambda expression

            // Create menu item and set style
            JMenuItem menuItem = new JMenuItem(menuList[i]);
            setStyleMenuItem(menuItem);

            // Add ActionListener to handle menu item click
            menuItem.addActionListener((ActionEvent e) -> {
                handlerMenuItem.accept(index); // Call the callback function
            });

            // Add menu item to popup menu
            popupMenu.add(menuItem);
        }

        // Set preferred size
        popupMenu.setBackground(Color.WHITE);
        popupMenu.setPreferredSize(new Dimension(150, popupMenu.getPreferredSize().height));

        // Attach event when hover component
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                // Show location bottom left
                popupMenu.show(button, 4, button.getHeight());
            }
        });

        popupMenu.pack();
        popupMenu.revalidate();
        popupMenu.repaint();
    }

    /**
     * Sets the style (background, foreground, font, cursor, border) for a
     * JMenuItem.
     *
     * @param menuItem The JMenuItem to set the style for.
     */
    static void setStyleMenuItem(JMenuItem menuItem) {
        menuItem.setBackground(Color.WHITE);
        menuItem.setForeground(new Color(11, 11, 11));
        menuItem.setFont(new Font("Arial", Font.PLAIN, 14));
        menuItem.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        menuItem.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 80));
    }

}
