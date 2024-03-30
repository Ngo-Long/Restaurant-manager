package restaurant.ui;

//import buffet.utils.XAuth;
//import buffet.utils.XDialog;
//import buffet.utils.XHelper;
//import buffet.utils.XValidate;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import restaurant.dao.EmployeeDAO;

public class FrmDangNhapJD extends javax.swing.JDialog {

    EmployeeDAO Employee = new EmployeeDAO();

    public FrmDangNhapJD(java.awt.Frame parent, boolean modal) {
        super(null, java.awt.Dialog.ModalityType.TOOLKIT_MODAL);
        initComponents();
        init();
    }

    private void init() {
        setLocationRelativeTo(null);
//        setIconImage(XHelper.getAppIcon());
//        XHelper.welcome();
    }

    private void login() {
//        String tk = txtUser.getText();
//        String mk = new String(txtPassword.getPassword());
//        NguoiDung nd = nddao.selectById(tk);
//        if (nd == null) {
//            txtUser.requestFocus();
//            XDialog.alert(this, "Sai tài khoản!");
//        } else if (!mk.equals(nd.getMatKhau())) {
//            XDialog.alert(this, "Sai mật khẩu!");
//        } else {
//            XDialog.alert(this, "Đăng nhập thành công!");
//            XAuth.user = nd;
//            this.dispose();
//        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        pnlLogo = new javax.swing.JPanel();
        lblLogo = new javax.swing.JLabel();
        pnlLogin = new javax.swing.JPanel();
        pnlBg = new javax.swing.JPanel();
        lblTaiKhoan = new javax.swing.JLabel();
        pnlUser = new javax.swing.JPanel();
        txtUser = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        lblMatKhau = new javax.swing.JLabel();
        pnlPass = new javax.swing.JPanel();
        txtPassword = new javax.swing.JPasswordField();
        lblhide = new javax.swing.JLabel();
        lblshow = new javax.swing.JLabel();
        lblIcon = new javax.swing.JLabel();
        btnLogin = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        lblDangNhap = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("QUẢN LÝ NHÀ HÀNG BUFFET");
        setUndecorated(true);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        pnlLogo.setBackground(new java.awt.Color(54, 180, 252));

        lblLogo.setBackground(new java.awt.Color(54, 180, 252));
        lblLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/logo-login.png"))); // NOI18N

        javax.swing.GroupLayout pnlLogoLayout = new javax.swing.GroupLayout(pnlLogo);
        pnlLogo.setLayout(pnlLogoLayout);
        pnlLogoLayout.setHorizontalGroup(
            pnlLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlLogoLayout.createSequentialGroup()
                .addContainerGap(60, Short.MAX_VALUE)
                .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 483, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        pnlLogoLayout.setVerticalGroup(
            pnlLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlLogoLayout.createSequentialGroup()
                .addGap(0, 17, Short.MAX_VALUE)
                .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 682, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnlLogin.setBackground(new java.awt.Color(54, 180, 252));

        pnlBg.setBackground(new java.awt.Color(253, 249, 222));

        lblTaiKhoan.setFont(new java.awt.Font("Be Vietnam Pro", 0, 24)); // NOI18N
        lblTaiKhoan.setText("Tài khoản:");

        pnlUser.setBackground(new java.awt.Color(253, 249, 222));

        txtUser.setFont(new java.awt.Font("Be Vietnam Pro", 0, 20)); // NOI18N
        txtUser.setText("admin");
        txtUser.setToolTipText("Tài khoản");
        txtUser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtUserKeyPressed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-userlg.png"))); // NOI18N

        javax.swing.GroupLayout pnlUserLayout = new javax.swing.GroupLayout(pnlUser);
        pnlUser.setLayout(pnlUserLayout);
        pnlUserLayout.setHorizontalGroup(
            pnlUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlUserLayout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtUser, javax.swing.GroupLayout.DEFAULT_SIZE, 339, Short.MAX_VALUE))
        );
        pnlUserLayout.setVerticalGroup(
            pnlUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlUserLayout.createSequentialGroup()
                .addGroup(pnlUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtUser)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        lblMatKhau.setFont(new java.awt.Font("Be Vietnam Pro", 0, 24)); // NOI18N
        lblMatKhau.setText("Mật khẩu:");

        pnlPass.setBackground(new java.awt.Color(255, 255, 255));
        pnlPass.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 197, 198)));

        txtPassword.setFont(new java.awt.Font("Be Vietnam Pro", 0, 20)); // NOI18N
        txtPassword.setText("123456");
        txtPassword.setToolTipText("Mật khẩu");
        txtPassword.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        txtPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPasswordKeyPressed(evt);
            }
        });

        lblhide.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblhide.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblhideMouseClicked(evt);
            }
        });

        lblshow.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblshow.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblshowMouseClicked(evt);
            }
        });

        lblIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-hide.png"))); // NOI18N

        javax.swing.GroupLayout pnlPassLayout = new javax.swing.GroupLayout(pnlPass);
        pnlPass.setLayout(pnlPassLayout);
        pnlPassLayout.setHorizontalGroup(
            pnlPassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPassLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlPassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblhide, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblshow, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlPassLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lblIcon)))
                .addContainerGap())
        );
        pnlPassLayout.setVerticalGroup(
            pnlPassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPassLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(pnlPassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblhide, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblshow, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
            .addComponent(txtPassword, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        btnLogin.setBackground(new java.awt.Color(0, 80, 143));
        btnLogin.setFont(new java.awt.Font("Be Vietnam Pro", 1, 24)); // NOI18N
        btnLogin.setForeground(new java.awt.Color(255, 255, 255));
        btnLogin.setText("Đăng nhập");
        btnLogin.setBorderPainted(false);
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        btnClose.setBackground(new java.awt.Color(0, 80, 143));
        btnClose.setFont(new java.awt.Font("Be Vietnam Pro", 1, 24)); // NOI18N
        btnClose.setForeground(new java.awt.Color(255, 255, 255));
        btnClose.setText("Đóng");
        btnClose.setBorderPainted(false);
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-key.png"))); // NOI18N

        javax.swing.GroupLayout pnlBgLayout = new javax.swing.GroupLayout(pnlBg);
        pnlBg.setLayout(pnlBgLayout);
        pnlBgLayout.setHorizontalGroup(
            pnlBgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBgLayout.createSequentialGroup()
                .addGroup(pnlBgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlBgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlBgLayout.createSequentialGroup()
                            .addGap(27, 27, 27)
                            .addGroup(pnlBgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblMatKhau)
                                .addComponent(lblTaiKhoan)
                                .addComponent(pnlUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(pnlBgLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(54, 54, 54)
                            .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlBgLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pnlPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlBgLayout.setVerticalGroup(
            pnlBgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBgLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(lblTaiKhoan)
                .addGap(18, 18, 18)
                .addComponent(pnlUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(lblMatKhau)
                .addGap(18, 18, 18)
                .addGroup(pnlBgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addGroup(pnlBgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28))
        );

        lblDangNhap.setFont(new java.awt.Font("Be Vietnam Pro", 1, 32)); // NOI18N
        lblDangNhap.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDangNhap.setText("ĐĂNG NHẬP HỆ THỐNG");

        javax.swing.GroupLayout pnlLoginLayout = new javax.swing.GroupLayout(pnlLogin);
        pnlLogin.setLayout(pnlLoginLayout);
        pnlLoginLayout.setHorizontalGroup(
            pnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlLoginLayout.createSequentialGroup()
                .addContainerGap(120, Short.MAX_VALUE)
                .addGroup(pnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlBg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60))
        );
        pnlLoginLayout.setVerticalGroup(
            pnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLoginLayout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addComponent(lblDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlBg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(pnlLogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnlLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
//        if (XValidate.checkNullText(txtUser)
//                && XValidate.checkNullPass(txtPassword)) {
//            if (XValidate.checkMa(txtUser)
//                    && XValidate.checkPass(txtPassword)) {
//                this.login();
//            }
//        }
    }//GEN-LAST:event_btnLoginActionPerformed

    private void lblhideMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblhideMouseClicked
        lblshow.setVisible(true);
        lblshow.setEnabled(true);
        txtPassword.setEchoChar((char) 0);
        ImageIcon icon = new ImageIcon(getClass().getResource("/icons/icons8-eye.png"));
        lblIcon.setIcon(icon);
        lblhide.setVisible(false);
        lblhide.setEnabled(false);
    }//GEN-LAST:event_lblhideMouseClicked

    private void lblshowMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblshowMouseClicked
        // TODO add your handling code here:
        lblhide.setVisible(true);
        lblhide.setEnabled(true);
        txtPassword.setEchoChar((char) 8226);
        ImageIcon icon = new ImageIcon(getClass().getResource("/icons/icons8-hide.png"));
        lblIcon.setIcon(icon);
        lblshow.setVisible(false);
        lblshow.setEnabled(false);
    }//GEN-LAST:event_lblshowMouseClicked

    private void txtUserKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUserKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            this.getRootPane().setDefaultButton(btnLogin);
            btnLogin.requestFocus();
        }
        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            System.exit(0);
        }
    }//GEN-LAST:event_txtUserKeyPressed

    private void txtPasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPasswordKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            this.getRootPane().setDefaultButton(btnLogin);
            btnLogin.requestFocus();
        }
        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            System.exit(0);
        }
    }//GEN-LAST:event_txtPasswordKeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblDangNhap;
    private javax.swing.JLabel lblIcon;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblMatKhau;
    private javax.swing.JLabel lblTaiKhoan;
    private javax.swing.JLabel lblhide;
    private javax.swing.JLabel lblshow;
    private javax.swing.JPanel pnlBg;
    private javax.swing.JPanel pnlLogin;
    private javax.swing.JPanel pnlLogo;
    private javax.swing.JPanel pnlPass;
    private javax.swing.JPanel pnlUser;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}