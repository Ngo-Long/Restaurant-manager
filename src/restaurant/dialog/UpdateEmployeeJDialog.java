package restaurant.dialog;

import java.util.List;
import java.awt.Color;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTextField;
import restaurant.dao.EmployeeDAO;

import restaurant.utils.Common;
import restaurant.utils.Dialog;
import restaurant.utils.XImage;
import restaurant.utils.XComboBox;
import restaurant.utils.XTextField;

import restaurant.dao.ProductDAO;
import restaurant.entity.Employee;
import static restaurant.utils.Common.openSmallDialog;
import static restaurant.utils.XImage.setImageButtonIcon;
import static restaurant.utils.XComboBox.insertPlaceholder;
import static restaurant.utils.XComboBox.loadDataToComboBox;
import static restaurant.utils.XImage.chooseImageFromDirectory;

public final class UpdateEmployeeJDialog extends JDialog {

    public UpdateEmployeeJDialog(java.awt.Frame parent, boolean modal) {
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
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        textName = new javax.swing.JTextField();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnImage = new javax.swing.JButton();
        cbPosition = new javax.swing.JComboBox<>();
        btnAddPosition = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        radioOn = new javax.swing.JRadioButton();
        radioOff = new javax.swing.JRadioButton();
        jLabel14 = new javax.swing.JLabel();
        textEmail = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        textDesc = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        radioMale = new javax.swing.JRadioButton();
        radioFemale = new javax.swing.JRadioButton();
        radioGender3rd = new javax.swing.JRadioButton();
        jLabel9 = new javax.swing.JLabel();
        textBirthDay = new com.toedter.calendar.JDateChooser();
        jLabel15 = new javax.swing.JLabel();
        textPhoneNum = new javax.swing.JTextField();

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
        setTitle("Cập nhật nhân viên");
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Mã nhân viên:");

        textID.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textID.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        textID.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(51, 204, 0)));
        textID.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        textID.setMargin(new java.awt.Insets(2, 60, 2, 6));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Họ tên:");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setText("Chức danh:");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setText("Mô tả:");

        btnAdd.setBackground(new java.awt.Color(0, 153, 0));
        btnAdd.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd.setText("THÊM");
        btnAdd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAdd.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        textName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textName.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        textName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        textName.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        textName.setMargin(new java.awt.Insets(2, 60, 2, 6));

        btnUpdate.setBackground(new java.awt.Color(0, 0, 255));
        btnUpdate.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnUpdate.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdate.setText("SỬA");
        btnUpdate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUpdate.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        btnDelete.setBackground(new java.awt.Color(255, 0, 0));
        btnDelete.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete.setText("XÓA");
        btnDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDelete.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        btnImage.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnImage.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        cbPosition.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbPosition.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbPosition.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnAddPosition.setBackground(new java.awt.Color(51, 153, 0));
        btnAddPosition.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/icon/plusWhile.png"))); // NOI18N
        btnAddPosition.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setText("Trạng thái:");

        radioOn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        radioOn.setSelected(true);
        radioOn.setText("Đang làm");

        radioOff.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        radioOff.setText("Nghỉ việc");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel14.setText("Email:");

        textEmail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textEmail.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        textEmail.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        textEmail.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        textEmail.setMargin(new java.awt.Insets(2, 60, 2, 6));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Ảnh nhân viên");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        textDesc.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Giới tính:");

        radioMale.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        radioMale.setSelected(true);
        radioMale.setText("Nam");

        radioFemale.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        radioFemale.setText("Nữ");

        radioGender3rd.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        radioGender3rd.setText("Khác");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Ngày sinh:");

        textBirthDay.setBackground(new java.awt.Color(255, 255, 255));
        textBirthDay.setToolTipText("Ngày");
        textBirthDay.setDateFormatString("dd/MM/yyyy");
        textBirthDay.setFocusable(false);
        textBirthDay.setFont(new java.awt.Font("Be Vietnam Pro", 0, 13)); // NOI18N

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel15.setText("Số điện thoại:");

        textPhoneNum.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textPhoneNum.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        textPhoneNum.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        textPhoneNum.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        textPhoneNum.setMargin(new java.awt.Insets(2, 60, 2, 6));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnImage, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(25, 25, 25)
                                .addComponent(cbPosition, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(textName, javax.swing.GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
                                            .addComponent(textID)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel11)
                                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(39, 39, 39)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addComponent(textEmail, javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                        .addComponent(radioMale)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(radioFemale)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(radioGender3rd))
                                                    .addComponent(textBirthDay, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE)))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(textDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel12)
                                        .addGap(29, 29, 29)
                                        .addComponent(radioOn)
                                        .addGap(36, 36, 36)
                                        .addComponent(radioOff))
                                    .addComponent(jLabel15))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnAddPosition)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30)
                                .addComponent(textPhoneNum, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(0, 33, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textID, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(radioMale, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(radioFemale, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(radioGender3rd, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                            .addComponent(textBirthDay, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnImage, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textPhoneNum, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAddPosition, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbPosition, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(radioOn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(radioOff, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30)
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
            java.util.logging.Logger.getLogger(UpdateEmployeeJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            UpdateEmployeeJDialog dialog = new UpdateEmployeeJDialog(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnAddPosition;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnImage;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cbPosition;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JRadioButton radioFemale;
    private javax.swing.JRadioButton radioGender3rd;
    private javax.swing.JRadioButton radioMale;
    private javax.swing.JRadioButton radioOff;
    private javax.swing.JRadioButton radioOn;
    private com.toedter.calendar.JDateChooser textBirthDay;
    private javax.swing.JTextField textDesc;
    private javax.swing.JTextField textEmail;
    private javax.swing.JTextField textID;
    private javax.swing.JTextField textName;
    private javax.swing.JTextField textPhoneNum;
    // End of variables declaration//GEN-END:variables

    String imagePath;
    final String PLACEHOLDER_COMBOBOX = "--Lựa chọn--";

    void init() {
        // <--- Setup common --->
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.WHITE);

        // set text fields 
        JTextField[] textFields = {textID, textName, textEmail, textPhoneNum};
        for (JTextField textField : textFields) {
            XTextField.addFocusBorder(textField, new Color(51, 204, 0), new Color(220, 220, 220));
        }

        // set date     
        textBirthDay.setDate(new Date());
        XComboBox.setComboboxStyle(cbPosition);
        XImage.setImageButtonIcon("src/restaurant/img/background.jpg", btnImage);

        // setup combobox
        Common.createButtonGroup(radioOn, radioOff);
        Common.createButtonGroup(radioMale, radioFemale, radioGender3rd);

        // <--- Setup main --->
        // hanle click button lisr
        hanleClickButotns(btnAdd, btnUpdate, btnDelete, btnImage, btnAddPosition);

        // setup combobox
        List<Employee> dataList = new EmployeeDAO().getAll();
        loadDataToComboBox(cbPosition, dataList, Employee::getPosition);
        insertPlaceholder(cbPosition, PLACEHOLDER_COMBOBOX);
    }

    void hanleClickButotns(JButton btnAdd, JButton btnUpdate, JButton btnDelete,
            JButton btnImage, JButton btnAddPosition) {

        // click button CRUD  
        btnAdd.addActionListener(e -> insert());
        btnUpdate.addActionListener(e -> update());
        btnDelete.addActionListener(e -> delete());

        // get imagePath from directory
        btnImage.addActionListener(e -> {
            imagePath = chooseImageFromDirectory(btnImage);
        });

        // add more comboxbox
        btnAddPosition.addActionListener(e -> {
            openSmallDialog("Thêm chức vụ", "Chức vụ:", cbPosition);
        });

    }

    Employee getModel() {
        String id = textID.getText().toUpperCase();
        String name = textName.getText();
        String email = textEmail.getText();
        String phoneNum = textPhoneNum.getText();
        String position = cbPosition.getSelectedItem().toString();
        String desc = textDesc.getText();
        String status = radioOn.isSelected() ? "Đang làm" : "Nghỉ việc";
        String gender = radioMale.isSelected() ? "Nam" : radioFemale.isSelected() ? "Nữ" : "Khác";

        if (!validateInput(id, name, position)) {
            return null;
        }

        try {
            Employee model = new Employee();
            model.setEmployeeID(id);
            model.setFullName(name);
            model.setPhone(phoneNum);
            model.setEmail(email);
            model.setGender(gender);
            model.setDateOfBirth(textBirthDay.getDate());
            model.setPosition(position);
            model.setDescription(desc);
            model.setUrlImage(imagePath);
            model.setStatus(status);
            return model;
        } catch (NumberFormatException e) {
            Dialog.error(this, "Lỗi!");
            return null;
        }
    }

    boolean validateInput(String id, String name, String position) {
        if (id.trim().isEmpty()) {
            Dialog.warning(this, "Mã nhân viên không để trống!");
            return false;
        }

        if (name.trim().isEmpty() || position.trim().isEmpty()) {
            Dialog.warning(this, "Vui lòng nhập thêm tên và chức vụ!");
            return false;
        }

        if (position.equals(PLACEHOLDER_COMBOBOX)) {
            Dialog.warning(this, "Vui lòng lựa chọn khu vực!");
            return false;
        }

        return true;
    }

    public void setModel(Employee dataEmployee) {
        if (dataEmployee == null) {
            textID.requestFocus();
            btnUpdate.setEnabled(false);
            btnDelete.setEnabled(false);
            return;
        }

        textName.requestFocus();
        textID.setEnabled(false);
        btnAdd.setEnabled(false);

        // set info
        textID.setText(dataEmployee.getEmployeeID());
        textName.setText(dataEmployee.getFullName());
        textBirthDay.setDate(dataEmployee.getDateOfBirth());
        textEmail.setText(dataEmployee.getEmail());
        textPhoneNum.setText(dataEmployee.getPhone());
        textDesc.setText(dataEmployee.getDescription());
        cbPosition.setSelectedItem(dataEmployee.getPosition());

        // Set radio
        String activiti = dataEmployee.getStatus();
        radioOn.setSelected(activiti.equals("Đang làm"));
        radioOff.setSelected(activiti.equals("Nghỉ việc"));

        String gender = dataEmployee.getGender();
        radioMale.setSelected(gender.equals("Nam"));
        radioFemale.setSelected(activiti.equals("Nữ"));
        radioGender3rd.setSelected(activiti.equals("Khác"));

        // Set image
        setImageButtonIcon(dataEmployee.getUrlImage(), btnImage);
    }

    void insert() {
        Employee model = getModel();
        if (model == null) {
            return;
        }

        if (new ProductDAO().isIDExists(model.getEmployeeID())) {
            Dialog.warning(this, "Mã nhân viên đã tồn tại!");
            return;
        }

        try {
            new EmployeeDAO().insert(model);
            Dialog.success(this, "Thêm mới thành công!");
            dispose();
        } catch (Exception e) {
            Dialog.error(this, "Thêm mới thất bại!");
            e.printStackTrace();
        }
    }

    void update() {
        if (textID.getText().equals("")) {
            Dialog.warning(this, "Mã nhân viên không tồn tại!");
            return;
        }

        Employee model = getModel();
        if (model == null) {
            return;
        }

        try {
            new EmployeeDAO().update(model);
            Dialog.success(this, "Cập nhật thành công!");
            dispose();
        } catch (Exception e) {
            Dialog.error(this, "Cập nhật thất bại!");
        }
    }

    void delete() {
        if (textID.getText().equals("")) {
            Dialog.warning(this, "Mã nhân viên không tồn tại!");
            return;
        }

        if (textID.getText().trim().equals("NV000")) {
            Dialog.warning(this, "Tài khoản chính không xóa được!");
            return;
        }

        boolean isResult = Dialog.confirm(this, "Xác nhận xóa!");
        if (!isResult) {
            return;
        }

        try {
            new EmployeeDAO().delete(textID.getText());
            Dialog.success(this, "Xóa thành công!");
            dispose();
        } catch (Exception e) {
            Dialog.error(this, "Xóa thất bại!");
        }
    }
}
