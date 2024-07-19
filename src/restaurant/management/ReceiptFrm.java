package restaurant.management;

import java.awt.Color;
import java.util.Date;
import java.sql.Timestamp;
import java.util.Comparator;
import java.text.SimpleDateFormat;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledExecutorService;

import restaurant.dao.ReceiptDAO;
import restaurant.dao.SupplierDAO;
import restaurant.entity.Receipt;
import restaurant.entity.Supplier;

import javax.swing.SwingUtilities;
import restaurant.utils.XTextField;
import restaurant.table.TableCustom;
import restaurant.utils.ColumnTable;
import restaurant.main.ManagementMode;
import restaurant.utils.TableNavigator;
import javax.swing.table.DefaultTableModel;
import restaurant.dialog.HistoryReceiptDetailJDialog;
import static restaurant.utils.Common.customizeTable;
import static restaurant.utils.Common.createButtonGroup;
import static restaurant.utils.XTextField.addCommasToNumber;
import static restaurant.utils.XRunnable.addComponentListeners;
import static restaurant.utils.XRunnable.addTextFieldListeners;

public final class ReceiptFrm extends javax.swing.JPanel {

    private final ManagementMode managementMode;

    public ReceiptFrm(ManagementMode managementMode) {
        initComponents();
        this.init();
        this.managementMode = managementMode;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        panelBody = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        btnExport = new javax.swing.JButton();
        btnCreate = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableReceipts = new javax.swing.JTable();
        btnLast = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        btnPrev = new javax.swing.JButton();
        btnFirst = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        textSearch = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        radioPurchase = new javax.swing.JRadioButton();
        radioReturn = new javax.swing.JRadioButton();
        radioAllReceipt = new javax.swing.JRadioButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        radioPaied = new javax.swing.JRadioButton();
        radioUnpay = new javax.swing.JRadioButton();
        radioAllPay = new javax.swing.JRadioButton();

        panelBody.setToolTipText("");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(926, 0));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Phiếu hàng hóa");

        btnExport.setBackground(new java.awt.Color(0, 153, 0));
        btnExport.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnExport.setForeground(new java.awt.Color(255, 255, 255));
        btnExport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/icon/export-file.png"))); // NOI18N
        btnExport.setText("Export");
        btnExport.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnCreate.setBackground(new java.awt.Color(0, 153, 0));
        btnCreate.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCreate.setForeground(new java.awt.Color(255, 255, 255));
        btnCreate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/icon/plusWhile.png"))); // NOI18N
        btnCreate.setText("Tạo phiếu");
        btnCreate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        tableReceipts.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tableReceipts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Thời gian", "Mã phiếu", "Loại phiếu", "NCC", "Tổng tiền", "Trạng thái", "Chi tiết"
            }
        ));
        tableReceipts.setGridColor(new java.awt.Color(255, 255, 255));
        tableReceipts.setRowHeight(40);
        jScrollPane1.setViewportView(tableReceipts);
        if (tableReceipts.getColumnModel().getColumnCount() > 0) {
            tableReceipts.getColumnModel().getColumn(1).setPreferredWidth(30);
            tableReceipts.getColumnModel().getColumn(2).setPreferredWidth(30);
            tableReceipts.getColumnModel().getColumn(3).setPreferredWidth(115);
            tableReceipts.getColumnModel().getColumn(4).setPreferredWidth(30);
            tableReceipts.getColumnModel().getColumn(5).setPreferredWidth(55);
            tableReceipts.getColumnModel().getColumn(6).setPreferredWidth(20);
        }

        btnLast.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnLast.setText(">|");
        btnLast.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnNext.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnNext.setText(">>");
        btnNext.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnPrev.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnPrev.setText("<<");
        btnPrev.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnFirst.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnFirst.setText("|<");
        btnFirst.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("Hiển thị 1 - 10 trên tổng số 10 bàn");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnFirst, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPrev, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLast, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1007, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCreate)
                        .addGap(6, 6, 6)
                        .addComponent(btnExport, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnExport, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 483, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnNext, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                    .addComponent(btnPrev, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnFirst, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLast, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Tìm kiếm");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(textSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(textSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Loại phiếu");

        radioPurchase.setText("Phiếu nhập");

        radioReturn.setText("Phiếu trả");

        radioAllReceipt.setSelected(true);
        radioAllReceipt.setText("Tất cả");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(radioAllReceipt)
                    .addComponent(radioReturn)
                    .addComponent(radioPurchase)
                    .addComponent(jLabel5))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(radioPurchase)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(radioReturn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(radioAllReceipt)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("Trạng thái");

        radioPaied.setText("Đã thanh toán");

        radioUnpay.setText("Chưa trả");

        radioAllPay.setSelected(true);
        radioAllPay.setText("Tất cả");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(radioAllPay)
                    .addComponent(radioUnpay)
                    .addComponent(radioPaied)
                    .addComponent(jLabel7))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(radioPaied)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(radioUnpay)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(radioAllPay)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelBodyLayout = new javax.swing.GroupLayout(panelBody);
        panelBody.setLayout(panelBodyLayout);
        panelBodyLayout.setHorizontalGroup(
            panelBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBodyLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(panelBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1031, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        panelBodyLayout.setVerticalGroup(
            panelBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBodyLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(panelBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBodyLayout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 584, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(18, Short.MAX_VALUE))
                    .addGroup(panelBodyLayout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBody, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(panelBody, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnExport;
    private javax.swing.JButton btnFirst;
    private javax.swing.JButton btnLast;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrev;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelBody;
    private javax.swing.JRadioButton radioAllPay;
    private javax.swing.JRadioButton radioAllReceipt;
    private javax.swing.JRadioButton radioPaied;
    private javax.swing.JRadioButton radioPurchase;
    private javax.swing.JRadioButton radioReturn;
    private javax.swing.JRadioButton radioUnpay;
    private javax.swing.JTable tableReceipts;
    private javax.swing.JTextField textSearch;
    // End of variables declaration//GEN-END:variables

    final int DEBOUNCE_DELAY_LOAD = 300;
    final String PLACEHOLDER_SEARCH = "Tìm theo mã, tên nhà cung cấp";

    ScheduledFuture<?> scheduledFuture;
    ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);

    void init() {
        // <--- Fuction common from file common --->
        createButtonGroup(radioPaied, radioUnpay, radioAllPay);
        createButtonGroup(radioPurchase, radioReturn, radioAllReceipt);

        // edit field text
        XTextField.addPlaceholder(textSearch, PLACEHOLDER_SEARCH);
        XTextField.addFocusBorder(textSearch, new Color(51, 204, 0), new Color(204, 204, 204));

        // edit table
        TableCustom.apply(jScrollPane1, TableCustom.TableType.MULTI_LINE);
        customizeTable(tableReceipts, new int[]{}, 40);

        // <--- Setup main --->
        // navigator table 
        TableNavigator navigator = new TableNavigator(tableReceipts);
        btnFirst.addActionListener(e -> navigator.first());
        btnNext.addActionListener(e -> navigator.next());
        btnPrev.addActionListener(e -> navigator.prev());
        btnLast.addActionListener(e -> navigator.last());

        // add button cell column table
        int coulumnCell = 6;
        ColumnTable.addButtonColumn(
                "Chi tiết",
                coulumnCell,
                tableReceipts,
                this::handleClickBtnColumn
        );

        // handle click button
        btnCreate.addActionListener(e -> {
            managementMode.displayManagementPanel(new CreateReceiptFrm(managementMode));
        });

        // load list by search and classify when change
        addTextFieldListeners(textSearch, this::loadDataFillTable);
        addComponentListeners(
                this::loadDataFillTable,
                radioPaied, radioUnpay, radioAllPay
        );
        addComponentListeners(
                this::loadDataFillTable,
                radioPurchase, radioReturn, radioAllReceipt
        );

        // Load data
        this.loadDataFillTable();
    }

    void handleClickBtnColumn(int row) {
        if (row == -1) {
            return;
        }

        // Get data detail
        String receiptID = (String) tableReceipts.getValueAt(row, 1);
        Receipt dataReceipt = new ReceiptDAO().getByID(receiptID);

        // Open dialog 
        HistoryReceiptDetailJDialog dialog = new HistoryReceiptDetailJDialog(null, true);
        dialog.setModel(dataReceipt);
        dialog.setVisible(true);
    }

    void loadDataFillTable() {
        if (scheduledFuture != null && !scheduledFuture.isDone()) {
            scheduledFuture.cancel(false);
        }

        scheduledFuture = scheduledExecutorService.schedule(() -> {
            SwingUtilities.invokeLater(() -> {
                // Get info criterias
                String keyword = textSearch.getText().trim();
                if (keyword.equals(PLACEHOLDER_SEARCH)) {
                    keyword = "";
                }

                // get value radio
                String radioType = radioPurchase.isSelected() ? radioPurchase.getText()
                        : radioReturn.isSelected() ? radioReturn.getText() : "";
                String radioPay = radioPaied.isSelected() ? radioPaied.getText()
                        : radioUnpay.isSelected() ? radioUnpay.getText() : "";

                // Get data and load
                List<Receipt> dataList = new ReceiptDAO().searchByCriteria(keyword, keyword, radioType, radioPay);
                this.fillTable(dataList);
            });
        }, DEBOUNCE_DELAY_LOAD, TimeUnit.MILLISECONDS);
    }

    public void fillTable(List<Receipt> dataList) {
        System.out.println("Đang load dữ liệu từ cơ sở dữ liệu...");

        // Display table
        DefaultTableModel model = (DefaultTableModel) tableReceipts.getModel();
        model.setRowCount(0);

        // Sắp xếp theo thời gian bắt đầu từ xa nhất
        dataList.sort(Comparator.comparing(Receipt::getReceiptDate).reversed());

        // Load data into the table 
        for (Receipt dataItem : dataList) {
            // get data supplier
            String supplierID = dataItem.getSupplierID();
            Supplier supplier = new SupplierDAO().getByID(supplierID);

            // get create time
            Timestamp receiptDate = dataItem.getReceiptDate();
            String receiptDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm").format(receiptDate);

            // get transaction type
            String transactionType = dataItem.getTransactionType();
            String charactor = transactionType.equals("Phiếu nhập") ? "+" : "-";

            // get total amount
            long totalAmount = dataItem.getTotalAmount();
            String totalFormat = addCommasToNumber(totalAmount);

            model.addRow(new Object[]{
                receiptDateFormat,
                dataItem.getReceiptID(),
                dataItem.getTransactionType() + " [" + charactor + "]",
                supplier.getSupplierName(),
                totalFormat + " VND",
                dataItem.getStatus()
            });
        }
    }

}
