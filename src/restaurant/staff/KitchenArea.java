package restaurant.staff;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;

import java.util.List;
import java.util.Comparator;
import javax.swing.JTable;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.DefaultCellEditor;
import javax.swing.table.TableColumn;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import restaurant.utils.Common;
import restaurant.utils.Dialog;
import restaurant.main.MainStaff;
import restaurant.table.TableCustom;

import restaurant.dao.ProductDAO;
import restaurant.dao.DiningTableDAO;
import restaurant.dao.OrderDetailDAO;
import restaurant.entity.ProductEntity;
import restaurant.entity.DiningTableEntity;
import restaurant.entity.OrderDetailEntity;
import restaurant.dialog.HistoryProductsJDialog;
import restaurant.dialog.ReasonDeletionJDialog;
import static restaurant.utils.Common.createButton;
import static restaurant.staff.KitchenArea.DETAIL_ID_COLUMN_INDEX;

public class KitchenArea extends javax.swing.JPanel {

    private MainStaff mainStaff;

    public KitchenArea(MainStaff mainStaff) {
        this.mainStaff = mainStaff;
        initComponents();
        this.init();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tablePending = new javax.swing.JTable();
        btnHistory = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        btnSearch = new javax.swing.JButton();
        textSearch = new javax.swing.JTextField();
        btnSearch1 = new javax.swing.JButton();
        labelOrderTable = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        tablePending.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        tablePending.setForeground(new java.awt.Color(51, 51, 51));
        tablePending.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên món", "Tên bàn", "Thời gian", "Xác nhận", "Mã chi tiết"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tablePending.setEditingColumn(1);
        tablePending.setFillsViewportHeight(true);
        tablePending.setFocusCycleRoot(true);
        tablePending.setGridColor(new java.awt.Color(255, 255, 255));
        tablePending.setRowHeight(50);
        jScrollPane7.setViewportView(tablePending);
        if (tablePending.getColumnModel().getColumnCount() > 0) {
            tablePending.getColumnModel().getColumn(4).setMinWidth(0);
            tablePending.getColumnModel().getColumn(4).setPreferredWidth(0);
            tablePending.getColumnModel().getColumn(4).setMaxWidth(0);
        }

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

        btnReset.setBackground(new java.awt.Color(0, 153, 153));
        btnReset.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnReset.setForeground(new java.awt.Color(255, 255, 255));
        btnReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/icon/refreshWhile.png"))); // NOI18N
        btnReset.setToolTipText("Reset trang (Ctrl + F5)");
        btnReset.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        btnSearch.setBackground(new java.awt.Color(255, 51, 51));
        btnSearch.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSearch.setForeground(new java.awt.Color(255, 255, 255));
        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/icon/searchWhile.png"))); // NOI18N
        btnSearch.setToolTipText("Tìm kiếm");
        btnSearch.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        textSearch.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textSearchActionPerformed(evt);
            }
        });

        btnSearch1.setBackground(new java.awt.Color(255, 51, 51));
        btnSearch1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSearch1.setForeground(new java.awt.Color(255, 255, 255));
        btnSearch1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/icon/cart-while-24px.png"))); // NOI18N
        btnSearch1.setToolTipText("Tìm kiếm");
        btnSearch1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSearch1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearch1ActionPerformed(evt);
            }
        });

        labelOrderTable.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        labelOrderTable.setForeground(new java.awt.Color(255, 51, 51));
        labelOrderTable.setText("Chờ chế biến");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 1234, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnSearch1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelOrderTable)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(textSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnHistory, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(textSearch, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnSearch, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnReset, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnHistory, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(labelOrderTable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSearch1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 528, Short.MAX_VALUE)
                .addGap(12, 12, 12))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(12, 12, 12))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnHistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHistoryActionPerformed
        new HistoryProductsJDialog(null, true).setVisible(true);
    }//GEN-LAST:event_btnHistoryActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        mainStaff.displayStaffPanels(new KitchenArea(mainStaff));
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed

    }//GEN-LAST:event_btnSearchActionPerformed

    private void textSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textSearchActionPerformed

    }//GEN-LAST:event_textSearchActionPerformed

    private void btnSearch1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearch1ActionPerformed

    }//GEN-LAST:event_btnSearch1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHistory;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnSearch1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JLabel labelOrderTable;
    private javax.swing.JTable tablePending;
    private javax.swing.JTextField textSearch;
    // End of variables declaration//GEN-END:variables

    int detailID;
    int selectedRow;
    static final int DETAIL_ID_COLUMN_INDEX = 3;
    List<OrderDetailEntity> dataList;

    void init() {
        // Tùy chỉnh bảng
        TableCustom.apply(jScrollPane7, TableCustom.TableType.MULTI_LINE);
        Common.customizeTable(tablePending, new int[]{}, 50);
        setupButtonColumnConfirm(tablePending, 3);

        dataList = new OrderDetailDAO().getPendingProducts();
        this.fillTable(dataList);
    }

    void fillTable(List<OrderDetailEntity> dataList) {
        try {
            // Get model
            DefaultTableModel model = (DefaultTableModel) tablePending.getModel();
            model.setRowCount(0);

            // Fetch pending and confirmed products
            dataList = new OrderDetailDAO().getPendingProducts();
            tablePending.setModel(model);

            // Sắp xếp theo thời gian bắt đầu từ gần nhất
            dataList.sort(Comparator.comparing(OrderDetailEntity::getStartTime));

            // Thêm sản phẩm vào bảng tương ứng
            for (OrderDetailEntity dataItem : dataList) {
                // Get detail id and order id
                int detailProductId = dataItem.getOrderDetailID();
                int orderID = dataItem.getOrderID();

                // Get name table by id table
                DiningTableEntity tableDining = new DiningTableDAO().getByOrderID(orderID);
                String tableName = tableDining == null ? tableDining.getName() : "";

                // Get products in ordered
                String productId = dataItem.getProductID();
                int productQuantity = dataItem.getProductQuantity();
                String productTimeAdded = new SimpleDateFormat("HH:mm").format(dataItem.getStartTime());
                String productDesc = dataItem.getProductDesc();
                productDesc = (productDesc == null || productDesc.isEmpty()) ? "" : " ( " + productDesc + " )";

                // Get info product
                ProductEntity productEntity = new ProductDAO().getById(productId);
                String productName = productEntity.getProductName();
                String productNameAndLevel = productName + productDesc + " x" + productQuantity;

                // Thêm sản phẩm vào bảng 
                model.addRow(new Object[]{
                    productNameAndLevel,
                    tableName,
                    productTimeAdded,
                    detailProductId
                });
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // <--- Init 2 button "Finish" and "Delete"
    void setupButtonColumnConfirm(JTable table, int columnNumber) {
        TableColumn column = table.getColumnModel().getColumn(columnNumber);
        column.setCellRenderer(new ButtonRenderer(table));
        column.setCellEditor(new ButtonEditor(table));
    }

    class ButtonRenderer extends JPanel implements TableCellRenderer {

        public ButtonRenderer(JTable table) {
            setOpaque(true);
            setBackground(Color.white);
            setLayout(new FlowLayout(FlowLayout.CENTER, 5, 2));
            add(createButton("Hoàn thành", new Color(51, 153, 0), new Dimension(130, 44)));
            add(createButton("Xóa", new Color(255, 0, 51), new Dimension(60, 44)));
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            setBackground(isSelected ? table.getSelectionBackground() : Color.white);
            return this;
        }
    }

    class ButtonEditor extends DefaultCellEditor {

        private final JPanel panel;
        private final JTable table;
        private final JButton finishButton;
        private final JButton deleteButton;

        public ButtonEditor(JTable table) {
            super(new JTextField());
            this.table = table;
            setClickCountToStart(1);
            panel = new JPanel();
            panel.setBackground(Color.white);
            panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 2));

            // Create button
            deleteButton = createButton("Xóa", new Color(255, 0, 51), new Dimension(60, 44));
            finishButton = createButton("Hoàn thành", new Color(51, 153, 0), new Dimension(130, 44));

            // Handle click button
            finishButton.addActionListener((ActionEvent e) -> handleClickFinishButton(table));
            deleteButton.addActionListener((ActionEvent e) -> handleClickDeleteButton(table));

            // Add into panel
            panel.add(finishButton);
            panel.add(deleteButton);
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            return panel;
        }

        @Override
        public Object getCellEditorValue() {
            return "";
        }
    }
    // end --->

    // <--- Handle click button finish and delete
    void handleClickFinishButton(JTable table) {
        selectedRow = table.getSelectedRow();
        if (selectedRow == -1) {
            Dialog.warning(table, "\"Hãy chọn một dòng rồi ấn nút\"!");
            return;
        }

        try {
            // Get id detail product and update finish product
            detailID = (int) table.getValueAt(selectedRow, DETAIL_ID_COLUMN_INDEX);

            // Update finish order detail item
            OrderDetailEntity entity = new OrderDetailDAO().getById(detailID);
            entity.setProductStatus("Đã xử lý");
            new OrderDetailDAO().update(entity);

            // Remove selected row
            if (table.isEditing()) {
                table.getCellEditor().stopCellEditing();
            }
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.removeRow(selectedRow);

            // Message
            Dialog.warning(this, "In món thành công!");
        } catch (Exception e) {
            Dialog.warning(this, "Lỗi!");
        }

    }

    void handleClickDeleteButton(JTable table) {
        selectedRow = table.getSelectedRow();
        if (selectedRow == -1) {
            Dialog.warning(this, "Hãy chọn một dòng rồi ấn nút");
            return;
        }

        // Sau khi cửa sổ đã đóng, lấy lý do đã chọn
        ReasonDeletionJDialog reasonDialog = new ReasonDeletionJDialog(null, true);
        reasonDialog.setVisible(true);
        String selectedReason = reasonDialog.getSelectedReason();

        try {
            // Get id detail product and current time
            detailID = (int) table.getValueAt(selectedRow, DETAIL_ID_COLUMN_INDEX);

            // Update delete order detail item
            OrderDetailEntity entity = new OrderDetailDAO().getById(detailID);
            entity.setProductStatus("Đã hủy");
            entity.setNote(selectedReason);
            new OrderDetailDAO().update(entity);

            // Remove selected row
            if (table.isEditing()) {
                table.getCellEditor().stopCellEditing();
            }

            // Remove selected row
            if (table.isEditing()) {
                table.getCellEditor().stopCellEditing();
            }
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.removeRow(selectedRow);
        } catch (Exception e) {
            Dialog.warning(this, "Lỗi khi xóa dòng!");
        }
    }
    // end ---> 

}
