package restaurant.staff;

import restaurant.staff.DiningTables;
import restaurant.dialog.DetailOrderJDialog;
import java.util.*;
import java.util.List;
import java.text.SimpleDateFormat;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import javax.swing.*;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

import restaurant.dao.*;
import restaurant.entity.*;
import restaurant.frame.MainStaff;
import restaurant.utils.Auth;
import restaurant.utils.Dialog;
import restaurant.utils.Common;
import static restaurant.utils.Common.*;

public class Products extends javax.swing.JPanel {

    private MainStaff mainStaff;

    public Products(MainStaff mainStaff) {
        this.mainStaff = mainStaff;
        initComponents();
        this.init();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        tabbedPaneProduct = new javax.swing.JTabbedPane();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableOrder = new javax.swing.JTable();
        btnCancel = new javax.swing.JButton();
        btnNameDiningTable = new javax.swing.JButton();
        btnSubmit = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        textProductID = new javax.swing.JTextField();
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
        btnProductImage = new javax.swing.JButton();
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
        jPanel3 = new javax.swing.JPanel();
        CbCategoryProducts = new javax.swing.JComboBox<>();
        textSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        scrollPane = new javax.swing.JScrollPane();
        panelMainProducts = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        btnHistory = new javax.swing.JButton();
        btnSearch2 = new javax.swing.JButton();

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(420, 592));

        tabbedPaneProduct.setBackground(new java.awt.Color(255, 255, 255));
        tabbedPaneProduct.setFont(new java.awt.Font("Cascadia Code PL", 0, 14)); // NOI18N

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        tableOrder.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        tableOrder.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên món ăn             ", "Số lượng", "Cấp độ"
            }
        ));
        tableOrder.setAlignmentX(1.0F);
        tableOrder.setAlignmentY(1.0F);
        tableOrder.setFillsViewportHeight(true);
        tableOrder.setGridColor(new java.awt.Color(255, 255, 255));
        tableOrder.setRowHeight(35);
        jScrollPane1.setViewportView(tableOrder);
        if (tableOrder.getColumnModel().getColumnCount() > 0) {
            tableOrder.getColumnModel().getColumn(0).setPreferredWidth(150);
        }

        btnCancel.setBackground(new java.awt.Color(255, 0, 51));
        btnCancel.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        btnCancel.setForeground(new java.awt.Color(255, 255, 255));
        btnCancel.setText("HỦY");
        btnCancel.setToolTipText("Quay về bàn ăn");
        btnCancel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btnNameDiningTable.setFont(new java.awt.Font("Segoe UI Semibold", 0, 17)); // NOI18N
        btnNameDiningTable.setForeground(new java.awt.Color(30, 30, 30));
        btnNameDiningTable.setText("Chọn bàn (F1)");
        btnNameDiningTable.setToolTipText("Ấn F1 chuyển sang bàn ăn");
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
                        .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnNameDiningTable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(btnNameDiningTable, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        tabbedPaneProduct.addTab("Gọi món ", new javax.swing.ImageIcon(getClass().getResource("/icon/add-to-cart.png")), jPanel9); // NOI18N

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setForeground(new java.awt.Color(255, 255, 255));
        jPanel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Mã món ăn:");

        textProductID.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textProductID.setToolTipText("");
        textProductID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textProductIDActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Tên món ăn:");

        textDishName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Phân loại:");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel17.setText("Ngày thêm:");

        textAdditionalDay.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel19.setText("Nguyên liệu:");

        comboBoxStatus.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        comboBoxStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bật hoạt động", "Tắt hoạt động" }));

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

        btnProductImage.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnProductImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductImageActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setText("Ngày cập nhật:");

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel18.setText("Mô tả:");

        textUpdateDay.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        textMoney.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Trạng thái:");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setText("Đơn giá:");

        textCategory.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        textDesc.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

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
                                    .addComponent(textProductID)
                                    .addComponent(textDishName))
                                .addGap(18, 18, 18)
                                .addComponent(btnProductImage, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(35, 35, 35)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(comboBoxStatus, 0, 294, Short.MAX_VALUE)
                            .addComponent(textMoney))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textProductID, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(textDishName, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(btnProductImage, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        textProductID.getAccessibleContext().setAccessibleName("");

        tabbedPaneProduct.addTab("Cập nhật ", new javax.swing.ImageIcon(getClass().getResource("/icon/update.png")), jPanel10); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabbedPaneProduct)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabbedPaneProduct, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 592, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        CbCategoryProducts.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        CbCategoryProducts.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả" }));
        CbCategoryProducts.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        textSearch.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textSearchActionPerformed(evt);
            }
        });

        btnSearch.setBackground(new java.awt.Color(255, 102, 102));
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

        scrollPane.setBorder(null);

        panelMainProducts.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panelMainProductsLayout = new javax.swing.GroupLayout(panelMainProducts);
        panelMainProducts.setLayout(panelMainProductsLayout);
        panelMainProductsLayout.setHorizontalGroup(
            panelMainProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 853, Short.MAX_VALUE)
        );
        panelMainProductsLayout.setVerticalGroup(
            panelMainProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 554, Short.MAX_VALUE)
        );

        scrollPane.setViewportView(panelMainProducts);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/filter1.png"))); // NOI18N

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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CbCategoryProducts, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(textSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSearch2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnHistory, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
            .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 826, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(CbCategoryProducts, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textSearch, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSearch, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSearch2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnHistory, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 538, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        cancel();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnNameDiningTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNameDiningTableActionPerformed
        mainStaff.displayStaffPanels(new DiningTables(mainStaff));
    }//GEN-LAST:event_btnNameDiningTableActionPerformed

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        submit();
    }//GEN-LAST:event_btnSubmitActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        insert();
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        delete();
    }//GEN-LAST:event_btnRemoveActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        update();
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnProductImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductImageActionPerformed
        Common.chooseImageFromDirectory(null, btnProductImage);
    }//GEN-LAST:event_btnProductImageActionPerformed

    private void btnChoseIngredientsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChoseIngredientsActionPerformed
        //        ChoseIngredient choseIngredientFrame = new ChoseIngredient();
        //        choseIngredientFrame.setLocationRelativeTo(this); // Hiển thị frame mới ở giữa frame hiện tại
        //        choseIngredientFrame.setVisible(true);
    }//GEN-LAST:event_btnChoseIngredientsActionPerformed

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

    private void textSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textSearchActionPerformed
        displayProductsBySearchAndCategory();
    }//GEN-LAST:event_textSearchActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        displayProductsBySearchAndCategory();
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnHistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHistoryActionPerformed
        new DetailOrderJDialog(null, true).setVisible(true);
    }//GEN-LAST:event_btnHistoryActionPerformed

    private void btnSearch2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearch2ActionPerformed
//        openFullScreenWindow(new Products());
    }//GEN-LAST:event_btnSearch2ActionPerformed

    private void textProductIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textProductIDActionPerformed
        Common.addPlaceholder(textProductID, "Mã tự động nếu không nhập");
    }//GEN-LAST:event_textProductIDActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CbCategoryProducts;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnChoseIngredients;
    private javax.swing.JButton btnHistory;
    private javax.swing.JButton btnNameDiningTable;
    private javax.swing.JButton btnProductImage;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnSearch2;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> comboBoxStatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelMainProducts;
    private javax.swing.JRadioButton radioKitchenAreaDishes;
    private javax.swing.JRadioButton radioKitchenAreaDrinks;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JTabbedPane tabbedPaneProduct;
    private javax.swing.JTable tableOrder;
    private javax.swing.JTextField textAdditionalDay;
    private javax.swing.JTextField textCategory;
    private javax.swing.JTextField textDesc;
    private javax.swing.JTextField textDishName;
    private javax.swing.JTextField textMoney;
    private javax.swing.JTextField textProductID;
    private javax.swing.JTextField textSearch;
    private javax.swing.JTextField textUpdateDay;
    // End of variables declaration//GEN-END:variables

    String imagePath;
    String kitchenArea;
    String selectedCategory;
    List<ProductEntity> dataProductsByCategory;
    List<ProductEntity> dataProducts = new ProductDAO().getAll();

    void init() {
        Common.customizeScrollBar(scrollPane);
        Common.customizeTable(tableOrder, new int[]{0});
        Common.setupButtonColumn(tableOrder, 1);
        Common.setupComboBoxColumn(tableOrder, 2);
        Common.addPlaceholder(textProductID, "Mã có thể tự động sinh");

        // Get food list
        hideSecondTab();
        displayButtonTableName();
        displayProductList(dataProducts);
        setupComboboxCategoryProducts();
        handleClickComboboxCategoryProducts();
    }

    // <--- common
    void hideSecondTab() {
        if (!Auth.isManager()) {
            tabbedPaneProduct.removeTabAt(1);
        }
    }

    void displayButtonTableName() {
        String tableName = "";
        int orderCount = 0;
        String totalAmount = "";

        if (Auth.table != null) {
            tableName = Objects.toString(Auth.table.getTableName(), "");
            orderCount = Auth.orderCount;
            totalAmount = Auth.totalAmount;
        }

        // Đặt nội dung cho nút
        btnNameDiningTable.setText(tableName.equals("")
                ? "Chọn bàn (F1)"
                : tableName + " - Tổng: " + totalAmount + "₫ / " + orderCount + " đơn");
    }
    // end --->

    // <--- Add, update, delete, submit, delete
    ProductEntity getModel() {
        String id = textProductID.getText();
        String name = textDishName.getText();
        String category = textCategory.getText();
        String priceText = textMoney.getText();
        String status = comboBoxStatus.getSelectedItem().toString();
        String desc = textDesc.getText();

        try {
            if (name.isEmpty() || category.isEmpty() || priceText.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }

            int price = Integer.parseInt(Common.removeCommasFromNumber(priceText));
            if (price < 0) {
                JOptionPane.showMessageDialog(null, "Số tiền là số không âm!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }

            ProductEntity model = new ProductEntity();
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

    void insert() {
        ProductEntity model = getModel();

        if (new ProductDAO().isDuplicatedId(model.getProductID())) {
            Dialog.alert(this, "Mã ID đã tồn tại. Vui lòng chọn mã ID khác!");
            return;
        }

        if (new ProductDAO().isDuplicateName(model.getProductName())) {
            Dialog.alert(this, "Tên món đã tồn tại. Vui lòng sửa tên khác!");
            return;
        }

        try {
            new ProductDAO().insert(model);
            Dialog.success(this, "Thêm mới thành công!");

            dataProducts = new ProductDAO().getAll();
            displayProductList(dataProducts);
        } catch (Exception e) {
            Dialog.error(this, "Thêm mới thất bại!");
            e.printStackTrace();
        }
    }

    void update() {
        ProductEntity model = getModel();

        if (!new ProductDAO().isDuplicatedId(model.getProductID())) {
            Dialog.alert(this, "Mã ID đã chưa tồn tại. Vui lòng nhập lại mã ID!");
            return;
        }

        try {
            new ProductDAO().update(model);
            Dialog.success(this, "Cập nhật thành công!");

            dataProducts = new ProductDAO().getAll();
            displayProductList(dataProducts);
        } catch (Exception e) {
            Dialog.alert(this, "Cập nhật thất bại!");
        }
    }

    void delete() {
        ProductEntity model = getModel();

        String id = textProductID.getText();
        if (!new ProductDAO().isDuplicatedId(id)) {
            Dialog.alert(this, "Mã ID đã chưa tồn tại. Vui lòng nhập lại mã ID!");
            return;
        }

        try {
            new ProductDAO().delete(id);
            Dialog.alert(this, "Xóa thành công!");

            dataProducts = new ProductDAO().getAll();
            displayProductList(dataProducts);
        } catch (Exception e) {
            Dialog.error(this, "Xóa thất bại!");
        }
    }

    void cancel() {
        // Nếu bàn chưa chọn món thì rời đi luôn
        DefaultTableModel model = (DefaultTableModel) tableOrder.getModel();
        if (model.getRowCount() == 0) {
            mainStaff.displayStaffPanels(new DiningTables(mainStaff));
            return;
        }

        // Nếu bàn đã gọi món thì hỏi trước khi thoát
        Boolean result = Dialog.confirm(this, "Nếu thoát bạn sẽ mất các món ăn đã chọn?");
        if (result) {
            mainStaff.displayStaffPanels(new DiningTables(mainStaff));
        }
    }
    // end --->    

    // <--- Display and handle events products
    void displayProductList(List<ProductEntity> dataList) {
        // Reset food list
        panelMainProducts.removeAll();
        panelMainProducts.setLayout(new GridBagLayout());

        // Init gridbag 
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 8, 16, 8);
        gbc.anchor = GridBagConstraints.NORTHWEST;

        int columnCount = 5;
        for (int i = 0; i < dataList.size(); i++) {
            // create panel product item
            ProductEntity dataItem = dataList.get(i);
            JPanel panelProduct = createPanelProduct(dataItem);

            // Tính toán vị trí dựa trên số cột
            gbc.gridx = i % columnCount;
            gbc.gridy = i / columnCount;

            panelMainProducts.add(panelProduct, gbc);
        }

        // Refresh the panel
        panelMainProducts.repaint();
        panelMainProducts.revalidate();
    }

    JPanel createPanelProduct(ProductEntity product) {
        // Create a image product
        String imageUrl = product.getImageURL();
        ImageIcon scaledIcon = getScaledImageIcon(imageUrl, 200, 200);

        // Create a JLabel name
        JLabel textLabel = new JLabel(product.getProductName());
        textLabel.setForeground(new Color(30, 30, 30));
        textLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        textLabel.setFont(new Font(textLabel.getFont().getName(), Font.BOLD, 14));

        // Create a JLabel price
        String formattedPrice = Common.addCommasToNumber(String.valueOf(product.getPrice()));
        JLabel priceLabel = new JLabel(formattedPrice + " VND");
        priceLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        priceLabel.setFont(new Font(priceLabel.getFont().getName(), Font.PLAIN, 14));

        // Create border in half
        MatteBorder topBorder = BorderFactory.createMatteBorder(1, 0, 0, 0, new Color(200, 200, 200));

        // Create label top contains (scaledIcon) 
        JLabel labelTop = new JLabel(scaledIcon);
        labelTop.setHorizontalAlignment(JLabel.CENTER);

        // Create button "Đặt món"
        JButton orderButton = createButton("Đặt món", new Color(51, 153, 255), new Dimension(120, 40));

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
        mainPanel.setPreferredSize(new Dimension(146, 200));
        mainPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        mainPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        // mainPanel contains (labelTop, panelBottom)
        mainPanel.add(labelTop, BorderLayout.CENTER);
        mainPanel.add(panelBottom, BorderLayout.SOUTH);

        // Call method displayDetailedInfo when user clicked
        mainPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                displayDetailedInfo(product);
            }
        });

        orderButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                displayDetailedInfo(product);
                handleClickButtonOrder(product);
            }
        });

        return mainPanel;
    }

    void displayDetailedInfo(ProductEntity product) {
        // Set detailed information in your text fields, combobox, etc.
        String money = Common.addCommasToNumber(String.valueOf(product.getPrice()));
        textMoney.setText(money);
        textProductID.setText(product.getProductID());
        textDishName.setText(product.getProductName());
        textCategory.setText(product.getCategory());
        textDesc.setText(product.getDescription());
        imagePath = product.getImageURL();
        kitchenArea = product.getKitchenArea();
        if ("Khu bếp".equals(kitchenArea)) {
            radioKitchenAreaDrinks.setSelected(false);
            radioKitchenAreaDishes.setSelected(true);
        } else if ("Quầy nước".equals(kitchenArea)) {
            radioKitchenAreaDrinks.setSelected(true);
            radioKitchenAreaDishes.setSelected(false);
        }

        String imageUrl = product.getImageURL();
        ImageIcon scaledIcon = getScaledImageIcon(imageUrl, 94, 94);

        // Format date if needed
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy  -  HH:mm:ss");
        textAdditionalDay.setText(dateFormat.format(product.getDateAdded()));
        textUpdateDay.setText(dateFormat.format(product.getLastUpdated()));

        // Avatar 
        btnProductImage.setBorder(null);
        btnProductImage.setIcon(scaledIcon);
        btnProductImage.setPreferredSize(new Dimension(94, 94));
    }

    void handleClickButtonOrder(ProductEntity product) {
        if ("Chọn bàn (F1)".equals(btnNameDiningTable.getText())) {
            Dialog.warning(this, "Vui lòng chọn bàn ăn!");
            return;
        }

        // Get info
        String productName = product.getProductName();
        DefaultTableModel saveOrder = (DefaultTableModel) tableOrder.getModel();

        // Add new row into the table at the end
        Object[] rowData = {productName, 1};
        saveOrder.addRow(rowData);
    }
    // end --->

    // <--- Handle click button submit
    void submit() {

        if (tableOrder != null && tableOrder.getRowCount() == 0) {
            Dialog.warning(this, "Vui lòng chọn món ăn!");
            return;
        }

        // Get data from the table ordering more dishes
        DefaultTableModel model = (DefaultTableModel) tableOrder.getModel();
        Vector<Vector> data = model.getDataVector();

        // Get diningTableId in auth
        String diningTableId = Auth.table.getTableID();
        try {
            // Create an order if don't have one yet
            OrderEntity existingOrder = new OrdersDAO().getPendingOrderByTableId(diningTableId);
            if (existingOrder == null) {
                // Create new idcoice after create new order
                int invoiceId = new InvoiceDAO().insert();
                createNewOrder(invoiceId, diningTableId);
            }

            // Get newly created order information
            existingOrder = new OrdersDAO().getPendingOrderByTableId(diningTableId);
            addDishesToExistingOrder(existingOrder, data);

            // Open file table
            mainStaff.displayStaffPanels(new DiningTables(mainStaff));
        } catch (Exception e) {
            Dialog.error(this, "Đã xảy ra lỗi khi xử lý đơn hàng!");
            e.printStackTrace();
        }
    }

    private void createNewOrder(int invoiceId, String diningTableId) {
        try {
            // Create new order
            OrderEntity newOrder = new OrderEntity();
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

    private void addDishesToExistingOrder(OrderEntity existingOrder, Vector<Vector> data) {
        try {
            // Get the current order detail list of an existing order
            List<OrderDetailEntity> currentDetails = new OrderDetailDAO().getByOrderId(existingOrder.getOrderId());

            // For each new list of dishes
            for (Vector<Object> row : data) {
                String dishName = row.get(0).toString();
                int dishQuantity = Integer.parseInt(row.get(1).toString());
                String dishDesc = row.get(2) != null ? row.get(2).toString() : "";
                String dishId = ProductDAO.getIdDishFromName(dishName);

                // Add new each dish on detail order
                for (int i = 1; i <= dishQuantity; i++) {
                    OrderDetailEntity newDetail = new OrderDetailEntity();
                    newDetail.setOrderID(existingOrder.getOrderId());
                    newDetail.setProductID(dishId);
                    newDetail.setProductQuantity(1);
                    newDetail.setProductDesc(dishDesc);
                    new OrderDetailDAO().insert(newDetail);
                }
            }

            Dialog.alert(this, "Thêm món ăn thành công!");
        } catch (Exception e) {
            Dialog.alert(this, "Thêm món ăn thất bại!");
            e.printStackTrace();
        }
    }
    // end --->

    // <--- Handle event search and catogory
    void setupComboboxCategoryProducts() {
        // Create a DefaultComboBoxModel 
        DefaultComboBoxModel<String> cbModelProducts = new DefaultComboBoxModel<>();
        cbModelProducts.addElement("Tất cả món");
        Set<String> categorySet = new HashSet<>();

        // Collect unique kitchen area
        for (ProductEntity dateItem : dataProducts) {
            categorySet.add(dateItem.getCategory());
        }

        // Convert the Set to an array
        String[] categoryList = categorySet.toArray(String[]::new);
        for (String categoryItem : categoryList) {
            cbModelProducts.addElement(categoryItem);
        }

        // Set the ComboBoxModel to the comboBox
        CbCategoryProducts.setModel(cbModelProducts);
    }

    void handleClickComboboxCategoryProducts() {
        // Attach event 
        CbCategoryProducts.addActionListener((ActionEvent e) -> {
            displayProductsBySearchAndCategory();
        });

        // Reset default
        CbCategoryProducts.setSelectedIndex(0);
    }

    void displayProductsBySearchAndCategory() {
        // Lấy danh mục đã chọn
        selectedCategory = (String) CbCategoryProducts.getSelectedItem();

        // Xử lý từ khóa tìm kiếm
        String keyword = textSearch.getText().trim().replaceAll("\\s+", "");

        // Nếu danh mục là "Tất cả món", đặt selectedCategory thành chuỗi rỗng
        if (selectedCategory.equals("Tất cả món")) {
            selectedCategory = "";
        }

        // Tìm kiếm sản phẩm theo từ khóa và danh mục
        dataProductsByCategory = new ProductDAO().searchByNameInCategory(keyword, selectedCategory);

        // Hiển thị danh sách sản phẩm
        displayProductList(dataProductsByCategory);
    }
    // end --->

}
