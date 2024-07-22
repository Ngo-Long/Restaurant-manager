package restaurant.utils;

import java.awt.Font;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Insets;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.GridBagConstraints;

import java.util.List;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.BorderFactory;

import restaurant.dao.ProductDAO;
import restaurant.entity.Product;
import javax.swing.table.DefaultTableModel;
import static restaurant.utils.XImage.getScaledImageIcon;
import static restaurant.utils.XTextField.addCommasToNumber;
import static restaurant.utils.XTextField.removeCommasFromNumber;

public class PanelProduct {

    /**
     * Displays a list of products in a specified panel.
     *
     * @param dataList List of Product objects to be displayed.
     * @param panelMain The main panel where products will be displayed.
     * @param tableOrder The table where ordered products are listed.
     * @param labelTotal The label showing the total price of the order.
     */
    public static void displayProductList(List<Product> dataList, JPanel panelMain,
            JTable tableOrder, JLabel labelTotal) {
        panelMain.removeAll(); // reset panel 
        panelMain.setLayout(new GridBagLayout()); // init GridBagLayout

        // Init gridbag 
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(0, 14, 20, 14);
        constraints.anchor = GridBagConstraints.NORTHWEST;
        constraints.gridx = 0;
        constraints.gridy = 0;

        int maxColumns = 7; // Số lượng cột tối đa trên mỗi hàng
        int columnCount = 0; // Biến đếm số lượng cột hiện tại

        // Iterate through the dining table list for the selected area
        for (Product dataItem : dataList) {
            // Create and set colors based on status
            JPanel productItem = createPanelProduct(dataItem, tableOrder, labelTotal);
            panelMain.add(productItem, constraints);

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
        panelMain.repaint();
        panelMain.revalidate();
    }

    /**
     * Creates a JPanel representing a single product.
     *
     * @param dataProduct The product data.
     * @param tableOrder The table where ordered products are listed.
     * @param labelTotal The label showing the total price of the order.
     * @return A JPanel displaying the product.
     */
    public static JPanel createPanelProduct(Product dataProduct, JTable tableOrder,
            JLabel labelTotal) {
        // Create a JLabel name
        JLabel textLabel = new JLabel(dataProduct.getProductName());
        textLabel.setForeground(new Color(30, 30, 30));
        textLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        textLabel.setFont(new Font(textLabel.getFont().getName(), Font.PLAIN, 14));

        // Create a JLabel price
        String price = String.valueOf(dataProduct.getPrice());
        String formattedPrice = addCommasToNumber(price);
        JLabel priceLabel = new JLabel(formattedPrice + "đ");

        // Set alignment, font, and color
        priceLabel.setForeground(new Color(255, 51, 51));
        priceLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        priceLabel.setFont(new Font(priceLabel.getFont().getName(), Font.BOLD, 16));

        // Create label top contains (scaledIcon) 
        ImageIcon scaledIcon = getScaledImageIcon(dataProduct.getImageURL(), 170, 200);
        JLabel labelTop = new JLabel(scaledIcon);

        // Create panel bottom contains (name, price, border, button)
        JPanel panelBottom = new JPanel();
        panelBottom.add(textLabel);
        panelBottom.add(Box.createVerticalStrut(8));
        panelBottom.add(priceLabel);
        panelBottom.setBackground(Color.WHITE);
        panelBottom.setLayout(new BoxLayout(panelBottom, BoxLayout.Y_AXIS));
        panelBottom.setBorder(BorderFactory.createEmptyBorder(6, 0, 6, 0));

        // Create a panel main 
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(Color.WHITE);
        mainPanel.setPreferredSize(new Dimension(146, 200));
        mainPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        mainPanel.setBorder(BorderFactory.createLineBorder(Color.lightGray));
        mainPanel.add(labelTop, BorderLayout.CENTER);
        mainPanel.add(panelBottom, BorderLayout.SOUTH);

        // Attach handle click 
        mainPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Add products to the table
                clickAddDataToTable(dataProduct, tableOrder);

                // Calculate and display total amount
                calculateTotalAmount(tableOrder, labelTotal);
            }
        });

        return mainPanel;
    }

    /**
     * Adds a product to the order table.
     *
     * @param dataProduct The product to be added.
     * @param tableOrder The table where ordered products are listed.
     */
    public static void clickAddDataToTable(Product dataProduct, JTable tableOrder) {
        if (dataProduct == null || tableOrder == null) {
            return;
        }

        // Get model
        DefaultTableModel modelOrder = (DefaultTableModel) tableOrder.getModel();

        String priceStr = String.valueOf(dataProduct.getPrice());
        String formattedPrice = addCommasToNumber(priceStr);

        // Check if the product already exists in the table
        boolean productExists = false;
        for (int i = 0; i < modelOrder.getRowCount(); i++) {
            if (modelOrder.getValueAt(i, 0).equals(dataProduct.getProductID())) {
                // Product exists, increase quantity by 3
                int quantity = (modelOrder.getValueAt(i, 3) instanceof String)
                        ? Integer.parseInt((String) modelOrder.getValueAt(i, 3))
                        : (Integer) modelOrder.getValueAt(i, 3);
                
                modelOrder.setValueAt(quantity + 1, i, 3);
                productExists = true;
                break;
            }
        }

        // If the product does not exist, add a new row
        if (!productExists) {
            modelOrder.addRow(new Object[]{
                dataProduct.getProductID(),
                "",
                dataProduct.getProductName(),
                1,
                formattedPrice
            });
        }
    }

    /**
     * Calculates and displays the total amount of the order.
     *
     * @param tableOrder The table where ordered products are listed.
     * @param labelTotal The label showing the total price of the order.
     */
    public static void calculateTotalAmount(JTable tableOrder, JLabel labelTotal) {
        long totalAmount = 0;
        DefaultTableModel model = (DefaultTableModel) tableOrder.getModel();

        for (int i = 0; i < model.getRowCount(); i++) {
            // Get price
            String id = model.getValueAt(i, 0).toString();
            Product product = new ProductDAO().getByID(id);
            long price = product.getPrice();

            // Get quantity
            String quantityStr = (String) model.getValueAt(i, 3).toString();
            int quantity = Integer.parseInt(removeCommasFromNumber(quantityStr));

            // Calculate subtotal for the row
            long subtotal = price * quantity;
            String convertSubtotal = addCommasToNumber(String.valueOf(subtotal));

            // Set value
            model.setValueAt(convertSubtotal, i, 4);

            // Accumulate subtotal to totalAmount
            totalAmount += subtotal;
        }

        // Format totalAmount to display
        String formattedTotal = addCommasToNumber(String.valueOf(totalAmount));
        labelTotal.setText(formattedTotal);
    }
}
