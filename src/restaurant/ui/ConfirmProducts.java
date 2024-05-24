package restaurant.ui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.*;
import java.util.List;
import javax.swing.*;
import javax.swing.table.*;
import java.text.SimpleDateFormat;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import restaurant.dao.OrdersDAO;
import restaurant.dao.ProductsDAO;
import restaurant.dao.OrderDetailsDAO;
import restaurant.entity.ProductsEntity;
import restaurant.entity.OrderDetailsEntity;
import restaurant.utils.Auth;
import restaurant.utils.Common;
import restaurant.utils.Dialog;
import static restaurant.utils.Common.createButton;

public class ConfirmProducts extends javax.swing.JFrame {

    int detailID;
    int selectedRow;
    String selectedReason = "";
    private DefaultTableModel modelDrinks;
    private DefaultTableModel modelDishes;
    private DefaultTableModel modelProducts;

    private static final int DETAIL_ID_COLUMN_INDEX = 3;
    private List<OrderDetailsEntity> pendingProducts;
    private List<OrderDetailsEntity> confirmedProducts;

    public ConfirmProducts() {
        initComponents();

        Common.initClock(labelHouse);
        Common.setAccountLabel(labelAccount);
        Common.addClickActionToLabelLogo(labelLogo, this);

        Common.customizeTable(tablePendingDishes, new int[]{});
        Common.customizeTable(tablePendingDrinks, new int[]{});
        Common.customizeTable(tableFinishedProducts, new int[]{});
        
        setupButtonColumn(tablePendingDishes, 3);
        setupButtonColumn(tablePendingDrinks, 3);
        displayProductsInTables();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel3 = new javax.swing.JPanel();
        tabbedPanePay = new javax.swing.JTabbedPane();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tablePendingDishes = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablePendingDrinks = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tableFinishedProducts = new javax.swing.JTable();
        jPanel9 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        labelHouse = new javax.swing.JLabel();
        labelAccount = new javax.swing.JLabel();
        labelLogo = new javax.swing.JLabel();
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
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setPreferredSize(new java.awt.Dimension(860, 555));

        tabbedPanePay.setBackground(new java.awt.Color(255, 255, 255));
        tabbedPanePay.setDoubleBuffered(true);
        tabbedPanePay.setFocusCycleRoot(true);
        tabbedPanePay.setFocusTraversalPolicyProvider(true);
        tabbedPanePay.setFont(new java.awt.Font("Cascadia Code PL", 0, 14)); // NOI18N
        tabbedPanePay.setInheritsPopupMenu(true);
        tabbedPanePay.setOpaque(true);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setAutoscrolls(true);
        jPanel5.setFocusCycleRoot(true);
        jPanel5.setFocusTraversalPolicyProvider(true);
        jPanel5.setInheritsPopupMenu(true);

        tablePendingDishes.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        tablePendingDishes.setForeground(new java.awt.Color(51, 51, 51));
        tablePendingDishes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên món", "Tên bàn", "Thời gian", "Xác nhận", "Mã chi tiết"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tablePendingDishes.setEditingColumn(1);
        tablePendingDishes.setFillsViewportHeight(true);
        tablePendingDishes.setFocusCycleRoot(true);
        tablePendingDishes.setGridColor(new java.awt.Color(255, 255, 255));
        tablePendingDishes.setRowHeight(50);
        jScrollPane5.setViewportView(tablePendingDishes);
        if (tablePendingDishes.getColumnModel().getColumnCount() > 0) {
            tablePendingDishes.getColumnModel().getColumn(4).setMinWidth(0);
            tablePendingDishes.getColumnModel().getColumn(4).setPreferredWidth(0);
            tablePendingDishes.getColumnModel().getColumn(4).setMaxWidth(0);
        }

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 1296, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 549, Short.MAX_VALUE)
        );

        tabbedPanePay.addTab("NHÀ BẾP ", new javax.swing.ImageIcon(getClass().getResource("/icon/chef.png")), jPanel5); // NOI18N
        jPanel5.getAccessibleContext().setAccessibleName("");

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        tablePendingDrinks.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        tablePendingDrinks.setForeground(new java.awt.Color(51, 51, 51));
        tablePendingDrinks.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên món", "Tên bàn", "Thời gian", "Xác nhận", "Mã chi tiết"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tablePendingDrinks.setFillsViewportHeight(true);
        tablePendingDrinks.setGridColor(new java.awt.Color(255, 255, 255));
        tablePendingDrinks.setRowHeight(50);
        tablePendingDrinks.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jScrollPane3.setViewportView(tablePendingDrinks);
        if (tablePendingDrinks.getColumnModel().getColumnCount() > 0) {
            tablePendingDrinks.getColumnModel().getColumn(4).setMinWidth(0);
            tablePendingDrinks.getColumnModel().getColumn(4).setPreferredWidth(0);
            tablePendingDrinks.getColumnModel().getColumn(4).setMaxWidth(0);
        }

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1296, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 549, Short.MAX_VALUE)
        );

        tabbedPanePay.addTab("QUẦY NƯỚC ", new javax.swing.ImageIcon(getClass().getResource("/icon/drink.png")), jPanel6); // NOI18N

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        tableFinishedProducts.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        tableFinishedProducts.setForeground(new java.awt.Color(51, 51, 51));
        tableFinishedProducts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên món", "Tên bàn", "Thời gian", "Trạng thái", "Mã chi tiết"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tableFinishedProducts.setAlignmentX(0.0F);
        tableFinishedProducts.setAlignmentY(0.0F);
        tableFinishedProducts.setFillsViewportHeight(true);
        tableFinishedProducts.setGridColor(new java.awt.Color(255, 255, 255));
        tableFinishedProducts.setRowHeight(50);
        tableFinishedProducts.setShowGrid(false);
        jScrollPane4.setViewportView(tableFinishedProducts);
        if (tableFinishedProducts.getColumnModel().getColumnCount() > 0) {
            tableFinishedProducts.getColumnModel().getColumn(4).setMinWidth(0);
            tableFinishedProducts.getColumnModel().getColumn(4).setPreferredWidth(0);
            tableFinishedProducts.getColumnModel().getColumn(4).setMaxWidth(0);
        }

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 1296, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 549, Short.MAX_VALUE)
        );

        tabbedPanePay.addTab("LỊCH SỬ ", new javax.swing.ImageIcon(getClass().getResource("/icon/history.png")), jPanel8); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabbedPanePay)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabbedPanePay)
        );

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 1, 1, new java.awt.Color(204, 204, 204)));

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
        labelLogo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
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
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(labelLogo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
            .addComponent(labelAccount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(labelHouse, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 1296, Short.MAX_VALUE)
                        .addGap(12, 12, 12))
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 594, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConfirmProducts.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            new ConfirmProducts().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton3;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
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
    private javax.swing.JTabbedPane tabbedPanePay;
    private javax.swing.JTable tableFinishedProducts;
    private javax.swing.JTable tablePendingDishes;
    private javax.swing.JTable tablePendingDrinks;
    // End of variables declaration//GEN-END:variables

    void openFullScreenWindow(JFrame window) {
        window.setExtendedState(JFrame.MAXIMIZED_BOTH);
        window.setVisible(true);
        this.dispose();
    }

    void displayProductsInTables() {
        // Fetch pending and confirmed products
        pendingProducts = new OrderDetailsDAO().getPendingProducts();
        confirmedProducts = new OrderDetailsDAO().getConfirmedProducts();

        // Get model
        modelDrinks = (DefaultTableModel) tablePendingDrinks.getModel();
        modelDishes = (DefaultTableModel) tablePendingDishes.getModel();
        modelProducts = (DefaultTableModel) tableFinishedProducts.getModel();

        // Prepare data for pending and confirmed products table
        fillPendingProductsTable(modelDrinks, modelDishes);
        fillConfirmedProductsTable(modelProducts);

        // Đặt model cho bảng 
        tablePendingDrinks.setModel(modelDrinks);
        tablePendingDishes.setModel(modelDishes);
        tableFinishedProducts.setModel(modelProducts);
    }

    void fillPendingProductsTable(DefaultTableModel modelDrinks, DefaultTableModel modelDishes) {
        // Sắp xếp theo thời gian bắt đầu từ gần nhất
        Collections.sort(pendingProducts, (product1, product2)
                -> product2.getStartTime().compareTo(product1.getStartTime())
        );

        // Get data from list Confirmed products in model
        for (OrderDetailsEntity pendingProduct : pendingProducts) {
            // Get id detail
            int detailProductId = pendingProduct.getOrderDetailID();

            // Get name table by id table
            String tableDiningName = new OrdersDAO().getTableNameByOrderId(pendingProduct.getOrderID());

            // Get info detail
            String productId = pendingProduct.getProductID();
            int productQuantity = pendingProduct.getProductQuantity();
            String productLevel = !pendingProduct.getProductDesc().isEmpty() ? " (" + pendingProduct.getProductDesc() + ")" : "";
            String productTimeAdded = new SimpleDateFormat("HH:mm").format(pendingProduct.getStartTime());

            // Get info dish
            ProductsEntity productEntity = new ProductsDAO().getById(productId);
            String productName = productEntity.getProductName();
            String productNameAndLevel = productName + productLevel + " x" + productQuantity;
            String productKitchenArea = productEntity.getKitchenArea();

            // Thêm sản phẩm vào bảng tương ứng
            if (productKitchenArea.equals("Khu bếp")) {
                modelDishes.addRow(new Object[]{
                    productNameAndLevel,
                    tableDiningName,
                    productTimeAdded,
                    detailProductId
                });
            } else if (productKitchenArea.equals("Quầy nước")) {
                modelDrinks.addRow(new Object[]{
                    productNameAndLevel,
                    tableDiningName,
                    productTimeAdded,
                    detailProductId
                });
            }
        }
    }

    void fillConfirmedProductsTable(DefaultTableModel modelProducts) {
        // Sắp xếp theo thời gian kết thúc từ gần nhất
        Collections.sort(confirmedProducts, (product1, product2)
                -> product2.getEndTime().compareTo(product1.getEndTime())
        );

        // Get data from list Confirmed products in model
        for (OrderDetailsEntity confirmedProduct : confirmedProducts) {
            // Get name table by id table
            String tableDiningName = new OrdersDAO().getTableNameByOrderId(confirmedProduct.getOrderID());

            // Get info detail
            String productId = confirmedProduct.getProductID();
            int productQuantity = confirmedProduct.getProductQuantity();
            String productStatus = confirmedProduct.getProductStatus();
            String productLevel = !confirmedProduct.getProductDesc().isEmpty() ? " (" + confirmedProduct.getProductDesc() + ")" : "";
            String productTimeAdded = new SimpleDateFormat("HH:mm").format(confirmedProduct.getStartTime());
            String productTimeUpdate = new SimpleDateFormat("HH:mm").format(confirmedProduct.getEndTime());

            // Get info dish
            ProductsEntity productEntity = new ProductsDAO().getById(productId);
            String productName = productEntity.getProductName();
            String productNameAndLevel = productName + productLevel + " x" + productQuantity;

            Object[] rowData = {
                productNameAndLevel,
                tableDiningName,
                productTimeAdded + " - " + productTimeUpdate,
                productStatus
            };

            // Add row to model
            modelProducts.addRow(rowData);
        }
    }

    void resetTables() {
        // Xóa tất cả các dòng trong bảng
        modelDrinks.setRowCount(0);
        modelDishes.setRowCount(0);
        modelProducts.setRowCount(0);

        // Cập nhật lại dữ liệu mới
        displayProductsInTables();
    }

    // Init 2 button "Finish" and "Delete"
    void setupButtonColumn(JTable table, int columnNumber) {
        TableColumn column = table.getColumnModel().getColumn(columnNumber);
        column.setCellRenderer(new ButtonRenderer());
        column.setCellEditor(new ButtonEditor(table));
    }

    class ButtonRenderer extends JPanel implements TableCellRenderer {

        public ButtonRenderer() {
            setOpaque(true);
            setLayout(new FlowLayout(FlowLayout.CENTER, 5, 2));
            add(createButton("Hoàn thành", new Color(0, 153, 0), new Dimension(130, 44)));
            add(createButton("Xóa", new Color(255, 0, 51), new Dimension(60, 44)));
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            setBackground(isSelected ? table.getSelectionBackground() : table.getBackground());
            return this;
        }
    }

    class ButtonEditor extends DefaultCellEditor {

        private final JPanel panel;
        private final JButton finishButton;
        private final JButton deleteButton;

        public ButtonEditor(JTable table) {
            super(new JTextField());
            setClickCountToStart(1);
            panel = new JPanel();
            panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 2));

            // Create button
            deleteButton = createButton("Xóa", new Color(255, 0, 51), new Dimension(60, 44));
            finishButton = createButton("Hoàn thành", new Color(0, 153, 0), new Dimension(130, 44));

            // Handle click button
            finishButton.addActionListener((ActionEvent e) -> handleClickFinishButton(table));
            deleteButton.addActionListener((ActionEvent e) -> handleClickDeleteButton(table));

            // Add into panel
            panel.add(finishButton);
            panel.add(deleteButton);
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            return panel;
        }

        @Override
        public Object getCellEditorValue() {
            return "";
        }
    }

    void removeSelectedRowAndUpdateSelection(JTable table, int selectedRow) {
        // Get model and remove row
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        int rowCount = model.getRowCount();

        if (rowCount <= 0) {
            JOptionPane.showMessageDialog(table, "Lỗi rồi!", "Xác nhận", JOptionPane.WARNING_MESSAGE);
            return;
        }

        model.removeRow(selectedRow);

        // Check if the table is still populated
        if (model.getRowCount() > 0) {
            int selectionIndex = Math.max(0, selectedRow - 1);
            table.setRowSelectionInterval(selectionIndex, selectionIndex);
        }

        resetTables();
    }

    void handleClickFinishButton(JTable table) {
        selectedRow = table.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(table, "Hãy chọn một dòng rồi ấn nút", "Xác nhận", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Get id detail product and update finish product
        detailID = (int) table.getValueAt(selectedRow, DETAIL_ID_COLUMN_INDEX);
        new OrderDetailsDAO().updateProductFinished(detailID);

        // Remove selected row
        removeSelectedRowAndUpdateSelection(table, selectedRow);
        JOptionPane.showMessageDialog(null, "In món thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
    }

    void handleClickDeleteButton(JTable table) {
        selectedRow = table.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(table, "Hãy chọn một dòng rồi ấn nút", "Xác nhận", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Get id detail product 
        detailID = (int) table.getValueAt(selectedRow, DETAIL_ID_COLUMN_INDEX);

        // Hiển thị hộp thoại
        JDialog deleteDialog = new JDialog();
        deleteDialog.setTitle("Xác nhận xóa");
        deleteDialog.setSize(300, 400);
        deleteDialog.setLocationRelativeTo(null);
        deleteDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        //  Xác nhận xóa và nhận lí do
        JPanel reasonPanel = createDeleteConfirmationPanel(deleteDialog, detailID);
        deleteDialog.setContentPane(reasonPanel);
        deleteDialog.setVisible(true);
    }

    JPanel createDeleteConfirmationPanel(JDialog deleteDialog, int detailID) {
        // Create panel main
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 10, 10, 10));

        // Create panel info
        JPanel checkBoxPanel = new JPanel();
        checkBoxPanel.setLayout(new BoxLayout(checkBoxPanel, BoxLayout.Y_AXIS));

        // Chỉ cho phép chọn một checkbox
        ButtonGroup group = new ButtonGroup();

        // Add JCheckBox into checkBoxPanel
        JCheckBox[] reasons = new JCheckBox[]{
            createCheckBox("Khách đợi lâu"),
            createCheckBox("Khác không hài lòng"),
            createCheckBox("Khách đổi món"),
            createCheckBox("Khác hủy món"),
            createCheckBox("Hết nguyên liệu"),
            createCheckBox("Nhân viên ghi sai đơn"),};

        // Add spacing after each checkbox
        for (JCheckBox reason : reasons) {
            group.add(reason);
            checkBoxPanel.add(reason);
            checkBoxPanel.add(Box.createVerticalStrut(10));
        }

        // Create other reson panel
        JPanel otherReasonPanel = createOtherReasonPanel();
        checkBoxPanel.add(otherReasonPanel);

        // Create button panel: 
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton cancelButton = createButton("Đóng", Color.WHITE, new Dimension(64, 34));
        JButton confirmatRemoveBtn = createButton("Xác nhận", new Color(255, 100, 0), new Dimension(90, 34));

        // Customize button appearance
        cancelButton.setForeground(Color.BLACK);
        cancelButton.setFont(new Font("SansSerif", Font.PLAIN, 14));
        confirmatRemoveBtn.setFont(new Font("SansSerif", Font.PLAIN, 14));

        // Confirmation selected reason
        confirmatRemoveBtn.addActionListener((ActionEvent e) -> {
            for (JCheckBox reason : reasons) {
                if (reason.isSelected()) {
                    selectedReason = reason.getText();
                    break;
                }
            }

            // Update product remove
            new OrderDetailsDAO().updateProductRemove(detailID, selectedReason);
            resetTables();
            deleteDialog.dispose();
        });

        // Button cancel
        cancelButton.addActionListener(e -> deleteDialog.dispose());

        // Add into panel
        buttonPanel.add(confirmatRemoveBtn);
        buttonPanel.add(cancelButton);
        panel.add(checkBoxPanel, BorderLayout.CENTER);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        return panel;
    }

    JPanel createOtherReasonPanel() {
        JPanel otherReasonPanel = new JPanel(new BorderLayout());
        JTextField textField = new JTextField();

        textField.setFont(textField.getFont().deriveFont(16f));
        otherReasonPanel.add(textField);
        otherReasonPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        otherReasonPanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(EtchedBorder.LOWERED), "Lí do khác",
                TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION,
                new Font("SansSerif", Font.PLAIN, 16))
        );

        return otherReasonPanel;
    }

    static JCheckBox createCheckBox(String text) {
        JCheckBox checkBox = new JCheckBox(text);
        checkBox.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 16));
        return checkBox;
    }
}
