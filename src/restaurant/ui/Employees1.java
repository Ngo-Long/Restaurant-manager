package restaurant.ui;

import javax.swing.JFrame;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import restaurant.dao.EmployeeDAO;
import static restaurant.dao.EmployeeDAO.isIdExists;
import static restaurant.dao.EmployeeDAO.searchAndClassifyEmployee;

import restaurant.entity.EmployeeEntity;
import java.awt.Dimension;
import java.awt.Image;
import java.io.File;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;

public class Employees1 extends javax.swing.JFrame {

    Map<String, String> userInfo = CommonUtils.getUserInfo();
    private String imagePath;
    private int currentIndex = 0;
    private List<EmployeeEntity> employeeList;

    public Employees1(Map<String, String> userInfo) {
        initComponents();
        CommonUtils.initClock(labelHouse);
        CommonUtils.displayUserInfoBar(userInfo, labelAccount, labelPosition);
        CommonUtils.setImage("D:\\FPT Polytechnic\\KiThuatPhanMem\\KTLT\\KTLT\\src\\icon\\logo.jpg", labelLogo);

        employeeList = new ArrayList<>();
        loadDataIntoTable();
        addTableMouseListener();
        updateTongNhanVien();
        loadEmployeeList();
        displayCurrentEmployee(currentIndex);
        ((DefaultTableModel) tblDanhSachNV.getModel()).addTableModelListener(e -> updateTongNhanVien());
        tblDanhSachNV.setRowSelectionInterval(currentIndex, currentIndex);
    }

    private void openFullScreenWindow(JFrame window) {
        window.setExtendedState(JFrame.MAXIMIZED_BOTH);
        window.setVisible(true);
        this.dispose();
    }

    private void addTableMouseListener() {
        tblDanhSachNV.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int selectedRow = tblDanhSachNV.getSelectedRow();
                if (selectedRow != -1) {
                    currentIndex = selectedRow; // Cập nhật currentIndex khi chọn dòng mới trong bảng
                    displayEmployeeDetails(selectedRow);
                }
            }
        });
    }

    private void updateTongNhanVien() {
        int rowCount = tblDanhSachNV.getRowCount();
        labelTongNv.setText("Tổng nhân viên: " + rowCount);
    }

    private void loadEmployeeList() {
        employeeList = EmployeeDAO.getAllEmployees();
    }

    private void loadDataIntoTable() {
        DefaultTableModel model = (DefaultTableModel) tblDanhSachNV.getModel();
        model.setRowCount(0);

        try {
            Connection conn = EmployeeDAO.getConnection();

            String sql = "SELECT * FROM NhanVien";
            try (PreparedStatement statement = conn.prepareStatement(sql); ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Object[] row = {
                        resultSet.getString("idNhanVien"),
                        resultSet.getString("hoTen"),
                        resultSet.getString("gioiTinh"),
                        resultSet.getString("ngaySinh"),
                        resultSet.getString("chucVu"),
                        resultSet.getString("idCa"),
                        resultSet.getDouble("luong"),
                        resultSet.getString("trangThai"),};
                    model.addRow(row);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void displayEmployeeDetails(int selectedRow) {
        // Get data from the selected row
        String idNhanVien = tblDanhSachNV.getValueAt(selectedRow, 0).toString();

        EmployeeEntity employee = EmployeeDAO.viewEmployeeDetails(idNhanVien);

        textMa.setText(employee.getIdNhanVien());
        textHoTen.setText(employee.getHoTen());
        textCmnd.setText(employee.getCmnd());
        textEmail.setText(employee.getEmail());
        textSdt.setText(String.valueOf(employee.getSdt()));
        textDiaChi.setText(employee.getDiaChi());
        textLuong.setText(String.valueOf(employee.getLuong()));
        textNganHang.setText(employee.getSoTaiKhoan());
        textSoTK.setText(employee.getNganHang());
        textMoTa.setText(employee.getMoTa());

        // Avatar 
        btnAvatar.setBorder(null);
        btnAvatar.setPreferredSize(new Dimension(87, 87));

        String avatarPath = employee.getAvatarPath();
        ImageIcon icon = new ImageIcon(avatarPath);
        Image image = icon.getImage().getScaledInstance(87, 87, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(image);
        btnAvatar.setIcon(scaledIcon);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        textNgaySinh.setText(sdf.format(employee.getNgaySinh()));
        textNgayDau.setText(sdf.format(employee.getNgayVaoLam()));

        // Set selected item for ComboBoxes
        CbCa.setSelectedItem(employee.getIdCa());
        CbChucVu.setSelectedItem(employee.getChucVu());
        CbGioiTinh.setSelectedItem(employee.getGioiTinh());
        CbTrangThai.setSelectedItem(employee.getTrangThai());
    }

    private void addEmployee() throws ParseException {
        String idNhanVien = textMa.getText();

        if (isIdExists(idNhanVien)) {
            JOptionPane.showMessageDialog(this, "Mã nhân viên đã tồn tại!");
            return;
        }

        if (textMa.getText().isEmpty() || textHoTen.getText().isEmpty() || textSdt.getText().isEmpty()
                || textNgaySinh.getText().isEmpty() || textCmnd.getText().isEmpty() || textEmail.getText().isEmpty()
                || textDiaChi.getText().isEmpty() || textLuong.getText().isEmpty() || textMoTa.getText().isEmpty()
                || textSoTK.getText().isEmpty() || textNganHang.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng điền đầy đủ thông tin.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String idCa = CbCa.getSelectedItem().toString();
        String hoTen = textHoTen.getText();
        String gioiTinh = CbGioiTinh.getSelectedItem().toString();
        String sdt = textSdt.getText();
        String ngaySinh = textNgaySinh.getText();
        String cmnd = textCmnd.getText();
        String email = textEmail.getText();
        String diaChi = textDiaChi.getText();
        String hinhAnh = imagePath;
        String chucVu = CbChucVu.getSelectedItem().toString();
        String trangThai = CbTrangThai.getSelectedItem().toString();
        double luong = Double.parseDouble(textLuong.getText());
        String moTa = textMoTa.getText();
        String nganHang = textSoTK.getText();
        String soTaiKhoan = textNganHang.getText();

        EmployeeDAO.insertEmployee(idNhanVien, idCa, hoTen, gioiTinh, sdt, ngaySinh, cmnd, email, diaChi, hinhAnh,
                chucVu, trangThai, luong, moTa, nganHang, soTaiKhoan);

        loadDataIntoTable();
    }

    private void updateEmployee() {
        String idNhanVien = textMa.getText();
        String idCa = CbCa.getSelectedItem().toString();
        String newHoTen = textHoTen.getText();
        String newChucVu = CbChucVu.getSelectedItem().toString();
        double newLuong = Double.parseDouble(textLuong.getText());
        String newGioiTinh = CbGioiTinh.getSelectedItem().toString();
        String newSdt = textSdt.getText();
        String newNgaySinh = textNgaySinh.getText();
        String newCmnd = textCmnd.getText();
        String newEmail = textEmail.getText();
        String newDiaChi = textDiaChi.getText();
        String newHinhAnhPath = imagePath;
        String newTrangThai = CbTrangThai.getSelectedItem().toString();
        String newMoTa = textMoTa.getText();
        String newNganHang = textSoTK.getText();
        String newSoTaiKhoan = textNganHang.getText();

        EmployeeDAO.updateEmployee(idNhanVien, idCa, newHoTen, newChucVu, newLuong,
                newGioiTinh, newSdt, newNgaySinh, newCmnd, newEmail, newDiaChi,
                newHinhAnhPath, newMoTa, newNganHang, newSoTaiKhoan, newTrangThai);

        loadDataIntoTable();
    }

    private void updateEmployeeStatusSoft() {
        String idNhanVien = textMa.getText();

        EmployeeDAO.updateEmployeeStatus(idNhanVien, "Nghỉ Việc");

        loadDataIntoTable();
    }

    private void resetFields() {
        textMa.setText("");
        textHoTen.setText("");
        textCmnd.setText("");
        textEmail.setText("");
        textSdt.setText("");
        textDiaChi.setText("");
        textLuong.setText("");
        textNganHang.setText("");
        textSoTK.setText("");
        textMoTa.setText("");
        textNgaySinh.setText("");
        textNgayDau.setText("");

        // Đặt giá trị mặc định cho ComboBoxes
        CbChucVu.setSelectedIndex(0);
        CbTrangThai.setSelectedIndex(0);
        CbGioiTinh.setSelectedIndex(0);
        CbCa.setSelectedIndex(0);
    }

    private void displayCurrentEmployee(int index) {
        if (index >= 0 && index < employeeList.size()) {
            EmployeeEntity employee = employeeList.get(index);
            // Hiển thị thông tin của nhân viên trong giao diện của bạn
            textMa.setText(employee.getIdNhanVien());
            textHoTen.setText(employee.getHoTen());
            textCmnd.setText(employee.getCmnd());
            textEmail.setText(employee.getEmail());
            textSdt.setText(String.valueOf(employee.getSdt()));
            textDiaChi.setText(employee.getDiaChi());
            textLuong.setText(String.valueOf(employee.getLuong()));
            textNganHang.setText(employee.getSoTaiKhoan());
            textSoTK.setText(employee.getNganHang());
            textMoTa.setText(employee.getMoTa());

            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            textNgaySinh.setText(sdf.format(employee.getNgaySinh()));
            textNgayDau.setText(sdf.format(employee.getNgayVaoLam()));

            // Set selected item for ComboBoxes
            CbChucVu.setSelectedItem(employee.getChucVu());
            CbTrangThai.setSelectedItem(employee.getTrangThai());
            CbGioiTinh.setSelectedItem(employee.getGioiTinh());
            CbCa.setSelectedItem(employee.getIdCa());
        }

        // Btn
        btnFirst.setEnabled(index != 0);
        btnPre.setEnabled(index != 0);
        btnNext.setEnabled(index != employeeList.size() - 1);
        btnLast.setEnabled(index != employeeList.size() - 1);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnDinnerTable = new javax.swing.JButton();
        btnOrder = new javax.swing.JButton();
        btnPay = new javax.swing.JButton();
        btnConfirm = new javax.swing.JButton();
        btnStaff = new javax.swing.JButton();
        btnClient = new javax.swing.JButton();
        btnAccount = new javax.swing.JButton();
        btnOverview = new javax.swing.JButton();
        btnCallTable = new javax.swing.JButton();
        btnReport = new javax.swing.JButton();
        btnWarehouse = new javax.swing.JButton();
        labelLogo = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        jButton14 = new javax.swing.JButton();
        labelAccount = new javax.swing.JLabel();
        labelPosition = new javax.swing.JLabel();
        labelHouse = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDanhSachNV = new javax.swing.JTable();
        btnTimKiem = new javax.swing.JButton();
        textTimKiem = new javax.swing.JTextField();
        CbPhanLoaiCa = new javax.swing.JComboBox<>();
        CbPhanLoaiChucVu = new javax.swing.JComboBox<>();
        btnPhanLoai = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        textMa = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        textHoTen = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        CbChucVu = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        CbGioiTinh = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        textNgaySinh = new javax.swing.JTextField();
        textMoTa = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        textEmail = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        textSdt = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        textDiaChi = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        textNgayDau = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        CbCa = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        CbTrangThai = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        textCmnd = new javax.swing.JTextField();
        btnAvatar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        labelTongNv = new javax.swing.JLabel();
        btnLast = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        btnPre = new javax.swing.JButton();
        btnFirst = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        btnTimKiem2 = new javax.swing.JButton();
        textTimKiem2 = new javax.swing.JTextField();
        btnPhanLoai2 = new javax.swing.JButton();
        CbPhanLoaiChucVu2 = new javax.swing.JComboBox<>();
        btnFirst1 = new javax.swing.JButton();
        btnPre1 = new javax.swing.JButton();
        btnNext1 = new javax.swing.JButton();
        btnLast1 = new javax.swing.JButton();
        labelTongNv1 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        textMa2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        textHoTen2 = new javax.swing.JTextField();
        btnAvatar2 = new javax.swing.JButton();
        CbChucVu2 = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        btnAdd1 = new javax.swing.JButton();
        btnRemove1 = new javax.swing.JButton();
        btnUpdate1 = new javax.swing.JButton();
        btnReset1 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblDanhSachNV2 = new javax.swing.JTable();
        textNgayTao = new javax.swing.JTextField();
        textTaiKhoan = new javax.swing.JTextField();
        textMatKhau = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        maTaiKhoan = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        btnTimKiem4 = new javax.swing.JButton();
        textTimKiem4 = new javax.swing.JTextField();
        btnPhanLoai4 = new javax.swing.JButton();
        CbPhanLoaiChucVu4 = new javax.swing.JComboBox<>();
        CbPhanLoaiCa4 = new javax.swing.JComboBox<>();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblDanhSachNV4 = new javax.swing.JTable();
        btnFirst2 = new javax.swing.JButton();
        btnPre2 = new javax.swing.JButton();
        btnNext2 = new javax.swing.JButton();
        btnLast2 = new javax.swing.JButton();
        labelTongNv2 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        textMa3 = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        textHoTen3 = new javax.swing.JTextField();
        btnAvatar3 = new javax.swing.JButton();
        CbCa2 = new javax.swing.JComboBox<>();
        CbChucVu3 = new javax.swing.JComboBox<>();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        CbGioiTinh2 = new javax.swing.JComboBox<>();
        jLabel43 = new javax.swing.JLabel();
        CbTrangThai2 = new javax.swing.JComboBox<>();
        textNgaySinh2 = new javax.swing.JTextField();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        textCmnd2 = new javax.swing.JTextField();
        jLabel46 = new javax.swing.JLabel();
        textEmail2 = new javax.swing.JTextField();
        jLabel47 = new javax.swing.JLabel();
        textSdt2 = new javax.swing.JTextField();
        jLabel48 = new javax.swing.JLabel();
        textDiaChi2 = new javax.swing.JTextField();
        jLabel49 = new javax.swing.JLabel();
        textMoTa2 = new javax.swing.JTextField();
        jLabel50 = new javax.swing.JLabel();
        textNgayDau2 = new javax.swing.JTextField();
        btnAdd2 = new javax.swing.JButton();
        btnRemove2 = new javax.swing.JButton();
        btnUpdate2 = new javax.swing.JButton();
        btnReset2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btnTimKiem5 = new javax.swing.JButton();
        textTimKiem5 = new javax.swing.JTextField();
        btnPhanLoai5 = new javax.swing.JButton();
        CbPhanLoaiChucVu5 = new javax.swing.JComboBox<>();
        CbPhanLoaiCa5 = new javax.swing.JComboBox<>();
        jPanel13 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblDanhSachNV5 = new javax.swing.JTable();
        labelTongNv3 = new javax.swing.JLabel();
        btnLast3 = new javax.swing.JButton();
        btnNext3 = new javax.swing.JButton();
        btnPre3 = new javax.swing.JButton();
        btnFirst3 = new javax.swing.JButton();
        btnAdd3 = new javax.swing.JButton();
        btnRemove3 = new javax.swing.JButton();
        btnUpdate3 = new javax.swing.JButton();
        btnReset3 = new javax.swing.JButton();
        textNgayDau3 = new javax.swing.JTextField();
        jLabel51 = new javax.swing.JLabel();
        CbChucVu4 = new javax.swing.JComboBox<>();
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        textHoTen4 = new javax.swing.JTextField();
        textMa4 = new javax.swing.JTextField();
        jLabel63 = new javax.swing.JLabel();
        btnAvatar4 = new javax.swing.JButton();
        jLabel64 = new javax.swing.JLabel();
        textSoTK = new javax.swing.JTextField();
        textLuong = new javax.swing.JTextField();
        textNganHang = new javax.swing.JTextField();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản lí nhân viên");
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(0, 51, 102));
        jPanel1.setForeground(new java.awt.Color(51, 51, 255));

        btnDinnerTable.setBackground(new java.awt.Color(0, 51, 102));
        btnDinnerTable.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnDinnerTable.setForeground(new java.awt.Color(255, 255, 255));
        btnDinnerTable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dining-table.png"))); // NOI18N
        btnDinnerTable.setText("Bàn ăn");
        btnDinnerTable.setBorder(null);
        btnDinnerTable.setBorderPainted(false);
        btnDinnerTable.setContentAreaFilled(false);
        btnDinnerTable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDinnerTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDinnerTableActionPerformed(evt);
            }
        });

        btnOrder.setBackground(new java.awt.Color(0, 51, 102));
        btnOrder.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnOrder.setForeground(new java.awt.Color(255, 255, 255));
        btnOrder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/online-order.png"))); // NOI18N
        btnOrder.setText("Order");
        btnOrder.setBorder(null);
        btnOrder.setBorderPainted(false);
        btnOrder.setContentAreaFilled(false);
        btnOrder.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrderActionPerformed(evt);
            }
        });

        btnPay.setBackground(new java.awt.Color(0, 51, 102));
        btnPay.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnPay.setForeground(new java.awt.Color(255, 255, 255));
        btnPay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/pay.png"))); // NOI18N
        btnPay.setText("Thanh toán");
        btnPay.setBorder(null);
        btnPay.setBorderPainted(false);
        btnPay.setContentAreaFilled(false);
        btnPay.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPayActionPerformed(evt);
            }
        });

        btnConfirm.setBackground(new java.awt.Color(0, 51, 102));
        btnConfirm.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnConfirm.setForeground(new java.awt.Color(255, 255, 255));
        btnConfirm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/customer.png"))); // NOI18N
        btnConfirm.setText("Xác nhận món");
        btnConfirm.setBorder(null);
        btnConfirm.setBorderPainted(false);
        btnConfirm.setContentAreaFilled(false);
        btnConfirm.setCursor(new java.awt.Cursor(java.awt.Cursor.MOVE_CURSOR));
        btnConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmActionPerformed(evt);
            }
        });

        btnStaff.setBackground(new java.awt.Color(0, 51, 102));
        btnStaff.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnStaff.setForeground(new java.awt.Color(255, 255, 255));
        btnStaff.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/staff.png"))); // NOI18N
        btnStaff.setText("Nhân viên");
        btnStaff.setBorder(null);
        btnStaff.setBorderPainted(false);
        btnStaff.setContentAreaFilled(false);
        btnStaff.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnStaff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStaffActionPerformed(evt);
            }
        });

        btnClient.setBackground(new java.awt.Color(0, 51, 102));
        btnClient.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnClient.setForeground(new java.awt.Color(255, 255, 255));
        btnClient.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/client.png"))); // NOI18N
        btnClient.setText("Khách hàng");
        btnClient.setBorder(null);
        btnClient.setBorderPainted(false);
        btnClient.setContentAreaFilled(false);
        btnClient.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClientActionPerformed(evt);
            }
        });

        btnAccount.setBackground(new java.awt.Color(0, 51, 102));
        btnAccount.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAccount.setForeground(new java.awt.Color(255, 255, 255));
        btnAccount.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/settings.png"))); // NOI18N
        btnAccount.setText("Tài khoản");
        btnAccount.setBorder(null);
        btnAccount.setBorderPainted(false);
        btnAccount.setContentAreaFilled(false);
        btnAccount.setCursor(new java.awt.Cursor(java.awt.Cursor.MOVE_CURSOR));
        btnAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAccountActionPerformed(evt);
            }
        });

        btnOverview.setBackground(new java.awt.Color(0, 51, 102));
        btnOverview.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnOverview.setForeground(new java.awt.Color(255, 255, 255));
        btnOverview.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Home.png"))); // NOI18N
        btnOverview.setText("Tổng quan");
        btnOverview.setBorder(null);
        btnOverview.setBorderPainted(false);
        btnOverview.setContentAreaFilled(false);
        btnOverview.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnOverview.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOverviewActionPerformed(evt);
            }
        });

        btnCallTable.setBackground(new java.awt.Color(0, 51, 102));
        btnCallTable.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCallTable.setForeground(new java.awt.Color(255, 255, 255));
        btnCallTable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/phone-call.png"))); // NOI18N
        btnCallTable.setText("Đặt bàn");
        btnCallTable.setBorder(null);
        btnCallTable.setBorderPainted(false);
        btnCallTable.setContentAreaFilled(false);
        btnCallTable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCallTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCallTableActionPerformed(evt);
            }
        });

        btnReport.setBackground(new java.awt.Color(0, 51, 102));
        btnReport.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnReport.setForeground(new java.awt.Color(255, 255, 255));
        btnReport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Statistics.png"))); // NOI18N
        btnReport.setText("Báo cáo");
        btnReport.setBorder(null);
        btnReport.setBorderPainted(false);
        btnReport.setContentAreaFilled(false);
        btnReport.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportActionPerformed(evt);
            }
        });

        btnWarehouse.setBackground(new java.awt.Color(0, 51, 102));
        btnWarehouse.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnWarehouse.setForeground(new java.awt.Color(255, 255, 255));
        btnWarehouse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/man.png"))); // NOI18N
        btnWarehouse.setText("Kho hàng");
        btnWarehouse.setBorder(null);
        btnWarehouse.setBorderPainted(false);
        btnWarehouse.setContentAreaFilled(false);
        btnWarehouse.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnWarehouse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnWarehouseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnOverview, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnDinnerTable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnOrder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnConfirm, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
            .addComponent(btnPay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnCallTable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnReport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnWarehouse, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnStaff, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnClient, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnAccount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(labelLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(labelLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnOverview, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDinnerTable, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPay, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCallTable, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnReport, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnWarehouse, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnStaff, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnClient, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(67, Short.MAX_VALUE))
        );

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, new java.awt.Color(204, 204, 204), java.awt.Color.white));

        jLabel30.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel30.setText("Mì cay Sisan");

        jButton14.setBackground(new java.awt.Color(238, 238, 238));
        jButton14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/bell.png"))); // NOI18N
        jButton14.setBorder(null);
        jButton14.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        labelAccount.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        labelAccount.setText("TÀI KHOẢN: NGÔ KIM LONG");

        labelPosition.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        labelPosition.setText("CHỨC VỤ: QUẢN LÝ");

        labelHouse.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        labelHouse.setText("00:00:00");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel30)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 497, Short.MAX_VALUE)
                .addComponent(labelHouse)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelAccount)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelPosition)
                .addGap(18, 18, 18)
                .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelPosition, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(jButton14, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(labelHouse, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(labelAccount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTabbedPane1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jTabbedPane1.setInheritsPopupMenu(true);

        tblDanhSachNV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã", "Họ tên", "Giới tính", "Ngày sinh", "Chức vụ", "Ca", "Lương", "Trạng thái"
            }
        ));
        tblDanhSachNV.setShowGrid(false);
        jScrollPane1.setViewportView(tblDanhSachNV);
        if (tblDanhSachNV.getColumnModel().getColumnCount() > 0) {
            tblDanhSachNV.getColumnModel().getColumn(0).setPreferredWidth(50);
            tblDanhSachNV.getColumnModel().getColumn(1).setPreferredWidth(130);
        }

        btnTimKiem.setBackground(new java.awt.Color(0, 51, 102));
        btnTimKiem.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnTimKiem.setForeground(new java.awt.Color(255, 255, 255));
        btnTimKiem.setText("Tìm kiếm");
        btnTimKiem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        textTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textTimKiemActionPerformed(evt);
            }
        });

        CbPhanLoaiCa.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        CbPhanLoaiCa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất Cả Ca", "Ca1", "Ca2" }));
        CbPhanLoaiCa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CbPhanLoaiCa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CbPhanLoaiCaActionPerformed(evt);
            }
        });

        CbPhanLoaiChucVu.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        CbPhanLoaiChucVu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất Cả CV", "Quản Lý", "Phục Vụ", "Thu Ngân", "Đầu Bếp", "Kho" }));
        CbPhanLoaiChucVu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CbPhanLoaiChucVu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CbPhanLoaiChucVuActionPerformed(evt);
            }
        });

        btnPhanLoai.setBackground(new java.awt.Color(0, 51, 102));
        btnPhanLoai.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnPhanLoai.setForeground(new java.awt.Color(255, 255, 255));
        btnPhanLoai.setText("Phân loại");
        btnPhanLoai.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPhanLoai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPhanLoaiActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Mã:");

        textMa.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textMa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textMaActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Họ tên:");

        textHoTen.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textHoTen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textHoTenActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setText("Chức vụ:");

        CbChucVu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        CbChucVu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Quản Lý", "Phục Vụ", "Thu Ngân", "Đầu Bếp", "Kho" }));
        CbChucVu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CbChucVuActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel18.setText("Giới tính:");

        CbGioiTinh.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        CbGioiTinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ", "Khác" }));
        CbGioiTinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CbGioiTinhActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Ngày sinh:");

        textNgaySinh.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textNgaySinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textNgaySinhActionPerformed(evt);
            }
        });

        textMoTa.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textMoTa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textMoTaActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel17.setText("Email:");

        textEmail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textEmailActionPerformed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel20.setText("Sđt:");

        textSdt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textSdt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textSdtActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Địa chỉ:");

        textDiaChi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textDiaChi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textDiaChiActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel16.setText("Mô tả:");

        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel21.setText("Ngày đầu:");

        textNgayDau.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textNgayDau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textNgayDauActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel19.setText("Ca:");

        CbCa.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        CbCa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ca1", "Ca2" }));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setText("Trạng thái:");

        CbTrangThai.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        CbTrangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Đang Làm", "Xin Nghỉ", "Nghỉ Làm" }));
        CbTrangThai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CbTrangThaiActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setText("CMCD:");

        textCmnd.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textCmnd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textCmndActionPerformed(evt);
            }
        });

        btnAvatar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAvatar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAvatarActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel5.setText("Thông tin");

        labelTongNv.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelTongNv.setText("Tổng nhân viên:");

        btnLast.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnLast.setText(">|");
        btnLast.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLastActionPerformed(evt);
            }
        });

        btnNext.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnNext.setText(">>");
        btnNext.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        btnPre.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnPre.setText("<<");
        btnPre.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreActionPerformed(evt);
            }
        });

        btnFirst.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnFirst.setText("|<");
        btnFirst.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFirstActionPerformed(evt);
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

        btnReset.setBackground(new java.awt.Color(0, 51, 102));
        btnReset.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnReset.setForeground(new java.awt.Color(255, 255, 255));
        btnReset.setText("Hủy");
        btnReset.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        jPanel9.setBackground(new java.awt.Color(0, 51, 102));
        jPanel9.setPreferredSize(new java.awt.Dimension(6, 0));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 6, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnFirst, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnPre, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnLast, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(97, 97, 97)
                        .addComponent(labelTongNv, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 27, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnTimKiem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textTimKiem)
                        .addGap(18, 18, 18)
                        .addComponent(btnPhanLoai)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CbPhanLoaiChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CbPhanLoaiCa, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addGap(106, 106, 106)
                                    .addComponent(jLabel11)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(CbTrangThai, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addGap(10, 10, 10)
                                    .addComponent(CbChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel19)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(CbCa, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(4, 4, 4)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(textMoTa, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(textDiaChi, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(textSdt, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(textEmail, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(textNgayDau, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                            .addComponent(jLabel2)
                                            .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                            .addComponent(jLabel6)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(textMa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                                                .addComponent(textHoTen, javax.swing.GroupLayout.Alignment.TRAILING))))
                                    .addGap(10, 10, 10))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(btnAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(4, 4, 4)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(CbGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textNgaySinh)
                                    .addComponent(textCmnd)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(12, 12, 12)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textMa, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(10, 10, 10)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(btnAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CbChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CbCa, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CbGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CbTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textCmnd, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textSdt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textMoTa, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textNgayDau, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(CbPhanLoaiCa, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(CbPhanLoaiChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnPhanLoai, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPre, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLast, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFirst, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelTongNv, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 84, Short.MAX_VALUE))
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, 639, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Danh Sách", new javax.swing.ImageIcon(getClass().getResource("/icon/Closed folder.png")), jPanel3); // NOI18N

        btnTimKiem2.setBackground(new java.awt.Color(0, 51, 102));
        btnTimKiem2.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnTimKiem2.setForeground(new java.awt.Color(255, 255, 255));
        btnTimKiem2.setText("Tìm kiếm");
        btnTimKiem2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTimKiem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiem2ActionPerformed(evt);
            }
        });

        textTimKiem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textTimKiem2ActionPerformed(evt);
            }
        });

        btnPhanLoai2.setBackground(new java.awt.Color(0, 51, 102));
        btnPhanLoai2.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnPhanLoai2.setForeground(new java.awt.Color(255, 255, 255));
        btnPhanLoai2.setText("Phân loại");
        btnPhanLoai2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPhanLoai2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPhanLoai2ActionPerformed(evt);
            }
        });

        CbPhanLoaiChucVu2.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        CbPhanLoaiChucVu2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất Cả CV", "Quản Lý", "Phục Vụ", "Thu Ngân", "Đầu Bếp", "Kho" }));
        CbPhanLoaiChucVu2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CbPhanLoaiChucVu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CbPhanLoaiChucVu2ActionPerformed(evt);
            }
        });

        btnFirst1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnFirst1.setText("|<");
        btnFirst1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnFirst1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFirst1ActionPerformed(evt);
            }
        });

        btnPre1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnPre1.setText("<<");
        btnPre1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPre1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPre1ActionPerformed(evt);
            }
        });

        btnNext1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnNext1.setText(">>");
        btnNext1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNext1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNext1ActionPerformed(evt);
            }
        });

        btnLast1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnLast1.setText(">|");
        btnLast1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLast1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLast1ActionPerformed(evt);
            }
        });

        labelTongNv1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelTongNv1.setText("Tổng nhân viên:");

        jPanel10.setBackground(new java.awt.Color(0, 51, 102));
        jPanel10.setPreferredSize(new java.awt.Dimension(6, 0));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 6, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel13.setText("Thông tin");

        textMa2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textMa2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textMa2ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Mã:");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel14.setText("Họ tên:");

        textHoTen2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textHoTen2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textHoTen2ActionPerformed(evt);
            }
        });

        btnAvatar2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAvatar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAvatar2ActionPerformed(evt);
            }
        });

        CbChucVu2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        CbChucVu2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Quản Lý", "Phục Vụ", "Thu Ngân", "Đầu Bếp", "Kho" }));
        CbChucVu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CbChucVu2ActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel15.setText("Chức vụ:");

        btnAdd1.setBackground(new java.awt.Color(0, 51, 102));
        btnAdd1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAdd1.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd1.setText("Thêm");
        btnAdd1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAdd1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdd1ActionPerformed(evt);
            }
        });

        btnRemove1.setBackground(new java.awt.Color(0, 51, 102));
        btnRemove1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnRemove1.setForeground(new java.awt.Color(255, 255, 255));
        btnRemove1.setText("Xóa");
        btnRemove1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRemove1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemove1ActionPerformed(evt);
            }
        });

        btnUpdate1.setBackground(new java.awt.Color(0, 51, 102));
        btnUpdate1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnUpdate1.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdate1.setText("Sửa");
        btnUpdate1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUpdate1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdate1ActionPerformed(evt);
            }
        });

        btnReset1.setBackground(new java.awt.Color(0, 51, 102));
        btnReset1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnReset1.setForeground(new java.awt.Color(255, 255, 255));
        btnReset1.setText("Hủy");
        btnReset1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnReset1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReset1ActionPerformed(evt);
            }
        });

        tblDanhSachNV2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã", "Họ tên", "Chức vụ", "Tài khoản", "Mật khẩu", "Ngày tạo"
            }
        ));
        jScrollPane3.setViewportView(tblDanhSachNV2);

        textNgayTao.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textNgayTao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textNgayTaoActionPerformed(evt);
            }
        });

        textTaiKhoan.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textTaiKhoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textTaiKhoanActionPerformed(evt);
            }
        });

        textMatKhau.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textMatKhau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textMatKhauActionPerformed(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel22.setText("Mật khẩu:");

        jLabel23.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel23.setText("Tài khoản:");

        maTaiKhoan.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        maTaiKhoan.setText("Ngày tạo:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btnFirst1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnPre1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnNext1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnLast1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(97, 97, 97)
                        .addComponent(labelTongNv1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 27, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btnTimKiem2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textTimKiem2)
                        .addGap(18, 18, 18)
                        .addComponent(btnPhanLoai2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CbPhanLoaiChucVu2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(btnAdd1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnRemove1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnUpdate1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(btnReset1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel23, javax.swing.GroupLayout.Alignment.LEADING)))
                                    .addComponent(maTaiKhoan))
                                .addGap(7, 7, 7)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textMatKhau)
                                    .addComponent(textNgayTao, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(textTaiKhoan)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel14)
                                            .addComponent(jLabel4))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(textMa2, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(textHoTen2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(10, 10, 10))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel13)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addComponent(btnAvatar2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(CbChucVu2, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnTimKiem2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textTimKiem2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CbPhanLoaiChucVu2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnPhanLoai2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(19, 19, 19)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNext1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPre1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLast1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFirst1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelTongNv1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 85, Short.MAX_VALUE))
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, 639, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnAvatar2, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(12, 12, 12)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textMa2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textHoTen2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(10, 10, 10)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CbChucVu2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(maTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textNgayTao, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnReset1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdate1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRemove1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdd1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(80, 80, 80))
        );

        jTabbedPane1.addTab("Tài Khoản", new javax.swing.ImageIcon(getClass().getResource("/icon/Lock.png")), jPanel4); // NOI18N

        btnTimKiem4.setBackground(new java.awt.Color(0, 51, 102));
        btnTimKiem4.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnTimKiem4.setForeground(new java.awt.Color(255, 255, 255));
        btnTimKiem4.setText("Tìm kiếm");
        btnTimKiem4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTimKiem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiem4ActionPerformed(evt);
            }
        });

        textTimKiem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textTimKiem4ActionPerformed(evt);
            }
        });

        btnPhanLoai4.setBackground(new java.awt.Color(0, 51, 102));
        btnPhanLoai4.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnPhanLoai4.setForeground(new java.awt.Color(255, 255, 255));
        btnPhanLoai4.setText("Phân loại");
        btnPhanLoai4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPhanLoai4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPhanLoai4ActionPerformed(evt);
            }
        });

        CbPhanLoaiChucVu4.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        CbPhanLoaiChucVu4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất Cả CV", "Quản Lý", "Phục Vụ", "Thu Ngân", "Đầu Bếp", "Kho" }));
        CbPhanLoaiChucVu4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CbPhanLoaiChucVu4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CbPhanLoaiChucVu4ActionPerformed(evt);
            }
        });

        CbPhanLoaiCa4.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        CbPhanLoaiCa4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất Cả Ca", "Ca1", "Ca2" }));
        CbPhanLoaiCa4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CbPhanLoaiCa4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CbPhanLoaiCa4ActionPerformed(evt);
            }
        });

        tblDanhSachNV4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã", "Họ tên", "Giới tính", "Ngày sinh", "Chức vụ", "Ca", "Lương", "Trạng thái"
            }
        ));
        tblDanhSachNV4.setShowGrid(false);
        jScrollPane5.setViewportView(tblDanhSachNV4);
        if (tblDanhSachNV4.getColumnModel().getColumnCount() > 0) {
            tblDanhSachNV4.getColumnModel().getColumn(0).setPreferredWidth(50);
            tblDanhSachNV4.getColumnModel().getColumn(1).setPreferredWidth(130);
        }

        btnFirst2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnFirst2.setText("|<");
        btnFirst2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnFirst2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFirst2ActionPerformed(evt);
            }
        });

        btnPre2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnPre2.setText("<<");
        btnPre2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPre2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPre2ActionPerformed(evt);
            }
        });

        btnNext2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnNext2.setText(">>");
        btnNext2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNext2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNext2ActionPerformed(evt);
            }
        });

        btnLast2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnLast2.setText(">|");
        btnLast2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLast2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLast2ActionPerformed(evt);
            }
        });

        labelTongNv2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelTongNv2.setText("Tổng nhân viên:");

        jPanel12.setBackground(new java.awt.Color(0, 51, 102));
        jPanel12.setPreferredSize(new java.awt.Dimension(6, 0));

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 6, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel37.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel37.setText("Thông tin");

        textMa3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textMa3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textMa3ActionPerformed(evt);
            }
        });

        jLabel38.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel38.setText("Mã:");

        jLabel39.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel39.setText("Họ tên:");

        textHoTen3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textHoTen3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textHoTen3ActionPerformed(evt);
            }
        });

        btnAvatar3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAvatar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAvatar3ActionPerformed(evt);
            }
        });

        CbCa2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        CbCa2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ca1", "Ca2" }));

        CbChucVu3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        CbChucVu3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Quản Lý", "Phục Vụ", "Thu Ngân", "Đầu Bếp", "Kho" }));
        CbChucVu3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CbChucVu3ActionPerformed(evt);
            }
        });

        jLabel40.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel40.setText("Ca:");

        jLabel41.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel41.setText("Chức vụ:");

        jLabel42.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel42.setText("Giới tính:");

        CbGioiTinh2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        CbGioiTinh2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ", "Khác" }));
        CbGioiTinh2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CbGioiTinh2ActionPerformed(evt);
            }
        });

        jLabel43.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel43.setText("Trạng thái:");

        CbTrangThai2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        CbTrangThai2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Đang Làm", "Xin Nghỉ", "Nghỉ Làm" }));
        CbTrangThai2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CbTrangThai2ActionPerformed(evt);
            }
        });

        textNgaySinh2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textNgaySinh2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textNgaySinh2ActionPerformed(evt);
            }
        });

        jLabel44.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel44.setText("Ngày sinh:");

        jLabel45.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel45.setText("CMCD:");

        textCmnd2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textCmnd2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textCmnd2ActionPerformed(evt);
            }
        });

        jLabel46.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel46.setText("Email:");

        textEmail2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textEmail2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textEmail2ActionPerformed(evt);
            }
        });

        jLabel47.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel47.setText("Sđt:");

        textSdt2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textSdt2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textSdt2ActionPerformed(evt);
            }
        });

        jLabel48.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel48.setText("Địa chỉ:");

        textDiaChi2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textDiaChi2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textDiaChi2ActionPerformed(evt);
            }
        });

        jLabel49.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel49.setText("Mô tả:");

        textMoTa2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textMoTa2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textMoTa2ActionPerformed(evt);
            }
        });

        jLabel50.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel50.setText("Ngày đầu:");

        textNgayDau2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textNgayDau2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textNgayDau2ActionPerformed(evt);
            }
        });

        btnAdd2.setBackground(new java.awt.Color(0, 51, 102));
        btnAdd2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAdd2.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd2.setText("Thêm");
        btnAdd2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAdd2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdd2ActionPerformed(evt);
            }
        });

        btnRemove2.setBackground(new java.awt.Color(0, 51, 102));
        btnRemove2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnRemove2.setForeground(new java.awt.Color(255, 255, 255));
        btnRemove2.setText("Xóa");
        btnRemove2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRemove2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemove2ActionPerformed(evt);
            }
        });

        btnUpdate2.setBackground(new java.awt.Color(0, 51, 102));
        btnUpdate2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnUpdate2.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdate2.setText("Sửa");
        btnUpdate2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUpdate2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdate2ActionPerformed(evt);
            }
        });

        btnReset2.setBackground(new java.awt.Color(0, 51, 102));
        btnReset2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnReset2.setForeground(new java.awt.Color(255, 255, 255));
        btnReset2.setText("Hủy");
        btnReset2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnReset2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReset2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(btnFirst2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnPre2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnNext2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnLast2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(97, 97, 97)
                        .addComponent(labelTongNv2, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 27, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(btnTimKiem4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textTimKiem4)
                        .addGap(18, 18, 18)
                        .addComponent(btnPhanLoai4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CbPhanLoaiChucVu4, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CbPhanLoaiCa4, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel5Layout.createSequentialGroup()
                                    .addGap(106, 106, 106)
                                    .addComponent(jLabel43)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(CbTrangThai2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(jPanel5Layout.createSequentialGroup()
                                    .addGap(10, 10, 10)
                                    .addComponent(CbChucVu3, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel40)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(CbCa2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(4, 4, 4)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(textMoTa2, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(textDiaChi2, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(textSdt2, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(textEmail2, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(textNgayDau2, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel5Layout.createSequentialGroup()
                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel5Layout.createSequentialGroup()
                                            .addComponent(jLabel38)
                                            .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                            .addComponent(jLabel39)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(textMa3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                                                .addComponent(textHoTen3, javax.swing.GroupLayout.Alignment.TRAILING))))
                                    .addGap(10, 10, 10))
                                .addGroup(jPanel5Layout.createSequentialGroup()
                                    .addComponent(jLabel37)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(btnAvatar3, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(4, 4, 4)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(CbGioiTinh2, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textNgaySinh2)
                                    .addComponent(textCmnd2)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(btnAdd2, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnRemove2, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnUpdate2, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(btnReset2, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnTimKiem4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textTimKiem4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(CbPhanLoaiCa4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(CbPhanLoaiChucVu4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnPhanLoai4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel37)
                                .addGap(12, 12, 12)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textMa3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(10, 10, 10)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textHoTen3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(btnAvatar3, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CbChucVu3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CbCa2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CbGioiTinh2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CbTrangThai2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textNgaySinh2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textCmnd2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textEmail2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textSdt2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textDiaChi2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textMoTa2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textNgayDau2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnReset2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdate2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRemove2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdd2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNext2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPre2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLast2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFirst2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelTongNv2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 84, Short.MAX_VALUE))
            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, 639, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Lịch làm việc", new javax.swing.ImageIcon(getClass().getResource("/icon/Date.png")), jPanel5); // NOI18N

        btnTimKiem5.setBackground(new java.awt.Color(0, 51, 102));
        btnTimKiem5.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnTimKiem5.setForeground(new java.awt.Color(255, 255, 255));
        btnTimKiem5.setText("Tìm kiếm");
        btnTimKiem5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTimKiem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiem5ActionPerformed(evt);
            }
        });

        textTimKiem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textTimKiem5ActionPerformed(evt);
            }
        });

        btnPhanLoai5.setBackground(new java.awt.Color(0, 51, 102));
        btnPhanLoai5.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnPhanLoai5.setForeground(new java.awt.Color(255, 255, 255));
        btnPhanLoai5.setText("Phân loại");
        btnPhanLoai5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPhanLoai5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPhanLoai5ActionPerformed(evt);
            }
        });

        CbPhanLoaiChucVu5.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        CbPhanLoaiChucVu5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất Cả CV", "Quản Lý", "Phục Vụ", "Thu Ngân", "Đầu Bếp", "Kho" }));
        CbPhanLoaiChucVu5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CbPhanLoaiChucVu5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CbPhanLoaiChucVu5ActionPerformed(evt);
            }
        });

        CbPhanLoaiCa5.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        CbPhanLoaiCa5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất Cả Ca", "Ca1", "Ca2" }));
        CbPhanLoaiCa5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CbPhanLoaiCa5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CbPhanLoaiCa5ActionPerformed(evt);
            }
        });

        jPanel13.setBackground(new java.awt.Color(0, 51, 102));
        jPanel13.setPreferredSize(new java.awt.Dimension(6, 0));

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 6, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        tblDanhSachNV5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã", "Họ tên", "Giới tính", "Ngày sinh", "Chức vụ", "Ca", "Lương", "Trạng thái"
            }
        ));
        tblDanhSachNV5.setShowGrid(false);
        jScrollPane6.setViewportView(tblDanhSachNV5);
        if (tblDanhSachNV5.getColumnModel().getColumnCount() > 0) {
            tblDanhSachNV5.getColumnModel().getColumn(0).setPreferredWidth(50);
            tblDanhSachNV5.getColumnModel().getColumn(1).setPreferredWidth(130);
        }

        labelTongNv3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelTongNv3.setText("Tổng nhân viên:");

        btnLast3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnLast3.setText(">|");
        btnLast3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLast3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLast3ActionPerformed(evt);
            }
        });

        btnNext3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnNext3.setText(">>");
        btnNext3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNext3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNext3ActionPerformed(evt);
            }
        });

        btnPre3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnPre3.setText("<<");
        btnPre3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPre3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPre3ActionPerformed(evt);
            }
        });

        btnFirst3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnFirst3.setText("|<");
        btnFirst3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnFirst3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFirst3ActionPerformed(evt);
            }
        });

        btnAdd3.setBackground(new java.awt.Color(0, 51, 102));
        btnAdd3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAdd3.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd3.setText("Thêm");
        btnAdd3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAdd3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdd3ActionPerformed(evt);
            }
        });

        btnRemove3.setBackground(new java.awt.Color(0, 51, 102));
        btnRemove3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnRemove3.setForeground(new java.awt.Color(255, 255, 255));
        btnRemove3.setText("Xóa");
        btnRemove3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRemove3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemove3ActionPerformed(evt);
            }
        });

        btnUpdate3.setBackground(new java.awt.Color(0, 51, 102));
        btnUpdate3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnUpdate3.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdate3.setText("Sửa");
        btnUpdate3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUpdate3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdate3ActionPerformed(evt);
            }
        });

        btnReset3.setBackground(new java.awt.Color(0, 51, 102));
        btnReset3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnReset3.setForeground(new java.awt.Color(255, 255, 255));
        btnReset3.setText("Hủy");
        btnReset3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnReset3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReset3ActionPerformed(evt);
            }
        });

        textNgayDau3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textNgayDau3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textNgayDau3ActionPerformed(evt);
            }
        });

        jLabel51.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel51.setText("Ngày đầu:");

        CbChucVu4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        CbChucVu4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Quản Lý", "Phục Vụ", "Thu Ngân", "Đầu Bếp", "Kho" }));
        CbChucVu4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CbChucVu4ActionPerformed(evt);
            }
        });

        jLabel61.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel61.setText("Chức vụ:");

        jLabel62.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel62.setText("Họ tên:");

        textHoTen4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textHoTen4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textHoTen4ActionPerformed(evt);
            }
        });

        textMa4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textMa4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textMa4ActionPerformed(evt);
            }
        });

        jLabel63.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel63.setText("Mã:");

        btnAvatar4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAvatar4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAvatar4ActionPerformed(evt);
            }
        });

        jLabel64.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel64.setText("Thông tin");

        textSoTK.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textSoTK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textSoTKActionPerformed(evt);
            }
        });

        textLuong.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textLuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textLuongActionPerformed(evt);
            }
        });

        textNganHang.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textNganHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textNganHangActionPerformed(evt);
            }
        });

        jLabel52.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel52.setText("Lương:");

        jLabel53.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel53.setText("Ngân hàng:");

        jLabel54.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel54.setText("Số TK:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnFirst3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnPre3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnNext3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnLast3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(97, 97, 97)
                        .addComponent(labelTongNv3, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 27, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnTimKiem5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textTimKiem5)
                        .addGap(18, 18, 18)
                        .addComponent(btnPhanLoai5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CbPhanLoaiChucVu5, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CbPhanLoaiCa5, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel63)
                            .addComponent(jLabel62)
                            .addComponent(jLabel64))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAvatar4, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnAdd3, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnRemove3, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnUpdate3, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(btnReset3, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(textNgayDau3, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel53)
                            .addComponent(jLabel61, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(textNganHang, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                                    .addComponent(textSoTK)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(textMa4, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(textHoTen4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(textLuong)
                            .addComponent(CbChucVu4, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnTimKiem5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textTimKiem5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(CbPhanLoaiCa5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(CbPhanLoaiChucVu5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnPhanLoai5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel64)
                                .addGap(12, 12, 12)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel63, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textMa4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(10, 10, 10)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel62, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textHoTen4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(btnAvatar4, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel61, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CbChucVu4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel53, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textNganHang, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textSoTK, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textNgayDau3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnReset3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdate3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRemove3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdd3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNext3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPre3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLast3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFirst3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelTongNv3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 84, Short.MAX_VALUE))
            .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, 639, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Lương", new javax.swing.ImageIcon(getClass().getResource("/icon/Price list.png")), jPanel2); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1017, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, 0)
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTabbedPane1)))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void resetImagePath() {
        ImageIcon icon = new ImageIcon(imagePath);
        Image image = icon.getImage().getScaledInstance(94, 94, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(image);
        btnAvatar.setIcon(scaledIcon);
    }

    private void btnDinnerTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDinnerTableActionPerformed
        DiningTables chonBan = new DiningTables(userInfo);
        openFullScreenWindow(chonBan);
    }//GEN-LAST:event_btnDinnerTableActionPerformed

    private void btnOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrderActionPerformed
        Dishes monAn = new Dishes(userInfo);
        openFullScreenWindow(monAn);
    }//GEN-LAST:event_btnOrderActionPerformed

    private void btnPayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPayActionPerformed
        Bills hoaDon = new Bills(userInfo);
        openFullScreenWindow(hoaDon);
    }//GEN-LAST:event_btnPayActionPerformed

    private void btnConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmActionPerformed
        ConfirmDishes nvBep = new ConfirmDishes(userInfo);
        openFullScreenWindow(nvBep);
    }//GEN-LAST:event_btnConfirmActionPerformed

    private void btnStaffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStaffActionPerformed
        Employees1 qlnv = new Employees1(userInfo);
        openFullScreenWindow(qlnv);
    }//GEN-LAST:event_btnStaffActionPerformed

    private void btnClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClientActionPerformed
        //         TongQuan qlnv = new TongQuan();
        //        openFullScreenWindow(qlnv);
    }//GEN-LAST:event_btnClientActionPerformed

    private void btnAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAccountActionPerformed
        Accounts taiKhoan = new Accounts(userInfo);
        openFullScreenWindow(taiKhoan);
    }//GEN-LAST:event_btnAccountActionPerformed

    private void btnOverviewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOverviewActionPerformed
        Overview tongQuan = new Overview(userInfo);
        openFullScreenWindow(tongQuan);
    }//GEN-LAST:event_btnOverviewActionPerformed

    private void btnCallTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCallTableActionPerformed
        //        TongQuan overview = new TongQuan();
        //        openFullScreenWindow(overview);
    }//GEN-LAST:event_btnCallTableActionPerformed

    private void btnReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportActionPerformed
        //        TongQuan overview = new TongQuan();
        //        openFullScreenWindow(overview);
    }//GEN-LAST:event_btnReportActionPerformed

    private void btnWarehouseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnWarehouseActionPerformed
        Warehouse khoHang = new Warehouse(userInfo);
        openFullScreenWindow(khoHang);
    }//GEN-LAST:event_btnWarehouseActionPerformed

    private void textNganHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textNganHangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textNganHangActionPerformed

    private void textLuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textLuongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textLuongActionPerformed

    private void textSoTKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textSoTKActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textSoTKActionPerformed

    private void btnAvatar4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAvatar4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAvatar4ActionPerformed

    private void textMa4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textMa4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textMa4ActionPerformed

    private void textHoTen4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textHoTen4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textHoTen4ActionPerformed

    private void CbChucVu4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CbChucVu4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CbChucVu4ActionPerformed

    private void textNgayDau3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textNgayDau3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textNgayDau3ActionPerformed

    private void btnReset3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReset3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnReset3ActionPerformed

    private void btnUpdate3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdate3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnUpdate3ActionPerformed

    private void btnRemove3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemove3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRemove3ActionPerformed

    private void btnAdd3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdd3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAdd3ActionPerformed

    private void btnFirst3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirst3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnFirst3ActionPerformed

    private void btnPre3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPre3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPre3ActionPerformed

    private void btnNext3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNext3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNext3ActionPerformed

    private void btnLast3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLast3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLast3ActionPerformed

    private void CbPhanLoaiCa5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CbPhanLoaiCa5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CbPhanLoaiCa5ActionPerformed

    private void CbPhanLoaiChucVu5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CbPhanLoaiChucVu5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CbPhanLoaiChucVu5ActionPerformed

    private void btnPhanLoai5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPhanLoai5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPhanLoai5ActionPerformed

    private void textTimKiem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textTimKiem5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textTimKiem5ActionPerformed

    private void btnTimKiem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiem5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTimKiem5ActionPerformed

    private void btnReset2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReset2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnReset2ActionPerformed

    private void btnUpdate2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdate2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnUpdate2ActionPerformed

    private void btnRemove2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemove2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRemove2ActionPerformed

    private void btnAdd2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdd2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAdd2ActionPerformed

    private void textNgayDau2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textNgayDau2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textNgayDau2ActionPerformed

    private void textMoTa2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textMoTa2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textMoTa2ActionPerformed

    private void textDiaChi2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textDiaChi2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textDiaChi2ActionPerformed

    private void textSdt2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textSdt2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textSdt2ActionPerformed

    private void textEmail2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textEmail2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textEmail2ActionPerformed

    private void textCmnd2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textCmnd2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textCmnd2ActionPerformed

    private void textNgaySinh2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textNgaySinh2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textNgaySinh2ActionPerformed

    private void CbTrangThai2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CbTrangThai2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CbTrangThai2ActionPerformed

    private void CbGioiTinh2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CbGioiTinh2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CbGioiTinh2ActionPerformed

    private void CbChucVu3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CbChucVu3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CbChucVu3ActionPerformed

    private void btnAvatar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAvatar3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAvatar3ActionPerformed

    private void textHoTen3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textHoTen3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textHoTen3ActionPerformed

    private void textMa3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textMa3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textMa3ActionPerformed

    private void btnLast2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLast2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLast2ActionPerformed

    private void btnNext2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNext2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNext2ActionPerformed

    private void btnPre2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPre2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPre2ActionPerformed

    private void btnFirst2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirst2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnFirst2ActionPerformed

    private void CbPhanLoaiCa4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CbPhanLoaiCa4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CbPhanLoaiCa4ActionPerformed

    private void CbPhanLoaiChucVu4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CbPhanLoaiChucVu4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CbPhanLoaiChucVu4ActionPerformed

    private void btnPhanLoai4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPhanLoai4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPhanLoai4ActionPerformed

    private void textTimKiem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textTimKiem4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textTimKiem4ActionPerformed

    private void btnTimKiem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiem4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTimKiem4ActionPerformed

    private void btnReset1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReset1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnReset1ActionPerformed

    private void btnUpdate1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdate1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnUpdate1ActionPerformed

    private void btnRemove1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemove1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRemove1ActionPerformed

    private void btnAdd1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdd1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAdd1ActionPerformed

    private void CbChucVu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CbChucVu2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CbChucVu2ActionPerformed

    private void btnAvatar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAvatar2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAvatar2ActionPerformed

    private void textHoTen2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textHoTen2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textHoTen2ActionPerformed

    private void textMa2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textMa2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textMa2ActionPerformed

    private void btnLast1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLast1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLast1ActionPerformed

    private void btnNext1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNext1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNext1ActionPerformed

    private void btnPre1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPre1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPre1ActionPerformed

    private void btnFirst1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirst1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnFirst1ActionPerformed

    private void CbPhanLoaiChucVu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CbPhanLoaiChucVu2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CbPhanLoaiChucVu2ActionPerformed

    private void btnPhanLoai2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPhanLoai2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPhanLoai2ActionPerformed

    private void textTimKiem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textTimKiem2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textTimKiem2ActionPerformed

    private void btnTimKiem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiem2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTimKiem2ActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        resetFields();
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        updateEmployee();
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        updateEmployeeStatusSoft();
    }//GEN-LAST:event_btnRemoveActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        try {
            addEmployee();
        } catch (ParseException ex) {
            Logger.getLogger(Employees1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirstActionPerformed
        currentIndex = 0;
        displayCurrentEmployee(currentIndex > 0 ? currentIndex - 1 : 0);
        tblDanhSachNV.setRowSelectionInterval(currentIndex, currentIndex);
    }//GEN-LAST:event_btnFirstActionPerformed

    private void btnPreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreActionPerformed
        currentIndex--;

        if (currentIndex < 0) {
            return;
        }

        if (currentIndex >= tblDanhSachNV.getRowCount()) {
            currentIndex = tblDanhSachNV.getRowCount() - 1;
        }

        displayCurrentEmployee(currentIndex);
        tblDanhSachNV.setRowSelectionInterval(currentIndex, currentIndex);
    }//GEN-LAST:event_btnPreActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        currentIndex++;
        if (currentIndex >= employeeList.size()) {
            currentIndex = employeeList.size() - 1;
        }

        displayCurrentEmployee(currentIndex);
        tblDanhSachNV.setRowSelectionInterval(currentIndex, currentIndex);
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLastActionPerformed
        currentIndex = employeeList.size() - 1;
        displayCurrentEmployee(currentIndex);
        tblDanhSachNV.setRowSelectionInterval(currentIndex, currentIndex);
    }//GEN-LAST:event_btnLastActionPerformed

    private void btnAvatarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAvatarActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));

        int result = fileChooser.showOpenDialog(this);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();// Chọn
            imagePath = selectedFile.getAbsolutePath(); // Lưu đường dẫn ảnh đã chọn
            resetImagePath();
        }
    }//GEN-LAST:event_btnAvatarActionPerformed

    private void textCmndActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textCmndActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textCmndActionPerformed

    private void CbTrangThaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CbTrangThaiActionPerformed

    }//GEN-LAST:event_CbTrangThaiActionPerformed

    private void textNgayDauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textNgayDauActionPerformed

    }//GEN-LAST:event_textNgayDauActionPerformed

    private void textDiaChiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textDiaChiActionPerformed

    }//GEN-LAST:event_textDiaChiActionPerformed

    private void textSdtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textSdtActionPerformed

    }//GEN-LAST:event_textSdtActionPerformed

    private void textEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textEmailActionPerformed

    }//GEN-LAST:event_textEmailActionPerformed

    private void textMoTaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textMoTaActionPerformed

    }//GEN-LAST:event_textMoTaActionPerformed

    private void textNgaySinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textNgaySinhActionPerformed

    }//GEN-LAST:event_textNgaySinhActionPerformed

    private void CbGioiTinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CbGioiTinhActionPerformed

    }//GEN-LAST:event_CbGioiTinhActionPerformed

    private void CbChucVuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CbChucVuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CbChucVuActionPerformed

    private void textHoTenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textHoTenActionPerformed

    }//GEN-LAST:event_textHoTenActionPerformed

    private void textMaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textMaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textMaActionPerformed

    private void btnPhanLoaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPhanLoaiActionPerformed

    }//GEN-LAST:event_btnPhanLoaiActionPerformed

    private void CbPhanLoaiChucVuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CbPhanLoaiChucVuActionPerformed
        String keyword = textTimKiem.getText().trim();
        String selectedPhanLoaiChucVu = (String) CbPhanLoaiChucVu.getSelectedItem();
        String selectedPhanLoaiCa = (String) CbPhanLoaiCa.getSelectedItem();

        searchAndClassifyEmployee(keyword, selectedPhanLoaiChucVu, selectedPhanLoaiCa, (DefaultTableModel) tblDanhSachNV.getModel());
    }//GEN-LAST:event_CbPhanLoaiChucVuActionPerformed

    private void CbPhanLoaiCaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CbPhanLoaiCaActionPerformed
        String keyword = textTimKiem.getText().trim();
        String selectedPhanLoaiChucVu = (String) CbPhanLoaiChucVu.getSelectedItem();
        String selectedPhanLoaiCa = (String) CbPhanLoaiCa.getSelectedItem();

        searchAndClassifyEmployee(keyword, selectedPhanLoaiChucVu, selectedPhanLoaiCa, (DefaultTableModel) tblDanhSachNV.getModel());
    }//GEN-LAST:event_CbPhanLoaiCaActionPerformed

    private void textTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textTimKiemActionPerformed
        String keyword = textTimKiem.getText().trim();
        String selectedPhanLoaiChucVu = (String) CbPhanLoaiChucVu.getSelectedItem();
        String selectedPhanLoaiCa = (String) CbPhanLoaiCa.getSelectedItem();

        searchAndClassifyEmployee(keyword, selectedPhanLoaiChucVu, selectedPhanLoaiCa, (DefaultTableModel) tblDanhSachNV.getModel());
    }//GEN-LAST:event_textTimKiemActionPerformed

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        String keyword = textTimKiem.getText().trim();
        String selectedPhanLoaiChucVu = (String) CbPhanLoaiChucVu.getSelectedItem();
        String selectedPhanLoaiCa = (String) CbPhanLoaiCa.getSelectedItem();

        searchAndClassifyEmployee(keyword, selectedPhanLoaiChucVu, selectedPhanLoaiCa, (DefaultTableModel) tblDanhSachNV.getModel());
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void textNgayTaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textNgayTaoActionPerformed

    }//GEN-LAST:event_textNgayTaoActionPerformed

    private void textTaiKhoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textTaiKhoanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textTaiKhoanActionPerformed

    private void textMatKhauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textMatKhauActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textMatKhauActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Employees1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            Map<String, String> userInfo = new HashMap<>();
            userInfo.put("hoTen", "YourName");
            userInfo.put("chucVu", "YourPosition");

            Employees1 nv = new Employees1(userInfo);
            nv.setExtendedState(JFrame.MAXIMIZED_BOTH); // Mở toàn màn hình
            nv.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CbCa;
    private javax.swing.JComboBox<String> CbCa2;
    private javax.swing.JComboBox<String> CbChucVu;
    private javax.swing.JComboBox<String> CbChucVu2;
    private javax.swing.JComboBox<String> CbChucVu3;
    private javax.swing.JComboBox<String> CbChucVu4;
    private javax.swing.JComboBox<String> CbGioiTinh;
    private javax.swing.JComboBox<String> CbGioiTinh2;
    private javax.swing.JComboBox<String> CbPhanLoaiCa;
    private javax.swing.JComboBox<String> CbPhanLoaiCa4;
    private javax.swing.JComboBox<String> CbPhanLoaiCa5;
    private javax.swing.JComboBox<String> CbPhanLoaiChucVu;
    private javax.swing.JComboBox<String> CbPhanLoaiChucVu2;
    private javax.swing.JComboBox<String> CbPhanLoaiChucVu4;
    private javax.swing.JComboBox<String> CbPhanLoaiChucVu5;
    private javax.swing.JComboBox<String> CbTrangThai;
    private javax.swing.JComboBox<String> CbTrangThai2;
    private javax.swing.JButton btnAccount;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnAdd1;
    private javax.swing.JButton btnAdd2;
    private javax.swing.JButton btnAdd3;
    private javax.swing.JButton btnAvatar;
    private javax.swing.JButton btnAvatar2;
    private javax.swing.JButton btnAvatar3;
    private javax.swing.JButton btnAvatar4;
    private javax.swing.JButton btnCallTable;
    private javax.swing.JButton btnClient;
    private javax.swing.JButton btnConfirm;
    private javax.swing.JButton btnDinnerTable;
    private javax.swing.JButton btnFirst;
    private javax.swing.JButton btnFirst1;
    private javax.swing.JButton btnFirst2;
    private javax.swing.JButton btnFirst3;
    private javax.swing.JButton btnLast;
    private javax.swing.JButton btnLast1;
    private javax.swing.JButton btnLast2;
    private javax.swing.JButton btnLast3;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnNext1;
    private javax.swing.JButton btnNext2;
    private javax.swing.JButton btnNext3;
    private javax.swing.JButton btnOrder;
    private javax.swing.JButton btnOverview;
    private javax.swing.JButton btnPay;
    private javax.swing.JButton btnPhanLoai;
    private javax.swing.JButton btnPhanLoai2;
    private javax.swing.JButton btnPhanLoai4;
    private javax.swing.JButton btnPhanLoai5;
    private javax.swing.JButton btnPre;
    private javax.swing.JButton btnPre1;
    private javax.swing.JButton btnPre2;
    private javax.swing.JButton btnPre3;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnRemove1;
    private javax.swing.JButton btnRemove2;
    private javax.swing.JButton btnRemove3;
    private javax.swing.JButton btnReport;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnReset1;
    private javax.swing.JButton btnReset2;
    private javax.swing.JButton btnReset3;
    private javax.swing.JButton btnStaff;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnTimKiem2;
    private javax.swing.JButton btnTimKiem4;
    private javax.swing.JButton btnTimKiem5;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btnUpdate1;
    private javax.swing.JButton btnUpdate2;
    private javax.swing.JButton btnUpdate3;
    private javax.swing.JButton btnWarehouse;
    private javax.swing.JButton jButton14;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel labelAccount;
    private javax.swing.JLabel labelHouse;
    private javax.swing.JLabel labelLogo;
    private javax.swing.JLabel labelPosition;
    private javax.swing.JLabel labelTongNv;
    private javax.swing.JLabel labelTongNv1;
    private javax.swing.JLabel labelTongNv2;
    private javax.swing.JLabel labelTongNv3;
    private javax.swing.JLabel maTaiKhoan;
    private javax.swing.JTable tblDanhSachNV;
    private javax.swing.JTable tblDanhSachNV2;
    private javax.swing.JTable tblDanhSachNV4;
    private javax.swing.JTable tblDanhSachNV5;
    private javax.swing.JTextField textCmnd;
    private javax.swing.JTextField textCmnd2;
    private javax.swing.JTextField textDiaChi;
    private javax.swing.JTextField textDiaChi2;
    private javax.swing.JTextField textEmail;
    private javax.swing.JTextField textEmail2;
    private javax.swing.JTextField textHoTen;
    private javax.swing.JTextField textHoTen2;
    private javax.swing.JTextField textHoTen3;
    private javax.swing.JTextField textHoTen4;
    private javax.swing.JTextField textLuong;
    private javax.swing.JTextField textMa;
    private javax.swing.JTextField textMa2;
    private javax.swing.JTextField textMa3;
    private javax.swing.JTextField textMa4;
    private javax.swing.JTextField textMatKhau;
    private javax.swing.JTextField textMoTa;
    private javax.swing.JTextField textMoTa2;
    private javax.swing.JTextField textNganHang;
    private javax.swing.JTextField textNgayDau;
    private javax.swing.JTextField textNgayDau2;
    private javax.swing.JTextField textNgayDau3;
    private javax.swing.JTextField textNgaySinh;
    private javax.swing.JTextField textNgaySinh2;
    private javax.swing.JTextField textNgayTao;
    private javax.swing.JTextField textSdt;
    private javax.swing.JTextField textSdt2;
    private javax.swing.JTextField textSoTK;
    private javax.swing.JTextField textTaiKhoan;
    private javax.swing.JTextField textTimKiem;
    private javax.swing.JTextField textTimKiem2;
    private javax.swing.JTextField textTimKiem4;
    private javax.swing.JTextField textTimKiem5;
    // End of variables declaration//GEN-END:variables
}
