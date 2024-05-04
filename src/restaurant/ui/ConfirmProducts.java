package restaurant.ui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.*;
import java.util.List;
import javax.swing.*;
import javax.swing.table.*;
import java.text.SimpleDateFormat;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import restaurant.dao.OrdersDAO;
import restaurant.dao.ProductsDAO;
import restaurant.dao.OrderDetailsDAO;
import restaurant.entity.ProductsEntity;
import restaurant.entity.OrderDetailsEntity;
import restaurant.utils.Common;
import static restaurant.utils.Common.createButton;

public final class ConfirmProducts extends javax.swing.JFrame {

    int detailID;
    int selectedRow;
    String selectedReason = "";
    private DefaultTableModel modelDrinks;
    private DefaultTableModel modelDishes;
    private DefaultTableModel modelProducts;
    private static final int DETAIL_ID_COLUMN_INDEX = 3;
    private List<OrderDetailsEntity> pendingProducts;
    private List<OrderDetailsEntity> confirmedProducts;
    Map<String, String> userInfo = Common.getUserInfo();

    public ConfirmProducts(Map<String, String> userInfo) {
        initComponents();
        displayProductsInTables();

        Common.initClock(labelHouse);
        Common.displayUserInfoBar(userInfo, labelAccount, labelPosition);
        Common.setImage("D:\\Workspaces\\Java\\Restaurant-manager\\src\\restaurant\\img\\logo.png", labelLogo);
        Common.customizeTable(tablePendingDishes, new int[]{});
        Common.customizeTable(tablePendingDrinks, new int[]{});
        Common.customizeTable(tableFinishedProducts, new int[]{});
        setupButtonColumn(tablePendingDishes, 3);
        setupButtonColumn(tablePendingDrinks, 3);

    }

    private void openFullScreenWindow(JFrame window) {
        window.setExtendedState(JFrame.MAXIMIZED_BOTH);
        window.setVisible(true);
        this.dispose();
    }

    private void displayProductsInTables() {
        // Fetch pending and confirmed products
        pendingProducts = new OrderDetailsDAO().getPendingProducts();
        confirmedProducts = new OrderDetailsDAO().getConfirmedProducts();

        // Get model
        modelDrinks = (DefaultTableModel) tablePendingDrinks.getModel();
        modelDishes = (DefaultTableModel) tablePendingDishes.getModel();
        modelProducts = (DefaultTableModel) tableFinishedProducts.getModel();

        // Prepare data for pending and confirmed products table
        fillPendingProductsTable(modelDrinks, modelDishes);
        fillConfirmedProductsTable(modelProducts);

        // Đặt model cho bảng 
        tablePendingDrinks.setModel(modelDrinks);
        tablePendingDishes.setModel(modelDishes);
        tableFinishedProducts.setModel(modelProducts);
    }

    private void fillPendingProductsTable(DefaultTableModel modelDrinks, DefaultTableModel modelDishes) {
        // Sắp xếp theo thời gian bắt đầu từ gần nhất
        Collections.sort(pendingProducts, (product1, product2)
                -> product2.getStartTime().compareTo(product1.getStartTime())
        );

        // Get data from list Confirmed products in model
        for (OrderDetailsEntity pendingProduct : pendingProducts) {
            // Get id detail
            int detailProductId = pendingProduct.getOrderDetailID();

            // Get name table by id table
            String tableDiningName = new OrdersDAO().getTableNameByOrderId(pendingProduct.getOrderID());

            // Get info detail
            String productId = pendingProduct.getProductID();
            int productQuantity = pendingProduct.getProductQuantity();
            String productLevel = !pendingProduct.getProductDesc().isEmpty() ? " (" + pendingProduct.getProductDesc() + ")" : "";
            String productTimeAdded = new SimpleDateFormat("HH:mm").format(pendingProduct.getStartTime());

            // Get info dish
            ProductsEntity productEntity = new ProductsDAO().getById(productId);
            String productName = productEntity.getProductName();
            String productNameAndLevel = productName + productLevel + " x" + productQuantity;
            String productKitchenArea = productEntity.getKitchenArea();

            // Thêm sản phẩm vào bảng tương ứng
            if (productKitchenArea.equals("Khu bếp")) {
                modelDishes.addRow(new Object[]{
                    productNameAndLevel,
                    tableDiningName,
                    productTimeAdded,
                    detailProductId
                });
            } else if (productKitchenArea.equals("Quầy nước")) {
                modelDrinks.addRow(new Object[]{
                    productNameAndLevel,
                    tableDiningName,
                    productTimeAdded,
                    detailProductId
                });
            }
        }
    }

    private void fillConfirmedProductsTable(DefaultTableModel modelProducts) {
        // Sắp xếp theo thời gian kết thúc từ gần nhất
        Collections.sort(confirmedProducts, (product1, product2)
                -> product2.getEndTime().compareTo(product1.getEndTime())
        );

        // Get data from list Confirmed products in model
        for (OrderDetailsEntity confirmedProduct : confirmedProducts) {
            // Get name table by id table
            String tableDiningName = new OrdersDAO().getTableNameByOrderId(confirmedProduct.getOrderID());

            // Get info detail
            String productId = confirmedProduct.getProductID();
            int productQuantity = confirmedProduct.getProductQuantity();
            String productStatus = confirmedProduct.getProductStatus();
            String productLevel = !confirmedProduct.getProductDesc().isEmpty() ? " (" + confirmedProduct.getProductDesc() + ")" : "";
            String productTimeAdded = new SimpleDateFormat("HH:mm").format(confirmedProduct.getStartTime());
            String productTimeUpdate = new SimpleDateFormat("HH:mm").format(confirmedProduct.getEndTime());

            // Get info dish
            ProductsEntity productEntity = new ProductsDAO().getById(productId);
            String productName = productEntity.getProductName();
            String productNameAndLevel = productName + productLevel + " x" + productQuantity;

            Object[] rowData = {
                productNameAndLevel,
                tableDiningName,
                productTimeAdded + " - " + productTimeUpdate,
                productStatus
            };

            // Add row to model
            modelProducts.addRow(rowData);
        }
    }

    private void resetTables() {
        // Xóa tất cả các dòng trong bảng
        modelDrinks.setRowCount(0);
        modelDishes.setRowCount(0);
        modelProducts.setRowCount(0);

        // Cập nhật lại dữ liệu mới
        displayProductsInTables();
    }

    // Init 2 button "Finish" and "Delete"
    public void setupButtonColumn(JTable table, int columnNumber) {
        TableColumn column = table.getColumnModel().getColumn(columnNumber);
        column.setCellRenderer(new ButtonRenderer());
        column.setCellEditor(new ButtonEditor(table));
    }

    private class ButtonRenderer extends JPanel implements TableCellRenderer {

        private final JButton finishButton;
        private final JButton deleteButton;

        public ButtonRenderer() {
            setOpaque(true);
            setLayout(new FlowLayout(FlowLayout.CENTER, 5, 2));
            deleteButton = createButton("Xóa", new Color(255, 100, 0), new Dimension(60, 44));
            finishButton = createButton("Hoàn thành", new Color(51, 153, 255), new Dimension(130, 44));
            add(finishButton);
            add(deleteButton);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            setBackground(isSelected ? table.getSelectionBackground() : table.getBackground());
            return this;
        }
    }

    private class ButtonEditor extends DefaultCellEditor {

        private final JPanel panel;
        private final JButton finishButton;
        private final JButton deleteButton;

        public ButtonEditor(JTable table) {
            super(new JTextField());
            setClickCountToStart(1);
            panel = new JPanel();
            panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 2));

            // Create button
            deleteButton = createButton("Xóa", new Color(255, 100, 0), new Dimension(60, 44));
            finishButton = createButton("Hoàn thành", new Color(51, 153, 255), new Dimension(130, 44));

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

    private void removeSelectedRowAndUpdateSelection(JTable table, int selectedRow) {
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

        resetTables();
    }

    private void handleClickFinishButton(JTable table) {
        selectedRow = table.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(table, "Hãy chọn một dòng rồi ấn nút", "Xác nhận", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Get id detail product and update finish product
        detailID = (int) table.getValueAt(selectedRow, DETAIL_ID_COLUMN_INDEX);
        new OrderDetailsDAO().updateProductFinished(detailID);

        // Remove selected row
        removeSelectedRowAndUpdateSelection(table, selectedRow);
        JOptionPane.showMessageDialog(null, "In món thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
    }

    private void handleClickDeleteButton(JTable table) {
        selectedRow = table.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(table, "Hãy chọn một dòng rồi ấn nút", "Xác nhận", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Get id detail product 
        detailID = (int) table.getValueAt(selectedRow, DETAIL_ID_COLUMN_INDEX);

        // Hiển thị hộp thoại
        JDialog deleteDialog = new JDialog();
        deleteDialog.setTitle("Xác nhận xóa");
        deleteDialog.setSize(300, 400);
        deleteDialog.setLocationRelativeTo(null);
        deleteDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        //  Xác nhận xóa và nhận lí do
        JPanel reasonPanel = createDeleteConfirmationPanel(deleteDialog, detailID);
        deleteDialog.setContentPane(reasonPanel);
        deleteDialog.setVisible(true);
    }

    public JPanel createDeleteConfirmationPanel(JDialog deleteDialog, int detailID) {
        // Create panel main
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 10, 10, 10));

        // Create panel info
        JPanel checkBoxPanel = new JPanel();
        checkBoxPanel.setLayout(new BoxLayout(checkBoxPanel, BoxLayout.Y_AXIS));

        // Chỉ cho phép chọn một checkbox
        ButtonGroup group = new ButtonGroup();

        // Add JCheckBox into checkBoxPanel
        JCheckBox[] reasons = new JCheckBox[]{
            createCheckBox("Khách đợi lâu"),
            createCheckBox("Khác không hài lòng"),
            createCheckBox("Khách đổi món"),
            createCheckBox("Khác hủy món"),
            createCheckBox("Hết nguyên liệu"),
            createCheckBox("Nhân viên ghi sai đơn"),
        };

        // Add spacing after each checkbox
        for (JCheckBox reason : reasons) {
            group.add(reason);
            checkBoxPanel.add(reason);
            checkBoxPanel.add(Box.createVerticalStrut(10));
        }

        // Create other reson panel
        JPanel otherReasonPanel = createOtherReasonPanel();
        checkBoxPanel.add(otherReasonPanel);

        // Create button panel: 
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton cancelButton = createButton("Đóng", Color.WHITE, new Dimension(64, 34));
        JButton confirmatRemoveBtn = createButton("Xác nhận", new Color(255, 100, 0), new Dimension(90, 34));

        // Customize button appearance
        cancelButton.setForeground(Color.BLACK);
        cancelButton.setFont(new Font("SansSerif", Font.PLAIN, 14));
        confirmatRemoveBtn.setFont(new Font("SansSerif", Font.PLAIN, 14));

        // Confirmation selected reason
        confirmatRemoveBtn.addActionListener((ActionEvent e) -> {
            for (JCheckBox reason : reasons) {
                if (reason.isSelected()) {
                    selectedReason = reason.getText();
                    break;
                }
            }

            // Update product remove
            new OrderDetailsDAO().updateProductRemove(detailID, selectedReason);
            resetTables();
            deleteDialog.dispose();
        });

        // Button cancel
        cancelButton.addActionListener(e -> deleteDialog.dispose());

        // Add into panel
        buttonPanel.add(confirmatRemoveBtn);
        buttonPanel.add(cancelButton);
        panel.add(checkBoxPanel, BorderLayout.CENTER);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        return panel;
    }

    private JPanel createOtherReasonPanel() {
        JPanel otherReasonPanel = new JPanel(new BorderLayout());
        JTextField textField = new JTextField();

        textField.setFont(textField.getFont().deriveFont(16f));
        otherReasonPanel.add(textField);
        otherReasonPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        otherReasonPanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(EtchedBorder.LOWERED), "Lí do khác",
                TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION,
                new Font("SansSerif", Font.PLAIN, 16))
        );

        return otherReasonPanel;
    }

    private static JCheckBox createCheckBox(String text) {
        JCheckBox checkBox = new JCheckBox(text);
        checkBox.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 16));
        return checkBox;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnDinnerTable = new javax.swing.JButton();
        btnOrder = new javax.swing.JButton();
        btnPay = new javax.swing.JButton();
        btnConfirm = new javax.swing.JButton();
        btnStaff = new javax.swing.JButton();
        btnClient = new javax.swing.JButton();
        btnAccount = new javax.swing.JButton();
        btnOverview = new javax.swing.JButton();
        btnCallTable = new javax.swing.JButton();
        btnReport = new javax.swing.JButton();
        btnWarehouse = new javax.swing.JButton();
        labelLogo = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        labelHouse = new javax.swing.JLabel();
        labelPosition = new javax.swing.JLabel();
        labelAccount = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tablePendingDishes = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablePendingDrinks = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tableFinishedProducts = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản lí nhân viên");
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(0, 51, 102));
        jPanel1.setForeground(new java.awt.Color(51, 51, 255));

        btnDinnerTable.setBackground(new java.awt.Color(0, 51, 102));
        btnDinnerTable.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnDinnerTable.setForeground(new java.awt.Color(255, 255, 255));
        btnDinnerTable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dining-table.png"))); // NOI18N
        btnDinnerTable.setText("Bàn ăn");
        btnDinnerTable.setBorder(null);
        btnDinnerTable.setBorderPainted(false);
        btnDinnerTable.setContentAreaFilled(false);
        btnDinnerTable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDinnerTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDinnerTableActionPerformed(evt);
            }
        });

        btnOrder.setBackground(new java.awt.Color(0, 51, 102));
        btnOrder.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnOrder.setForeground(new java.awt.Color(255, 255, 255));
        btnOrder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/online-order.png"))); // NOI18N
        btnOrder.setText("Order");
        btnOrder.setBorder(null);
        btnOrder.setBorderPainted(false);
        btnOrder.setContentAreaFilled(false);
        btnOrder.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrderActionPerformed(evt);
            }
        });

        btnPay.setBackground(new java.awt.Color(0, 51, 102));
        btnPay.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnPay.setForeground(new java.awt.Color(255, 255, 255));
        btnPay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/pay.png"))); // NOI18N
        btnPay.setText("Thanh toán");
        btnPay.setBorder(null);
        btnPay.setBorderPainted(false);
        btnPay.setContentAreaFilled(false);
        btnPay.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPayActionPerformed(evt);
            }
        });

        btnConfirm.setBackground(new java.awt.Color(0, 51, 102));
        btnConfirm.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnConfirm.setForeground(new java.awt.Color(255, 255, 255));
        btnConfirm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/customer.png"))); // NOI18N
        btnConfirm.setText("Xác nhận món");
        btnConfirm.setBorder(null);
        btnConfirm.setBorderPainted(false);
        btnConfirm.setContentAreaFilled(false);
        btnConfirm.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmActionPerformed(evt);
            }
        });

        btnStaff.setBackground(new java.awt.Color(0, 51, 102));
        btnStaff.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnStaff.setForeground(new java.awt.Color(255, 255, 255));
        btnStaff.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/staff.png"))); // NOI18N
        btnStaff.setText("Nhân viên");
        btnStaff.setBorder(null);
        btnStaff.setBorderPainted(false);
        btnStaff.setContentAreaFilled(false);
        btnStaff.setCursor(new java.awt.Cursor(java.awt.Cursor.MOVE_CURSOR));
        btnStaff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStaffActionPerformed(evt);
            }
        });

        btnClient.setBackground(new java.awt.Color(0, 51, 102));
        btnClient.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnClient.setForeground(new java.awt.Color(255, 255, 255));
        btnClient.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/client.png"))); // NOI18N
        btnClient.setText("Khách hàng");
        btnClient.setBorder(null);
        btnClient.setBorderPainted(false);
        btnClient.setContentAreaFilled(false);
        btnClient.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClientActionPerformed(evt);
            }
        });

        btnAccount.setBackground(new java.awt.Color(0, 51, 102));
        btnAccount.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAccount.setForeground(new java.awt.Color(255, 255, 255));
        btnAccount.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/settings.png"))); // NOI18N
        btnAccount.setText("Tài khoản");
        btnAccount.setBorder(null);
        btnAccount.setBorderPainted(false);
        btnAccount.setContentAreaFilled(false);
        btnAccount.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAccountActionPerformed(evt);
            }
        });

        btnOverview.setBackground(new java.awt.Color(0, 51, 102));
        btnOverview.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnOverview.setForeground(new java.awt.Color(255, 255, 255));
        btnOverview.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Home.png"))); // NOI18N
        btnOverview.setText("Tổng quan");
        btnOverview.setBorder(null);
        btnOverview.setBorderPainted(false);
        btnOverview.setContentAreaFilled(false);
        btnOverview.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnOverview.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOverviewActionPerformed(evt);
            }
        });

        btnCallTable.setBackground(new java.awt.Color(0, 51, 102));
        btnCallTable.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCallTable.setForeground(new java.awt.Color(255, 255, 255));
        btnCallTable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/phone-call.png"))); // NOI18N
        btnCallTable.setText("Đặt bàn");
        btnCallTable.setBorder(null);
        btnCallTable.setBorderPainted(false);
        btnCallTable.setContentAreaFilled(false);
        btnCallTable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCallTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCallTableActionPerformed(evt);
            }
        });

        btnReport.setBackground(new java.awt.Color(0, 51, 102));
        btnReport.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnReport.setForeground(new java.awt.Color(255, 255, 255));
        btnReport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Statistics.png"))); // NOI18N
        btnReport.setText("Báo cáo");
        btnReport.setBorder(null);
        btnReport.setBorderPainted(false);
        btnReport.setContentAreaFilled(false);
        btnReport.setCursor(new java.awt.Cursor(java.awt.Cursor.MOVE_CURSOR));
        btnReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportActionPerformed(evt);
            }
        });

        btnWarehouse.setBackground(new java.awt.Color(0, 51, 102));
        btnWarehouse.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnWarehouse.setForeground(new java.awt.Color(255, 255, 255));
        btnWarehouse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/man.png"))); // NOI18N
        btnWarehouse.setText("Kho hàng");
        btnWarehouse.setBorder(null);
        btnWarehouse.setBorderPainted(false);
        btnWarehouse.setContentAreaFilled(false);
        btnWarehouse.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnWarehouse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnWarehouseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnOverview, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnDinnerTable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnOrder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnConfirm, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
            .addComponent(btnPay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnCallTable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnReport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnWarehouse, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnStaff, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnClient, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnAccount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(labelLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(labelLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnOverview, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDinnerTable, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPay, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCallTable, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnReport, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnWarehouse, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnStaff, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnClient, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(60, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, new java.awt.Color(204, 204, 204), java.awt.Color.white));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Mì cay Sisan");

        jButton3.setBackground(new java.awt.Color(238, 238, 238));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/bell.png"))); // NOI18N
        jButton3.setBorder(null);

        labelHouse.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        labelHouse.setText("00:00:00");

        labelPosition.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        labelPosition.setText("CHỨC VỤ: QUẢN LÝ");

        labelAccount.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        labelAccount.setText("TÀI KHOẢN: NGÔ KIM LONG");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelHouse)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelAccount)
                .addGap(18, 18, 18)
                .addComponent(labelPosition)
                .addGap(18, 18, 18)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(labelPosition, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(labelAccount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(labelHouse, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setFont(new java.awt.Font("Cascadia Code PL", 0, 14)); // NOI18N

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        tablePendingDishes.setAutoCreateRowSorter(true);
        tablePendingDishes.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
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
        tablePendingDishes.setCellSelectionEnabled(true);
        tablePendingDishes.setDoubleBuffered(true);
        tablePendingDishes.setDragEnabled(true);
        tablePendingDishes.setFillsViewportHeight(true);
        tablePendingDishes.setFocusCycleRoot(true);
        tablePendingDishes.setFocusTraversalPolicyProvider(true);
        tablePendingDishes.setGridColor(new java.awt.Color(255, 255, 255));
        tablePendingDishes.setInheritsPopupMenu(true);
        tablePendingDishes.setRowHeight(50);
        jScrollPane5.setViewportView(tablePendingDishes);
        if (tablePendingDishes.getColumnModel().getColumnCount() > 0) {
            tablePendingDishes.getColumnModel().getColumn(0).setResizable(false);
            tablePendingDishes.getColumnModel().getColumn(1).setResizable(false);
            tablePendingDishes.getColumnModel().getColumn(4).setMinWidth(0);
            tablePendingDishes.getColumnModel().getColumn(4).setPreferredWidth(0);
            tablePendingDishes.getColumnModel().getColumn(4).setMaxWidth(0);
        }

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 1020, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 576, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("BẾP NÓNG ", new javax.swing.ImageIcon(getClass().getResource("/icon/chef.png")), jPanel4); // NOI18N

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        tablePendingDrinks.setAutoCreateRowSorter(true);
        tablePendingDrinks.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
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
        tablePendingDrinks.setCellSelectionEnabled(true);
        tablePendingDrinks.setDoubleBuffered(true);
        tablePendingDrinks.setDragEnabled(true);
        tablePendingDrinks.setFillsViewportHeight(true);
        tablePendingDrinks.setFocusCycleRoot(true);
        tablePendingDrinks.setFocusTraversalPolicyProvider(true);
        tablePendingDrinks.setGridColor(new java.awt.Color(255, 255, 255));
        tablePendingDrinks.setRowHeight(50);
        jScrollPane3.setViewportView(tablePendingDrinks);
        if (tablePendingDrinks.getColumnModel().getColumnCount() > 0) {
            tablePendingDrinks.getColumnModel().getColumn(0).setResizable(false);
            tablePendingDrinks.getColumnModel().getColumn(1).setResizable(false);
            tablePendingDrinks.getColumnModel().getColumn(4).setMinWidth(0);
            tablePendingDrinks.getColumnModel().getColumn(4).setPreferredWidth(0);
            tablePendingDrinks.getColumnModel().getColumn(4).setMaxWidth(0);
        }

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1020, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 576, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("QUẦY NƯỚC ", new javax.swing.ImageIcon(getClass().getResource("/icon/drink.png")), jPanel5); // NOI18N

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        tableFinishedProducts.setAutoCreateRowSorter(true);
        tableFinishedProducts.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
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
        tableFinishedProducts.setGridColor(new java.awt.Color(255, 255, 255));
        tableFinishedProducts.setRequestFocusEnabled(false);
        tableFinishedProducts.setRowHeight(50);
        jScrollPane4.setViewportView(tableFinishedProducts);
        if (tableFinishedProducts.getColumnModel().getColumnCount() > 0) {
            tableFinishedProducts.getColumnModel().getColumn(0).setResizable(false);
            tableFinishedProducts.getColumnModel().getColumn(1).setResizable(false);
            tableFinishedProducts.getColumnModel().getColumn(4).setMinWidth(0);
            tableFinishedProducts.getColumnModel().getColumn(4).setPreferredWidth(0);
            tableFinishedProducts.getColumnModel().getColumn(4).setMaxWidth(0);
        }

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 1020, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 576, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("LỊCH SỬ ", new javax.swing.ImageIcon(getClass().getResource("/icon/Notes.png")), jPanel6); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1020, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 621, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrderActionPerformed
        Products monAn = new Products(userInfo);
        openFullScreenWindow(monAn);
    }//GEN-LAST:event_btnOrderActionPerformed

    private void btnPayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPayActionPerformed
        Invoices hoaDon = new Invoices(userInfo);
        openFullScreenWindow(hoaDon);
    }//GEN-LAST:event_btnPayActionPerformed

    private void btnConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmActionPerformed
        ConfirmProducts nvBep = new ConfirmProducts(userInfo);
        openFullScreenWindow(nvBep);
    }//GEN-LAST:event_btnConfirmActionPerformed

    private void btnStaffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStaffActionPerformed
        Employees qlnv = new Employees(userInfo);
        openFullScreenWindow(qlnv);
    }//GEN-LAST:event_btnStaffActionPerformed

    private void btnClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClientActionPerformed
//         TongQuan qlnv = new TongQuan();
//        openFullScreenWindow(qlnv);
    }//GEN-LAST:event_btnClientActionPerformed

    private void btnAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAccountActionPerformed
        Accounts taiKhoan = new Accounts(userInfo);
        openFullScreenWindow(taiKhoan);
    }//GEN-LAST:event_btnAccountActionPerformed

    private void btnDinnerTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDinnerTableActionPerformed
        DiningTables chonBan = new DiningTables(userInfo);
        openFullScreenWindow(chonBan);
    }//GEN-LAST:event_btnDinnerTableActionPerformed


    private void btnOverviewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOverviewActionPerformed
        Overview tongQuan = new Overview(userInfo);
        openFullScreenWindow(tongQuan);
    }//GEN-LAST:event_btnOverviewActionPerformed

    private void btnCallTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCallTableActionPerformed
//        TongQuan overview = new TongQuan();
//        openFullScreenWindow(overview);
    }//GEN-LAST:event_btnCallTableActionPerformed

    private void btnReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportActionPerformed
//        TongQuan overview = new TongQuan();
//        openFullScreenWindow(overview);
    }//GEN-LAST:event_btnReportActionPerformed

    private void btnWarehouseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnWarehouseActionPerformed
        ConfirmProducts khoHang = new ConfirmProducts(userInfo);
        openFullScreenWindow(khoHang);
    }//GEN-LAST:event_btnWarehouseActionPerformed

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConfirmProducts.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            Map<String, String> userInfo = new HashMap<>();
            ConfirmProducts khoHang = new ConfirmProducts(userInfo);
            khoHang.setExtendedState(JFrame.MAXIMIZED_BOTH);
            khoHang.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAccount;
    private javax.swing.JButton btnCallTable;
    private javax.swing.JButton btnClient;
    private javax.swing.JButton btnConfirm;
    private javax.swing.JButton btnDinnerTable;
    private javax.swing.JButton btnOrder;
    private javax.swing.JButton btnOverview;
    private javax.swing.JButton btnPay;
    private javax.swing.JButton btnReport;
    private javax.swing.JButton btnStaff;
    private javax.swing.JButton btnWarehouse;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel labelAccount;
    private javax.swing.JLabel labelHouse;
    private javax.swing.JLabel labelLogo;
    private javax.swing.JLabel labelPosition;
    private javax.swing.JTable tableFinishedProducts;
    private javax.swing.JTable tablePendingDishes;
    private javax.swing.JTable tablePendingDrinks;
    // End of variables declaration//GEN-END:variables

}
