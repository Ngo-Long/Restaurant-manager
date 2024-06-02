package restaurant.dialog;

import java.awt.Color;
import java.util.Date;
import java.util.List;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import restaurant.dao.ProductDAO;
import restaurant.entity.InvoiceEntity;
import restaurant.entity.OrderDetailEntity;
import restaurant.entity.ProductEntity;
import restaurant.utils.Auth;
import restaurant.utils.Dialog;

public class BillJDialog extends javax.swing.JDialog {

    public BillJDialog(java.awt.Frame parent, boolean modal) {
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
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        jScrollPane3 = new javax.swing.JScrollPane();
        b = new javax.swing.JTextArea();

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
        setTitle("Xác nhận lý do hủy món");
        setBackground(new java.awt.Color(255, 255, 255));

        b.setColumns(20);
        b.setRows(5);
        b.setEnabled(false);
        b.setFocusable(false);
        jScrollPane3.setViewportView(b);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 273, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 533, Short.MAX_VALUE)
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
            java.util.logging.Logger.getLogger(BillJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            BillJDialog dialog = new BillJDialog(new javax.swing.JFrame(), true);
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
    private javax.swing.JTextArea b;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

    private void init() {
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(new Color(248, 248, 248));
        bill();
    }

    void bill() {
        if (Auth.invoice == null || Auth.orderDetails == null) {
            return;
        }

        // Lấy thông tin hóa đơn từ Auth.invoice
        int invoiceID = Auth.invoice.getInvoiceID();
        String employeeID = Auth.invoice.getEmployeeID();
        String paymentMethod = Auth.invoice.getPaymentMethod();
        Date paymentTime = Auth.invoice.getPaymentTime();
        int totalAmount = Auth.invoice.getTotalAmount();
        int tax = Auth.invoice.getTax();

        // Sử dụng StringBuilder để xây dựng chuỗi hiển thị hóa đơn
        StringBuilder billText = new StringBuilder();
        billText.append("=========================================\n")
                .append("                  HÓA ĐƠN\n")
                .append("=========================================\n")
                .append("Mã hóa đơn: ").append(invoiceID).append("\n")
                .append("Nhân viên: ").append(employeeID).append("\n")
                .append("Phương thức thanh toán: ").append(paymentMethod).append("\n")
                .append("Thời gian thanh toán: ").append(paymentTime).append("\n")
                .append("=========================================\n")
                .append("TT  Tên món\tSL\tĐơn giá\tThành tiền\n")
                .append("=========================================\n");

        // Trả về danh sách các món hàng
        int index = 1;
        List<OrderDetailEntity> dataDetails = Auth.orderDetails;

        for (OrderDetailEntity dataDetail : dataDetails) {
            // Trả về món ăn
            ProductEntity dataProduct = new ProductDAO().getById(dataDetail.getProductID());

            // Lấy thông tin
            String name = dataProduct.getProductName();
            int unitPrice = dataProduct.getPrice();
            int quantity = dataDetail.getProductQuantity();
            int totalPrice = quantity * unitPrice;

            billText.append(String.format("%-4d%-10s%-8d%-10d%-10d\n",
                    index++, name, quantity, unitPrice, totalPrice));
        }

        billText.append("=========================================\n")
                .append("Tổng cộng: ").append(totalAmount).append("\n")
                .append("Thuế: ").append(tax).append("\n")
                .append("=========================================\n")
                .append("Cảm ơn quý khách!");

        // Hiển thị chuỗi hóa đơn trong JTextArea b
        b.setText(billText.toString());
    }

}
