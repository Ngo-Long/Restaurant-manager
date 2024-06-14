package restaurant.dialog;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JTextField;

import restaurant.utils.Auth;
import restaurant.utils.Common;
import restaurant.utils.Dialog;
import restaurant.dao.DiningTableDAO;
import restaurant.dao.ProductDAO;
import restaurant.entity.DiningTableEntity;
import restaurant.entity.ProductEntity;
import static restaurant.utils.Common.getScaledImageIcon;

public final class UpdateProductJDialog extends javax.swing.JDialog {

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
        textDesc = new javax.swing.JTextField();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        btnProductImage = new javax.swing.JButton();
        btnProductImage1 = new javax.swing.JButton();
        btnProductImage2 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        cbKitchenArea = new javax.swing.JComboBox<>();
        btnAddArea = new javax.swing.JButton();
        cbCaterory = new javax.swing.JComboBox<>();
        btnAddCategory = new javax.swing.JButton();

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
        setTitle("Cập nhật sản phẩm");
        setBackground(new java.awt.Color(255, 255, 255));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Mã SP:");

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
        jLabel7.setText("Tên SP:");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Đơn giá:");

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
        jLabel10.setText("Phân loại:");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setText("Mô tả:");

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

        textDesc.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textDesc.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        textDesc.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        textDesc.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        textDesc.setMargin(new java.awt.Insets(2, 60, 2, 6));
        textDesc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textDescActionPerformed(evt);
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

        btnDelete.setBackground(new java.awt.Color(255, 0, 0));
        btnDelete.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete.setText("XÓA");
        btnDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Ảnh:");

        btnProductImage.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnProductImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductImageActionPerformed(evt);
            }
        });

        btnProductImage1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnProductImage1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductImage1ActionPerformed(evt);
            }
        });

        btnProductImage2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnProductImage2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductImage2ActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setText("Khu vực:");

        cbKitchenArea.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbKitchenArea.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbKitchenArea.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnAddArea.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Add.png"))); // NOI18N
        btnAddArea.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        cbCaterory.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbCaterory.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbCaterory.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnAddCategory.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Add.png"))); // NOI18N
        btnAddCategory.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(18, 18, 18)
                        .addComponent(cbKitchenArea, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnAddArea, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6)
                            .addComponent(jLabel9))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnProductImage, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(10, 10, 10)
                                        .addComponent(btnProductImage1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(10, 10, 10)
                                        .addComponent(btnProductImage2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(texID)
                                    .addComponent(textDesc)
                                    .addComponent(textName)
                                    .addComponent(textPrice)))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbCaterory, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnAddCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnProductImage, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnProductImage1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnProductImage2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(texID, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(textName, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbCaterory, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnAddCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbKitchenArea, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddArea, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void texIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_texIDActionPerformed

    }//GEN-LAST:event_texIDActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        insert();
    }//GEN-LAST:event_btnAddActionPerformed

    private void textDescActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textDescActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textDescActionPerformed

    private void texIDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_texIDMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_texIDMouseClicked

    private void textPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textPriceActionPerformed

    private void textNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textNameActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        update();
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        delete();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnProductImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductImageActionPerformed
        Common.chooseImageFromDirectory(null, btnProductImage);
    }//GEN-LAST:event_btnProductImageActionPerformed

    private void btnProductImage1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductImage1ActionPerformed
        Common.chooseImageFromDirectory(null, btnProductImage);
    }//GEN-LAST:event_btnProductImage1ActionPerformed

    private void btnProductImage2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductImage2ActionPerformed
        Common.chooseImageFromDirectory(null, btnProductImage);
    }//GEN-LAST:event_btnProductImage2ActionPerformed

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
    private javax.swing.JButton btnAddArea;
    private javax.swing.JButton btnAddCategory;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnProductImage;
    private javax.swing.JButton btnProductImage1;
    private javax.swing.JButton btnProductImage2;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cbCaterory;
    private javax.swing.JComboBox<String> cbKitchenArea;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField texID;
    private javax.swing.JTextField textDesc;
    private javax.swing.JTextField textName;
    private javax.swing.JTextField textPrice;
    // End of variables declaration//GEN-END:variables

    String imagePath;

    void init() {
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(new Color(255, 255, 255));

        textName.requestFocus();
        Common.addPlaceholder(texID, "Mã tự động sinh nếu không nhập");
        setModel();

        // Đặt tất cả JTextField vào mảng
        JTextField[] textFields = {texID, textName, textPrice, textPrice, textDesc};
        for (JTextField textField : textFields) {
            Common.addFocusBorder(textField, new Color(51, 204, 0), new Color(220, 220, 220));
        }
    }

    boolean validateInput(String name, String numberSeatsText, String area) {
        if (name.isEmpty() || numberSeatsText.isEmpty() || area.isEmpty()) {
            Dialog.warning(this, "Vui lòng nhập đầy đủ thông tin!");
            return false;
        }

        try {
            int numberSeats = Integer.parseInt(numberSeatsText);
            if (numberSeats <= 0) {
                Dialog.warning(this, "Số chỗ ngồi phải là số lớn hơn 0!");
                return false;
            }
        } catch (NumberFormatException e) {
            Dialog.warning(this, "Số chỗ ngồi phải là một số hợp lệ!");
            return false;
        }

        return true;
    }

    ProductEntity getModel() {
        String id = texID.getText();
        String name = textName.getText();
        String priceText = textPrice.getText();
        String category = cbCaterory.getSelectedItem().toString();
        String kitchenArea = cbKitchenArea.getSelectedItem().toString();
        String desc = textDesc.getText();
        String status = "Ngưng hoạt động";

        try {
            if (name.isEmpty() || category.isEmpty() || priceText.isEmpty()) {
                Dialog.warning(this, "Vui lòng nhập đầy đủ thông tin!");
            }

            int price = Integer.parseInt(Common.removeCommasFromNumber(priceText));
            if (price < 0) {
                Dialog.warning(this, "Số tiền là số không âm!");
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

    void setModel() {
        ProductEntity product = Auth.product;
        if (product == null) {
            return;
        }

        // Set info
        texID.setText(product.getProductID());
        textName.setText(product.getProductName());
        cbCaterory.setSelectedItem(product.getCategory());
        cbKitchenArea.setSelectedItem(product.getKitchenArea());
        textDesc.setText(product.getDescription());
        String price = String.valueOf(product.getPrice());
        textPrice.setText(Common.addCommasToNumber(price));

        // Set image
        String imageUrl = product.getImageURL();
        ImageIcon scaledIcon = getScaledImageIcon(imageUrl, 94, 94);
        btnProductImage.setBorder(null);
        btnProductImage.setIcon(scaledIcon);
        btnProductImage.setPreferredSize(new Dimension(94, 94));
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
            dispose();
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
