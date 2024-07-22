package restaurant.utils;

import java.awt.Font;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;

import java.util.Set;
import java.util.List;
import java.util.HashSet;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import javax.swing.SwingConstants;

public class PanelMenu {

    public static JLabel selectedMenu;

    /**
     * Sets up the menu panel with values extracted from the provided data list.
     *
     * @param panelMenu The JPanel to add menu items to.
     * @param dataList The list of data items from which values are extracted.
     * @param propertyExtractor A function to extract values from data items.
     * @param actionLoadData A Consumer to handle actions when a menu item is
     * selected.
     * @param <T> The type of data items in the list.
     */
    public static <T> void loadDataPanelMenu(JPanel panelMenu, List<T> dataList,
            Function<T, String> propertyExtractor, Consumer<JLabel> actionLoadData) {
        // Create a set to store unique names
        Set<String> uniqueValues = new HashSet<>();
        for (T dataItem : dataList) {
            uniqueValues.add(propertyExtractor.apply(dataItem));
        }

        // Convert the set to a sorted list
        List<String> valueList = uniqueValues.stream().sorted().collect(Collectors.toList());

        // Create buttons for each and add them to panel
        for (String value : valueList) {
            // Create label category
            JLabel labelItem = createValueLabel(value, actionLoadData);

            // Automatically select the first item
            if (selectedMenu == null) {
                updateSelectedMenu(labelItem, () -> actionLoadData.accept(selectedMenu));
            }

            // Add item location to the panel
            panelMenu.add(labelItem);
        }

        // Set layout for panelButtons
        panelMenu.setLayout(new FlowLayout(FlowLayout.LEFT, 12, 12));
        panelMenu.revalidate();
        panelMenu.repaint();
    }

    /**
     * Creates a JLabel for displaying a values and handle click.
     *
     * @param value The category value to display.
     * @param actionLoadData handle actions when a menu item is selected.
     * @return A JLabel configured with the given category value.
     */
    public static JLabel createValueLabel(String value, Consumer<JLabel> actionLoadData) {
        if (value == null || value.equals("")) {
            return null;
        }

        JLabel labelItem = new JLabel(value);
        labelItem.setBackground(Color.LIGHT_GRAY);
        labelItem.setForeground(new Color(120, 120, 120));
        labelItem.setPreferredSize(new Dimension(140, 50));
        labelItem.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        labelItem.setVerticalAlignment(SwingConstants.CENTER);
        labelItem.setHorizontalAlignment(SwingConstants.CENTER);
        labelItem.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        labelItem.setBorder(BorderFactory.createLineBorder(new Color(150, 150, 150), 2, true));

        // Handle click location
        labelItem.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                updateSelectedMenu(labelItem, () -> actionLoadData.accept(selectedMenu));
            }
        });

        return labelItem;
    }

    /**
     * Updates the currently selected menu item and triggers the action for the
     * new selection.
     *
     * @param labelItem The JLabel to be marked as selected.
     * @param actionLoadData The action to perform when a new menu item is
     * selected.
     */
    public static void updateSelectedMenu(JLabel labelItem, Runnable actionLoadData) {
        // Return if the new label is already selected
        if (selectedMenu == labelItem) {
            return;
        }

        // Reset the appearance of the previously selected label
        if (selectedMenu != null) {
            selectedMenu.setForeground(new Color(120, 120, 120));
            selectedMenu.setBorder(BorderFactory.createLineBorder(new Color(150, 150, 150), 2, true));
        }

        // Update the appearance of the newly selected label
        labelItem.setForeground(new Color(255, 11, 11));
        labelItem.setBorder(BorderFactory.createLineBorder(new Color(255, 11, 11), 2, true));

        // Update the currently selected menu item
        selectedMenu = labelItem;
        actionLoadData.run();
    }
    // end --->
}
