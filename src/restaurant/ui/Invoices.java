package restaurant.ui;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Collections;
import javax.swing.Timer;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.text.SimpleDateFormat;

import restaurant.dao.*;
import restaurant.entity.*;
import restaurant.utils.Auth;
import restaurant.utils.Dialog;
import restaurant.utils.Common;
import static restaurant.utils.Common.*;

public class Invoices extends javax.swing.JFrame {

    private Timer timer;
    int index = 0;
    int invoiceId;
    String tableId;
    String tableName;
    private String methodPay;

    public Invoices() {
        initComponents();

        Common.initClock(labelHouse);
        Common.setAccountLabel(labelAccount);
        Common.addClickActionToLabelLogo(labelLogo, this);
        Common.customizeTable(tablePendingInvoices, new int[]{});
        Common.customizeTable(tableFinishedInvoices, new int[]{});
        Common.customizeTable(tableListOrderedDishes, new int[]{0});

        displayUserInfo();
        displayProductsPayment(tableId);
        displayProductsInTables();

    }

    void calculateCashReturn() {
        textGiveMoney.addActionListener(e -> {
            String giveMoneyText = removeCommasFromNumber(textGiveMoney.getText());
            String totalAmountText = removeCommasFromNumber(labelTotalAmount.getText());

            if (giveMoneyText.isEmpty() || totalAmountText.isEmpty()) {
                return;
            }

            // Parse strings to integers only after checking for emptiness
            int giveMoney = Integer.parseInt(giveMoneyText);
            int totalAmount = Integer.parseInt(totalAmountText);

            if (giveMoney >= totalAmount) {
                String cashReurn = addCommasToNumber(String.valueOf(giveMoney - totalAmount));
                labelCashReturn.setText(cashReurn);
            } else {
                labelCashReturn.setText("-1");
            }
        });
    }

    InvoicesEntity getModel() {
        String employeeId = Auth.user.getEmployeeID();
        int tax = Integer.parseInt(removeCommasFromNumber(labelTax.getText()));
        int discount = Integer.parseInt(removeCommasFromNumber(labelDiscount.getText()));
        methodPay = radioCash.isSelected() ? "Tiền mặt" : radioCard.isSelected() ? "Thẻ" : "Chuyển khoản";

        int totalAmount = Integer.parseInt(removeCommasFromNumber(labelTotalAmount.getText()));
        String giveMoney = textGiveMoney.getText();

        try {
            if (giveMoney.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Vui lòng nhập số tiền khách đưa.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return null;
            }

            InvoicesEntity model = new InvoicesEntity();
            model.setInvoiceID(invoiceId);
            model.setEmployeeID(employeeId);
            model.setTax(tax);
            model.setDiscount(discount);
            model.setPaymentMethod(methodPay);
            model.setNote("");
            model.setTotalAmount(totalAmount);
            model.setStatus("Đã thanh toán");

            return model;
        } catch (NumberFormatException e) {
            System.err.println("Lỗi: " + e.getMessage());
            return null;
        }
    }

    void openFullScreenWindow(JFrame window) {
        window.setExtendedState(JFrame.MAXIMIZED_BOTH);
        window.setVisible(true);
        this.dispose();
    }

    void displayUserInfo() {
        // Kiểm tra và gán giá trị 
        if (Auth.table != null && Auth.table.getTableID() != null) {
            tableId = Auth.table.getTableID();
        }

        if (Auth.table != null && Auth.table.getTableName() != null) {
            tableName = Auth.table.getTableName();
        }

        invoiceId = new InvoicesDAO().getIdByTableId(tableId);

        // Set case
        btnNameDiningTable.setText(invoiceId == 0
                ? (tableName == null || tableName.equals("")
                ? "Chọn bàn"
                : "Trống - " + tableName)
                : "Đơn hàng[" + invoiceId + "] - " + tableName);
    }

    public void displayProductsPayment(String tableId) {
        // Reset table
        DefaultTableModel model = (DefaultTableModel) tableListOrderedDishes.getModel();
        model.setRowCount(0);

        // Get info detail order through dining table id
        List<OrderDetailsEntity> detailOrderList = new OrderDetailsDAO().getOrderdByTableId(tableId);

        // Create a Map để lưu trữ số lượng và giá của mỗi món
        Map<String, Integer> productPriceMap = new HashMap<>();
        Map<String, Integer> productQuantityMap = new HashMap<>();

        // Total money all
        int totalAmount = 0;

        // Display dishes on the table
        for (OrderDetailsEntity detailOrder : detailOrderList) {
            // Get info dish
            String dishId = detailOrder.getProductID();
            String dishLevel = !detailOrder.getProductDesc().isEmpty() ? " (" + detailOrder.getProductDesc() + ")" : "";

            // Get detail dish  
            ProductsEntity productEntity = new ProductsDAO().getById(dishId);
            String productName = productEntity.getProductName();
            String productNameAndLevel = productName + dishLevel;

            // Tăng số lượng của món trong Map
            int quantity = detailOrder.getProductQuantity();
            if (productQuantityMap.containsKey(productNameAndLevel)) {
                quantity += productQuantityMap.get(productNameAndLevel);
            }

            productQuantityMap.put(productNameAndLevel, quantity);
            productPriceMap.put(productNameAndLevel, productEntity.getPrice());
        }

        // Add data into the table
        for (Map.Entry<String, Integer> entry : productQuantityMap.entrySet()) {
            // Get name and level -> ex: Mì cay (Cấp 7)
            String productNameAndLevel = entry.getKey();
            int totalQuantity = entry.getValue();

            // Get unit price and quantity -> ex: 50.000₫ x 3
            int unitPrice = productPriceMap.get(productNameAndLevel);
            String convertUnitPrice = addCommasToNumber(String.valueOf(unitPrice)) + "₫";

            // Get total price -> ex: 50.000 x 3 = 150.000
            int totalPrice = unitPrice * totalQuantity;
            String convertTotalPrice = addCommasToNumber(String.valueOf(totalPrice)) + "₫";

            // Total invoice
            totalAmount += totalPrice;

            // Add row into the table
            model.addRow(new Object[]{
                productNameAndLevel,
                convertUnitPrice,
                totalQuantity,
                convertTotalPrice
            });
        }

        String totalConvert = addCommasToNumber(String.valueOf(totalAmount));
        labelTotalPrice.setText(totalConvert);
        labelTotalAmount.setText(totalConvert);
    }

    private void displayProductsInTables() {
        // Fetch pending and confirmed products
        List<InvoicesEntity> pendingInvoices = new InvoicesDAO().getAllUnPaid();
        List<InvoicesEntity> confirmedInvoices = new InvoicesDAO().getAll();

        // Get model
        DefaultTableModel modelPending = (DefaultTableModel) tablePendingInvoices.getModel();
        DefaultTableModel modelConfirmed = (DefaultTableModel) tableFinishedInvoices.getModel();

        // Prepare data for pending and confirmed products table
        fillPendingInvoicesTable(modelPending, pendingInvoices);
        fillConfirmedInvoicesTable(modelConfirmed, confirmedInvoices);

        // Đặt model cho bảng 
        tablePendingInvoices.setModel(modelPending);
        tableFinishedInvoices.setModel(modelConfirmed);
    }

    private void fillPendingInvoicesTable(DefaultTableModel modelPending, List<InvoicesEntity> pendingInvoices) {
        // Sắp xếp theo thời gian kết thúc từ gần nhất
        Collections.sort(pendingInvoices, (invoice1, invoice2)
                -> invoice1.getPaymentTime().compareTo(invoice2.getPaymentTime())
        );

        // Get data from list Confirmed invoices in model
        for (InvoicesEntity invoice : pendingInvoices) {
            // Get id order and info detail
            int invoicesId = invoice.getInvoiceID();
            OrdersEntity order = new OrdersDAO().getOrderByInvoiceId(invoicesId);
            if (order == null) {
                return;
            }
            int orderId = order.getOrderId();

            int totalAmount = new OrderDetailsDAO().getTotalAmountByInvoiceID(invoicesId);
            String totalAmountConvert = addCommasToNumber(String.valueOf(totalAmount)) + " ₫";
            String status = invoice.getStatus();
            java.sql.Timestamp startTime = new OrdersDAO().getCreateDateByInvoiceId(invoicesId);
            String timeRemaining = calculateTimeRemaining(startTime);

            // Get name table 
            List<String> tableNames = new TablesDAO().getTableNamesByInvoiceId(invoicesId);
            StringBuilder combinedNames = new StringBuilder();
            for (String tableName : tableNames) {
                combinedNames.append(tableName).append(" + ");
            }
            combinedNames.delete(combinedNames.length() - 3, combinedNames.length()); // Xóa dấu cộng và khoảng trắng ở cuối

            // Add invoice on table
            modelPending.addRow(new Object[]{
                orderId,
                combinedNames,
                totalAmountConvert,
                status,
                timeRemaining
            });
        }
    }

    private void fillConfirmedInvoicesTable(DefaultTableModel modelConfirmed, List<InvoicesEntity> confirmedInvoices) {
        // Sắp xếp theo thời gian kết thúc từ gần nhất
        Collections.sort(confirmedInvoices, (invoice1, invoice2)
                -> invoice2.getPaymentTime().compareTo(invoice1.getPaymentTime())
        );

        // Get data from list Confirmed products in model
        for (InvoicesEntity invoice : confirmedInvoices) {
            // Get id detail
            int invoicesId = invoice.getInvoiceID();
            int tax = invoice.getTax();
            int discount = invoice.getDiscount();
            int totalAmount = new OrderDetailsDAO().getTotalAmountByInvoiceID(invoicesId);
            String totalAmountConvert = addCommasToNumber(String.valueOf(totalAmount)) + " ₫";
            String status = invoice.getStatus();
            String paiedTime = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(invoice.getPaymentTime());

            // Get name table
            List<String> tableNames = new TablesDAO().getTableNamesByInvoiceId(invoicesId);

            StringBuilder combinedNames = new StringBuilder();
            for (String tableName : tableNames) {
                combinedNames.append(tableName).append(" + ");
            }

            // Xóa dấu cộng và khoảng trắng ở cuối
            combinedNames.delete(combinedNames.length() - 3, combinedNames.length());

            // Add invoice on table
            modelConfirmed.addRow(new Object[]{
                invoicesId,
                combinedNames,
                totalAmountConvert,
                status,
                paiedTime
            });
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel3 = new javax.swing.JPanel();
        tabbedPanePay = new javax.swing.JTabbedPane();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableListOrderedDishes = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablePendingInvoices = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tableFinishedInvoices = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        btnNameDiningTable = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        labelTotalPrice = new javax.swing.JLabel();
        labelTax = new javax.swing.JLabel();
        labelDiscount = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        labelTotalAmount = new javax.swing.JLabel();
        radioCash = new javax.swing.JRadioButton();
        radioCard = new javax.swing.JRadioButton();
        textGiveMoney = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        labelCashReturn = new javax.swing.JLabel();
        btnPayInvoice = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        btnFiftyThousand = new javax.swing.JButton();
        btnTwentyThousand = new javax.swing.JButton();
        btnFiveThousand = new javax.swing.JButton();
        btnTenThousand = new javax.swing.JButton();
        btnHundredThousand = new javax.swing.JButton();
        btnTwoHundredThousand = new javax.swing.JButton();
        btnFiveHundredThousand = new javax.swing.JButton();
        btnTwoThousand = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        radioTransfer = new javax.swing.JRadioButton();
        jPanel9 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        labelHouse = new javax.swing.JLabel();
        labelAccount = new javax.swing.JLabel();
        labelLogo = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        menuSysten = new javax.swing.JMenu();
        menuItemSystem = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        menuLogout = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        menuEnd = new javax.swing.JMenuItem();
        menuItemManager = new javax.swing.JMenu();
        menuTables = new javax.swing.JMenuItem();
        menuDishes = new javax.swing.JMenuItem();
        menuChicken = new javax.swing.JMenuItem();
        menuPay = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        menuEmployeeList = new javax.swing.JMenuItem();
        menuStatistical = new javax.swing.JMenu();
        menuIngridiants = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        menuEmployees = new javax.swing.JMenuItem();
        jSeparator8 = new javax.swing.JPopupMenu.Separator();
        menuClients = new javax.swing.JMenuItem();
        jSeparator9 = new javax.swing.JPopupMenu.Separator();
        menuRevenue = new javax.swing.JMenuItem();
        menuItemHelp = new javax.swing.JMenu();
        mniHuongDan = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        mniGioiThieu = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setPreferredSize(new java.awt.Dimension(860, 555));

        tabbedPanePay.setBackground(new java.awt.Color(255, 255, 255));
        tabbedPanePay.setDoubleBuffered(true);
        tabbedPanePay.setFocusCycleRoot(true);
        tabbedPanePay.setFocusTraversalPolicyProvider(true);
        tabbedPanePay.setFont(new java.awt.Font("Cascadia Code PL", 0, 14)); // NOI18N
        tabbedPanePay.setInheritsPopupMenu(true);
        tabbedPanePay.setOpaque(true);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setAutoscrolls(true);
        jPanel5.setFocusCycleRoot(true);
        jPanel5.setFocusTraversalPolicyProvider(true);
        jPanel5.setInheritsPopupMenu(true);

        tableListOrderedDishes.setAutoCreateRowSorter(true);
        tableListOrderedDishes.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        tableListOrderedDishes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên món", "Đơn giá", "Số lượng", "Tổng giá"
            }
        ));
        tableListOrderedDishes.setAlignmentX(2.0F);
        tableListOrderedDishes.setAlignmentY(2.0F);
        tableListOrderedDishes.setDoubleBuffered(true);
        tableListOrderedDishes.setDragEnabled(true);
        tableListOrderedDishes.setFillsViewportHeight(true);
        tableListOrderedDishes.setGridColor(new java.awt.Color(255, 255, 255));
        tableListOrderedDishes.setRowHeight(40);
        tableListOrderedDishes.setShowGrid(false);
        jScrollPane1.setViewportView(tableListOrderedDishes);
        tableListOrderedDishes.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        if (tableListOrderedDishes.getColumnModel().getColumnCount() > 0) {
            tableListOrderedDishes.getColumnModel().getColumn(0).setPreferredWidth(250);
        }

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 866, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 80, Short.MAX_VALUE))
        );

        tabbedPanePay.addTab("THANH TOÁN ", new javax.swing.ImageIcon(getClass().getResource("/icon/card.png")), jPanel5); // NOI18N
        jPanel5.getAccessibleContext().setAccessibleName("");

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        tablePendingInvoices.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        tablePendingInvoices.setForeground(new java.awt.Color(51, 51, 51));
        tablePendingInvoices.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Đơn hàng", "Tên bàn", "Tổng tiền", "Trạng thái", "Thời gian đợi"
            }
        ));
        tablePendingInvoices.setAlignmentX(2.0F);
        tablePendingInvoices.setAlignmentY(2.0F);
        tablePendingInvoices.setFillsViewportHeight(true);
        tablePendingInvoices.setGridColor(new java.awt.Color(255, 255, 255));
        tablePendingInvoices.setRowHeight(40);
        tablePendingInvoices.setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        tablePendingInvoices.setShowGrid(false);
        tablePendingInvoices.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablePendingInvoicesMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tablePendingInvoices);
        tablePendingInvoices.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        if (tablePendingInvoices.getColumnModel().getColumnCount() > 0) {
            tablePendingInvoices.getColumnModel().getColumn(3).setPreferredWidth(120);
            tablePendingInvoices.getColumnModel().getColumn(4).setPreferredWidth(135);
        }

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 866, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 630, Short.MAX_VALUE)
        );

        tabbedPanePay.addTab("CHỜ THANH TOÁN", new javax.swing.ImageIcon(getClass().getResource("/icon/price-list.png")), jPanel6); // NOI18N

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        tableFinishedInvoices.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        tableFinishedInvoices.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Hóa đơn", "Tên bàn", "Tổng tiền", "Trạng thái", "Thời gian"
            }
        ));
        tableFinishedInvoices.setAlignmentX(2.0F);
        tableFinishedInvoices.setAlignmentY(2.0F);
        tableFinishedInvoices.setFillsViewportHeight(true);
        tableFinishedInvoices.setGridColor(new java.awt.Color(255, 255, 255));
        tableFinishedInvoices.setRowHeight(40);
        tableFinishedInvoices.setShowGrid(false);
        jScrollPane4.setViewportView(tableFinishedInvoices);
        tableFinishedInvoices.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        if (tableFinishedInvoices.getColumnModel().getColumnCount() > 0) {
            tableFinishedInvoices.getColumnModel().getColumn(3).setPreferredWidth(120);
            tableFinishedInvoices.getColumnModel().getColumn(4).setPreferredWidth(135);
        }

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 866, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 548, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 82, Short.MAX_VALUE))
        );

        tabbedPanePay.addTab("LỊCH SỬ ", new javax.swing.ImageIcon(getClass().getResource("/icon/history.png")), jPanel8); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabbedPanePay)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabbedPanePay)
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        btnNameDiningTable.setFont(new java.awt.Font("Cascadia Code PL", 0, 16)); // NOI18N
        btnNameDiningTable.setText("Chọn bàn");
        btnNameDiningTable.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(210, 210, 210), 4, true));
        btnNameDiningTable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNameDiningTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNameDiningTableActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Tổng tiền:");

        labelTotalPrice.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelTotalPrice.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelTotalPrice.setText("20,000");

        labelTax.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelTax.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelTax.setText("0");

        labelDiscount.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelDiscount.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelDiscount.setText("0");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("Giảm giá:");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(51, 51, 51));
        jLabel14.setText("Thuế:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("Khách cần trả:");

        labelTotalAmount.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        labelTotalAmount.setForeground(new java.awt.Color(255, 0, 0));
        labelTotalAmount.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelTotalAmount.setText("20,000");

        radioCash.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        radioCash.setSelected(true);
        radioCash.setText("Tiền mặt");
        radioCash.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioCashActionPerformed(evt);
            }
        });

        radioCard.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        radioCard.setText("Thẻ");
        radioCard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioCardActionPerformed(evt);
            }
        });

        textGiveMoney.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        textGiveMoney.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        textGiveMoney.setActionCommand("<Not Set>");
        textGiveMoney.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 0, 0)));
        textGiveMoney.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        textGiveMoney.setMargin(new java.awt.Insets(2, 60, 2, 6));
        textGiveMoney.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textGiveMoneyActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 51, 51));
        jLabel10.setText("Khách thanh toán:");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(51, 51, 51));
        jLabel16.setText("Tiền thừa trả khách:");

        labelCashReturn.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        labelCashReturn.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelCashReturn.setText("0");

        btnPayInvoice.setBackground(new java.awt.Color(0, 153, 0));
        btnPayInvoice.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnPayInvoice.setForeground(new java.awt.Color(255, 255, 255));
        btnPayInvoice.setText("THANH TOÁN");
        btnPayInvoice.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPayInvoice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPayInvoiceActionPerformed(evt);
            }
        });

        btnCancel.setBackground(new java.awt.Color(225, 0, 0));
        btnCancel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnCancel.setForeground(new java.awt.Color(255, 255, 255));
        btnCancel.setText("HỦY");
        btnCancel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnFiftyThousand.setText("50.000");
        btnFiftyThousand.setBorder(null);
        btnFiftyThousand.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiftyThousandActionPerformed(evt);
            }
        });

        btnTwentyThousand.setText("20.000");
        btnTwentyThousand.setBorder(null);
        btnTwentyThousand.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTwentyThousandActionPerformed(evt);
            }
        });

        btnFiveThousand.setText("5.000");
        btnFiveThousand.setBorder(null);
        btnFiveThousand.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiveThousandActionPerformed(evt);
            }
        });

        btnTenThousand.setText("10.000");
        btnTenThousand.setBorder(null);
        btnTenThousand.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTenThousandActionPerformed(evt);
            }
        });

        btnHundredThousand.setText("100.000");
        btnHundredThousand.setBorder(null);
        btnHundredThousand.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHundredThousandActionPerformed(evt);
            }
        });

        btnTwoHundredThousand.setText("200.000");
        btnTwoHundredThousand.setBorder(null);
        btnTwoHundredThousand.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTwoHundredThousandActionPerformed(evt);
            }
        });

        btnFiveHundredThousand.setText("500.000");
        btnFiveHundredThousand.setBorder(null);
        btnFiveHundredThousand.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiveHundredThousandActionPerformed(evt);
            }
        });

        btnTwoThousand.setText("2.000");
        btnTwoThousand.setBorder(null);
        btnTwoThousand.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTwoThousandActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setPreferredSize(new java.awt.Dimension(251, 2));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        radioTransfer.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        radioTransfer.setText("Chuyển khoản");
        radioTransfer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioTransferActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPayInvoice, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnNameDiningTable, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(radioCash)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(btnTwoThousand, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnFiftyThousand, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addComponent(btnHundredThousand, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnTwoHundredThousand, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addComponent(btnFiveThousand, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnTenThousand, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btnTwentyThousand, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnFiveHundredThousand, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                            .addComponent(jLabel10)
                            .addGap(27, 27, 27)
                            .addComponent(textGiveMoney))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                            .addComponent(radioCard)
                            .addGap(69, 69, 69)
                            .addComponent(radioTransfer))
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addComponent(jLabel16)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(labelCashReturn, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(185, 185, 185)
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(labelTotalPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(labelTotalAmount, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                                            .addComponent(labelDiscount, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(labelTax, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                            .addGap(8, 8, 8))))
                .addGap(0, 12, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(btnNameDiningTable, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelTotalPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTax, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelDiscount, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelTotalAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(radioCard, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                        .addComponent(radioTransfer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(radioCash, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(textGiveMoney, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(13, 13, 13)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCashReturn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFiveThousand, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTenThousand, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTwoThousand, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTwentyThousand, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnHundredThousand, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTwoHundredThousand, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFiftyThousand, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFiveHundredThousand, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPayInvoice, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 1, 1, new java.awt.Color(204, 204, 204)));

        jButton3.setBackground(new java.awt.Color(238, 238, 238));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/bell.png"))); // NOI18N
        jButton3.setBorder(null);

        labelHouse.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        labelHouse.setText("00:00:00");

        labelAccount.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        labelAccount.setText("TÀI KHOẢN: NGÔ KIM LONG");

        labelLogo.setFont(new java.awt.Font("Segoe Print", 1, 26)); // NOI18N
        labelLogo.setForeground(new java.awt.Color(255, 153, 153));
        labelLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelLogo.setText("HOT NOODLE");
        labelLogo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelLogo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(labelLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelHouse)
                .addGap(18, 18, 18)
                .addComponent(labelAccount)
                .addGap(18, 18, 18)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(labelLogo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
            .addComponent(labelAccount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(labelHouse, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        menuSysten.setText("Hệ thống");

        menuItemSystem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Refresh.png"))); // NOI18N
        menuItemSystem.setText("Đổi mật khẩu");
        menuItemSystem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemSystemActionPerformed(evt);
            }
        });
        menuSysten.add(menuItemSystem);
        menuSysten.add(jSeparator2);

        menuLogout.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        menuLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Log out.png"))); // NOI18N
        menuLogout.setText("Đăng xuất");
        menuLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuLogoutActionPerformed(evt);
            }
        });
        menuSysten.add(menuLogout);
        menuSysten.add(jSeparator1);

        menuEnd.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        menuEnd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Stop.png"))); // NOI18N
        menuEnd.setText("Kết thúc");
        menuEnd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuEndActionPerformed(evt);
            }
        });
        menuSysten.add(menuEnd);

        menuBar.add(menuSysten);

        menuItemManager.setText("Quản lý");

        menuTables.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        menuTables.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Discussion.png"))); // NOI18N
        menuTables.setText("Bàn ăn");
        menuTables.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuTablesActionPerformed(evt);
            }
        });
        menuItemManager.add(menuTables);

        menuDishes.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, 0));
        menuDishes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Add to basket.png"))); // NOI18N
        menuDishes.setText("Món ăn");
        menuDishes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuDishesActionPerformed(evt);
            }
        });
        menuItemManager.add(menuDishes);

        menuChicken.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F3, 0));
        menuChicken.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/chef.png"))); // NOI18N
        menuChicken.setText("Nhà bếp");
        menuChicken.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuChickenActionPerformed(evt);
            }
        });
        menuItemManager.add(menuChicken);

        menuPay.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, 0));
        menuPay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/card.png"))); // NOI18N
        menuPay.setText("Thanh toán");
        menuPay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuPayActionPerformed(evt);
            }
        });
        menuItemManager.add(menuPay);
        menuItemManager.add(jSeparator4);

        menuEmployeeList.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, 0));
        menuEmployeeList.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Clien list.png"))); // NOI18N
        menuEmployeeList.setText("Nhân viên");
        menuEmployeeList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuEmployeeListActionPerformed(evt);
            }
        });
        menuItemManager.add(menuEmployeeList);

        menuBar.add(menuItemManager);

        menuStatistical.setText("Thống kê");

        menuIngridiants.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, java.awt.event.InputEvent.SHIFT_DOWN_MASK));
        menuIngridiants.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Dollar.png"))); // NOI18N
        menuIngridiants.setText("Xem doanh thu cuối ngày");
        menuIngridiants.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuIngridiantsActionPerformed(evt);
            }
        });
        menuStatistical.add(menuIngridiants);
        menuStatistical.add(jSeparator3);

        menuEmployees.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, java.awt.event.InputEvent.SHIFT_DOWN_MASK));
        menuEmployees.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Label.png"))); // NOI18N
        menuEmployees.setText("Xem nguyên liệu cuối ngày");
        menuEmployees.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuEmployeesActionPerformed(evt);
            }
        });
        menuStatistical.add(menuEmployees);
        menuStatistical.add(jSeparator8);

        menuClients.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F3, java.awt.event.InputEvent.SHIFT_DOWN_MASK));
        menuClients.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Users.png"))); // NOI18N
        menuClients.setText("Xem khách hàng cuối ngày");
        menuClients.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuClientsActionPerformed(evt);
            }
        });
        menuStatistical.add(menuClients);
        menuStatistical.add(jSeparator9);

        menuRevenue.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.SHIFT_DOWN_MASK));
        menuRevenue.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/history.png"))); // NOI18N
        menuRevenue.setText("Xem món ăn cuối ngày");
        menuRevenue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuRevenueActionPerformed(evt);
            }
        });
        menuStatistical.add(menuRevenue);

        menuBar.add(menuStatistical);

        menuItemHelp.setText("Trợ giúp");

        mniHuongDan.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        mniHuongDan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Globe.png"))); // NOI18N
        mniHuongDan.setText("Hướng dẫn sử dụng");
        mniHuongDan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniHuongDanActionPerformed(evt);
            }
        });
        menuItemHelp.add(mniHuongDan);
        menuItemHelp.add(jSeparator5);

        mniGioiThieu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, 0));
        mniGioiThieu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Brick house.png"))); // NOI18N
        mniGioiThieu.setText("Giới thiệu sản phẩm");
        mniGioiThieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniGioiThieuActionPerformed(evt);
            }
        });
        menuItemHelp.add(mniGioiThieu);

        menuBar.add(menuItemHelp);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 866, Short.MAX_VALUE)
                        .addGap(12, 12, 12)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)))
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 594, Short.MAX_VALUE))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNameDiningTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNameDiningTableActionPerformed
        openFullScreenWindow(new DiningTables());
    }//GEN-LAST:event_btnNameDiningTableActionPerformed

    private void btnFiftyThousandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiftyThousandActionPerformed
        textGiveMoney.setText("50,000");
        calculateCashReturn();
    }//GEN-LAST:event_btnFiftyThousandActionPerformed

    private void btnTwentyThousandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTwentyThousandActionPerformed
        textGiveMoney.setText("20,000");
        calculateCashReturn();
    }//GEN-LAST:event_btnTwentyThousandActionPerformed

    private void btnFiveThousandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiveThousandActionPerformed
        textGiveMoney.setText("5,000");
        calculateCashReturn();
    }//GEN-LAST:event_btnFiveThousandActionPerformed

    private void btnTenThousandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTenThousandActionPerformed
        textGiveMoney.setText("  10,000");
        calculateCashReturn();
    }//GEN-LAST:event_btnTenThousandActionPerformed

    private void textGiveMoneyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textGiveMoneyActionPerformed
    }//GEN-LAST:event_textGiveMoneyActionPerformed

    private void radioCashActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioCashActionPerformed
        radioCash.setSelected(true);
        radioCard.setSelected(false);
        radioTransfer.setSelected(false);
    }//GEN-LAST:event_radioCashActionPerformed

    private void radioCardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioCardActionPerformed
        radioCard.setSelected(true);
        radioCash.setSelected(false);
        radioTransfer.setSelected(false);
    }//GEN-LAST:event_radioCardActionPerformed

    private void btnTwoThousandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTwoThousandActionPerformed
        textGiveMoney.setText("2,000");
        calculateCashReturn();
    }//GEN-LAST:event_btnTwoThousandActionPerformed

    private void btnHundredThousandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHundredThousandActionPerformed
        textGiveMoney.setText("100,000");
        calculateCashReturn();
    }//GEN-LAST:event_btnHundredThousandActionPerformed

    private void btnTwoHundredThousandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTwoHundredThousandActionPerformed
        textGiveMoney.setText("200,000");
        calculateCashReturn();
    }//GEN-LAST:event_btnTwoHundredThousandActionPerformed

    private void btnFiveHundredThousandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiveHundredThousandActionPerformed
        textGiveMoney.setText("500,000");
        calculateCashReturn();
    }//GEN-LAST:event_btnFiveHundredThousandActionPerformed

    private void btnPayInvoiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPayInvoiceActionPerformed
        if (!Auth.isManager()) {
            Dialog.warning(this, "Bạn không có quyền thanh toán!");
            return;
        }

        if (invoiceId == 0) {
            Dialog.warning(this, "Vui lòng chọn bàn đã gọi món!");
            return;
        }

        InvoicesEntity model = getModel();
        try {
            new InvoicesDAO().update(model);
            new OrdersDAO().updateStatusByInvoiceId(invoiceId);
            Dialog.success(this, "Đã thanh toán!");
            openFullScreenWindow(new DiningTables());
        } catch (Exception e) {
            System.out.println("Thanh toán thất bại!");
        }
    }//GEN-LAST:event_btnPayInvoiceActionPerformed

    private void radioTransferActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioTransferActionPerformed
        radioCard.setSelected(false);
        radioCash.setSelected(false);
        radioTransfer.setSelected(true);
    }//GEN-LAST:event_radioTransferActionPerformed

    private void tablePendingInvoicesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablePendingInvoicesMouseClicked
        if (evt.getClickCount() < 2) {
            return;
        }

        int selectedRow = tablePendingInvoices.getSelectedRow();
        if (selectedRow < 0) {
            return;
        }

        tableName = tablePendingInvoices.getValueAt(selectedRow, 1).toString();
        tableId = new TablesDAO().getIdByName(tableName);
        invoiceId = new InvoicesDAO().getIdByTableId(tableId);
        displayProductsPayment(tableId);

        // Set case
        btnNameDiningTable.setText(invoiceId == 0
                ? (tableName == null || tableName.equals("")
                ? "Chọn bàn"
                : "Trống - " + tableName)
                : "Đơn hàng[" + invoiceId + "] - " + tableName);

        // Move pane
        tabbedPanePay.setSelectedIndex(0);
    }//GEN-LAST:event_tablePendingInvoicesMouseClicked

    private void menuItemSystemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemSystemActionPerformed

    }//GEN-LAST:event_menuItemSystemActionPerformed

    private void menuLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuLogoutActionPerformed
        if (Dialog.confirm(this, "Bạn muốn đăng xuất?")) {
            Auth.clear();
            dispose();
            new Login(this, true).setVisible(true);
        }
    }//GEN-LAST:event_menuLogoutActionPerformed

    private void menuEndActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuEndActionPerformed
        if (Dialog.confirm(this, "Bạn muốn kết thúc làm việc?")) {
            System.exit(0);
        }
    }//GEN-LAST:event_menuEndActionPerformed

    private void menuTablesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuTablesActionPerformed
        openFullScreenWindow(new DiningTables());
    }//GEN-LAST:event_menuTablesActionPerformed

    private void menuDishesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuDishesActionPerformed
        openFullScreenWindow(new Products());
    }//GEN-LAST:event_menuDishesActionPerformed

    private void menuChickenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuChickenActionPerformed
        openFullScreenWindow(new ConfirmProducts());
    }//GEN-LAST:event_menuChickenActionPerformed

    private void menuPayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuPayActionPerformed
        openFullScreenWindow(new Invoices());
    }//GEN-LAST:event_menuPayActionPerformed

    private void menuEmployeeListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuEmployeeListActionPerformed
        openFullScreenWindow(new Employees());
    }//GEN-LAST:event_menuEmployeeListActionPerformed

    private void menuIngridiantsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuIngridiantsActionPerformed

    }//GEN-LAST:event_menuIngridiantsActionPerformed

    private void menuEmployeesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuEmployeesActionPerformed

    }//GEN-LAST:event_menuEmployeesActionPerformed

    private void menuClientsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuClientsActionPerformed

    }//GEN-LAST:event_menuClientsActionPerformed

    private void menuRevenueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuRevenueActionPerformed

    }//GEN-LAST:event_menuRevenueActionPerformed

    private void mniHuongDanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniHuongDanActionPerformed

    }//GEN-LAST:event_mniHuongDanActionPerformed

    private void mniGioiThieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniGioiThieuActionPerformed

    }//GEN-LAST:event_mniGioiThieuActionPerformed

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Invoices.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            new Invoices().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnFiftyThousand;
    private javax.swing.JButton btnFiveHundredThousand;
    private javax.swing.JButton btnFiveThousand;
    private javax.swing.JButton btnHundredThousand;
    private javax.swing.JButton btnNameDiningTable;
    private javax.swing.JButton btnPayInvoice;
    private javax.swing.JButton btnTenThousand;
    private javax.swing.JButton btnTwentyThousand;
    private javax.swing.JButton btnTwoHundredThousand;
    private javax.swing.JButton btnTwoThousand;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JPopupMenu.Separator jSeparator8;
    private javax.swing.JPopupMenu.Separator jSeparator9;
    private javax.swing.JLabel labelAccount;
    private javax.swing.JLabel labelCashReturn;
    private javax.swing.JLabel labelDiscount;
    private javax.swing.JLabel labelHouse;
    private javax.swing.JLabel labelLogo;
    private javax.swing.JLabel labelTax;
    private javax.swing.JLabel labelTotalAmount;
    private javax.swing.JLabel labelTotalPrice;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem menuChicken;
    private javax.swing.JMenuItem menuClients;
    private javax.swing.JMenuItem menuDishes;
    private javax.swing.JMenuItem menuEmployeeList;
    private javax.swing.JMenuItem menuEmployees;
    private javax.swing.JMenuItem menuEnd;
    private javax.swing.JMenuItem menuIngridiants;
    private javax.swing.JMenu menuItemHelp;
    private javax.swing.JMenu menuItemManager;
    private javax.swing.JMenuItem menuItemSystem;
    private javax.swing.JMenuItem menuLogout;
    private javax.swing.JMenuItem menuPay;
    private javax.swing.JMenuItem menuRevenue;
    private javax.swing.JMenu menuStatistical;
    private javax.swing.JMenu menuSysten;
    private javax.swing.JMenuItem menuTables;
    private javax.swing.JMenuItem mniGioiThieu;
    private javax.swing.JMenuItem mniHuongDan;
    private javax.swing.JRadioButton radioCard;
    private javax.swing.JRadioButton radioCash;
    private javax.swing.JRadioButton radioTransfer;
    private javax.swing.JTabbedPane tabbedPanePay;
    private javax.swing.JTable tableFinishedInvoices;
    private javax.swing.JTable tableListOrderedDishes;
    private javax.swing.JTable tablePendingInvoices;
    private javax.swing.JTextField textGiveMoney;
    // End of variables declaration//GEN-END:variables
}
