package restaurant.dialog;

import java.awt.Color;
import java.awt.Component;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTabbedPane;
import restaurant.dao.DiningTableDAO;
import restaurant.dao.OrderDAO;
import restaurant.entity.DiningTableEntity;
import restaurant.entity.OrderEntity;
import restaurant.main.OnSiteMode;
import restaurant.onsite.DiningTable;
import restaurant.table.TableCustom;
import restaurant.utils.Common;
import restaurant.utils.Dialog;

public class SplitMergeJDialog extends javax.swing.JDialog {

    OnSiteMode onSite = new OnSiteMode();

    public SplitMergeJDialog(java.awt.Frame parent, boolean modal, OnSiteMode onSite) {
        super(parent, modal);
        initComponents();
        this.init();
        this.onSite = onSite;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        labelTitle = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        cbOrderPairing = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableSplit = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        cbSplitOrder = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableMerge = new javax.swing.JTable();
        cbSplitTable = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Tách/ghép đơn");

        btnAdd.setBackground(new java.awt.Color(0, 153, 0));
        btnAdd.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/icon/check.png"))); // NOI18N
        btnAdd.setText("Thực hiện");
        btnAdd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnUpdate.setBackground(new java.awt.Color(102, 102, 102));
        btnUpdate.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnUpdate.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/icon/cancel.png"))); // NOI18N
        btnUpdate.setText("Bỏ qua");
        btnUpdate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        labelTitle.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        labelTitle.setForeground(new java.awt.Color(51, 51, 51));
        labelTitle.setText("Bàn 1 - Lầu 2");

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setFont(jTabbedPane1.getFont().deriveFont(jTabbedPane1.getFont().getSize()+4f));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel2.setText("Ghép đến");

        cbOrderPairing.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chọn bàn", "Bàn 1", "Bàn 2" }));

        tableSplit.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tableSplit.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã đơn", "Số lượng hàng", "Tổng tiền"
            }
        ));
        jScrollPane1.setViewportView(tableSplit);
        if (tableSplit.getColumnModel().getColumnCount() > 0) {
            tableSplit.getColumnModel().getColumn(0).setPreferredWidth(200);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbOrderPairing, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbOrderPairing, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab(" Ghép đơn", jPanel2);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel3.setText("Ghép đến");

        cbSplitOrder.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tạo đơn mới" }));

        tableMerge.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tableMerge.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên món", "Số lượng hàng", "Số lượng tách"
            }
        ));
        jScrollPane2.setViewportView(tableMerge);
        if (tableMerge.getColumnModel().getColumnCount() > 0) {
            tableMerge.getColumnModel().getColumn(0).setPreferredWidth(200);
        }

        cbSplitTable.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chọn bàn", "Bàn 1", "Bàn 2" }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbSplitOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cbSplitTable, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbSplitOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbSplitTable, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab(" Tách đơn", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAdd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnUpdate))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(labelTitle)
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(labelTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        dispose();
    }//GEN-LAST:event_btnUpdateActionPerformed

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SplitMergeJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            SplitMergeJDialog dialog = new SplitMergeJDialog(new javax.swing.JFrame(), true, new OnSiteMode());
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
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnUpdate;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbOrderPairing;
    private javax.swing.JComboBox<String> cbSplitOrder;
    private javax.swing.JComboBox<String> cbSplitTable;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel labelTitle;
    private javax.swing.JTable tableMerge;
    private javax.swing.JTable tableSplit;
    // End of variables declaration//GEN-END:variables

    DiningTableEntity dataTable;
    private JComboBox<String> cbMain;

    void init() {
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.WHITE);

        // Set table
        TableCustom.apply(jScrollPane1, TableCustom.TableType.MULTI_LINE);
        TableCustom.apply(jScrollPane2, TableCustom.TableType.MULTI_LINE);
        Common.customizeTable(tableSplit, new int[]{}, 25);
        Common.customizeTable(tableMerge, new int[]{}, 25);
        Common.setComboboxStyle(cbOrderPairing, cbSplitOrder, cbSplitTable);

        // Set combobox
        addDataToComboboxs();
    }

    void setInfoDialog(DiningTableEntity dataTable) {
        System.out.println(dataTable);
        if (dataTable == null) {
            return;
        }

        String tableID = dataTable.getTableID();
        String tableName = dataTable.getName();
        String tableLocation = dataTable.getLocation();

        OrderEntity order = new OrderDAO().getByTableID(tableID);
        String orderID = String.valueOf(order.getOrderId());
        labelTitle.setText(tableName + " - " + tableLocation);
    }

//    void switchTables() {
//        // Get orderd
//        dataOrder = new OrderDAO().getByTableID(labelTableId.getText());
//        if (dataOrder == null) {
//            Dialog.warning(this, "Không tìm thấy đơn đặt hàng!");
//            return;
//        }
//
//        // Chose table name in combobox
//        String newtableName = comboboxTables.getSelectedItem().toString();
//        if ("Chọn bàn".equals(newtableName)) {
//            Dialog.warning(this, "Vui lòng chọn bàn cần chuyển!");
//            return;
//        }
//
//        // Check to see if the dining table is in use
//        String newTableId = new DiningTableDAO().getIdByName(newtableName);
//        if (new OrderDAO().getByTableID(newTableId) != null) {
//            Dialog.warning(this, "Bàn đang có khách dùng! \nVui lòng chọn bàn khác!");
//            return;
//        }
//
//        if (!Dialog.confirm(this, "Xác nhận chuyển bàn!")) {
//            return;
//        }
//
//        try {
////            dataOrder.setTableId(newTableId); // setup
//            new OrderDAO().update(dataOrder); // update
//
//            // Upload
//            mainStaff.displayStaffPanels(new DiningTable(mainStaff));
//            dispose();
//        } catch (Exception e) {
//            Dialog.error(this, "Chuyển bàn thất bại!");
//        }
//
//    }
    void addDataToComboboxs() {
        // Get all table list
        List<DiningTableEntity> dataAllTables = new DiningTableDAO().getAll();

        // Create a DefaultComboBoxModel 
        DefaultComboBoxModel<String> comboBoxOrderTables = new DefaultComboBoxModel<>();
        DefaultComboBoxModel<String> comboBoxTables = new DefaultComboBoxModel<>();

        // Create a Set to store unique
        comboBoxOrderTables.addElement("Chọn bàn");
        comboBoxTables.addElement("Chọn bàn");

        // Add table name to the ComboBoxModel
        for (DiningTableEntity dataTable : dataAllTables) {
            // All table
            comboBoxTables.addElement(dataTable.getName());

            // If tables status on
            if (dataTable.getStatus().equals("Đang phục vụ")) {
                comboBoxOrderTables.addElement(dataTable.getName());
            }
        }

        // Set the ComboBoxModel to the comboBox
        cbOrderPairing.setModel(comboBoxOrderTables);
        cbSplitOrder.setModel(comboBoxOrderTables);
        cbSplitTable.setModel(comboBoxTables);
    }

}
