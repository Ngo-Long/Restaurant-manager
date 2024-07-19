package restaurant.dialog;

import java.awt.Color;
import java.util.List;
import javax.swing.JTextField;
import restaurant.utils.Common;
import restaurant.utils.Dialog;
import restaurant.utils.XComboBox;
import restaurant.utils.XTextField;
import restaurant.dao.DiningTableDAO;
import restaurant.entity.DiningTable;
import static restaurant.utils.XTextField.getRealText;
import static restaurant.utils.Common.openSmallDialog;
import static restaurant.utils.XComboBox.insertPlaceholder;
import static restaurant.utils.XComboBox.loadDataToComboBox;

public final class UpdateTableJDialog extends javax.swing.JDialog {

    public UpdateTableJDialog(java.awt.Frame parent, boolean modal) {
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
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        textName = new javax.swing.JTextField();
        textDesc = new javax.swing.JTextField();
        textNumberSeats = new javax.swing.JTextField();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        radioOn = new javax.swing.JRadioButton();
        radioOff = new javax.swing.JRadioButton();
        cbLocation = new javax.swing.JComboBox<>();
        btnAddLocation = new javax.swing.JButton();

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
        setResizable(false);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Mã bàn:");

        textID.setEditable(false);
        textID.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textID.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        textID.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(51, 204, 0)));
        textID.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        textID.setMargin(new java.awt.Insets(2, 60, 2, 6));
        textID.setRequestFocusEnabled(false);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Tên bàn:");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Khu vực:");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setText("Số ghế:");

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

        textNumberSeats.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textNumberSeats.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        textNumberSeats.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        textNumberSeats.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        textNumberSeats.setMargin(new java.awt.Insets(2, 60, 2, 6));

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

        cbLocation.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbLocation.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbLocation.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnAddLocation.setBackground(new java.awt.Color(51, 153, 0));
        btnAddLocation.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/icon/plusWhile.png"))); // NOI18N
        btnAddLocation.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel11)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(textID)
                            .addComponent(textName)
                            .addComponent(textNumberSeats)
                            .addComponent(textDesc)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(radioOn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(radioOff))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cbLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAddLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(textID, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel7))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(textName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textNumberSeats, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnAddLocation, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbLocation))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(radioOff, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(radioOn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
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
            java.util.logging.Logger.getLogger(UpdateTableJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            UpdateTableJDialog dialog = new UpdateTableJDialog(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnAddLocation;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cbLocation;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
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
    private javax.swing.JTextField textID;
    private javax.swing.JTextField textName;
    private javax.swing.JTextField textNumberSeats;
    // End of variables declaration//GEN-END:variables

    String saveName;
    final String PLACEHOLDER_ID = "Mã tự động";
    final String PLACEHOLDER_COMBOBOX = "--Lựa chọn--";

    void init() {
        // Set system
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.WHITE);

        // Setup UI
        textName.requestFocus();
        XTextField.addPlaceholder(textID, PLACEHOLDER_ID);
        XComboBox.setComboboxStyle(cbLocation);
        Common.createButtonGroup(radioOn, radioOff);

        // Setup text fields 
        JTextField[] textFields = {textID, textName, textNumberSeats};
        for (JTextField textField : textFields) {
            XTextField.addFocusBorder(textField, new Color(51, 204, 0), new Color(220, 220, 220));
        }

        // <--- Setup main --->
        // setup combobox
        List<DiningTable> dataList = new DiningTableDAO().getAll();
        loadDataToComboBox(cbLocation, dataList, DiningTable::getLocation);
        insertPlaceholder(cbLocation, PLACEHOLDER_COMBOBOX);

        // add more comboxbox
        btnAddLocation.addActionListener(e -> {
            openSmallDialog("Thêm vị trí", "Nhóm vị trí:", cbLocation);
        });

        // click button CRUD  
        btnAdd.addActionListener(e -> insert());
        btnUpdate.addActionListener(e -> update());
        btnDelete.addActionListener(e -> delete());
    }

    boolean validateInput(String name, String numberSeatsText, String area) {
        if (name.trim().isEmpty() || numberSeatsText.trim().isEmpty() || area.trim().isEmpty()) {
            Dialog.warning(this, "Vui lòng nhập đầy đủ thông tin!");
            return false;
        }

        if (area.equals(PLACEHOLDER_COMBOBOX)) {
            Dialog.warning(this, "Vui lòng chọn khu vực!");
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

    DiningTable getModel() {
        String tableId = XTextField.getRealText(textID, PLACEHOLDER_ID);
        String name = textName.getText();
        String area = cbLocation.getSelectedItem().toString();
        String numberSeats = textNumberSeats.getText();

        if (!validateInput(name, numberSeats, area)) {
            return null;
        }

        try {
            DiningTable model = new DiningTable();
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

    public void setModel(DiningTable dataTable) {
        if (dataTable == null) {
            return;
        }

        saveName = dataTable.getName();
        textName.setText(dataTable.getName());

        textID.setText(dataTable.getTableID());
        cbLocation.setSelectedItem(dataTable.getLocation());
        textNumberSeats.setText(String.valueOf(dataTable.getCapacity()));
        textDesc.setText(dataTable.getDescription());

        String activiti = dataTable.getActivity();
        radioOn.setSelected(activiti.equals("Đang hoạt động"));
        radioOff.setSelected(activiti.equals("Ngưng hoạt động"));
    }

    void insert() {
        DiningTable model = getModel();
        if (model == null) {
            return;
        }

        if (new DiningTableDAO().isIDExists(model.getTableID())) {
            Dialog.warning(this, "Bàn ăn đã tồn tại!");
            return;
        }

        if (new DiningTableDAO().isNameExists(model.getName())) {
            Dialog.warning(this, "Tên bàn đã tồn tại. Vui lòng nhập tên khác!");
            return;
        }

        try {
            new DiningTableDAO().insert(model);
            Dialog.success(this, "Thêm mới thành công!");
            dispose();
        } catch (Exception e) {
            Dialog.error(this, "Thêm mới thất bại!");
            e.printStackTrace();
        }
    }

    void update() {
        String id = getRealText(textID, PLACEHOLDER_ID);
        if (id.equals("")) {
            Dialog.warning(this, "Bàn ăn không tồn tại!");
            return;
        }

        DiningTable model = getModel();
        if (model == null) {
            return;
        }

        if (!textName.getText().equals(saveName)
                && new DiningTableDAO().isNameExists(model.getName())) {
            Dialog.warning(this, "Tên bàn đã tồn tại. Vui lòng nhập tên khác!");
            return;
        }

        try {
            new DiningTableDAO().update(model);
            Dialog.success(this, "Cập nhật thành công!");
            dispose();
        } catch (Exception e) {
            Dialog.error(this, "Cập nhật thất bại!");
        }
    }

    void delete() {
        String id = getRealText(textID, PLACEHOLDER_ID);
        if (id.equals("")) {
            Dialog.warning(this, "Bàn ăn không tồn tại!");
            return;
        }

        boolean isResult = Dialog.confirm(this, "Xác nhận xóa!");
        if (!isResult) {
            return;
        }

        try {
            new DiningTableDAO().delete(id);
            Dialog.success(this, "Xóa thành công!");
            dispose();
        } catch (Exception e) {
            Dialog.error(this, "Xóa thất bại!");
        }
    }
    // end --->

}
