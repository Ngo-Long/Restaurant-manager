package restaurant.staff;

import java.util.Set;
import java.util.List;
import java.util.Vector;
import java.util.Objects;
import java.util.HashSet;

import java.awt.Font;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Insets;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.BorderFactory;
import javax.swing.border.MatteBorder;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import java.text.SimpleDateFormat;

import restaurant.dao.OrderDAO;
import restaurant.dao.InvoiceDAO;
import restaurant.dao.ProductDAO;
import restaurant.dao.OrderDetailDAO;

import restaurant.utils.Auth;
import restaurant.utils.Dialog;
import restaurant.utils.Common;
import restaurant.main.MainStaff;
import restaurant.dialog.DetailOrderJDialog;

import restaurant.entity.OrderEntity;
import restaurant.entity.ProductEntity;
import restaurant.entity.OrderDetailEntity;
import static restaurant.utils.Common.createButton;
import static restaurant.utils.Common.getScaledImageIcon;

public class Products extends javax.swing.JPanel {

    private MainStaff mainStaff;

    public Products(MainStaff mainStaff) {
        this.mainStaff = mainStaff;
        initComponents();
        this.init();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        tabbedPaneProduct = new javax.swing.JTabbedPane();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableOrder = new javax.swing.JTable();
        btnCancel = new javax.swing.JButton();
        btnNameDiningTable = new javax.swing.JButton();
        btnSubmit = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        CbCategoryProducts = new javax.swing.JComboBox<>();
        textSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        scrollPane = new javax.swing.JScrollPane();
        panelMainProducts = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        btnHistory = new javax.swing.JButton();
        btnSearch2 = new javax.swing.JButton();

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(420, 592));

        tabbedPaneProduct.setBackground(new java.awt.Color(255, 255, 255));
        tabbedPaneProduct.setFont(new java.awt.Font("Cascadia Code PL", 0, 14)); // NOI18N

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        tableOrder.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        tableOrder.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên món ăn             ", "Số lượng", "Cấp độ"
            }
        ));
        tableOrder.setAlignmentX(1.0F);
        tableOrder.setAlignmentY(1.0F);
        tableOrder.setFillsViewportHeight(true);
        tableOrder.setGridColor(new java.awt.Color(255, 255, 255));
        tableOrder.setRowHeight(35);
        jScrollPane1.setViewportView(tableOrder);
        if (tableOrder.getColumnModel().getColumnCount() > 0) {
            tableOrder.getColumnModel().getColumn(0).setPreferredWidth(150);
        }

        btnCancel.setBackground(new java.awt.Color(255, 0, 51));
        btnCancel.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        btnCancel.setForeground(new java.awt.Color(255, 255, 255));
        btnCancel.setText("HỦY");
        btnCancel.setToolTipText("Quay về bàn ăn");
        btnCancel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btnNameDiningTable.setFont(new java.awt.Font("Segoe UI Semibold", 0, 17)); // NOI18N
        btnNameDiningTable.setForeground(new java.awt.Color(30, 30, 30));
        btnNameDiningTable.setText("Chọn bàn (F1)");
        btnNameDiningTable.setToolTipText("Ấn F1 chuyển sang bàn ăn");
        btnNameDiningTable.setBorder(null);
        btnNameDiningTable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNameDiningTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNameDiningTableActionPerformed(evt);
            }
        });

        btnSubmit.setBackground(new java.awt.Color(0, 153, 0));
        btnSubmit.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        btnSubmit.setForeground(new java.awt.Color(255, 255, 255));
        btnSubmit.setText("XÁC NHẬN");
        btnSubmit.setToolTipText("Ấn xác nhận để chuyển tới bếp");
        btnSubmit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnNameDiningTable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(btnNameDiningTable, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        tabbedPaneProduct.addTab("Gọi món ", new javax.swing.ImageIcon(getClass().getResource("/icon/add-to-cart.png")), jPanel9); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabbedPaneProduct)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabbedPaneProduct, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 592, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        CbCategoryProducts.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        CbCategoryProducts.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả" }));
        CbCategoryProducts.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        textSearch.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textSearchActionPerformed(evt);
            }
        });

        btnSearch.setBackground(new java.awt.Color(255, 102, 102));
        btnSearch.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSearch.setForeground(new java.awt.Color(255, 255, 255));
        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/searchWhile.png"))); // NOI18N
        btnSearch.setToolTipText("Tìm kiếm");
        btnSearch.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        scrollPane.setBorder(null);

        panelMainProducts.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panelMainProductsLayout = new javax.swing.GroupLayout(panelMainProducts);
        panelMainProducts.setLayout(panelMainProductsLayout);
        panelMainProductsLayout.setHorizontalGroup(
            panelMainProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 853, Short.MAX_VALUE)
        );
        panelMainProductsLayout.setVerticalGroup(
            panelMainProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 554, Short.MAX_VALUE)
        );

        scrollPane.setViewportView(panelMainProducts);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/filter1.png"))); // NOI18N

        btnHistory.setBackground(new java.awt.Color(51, 204, 0));
        btnHistory.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnHistory.setForeground(new java.awt.Color(255, 255, 255));
        btnHistory.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/historyWhile.png"))); // NOI18N
        btnHistory.setToolTipText("Xem lịch sử gọi món");
        btnHistory.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnHistory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHistoryActionPerformed(evt);
            }
        });

        btnSearch2.setBackground(new java.awt.Color(0, 153, 153));
        btnSearch2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSearch2.setForeground(new java.awt.Color(255, 255, 255));
        btnSearch2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/refreshWhile.png"))); // NOI18N
        btnSearch2.setToolTipText("Reset trang (Ctrl + F5)");
        btnSearch2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSearch2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearch2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CbCategoryProducts, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(textSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSearch2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnHistory, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
            .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 826, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(CbCategoryProducts, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textSearch, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSearch, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSearch2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnHistory, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 538, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        cancel();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnNameDiningTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNameDiningTableActionPerformed
        mainStaff.displayStaffPanels(new OrderTables(mainStaff));
    }//GEN-LAST:event_btnNameDiningTableActionPerformed

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        submit();
    }//GEN-LAST:event_btnSubmitActionPerformed

    private void textSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textSearchActionPerformed
        displayProductsBySearchAndCategory();
    }//GEN-LAST:event_textSearchActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        displayProductsBySearchAndCategory();
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnHistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHistoryActionPerformed
        new DetailOrderJDialog(null, true).setVisible(true);
    }//GEN-LAST:event_btnHistoryActionPerformed

    private void btnSearch2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearch2ActionPerformed
//        openFullScreenWindow(new Products());
    }//GEN-LAST:event_btnSearch2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CbCategoryProducts;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnHistory;
    private javax.swing.JButton btnNameDiningTable;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnSearch2;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelMainProducts;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JTabbedPane tabbedPaneProduct;
    private javax.swing.JTable tableOrder;
    private javax.swing.JTextField textSearch;
    // End of variables declaration//GEN-END:variables

    String imagePath;
    String kitchenArea;
    String selectedCategory;
    List<ProductEntity> dataProductsByCategory;
    List<ProductEntity> dataProducts = new ProductDAO().getAll();

    void init() {
        Common.customizeScrollBar(scrollPane);
        Common.customizeTable(tableOrder, new int[]{0});
        Common.setupButtonColumn(tableOrder, 1);
        Common.setupComboBoxColumn(tableOrder, 2);

        // Get food list
        displayButtonTableName();
        displayProductList(dataProducts);
        setupComboboxCategoryProducts();
        handleClickComboboxCategoryProducts();
    }

    void displayButtonTableName() {
        String tableName = "";
        int orderCount = 0;
        String totalAmount = "";

        if (Auth.table != null) {
            tableName = Objects.toString(Auth.table.getName(), "");
            orderCount = Auth.orderCount;
            totalAmount = Auth.totalAmount;
        }

        // Đặt nội dung cho nút
        btnNameDiningTable.setText(tableName.equals("")
                ? "Chọn bàn (F1)"
                : tableName + " - Tổng: " + totalAmount + "₫ / " + orderCount + " đơn");
    }

    void cancel() {
        // Nếu bàn chưa chọn món thì rời đi luôn
        DefaultTableModel model = (DefaultTableModel) tableOrder.getModel();
        if (model.getRowCount() == 0) {
            mainStaff.displayStaffPanels(new OrderTables(mainStaff));
            return;
        }

        // Nếu bàn đã gọi món thì hỏi trước khi thoát
        Boolean result = Dialog.confirm(this, "Nếu thoát bạn sẽ mất các món ăn đã chọn?");
        if (result) {
            mainStaff.displayStaffPanels(new OrderTables(mainStaff));
        }
    }

    // <--- Display and handle events products
    void displayProductList(List<ProductEntity> dataList) {
        // Reset food list
        panelMainProducts.removeAll();
        panelMainProducts.setLayout(new GridBagLayout());

        // Init gridbag 
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 8, 16, 8);
        gbc.anchor = GridBagConstraints.NORTHWEST;

        int columnCount = 5;
        for (int i = 0; i < dataList.size(); i++) {
            // create panel product item
            ProductEntity dataItem = dataList.get(i);
            JPanel panelProduct = createPanelProduct(dataItem);

            // Tính toán vị trí dựa trên số cột
            gbc.gridx = i % columnCount;
            gbc.gridy = i / columnCount;

            panelMainProducts.add(panelProduct, gbc);
        }

        // Refresh the panel
        panelMainProducts.repaint();
        panelMainProducts.revalidate();
    }

    JPanel createPanelProduct(ProductEntity product) {
        // Create a image product
        String imageUrl = product.getImageURL();
        ImageIcon scaledIcon = getScaledImageIcon(imageUrl, 200, 200);

        // Create a JLabel name
        JLabel textLabel = new JLabel(product.getProductName());
        textLabel.setForeground(new Color(30, 30, 30));
        textLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        textLabel.setFont(new Font(textLabel.getFont().getName(), Font.BOLD, 14));

        // Create a JLabel price
        String formattedPrice = Common.addCommasToNumber(String.valueOf(product.getPrice()));
        JLabel priceLabel = new JLabel(formattedPrice + " VND");
        priceLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        priceLabel.setFont(new Font(priceLabel.getFont().getName(), Font.PLAIN, 14));

        // Create border in half
        MatteBorder topBorder = BorderFactory.createMatteBorder(1, 0, 0, 0, new Color(200, 200, 200));

        // Create label top contains (scaledIcon) 
        JLabel labelTop = new JLabel(scaledIcon);
        labelTop.setHorizontalAlignment(JLabel.CENTER);

        // Create button "Đặt món"
        JButton orderButton = createButton("Đặt món", new Color(51, 153, 255), new Dimension(120, 40));

        // Create panel bottom contains (name, price, border, button)
        JPanel panelBottom = new JPanel();
        panelBottom.add(textLabel);
        panelBottom.add(priceLabel);
        panelBottom.add(orderButton);
        panelBottom.setBackground(Color.WHITE);
        panelBottom.setLayout(new BoxLayout(panelBottom, BoxLayout.Y_AXIS));
        panelBottom.setBorder(BorderFactory.createEmptyBorder(2, 0, 0, 0));
        panelBottom.setBorder(BorderFactory.createCompoundBorder(topBorder, panelBottom.getBorder()));

        // Create a panel main 
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setPreferredSize(new Dimension(146, 200));
        mainPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        mainPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        mainPanel.add(labelTop, BorderLayout.CENTER);
        mainPanel.add(panelBottom, BorderLayout.SOUTH);

        // Attach handle click button order
        orderButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                handleClickButtonOrder(product);
            }
        });

        return mainPanel;
    }

    void handleClickButtonOrder(ProductEntity product) {
        if ("Chọn bàn (F1)".equals(btnNameDiningTable.getText())) {
            Dialog.warning(this, "Vui lòng chọn bàn ăn!");
            return;
        }

        // Get info
        String productName = product.getProductName();
        DefaultTableModel saveOrder = (DefaultTableModel) tableOrder.getModel();

        // Add new row into the table at the end
        Object[] rowData = {productName, 1};
        saveOrder.addRow(rowData);
    }

    // <--- Handle click button submit
    void submit() {
        if (tableOrder != null && tableOrder.getRowCount() == 0) {
            Dialog.warning(this, "Vui lòng chọn món ăn!");
            return;
        }

        // Get data from the table ordering more dishes
        DefaultTableModel model = (DefaultTableModel) tableOrder.getModel();
        Vector<Vector> data = model.getDataVector();

        // Get diningTableId in auth
        String diningTableId = Auth.table.getTableID();
        try {
            // Create an order if don't have one yet
            OrderEntity existingOrder = new OrderDAO().getPendingByTableId(diningTableId);
            if (existingOrder == null) {
                // Create new idcoice after create new order
                int invoiceId = new InvoiceDAO().insert();
                createNewOrder(invoiceId, diningTableId);
            }

            // Get newly created order information
            existingOrder = new OrderDAO().getPendingByTableId(diningTableId);
            addDishesToExistingOrder(existingOrder, data);

            // Open file table
            mainStaff.displayStaffPanels(new OrderTables(mainStaff));
        } catch (Exception e) {
            Dialog.error(this, "Đã xảy ra lỗi khi xử lý đơn hàng!");
            e.printStackTrace();
        }
    }

    private void createNewOrder(int invoiceId, String diningTableId) {
        try {
            // Create new order
            OrderEntity newOrder = new OrderEntity();
            newOrder.setInvoiceID(invoiceId);
            newOrder.setTableId(diningTableId);
            newOrder.setStatus("Đang đặt hàng");
            newOrder.setMethod("Tại nhà hàng");
            new OrderDAO().insert(newOrder);
        } catch (Exception e) {
            Dialog.alert(this, "Tạo đơn hàng thất bại!");
            e.printStackTrace();
        }
    }

    private void addDishesToExistingOrder(OrderEntity existingOrder, Vector<Vector> data) {
        try {
            // Get the current order detail list of an existing order
            List<OrderDetailEntity> currentDetails = new OrderDetailDAO().getByOrderId(existingOrder.getOrderId());

            // For each new list of dishes
            for (Vector<Object> row : data) {
                String dishName = row.get(0).toString();
                int dishQuantity = Integer.parseInt(row.get(1).toString());
                String dishDesc = row.get(2) != null ? row.get(2).toString() : "";
                String dishId = ProductDAO.getIdDishFromName(dishName);

                // Add new each dish on detail order
                for (int i = 1; i <= dishQuantity; i++) {
                    OrderDetailEntity newDetail = new OrderDetailEntity();
                    newDetail.setOrderID(existingOrder.getOrderId());
                    newDetail.setProductID(dishId);
                    newDetail.setProductQuantity(1);
                    newDetail.setProductDesc(dishDesc);
                    new OrderDetailDAO().insert(newDetail);
                }
            }

            Dialog.alert(this, "Thêm món ăn thành công!");
        } catch (Exception e) {
            Dialog.alert(this, "Thêm món ăn thất bại!");
            e.printStackTrace();
        }
    }
    // end --->

    // <--- Handle event search and catogory
    void setupComboboxCategoryProducts() {
        // Create a DefaultComboBoxModel 
        DefaultComboBoxModel<String> cbModelProducts = new DefaultComboBoxModel<>();
        cbModelProducts.addElement("Tất cả món");
        Set<String> categorySet = new HashSet<>();

        // Collect unique kitchen area
        for (ProductEntity dateItem : dataProducts) {
            categorySet.add(dateItem.getCategory());
        }

        // Convert the Set to an array
        String[] categoryList = categorySet.toArray(new String[categorySet.size()]);
        for (String categoryItem : categoryList) {
            cbModelProducts.addElement(categoryItem);
        }

        // Set the ComboBoxModel to the comboBox
        CbCategoryProducts.setModel(cbModelProducts);
    }

    void handleClickComboboxCategoryProducts() {
        // Attach event 
        CbCategoryProducts.addActionListener((ActionEvent e) -> {
            displayProductsBySearchAndCategory();
        });

        // Reset default
        CbCategoryProducts.setSelectedIndex(0);
    }

    void displayProductsBySearchAndCategory() {
        // Lấy danh mục đã chọn
        selectedCategory = (String) CbCategoryProducts.getSelectedItem();

        // Xử lý từ khóa tìm kiếm
        String keyword = textSearch.getText().trim().replaceAll("\\s+", "");

        // Nếu danh mục là "Tất cả món", đặt selectedCategory thành chuỗi rỗng
        if (selectedCategory.equals("Tất cả món")) {
            selectedCategory = "";
        }

        // Tìm kiếm sản phẩm theo từ khóa và danh mục
        dataProductsByCategory = new ProductDAO().searchByNameInCategory(keyword, selectedCategory);

        // Hiển thị danh sách sản phẩm
        displayProductList(dataProductsByCategory);
    }
    // end --->

}
