package restaurant.main;

import java.awt.Font;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;

import restaurant.utils.Auth;
import restaurant.utils.Common;
import restaurant.utils.Dialog;
import restaurant.onsite.OverviewFrm;
import restaurant.onsite.ProductFrm;
import restaurant.onsite.InvoiceFrm;
import restaurant.onsite.DiningTableFrm;
import restaurant.onsite.AreaKitchenFrm;

public final class OnSiteMode extends javax.swing.JFrame {

    public OnSiteMode() {
        initComponents();
        this.init();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jPopupMenu2 = new javax.swing.JPopupMenu();
        buttonGroup1 = new javax.swing.ButtonGroup();
        scrollPaneMain = new javax.swing.JScrollPane();
        panelMain = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        btnOverview = new javax.swing.JButton();
        btnTable = new javax.swing.JButton();
        btnProduct = new javax.swing.JButton();
        btnPay = new javax.swing.JButton();
        btnOrderTake = new javax.swing.JButton();
        btnClosingShift = new javax.swing.JButton();
        btnWareHouse = new javax.swing.JButton();
        btnCheck = new javax.swing.JButton();
        btnBell = new javax.swing.JButton();
        btnMenu = new javax.swing.JButton();
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
        menuVaiTro = new javax.swing.JMenu();
        menuItemManagement = new javax.swing.JMenuItem();
        menuItemOnSite = new javax.swing.JMenuItem();
        menuItemSalerQuick = new javax.swing.JMenuItem();
        menuStaff = new javax.swing.JMenu();

        jMenuItem1.setText("jMenuItem1");

        jMenuItem6.setText("jMenuItem6");

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        jMenu1.setText("jMenu1");

        jMenuItem2.setText("jMenuItem2");

        jMenuItem3.setText("jMenuItem3");

        jMenu3.setText("File");
        jMenuBar1.add(jMenu3);

        jMenu4.setText("Edit");
        jMenuBar1.add(jMenu4);

        jMenu5.setText("jMenu5");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Hot Noodle");

        scrollPaneMain.setBorder(null);
        scrollPaneMain.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPaneMain.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        javax.swing.GroupLayout panelMainLayout = new javax.swing.GroupLayout(panelMain);
        panelMain.setLayout(panelMainLayout);
        panelMainLayout.setHorizontalGroup(
            panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1369, Short.MAX_VALUE)
        );
        panelMainLayout.setVerticalGroup(
            panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 790, Short.MAX_VALUE)
        );

        scrollPaneMain.setViewportView(panelMain);

        jPanel1.setAutoscrolls(true);

        btnOverview.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnOverview.setForeground(new java.awt.Color(51, 51, 51));
        btnOverview.setText("Tổng Quan");
        btnOverview.setBorder(null);
        btnOverview.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnTable.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnTable.setText("Bàn Ăn");
        btnTable.setBorder(null);
        btnTable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnProduct.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnProduct.setText("Món Ăn");
        btnProduct.setBorder(null);
        btnProduct.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnPay.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnPay.setText("Thanh Toán");
        btnPay.setBorder(null);
        btnPay.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnOrderTake.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnOrderTake.setText("Lịch hẹn");
        btnOrderTake.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnClosingShift.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnClosingShift.setText("Chốt Ca");
        btnClosingShift.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnWareHouse.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnWareHouse.setText("Kho Hàng");
        btnWareHouse.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnCheck.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnCheck.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/icon/check-mark.png"))); // NOI18N
        btnCheck.setBorder(null);
        btnCheck.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnBell.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnBell.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/icon/bell.png"))); // NOI18N
        btnBell.setBorder(null);
        btnBell.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnMenu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/icon/menu.png"))); // NOI18N
        btnMenu.setBorder(null);
        btnMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(btnOverview, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnTable, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnPay, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnOrderTake, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnClosingShift, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnWareHouse, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnBell, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCheck, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnMenu, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                    .addComponent(btnBell, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                    .addComponent(btnCheck, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnOverview, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnTable, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnPay, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnOrderTake, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnClosingShift, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnWareHouse, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );

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

        menuTables.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        menuTables.setText("Bàn ăn");
        menuTables.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuManager.add(menuTables);

        menuDishes.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, 0));
        menuDishes.setText("Món ăn");
        menuDishes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuManager.add(menuDishes);

        menuChicken.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F3, 0));
        menuChicken.setText("Nhà bếp");
        menuChicken.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuManager.add(menuChicken);

        menuPay.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, 0));
        menuPay.setText("Thanh toán");
        menuPay.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuManager.add(menuPay);

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

        menuStaff.setText("Tên nhân viên");
        menuBar.add(menuStaff);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(scrollPaneMain, javax.swing.GroupLayout.DEFAULT_SIZE, 1280, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(scrollPaneMain, javax.swing.GroupLayout.DEFAULT_SIZE, 618, Short.MAX_VALUE))
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
            java.util.logging.Logger.getLogger(OnSiteMode.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            new OnSiteMode().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBell;
    private javax.swing.JButton btnCheck;
    private javax.swing.JButton btnClosingShift;
    private javax.swing.JButton btnMenu;
    private javax.swing.JButton btnOrderTake;
    private javax.swing.JButton btnOverview;
    private javax.swing.JButton btnPay;
    private javax.swing.JButton btnProduct;
    private javax.swing.JButton btnTable;
    private javax.swing.JButton btnWareHouse;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JPopupMenu.Separator jSeparator8;
    private javax.swing.JPopupMenu.Separator jSeparator9;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem menuChange;
    private javax.swing.JMenuItem menuChicken;
    private javax.swing.JMenuItem menuClients;
    private javax.swing.JMenuItem menuDishes;
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

    JButton selectedButton = btnOverview;

    void init() {
        // Common
        Common.setAccountMenu(menuStaff);
        Common.customizeScrollBar(scrollPaneMain);

        // handle click menu
        menuLogout.addActionListener(e -> {
            if (Dialog.confirm(this, "Bạn muốn đăng xuất?")) {
                Auth.clear();
                dispose();
                new Login(this, true).setVisible(true);
            }
        });
        menuEnd.addActionListener(e -> {
            if (Dialog.confirm(this, "Bạn muốn kết thúc làm việc?")) {
                System.exit(0);
            }
        });
        menuTables.addActionListener(e -> displayOnSitePanel(new ProductFrm(this)));
        menuDishes.addActionListener(e -> displayOnSitePanel(new ProductFrm(this)));
        menuItemOnSite.addActionListener(e -> openFullScreenWindow(new OnSiteMode()));
        menuItemSalerQuick.addActionListener(e -> openFullScreenWindow(new QuickOrderMode()));
        menuItemManagement.addActionListener(e -> openFullScreenWindow(new ManagementMode()));

        // handle click button header
        btnOverview.addActionListener(e -> displayOnSitePanel(new OverviewFrm(this)));
        btnTable.addActionListener(e -> displayOnSitePanel(new DiningTableFrm(this)));
        btnBell.addActionListener(e -> displayOnSitePanel(new AreaKitchenFrm(this)));
        btnProduct.addActionListener(e -> {
            Auth.table = null;
            Auth.order = null;
            displayOnSitePanel(new ProductFrm(this));
        });
        btnPay.addActionListener(e -> {
            Auth.table = null;
            Auth.order = null;
            Auth.invoice = null;
            displayOnSitePanel(new InvoiceFrm(this));
        });

        // Attach event hover button chose. Fisrt button is btnOverview
        setupHeaderButtons(btnOverview);

        // Display UI main
        displayOnSitePanel(new OverviewFrm(this));
    }

    public JButton[] getHeaderButtons() {
        JButton[] headerButtons = {btnOverview, btnTable, btnProduct, btnPay,
            btnOrderTake, btnClosingShift, btnWareHouse, btnBell, btnCheck, btnMenu};

        return headerButtons;
    }

    public void setupHeaderButtons(JButton selectedBtn) {
        // Mảng chứa các nút cần xử lý
        JButton[] buttons = getHeaderButtons();

        // Thiết lập sự kiện cho từng nút
        for (JButton button : buttons) {
            // Thiết lập nút bình thường
            setButtonStyle(button, new Color(11, 11, 11), new Color(255, 255, 255), Font.PLAIN);

            button.addActionListener((ActionEvent e) -> {
                // Kiểm tra nếu nút hiện tại không phải là nút đã được chọn trước đó
                if (selectedButton != button) {
                    // Đặt lại màu cho nút trước đó nếu có
                    if (selectedButton != null) {
                        setButtonStyle(selectedButton, new Color(11, 11, 11), new Color(255, 255, 255), Font.PLAIN);
                    }

                    // Thiết lập lại màu cho nút hiện tại
                    setButtonStyle(button, Color.WHITE, new Color(255, 51, 51), Font.BOLD);

                    // Cập nhật nút được chọn hiện tại
                    selectedButton = button;
                }
            });

            // Đặt trạng thái ban đầu cho nút được chọn
            if (selectedBtn != null) {
                setButtonStyle(selectedBtn, Color.WHITE, new Color(255, 51, 51), Font.BOLD);
                selectedButton = selectedBtn;
            }
        }
    }

    void setButtonStyle(JButton button, Color foregroundColor, Color backgroundColor, int fontWeight) {
        button.setForeground(foregroundColor);
        button.setBackground(backgroundColor);
        button.setFont(button.getFont().deriveFont(fontWeight));
    }

    public void displayOnSitePanel(JPanel panel) {
        panelMain.removeAll();
        panelMain.setLayout(new BorderLayout());
        panelMain.add(panel, BorderLayout.CENTER);
        panelMain.revalidate();
        panelMain.repaint();
    }

    void openFullScreenWindow(JFrame window) {
        window.setVisible(true);
        this.dispose();
    }
}
