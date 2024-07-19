package restaurant.dialog;

import java.awt.Color;
import java.util.List;
import java.text.SimpleDateFormat;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import restaurant.utils.Common;
import restaurant.table.TableCustom;
import restaurant.dao.EmployeeDAO;
import restaurant.dao.GoodsDAO;
import restaurant.dao.ReceiptDetailDAO;
import restaurant.dao.SupplierDAO;

import restaurant.entity.Employee;
import restaurant.entity.Goods;
import restaurant.entity.Receipt;
import restaurant.entity.ReceiptDetail;
import restaurant.entity.Supplier;
import static restaurant.utils.XTextField.addCommasToNumber;

public class HistoryReceiptDetailJDialog extends javax.swing.JDialog {

    public HistoryReceiptDetailJDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        init();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        textNote = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        labelEmployee = new javax.swing.JLabel();
        labelSupplier = new javax.swing.JLabel();
        labelTyle = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        labelStatus = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableMain = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        labelDate = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jList1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Chi tiết Order [31584]");
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Loại phiếu:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Tên NCC:");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Nhân viên:");

        textNote.setEditable(false);
        textNote.setBackground(new java.awt.Color(255, 255, 255));
        textNote.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textNote.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        textNote.setFocusable(false);
        textNote.setRequestFocusEnabled(false);
        textNote.setVerifyInputWhenFocusTarget(false);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Ghi chú:");

        labelEmployee.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelEmployee.setText("Trống");

        labelSupplier.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelSupplier.setText("Trống");

        labelTyle.setBackground(new java.awt.Color(255, 255, 255));
        labelTyle.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelTyle.setText("Trống");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Trạng thái:");

        labelStatus.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelStatus.setText("Trống");

        tableMain.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        tableMain.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên hàng hóa", "SL", "Đơn giá", "Thành tiền"
            }
        ));
        tableMain.setAlignmentX(1.0F);
        tableMain.setAlignmentY(1.0F);
        tableMain.setFillsViewportHeight(true);
        tableMain.setGridColor(new java.awt.Color(255, 255, 255));
        tableMain.setRowHeight(35);
        jScrollPane3.setViewportView(tableMain);
        if (tableMain.getColumnModel().getColumnCount() > 0) {
            tableMain.getColumnModel().getColumn(0).setPreferredWidth(140);
            tableMain.getColumnModel().getColumn(1).setPreferredWidth(28);
            tableMain.getColumnModel().getColumn(2).setPreferredWidth(60);
            tableMain.getColumnModel().getColumn(3).setPreferredWidth(78);
        }

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setText("Thời gian:");

        labelDate.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelDate.setText("Trống");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(labelDate))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel9)
                                .addComponent(jLabel8)
                                .addComponent(jLabel7)
                                .addComponent(jLabel6))
                            .addGap(14, 14, 14)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(labelTyle)
                                .addComponent(labelSupplier)
                                .addComponent(labelEmployee)
                                .addComponent(labelStatus)))
                        .addComponent(jLabel1)
                        .addComponent(textNote, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(labelTyle))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(labelSupplier))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(labelEmployee))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(labelDate))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(labelStatus))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addGap(0, 0, 0)
                .addComponent(textNote, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
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
            java.util.logging.Logger.getLogger(HistoryReceiptDetailJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            HistoryReceiptDetailJDialog dialog = new HistoryReceiptDetailJDialog(new javax.swing.JFrame(), true);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });
            dialog.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel labelDate;
    private javax.swing.JLabel labelEmployee;
    private javax.swing.JLabel labelStatus;
    private javax.swing.JLabel labelSupplier;
    private javax.swing.JLabel labelTyle;
    private javax.swing.JTable tableMain;
    private javax.swing.JTextField textNote;
    // End of variables declaration//GEN-END:variables

    String tableNamesStr;

    private void init() {
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.WHITE);

        // Setup common
        TableCustom.apply(jScrollPane3, TableCustom.TableType.MULTI_LINE);
        Common.customizeTable(tableMain, new int[]{}, 30);
    }

    public void setModel(Receipt dataItem) {
        if (dataItem == null) {
            this.setTitle("Chi tiết biên lai");
            labelTyle.setText("Trống");
            labelSupplier.setText("");
            labelEmployee.setText("");
            labelDate.setText("");
            labelStatus.setText("");
            textNote.setText("");
            return;
        }

        try {
            // get id
            String receiptID = dataItem.getReceiptID();
            String receiptType = dataItem.getTransactionType();
            String charator = receiptType.equals("Phiếu nhập") ? "+" : "-";

            // Set name 
            Employee employee = new EmployeeDAO().getByID(dataItem.getEmployeeID());
            String employeeName = employee.getFullName();

            // get data supplier
            String supplierID = dataItem.getSupplierID();
            Supplier supplier = new SupplierDAO().getByID(supplierID);

            // set info
            this.setTitle("Chi tiết biên lai [" + dataItem.getReceiptID() + "]");
            labelTyle.setText(dataItem.getTransactionType());
            labelSupplier.setText(supplier.getSupplierName());
            labelEmployee.setText(employeeName);
            labelDate.setText(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(dataItem.getReceiptDate()));
            labelStatus.setText(dataItem.getStatus());
            textNote.setText(dataItem.getNote());

            // set receipt detail
            List<ReceiptDetail> receiptDetails = new ReceiptDetailDAO().findByReceiptID(receiptID);
            this.displayTableOrder(receiptDetails, charator, tableMain);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    void displayTableOrder(List<ReceiptDetail> dataList, String charator, JTable tableMain) {
        if (charator == null || dataList == null) {
            return;
        }

        // Set table ordered
        for (ReceiptDetail dataItem : dataList) {
            // Get goods name
            Goods dataGoods = new GoodsDAO().getByID(dataItem.getGoodsID());
            String goodsName = dataGoods.getGoodsName();

            int quantity = dataItem.getQuantity();
            String price = addCommasToNumber(dataItem.getUnitPrice());
            String subTotal = addCommasToNumber(dataItem.getTotalPrice());

            // Get model
            DefaultTableModel table = (DefaultTableModel) tableMain.getModel();
            table.addRow(new Object[]{
                goodsName,
                charator + quantity,
                price,
                subTotal
            });
        }
    }
}
