package restaurant.dialog;

import restaurant.dao.GoodsDAO;
import restaurant.entity.GoodsEntity;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ChoseIngredient extends javax.swing.JFrame {

    private int currentIndex = 0;
    private List<GoodsEntity> ingredientList;
    private List<String> addedIngredients = new ArrayList<>();

    public ChoseIngredient(Map<String, String> userInfo) {
        initComponents();

        loadDataIntoTable();
        addTableMouseListener();
        addSaveTableMouseListener();
    }

    private void loadDataIntoTable() {
        ingredientList = new GoodsDAO().getAll();

        DefaultTableModel model = (DefaultTableModel) tableIngredientList.getModel();
        model.setRowCount(0);

        // Load data into the table
        for (GoodsEntity ingredientItem : ingredientList) {
            Object[] rowData = {
//                ingredientItem.getIngredientID(),
//                ingredientItem.getIngredientName(),
                ingredientItem.getUnitPrice()
            };

            model.addRow(rowData);
        }
    }

    private void addTableMouseListener() {
        tableIngredientList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int selectedRow = tableIngredientList.getSelectedRow();
                if (selectedRow != -1) {
                    // Cập nhật currentIndex khi chọn dòng mới trong bảng
                    currentIndex = selectedRow;
                    displayIngredientDetails(selectedRow);
                }
            }
        });
    }

    private void addSaveTableMouseListener() {
        tableSaveIngredientList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int selectedRow = tableSaveIngredientList.getSelectedRow();
                if (selectedRow != -1) {
                    // Cập nhật chi tiết từ hàng đã chọn
                    displaySaveTableIngredientDetails(selectedRow);
                }
            }
        });
    }

    private void displaySaveTableIngredientDetails(int selectedRow) {
        if (selectedRow >= 0 && selectedRow < tableSaveIngredientList.getRowCount()) {
            String ingredientID = tableSaveIngredientList.getValueAt(selectedRow, 0).toString();
            String ingredientName = tableSaveIngredientList.getValueAt(selectedRow, 1).toString();
            String quantity = tableSaveIngredientList.getValueAt(selectedRow, 2).toString();

            // Hiển thị chi tiết vào textIngredientID, textIngredientName, và textQuantity
            textIngredientID.setText(ingredientID);
            textIngredientName.setText(ingredientName);
            textQuantity.setText(quantity);
        }
    }

    private void displayIngredientDetails(int selectedRow) {
        if (selectedRow >= 0 && selectedRow < ingredientList.size()) {
            GoodsEntity selectedIngredient = ingredientList.get(selectedRow);

//            textIngredientID.setText(selectedIngredient.getIngredientID());
//            textIngredientName.setText(selectedIngredient.getIngredientName());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        textSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        text1 = new javax.swing.JLabel();
        text2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnMinus = new javax.swing.JButton();
        textQuantity = new javax.swing.JTextField();
        btnPlus = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();
        btnSubmit = new javax.swing.JButton();
        textIngredientID = new javax.swing.JLabel();
        textIngredientName = new javax.swing.JLabel();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableIngredientList = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableSaveIngredientList = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Chọn nguyên liệu");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        jLabel4.setText("Danh sách nguyên liệu");

        textSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textSearchActionPerformed(evt);
            }
        });

        btnSearch.setBackground(new java.awt.Color(0, 51, 102));
        btnSearch.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSearch.setForeground(new java.awt.Color(255, 255, 255));
        btnSearch.setText("Tìm kiếm");
        btnSearch.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 51, 102));
        jPanel1.setForeground(new java.awt.Color(0, 51, 102));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 6, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 535, Short.MAX_VALUE)
        );

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        jLabel5.setText("Chọn nguyên liệu");

        text1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        text1.setText("Mã nguyên liệu:");

        text2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        text2.setText("Tên nguyên liệu:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Số lượng:");

        btnMinus.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnMinus.setText("-");
        btnMinus.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMinus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMinusActionPerformed(evt);
            }
        });

        textQuantity.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        textQuantity.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textQuantity.setText("1");
        textQuantity.setAutoscrolls(false);
        textQuantity.setBorder(null);
        textQuantity.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        textQuantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textQuantityActionPerformed(evt);
            }
        });

        btnPlus.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnPlus.setText("+");
        btnPlus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlusActionPerformed(evt);
            }
        });

        btnSave.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnSave.setText("Lưu");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnRemove.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnRemove.setText("Xóa");
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });

        btnSubmit.setBackground(new java.awt.Color(0, 51, 102));
        btnSubmit.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnSubmit.setForeground(new java.awt.Color(255, 255, 255));
        btnSubmit.setText("Xác nhận");
        btnSubmit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });

        textIngredientID.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        textIngredientID.setText(" ");

        textIngredientName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        textIngredientName.setText(" ");

        tableIngredientList.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tableIngredientList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Mã nguyên liệu", "Tên nguyên liệu", "Đơn giá"
            }
        ));
        tableIngredientList.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane2.setViewportView(tableIngredientList);
        if (tableIngredientList.getColumnModel().getColumnCount() > 0) {
            tableIngredientList.getColumnModel().getColumn(0).setPreferredWidth(20);
            tableIngredientList.getColumnModel().getColumn(2).setPreferredWidth(20);
        }

        jTabbedPane3.addTab("Danh sách", jScrollPane2);

        tableSaveIngredientList.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tableSaveIngredientList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Mã", "Tên", "Số lượng"
            }
        ));
        jScrollPane1.setViewportView(tableSaveIngredientList);
        if (tableSaveIngredientList.getColumnModel().getColumnCount() > 0) {
            tableSaveIngredientList.getColumnModel().getColumn(0).setPreferredWidth(15);
            tableSaveIngredientList.getColumnModel().getColumn(2).setPreferredWidth(15);
        }

        jTabbedPane3.addTab("Đã chọn", jScrollPane1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSearch)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTabbedPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnRemove, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(text2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textIngredientName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnMinus, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPlus, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(text1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textIngredientID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(btnSubmit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTabbedPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(text1)
                            .addComponent(textIngredientID))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(text2)
                            .addComponent(textIngredientName))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(textQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnMinus, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnPlus, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                            .addComponent(btnRemove, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(280, 280, 280)
                        .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27))))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMinusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMinusActionPerformed
        int quantity = Integer.parseInt(textQuantity.getText());

        if (quantity > 0) {
            quantity--;
            textQuantity.setText(Integer.toString(quantity));
        }
    }//GEN-LAST:event_btnMinusActionPerformed

    private void btnPlusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlusActionPerformed
        int quantity = Integer.parseInt(textQuantity.getText());

        quantity++;
        textQuantity.setText(Integer.toString(quantity));
    }//GEN-LAST:event_btnPlusActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // Get values from textIngredientID, textIngredientName, and textQuantity
        String ingredientID = textIngredientID.getText();
        String ingredientName = textIngredientName.getText();
        int quantity = Integer.parseInt(textQuantity.getText());

        try {
            DefaultTableModel saveTableModel = (DefaultTableModel) tableSaveIngredientList.getModel();

            // Check if the ingredient is already added
            int existingRowIndex = findIngredientRowIndex(ingredientID);
            if (existingRowIndex != -1) {
                // Mã nguyên liệu đã tồn tại trong bảng
                if (quantity == 0) {
                    // Số lượng là 0, xóa khỏi bảng
                    saveTableModel.removeRow(existingRowIndex);
                    JOptionPane.showMessageDialog(this, "Đã xóa nguyên liệu.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    // Số lượng khác 0, cập nhật số lượng từ textQuantity
                    saveTableModel.setValueAt(quantity, existingRowIndex, 2);
                    JOptionPane.showMessageDialog(this, "Đã cập nhật số lượng.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                // Mã nguyên liệu chưa tồn tại trong bảng
                if (quantity != 0) {
                    // Thêm vào đầu bảng nếu số lượng khác 0
                    Object[] rowData = {ingredientID, ingredientName, quantity};
                    saveTableModel.insertRow(0, rowData);
                }
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Bị lỗi. Vui lòng nhập số đúng!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private int findIngredientRowIndex(String ingredientID) {
        DefaultTableModel saveTableModel = (DefaultTableModel) tableSaveIngredientList.getModel();
        int rowCount = saveTableModel.getRowCount();

        for (int i = 0; i < rowCount; i++) {
            Object value = saveTableModel.getValueAt(i, 0);
            if (value != null && ingredientID.equals(value.toString())) {
                return i;  // Trả về chỉ số dòng nếu mã nguyên liệu đã tồn tại trong bảng
            }
        }

        return -1;  // Trả về -1 nếu mã nguyên liệu chưa tồn tại trong bảng
    }

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        String ingredientID = textIngredientID.getText();

        DefaultTableModel saveTableModel = (DefaultTableModel) tableSaveIngredientList.getModel();
        int existingRowIndex = findIngredientRowIndex(ingredientID);

        if (existingRowIndex != -1) {
            // Mã nguyên liệu đã tồn tại trong bảng, xóa khỏi bảng
            saveTableModel.removeRow(existingRowIndex);
            JOptionPane.showMessageDialog(this, "Đã xóa nguyên liệu.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Nguyên liệu không tồn tại trong bảng.", "Thông báo", JOptionPane.WARNING_MESSAGE);
        }

        // Remove value
        textIngredientID.setText("");
        textIngredientName.setText("");
        textQuantity.setText("0");
    }//GEN-LAST:event_btnRemoveActionPerformed

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        // Tạo Map để lưu thông tin
        Map<String, Integer> ingredientListMap = new HashMap<>();

        // Duyệt qua từng hàng trong tableSaveIngredientList
        DefaultTableModel saveTableModel = (DefaultTableModel) tableSaveIngredientList.getModel();
        int rowCount = saveTableModel.getRowCount();
        for (int i = 0; i < rowCount; i++) {
            // Kiểm tra giá trị tại cột 0
            Object ingredientIDObject = saveTableModel.getValueAt(i, 0);
            if (ingredientIDObject != null) {
                String ingredientID = ingredientIDObject.toString();

                // Kiểm tra giá trị tại cột 2
                Object quantityObject = saveTableModel.getValueAt(i, 2);
                if (quantityObject != null) {
                    int quantity = Integer.parseInt(quantityObject.toString());

                    // Thêm vào Map
                    ingredientListMap.put(ingredientID, quantity);
                }
            }
        }

        // In thông tin từ Map
        for (Map.Entry<String, Integer> entry : ingredientListMap.entrySet()) {
            System.out.println("Mã nguyên liệu: " + entry.getKey() + ", Số lượng: " + entry.getValue());
        }
    }//GEN-LAST:event_btnSubmitActionPerformed

    private void textSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textSearchActionPerformed
        String keyword = textSearch.getText().trim();
        String selectedPhanLoaiTrangThai = "Trạng thái";
    }//GEN-LAST:event_textSearchActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        String keyword = textSearch.getText().trim();
        String selectedPhanLoaiTrangThai = "Trạng thái";
    }//GEN-LAST:event_btnSearchActionPerformed

    private void textQuantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textQuantityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textQuantityActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChoseIngredient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            Map<String, String> userInfo = new HashMap<>();
            userInfo.put("hoTen", "YourName");
            userInfo.put("chucVu", "YourPosition");

            ChoseIngredient monAn = new ChoseIngredient(userInfo);
            monAn.setLocationRelativeTo(null);
            monAn.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMinus;
    private javax.swing.JButton btnPlus;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTable tableIngredientList;
    private javax.swing.JTable tableSaveIngredientList;
    private javax.swing.JLabel text1;
    private javax.swing.JLabel text2;
    private javax.swing.JLabel textIngredientID;
    private javax.swing.JLabel textIngredientName;
    private javax.swing.JTextField textQuantity;
    private javax.swing.JTextField textSearch;
    // End of variables declaration//GEN-END:variables
}
