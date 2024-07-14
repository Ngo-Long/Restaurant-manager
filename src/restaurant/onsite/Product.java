package restaurant.onsite;

import java.awt.Font;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import javax.swing.SwingUtilities;
import javax.swing.SwingConstants;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;

import java.util.Set;
import java.util.List;
import java.util.Vector;
import java.util.HashSet;
import java.util.stream.Collectors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledExecutorService;

import restaurant.dao.OrderDAO;
import restaurant.dao.InvoiceDAO;
import restaurant.dao.ProductDAO;
import restaurant.dao.OrderTableDAO;
import restaurant.dao.DiningTableDAO;
import restaurant.dao.OrderDetailDAO;

import restaurant.utils.Auth;
import restaurant.utils.Dialog;
import restaurant.utils.Common;
import restaurant.utils.ColumnTable;
import restaurant.main.OnSiteMode;
import restaurant.table.TableCustom;
import restaurant.entity.OrderEntity;
import restaurant.entity.ProductEntity;
import restaurant.entity.OrderDetailEntity;
import restaurant.entity.DiningTableEntity;
import restaurant.dialog.OrderDetailJDialog;
import restaurant.main.QuickOrderMode;
import static restaurant.utils.TextFieldUtils.getRealText;
import restaurant.utils.RunnableUtils;
import restaurant.utils.TextFieldUtils;

public class Product extends javax.swing.JPanel {

    private OnSiteMode onSite;

    public Product(OnSiteMode onSite) {
        this.onSite = onSite;
        initComponents();
        this.init();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableOrder = new javax.swing.JTable();
        btnSubmit = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        btnSearch1 = new javax.swing.JButton();
        labelOrderTable = new javax.swing.JLabel();
        textNote = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        labelTotalAmount = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        textSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        scrollPane = new javax.swing.JScrollPane();
        panelProducts = new javax.swing.JPanel();
        btnHistory = new javax.swing.JButton();
        btnSearch2 = new javax.swing.JButton();
        btnSearch3 = new javax.swing.JButton();
        labelOrderedTable = new javax.swing.JLabel();
        panelMenu = new javax.swing.JPanel();

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
            tableOrder.getColumnModel().getColumn(2).setPreferredWidth(78);
            tableOrder.getColumnModel().getColumn(3).setPreferredWidth(88);
        }

        btnSubmit.setBackground(new java.awt.Color(0, 153, 0));
        btnSubmit.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnSubmit.setForeground(new java.awt.Color(255, 255, 255));
        btnSubmit.setText("XÁC NHẬN");
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

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Tổng cộng");

        labelTotalAmount.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        labelTotalAmount.setForeground(new java.awt.Color(255, 51, 51));
        labelTotalAmount.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelTotalAmount.setText("0₫");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelTotalAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(labelTotalAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnSearch1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelOrderTable, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(textNote, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGap(12, 12, 12))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labelOrderTable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSearch1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textNote, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSubmit, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                    .addComponent(btnCancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

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

        panelProducts.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panelProductsLayout = new javax.swing.GroupLayout(panelProducts);
        panelProducts.setLayout(panelProductsLayout);
        panelProductsLayout.setHorizontalGroup(
            panelProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 853, Short.MAX_VALUE)
        );
        panelProductsLayout.setVerticalGroup(
            panelProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 554, Short.MAX_VALUE)
        );

        scrollPane.setViewportView(panelProducts);

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

        btnSearch2.setBackground(new java.awt.Color(0, 153, 153));
        btnSearch2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSearch2.setForeground(new java.awt.Color(255, 255, 255));
        btnSearch2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/icon/historyWhile.png"))); // NOI18N
        btnSearch2.setToolTipText("Reset trang (Ctrl + F5)");
        btnSearch2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSearch2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearch2ActionPerformed(evt);
            }
        });

        btnSearch3.setBackground(new java.awt.Color(255, 51, 51));
        btnSearch3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSearch3.setForeground(new java.awt.Color(255, 255, 255));
        btnSearch3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/icon/cart-while-24px.png"))); // NOI18N
        btnSearch3.setToolTipText("Tìm kiếm");
        btnSearch3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSearch3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearch3ActionPerformed(evt);
            }
        });

        labelOrderedTable.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        labelOrderedTable.setForeground(new java.awt.Color(255, 51, 51));
        labelOrderedTable.setText("Dịch Vụ");

        panelMenu.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panelMenuLayout = new javax.swing.GroupLayout(panelMenu);
        panelMenu.setLayout(panelMenuLayout);
        panelMenuLayout.setHorizontalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelMenuLayout.setVerticalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(btnSearch3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelOrderedTable)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(textSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSearch2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnHistory, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
            .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 826, Short.MAX_VALUE)
            .addComponent(panelMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btnHistory, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSearch2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSearch, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(textSearch, javax.swing.GroupLayout.Alignment.LEADING))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(labelOrderedTable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSearch3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 468, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(panelMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE)
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 602, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(12, 12, 12))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        cancel();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        submit();
    }//GEN-LAST:event_btnSubmitActionPerformed

    private void textSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textSearchActionPerformed
    }//GEN-LAST:event_textSearchActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnHistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHistoryActionPerformed
        new OrderDetailJDialog(null, true).setVisible(true);
    }//GEN-LAST:event_btnHistoryActionPerformed

    private void btnSearch2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearch2ActionPerformed
        onSite.displayOnSitePanel(new Product(onSite));
    }//GEN-LAST:event_btnSearch2ActionPerformed

    private void btnSearch1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearch1ActionPerformed
    }//GEN-LAST:event_btnSearch1ActionPerformed

    private void btnSearch3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearch3ActionPerformed

    }//GEN-LAST:event_btnSearch3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnHistory;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnSearch1;
    private javax.swing.JButton btnSearch2;
    private javax.swing.JButton btnSearch3;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelOrderTable;
    private javax.swing.JLabel labelOrderedTable;
    private javax.swing.JLabel labelTotalAmount;
    private javax.swing.JPanel panelMenu;
    private javax.swing.JPanel panelProducts;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JTable tableOrder;
    private javax.swing.JTextField textNote;
    private javax.swing.JTextField textSearch;
    // End of variables declaration//GEN-END:variables

    JLabel selectedMenu;
    final int COLUMN_CELL = 2;
    final String PLACEHOLDER_NOTE = "Tối đa 60 ký tự";
    final String PLACEHOLDER_SEARCH = "Tìm theo tên món";

    ScheduledFuture<?> scheduledFuture;
    ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);

    void init() {
        // <--- Setup common --->
        TableCustom.apply(jScrollPane1, TableCustom.TableType.MULTI_LINE);
        Common.customizeTable(tableOrder, new int[]{3}, 30);
        Common.customizeScrollBar(scrollPane);
        TextFieldUtils.addPlaceholder(textNote, PLACEHOLDER_NOTE);
        TextFieldUtils.addPlaceholder(textSearch, PLACEHOLDER_SEARCH);

        // <--- Setup main --->
        // Set info
        displayTableInfo(Auth.table);
        displayOrderInfo(Auth.table);

        // Add buttons quantity "+" and "-"
        ColumnTable.addQuantityButtonsColumn(tableOrder, COLUMN_CELL);

        // Calc total amount click column 
        tableOrder.getModel().addTableModelListener((TableModelEvent e) -> {
            if (e.getColumn() == COLUMN_CELL) {
                QuickOrderMode.calculateTotalAmount(tableOrder, labelTotalAmount);
            }
        });

        // Get menu category
        List<ProductEntity> dataList = new ProductDAO().getAll();
        setupMenuCategory(dataList, panelMenu, selectedMenu);

        // Load data
        RunnableUtils.addTextFieldListeners(textSearch, this::loadData);
        this.loadData();
    }

    // <--- display info
    void displayTableInfo(DiningTableEntity dataTable) {
        if (dataTable == null) {
            return;
        }

        String tableID = dataTable.getTableID();
        String tableName = dataTable.getName();

        // Set case
        labelOrderTable.setText(tableID == null
                ? "ORDER [ Bàn Trống ]"
                : "ORDER [ " + tableName + " ]");
    }

    void displayOrderInfo(DiningTableEntity dataTable) {
        if (dataTable == null) {
            return;
        }

        try {
            // Get order
            String tableID = dataTable.getTableID();
            OrderEntity existingOrder = new OrderDAO().getByTableID(tableID);

            // Set text note
            String note = existingOrder.getNote();
            if (note.equals("")) {
                TextFieldUtils.addPlaceholder(textNote, "Tối đa 60 ký tự");
            } else {
                textNote.setText(note);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    // end --->

    // <--- setup menu
    void setupMenuCategory(List<ProductEntity> datAll, JPanel panelMenu, JLabel selectedMenu) {
        // Create a set to store unique names
        Set<String> dataSet = new HashSet<>();
        for (ProductEntity dataItem : datAll) {
            dataSet.add(dataItem.getCategory());
        }

        // Convert the set to a sorted list
        List<String> dataList = dataSet.stream().sorted().collect(Collectors.toList());

        // Create buttons for each and add them to panel
        for (String dataItem : dataList) {
            // Set button location
            JLabel labelItem = new JLabel(dataItem);
            labelItem.setBackground(Color.LIGHT_GRAY);
            labelItem.setForeground(new Color(120, 120, 120));
            labelItem.setPreferredSize(new Dimension(140, 50));
            labelItem.setFont(new Font("Segoe UI", Font.PLAIN, 14));
            labelItem.setVerticalAlignment(SwingConstants.CENTER);
            labelItem.setHorizontalAlignment(SwingConstants.CENTER);
            labelItem.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            labelItem.setBorder(BorderFactory.createLineBorder(new Color(150, 150, 150), 2, true));

            // Handle click location
            labelItem.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    handleClickMenu(labelItem);
                }
            });

            // Automatically select the first item
            if (selectedMenu == null) {
                handleClickMenu(labelItem);
            }

            // Add item location to the panel
            panelMenu.add(labelItem);
        }

        // Set layout for panelButtons
        panelMenu.setLayout(new FlowLayout(FlowLayout.LEFT, 12, 12));

        // Refresh the panel to display the new buttons
        panelMenu.revalidate();
        panelMenu.repaint();
    }

    void handleClickMenu(JLabel labelItem) {
        // Kiểm tra nếu nút hiện tại không phải là nút đã được chọn trước đó
        if (selectedMenu == labelItem) {
            return;
        }

        // Đặt lại màu cho nút trước đó nếu có
        if (selectedMenu != null) {
            selectedMenu.setForeground(new Color(120, 120, 120));
            selectedMenu.setBorder(BorderFactory.createLineBorder(new Color(150, 150, 150), 2, true));
        }

        // Thiết lập lại màu cho nút hiện tại
        labelItem.setForeground(new Color(255, 11, 11));
        labelItem.setBorder(BorderFactory.createLineBorder(new Color(255, 11, 11), 2, true));

        // Cập nhật nút được chọn hiện tại
        selectedMenu = labelItem;
        this.loadData();
    }
    // end --->

    //  Load data
    void loadData() {
        if (scheduledFuture != null && !scheduledFuture.isDone()) {
            scheduledFuture.cancel(false);
        }

        scheduledFuture = scheduledExecutorService.schedule(() -> {
            SwingUtilities.invokeLater(() -> {
                // Get category and search text
                String menuItem = selectedMenu.getText();
                String keyword = getRealText(textSearch, PLACEHOLDER_SEARCH);

                // Get data and display
                List<ProductEntity> dataList
                        = new ProductDAO().searchByCriteria(keyword, menuItem, "");

                // Display product list on panel
                QuickOrderMode.displayProductList(
                        dataList, 
                        panelProducts, 
                        tableOrder, 
                        labelTotalAmount
                );
            });
        }, 300, TimeUnit.MILLISECONDS);
    }

    // <--- Handle click button submit and cancel
    void cancel() {
        // Nếu bàn chưa chọn món thì rời đi luôn
        DefaultTableModel model = (DefaultTableModel) tableOrder.getModel();
        if (model.getRowCount() == 0) {
            onSite.displayOnSitePanel(new DiningTable(onSite));
            return;
        }

        // Nếu bàn đã gọi món thì hỏi trước khi thoát
        Boolean result = Dialog.confirm(this, "Nếu thoát bạn sẽ mất các món ăn đã chọn?");
        if (result) {
            onSite.displayOnSitePanel(new DiningTable(onSite));
        }
    }

    void submit() {
        String tableID = Auth.table != null ? Auth.table.getTableID() : "";
        if (tableID == "") {
            Dialog.warning(this, "Vui lòng chọn bàn ăn!");
            return;
        }

        if (tableOrder != null && tableOrder.getRowCount() == 0) {
            Dialog.warning(this, "Vui lòng chọn món ăn!");
            return;
        }

        // Get data from the table ordering more dishes
        DefaultTableModel model = (DefaultTableModel) tableOrder.getModel();
        Vector<Vector> orderProducts = model.getDataVector();

        try {
            // Create an order if don't have one yet
            OrderEntity existingOrder = new OrderDAO().getByTableID(tableID);
            if (existingOrder == null) {
                // Create new invoice
                int invoiceID = new InvoiceDAO().insert();

                // Create new order
                int orderId = new OrderDAO().insert(invoiceID, "Đang chuẩn bị", "Tại nhà hàng");

                // Set status table
                DiningTableEntity dataTable = new DiningTableDAO().getByID(tableID);
                dataTable.setStatus("Đang phục vụ");
                new DiningTableDAO().update(dataTable);

                // Set OrderTable
                new OrderTableDAO().insert(orderId, tableID, "Đang hoạt động");
            }

            // Get newly created order information and update note
            existingOrder = new OrderDAO().getByTableID(tableID);
            String note = TextFieldUtils.getRealText(textNote, "Tối đa 60 ký tự");
            if (note.length() > 60) {
                Dialog.warning(this, "Nhập tối đa 60 ký tự!");
                return;
            } else {
                existingOrder.setNote(note);
                new OrderDAO().update(existingOrder);
            }

            // Add product to the order
            addProductsToOrderd(existingOrder.getOrderId(), orderProducts);

            // Open file table
            onSite.displayOnSitePanel(new DiningTable(onSite));
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

                // Add new each dish on detail order
                for (int i = 1; i <= quantity; i++) {
                    OrderDetailEntity newDetail = new OrderDetailEntity();
                    newDetail.setOrderID(orderID);
                    newDetail.setProductID(productID);
                    newDetail.setProductQuantity(1);
                    newDetail.setProductStatus("Chưa xử lý");
                    newDetail.setProductDesc("");
                    new OrderDetailDAO().insert(newDetail);
                }
            }

            Dialog.alert(this, "Thêm món ăn thành công!");
        } catch (Exception e) {
            Dialog.alert(this, "Thêm món ăn thất bại!");
            e.printStackTrace();
        }
    }
    // end --->
}
