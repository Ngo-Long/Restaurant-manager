package restaurant.ui;

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
import restaurant.utils.Auth;
import restaurant.utils.Dialog;
import restaurant.utils.Common;
import restaurant.utils.Ordered;
import static restaurant.utils.Common.addCommasToNumber;

public class DiningTables extends javax.swing.JPanel {

    private Main mainInstance;

    public DiningTables(Main mainInstance) {
        this.mainInstance = mainInstance;
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
        tabbedPaneProducts = new javax.swing.JTabbedPane();
        jPanel9 = new javax.swing.JPanel();
        labelTableName = new javax.swing.JLabel();
        comboboxTables = new javax.swing.JComboBox<>();
        btnMergeTables = new javax.swing.JButton();
        btnSwitchTables = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableListOrderedDishes = new javax.swing.JTable();
        btnAddOrder = new javax.swing.JButton();
        btnPay = new javax.swing.JButton();
        labelTenBan1 = new javax.swing.JLabel();
        labelTenBan2 = new javax.swing.JLabel();
        labelTotalPrice = new javax.swing.JLabel();
        labelTotalAmount = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        textTableId = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        textName = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        textNumberSeats = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        textSurcharge = new javax.swing.JTextField();
        textDesc = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        textArea = new javax.swing.JTextField();

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
                .addComponent(scrollPaneTableDining, javax.swing.GroupLayout.DEFAULT_SIZE, 534, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        tabbedPaneProducts.setBackground(new java.awt.Color(255, 255, 255));
        tabbedPaneProducts.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tabbedPaneProducts.setFont(new java.awt.Font("Cascadia Code PL", 0, 14)); // NOI18N

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        labelTableName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelTableName.setText(" ");

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

        btnMergeTables.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnMergeTables.setText("Thêm / gộp bàn");
        btnMergeTables.setToolTipText("Chọn bàn cần gộp trước ");
        btnMergeTables.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMergeTables.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMergeTablesActionPerformed(evt);
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

        labelTenBan1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelTenBan1.setText("Tên:");

        labelTenBan2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelTenBan2.setText("Tổng cộng:");

        labelTotalPrice.setForeground(new java.awt.Color(255, 255, 255));

        labelTotalAmount.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(btnAddOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(labelTenBan1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelTableName, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(comboboxTables, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(labelTenBan2, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelTotalAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelTotalPrice))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(btnSwitchTables, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnMergeTables, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(12, 12, 12))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelTenBan1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelTableName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(labelTotalAmount, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelTotalPrice, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                            .addComponent(labelTenBan2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(12, 12, 12)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSwitchTables, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMergeTables, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboboxTables, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnPay, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34))
        );

        tabbedPaneProducts.addTab("Món đã gọi ", new javax.swing.ImageIcon(getClass().getResource("/icon/cart-done.png")), jPanel9); // NOI18N

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setForeground(new java.awt.Color(242, 242, 242));
        jPanel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Mã bàn:");

        textTableId.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textTableId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textTableIdActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Tên bàn:");

        textName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textNameActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Số chỗ ngồi:");

        textNumberSeats.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textNumberSeats.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textNumberSeatsActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setText("Phụ thu:");

        textSurcharge.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textSurcharge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textSurchargeActionPerformed(evt);
            }
        });

        textDesc.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textDesc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textDescActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel19.setText("Mô tả:");

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel20.setText("Khu vực:");

        btnAdd.setBackground(new java.awt.Color(0, 153, 0));
        btnAdd.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd.setText("THÊM");
        btnAdd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnDelete.setBackground(new java.awt.Color(255, 0, 0));
        btnDelete.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete.setText("XÓA");
        btnDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnUpdate.setBackground(new java.awt.Color(0, 0, 255));
        btnUpdate.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnUpdate.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdate.setText("SỬA");
        btnUpdate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        textArea.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textAreaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel9)
                            .addComponent(jLabel19)
                            .addComponent(jLabel20))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textName)
                            .addComponent(textSurcharge)
                            .addComponent(textDesc)
                            .addComponent(textTableId, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(textArea)
                            .addComponent(textNumberSeats)))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(textTableId, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(textName, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(textNumberSeats, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textSurcharge, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(textArea, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(textDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17))
        );

        tabbedPaneProducts.addTab("Cập nhật ", new javax.swing.ImageIcon(getClass().getResource("/icon/update.png")), jPanel10); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabbedPaneProducts)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabbedPaneProducts, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
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
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(12, Short.MAX_VALUE))
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

    private void btnMergeTablesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMergeTablesActionPerformed

    }//GEN-LAST:event_btnMergeTablesActionPerformed

    private void btnSwitchTablesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSwitchTablesActionPerformed
        switchTables();
    }//GEN-LAST:event_btnSwitchTablesActionPerformed


    private void btnAddOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddOrderActionPerformed
        // Add info dining table in auth
        Auth.table = getModel();
        Auth.order = dataOrder;
        Auth.orderCount = orderCount;
        Auth.totalAmount = totalConvert;

        mainInstance.displayPanels(new Products(mainInstance));
    }//GEN-LAST:event_btnAddOrderActionPerformed


    private void btnPayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPayActionPerformed
        // Add info dining table in auth
        TablesEntity model = getModel();
        Auth.table = model;

        mainInstance.displayPanels(new Invoices(mainInstance));
    }//GEN-LAST:event_btnPayActionPerformed

    private void textTableIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textTableIdActionPerformed

    }//GEN-LAST:event_textTableIdActionPerformed

    private void textNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textNameActionPerformed

    }//GEN-LAST:event_textNameActionPerformed

    private void textNumberSeatsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textNumberSeatsActionPerformed

    }//GEN-LAST:event_textNumberSeatsActionPerformed

    private void textSurchargeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textSurchargeActionPerformed

    }//GEN-LAST:event_textSurchargeActionPerformed

    private void textDescActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textDescActionPerformed

    }//GEN-LAST:event_textDescActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        insert();
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        delete();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        update();
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void textAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textAreaActionPerformed

    }//GEN-LAST:event_textAreaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnAddOrder;
    private javax.swing.JButton btnBooked;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEmpty;
    private javax.swing.JButton btnMergeTables;
    private javax.swing.JButton btnPay;
    private javax.swing.JButton btnStatusServing;
    private javax.swing.JButton btnSwitchTables;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> comboboxArea;
    private javax.swing.JComboBox<String> comboboxTables;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelTableName;
    private javax.swing.JLabel labelTenBan1;
    private javax.swing.JLabel labelTenBan2;
    private javax.swing.JLabel labelTotalAmount;
    private javax.swing.JLabel labelTotalPrice;
    private javax.swing.JPanel panelBody;
    private javax.swing.JPanel panelDiningTableList;
    private javax.swing.JScrollPane scrollPaneTableDining;
    private javax.swing.JTabbedPane tabbedPaneProducts;
    private javax.swing.JTable tableListOrderedDishes;
    private javax.swing.JTextField textArea;
    private javax.swing.JTextField textDesc;
    private javax.swing.JTextField textName;
    private javax.swing.JTextField textNumberSeats;
    private javax.swing.JTextField textSurcharge;
    private javax.swing.JTextField textTableId;
    // End of variables declaration//GEN-END:variables

    int orderCount;
    String totalConvert;
    String selectedArea = "Tầng 1";
    JButton selectedTableButton;
    OrdersEntity dataOrder;
    List<OrderDetailsEntity> dataOrderDetails;
    List<TablesEntity> dataTablesByArea;
    List<TablesEntity> dataDiningTables = new TablesDAO().getAll();
    ExecutorService executorService = Executors.newFixedThreadPool(5);

    void init() {
        Common.customizeScrollBar(scrollPaneTableDining);
        Common.customizeTable(tableListOrderedDishes, new int[]{0});

        loadTablesCombobox();
        loadDiningTables();
        hideSecondTab();

        setupComboboxTables(dataDiningTables);
        handleClickComboboxArea();
        comboboxArea.setSelectedIndex(0);
    }

    // <--- Common
    void hideSecondTab() {
        if (!Auth.isManager()) {
            tabbedPaneProducts.removeTabAt(1);
        }
    }

    void switchTables() {
        // Chose table
        String tableId = textTableId.getText();
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
        String newTableId = new TablesDAO().getIdByName(newtableName);
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
            loadDiningTables(); // load
            Dialog.success(this, "Chuyển bàn thành công!");
        } catch (Exception e) {
            Dialog.error(this, "Chuyển bàn thất bại!");
        }

    }
    // end --->

    // <--- Load async
    void loadDiningTables() {
        executorService.submit(() -> {
            dataTablesByArea = new TablesDAO().searchByArea(selectedArea);
            SwingUtilities.invokeLater(() -> displayDiningTables(dataTablesByArea));
        });
    }

    void loadOrderDetails() {
        executorService.submit(() -> {
            dataTablesByArea = new TablesDAO().searchByArea(selectedArea);
            SwingUtilities.invokeLater(() -> displayOrderedByTable(textTableId.getText()));
        });
    }

    void loadTablesCombobox() {
        executorService.submit(() -> {
            dataDiningTables = new TablesDAO().getAll();
            SwingUtilities.invokeLater(() -> setupComboboxTables(dataDiningTables));
        });
    }
    // end --->

    // <--- CRUD
    TablesEntity getModel() {
        String tableId = textTableId.getText();
        String name = textName.getText();
        String area = textArea.getText();
        String numberSeatsText = textNumberSeats.getText();
        String surchargeText = textSurcharge.getText();
        String status = "Còn trống";
        String desc = textDesc.getText();

        if (tableId.isEmpty() || name.isEmpty() || numberSeatsText.isEmpty() || surchargeText.isEmpty() || area.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn bàn", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }

        int numberSeats = Integer.parseInt(numberSeatsText);
        int surcharge = Integer.parseInt(Common.removeCommasFromNumber(surchargeText));

        if (numberSeats < 0 || surcharge < 0) {
            JOptionPane.showMessageDialog(null, "Số chỗ ngồi và Phụ thu phải là số không âm!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }

        TablesEntity model = new TablesEntity();
        model.setTableID(tableId);
        model.setTableName(name);
        model.setArea(area);
        model.setSeatingCapacity(numberSeats);
        model.setSurcharge(surcharge);
        model.setStatus(status);
        model.setDescription(desc);

        return model;
    }

    void insert() {
        TablesEntity model = getModel();

        // Kiểm tra xem mã ID có bị trùng không
        if (new TablesDAO().isIdDuplicated(model.getTableID())) {
            Dialog.alert(this, "Mã ID đã tồn tại. Vui lòng chọn mã ID khác!");
            return;
        }

        try {
            new TablesDAO().insert(model);
            Dialog.success(this, "Thêm mới thành công!");
            loadDiningTables();
            loadTablesCombobox();
        } catch (Exception e) {
            Dialog.alert(this, "Thêm mới thất bại!");
            e.printStackTrace();
        }
    }

    void update() {
        TablesEntity model = getModel();

        if (!new TablesDAO().isIdDuplicated(model.getTableID())) {
            Dialog.alert(this, "Mã ID đã chưa tồn tại. Vui lòng nhập lại mã ID!");
            return;
        }

        try {
            new TablesDAO().update(model);
            Dialog.alert(this, "Cập nhật thành công!");
            loadDiningTables();
            loadTablesCombobox();
        } catch (Exception e) {
            Dialog.alert(this, "Cập nhật thất bại!");
        }
    }

    void updateStatus(String status) {
        TablesEntity model = getModel();
        String tableId = textTableId.getText();
        dataOrderDetails = new OrderDetailsDAO().getByTableId(tableId);

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
            model.setStatus(status);
            new TablesDAO().update(model);
            displayDiningTables(new TablesDAO().getAll());
            Dialog.success(this, "Đổi trạng thái thành công!");
        } catch (Exception e) {
            Dialog.warning(this, "Đổi trạng thái thất bại!");
        }
    }

    void delete() {
        String id = textTableId.getText();
        if (!new TablesDAO().isIdDuplicated(id)) {
            Dialog.alert(this, "Mã ID đã chưa tồn tại. Vui lòng nhập lại mã ID!");
            return;
        }

        try {
            new TablesDAO().delete(id);
            Dialog.alert(this, "Xóa thành công!");
            loadDiningTables();
            loadTablesCombobox();
        } catch (Exception e) {
            Dialog.alert(this, "Xóa thất bại!");
        }
    }
    // end --->

    // <--- Display and handle event table dining
    void displayDiningTables(List<TablesEntity> dataTables) {
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
        for (TablesEntity dataItem : dataTables) {
            // Create and set colors based on status
            JButton tableButton = createTableButton(dataItem);

            // Check if the table has any ordered dishes
            String tableId = dataItem.getTableID();
            String tableStatus = dataItem.getStatus();
            dataOrderDetails = new OrderDetailsDAO().getByTableId(tableId);

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

    JButton createTableButton(TablesEntity diningTable) {
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

    void displayDetailTable(TablesEntity diningTable) {
        // Set detailed information in your text fields, combobox, etc.
        String surcharge = Common.addCommasToNumber(String.valueOf(diningTable.getSurcharge()));
        textSurcharge.setText(surcharge);
        textTableId.setText(diningTable.getTableID());
        textName.setText(diningTable.getTableName());
        labelTableName.setText(diningTable.getTableName());
        textArea.setText(diningTable.getArea());
        textNumberSeats.setText(String.valueOf(diningTable.getSeatingCapacity()));
        textDesc.setText(diningTable.getDescription());
    }

    void displayOrderedByTable(String tableId) {
        // Reset table
        DefaultTableModel model = (DefaultTableModel) tableListOrderedDishes.getModel();
        model.setRowCount(0);

        // Get info detail order through dining table id
        OrdersEntity ordered = new OrdersDAO().getByTableId(tableId);
        dataOrderDetails = new OrderDetailsDAO().getByTableId(tableId);

        if (ordered == null || dataOrderDetails == null) {
            labelTotalAmount.setText("0₫ / 0 đơn");
            return;
        }

        // Display total - Tổng cộng: 100.000₫ / 1 đơn
        totalConvert = addCommasToNumber(String.valueOf(ordered.getTotal()));
        orderCount = new TablesDAO().getOrderCountByTableId(textTableId.getText());
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
    void setupComboboxTables(List<TablesEntity> dataTables) {
        // Create a DefaultComboBoxModel 
        DefaultComboBoxModel<String> comboBoxModelArea = new DefaultComboBoxModel<>();
        DefaultComboBoxModel<String> comboBoxModelTables = new DefaultComboBoxModel<>();

        // Create a Set to store unique area names
        Set<String> areaSet = new HashSet<>();
        comboBoxModelTables.addElement("Chọn bàn");

        for (TablesEntity dataTable : dataTables) {
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
            selectedArea = (String) comboboxArea.getSelectedItem(); // Get the selected area
            loadDiningTables();
        });

        comboboxArea.setSelectedIndex(0); // Reset default
    }
    // end --->   

}
