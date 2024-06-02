package restaurant.staff;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.*;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import restaurant.dao.*;
import restaurant.entity.*;
import restaurant.frame.MainStaff;
import restaurant.utils.Auth;
import restaurant.utils.Dialog;
import restaurant.utils.Common;
import restaurant.utils.Ordered;
import static restaurant.utils.Common.addCommasToNumber;

public final class DiningTables extends javax.swing.JPanel {

    private MainStaff mainStaff;

    public DiningTables(MainStaff mainStaff) {
        this.mainStaff = mainStaff;
        initComponents();
        this.init();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBody = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        comboboxArea = new javax.swing.JComboBox<>();
        btnEmpty = new javax.swing.JButton();
        btnStatusServing = new javax.swing.JButton();
        btnBooked = new javax.swing.JButton();
        scrollPaneTableDining = new javax.swing.JScrollPane();
        panelDiningTableList = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        labelTenBan1 = new javax.swing.JLabel();
        comboboxTables = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableListOrderedDishes = new javax.swing.JTable();
        btnSwitchTables = new javax.swing.JButton();
        labelTableName = new javax.swing.JLabel();
        labelTenBan2 = new javax.swing.JLabel();
        btnAddOrder = new javax.swing.JButton();
        btnPay = new javax.swing.JButton();
        labelTotalAmount = new javax.swing.JLabel();
        btnSwitchTables1 = new javax.swing.JButton();
        labelTableId = new javax.swing.JLabel();

        panelBody.setToolTipText("");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(826, 592));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/filter1.png"))); // NOI18N

        comboboxArea.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        comboboxArea.setToolTipText("Ấn vô chọn khu vực");
        comboboxArea.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        comboboxArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboboxAreaActionPerformed(evt);
            }
        });

        btnEmpty.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnEmpty.setForeground(new java.awt.Color(51, 51, 51));
        btnEmpty.setText("Còn trống");
        btnEmpty.setBorder(null);
        btnEmpty.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEmpty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmptyActionPerformed(evt);
            }
        });

        btnStatusServing.setBackground(new java.awt.Color(255, 102, 102));
        btnStatusServing.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnStatusServing.setForeground(new java.awt.Color(51, 51, 51));
        btnStatusServing.setText("Đang phục vụ");
        btnStatusServing.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnStatusServing.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStatusServingActionPerformed(evt);
            }
        });

        btnBooked.setBackground(new java.awt.Color(255, 153, 51));
        btnBooked.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnBooked.setForeground(new java.awt.Color(51, 51, 51));
        btnBooked.setText("Đã đặt");
        btnBooked.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBooked.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBookedActionPerformed(evt);
            }
        });

        scrollPaneTableDining.setBorder(null);
        scrollPaneTableDining.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        panelDiningTableList.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panelDiningTableListLayout = new javax.swing.GroupLayout(panelDiningTableList);
        panelDiningTableList.setLayout(panelDiningTableListLayout);
        panelDiningTableListLayout.setHorizontalGroup(
            panelDiningTableListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 858, Short.MAX_VALUE)
        );
        panelDiningTableListLayout.setVerticalGroup(
            panelDiningTableListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 565, Short.MAX_VALUE)
        );

        scrollPaneTableDining.setViewportView(panelDiningTableList);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel5)
                .addGap(0, 0, 0)
                .addComponent(comboboxArea, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnEmpty, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnStatusServing, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBooked)
                .addGap(12, 12, 12))
            .addComponent(scrollPaneTableDining, javax.swing.GroupLayout.DEFAULT_SIZE, 826, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                        .addComponent(btnStatusServing, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnBooked, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEmpty, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(comboboxArea, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scrollPaneTableDining, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/cart-done.png"))); // NOI18N
        jLabel1.setText("Món đã gọi");

        labelTenBan1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelTenBan1.setText("Tên:");

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

        tableListOrderedDishes.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tableListOrderedDishes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Các món ăn đã gọi", "Đơn giá", "SL", "Tổng giá"
            }
        ));
        tableListOrderedDishes.setAlignmentX(2.0F);
        tableListOrderedDishes.setAlignmentY(2.0F);
        tableListOrderedDishes.setFillsViewportHeight(true);
        tableListOrderedDishes.setGridColor(new java.awt.Color(255, 255, 255));
        tableListOrderedDishes.setRowHeight(30);
        jScrollPane1.setViewportView(tableListOrderedDishes);
        if (tableListOrderedDishes.getColumnModel().getColumnCount() > 0) {
            tableListOrderedDishes.getColumnModel().getColumn(0).setPreferredWidth(190);
            tableListOrderedDishes.getColumnModel().getColumn(2).setPreferredWidth(22);
        }

        btnSwitchTables.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnSwitchTables.setText("Chuyển bàn");
        btnSwitchTables.setToolTipText("Chọn bàn cần chuyển trước ");
        btnSwitchTables.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSwitchTables.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSwitchTablesActionPerformed(evt);
            }
        });

        labelTableName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        labelTenBan2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelTenBan2.setText("Tổng cộng:");

        btnAddOrder.setBackground(new java.awt.Color(0, 153, 0));
        btnAddOrder.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
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
        btnPay.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnPay.setForeground(new java.awt.Color(255, 255, 255));
        btnPay.setText("THANH TOÁN (F4)");
        btnPay.setToolTipText("Ấn F4 để thanh toán");
        btnPay.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPayActionPerformed(evt);
            }
        });

        btnSwitchTables1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnSwitchTables1.setText("Chuyển bàn");
        btnSwitchTables1.setToolTipText("Chọn bàn cần chuyển trước ");
        btnSwitchTables1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSwitchTables1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSwitchTables1ActionPerformed(evt);
            }
        });

        labelTableId.setBackground(new java.awt.Color(255, 255, 255));
        labelTableId.setForeground(new java.awt.Color(255, 255, 255));
        labelTableId.setText("jLabel2");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btnAddOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPay, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addComponent(labelTenBan1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(labelTableName, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(12, 12, 12))
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addComponent(comboboxTables, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGap(18, 18, 18)))
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                    .addComponent(btnSwitchTables, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnSwitchTables1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addGap(1, 1, 1)
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(labelTableId)
                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                            .addComponent(labelTenBan2)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(labelTotalAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGap(0, 0, Short.MAX_VALUE))))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 12, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(labelTableId))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelTotalAmount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(labelTenBan1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(labelTableName, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                        .addComponent(labelTenBan2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboboxTables, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSwitchTables, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSwitchTables1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnPay, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17))
        );

        javax.swing.GroupLayout panelBodyLayout = new javax.swing.GroupLayout(panelBody);
        panelBody.setLayout(panelBodyLayout);
        panelBodyLayout.setHorizontalGroup(
            panelBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBodyLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );
        panelBodyLayout.setVerticalGroup(
            panelBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBodyLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(panelBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 606, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(10, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBody, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(panelBody, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void comboboxAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboboxAreaActionPerformed

    }//GEN-LAST:event_comboboxAreaActionPerformed

    private void btnEmptyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmptyActionPerformed
        updateStatus("Còn trống");
    }//GEN-LAST:event_btnEmptyActionPerformed

    private void btnStatusServingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStatusServingActionPerformed
        updateStatus("Đang phục vụ");
    }//GEN-LAST:event_btnStatusServingActionPerformed

    private void btnBookedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBookedActionPerformed
        updateStatus("Đã đặt");
    }//GEN-LAST:event_btnBookedActionPerformed

    private void comboboxTablesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboboxTablesActionPerformed

    }//GEN-LAST:event_comboboxTablesActionPerformed

    private void btnSwitchTablesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSwitchTablesActionPerformed
        switchTables();
    }//GEN-LAST:event_btnSwitchTablesActionPerformed


    private void btnAddOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddOrderActionPerformed
        // Add info dining table in auth
        Auth.table = dataTable;
        Auth.order = dataOrder;
        Auth.orderCount = orderCount;
        Auth.totalAmount = totalConvert;

        mainStaff.displayStaffPanels(new Products(mainStaff));
    }//GEN-LAST:event_btnAddOrderActionPerformed


    private void btnPayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPayActionPerformed
        // Add info dining table in auth
        Auth.table = dataTable;
        mainStaff.displayStaffPanels(new Invoices(mainStaff));
    }//GEN-LAST:event_btnPayActionPerformed

    private void btnSwitchTables1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSwitchTables1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSwitchTables1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddOrder;
    private javax.swing.JButton btnBooked;
    private javax.swing.JButton btnEmpty;
    private javax.swing.JButton btnPay;
    private javax.swing.JButton btnStatusServing;
    private javax.swing.JButton btnSwitchTables;
    private javax.swing.JButton btnSwitchTables1;
    private javax.swing.JComboBox<String> comboboxArea;
    private javax.swing.JComboBox<String> comboboxTables;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelTableId;
    private javax.swing.JLabel labelTableName;
    private javax.swing.JLabel labelTenBan1;
    private javax.swing.JLabel labelTenBan2;
    private javax.swing.JLabel labelTotalAmount;
    private javax.swing.JPanel panelBody;
    private javax.swing.JPanel panelDiningTableList;
    private javax.swing.JScrollPane scrollPaneTableDining;
    private javax.swing.JTable tableListOrderedDishes;
    // End of variables declaration//GEN-END:variables

    int orderCount;
    String totalConvert;
    String selectedArea = "Tầng 1";
    String searchName = "";
    JButton selectedTableButton;

    OrderEntity dataOrder;
    DiningTableEntity dataTable;
    List<DiningTableEntity> dataTables;
    List<OrderDetailEntity> dataOrderDetails;
    ExecutorService executorService = Executors.newFixedThreadPool(5);

    void init() {
        Common.customizeScrollBar(scrollPaneTableDining);
        Common.customizeTable(tableListOrderedDishes, new int[]{0});

        loadDiningTables(new DiningTableDAO().getAll());
        setupComboboxTables();
        handleClickComboboxArea();
        comboboxArea.setSelectedIndex(0);
    }

    void switchTables() {
        // Chose table
        String tableId = labelTableId.getText();
        if ("".equals(tableId)) {
            Dialog.warning(this, "Vui lòng chọn bàn!");
            return;
        }

        dataOrder = new OrdersDAO().getByTableId(tableId);
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
        if (new OrdersDAO().getByTableId(newTableId) != null) {
            Dialog.warning(this, "Bàn đang có khách dùng! \nVui lòng chọn bàn khác!");
            return;
        }

        if (!Dialog.confirm(this, "Xác nhận chuyển bàn!")) {
            return;
        }

        try {
            dataOrder.setTableId(newTableId); // setup
            new OrdersDAO().update(dataOrder); // update
            this.loadDiningTables(new DiningTableDAO().getAll()); // load
            Dialog.success(this, "Chuyển bàn thành công!");
        } catch (Exception e) {
            Dialog.error(this, "Chuyển bàn thất bại!");
        }

    }

    void loadDiningTables(List<DiningTableEntity> dataTables) {
        executorService.submit(() -> {
            SwingUtilities.invokeLater(() -> displayDiningTables(dataTables));
        });
    }

    void loadOrderDetails() {
        executorService.submit(() -> {
            dataTables = new DiningTableDAO().searchByAreaAndName(selectedArea, searchName);
            SwingUtilities.invokeLater(() -> displayOrderedByTable(labelTableId.getText()));
        });
    }

    void updateStatus(String status) {
        String tableId = labelTableId.getText();
        dataTable = new DiningTableDAO().getById(tableId);
        dataOrderDetails = new OrderDetailDAO().getByTableId(tableId);

        if (tableId.equals("")) {
            Dialog.warning(this, "Vui lòng chọn bàn muốn đổi trạng thái!");
            return;
        }

        if (!dataOrderDetails.isEmpty()) {
            Dialog.warning(this, "Bàn này đang có người ngồi!");
            return;
        }

        if (!Dialog.confirm(this, "Xác nhận đổi trạng thái thành \"" + status + "\"")) {
            return;
        }

        try {
            dataTable.setStatus(status);
            new DiningTableDAO().update(dataTable);
            displayDiningTables(new DiningTableDAO().getAll());
            Dialog.success(this, "Đổi trạng thái thành công!");
        } catch (Exception e) {
            Dialog.warning(this, "Đổi trạng thái thất bại!");
        }
    }

    // <--- Display and handle event table dining
    void displayDiningTables(List<DiningTableEntity> dataTables) {
        panelDiningTableList.removeAll(); // Reset 

        // Init GridBagLayout
        GridBagLayout gridBagLayout = new GridBagLayout();
        panelDiningTableList.setLayout(gridBagLayout);

        // Init gridbag 
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.insets = new Insets(2, 6, 2, 6);
        constraints.anchor = GridBagConstraints.NORTHWEST;

        int maxColumns = 5; // Số lượng cột tối đa trên mỗi hàng
        int columnCount = 0; // Biến đếm số lượng cột hiện tại

        // Iterate through the dining table list for the selected area
        for (DiningTableEntity dataItem : dataTables) {
            // Create and set colors based on status
            JButton tableButton = createTableButton(dataItem);

            // Check if the table has any ordered dishes
            String tableId = dataItem.getTableID();
            String tableStatus = dataItem.getStatus();
            dataOrderDetails = new OrderDetailDAO().getByTableId(tableId);

            // Set status
            if (!dataOrderDetails.isEmpty()) {
                setTableButtonColors(tableButton, "Đang phục vụ");
            } else {
                setTableButtonColors(tableButton, tableStatus);
            }

            // Đặt các ràng buộc cho thành phần
            constraints.gridwidth = 1;
            gridBagLayout.setConstraints(tableButton, constraints);
            if (++columnCount == maxColumns) {
                columnCount = 0;
                constraints.gridx = 0;
                constraints.gridy++;
            } else {
                constraints.gridx++;
            }

            panelDiningTableList.add(tableButton);
        }

        // Refresh the panel
        panelDiningTableList.revalidate();
        panelDiningTableList.repaint();
    }

    JButton createTableButton(DiningTableEntity diningTable) {
        // Create a button for a dining table with the icon
        java.net.URL imageURL = getClass().getResource("/icon/dining-room.png");
        ImageIcon icon = new ImageIcon(imageURL);
        JButton tableButton = new JButton(diningTable.getTableName(), icon);

        // Set the preferred size of the button based on the icon size
        tableButton.setPreferredSize(new Dimension(150, 150));
        tableButton.setHorizontalTextPosition(SwingConstants.CENTER);
        tableButton.setForeground(new Color(30, 30, 30));
        tableButton.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
        tableButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        tableButton.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255), 5, true));

        // Add ActionListener to Call a method to display detailed information
        tableButton.addActionListener((ActionEvent e) -> {
            // Display border bode when click
            if (selectedTableButton != null && selectedTableButton != tableButton) {
                Common.setTableButtonBorder(selectedTableButton, false);
            }
            Common.setTableButtonBorder(selectedTableButton = tableButton, true);

            // Reset default
            comboboxTables.setSelectedIndex(0);
            displayDetailTable(diningTable);
            loadOrderDetails();
        });

        return tableButton;
    }

    void setTableButtonColors(JButton tableButton, String status) {
        if (status == null || tableButton == null) {
            return;
        }

        switch (status) {
            case "Đã đặt" ->
                tableButton.setBackground(new Color(255, 153, 51)); // Màu nền FF9933
            case "Đang phục vụ" ->
                tableButton.setBackground(new Color(255, 102, 102)); // Màu nền FF6666
            case "Còn trống" ->
                tableButton.setBackground(new Color(255, 255, 255)); // Màu nền FFF
            default -> {
                return;
            }
        }
    }

    void displayDetailTable(DiningTableEntity diningTable) {
        labelTableId.setText(diningTable.getTableID());
        labelTableName.setText(diningTable.getTableName());

//        String surcharge = Common.addCommasToNumber(String.valueOf(diningTable.getSurcharge()));
//        textSurcharge.setText(surcharge);
//        textTableId.setText(diningTable.getTableID());
//        textName.setText(diningTable.getTableName());
//        textArea.setText(diningTable.getArea());
//        textNumberSeats.setText(String.valueOf(diningTable.getSeatingCapacity()));
//        textDesc.setText(diningTable.getDescription());
    }

    void displayOrderedByTable(String tableId) {
        // Reset table
        DefaultTableModel model = (DefaultTableModel) tableListOrderedDishes.getModel();
        model.setRowCount(0);

        // Get info detail order through dining table id
        OrderEntity ordered = new OrdersDAO().getByTableId(tableId);
        dataOrderDetails = new OrderDetailDAO().getByTableId(tableId);

        if (ordered == null || dataOrderDetails == null) {
            labelTotalAmount.setText("0₫ / 0 đơn");
            return;
        }

        // Display total - Tổng cộng: 100.000₫ / 1 đơn
        totalConvert = addCommasToNumber(String.valueOf(ordered.getTotal()));
        orderCount = new DiningTableDAO().getOrderCountByTableId(labelTableId.getText());
        labelTotalAmount.setText(totalConvert + "₫ / " + orderCount + " đơn");

        // Create a Map để lưu trữ số lượng và giá của mỗi món
        Map<String, Integer> productPriceMap = new HashMap<>();
        Map<String, Integer> productQuantityMap = new HashMap<>();

        // Init process ---> Add products into the table
        Ordered.processOrderedDetails(dataOrderDetails, productPriceMap, productQuantityMap);
        Ordered.addOrderedToTable(model, productPriceMap, productQuantityMap);
    }
    // end --->

    // <--- Handle event search and catogory
    void setupComboboxTables() {
        // Get all table list
        List<DiningTableEntity> dataAllTables = new DiningTableDAO().getAll();

        // Create a DefaultComboBoxModel 
        DefaultComboBoxModel<String> comboBoxModelArea = new DefaultComboBoxModel<>();
        DefaultComboBoxModel<String> comboBoxModelTables = new DefaultComboBoxModel<>();

        // Create a Set to store unique area names
        Set<String> areaSet = new HashSet<>();
        comboBoxModelTables.addElement("Chọn bàn");

        for (DiningTableEntity dataTable : dataAllTables) {
            // Add table name to the ComboBoxModel
            comboBoxModelTables.addElement(dataTable.getTableName());
            areaSet.add(dataTable.getArea()); // Collect unique area names
        }

        // Convert the Set to a sorted array
        areaSet.stream().sorted().forEach(comboBoxModelArea::addElement);

        // Set the ComboBoxModel to the comboBox
        comboboxArea.setModel(comboBoxModelArea);
        comboboxTables.setModel(comboBoxModelTables);
    }

    void handleClickComboboxArea() {
        comboboxArea.addActionListener((ActionEvent e) -> {
            // Get the selected area
            selectedArea = (String) comboboxArea.getSelectedItem();
            dataTables = new DiningTableDAO().searchByAreaAndName(selectedArea, "");
            this.loadDiningTables(dataTables); // load
        });

        comboboxArea.setSelectedIndex(0); // Reset default
    }
    // end --->   
}
