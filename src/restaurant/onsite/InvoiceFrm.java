package restaurant.onsite;

import java.util.Map;
import java.util.List;
import java.util.HashMap;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import restaurant.dao.OrderDAO;
import restaurant.dao.InvoiceDAO;
import restaurant.dao.OrderDetailDAO;
import restaurant.entity.Order;
import restaurant.entity.Invoice;
import restaurant.entity.OrderDetail;

import restaurant.utils.Bill;
import restaurant.utils.Auth;
import restaurant.utils.Dialog;
import restaurant.utils.Common;
import restaurant.utils.Ordered;
import restaurant.utils.XTextField;

import restaurant.main.OnSiteMode;
import restaurant.table.TableCustom;
import restaurant.entity.DiningTable;
import restaurant.dialog.HistoryInvoicesJDialog;
import static restaurant.utils.XTextField.addCommasToNumber;
import static restaurant.utils.XRunnable.addTextFieldListeners;
import static restaurant.utils.XTextField.removeCommasFromNumber;

public final class InvoiceFrm extends javax.swing.JPanel {

    private final OnSiteMode onSite;

    public InvoiceFrm(OnSiteMode onSite) {
        initComponents();
        this.init();
        this.onSite = onSite;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableOrdered = new javax.swing.JTable();
        btnSearch2 = new javax.swing.JButton();
        labelOrderedTable = new javax.swing.JLabel();
        btnHistory = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        textSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        labelTotalPrice = new javax.swing.JLabel();
        labelTax = new javax.swing.JLabel();
        labelDiscount = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        labelTotalAmount = new javax.swing.JLabel();
        radioCash = new javax.swing.JRadioButton();
        radioCard = new javax.swing.JRadioButton();
        textGiveMoney = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        labelCashReturn = new javax.swing.JLabel();
        btnPay = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        btnCalc5 = new javax.swing.JButton();
        btnCalc4 = new javax.swing.JButton();
        btnCalc2 = new javax.swing.JButton();
        btnCalc3 = new javax.swing.JButton();
        btnCalc6 = new javax.swing.JButton();
        btnCalc7 = new javax.swing.JButton();
        btnCalc8 = new javax.swing.JButton();
        btnCalc1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        radioTransfer = new javax.swing.JRadioButton();
        labelInvoiceID = new javax.swing.JLabel();
        btnSearch1 = new javax.swing.JButton();

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setAutoscrolls(true);
        jPanel3.setPreferredSize(new java.awt.Dimension(860, 555));

        tableOrdered.setAutoCreateRowSorter(true);
        tableOrdered.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        tableOrdered.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên món", "Đơn giá", "Số lượng", "Tổng giá"
            }
        ));
        tableOrdered.setAlignmentX(2.0F);
        tableOrdered.setAlignmentY(2.0F);
        tableOrdered.setDoubleBuffered(true);
        tableOrdered.setDragEnabled(true);
        tableOrdered.setFillsViewportHeight(true);
        tableOrdered.setGridColor(new java.awt.Color(255, 255, 255));
        tableOrdered.setRowHeight(40);
        jScrollPane1.setViewportView(tableOrdered);

        btnSearch2.setBackground(new java.awt.Color(255, 51, 51));
        btnSearch2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSearch2.setForeground(new java.awt.Color(255, 255, 255));
        btnSearch2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/icon/cart-while-24px.png"))); // NOI18N
        btnSearch2.setToolTipText("Tìm kiếm");
        btnSearch2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        labelOrderedTable.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        labelOrderedTable.setForeground(new java.awt.Color(255, 51, 51));
        labelOrderedTable.setText("Các sản phẩm đã gọi");

        btnHistory.setBackground(new java.awt.Color(51, 204, 0));
        btnHistory.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnHistory.setForeground(new java.awt.Color(255, 255, 255));
        btnHistory.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/icon/historyWhile.png"))); // NOI18N
        btnHistory.setToolTipText("Xem lịch sử gọi món");
        btnHistory.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnReset.setBackground(new java.awt.Color(0, 153, 153));
        btnReset.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnReset.setForeground(new java.awt.Color(255, 255, 255));
        btnReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/icon/refreshWhile.png"))); // NOI18N
        btnReset.setToolTipText("Reset trang (Ctrl + F5)");
        btnReset.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        textSearch.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        btnSearch.setBackground(new java.awt.Color(255, 51, 51));
        btnSearch.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSearch.setForeground(new java.awt.Color(255, 255, 255));
        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/icon/searchWhile.png"))); // NOI18N
        btnSearch.setToolTipText("Tìm kiếm");
        btnSearch.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnSearch2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelOrderedTable)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 241, Short.MAX_VALUE)
                        .addComponent(textSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnHistory, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(labelOrderedTable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSearch2))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(textSearch, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnReset, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSearch, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnHistory, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 536, Short.MAX_VALUE)
                .addGap(12, 12, 12))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setPreferredSize(new java.awt.Dimension(420, 596));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Tổng tiền:");

        labelTotalPrice.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelTotalPrice.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelTotalPrice.setText("0");

        labelTax.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelTax.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelTax.setText("0");

        labelDiscount.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelDiscount.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelDiscount.setText("0");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("Giảm giá:");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(51, 51, 51));
        jLabel14.setText("Thuế:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("Khách cần trả:");

        labelTotalAmount.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        labelTotalAmount.setForeground(new java.awt.Color(255, 0, 0));
        labelTotalAmount.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelTotalAmount.setText("0");

        radioCash.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        radioCash.setSelected(true);
        radioCash.setText("Tiền mặt");

        radioCard.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        radioCard.setText("Thẻ");

        textGiveMoney.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        textGiveMoney.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        textGiveMoney.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 0, 0)));
        textGiveMoney.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        textGiveMoney.setMargin(new java.awt.Insets(20, 60, 2, 40));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 51, 51));
        jLabel10.setText("Khách thanh toán:");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(51, 51, 51));
        jLabel16.setText("Tiền thừa trả khách:");

        labelCashReturn.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        labelCashReturn.setForeground(new java.awt.Color(255, 0, 0));
        labelCashReturn.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelCashReturn.setText("0");

        btnPay.setBackground(new java.awt.Color(0, 153, 0));
        btnPay.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnPay.setForeground(new java.awt.Color(255, 255, 255));
        btnPay.setText("THANH TOÁN");
        btnPay.setToolTipText("Ấn để in hóa đơn");
        btnPay.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnCancel.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnCancel.setForeground(new java.awt.Color(51, 51, 51));
        btnCancel.setText("IN BILL");
        btnCancel.setToolTipText("Quay lại bàn ăn (F1)");
        btnCancel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnCalc5.setText("100,000");
        btnCalc5.setBorder(null);
        btnCalc5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalc5ActionPerformed(evt);
            }
        });

        btnCalc4.setText("50,000");
        btnCalc4.setBorder(null);
        btnCalc4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalc4ActionPerformed(evt);
            }
        });

        btnCalc2.setText("10,000");
        btnCalc2.setBorder(null);
        btnCalc2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalc2ActionPerformed(evt);
            }
        });

        btnCalc3.setText("20,000");
        btnCalc3.setBorder(null);
        btnCalc3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalc3ActionPerformed(evt);
            }
        });

        btnCalc6.setText("200,000");
        btnCalc6.setBorder(null);
        btnCalc6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalc6ActionPerformed(evt);
            }
        });

        btnCalc7.setText("300,000");
        btnCalc7.setBorder(null);
        btnCalc7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalc7ActionPerformed(evt);
            }
        });

        btnCalc8.setText("500.000");
        btnCalc8.setBorder(null);
        btnCalc8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalc8ActionPerformed(evt);
            }
        });

        btnCalc1.setText("10.000");
        btnCalc1.setBorder(null);
        btnCalc1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalc1ActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setPreferredSize(new java.awt.Dimension(251, 2));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 396, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );

        radioTransfer.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        radioTransfer.setText("Chuyển khoản");

        labelInvoiceID.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        labelInvoiceID.setForeground(new java.awt.Color(255, 51, 51));
        labelInvoiceID.setText("Hóa đơn [ Trống ]");

        btnSearch1.setBackground(new java.awt.Color(255, 51, 51));
        btnSearch1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSearch1.setForeground(new java.awt.Color(255, 255, 255));
        btnSearch1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/icon/cart-while-24px.png"))); // NOI18N
        btnSearch1.setToolTipText("Tìm kiếm");
        btnSearch1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 12, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btnSearch1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelInvoiceID, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(radioTransfer)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(18, 18, 18)
                                .addComponent(textGiveMoney, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(radioCash)
                                .addGap(91, 91, 91)
                                .addComponent(radioCard)
                                .addGap(182, 182, 182))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(148, 148, 148)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(labelTotalPrice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(labelTax, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(labelDiscount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(labelTotalAmount, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE))))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnPay, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnCalc5, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnCalc1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCalc6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCalc7, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCalc8, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(108, 108, 108)
                                .addComponent(btnCalc2, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCalc3, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCalc4, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addGap(113, 113, 113)
                        .addComponent(labelCashReturn, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labelInvoiceID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSearch1))
                .addGap(12, 12, 12)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(144, 144, 144)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelTotalPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelTax, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelDiscount, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labelTotalAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                    .addComponent(radioCard, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(radioTransfer, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(radioCash, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(textGiveMoney, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)))
                .addGap(15, 15, 15)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCashReturn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnCalc2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnCalc3, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnCalc4, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnCalc1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCalc6, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCalc7, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCalc5, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCalc8, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPay, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 824, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 602, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 602, Short.MAX_VALUE))
                .addContainerGap(12, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCalc5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalc5ActionPerformed
        textGiveMoney.setText("50,000");
        calculateCashReturn();
    }//GEN-LAST:event_btnCalc5ActionPerformed

    private void btnCalc4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalc4ActionPerformed
        textGiveMoney.setText("20,000");
        calculateCashReturn();
    }//GEN-LAST:event_btnCalc4ActionPerformed

    private void btnCalc2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalc2ActionPerformed
        textGiveMoney.setText("5,000");
        calculateCashReturn();
    }//GEN-LAST:event_btnCalc2ActionPerformed

    private void btnCalc3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalc3ActionPerformed
        textGiveMoney.setText("10,000");
        calculateCashReturn();
    }//GEN-LAST:event_btnCalc3ActionPerformed

    private void btnCalc6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalc6ActionPerformed
        textGiveMoney.setText("100,000");
        calculateCashReturn();
    }//GEN-LAST:event_btnCalc6ActionPerformed

    private void btnCalc7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalc7ActionPerformed
        textGiveMoney.setText("200,000");
        calculateCashReturn();
    }//GEN-LAST:event_btnCalc7ActionPerformed

    private void btnCalc8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalc8ActionPerformed
        textGiveMoney.setText("500,000");
        calculateCashReturn();
    }//GEN-LAST:event_btnCalc8ActionPerformed

    private void btnCalc1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalc1ActionPerformed
        textGiveMoney.setText(labelCashReturn.getText());
        calculateCashReturn();
    }//GEN-LAST:event_btnCalc1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCalc1;
    private javax.swing.JButton btnCalc2;
    private javax.swing.JButton btnCalc3;
    private javax.swing.JButton btnCalc4;
    private javax.swing.JButton btnCalc5;
    private javax.swing.JButton btnCalc6;
    private javax.swing.JButton btnCalc7;
    private javax.swing.JButton btnCalc8;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnHistory;
    private javax.swing.JButton btnPay;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnSearch1;
    private javax.swing.JButton btnSearch2;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelCashReturn;
    private javax.swing.JLabel labelDiscount;
    private javax.swing.JLabel labelInvoiceID;
    private javax.swing.JLabel labelOrderedTable;
    private javax.swing.JLabel labelTax;
    private javax.swing.JLabel labelTotalAmount;
    private javax.swing.JLabel labelTotalPrice;
    private javax.swing.JRadioButton radioCard;
    private javax.swing.JRadioButton radioCash;
    private javax.swing.JRadioButton radioTransfer;
    private javax.swing.JTable tableOrdered;
    private javax.swing.JTextField textGiveMoney;
    private javax.swing.JTextField textSearch;
    // End of variables declaration//GEN-END:variables

    final String PLACEHOLDER_SEARCH = "Tìm tên hoặc sđt khách hàng";

    void init() {
        // <--- Setup common --->
        TableCustom.apply(jScrollPane1, TableCustom.TableType.MULTI_LINE);
        Common.customizeTable(tableOrdered, new int[]{}, 30);
        Common.createButtonGroup(radioCash, radioCard, radioTransfer);
        XTextField.addPlaceholder(textSearch, PLACEHOLDER_SEARCH);

        // <--- Setup main --->
        // set info
        displayTableInfo(Auth.table);
        displayInvoiceInfo(Auth.invoice);

        // calc return cash
        addTextFieldListeners(textGiveMoney, this::calculateCashReturn);

        // display product list to table
        displayOrderedOfTable(Auth.table, tableOrdered);

        // handle click button history and reset
        btnReset.addActionListener(e -> onSite.displayOnSitePanel(new InvoiceFrm(onSite)));
        btnHistory.addActionListener(e -> {
            new HistoryInvoicesJDialog(null, true).setVisible(true);
        });
        btnPay.addActionListener(e -> pay());

        // hanlde click button calc
        handleClickButtonsCalc();

    }

    void handleClickButtonsCalc() {
        btnCalc1.addActionListener(e -> {
            textGiveMoney.setText(labelCashReturn.getText());
            calculateCashReturn();
        });
        btnCalc2.addActionListener(e -> {
            textGiveMoney.setText("10,000");
            calculateCashReturn();
        });
        btnCalc3.addActionListener(e -> {
            textGiveMoney.setText("20,000");
            calculateCashReturn();
        });
        btnCalc4.addActionListener(e -> {
            textGiveMoney.setText("50,000");
            calculateCashReturn();
        });
        btnCalc5.addActionListener(e -> {
            textGiveMoney.setText("100,000");
            calculateCashReturn();
        });
        btnCalc6.addActionListener(e -> {
            textGiveMoney.setText("200,000");
            calculateCashReturn();
        });
        btnCalc7.addActionListener(e -> {
            textGiveMoney.setText("300,000");
            calculateCashReturn();
        });
        btnCalc8.addActionListener(e -> {
            textGiveMoney.setText("500,000");
            calculateCashReturn();
        });

    }

    void displayTableInfo(DiningTable table) {
        if (table == null) {
            return;
        }

        // Kiểm tra và gán giá trị 
        String tableID = table.getTableID();
        String tableName = table.getName();

        // Set label
        labelOrderedTable.setText(tableID == null
                ? "Các món đã gọi [ Bàn Trống ]"
                : "Các món đã gọi [ " + tableName + " ]");
    }

    void displayInvoiceInfo(Invoice invoice) {
        if (invoice == null) {
            return;
        }

        // Get invoice id
        int invoiceID = invoice.getInvoiceID();

        // Set label
        labelInvoiceID.setText(String.valueOf(invoiceID).equals("")
                ? "Hóa đơn [ Trống ]"
                : "Hóa đơn [ " + invoiceID + " ]");
    }

    void calculateCashReturn() {
        String giveMoneyText = removeCommasFromNumber(textGiveMoney.getText());
        String totalAmountText = removeCommasFromNumber(labelTotalAmount.getText());
        if (giveMoneyText.isEmpty() || totalAmountText.isEmpty()) {
            return;
        }

        // Parse strings to integers only after checking for emptiness
        int giveMoney = Integer.parseInt(giveMoneyText);
        int totalAmount = Integer.parseInt(totalAmountText);

        if (giveMoney >= totalAmount) {
            String cashReurn = addCommasToNumber(String.valueOf(giveMoney - totalAmount));
            labelCashReturn.setText(cashReurn);
        } else {
            labelCashReturn.setText(" ");
        }
    }

    public void displayOrderedOfTable(DiningTable dataTable, JTable table) {
        if (dataTable == null || table == null) {
            return;
        }

        // Reset table
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);

        try {
            // Get data order
            String tableID = dataTable.getTableID();
            Order dataOrder = new OrderDAO().getByTableID(tableID);

            // Get order deatails
            List<OrderDetail> dataOrderDetails
                    = new OrderDetailDAO().getByOrderID(dataOrder.getOrderId());

            // Set total 
            long totalAmount = dataOrder.getTotal();
            String totalConvert = addCommasToNumber(String.valueOf(totalAmount));
            labelTotalPrice.setText(totalConvert);
            labelTotalAmount.setText(totalConvert);

            // Create a map to store the quantity and price of each item
            Map<String, Long> productPriceMap = new HashMap<>();
            Map<String, Integer> productQuantityMap = new HashMap<>();

            // Init process ---> Add products into the table
            Ordered.processOrderedDetails(dataOrderDetails, productPriceMap, productQuantityMap);
            Ordered.addOrderedToTable(model, productPriceMap, productQuantityMap);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    Invoice getModel() {
        if (!isModel()) {
            return null;
        }

        // get info
        int tax = Integer.parseInt(removeCommasFromNumber(labelTax.getText()));
        int discount = Integer.parseInt(removeCommasFromNumber(labelDiscount.getText()));
        String methodPay = radioCash.isSelected()
                ? "Tiền mặt" : radioCard.isSelected()
                ? "Thẻ" : "Chuyển khoản";
        int total = Integer.parseInt(removeCommasFromNumber(labelTotalAmount.getText()));
        int totalAmount = total + tax - discount;

        Invoice model = new Invoice();
        model.setInvoiceID(Auth.invoice.getInvoiceID());
        model.setEmployeeID(Auth.user.getEmployeeID());
        model.setTax(tax);
        model.setDiscount(discount);
        model.setPaymentMethod(methodPay);
        model.setNote("");
        model.setTotalAmount(totalAmount);
        model.setStatus("Đã thanh toán");

        return model;
    }

    boolean isModel() {
        if (Auth.invoice == null) {
            Dialog.warning(this, "Vui lòng chọn bàn đã gọi món!");
            return false;
        }

        if (!Auth.isManager() || Auth.user == null) {
            Dialog.warning(this, "Bạn không có quyền thanh toán!");
            return false;
        }

        if (textGiveMoney.getText().trim().equals("")) {
            Dialog.warning(this, "Vui lòng nhập số tiền khách đưa!");
            return false;
        }

        return true;
    }

    void pay() {
        Invoice model = getModel();
        if (model == null) {
            return;
        }

        try {
            // update status invoice pay
            new InvoiceDAO().update(getModel());

            // println bill
            Bill.billInvoice(Auth.invoice);

            // move file table
            onSite.displayOnSitePanel(new DiningTableFrm(onSite));
        } catch (Exception e) {
            System.out.println(e);
            Dialog.success(this, "Thanh toán không thành công!");
        }
    }

}
