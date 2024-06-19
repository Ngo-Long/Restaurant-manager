package restaurant.staff;

import java.util.Map;
import java.util.Date;
import java.util.List;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.FileOutputStream;

import java.awt.Desktop;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import javax.swing.Timer;
import javax.swing.JFileChooser;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;

import restaurant.dao.OrderDAO;
import restaurant.dao.InvoiceDAO;
import restaurant.dao.OrderDetailDAO;
import restaurant.dao.DiningTableDAO;

import restaurant.entity.OrderEntity;
import restaurant.entity.InvoiceEntity;
import restaurant.entity.DiningTableEntity;
import restaurant.entity.OrderDetailEntity;

import restaurant.utils.JDBC;
import restaurant.utils.Auth;
import restaurant.utils.Dialog;
import restaurant.utils.Common;
import restaurant.utils.Ordered;
import restaurant.main.MainStaff;
import static restaurant.utils.Common.addCommasToNumber;
import static restaurant.utils.Common.calculateTimeRemaining;
import static restaurant.utils.Common.removeCommasFromNumber;

import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.view.JasperViewer;

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
        tabbedPanePay = new javax.swing.JTabbedPane();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableOrderDetails = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableUnpaidInvoices = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tableAllOfInvoices = new javax.swing.JTable();
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
        labelOrderTable = new javax.swing.JLabel();
        btnSearch1 = new javax.swing.JButton();

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

        tableOrderDetails.setAutoCreateRowSorter(true);
        tableOrderDetails.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        tableOrderDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên món", "Đơn giá", "Số lượng", "Tổng giá"
            }
        ));
        tableOrderDetails.setAlignmentX(2.0F);
        tableOrderDetails.setAlignmentY(2.0F);
        tableOrderDetails.setDoubleBuffered(true);
        tableOrderDetails.setDragEnabled(true);
        tableOrderDetails.setFillsViewportHeight(true);
        tableOrderDetails.setGridColor(new java.awt.Color(255, 255, 255));
        tableOrderDetails.setRowHeight(40);
        jScrollPane1.setViewportView(tableOrderDetails);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 824, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 548, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        tabbedPanePay.addTab("THANH TOÁN ", new javax.swing.ImageIcon(getClass().getResource("/icon/cash-machine.png")), jPanel5); // NOI18N

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        tableUnpaidInvoices.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        tableUnpaidInvoices.setForeground(new java.awt.Color(51, 51, 51));
        tableUnpaidInvoices.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Đơn hàng", "Tên bàn", "Tổng tiền", "Trạng thái", "Thời gian đợi"
            }
        ));
        tableUnpaidInvoices.setAlignmentX(2.0F);
        tableUnpaidInvoices.setAlignmentY(2.0F);
        tableUnpaidInvoices.setFillsViewportHeight(true);
        tableUnpaidInvoices.setGridColor(new java.awt.Color(255, 255, 255));
        tableUnpaidInvoices.setRowHeight(40);
        tableUnpaidInvoices.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableUnpaidInvoicesMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tableUnpaidInvoices);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 824, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 549, Short.MAX_VALUE)
        );

        tabbedPanePay.addTab("CHỜ THANH TOÁN ", new javax.swing.ImageIcon(getClass().getResource("/icon/pay-later.png")), jPanel6); // NOI18N

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        tableAllOfInvoices.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        tableAllOfInvoices.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Hóa đơn", "Tên bàn", "Tổng tiền", "Trạng thái", "Thời gian"
            }
        ));
        tableAllOfInvoices.setAlignmentX(2.0F);
        tableAllOfInvoices.setAlignmentY(2.0F);
        tableAllOfInvoices.setFillsViewportHeight(true);
        tableAllOfInvoices.setGridColor(new java.awt.Color(255, 255, 255));
        tableAllOfInvoices.setRowHeight(40);
        jScrollPane4.setViewportView(tableAllOfInvoices);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 824, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 548, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        tabbedPanePay.addTab("LỊCH SỬ ", new javax.swing.ImageIcon(getClass().getResource("/icon/history.png")), jPanel8); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(tabbedPanePay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabbedPanePay)
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Tổng tiền:");

        labelTotalPrice.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelTotalPrice.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelTotalPrice.setText("20,000");

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
        labelTotalAmount.setText("20,000");

        radioCash.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        radioCash.setSelected(true);
        radioCash.setText("Tiền mặt");

        radioCard.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        radioCard.setText("Thẻ");

        textGiveMoney.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        textGiveMoney.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        textGiveMoney.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 0, 0)));
        textGiveMoney.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        textGiveMoney.setMargin(new java.awt.Insets(2, 60, 2, 6));
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
        labelCashReturn.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelCashReturn.setText("0");

        btnPayInvoice.setBackground(new java.awt.Color(0, 153, 0));
        btnPayInvoice.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnPayInvoice.setForeground(new java.awt.Color(255, 255, 255));
        btnPayInvoice.setText("THANH TOÁN");
        btnPayInvoice.setToolTipText("Ấn để in hóa đơn");
        btnPayInvoice.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPayInvoice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPayInvoiceActionPerformed(evt);
            }
        });

        btnCancel.setBackground(new java.awt.Color(225, 0, 0));
        btnCancel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnCancel.setForeground(new java.awt.Color(255, 255, 255));
        btnCancel.setText("HỦY");
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

        labelOrderTable.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        labelOrderTable.setForeground(new java.awt.Color(255, 51, 51));
        labelOrderTable.setText("PAY");

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
                        .addComponent(labelOrderTable, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                                .addGap(195, 195, 195)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(labelTax, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelTotalPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelDiscount, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelTotalAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(304, 304, 304)
                                .addComponent(labelCashReturn, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnPayInvoice, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnTwoThousand, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnFiftyThousand, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnHundredThousand, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnTwoHundredThousand, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnFiveHundredThousand, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addGap(108, 108, 108)
                            .addComponent(btnFiveThousand, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btnTenThousand, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btnTwentyThousand, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel16))
                .addGap(12, 12, 12))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labelOrderTable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnFiveThousand, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnTenThousand, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnTwentyThousand, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnTwoThousand, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnHundredThousand, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTwoHundredThousand, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFiftyThousand, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFiveHundredThousand, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 826, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 594, Short.MAX_VALUE))
                .addContainerGap(14, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tableUnpaidInvoicesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableUnpaidInvoicesMouseClicked
        handleClickTable(evt);
    }//GEN-LAST:event_tableUnpaidInvoicesMouseClicked

    private void textGiveMoneyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textGiveMoneyActionPerformed

    }//GEN-LAST:event_textGiveMoneyActionPerformed

    private void btnPayInvoiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPayInvoiceActionPerformed
        pay();
    }//GEN-LAST:event_btnPayInvoiceActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        mainStaff.displayStaffPanels(new OrderTables(mainStaff));
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnFiftyThousand;
    private javax.swing.JButton btnFiveHundredThousand;
    private javax.swing.JButton btnFiveThousand;
    private javax.swing.JButton btnHundredThousand;
    private javax.swing.JButton btnPayInvoice;
    private javax.swing.JButton btnSearch1;
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
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel labelCashReturn;
    private javax.swing.JLabel labelDiscount;
    private javax.swing.JLabel labelOrderTable;
    private javax.swing.JLabel labelTax;
    private javax.swing.JLabel labelTotalAmount;
    private javax.swing.JLabel labelTotalPrice;
    private javax.swing.JRadioButton radioCard;
    private javax.swing.JRadioButton radioCash;
    private javax.swing.JRadioButton radioTransfer;
    private javax.swing.JTabbedPane tabbedPanePay;
    private javax.swing.JTable tableAllOfInvoices;
    private javax.swing.JTable tableOrderDetails;
    private javax.swing.JTable tableUnpaidInvoices;
    private javax.swing.JTextField textGiveMoney;
    // End of variables declaration//GEN-END:variables

    Timer timer;
    int index = 0;
    int invoiceId;
    String tableID;
    String tableName;
    String methodPay;
    OrderEntity dataOrder;
    List<OrderDetailEntity> dataOrderDetails;
    ExecutorService executorService = Executors.newFixedThreadPool(10);

    void init() {
        Common.customizeTable(tableUnpaidInvoices, new int[]{});
        Common.customizeTable(tableAllOfInvoices, new int[]{});
        Common.customizeTable(tableOrderDetails, new int[]{0});
        Common.createButtonGroup(radioCash, radioCard, radioTransfer);

        displayPayTable();
        displayOrderDetails(tableID);
        displayProductsOfTable();
    }

    void displayPayTable() {
        // Kiểm tra và gán giá trị 
        if (Auth.table != null && Auth.table.getTableID() != null) {
            tableID = Auth.table.getTableID();
        }

        if (Auth.table != null && Auth.table.getName() != null) {
            tableName = Auth.table.getName();
        }

        // Set case
        labelOrderTable.setText(tableID == null ? "PAY [ Bàn Trống ]" : "PAY [ " + tableName + " ]");
    }

    InvoiceEntity getModel() {
        int tax = Integer.parseInt(removeCommasFromNumber(labelTax.getText()));
        int discount = Integer.parseInt(removeCommasFromNumber(labelDiscount.getText()));
        methodPay = radioCash.isSelected() ? "Tiền mặt" : radioCard.isSelected() ? "Thẻ" : "Chuyển khoản";
        int total = Integer.parseInt(removeCommasFromNumber(labelTotalAmount.getText()));
        int totalAmount = total + tax - discount;

        if (invoiceId == 0) {
            Dialog.warning(this, "Vui lòng chọn bàn đã gọi món!");
            return null;
        }

        if (!Auth.isManager()) {
            Dialog.warning(this, "Bạn không có quyền thanh toán!");
            return null;
        }

        if (textGiveMoney.getText().equals("")) {
            Dialog.warning(this, "Vui lòng nhập số tiền khách đưa!");
            return null;
        }

        InvoiceEntity model = new InvoiceEntity();
        model.setInvoiceID(invoiceId);
        model.setEmployeeID(Auth.user.getEmployeeID());
        model.setTax(tax);
        model.setDiscount(discount);
        model.setPaymentMethod(methodPay);
        model.setNote("");
        model.setTotalAmount(totalAmount);
        model.setStatus("Đã thanh toán");

        return model;
    }

    void bill() {
        try {
            // Create map contains the parameters and values ​​of the report
            Hashtable<String, Object> map = new Hashtable<>();
            map.put("ToInvoiceID", invoiceId);

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

    void pay() {
        InvoiceEntity model = getModel();
        if (model == null) {
            return;
        }

        try {
            // Update invoice successfully
            new InvoiceDAO().update(getModel());

            // Update status order successfully
            OrderEntity ordered = new OrderDAO().getByInvoiceId(invoiceId);
            ordered.setStatus("Đã thanh toán");
            new OrderDAO().update(ordered);

            // Open bill
            bill();

            // Update status
            Dialog.success(this, "Đã thanh toán!");
            mainStaff.displayStaffPanels(new OrderTables(mainStaff));
        } catch (Exception e) {
            Dialog.success(this, "Thanh toán không thành công!");
        }
    }

    void calculateCashReturn() {
        textGiveMoney.addActionListener(e -> {
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
                labelCashReturn.setText("-1");
            }
        });
    }

    void displayOrderDetails(String tableId) {
        // Reset table
        DefaultTableModel model = (DefaultTableModel) tableOrderDetails.getModel();
        model.setRowCount(0);

        // Get info detail order through dining table id
        dataOrder = new OrderDAO().getByTableId(tableId);
        dataOrderDetails = new OrderDetailDAO().getByOrderId(dataOrder.getOrderId());

        if (dataOrder == null || dataOrderDetails == null) {
            labelTotalPrice.setText("0");
            labelTotalAmount.setText("0");
            return;
        }

        // Display total - Tổng cộng: 100.000₫ 
        String totalConvert = addCommasToNumber(String.valueOf(dataOrder.getTotal()));
        labelTotalPrice.setText(totalConvert);
        labelTotalAmount.setText(totalConvert);

        // Create a Map để lưu trữ số lượng và giá của mỗi món
        Map<String, Integer> productPriceMap = new HashMap<>();
        Map<String, Integer> productQuantityMap = new HashMap<>();

        // Init process ---> Add products into the table
        Ordered.processOrderedDetails(dataOrderDetails, productPriceMap, productQuantityMap);
        Ordered.addOrderedToTable(model, productPriceMap, productQuantityMap);
    }

    void displayProductsOfTable() {
        // Fetch pending and confirmed products
        List<InvoiceEntity> pendingInvoices = new InvoiceDAO().getAllUnPaid();
        List<InvoiceEntity> confirmedInvoices = new InvoiceDAO().getAll();

        // Get model
        DefaultTableModel modelPending = (DefaultTableModel) tableUnpaidInvoices.getModel();
        DefaultTableModel modelConfirmed = (DefaultTableModel) tableAllOfInvoices.getModel();

        // Prepare data for pending and confirmed products table
        displayUnpaidInvoices(modelPending, pendingInvoices);
        displayAllOfInvoices(modelConfirmed, confirmedInvoices);

        // Đặt model cho bảng 
        tableUnpaidInvoices.setModel(modelPending);
        tableAllOfInvoices.setModel(modelConfirmed);
    }

    void displayUnpaidInvoices(DefaultTableModel modelPending, List<InvoiceEntity> pendingInvoices) {
        // Sắp xếp theo thời gian kết thúc từ gần nhất
        Collections.sort(pendingInvoices, (invoice1, invoice2)
                -> invoice1.getPaymentTime().compareTo(invoice2.getPaymentTime())
        );

        // Get data from list Confirmed invoices in model
        for (InvoiceEntity invoice : pendingInvoices) {
            // Get id invoice
            int invoiceId = invoice.getInvoiceID();
            String status = invoice.getStatus();

            // Get info ordered
            OrderEntity order = new OrderDAO().getByInvoiceId(invoiceId);
            int orderId = order.getOrderId();

            // Get start time ordered
            Date orderTime = order.getCreatedDate();
            String orderTimeFormat = calculateTimeRemaining(orderTime);

            // Get total amount ordered
            long totalAmount = order.getTotal();
            String totalAmountConvert = addCommasToNumber(String.valueOf(totalAmount)) + " ₫";

            // Get name table 
            DiningTableEntity dataTable = new DiningTableDAO().getByInvoiceId(invoiceId);
            String tableName = dataTable.getName();

            // Add add info on table invoice
            modelPending.addRow(new Object[]{
                orderId,
                tableName,
                totalAmountConvert,
                status,
                orderTimeFormat
            });
        }
    }

    void displayAllOfInvoices(DefaultTableModel modelConfirmed, List<InvoiceEntity> confirmedInvoices) {
        // Sắp xếp theo thời gian kết thúc từ gần nhất
        Collections.sort(confirmedInvoices, (invoice1, invoice2)
                -> invoice2.getPaymentTime().compareTo(invoice1.getPaymentTime())
        );

        // Get data from list Confirmed products in model
        for (InvoiceEntity invoice : confirmedInvoices) {
            // Get id detail
            int invoicesId = invoice.getInvoiceID();
            int tax = invoice.getTax();
            int discount = invoice.getDiscount();
            int totalAmount = new OrderDetailDAO().getTotalAmountByInvoiceID(invoicesId);
            String totalAmountConvert = addCommasToNumber(String.valueOf(totalAmount)) + " ₫";
            String status = invoice.getStatus();
            String paiedTime = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(invoice.getPaymentTime());

            // Get name table
            DiningTableEntity dataTable = new DiningTableDAO().getByInvoiceId(invoicesId);
            String tableName = dataTable.getName();

            // Add invoice on table
            modelConfirmed.addRow(new Object[]{
                invoicesId,
                tableName,
                totalAmountConvert,
                status,
                paiedTime
            });
        }
    }

    void handleClickTable(java.awt.event.MouseEvent evt) {
        if (evt.getClickCount() < 2) {
            return;
        }

        int selectedRow = tableUnpaidInvoices.getSelectedRow();
        if (selectedRow < 0) {
            return;
        }

        tableName = tableUnpaidInvoices.getValueAt(selectedRow, 1).toString();
        tableID = new DiningTableDAO().getIdByName(tableName);
        invoiceId = new InvoiceDAO().getIdByTableId(tableID);
        displayOrderDetails(tableID);

        // Set case
        labelOrderTable.setText(tableID == null ? "PAY [ Bàn Trống ]" : "PAY [ " + tableName + " ]");

        // Move pane
        tabbedPanePay.setSelectedIndex(0);
    }

}
