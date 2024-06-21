package restaurant.staff;

import java.util.Set;
import java.util.List;
import java.util.Vector;
import java.util.HashSet;

import java.awt.Font;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Insets;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.BorderFactory;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.event.TableModelEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

import restaurant.dao.OrderDAO;
import restaurant.dao.InvoiceDAO;
import restaurant.dao.ProductDAO;
import restaurant.dao.OrderTableDAO;
import restaurant.dao.DiningTableDAO;
import restaurant.dao.OrderDetailDAO;

import restaurant.utils.Auth;
import restaurant.utils.Dialog;
import restaurant.utils.Common;
import restaurant.main.MainStaff;
import restaurant.dialog.DetailOrderJDialog;
import restaurant.entity.DiningTableEntity;

import restaurant.table.TableCustom;
import restaurant.entity.OrderEntity;
import restaurant.entity.ProductEntity;
import restaurant.entity.OrderDetailEntity;
import restaurant.utils.ColumnTable;
import static restaurant.utils.Common.addCommasToNumber;
import static restaurant.utils.ImageUtils.getScaledImageIcon;

public class Products extends javax.swing.JPanel {

    private MainStaff mainStaff;

    public Products(MainStaff mainStaff) {
        this.mainStaff = mainStaff;
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
        labelTotal = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        CbCategory = new javax.swing.JComboBox<>();
        textSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        scrollPane = new javax.swing.JScrollPane();
        panelMainProducts = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        btnHistory = new javax.swing.JButton();
        btnSearch2 = new javax.swing.JButton();

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(420, 592));

        tableOrder.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
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
            tableOrder.getColumnModel().getColumn(2).setPreferredWidth(77);
            tableOrder.getColumnModel().getColumn(3).setPreferredWidth(87);
        }

        btnSubmit.setBackground(new java.awt.Color(0, 153, 0));
        btnSubmit.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
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
        btnCancel.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
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

        labelOrderTable.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        labelOrderTable.setForeground(new java.awt.Color(255, 51, 51));
        labelOrderTable.setText("ORDER");

        textNote.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textNote.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED), "Ghi chú", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 0, 16))); // NOI18N

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Tổng cộng");

        labelTotal.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelTotal.setForeground(new java.awt.Color(255, 51, 51));
        labelTotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelTotal.setText("0₫");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(labelTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addGap(12, 12, 12)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(textNote, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        CbCategory.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        CbCategory.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả" }));
        CbCategory.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        textSearch.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textSearchActionPerformed(evt);
            }
        });

        btnSearch.setBackground(new java.awt.Color(255, 51, 51));
        btnSearch.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSearch.setForeground(new java.awt.Color(255, 255, 255));
        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/searchWhile.png"))); // NOI18N
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
            .addGap(0, 853, Short.MAX_VALUE)
        );
        panelMainProductsLayout.setVerticalGroup(
            panelMainProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 554, Short.MAX_VALUE)
        );

        scrollPane.setViewportView(panelMainProducts);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/filter1.png"))); // NOI18N

        btnHistory.setBackground(new java.awt.Color(51, 204, 0));
        btnHistory.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnHistory.setForeground(new java.awt.Color(255, 255, 255));
        btnHistory.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/historyWhile.png"))); // NOI18N
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
        btnSearch2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/refreshWhile.png"))); // NOI18N
        btnSearch2.setToolTipText("Reset trang (Ctrl + F5)");
        btnSearch2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSearch2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearch2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CbCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 294, Short.MAX_VALUE)
                .addComponent(textSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSearch2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnHistory, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
            .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(CbCategory, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                    .addComponent(textSearch, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                    .addComponent(btnSearch, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                    .addComponent(btnSearch2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                    .addComponent(btnHistory, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 596, Short.MAX_VALUE))
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
        new DetailOrderJDialog(null, true).setVisible(true);
    }//GEN-LAST:event_btnHistoryActionPerformed

    private void btnSearch2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearch2ActionPerformed
        mainStaff.displayStaffPanels(new Products(mainStaff));
    }//GEN-LAST:event_btnSearch2ActionPerformed

    private void btnSearch1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearch1ActionPerformed
    }//GEN-LAST:event_btnSearch1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CbCategory;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnHistory;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnSearch1;
    private javax.swing.JButton btnSearch2;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelOrderTable;
    private javax.swing.JLabel labelTotal;
    private javax.swing.JPanel panelMainProducts;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JTable tableOrder;
    private javax.swing.JTextField textNote;
    private javax.swing.JTextField textSearch;
    // End of variables declaration//GEN-END:variables

    String tableID;
    String tableName;
    String imagePath;
    String kitchenArea;
    String selectedCategory;

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
        Common.customizeTable(tableOrder, new int[]{1}, 30);
        Common.customizeScrollBar(scrollPane);
        Common.addPlaceholder(textNote, "Tối đa 60 ký tự");
        ColumnTable.setupButtonColumn(tableOrder, 2);

        // Setup
        displayTableName();
        displayOrderOfTable();
        setupComboboxCategory();

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

    // <--- Common 
    void displayTableName() {
        // Kiểm tra và gán giá trị 
        if (Auth.table != null && Auth.table.getTableID() != null) {
            tableID = Auth.table.getTableID();
        }

        if (Auth.table != null && Auth.table.getName() != null) {
            tableName = Auth.table.getName();
        }

        // Set case
        labelOrderTable.setText(tableID == null ? "ORDER [ Bàn Trống ]" : "ORDER [ " + tableName + " ]");
    }

    void displayOrderOfTable() {
        // Get order
        existingOrder = new OrderDAO().getByTableId(tableID);
        if (existingOrder == null) {
            return;
        }

        // Set text note
        String note = existingOrder.getNote();
        if (note.equals("")) {
            Common.addPlaceholder(textNote, "Tối đa 60 ký tự");
        } else {
            textNote.setText(note);
        }
    }

    void setupComboboxCategory() {
        // Get data all
        dataProducts = new ProductDAO().getAll();

        // Create a DefaultComboBoxModel 
        DefaultComboBoxModel<String> cbModelProducts = new DefaultComboBoxModel<>();
        cbModelProducts.addElement("Tất cả món");
        Set<String> categorySet = new HashSet<>();

        // Collect unique kitchen area
        for (ProductEntity dateItem : dataProducts) {
            categorySet.add(dateItem.getCategory());
        }

        // Convert the Set to an array
        String[] categoryList = categorySet.toArray(new String[categorySet.size()]);
        for (String categoryItem : categoryList) {
            cbModelProducts.addElement(categoryItem);
        }

        // Set the ComboBoxModel to the comboBox
        CbCategory.setModel(cbModelProducts);
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

        // Attach event comboBox
        ActionListener actionListener = (ActionEvent e) -> {
            loadDataByCriteria();
        };

        CbCategory.addActionListener(actionListener);
    }

    void loadDataByCriteria() {
        if (scheduledFuture != null && !scheduledFuture.isDone()) {
            scheduledFuture.cancel(false);
        }

        scheduledFuture = scheduledExecutorService.schedule(() -> {
            SwingUtilities.invokeLater(() -> {
                // Get category
                selectedCategory = (String) CbCategory.getSelectedItem();
                if (selectedCategory.equals("Tất cả món")) {
                    selectedCategory = "";
                }

                // Get search text
                String keyword = textSearch.getText().trim().replaceAll("\\s+", "");

                // Get data and display
                dataProductsByCategory = new ProductDAO().searchByCriteria(keyword, selectedCategory, "");
                displayProductList(dataProductsByCategory);
            });
        }, 300, TimeUnit.MILLISECONDS);
    }
    // end --->

    // <--- Display and handle events products
    void displayProductList(List<ProductEntity> dataList) {
        // Reset food list
        panelMainProducts.removeAll();
        panelMainProducts.setLayout(new GridBagLayout());

        // Init gridbag 
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 8, 16, 8);
        gbc.anchor = GridBagConstraints.NORTHWEST;

        int columnCount = 5;
        for (int i = 0; i < dataList.size(); i++) {
            // create panel product item
            ProductEntity dataItem = dataList.get(i);
            JPanel panelProduct = createPanelProduct(dataItem);

            // Tính toán vị trí dựa trên số cột
            gbc.gridx = i % columnCount;
            gbc.gridy = i / columnCount;

            panelMainProducts.add(panelProduct, gbc);
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

        // Update model
        saveOrder.addRow(new Object[]{
            product.getProductID(),
            product.getProductName(),
            1,
            formattedPrice
        });

    }

    void calculateTotalAmount() {
        long totalAmount = 0;
        DefaultTableModel model = (DefaultTableModel) tableOrder.getModel();

        for (int i = 0; i < model.getRowCount(); i++) {
            // Get price
            String id = model.getValueAt(i, 0).toString();
            ProductEntity product = new ProductDAO().getById(id);
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
        labelTotal.setText(formattedTotal + "₫");
    }

    // <--- Handle click button submit and cancel
    void cancel() {
        // Nếu bàn chưa chọn món thì rời đi luôn
        DefaultTableModel model = (DefaultTableModel) tableOrder.getModel();
        if (model.getRowCount() == 0) {
            mainStaff.displayStaffPanels(new TableOrder(mainStaff));
            return;
        }

        // Nếu bàn đã gọi món thì hỏi trước khi thoát
        Boolean result = Dialog.confirm(this, "Nếu thoát bạn sẽ mất các món ăn đã chọn?");
        if (result) {
            mainStaff.displayStaffPanels(new TableOrder(mainStaff));
        }
    }

    void submit() {
        if (labelOrderTable.getText().equals("ORDER [ Bàn Trống ]")) {
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
            existingOrder = new OrderDAO().getByTableId(tableID);
            if (existingOrder == null) {
                // Create new invoice
                int invoiceID = new InvoiceDAO().insert();

                // Create new order
                int orderId = new OrderDAO().insert(invoiceID, "Đang đặt hàng", "Tại nhà hàng");

                // Set status table
                dataTable = new DiningTableDAO().getById(tableID);
                dataTable.setStatus("Đang phục vụ");
                new DiningTableDAO().update(dataTable);

                // Set OrderTable
                new OrderTableDAO().insert(orderId, tableID, "Đang hoạt động");
            }

            // Get newly created order information and update note
            existingOrder = new OrderDAO().getByTableId(tableID);
            String note = Common.getRealText(textNote, "Tối đa 60 ký tự");
            if (note.length() > 60) {
                Dialog.warning(this, "Vui lòng nhập tối đa 60 ký tự!");
                return;
            }

            existingOrder.setNote(note);
            new OrderDAO().update(existingOrder);

            // Add product to the order
            addProductsToOrderd(existingOrder.getOrderId(), orderProducts);

            // Open file table
            mainStaff.displayStaffPanels(new TableOrder(mainStaff));
            System.out.println("Tạo đơn hàng thành công");
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
