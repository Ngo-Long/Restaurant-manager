package restaurant.dialog;

import java.util.Set;
import java.util.List;
import java.util.HashSet;

import java.awt.Color;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledExecutorService;

import javax.swing.Timer;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.event.DocumentListener;

import restaurant.utils.Auth;
import restaurant.utils.Common;
import restaurant.utils.Dialog;
import restaurant.dao.ProductDAO;
import restaurant.main.MainManager;
import restaurant.entity.ProductEntity;

import static restaurant.utils.Common.getRealText;
import static restaurant.utils.Common.createButtonGroup;
import static restaurant.utils.Common.addCommasToNumber;
import static restaurant.utils.Common.removeCommasFromNumber;
import static restaurant.utils.ImageUtils.setImageButtonIcon;
import static restaurant.utils.ImageUtils.chooseImageFromDirectory;

public final class UpdateProductJDialog extends javax.swing.JDialog {

    private MainManager mainManager;

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
        btnProductImage = new javax.swing.JButton();
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
        jLabel10.setText("Nhóm hàng:");

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

        btnProductImage.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnProductImage.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnProductImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductImageActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setText("Khu chế biến:");

        cbKitchenArea.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbKitchenArea.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbKitchenArea.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnAddChicken.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Add.png"))); // NOI18N
        btnAddChicken.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAddChicken.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddChickenActionPerformed(evt);
            }
        });

        cbCategory.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbCategory.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbCategory.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnAddCategory.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Add.png"))); // NOI18N
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
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Ảnh sản phẩm");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(248, 248, 248)
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnProductImage, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
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
                                    .addComponent(jLabel12))
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(radioOn)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(radioOff))
                                    .addComponent(textUnit)
                                    .addComponent(textPrice)
                                    .addComponent(textName)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(cbKitchenArea, 0, 268, Short.MAX_VALUE)
                                            .addComponent(cbCategory, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(btnAddCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGap(12, 12, 12)
                                                .addComponent(btnAddChicken, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addComponent(textDesc))))))
                .addGap(0, 30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(texID, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textName, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textUnit, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAddCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cbCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(btnProductImage, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAddChicken, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cbKitchenArea, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(radioOff, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(radioOn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void texIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_texIDActionPerformed

    }//GEN-LAST:event_texIDActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        insert();
    }//GEN-LAST:event_btnAddActionPerformed

    private void textDescActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textDescActionPerformed
    }//GEN-LAST:event_textDescActionPerformed

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

    private void btnProductImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductImageActionPerformed
        imagePath = chooseImageFromDirectory(null, btnProductImage);
    }//GEN-LAST:event_btnProductImageActionPerformed

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
    private javax.swing.JButton btnProductImage;
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
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JRadioButton radioOff;
    private javax.swing.JRadioButton radioOn;
    private javax.swing.JTextField texID;
    private javax.swing.JTextField textDesc;
    private javax.swing.JTextField textName;
    private javax.swing.JTextField textPrice;
    private javax.swing.JTextField textUnit;
    // End of variables declaration//GEN-END:variables

    Timer timer;
    String imagePath;
    boolean isEditable = true;
    JComboBox<String> comboBox;
    ScheduledFuture<?> scheduledFuture;
    ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);

    void init() {
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(new Color(240, 240, 240));

        // <--- Setup common --->
        createButtonGroup(radioOn, radioOff);

        // Set field text
        textName.requestFocus();
        Common.addPlaceholder(texID, "Mã tự động");

        // Set text fields 
        JTextField[] textFields = {texID, textName, textPrice, textUnit, textPrice, textDesc};
        for (JTextField textField : textFields) {
            Common.addFocusBorder(textField, new Color(51, 204, 0), new Color(220, 220, 220));
        }

        // <--- Setup main --->
        initEventHandle();
        setupMultipleCombobox();
        setModel();
    }

    void initEventHandle() {
        // Attach event textSearch
        textPrice.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateFormattedText();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateFormattedText();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateFormattedText();
            }
        });

    }

    public void updateFormattedText() {
        if (scheduledFuture != null && !scheduledFuture.isDone()) {
            scheduledFuture.cancel(false);
        }

        scheduledFuture = scheduledExecutorService.schedule(() -> {
            SwingUtilities.invokeLater(() -> {
                String text = textPrice.getText().trim();
                String removeCommas = removeCommasFromNumber(text);
                String addCommas = addCommasToNumber(removeCommas);
                textPrice.setText(addCommas);
            });
        }, 500, TimeUnit.MILLISECONDS);
    }

    public void setIsEditable(boolean editable) {
        this.isEditable = editable;
        texID.setEditable(editable);
    }

    void setupMultipleCombobox() {
        // Get data list
        List<ProductEntity> dataList = new ProductDAO().getAll();

        // Add into combobox 
        DefaultComboBoxModel<String> cbModelKitchen = new DefaultComboBoxModel<>();
        DefaultComboBoxModel<String> cbModelCategory = new DefaultComboBoxModel<>();

        // Use TreeSet to automatically sort and remove duplicate elements
        Set<String> areaSetKitchen = new HashSet<>();
        Set<String> areaSetCategory = new HashSet<>();

        // Load data into combobox 
        for (ProductEntity dataItem : dataList) {
            areaSetKitchen.add(dataItem.getKitchenArea());
            areaSetCategory.add(dataItem.getCategory());
        }

        // Add "--Tất cả--" to the beginning of the set
        cbModelKitchen.addElement("--Lựa chọn--");
        cbModelCategory.addElement("--Lựa chọn--");

        // Convert the Set to a sorted array --> Set to the comboBox
        areaSetKitchen.stream().sorted().forEach(cbModelKitchen::addElement);
        areaSetCategory.stream().sorted().forEach(cbModelCategory::addElement);

        // Into combobox
        cbKitchenArea.setModel(cbModelKitchen);
        cbCategory.setModel(cbModelCategory);
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
        String priceText = textPrice.getText();
        String unit = textUnit.getText();
        String category = cbCategory.getSelectedItem().toString();
        String kitchenArea = cbKitchenArea.getSelectedItem().toString();
        String desc = textDesc.getText();

        if (!validateInput(name, priceText, category, kitchenArea)) {
            return null;
        }

        try {
            ProductEntity model = new ProductEntity();
            model.setProductID(id);
            model.setProductName(name);
            model.setPrice(Integer.parseInt(removeCommasFromNumber(priceText)));
            model.setUnit(unit);
            model.setCategory(category);
            model.setKitchenArea(kitchenArea);
            model.setDescription(desc);
            model.setImageURL(imagePath);
            model.setStatus(radioOn.isSelected() ? "Đang kinh doanh" : "Ngừng kinh doanh");

            return model;
        } catch (NumberFormatException e) {
            Dialog.error(this, "Lỗi!");
            System.err.println("Lỗi: " + e.getMessage());
            return null;
        }
    }

    boolean validateInput(String name, String priceText, String category, String kitchenArea) {
        if (name.trim().isEmpty() || priceText.trim().isEmpty()
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

    void setModel() {
        ProductEntity product = Auth.product;
        if (product == null) {
            return;
        }

        // Set text 
        texID.setText(product.getProductID());
        textName.setText(product.getProductName());
        String price = String.valueOf(product.getPrice());
        textPrice.setText(Common.addCommasToNumber(price));
        textUnit.setText(product.getUnit());
        textDesc.setText(product.getDescription());

        // Set combobox
        cbCategory.setSelectedItem(product.getCategory());
        cbKitchenArea.setSelectedItem(product.getKitchenArea());

        // Set radio
        String activiti = product.getStatus();
        radioOn.setSelected(activiti.equals("Đang kinh doanh"));
        radioOff.setSelected(activiti.equals("Ngừng kinh doanh"));

        // Set image
        if (product.getImageURL() == null) {
            imagePath = "src/restaurant/img/background.jpg";
            setImageButtonIcon(imagePath, btnProductImage);
        } else {
            setImageButtonIcon(product.getImageURL(), btnProductImage);
        }
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
