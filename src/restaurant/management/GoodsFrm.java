package restaurant.management;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.WindowAdapter;

import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledExecutorService;

import restaurant.dao.GoodsDAO;
import restaurant.entity.Goods;
import restaurant.utils.XComboBox;
import restaurant.utils.XTextField;
import restaurant.table.TableCustom;
import restaurant.main.ManagementMode;
import restaurant.utils.TableNavigator;
import restaurant.dialog.UpdateGoodsJDialog;
import static restaurant.utils.Common.customizeTable;
import static restaurant.utils.Common.createButtonGroup;
import static restaurant.utils.XComboBox.insertPlaceholder;
import static restaurant.utils.XTextField.addCommasToNumber;
import static restaurant.utils.XComboBox.loadDataToComboBox;
import static restaurant.utils.XRunnable.addComponentListeners;
import static restaurant.utils.XRunnable.addTextFieldListeners;

public final class GoodsFrm extends javax.swing.JPanel {

    public GoodsFrm(ManagementMode managementMode) {
        initComponents();
        this.init();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        panelBody = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cbCategory = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        btnExport = new javax.swing.JButton();
        btnImport = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableGoods = new javax.swing.JTable();
        btnLast = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        btnPrev = new javax.swing.JButton();
        btnFirst = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        textSearch = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        radioOn = new javax.swing.JRadioButton();
        radioOff = new javax.swing.JRadioButton();
        radioAll = new javax.swing.JRadioButton();

        panelBody.setToolTipText("");

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Phân loại");

        cbCategory.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(cbCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(cbCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(926, 0));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Hàng hóa");

        btnExport.setBackground(new java.awt.Color(0, 153, 0));
        btnExport.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnExport.setForeground(new java.awt.Color(255, 255, 255));
        btnExport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/icon/export-file.png"))); // NOI18N
        btnExport.setText("Export");
        btnExport.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnImport.setBackground(new java.awt.Color(0, 153, 0));
        btnImport.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnImport.setForeground(new java.awt.Color(255, 255, 255));
        btnImport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/icon/file-import.png"))); // NOI18N
        btnImport.setText("Import");
        btnImport.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnAdd.setBackground(new java.awt.Color(0, 153, 0));
        btnAdd.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/icon/plusWhile.png"))); // NOI18N
        btnAdd.setText("Thêm hàng hóa");
        btnAdd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        tableGoods.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tableGoods.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã HH", "Tên hàng hóa", "Đơn giá", "Đơn vị", "Phân loại", "SL ban đầu", "SL tối thiểu", "Trạng thái"
            }
        ));
        tableGoods.setGridColor(new java.awt.Color(255, 255, 255));
        tableGoods.setRowHeight(40);
        jScrollPane1.setViewportView(tableGoods);
        if (tableGoods.getColumnModel().getColumnCount() > 0) {
            tableGoods.getColumnModel().getColumn(0).setPreferredWidth(20);
            tableGoods.getColumnModel().getColumn(1).setPreferredWidth(120);
        }

        btnLast.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnLast.setText(">|");
        btnLast.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnNext.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnNext.setText(">>");
        btnNext.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnPrev.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnPrev.setText("<<");
        btnPrev.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnFirst.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnFirst.setText("|<");
        btnFirst.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("Hiển thị 1 - 10 trên tổng số 10 bàn");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnFirst, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPrev, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLast, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 524, Short.MAX_VALUE)
                        .addComponent(btnAdd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnImport, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnExport, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnExport, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnImport, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 489, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLast)
                    .addComponent(btnNext)
                    .addComponent(btnPrev)
                    .addComponent(btnFirst)
                    .addComponent(jLabel6))
                .addGap(10, 10, 10))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Tìm kiếm");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(textSearch))
                .addGap(12, 12, 12))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(textSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Trạng thái");

        radioOn.setText("Còn hàng");

        radioOff.setText("Hết hàng");

        radioAll.setSelected(true);
        radioAll.setText("Tất cả");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(radioAll)
                    .addComponent(radioOff)
                    .addComponent(radioOn)
                    .addComponent(jLabel4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(radioOn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(radioOff)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(radioAll)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelBodyLayout = new javax.swing.GroupLayout(panelBody);
        panelBody.setLayout(panelBodyLayout);
        panelBodyLayout.setHorizontalGroup(
            panelBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBodyLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(panelBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1022, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        panelBodyLayout.setVerticalGroup(
            panelBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBodyLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(panelBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBodyLayout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(207, 207, 207))
                    .addGroup(panelBodyLayout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 584, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBody, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(panelBody, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnExport;
    private javax.swing.JButton btnFirst;
    private javax.swing.JButton btnImport;
    private javax.swing.JButton btnLast;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrev;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> cbCategory;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelBody;
    private javax.swing.JRadioButton radioAll;
    private javax.swing.JRadioButton radioOff;
    private javax.swing.JRadioButton radioOn;
    private javax.swing.JTable tableGoods;
    private javax.swing.JTextField textSearch;
    // End of variables declaration//GEN-END:variables

    final int DEBOUNCE_DELAY_LOAD = 300;
    final String PLACEHOLDER_STATUS = "--Tất cả--";
    final String PLACEHOLDER_SEARCH = "Tìm theo mã hoặc tên";

    Goods dataGoods;
    GoodsDAO dao = new GoodsDAO();
    ScheduledFuture<?> scheduledFuture;
    ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);

    void init() {
        // <--- Fuction common from file common --->
        createButtonGroup(radioOn, radioOff, radioAll);
        XComboBox.setComboboxStyle(cbCategory);

        // edit field text
        XTextField.addPlaceholder(textSearch, PLACEHOLDER_SEARCH);
        XTextField.addFocusBorder(textSearch, new Color(51, 204, 0), new Color(204, 204, 204));

        // edit table
        TableCustom.apply(jScrollPane1, TableCustom.TableType.MULTI_LINE);
        customizeTable(tableGoods, new int[]{}, 30);

        // <--- Setup main --->
        // navigator table 
        TableNavigator navigator = new TableNavigator(tableGoods);
        btnFirst.addActionListener(e -> navigator.first());
        btnNext.addActionListener(e -> navigator.next());
        btnPrev.addActionListener(e -> navigator.prev());
        btnLast.addActionListener(e -> navigator.last());

        // Handle click button add show dialog add goods
        btnAdd.addActionListener(e -> {
            openUpdateDialog("Thêm hàng hóa", null);
        });

        // handle click row table show dialog update goods
        attachRowClickListener(
                tableGoods,
                () -> openUpdateDialog("Cập nhật hàng hóa", dataGoods)
        );

        // add data to combobox
        loadDataToComboBox(cbCategory, dao.getAll(), Goods::getCategory);
        insertPlaceholder(cbCategory, PLACEHOLDER_STATUS);

        // load data list by search and classify when change
        addTextFieldListeners(textSearch, this::loadDataFillTable);
        addComponentListeners(
                this::loadDataFillTable,
                cbCategory, radioOn, radioOff, radioAll
        );

        // load data and fill table
        this.loadDataFillTable();
    }

    // <--- Handle click row show dialog
    void attachRowClickListener(JTable tableMain, Runnable rowClickAction) {
        tableMain.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JTable target = (JTable) e.getSource();
                int row = target.getSelectedRow();
                if (row == -1) {
                    return;
                }

                // Lấy dữ liệu từ hàng được chọn
                String id = (String) target.getValueAt(row, 0);
                dataGoods = new GoodsDAO().getByID(id);

                // Perform the action
                rowClickAction.run();
            }
        });
    }

    void openUpdateDialog(String title, Goods dataGoods) {
        if (title == null || title.equals("")) {
            return;
        }

        // Init dialog
        UpdateGoodsJDialog dialog = new UpdateGoodsJDialog(null, true);
        dialog.setTitle(title); // Set title dialog
        dialog.setModel(dataGoods); // Set data product

        // Attach event when dispose
        dialog.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                // reset data
                loadDataFillTable();

                // reset combobox
                loadDataToComboBox(cbCategory, dao.getAll(), Goods::getCategory);
                insertPlaceholder(cbCategory, PLACEHOLDER_STATUS);
            }
        });

        dialog.setVisible(true);
    }
    // end --->

    // <--- Load data
    void loadDataFillTable() {
        if (scheduledFuture != null && !scheduledFuture.isDone()) {
            scheduledFuture.cancel(false);
        }

        scheduledFuture = scheduledExecutorService.schedule(() -> {
            SwingUtilities.invokeLater(() -> {
                // Get info criterias
                String keyword = textSearch.getText().trim();
                if (keyword.equals(PLACEHOLDER_SEARCH)) {
                    keyword = "";
                }

                String position = cbCategory.getSelectedItem().toString();
                if (position.equals(PLACEHOLDER_STATUS)) {
                    position = "";
                }

                String selectedRadio = radioOn.isSelected() ? radioOn.getText()
                        : radioOff.isSelected() ? radioOff.getText() : "";

                // Get data and load
                List<Goods> dataList
                        = new GoodsDAO().searchByCriteria(keyword, keyword, position, selectedRadio);
                this.fillTable(dataList);
            });
        }, DEBOUNCE_DELAY_LOAD, TimeUnit.MILLISECONDS);
    }

    void fillTable(List<Goods> dataList) {
        // Display table
        DefaultTableModel model = (DefaultTableModel) tableGoods.getModel();
        model.setRowCount(0);

        // Load data into the table 
        dataList.forEach(dataItem -> {
            model.addRow(new Object[]{
                dataItem.getGoodsID(),
                dataItem.getGoodsName(),
                addCommasToNumber(String.valueOf(dataItem.getUnitPrice())),
                dataItem.getUnit(),
                dataItem.getCategory(),
                dataItem.getInitialQuantity(),
                dataItem.getMinimumQuantity(),
                dataItem.getStatus()
            });
        });
    }
    // end --->

}
