package restaurant.staff;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.*;
import java.util.List;
import javax.swing.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import restaurant.dao.*;
import restaurant.dialog.OrderTableJDialog;
import restaurant.entity.*;
import restaurant.main.MainStaff;
import restaurant.utils.Dialog;
import restaurant.utils.Common;

public final class OrderTables extends javax.swing.JPanel {

    private MainStaff mainStaff;

    public OrderTables(MainStaff mainStaff) {
        this.mainStaff = mainStaff;
        initComponents();
        this.init();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBody = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        comboboxArea = new javax.swing.JComboBox<>();
        btnEmpty = new javax.swing.JButton();
        btnStatusServing = new javax.swing.JButton();
        btnBooked = new javax.swing.JButton();
        scrollPaneTableDining = new javax.swing.JScrollPane();
        panelDiningTableList = new javax.swing.JPanel();

        panelBody.setToolTipText("");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(826, 592));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/filter1.png"))); // NOI18N

        comboboxArea.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        comboboxArea.setToolTipText("Ấn vô chọn khu vực");
        comboboxArea.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        comboboxArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboboxAreaActionPerformed(evt);
            }
        });

        btnEmpty.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnEmpty.setForeground(new java.awt.Color(51, 51, 51));
        btnEmpty.setText("Còn trống");
        btnEmpty.setBorder(null);
        btnEmpty.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEmpty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmptyActionPerformed(evt);
            }
        });

        btnStatusServing.setBackground(new java.awt.Color(255, 102, 102));
        btnStatusServing.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnStatusServing.setForeground(new java.awt.Color(51, 51, 51));
        btnStatusServing.setText("Đang phục vụ");
        btnStatusServing.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnStatusServing.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStatusServingActionPerformed(evt);
            }
        });

        btnBooked.setBackground(new java.awt.Color(255, 153, 51));
        btnBooked.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnBooked.setForeground(new java.awt.Color(51, 51, 51));
        btnBooked.setText("Đã đặt");
        btnBooked.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBooked.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBookedActionPerformed(evt);
            }
        });

        scrollPaneTableDining.setBorder(null);
        scrollPaneTableDining.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        panelDiningTableList.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panelDiningTableListLayout = new javax.swing.GroupLayout(panelDiningTableList);
        panelDiningTableList.setLayout(panelDiningTableListLayout);
        panelDiningTableListLayout.setHorizontalGroup(
            panelDiningTableListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1235, Short.MAX_VALUE)
        );
        panelDiningTableListLayout.setVerticalGroup(
            panelDiningTableListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 565, Short.MAX_VALUE)
        );

        scrollPaneTableDining.setViewportView(panelDiningTableList);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel5)
                .addGap(0, 0, 0)
                .addComponent(comboboxArea, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnEmpty, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnStatusServing, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBooked)
                .addGap(12, 12, 12))
            .addComponent(scrollPaneTableDining)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnStatusServing, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                        .addComponent(btnBooked, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEmpty, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(comboboxArea, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scrollPaneTableDining, javax.swing.GroupLayout.PREFERRED_SIZE, 533, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout panelBodyLayout = new javax.swing.GroupLayout(panelBody);
        panelBody.setLayout(panelBodyLayout);
        panelBodyLayout.setHorizontalGroup(
            panelBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBodyLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );
        panelBodyLayout.setVerticalGroup(
            panelBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBodyLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 591, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
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

    private void comboboxAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboboxAreaActionPerformed

    }//GEN-LAST:event_comboboxAreaActionPerformed

    private void btnEmptyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmptyActionPerformed
        updateStatus("Còn trống");
    }//GEN-LAST:event_btnEmptyActionPerformed

    private void btnStatusServingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStatusServingActionPerformed
        updateStatus("Đang phục vụ");
    }//GEN-LAST:event_btnStatusServingActionPerformed

    private void btnBookedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBookedActionPerformed
        updateStatus("Đã đặt");
    }//GEN-LAST:event_btnBookedActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBooked;
    private javax.swing.JButton btnEmpty;
    private javax.swing.JButton btnStatusServing;
    private javax.swing.JComboBox<String> comboboxArea;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel panelBody;
    private javax.swing.JPanel panelDiningTableList;
    private javax.swing.JScrollPane scrollPaneTableDining;
    // End of variables declaration//GEN-END:variables

    int orderCount;
    String totalConvert;
    String searchName = "";
    String selectedArea = "Tầng 1";
    JButton selectedTableButton;

    OrderEntity dataOrder;
    DiningTableEntity dataTable;
    List<DiningTableEntity> dataTables;
    List<OrderDetailEntity> dataOrderDetails;
    ExecutorService executorService = Executors.newFixedThreadPool(3);

    void init() {
        Common.customizeScrollBar(scrollPaneTableDining);

        dataTables = new DiningTableDAO().getAll();
        loadDiningTables(dataTables);

        setupComboboxTables();
        handleClickComboboxArea();
        comboboxArea.setSelectedIndex(0);
    }

    public void loadDiningTables(List<DiningTableEntity> dataTables) {
        executorService.submit(() -> {
            SwingUtilities.invokeLater(() -> displayDiningTables(dataTables));
        });
    }

    void updateStatus(String status) {
        String tableID = "";
        if (tableID.equals("")) {
            Dialog.warning(this, "Vui lòng chọn bàn muốn đổi trạng thái!");
            return;
        }

        dataOrderDetails = new OrderDetailDAO().getByTableId(tableID);
        if (!dataOrderDetails.isEmpty()) {
            Dialog.warning(this, "Bàn này đang có người ngồi!");
            return;
        }

        if (!Dialog.confirm(this, "Xác nhận đổi trạng thái thành \"" + status + "\"")) {
            return;
        }

        try {
            dataTable = new DiningTableDAO().getById(tableID);
            dataTable.setStatus(status);
            new DiningTableDAO().update(dataTable);
            displayDiningTables(new DiningTableDAO().getAll());
            Dialog.success(this, "Đổi trạng thái thành công!");
        } catch (Exception e) {
            Dialog.warning(this, "Đổi trạng thái thất bại!");
        }
    }

    // <--- Display and handle event table dining
    void displayDiningTables(List<DiningTableEntity> dataTables) {
        panelDiningTableList.removeAll(); // Reset 

        // Init GridBagLayout
        GridBagLayout gridBagLayout = new GridBagLayout();
        panelDiningTableList.setLayout(gridBagLayout);

        // Init gridbag 
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.insets = new Insets(0, 14, 20, 14);
        constraints.anchor = GridBagConstraints.NORTHWEST;

        int maxColumns = 7; // Số lượng cột tối đa trên mỗi hàng
        int columnCount = 0; // Biến đếm số lượng cột hiện tại

        // Iterate through the dining table list for the selected area
        for (DiningTableEntity dataItem : dataTables) {
            // Create and set colors based on status
            JButton tableButton = createTableButton(dataItem);

            // Đặt các ràng buộc cho thành phần
            constraints.gridwidth = 1;
            gridBagLayout.setConstraints(tableButton, constraints);
            if (++columnCount == maxColumns) {
                columnCount = 0;
                constraints.gridx = 0;
                constraints.gridy++;
            } else {
                constraints.gridx++;
            }

            panelDiningTableList.add(tableButton);
        }

        // Refresh the panel
        panelDiningTableList.revalidate();
        panelDiningTableList.repaint();
    }

    JButton createTableButton(DiningTableEntity diningTable) {
        // Create a button for a dining table with the icon
        java.net.URL imageURL = getClass().getResource("/icon/dining-room.png");
        ImageIcon icon = new ImageIcon(imageURL);
        JButton tableButton = new JButton(diningTable.getName(), icon);

        // Set the preferred size of the button based on the icon size
        tableButton.setForeground(new Color(30, 30, 30));
        tableButton.setPreferredSize(new Dimension(150, 150));
        tableButton.setBackground(new Color(255, 255, 255));
        tableButton.setHorizontalTextPosition(SwingConstants.CENTER);
        tableButton.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
        tableButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        tableButton.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255), 5, true));

        // Set background for status table
        setTableButtonColors(tableButton, diningTable.getStatus());

        // Add ActionListener to Call a method to display detailed information
        tableButton.addActionListener((ActionEvent e) -> {
            // Display border bode when click
            if (selectedTableButton != null && selectedTableButton != tableButton) {
                Common.setTableButtonBorder(selectedTableButton, false);
            }
            Common.setTableButtonBorder(selectedTableButton = tableButton, true);

            // Init dialog
            OrderTableJDialog orderTableDialog = new OrderTableJDialog(null, true, mainStaff);

            // Transmit data via file orderTableDialog
            orderTableDialog.displayDetailTable(diningTable);
            orderTableDialog.displayOrderedByTable(diningTable.getTableID());
            orderTableDialog.setLocationRelativeTo(new MainStaff());

            // Open dialog
            orderTableDialog.setVisible(true);
        });

        return tableButton;
    }

    void setTableButtonColors(JButton tableButton, String status) {
        if (status == null || tableButton == null) {
            return;
        }

        switch (status) {
            case "Đã đặt":
                tableButton.setBackground(new Color(255, 153, 51));
                break;
            case "Đang phục vụ":
                tableButton.setBackground(new Color(255, 102, 102));
                break;
            case "Còn trống":
                tableButton.setBackground(new Color(255, 255, 255));
                break;
        }
    }
    // end --->

    // <--- Handle event search and catogory
    void setupComboboxTables() {
        // Get all table list
        List<DiningTableEntity> dataAllTables = new DiningTableDAO().getAll();

        // Create a DefaultComboBoxModel 
        DefaultComboBoxModel<String> comboBoxModelArea = new DefaultComboBoxModel<>();

        // Create a Set to store unique area names
        Set<String> areaSet = new HashSet<>();

        // Collect unique area names
        for (DiningTableEntity dataTable : dataAllTables) {
            areaSet.add(dataTable.getLocation());
        }

        // Convert the Set to a sorted array
        areaSet.stream().sorted().forEach(comboBoxModelArea::addElement);

        // Set the ComboBoxModel to the comboBox
        comboboxArea.setModel(comboBoxModelArea);
    }

    void handleClickComboboxArea() {
        // Attach event
        comboboxArea.addActionListener((ActionEvent e) -> {
            // Get the selected area
            selectedArea = (String) comboboxArea.getSelectedItem();
            dataTables = new DiningTableDAO().searchByAreaAndName(selectedArea, "");
            this.loadDiningTables(dataTables); // load
        });

        // Reset default
        comboboxArea.setSelectedIndex(0);
    }
    // end --->   
}
