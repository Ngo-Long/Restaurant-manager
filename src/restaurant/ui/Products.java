package restaurant.ui;

import java.io.File;
import java.util.*;
import java.util.List;
import java.text.SimpleDateFormat;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import javax.swing.*;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

import restaurant.dao.*;
import restaurant.entity.*;
import restaurant.utils.Auth;
import restaurant.utils.Dialog;
import restaurant.utils.Common;
import static restaurant.utils.Common.*;

public class Products extends javax.swing.JFrame {

    private String imagePath;
    private String kitchenArea;
    private List<ProductsEntity> dishesList;

    public Products() {
        initComponents();

        Common.initClock(labelHouse);
        Common.setAccountLabel(labelAccount);
        Common.customizeScrollBar(scrollPane);
        Common.customizeTable(tableOrder, new int[]{0});

        Common.setupButtonColumn(tableOrder, 1);
        Common.setupComboBoxColumn(tableOrder, 2);

        displayTableName();
        displayDishesList();
    }

    ProductsEntity getModel() {
        String id = textDishID.getText();
        String name = textDishName.getText();
        String category = textCategory.getText();
        String priceText = textMoney.getText();
        String status = comboBoxStatus.getSelectedItem().toString();
        String desc = textDesc.getText();

        try {
            if (id.isEmpty() || name.isEmpty() || category.isEmpty() || priceText.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }

            int price = Integer.parseInt(Common.removeCommasFromNumber(priceText));
            if (price < 0) {
                JOptionPane.showMessageDialog(null, "Số tiền là số không âm!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }

            ProductsEntity model = new ProductsEntity();
            model.setProductID(id);
            model.setProductName(name);
            model.setCategory(category);
            model.setKitchenArea(kitchenArea);
            model.setPrice(price);
            model.setDescription(desc);
            model.setImageURL(imagePath);
            model.setStatus(status);

            return model;
        } catch (NumberFormatException e) {
            System.err.println("Lỗi: " + e.getMessage());
            return null;
        }
    }

    void displayTableName() {
        String tableName = "";

        if (Auth.table != null) {
            tableName = Objects.toString(Auth.table.getTableName(), "");
        }

        btnNameDiningTable.setText(tableName.equals("") ? "Chọn bàn" : tableName);
    }

    private void displayDishesList() {
        // Reset food list
        panelListDishes.removeAll();
        panelListDishes.setLayout(new GridBagLayout());

        // Get food list
        dishesList = new ProductsDAO().getAll();

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(6, 6, 6, 6);
        gbc.anchor = GridBagConstraints.NORTHWEST;

        int columnCount = 4; // Số cột trên mỗi hàng
        for (int i = 0; i < dishesList.size(); i++) {
            ProductsEntity dishItem = dishesList.get(i);
            JPanel btnDishItem = createButtonDishItem(dishItem);

            // Tính toán vị trí dựa trên số cột
            gbc.gridx = i % columnCount; // 4 item mỗi hàng
            gbc.gridy = i / columnCount;

            panelListDishes.add(btnDishItem, gbc);
        }

        // Refresh the panel
        panelListDishes.revalidate();
        panelListDishes.repaint();
    }

    private JPanel createButtonDishItem(ProductsEntity dishItem) {
        // Create a image product
        String imageUrl = dishItem.getImageURL();
        ImageIcon scaledIcon = getScaledImageIcon(imageUrl, 150, 150);

        // Create a JLabel name
        JLabel textLabel = new JLabel(dishItem.getProductName());
        textLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        textLabel.setFont(new Font(textLabel.getFont().getName(), Font.BOLD, 14));

        // Create a JLabel price
        String formattedPrice = Common.addCommasToNumber(String.valueOf(dishItem.getPrice()));
        JLabel priceLabel = new JLabel(formattedPrice + " VND");
        priceLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        priceLabel.setFont(new Font(priceLabel.getFont().getName(), Font.PLAIN, 14));

        // Create border in half
        MatteBorder topBorder = BorderFactory.createMatteBorder(1, 0, 0, 0, new Color(200, 200, 200));

        // Create button "Đặt món"
        JButton orderButton = createButton("Đặt món", new Color(51, 153, 255), new Dimension(120, 40));
        orderButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                handleOrderDish(dishItem);
                displayDetailedInfo(dishItem);
            }
        });

        // Create label top contains (scaledIcon) 
        JLabel labelTop = new JLabel(scaledIcon);
        labelTop.setHorizontalAlignment(JLabel.CENTER);

        // Create panel bottom contains (name, price, border, button)
        JPanel panelBottom = new JPanel();
        panelBottom.add(textLabel);
        panelBottom.add(priceLabel);
        panelBottom.add(orderButton);
        panelBottom.setBackground(Color.WHITE);
        panelBottom.setBorder(BorderFactory.createEmptyBorder(2, 0, 0, 0));
        panelBottom.setLayout(new BoxLayout(panelBottom, BoxLayout.Y_AXIS));
        panelBottom.setBorder(BorderFactory.createCompoundBorder(topBorder, panelBottom.getBorder()));

        // Create a panel main 
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setPreferredSize(new Dimension(140, 174));
        mainPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        mainPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        // mainPanel contains (labelTop, panelBottom)
        mainPanel.add(labelTop, BorderLayout.CENTER);
        mainPanel.add(panelBottom, BorderLayout.SOUTH);

        // Call method displayDetailedInfo when user clicked
        mainPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                displayDetailedInfo(dishItem);
            }
        });

        return mainPanel;
    }

    private void displayDetailedInfo(ProductsEntity dishItem) {
        // Set detailed information in your text fields, combobox, etc.
        String money = Common.addCommasToNumber(String.valueOf(dishItem.getPrice()));
        textMoney.setText(money);
        textDishID.setText(dishItem.getProductID());
        textDishName.setText(dishItem.getProductName());
        textCategory.setText(dishItem.getCategory());
        textDesc.setText(dishItem.getDescription());
        imagePath = dishItem.getImageURL();
        kitchenArea = dishItem.getKitchenArea();
        if ("Khu bếp".equals(kitchenArea)) {
            radioKitchenAreaDrinks.setSelected(false);
            radioKitchenAreaDishes.setSelected(true);
        } else if ("Quầy nước".equals(kitchenArea)) {
            radioKitchenAreaDrinks.setSelected(true);
            radioKitchenAreaDishes.setSelected(false);
        }

        String imageUrl = dishItem.getImageURL();
        ImageIcon scaledIcon = getScaledImageIcon(imageUrl, 94, 94);

        // Format date if needed
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy  -  HH:mm:ss");
        textAdditionalDay.setText(dateFormat.format(dishItem.getDateAdded()));
        textUpdateDay.setText(dateFormat.format(dishItem.getLastUpdated()));

        // Avatar 
        btnFood.setBorder(null);
        btnFood.setIcon(scaledIcon);
        btnFood.setPreferredSize(new Dimension(94, 94));
    }

    // handle when click button "Đặt món" 
    private void handleOrderDish(ProductsEntity dishItem) {
        if ("Chọn bàn".equals(btnNameDiningTable.getText())) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn bàn!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Get info
        String productName = dishItem.getProductName();
        DefaultTableModel saveOrder = (DefaultTableModel) tableOrder.getModel();

        // Add new row into the table
        Object[] rowData = {productName, 1};
        saveOrder.insertRow(0, rowData);
    }

    private void openFullScreenWindow(JFrame window) {
        window.setVisible(true);
        window.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.dispose();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        CbPhanLoai = new javax.swing.JComboBox<>();
        textSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        scrollPane = new javax.swing.JScrollPane();
        panelListDishes = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableOrder = new javax.swing.JTable();
        btnCancel = new javax.swing.JButton();
        btnNameDiningTable = new javax.swing.JButton();
        btnSubmit = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        textDishID = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        textDishName = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        textAdditionalDay = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        comboBoxStatus = new javax.swing.JComboBox<>();
        btnAdd = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnFood = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        textUpdateDay = new javax.swing.JTextField();
        textMoney = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        textCategory = new javax.swing.JTextField();
        textDesc = new javax.swing.JTextField();
        btnChoseIngredients = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        radioKitchenAreaDishes = new javax.swing.JRadioButton();
        radioKitchenAreaDrinks = new javax.swing.JRadioButton();
        jPanel4 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        labelHouse = new javax.swing.JLabel();
        labelAccount = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
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

        CbPhanLoai.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        CbPhanLoai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả" }));

        textSearch.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textSearchActionPerformed(evt);
            }
        });

        btnSearch.setBackground(new java.awt.Color(0, 51, 102));
        btnSearch.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSearch.setForeground(new java.awt.Color(255, 255, 255));
        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Search.png"))); // NOI18N
        btnSearch.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        scrollPane.setBorder(null);

        panelListDishes.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panelListDishesLayout = new javax.swing.GroupLayout(panelListDishes);
        panelListDishes.setLayout(panelListDishesLayout);
        panelListDishesLayout.setHorizontalGroup(
            panelListDishesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 851, Short.MAX_VALUE)
        );
        panelListDishesLayout.setVerticalGroup(
            panelListDishesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 554, Short.MAX_VALUE)
        );

        scrollPane.setViewportView(panelListDishes);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/filter1.png"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(textSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(0, 0, 0)
                .addComponent(CbPhanLoai, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
            .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 861, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(CbPhanLoai, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(textSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 529, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jTabbedPane3.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane3.setFont(new java.awt.Font("Cascadia Code PL", 0, 14)); // NOI18N

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        tableOrder.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        tableOrder.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên món ăn", "Số lượng", "Cấp độ"
            }
        ));
        tableOrder.setAlignmentX(1.0F);
        tableOrder.setAlignmentY(1.0F);
        tableOrder.setGridColor(new java.awt.Color(255, 255, 255));
        tableOrder.setRowHeight(35);
        jScrollPane1.setViewportView(tableOrder);
        if (tableOrder.getColumnModel().getColumnCount() > 0) {
            tableOrder.getColumnModel().getColumn(0).setPreferredWidth(140);
            tableOrder.getColumnModel().getColumn(1).setPreferredWidth(105);
        }

        btnCancel.setBackground(new java.awt.Color(255, 0, 51));
        btnCancel.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        btnCancel.setForeground(new java.awt.Color(255, 255, 255));
        btnCancel.setText("HỦY");
        btnCancel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btnNameDiningTable.setFont(new java.awt.Font("Cascadia Code", 2, 18)); // NOI18N
        btnNameDiningTable.setText("Chọn bàn");
        btnNameDiningTable.setBorder(null);
        btnNameDiningTable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNameDiningTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNameDiningTableActionPerformed(evt);
            }
        });

        btnSubmit.setBackground(new java.awt.Color(0, 153, 0));
        btnSubmit.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        btnSubmit.setForeground(new java.awt.Color(255, 255, 255));
        btnSubmit.setText("XÁC NHẬN");
        btnSubmit.setToolTipText("Ấn xác nhận để chuyển tới bếp");
        btnSubmit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSubmit, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 397, Short.MAX_VALUE)
                    .addComponent(btnNameDiningTable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNameDiningTable, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 429, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jTabbedPane3.addTab("Gọi món ", new javax.swing.ImageIcon(getClass().getResource("/icon/Add to basket.png")), jPanel9); // NOI18N

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setForeground(new java.awt.Color(255, 255, 255));
        jPanel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Mã món ăn:");

        textDishID.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textDishID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textDishIDActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Tên món ăn:");

        textDishName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textDishName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textDishNameActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Phân loại:");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel17.setText("Ngày thêm:");

        textAdditionalDay.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textAdditionalDay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textAdditionalDayActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel19.setText("Nguyên liệu:");

        comboBoxStatus.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        comboBoxStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bật hoạt động", "Tắt hoạt động" }));
        comboBoxStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxStatusActionPerformed(evt);
            }
        });

        btnAdd.setBackground(new java.awt.Color(0, 153, 0));
        btnAdd.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd.setText("THÊM");
        btnAdd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnRemove.setBackground(new java.awt.Color(255, 0, 51));
        btnRemove.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnRemove.setForeground(new java.awt.Color(255, 255, 255));
        btnRemove.setText("XÓA");
        btnRemove.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });

        btnUpdate.setBackground(new java.awt.Color(0, 0, 255));
        btnUpdate.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnUpdate.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdate.setText("SỬA");
        btnUpdate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnFood.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnFood.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFoodActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setText("Ngày cập nhật:");

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel18.setText("Mô tả:");

        textUpdateDay.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textUpdateDay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textUpdateDayActionPerformed(evt);
            }
        });

        textMoney.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textMoney.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textMoneyActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Trạng thái:");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setText("Đơn giá:");

        textCategory.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textCategoryActionPerformed(evt);
            }
        });

        textDesc.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textDesc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textDescActionPerformed(evt);
            }
        });

        btnChoseIngredients.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnChoseIngredients.setText("Chọn nguyên liệu");
        btnChoseIngredients.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnChoseIngredients.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChoseIngredientsActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setText("Khu chế biến:");

        radioKitchenAreaDishes.setBackground(new java.awt.Color(255, 255, 255));
        radioKitchenAreaDishes.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        radioKitchenAreaDishes.setSelected(true);
        radioKitchenAreaDishes.setText("Khu bếp");
        radioKitchenAreaDishes.setPreferredSize(new java.awt.Dimension(76, 25));
        radioKitchenAreaDishes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioKitchenAreaDishesActionPerformed(evt);
            }
        });

        radioKitchenAreaDrinks.setBackground(new java.awt.Color(255, 255, 255));
        radioKitchenAreaDrinks.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        radioKitchenAreaDrinks.setText("Quầy nước");
        radioKitchenAreaDrinks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioKitchenAreaDrinksActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(btnRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textUpdateDay, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel17)
                            .addComponent(jLabel7)
                            .addComponent(jLabel19)
                            .addComponent(jLabel18)
                            .addComponent(jLabel12))
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(radioKitchenAreaDishes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(radioKitchenAreaDrinks)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textAdditionalDay, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnChoseIngredients, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textDesc, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(textCategory)))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textDishID)
                                    .addComponent(textDishName))
                                .addGap(18, 18, 18)
                                .addComponent(btnFood, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(35, 35, 35)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(comboBoxStatus, 0, 294, Short.MAX_VALUE)
                            .addComponent(textMoney))))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textDishID, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(textDishName, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(btnFood, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(radioKitchenAreaDrinks)
                        .addComponent(radioKitchenAreaDishes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnChoseIngredients, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(textMoney, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(comboBoxStatus, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(textAdditionalDay, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(textUpdateDay, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );

        jTabbedPane3.addTab("Cập nhật ", new javax.swing.ImageIcon(getClass().getResource("/icon/update.png")), jPanel10); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane3)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jTabbedPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 1, 1, new java.awt.Color(204, 204, 204)));

        jButton3.setBackground(new java.awt.Color(238, 238, 238));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/bell.png"))); // NOI18N
        jButton3.setBorder(null);

        labelHouse.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        labelHouse.setText("00:00:00");

        labelAccount.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        labelAccount.setText("TÀI KHOẢN: NGÔ KIM LONG");

        jLabel14.setFont(new java.awt.Font("Segoe Print", 1, 26)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 153, 153));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("HOT NOODLE");
        jLabel14.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelHouse)
                .addGap(18, 18, 18)
                .addComponent(labelAccount)
                .addGap(18, 18, 18)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
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
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        ProductsEntity model = getModel();

        if (new ProductsDAO().isDuplicatedId(model.getProductID())) {
            Dialog.alert(this, "Mã ID đã tồn tại. Vui lòng chọn mã ID khác!");
            return;
        }

        if (new ProductsDAO().isDuplicateName(model.getProductName())) {
            Dialog.alert(this, "Tên món đã tồn tại. Vui lòng sửa tên khác!");
            return;
        }

        try {
            new ProductsDAO().insert(model);
            displayDishesList();
            Dialog.alert(this, "Thêm mới thành công!");
        } catch (Exception e) {
            Dialog.alert(this, "Thêm mới thất bại!");
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        String id = textDishID.getText();
        if (!new ProductsDAO().isDuplicatedId(id)) {
            Dialog.alert(this, "Mã ID đã chưa tồn tại. Vui lòng nhập lại mã ID!");
            return;
        }

        try {
            new ProductsDAO().delete(id);
            displayDishesList();
            Dialog.alert(this, "Xóa thành công!");
        } catch (Exception e) {
            Dialog.alert(this, "Xóa thất bại!");
        }
    }//GEN-LAST:event_btnRemoveActionPerformed

    private void textDishIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textDishIDActionPerformed
    }//GEN-LAST:event_textDishIDActionPerformed

    private void textDishNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textDishNameActionPerformed
    }//GEN-LAST:event_textDishNameActionPerformed

    private void textAdditionalDayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textAdditionalDayActionPerformed
    }//GEN-LAST:event_textAdditionalDayActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        Boolean result = Dialog.confirm(this, "Nếu thoát bạn sẽ mất các món ăn đã chọn?");
        if (result) {
            openFullScreenWindow(new DiningTables());
        }
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnFoodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFoodActionPerformed
        String imgPath = "src/restaurant/img";
        JFileChooser fileChooser = new JFileChooser(imgPath);

        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            imagePath = selectedFile.getAbsolutePath();
            new Common().resetImagePath(imagePath, btnFood);
        }
    }//GEN-LAST:event_btnFoodActionPerformed


    private void textUpdateDayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textUpdateDayActionPerformed
    }//GEN-LAST:event_textUpdateDayActionPerformed

    private void textMoneyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textMoneyActionPerformed
    }//GEN-LAST:event_textMoneyActionPerformed

    private void comboBoxStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxStatusActionPerformed
    }//GEN-LAST:event_comboBoxStatusActionPerformed

    private void textCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textCategoryActionPerformed
    }//GEN-LAST:event_textCategoryActionPerformed

    private void textDescActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textDescActionPerformed
    }//GEN-LAST:event_textDescActionPerformed

    private void btnChoseIngredientsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChoseIngredientsActionPerformed
//        ChoseIngredient choseIngredientFrame = new ChoseIngredient();
//        choseIngredientFrame.setLocationRelativeTo(this); // Hiển thị frame mới ở giữa frame hiện tại
//        choseIngredientFrame.setVisible(true);
    }//GEN-LAST:event_btnChoseIngredientsActionPerformed

    private void textSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textSearchActionPerformed
        String keyword = textSearch.getText().trim();
        String selectedPhanLoai = (String) CbPhanLoai.getSelectedItem();
        searchAndClassifyMenu(keyword, selectedPhanLoai, panelListDishes);
    }//GEN-LAST:event_textSearchActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        String keyword = textSearch.getText().trim();
        String selectedPhanLoai = (String) CbPhanLoai.getSelectedItem();
        searchAndClassifyMenu(keyword, selectedPhanLoai, panelListDishes);
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        if (tableOrder != null && tableOrder.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn món ăn!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Get data from the table ordering more dishes
        DefaultTableModel model = (DefaultTableModel) tableOrder.getModel();
        Vector<Vector> data = model.getDataVector();

        // Get diningTableId in auth
        String diningTableId = Auth.table.getTableID();
        try {
            // Create an order if don't have one yet
            OrdersEntity existingOrder = new OrdersDAO().getOrderByTableId(diningTableId);
            if (existingOrder == null) {
                // Create new idcoice after create new order
                int invoiceId = new InvoicesDAO().insert();
                createNewOrder(invoiceId, diningTableId);
            }

            // Get newly created order information
            existingOrder = new OrdersDAO().getOrderByTableId(diningTableId);
            addDishesToExistingOrder(existingOrder, data);

            // Open file table
            DiningTables chonBan = new DiningTables();
            openFullScreenWindow(chonBan);
        } catch (Exception e) {
            Dialog.alert(this, "Đã xảy ra lỗi khi xử lý đơn hàng!");
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnSubmitActionPerformed

    private void createNewOrder(int invoiceId, String diningTableId) {
        try {
            // Create new order
            OrdersEntity newOrder = new OrdersEntity();
            newOrder.setInvoiceID(invoiceId);
            newOrder.setTableId(diningTableId);
            newOrder.setStatus("Đang đặt hàng");
            newOrder.setMethod("Tại nhà hàng");
            new OrdersDAO().insert(newOrder);
        } catch (Exception e) {
            Dialog.alert(this, "Tạo đơn hàng thất bại!");
            e.printStackTrace();
        }
    }

    private void addDishesToExistingOrder(OrdersEntity existingOrder, Vector<Vector> data) {
        try {
            // Get the current order detail list of an existing order
            List<OrderDetailsEntity> currentDetails = new OrderDetailsDAO().getByOrderId(existingOrder.getOrderId());

            // For each new list of dishes
            for (Vector<Object> row : data) {
                String dishName = row.get(0).toString();
                int dishQuantity = Integer.parseInt(row.get(1).toString());
                String dishDesc = row.get(2) != null ? row.get(2).toString() : "";
                String dishId = ProductsDAO.getIdDishFromName(dishName);

                // Add new each dish on detail order
                for (int i = 1; i <= dishQuantity; i++) {
                    OrderDetailsEntity newDetail = new OrderDetailsEntity();
                    newDetail.setOrderID(existingOrder.getOrderId());
                    newDetail.setProductID(dishId);
                    newDetail.setProductQuantity(1);
                    newDetail.setProductDesc(dishDesc);
                    new OrderDetailsDAO().insert(newDetail);
                }
            }

            Dialog.alert(this, "Thêm món ăn thành công!");
        } catch (Exception e) {
            Dialog.alert(this, "Thêm món ăn thất bại!");
            e.printStackTrace();
        }
    }

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        ProductsEntity model = getModel();

        System.out.println(kitchenArea);

        if (!new ProductsDAO().isDuplicatedId(model.getProductID())) {
            Dialog.alert(this, "Mã ID đã chưa tồn tại. Vui lòng nhập lại mã ID!");
            return;
        }

        try {
            new ProductsDAO().update(model);
            displayDishesList();
            Dialog.alert(this, "Cập nhật thành công!");
        } catch (Exception e) {
            Dialog.alert(this, "Cập nhật thất bại!");
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnNameDiningTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNameDiningTableActionPerformed
        DiningTables chonBan = new DiningTables();
        openFullScreenWindow(chonBan);
    }//GEN-LAST:event_btnNameDiningTableActionPerformed

    private void radioKitchenAreaDishesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioKitchenAreaDishesActionPerformed
        kitchenArea = radioKitchenAreaDishes.getText();
        radioKitchenAreaDishes.setSelected(true);
        radioKitchenAreaDrinks.setSelected(false);
    }//GEN-LAST:event_radioKitchenAreaDishesActionPerformed

    private void radioKitchenAreaDrinksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioKitchenAreaDrinksActionPerformed
        kitchenArea = radioKitchenAreaDrinks.getText();
        radioKitchenAreaDrinks.setSelected(true);
        radioKitchenAreaDishes.setSelected(false);
    }//GEN-LAST:event_radioKitchenAreaDrinksActionPerformed

    private void menuItemSystemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemSystemActionPerformed

    }//GEN-LAST:event_menuItemSystemActionPerformed

    private void menuLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuLogoutActionPerformed
        Auth.clear();
        new Login(this, true).setVisible(true);
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

    public static void searchAndClassifyMenu(String keyword, String phanLoai, JPanel panel) {
//        try (Connection connection = getConnection()) {
//            String sql = "SELECT * FROM MonAn WHERE (? IS NULL OR phanLoai = ?)"
//                    + "AND (ten LIKE ? OR idMonAn LIKE ?)";
//
//            if ("Tất cả".equals(phanLoai)) {
//                phanLoai = null;
//            }
//
//            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
//                preparedStatement.setString(1, phanLoai);
//                preparedStatement.setString(2, phanLoai != null ? "%" + phanLoai + "%" : "%");
//                preparedStatement.setString(3, "%" + keyword + "%");
//                preparedStatement.setString(4, "%" + keyword + "%");
//                ResultSet resultSet = preparedStatement.executeQuery();
//
//                panel.removeAll();
//                while (resultSet.next()) {
//                    String item = "ID: " + resultSet.getString("idMonAn")
//                            + " | Tên: " + resultSet.getString("ten")
//                            + " | Giá: " + resultSet.getBigDecimal("gia")
//                            + " | Mô tả: " + resultSet.getString("moTa")
//                            + " | Hình ảnh: " + resultSet.getString("hinhAnh")
//                            + " | Phân loại: " + resultSet.getString("phanLoai")
//                            + " | Trạng thái: " + resultSet.getString("trangThai");
//
//                    JLabel label = new JLabel(item);
//                    panel.add(label);
//                }
//
//                if (panel.getComponentCount() > 0) {
//                    JOptionPane.showMessageDialog(null, "Tìm kiếm và phân loại thành công!", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
//                } else {
//                    JOptionPane.showMessageDialog(null, "Không tìm thấy kết quả nào!", "Thông Báo", JOptionPane.WARNING_MESSAGE);
//                }
//
//                panel.revalidate();
//                panel.repaint();
//            }
//        } catch (SQLException e) {
//            JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi khi tìm kiếm và phân loại nguyên liệu.", "Lỗi", JOptionPane.ERROR_MESSAGE);
//            e.printStackTrace();
//        }
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Products.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            new Products().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CbPhanLoai;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnChoseIngredients;
    private javax.swing.JButton btnFood;
    private javax.swing.JButton btnNameDiningTable;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> comboBoxStatus;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JPopupMenu.Separator jSeparator8;
    private javax.swing.JPopupMenu.Separator jSeparator9;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JLabel labelAccount;
    private javax.swing.JLabel labelHouse;
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
    private javax.swing.JPanel panelListDishes;
    private javax.swing.JRadioButton radioKitchenAreaDishes;
    private javax.swing.JRadioButton radioKitchenAreaDrinks;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JTable tableOrder;
    private javax.swing.JTextField textAdditionalDay;
    private javax.swing.JTextField textCategory;
    private javax.swing.JTextField textDesc;
    private javax.swing.JTextField textDishID;
    private javax.swing.JTextField textDishName;
    private javax.swing.JTextField textMoney;
    private javax.swing.JTextField textSearch;
    private javax.swing.JTextField textUpdateDay;
    // End of variables declaration//GEN-END:variables
}
