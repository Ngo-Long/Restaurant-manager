package restaurant.dialog;

import java.awt.Color;
import java.util.List;
import java.text.SimpleDateFormat;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import restaurant.utils.Common;
import restaurant.table.TableCustom;
import restaurant.utils.XTextField;

import restaurant.dao.OrderDAO;
import restaurant.dao.ProductDAO;
import restaurant.dao.EmployeeDAO;
import restaurant.dao.DiningTableDAO;
import restaurant.dao.OrderDetailDAO;

import restaurant.entity.Order;
import restaurant.entity.Product;
import restaurant.entity.Invoice;
import restaurant.entity.Employee;
import restaurant.entity.DiningTable;
import restaurant.entity.OrderDetail;

public class HistoryInvoiceDetailJDialog extends javax.swing.JDialog {

    public HistoryInvoiceDetailJDialog(java.awt.Frame parent, boolean modal) {
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
        labelTime = new javax.swing.JLabel();
        labelEmployee = new javax.swing.JLabel();
        labelTable = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        labelStatus = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableOrdered = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        labelTotal = new javax.swing.JLabel();

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
        jLabel6.setText("Nguồn:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Thu ngân:");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Thời gian:");

        textNote.setEditable(false);
        textNote.setBackground(new java.awt.Color(255, 255, 255));
        textNote.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textNote.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        textNote.setFocusable(false);
        textNote.setRequestFocusEnabled(false);
        textNote.setVerifyInputWhenFocusTarget(false);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Ghi chú:");

        labelTime.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelTime.setText("Trống");

        labelEmployee.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelEmployee.setText("Trống");

        labelTable.setBackground(new java.awt.Color(255, 255, 255));
        labelTable.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelTable.setText("Trống");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Trạng thái:");

        labelStatus.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelStatus.setText("Trống");

        tableOrdered.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        tableOrdered.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên món", "Trạng thái"
            }
        ));
        tableOrdered.setAlignmentX(1.0F);
        tableOrdered.setAlignmentY(1.0F);
        tableOrdered.setFillsViewportHeight(true);
        tableOrdered.setGridColor(new java.awt.Color(255, 255, 255));
        tableOrdered.setRowHeight(35);
        jScrollPane3.setViewportView(tableOrdered);
        if (tableOrdered.getColumnModel().getColumnCount() > 0) {
            tableOrdered.getColumnModel().getColumn(0).setPreferredWidth(140);
            tableOrdered.getColumnModel().getColumn(1).setPreferredWidth(20);
        }

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setText("Tổng tiền:");

        labelTotal.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelTotal.setText("Trống");

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
                        .addComponent(labelTotal))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel9)
                                .addComponent(jLabel8)
                                .addComponent(jLabel7)
                                .addComponent(jLabel6))
                            .addGap(14, 14, 14)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(labelTable)
                                .addComponent(labelEmployee)
                                .addComponent(labelTime)
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
                    .addComponent(labelTable))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(labelEmployee))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(labelTime))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(labelTotal))
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
            java.util.logging.Logger.getLogger(HistoryInvoiceDetailJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            HistoryInvoiceDetailJDialog dialog = new HistoryInvoiceDetailJDialog(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel labelEmployee;
    private javax.swing.JLabel labelStatus;
    private javax.swing.JLabel labelTable;
    private javax.swing.JLabel labelTime;
    private javax.swing.JLabel labelTotal;
    private javax.swing.JTable tableOrdered;
    private javax.swing.JTextField textNote;
    // End of variables declaration//GEN-END:variables

    String tableNamesStr;

    private void init() {
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.WHITE);

        // Setup common
        TableCustom.apply(jScrollPane3, TableCustom.TableType.MULTI_LINE);
        Common.customizeTable(tableOrdered, new int[]{}, 30);
    }

    public void displayDetailInvoice(Invoice data) {
        if (data == null) {
            this.setTitle("Chi tiết đơn hàng");
            labelTable.setText("Trống");
            labelEmployee.setText("");
            labelTime.setText("");
            labelTotal.setText("");
            labelStatus.setText("");
            textNote.setText("");
            return;
        }

        // Set title
        this.setTitle("Chi tiết đơn hàng [" + data.getInvoiceID() + "]");

        // Get table name list
        List<DiningTable> dataTables = new DiningTableDAO().getByInvoicesID(data.getInvoiceID());
        for (DiningTable dateTable : dataTables) {
            tableNamesStr = String.join(" + ", dateTable.getName());
        }
        if (tableNamesStr == null) {
            tableNamesStr = "Mang về";
        }

        // Quantity order
        List<Order> dataOrders = new OrderDAO().getByInvoiceID(data.getInvoiceID());
        int quantityOrders = dataOrders.size();

        // Set name 
        Employee employee = new EmployeeDAO().getByID(data.getEmployeeID());
        String employeeName = employee.getFullName();

        // Set total
        String total = String.valueOf(data.getTotalAmount());
        String totalConfirm = XTextField.addCommasToNumber(total) + " đ";

        labelTable.setText(tableNamesStr + " / " + quantityOrders + " đơn");
        labelEmployee.setText(employeeName);
        labelTime.setText(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(data.getPaymentTime()));
        labelTotal.setText(totalConfirm);
        labelStatus.setText(data.getStatus());
        textNote.setText(data.getNote());

        this.displayTableOrder(dataOrders, tableOrdered);
    }

    void displayTableOrder(List<Order> dataOrders, JTable tableMain) {
        if (dataOrders == null) {
            return;
        }

        // Set table ordered
        for (Order dataOrder : dataOrders) {
            // Get order deatails
            int orderID = dataOrder.getOrderId();
            List<OrderDetail> dataDetails = new OrderDetailDAO().getByOrderID(orderID);

            for (OrderDetail dataDetail : dataDetails) {
                String productID = dataDetail.getProductID();
                Product dataProduct = new ProductDAO().getByID(productID);
                String productName = dataProduct.getProductName();
                int productQuantity = dataDetail.getProductQuantity();
                String productStatus = dataDetail.getProductStatus();

                // Get model
                DefaultTableModel table = (DefaultTableModel) tableMain.getModel();

                // Update model
                table.addRow(new Object[]{
                    productName + "    x " + productQuantity,
                    productStatus
                });
            }
        }
    }
}
