package restaurant.ui;

public class FrmChaoJD extends javax.swing.JDialog {

    public FrmChaoJD(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        welcome();
    }

    private void welcome() {
        System.out.println("Welcome to Nghien Buffet...");
        //thread là 1 khối mã thực hiện nhiệm vụ
        Thread t = new Thread() {
            int i = -1;

            @Override
            public void run() {
                while (true) {
                    try {
                        i++;
                        progressBar.setValue(i);
                        if (i == 20) {
                            lblStatus.setText("   Đang khởi tạo các mô-đun...");
                        }
                        if (i == 40) {
                            lblStatus.setText("   Đang kết nối với CSDL...");
                        }
                        if (i == 60) {
                            lblStatus.setText("   Đang khởi tạo giao diện...");
                        }
                        if (i == 80) {
                            lblStatus.setText("   Chuẩn bị vào chương trình...");
                        }
                        if (i == 100) {
                            dispose();
                        }
                        Thread.sleep(25); //thread tạm dừng hoạt động trong 25 ms
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        t.start(); //thread bắt đầu hoạt động
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        pnlStatus = new javax.swing.JPanel();
        lblStatus = new javax.swing.JLabel();
        progressBar = new javax.swing.JProgressBar();
        pnlLogo = new javax.swing.JPanel();
        lblLogo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("QUẢN LÝ NHÀ HÀNG BUFFET");
        setUndecorated(true);

        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        pnlStatus.setBackground(new java.awt.Color(228, 246, 250));
        pnlStatus.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(54, 180, 252)));
        pnlStatus.setLayout(new java.awt.BorderLayout());

        lblStatus.setBackground(new java.awt.Color(228, 246, 250));
        lblStatus.setFont(new java.awt.Font("Be Vietnam Pro", 0, 14)); // NOI18N
        lblStatus.setText("   Khởi động ứng dụng...");
        lblStatus.setPreferredSize(new java.awt.Dimension(134, 28));
        pnlStatus.add(lblStatus, java.awt.BorderLayout.CENTER);

        progressBar.setBackground(new java.awt.Color(54, 180, 252));
        progressBar.setFont(new java.awt.Font("Be Vietnam Pro", 1, 18)); // NOI18N
        progressBar.setForeground(new java.awt.Color(0, 147, 218));
        progressBar.setPreferredSize(new java.awt.Dimension(970, 35));
        progressBar.setStringPainted(true);

        pnlLogo.setBackground(new java.awt.Color(54, 180, 252));
        pnlLogo.setLayout(new java.awt.BorderLayout());

        lblLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/welcome.gif"))); // NOI18N
        pnlLogo.add(lblLogo, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(progressBar, javax.swing.GroupLayout.DEFAULT_SIZE, 1168, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(pnlLogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnlStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JPanel pnlLogo;
    private javax.swing.JPanel pnlStatus;
    private javax.swing.JProgressBar progressBar;
    // End of variables declaration//GEN-END:variables
}