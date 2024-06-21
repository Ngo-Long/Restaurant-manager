package restaurant.staff;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;
import javax.swing.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import restaurant.dao.*;
import restaurant.dialog.OrderTableJDialog;
import restaurant.entity.*;
import restaurant.main.MainStaff;
import restaurant.utils.Dialog;
import restaurant.utils.Common;

public final class TableOrder extends javax.swing.JPanel {

    private MainStaff mainStaff;

    public TableOrder(MainStaff mainStaff) {
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
        scrollPaneTableDining = new javax.swing.JScrollPane();
        panelDiningTableList = new javax.swing.JPanel();
        textSearch = new javax.swing.JTextField();
        btnSearch2 = new javax.swing.JButton();
        btnHistory = new javax.swing.JButton();
        btnSearch = new javax.swing.JButton();

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

        scrollPaneTableDining.setBorder(null);
        scrollPaneTableDining.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        panelDiningTableList.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panelDiningTableListLayout = new javax.swing.GroupLayout(panelDiningTableList);
        panelDiningTableList.setLayout(panelDiningTableListLayout);
        panelDiningTableListLayout.setHorizontalGroup(
            panelDiningTableListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1254, Short.MAX_VALUE)
        );
        panelDiningTableListLayout.setVerticalGroup(
            panelDiningTableListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 565, Short.MAX_VALUE)
        );

        scrollPaneTableDining.setViewportView(panelDiningTableList);

        textSearch.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textSearchActionPerformed(evt);
            }
        });

        btnSearch2.setBackground(new java.awt.Color(0, 153, 153));
        btnSearch2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSearch2.setForeground(new java.awt.Color(255, 255, 255));
        btnSearch2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/refreshWhile.png"))); // NOI18N
        btnSearch2.setToolTipText("Reset trang (Ctrl + F5)");
        btnSearch2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSearch2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearch2ActionPerformed(evt);
            }
        });

        btnHistory.setBackground(new java.awt.Color(51, 204, 0));
        btnHistory.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnHistory.setForeground(new java.awt.Color(255, 255, 255));
        btnHistory.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/historyWhile.png"))); // NOI18N
        btnHistory.setToolTipText("Xem lịch sử gọi món");
        btnHistory.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnHistory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHistoryActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboboxArea, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(textSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSearch2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnHistory, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
            .addComponent(scrollPaneTableDining, javax.swing.GroupLayout.DEFAULT_SIZE, 1256, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comboboxArea, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(textSearch, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnSearch, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                        .addComponent(btnSearch2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnHistory, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scrollPaneTableDining, javax.swing.GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelBodyLayout = new javax.swing.GroupLayout(panelBody);
        panelBody.setLayout(panelBodyLayout);
        panelBodyLayout.setHorizontalGroup(
            panelBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBodyLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1256, Short.MAX_VALUE)
                .addGap(12, 12, 12))
        );
        panelBodyLayout.setVerticalGroup(
            panelBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBodyLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 596, Short.MAX_VALUE)
                .addGap(12, 12, 12))
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

    private void textSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textSearchActionPerformed

    }//GEN-LAST:event_textSearchActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed

    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnSearch2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearch2ActionPerformed
        mainStaff.displayStaffPanels(new TableOrder(mainStaff));
    }//GEN-LAST:event_btnSearch2ActionPerformed

    private void btnHistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHistoryActionPerformed
    }//GEN-LAST:event_btnHistoryActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHistory;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnSearch2;
    private javax.swing.JComboBox<String> comboboxArea;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel panelBody;
    private javax.swing.JPanel panelDiningTableList;
    private javax.swing.JScrollPane scrollPaneTableDining;
    private javax.swing.JTextField textSearch;
    // End of variables declaration//GEN-END:variables

    int orderCount;
    String totalConvert;
    String searchName = "";
    String selectedArea = "Tầng 1";
    JButton selectedTableButton;

    OrderEntity dataOrder;
    DiningTableEntity dataTable;
    List<DiningTableEntity> dataTables;

    ScheduledFuture<?> scheduledFuture;
    ExecutorService executorService = Executors.newFixedThreadPool(3);
    ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);

    void init() {
        Common.customizeScrollBar(scrollPaneTableDining);

        // Setup combobox
        setupMultipleCombobox();

        // Load list by search and classify when change
        initEventHandlers();
        loadDataByCriteria();
    }

    void updateStatus(String status) {
        String tableID = "";
        if (tableID.equals("")) {
            Dialog.warning(this, "Vui lòng chọn bàn muốn đổi trạng thái!");
            return;
        }

        dataOrder = new OrderDAO().getByTableId(tableID);
        if (dataOrder != null) {
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

    // <--- Load data
    void initEventHandlers() {
        // Attach event textSearch
        textSearch.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                loadDataByCriteria();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                loadDataByCriteria();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                loadDataByCriteria();
            }
        });

        // Attach event comboBoxArea
        ActionListener actionListener = (ActionEvent e) -> {
            loadDataByCriteria();
        };

        comboboxArea.addActionListener(actionListener);
    }

    public void loadDataByCriteria() {
        if (scheduledFuture != null && !scheduledFuture.isDone()) {
            scheduledFuture.cancel(false);
        }

        scheduledFuture = scheduledExecutorService.schedule(() -> {
            SwingUtilities.invokeLater(() -> {
                // Get info criterias
                String searchName = textSearch.getText().trim();
                String location = comboboxArea.getSelectedItem().toString();

                // Get data and load
                dataTables = new DiningTableDAO().searchByCriteria(searchName, location, "");
                loadDiningTables(dataTables);
            });
        }, 200, TimeUnit.MILLISECONDS);
    }

    public void loadDiningTables(List<DiningTableEntity> dataTables) {
        executorService.submit(() -> {
            SwingUtilities.invokeLater(() -> this.displayDiningTables(dataTables));
        });
    }
    // end --->

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
        tableButton.setBackground(new Color(255, 255, 255));
        tableButton.setPreferredSize(new Dimension(150, 150));
        tableButton.setHorizontalTextPosition(SwingConstants.CENTER);
        tableButton.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
        tableButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        tableButton.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255), 5, true));

        // Set background for status table
        setTableButtonColors(tableButton, diningTable.getStatus());

        // Add ActionListener to Call a method to display detailed information
        tableButton.addActionListener((ActionEvent e) -> {
            handleEventClickTableBtn(tableButton, diningTable);
        });

        return tableButton;
    }

    void handleEventClickTableBtn(JButton tableBtn, DiningTableEntity data) {
        // Display border bode when click
        if (selectedTableButton != null && selectedTableButton != tableBtn) {
            Common.setTableButtonBorder(selectedTableButton, false);
        }
        Common.setTableButtonBorder(selectedTableButton = tableBtn, true);

        // Init dialog
        OrderTableJDialog dialog = new OrderTableJDialog(null, true, mainStaff);

        // Transmit data via file orderTableDialog
        dialog.displayDetailTable(data);
        dialog.displayOrderedOfTable(data.getTableID());
        dialog.setLocationRelativeTo(null);

        // Open dialog
        dialog.setVisible(true);
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
    void setupMultipleCombobox() {
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
            dataTables = new DiningTableDAO().searchByCriteria("", selectedArea, "");
            this.loadDiningTables(dataTables); // load
        });

        // Reset default
        comboboxArea.setSelectedIndex(0);
    }
    // end --->   
}
