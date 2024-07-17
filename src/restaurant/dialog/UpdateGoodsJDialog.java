package restaurant.dialog;

import java.awt.Color;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledExecutorService;

import javax.swing.Timer;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import restaurant.utils.Auth;
import restaurant.utils.Common;
import restaurant.utils.Dialog;
import restaurant.dao.GoodsDAO;
import restaurant.utils.XImage;
import restaurant.entity.Goods;
import restaurant.utils.XComboBox;
import static restaurant.utils.Common.openSmallDialog;
import restaurant.utils.XTextField;
import static restaurant.utils.XTextField.addCommasToNumber;
import static restaurant.utils.XTextField.getRealText;
import static restaurant.utils.XTextField.removeCommasFromNumber;
import static restaurant.utils.XImage.chooseImageFromDirectory;
import static restaurant.utils.XImage.setImageButtonIcon;

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
        textUnit = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();

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

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Tên hàng hóa:");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Đơn giá:");

        textPrice.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textPrice.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        textPrice.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        textPrice.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        textPrice.setMargin(new java.awt.Insets(2, 60, 2, 6));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setText("Phân loại:");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setText("Trạng thái:");

        btnAdd.setBackground(new java.awt.Color(0, 153, 0));
        btnAdd.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd.setText("THÊM");
        btnAdd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        textName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textName.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        textName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        textName.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        textName.setMargin(new java.awt.Insets(2, 60, 2, 6));

        textDesc.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textDesc.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        textDesc.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        textDesc.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        textDesc.setMargin(new java.awt.Insets(2, 60, 2, 6));

        btnUpdate.setBackground(new java.awt.Color(0, 0, 255));
        btnUpdate.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnUpdate.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdate.setText("SỬA");
        btnUpdate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnDelete.setBackground(new java.awt.Color(255, 0, 0));
        btnDelete.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete.setText("XÓA");
        btnDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setText("Mô tả:");

        radioOn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        radioOn.setSelected(true);
        radioOn.setText("Đang hoạt động");

        radioOff.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        radioOff.setText("Ngưng hoạt động");

        textInitQuantity.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textInitQuantity.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        textInitQuantity.setText("0");
        textInitQuantity.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        textInitQuantity.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        textInitQuantity.setMargin(new java.awt.Insets(2, 60, 2, 6));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setText("SL hiện tại:");

        textMiniQuantity.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textMiniQuantity.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        textMiniQuantity.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        textMiniQuantity.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        textMiniQuantity.setMargin(new java.awt.Insets(2, 60, 2, 6));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel14.setText("SL tối thiểu:");

        btnImage.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnImage.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

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

        textUnit.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textUnit.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        textUnit.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        textUnit.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        textUnit.setMargin(new java.awt.Insets(2, 60, 2, 6));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Đơn vị:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(btnImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel11)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                                .addComponent(btnAddCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(textUnit, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)))
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textUnit, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                            .addComponent(textInitQuantity, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)))
                    .addComponent(btnImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(textMiniQuantity, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnAddCategory, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(radioOn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(radioOff, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
    private javax.swing.JLabel jLabel9;
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
    private javax.swing.JTextField textUnit;
    // End of variables declaration//GEN-END:variables

    Timer timer;
    boolean isEditable = true;
    JComboBox<String> comboBox;
    final String PLACEHOLDER_ID = "Mã tự động";
    final String PLACEHOLDER_STATUS = "--Lựa chọn--";
    String imagePath = Auth.goods != null ? Auth.goods.getImageURL() : "";

    ScheduledFuture<?> scheduledFuture;
    ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);

    void init() {
        // <--- Setup common --->
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.WHITE);

        // Setup text fields 
        JTextField[] textFields = {textId, textName, textPrice, textUnit, textInitQuantity, textMiniQuantity};
        for (JTextField textField : textFields) {
            XTextField.addFocusBorder(textField, new Color(51, 204, 0), new Color(220, 220, 220));
        }

        // Setup UI
        textName.requestFocus();
        textId.setEditable(isEditable);
        XComboBox.setComboboxStyle(cbCategory);
        Common.createButtonGroup(radioOn, radioOff);
        XTextField.addPlaceholder(textId, PLACEHOLDER_ID);
        XImage.setImageButtonIcon("src/restaurant/img/background.jpg", btnImage);

        // <--- Setup main --->
        // attach event formatted price
        XTextField.addPriceDocumentListener(textPrice);

        // add data to combobox
        List<Goods> dataList = new GoodsDAO().getAll();
        XComboBox.loadDataToComboBox(cbCategory,
                dataList,
                Goods::getCategory
        );
        XComboBox.insertPlaceholder(cbCategory, PLACEHOLDER_STATUS);

        // add more comboxbox
        btnAddCategory.addActionListener(e -> {
            openSmallDialog("Thêm nhóm hàng", "Nhóm hàng:", cbCategory);
        });

        // get imagePath from directory
        btnImage.addActionListener(e -> {
            imagePath = chooseImageFromDirectory(null, btnImage);
        });

        // click button CRUD  
        btnAdd.addActionListener(e -> insert());
        btnUpdate.addActionListener(e -> update());
        btnDelete.addActionListener(e -> delete());
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

    boolean validateInput(String name, String priceText, String unit, String numMiniText, String category) {
        if (name.trim().isEmpty() || priceText.trim().isEmpty() || unit.trim().isEmpty()
                || numMiniText.trim().isEmpty() || category.isEmpty()) {
            Dialog.warning(this, "Vui lòng nhập đầy đủ thông tin!");
            return false;
        }

        if (category.equals("--Lựa chọn--")) {
            Dialog.warning(this, "Vui lòng lựa chọn khu vực!");
            return false;
        }

        try {
            int numMini = Integer.parseInt(numMiniText);
            if (numMini <= 0) {
                Dialog.warning(this, "Số lớn hơn 0!");
                return false;
            }
        } catch (NumberFormatException e) {
            Dialog.warning(this, "Là một số hợp lệ!");
            return false;
        }

        return true;
    }

    Goods getModel() {
        String id = getRealText(textId, PLACEHOLDER_ID);
        String name = textName.getText();
        String priceText = textPrice.getText();
        String unit = textUnit.getText();
        String numMiniText = textMiniQuantity.getText();
        String numInitText = textInitQuantity.getText();
        String category = cbCategory.getSelectedItem().toString();

        if (!validateInput(name, priceText, unit, numMiniText, category)) {
            return null;
        }

        try {
            Goods model = new Goods();
            model.setGoodsID(id);
            model.setGoodsName(name);
            model.setUnitPrice(Integer.parseInt(removeCommasFromNumber(priceText)));
            model.setUnit(unit);
            model.setCategory(category);
            model.setInitialQuantity(Integer.parseInt(numInitText));
            model.setMinimumQuantity(Integer.parseInt(numMiniText));
            model.setStatus("Còn hàng");
            model.setNote(textDesc.getText());
            model.setActivity(radioOn.isSelected() ? "Đang hoạt động" : "Ngưng hoạt động");
            model.setImageURL(imagePath.equals("") ? "src/restaurant/img/background.jpg" : imagePath);
            return model;
        } catch (NumberFormatException e) {
            System.err.println("Lỗi: " + e.getMessage());
            return null;
        }
    }

    void setModel(Goods goods) {
        if (goods == null) {
            return;
        }

        textId.setText(goods.getGoodsID());
        textName.setText(goods.getGoodsName());
        cbCategory.setSelectedItem(goods.getCategory());
        textPrice.setText(String.valueOf(goods.getUnitPrice()));
        textUnit.setText(goods.getUnit());
        textInitQuantity.setText(String.valueOf(goods.getInitialQuantity()));
        textMiniQuantity.setText(String.valueOf(goods.getMinimumQuantity()));
        textDesc.setText(goods.getNote());

        String activiti = goods.getStatus();
        radioOn.setSelected(activiti.equals("Đang hoạt động"));
        radioOff.setSelected(activiti.equals("Ngưng hoạt động"));

        // Set combobox
        cbCategory.setSelectedItem(goods.getCategory());

        // Set image
        setImageButtonIcon(imagePath, btnImage);
    }

    void insert() {
        Goods model = getModel();

        if (new GoodsDAO().isIdExists(model.getGoodsID())) {
            Dialog.warning(this, "Mã ID đã tồn tại. Vui lòng chọn mã ID khác!");
            return;
        }

        if (new GoodsDAO().isNameExists(model.getGoodsName())) {
            Dialog.alert(this, "Tên đã tồn tại. Vui lòng sửa tên khác!");
            return;
        }

        try {
            new GoodsDAO().insert(model);
            Dialog.success(this, "Thêm mới thành công!");
            dispose();
        } catch (Exception e) {
            Dialog.alert(this, "Thêm mới thất bại!");
            e.printStackTrace();
        }
    }

    void update() {
        Goods model = getModel();

        if (!new GoodsDAO().isIdExists(model.getGoodsID())) {
            Dialog.alert(this, "Mã ID đã chưa tồn tại. Vui lòng nhập lại mã ID!");
            return;
        }

        if (new GoodsDAO().isNameExists(model.getGoodsName())) {
            Dialog.alert(this, "Tên đã tồn tại. Vui lòng sửa tên khác!");
            return;
        }

        try {
            new GoodsDAO().update(model);
            Dialog.alert(this, "Cập nhật thành công!");
            dispose();
        } catch (Exception e) {
            Dialog.alert(this, "Cập nhật thất bại!");
        }
    }

    void delete() {
        String id = textId.getText();
        if (!new GoodsDAO().isIdExists(id)) {
            Dialog.alert(this, "Mã ID không tồn tại. Vui lòng nhập lại mã ID!");
            return;
        }

        try {
            new GoodsDAO().delete(id);
            Dialog.alert(this, "Xóa thành công!");
            dispose();
        } catch (Exception e) {
            Dialog.alert(this, "Xóa thất bại!");
        }
    }
    // end --->

}
