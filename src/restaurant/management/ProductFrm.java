package restaurant.management;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.WindowAdapter;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledExecutorService;

import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import restaurant.utils.Common;
import restaurant.entity.Product;
import restaurant.dao.ProductDAO;
import restaurant.utils.XTextField;
import restaurant.table.TableCustom;
import restaurant.main.ManagementMode;
import restaurant.utils.TableNavigator;
import restaurant.dialog.UpdateProductJDialog;
import static restaurant.utils.XComboBox.insertPlaceholder;
import static restaurant.utils.XComboBox.loadDataToComboBox;
import static restaurant.utils.XRunnable.addComponentListeners;
import static restaurant.utils.XRunnable.addTextFieldListeners;

public final class ProductFrm extends javax.swing.JPanel {

    public ProductFrm(ManagementMode mainManager) {
        initComponents();
        this.init();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        scrollPaneProdcut = new javax.swing.JScrollPane();
        panelBody = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        btnExport = new javax.swing.JButton();
        btnImport = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableProducts = new javax.swing.JTable();
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
        jPanel5 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        cbCategory = new javax.swing.JComboBox<>();

        scrollPaneProdcut.setBorder(null);

        panelBody.setToolTipText("");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(926, 0));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Sản phẩm");

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
        btnAdd.setText("Thêm món ăn");
        btnAdd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        tableProducts.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tableProducts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã món", "Tên", "Giá vốn", "Giá bán", "Đơn vị tính", "Phân loại"
            }
        ));
        tableProducts.setGridColor(new java.awt.Color(255, 255, 255));
        tableProducts.setRowHeight(40);
        jScrollPane1.setViewportView(tableProducts);
        if (tableProducts.getColumnModel().getColumnCount() > 0) {
            tableProducts.getColumnModel().getColumn(0).setPreferredWidth(20);
            tableProducts.getColumnModel().getColumn(1).setPreferredWidth(120);
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
        jLabel6.setText("Hiển thị 1 - 10 trên tổng số 10 món ăn");

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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 543, Short.MAX_VALUE)
                        .addComponent(jLabel6))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAdd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
                    .addComponent(btnFirst)
                    .addComponent(btnPrev)
                    .addComponent(btnNext)
                    .addComponent(btnLast)
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
                    .addComponent(jLabel2)
                    .addComponent(textSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(textSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Lựa chọn hiển thị");

        radioOn.setSelected(true);
        radioOn.setText("Đang kinh doanh");

        radioOff.setText("Ngừng kinh doanh");

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

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("Loại hàng");

        cbCategory.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(cbCategory, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(12, 12, 12))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(cbCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelBodyLayout = new javax.swing.GroupLayout(panelBody);
        panelBody.setLayout(panelBodyLayout);
        panelBodyLayout.setHorizontalGroup(
            panelBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBodyLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(panelBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1013, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );
        panelBodyLayout.setVerticalGroup(
            panelBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBodyLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(panelBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 584, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelBodyLayout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        scrollPaneProdcut.setViewportView(panelBody);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollPaneProdcut)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollPaneProdcut, javax.swing.GroupLayout.Alignment.TRAILING)
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelBody;
    private javax.swing.JRadioButton radioAll;
    private javax.swing.JRadioButton radioOff;
    private javax.swing.JRadioButton radioOn;
    private javax.swing.JScrollPane scrollPaneProdcut;
    private javax.swing.JTable tableProducts;
    private javax.swing.JTextField textSearch;
    // End of variables declaration//GEN-END:variables

    int row = -1;
    final int DEBOUNCE_DELAY_LOAD = 300;
    final String PLACEHOLDER_STATUS = "--Tất cả--";
    final String PLACEHOLDER_SEARCH = "Tìm theo tên sản phẩm";

    restaurant.entity.Product dataProduct;
    ProductDAO dao = new ProductDAO();

    ScheduledFuture<?> scheduledFuture;
    ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);

    void init() {
        // <--- Setup common --->
        Common.customizeScrollBar(scrollPaneProdcut);
        Common.createButtonGroup(radioOn, radioOff, radioAll);

        // Setup field text
        XTextField.addPlaceholder(textSearch, PLACEHOLDER_SEARCH);
        XTextField.addFocusBorder(textSearch, new Color(51, 204, 0), new Color(204, 204, 204));

        // Setup table
        TableCustom.apply(jScrollPane1, TableCustom.TableType.MULTI_LINE);
        Common.customizeTable(tableProducts, new int[]{}, 30);

        // <--- Setup main --->
        // navigator table 
        TableNavigator navigator = new TableNavigator(tableProducts);
        btnFirst.addActionListener(e -> navigator.first());
        btnNext.addActionListener(e -> navigator.next());
        btnPrev.addActionListener(e -> navigator.prev());
        btnLast.addActionListener(e -> navigator.last());

        // Click button add  product
        btnAdd.addActionListener(e -> openUpdateDialog("Thêm sản phẩm", null));

        // handle click row table show dialog
        attachRowClickListener(
                tableProducts,
                () -> openUpdateDialog("Cập nhật sản phẩm", dataProduct)
        );

        // add data to combobox
        insertPlaceholder(cbCategory, PLACEHOLDER_STATUS);
        loadDataToComboBox(cbCategory, dao.getAll(), Product::getCategory);

        // load list by search and classify when change
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
                if (row != -1) {
                    // Get data from row
                    String id = (String) target.getValueAt(row, 0);
                    dataProduct = dao.getByID(id);

                    // Perform the action
                    rowClickAction.run();
                }
            }
        });
    }

    void openUpdateDialog(String title, Product dataProduct) {
        if (title == null || title.equals("")) {
            return;
        }

        // Init dialog
        UpdateProductJDialog dialog = new UpdateProductJDialog(null, true);
        dialog.setTitle(title); // Set title dialog
        dialog.setModel(dataProduct); // Set data product

        // Attach event when dispose
        dialog.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                // reset data
                loadDataFillTable();

                // reset combobox
                loadDataToComboBox(cbCategory, dao.getAll(), Product::getCategory);
                insertPlaceholder(cbCategory, PLACEHOLDER_STATUS);
            }
        });

        dialog.setVisible(true); // Open dialog
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
                String search = textSearch.getText().trim();
                if (search.equals(PLACEHOLDER_SEARCH)) {
                    search = "";
                }

                String category = cbCategory.getSelectedItem().toString();
                if (category.equals(PLACEHOLDER_STATUS)) {
                    category = "";
                }

                String selectedRadio = radioOn.isSelected() ? radioOn.getText()
                        : radioOff.isSelected() ? radioOff.getText() : "";

                // Get data and load
                List<Product> dataList
                        = dao.searchByCriteria(search, category, selectedRadio);
                this.fillTable(dataList);
            });
        }, DEBOUNCE_DELAY_LOAD, TimeUnit.MILLISECONDS);
    }

    void fillTable(List<Product> dataProducts) {
        System.out.println("Đang load dữ liệu từ cơ sở dữ liệu...");

        // Display table
        DefaultTableModel model = (DefaultTableModel) tableProducts.getModel();
        model.setRowCount(0);

        // Load data into the table 
        for (Product dataProduct : dataProducts) {
            String price = String.valueOf(dataProduct.getPrice());
            String formattedPrice = XTextField.addCommasToNumber(price) + "đ";

            String costPrice = String.valueOf(dataProduct.getCostPrice());
            String formattedCostPrice = XTextField.addCommasToNumber(costPrice) + "đ";

            model.addRow(new Object[]{
                dataProduct.getProductID(),
                dataProduct.getProductName(),
                formattedCostPrice,
                formattedPrice,
                dataProduct.getUnit(),
                dataProduct.getCategory()
            });
        }

    }
    // end --->
}
