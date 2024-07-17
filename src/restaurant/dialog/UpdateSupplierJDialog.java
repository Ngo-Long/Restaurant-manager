package restaurant.dialog;

import java.awt.Color;
import javax.swing.JTextField;
import restaurant.utils.Common;
import restaurant.utils.Dialog;
import restaurant.dao.SupplierDAO;
import restaurant.utils.XTextField;
import restaurant.entity.Supplier;

public final class UpdateSupplierJDialog extends javax.swing.JDialog {

    public UpdateSupplierJDialog(java.awt.Frame parent, boolean modal) {
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
        textID = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        textPhone = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        textName = new javax.swing.JTextField();
        textDesc = new javax.swing.JTextField();
        textEmail = new javax.swing.JTextField();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        radioOn = new javax.swing.JRadioButton();
        radioOff = new javax.swing.JRadioButton();
        textAddress = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();

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
        setTitle("Cập nhật phòng/bàn");
        setBackground(new java.awt.Color(255, 255, 255));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Mã NCC:");

        textID.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textID.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        textID.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(51, 204, 0)));
        textID.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        textID.setMargin(new java.awt.Insets(2, 60, 2, 6));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Tên NCC:");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Số ĐT:");

        textPhone.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textPhone.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        textPhone.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        textPhone.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        textPhone.setMargin(new java.awt.Insets(2, 60, 2, 6));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setText("Email:");

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

        textEmail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textEmail.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        textEmail.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        textEmail.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        textEmail.setMargin(new java.awt.Insets(2, 60, 2, 6));

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
        radioOn.setText("Đang hợp tác");

        radioOff.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        radioOff.setText("Ngừng hợp tác");

        textAddress.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textAddress.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        textAddress.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        textAddress.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        textAddress.setMargin(new java.awt.Insets(2, 60, 2, 6));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setText("Địa chỉ:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel11)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(textID, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
                            .addComponent(textName, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
                            .addComponent(textPhone, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
                            .addComponent(textEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
                            .addComponent(textDesc, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(radioOn)
                                .addGap(18, 18, 18)
                                .addComponent(radioOff))
                            .addComponent(textAddress, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(textID, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(textName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(textPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(textEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(radioOn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(radioOff, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
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
            java.util.logging.Logger.getLogger(UpdateSupplierJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            UpdateSupplierJDialog dialog = new UpdateSupplierJDialog(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JRadioButton radioOff;
    private javax.swing.JRadioButton radioOn;
    private javax.swing.JTextField textAddress;
    private javax.swing.JTextField textDesc;
    private javax.swing.JTextField textEmail;
    private javax.swing.JTextField textID;
    private javax.swing.JTextField textName;
    private javax.swing.JTextField textPhone;
    // End of variables declaration//GEN-END:variables

    final String PLACEHOLDER_ID = "Mã tự động";

    void init() {
        // Set system
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.WHITE);

        // Setup UI
        textName.requestFocus();
        Common.createButtonGroup(radioOn, radioOff);
        XTextField.addPlaceholder(textID, PLACEHOLDER_ID);

        // Setup text fields 
        JTextField[] textFields = {textID, textName, textPhone, textEmail, textPhone, textAddress};
        for (JTextField textField : textFields) {
            XTextField.addFocusBorder(textField, new Color(51, 204, 0), new Color(220, 220, 220));
        }

        // Click button CRUD  
        btnAdd.addActionListener(e -> insert());
        btnUpdate.addActionListener(e -> update());
        btnDelete.addActionListener(e -> delete());
    }

    boolean validateInput(String name, String phoneText) {
        if (name.trim().isEmpty() || phoneText.trim().isEmpty()) {
            Dialog.warning(this, "Vui lòng nhập đầy đủ thông tin!");
            return false;
        }

        try {
            int numberSeats = Integer.parseInt(phoneText);
            if (numberSeats <= 0) {
                Dialog.warning(this, "Số điện thoại không hợp lệ!");
                return false;
            }
        } catch (NumberFormatException e) {
            Dialog.warning(this, "Số chỗ ngồi phải là một số hợp lệ!");
            return false;
        }

        return true;
    }

    Supplier getModel() {
        String id = XTextField.getRealText(textID, PLACEHOLDER_ID);
        String name = textName.getText();
        String phoneText = textPhone.getText();

        if (!validateInput(name, phoneText)) {
            return null;
        }

        try {
            Supplier model = new Supplier();
            model.setSupplierID(id);
            model.setSupplierName(name);
            model.setPhone(phoneText);
            model.setEmail(textEmail.getText());
            model.setAddress(textAddress.getText());
            model.setDescription(textDesc.getText());
            model.setStatus(radioOn.isSelected() ? "Đang hợp tác" : "Ngừng hợp tác");
            return model;
        } catch (NumberFormatException e) {
            System.err.println("Lỗi: " + e.getMessage());
            return null;
        }
    }

    public void setModel(Supplier data) {
        if (data == null) {
            return;
        }

        textID.setText(data.getSupplierID());
        textName.setText(data.getSupplierName());
        textPhone.setText(data.getPhone());
        textEmail.setText(data.getEmail());
        textAddress.setText(data.getAddress());
        textDesc.setText(data.getDescription());

        String activiti = data.getStatus();
        radioOn.setSelected(activiti.equals("Đang hợp tác"));
        radioOff.setSelected(activiti.equals("Ngừng hợp tác"));
    }

    void insert() {
        Supplier model = getModel();
        if (model == null) {
            return;
        }

        if (new SupplierDAO().isIdExists(model.getSupplierID())) {
            Dialog.warning(this, "Mã ID đã tồn tại. Vui lòng chọn mã ID khác!");
            return;
        }

        try {
            new SupplierDAO().insert(model);
            Dialog.success(this, "Thêm mới thành công!");
            dispose();
        } catch (Exception e) {
            Dialog.alert(this, "Thêm mới thất bại!");
            e.printStackTrace();
        }
    }

    void update() {
        Supplier model = getModel();
        if (model == null) {
            return;
        }

        if (!new SupplierDAO().isIdExists(model.getSupplierID())) {
            Dialog.alert(this, "Mã ID đã chưa tồn tại. Vui lòng nhập lại mã ID!");
            return;
        }

        try {
            new SupplierDAO().update(model);
            Dialog.alert(this, "Cập nhật thành công!");
            dispose();
        } catch (Exception e) {
            Dialog.alert(this, "Cập nhật thất bại!");
        }
    }

    void delete() {
        String id = textID.getText();
        if (!new SupplierDAO().isIdExists(id)) {
            Dialog.alert(this, "Mã ID không tồn tại. Vui lòng nhập lại mã ID!");
            return;
        }

        try {
            new SupplierDAO().delete(id);
            Dialog.alert(this, "Xóa thành công!");
            dispose();
        } catch (Exception e) {
            Dialog.alert(this, "Xóa thất bại!");
        }
    }
    // end --->

}
