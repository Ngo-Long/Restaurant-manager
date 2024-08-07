package restaurant.dialog;

import java.util.Map;
import java.util.List;
import java.awt.Color;
import java.util.HashMap;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.awt.event.WindowAdapter;
import javax.swing.table.DefaultTableModel;

import restaurant.main.OnSiteMode;
import restaurant.onsite.ProductFrm;
import restaurant.onsite.InvoiceFrm;
import restaurant.table.TableCustom;

import restaurant.utils.Auth;
import restaurant.utils.Common;
import restaurant.utils.Dialog;
import restaurant.utils.Ordered;
import restaurant.utils.XComboBox;
import restaurant.utils.XTextField;
import restaurant.dao.OrderDAO;
import restaurant.dao.InvoiceDAO;
import restaurant.dao.OrderDetailDAO;
import restaurant.dao.DiningTableDAO;
import restaurant.entity.Order;
import restaurant.entity.Invoice;
import restaurant.entity.DiningTable;
import restaurant.entity.OrderDetail;

public final class TableOrderJDialog extends javax.swing.JDialog {

    OnSiteMode onSite = new OnSiteMode();

    public TableOrderJDialog(java.awt.Frame parent, boolean modal, OnSiteMode onSite) {
        super(parent, modal);
        initComponents();
        this.init();
        this.onSite = onSite;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jComboBox1 = new javax.swing.JComboBox<>();
        labelTenBan1 = new javax.swing.JLabel();
        labelTableName = new javax.swing.JLabel();
        labelTenBan2 = new javax.swing.JLabel();
        labelStartTime = new javax.swing.JLabel();
        btnSplitMerge = new javax.swing.JButton();
        btnAddOrder = new javax.swing.JButton();
        btnPay = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableOrderedDishes = new javax.swing.JTable();
        labelTableId = new javax.swing.JLabel();
        textNote = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        labelTotal = new javax.swing.JLabel();
        cbStatus = new javax.swing.JComboBox<>();

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
        setTitle("Đơn hàng ");
        setBackground(new java.awt.Color(51, 102, 255));
        setResizable(false);

        labelTenBan1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelTenBan1.setText("Tên:");

        labelTableName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        labelTenBan2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelTenBan2.setText("Giờ vào:");

        labelStartTime.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        btnSplitMerge.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnSplitMerge.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/icon/merge.png"))); // NOI18N
        btnSplitMerge.setText("Tách nghép");
        btnSplitMerge.setToolTipText("Chọn bàn cần chuyển trước ");
        btnSplitMerge.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnAddOrder.setBackground(new java.awt.Color(0, 153, 0));
        btnAddOrder.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnAddOrder.setForeground(new java.awt.Color(255, 255, 255));
        btnAddOrder.setText("THÊM MÓN (F2)");
        btnAddOrder.setToolTipText("Ấn F2 để chọn món ăn");
        btnAddOrder.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnPay.setBackground(new java.awt.Color(0, 0, 204));
        btnPay.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnPay.setForeground(new java.awt.Color(255, 255, 255));
        btnPay.setText("THANH TOÁN (F4)");
        btnPay.setToolTipText("Ấn F4 để thanh toán");
        btnPay.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        tableOrderedDishes.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        tableOrderedDishes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Các món ăn", "Đơn giá", "SL", "Tổng giá"
            }
        ));
        tableOrderedDishes.setAlignmentX(2.0F);
        tableOrderedDishes.setAlignmentY(2.0F);
        tableOrderedDishes.setFillsViewportHeight(true);
        tableOrderedDishes.setGridColor(new java.awt.Color(255, 255, 255));
        tableOrderedDishes.setRowHeight(35);
        jScrollPane3.setViewportView(tableOrderedDishes);
        if (tableOrderedDishes.getColumnModel().getColumnCount() > 0) {
            tableOrderedDishes.getColumnModel().getColumn(0).setPreferredWidth(200);
            tableOrderedDishes.getColumnModel().getColumn(1).setPreferredWidth(66);
            tableOrderedDishes.getColumnModel().getColumn(2).setPreferredWidth(28);
            tableOrderedDishes.getColumnModel().getColumn(3).setPreferredWidth(70);
        }

        labelTableId.setForeground(new java.awt.Color(243, 243, 243));
        labelTableId.setText("Mã bàn");

        textNote.setEditable(false);
        textNote.setBackground(new java.awt.Color(255, 255, 255));
        textNote.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        textNote.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED), "Ghi chú", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 0, 16))); // NOI18N
        textNote.setFocusable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Tổng cộng");

        labelTotal.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        labelTotal.setForeground(new java.awt.Color(255, 51, 51));
        labelTotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelTotal.setText("0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(labelTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        cbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Còn trống", "Đang phục vụ", "Đã đặt" }));
        cbStatus.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAddOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPay, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(textNote, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(labelTenBan1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(labelTableName, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(cbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(labelTenBan2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(labelStartTime, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(38, 38, 38)
                                    .addComponent(labelTableId, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(btnSplitMerge)))
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labelStartTime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelTenBan2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(labelTenBan1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(labelTableName, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(labelTableId, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSplitMerge, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                    .addComponent(cbStatus, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE))
                .addGap(12, 12, 12)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(textNote, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPay, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TableOrderJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            TableOrderJDialog dialog = new TableOrderJDialog(new javax.swing.JFrame(), true, new OnSiteMode());
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
    private javax.swing.JButton btnAddOrder;
    private javax.swing.JButton btnPay;
    private javax.swing.JButton btnSplitMerge;
    private javax.swing.JComboBox<String> cbStatus;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel labelStartTime;
    private javax.swing.JLabel labelTableId;
    private javax.swing.JLabel labelTableName;
    private javax.swing.JLabel labelTenBan1;
    private javax.swing.JLabel labelTenBan2;
    private javax.swing.JLabel labelTotal;
    private javax.swing.JTable tableOrderedDishes;
    private javax.swing.JTextField textNote;
    // End of variables declaration//GEN-END:variables

    Order dataOrder;
    DiningTable dataTable;

    void init() {
        // <--- Set common --->
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.WHITE);

        // set UI
        TableCustom.apply(jScrollPane3, TableCustom.TableType.MULTI_LINE);
        Common.customizeTable(tableOrderedDishes, new int[]{}, 30);
        XComboBox.setComboboxStyle(cbStatus);
        btnSplitMerge.setBackground(Color.WHITE);

        // <--- Setup main --->
        // Attach event when click combobox status
        cbStatus.addActionListener((ActionEvent e) -> {
            // get selected status
            String selectedStatus = (String) cbStatus.getSelectedItem();
            if (selectedStatus.equals(dataTable.getStatus())) {
                return;
            }

            // change status table
            updateStatusTable(selectedStatus);
        });

        // Attach event when click button split merge
        btnSplitMerge.addActionListener(e -> {
            handleClickBtnSplitMerge(btnSplitMerge, dataTable);
        });

        btnPay.addActionListener(e -> pay());
        btnAddOrder.addActionListener(e -> addOrder());
    }

    // <--- display info public 
    public void displayTableInfo(DiningTable dataTableOld) {
        if (dataTableOld == null) {
            return;
        }

        dataTable = dataTableOld;
        cbStatus.setSelectedItem(dataTable.getStatus());
        labelTableId.setText(dataTable.getTableID());
        labelTableName.setText(dataTable.getName());
    }

    public void displayOrderedOfTable(DiningTable dataTable) {
        if (dataTable == null) {
            Dialog.error(this, "Lỗi không hiển thị");
            return;
        }

        // Reset table
        DefaultTableModel model = (DefaultTableModel) tableOrderedDishes.getModel();
        model.setRowCount(0);

        try {
            // get table id
            String tableID = dataTable.getTableID();

            // Get data order and order deatails
            Order dataOrder = new OrderDAO().getByTableID(tableID);
            List<OrderDetail> dataOrderDetails
                    = new OrderDetailDAO().getByOrderID(dataOrder.getOrderId());

            // Set title
            this.setTitle("Chi tiết Order [ " + dataOrder.getOrderId() + " ]");

            // Set start time
            String startTime = new SimpleDateFormat("HH:mm:ss").format(dataOrder.getCreatedDate());
            labelStartTime.setText(startTime);

            // Set total 
            long total = dataOrder.getTotal();
            String totalConvert = XTextField.addCommasToNumber(String.valueOf(total));
            labelTotal.setText(totalConvert + "₫");

            // Set note
            textNote.setText(dataOrder.getNote());

            // Create a map to store the quantity and price of each item
            Map<String, Long> productPriceMap = new HashMap<>();
            Map<String, Integer> productQuantityMap = new HashMap<>();

            // Init process ---> Add products into the table
            Ordered.processOrderedDetails(dataOrderDetails, productPriceMap, productQuantityMap);
            Ordered.addOrderedToTable(model, productPriceMap, productQuantityMap);
        } catch (Exception e) {
            this.setTitle("Chi tiết Order [ Trống ]");
            labelStartTime.setText("Trống");
            System.out.println(e);
        }
    }
    // end --->

    void handleClickBtnSplitMerge(JButton tableBtn, DiningTable dataTable) {
        // Open dialog and Transmit data via file orderTableDialog
        SplitMergeJDialog dialog = new SplitMergeJDialog(null, true, onSite);
        dialog.setInfoDialog(dataTable);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);

        // Reload data when the dialog is closed
        dialog.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
//                loadDataByCriteria();
            }
        });
    }

    void updateStatusTable(String status) {
        String tableID = labelTableId.getText();
        if (tableID == null) {
            return;
        }

        if (status == null || status.equals("--Chọn bàn--")) {
            return;
        }

        if (!Dialog.confirm(this, "Xác nhận đổi trạng thái thành \"" + status + "\"")) {
            return;
        }

        try {
            DiningTable dataTable = new DiningTableDAO().getByID(tableID);
            dataTable.setStatus(status);
            new DiningTableDAO().update(dataTable);
            Dialog.success(this, "Đổi trạng thái thành công!");
            dispose();
        } catch (Exception e) {
            Dialog.warning(this, "Đổi trạng thái thất bại!");
        }
    }

    void pay() {
        // Set selected button product
        JButton[] buttons = onSite.getHeaderButtons();
        for (JButton button : buttons) {
            if (button.getText().equals("Thanh Toán")) {
                onSite.setupHeaderButtons(button);
                break;
            }
        }

        // Set attach info other file
        String tableID = dataTable.getTableID();
        Invoice dataInvoice = new InvoiceDAO().getByTableID(tableID);

        // Add add to auth
        Auth.table = dataTable;
        Auth.invoice = dataInvoice;

        // Display file invoice
        onSite.displayOnSitePanel(new InvoiceFrm(onSite));
        dispose();
    }

    void addOrder() {
        // Set selected button product
        JButton[] buttons = onSite.getHeaderButtons();
        for (JButton button : buttons) {
            if (button.getText().equals("Món Ăn")) {
                onSite.setupHeaderButtons(button);
                break;
            }
        }

        // Set attach info other file
        Auth.table = dataTable;
        Auth.order = dataOrder;
        onSite.displayOnSitePanel(new ProductFrm(onSite));
        dispose();
    }

}
