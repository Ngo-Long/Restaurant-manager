package restaurant.dialog;

import java.awt.Color;
import java.util.List;
import java.text.SimpleDateFormat;
import javax.swing.SwingUtilities;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

import java.util.Set;
import java.util.Date;
import java.util.HashSet;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledExecutorService;

import restaurant.utils.Common;
import restaurant.utils.ColumnTable;
import restaurant.table.TableCustom;
import restaurant.dao.InvoiceDAO;
import restaurant.dao.EmployeeDAO;
import restaurant.entity.InvoiceEntity;
import restaurant.entity.EmployeeEntity;
import static restaurant.utils.Common.addCommasToNumber;
import static restaurant.utils.Common.getRealText;

public final class HistoryInvoicesJDialog extends javax.swing.JDialog {

    public HistoryInvoicesJDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.init();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jComboBox1 = new javax.swing.JComboBox<>();
        textSearch = new javax.swing.JTextField();
        textStartDate = new com.toedter.calendar.JDateChooser();
        textEndDate = new com.toedter.calendar.JDateChooser();
        cbStatus = new javax.swing.JComboBox<>();
        btnSearch = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tableInvoices = new javax.swing.JTable();
        cbKitchen = new javax.swing.JComboBox<>();

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

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Lịch sử thanh toán");
        setBackground(new java.awt.Color(51, 102, 255));

        textSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textSearchActionPerformed(evt);
            }
        });

        textStartDate.setBackground(new java.awt.Color(255, 255, 255));
        textStartDate.setToolTipText("Ngày");
        textStartDate.setDateFormatString("dd/MM/yyyy");
        textStartDate.setFocusable(false);
        textStartDate.setFont(new java.awt.Font("Be Vietnam Pro", 0, 13)); // NOI18N

        textEndDate.setBackground(new java.awt.Color(255, 255, 255));
        textEndDate.setToolTipText("Ngày");
        textEndDate.setDateFormatString("dd/MM/yyyy");
        textEndDate.setFocusable(false);
        textEndDate.setFont(new java.awt.Font("Be Vietnam Pro", 0, 13)); // NOI18N

        cbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbStatus.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnSearch.setBackground(new java.awt.Color(255, 51, 51));
        btnSearch.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSearch.setForeground(new java.awt.Color(255, 255, 255));
        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/searchWhile.png"))); // NOI18N
        btnSearch.setToolTipText("Tìm kiếm");
        btnSearch.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        btnReset.setBackground(new java.awt.Color(0, 153, 153));
        btnReset.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnReset.setForeground(new java.awt.Color(255, 255, 255));
        btnReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/refreshWhile.png"))); // NOI18N
        btnReset.setToolTipText("Reset trang (Ctrl + F5)");
        btnReset.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        tableInvoices.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        tableInvoices.setForeground(new java.awt.Color(51, 51, 51));
        tableInvoices.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã HD", "Nhân viên", "Bàn ăn", "Thời gian", "Tổng tiền", "Trạng thái", "Tác vụ"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tableInvoices.setAlignmentX(0.0F);
        tableInvoices.setAlignmentY(0.0F);
        tableInvoices.setFillsViewportHeight(true);
        tableInvoices.setGridColor(new java.awt.Color(255, 255, 255));
        tableInvoices.setRowHeight(50);
        jScrollPane4.setViewportView(tableInvoices);
        if (tableInvoices.getColumnModel().getColumnCount() > 0) {
            tableInvoices.getColumnModel().getColumn(0).setPreferredWidth(44);
            tableInvoices.getColumnModel().getColumn(1).setPreferredWidth(110);
            tableInvoices.getColumnModel().getColumn(3).setPreferredWidth(120);
            tableInvoices.getColumnModel().getColumn(4).setPreferredWidth(80);
        }

        cbKitchen.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbKitchen.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(textSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(textStartDate, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textEndDate, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbKitchen, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(textEndDate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(textSearch, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(textStartDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbKitchen, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cbStatus, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnReset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textSearchActionPerformed

    }//GEN-LAST:event_textSearchActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed

    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        dispose();
        new HistoryInvoicesJDialog(null, true).setVisible(true);
    }//GEN-LAST:event_btnResetActionPerformed

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HistoryInvoicesJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            HistoryInvoicesJDialog dialog = new HistoryInvoicesJDialog(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSearch;
    private javax.swing.JComboBox<String> cbKitchen;
    private javax.swing.JComboBox<String> cbStatus;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tableInvoices;
    private com.toedter.calendar.JDateChooser textEndDate;
    private javax.swing.JTextField textSearch;
    private com.toedter.calendar.JDateChooser textStartDate;
    // End of variables declaration//GEN-END:variables

    final String PLACEHOLDER = "Tìm theo tên bàn";
    List<InvoiceEntity> dataInvoices;
    ScheduledFuture<?> scheduledFuture;
    ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);

    void init() {
        // Set system
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(new Color(255, 255, 255));

        // Set table
        TableCustom.apply(jScrollPane4, TableCustom.TableType.MULTI_LINE);
        Common.customizeTable(tableInvoices, new int[]{1}, 40);
        Common.addPlaceholder(textSearch, PLACEHOLDER);

        // Set combobox
        setupComboboxTables();
        ColumnTable.setupDetailButtonColumn(tableInvoices, 6);

        // Set today on JDateChooser
        textEndDate.setDate(new Date());
        textStartDate.setDate(new Date());

        // Load data
        loadDataByCriteria();
        btnSearch.addActionListener((java.awt.event.ActionEvent evt1) -> {
            loadDataByCriteria();
        });
    }

    void setupComboboxTables() {
        // Get all list
        List<InvoiceEntity> dataList = new InvoiceDAO().getAll();

        // Create a modal 
        DefaultComboBoxModel<String> modalStatus = new DefaultComboBoxModel<>();
        modalStatus.addElement("--Trạng thái--");

        DefaultComboBoxModel<String> modalPaymentMethod = new DefaultComboBoxModel<>();
        modalPaymentMethod.addElement("--PP thanh toán--");

        // Set only 
        Set<String> setStatus = new HashSet<>();
        Set<String> setPaymentMethod = new HashSet<>();
        for (InvoiceEntity dataItem : dataList) {
            if (!"Chờ thanh toán".equals(dataItem.getStatus())) {
                setStatus.add(dataItem.getStatus());
            }
            setPaymentMethod.add(dataItem.getPaymentMethod());
        }

        // Convert the Set to an array
        String[] statusList = setStatus.toArray(new String[0]);
        for (String statusItem : statusList) {
            modalStatus.addElement(statusItem);
        }

        String[] payMethodList = setPaymentMethod.toArray(new String[0]);
        for (String payMethodItem : payMethodList) {
            modalPaymentMethod.addElement(payMethodItem);
        }

        // Set to the comboBox
        cbStatus.setModel(modalStatus);
        cbKitchen.setModel(modalPaymentMethod);
    }

    // <--- Load data
    void loadDataByCriteria() {
        if (scheduledFuture != null && !scheduledFuture.isDone()) {
            scheduledFuture.cancel(false);
        }

        scheduledFuture = scheduledExecutorService.schedule(() -> {
            SwingUtilities.invokeLater(() -> {
                // Get search text
                String keyword = getRealText(textSearch, PLACEHOLDER).trim();

                // Get category
                String selectedStatus = (String) cbStatus.getSelectedItem();
                if (selectedStatus.equals("--Trạng thái--")) {
                    selectedStatus = "";
                }

                String selectedKitchen = (String) cbKitchen.getSelectedItem();
                if (selectedKitchen.equals("--PP thanh toán--")) {
                    selectedKitchen = "";
                }

                // Định dạng ngày tháng thành chuỗi "năm-tháng-ngày"
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                String startDate = dateFormat.format(textStartDate.getDate());
                String endDate = dateFormat.format(textEndDate.getDate());

                // Get data and display
                dataInvoices = new InvoiceDAO().searchByCriteria(startDate, endDate,
                        selectedStatus, selectedKitchen, keyword, keyword);
                this.fillTable(dataInvoices);
            });
        }, 200, TimeUnit.MILLISECONDS);
    }

    void fillTable(List<InvoiceEntity> dataList) {
        System.out.println("Đang load dữ liệu lịch sử hóa đơn từ cơ sở dữ liệu...");

        // Display table
        DefaultTableModel model = (DefaultTableModel) tableInvoices.getModel();
        model.setRowCount(0);

        // Sắp xếp theo thời gian kết thúc từ gần nhất
        dataInvoices.sort(Comparator.comparing(InvoiceEntity::getPaymentTime).reversed());

        // Load data into the table 
        for (InvoiceEntity dataItem : dataList) {
            // Get table name list
            List<String> tableNames = new InvoiceDAO().getTableNamesByInvoiceID(dataItem.getInvoiceID());
            String tableNamesStr = String.join(" + ", tableNames);

            // Set name 
            EmployeeEntity employee = new EmployeeDAO().getById(dataItem.getEmployeeID());
            String employeeName = employee.getFullName();

            // Set total 
            String totalConvert = addCommasToNumber(String.valueOf(dataItem.getTotalAmount())) + "đ";

            model.addRow(new Object[]{
                dataItem.getInvoiceID(),
                employeeName,
                tableNamesStr,
                new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(dataItem.getPaymentTime()),
                totalConvert,
                dataItem.getStatus()
            });
        }

        // Reset table UI
        tableInvoices.repaint();
        tableInvoices.revalidate();
    }
    // end --->

}