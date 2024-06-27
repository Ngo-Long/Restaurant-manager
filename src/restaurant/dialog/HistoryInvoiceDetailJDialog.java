package restaurant.dialog;

import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.List;
import restaurant.dao.DiningTableDAO;
import restaurant.dao.EmployeeDAO;
import restaurant.dao.OrderDAO;
import restaurant.dao.ProductDAO;
import restaurant.entity.DiningTableEntity;
import restaurant.entity.EmployeeEntity;
import restaurant.entity.InvoiceEntity;
import restaurant.entity.OrderDetailEntity;
import restaurant.entity.OrderEntity;
import restaurant.entity.ProductEntity;

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

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Bàn ăn:");

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
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
                    .addComponent(textNote, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
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
                    .addComponent(jLabel9)
                    .addComponent(labelStatus))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(textNote, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
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
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel labelEmployee;
    private javax.swing.JLabel labelStatus;
    private javax.swing.JLabel labelTable;
    private javax.swing.JLabel labelTime;
    private javax.swing.JTextField textNote;
    // End of variables declaration//GEN-END:variables

    String tableNamesStr;

    private void init() {
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(new Color(248, 248, 248));
    }

    public void displayDetailOrder(InvoiceEntity data) {
        System.out.println("Run...");
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy   HH:mm:ss");

        if (data == null) {
            this.setTitle("Chi tiết hóa đơn");
            labelTable.setText("Trống");
            labelEmployee.setText("Trống");
            labelTime.setText("Trống");
            labelStatus.setText("Trống");
            textNote.setText("");
            return;
        }

        this.setTitle("Chi tiết hóa đơn [" + data.getInvoiceID() + "]");

        // Get table name list
        List<DiningTableEntity> dataTables = new DiningTableDAO().getAllByInvoiceID(data.getInvoiceID());
        for (DiningTableEntity dateTable : dataTables) {
            tableNamesStr = String.join(" + ", dateTable.getName());
        }

        // Get order list and calculate the total number of orders
        List<OrderEntity> dataOrders = new OrderDAO().getAllByInvoiceId(data.getInvoiceID());
        int totalOrders = dataOrders.size();

        // Set name 
        EmployeeEntity employee = new EmployeeDAO().getById(data.getEmployeeID());
        String employeeName = employee.getFullName();

        labelTable.setText(tableNamesStr + " / " + totalOrders + " đơn");
        labelEmployee.setText(employeeName);
        labelTime.setText(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(data.getPaymentTime()));
        labelStatus.setText(data.getStatus());
        textNote.setText(data.getNote());
    }

}
