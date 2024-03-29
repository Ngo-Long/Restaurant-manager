package restaurant.ui;

import restaurant.dao.DiningTableDAO;
import static restaurant.dao.DishDAO.getNameFoodFromId;
import restaurant.dao.OrderDAO;
import restaurant.entity.DiningTableEntity;
import restaurant.entity.OrderEntity;
import java.text.SimpleDateFormat;
import restaurant.helper.DialogHelper;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingConstants;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class DiningTables extends javax.swing.JFrame {

    String selectedArea;
    private List<DiningTableEntity> diningTableList;
    private List<DiningTableEntity> diningTableListByArea;
    Map<String, String> userInfo = CommonUtils.getUserInfo();

    public DiningTables(Map<String, String> userInfo) {
        initComponents();
        CommonUtils.initClock(labelHouse);
        CommonUtils.displayUserInfoBar(userInfo, labelAccount, labelPosition);
        CommonUtils.customizeScrollBar(scrollPaneTableDining, Color.lightGray);
        CommonUtils.setImage("D:\\FPT Polytechnic\\KiThuatPhanMem\\KTLT\\KTLT\\src\\icon\\logo.jpg", labelLogo);

        displayDiningTableList();

        // Listen for events when the user selects an area from cbArea
        cbArea.addActionListener((ActionEvent e) -> {
            selectedArea = (String) cbArea.getSelectedItem();
            displayDiningTableListByArea(selectedArea);
        });
        cbArea.setSelectedIndex(0);
    }

    private void displayDiningTableList() {
        // Get dining table list
        diningTableList = new DiningTableDAO().getAll();

        // Create a DefaultComboBoxModel 
        DefaultComboBoxModel<String> comboBoxModelTables = new DefaultComboBoxModel<>();
        comboBoxModelTables.addElement("Chọn bàn");

        DefaultComboBoxModel<String> comboBoxModelArea = new DefaultComboBoxModel<>();
        Set<String> areaSet = new HashSet<>(); // Create a Set to store unique area names

        for (DiningTableEntity diningTable : diningTableList) {
            // Add table name to the ComboBoxModel
            comboBoxModelTables.addElement(diningTable.getTenBanAn());

            // Collect unique area names
            areaSet.add(diningTable.getKhuVuc());
        }

        // Convert the Set to an array
        String[] areas = areaSet.toArray(String[]::new);

        // Populate the comboBoxArea with unique area names
        for (String area : areas) {
            comboBoxModelArea.addElement(area);
        }

        // Set the ComboBoxModel to the comboBox
        cbArea.setModel(comboBoxModelArea);
        cbDinnerTables.setModel(comboBoxModelTables);
    }

    private void displayDiningTableListByArea(String selectedArea) {
        // Reset each time an area is selected
        panelDiningTableList.removeAll();

        // Get dining table list for the selected area
        diningTableListByArea = new DiningTableDAO().getAllByArea(selectedArea);

        // Init GridBagLayout
        GridBagLayout gridBagLayout = new GridBagLayout();
        panelDiningTableList.setLayout(gridBagLayout);

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.insets = new Insets(6, 6, 6, 6);

        int columnCount = 0;

        // Iterate through the dining table list for the selected area
        for (DiningTableEntity diningTable : diningTableListByArea) {
            // Create and set colors based on status
            JButton tableButton = createTableButton(diningTable);
            setTableButtonColors(tableButton, diningTable.getTrangThai());

            // Đặt các ràng buộc cho thành phần
            gridBagLayout.setConstraints(tableButton, constraints);

            // Tăng chỉ số cột và kiểm tra nếu đã đủ 5 sản phẩm trên hàng
            if (++columnCount == 4) {
                columnCount = 0;
                constraints.gridx = 0;
                constraints.gridy++;
            } else {
                constraints.gridx++;
            }

            // Add button to the panel
            panelDiningTableList.add(tableButton);

        }

        // Refresh the panel
        panelDiningTableList.revalidate();
        panelDiningTableList.repaint();
    }

    private JButton createTableButton(DiningTableEntity diningTable) {
        // Create an ImageIcon with the dining-room.png file
        java.net.URL imageURL = getClass().getResource("/icon/dining-room.png");

        // Create an ImageIcon with the URL
        ImageIcon icon = new ImageIcon(imageURL);

        // Create a button for a dining table with the icon
        JButton tableButton = new JButton(diningTable.getTenBanAn(), icon);

        // Set the preferred size of the button based on the icon size
        tableButton.setPreferredSize(new Dimension(140, 140));

        tableButton.setHorizontalTextPosition(SwingConstants.CENTER);
        tableButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        // Add ActionListener to handle button click
        tableButton.addActionListener((ActionEvent e) -> {
            // Call a method to display detailed information
            displayDetailedDiningTable(diningTable);
        });

        return tableButton;
    }

    private void setTableButtonColors(JButton tableButton, String status) {
        if ("Đã đặt".equals(status)) {
            tableButton.setBackground(new Color(255, 153, 51)); // Màu nền FF9933
        } else if ("Đang phục vụ".equals(status)) {
            tableButton.setBackground(new Color(255, 102, 102)); // Màu nền FF6666
        } else if ("Còn trống".equals(status)) {
            tableButton.setBackground(new Color(255, 255, 255)); // Màu nền FFF
        }
    }

    private void displayDetailedDiningTable(DiningTableEntity diningTable) {
        OrderDAO orderDAO = new OrderDAO();
        List<OrderEntity> orderList = OrderDAO.getOrderList();

        // Lấy DefaultTableModel từ bảng tblDsGoiMon
        DefaultTableModel model = (DefaultTableModel) tblDsGoiMon.getModel();

        // Reset bảng bằng cách đặt số hàng bằng 0
        model.setRowCount(0);

        // Duyệt qua danh sách đơn hàng
        for (OrderEntity order : orderList) {
            // Kiểm tra xem đơn hàng có chứa bàn ăn không
            if (order.getIdBanAn().equals(diningTable.getIdBanAn())) {
                // Add to table tblDsGoiMon
                String tenMonAn = getNameFoodFromId(order.getIdMonAn());
                String soLuong = String.valueOf(order.getSoLuongMonAn());

                model.insertRow(0, new Object[]{tenMonAn, soLuong});
            }
        }

        // Set detailed information in your text fields, combobox, etc.
        textDiningTableId.setText(diningTable.getIdBanAn());
        textName.setText(diningTable.getTenBanAn());
        labelTenBan.setText(diningTable.getTenBanAn());
        textArea.setText(diningTable.getKhuVuc());
        textNumberSeats.setText(String.valueOf(diningTable.getSoChoNgoi()));
        textSurcharge.setText(String.valueOf(diningTable.getPhuThu()));
        CbStatus.setSelectedItem(diningTable.getTrangThai());
        textDesc.setText(diningTable.getMoTa());

        // Format date if needed
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss - dd/MM/yyyy");
        textUpdateDay.setText(diningTable.getTrangThai().equals("Đang phục vụ") ? dateFormat.format(diningTable.getNgayCapNhat()) : "");

        // Add idBanAn and tenBanAn to userInfo
        userInfo.put("idBanAn", diningTable.getIdBanAn());
        userInfo.put("tenBanAn", diningTable.getTenBanAn());
    }

    private void openFullScreenWindow(JFrame window) {
        window.setExtendedState(JFrame.MAXIMIZED_BOTH);
        window.setVisible(true);
        this.dispose();
    }

    DiningTableEntity getModel() {
        String maBan = textDiningTableId.getText();
        String name = textName.getText();
        String area = textArea.getText();
        String numberSeatsText = textNumberSeats.getText();
        String surchargeText = textSurcharge.getText();
        String status = CbStatus.getSelectedItem().toString();
        String desc = textDesc.getText();

        if (maBan.isEmpty() || name.isEmpty() || numberSeatsText.isEmpty() || surchargeText.isEmpty() || area.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }

        int numberSeats = Integer.parseInt(numberSeatsText);
        double surcharge = Double.parseDouble(surchargeText);

        if (numberSeats < 0 || surcharge < 0) {
            JOptionPane.showMessageDialog(null, "Số chỗ ngồi và Phụ thu phải là số không âm!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }

        DiningTableEntity model = new DiningTableEntity();
        model.setIdBanAn(maBan);
        model.setTenBanAn(name);
        model.setKhuVuc(area);
        model.setSoChoNgoi(numberSeats);
        model.setPhuThu(surcharge);
        model.setTrangThai(status);
        model.setMoTa(desc);

        return model;
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
        panelBody = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPanel9 = new javax.swing.JPanel();
        labelTenBan = new javax.swing.JLabel();
        cbDinnerTables = new javax.swing.JComboBox<>();
        btnGopBan = new javax.swing.JButton();
        btnChuyenBan = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDsGoiMon = new javax.swing.JTable();
        btnGoiMon = new javax.swing.JButton();
        btnThanhToan = new javax.swing.JButton();
        labelTenBan1 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        CbStatus = new javax.swing.JComboBox<>();
        jLabel23 = new javax.swing.JLabel();
        textUpdateDay = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        textDiningTableId = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        textName = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        textNumberSeats = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        textSurcharge = new javax.swing.JTextField();
        textDesc = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        textArea = new javax.swing.JTextField();
        jButton17 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        scrollPaneTableDining = new javax.swing.JScrollPane();
        panelDiningTableList = new javax.swing.JPanel();
        cbArea = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản lí nhân viên");

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
                .addContainerGap(81, Short.MAX_VALUE))
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
            .addComponent(labelHouse, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(labelAccount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        panelBody.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        jLabel5.setText("Khu vực bàn ăn");

        jPanel8.setBackground(new java.awt.Color(0, 51, 102));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jTabbedPane3.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        labelTenBan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelTenBan.setText(" ");

        cbDinnerTables.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbDinnerTables.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bàn 1", "Bàn 2", "Bàn 3" }));
        cbDinnerTables.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnGopBan.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnGopBan.setText("Gộp bàn");

        btnChuyenBan.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnChuyenBan.setText("Chuyển bàn");

        tblDsGoiMon.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblDsGoiMon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Tên món ăn", "Số lượng"
            }
        ));
        tblDsGoiMon.setAlignmentX(2.0F);
        tblDsGoiMon.setAlignmentY(2.0F);
        tblDsGoiMon.setRowHeight(30);
        jScrollPane1.setViewportView(tblDsGoiMon);

        btnGoiMon.setBackground(new java.awt.Color(51, 102, 0));
        btnGoiMon.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnGoiMon.setForeground(new java.awt.Color(255, 255, 255));
        btnGoiMon.setText("Thêm món");
        btnGoiMon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGoiMon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGoiMonActionPerformed(evt);
            }
        });

        btnThanhToan.setBackground(new java.awt.Color(0, 0, 102));
        btnThanhToan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnThanhToan.setForeground(new java.awt.Color(255, 255, 255));
        btnThanhToan.setText("Thanh toán");
        btnThanhToan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });

        labelTenBan1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelTenBan1.setText("Tên:");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel17.setText("Trạng thái:");

        CbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Còn trống", "Đang phục vụ", "Đã đặt" }));
        CbStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CbStatusActionPerformed(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel23.setText("Giờ vào:");

        textUpdateDay.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textUpdateDay.setText(" ");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel9Layout.createSequentialGroup()
                                .addComponent(cbDinnerTables, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnChuyenBan)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnGopBan))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel9Layout.createSequentialGroup()
                                .addComponent(btnGoiMon, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel9Layout.createSequentialGroup()
                                .addComponent(labelTenBan1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelTenBan, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel23)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textUpdateDay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(30, 30, 30))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTenBan)
                    .addComponent(labelTenBan1))
                .addGap(10, 10, 10)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(textUpdateDay))
                .addGap(10, 10, 10)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnGopBan, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbDinnerTables, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnChuyenBan, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnThanhToan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnGoiMon, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(80, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("Gọi món", new javax.swing.ImageIcon(getClass().getResource("/icon/Add to basket.png")), jPanel9); // NOI18N

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setForeground(new java.awt.Color(242, 242, 242));
        jPanel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Mã bàn:");

        textDiningTableId.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textDiningTableId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textDiningTableIdActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Tên bàn:");

        textName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textNameActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Số chỗ ngồi:");

        textNumberSeats.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textNumberSeats.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textNumberSeatsActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setText("Phụ thu:");

        textSurcharge.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textSurcharge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textSurchargeActionPerformed(evt);
            }
        });

        textDesc.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textDesc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textDescActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel19.setText("Mô tả:");

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel20.setText("Khu vực:");

        btnAdd.setBackground(new java.awt.Color(51, 102, 0));
        btnAdd.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd.setText("Thêm");
        btnAdd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnDelete.setBackground(new java.awt.Color(153, 0, 51));
        btnDelete.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete.setText("Xóa");
        btnDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnUpdate.setBackground(new java.awt.Color(0, 0, 102));
        btnUpdate.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnUpdate.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdate.setText("Sửa");
        btnUpdate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        textArea.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textAreaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel9)
                            .addComponent(jLabel19)
                            .addComponent(jLabel20))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(textName, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textSurcharge, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textNumberSeats)
                            .addComponent(textDesc, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textDiningTableId)
                            .addComponent(textArea, javax.swing.GroupLayout.Alignment.LEADING))))
                .addGap(30, 30, 30))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(textDiningTableId, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textName, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textNumberSeats, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textSurcharge, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textArea, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(textDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(259, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("Cập nhật", new javax.swing.ImageIcon(getClass().getResource("/icon/Add.png")), jPanel10); // NOI18N

        jButton17.setBackground(new java.awt.Color(255, 153, 51));
        jButton17.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton17.setForeground(new java.awt.Color(51, 51, 51));
        jButton17.setText("Đã đặt");

        jButton18.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton18.setForeground(new java.awt.Color(51, 51, 51));
        jButton18.setText("Còn trống");

        jButton19.setBackground(new java.awt.Color(255, 102, 102));
        jButton19.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton19.setForeground(new java.awt.Color(51, 51, 51));
        jButton19.setText("Đang phục vụ");

        scrollPaneTableDining.setBorder(null);
        scrollPaneTableDining.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        panelDiningTableList.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panelDiningTableListLayout = new javax.swing.GroupLayout(panelDiningTableList);
        panelDiningTableList.setLayout(panelDiningTableListLayout);
        panelDiningTableListLayout.setHorizontalGroup(
            panelDiningTableListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 667, Short.MAX_VALUE)
        );
        panelDiningTableListLayout.setVerticalGroup(
            panelDiningTableListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 559, Short.MAX_VALUE)
        );

        scrollPaneTableDining.setViewportView(panelDiningTableList);

        cbArea.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        javax.swing.GroupLayout panelBodyLayout = new javax.swing.GroupLayout(panelBody);
        panelBody.setLayout(panelBodyLayout);
        panelBodyLayout.setHorizontalGroup(
            panelBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBodyLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBodyLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbArea, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                        .addComponent(jButton18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton19, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton17))
                    .addComponent(scrollPaneTableDining, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(20, 20, 20)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jTabbedPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        panelBodyLayout.setVerticalGroup(
            panelBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelBodyLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(panelBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(panelBodyLayout.createSequentialGroup()
                        .addGroup(panelBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbArea)
                            .addComponent(jButton18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(scrollPaneTableDining, javax.swing.GroupLayout.PREFERRED_SIZE, 559, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(76, 76, 76))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelBody, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(panelBody, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrderActionPerformed
        Dishes monAn = new Dishes(userInfo);
        openFullScreenWindow(monAn);
    }//GEN-LAST:event_btnOrderActionPerformed

    private void btnPayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPayActionPerformed
        Bills hoaDon = new Bills(userInfo);
        openFullScreenWindow(hoaDon);
    }//GEN-LAST:event_btnPayActionPerformed

    private void btnConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmActionPerformed
        ConfirmDishes nvBep = new ConfirmDishes(userInfo);
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
        DiningTables khoHang = new DiningTables(userInfo);
        openFullScreenWindow(khoHang);
    }//GEN-LAST:event_btnWarehouseActionPerformed

    private void textDiningTableIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textDiningTableIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textDiningTableIdActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        DiningTableEntity model = getModel();

        if (!new DiningTableDAO().isIdDuplicated(model.getIdBanAn())) {
            DialogHelper.alert(this, "Mã ID đã chưa tồn tại. Vui lòng nhập lại mã ID!");
            return;
        }

        try {
            new DiningTableDAO().update(model);
            displayDiningTableList();
            displayDiningTableListByArea(selectedArea);
            DialogHelper.alert(this, "Cập nhật thành công!");
        } catch (Exception e) {
            DialogHelper.alert(this, "Cập nhật thất bại!");
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        String id = textDiningTableId.getText();
        if (!new DiningTableDAO().isIdDuplicated(id)) {
            DialogHelper.alert(this, "Mã ID đã chưa tồn tại. Vui lòng nhập lại mã ID!");
            return;
        }

        try {
            new DiningTableDAO().delete(id);
            displayDiningTableList();
            DialogHelper.alert(this, "Xóa thành công!");
        } catch (Exception e) {
            DialogHelper.alert(this, "Xóa thất bại!");
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        DiningTableEntity model = getModel();

        // Kiểm tra xem mã ID có bị trùng không
        if (new DiningTableDAO().isIdDuplicated(model.getIdBanAn())) {
            DialogHelper.alert(this, "Mã ID đã tồn tại. Vui lòng chọn mã ID khác!");
            return;
        }

        try {
            new DiningTableDAO().insert(model);
            displayDiningTableList();
            displayDiningTableListByArea(selectedArea);
            DialogHelper.alert(this, "Thêm mới thành công!");
        } catch (Exception e) {
            DialogHelper.alert(this, "Thêm mới thất bại!");
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void textSurchargeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textSurchargeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textSurchargeActionPerformed

    private void textNumberSeatsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textNumberSeatsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textNumberSeatsActionPerformed

    private void textNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textNameActionPerformed

    private void textDescActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textDescActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textDescActionPerformed

    private void btnGoiMonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGoiMonActionPerformed
        if (userInfo.containsKey("idBanAn")) {
            Dishes monAn = new Dishes(userInfo);
            openFullScreenWindow(monAn);
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn bàn trước khi gọi món.");
        }
    }//GEN-LAST:event_btnGoiMonActionPerformed

    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed
        if (userInfo.containsKey("idBanAn")) {
            Bills hoaDon = new Bills(userInfo);
            openFullScreenWindow(hoaDon);
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn bàn trước khi thanh toán.");
        }
    }//GEN-LAST:event_btnThanhToanActionPerformed

    private void CbStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CbStatusActionPerformed
        DiningTableEntity model = getModel();

        if (!new DiningTableDAO().isIdDuplicated(model.getIdBanAn())) {
            return;
        }

        try {
            new DiningTableDAO().update(model);
            displayDiningTableList();
            displayDiningTableListByArea(selectedArea);
        } catch (Exception e) {
            DialogHelper.alert(this, "Chuyển trạng thái thất bại!");
        }

    }//GEN-LAST:event_CbStatusActionPerformed

    private void textAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textAreaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textAreaActionPerformed

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DiningTables.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            Map<String, String> userInfo = new HashMap<>();
            userInfo.put("hoTen", "YourName");
            userInfo.put("chucVu", "YourPosition");

            DiningTables khoHang = new DiningTables(userInfo);
            khoHang.setExtendedState(JFrame.MAXIMIZED_BOTH);
            khoHang.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CbStatus;
    private javax.swing.JButton btnAccount;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCallTable;
    private javax.swing.JButton btnChuyenBan;
    private javax.swing.JButton btnClient;
    private javax.swing.JButton btnConfirm;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnDinnerTable;
    private javax.swing.JButton btnGoiMon;
    private javax.swing.JButton btnGopBan;
    private javax.swing.JButton btnOrder;
    private javax.swing.JButton btnOverview;
    private javax.swing.JButton btnPay;
    private javax.swing.JButton btnReport;
    private javax.swing.JButton btnStaff;
    private javax.swing.JButton btnThanhToan;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btnWarehouse;
    private javax.swing.JComboBox<String> cbArea;
    private javax.swing.JComboBox<String> cbDinnerTables;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JLabel labelAccount;
    private javax.swing.JLabel labelHouse;
    private javax.swing.JLabel labelLogo;
    private javax.swing.JLabel labelPosition;
    private javax.swing.JLabel labelTenBan;
    private javax.swing.JLabel labelTenBan1;
    private javax.swing.JPanel panelBody;
    private javax.swing.JPanel panelDiningTableList;
    private javax.swing.JScrollPane scrollPaneTableDining;
    private javax.swing.JTable tblDsGoiMon;
    private javax.swing.JTextField textArea;
    private javax.swing.JTextField textDesc;
    private javax.swing.JTextField textDiningTableId;
    private javax.swing.JTextField textName;
    private javax.swing.JTextField textNumberSeats;
    private javax.swing.JTextField textSurcharge;
    private javax.swing.JLabel textUpdateDay;
    // End of variables declaration//GEN-END:variables

}
