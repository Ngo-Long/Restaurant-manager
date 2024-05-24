package restaurant.ui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.*;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import restaurant.dao.*;
import restaurant.entity.*;
import restaurant.utils.Auth;
import restaurant.utils.Dialog;
import restaurant.utils.Common;
import static restaurant.utils.Common.addCommasToNumber;

public class DiningTables extends javax.swing.JFrame {

    public DiningTables() {
        initComponents();
        this.init();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        labelHouse = new javax.swing.JLabel();
        labelAccount = new javax.swing.JLabel();
        labelLogo = new javax.swing.JLabel();
        panelBody = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        comboboxArea = new javax.swing.JComboBox<>();
        jButton18 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        scrollPaneTableDining = new javax.swing.JScrollPane();
        panelDiningTableList = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        tabbedPaneProducts = new javax.swing.JTabbedPane();
        jPanel9 = new javax.swing.JPanel();
        labelNameDiningTable = new javax.swing.JLabel();
        comboboxTables = new javax.swing.JComboBox<>();
        btnMergeTables = new javax.swing.JButton();
        btnSwitchTables = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableListOrderedDishes = new javax.swing.JTable();
        btnAddOrder = new javax.swing.JButton();
        btnPay2 = new javax.swing.JButton();
        labelTenBan1 = new javax.swing.JLabel();
        labelTenBan2 = new javax.swing.JLabel();
        labelTotalPrice = new javax.swing.JLabel();
        labelTotalAmount = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        textDiningTableId = new javax.swing.JTextField();
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
        menuBar = new javax.swing.JMenuBar();
        menuSysten = new javax.swing.JMenu();
        menuItemSystem = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        menuLogout = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        menuEnd = new javax.swing.JMenuItem();
        menuItemManager = new javax.swing.JMenu();
        menuTables = new javax.swing.JMenuItem();
        menuDishes = new javax.swing.JMenuItem();
        menuChicken = new javax.swing.JMenuItem();
        menuPay = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        menuEmployeeList = new javax.swing.JMenuItem();
        menuStatistical = new javax.swing.JMenu();
        menuIngridiants = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        menuEmployees = new javax.swing.JMenuItem();
        jSeparator8 = new javax.swing.JPopupMenu.Separator();
        menuClients = new javax.swing.JMenuItem();
        jSeparator9 = new javax.swing.JPopupMenu.Separator();
        menuRevenue = new javax.swing.JMenuItem();
        menuItemHelp = new javax.swing.JMenu();
        mniHuongDan = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        mniGioiThieu = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản lí nhân viên");

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 1, 1, new java.awt.Color(204, 204, 204)));

        jButton3.setBackground(new java.awt.Color(238, 238, 238));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/bell.png"))); // NOI18N
        jButton3.setBorder(null);

        labelHouse.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        labelHouse.setText("00:00:00");

        labelAccount.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        labelAccount.setText("TÀI KHOẢN: NGÔ KIM LONG");

        labelLogo.setFont(new java.awt.Font("Segoe Print", 1, 26)); // NOI18N
        labelLogo.setForeground(new java.awt.Color(255, 153, 153));
        labelLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelLogo.setText("HOT NOODLE");
        labelLogo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelLogo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(labelLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelHouse)
                .addGap(18, 18, 18)
                .addComponent(labelAccount)
                .addGap(18, 18, 18)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(labelLogo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
            .addComponent(labelAccount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(labelHouse, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

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

        jButton18.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton18.setForeground(new java.awt.Color(51, 51, 51));
        jButton18.setText("Còn trống");
        jButton18.setBorder(null);

        jButton19.setBackground(new java.awt.Color(255, 102, 102));
        jButton19.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton19.setForeground(new java.awt.Color(51, 51, 51));
        jButton19.setText("Đang phục vụ");

        jButton17.setBackground(new java.awt.Color(255, 153, 51));
        jButton17.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton17.setForeground(new java.awt.Color(51, 51, 51));
        jButton17.setText("Đã đặt");

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
                .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton19, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton17)
                .addGap(12, 12, 12))
            .addComponent(scrollPaneTableDining, javax.swing.GroupLayout.DEFAULT_SIZE, 864, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                        .addComponent(jButton19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        labelNameDiningTable.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        labelNameDiningTable.setText(" ");

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
                "Các món ăn đã gọi", "Đơn giá", "Tổng giá"
            }
        ));
        tableListOrderedDishes.setAlignmentX(2.0F);
        tableListOrderedDishes.setAlignmentY(2.0F);
        tableListOrderedDishes.setFillsViewportHeight(true);
        tableListOrderedDishes.setGridColor(new java.awt.Color(255, 255, 255));
        tableListOrderedDishes.setRowHeight(30);
        jScrollPane1.setViewportView(tableListOrderedDishes);
        if (tableListOrderedDishes.getColumnModel().getColumnCount() > 0) {
            tableListOrderedDishes.getColumnModel().getColumn(0).setPreferredWidth(140);
            tableListOrderedDishes.getColumnModel().getColumn(1).setResizable(false);
            tableListOrderedDishes.getColumnModel().getColumn(2).setResizable(false);
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

        btnPay2.setBackground(new java.awt.Color(0, 0, 204));
        btnPay2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnPay2.setForeground(new java.awt.Color(255, 255, 255));
        btnPay2.setText("THANH TOÁN (F4)");
        btnPay2.setToolTipText("Ấn F4 để thanh toán");
        btnPay2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPay2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPay2ActionPerformed(evt);
            }
        });

        labelTenBan1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        labelTenBan1.setText("Tên:");

        labelTenBan2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        labelTenBan2.setText("Tổng cộng:");

        labelTotalPrice.setForeground(new java.awt.Color(255, 255, 255));

        labelTotalAmount.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

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
                        .addComponent(btnPay2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(labelTenBan1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelNameDiningTable, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(comboboxTables, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(btnSwitchTables)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnMergeTables, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(labelTenBan2, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelTotalAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelTotalPrice)))
                .addGap(12, 12, 12))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelTenBan1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelNameDiningTable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(labelTotalAmount, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelTotalPrice, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                            .addComponent(labelTenBan2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(12, 12, 12)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSwitchTables, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMergeTables, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboboxTables, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnPay2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34))
        );

        comboboxTables.getAccessibleContext().setAccessibleName("");

        tabbedPaneProducts.addTab("Món đã gọi ", new javax.swing.ImageIcon(getClass().getResource("/icon/cart-done.png")), jPanel9); // NOI18N

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setForeground(new java.awt.Color(242, 242, 242));
        jPanel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Mã bàn:");

        textDiningTableId.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textDiningTableId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textDiningTableIdActionPerformed(evt);
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
                            .addComponent(textDiningTableId, javax.swing.GroupLayout.Alignment.TRAILING)
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
                    .addComponent(textDiningTableId, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
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

        menuSysten.setText("Hệ thống");

        menuItemSystem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Refresh.png"))); // NOI18N
        menuItemSystem.setText("Đổi mật khẩu");
        menuItemSystem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemSystemActionPerformed(evt);
            }
        });
        menuSysten.add(menuItemSystem);
        menuSysten.add(jSeparator2);

        menuLogout.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        menuLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Log out.png"))); // NOI18N
        menuLogout.setText("Đăng xuất");
        menuLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuLogoutActionPerformed(evt);
            }
        });
        menuSysten.add(menuLogout);
        menuSysten.add(jSeparator1);

        menuEnd.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        menuEnd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Stop.png"))); // NOI18N
        menuEnd.setText("Kết thúc");
        menuEnd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuEndActionPerformed(evt);
            }
        });
        menuSysten.add(menuEnd);

        menuBar.add(menuSysten);

        menuItemManager.setText("Quản lý");

        menuTables.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        menuTables.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Discussion.png"))); // NOI18N
        menuTables.setText("Bàn ăn");
        menuTables.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuTablesActionPerformed(evt);
            }
        });
        menuItemManager.add(menuTables);

        menuDishes.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, 0));
        menuDishes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Add to basket.png"))); // NOI18N
        menuDishes.setText("Món ăn");
        menuDishes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuDishesActionPerformed(evt);
            }
        });
        menuItemManager.add(menuDishes);

        menuChicken.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F3, 0));
        menuChicken.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/chef.png"))); // NOI18N
        menuChicken.setText("Nhà bếp");
        menuChicken.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuChickenActionPerformed(evt);
            }
        });
        menuItemManager.add(menuChicken);

        menuPay.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, 0));
        menuPay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/card.png"))); // NOI18N
        menuPay.setText("Thanh toán");
        menuPay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuPayActionPerformed(evt);
            }
        });
        menuItemManager.add(menuPay);
        menuItemManager.add(jSeparator4);

        menuEmployeeList.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, 0));
        menuEmployeeList.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Clien list.png"))); // NOI18N
        menuEmployeeList.setText("Nhân viên");
        menuEmployeeList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuEmployeeListActionPerformed(evt);
            }
        });
        menuItemManager.add(menuEmployeeList);

        menuBar.add(menuItemManager);

        menuStatistical.setText("Thống kê");

        menuIngridiants.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, java.awt.event.InputEvent.SHIFT_DOWN_MASK));
        menuIngridiants.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Dollar.png"))); // NOI18N
        menuIngridiants.setText("Xem doanh thu cuối ngày");
        menuIngridiants.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuIngridiantsActionPerformed(evt);
            }
        });
        menuStatistical.add(menuIngridiants);
        menuStatistical.add(jSeparator3);

        menuEmployees.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, java.awt.event.InputEvent.SHIFT_DOWN_MASK));
        menuEmployees.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Label.png"))); // NOI18N
        menuEmployees.setText("Xem nguyên liệu cuối ngày");
        menuEmployees.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuEmployeesActionPerformed(evt);
            }
        });
        menuStatistical.add(menuEmployees);
        menuStatistical.add(jSeparator8);

        menuClients.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F3, java.awt.event.InputEvent.SHIFT_DOWN_MASK));
        menuClients.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Users.png"))); // NOI18N
        menuClients.setText("Xem khách hàng cuối ngày");
        menuClients.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuClientsActionPerformed(evt);
            }
        });
        menuStatistical.add(menuClients);
        menuStatistical.add(jSeparator9);

        menuRevenue.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.SHIFT_DOWN_MASK));
        menuRevenue.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/history.png"))); // NOI18N
        menuRevenue.setText("Xem món ăn cuối ngày");
        menuRevenue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuRevenueActionPerformed(evt);
            }
        });
        menuStatistical.add(menuRevenue);

        menuBar.add(menuStatistical);

        menuItemHelp.setText("Trợ giúp");

        mniHuongDan.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        mniHuongDan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Globe.png"))); // NOI18N
        mniHuongDan.setText("Hướng dẫn sử dụng");
        mniHuongDan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniHuongDanActionPerformed(evt);
            }
        });
        menuItemHelp.add(mniHuongDan);
        menuItemHelp.add(jSeparator5);

        mniGioiThieu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, 0));
        mniGioiThieu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Brick house.png"))); // NOI18N
        mniGioiThieu.setText("Giới thiệu sản phẩm");
        mniGioiThieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniGioiThieuActionPerformed(evt);
            }
        });
        menuItemHelp.add(mniGioiThieu);

        menuBar.add(menuItemHelp);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelBody, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(panelBody, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textDiningTableIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textDiningTableIdActionPerformed
    }//GEN-LAST:event_textDiningTableIdActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        update();
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        delete();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        insert();
    }//GEN-LAST:event_btnAddActionPerformed

    private void textSurchargeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textSurchargeActionPerformed
    }//GEN-LAST:event_textSurchargeActionPerformed

    private void textNumberSeatsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textNumberSeatsActionPerformed
    }//GEN-LAST:event_textNumberSeatsActionPerformed

    private void textNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textNameActionPerformed
    }//GEN-LAST:event_textNameActionPerformed

    private void textDescActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textDescActionPerformed
    }//GEN-LAST:event_textDescActionPerformed

    private void textAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textAreaActionPerformed
    }//GEN-LAST:event_textAreaActionPerformed

    private void comboboxAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboboxAreaActionPerformed
    }//GEN-LAST:event_comboboxAreaActionPerformed

    private void btnPay2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPay2ActionPerformed
        // Add info dining table in auth
        TablesEntity model = getModel();
        Auth.table = model;

        // Switch to interface Invoices.java
        openFullScreenWindow(new Invoices());
    }//GEN-LAST:event_btnPay2ActionPerformed

    private void btnAddOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddOrderActionPerformed
        // Add info dining table in auth
        TablesEntity model = getModel();
        Auth.table = model;
        Auth.orderCount = orderCount;
        Auth.totalAmount = totalConvert;

        // Switch to interface Invoices.java
        openFullScreenWindow(new Products());
    }//GEN-LAST:event_btnAddOrderActionPerformed

    private void menuItemSystemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemSystemActionPerformed

    }//GEN-LAST:event_menuItemSystemActionPerformed

    private void menuLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuLogoutActionPerformed
        if (Dialog.confirm(this, "Bạn muốn đăng xuất?")) {
            Auth.clear();
            dispose();
            new Login(this, true).setVisible(true);
        }
    }//GEN-LAST:event_menuLogoutActionPerformed

    private void menuEndActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuEndActionPerformed
        if (Dialog.confirm(this, "Bạn muốn kết thúc làm việc?")) {
            System.exit(0);
        }
    }//GEN-LAST:event_menuEndActionPerformed

    private void menuTablesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuTablesActionPerformed
        openFullScreenWindow(new DiningTables());
    }//GEN-LAST:event_menuTablesActionPerformed

    private void menuDishesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuDishesActionPerformed
        openFullScreenWindow(new Products());
    }//GEN-LAST:event_menuDishesActionPerformed

    private void menuChickenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuChickenActionPerformed
        openFullScreenWindow(new ConfirmProducts());
    }//GEN-LAST:event_menuChickenActionPerformed

    private void menuPayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuPayActionPerformed
        openFullScreenWindow(new Invoices());
    }//GEN-LAST:event_menuPayActionPerformed

    private void menuEmployeeListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuEmployeeListActionPerformed
        openFullScreenWindow(new Employees());
    }//GEN-LAST:event_menuEmployeeListActionPerformed

    private void menuIngridiantsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuIngridiantsActionPerformed

    }//GEN-LAST:event_menuIngridiantsActionPerformed

    private void menuEmployeesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuEmployeesActionPerformed

    }//GEN-LAST:event_menuEmployeesActionPerformed

    private void menuClientsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuClientsActionPerformed

    }//GEN-LAST:event_menuClientsActionPerformed

    private void menuRevenueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuRevenueActionPerformed
    }//GEN-LAST:event_menuRevenueActionPerformed

    private void mniHuongDanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniHuongDanActionPerformed

    }//GEN-LAST:event_mniHuongDanActionPerformed

    private void mniGioiThieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniGioiThieuActionPerformed

    }//GEN-LAST:event_mniGioiThieuActionPerformed

    private void btnSwitchTablesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSwitchTablesActionPerformed
        switchTables();
    }//GEN-LAST:event_btnSwitchTablesActionPerformed

    private void btnMergeTablesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMergeTablesActionPerformed
    }//GEN-LAST:event_btnMergeTablesActionPerformed

    private void comboboxTablesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboboxTablesActionPerformed
    }//GEN-LAST:event_comboboxTablesActionPerformed

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DiningTables.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            new DiningTables().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnAddOrder;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnMergeTables;
    private javax.swing.JButton btnPay2;
    private javax.swing.JButton btnSwitchTables;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> comboboxArea;
    private javax.swing.JComboBox<String> comboboxTables;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JPopupMenu.Separator jSeparator8;
    private javax.swing.JPopupMenu.Separator jSeparator9;
    private javax.swing.JLabel labelAccount;
    private javax.swing.JLabel labelHouse;
    private javax.swing.JLabel labelLogo;
    private javax.swing.JLabel labelNameDiningTable;
    private javax.swing.JLabel labelTenBan1;
    private javax.swing.JLabel labelTenBan2;
    private javax.swing.JLabel labelTotalAmount;
    private javax.swing.JLabel labelTotalPrice;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem menuChicken;
    private javax.swing.JMenuItem menuClients;
    private javax.swing.JMenuItem menuDishes;
    private javax.swing.JMenuItem menuEmployeeList;
    private javax.swing.JMenuItem menuEmployees;
    private javax.swing.JMenuItem menuEnd;
    private javax.swing.JMenuItem menuIngridiants;
    private javax.swing.JMenu menuItemHelp;
    private javax.swing.JMenu menuItemManager;
    private javax.swing.JMenuItem menuItemSystem;
    private javax.swing.JMenuItem menuLogout;
    private javax.swing.JMenuItem menuPay;
    private javax.swing.JMenuItem menuRevenue;
    private javax.swing.JMenu menuStatistical;
    private javax.swing.JMenu menuSysten;
    private javax.swing.JMenuItem menuTables;
    private javax.swing.JMenuItem mniGioiThieu;
    private javax.swing.JMenuItem mniHuongDan;
    private javax.swing.JPanel panelBody;
    private javax.swing.JPanel panelDiningTableList;
    private javax.swing.JScrollPane scrollPaneTableDining;
    private javax.swing.JTabbedPane tabbedPaneProducts;
    private javax.swing.JTable tableListOrderedDishes;
    private javax.swing.JTextField textArea;
    private javax.swing.JTextField textDesc;
    private javax.swing.JTextField textDiningTableId;
    private javax.swing.JTextField textName;
    private javax.swing.JTextField textNumberSeats;
    private javax.swing.JTextField textSurcharge;
    // End of variables declaration//GEN-END:variables

    int orderCount;
    String totalConvert;
    JButton selectedTableButton;
    List<TablesEntity> dataDiningTables = new TablesDAO().getAll();

    void init() {
        Common.initClock(labelHouse);
        Common.setAccountLabel(labelAccount);
        Common.addClickActionToLabelLogo(labelLogo, this);
        Common.customizeScrollBar(scrollPaneTableDining);
        Common.customizeTable(tableListOrderedDishes, new int[]{0});

        hideSecondTab();
        displayDiningTables(dataDiningTables);
        setupComboboxTablesByArea();
        handleClickComboboxArea();
    }

    // <--- Common
    void openFullScreenWindow(JFrame window) {
        window.setExtendedState(JFrame.MAXIMIZED_BOTH);
        window.setVisible(true);
        this.dispose();
    }

    void hideSecondTab() {
        if (!Auth.isManager()) {
            tabbedPaneProducts.removeTabAt(1);
        }
    }

    void switchTables() {
        // Chose table
        String tableId = textDiningTableId.getText();
        if ("".equals(tableId)) {
            Dialog.warning(this, "Vui lòng chọn bàn!");
            return;
        }

        OrdersEntity order = new OrdersDAO().getOrderByTableId(tableId);
        if (order == null) {
            Dialog.warning(this, "Không tìm thấy đơn đặt hàng!");
            return;
        }

        // Chose table name in combobox
        String newtableName = comboboxTables.getSelectedItem().toString();
        String newTableId = new TablesDAO().getIdByName(newtableName);
        if ("Chọn bàn".equals(newtableName)) {
            Dialog.warning(this, "Vui lòng chọn bàn cần chuyển!");
            return;
        }

        // Check to see if the dining table is in use
        if (new OrdersDAO().getOrderByTableId(newTableId) != null) {
            Dialog.warning(this, "Bàn đang có khách dùng! \nVui lòng chọn bàn khác!");
            return;
        }

        if (!Dialog.confirm(this, "Xác nhận chuyển " + labelNameDiningTable.getText() + " qua " + newtableName)) {
            return;
        }

        try {
            order.setTableId(newTableId); // setup
            new OrdersDAO().update(order); // update
            displayDiningTables(dataDiningTables);
            Dialog.success(this, "Chuyển bàn thành công!");
        } catch (Exception e) {
            Dialog.error(this, "Chuyển bàn thất bại!");
        }
    }
    // end --->

    // <--- CRUD
    TablesEntity getModel() {
        String tableId = textDiningTableId.getText();
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

            dataDiningTables = new TablesDAO().getAll();
            displayDiningTables(dataDiningTables);
            setupComboboxTablesByArea();
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

            dataDiningTables = new TablesDAO().getAll();
            displayDiningTables(dataDiningTables);
            setupComboboxTablesByArea();
        } catch (Exception e) {
            Dialog.alert(this, "Cập nhật thất bại!");
        }
    }

    void delete() {
        String id = textDiningTableId.getText();
        if (!new TablesDAO().isIdDuplicated(id)) {
            Dialog.alert(this, "Mã ID đã chưa tồn tại. Vui lòng nhập lại mã ID!");
            return;
        }

        try {
            new TablesDAO().delete(id);
            Dialog.alert(this, "Xóa thành công!");

            dataDiningTables = new TablesDAO().getAll();
            displayDiningTables(dataDiningTables);
            setupComboboxTablesByArea();
        } catch (Exception e) {
            Dialog.alert(this, "Xóa thất bại!");
        }
    }
    // end --->

    // <--- Display and handle event table dining
    void displayDiningTables(List<TablesEntity> dataTables) {
        // Reset 
        panelDiningTableList.removeAll();

        // Init GridBagLayout
        GridBagLayout gridBagLayout = new GridBagLayout();
        panelDiningTableList.setLayout(gridBagLayout);

        // Init gridbag 
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.insets = new Insets(2, 6, 2, 6);
        constraints.anchor = GridBagConstraints.CENTER;

        int columnCount = 0;

        // Iterate through the dining table list for the selected area
        for (TablesEntity dataItem : dataTables) {
            // Create and set colors based on status
            JButton tableButton = createTableButton(dataItem);

            // Check if the table has any ordered dishes
            String tableId = dataItem.getTableID();
            List<OrderDetailsEntity> detailOrderList = new OrderDetailsDAO().getOrderdByTableId(tableId);
            setTableButtonColors(tableButton, !detailOrderList.isEmpty() ? "Đang phục vụ" : "Còn trống");

            // Đặt các ràng buộc cho thành phần
            gridBagLayout.setConstraints(tableButton, constraints);
            if (++columnCount == 5) {
                columnCount = 0;
                constraints.gridx = 0;
                constraints.gridy++;
            } else {
                constraints.gridx++;
            }

            panelDiningTableList.add(tableButton); // Add button to the panel
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
        tableButton.setFont(new Font("Cascadia Code PL", Font.PLAIN, 16));
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
            displayDetailedDiningTable(diningTable);
            displayOrderedDishesByTable(diningTable.getTableID());

        });

        return tableButton;
    }

    void setTableButtonColors(JButton tableButton, String status) {
        if ("Đã đặt".equals(status)) {
            tableButton.setBackground(new Color(255, 153, 51)); // Màu nền FF9933
        } else if ("Đang phục vụ".equals(status)) {
            tableButton.setBackground(new Color(255, 102, 102)); // Màu nền FF6666
        } else if ("Còn trống".equals(status)) {
            tableButton.setBackground(new Color(255, 255, 255)); // Màu nền FFF
        }
    }

    void displayDetailedDiningTable(TablesEntity diningTable) {
        // Set detailed information in your text fields, combobox, etc.
        String surcharge = Common.addCommasToNumber(String.valueOf(diningTable.getSurcharge()));
        textSurcharge.setText(surcharge);
        textDiningTableId.setText(diningTable.getTableID());
        textName.setText(diningTable.getTableName());
        labelNameDiningTable.setText(diningTable.getTableName());
        textArea.setText(diningTable.getArea());
        textNumberSeats.setText(String.valueOf(diningTable.getSeatingCapacity()));
        textDesc.setText(diningTable.getDescription());
    }

    void displayOrderedDishesByTable(String tableId) {
        // Reset table
        DefaultTableModel model = (DefaultTableModel) tableListOrderedDishes.getModel();
        model.setRowCount(0);

        // Get info detail order through dining table id
        List<OrderDetailsEntity> detailOrderList = new OrderDetailsDAO().getOrderdByTableId(tableId);

        // Create a Map để lưu trữ số lượng và giá của mỗi món
        Map<String, Integer> productPriceMap = new HashMap<>();
        Map<String, Integer> productQuantityMap = new HashMap<>();

        int totalAmount = 0; // Total money all

        // Display dishes on the table
        for (OrderDetailsEntity detailOrder : detailOrderList) {
            // Get info dish
            String dishId = detailOrder.getProductID();
            String dishLevel = !detailOrder.getProductDesc().isEmpty() ? " (" + detailOrder.getProductDesc() + ")" : "";

            // Get detail dish  
            ProductsEntity productEntity = new ProductsDAO().getById(dishId);
            String productName = productEntity.getProductName();
            String productNameAndLevel = productName + dishLevel;

            // Tăng số lượng của món trong Map
            int quantity = detailOrder.getProductQuantity();
            if (productQuantityMap.containsKey(productNameAndLevel)) {
                quantity += productQuantityMap.get(productNameAndLevel);
            }

            productQuantityMap.put(productNameAndLevel, quantity);
            productPriceMap.put(productNameAndLevel, productEntity.getPrice());
        }

        // Add data into the table
        for (Map.Entry<String, Integer> entry : productQuantityMap.entrySet()) {
            // Get name and level -> ex: Mì cay (Cấp 7)
            String productNameAndLevel = entry.getKey();
            int totalQuantity = entry.getValue();

            // Get unit price and quantity -> ex: 50.000₫ x 3
            int unitPrice = productPriceMap.get(productNameAndLevel);
            String convertUnitPrice = Common.addCommasToNumber(String.valueOf(unitPrice)) + "₫";
            String unitPriceAndtotalQuantity = convertUnitPrice + "  x" + totalQuantity;

            // Get total price -> ex: 50.000 x 3 = 150.000
            int totalPrice = unitPrice * totalQuantity;
            String convertTotalPrice = Common.addCommasToNumber(String.valueOf(totalPrice)) + "₫";

            totalAmount += totalPrice; // Total invoice

            // Add row into the table
            model.addRow(new Object[]{
                productNameAndLevel,
                unitPriceAndtotalQuantity,
                convertTotalPrice
            });
        }

        // ex: 100.000 / 1 đơn
        totalConvert = addCommasToNumber(String.valueOf(totalAmount));
        orderCount = new TablesDAO().getOrderCountByTableId(textDiningTableId.getText());
        labelTotalAmount.setText(totalConvert + "₫ / " + orderCount + " đơn");
    }
    // end --->

    // <--- Handle event search and catogory
    void setupComboboxTablesByArea() {
        // Create a DefaultComboBoxModel 
        DefaultComboBoxModel<String> comboBoxModelTables = new DefaultComboBoxModel<>();
        comboBoxModelTables.addElement("Chọn bàn");

        // Create a Set to store unique area names
        DefaultComboBoxModel<String> comboBoxModelArea = new DefaultComboBoxModel<>();
        Set<String> areaSet = new HashSet<>();

        for (TablesEntity dataTable : dataDiningTables) {
            // Add table name to the ComboBoxModel
            comboBoxModelTables.addElement(dataTable.getTableName());

            // Collect unique area names
            areaSet.add(dataTable.getArea());
        }

        // Convert the Set to an array
        String[] areas = areaSet.toArray(String[]::new);
        for (String area : areas) {
            comboBoxModelArea.addElement(area);
        }

        // Set the ComboBoxModel to the comboBox
        comboboxArea.setModel(comboBoxModelArea);
        comboboxTables.setModel(comboBoxModelTables);
    }

    void handleClickComboboxArea() {
        comboboxArea.addActionListener((ActionEvent e) -> {
            // Get the selected area
            String selectedArea = (String) comboboxArea.getSelectedItem();

            // Search area
            List<TablesEntity> dataTables = new TablesDAO().searchByArea(selectedArea);
            displayDiningTables(dataTables);
        });

        // Reset default
        comboboxArea.setSelectedIndex(0);
    }
    // end --->   
}
