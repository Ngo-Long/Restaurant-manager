package restaurant.dialog;

import java.awt.Color;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import restaurant.utils.Auth;
import restaurant.utils.Common;
import restaurant.utils.Dialog;
import restaurant.dao.DiningTableDAO;
import restaurant.entity.DiningTableEntity;
import restaurant.entity.GoodsEntity;
import restaurant.utils.ComboBoxUtils;
import static restaurant.utils.TextFieldUtils.addCommasToNumber;
import static restaurant.utils.TextFieldUtils.getRealText;
import static restaurant.utils.TextFieldUtils.removeCommasFromNumber;
import restaurant.utils.ImageUtils;
import restaurant.utils.TextFieldUtils;

public final class UpdateGoodsJDialog extends javax.swing.JDialog {

    public UpdateGoodsJDialog(java.awt.Frame parent, boolean modal) {
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
        textId = new javax.swing.JTextField();
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
        jLabel12 = new javax.swing.JLabel();
        radioOn = new javax.swing.JRadioButton();
        radioOff = new javax.swing.JRadioButton();
        textInitQuantity = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        textMiniQuantity = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        btnImage = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        cbCategory = new javax.swing.JComboBox<>();
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
        setTitle("Cập nhật hàng hóa");
        setBackground(new java.awt.Color(255, 255, 255));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Mã hàng hóa:");

        textId.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textId.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        textId.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(51, 204, 0)));
        textId.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        textId.setMargin(new java.awt.Insets(2, 60, 2, 6));
        textId.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                textIdMouseClicked(evt);
            }
        });
        textId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textIdActionPerformed(evt);
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
        jLabel10.setText("Phân loại:");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setText("Trạng thái:");

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
        textDesc.setBorder(javax.swing.BorderFactory.createEtchedBorder());
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

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setText("Mô tả:");

        radioOn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        radioOn.setSelected(true);
        radioOn.setText("Đang hoạt động");
        radioOn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioOnActionPerformed(evt);
            }
        });

        radioOff.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        radioOff.setText("Ngưng hoạt động");
        radioOff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioOffActionPerformed(evt);
            }
        });

        textInitQuantity.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textInitQuantity.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        textInitQuantity.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        textInitQuantity.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        textInitQuantity.setMargin(new java.awt.Insets(2, 60, 2, 6));
        textInitQuantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textInitQuantityActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setText("SL hiện tại:");

        textMiniQuantity.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textMiniQuantity.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        textMiniQuantity.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        textMiniQuantity.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        textMiniQuantity.setMargin(new java.awt.Insets(2, 60, 2, 6));
        textMiniQuantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textMiniQuantityActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel14.setText("SL tối thiểu:");

        btnImage.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnImage.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImageActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Ảnh sản phẩm");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel11)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(textId, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
                            .addComponent(textName, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
                            .addComponent(textPrice, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
                            .addComponent(textDesc, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(radioOn)
                                .addGap(18, 18, 18)
                                .addComponent(radioOff))
                            .addComponent(textInitQuantity, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
                            .addComponent(textMiniQuantity, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(cbCategory, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAddCategory))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textId, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(textPrice, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btnAddCategory, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cbCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                            .addComponent(textInitQuantity)))
                    .addComponent(btnImage, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(textMiniQuantity, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(radioOn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(radioOff, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textIdActionPerformed

    }//GEN-LAST:event_textIdActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        insert();
    }//GEN-LAST:event_btnAddActionPerformed

    private void textIdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_textIdMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_textIdMouseClicked

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

    private void radioOnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioOnActionPerformed

    }//GEN-LAST:event_radioOnActionPerformed

    private void radioOffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioOffActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radioOffActionPerformed

    private void textDescActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textDescActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textDescActionPerformed

    private void textInitQuantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textInitQuantityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textInitQuantityActionPerformed

    private void textMiniQuantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textMiniQuantityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textMiniQuantityActionPerformed

    private void btnImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImageActionPerformed
        imagePath = chooseImageFromDirectory(null, btnImage);
    }//GEN-LAST:event_btnImageActionPerformed

    private void btnAddCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddCategoryActionPerformed
        openSmallDialog("Thêm nhóm hàng", "Nhóm hàng:", cbCategory);
    }//GEN-LAST:event_btnAddCategoryActionPerformed

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UpdateGoodsJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            UpdateGoodsJDialog dialog = new UpdateGoodsJDialog(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnImage;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cbCategory;
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
    private javax.swing.JTextField textDesc;
    private javax.swing.JTextField textId;
    private javax.swing.JTextField textInitQuantity;
    private javax.swing.JTextField textMiniQuantity;
    private javax.swing.JTextField textName;
    private javax.swing.JTextField textPrice;
    // End of variables declaration//GEN-END:variables

    Timer timer;
    boolean isEditable = true;
    JComboBox<String> comboBox;
    String imagePath = Auth.goods != null ? Auth.goods.getImageUrl() : "";

    ScheduledFuture<?> scheduledFuture;
    ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);

    void init() {
        // <--- Setup common --->
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.WHITE);

        // Setup text fields 
        JTextField[] textFields = {textId, textName, textPrice, textInitQuantity, textMiniQuantity, textDesc};
        for (JTextField textField : textFields) {
            TextFieldUtils.addFocusBorder(textField, new Color(51, 204, 0), new Color(220, 220, 220));
        }

        // Setup UI
        textName.requestFocus();
        textId.setEditable(isEditable);
        TextFieldUtils.addPlaceholder(textId, "Mã tự động");
        ComboBoxUtils.setComboboxStyle(cbCategory);
        Common.createButtonGroup(radioOn, radioOff);
        ImageUtils.setImageButtonIcon("src/restaurant/img/background.jpg", btnImage);

        // <--- Setup main --->
        addDocumentListener(textPrice);
        addDataToComboBoxs();
        setModel();
    }

    void addDocumentListener(JTextField textField) {
        textField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateFormattedText(textField);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateFormattedText(textField);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateFormattedText(textField);
            }
        });
    }

    public void updateFormattedText(JTextField textFieldPrice) {
        if (scheduledFuture != null && !scheduledFuture.isDone()) {
            scheduledFuture.cancel(false);
        }

        scheduledFuture = scheduledExecutorService.schedule(() -> {
            SwingUtilities.invokeLater(() -> {
                String price = textFieldPrice.getText().trim();
                String removeCommas = removeCommasFromNumber(price);
                String addCommas = addCommasToNumber(removeCommas);
                textFieldPrice.setText(addCommas);
            });
        }, 500, TimeUnit.MILLISECONDS);
    }

    public void setIsEditable(boolean editable) {
        this.isEditable = editable;
        textId.setEditable(editable);
    }

    boolean validateInput(String name, String numberSeatsText, String area) {
        if (name.trim().isEmpty() || numberSeatsText.trim().isEmpty() || area.trim().isEmpty()) {
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

    DiningTableEntity getModel() {
        String id = getRealText(textId, "Mã tự động");
        String name = textName.getText();
        String price = textPrice.getText();
        cbCategory.setSelectedItem(product.getCategory());
        String numberSeats = textNumberSeats.getText();

        if (!validateInput(name, numberSeats, area)) {
            return null;
        }

        try {
            DiningTableEntity model = new DiningTableEntity();
            model.setTableID(tableId);
            model.setName(name);
            model.setLocation(area);
            model.setCapacity(Integer.parseInt(numberSeats));
            model.setStatus("Còn trống");
            model.setDescription(textDesc.getText());
            model.setActivity(radioOn.isSelected() ? "Đang hoạt động" : "Ngưng hoạt động");
            return model;
        } catch (NumberFormatException e) {
            System.err.println("Lỗi: " + e.getMessage());
            return null;
        }
    }

    void setModel() {
        GoodsEntity goods = Auth.goods;
        if (goods == null) {
            return;
        }

        textId.setText(goods.getGoodsID());
        textName.setText(goods.getGoodsName());
        cbCategory.setSelectedItem(goods.getCategory());
        textPrice.setText(String.valueOf(goods.getUnitPrice()));

        String activiti = goods.getStatus();
        radioOn.setSelected(activiti.equals("Đang hoạt động"));
        radioOff.setSelected(activiti.equals("Ngưng hoạt động"));
    }

    void insert() {
        DiningTableEntity model = getModel();

        if (new DiningTableDAO().isIdDuplicated(model.getTableID())) {
            Dialog.warning(this, "Mã ID đã tồn tại. Vui lòng chọn mã ID khác!");
            return;
        }

        if (new DiningTableDAO().isDuplicateName(model.getName())) {
            Dialog.alert(this, "Tên bàn đã tồn tại. Vui lòng sửa tên khác!");
            return;
        }

        try {
            new DiningTableDAO().insert(model);
            Dialog.success(this, "Thêm mới thành công!");
            dispose();
        } catch (Exception e) {
            Dialog.alert(this, "Thêm mới thất bại!");
            e.printStackTrace();
        }
    }

    void update() {
        DiningTableEntity model = getModel();

        if (!new DiningTableDAO().isIdDuplicated(model.getTableID())) {
            Dialog.alert(this, "Mã ID đã chưa tồn tại. Vui lòng nhập lại mã ID!");
            return;
        }

        try {
            new DiningTableDAO().update(model);
            Dialog.alert(this, "Cập nhật thành công!");
            dispose();
        } catch (Exception e) {
            Dialog.alert(this, "Cập nhật thất bại!");
        }
    }

    void delete() {
        String id = textId.getText();
        if (!new DiningTableDAO().isIdDuplicated(id)) {
            Dialog.alert(this, "Mã ID không tồn tại. Vui lòng nhập lại mã ID!");
            return;
        }

        try {
            new DiningTableDAO().delete(id);
            Dialog.alert(this, "Xóa thành công!");
            dispose();
        } catch (Exception e) {
            Dialog.alert(this, "Xóa thất bại!");
        }
    }
    // end --->

}
