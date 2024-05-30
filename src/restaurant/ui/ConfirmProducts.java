package restaurant.ui;

import restaurent.dialog.reasonDeletionJDialog;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.*;
import java.util.List;
import javax.swing.*;
import javax.swing.table.*;
import java.text.SimpleDateFormat;
import java.util.concurrent.ExecutionException;
import jdk.jfr.Timestamp;

import restaurant.dao.OrdersDAO;
import restaurant.dao.ProductsDAO;
import restaurant.dao.OrderDetailsDAO;
import restaurant.entity.ProductsEntity;
import restaurant.entity.OrderDetailsEntity;

import restaurant.utils.Common;
import restaurant.utils.Dialog;
import static restaurant.utils.Common.createButton;
import static restaurant.ui.ConfirmProducts.DETAIL_ID_COLUMN_INDEX;

public class ConfirmProducts extends javax.swing.JPanel {

    private Main mainInstance;

    public ConfirmProducts(Main mainInstance) {
        this.mainInstance = mainInstance;
        initComponents();
        this.init();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabbedPanePay2 = new javax.swing.JTabbedPane();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tablePendingDishes = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablePendingDrinks = new javax.swing.JTable();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tableFinishedProducts = new javax.swing.JTable();

        tabbedPanePay2.setBackground(new java.awt.Color(255, 255, 255));
        tabbedPanePay2.setDoubleBuffered(true);
        tabbedPanePay2.setFocusCycleRoot(true);
        tabbedPanePay2.setFocusTraversalPolicyProvider(true);
        tabbedPanePay2.setFont(new java.awt.Font("Cascadia Code PL", 0, 14)); // NOI18N
        tabbedPanePay2.setInheritsPopupMenu(true);
        tabbedPanePay2.setOpaque(true);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setAutoscrolls(true);
        jPanel7.setFocusCycleRoot(true);
        jPanel7.setFocusTraversalPolicyProvider(true);
        jPanel7.setInheritsPopupMenu(true);

        tablePendingDishes.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        tablePendingDishes.setForeground(new java.awt.Color(51, 51, 51));
        tablePendingDishes.setModel(new javax.swing.table.DefaultTableModel(
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
        tablePendingDishes.setEditingColumn(1);
        tablePendingDishes.setFillsViewportHeight(true);
        tablePendingDishes.setFocusCycleRoot(true);
        tablePendingDishes.setGridColor(new java.awt.Color(255, 255, 255));
        tablePendingDishes.setRowHeight(50);
        jScrollPane7.setViewportView(tablePendingDishes);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 1258, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 549, Short.MAX_VALUE)
        );

        tabbedPanePay2.addTab("NHÀ BẾP ", new javax.swing.ImageIcon(getClass().getResource("/icon/chef.png")), jPanel7); // NOI18N

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        tablePendingDrinks.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        tablePendingDrinks.setForeground(new java.awt.Color(51, 51, 51));
        tablePendingDrinks.setModel(new javax.swing.table.DefaultTableModel(
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
        tablePendingDrinks.setFillsViewportHeight(true);
        tablePendingDrinks.setGridColor(new java.awt.Color(255, 255, 255));
        tablePendingDrinks.setRowHeight(50);
        tablePendingDrinks.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jScrollPane3.setViewportView(tablePendingDrinks);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1258, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 549, Short.MAX_VALUE)
        );

        tabbedPanePay2.addTab("QUẦY NƯỚC ", new javax.swing.ImageIcon(getClass().getResource("/icon/drink.png")), jPanel8); // NOI18N

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));

        tableFinishedProducts.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        tableFinishedProducts.setForeground(new java.awt.Color(51, 51, 51));
        tableFinishedProducts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên món", "Tên bàn", "Thời gian", "Trạng thái", "Mã chi tiết"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tableFinishedProducts.setAlignmentX(0.0F);
        tableFinishedProducts.setAlignmentY(0.0F);
        tableFinishedProducts.setFillsViewportHeight(true);
        tableFinishedProducts.setGridColor(new java.awt.Color(255, 255, 255));
        tableFinishedProducts.setRowHeight(50);
        tableFinishedProducts.setShowGrid(false);
        jScrollPane4.setViewportView(tableFinishedProducts);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 1258, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 549, Short.MAX_VALUE)
        );

        tabbedPanePay2.addTab("LỊCH SỬ ", new javax.swing.ImageIcon(getClass().getResource("/icon/history.png")), jPanel9); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(tabbedPanePay2, javax.swing.GroupLayout.PREFERRED_SIZE, 1258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(tabbedPanePay2, javax.swing.GroupLayout.PREFERRED_SIZE, 594, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTabbedPane tabbedPanePay2;
    private javax.swing.JTable tableFinishedProducts;
    private javax.swing.JTable tablePendingDishes;
    private javax.swing.JTable tablePendingDrinks;
    // End of variables declaration//GEN-END:variables

    int detailID;
    int selectedRow;
    static final int DETAIL_ID_COLUMN_INDEX = 3;
    List<OrderDetailsEntity> pendingProducts;
    List<OrderDetailsEntity> confirmedProducts;

    DefaultTableModel modelDrinks;
    DefaultTableModel modelDishes;
    DefaultTableModel modelProducts;

    void init() {
        // Tùy chỉnh bảng
        Common.customizeTable(tablePendingDishes, new int[]{});
        Common.customizeTable(tablePendingDrinks, new int[]{});
        Common.customizeTable(tableFinishedProducts, new int[]{});

        // Thiết lập cột nút cho bảng
        setupButtonColumn(tablePendingDishes, 3);
        setupButtonColumn(tablePendingDrinks, 3);

        // Khởi chạy luồng SwingWorker để truy vấn dữ liệu từ cơ sở dữ liệu
        new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                pendingProducts = new OrderDetailsDAO().getPendingProducts();
                confirmedProducts = new OrderDetailsDAO().getConfirmedProducts();
                return null;
            }

            @Override
            protected void done() {
                try {
                    get();
                    displayProductsInTables();
                } catch (InterruptedException | ExecutionException ex) {
                    ex.printStackTrace();
                }
            }
        }.execute();
    }

    // <--- Display products by kitchen
    void displayProductsInTables() {
        // Get model
        modelDrinks = (DefaultTableModel) tablePendingDrinks.getModel();
        modelDishes = (DefaultTableModel) tablePendingDishes.getModel();
        modelProducts = (DefaultTableModel) tableFinishedProducts.getModel();

        // Xóa tất cả các dòng trong bảng trước khi cập nhật dữ liệu mới
        modelDrinks.setRowCount(0);
        modelDishes.setRowCount(0);
        modelProducts.setRowCount(0);

        // Fetch pending and confirmed products
        pendingProducts = new OrderDetailsDAO().getPendingProducts();
        confirmedProducts = new OrderDetailsDAO().getConfirmedProducts();

        // Đặt model cho bảng 
        tablePendingDrinks.setModel(modelDrinks);
        tablePendingDishes.setModel(modelDishes);
        tableFinishedProducts.setModel(modelProducts);

        // Prepare data for pending and confirmed products table
        fillPendingProductsTable(modelDrinks, modelDishes);
        fillConfirmedProductsTable(modelProducts);
    }

    void fillPendingProductsTable(DefaultTableModel modelDrinks, DefaultTableModel modelDishes) {
        // Sắp xếp theo thời gian bắt đầu từ gần nhất
        pendingProducts.sort(Comparator.comparing(OrderDetailsEntity::getStartTime).reversed());

        // Thêm sản phẩm vào bảng tương ứng
        for (OrderDetailsEntity pendingProduct : pendingProducts) {
            // Get id detail
            int detailProductId = pendingProduct.getOrderDetailID();

            // Get name table by id table
            String tableDiningName = new OrdersDAO().getTableNameByOrderId(pendingProduct.getOrderID());

            // Get products in ordered
            String productId = pendingProduct.getProductID();
            int productQuantity = pendingProduct.getProductQuantity();
            String productLevel = !pendingProduct.getProductDesc().isEmpty() ? " (" + pendingProduct.getProductDesc() + ")" : "";
            String productTimeAdded = new SimpleDateFormat("HH:mm").format(pendingProduct.getStartTime());

            // Get info product
            ProductsEntity productEntity = new ProductsDAO().getById(productId);
            String productName = productEntity.getProductName();
            String productNameAndLevel = productName + productLevel + " x" + productQuantity;
            String productKitchenArea = productEntity.getKitchenArea();

            // Thêm sản phẩm vào bảng tương ứng (Khu bếp, Quầy nước)
            DefaultTableModel model = productKitchenArea.equals("Khu bếp") ? modelDishes : modelDrinks;
            model.addRow(new Object[]{
                productNameAndLevel,
                tableDiningName,
                productTimeAdded,
                detailProductId
            });
        }
    }

    void fillConfirmedProductsTable(DefaultTableModel modelProducts) {
        // Sắp xếp theo thời gian kết thúc từ gần nhất
        confirmedProducts.sort(Comparator.comparing(OrderDetailsEntity::getEndTime).reversed());

        // Thêm sản phẩm vào bảng đã xác nhận
        for (OrderDetailsEntity confirmedProduct : confirmedProducts) {
            // Get name table by id table
            String tableDiningName = new OrdersDAO().getTableNameByOrderId(confirmedProduct.getOrderID());

            // Get products in ordered
            String productId = confirmedProduct.getProductID();
            int productQuantity = confirmedProduct.getProductQuantity();
            String productStatus = confirmedProduct.getProductStatus();
            String productLevel = !confirmedProduct.getProductDesc().isEmpty() ? " (" + confirmedProduct.getProductDesc() + ")" : "";
            String productTimeAdded = new SimpleDateFormat("HH:mm").format(confirmedProduct.getStartTime());
            String productTimeUpdate = new SimpleDateFormat("HH:mm").format(confirmedProduct.getEndTime());

            // Get info product
            ProductsEntity productEntity = new ProductsDAO().getById(productId);
            String productName = productEntity.getProductName();
            String productNameAndLevel = productName + productLevel + " x" + productQuantity;

            // Add too table
            Object[] rowData = {
                productNameAndLevel,
                tableDiningName,
                productTimeAdded + " - " + productTimeUpdate,
                productStatus
            };
            modelProducts.addRow(rowData);
        }
    }
    // end --->    

    // <--- Init 2 button "Finish" and "Delete"
    void setupButtonColumn(JTable table, int columnNumber) {
        TableColumn column = table.getColumnModel().getColumn(columnNumber);
        column.setCellRenderer(new ButtonRenderer());
        column.setCellEditor(new ButtonEditor(table));
    }

    class ButtonRenderer extends JPanel implements TableCellRenderer {

        public ButtonRenderer() {
            setOpaque(true);
            setLayout(new FlowLayout(FlowLayout.CENTER, 5, 2));
            add(createButton("Hoàn thành", new Color(0, 153, 0), new Dimension(130, 44)));
            add(createButton("Xóa", new Color(255, 0, 51), new Dimension(60, 44)));
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            setBackground(isSelected ? table.getSelectionBackground() : table.getBackground());
            return this;
        }
    }

    class ButtonEditor extends DefaultCellEditor {

        private final JPanel panel;
        private final JButton finishButton;
        private final JButton deleteButton;

        public ButtonEditor(JTable table) {
            super(new JTextField());
            setClickCountToStart(1);
            panel = new JPanel();
            panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 2));

            // Create button
            deleteButton = createButton("Xóa", new Color(255, 0, 51), new Dimension(60, 44));
            finishButton = createButton("Hoàn thành", new Color(0, 153, 0), new Dimension(130, 44));

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
            OrderDetailsEntity model = new OrderDetailsDAO().getById(detailID);
            model.setProductStatus("Đã hoàn thành");
            new OrderDetailsDAO().update(model);

            // Remove selected row
            removeSelectedRowAndUpdateSelection(table, selectedRow);
            Dialog.warning(this, "In món thành công!");
        } catch (Exception e) {
            Dialog.warning(this, "Lỗi!");
        }

    }

    void handleClickDeleteButton(JTable table) {
        selectedRow = table.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(table, "Hãy chọn một dòng rồi ấn nút", "Xác nhận", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Sau khi cửa sổ đã đóng, lấy lý do đã chọn
        reasonDeletionJDialog reasonDialog = new reasonDeletionJDialog(null, true);
        reasonDialog.setVisible(true);
        String selectedReason = reasonDialog.getSelectedReason();

        // Get id detail product and current time
        detailID = (int) table.getValueAt(selectedRow, DETAIL_ID_COLUMN_INDEX);

        // Update delete order detail item
        OrderDetailsEntity model = new OrderDetailsDAO().getById(detailID);
        model.setProductStatus("Đã xóa");
        model.setNote(selectedReason);
        new OrderDetailsDAO().update(model);

        // Remove selected row
        removeSelectedRowAndUpdateSelection(table, selectedRow);
    }

    void removeSelectedRowAndUpdateSelection(JTable table, int selectedRow) {
        // Get model and remove row
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        int rowCount = model.getRowCount();

        if (rowCount <= 0) {
            JOptionPane.showMessageDialog(table, "Lỗi rồi!", "Xác nhận", JOptionPane.WARNING_MESSAGE);
            return;
        }

        model.removeRow(selectedRow);

        // Check if the table is still populated
        if (model.getRowCount() > 0) {
            int selectionIndex = Math.max(0, selectedRow - 1);
            table.setRowSelectionInterval(selectionIndex, selectionIndex);
        }
    }
    // end ---> 

}
