package restaurant.utils;

import java.awt.Font;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Insets;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.GridBagConstraints;

import java.util.Date;
import java.util.List;
import java.util.function.Consumer;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import javax.swing.SwingConstants;

import restaurant.dao.OrderDAO;
import restaurant.entity.Order;
import restaurant.entity.DiningTable;

public class PanelDiningTable {

    public static JPanel selectedTable;

    /**
     * Displays a list of dining tables in the given panel.
     *
     * @param panelMain The main panel to display dining tables.
     * @param dataList A list of dining table data.
     * @param actionShowDialog A consumer to handle the action of showing a
     * dialog with table order.
     */
    public static void displayDiningTables(JPanel panelMain, List<DiningTable> dataList,
            Consumer<DiningTable> actionShowDialog) {
        panelMain.removeAll(); // reset panel 
        panelMain.setLayout(new GridBagLayout()); // init GridBagLayout

        // Init gridbag constraints
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(8, 15, 24, 38);
        constraints.anchor = GridBagConstraints.NORTHWEST;
        constraints.gridx = 0;
        constraints.gridy = 0;

        int maxColumns = 6;  // Max columns per row
        int columnCount = 0; // Current column count

        // Iterate through the dining table list 
        for (DiningTable dataItem : dataList) {
            // Create and set colors based on status
            JPanel tablePanel = createTablePanel(dataItem, actionShowDialog);
            if (tablePanel == null) {
                return;
            }

            // panel main add tale
            panelMain.add(tablePanel, constraints);

            // Update column and row indices
            if (++columnCount == maxColumns) {
                columnCount = 0;
                constraints.gridx = 0;
                constraints.gridy++;
            } else {
                constraints.gridx++;
            }
        }

        // Add a spacer to push the components to the top-left corner
        constraints.gridx = columnCount;
        constraints.gridy++;
        constraints.weightx = 1;
        constraints.weighty = 1;
        constraints.gridwidth = GridBagConstraints.REMAINDER;
        panelMain.add(new JPanel(), constraints);

        // Refresh the panel
        panelMain.revalidate();
        panelMain.repaint();
    }

    // Creates a JPanel for a dining table
    public static JPanel createTablePanel(DiningTable dataTable,
            Consumer<DiningTable> actionShowDialog) {
        if (dataTable == null) {
            return new JPanel();
        }

        // Create a button for a dining table 
        JPanel tablePanel = new JPanel(new BorderLayout());
        tablePanel.setPreferredSize(new Dimension(160, 120));
        tablePanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        // Create and add table name label to the top panel
        JLabel nameLabel = new JLabel(dataTable.getName());
        nameLabel.setFont(new Font("Segoe UI", Font.BOLD, 15));
        nameLabel.setVerticalAlignment(SwingConstants.TOP);
        nameLabel.setHorizontalAlignment(SwingConstants.LEFT);
        nameLabel.setBorder(BorderFactory.createEmptyBorder(6, 6, 0, 0));

        // Create top panel with table name
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(nameLabel, BorderLayout.WEST);
        topPanel.setPreferredSize(new Dimension(160, 40));

        // check status table
        if (dataTable.getStatus().equals("Còn trống")) {
            // Add top panel only if bottomPanel is not added
            tablePanel.add(topPanel, BorderLayout.NORTH);
        } else {
            // Create bottom panel with time and money information
            JPanel bottomPanel = createBottomPanel(dataTable);

            // Add panels to the button
            tablePanel.add(topPanel, BorderLayout.NORTH);
            tablePanel.add(bottomPanel, BorderLayout.SOUTH);
        }

        // Set background for status table
        setColorStatusTable(tablePanel, topPanel, nameLabel, dataTable.getStatus());

        // Add ActionListener to Call a method to display detailed information
        tablePanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setColorsSelectedTable(tablePanel, topPanel, nameLabel);
                actionShowDialog.accept(dataTable);
            }
        });

        return tablePanel;
    }

    // Creates the bottom panel with time and money info
    public static JPanel createBottomPanel(DiningTable dataTable) {
        if (dataTable == null) {
            return new JPanel();
        }

        // get table id
        String tableID = dataTable.getTableID();

        // get data order
        Order dataOrder = new OrderDAO().getByTableID(tableID);
        if (dataOrder == null) {
            return new JPanel();
        }

        // get order date
        Date orderDate = dataOrder.getCreatedDate();
        String timeDifference = Common.calculateTimeDifference(orderDate);

        // get order total 
        long orderTotal = dataOrder.getTotal();
        String totalFormat = XTextField.addCommasToNumber(orderTotal);

        // setup bottom panel table
        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.setPreferredSize(new Dimension(0, 30));
        bottomPanel.setBorder(BorderFactory.createEmptyBorder());

        // get table status
        switch (dataTable.getStatus()) {
            case "Đã đặt":
                bottomPanel.setBackground(new Color(255, 153, 51));
                break;
            case "Đang phục vụ":
                bottomPanel.setBackground(new Color(255, 102, 102));
                break;
            default:
                bottomPanel.setBackground(Color.white);
                break;
        }

        // Create and add time label
        JLabel timeLabel = new JLabel(timeDifference);
        timeLabel.setForeground(Color.white);
        timeLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        timeLabel.setHorizontalAlignment(SwingConstants.LEFT);
        timeLabel.setBorder(BorderFactory.createEmptyBorder(2, 6, 0, 0));

        // Create and add money label
        JLabel moneyLabel = new JLabel(totalFormat);
        moneyLabel.setForeground(Color.white);
        moneyLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
        moneyLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        moneyLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 6));

        // Align labels to the left and right
        bottomPanel.add(timeLabel, BorderLayout.WEST);
        bottomPanel.add(moneyLabel, BorderLayout.EAST);

        return bottomPanel;
    }

    // Sets the color status of a table based on its status
    public static void setColorStatusTable(JPanel tablePanel, JPanel topPanel,
            JLabel nameLabel, String status) {
        if (tablePanel == null || status == null) {
            return;
        }

        Color bgColor;
        Color borderColor;
        Color nameColor = Color.WHITE;

        switch (status) {
            case "Đã đặt":
                bgColor = new Color(255, 153, 51);
                borderColor = bgColor;
                break;
            case "Đang phục vụ":
                bgColor = new Color(255, 102, 102);
                borderColor = bgColor;
                break;
            default:
                bgColor = Color.WHITE;
                borderColor = Color.GRAY;
                nameColor = new Color(30, 30, 30);
                break;
        }

        topPanel.setBackground(bgColor);
        tablePanel.setBackground(bgColor);
        tablePanel.setBorder(BorderFactory.createLineBorder(borderColor, 4, true));
        nameLabel.setForeground(nameColor);
    }

    // Sets the color for the selected table
    public static void setColorsSelectedTable(JPanel tablePanel, JPanel topPanel,
            JLabel nameLabel) {
        // Reset the previous selection
        if (selectedTable != null && selectedTable != tablePanel) {
            tablePanel.setBackground(Color.WHITE);
            topPanel.setBackground(Color.WHITE);
            nameLabel.setForeground(new Color(30, 30, 30));
        }

        tablePanel.setBackground(new Color(255, 102, 102));
        topPanel.setBackground(new Color(255, 102, 102));
        nameLabel.setForeground(Color.WHITE);
    }

}
