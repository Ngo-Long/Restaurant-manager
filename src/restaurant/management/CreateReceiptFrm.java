package restaurant.management;

import java.awt.Font;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;

import java.util.List;
import java.util.Vector;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledExecutorService;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.SwingUtilities;
import javax.swing.DefaultCellEditor;
import javax.swing.table.DefaultTableModel;

import restaurant.dao.GoodsDAO;
import restaurant.dao.ReceiptDAO;
import restaurant.dao.SupplierDAO;
import restaurant.table.TableCustom;
import restaurant.entity.Goods;
import restaurant.entity.Receipt;
import restaurant.main.ManagementMode;
import restaurant.entity.Supplier;

import restaurant.utils.Auth;
import restaurant.utils.Common;
import restaurant.utils.ColumnTable;
import restaurant.utils.XComboBox;
import restaurant.utils.XTextField;
import static restaurant.utils.ColumnTable.addTextFieldColumn;
import static restaurant.utils.XTextField.addCommasToNumber;
import static restaurant.utils.ColumnTable.addQuantityButtonsColumn;
import static restaurant.utils.XComboBox.insertPlaceholder;
import static restaurant.utils.XComboBox.loadDataToComboBox;
import restaurant.utils.Dialog;
import static restaurant.utils.XTextField.removeCommasFromNumber;

public class CreateReceiptFrm extends javax.swing.JPanel {

    public CreateReceiptFrm(ManagementMode mainManager) {
        initComponents();
        this.init();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableReceipts = new javax.swing.JTable();
        labelOrderedTable = new javax.swing.JLabel();
        btnChoseGroupGoods = new javax.swing.JButton();
        textSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        btnCalc = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        labelDate = new javax.swing.JLabel();
        labelTotal = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        textID = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        btnSubmit = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        labelInvoiceID = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cbSuppliers = new javax.swing.JComboBox<>();
        cbReceiptType = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        labelEmployeeName = new javax.swing.JLabel();
        btnQuantity = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        textDiscount = new javax.swing.JTextField();
        labelTotalAmount = new javax.swing.JLabel();
        radioPaied = new javax.swing.JRadioButton();
        radioUnpay = new javax.swing.JRadioButton();
        jLabel11 = new javax.swing.JLabel();
        labelTime = new javax.swing.JLabel();

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setAutoscrolls(true);
        jPanel3.setPreferredSize(new java.awt.Dimension(860, 555));

        tableReceipts.setAutoCreateRowSorter(true);
        tableReceipts.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        tableReceipts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "Mã hàng hóa", "Tên hàng", "Số lượng", "Đơn giá", "Giảm giá", "Tổng giá"
            }
        ));
        tableReceipts.setAlignmentX(2.0F);
        tableReceipts.setAlignmentY(2.0F);
        tableReceipts.setDoubleBuffered(true);
        tableReceipts.setDragEnabled(true);
        tableReceipts.setFillsViewportHeight(true);
        tableReceipts.setGridColor(new java.awt.Color(255, 255, 255));
        tableReceipts.setRowHeight(40);
        jScrollPane1.setViewportView(tableReceipts);
        if (tableReceipts.getColumnModel().getColumnCount() > 0) {
            tableReceipts.getColumnModel().getColumn(0).setMinWidth(35);
            tableReceipts.getColumnModel().getColumn(0).setPreferredWidth(35);
            tableReceipts.getColumnModel().getColumn(0).setMaxWidth(35);
            tableReceipts.getColumnModel().getColumn(1).setPreferredWidth(16);
            tableReceipts.getColumnModel().getColumn(2).setPreferredWidth(140);
            tableReceipts.getColumnModel().getColumn(3).setPreferredWidth(20);
            tableReceipts.getColumnModel().getColumn(4).setPreferredWidth(20);
            tableReceipts.getColumnModel().getColumn(5).setPreferredWidth(20);
            tableReceipts.getColumnModel().getColumn(6).setPreferredWidth(20);
        }

        labelOrderedTable.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        labelOrderedTable.setForeground(new java.awt.Color(255, 51, 51));
        labelOrderedTable.setText("Nhập hàng");

        btnChoseGroupGoods.setBackground(new java.awt.Color(0, 153, 153));
        btnChoseGroupGoods.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnChoseGroupGoods.setForeground(new java.awt.Color(255, 255, 255));
        btnChoseGroupGoods.setText("Chọn nhóm hàng");
        btnChoseGroupGoods.setToolTipText("Xem lịch sử gọi món");
        btnChoseGroupGoods.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        textSearch.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        btnSearch.setBackground(new java.awt.Color(255, 51, 51));
        btnSearch.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSearch.setForeground(new java.awt.Color(255, 255, 255));
        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/icon/searchWhile.png"))); // NOI18N
        btnSearch.setToolTipText("Tìm kiếm");
        btnSearch.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnCalc.setBackground(new java.awt.Color(51, 153, 0));
        btnCalc.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnCalc.setForeground(new java.awt.Color(255, 255, 255));
        btnCalc.setText("Tính toán");
        btnCalc.setToolTipText("Xem lịch sử gọi món");
        btnCalc.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(labelOrderedTable)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(textSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnChoseGroupGoods)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCalc))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 786, Short.MAX_VALUE))
                .addGap(12, 12, 12))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap(8, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelOrderedTable, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnChoseGroupGoods, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnCalc, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnSearch, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 516, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setPreferredSize(new java.awt.Dimension(420, 596));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Thời gian:");

        labelDate.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelDate.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelDate.setText("31-05-2024");
        labelDate.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));

        labelTotal.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelTotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelTotal.setText("0");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("Mã phiếu:");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(51, 51, 51));
        jLabel14.setText("Nhân viên:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("Nhà cung cấp:");

        textID.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        textID.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        textID.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(51, 204, 0)));
        textID.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        textID.setMargin(new java.awt.Insets(20, 60, 2, 40));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(51, 51, 51));
        jLabel16.setText("Tổng cần trả:");

        btnSubmit.setBackground(new java.awt.Color(0, 153, 0));
        btnSubmit.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnSubmit.setForeground(new java.awt.Color(255, 255, 255));
        btnSubmit.setText("HOÀN THÀNH");
        btnSubmit.setToolTipText("Ấn để in hóa đơn");
        btnSubmit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnCancel.setBackground(new java.awt.Color(255, 0, 51));
        btnCancel.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnCancel.setForeground(new java.awt.Color(255, 255, 255));
        btnCancel.setText("HỦY");
        btnCancel.setToolTipText("Quay lại bàn ăn (F1)");
        btnCancel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        labelInvoiceID.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        labelInvoiceID.setForeground(new java.awt.Color(255, 51, 51));
        labelInvoiceID.setText("Tạo phiếu");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setText("Tổng tiền hàng:");

        cbSuppliers.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbSuppliers.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Lựa chọn--", "Nhà cung cấp thịt" }));

        cbReceiptType.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbReceiptType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Lựa chọn--", "Phiếu nhập", "Phiếu trả", "Phiếu hủy" }));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("Loại phiếu:");

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setPreferredSize(new java.awt.Dimension(251, 2));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        labelEmployeeName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelEmployeeName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelEmployeeName.setText("Ngô Kim Long");

        btnQuantity.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnQuantity.setText("1");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 51, 51));
        jLabel10.setText("Giảm giá:");

        textDiscount.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        textDiscount.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        textDiscount.setText("0");
        textDiscount.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(51, 204, 0)));
        textDiscount.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        textDiscount.setMargin(new java.awt.Insets(20, 60, 2, 40));

        labelTotalAmount.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        labelTotalAmount.setForeground(new java.awt.Color(255, 0, 51));
        labelTotalAmount.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelTotalAmount.setText("0");

        radioPaied.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        radioPaied.setSelected(true);
        radioPaied.setText("Thanh toán ngay");

        radioUnpay.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        radioUnpay.setText("Chưa thanh toán");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(51, 51, 51));
        jLabel11.setText("Trạng thái:");

        labelTime.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelTime.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelTime.setText("23:39");
        labelTime.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(81, 81, 81)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textDiscount)
                                    .addComponent(cbReceiptType, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbSuppliers, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(textID, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addComponent(labelDate)
                                                .addGap(22, 22, 22)
                                                .addComponent(labelTime))
                                            .addComponent(labelEmployeeName, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(radioPaied, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                                        .addComponent(radioUnpay))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(btnQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(labelTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(4, 4, 4)))))
                        .addGap(14, 14, 14))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(labelInvoiceID, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                    .addComponent(jLabel16)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(labelTotalAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(labelInvoiceID, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelDate, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelTime, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelEmployeeName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textID, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbReceiptType, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbSuppliers, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(radioPaied, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(radioUnpay, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(labelTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(textDiscount, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)))
                .addGap(14, 14, 14)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelTotalAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSubmit, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                    .addComponent(btnCancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(12, 12, 12))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 810, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 587, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 587, Short.MAX_VALUE))
                .addContainerGap(18, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCalc;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnChoseGroupGoods;
    private javax.swing.JButton btnQuantity;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JComboBox<String> cbReceiptType;
    private javax.swing.JComboBox<String> cbSuppliers;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelDate;
    private javax.swing.JLabel labelEmployeeName;
    private javax.swing.JLabel labelInvoiceID;
    private javax.swing.JLabel labelOrderedTable;
    private javax.swing.JLabel labelTime;
    private javax.swing.JLabel labelTotal;
    private javax.swing.JLabel labelTotalAmount;
    private javax.swing.JRadioButton radioPaied;
    private javax.swing.JRadioButton radioUnpay;
    private javax.swing.JTable tableReceipts;
    private javax.swing.JTextField textDiscount;
    private javax.swing.JTextField textID;
    private javax.swing.JTextField textSearch;
    // End of variables declaration//GEN-END:variables

    final int DEBOUNCE_DELAY_LOAD = 200;
    final String PLACEHOLDER_ID = "Mã phiếu tự động";
    final String PLACEHOLDER_STATUS = "--Lựa chọn--";
    final String PLACEHOLDER_SEARCH = "Tìm hàng hóa theo tên hoặc mã";

    ScheduledFuture<?> scheduledFuture;
    ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);

    void init() {
        // <--- Setup common --->
        Common.startClock(labelTime, "HH:mm");
        Common.startClock(labelDate, "dd-MM-yyyy");
        Common.createButtonGroup(radioPaied, radioUnpay);

        // set table
        TableCustom.apply(jScrollPane1, TableCustom.TableType.MULTI_LINE);
        Common.customizeTable(tableReceipts, new int[]{}, 36);

        // Set button style
        btnQuantity.setBackground(Color.white);

        // set combobox style
        XComboBox.setComboboxStyle(cbSuppliers);
        XComboBox.setComboboxStyle(cbReceiptType);

        // set placeholder text field
        XTextField.addPlaceholder(textID, PLACEHOLDER_ID);
        XTextField.addPlaceholder(textSearch, PLACEHOLDER_SEARCH);

        // set border when focus
        XTextField.addFocusBorder(textID, new Color(51, 204, 0), new Color(204, 204, 204));
        XTextField.addFocusBorder(textDiscount, new Color(51, 204, 0), new Color(204, 204, 204));

        // <--- Setup main --->
        // set name employee
        if (Auth.user != null) {
            labelEmployeeName.setText("" + Auth.user.getFullName());
        }

        // handle add button column to table
        addButtonColumnCells();

        // add data to combobox
        List<Supplier> dataSupplierList = new SupplierDAO().getAll();
        loadDataToComboBox(cbSuppliers,
                dataSupplierList,
                Supplier::getSupplierName
        );
        insertPlaceholder(cbSuppliers, PLACEHOLDER_STATUS);

        // handle click button search
        btnSearch.addActionListener(e -> {
            this.loadDataPopupMenu();
        });

        btnSubmit.addActionListener(e -> submit());

    }

    // <--- button column cell list
    void addButtonColumnCells() {
        // add button cell column table icon
        int COLUMN_CELL_ZERO = 0;
        ColumnTable.addButtonIconColumn("src/restaurant/icon/delete.png",
                COLUMN_CELL_ZERO,
                tableReceipts,
                this::handleClickBtnColumnDelete
        );

        // add text field in the cell table
        int COLUMN_CELL_FOUR = 4;
        addTextFieldColumn(tableReceipts, COLUMN_CELL_FOUR);

        // add text field in the cell table
        int COLUMN_CELL_FIVE = 5;
        addTextFieldColumn(tableReceipts, COLUMN_CELL_FIVE);

        // add button change quantity "+" and "-" column
        int COLUMN_CELL_THREE = 3;
        addQuantityButtonsColumn(tableReceipts, COLUMN_CELL_THREE, true);

        // Button calc total 
        btnCalc.addActionListener(e -> {
            calculateTotalAmount(tableReceipts);
        });
    }

    void handleClickBtnColumnDelete(int row) {
        boolean isSubmit = Dialog.confirm(this, "Xác nhận xóa món ăn!");
        if (isSubmit) {
            // Remove selected row
            if (tableReceipts.isEditing()) {
                tableReceipts.getCellEditor().stopCellEditing();
            }

            // Call table get model 
            DefaultTableModel model = (DefaultTableModel) tableReceipts.getModel();

            // Delete row
            model.removeRow(row);
        }
    }
    // end --->

    // <--- submit and cancel
    void submit() {
        if (!isSubmit()) {
            return;
        }

        // Get data from the table
        DefaultTableModel model = (DefaultTableModel) tableReceipts.getModel();

        try {
            Receipt receipt = new Receipt();
            receipt.setEmployeeID(Auth.user.getEmployeeID());
            receipt.setSupplierID(PLACEHOLDER_ID);
            receipt.setTransactionType(PLACEHOLDER_ID);
            receipt.setTotalAmount(1000);
            receipt.setNote(PLACEHOLDER_ID);
            receipt.setStatus(PLACEHOLDER_ID);
            new ReceiptDAO().insert(receipt);
        } catch (Exception e) {
        }
    }

    boolean isSubmit() {
        if (Auth.user == null) {
            Dialog.warning(this, "Vui lòng đăng nhập!");
            return false;
        }

        if (tableReceipts.getRowCount() == 0) {
            Dialog.warning(this, "Vui lòng chọn hàng hóa!");
            return false;
        }

//        if ()
        return true;
    }

    void cancel() {

    }
    // end --->

    // <--- load data and display menu
    void loadDataPopupMenu() {
        if (scheduledFuture != null && !scheduledFuture.isDone()) {
            scheduledFuture.cancel(false);
        }

        scheduledFuture = scheduledExecutorService.schedule(() -> {
            SwingUtilities.invokeLater(() -> {
                // Get keyword
                String keyword = textSearch.getText().trim();
                if (keyword.equals(PLACEHOLDER_SEARCH) || keyword.equals("")) {
                    keyword = "Không có sản phẩm";
                }

                // Get data and load
                List<Goods> dataList
                        = new GoodsDAO().searchByCriteria(keyword, keyword, "", "");
                this.displayPopupMenu(textSearch, dataList);
            });
        }, DEBOUNCE_DELAY_LOAD, TimeUnit.MILLISECONDS);
    }

    void displayPopupMenu(JTextField textField, List<Goods> dataList) {
        // Create popup menu
        JPopupMenu popupMenu = new JPopupMenu();

        // Reset 
        popupMenu.removeAll();

        if (dataList == null || dataList.isEmpty()) {
            JMenuItem menuItem = new JMenuItem("Không tìm thấy hàng hóa");
            menuItem.setEnabled(false);
            popupMenu.add(menuItem);
        } else {
            for (Goods dataItem : dataList) {
                // Create a panel to data item
                JPanel panel = createPanel(dataItem);

                // Create a menu item containing the panel
                JMenuItem menuItem = createMenuItem(panel, dataItem);

                // Add menu item to popup menu
                popupMenu.add(menuItem);
            }

            // Set preferred size
            int totalHeight = dataList.size() * 70;
            int totalWidth = textField.getWidth() + 50;
            popupMenu.setPreferredSize(new Dimension(totalWidth, totalHeight));
        }

        // Show location bottom left
        popupMenu.show(textField, 0, textField.getHeight());

        // Revalidate and repaint
        popupMenu.revalidate();
        popupMenu.repaint();
    }

    JPanel createPanel(Goods dataItem) {
        JPanel panel = new JPanel(new GridLayout(2, 2));
        panel.setBackground(Color.WHITE);
        panel.setPreferredSize(new Dimension(200, 60));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 0));

        panel.add(createLabel("Tên: " + dataItem.getGoodsName()));
        panel.add(createLabel("Mã: " + dataItem.getGoodsID()));
        long price = dataItem.getUnitPrice();
        panel.add(createLabel("Đơn giá: " + addCommasToNumber(price) + "đ"));
        panel.add(createLabel("SL tồn kho: " + dataItem.getInitialQuantity()));

        return panel;
    }

    JLabel createLabel(String text) {
        if (text == null || text.equals("")) {
            return null;
        }

        Font labelFont = new Font("SansSerif", Font.PLAIN, 13);
        JLabel label = new JLabel(text);
        label.setFont(labelFont);

        return label;
    }

    JMenuItem createMenuItem(JPanel panel, Goods dataItem) {
        if (panel == null) {
            return null;
        }

        // setup menu item
        JMenuItem menuItem = new JMenuItem();
        menuItem.setLayout(new BorderLayout());
        menuItem.add(panel, BorderLayout.CENTER);
        menuItem.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        menuItem.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        // Add ActionListener to handle menu item click
        menuItem.addActionListener((ActionEvent e) -> {
            addDataToTable(dataItem.getGoodsID());
        });

        // Add MouseListener to change color on hover
        menuItem.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (menuItem.getComponentCount() > 0) {
                    menuItem.getComponent(0).setBackground(new Color(215, 215, 215));
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (menuItem.getComponentCount() > 0) {
                    menuItem.getComponent(0).setBackground(Color.WHITE);
                }
            }
        });

        return menuItem;
    }

    void addDataToTable(String id) {
        if (id == null || id.equals("")) {
            return;
        }

        // Get data
        Goods dataGoods = new GoodsDAO().getByID(id);

        // Display table
        DefaultTableModel model = (DefaultTableModel) tableReceipts.getModel();

        // Enable cell editing for specific columns 
        tableReceipts.getColumnModel().getColumn(4).setCellEditor(new DefaultCellEditor(new JTextField()));
        tableReceipts.getColumnModel().getColumn(5).setCellEditor(new DefaultCellEditor(new JTextField()));

        // Add to the table
        model.addRow(new Object[]{
            "",
            dataGoods.getGoodsID(),
            dataGoods.getGoodsName(),
            1,
            addCommasToNumber(dataGoods.getUnitPrice()),
            0,
            addCommasToNumber(dataGoods.getUnitPrice())
        });
    }

    void calculateTotalAmount(JTable tableMain) {
        long totalAmount = 0;
        int totalQuantity = 0;
        int totalDiscount = 0;
        DefaultTableModel model = (DefaultTableModel) tableMain.getModel();

        for (int i = 0; i < model.getRowCount(); i++) {
            // Get quantity
            String quantityStr = model.getValueAt(i, 3).toString();
            int quantity = Integer.parseInt(quantityStr);

            // Get price
            String priceStr = removeCommasFromNumber(model.getValueAt(i, 4).toString());
            long price = Long.parseLong(removeCommasFromNumber(priceStr));

            // String
            String discountStr = model.getValueAt(i, 5).toString();
            long discount = Long.parseLong(removeCommasFromNumber(discountStr));

            // Calculate subtotal for the row
            long subtotal = (quantity * price) - discount;

            // Set value
            model.setValueAt(addCommasToNumber(priceStr), i, 4);
            model.setValueAt(addCommasToNumber(discountStr), i, 5);
            model.setValueAt(addCommasToNumber(subtotal), i, 6);

            // Accumulate subtotal to totalAmount
            totalAmount += subtotal;
            totalQuantity += quantity;
            totalDiscount += discount;
        }

        // display discount
        textDiscount.setText(addCommasToNumber(totalDiscount));

        // dispay total quantity
        btnQuantity.setText(String.valueOf(totalQuantity));

        // Format totalAmount to display
        String formattedTotal = addCommasToNumber(String.valueOf(totalAmount));
        labelTotal.setText(formattedTotal);
        labelTotalAmount.setText(formattedTotal);

    }
    // end -->
}
