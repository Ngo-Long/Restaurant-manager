package restaurant.onsite;

import java.awt.Font;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.WindowAdapter;

import java.util.Set;
import java.util.List;
import java.util.LinkedHashSet;
import java.util.stream.Collectors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledExecutorService;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.BorderFactory;
import javax.swing.SwingUtilities;
import javax.swing.SwingConstants;

import restaurant.utils.Common;
import restaurant.main.OnSiteMode;
import restaurant.entity.DiningTable;
import restaurant.dao.DiningTableDAO;
import restaurant.utils.DiningTablePanel;
import restaurant.dialog.TableOrderJDialog;
import static restaurant.utils.XRunnable.addTextFieldListeners;

public final class DiningTableFrm extends javax.swing.JPanel {

    private final OnSiteMode onSite;

    public DiningTableFrm(OnSiteMode onSite) {
        initComponents();
        this.init();
        this.onSite = onSite;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBody = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        scrollPaneTableDining = new javax.swing.JScrollPane();
        panelMain = new javax.swing.JPanel();
        textSearch = new javax.swing.JTextField();
        btnReset = new javax.swing.JButton();
        btnHistory = new javax.swing.JButton();
        btnSearch = new javax.swing.JButton();
        panelMenu = new javax.swing.JPanel();

        panelBody.setToolTipText("");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(826, 592));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/icon/filterBlack.png"))); // NOI18N

        scrollPaneTableDining.setBorder(null);
        scrollPaneTableDining.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        panelMain.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panelMainLayout = new javax.swing.GroupLayout(panelMain);
        panelMain.setLayout(panelMainLayout);
        panelMainLayout.setHorizontalGroup(
            panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1254, Short.MAX_VALUE)
        );
        panelMainLayout.setVerticalGroup(
            panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 565, Short.MAX_VALUE)
        );

        scrollPaneTableDining.setViewportView(panelMain);

        textSearch.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        btnReset.setBackground(new java.awt.Color(0, 153, 153));
        btnReset.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnReset.setForeground(new java.awt.Color(255, 255, 255));
        btnReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/icon/refreshWhile.png"))); // NOI18N
        btnReset.setToolTipText("Reset trang (Ctrl + F5)");
        btnReset.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnHistory.setBackground(new java.awt.Color(51, 204, 0));
        btnHistory.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnHistory.setForeground(new java.awt.Color(255, 255, 255));
        btnHistory.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/icon/historyWhile.png"))); // NOI18N
        btnHistory.setToolTipText("Xem lịch sử gọi món");
        btnHistory.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnSearch.setBackground(new java.awt.Color(255, 51, 51));
        btnSearch.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSearch.setForeground(new java.awt.Color(255, 255, 255));
        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/icon/searchWhile.png"))); // NOI18N
        btnSearch.setToolTipText("Tìm kiếm");
        btnSearch.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        panelMenu.setBackground(new java.awt.Color(255, 255, 255));
        panelMenu.setAutoscrolls(true);

        javax.swing.GroupLayout panelMenuLayout = new javax.swing.GroupLayout(panelMenu);
        panelMenu.setLayout(panelMenuLayout);
        panelMenuLayout.setHorizontalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 728, Short.MAX_VALUE)
        );
        panelMenuLayout.setVerticalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(textSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnHistory, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
            .addComponent(scrollPaneTableDining, javax.swing.GroupLayout.DEFAULT_SIZE, 1256, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(textSearch)
                    .addComponent(btnSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                    .addComponent(btnReset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnHistory, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scrollPaneTableDining, javax.swing.GroupLayout.DEFAULT_SIZE, 546, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelBodyLayout = new javax.swing.GroupLayout(panelBody);
        panelBody.setLayout(panelBodyLayout);
        panelBodyLayout.setHorizontalGroup(
            panelBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBodyLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1256, Short.MAX_VALUE)
                .addGap(12, 12, 12))
        );
        panelBodyLayout.setVerticalGroup(
            panelBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBodyLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 602, Short.MAX_VALUE)
                .addGap(12, 12, 12))
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
    private javax.swing.JButton btnHistory;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSearch;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel panelBody;
    private javax.swing.JPanel panelMain;
    private javax.swing.JPanel panelMenu;
    private javax.swing.JScrollPane scrollPaneTableDining;
    private javax.swing.JTextField textSearch;
    // End of variables declaration//GEN-END:variables

    JLabel selectedMenu;
    final int DEBOUNCE_DELAY_LOAD = 300;

    DiningTableDAO dao = new DiningTableDAO();
    ScheduledFuture<?> scheduledFuture;
    ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);

    void init() {
        // Setup common
        Common.customizeScrollBar(scrollPaneTableDining);
        scrollPaneTableDining.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        // Setup menu
        setupPanelMenu(panelMenu, dao.getAll());

        // Handle click button reset
        btnReset.addActionListener(e -> onSite.displayOnSitePanel(new DiningTableFrm(onSite)));

        // Load load by search when change
        addTextFieldListeners(textSearch, this::loadDataDisplayTables);

        // load data and display table list
        this.loadDataDisplayTables();
    }

    // Load data
    void loadDataDisplayTables() {
        if (scheduledFuture != null && !scheduledFuture.isDone()) {
            scheduledFuture.cancel(false);
        }

        scheduledFuture = scheduledExecutorService.schedule(() -> {
            SwingUtilities.invokeLater(() -> {
                // get info criterias
                String searchName = textSearch.getText().trim();
                String menuItem = selectedMenu.getText();

                // get data and load
                List<DiningTable> dataList = dao.searchByCriteria(searchName, menuItem, "");
                
                // display tables list and click show dialog table order
                DiningTablePanel.displayDiningTables(
                        panelMain,
                        dataList,
                        this::handleClickTableShowDialog
                );
            });
        }, DEBOUNCE_DELAY_LOAD, TimeUnit.MILLISECONDS);
    }

    void handleClickTableShowDialog(DiningTable dataTable) {
        // Open dialog and Transmit data via file orderTableDialog
        TableOrderJDialog dialog = new TableOrderJDialog(null, true, onSite);
        dialog.displayTableInfo(dataTable);
        dialog.displayOrderedOfTable(dataTable);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);

        // Reload data when the dialog is closed
        dialog.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                // Reset load data
                loadDataDisplayTables();
            }
        });
    }
    // end --->

    // <--- Handle event search and catogory
    void setupPanelMenu(JPanel panelMenu, List<DiningTable> dataAll) {
        // Create a set to store unique names
        Set<String> dataSet = new LinkedHashSet<>();
        for (DiningTable data : dataAll) {
            dataSet.add(data.getLocation());
        }

        // Convert the set to a sorted list
        List<String> dataList = dataSet.stream().sorted().collect(Collectors.toList());

        // Create buttons for each and add them to panel
        for (String dataItem : dataList) {
            // Set button location
            JLabel item = new JLabel(dataItem);
            item.setBackground(Color.LIGHT_GRAY);
            item.setForeground(new Color(120, 120, 120));
            item.setPreferredSize(new Dimension(74, 30));
            item.setFont(new Font("Segoe UI", Font.PLAIN, 14));
            item.setVerticalAlignment(SwingConstants.CENTER);
            item.setHorizontalAlignment(SwingConstants.CENTER);
            item.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            item.setBorder(BorderFactory.createLineBorder(new Color(150, 150, 150), 2, true));

            // Handle click location
            item.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    handleClickMenu(item);
                }
            });

            // Automatically select the first item
            if (selectedMenu == null) {
                handleClickMenu(item);
            }

            // Add item location to the panel
            panelMenu.add(item);
        }

        // Set layout for panelButtons
        panelMenu.setLayout(new FlowLayout(FlowLayout.CENTER, 4, 4));

        // Refresh the panel to display the new buttons
        panelMenu.revalidate();
        panelMenu.repaint();
    }

    void handleClickMenu(JLabel item) {
        // Kiểm tra nếu nút hiện tại không phải là nút đã được chọn trước đó
        if (selectedMenu == item) {
            return;
        }

        // Đặt lại màu cho nút trước đó nếu có
        if (selectedMenu != null) {
            selectedMenu.setForeground(new Color(120, 120, 120));
            selectedMenu.setBorder(BorderFactory.createLineBorder(new Color(150, 150, 150), 2, true));
        }

        // Thiết lập lại màu cho nút hiện tại
        item.setForeground(new Color(255, 11, 11));
        item.setBorder(BorderFactory.createLineBorder(new Color(255, 11, 11), 2, true));

        // Cập nhật nút được chọn hiện tại
        selectedMenu = item;
        this.loadDataDisplayTables();
    }
    // end --->   
}
