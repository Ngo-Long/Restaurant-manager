package restaurant.dialog;

import java.awt.Color;
import java.awt.Frame;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;
import restaurant.dao.GoodsDAO;
import restaurant.entity.Goods;
import restaurant.main.ManagementMode;
import restaurant.management.CreateReceiptFrm;
import restaurant.utils.Dialog;
import restaurant.utils.XComboBox;
import static restaurant.utils.XComboBox.insertPlaceholder;
import static restaurant.utils.XComboBox.loadDataToComboBox;

public final class SmallComboBoxJDialog extends javax.swing.JDialog {

    public SmallComboBoxJDialog(Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.init();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelMain = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        textNote = new javax.swing.JTextField();
        btnSubmit = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        comboBoxMain = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Thêm khu vực");
        setResizable(false);

        labelMain.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelMain.setText("Khu vực:");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel15.setText("Ghi chú:");

        textNote.setEditable(false);
        textNote.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textNote.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        textNote.setText("Tự động xóa khi không sản phẩm nào dùng ");
        textNote.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        textNote.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        textNote.setEnabled(false);
        textNote.setFocusable(false);
        textNote.setMargin(new java.awt.Insets(2, 60, 2, 6));

        btnSubmit.setBackground(new java.awt.Color(0, 153, 0));
        btnSubmit.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnSubmit.setForeground(new java.awt.Color(255, 255, 255));
        btnSubmit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/icon/check.png"))); // NOI18N
        btnSubmit.setText("Thực hiện");
        btnSubmit.setToolTipText("Enter");
        btnSubmit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnCancel.setBackground(new java.awt.Color(102, 102, 102));
        btnCancel.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnCancel.setForeground(new java.awt.Color(255, 255, 255));
        btnCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/icon/cancel.png"))); // NOI18N
        btnCancel.setText("Bỏ qua");
        btnCancel.setToolTipText("Esc");
        btnCancel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        comboBoxMain.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(btnSubmit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancel))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(labelMain, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(textNote, javax.swing.GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE)
                            .addComponent(comboBoxMain, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labelMain, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(comboBoxMain, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textNote, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
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
            java.util.logging.Logger.getLogger(SmallComboBoxJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            SmallComboBoxJDialog dialog = new SmallComboBoxJDialog(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JComboBox<String> comboBoxMain;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel labelMain;
    private javax.swing.JTextField textNote;
    // End of variables declaration//GEN-END:variables

    private List<Goods> selectedGoods;

    void init() {
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.WHITE);

        // add data to combobox
        XComboBox.setComboboxStyle(comboBoxMain);
        loadDataToComboBox(comboBoxMain, new GoodsDAO().getAll(), Goods::getCategory);
        insertPlaceholder(comboBoxMain, "--Lựa chọn--");

        // Handle click button
        btnSubmit.addActionListener(e -> submit());
        btnCancel.addActionListener(e -> dispose());

        // Common KeyListener for ESC and ENTER keys
        comboBoxMain.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    System.exit(0);
                } else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    btnSubmit.doClick();
                }
            }
        });
    }

    void submit() {
        String category = comboBoxMain.getSelectedItem().toString();
        if (category.equals("--Lựa chọn--")) {
            Dialog.alert(this, "Vui lòng chọn phân loại!");
            comboBoxMain.requestFocus();
            return;
        }

        // get data list
        selectedGoods = new GoodsDAO().findByCategory(category);
        dispose();
    }

    public List<Goods> getSelectedGoods() {
        return selectedGoods;
    }
}
