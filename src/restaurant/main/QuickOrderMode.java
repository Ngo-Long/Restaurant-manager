package restaurant.main;

import java.util.List;
import java.util.Vector;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledExecutorService;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import restaurant.dao.OrderDAO;
import restaurant.dao.InvoiceDAO;
import restaurant.dao.ProductDAO;
import restaurant.dao.OrderDetailDAO;
import restaurant.entity.Invoice;
import restaurant.entity.Product;
import restaurant.entity.OrderDetail;

import restaurant.utils.Bill;
import restaurant.utils.Auth;
import restaurant.utils.Dialog;
import restaurant.utils.Common;
import restaurant.utils.PanelMenu;
import restaurant.utils.XTextField;
import restaurant.utils.ColumnTable;
import restaurant.utils.PanelProduct;
import restaurant.table.TableCustom;
import restaurant.dialog.HistoryInvoicesJDialog;
import static restaurant.utils.XTextField.getRealText;
import static restaurant.utils.XTextField.removeCommasFromNumber;
import static restaurant.utils.ColumnTable.addQuantityButtonsColumn;
import static restaurant.utils.Common.setButtonStyle;

public final class QuickOrderMode extends javax.swing.JFrame {

    public QuickOrderMode() {
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
        jPanel3 = new javax.swing.JPanel();
        textSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        scrollPane = new javax.swing.JScrollPane();
        panelProducts = new javax.swing.JPanel();
        btnHistory = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        panelMenu = new javax.swing.JPanel();
        selectBtnTable = new javax.swing.JButton();
        selectBtnProduct = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableOrder = new javax.swing.JTable();
        btnSubmit = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        btnSearch1 = new javax.swing.JButton();
        labelOrderTable = new javax.swing.JLabel();
        textNote = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        labelTotalAmount = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        labelVoucher = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        menuSystem = new javax.swing.JMenu();
        menuChange = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        menuItemLogout = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        menuItemEnd = new javax.swing.JMenuItem();
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

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setPreferredSize(new java.awt.Dimension(1260, 639));

        textSearch.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        btnSearch.setBackground(new java.awt.Color(255, 51, 51));
        btnSearch.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSearch.setForeground(new java.awt.Color(255, 255, 255));
        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/icon/Search.png"))); // NOI18N
        btnSearch.setToolTipText("Tìm kiếm");
        btnSearch.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        scrollPane.setBorder(null);

        panelProducts.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panelProductsLayout = new javax.swing.GroupLayout(panelProducts);
        panelProducts.setLayout(panelProductsLayout);
        panelProductsLayout.setHorizontalGroup(
            panelProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1214, Short.MAX_VALUE)
        );
        panelProductsLayout.setVerticalGroup(
            panelProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 690, Short.MAX_VALUE)
        );

        scrollPane.setViewportView(panelProducts);

        btnHistory.setBackground(new java.awt.Color(51, 204, 0));
        btnHistory.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnHistory.setForeground(new java.awt.Color(255, 255, 255));
        btnHistory.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/icon/historyWhile.png"))); // NOI18N
        btnHistory.setToolTipText("Xem lịch sử hóa đơn");
        btnHistory.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnReset.setBackground(new java.awt.Color(0, 153, 153));
        btnReset.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnReset.setForeground(new java.awt.Color(255, 255, 255));
        btnReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/icon/refreshWhile.png"))); // NOI18N
        btnReset.setToolTipText("Reset trang (Ctrl + F5)");
        btnReset.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        panelMenu.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panelMenuLayout = new javax.swing.GroupLayout(panelMenu);
        panelMenu.setLayout(panelMenuLayout);
        panelMenuLayout.setHorizontalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelMenuLayout.setVerticalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 78, Short.MAX_VALUE)
        );

        selectBtnTable.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        selectBtnTable.setForeground(new java.awt.Color(204, 51, 0));
        selectBtnTable.setText("Phòng/bàn");

        selectBtnProduct.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        selectBtnProduct.setForeground(new java.awt.Color(204, 0, 0));
        selectBtnProduct.setText("Thực đơn");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(selectBtnTable)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(selectBtnProduct)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 226, Short.MAX_VALUE)
                .addComponent(textSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnHistory, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
            .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(panelMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnSearch, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(selectBtnTable, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                        .addComponent(selectBtnProduct, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE))
                    .addComponent(btnHistory, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnReset, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(textSearch, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(11, 11, 11)
                .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 518, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(panelMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(420, 592));

        tableOrder.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        tableOrder.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã món", "", "Tên món ăn ", "Số lượng", "Thành tiền"
            }
        ));
        tableOrder.setAlignmentX(1.0F);
        tableOrder.setAlignmentY(1.0F);
        tableOrder.setFillsViewportHeight(true);
        tableOrder.setGridColor(new java.awt.Color(255, 255, 255));
        tableOrder.setRowHeight(35);
        jScrollPane1.setViewportView(tableOrder);
        if (tableOrder.getColumnModel().getColumnCount() > 0) {
            tableOrder.getColumnModel().getColumn(0).setMinWidth(0);
            tableOrder.getColumnModel().getColumn(0).setPreferredWidth(0);
            tableOrder.getColumnModel().getColumn(0).setMaxWidth(0);
            tableOrder.getColumnModel().getColumn(1).setPreferredWidth(20);
            tableOrder.getColumnModel().getColumn(2).setPreferredWidth(180);
            tableOrder.getColumnModel().getColumn(3).setPreferredWidth(80);
            tableOrder.getColumnModel().getColumn(4).setPreferredWidth(80);
        }

        btnSubmit.setBackground(new java.awt.Color(0, 153, 0));
        btnSubmit.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSubmit.setForeground(new java.awt.Color(255, 255, 255));
        btnSubmit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/icon/coin.png"))); // NOI18N
        btnSubmit.setText("Thanh toán");
        btnSubmit.setToolTipText("Ấn xác nhận để chuyển tới bếp");
        btnSubmit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnCancel.setBackground(new java.awt.Color(0, 153, 153));
        btnCancel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCancel.setForeground(new java.awt.Color(255, 255, 255));
        btnCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/icon/notification-bell.png"))); // NOI18N
        btnCancel.setText("Thông báo");
        btnCancel.setToolTipText("Quay về bàn ăn");
        btnCancel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnSearch1.setBackground(new java.awt.Color(255, 51, 51));
        btnSearch1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSearch1.setForeground(new java.awt.Color(255, 255, 255));
        btnSearch1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/icon/cart-while-24px.png"))); // NOI18N
        btnSearch1.setToolTipText("Tìm kiếm");
        btnSearch1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        labelOrderTable.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        labelOrderTable.setForeground(new java.awt.Color(255, 51, 51));
        labelOrderTable.setText("Order [ Trống ]");

        textNote.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        textNote.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED), "Ghi chú", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 0, 16))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Voucher:");

        labelTotalAmount.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        labelTotalAmount.setForeground(new java.awt.Color(255, 51, 51));
        labelTotalAmount.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelTotalAmount.setText("0");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("0");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Giảm giá:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Thanh toán:");

        labelVoucher.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        labelVoucher.setForeground(new java.awt.Color(51, 51, 51));
        labelVoucher.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelVoucher.setText("0");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(textNote, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel4)
                                .addGap(135, 135, 135)
                                .addComponent(labelTotalAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 3, Short.MAX_VALUE)
                                .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(12, 12, 12))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btnSearch1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelOrderTable, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(144, 144, 144)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(labelVoucher, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addComponent(jLabel1))))
                        .addContainerGap(20, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labelOrderTable, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                    .addComponent(btnSearch1, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textNote, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelVoucher, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelTotalAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        menuSystem.setText("Hệ thống");
        menuSystem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        menuChange.setText("Đổi mật khẩu");
        menuChange.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuSystem.add(menuChange);
        menuSystem.add(jSeparator2);

        menuItemLogout.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        menuItemLogout.setText("Đăng xuất");
        menuItemLogout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuSystem.add(menuItemLogout);
        menuSystem.add(jSeparator1);

        menuItemEnd.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        menuItemEnd.setText("Kết thúc");
        menuItemEnd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuSystem.add(menuItemEnd);

        menuBar.add(menuSystem);

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 826, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 651, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 651, Short.MAX_VALUE))
                .addGap(12, 12, 12))
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
            java.util.logging.Logger.getLogger(QuickOrderMode.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            new QuickOrderMode().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnHistory;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnSearch1;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JLabel labelOrderTable;
    private javax.swing.JLabel labelTotalAmount;
    private javax.swing.JLabel labelVoucher;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem menuChange;
    private javax.swing.JMenuItem menuItemEnd;
    private javax.swing.JMenuItem menuItemLogout;
    private javax.swing.JMenuItem menuItemManagement;
    private javax.swing.JMenuItem menuItemOnSite;
    private javax.swing.JMenuItem menuItemSalerQuick;
    private javax.swing.JMenu menuStaff;
    private javax.swing.JMenu menuSystem;
    private javax.swing.JMenu menuVaiTro;
    private javax.swing.JPanel panelMenu;
    private javax.swing.JPanel panelProducts;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JButton selectBtnProduct;
    private javax.swing.JButton selectBtnTable;
    private javax.swing.JTable tableOrder;
    private javax.swing.JTextField textNote;
    private javax.swing.JTextField textSearch;
    // End of variables declaration//GEN-END:variables

    JLabel selectedMenu;
    JButton selectedButton;
    final String PLACEHOLDER_NOTE = "Tối đa 60 ký tự";
    final String PLACEHOLDER_SEARCH = "Tìm theo tên món";

    ScheduledFuture<?> scheduledFuture;
    ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);

    void init() {
        // <--- Setup common --->
        // set table
        TableCustom.apply(jScrollPane1, TableCustom.TableType.MULTI_LINE);
        Common.customizeTable(tableOrder, new int[]{3}, 30);
        Common.customizeScrollBar(scrollPane);
        selectBtnTable.setBackground(Color.white);
        selectBtnProduct.setBackground(Color.white);

        // set text field
        XTextField.addPlaceholder(textNote, PLACEHOLDER_NOTE);
        XTextField.addPlaceholder(textSearch, PLACEHOLDER_SEARCH);

        // <--- Setup main --->
        // handle click list menu
        JMenuItem[] menuItems = {menuItemManagement, menuItemSalerQuick,
            menuItemOnSite, menuItemLogout, menuItemEnd};
        handleClickListMenuItem(menuItems);

        // handle click button header list
        JButton[] buttons = {btnSubmit, btnReset, btnHistory, btnCancel};
        handleClickButtons(buttons);

        // add button column cell list
        int COLUMN_CELL_ONE = 1;
        int COLUMN_CELL_THREE = 3;
        addButtonColumnCells(tableOrder, COLUMN_CELL_ONE, COLUMN_CELL_THREE);

        // get data all
        List<Product> dataProducts = new ProductDAO().getAll();
        PanelMenu.loadDataPanelMenu(
                panelMenu,
                dataProducts,
                Product::getCategory,
                this::loadDataDisplayProducts
        );

        // load data and display product list
        this.loadDataDisplayProducts(selectedMenu);

        loadDataDisplayProductsOrTable(selectBtnTable, selectBtnProduct);
//        selectBtnTable.doClick();
    }

    // <--- Common 
    void openFullScreenWindow(JFrame window) {
        window.setVisible(true);
        this.dispose();
    }

    void handleClickButtons(JButton[] buttons) {
        if (buttons == null) {
            return;
        }
        
        btnSubmit.addActionListener(e -> submit());
        btnReset.addActionListener(e -> openFullScreenWindow(new QuickOrderMode()));
        
        btnHistory.addActionListener(e -> {
            new HistoryInvoicesJDialog(null, true).setVisible(true);
        });
        
        btnCancel.addActionListener(e -> {
            if (tableOrder != null && tableOrder.getRowCount() == 0) {
                Dialog.warning(this, "Vui lòng chọn món ăn!");
                return;
            }

            Boolean result = Dialog.confirm(this, "Nếu hủy bạn sẽ mất các món ăn đã chọn?");
            if (result) {
                cancel();
            }
        });
    }

    void handleClickListMenuItem(JMenuItem[] menuItems) {
        if (menuItems == null) {
            return;
        }
        menuItemLogout.addActionListener(e -> {
            if (Dialog.confirm(this, "Bạn muốn đăng xuất?")) {
                Auth.clear();
                dispose();
                new Login(this, true).setVisible(true);
            }
        });
        menuItemEnd.addActionListener(e -> {
            if (Dialog.confirm(this, "Bạn muốn kết thúc làm việc?")) {
                System.exit(0);
            }
        });

        menuItemOnSite.addActionListener(e -> openFullScreenWindow(new OnSiteMode()));
        menuItemSalerQuick.addActionListener(e -> openFullScreenWindow(new QuickOrderMode()));
        menuItemManagement.addActionListener(e -> openFullScreenWindow(new ManagementMode()));
    }
    // end -->

    // Load data and display products or table
    void loadDataDisplayProductsOrTable(JButton selectBtnTable, JButton selectBtnProduct) {
        selectBtnTable.addActionListener(e -> {
            // set button product
            setButtonStyle(selectBtnTable, new Color(255, 51, 51), Color.WHITE, Font.BOLD);

            // reset button table
            setButtonStyle(selectBtnProduct, Color.WHITE, new Color(255, 51, 51), Font.PLAIN);
        });

        selectBtnProduct.addActionListener(e -> {
            // set button product
            setButtonStyle(selectBtnProduct, new Color(255, 51, 51), Color.WHITE, Font.BOLD);

            // reset button table
            setButtonStyle(selectBtnTable, Color.WHITE, new Color(255, 51, 51), Font.PLAIN);
        });

    }

    void loadDataDisplayProducts(JLabel selectedMenu) {
        if (selectedMenu == null) {
            return;
        }

        if (scheduledFuture != null && !scheduledFuture.isDone()) {
            scheduledFuture.cancel(false);
        }

        scheduledFuture = scheduledExecutorService.schedule(() -> {
            SwingUtilities.invokeLater(() -> {
                // Get category and search text
                String menuItem = selectedMenu.getText();
                String keyword = getRealText(textSearch, PLACEHOLDER_SEARCH);

                // Get data and display
                List<Product> dataList
                        = new ProductDAO().searchByCriteria(keyword, menuItem, "");

                // Display product list on panel
                PanelProduct.displayProductList(
                        dataList,
                        panelProducts,
                        tableOrder,
                        labelTotalAmount
                );
            });
        }, 300, TimeUnit.MILLISECONDS);
    }

    // <--- handle click cells table
    void addButtonColumnCells(JTable tableOrder, int COLUMN_CELL_ONE, int COLUMN_CELL_THREE) {
        // Add button delete row
        ColumnTable.addButtonIconColumn(
                "src/restaurant/icon/delete.png",
                COLUMN_CELL_ONE,
                tableOrder,
                this::handleClickBtnColumnDelete
        );

        // Add button change quantity "+" and "-"
        addQuantityButtonsColumn(tableOrder, COLUMN_CELL_THREE, false);

        // Calc total amount click column 
        tableOrder.getModel().addTableModelListener(e -> {
            if (e.getColumn() == COLUMN_CELL_THREE) {
                PanelProduct.calculateTotalAmount(tableOrder, labelTotalAmount);
            }
        });
    }

    void handleClickBtnColumnDelete(int row) {
        boolean isSubmit = Dialog.confirm(this, "Xác nhận xóa món ăn!");
        if (isSubmit) {
            // Remove selected row
            if (tableOrder.isEditing()) {
                tableOrder.getCellEditor().stopCellEditing();
            }

            // Call table get model 
            DefaultTableModel model = (DefaultTableModel) tableOrder.getModel();

            // Delete row
            model.removeRow(row);
        }
    }
    // end --->

    // <--- Handle click button submit and cancel
    void cancel() {
        DefaultTableModel model = (DefaultTableModel) tableOrder.getModel();
        model.setRowCount(0);

        labelVoucher.setText("0");
        labelTotalAmount.setText("0");
    }

    void submit() {
        if (!isValueSubmit()) {
            return;
        }

        // Get data from the table ordering more dishes
        DefaultTableModel model = (DefaultTableModel) tableOrder.getModel();
        Vector<Vector> orderProducts = model.getDataVector();

        try {
            // Create new invoice
            int invoiceID = new InvoiceDAO().insert();

            // Create new order
            int orderId = new OrderDAO().insert(invoiceID, "Đã hoàn tất", "Mang về");

            // Add product to the order
            addProductsToOrderd(orderId, orderProducts);

            // Get total
            int totalAmount = Integer.parseInt(removeCommasFromNumber(labelTotalAmount.getText()));

            // Update invoice
            Invoice invoiceModel = new InvoiceDAO().getByID(invoiceID);
            invoiceModel.setInvoiceID(invoiceID);
            invoiceModel.setEmployeeID(Auth.user.getEmployeeID());
            invoiceModel.setPaymentMethod("Tiền mặt");
            invoiceModel.setNote(getRealText(textNote, "Tối đa 60 ký tự"));
            invoiceModel.setTotalAmount(totalAmount);
            invoiceModel.setStatus("Đã thanh toán");
            new InvoiceDAO().update(invoiceModel);

            // prinlt bill invoice
            Bill.billInvoice(invoiceModel);
            cancel();
        } catch (Exception e) {
            Dialog.error(this, "Đã xảy ra lỗi khi xử lý đơn hàng!");
            e.printStackTrace();
        }
    }

    boolean isValueSubmit() {
        if (Auth.user == null) {
            Dialog.warning(this, "Vui lòng đăng nhập!");
            return false;
        }

        if (tableOrder != null && tableOrder.getRowCount() == 0) {
            Dialog.warning(this, "Vui lòng chọn món ăn!");
            return false;
        }

        // Set note for invoice
        String note = getRealText(textNote, "Tối đa 60 ký tự");
        if (note.length() > 60) {
            Dialog.warning(this, "Ghi chú tối đa 60 ký tự!");
            return false;
        }

        Boolean result = Dialog.confirm(this, "Xác nhận thanh toán đơn hàng!");
        if (!result) {
            return false;
        }

        return true;
    }

    void addProductsToOrderd(int orderID, Vector<Vector> orderProducts) {
        try {
            // For each new list of dishes
            for (Vector<Object> row : orderProducts) {
                String productID = row.get(0).toString();
                String name = row.get(2).toString();
                int quantity = Integer.parseInt(row.get(3).toString());
//                String desc = row.get(4) != null ? row.get(4).toString() : "";

                OrderDetail newDetail = new OrderDetail();
                newDetail.setOrderID(orderID);
                newDetail.setProductID(productID);
                newDetail.setProductQuantity(quantity);
                newDetail.setProductStatus("Đã xử lý");
                newDetail.setProductDesc("");
                new OrderDetailDAO().insert(newDetail);
            }

        } catch (Exception e) {
            Dialog.alert(this, "Thêm món ăn thất bại!");
            e.printStackTrace();
        }
    }
    // end --->
}
