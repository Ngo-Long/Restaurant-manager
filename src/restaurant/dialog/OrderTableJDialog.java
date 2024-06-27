package restaurant.dialog;

import java.util.Map;
import java.util.List;
import java.util.HashMap;

import java.awt.Color;
import java.text.SimpleDateFormat;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import restaurant.utils.Auth;
import restaurant.utils.Common;
import restaurant.utils.Dialog;
import restaurant.utils.Ordered;

import restaurant.main.MainStaff;
import restaurant.staff.Products;
import restaurant.staff.Invoices;
import restaurant.staff.DiningTable;
import restaurant.table.TableCustom;

import restaurant.dao.OrderDAO;
import restaurant.dao.DiningTableDAO;
import restaurant.dao.OrderDetailDAO;

import restaurant.entity.OrderEntity;
import restaurant.entity.DiningTableEntity;
import restaurant.entity.OrderDetailEntity;
import static restaurant.utils.Common.addCommasToNumber;

public final class OrderTableJDialog extends javax.swing.JDialog {

    MainStaff mainStaff = new MainStaff();

    public OrderTableJDialog(java.awt.Frame parent, boolean modal, MainStaff mainStaff) {
        super(parent, modal);
        initComponents();
        this.init();
        this.mainStaff = mainStaff;
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
        btnSwitchTables1 = new javax.swing.JButton();
        btnSwitchTables = new javax.swing.JButton();
        comboboxTables = new javax.swing.JComboBox<>();
        btnAddOrder = new javax.swing.JButton();
        btnPay = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableListOrderedDishes = new javax.swing.JTable();
        labelTableId = new javax.swing.JLabel();
        textNote = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        labelTotal = new javax.swing.JLabel();

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

        labelTenBan1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelTenBan1.setText("Tên:");

        labelTableName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        labelTenBan2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelTenBan2.setText("Giờ vào:");

        labelStartTime.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        btnSwitchTables1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnSwitchTables1.setText("Chuyển bàn");
        btnSwitchTables1.setToolTipText("Chọn bàn cần chuyển trước ");
        btnSwitchTables1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSwitchTables1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSwitchTables1ActionPerformed(evt);
            }
        });

        btnSwitchTables.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnSwitchTables.setText("Chuyển bàn");
        btnSwitchTables.setToolTipText("Chọn bàn cần chuyển trước ");
        btnSwitchTables.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSwitchTables.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSwitchTablesActionPerformed(evt);
            }
        });

        comboboxTables.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        comboboxTables.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bàn 1", "Bàn 2", "Bàn 3" }));
        comboboxTables.setToolTipText("Ấn vô chọn bàn");
        comboboxTables.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        comboboxTables.setName(""); // NOI18N
        comboboxTables.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboboxTablesActionPerformed(evt);
            }
        });

        btnAddOrder.setBackground(new java.awt.Color(0, 153, 0));
        btnAddOrder.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnAddOrder.setForeground(new java.awt.Color(255, 255, 255));
        btnAddOrder.setText("THÊM MÓN (F2)");
        btnAddOrder.setToolTipText("Ấn F2 để chọn món ăn");
        btnAddOrder.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAddOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddOrderActionPerformed(evt);
            }
        });

        btnPay.setBackground(new java.awt.Color(0, 0, 204));
        btnPay.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnPay.setForeground(new java.awt.Color(255, 255, 255));
        btnPay.setText("THANH TOÁN (F4)");
        btnPay.setToolTipText("Ấn F4 để thanh toán");
        btnPay.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPayActionPerformed(evt);
            }
        });

        tableListOrderedDishes.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        tableListOrderedDishes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Các món ăn", "Đơn giá", "SL", "Tổng giá"
            }
        ));
        tableListOrderedDishes.setAlignmentX(2.0F);
        tableListOrderedDishes.setAlignmentY(2.0F);
        tableListOrderedDishes.setFillsViewportHeight(true);
        tableListOrderedDishes.setGridColor(new java.awt.Color(255, 255, 255));
        tableListOrderedDishes.setRowHeight(35);
        jScrollPane3.setViewportView(tableListOrderedDishes);
        if (tableListOrderedDishes.getColumnModel().getColumnCount() > 0) {
            tableListOrderedDishes.getColumnModel().getColumn(0).setPreferredWidth(250);
            tableListOrderedDishes.getColumnModel().getColumn(1).setPreferredWidth(66);
            tableListOrderedDishes.getColumnModel().getColumn(2).setPreferredWidth(30);
            tableListOrderedDishes.getColumnModel().getColumn(3).setPreferredWidth(70);
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
                .addComponent(labelTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(labelTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnAddOrder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPay, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboboxTables, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labelTenBan1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelTableName, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labelTenBan2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(labelStartTime, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(labelTableId)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnSwitchTables, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnSwitchTables1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(textNote))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labelStartTime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelTenBan2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(labelTenBan1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(labelTableName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(labelTableId, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboboxTables, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSwitchTables, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSwitchTables1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(textNote, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPay, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSwitchTables1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSwitchTables1ActionPerformed

    }//GEN-LAST:event_btnSwitchTables1ActionPerformed

    private void btnSwitchTablesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSwitchTablesActionPerformed
        switchTables();
    }//GEN-LAST:event_btnSwitchTablesActionPerformed

    private void comboboxTablesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboboxTablesActionPerformed

    }//GEN-LAST:event_comboboxTablesActionPerformed


    private void btnAddOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddOrderActionPerformed
        // Set selected button product
        JButton[] buttons = mainStaff.getHeaderButtons();
        for (JButton button : buttons) {
            if (button.getText().equals("Món Ăn")) {
                mainStaff.setupHeaderButtons(button);
                break;
            }
        }

        // Set attach info other file
        Auth.table = dataTable;
        Auth.order = dataOrder;
        mainStaff.displayStaffPanels(new Products(mainStaff));
        dispose();
    }//GEN-LAST:event_btnAddOrderActionPerformed


    private void btnPayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPayActionPerformed
        // Set selected button product
        JButton[] buttons = mainStaff.getHeaderButtons();
        for (JButton button : buttons) {
            if (button.getText().equals("Thanh Toán")) {
                mainStaff.setupHeaderButtons(button);
                break;
            }
        }

        // Set attach info other file
        Auth.table = dataTable;
        mainStaff.displayStaffPanels(new Invoices(mainStaff));
        dispose();
    }//GEN-LAST:event_btnPayActionPerformed

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OrderTableJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            MainStaff mainStaff = new MainStaff();
            OrderTableJDialog dialog = new OrderTableJDialog(new javax.swing.JFrame(), true, mainStaff);
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
    private javax.swing.JButton btnSwitchTables;
    private javax.swing.JButton btnSwitchTables1;
    private javax.swing.JComboBox<String> comboboxTables;
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
    private javax.swing.JTable tableListOrderedDishes;
    private javax.swing.JTextField textNote;
    // End of variables declaration//GEN-END:variables

    OrderEntity dataOrder;
    DiningTableEntity dataTable;
    List<OrderDetailEntity> dataOrderDetails;

    void init() {
        // Set system
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(new Color(255, 255, 255));

        // Set table
        TableCustom.apply(jScrollPane3, TableCustom.TableType.MULTI_LINE);
        Common.customizeTable(tableListOrderedDishes, new int[]{0}, 30);

        // Set combobox
        setupComboboxTables();
    }

    void switchTables() {
        // Get orderd
        dataOrder = new OrderDAO().getByTableId(labelTableId.getText());
        if (dataOrder == null) {
            Dialog.warning(this, "Không tìm thấy đơn đặt hàng!");
            return;
        }

        // Chose table name in combobox
        String newtableName = comboboxTables.getSelectedItem().toString();
        if ("Chọn bàn".equals(newtableName)) {
            Dialog.warning(this, "Vui lòng chọn bàn cần chuyển!");
            return;
        }

        // Check to see if the dining table is in use
        String newTableId = new DiningTableDAO().getIdByName(newtableName);
        if (new OrderDAO().getByTableId(newTableId) != null) {
            Dialog.warning(this, "Bàn đang có khách dùng! \nVui lòng chọn bàn khác!");
            return;
        }

        if (!Dialog.confirm(this, "Xác nhận chuyển bàn!")) {
            return;
        }

        try {
//            dataOrder.setTableId(newTableId); // setup
            new OrderDAO().update(dataOrder); // update

            // Upload
            mainStaff.displayStaffPanels(new DiningTable(mainStaff));
            dispose();
        } catch (Exception e) {
            Dialog.error(this, "Chuyển bàn thất bại!");
        }

    }

    void setupComboboxTables() {
        // Get all table list
        List<DiningTableEntity> dataAllTables = new DiningTableDAO().getAll();

        // Create a DefaultComboBoxModel 
        DefaultComboBoxModel<String> comboBoxTables = new DefaultComboBoxModel<>();

        // Create a Set to store unique area names
        comboBoxTables.addElement("Chọn bàn");

        // Add table name to the ComboBoxModel
        for (DiningTableEntity dataTable : dataAllTables) {
            comboBoxTables.addElement(dataTable.getName());
        }

        // Set the ComboBoxModel to the comboBox
        comboboxTables.setModel(comboBoxTables);
    }

    public void displayTableInfo(DiningTableEntity diningTable) {
        dataTable = diningTable;
        labelTableId.setText(diningTable.getTableID());
        labelTableName.setText(diningTable.getName());
    }

    public void displayOrderedOfTable(String tableID) {
        // Reset table
        DefaultTableModel model = (DefaultTableModel) tableListOrderedDishes.getModel();
        model.setRowCount(0);

        try {
            // Get data order and order deatails
            dataOrder = new OrderDAO().getByTableId(tableID);
            dataOrderDetails = new OrderDetailDAO().getByOrderId(dataOrder.getOrderId());

            // Set title
            this.setTitle("Chi tiết Order [ " + dataOrder.getOrderId() + " ]");

            // Set start time
            String startTime = new SimpleDateFormat("HH:mm:ss").format(dataOrder.getCreatedDate());
            labelStartTime.setText(startTime);

            // Set total 
            String totalConvert = addCommasToNumber(String.valueOf(dataOrder.getTotal()));
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

}
