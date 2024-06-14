package restaurant.main;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;

import restaurant.utils.Auth;
import restaurant.utils.Common;
import restaurant.utils.Dialog;
import restaurant.authentication.Login;

import restaurant.staff.Overview;
import restaurant.staff.Products;
import restaurant.staff.Invoices;
import restaurant.staff.OrderTables;
import restaurant.staff.ConfirmProducts;

public final class MainStaff extends javax.swing.JFrame {

    public MainStaff() {
        initComponents();
        this.init();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        scrollPaneMain = new javax.swing.JScrollPane();
        panelMain = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        buttonOverview = new javax.swing.JButton();
        buttonDiningTable = new javax.swing.JButton();
        buttonProduct = new javax.swing.JButton();
        buttonPay = new javax.swing.JButton();
        buttonOverview4 = new javax.swing.JButton();
        buttonOverview5 = new javax.swing.JButton();
        buttonOverview6 = new javax.swing.JButton();
        menuBar = new javax.swing.JMenuBar();
        menuSystem = new javax.swing.JMenu();
        menuChange = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        menuLogout = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        menuEnd = new javax.swing.JMenuItem();
        menuManager = new javax.swing.JMenu();
        menuTables = new javax.swing.JMenuItem();
        menuDishes = new javax.swing.JMenuItem();
        menuChicken = new javax.swing.JMenuItem();
        menuPay = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        menuEmployeeList = new javax.swing.JMenuItem();
        menuStatistical = new javax.swing.JMenu();
        menuRevenue = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        menuIngridiants = new javax.swing.JMenuItem();
        jSeparator8 = new javax.swing.JPopupMenu.Separator();
        menuClients = new javax.swing.JMenuItem();
        jSeparator9 = new javax.swing.JPopupMenu.Separator();
        menuProducts = new javax.swing.JMenuItem();
        menuItemHelp = new javax.swing.JMenu();
        menuInstruct = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        menuIntroduce = new javax.swing.JMenuItem();
        menuStaff = new javax.swing.JMenu();
        menuVaiTro = new javax.swing.JMenu();
        menuItemEmployee = new javax.swing.JMenuItem();
        menuItemManager = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        jMenuItem6.setText("jMenuItem6");

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Hot Noodle");

        scrollPaneMain.setBorder(null);
        scrollPaneMain.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPaneMain.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        javax.swing.GroupLayout panelMainLayout = new javax.swing.GroupLayout(panelMain);
        panelMain.setLayout(panelMainLayout);
        panelMainLayout.setHorizontalGroup(
            panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1286, Short.MAX_VALUE)
        );
        panelMainLayout.setVerticalGroup(
            panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 717, Short.MAX_VALUE)
        );

        scrollPaneMain.setViewportView(panelMain);

        buttonOverview.setText("Tổng quan");
        buttonOverview.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonOverview.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonOverviewActionPerformed(evt);
            }
        });

        buttonDiningTable.setText("Bàn ăn");
        buttonDiningTable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonDiningTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDiningTableActionPerformed(evt);
            }
        });

        buttonProduct.setText("Món ăn");
        buttonProduct.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonProductActionPerformed(evt);
            }
        });

        buttonPay.setText("Thanh Toán");
        buttonPay.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonPay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPayActionPerformed(evt);
            }
        });

        buttonOverview4.setText("Mang về");
        buttonOverview4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonOverview4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonOverview4ActionPerformed(evt);
            }
        });

        buttonOverview5.setText("Chốt ca");
        buttonOverview5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonOverview5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonOverview5ActionPerformed(evt);
            }
        });

        buttonOverview6.setText("Kho hàng");
        buttonOverview6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonOverview6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonOverview6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(buttonOverview, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonDiningTable, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonPay, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonOverview4, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonOverview5, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonOverview6, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonOverview, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonDiningTable, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonPay, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonOverview4, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonOverview5, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonOverview6, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        menuSystem.setText("Hệ thống");
        menuSystem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        menuChange.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Refresh.png"))); // NOI18N
        menuChange.setText("Đổi mật khẩu");
        menuChange.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuChange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuChangeActionPerformed(evt);
            }
        });
        menuSystem.add(menuChange);
        menuSystem.add(jSeparator2);

        menuLogout.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        menuLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Log out.png"))); // NOI18N
        menuLogout.setText("Đăng xuất");
        menuLogout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuLogoutActionPerformed(evt);
            }
        });
        menuSystem.add(menuLogout);
        menuSystem.add(jSeparator1);

        menuEnd.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        menuEnd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Stop.png"))); // NOI18N
        menuEnd.setText("Kết thúc");
        menuEnd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuEnd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuEndActionPerformed(evt);
            }
        });
        menuSystem.add(menuEnd);

        menuBar.add(menuSystem);

        menuManager.setText("Quản lý");
        menuManager.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        menuTables.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        menuTables.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Discussion.png"))); // NOI18N
        menuTables.setText("Bàn ăn");
        menuTables.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuTables.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuTablesActionPerformed(evt);
            }
        });
        menuManager.add(menuTables);

        menuDishes.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, 0));
        menuDishes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Add to basket.png"))); // NOI18N
        menuDishes.setText("Món ăn");
        menuDishes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuDishes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuDishesActionPerformed(evt);
            }
        });
        menuManager.add(menuDishes);

        menuChicken.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F3, 0));
        menuChicken.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/chef.png"))); // NOI18N
        menuChicken.setText("Nhà bếp");
        menuChicken.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuChicken.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuChickenActionPerformed(evt);
            }
        });
        menuManager.add(menuChicken);

        menuPay.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, 0));
        menuPay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/card.png"))); // NOI18N
        menuPay.setText("Thanh toán");
        menuPay.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuPay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuPayActionPerformed(evt);
            }
        });
        menuManager.add(menuPay);
        menuManager.add(jSeparator4);

        menuEmployeeList.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, 0));
        menuEmployeeList.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Clien list.png"))); // NOI18N
        menuEmployeeList.setText("Nhân viên");
        menuEmployeeList.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuEmployeeList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuEmployeeListActionPerformed(evt);
            }
        });
        menuManager.add(menuEmployeeList);

        menuBar.add(menuManager);

        menuStatistical.setText("Thống kê");
        menuStatistical.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        menuRevenue.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, java.awt.event.InputEvent.SHIFT_DOWN_MASK));
        menuRevenue.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Dollar.png"))); // NOI18N
        menuRevenue.setText("Xem doanh thu cuối ngày");
        menuRevenue.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuRevenue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuRevenueActionPerformed(evt);
            }
        });
        menuStatistical.add(menuRevenue);
        menuStatistical.add(jSeparator3);

        menuIngridiants.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, java.awt.event.InputEvent.SHIFT_DOWN_MASK));
        menuIngridiants.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Label.png"))); // NOI18N
        menuIngridiants.setText("Xem nguyên liệu cuối ngày");
        menuIngridiants.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuIngridiants.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuIngridiantsActionPerformed(evt);
            }
        });
        menuStatistical.add(menuIngridiants);
        menuStatistical.add(jSeparator8);

        menuClients.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F3, java.awt.event.InputEvent.SHIFT_DOWN_MASK));
        menuClients.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Users.png"))); // NOI18N
        menuClients.setText("Xem khách hàng cuối ngày");
        menuClients.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuClients.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuClientsActionPerformed(evt);
            }
        });
        menuStatistical.add(menuClients);
        menuStatistical.add(jSeparator9);

        menuProducts.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.SHIFT_DOWN_MASK));
        menuProducts.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/history.png"))); // NOI18N
        menuProducts.setText("Xem món ăn cuối ngày");
        menuProducts.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuProducts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuProductsActionPerformed(evt);
            }
        });
        menuStatistical.add(menuProducts);

        menuBar.add(menuStatistical);

        menuItemHelp.setText("Trợ giúp");
        menuItemHelp.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        menuInstruct.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        menuInstruct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Globe.png"))); // NOI18N
        menuInstruct.setText("Hướng dẫn sử dụng");
        menuInstruct.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuInstruct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuInstructActionPerformed(evt);
            }
        });
        menuItemHelp.add(menuInstruct);
        menuItemHelp.add(jSeparator5);

        menuIntroduce.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, 0));
        menuIntroduce.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Brick house.png"))); // NOI18N
        menuIntroduce.setText("Giới thiệu sản phẩm");
        menuIntroduce.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuIntroduce.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuIntroduceActionPerformed(evt);
            }
        });
        menuItemHelp.add(menuIntroduce);

        menuBar.add(menuItemHelp);

        menuStaff.setText("Tên nhân viên");
        menuBar.add(menuStaff);

        menuVaiTro.setText("Vai trò");

        menuItemEmployee.setText("Nhân viên");
        menuItemEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemEmployeeActionPerformed(evt);
            }
        });
        menuVaiTro.add(menuItemEmployee);

        menuItemManager.setText("Quản lý");
        menuItemManager.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemManagerActionPerformed(evt);
            }
        });
        menuVaiTro.add(menuItemManager);

        menuBar.add(menuVaiTro);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollPaneMain, javax.swing.GroupLayout.DEFAULT_SIZE, 1281, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(scrollPaneMain, javax.swing.GroupLayout.PREFERRED_SIZE, 616, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuChangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuChangeActionPerformed

    }//GEN-LAST:event_menuChangeActionPerformed

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
        displayStaffPanels(new OrderTables(this));
    }//GEN-LAST:event_menuTablesActionPerformed

    private void menuDishesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuDishesActionPerformed
        displayStaffPanels(new Products(this));
    }//GEN-LAST:event_menuDishesActionPerformed

    private void menuChickenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuChickenActionPerformed
        displayStaffPanels(new ConfirmProducts(this));
    }//GEN-LAST:event_menuChickenActionPerformed

    private void menuPayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuPayActionPerformed
        displayStaffPanels(new Invoices(this));
    }//GEN-LAST:event_menuPayActionPerformed

    private void menuEmployeeListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuEmployeeListActionPerformed
    }//GEN-LAST:event_menuEmployeeListActionPerformed

    private void menuRevenueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuRevenueActionPerformed

    }//GEN-LAST:event_menuRevenueActionPerformed

    private void menuIngridiantsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuIngridiantsActionPerformed

    }//GEN-LAST:event_menuIngridiantsActionPerformed

    private void menuClientsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuClientsActionPerformed

    }//GEN-LAST:event_menuClientsActionPerformed

    private void menuProductsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuProductsActionPerformed

    }//GEN-LAST:event_menuProductsActionPerformed

    private void menuInstructActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuInstructActionPerformed
    }//GEN-LAST:event_menuInstructActionPerformed

    private void menuIntroduceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuIntroduceActionPerformed

    }//GEN-LAST:event_menuIntroduceActionPerformed

    private void buttonOverviewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonOverviewActionPerformed
        displayStaffPanels(new Overview(this));
    }//GEN-LAST:event_buttonOverviewActionPerformed

    private void buttonDiningTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDiningTableActionPerformed
        displayStaffPanels(new OrderTables(this));
    }//GEN-LAST:event_buttonDiningTableActionPerformed

    private void buttonProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonProductActionPerformed
        displayStaffPanels(new Products(this));
    }//GEN-LAST:event_buttonProductActionPerformed

    private void buttonPayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPayActionPerformed
        displayStaffPanels(new Invoices(this));
    }//GEN-LAST:event_buttonPayActionPerformed

    private void buttonOverview4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonOverview4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonOverview4ActionPerformed

    private void buttonOverview5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonOverview5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonOverview5ActionPerformed

    private void buttonOverview6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonOverview6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonOverview6ActionPerformed

    private void menuItemEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemEmployeeActionPerformed
        openFullScreenWindow(new MainStaff());
    }//GEN-LAST:event_menuItemEmployeeActionPerformed

    private void menuItemManagerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemManagerActionPerformed
        openFullScreenWindow(new MainManager());
    }//GEN-LAST:event_menuItemManagerActionPerformed

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainStaff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            new MainStaff().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonDiningTable;
    private javax.swing.JButton buttonOverview;
    private javax.swing.JButton buttonOverview4;
    private javax.swing.JButton buttonOverview5;
    private javax.swing.JButton buttonOverview6;
    private javax.swing.JButton buttonPay;
    private javax.swing.JButton buttonProduct;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JPopupMenu.Separator jSeparator8;
    private javax.swing.JPopupMenu.Separator jSeparator9;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem menuChange;
    private javax.swing.JMenuItem menuChicken;
    private javax.swing.JMenuItem menuClients;
    private javax.swing.JMenuItem menuDishes;
    private javax.swing.JMenuItem menuEmployeeList;
    private javax.swing.JMenuItem menuEnd;
    private javax.swing.JMenuItem menuIngridiants;
    private javax.swing.JMenuItem menuInstruct;
    private javax.swing.JMenuItem menuIntroduce;
    private javax.swing.JMenuItem menuItemEmployee;
    private javax.swing.JMenu menuItemHelp;
    private javax.swing.JMenuItem menuItemManager;
    private javax.swing.JMenuItem menuLogout;
    private javax.swing.JMenu menuManager;
    private javax.swing.JMenuItem menuPay;
    private javax.swing.JMenuItem menuProducts;
    private javax.swing.JMenuItem menuRevenue;
    private javax.swing.JMenu menuStaff;
    private javax.swing.JMenu menuStatistical;
    private javax.swing.JMenu menuSystem;
    private javax.swing.JMenuItem menuTables;
    private javax.swing.JMenu menuVaiTro;
    private javax.swing.JPanel panelMain;
    private javax.swing.JScrollPane scrollPaneMain;
    // End of variables declaration//GEN-END:variables

    void init() {
        Common.setAccountMenu(menuStaff);
        Common.customizeScrollBar(scrollPaneMain);

        displayStaffPanels(new Overview(this));
    }

    public void displayStaffPanels(JPanel panel) {
        panelMain.removeAll();
        panelMain.setLayout(new BorderLayout());
        panelMain.add(panel, BorderLayout.CENTER);
        panelMain.revalidate();
        panelMain.repaint();
    }

    void openFullScreenWindow(JFrame window) {
        window.setVisible(true);
        window.setLocationRelativeTo(null);
        this.dispose();
    }
}
