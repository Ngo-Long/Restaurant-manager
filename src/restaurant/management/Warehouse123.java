package restaurant.management;

import java.util.List;
import java.text.DecimalFormat;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import restaurant.utils.Dialog;
import restaurant.dao.IngrediantDAO;
import restaurant.entity.IngrediantEntity;

public class Warehouse123 extends javax.swing.JFrame {

    private int currentIndex = 0;
    private List<IngrediantEntity> ingrediantList;

    public Warehouse123() {
        initComponents();

        loadDataIntoTable();
        updateCountIngrediant();
        addTableMouseListener();
    }

    IngrediantEntity getModel() {
        String id = textIngredientID.getText();
        String name = textIngredientName.getText();
        String unitPriceText = textUnitPrice.getText();
        String initialQuantityText = textInitialQuantity.getText();
        String minimumQuantityText = textMinimumQuantity.getText();

        try {
            // Kiểm tra giá trị trước khi chuyển đổi
            if (id.isEmpty() || name.isEmpty() || unitPriceText.isEmpty() || initialQuantityText.isEmpty() || minimumQuantityText.isEmpty()) {
                throw new NumberFormatException("Vui lòng nhập đầy đủ thông tin.");
            }

            int unitPrice = Integer.parseInt(unitPriceText);
            int initialQuantity = Integer.parseInt(initialQuantityText);
            int minimumQuantity = Integer.parseInt(minimumQuantityText);

            // Kiểm tra giá trị số không âm
            if (initialQuantity < 0 || minimumQuantity < 0 || unitPrice < 0) {
                throw new NumberFormatException("Số lượng nhập và số lượng tối thiểu phải là số không âm!");
            }

            // Kiểm tra trạng thái
            String status;
            if (initialQuantity == 0) {
                status = "Hết hàng";
            } else if (initialQuantity < minimumQuantity) {
                status = "Thiếu hàng";
            } else {
                status = "Còn hàng";
            }

            IngrediantEntity model = new IngrediantEntity();
            model.setIngredientID(id);
            model.setIngredientName(name);
            model.setUnitPrice(unitPrice);
            model.setInitialQuantity(initialQuantity);
            model.setMinimumQuantity(minimumQuantity);
            model.setStatus(status);

            return model;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    private void loadDataIntoTable() {
        ingrediantList = new IngrediantDAO().getAll();

        DefaultTableModel model = (DefaultTableModel) tableIngrediant.getModel();
        model.setRowCount(0);

        // Load data into the table
        for (IngrediantEntity ingrediantItem : ingrediantList) {
            Object[] rowData = {
                ingrediantItem.getIngredientID(),
                ingrediantItem.getIngredientName(),
                ingrediantItem.getInitialQuantity(),
                ingrediantItem.getMinimumQuantity(),
                ingrediantItem.getUnitPrice(),
                ingrediantItem.getStatus()
            };

            model.addRow(rowData);
        }
    }

    private void updateCountIngrediant() {
        int rowCount = tableIngrediant.getRowCount();
        labelCountIngrediant.setText("Tổng nguyên liệu: " + rowCount);
    }

    private void addTableMouseListener() {
        tableIngrediant.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int selectedRow = tableIngrediant.getSelectedRow();
                if (selectedRow != -1) {
                    // Cập nhật currentIndex khi chọn dòng mới trong bảng
                    currentIndex = selectedRow;
                    displayIngrediantDetails(selectedRow);
                }
            }
        });
    }

    private void displayIngrediantDetails(int selectedRow) {
        if (selectedRow >= 0 && selectedRow < ingrediantList.size()) {
            IngrediantEntity selectedIngrediant = ingrediantList.get(selectedRow);

            textIngredientID.setText(selectedIngrediant.getIngredientID());
            textIngredientName.setText(selectedIngrediant.getIngredientName());
            textInitialQuantity.setText(String.valueOf(selectedIngrediant.getInitialQuantity()));
            textMinimumQuantity.setText(String.valueOf(selectedIngrediant.getMinimumQuantity()));
            DecimalFormat decimalFormat = new DecimalFormat("#.##");
            textUnitPrice.setText(decimalFormat.format(selectedIngrediant.getUnitPrice()));

            // Kiểm tra các điều kiện và cập nhật trạng thái
            int initialQuantity = selectedIngrediant.getInitialQuantity();
            int minimumQuantity = selectedIngrediant.getMinimumQuantity();

            if (initialQuantity == 0) {
                comboBoxStatus.setSelectedItem("Hết hàng");
            } else if (initialQuantity < minimumQuantity) {
                comboBoxStatus.setSelectedItem("Thiếu hàng");
            } else {
                comboBoxStatus.setSelectedItem("Còn hàng");
            }
        }

        // Btn
        btnFirst.setEnabled(selectedRow != 0);
        btnPre.setEnabled(selectedRow != 0);
        btnNext.setEnabled(selectedRow != ingrediantList.size() - 1);
        btnLast.setEnabled(selectedRow != ingrediantList.size() - 1);
    }



    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        btnReset = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPanel9 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        textMa1 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        textHoTen1 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        textNgaySinh1 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        textCmnd1 = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        textEmail1 = new javax.swing.JTextField();
        jPanel10 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        textIngredientID = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        textIngredientName = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        textUnitPrice = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        textInitialQuantity = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        textMinimumQuantity = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        comboBoxStatus = new javax.swing.JComboBox<>();
        btnTimKiem = new javax.swing.JButton();
        textSearch = new javax.swing.JTextField();
        btnPhanLoai = new javax.swing.JButton();
        CbPhanLoaiTrangThai = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableIngrediant = new javax.swing.JTable();
        btnLast = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        btnPre = new javax.swing.JButton();
        btnFirst = new javax.swing.JButton();
        labelCountIngrediant = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản lí nhân viên");

        jPanel2.setBackground(new java.awt.Color(243, 243, 243));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        jLabel5.setText("Kho hàng nguyên liệu");

        jPanel8.setBackground(new java.awt.Color(0, 51, 102));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        btnReset.setBackground(new java.awt.Color(0, 51, 102));
        btnReset.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnReset.setForeground(new java.awt.Color(255, 255, 255));
        btnReset.setText("Hủy");
        btnReset.setCursor(new java.awt.Cursor(java.awt.Cursor.MOVE_CURSOR));
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        btnAdd.setBackground(new java.awt.Color(0, 51, 102));
        btnAdd.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd.setText("Thêm");
        btnAdd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnRemove.setBackground(new java.awt.Color(0, 51, 102));
        btnRemove.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnRemove.setForeground(new java.awt.Color(255, 255, 255));
        btnRemove.setText("Xóa");
        btnRemove.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });

        btnUpdate.setBackground(new java.awt.Color(0, 51, 102));
        btnUpdate.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnUpdate.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdate.setText("Sửa");
        btnUpdate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        jTabbedPane3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Mã phiếu:");

        textMa1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textMa1ActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Tên phiếu:");

        textHoTen1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textHoTen1ActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setText("NCC:");

        textNgaySinh1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textNgaySinh1ActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setText("Ngày tạo:");

        textCmnd1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textCmnd1ActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel18.setText("Ghi chú:");

        textEmail1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textEmail1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addGap(6, 6, 6)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(textEmail1, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                    .addComponent(textHoTen1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textNgaySinh1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textCmnd1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textMa1, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(textMa1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textHoTen1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textNgaySinh1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textCmnd1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textEmail1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(283, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("Tạo phiếu nhập", jPanel9);

        jPanel10.setForeground(new java.awt.Color(242, 242, 242));
        jPanel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Mã NL:");

        textIngredientID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textIngredientIDActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Tên NL:");

        textIngredientName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textIngredientNameActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Đơn giá:");

        textUnitPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textUnitPriceActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setText("SL nhập:");

        textInitialQuantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textInitialQuantityActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel17.setText("SL tối thiểu:");

        textMinimumQuantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textMinimumQuantityActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel19.setText("Trạng thái:");

        comboBoxStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Còn hàng", "Thiếu hàng", "Hết hàng" }));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(comboBoxStatus, 0, 235, Short.MAX_VALUE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel17))
                        .addGap(5, 5, 5)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(textIngredientID, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                            .addComponent(textIngredientName, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textUnitPrice, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textInitialQuantity, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textMinimumQuantity, javax.swing.GroupLayout.Alignment.LEADING))))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(textIngredientID, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textIngredientName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textUnitPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textInitialQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textMinimumQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBoxStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(240, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("Tạo nguyên liệu", jPanel10);

        btnTimKiem.setBackground(new java.awt.Color(0, 51, 102));
        btnTimKiem.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnTimKiem.setForeground(new java.awt.Color(255, 255, 255));
        btnTimKiem.setText("Tìm kiếm");
        btnTimKiem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        textSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textSearchActionPerformed(evt);
            }
        });

        btnPhanLoai.setBackground(new java.awt.Color(0, 51, 102));
        btnPhanLoai.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnPhanLoai.setForeground(new java.awt.Color(255, 255, 255));
        btnPhanLoai.setText("Phân loại");
        btnPhanLoai.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPhanLoai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPhanLoaiActionPerformed(evt);
            }
        });

        CbPhanLoaiTrangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Trạng thái", "Còn hàng", "Thiếu hàng", "Hết hàng" }));
        CbPhanLoaiTrangThai.setCursor(new java.awt.Cursor(java.awt.Cursor.MOVE_CURSOR));
        CbPhanLoaiTrangThai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CbPhanLoaiTrangThaiActionPerformed(evt);
            }
        });

        tableIngrediant.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã", "Tên nguyên liệu", "SL ban đầu", "SL tối thiểu", "Đơn giá", "Trạng thái"
            }
        ));
        tableIngrediant.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane1.setViewportView(tableIngrediant);
        if (tableIngrediant.getColumnModel().getColumnCount() > 0) {
            tableIngrediant.getColumnModel().getColumn(0).setPreferredWidth(50);
        }

        btnLast.setText(">|");
        btnLast.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLastActionPerformed(evt);
            }
        });

        btnNext.setText(">>");
        btnNext.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        btnPre.setText("<<");
        btnPre.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreActionPerformed(evt);
            }
        });

        btnFirst.setText("|<");
        btnFirst.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFirstActionPerformed(evt);
            }
        });

        labelCountIngrediant.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelCountIngrediant.setText("Tổng nguyên liệu:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btnTimKiem)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textSearch)
                                .addGap(18, 18, 18)
                                .addComponent(btnPhanLoai)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CbPhanLoaiTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btnFirst, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnPre, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnLast, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(labelCountIngrediant, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 662, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane3)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)))
                .addGap(0, 0, 0))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jTabbedPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 535, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(textSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnPhanLoai, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(CbPhanLoaiTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 439, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnPre, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnLast, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnFirst, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelCountIngrediant, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(60, 60, 60))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(211, 211, 211)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void textIngredientIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textIngredientIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textIngredientIDActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        IngrediantEntity model = getModel();

        if (!new IngrediantDAO().isIdExists(model.getIngredientID())) {
            Dialog.alert(this, "Mã ID đã chưa tồn tại. Vui lòng nhập lại mã ID!");
            return;
        }

        try {
            new IngrediantDAO().update(model);
            loadDataIntoTable();
            Dialog.alert(this, "Cập nhật thành công!");
        } catch (Exception e) {
            Dialog.alert(this, "Cập nhật thất bại!");
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        String id = textIngredientID.getText();
        if (!new IngrediantDAO().isIdExists(id)) {
            Dialog.alert(this, "Mã ID đã chưa tồn tại. Vui lòng nhập lại mã ID!");
            return;
        }

        try {
            new IngrediantDAO().delete(id);
            loadDataIntoTable();
            Dialog.alert(this, "Xóa thành công!");
        } catch (Exception e) {
            Dialog.alert(this, "Xóa thất bại!");
        }
    }//GEN-LAST:event_btnRemoveActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        IngrediantEntity model = getModel();

        // Kiểm tra xem mã ID có bị trùng không
        if (new IngrediantDAO().isIdExists(model.getIngredientID())) {
            Dialog.alert(this, "Mã ID đã tồn tại. Vui lòng chọn mã ID khác!");
            return;
        }

        try {
            new IngrediantDAO().insert(model);
            loadDataIntoTable();
            Dialog.alert(this, "Thêm mới thành công!");
        } catch (Exception e) {
            Dialog.alert(this, "Thêm mới thất bại!");
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        textIngredientID.setText("");
        textIngredientName.setText("");
        textInitialQuantity.setText("");
        textMinimumQuantity.setText("");
        textUnitPrice.setText("");
        comboBoxStatus.setSelectedIndex(0);
        tableIngrediant.clearSelection();
        currentIndex = 0;
    }//GEN-LAST:event_btnResetActionPerformed

    private void textMinimumQuantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textMinimumQuantityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textMinimumQuantityActionPerformed

    private void textInitialQuantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textInitialQuantityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textInitialQuantityActionPerformed

    private void textUnitPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textUnitPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textUnitPriceActionPerformed

    private void textIngredientNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textIngredientNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textIngredientNameActionPerformed

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        String keyword = textSearch.getText().trim();
        String selectedPhanLoaiTrangThai = (String) CbPhanLoaiTrangThai.getSelectedItem();
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void textSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textSearchActionPerformed
        String keyword = textSearch.getText().trim();
        String selectedPhanLoaiTrangThai = (String) CbPhanLoaiTrangThai.getSelectedItem();
    }//GEN-LAST:event_textSearchActionPerformed

    private void btnPhanLoaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPhanLoaiActionPerformed
        String keyword = textSearch.getText().trim();
        String selectedPhanLoaiTrangThai = (String) CbPhanLoaiTrangThai.getSelectedItem();
    }//GEN-LAST:event_btnPhanLoaiActionPerformed

    private void CbPhanLoaiTrangThaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CbPhanLoaiTrangThaiActionPerformed
        String keyword = textSearch.getText().trim();
        String selectedPhanLoaiTrangThai = (String) CbPhanLoaiTrangThai.getSelectedItem();
    }//GEN-LAST:event_CbPhanLoaiTrangThaiActionPerformed

    private void btnLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLastActionPerformed
        currentIndex = ingrediantList.size() - 1;
        displayIngrediantDetails(currentIndex);
        tableIngrediant.setRowSelectionInterval(currentIndex, currentIndex);
    }//GEN-LAST:event_btnLastActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        currentIndex++;
        if (currentIndex >= ingrediantList.size()) {
            currentIndex = ingrediantList.size() - 1;
        }

        displayIngrediantDetails(currentIndex);
        tableIngrediant.setRowSelectionInterval(currentIndex, currentIndex);
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnPreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreActionPerformed
        currentIndex--;

        if (currentIndex < 0) {
            return;
        }

        if (currentIndex >= tableIngrediant.getRowCount()) {
            currentIndex = tableIngrediant.getRowCount() - 1;
        }

        displayIngrediantDetails(currentIndex);
        tableIngrediant.setRowSelectionInterval(currentIndex, currentIndex);
    }//GEN-LAST:event_btnPreActionPerformed

    private void btnFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirstActionPerformed
        currentIndex = 0;
        displayIngrediantDetails(currentIndex > 0 ? currentIndex - 1 : 0);
        tableIngrediant.setRowSelectionInterval(currentIndex, currentIndex);
    }//GEN-LAST:event_btnFirstActionPerformed

    private void textMa1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textMa1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textMa1ActionPerformed

    private void textHoTen1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textHoTen1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textHoTen1ActionPerformed

    private void textNgaySinh1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textNgaySinh1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textNgaySinh1ActionPerformed

    private void textCmnd1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textCmnd1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textCmnd1ActionPerformed

    private void textEmail1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textEmail1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textEmail1ActionPerformed

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Warehouse123.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            new Warehouse123().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CbPhanLoaiTrangThai;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnFirst;
    private javax.swing.JButton btnLast;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPhanLoai;
    private javax.swing.JButton btnPre;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> comboBoxStatus;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JLabel labelCountIngrediant;
    private javax.swing.JTable tableIngrediant;
    private javax.swing.JTextField textCmnd1;
    private javax.swing.JTextField textEmail1;
    private javax.swing.JTextField textHoTen1;
    private javax.swing.JTextField textIngredientID;
    private javax.swing.JTextField textIngredientName;
    private javax.swing.JTextField textInitialQuantity;
    private javax.swing.JTextField textMa1;
    private javax.swing.JTextField textMinimumQuantity;
    private javax.swing.JTextField textNgaySinh1;
    private javax.swing.JTextField textSearch;
    private javax.swing.JTextField textUnitPrice;
    // End of variables declaration//GEN-END:variables

}
