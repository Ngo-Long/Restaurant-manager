package restaurant.main;

import java.awt.Font;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Insets;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.event.MouseEvent;
import java.awt.GridBagConstraints;
import java.awt.Image;
import java.awt.event.MouseAdapter;

import java.util.Set;
import java.util.List;
import java.util.Vector;
import java.util.HashSet;
import java.util.stream.Collectors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.BorderFactory;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.TableModelEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

import restaurant.dao.OrderDAO;
import restaurant.dao.InvoiceDAO;
import restaurant.dao.ProductDAO;
import restaurant.dao.OrderDetailDAO;
import restaurant.dialog.HistoryInvoicesJDialog;
import restaurant.entity.OrderEntity;
import restaurant.entity.InvoiceEntity;
import restaurant.entity.ProductEntity;
import restaurant.entity.DiningTableEntity;
import restaurant.entity.OrderDetailEntity;

import restaurant.utils.Auth;
import restaurant.utils.Dialog;
import restaurant.utils.Common;
import restaurant.table.TableCustom;
import restaurant.utils.ColumnTable;
import static restaurant.utils.Common.getRealText;
import static restaurant.utils.Common.addCommasToNumber;
import static restaurant.utils.Common.removeCommasFromNumber;
import restaurant.utils.ImageUtils;
import static restaurant.utils.ImageUtils.getScaledImageIcon;

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
        panelMainProducts = new javax.swing.JPanel();
        btnHistory = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        labelOrderedTable = new javax.swing.JLabel();
        panelMenu = new javax.swing.JPanel();
        labelIcon1 = new javax.swing.JLabel();
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
        labelTotal = new javax.swing.JLabel();
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
        menuItemManager = new javax.swing.JMenuItem();
        menuItemDirectly = new javax.swing.JMenuItem();
        menuItemWayHome = new javax.swing.JMenuItem();
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
        textSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textSearchActionPerformed(evt);
            }
        });

        btnSearch.setBackground(new java.awt.Color(255, 51, 51));
        btnSearch.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSearch.setForeground(new java.awt.Color(255, 255, 255));
        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/icon/Search.png"))); // NOI18N
        btnSearch.setToolTipText("Tìm kiếm");
        btnSearch.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        scrollPane.setBorder(null);

        panelMainProducts.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panelMainProductsLayout = new javax.swing.GroupLayout(panelMainProducts);
        panelMainProducts.setLayout(panelMainProductsLayout);
        panelMainProductsLayout.setHorizontalGroup(
            panelMainProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1214, Short.MAX_VALUE)
        );
        panelMainProductsLayout.setVerticalGroup(
            panelMainProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 690, Short.MAX_VALUE)
        );

        scrollPane.setViewportView(panelMainProducts);

        btnHistory.setBackground(new java.awt.Color(51, 204, 0));
        btnHistory.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnHistory.setForeground(new java.awt.Color(255, 255, 255));
        btnHistory.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/icon/historyWhile.png"))); // NOI18N
        btnHistory.setToolTipText("Xem lịch sử gọi món");
        btnHistory.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnHistory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHistoryActionPerformed(evt);
            }
        });

        btnReset.setBackground(new java.awt.Color(0, 153, 153));
        btnReset.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnReset.setForeground(new java.awt.Color(255, 255, 255));
        btnReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/icon/historyWhile.png"))); // NOI18N
        btnReset.setToolTipText("Reset trang (Ctrl + F5)");
        btnReset.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        labelOrderedTable.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        labelOrderedTable.setForeground(new java.awt.Color(255, 51, 51));
        labelOrderedTable.setText("Dịch vụ");

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

        labelIcon1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/icon/fast-food.png"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(labelIcon1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(labelOrderedTable)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 359, Short.MAX_VALUE)
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
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btnHistory, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                        .addComponent(btnReset, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSearch, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(textSearch, javax.swing.GroupLayout.Alignment.LEADING))
                    .addComponent(labelOrderedTable, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelIcon1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 517, Short.MAX_VALUE)
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
                "Mã món", "Tên món ăn ", "Số lượng", "Thành tiền"
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
            tableOrder.getColumnModel().getColumn(1).setPreferredWidth(220);
            tableOrder.getColumnModel().getColumn(2).setPreferredWidth(80);
            tableOrder.getColumnModel().getColumn(3).setPreferredWidth(90);
        }

        btnSubmit.setBackground(new java.awt.Color(0, 153, 0));
        btnSubmit.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnSubmit.setForeground(new java.awt.Color(255, 255, 255));
        btnSubmit.setText("THANH TOÁN");
        btnSubmit.setToolTipText("Ấn xác nhận để chuyển tới bếp");
        btnSubmit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });

        btnCancel.setBackground(new java.awt.Color(255, 0, 51));
        btnCancel.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnCancel.setForeground(new java.awt.Color(255, 255, 255));
        btnCancel.setText("HỦY");
        btnCancel.setToolTipText("Quay về bàn ăn");
        btnCancel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btnSearch1.setBackground(new java.awt.Color(255, 51, 51));
        btnSearch1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSearch1.setForeground(new java.awt.Color(255, 255, 255));
        btnSearch1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/icon/cart-while-24px.png"))); // NOI18N
        btnSearch1.setToolTipText("Tìm kiếm");
        btnSearch1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSearch1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearch1ActionPerformed(evt);
            }
        });

        labelOrderTable.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        labelOrderTable.setForeground(new java.awt.Color(255, 51, 51));
        labelOrderTable.setText("ORDER");

        textNote.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        textNote.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED), "Ghi chú", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 0, 16))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Tổng cộng:");

        labelTotalAmount.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
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

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Thanh toán:");

        labelTotal.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        labelTotal.setForeground(new java.awt.Color(51, 51, 51));
        labelTotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelTotal.setText("0");

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
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jLabel4)))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                                        .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(30, 30, 30)
                                        .addComponent(labelTotalAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))))
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
                                            .addComponent(labelTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addComponent(jLabel1))))
                        .addContainerGap(20, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labelOrderTable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSearch1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textNote, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelTotalAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        menuSystem.setText("Hệ thống");
        menuSystem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

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
        menuTables.setText("Bàn ăn");
        menuTables.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuTables.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuTablesActionPerformed(evt);
            }
        });
        menuManager.add(menuTables);

        menuDishes.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, 0));
        menuDishes.setText("Món ăn");
        menuDishes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuDishes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuDishesActionPerformed(evt);
            }
        });
        menuManager.add(menuDishes);

        menuChicken.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F3, 0));
        menuChicken.setText("Nhà bếp");
        menuChicken.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuChicken.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuChickenActionPerformed(evt);
            }
        });
        menuManager.add(menuChicken);

        menuPay.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, 0));
        menuPay.setText("Thanh toán");
        menuPay.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuPay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuPayActionPerformed(evt);
            }
        });
        menuManager.add(menuPay);

        menuBar.add(menuManager);

        menuStatistical.setText("Thống kê");
        menuStatistical.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        menuRevenue.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, java.awt.event.InputEvent.SHIFT_DOWN_MASK));
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
        menuIntroduce.setText("Giới thiệu sản phẩm");
        menuIntroduce.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuIntroduce.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuIntroduceActionPerformed(evt);
            }
        });
        menuItemHelp.add(menuIntroduce);

        menuBar.add(menuItemHelp);

        menuVaiTro.setText("Vai trò");

        menuItemManager.setText("Quản lý");
        menuItemManager.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemManagerActionPerformed(evt);
            }
        });
        menuVaiTro.add(menuItemManager);

        menuItemDirectly.setText("Bán tại bàn");
        menuItemDirectly.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemDirectlyActionPerformed(evt);
            }
        });
        menuVaiTro.add(menuItemDirectly);

        menuItemWayHome.setText("Bán mang đi");
        menuItemWayHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemWayHomeActionPerformed(evt);
            }
        });
        menuVaiTro.add(menuItemWayHome);

        menuBar.add(menuVaiTro);

        menuStaff.setText("Tên nhân viên");
        menuBar.add(menuStaff);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 826, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 651, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 651, Short.MAX_VALUE))
                .addGap(12, 12, 12))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
    }//GEN-LAST:event_menuTablesActionPerformed

    private void menuDishesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuDishesActionPerformed
    }//GEN-LAST:event_menuDishesActionPerformed

    private void menuChickenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuChickenActionPerformed
    }//GEN-LAST:event_menuChickenActionPerformed

    private void menuPayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuPayActionPerformed
    }//GEN-LAST:event_menuPayActionPerformed

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

    private void menuItemManagerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemManagerActionPerformed
        openFullScreenWindow(new ManagementMode());
    }//GEN-LAST:event_menuItemManagerActionPerformed

    private void menuItemDirectlyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemDirectlyActionPerformed
        openFullScreenWindow(new OnSiteMode());
    }//GEN-LAST:event_menuItemDirectlyActionPerformed

    private void menuChangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuChangeActionPerformed

    }//GEN-LAST:event_menuChangeActionPerformed

    private void textSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textSearchActionPerformed

    }//GEN-LAST:event_textSearchActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed

    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnHistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHistoryActionPerformed
        new HistoryInvoicesJDialog(null, true).setVisible(true);
    }//GEN-LAST:event_btnHistoryActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        openFullScreenWindow(new QuickOrderMode());
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        submit();
    }//GEN-LAST:event_btnSubmitActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        if (tableOrder != null && tableOrder.getRowCount() == 0) {
            Dialog.warning(this, "Vui lòng chọn món ăn!");
            return;
        }

        Boolean result = Dialog.confirm(this, "Nếu hủy bạn sẽ mất các món ăn đã chọn?");
        if (result) {
            cancel();
        }
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnSearch1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearch1ActionPerformed

    }//GEN-LAST:event_btnSearch1ActionPerformed

    private void menuItemWayHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemWayHomeActionPerformed
        openFullScreenWindow(new QuickOrderMode());
    }//GEN-LAST:event_menuItemWayHomeActionPerformed

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
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JPopupMenu.Separator jSeparator8;
    private javax.swing.JPopupMenu.Separator jSeparator9;
    private javax.swing.JLabel labelIcon1;
    private javax.swing.JLabel labelOrderTable;
    private javax.swing.JLabel labelOrderedTable;
    private javax.swing.JLabel labelTotal;
    private javax.swing.JLabel labelTotalAmount;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem menuChange;
    private javax.swing.JMenuItem menuChicken;
    private javax.swing.JMenuItem menuClients;
    private javax.swing.JMenuItem menuDishes;
    private javax.swing.JMenuItem menuEnd;
    private javax.swing.JMenuItem menuIngridiants;
    private javax.swing.JMenuItem menuInstruct;
    private javax.swing.JMenuItem menuIntroduce;
    private javax.swing.JMenuItem menuItemDirectly;
    private javax.swing.JMenu menuItemHelp;
    private javax.swing.JMenuItem menuItemManager;
    private javax.swing.JMenuItem menuItemWayHome;
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
    private javax.swing.JPanel panelMainProducts;
    private javax.swing.JPanel panelMenu;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JTable tableOrder;
    private javax.swing.JTextField textNote;
    private javax.swing.JTextField textSearch;
    // End of variables declaration//GEN-END:variables

    String tableID;
    String tableName;
    JLabel selectedMenu;
    final String PLACEHOLDER_NOTE = "Tối đa 60 ký tự";
    final String PLACEHOLDER_SEARCH = "Tìm theo tên món";

    OrderEntity existingOrder;
    DiningTableEntity dataTable;
    List<ProductEntity> dataProducts;
    List<ProductEntity> dataProductsByCategory;

    ScheduledFuture<?> scheduledFuture;
    ExecutorService executorService = Executors.newFixedThreadPool(3);
    ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);

    void init() {
        // Setup common
        TableCustom.apply(jScrollPane1, TableCustom.TableType.MULTI_LINE);
        Common.customizeTable(tableOrder, new int[]{3}, 30);
        Common.customizeScrollBar(scrollPane);
        Common.addPlaceholder(textNote, PLACEHOLDER_NOTE);
        Common.addPlaceholder(textSearch, PLACEHOLDER_SEARCH);
        ColumnTable.setupQuantityButtonColumn(tableOrder, 2);

        // Setup
        setupMenu();

        // Calc total amount click column 2
        tableOrder.getModel().addTableModelListener((TableModelEvent e) -> {
            if (e.getColumn() == 2) {
                calculateTotalAmount();
            }
        });

        // Load data
        initEventHandlers();
        loadDataByCriteria();
    }

    static ImageIcon resizeIcon(ImageIcon icon, int width, int height) {
        Image img = icon.getImage();
        Image resizedImg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImg);
    }

    // <--- Common 
    void openFullScreenWindow(JFrame window) {
        window.setExtendedState(JFrame.MAXIMIZED_BOTH);
        window.setVisible(true);
        this.dispose();
    }

    void setupMenu() {
        // Get data all
        dataProducts = new ProductDAO().getAll();

        // Create a set to store unique names
        Set<String> dataSet = new HashSet<>();
        for (ProductEntity dataItem : dataProducts) {
            dataSet.add(dataItem.getCategory());
        }

        // Convert the set to a sorted list
        List<String> dataList = dataSet.stream().sorted().collect(Collectors.toList());

        // Create buttons for each and add them to panel
        for (String dataItem : dataList) {
            // Set button location
            JLabel item = new JLabel(dataItem);
            item.setBackground(Color.LIGHT_GRAY);
            item.setForeground(new Color(120, 120, 120));
            item.setPreferredSize(new Dimension(140, 50));
            item.setFont(new Font("Segoe UI", Font.PLAIN, 14));
            item.setVerticalAlignment(SwingConstants.CENTER);
            item.setHorizontalAlignment(SwingConstants.CENTER);
            item.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            item.setBorder(BorderFactory.createLineBorder(new Color(150, 150, 150), 2, true));

            // Handle click location
            item.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    handleClickMenu(item);
                }
            });

            // Automatically select the first item
            if (selectedMenu == null) {
                handleClickMenu(item);
            }

            // Add item location to the panel
            panelMenu.add(item);
        }

        // Set layout for panelButtons
        panelMenu.setLayout(new FlowLayout(FlowLayout.LEFT, 12, 12));

        // Refresh the panel to display the new buttons
        panelMenu.revalidate();
        panelMenu.repaint();
    }

    void handleClickMenu(JLabel item) {
        // Kiểm tra nếu nút hiện tại không phải là nút đã được chọn trước đó
        if (selectedMenu == item) {
            return;
        }

        // Đặt lại màu cho nút trước đó nếu có
        if (selectedMenu != null) {
            selectedMenu.setForeground(new Color(120, 120, 120));
            selectedMenu.setBorder(BorderFactory.createLineBorder(new Color(150, 150, 150), 2, true));
        }

        // Thiết lập lại màu cho nút hiện tại
        item.setForeground(new Color(255, 11, 11));
        item.setBorder(BorderFactory.createLineBorder(new Color(255, 11, 11), 2, true));

        // Cập nhật nút được chọn hiện tại
        selectedMenu = item;
        loadDataByCriteria();

    }
    // end --->

    // <--- Load data
    void initEventHandlers() {
        // Attach event textSearch
        textSearch.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                loadDataByCriteria();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                loadDataByCriteria();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                loadDataByCriteria();
            }
        });
    }

    void loadDataByCriteria() {
        if (scheduledFuture != null && !scheduledFuture.isDone()) {
            scheduledFuture.cancel(false);
        }

        scheduledFuture = scheduledExecutorService.schedule(() -> {
            SwingUtilities.invokeLater(() -> {
                // Get category and search text
                String menuItem = selectedMenu.getText();
                String keyword = getRealText(textSearch, PLACEHOLDER_SEARCH);

                // Get data and display
                dataProductsByCategory = new ProductDAO().searchByCriteria(keyword, menuItem, "");
                displayProductList(dataProductsByCategory);
            });
        }, 300, TimeUnit.MILLISECONDS);
    }
    // end --->

    // <--- Display and handle events products
    void displayProductList(List<ProductEntity> dataList) {
        // Reset food list
        panelMainProducts.removeAll();

        // Init GridBagLayout
        GridBagLayout gridBagLayout = new GridBagLayout();
        panelMainProducts.setLayout(gridBagLayout);

        // Init gridbag 
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.insets = new Insets(0, 14, 20, 14);
        constraints.anchor = GridBagConstraints.CENTER;

        int maxColumns = 7; // Số lượng cột tối đa trên mỗi hàng
        int columnCount = 0; // Biến đếm số lượng cột hiện tại

        // Iterate through the dining table list for the selected area
        for (ProductEntity dataItem : dataList) {
            // Create and set colors based on status
            JPanel productItem = createPanelProduct(dataItem);

            // Add product to the panel main
            gridBagLayout.setConstraints(productItem, constraints);
            panelMainProducts.add(productItem);

            // Tăng đếm số cột
            if (++columnCount == maxColumns) {
                columnCount = 0;
                constraints.gridx = 0;
                constraints.gridy++;
            } else {
                constraints.gridx++;
            }
        }

        // Refresh the panel
        panelMainProducts.repaint();
        panelMainProducts.revalidate();
    }

    JPanel createPanelProduct(ProductEntity product) {
        // Create a JLabel name
        JLabel textLabel = new JLabel(product.getProductName());
        textLabel.setForeground(new Color(30, 30, 30));
        textLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        textLabel.setFont(new Font(textLabel.getFont().getName(), Font.PLAIN, 14));

        // Create a JLabel price
        String price = String.valueOf(product.getPrice());
        String formattedPrice = Common.addCommasToNumber(price);
        JLabel priceLabel = new JLabel(formattedPrice + "đ");

        // Set alignment, font, and color
        priceLabel.setForeground(new Color(255, 51, 51));
        priceLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        priceLabel.setFont(new Font(priceLabel.getFont().getName(), Font.BOLD, 16));

        // Create label top contains (scaledIcon) 
        ImageIcon scaledIcon = getScaledImageIcon(product.getImageURL(), 170, 200);
        JLabel labelTop = new JLabel(scaledIcon);

        // Create panel bottom contains (name, price, border, button)
        JPanel panelBottom = new JPanel();
        panelBottom.add(textLabel);
        panelBottom.add(Box.createVerticalStrut(8));
        panelBottom.add(priceLabel);
        panelBottom.setBackground(Color.WHITE);
        panelBottom.setLayout(new BoxLayout(panelBottom, BoxLayout.Y_AXIS));
        panelBottom.setBorder(BorderFactory.createEmptyBorder(6, 0, 6, 0));

        // Create a panel main 
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(Color.WHITE);
        mainPanel.setPreferredSize(new Dimension(146, 200));
        mainPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        mainPanel.setBorder(BorderFactory.createLineBorder(Color.lightGray));
        mainPanel.add(labelTop, BorderLayout.CENTER);
        mainPanel.add(panelBottom, BorderLayout.SOUTH);

        // Attach handle click 
        mainPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Add products to the table
                handleClickOrderProduct(product);

                // Calculate and display total amount
                calculateTotalAmount();
            }
        });

        return mainPanel;
    }

    void handleClickOrderProduct(ProductEntity product) {
        // Get model
        DefaultTableModel saveOrder = (DefaultTableModel) tableOrder.getModel();
        String priceStr = String.valueOf(product.getPrice());
        String formattedPrice = Common.addCommasToNumber(priceStr);

        // Check if the product already exists in the table
        boolean productExists = false;
        for (int i = 0; i < saveOrder.getRowCount(); i++) {
            if (saveOrder.getValueAt(i, 0).equals(product.getProductID())) {
                // Product exists, increase quantity by 1
                int quantity = (int) saveOrder.getValueAt(i, 2);
                saveOrder.setValueAt(quantity + 1, i, 2);
                productExists = true;
                break;
            }
        }

        // If the product does not exist, add a new row
        if (!productExists) {
            saveOrder.addRow(new Object[]{
                product.getProductID(),
                product.getProductName(),
                1,
                formattedPrice
            });
        }
    }

    void calculateTotalAmount() {
        long totalAmount = 0;
        DefaultTableModel model = (DefaultTableModel) tableOrder.getModel();

        for (int i = 0; i < model.getRowCount(); i++) {
            // Get price
            String id = model.getValueAt(i, 0).toString();
            ProductEntity product = new ProductDAO().getByID(id);
            long price = product.getPrice();

            // Get quantity
            String quantityStr = model.getValueAt(i, 2).toString();
            int quantity = Integer.parseInt(quantityStr);

            // Calculate subtotal for the row
            long subtotal = price * quantity;
            String convertSubtotal = addCommasToNumber(String.valueOf(subtotal));

            // Set value
            model.setValueAt(convertSubtotal, i, 3);

            // Accumulate subtotal to totalAmount
            totalAmount += subtotal;
        }

        // Format totalAmount to display
        String formattedTotal = addCommasToNumber(String.valueOf(totalAmount));
        labelTotal.setText(formattedTotal);
        labelTotalAmount.setText(formattedTotal);
    }

    // <--- Handle click button submit and cancel
    void cancel() {

        DefaultTableModel model = (DefaultTableModel) tableOrder.getModel();
        model.setRowCount(0);

        labelTotal.setText("0");
        labelTotalAmount.setText("0");
    }

    void submit() {
        if (tableOrder != null && tableOrder.getRowCount() == 0) {
            Dialog.warning(this, "Vui lòng chọn món ăn!");
            return;
        }

        Boolean result = Dialog.confirm(this, "Xác nhận thanh toán đơn hàng!");
        if (!result) {
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

            // Set note for invoice
            String note = Common.getRealText(textNote, "Tối đa 60 ký tự");
            if (note.length() > 60) {
                Dialog.warning(this, "Nhập tối đa 60 ký tự!");
                return;
            }

            // Get total
            int totalAmount = Integer.parseInt(removeCommasFromNumber(labelTotalAmount.getText()));

            // Update invoice
            InvoiceEntity invoiceModel = new InvoiceDAO().getByID(invoiceID);
            invoiceModel.setInvoiceID(invoiceID);
            invoiceModel.setEmployeeID(Auth.user.getEmployeeID());
            invoiceModel.setTax(0);
            invoiceModel.setDiscount(0);
            invoiceModel.setPaymentMethod("Tiền mặt");
            invoiceModel.setNote(note);
            invoiceModel.setTotalAmount(totalAmount);
            invoiceModel.setStatus("Đã thanh toán");
            new InvoiceDAO().update(invoiceModel);

            Dialog.success(this, "Tạo đơn hàng [ " + invoiceModel.getInvoiceID() + " ] thành công!\n\n"
                    + "Vào lúc " + invoiceModel.getPaymentTime());
            cancel();
        } catch (Exception e) {
            Dialog.error(this, "Đã xảy ra lỗi khi xử lý đơn hàng!");
            e.printStackTrace();
        }
    }

    void addProductsToOrderd(int orderID, Vector<Vector> orderProducts) {
        try {
            // For each new list of dishes
            for (Vector<Object> row : orderProducts) {
                String productID = row.get(0).toString();
                String name = row.get(1).toString();
                int quantity = Integer.parseInt(row.get(2).toString());
//                String desc = row.get(3) != null ? row.get(3).toString() : "";

                OrderDetailEntity newDetail = new OrderDetailEntity();
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
