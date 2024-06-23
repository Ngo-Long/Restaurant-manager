package restaurant.dialog;

import java.util.List;
import java.awt.Color;
import java.text.SimpleDateFormat;
import javax.swing.SwingUtilities;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

import java.util.Set;
import java.util.Date;
import java.util.HashSet;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;

import restaurant.utils.Common;
import restaurant.utils.ColumnTable;
import restaurant.table.TableCustom;
import restaurant.dao.ProductDAO;
import restaurant.dao.DiningTableDAO;
import restaurant.dao.OrderDetailDAO;
import restaurant.entity.ProductEntity;
import restaurant.entity.DiningTableEntity;
import restaurant.entity.OrderDetailEntity;
import static restaurant.utils.Common.getRealText;

public final class HistoryProductsJDialog extends javax.swing.JDialog {

    public HistoryProductsJDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.init();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jComboBox1 = new javax.swing.JComboBox<>();
        textSearch = new javax.swing.JTextField();
        textStartDate = new com.toedter.calendar.JDateChooser();
        textEndDate = new com.toedter.calendar.JDateChooser();
        cbStatus = new javax.swing.JComboBox<>();
        btnSearch = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tableOrderDetail = new javax.swing.JTable();
        cbKitchen = new javax.swing.JComboBox<>();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jList1);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Lịch sử chế biến ");
        setBackground(new java.awt.Color(51, 102, 255));

        textSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textSearchActionPerformed(evt);
            }
        });

        textStartDate.setBackground(new java.awt.Color(255, 255, 255));
        textStartDate.setToolTipText("Ngày");
        textStartDate.setDateFormatString("dd/MM/yyyy");
        textStartDate.setFocusable(false);
        textStartDate.setFont(new java.awt.Font("Be Vietnam Pro", 0, 14)); // NOI18N

        textEndDate.setBackground(new java.awt.Color(255, 255, 255));
        textEndDate.setToolTipText("Ngày");
        textEndDate.setDateFormatString("dd/MM/yyyy");
        textEndDate.setFocusable(false);
        textEndDate.setFont(new java.awt.Font("Be Vietnam Pro", 0, 14)); // NOI18N

        cbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbStatus.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnSearch.setBackground(new java.awt.Color(255, 51, 51));
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

        btnReset.setBackground(new java.awt.Color(0, 153, 153));
        btnReset.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnReset.setForeground(new java.awt.Color(255, 255, 255));
        btnReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/refreshWhile.png"))); // NOI18N
        btnReset.setToolTipText("Reset trang (Ctrl + F5)");
        btnReset.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        tableOrderDetail.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        tableOrderDetail.setForeground(new java.awt.Color(51, 51, 51));
        tableOrderDetail.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã CT", "Tên món", "Số lượng", "Bàn ăn", "Thời gian", "Trạng thái", "Tác vụ"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tableOrderDetail.setAlignmentX(0.0F);
        tableOrderDetail.setAlignmentY(0.0F);
        tableOrderDetail.setFillsViewportHeight(true);
        tableOrderDetail.setGridColor(new java.awt.Color(255, 255, 255));
        tableOrderDetail.setRowHeight(50);
        jScrollPane4.setViewportView(tableOrderDetail);
        if (tableOrderDetail.getColumnModel().getColumnCount() > 0) {
            tableOrderDetail.getColumnModel().getColumn(0).setPreferredWidth(40);
            tableOrderDetail.getColumnModel().getColumn(1).setPreferredWidth(200);
            tableOrderDetail.getColumnModel().getColumn(2).setPreferredWidth(56);
            tableOrderDetail.getColumnModel().getColumn(4).setPreferredWidth(130);
        }

        cbKitchen.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbKitchen.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(textSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(textStartDate, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textEndDate, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbKitchen, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(textEndDate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(textSearch, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(textStartDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbKitchen, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cbStatus, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnReset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textSearchActionPerformed

    }//GEN-LAST:event_textSearchActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed

    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        dispose();
        new HistoryProductsJDialog(null, true).setVisible(true);
    }//GEN-LAST:event_btnResetActionPerformed

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HistoryProductsJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            HistoryProductsJDialog dialog = new HistoryProductsJDialog(new javax.swing.JFrame(), true);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });
            dialog.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSearch;
    private javax.swing.JComboBox<String> cbKitchen;
    private javax.swing.JComboBox<String> cbStatus;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tableOrderDetail;
    private com.toedter.calendar.JDateChooser textEndDate;
    private javax.swing.JTextField textSearch;
    private com.toedter.calendar.JDateChooser textStartDate;
    // End of variables declaration//GEN-END:variables

    final String PLACEHOLDER = "Tìm theo tên";
    List<OrderDetailEntity> dataOrderDetails;
    ScheduledFuture<?> scheduledFuture;
    ExecutorService executorService = Executors.newFixedThreadPool(3);
    ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);

    void init() {
        // Set system
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(new Color(255, 255, 255));

        // Set table
        TableCustom.apply(jScrollPane4, TableCustom.TableType.MULTI_LINE);
        Common.customizeTable(tableOrderDetail, new int[]{1}, 40);
        Common.addPlaceholder(textSearch, PLACEHOLDER);

        // Set today on JDateChooser
        textEndDate.setDate(new Date());
        textStartDate.setDate(new Date());

        // Set combobox
        setupComboboxTables();
        ColumnTable.setupDetailButtonColumn(tableOrderDetail, 6);

        // Load data
        loadDataByCriteria();
        btnSearch.addActionListener((java.awt.event.ActionEvent evt1) -> {
            loadDataByCriteria();
        });
    }

    void setupComboboxTables() {
        // Get all list
        List<OrderDetailEntity> dataDetails = new OrderDetailDAO().getAll();
        List<ProductEntity> dataProducts = new ProductDAO().getAll();

        // Create a modal 
        DefaultComboBoxModel<String> modalStatus = new DefaultComboBoxModel<>();
        modalStatus.addElement("--Trạng thái--");

        DefaultComboBoxModel<String> modalKitchen = new DefaultComboBoxModel<>();
        modalKitchen.addElement("--Khu chế biến--");

        // Set only status
        Set<String> setStatus = new HashSet<>();
        for (OrderDetailEntity dataItem : dataDetails) {
            if (!"Chưa xử lý".equals(dataItem.getProductStatus())) {
                setStatus.add(dataItem.getProductStatus());
            }
        }

        // Set only kitchen
        Set<String> setKitchen = new HashSet<>();
        for (ProductEntity dataItem : dataProducts) {
            String productID = dataItem.getProductID();
            ProductEntity product = new ProductDAO().getById(productID);

            setKitchen.add(product.getKitchenArea());
        }

        // Convert the Set to an array
        String[] statusList = setStatus.toArray(new String[0]);
        for (String statusItem : statusList) {
            modalStatus.addElement(statusItem);
        }

        String[] kitchenList = setKitchen.toArray(new String[0]);
        for (String kitchenItem : kitchenList) {
            modalKitchen.addElement(kitchenItem);
        }

        // Set to the comboBox
        cbStatus.setModel(modalStatus);
        cbKitchen.setModel(modalKitchen);
    }

    void loadDataByCriteria() {
        if (scheduledFuture != null && !scheduledFuture.isDone()) {
            scheduledFuture.cancel(false);
        }

        scheduledFuture = scheduledExecutorService.schedule(() -> {
            SwingUtilities.invokeLater(() -> {
                // Get search text
                String keyword = getRealText(textSearch, PLACEHOLDER).trim();

                // Get category
                String selectedStatus = (String) cbStatus.getSelectedItem();
                if (selectedStatus.equals("--Trạng thái--")) {
                    selectedStatus = "";
                }

                String selectedKitchen = (String) cbKitchen.getSelectedItem();
                if (selectedKitchen.equals("--Khu chế biến--")) {
                    selectedKitchen = "";
                }

                // Định dạng ngày tháng thành chuỗi "năm-tháng-ngày"
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                String startDate = dateFormat.format(textStartDate.getDate());
                String endDate = dateFormat.format(textEndDate.getDate());

                // Get data and display
                dataOrderDetails = new OrderDetailDAO().searchByCriteria(selectedStatus, selectedKitchen, keyword, startDate, endDate);
                this.fillTable(dataOrderDetails);
            });
        }, 200, TimeUnit.MILLISECONDS);
    }

    void fillTable(List<OrderDetailEntity> dataList) {
        System.out.println("Đang load dữ liệu lịch sử chế biến từ cơ sở dữ liệu...");

        // Display table
        DefaultTableModel model = (DefaultTableModel) tableOrderDetail.getModel();
        model.setRowCount(0);

        // Sắp xếp theo thời gian kết thúc từ gần nhất
        dataOrderDetails.sort(Comparator.comparing(OrderDetailEntity::getEndTime).reversed());

        // Load data into the table 
        for (OrderDetailEntity dataItem : dataList) {
            // Get info product
            ProductEntity productEntity = new ProductDAO().getById(dataItem.getProductID());
            String productName = productEntity.getProductName();
            String productDesc = dataItem.getProductDesc();
            productDesc = (productDesc == null || productDesc.isEmpty()) ? "" : " ( " + productDesc + " )";
            String productNameDesc = productName + productDesc;
            String productDateEnd = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(dataItem.getEndTime());

            // Get table by id table
            DiningTableEntity tableDining = new DiningTableDAO().getByOrderID(dataItem.getOrderID());

            model.addRow(new Object[]{
                dataItem.getOrderDetailID(),
                productNameDesc,
                dataItem.getProductQuantity(),
                tableDining.getName(),
                productDateEnd,
                dataItem.getProductStatus()
            });
        }

        // Reset table UI
        tableOrderDetail.repaint();
        tableOrderDetail.revalidate();
    }
}
