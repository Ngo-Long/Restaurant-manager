package restaurent.dialog;

public class HelloJDialog extends javax.swing.JDialog {

    public HelloJDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        welcome();
    }

    private void welcome() {
        System.out.println("Welcome to Hot Noodle...");
        
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
        t.start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        progressBar = new javax.swing.JProgressBar();
        lblStatus = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("QUẢN LÝ NHÀ HÀNG BUFFET");
        setUndecorated(true);

        progressBar.setBackground(new java.awt.Color(54, 180, 252));
        progressBar.setFont(new java.awt.Font("Be Vietnam Pro", 1, 18)); // NOI18N
        progressBar.setForeground(new java.awt.Color(0, 147, 218));
        progressBar.setPreferredSize(new java.awt.Dimension(970, 35));
        progressBar.setStringPainted(true);

        lblStatus.setBackground(new java.awt.Color(228, 246, 250));
        lblStatus.setFont(new java.awt.Font("Be Vietnam Pro", 0, 14)); // NOI18N
        lblStatus.setText("   Khởi động ứng dụng...");
        lblStatus.setPreferredSize(new java.awt.Dimension(134, 28));

        jLabel2.setBackground(new java.awt.Color(0, 153, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/welcome.gif"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(progressBar, javax.swing.GroupLayout.DEFAULT_SIZE, 1172, Short.MAX_VALUE)
            .addComponent(lblStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 623, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lblStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JProgressBar progressBar;
    // End of variables declaration//GEN-END:variables
}
