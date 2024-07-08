package restaurant.dialog;

import java.util.List;

import java.awt.Color;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledExecutorService;

import javax.swing.Timer;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;

import restaurant.utils.Auth;
import restaurant.utils.Common;
import restaurant.utils.Dialog;
import restaurant.dao.ProductDAO;
import restaurant.main.ManagementMode;
import restaurant.entity.ProductEntity;
import restaurant.utils.ComboBoxUtils;
import static restaurant.utils.ComboBoxUtils.addDataToComboBox;

import static restaurant.utils.TextFieldUtils.getRealText;
import static restaurant.utils.TextFieldUtils.addCommasToNumber;
import static restaurant.utils.TextFieldUtils.removeCommasFromNumber;
import restaurant.utils.ImageUtils;
import static restaurant.utils.ImageUtils.setImageButtonIcon;
import static restaurant.utils.ImageUtils.chooseImageFromDirectory;
import restaurant.utils.TextFieldUtils;

public final class UpdateProductJDialog extends javax.swing.JDialog {

    private ManagementMode mainManager;

    public UpdateProductJDialog(java.awt.Frame parent, boolean modal) {
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
        jLabel6 = new javax.swing.JLabel();
        texID = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        textPrice = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        textName = new javax.swing.JTextField();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnImage = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        cbKitchenArea = new javax.swing.JComboBox<>();
        btnAddChicken = new javax.swing.JButton();
        cbCategory = new javax.swing.JComboBox<>();
        btnAddCategory = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        radioOn = new javax.swing.JRadioButton();
        radioOff = new javax.swing.JRadioButton();
        jLabel14 = new javax.swing.JLabel();
        textUnit = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        textCostPrice = new javax.swing.JTextField();
        textDesc = new javax.swing.JTextField();

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
        setTitle("Cập nhật hàng hóa");
        setBackground(new java.awt.Color(255, 255, 255));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Mã hàng hóa:");

        texID.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        texID.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        texID.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(51, 204, 0)));
        texID.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        texID.setMargin(new java.awt.Insets(2, 60, 2, 6));
        texID.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                texIDMouseClicked(evt);
            }
        });
        texID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                texIDActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Tên hàng hóa:");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Giá bán:");

        textPrice.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textPrice.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        textPrice.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        textPrice.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        textPrice.setMargin(new java.awt.Insets(2, 60, 2, 6));
        textPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textPriceActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setText("Nhóm hàng:");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setText("Mô tả:");

        btnAdd.setBackground(new java.awt.Color(0, 153, 0));
        btnAdd.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd.setText("THÊM");
        btnAdd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAdd.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        textName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textName.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        textName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        textName.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        textName.setMargin(new java.awt.Insets(2, 60, 2, 6));
        textName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textNameActionPerformed(evt);
            }
        });

        btnUpdate.setBackground(new java.awt.Color(0, 0, 255));
        btnUpdate.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnUpdate.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdate.setText("SỬA");
        btnUpdate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUpdate.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setBackground(new java.awt.Color(255, 0, 0));
        btnDelete.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete.setText("XÓA");
        btnDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDelete.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnImage.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnImage.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImageActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setText("Khu chế biến:");

        cbKitchenArea.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbKitchenArea.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbKitchenArea.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnAddChicken.setBackground(new java.awt.Color(51, 153, 0));
        btnAddChicken.setForeground(new java.awt.Color(51, 153, 0));
        btnAddChicken.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/icon/plusWhile.png"))); // NOI18N
        btnAddChicken.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAddChicken.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddChickenActionPerformed(evt);
            }
        });

        cbCategory.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbCategory.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbCategory.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnAddCategory.setBackground(new java.awt.Color(51, 153, 0));
        btnAddCategory.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/icon/plusWhile.png"))); // NOI18N
        btnAddCategory.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAddCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddCategoryActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setText("Trạng thái:");

        radioOn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        radioOn.setSelected(true);
        radioOn.setText("Đang kinh doanh");
        radioOn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioOnActionPerformed(evt);
            }
        });

        radioOff.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        radioOff.setText("Ngừng kinh doanh");
        radioOff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioOffActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel14.setText("Đơn vị tính:");

        textUnit.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textUnit.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        textUnit.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        textUnit.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        textUnit.setMargin(new java.awt.Insets(2, 60, 2, 6));
        textUnit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textUnitActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Ảnh sản phẩm");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Giá vốn:");

        textCostPrice.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textCostPrice.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        textCostPrice.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        textCostPrice.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        textCostPrice.setMargin(new java.awt.Insets(2, 60, 2, 6));
        textCostPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textCostPriceActionPerformed(evt);
            }
        });

        textDesc.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnImage, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(texID, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel8)
                                        .addComponent(jLabel14)
                                        .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel9))
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(radioOn)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(radioOff))
                                        .addComponent(textUnit, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
                                        .addComponent(textPrice, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
                                        .addComponent(textName, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
                                        .addComponent(textCostPrice, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(cbKitchenArea, 0, 278, Short.MAX_VALUE)
                                            .addComponent(cbCategory, 0, 278, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(btnAddChicken, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btnAddCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                                    .addComponent(textDesc, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE))))))
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(texID, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textCostPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textUnit, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnImage, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAddCategory, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAddChicken, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbKitchenArea, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(radioOff, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(radioOn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void texIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_texIDActionPerformed

    }//GEN-LAST:event_texIDActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        insert();
    }//GEN-LAST:event_btnAddActionPerformed

    private void texIDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_texIDMouseClicked

    }//GEN-LAST:event_texIDMouseClicked

    private void textPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textPriceActionPerformed
    }//GEN-LAST:event_textPriceActionPerformed

    private void textNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textNameActionPerformed
    }//GEN-LAST:event_textNameActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        update();
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        delete();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImageActionPerformed
        imagePath = chooseImageFromDirectory(null, btnImage);
    }//GEN-LAST:event_btnImageActionPerformed

    private void radioOnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioOnActionPerformed

    }//GEN-LAST:event_radioOnActionPerformed

    private void radioOffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioOffActionPerformed
    }//GEN-LAST:event_radioOffActionPerformed

    private void textUnitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textUnitActionPerformed
    }//GEN-LAST:event_textUnitActionPerformed

    private void btnAddCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddCategoryActionPerformed
        openSmallDialog("Thêm nhóm hàng", "Nhóm hàng:", cbCategory);
    }//GEN-LAST:event_btnAddCategoryActionPerformed

    private void btnAddChickenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddChickenActionPerformed
        openSmallDialog("Thêm khu chế biến", "Khu chế biến:", cbKitchenArea);
    }//GEN-LAST:event_btnAddChickenActionPerformed

    private void textCostPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textCostPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textCostPriceActionPerformed

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UpdateProductJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            UpdateProductJDialog dialog = new UpdateProductJDialog(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnAddCategory;
    private javax.swing.JButton btnAddChicken;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnImage;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cbCategory;
    private javax.swing.JComboBox<String> cbKitchenArea;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JRadioButton radioOff;
    private javax.swing.JRadioButton radioOn;
    private javax.swing.JTextField texID;
    private javax.swing.JTextField textCostPrice;
    private javax.swing.JTextField textDesc;
    private javax.swing.JTextField textName;
    private javax.swing.JTextField textPrice;
    private javax.swing.JTextField textUnit;
    // End of variables declaration//GEN-END:variables

    Timer timer;
    boolean isEditable = true;
    JComboBox<String> comboBox;
    String imagePath = Auth.product != null ? Auth.product.getImageURL() : "";

    ScheduledFuture<?> scheduledFuture;
    ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);

    void init() {
        // <--- Setup common --->
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.WHITE);

        // Set text fields 
        JTextField[] textFields = {texID, textName, textCostPrice, textPrice, textUnit, textPrice};
        for (JTextField textField : textFields) {
            TextFieldUtils.addFocusBorder(textField, new Color(51, 204, 0), new Color(220, 220, 220));
        }

        // Set focus field text
        textName.requestFocus();
        TextFieldUtils.addPlaceholder(texID, "Mã tự động");
        Common.createButtonGroup(radioOn, radioOff);
        ComboBoxUtils.setComboboxStyle(cbCategory, cbKitchenArea);
        ImageUtils.setImageButtonIcon("src/restaurant/img/background.jpg", btnImage);

        // <--- Setup main --->
        // Attach event formatted price
        TextFieldUtils.addPriceDocumentListener(textPrice);
        TextFieldUtils.addPriceDocumentListener(textCostPrice);

        // Setup combobox
        String placeholder = "--Lựa chọn--";
        List<ProductEntity> dataList = new ProductDAO().getAll();
        addDataToComboBox(cbCategory, dataList, ProductEntity::getCategory, placeholder);
        addDataToComboBox(cbKitchenArea, dataList, ProductEntity::getKitchenArea, placeholder);

        // Set model
        ProductEntity product = Auth.product;
        this.setModel(product);
    }

    

    public void setIsEditable(boolean editable) {
        this.isEditable = editable;
        texID.setEditable(editable);
    }

    // <--- Dialog small
    void openSmallDialog(String title, String field, JComboBox combobox) {
        if (title.equals("") || field.equals("")) {
            return;
        }

        // Init dialog
        SmallJDialog dialog = new SmallJDialog(null, true);

        // Set title dialog
        dialog.setTitle(title);
        dialog.setLabel(field);
        dialog.setCombobox(combobox);

        // Open dialog
        dialog.setVisible(true);
    }

    void setComboBoxValue(String value, JComboBox cbMain) {
        if (value.trim().equals("") || value == null) {
            return;
        }

        DefaultComboBoxModel<String> model = (DefaultComboBoxModel<String>) cbMain.getModel();

        model.addElement(value); // Add value
        cbMain.setSelectedItem(value); // Display
    }
    // end --->

    // <--- CURD 
    ProductEntity getModel() {
        String id = getRealText(texID, "Mã tự động");
        String name = textName.getText();
        String costPriceText = textCostPrice.getText();
        String priceText = textPrice.getText();
        String unit = textUnit.getText();
        String category = cbCategory.getSelectedItem().toString();
        String kitchenArea = cbKitchenArea.getSelectedItem().toString();
        String desc = textDesc.getText();

        if (!validateInput(name, costPriceText, priceText, category, kitchenArea)) {
            return null;
        }

        try {
            ProductEntity model = new ProductEntity();
            model.setProductID(id);
            model.setProductName(name);
            model.setCostPrice(Integer.parseInt(removeCommasFromNumber(costPriceText)));
            model.setPrice(Integer.parseInt(removeCommasFromNumber(priceText)));
            model.setUnit(unit);
            model.setCategory(category);
            model.setKitchenArea(kitchenArea);
            model.setDescription(desc);
            model.setImageURL(imagePath.equals("") ? "src/restaurant/img/background.jpg" : imagePath);
            model.setStatus(radioOn.isSelected() ? "Đang kinh doanh" : "Ngừng kinh doanh");

            System.out.println(imagePath);

            return model;
        } catch (NumberFormatException e) {
            Dialog.error(this, "Lỗi!");
            System.err.println("Lỗi: " + e.getMessage());
            return null;
        }
    }

    boolean validateInput(String name, String costPriceText, String priceText, String category, String kitchenArea) {
        if (name.trim().isEmpty() || costPriceText.trim().isEmpty() || priceText.trim().isEmpty()
                || category.trim().isEmpty() || kitchenArea.trim().isEmpty()) {
            Dialog.warning(this, "Vui lòng nhập đầy đủ thông tin!");
            return false;
        }

        if (category.equals("--Lựa chọn--")) {
            Dialog.warning(this, "Vui lòng lựa chọn khu vực!");
            return false;
        }

        if (kitchenArea.equals("--Lựa chọn--")) {
            Dialog.warning(this, "Vui lòng lựa chọn khu chế biến!");
            return false;
        }

        try {
            int costPrice = Integer.parseInt(removeCommasFromNumber(costPriceText));
            if (costPrice <= 0) {
                Dialog.warning(this, "Số tiền phải lớn hơn 0!");
                return false;
            }

            int price = Integer.parseInt(removeCommasFromNumber(priceText));
            if (price <= 0) {
                Dialog.warning(this, "Số tiền phải lớn hơn 0!");
                return false;
            }
        } catch (NumberFormatException e) {
            Dialog.warning(this, "Số tiền phải là số hợp lệ!");
            return false;
        }

        return true;
    }

    void setModel(ProductEntity product) {
        if (product == null) {
            return;
        }

        // Set text 
        texID.setText(product.getProductID());
        textName.setText(product.getProductName());
        textUnit.setText(product.getUnit());
        textDesc.setText(product.getDescription());

        String costPrice = String.valueOf(product.getCostPrice());
        textCostPrice.setText(addCommasToNumber(costPrice));

        String price = String.valueOf(product.getPrice());
        textPrice.setText(addCommasToNumber(price));

        // Set combobox
        cbCategory.setSelectedItem(product.getCategory());
        cbKitchenArea.setSelectedItem(product.getKitchenArea());

        // Set radio
        String activiti = product.getStatus();
        radioOn.setSelected(activiti.equals("Đang kinh doanh"));
        radioOff.setSelected(activiti.equals("Ngừng kinh doanh"));

        // Set image
        setImageButtonIcon(imagePath, btnImage);
    }

    void insert() {
        ProductEntity model = getModel();
        if (model == null) {
            return;
        }

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
            dispose();
        } catch (Exception e) {
            Dialog.error(this, "Thêm mới thất bại!");
            e.printStackTrace();
        }
    }

    void update() {
        ProductEntity model = getModel();
        if (model == null) {
            return;
        }

        if (!new ProductDAO().isDuplicatedId(model.getProductID())) {
            Dialog.alert(this, "Mã ID đã chưa tồn tại. Vui lòng nhập lại mã ID!");
            return;
        }

        try {
            new ProductDAO().update(model);
            Dialog.success(this, "Cập nhật thành công!");
            dispose();
        } catch (Exception e) {
            Dialog.alert(this, "Cập nhật thất bại!");
        }
    }

    void delete() {
        String id = texID.getText();
        if (!new ProductDAO().isDuplicatedId(id)) {
            Dialog.alert(this, "Mã ID đã chưa tồn tại. Vui lòng nhập lại mã ID!");
            return;
        }

        try {
            new ProductDAO().delete(id);
            Dialog.alert(this, "Xóa thành công!");
            dispose();
        } catch (Exception e) {
            Dialog.error(this, "Xóa thất bại!");
        }
    }
    // end --->
}
