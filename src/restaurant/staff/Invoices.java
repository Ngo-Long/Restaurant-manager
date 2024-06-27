package restaurant.staff;

import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

import java.sql.SQLException;
import javax.swing.Timer;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;

import restaurant.dao.OrderDAO;
import restaurant.dao.InvoiceDAO;
import restaurant.dao.OrderDetailDAO;
import restaurant.entity.OrderEntity;
import restaurant.entity.InvoiceEntity;
import restaurant.entity.OrderDetailEntity;

import restaurant.utils.JDBC;
import restaurant.utils.Auth;
import restaurant.utils.Dialog;
import restaurant.utils.Common;
import restaurant.utils.Ordered;
import restaurant.main.MainStaff;
import restaurant.table.TableCustom;
import restaurant.dialog.HistoryInvoicesJDialog;
import static restaurant.utils.Common.addCommasToNumber;
import static restaurant.utils.Common.removeCommasFromNumber;

import net.sf.jasperreports.view.JasperViewer;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperCompileManager;

public class Invoices extends javax.swing.JPanel {

    private MainStaff mainStaff;

    public Invoices(MainStaff mainStaff) {
        initComponents();
        this.init();
        this.mainStaff = mainStaff;
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
        btnSearch3 = new javax.swing.JButton();
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
        btnPayInvoice = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        btnFiftyThousand = new javax.swing.JButton();
        btnTwentyThousand = new javax.swing.JButton();
        btnFiveThousand = new javax.swing.JButton();
        btnTenThousand = new javax.swing.JButton();
        btnHundredThousand = new javax.swing.JButton();
        btnTwoHundredThousand = new javax.swing.JButton();
        btnFiveHundredThousand = new javax.swing.JButton();
        btnTwoThousand = new javax.swing.JButton();
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
        btnSearch2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearch2ActionPerformed(evt);
            }
        });

        labelOrderedTable.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        labelOrderedTable.setForeground(new java.awt.Color(255, 51, 51));
        labelOrderedTable.setText("Các sản phẩm đã gọi");

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

        btnSearch3.setBackground(new java.awt.Color(0, 153, 153));
        btnSearch3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSearch3.setForeground(new java.awt.Color(255, 255, 255));
        btnSearch3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/icon/refreshWhile.png"))); // NOI18N
        btnSearch3.setToolTipText("Reset trang (Ctrl + F5)");
        btnSearch3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSearch3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearch3ActionPerformed(evt);
            }
        });

        textSearch.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textSearchActionPerformed(evt);
            }
        });

        btnSearch.setBackground(new java.awt.Color(255, 51, 51));
        btnSearch.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSearch.setForeground(new java.awt.Color(255, 255, 255));
        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/icon/searchWhile.png"))); // NOI18N
        btnSearch.setToolTipText("Tìm kiếm");
        btnSearch.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

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
                        .addComponent(btnSearch3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                        .addComponent(btnSearch3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                        .addComponent(btnSearch, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnHistory, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1)
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
        textGiveMoney.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textGiveMoneyActionPerformed(evt);
            }
        });

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

        btnPayInvoice.setBackground(new java.awt.Color(0, 153, 0));
        btnPayInvoice.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnPayInvoice.setForeground(new java.awt.Color(255, 255, 255));
        btnPayInvoice.setText("THANH TOÁN");
        btnPayInvoice.setToolTipText("Ấn để in hóa đơn");
        btnPayInvoice.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPayInvoice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPayInvoiceActionPerformed(evt);
            }
        });

        btnCancel.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnCancel.setForeground(new java.awt.Color(51, 51, 51));
        btnCancel.setText("IN BILL");
        btnCancel.setToolTipText("Quay lại bàn ăn (F1)");
        btnCancel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btnFiftyThousand.setText("50.000");
        btnFiftyThousand.setBorder(null);
        btnFiftyThousand.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiftyThousandActionPerformed(evt);
            }
        });

        btnTwentyThousand.setText("20.000");
        btnTwentyThousand.setBorder(null);
        btnTwentyThousand.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTwentyThousandActionPerformed(evt);
            }
        });

        btnFiveThousand.setText("5.000");
        btnFiveThousand.setBorder(null);
        btnFiveThousand.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiveThousandActionPerformed(evt);
            }
        });

        btnTenThousand.setText("10.000");
        btnTenThousand.setBorder(null);
        btnTenThousand.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTenThousandActionPerformed(evt);
            }
        });

        btnHundredThousand.setText("100.000");
        btnHundredThousand.setBorder(null);
        btnHundredThousand.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHundredThousandActionPerformed(evt);
            }
        });

        btnTwoHundredThousand.setText("200.000");
        btnTwoHundredThousand.setBorder(null);
        btnTwoHundredThousand.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTwoHundredThousandActionPerformed(evt);
            }
        });

        btnFiveHundredThousand.setText("500.000");
        btnFiveHundredThousand.setBorder(null);
        btnFiveHundredThousand.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiveHundredThousandActionPerformed(evt);
            }
        });

        btnTwoThousand.setText("2.000");
        btnTwoThousand.setBorder(null);
        btnTwoThousand.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTwoThousandActionPerformed(evt);
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
        btnSearch1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearch1ActionPerformed(evt);
            }
        });

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
                                .addComponent(btnPayInvoice, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnFiftyThousand, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnTwoThousand, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnHundredThousand, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnTwoHundredThousand, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnFiveHundredThousand, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(108, 108, 108)
                                .addComponent(btnFiveThousand, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnTenThousand, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnTwentyThousand, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))))
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
                    .addComponent(btnFiveThousand, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnTenThousand, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnTwentyThousand, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnTwoThousand, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnHundredThousand, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTwoHundredThousand, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFiftyThousand, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFiveHundredThousand, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPayInvoice, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 596, Short.MAX_VALUE))
                .addContainerGap(12, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void textGiveMoneyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textGiveMoneyActionPerformed

    }//GEN-LAST:event_textGiveMoneyActionPerformed

    private void btnPayInvoiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPayInvoiceActionPerformed
        pay();
    }//GEN-LAST:event_btnPayInvoiceActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        mainStaff.displayStaffPanels(new DiningTable(mainStaff));
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnFiftyThousandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiftyThousandActionPerformed
        textGiveMoney.setText("50,000");
        calculateCashReturn();
    }//GEN-LAST:event_btnFiftyThousandActionPerformed

    private void btnTwentyThousandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTwentyThousandActionPerformed
        textGiveMoney.setText("20,000");
        calculateCashReturn();
    }//GEN-LAST:event_btnTwentyThousandActionPerformed

    private void btnFiveThousandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiveThousandActionPerformed
        textGiveMoney.setText("5,000");
        calculateCashReturn();
    }//GEN-LAST:event_btnFiveThousandActionPerformed

    private void btnTenThousandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTenThousandActionPerformed
        textGiveMoney.setText("  10,000");
        calculateCashReturn();
    }//GEN-LAST:event_btnTenThousandActionPerformed

    private void btnHundredThousandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHundredThousandActionPerformed
        textGiveMoney.setText("100,000");
        calculateCashReturn();
    }//GEN-LAST:event_btnHundredThousandActionPerformed

    private void btnTwoHundredThousandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTwoHundredThousandActionPerformed
        textGiveMoney.setText("200,000");
        calculateCashReturn();
    }//GEN-LAST:event_btnTwoHundredThousandActionPerformed

    private void btnFiveHundredThousandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiveHundredThousandActionPerformed
        textGiveMoney.setText("500,000");
        calculateCashReturn();
    }//GEN-LAST:event_btnFiveHundredThousandActionPerformed

    private void btnTwoThousandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTwoThousandActionPerformed
        textGiveMoney.setText("2,000");
        calculateCashReturn();
    }//GEN-LAST:event_btnTwoThousandActionPerformed

    private void btnSearch1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearch1ActionPerformed

    }//GEN-LAST:event_btnSearch1ActionPerformed

    private void btnSearch2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearch2ActionPerformed

    }//GEN-LAST:event_btnSearch2ActionPerformed

    private void btnHistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHistoryActionPerformed
        new HistoryInvoicesJDialog(null, true).setVisible(true);
    }//GEN-LAST:event_btnHistoryActionPerformed

    private void btnSearch3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearch3ActionPerformed
        mainStaff.displayStaffPanels(new Invoices(mainStaff));
    }//GEN-LAST:event_btnSearch3ActionPerformed

    private void textSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textSearchActionPerformed

    }//GEN-LAST:event_textSearchActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed

    }//GEN-LAST:event_btnSearchActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnFiftyThousand;
    private javax.swing.JButton btnFiveHundredThousand;
    private javax.swing.JButton btnFiveThousand;
    private javax.swing.JButton btnHistory;
    private javax.swing.JButton btnHundredThousand;
    private javax.swing.JButton btnPayInvoice;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnSearch1;
    private javax.swing.JButton btnSearch2;
    private javax.swing.JButton btnSearch3;
    private javax.swing.JButton btnTenThousand;
    private javax.swing.JButton btnTwentyThousand;
    private javax.swing.JButton btnTwoHundredThousand;
    private javax.swing.JButton btnTwoThousand;
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

    Timer timer;
    int index = 0;
    int invoiceID;
    String tableID;
    String tableName;
    String methodPay;
    OrderEntity dataOrder;
    InvoiceEntity dataInvoice;
    List<OrderDetailEntity> dataOrderDetails;
    final String PLACEHOLDER = "Tìm tên hoặc sđt khách hàng";
    ExecutorService executorService = Executors.newFixedThreadPool(10);

    void init() {
        // Setup common
        TableCustom.apply(jScrollPane1, TableCustom.TableType.MULTI_LINE);
        Common.customizeTable(tableOrdered, new int[]{0, 1, 2, 3}, 30);
        Common.createButtonGroup(radioCash, radioCard, radioTransfer);
        Common.addPlaceholder(textSearch, PLACEHOLDER);

        // Setup main
        displayTableInfo();
        displayInvoiceInfo();

        initEventCashReturn();
        displayOrderedOfTable(tableID);
    }

    void displayTableInfo() {
        // Kiểm tra và gán giá trị 
        if (Auth.table != null && Auth.table.getTableID() != null) {
            tableID = Auth.table.getTableID();
        }

        if (Auth.table != null && Auth.table.getName() != null) {
            tableName = Auth.table.getName();
        }

        // Set label
        labelOrderedTable.setText(tableID == null
                ? "Các món đã gọi [ Bàn Trống ]"
                : "Các món đã gọi [ " + tableName + " ]");
    }

    void displayInvoiceInfo() {
        try {
            // Get data invoice 
            dataInvoice = new InvoiceDAO().getByTableID(tableID);

            // Get invoice id
            invoiceID = dataInvoice.getInvoiceID();

            // Set label
            labelInvoiceID.setText(String.valueOf(invoiceID).equals("")
                    ? "Hóa đơn [ Trống ]"
                    : "Hóa đơn [ " + invoiceID + " ]");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    void initEventCashReturn() {
        // Attach event textSearch
        textGiveMoney.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                calculateCashReturn();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                calculateCashReturn();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                calculateCashReturn();
            }
        });
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

    public void displayOrderedOfTable(String tableID) {
        // Reset table
        DefaultTableModel model = (DefaultTableModel) tableOrdered.getModel();
        model.setRowCount(0);

        try {
            // Get data order and order deatails
            dataOrder = new OrderDAO().getByTableId(tableID);
            dataOrderDetails = new OrderDetailDAO().getByOrderId(dataOrder.getOrderId());

            // Set total 
            String totalConvert = addCommasToNumber(String.valueOf(dataOrder.getTotal()));
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

    InvoiceEntity getModel() {
        int tax = Integer.parseInt(removeCommasFromNumber(labelTax.getText()));
        int discount = Integer.parseInt(removeCommasFromNumber(labelDiscount.getText()));
        methodPay = radioCash.isSelected() ? "Tiền mặt" : radioCard.isSelected() ? "Thẻ" : "Chuyển khoản";
        int total = Integer.parseInt(removeCommasFromNumber(labelTotalAmount.getText()));
        int totalAmount = total + tax - discount;

        if (invoiceID == 0) {
            Dialog.warning(this, "Vui lòng chọn bàn đã gọi món!");
            return null;
        }

        if (!Auth.isManager()) {
            Dialog.warning(this, "Bạn không có quyền thanh toán!");
            return null;
        }

        if (textGiveMoney.getText().trim().equals("")) {
            Dialog.warning(this, "Vui lòng nhập số tiền khách đưa!");
            return null;
        }

        InvoiceEntity model = new InvoiceEntity();
        model.setInvoiceID(invoiceID);
        model.setEmployeeID(Auth.user.getEmployeeID());
        model.setTax(tax);
        model.setDiscount(discount);
        model.setPaymentMethod(methodPay);
        model.setNote("");
        model.setTotalAmount(totalAmount);
        model.setStatus("Đã thanh toán");

        return model;
    }

    void pay() {
        InvoiceEntity model = getModel();
        if (model == null) {
            return;
        }

        try {
            // Update invoice successfully
            new InvoiceDAO().update(getModel());

            // Open bill
            // bill();
            // Update status
            Dialog.success(this, "Thanh toán thành công!");
            mainStaff.displayStaffPanels(new DiningTable(mainStaff));
        } catch (Exception e) {
            Dialog.success(this, "Thanh toán không thành công!");
        }
    }

    void bill() {
        try {
            // Create map contains the parameters and values ​​of the report
            Hashtable<String, Object> map = new Hashtable<>();
            map.put("ToInvoiceID", invoiceID);

            // Compile files report
            JasperReport report = JasperCompileManager.compileReport("src/restaurant/report/reportInvoice.jrxml");
            JasperPrint p = JasperFillManager.fillReport(report, map, JDBC.getConnection());

            // Hiển thị JasperViewer
            JasperViewer viewer = new JasperViewer(p, false);
            viewer.setVisible(true);
        } catch (SQLException | JRException e) {
            e.printStackTrace();
        }
    }

}
