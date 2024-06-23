package restaurant.dialog;

import restaurant.dao.DiningTableDAO;
import restaurant.dao.InvoiceDAO;

public class WaitForPayJDialog extends javax.swing.JFrame {

    public WaitForPayJDialog() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        tableUnpaidInvoices = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tableUnpaidInvoicesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableUnpaidInvoicesMouseClicked
        //        handleClickTable(evt);
    }//GEN-LAST:event_tableUnpaidInvoicesMouseClicked

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WaitForPayJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            new WaitForPayJDialog().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tableUnpaidInvoices;
    // End of variables declaration//GEN-END:variables


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
