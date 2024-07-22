package restaurant.main;

import java.awt.Font;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.border.LineBorder;

import restaurant.utils.Auth;
import restaurant.utils.Common;
import restaurant.utils.Dialog;

import restaurant.management.GoodsFrm;
import restaurant.management.InvoiceFrm;
import restaurant.management.ReceiptFrm;
import restaurant.management.OverviewFrm;
import restaurant.management.EmployeeFrm;
import restaurant.management.ProductFrm;
import restaurant.management.SupplierFrm;
import restaurant.management.DiningTableFrm;
import static restaurant.utils.PopupMenu.addDropdownMenu;

public final class ManagementMode extends javax.swing.JFrame {

    public ManagementMode() {
        initComponents();
        this.init();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu4 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jPopupMenu2 = new javax.swing.JPopupMenu();
        jPopupMenu3 = new javax.swing.JPopupMenu();
        jPopupMenu4 = new javax.swing.JPopupMenu();
        jPopupMenu5 = new javax.swing.JPopupMenu();
        jPopupMenu6 = new javax.swing.JPopupMenu();
        jPopupMenu7 = new javax.swing.JPopupMenu();
        jPanel3 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        labelLogo = new javax.swing.JLabel();
        btnOverview = new javax.swing.JButton();
        btnTable = new javax.swing.JButton();
        btnProduct = new javax.swing.JButton();
        btnWareHouse = new javax.swing.JButton();
        btnReceipt = new javax.swing.JButton();
        btnEmployee = new javax.swing.JButton();
        btnSuppleir = new javax.swing.JButton();
        btnReport = new javax.swing.JButton();
        scrollPaneMain = new javax.swing.JScrollPane();
        panelMain = new javax.swing.JPanel();
        menuBar = new javax.swing.JMenuBar();
        menuSystem = new javax.swing.JMenu();
        menuChange = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        menuLogout = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        menuEnd = new javax.swing.JMenuItem();
        menuManager = new javax.swing.JMenu();
        menuTable = new javax.swing.JMenuItem();
        menuProduct = new javax.swing.JMenuItem();
        menuChicken = new javax.swing.JMenuItem();
        menuPay = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        menuEmployee = new javax.swing.JMenuItem();
        menuEmployees = new javax.swing.JMenuItem();
        menuStatistical = new javax.swing.JMenu();
        menuRevenue = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        menuIngridiants = new javax.swing.JMenuItem();
        jSeparator8 = new javax.swing.JPopupMenu.Separator();
        menuClients = new javax.swing.JMenuItem();
        jSeparator9 = new javax.swing.JPopupMenu.Separator();
        menuProducts = new javax.swing.JMenuItem();
        menuItemHelp = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jSeparator6 = new javax.swing.JPopupMenu.Separator();
        menuInstruct = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        menuIntroduce = new javax.swing.JMenuItem();
        menuVaiTro = new javax.swing.JMenu();
        menuItemManagement = new javax.swing.JMenuItem();
        menuItemOnSite = new javax.swing.JMenuItem();
        menuItemSalerQuick = new javax.swing.JMenuItem();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        jMenu4.setText("File");
        jMenuBar2.add(jMenu4);

        jMenu5.setText("Edit");
        jMenuBar2.add(jMenu5);

        jMenuItem2.setText("jMenuItem2");

        jMenuItem3.setText("jMenuItem3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Hot Noodle");

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 1, 1, new java.awt.Color(204, 204, 204)));

        jButton3.setBackground(new java.awt.Color(238, 238, 238));
        jButton3.setBorder(null);

        labelLogo.setFont(new java.awt.Font("Showcard Gothic", 0, 32)); // NOI18N
        labelLogo.setForeground(new java.awt.Color(255, 102, 102));
        labelLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelLogo.setText("HOT NOODLE");
        labelLogo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelLogo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        btnOverview.setBackground(new java.awt.Color(255, 102, 102));
        btnOverview.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnOverview.setForeground(new java.awt.Color(51, 51, 51));
        btnOverview.setText("Tổng Quan");
        btnOverview.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 6, true));
        btnOverview.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnTable.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnTable.setText("Phòng/Bàn");
        btnTable.setBorder(null);
        btnTable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnProduct.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnProduct.setText("Sản Phẩm");
        btnProduct.setBorder(null);
        btnProduct.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnWareHouse.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnWareHouse.setText("Hàng Hóa");
        btnWareHouse.setBorder(null);
        btnWareHouse.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnReceipt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnReceipt.setText("Giao dịch");
        btnReceipt.setBorder(null);
        btnReceipt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnEmployee.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnEmployee.setText("Nhân Viên");
        btnEmployee.setBorder(null);
        btnEmployee.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnSuppleir.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnSuppleir.setText("Đối Tác");
        btnSuppleir.setBorder(null);
        btnSuppleir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnReport.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnReport.setText("Báo Cáo");
        btnReport.setBorder(null);
        btnReport.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(labelLogo)
                .addGap(115, 115, 115)
                .addComponent(btnOverview, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(btnTable, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(btnProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(btnWareHouse, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(btnReceipt, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(btnSuppleir, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(btnEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(btnReport, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 117, Short.MAX_VALUE)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(labelLogo))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnOverview, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnWareHouse, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnReceipt, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSuppleir, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnReport, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnTable, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        scrollPaneMain.setBorder(null);
        scrollPaneMain.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPaneMain.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        panelMain.setBackground(new java.awt.Color(243, 243, 243));

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

        menuSystem.setText("Hệ thống");
        menuSystem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        menuChange.setText("Đổi mật khẩu");
        menuChange.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuSystem.add(menuChange);
        menuSystem.add(jSeparator2);

        menuLogout.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        menuLogout.setText("Đăng xuất");
        menuLogout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuSystem.add(menuLogout);
        menuSystem.add(jSeparator1);

        menuEnd.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        menuEnd.setText("Kết thúc");
        menuEnd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuSystem.add(menuEnd);

        menuBar.add(menuSystem);

        menuManager.setText("Quản lý");
        menuManager.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        menuTable.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        menuTable.setText("Bàn ăn");
        menuTable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuManager.add(menuTable);

        menuProduct.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, 0));
        menuProduct.setText("Món ăn");
        menuProduct.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuManager.add(menuProduct);

        menuChicken.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F3, 0));
        menuChicken.setText("Nhà bếp");
        menuChicken.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuManager.add(menuChicken);

        menuPay.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, 0));
        menuPay.setText("Thanh toán");
        menuPay.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuManager.add(menuPay);
        menuManager.add(jSeparator4);

        menuEmployee.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, 0));
        menuEmployee.setText("Nhân viên");
        menuEmployee.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuManager.add(menuEmployee);

        menuEmployees.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F6, 0));
        menuEmployees.setText("Kho hàng");
        menuEmployees.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuManager.add(menuEmployees);

        menuBar.add(menuManager);

        menuStatistical.setText("Thống kê");
        menuStatistical.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        menuRevenue.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, java.awt.event.InputEvent.SHIFT_DOWN_MASK));
        menuRevenue.setText("Xem doanh thu cuối ngày");
        menuRevenue.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuStatistical.add(menuRevenue);
        menuStatistical.add(jSeparator3);

        menuIngridiants.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, java.awt.event.InputEvent.SHIFT_DOWN_MASK));
        menuIngridiants.setText("Xem nguyên liệu cuối ngày");
        menuIngridiants.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuStatistical.add(menuIngridiants);
        menuStatistical.add(jSeparator8);

        menuClients.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F3, java.awt.event.InputEvent.SHIFT_DOWN_MASK));
        menuClients.setText("Xem khách hàng cuối ngày");
        menuClients.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuStatistical.add(menuClients);
        menuStatistical.add(jSeparator9);

        menuProducts.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.SHIFT_DOWN_MASK));
        menuProducts.setText("Xem món ăn cuối ngày");
        menuProducts.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuStatistical.add(menuProducts);

        menuBar.add(menuStatistical);

        menuItemHelp.setText("Trợ giúp");
        menuItemHelp.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_5, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem1.setText("Reset");
        menuItemHelp.add(jMenuItem1);
        menuItemHelp.add(jSeparator6);

        menuInstruct.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        menuInstruct.setText("Hướng dẫn sử dụng");
        menuInstruct.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuItemHelp.add(menuInstruct);
        menuItemHelp.add(jSeparator5);

        menuIntroduce.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, 0));
        menuIntroduce.setText("Giới thiệu sản phẩm");
        menuIntroduce.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuItemHelp.add(menuIntroduce);

        menuBar.add(menuItemHelp);

        menuVaiTro.setText("Vai trò");

        menuItemManagement.setText("Quản lý");
        menuVaiTro.add(menuItemManagement);

        menuItemOnSite.setText("Bán tại bàn");
        menuVaiTro.add(menuItemOnSite);

        menuItemSalerQuick.setText("Bán mang đi");
        menuVaiTro.add(menuItemSalerQuick);

        menuBar.add(menuVaiTro);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(scrollPaneMain, javax.swing.GroupLayout.DEFAULT_SIZE, 1282, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(scrollPaneMain, javax.swing.GroupLayout.DEFAULT_SIZE, 616, Short.MAX_VALUE))
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
            java.util.logging.Logger.getLogger(ManagementMode.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            new ManagementMode().setVisible(true);
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEmployee;
    private javax.swing.JButton btnOverview;
    private javax.swing.JButton btnProduct;
    private javax.swing.JButton btnReceipt;
    private javax.swing.JButton btnReport;
    private javax.swing.JButton btnSuppleir;
    private javax.swing.JButton btnTable;
    private javax.swing.JButton btnWareHouse;
    private javax.swing.JButton jButton3;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JPopupMenu jPopupMenu3;
    private javax.swing.JPopupMenu jPopupMenu4;
    private javax.swing.JPopupMenu jPopupMenu5;
    private javax.swing.JPopupMenu jPopupMenu6;
    private javax.swing.JPopupMenu jPopupMenu7;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JPopupMenu.Separator jSeparator6;
    private javax.swing.JPopupMenu.Separator jSeparator8;
    private javax.swing.JPopupMenu.Separator jSeparator9;
    private javax.swing.JLabel labelLogo;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem menuChange;
    private javax.swing.JMenuItem menuChicken;
    private javax.swing.JMenuItem menuClients;
    private javax.swing.JMenuItem menuEmployee;
    private javax.swing.JMenuItem menuEmployees;
    private javax.swing.JMenuItem menuEnd;
    private javax.swing.JMenuItem menuIngridiants;
    private javax.swing.JMenuItem menuInstruct;
    private javax.swing.JMenuItem menuIntroduce;
    private javax.swing.JMenu menuItemHelp;
    private javax.swing.JMenuItem menuItemManagement;
    private javax.swing.JMenuItem menuItemOnSite;
    private javax.swing.JMenuItem menuItemSalerQuick;
    private javax.swing.JMenuItem menuLogout;
    private javax.swing.JMenu menuManager;
    private javax.swing.JMenuItem menuPay;
    private javax.swing.JMenuItem menuProduct;
    private javax.swing.JMenuItem menuProducts;
    private javax.swing.JMenuItem menuRevenue;
    private javax.swing.JMenu menuStatistical;
    private javax.swing.JMenu menuSystem;
    private javax.swing.JMenuItem menuTable;
    private javax.swing.JMenu menuVaiTro;
    private javax.swing.JPanel panelMain;
    private javax.swing.JScrollPane scrollPaneMain;
    // End of variables declaration//GEN-END:variables

    JButton selectedButton = btnOverview;

    void init() {
        // Common
        Common.customizeScrollBar(scrollPaneMain);

        // handle click menu item
        JMenuItem[] menuItems = {menuEnd, menuLogout, menuTable, menuProduct,
            menuEmployees, menuItemOnSite, menuItemSalerQuick, menuItemManagement};
        handleClickMenuItem(menuItems);

        // Create dropdown menu when hover button 
        JButton[] dropdownButtons = {btnWareHouse, btnReceipt, btnSuppleir,
            btnEmployee, btnReport};
        initDropdownButtons(dropdownButtons);

        // handle click button header
        JButton[] headerButtons = getHeaderButtons();
        handleClickButtons(headerButtons);

        // get started
        btnOverview.doClick();
    }

    // open window
    void openFullScreenWindow(JFrame window) {
        window.setVisible(true);
        this.dispose();
    }

    // move panel in management
    public void displayManagementPanel(JPanel panel) {
        panelMain.removeAll();
        panelMain.setLayout(new BorderLayout());
        panelMain.add(panel, BorderLayout.CENTER);
        panelMain.revalidate();
        panelMain.repaint();
    }

    // method add menu when hover button
    void initDropdownButtons(JButton[] buttons) {
        if (buttons == null) {
            return;
        }

        // get button
        JButton btnWareHouse = buttons[0];
        JButton btnReceipt = buttons[1];
        JButton btnSuppleir = buttons[2];
        JButton btnEmployee = buttons[3];
        JButton btnReport = buttons[4];

        // click button goods
        String[] menuItemsGoods = {"Danh mục", "Kiểm kho"};
        addDropdownMenu(btnWareHouse, menuItemsGoods, this::onGoodsDropdownItem);

        // click button receipt
        String[] menuItemsReceipt = {"Hóa đơn", "Nhập hàng"};
        addDropdownMenu(btnReceipt, menuItemsReceipt, this::onReceiptDropdownItem);

        // click button partner
        String[] menuItemsPartner = {"Khách hàng", "Nhà cung cấp"};
        addDropdownMenu(btnSuppleir, menuItemsPartner, this::onPartnerDropdownItem);

        // click button employee
        String[] menuItemsEmployee = {"Nhân viên", "Lịch làm việc", "Chấm công", "Bảng tính lương"};
        addDropdownMenu(btnEmployee, menuItemsEmployee, this::onEmployeeDropdownItem);

        // click button report
        String[] menuItemsReport = {"Cuối ngày", "Bán hàng", "Hàng hóa",
            "Khách hàng", "Nhà cung cấp", "Nhân viên", "Tài chính"};
        addDropdownMenu(btnReport, menuItemsReport, this::onReportDropdownItem);
    }

    // method handle event click menu and menu item
    void handleClickMenuItem(JMenuItem[] menuItems) {
        if (menuItems == null) {
            return;
        }

        // get button
        JMenuItem menuEnd = menuItems[0];
        JMenuItem menuLogout = menuItems[1];
        JMenuItem menuTable = menuItems[2];
        JMenuItem menuProduct = menuItems[3];
        JMenuItem menuEmployees = menuItems[4];
        JMenuItem menuItemOnSite = menuItems[5];
        JMenuItem menuItemSalerQuick = menuItems[6];
        JMenuItem menuItemManagement = menuItems[7];

        // click button list
        menuEnd.addActionListener(e -> {
            if (Dialog.confirm(this, "Bạn muốn kết thúc làm việc?")) {
                System.exit(0);
            }
        });

        menuLogout.addActionListener(e -> {
            if (Dialog.confirm(this, "Bạn muốn đăng xuất?")) {
                Auth.clear();
                dispose();
                new Login(this, true).setVisible(true);
            }
        });

        // move panel
        menuTable.addActionListener(e -> displayManagementPanel(new DiningTableFrm(this)));
        menuProduct.addActionListener(e -> displayManagementPanel(new ProductFrm(this)));
        menuEmployees.addActionListener(e -> displayManagementPanel(new EmployeeFrm(this)));

        // move file
        menuItemOnSite.addActionListener(e -> openFullScreenWindow(new OnSiteMode()));
        menuItemSalerQuick.addActionListener(e -> openFullScreenWindow(new QuickOrderMode()));
        menuItemManagement.addActionListener(e -> openFullScreenWindow(new ManagementMode()));
    }

    // method handle event click button
    void handleClickButtons(JButton[] buttons) {
        if (buttons == null) {
            return;
        }

        // get button
        JButton btnOverview = buttons[0];
        JButton btnTable = buttons[1];
        JButton btnProduct = buttons[2];
        JButton btnWarehouse = buttons[3];
        JButton btnReceipt = buttons[4];
        JButton btnSupplier = buttons[5];
        JButton btnEmployee = buttons[6];
        JButton btnReport = buttons[7];

        // set action listeners for each button
        btnOverview.addActionListener(e -> {
            setupSelectedButton(btnOverview);
            displayManagementPanel(new OverviewFrm(this));
        });

        btnTable.addActionListener(e -> {
            setupSelectedButton(btnTable);
            displayManagementPanel(new DiningTableFrm(this));
        });

        btnProduct.addActionListener(e -> {
            setupSelectedButton(btnProduct);
            displayManagementPanel(new ProductFrm(this));
        });

        btnWarehouse.addActionListener(e -> {
            setupSelectedButton(btnWarehouse);
            displayManagementPanel(new GoodsFrm(this));
        });

        btnReceipt.addActionListener(e -> {
            setupSelectedButton(btnReceipt);
            displayManagementPanel(new InvoiceFrm(this));
        });

        btnSupplier.addActionListener(e -> {
            setupSelectedButton(btnSupplier);
            displayManagementPanel(new SupplierFrm(this));
        });

        btnEmployee.addActionListener(e -> {
            setupSelectedButton(btnEmployee);
            displayManagementPanel(new EmployeeFrm(this));
        });
    }

    // <--- Setup click selected button
    public JButton[] getHeaderButtons() {
        JButton[] headerButtons = {btnOverview, btnTable, btnProduct,
            btnWareHouse, btnReceipt, btnEmployee, btnSuppleir, btnReport};
        return headerButtons;
    }

    public void setupSelectedButton(JButton selectedBtn) {
        // Mảng chứa các nút cần xử lý
        JButton[] buttons = getHeaderButtons();

        // Thiết lập sự kiện cho từng nút
        for (JButton button : buttons) {
            // Thiết lập nút bình thường
            setButtonStyle(button, new Color(11, 11, 11), Color.WHITE, Font.PLAIN);

            // Attach event when click button
            button.addActionListener((ActionEvent e) -> {
                // Kiểm tra nếu nút hiện tại không phải là nút đã được chọn trước đó
                if (selectedButton == button) {
                    return;
                }

                // Đặt lại màu cho nút trước đó nếu có
                if (selectedButton != null) {
                    setButtonStyle(selectedButton, new Color(11, 11, 11), Color.WHITE, Font.PLAIN);
                }

                // Thiết lập lại màu cho nút hiện tại
                setButtonStyle(button, new Color(255, 51, 51), Color.WHITE, Font.BOLD);

                // Cập nhật nút được chọn hiện tại
                selectedButton = button;
            });

            // Đặt trạng thái ban đầu cho nút được chọn
            if (selectedBtn != null) {
                setButtonStyle(selectedBtn, new Color(255, 51, 51), Color.WHITE, Font.BOLD);
                selectedButton = selectedBtn;
            }
        }
    }

    void setButtonStyle(JButton button, Color foregroundColor,
            Color backgroundColor, int fontWeight) {
        // set info
        button.setForeground(foregroundColor);
        button.setBackground(backgroundColor);
        button.setFont(button.getFont().deriveFont(fontWeight));
        button.setBorder(new LineBorder(Color.WHITE, 6, true));

        // Attach event when hover button
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setBackground(new Color(180, 180, 180));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button.setBackground(Color.WHITE);
            }
        });
    }
    // end --->

    // <--- Callback function to handle menu item selection
    void onGoodsDropdownItem(int index) {
        switch (index) {
            case 0:
            case 1:
                setupSelectedButton(btnWareHouse);
                displayManagementPanel(new GoodsFrm(this));
                break;
            default:
                break;
        }
    }

    void onReceiptDropdownItem(int index) {
        switch (index) {
            case 0:
                setupSelectedButton(btnReceipt);
                displayManagementPanel(new InvoiceFrm(this));
                break;
            case 1:
                setupSelectedButton(btnReceipt);
                displayManagementPanel(new ReceiptFrm(this));
                break;
            default:
                break;
        }
    }

    void onPartnerDropdownItem(int index) {
        switch (index) {
            case 0:
            case 1:
                setupSelectedButton(btnSuppleir);
                displayManagementPanel(new SupplierFrm(this));
                break;
            default:
                break;
        }
    }

    void onEmployeeDropdownItem(int index) {
        switch (index) {
            case 0:
            case 1:
            case 2:
            case 3:
                setupSelectedButton(btnEmployee);
                displayManagementPanel(new EmployeeFrm(this));
                break;
            default:
                break;
        }
    }

    void onReportDropdownItem(int index) {
        switch (index) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                setupSelectedButton(btnReport);
                displayManagementPanel(new EmployeeFrm(this));
                break;
            default:
                break;
        }
    }
    // end --->

}
