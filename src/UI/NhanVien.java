package UI;

import javax.swing.JFrame;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import DAO.NhanVienDAO;
import static DAO.NhanVienDAO.isIdExists;
import static DAO.NhanVienDAO.searchAndClassifyEmployee;

import Entity.NhanVienEntity;
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

public class NhanVien extends javax.swing.JFrame {

    Map<String, String> userInfo = CommonUtils.getUserInfo();
    private String imagePath;
    private int currentIndex = 0;
    private List<NhanVienEntity> employeeList;

    public NhanVien(Map<String, String> userInfo) {
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
        employeeList = NhanVienDAO.getAllEmployees();
    }

    private void loadDataIntoTable() {
        DefaultTableModel model = (DefaultTableModel) tblDanhSachNV.getModel();
        model.setRowCount(0);

        try {
            Connection conn = NhanVienDAO.getConnection();

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

        NhanVienEntity employee = NhanVienDAO.viewEmployeeDetails(idNhanVien);

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

        NhanVienDAO.insertEmployee(idNhanVien, idCa, hoTen, gioiTinh, sdt, ngaySinh, cmnd, email, diaChi, hinhAnh,
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

        NhanVienDAO.updateEmployee(idNhanVien, idCa, newHoTen, newChucVu, newLuong,
                newGioiTinh, newSdt, newNgaySinh, newCmnd, newEmail, newDiaChi,
                newHinhAnhPath, newMoTa, newNganHang, newSoTaiKhoan, newTrangThai);

        loadDataIntoTable();
    }

    private void updateEmployeeStatusSoft() {
        String idNhanVien = textMa.getText();

        NhanVienDAO.updateEmployeeStatus(idNhanVien, "Nghỉ Việc");

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
            NhanVienEntity employee = employeeList.get(index);
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

        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        textTimKiem = new javax.swing.JTextField();
        btnTimKiem = new javax.swing.JButton();
        btnPhanLoai = new javax.swing.JButton();
        CbPhanLoaiCa = new javax.swing.JComboBox<>();
        btnReset = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        textMa = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        textHoTen = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDanhSachNV = new javax.swing.JTable();
        btnAvatar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        textDiaChi = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        CbChucVu = new javax.swing.JComboBox<>();
        textNgaySinh = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        CbTrangThai = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        textCmnd = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        textLuong = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        textNganHang = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        textSoTK = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        textMoTa = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        CbGioiTinh = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        textEmail = new javax.swing.JTextField();
        textSdt = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        textNgayDau = new javax.swing.JTextField();
        CbPhanLoaiChucVu = new javax.swing.JComboBox<>();
        CbCa = new javax.swing.JComboBox<>();
        jLabel19 = new javax.swing.JLabel();
        btnFirst = new javax.swing.JButton();
        btnPre = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        btnLast = new javax.swing.JButton();
        labelTongNv = new javax.swing.JLabel();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản lí nhân viên");
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(0, 51, 102));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 678, Short.MAX_VALUE)
        );

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        jLabel4.setText("Danh sách nhân viên");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setText("Thông tin");

        textTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textTimKiemActionPerformed(evt);
            }
        });

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

        CbPhanLoaiCa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất Cả Ca", "Ca1", "Ca2" }));
        CbPhanLoaiCa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CbPhanLoaiCa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CbPhanLoaiCaActionPerformed(evt);
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

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Mã:");

        textMa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textMaActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Họ tên:");

        textHoTen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textHoTenActionPerformed(evt);
            }
        });

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
        jScrollPane1.setViewportView(tblDanhSachNV);
        if (tblDanhSachNV.getColumnModel().getColumnCount() > 0) {
            tblDanhSachNV.getColumnModel().getColumn(0).setPreferredWidth(50);
            tblDanhSachNV.getColumnModel().getColumn(1).setPreferredWidth(130);
        }

        btnAvatar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAvatar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAvatarActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Địa chỉ:");

        textDiaChi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textDiaChiActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Ngày sinh:");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setText("Chức vụ:");

        CbChucVu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Quản Lý", "Phục Vụ", "Thu Ngân", "Đầu Bếp", "Kho" }));
        CbChucVu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CbChucVuActionPerformed(evt);
            }
        });

        textNgaySinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textNgaySinhActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setText("Trạng thái:");

        CbTrangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Đang Làm", "Xin Nghỉ", "Nghỉ Làm" }));
        CbTrangThai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CbTrangThaiActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setText("CMCD:");

        textCmnd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textCmndActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setText("Lương:");

        textLuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textLuongActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel14.setText("Ngân hàng:");

        textNganHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textNganHangActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel15.setText("Số TK:");

        textSoTK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textSoTKActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel16.setText("Mô tả:");

        textMoTa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textMoTaActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel18.setText("Giới tính:");

        CbGioiTinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ", "Khác" }));
        CbGioiTinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CbGioiTinhActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel17.setText("Email:");

        textEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textEmailActionPerformed(evt);
            }
        });

        textSdt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textSdtActionPerformed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel20.setText("Sđt:");

        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel21.setText("Ngày đầu:");

        textNgayDau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textNgayDauActionPerformed(evt);
            }
        });

        CbPhanLoaiChucVu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất Cả CV", "Quản Lý", "Phục Vụ", "Thu Ngân", "Đầu Bếp", "Kho" }));
        CbPhanLoaiChucVu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CbPhanLoaiChucVu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CbPhanLoaiChucVuActionPerformed(evt);
            }
        });

        CbCa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ca1", "Ca2" }));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel19.setText("Ca:");

        btnFirst.setText("|<");
        btnFirst.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFirstActionPerformed(evt);
            }
        });

        btnPre.setText("<<");
        btnPre.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreActionPerformed(evt);
            }
        });

        btnNext.setText(">>");
        btnNext.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        btnLast.setText(">|");
        btnLast.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLastActionPerformed(evt);
            }
        });

        labelTongNv.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelTongNv.setText("Tổng nhân viên:");

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(textTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnPhanLoai)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(CbPhanLoaiChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(CbPhanLoaiCa, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(btnFirst, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnPre, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnLast, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(labelTongNv, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 610, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(20, 20, 20)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel5)
                                        .addGap(0, 1, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(20, 20, 20)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
                                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel14)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(textMa, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnAvatar, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE))
                                    .addComponent(textHoTen, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textNgayDau, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textMoTa, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textSoTK, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textNganHang, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textLuong, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textDiaChi, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textSdt, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textEmail, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(CbChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel19))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(CbGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(textNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(0, 0, 0)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(jLabel11)
                                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(CbTrangThai, javax.swing.GroupLayout.Alignment.LEADING, 0, 122, Short.MAX_VALUE)
                                            .addComponent(CbCa, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(textCmnd)))))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(30, 30, 30))
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jLabel4)
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(textTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnPhanLoai, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(CbPhanLoaiCa, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(CbPhanLoaiChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(20, 20, 20)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(14, 14, 14)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelTongNv, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnPre, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnLast, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnFirst, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(btnAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(textMa, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(7, 7, 7)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(CbCa, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(CbChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(CbGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(CbTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textCmnd, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(textSdt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textNganHang, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textSoTK, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textMoTa, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textNgayDau, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPhanLoaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPhanLoaiActionPerformed

    }//GEN-LAST:event_btnPhanLoaiActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        resetFields();
    }//GEN-LAST:event_btnResetActionPerformed

    private void textHoTenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textHoTenActionPerformed
    }//GEN-LAST:event_textHoTenActionPerformed

    private void textDiaChiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textDiaChiActionPerformed
    }//GEN-LAST:event_textDiaChiActionPerformed

    private void textNgaySinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textNgaySinhActionPerformed
    }//GEN-LAST:event_textNgaySinhActionPerformed

    private void CbTrangThaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CbTrangThaiActionPerformed
    }//GEN-LAST:event_CbTrangThaiActionPerformed

    private void textLuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textLuongActionPerformed
    }//GEN-LAST:event_textLuongActionPerformed

    private void textSoTKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textSoTKActionPerformed
    }//GEN-LAST:event_textSoTKActionPerformed

    private void textMoTaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textMoTaActionPerformed
    }//GEN-LAST:event_textMoTaActionPerformed

    private void CbGioiTinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CbGioiTinhActionPerformed
    }//GEN-LAST:event_CbGioiTinhActionPerformed

    private void textEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textEmailActionPerformed
    }//GEN-LAST:event_textEmailActionPerformed

    private void textSdtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textSdtActionPerformed
    }//GEN-LAST:event_textSdtActionPerformed

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

    private void resetImagePath() {
        ImageIcon icon = new ImageIcon(imagePath);
        Image image = icon.getImage().getScaledInstance(94, 94, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(image);
        btnAvatar.setIcon(scaledIcon);
    }

    private void textNgayDauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textNgayDauActionPerformed
    }//GEN-LAST:event_textNgayDauActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        try {
            addEmployee();
        } catch (ParseException ex) {
            Logger.getLogger(NhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        updateEmployee();
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        updateEmployeeStatusSoft();
    }//GEN-LAST:event_btnRemoveActionPerformed

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

    private void textMaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textMaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textMaActionPerformed

    private void btnDinnerTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDinnerTableActionPerformed
        BanAn chonBan = new BanAn(userInfo);
        openFullScreenWindow(chonBan);
    }//GEN-LAST:event_btnDinnerTableActionPerformed

    private void btnOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrderActionPerformed
        MonAn monAn = new MonAn(userInfo);
        openFullScreenWindow(monAn);
    }//GEN-LAST:event_btnOrderActionPerformed

    private void btnPayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPayActionPerformed
        HoaDon hoaDon = new HoaDon(userInfo);
        openFullScreenWindow(hoaDon);
    }//GEN-LAST:event_btnPayActionPerformed

    private void btnConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmActionPerformed
        Bep nvBep = new Bep(userInfo);
        openFullScreenWindow(nvBep);
    }//GEN-LAST:event_btnConfirmActionPerformed

    private void btnStaffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStaffActionPerformed
        NhanVien qlnv = new NhanVien(userInfo);
        openFullScreenWindow(qlnv);
    }//GEN-LAST:event_btnStaffActionPerformed

    private void btnClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClientActionPerformed
        //         TongQuan qlnv = new TongQuan();
        //        openFullScreenWindow(qlnv);
    }//GEN-LAST:event_btnClientActionPerformed

    private void btnAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAccountActionPerformed
        TaiKhoan taiKhoan = new TaiKhoan(userInfo);
        openFullScreenWindow(taiKhoan);
    }//GEN-LAST:event_btnAccountActionPerformed

    private void btnOverviewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOverviewActionPerformed
        TongQuan tongQuan = new TongQuan(userInfo);
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
        KhoHang khoHang = new KhoHang(userInfo);
        openFullScreenWindow(khoHang);
    }//GEN-LAST:event_btnWarehouseActionPerformed

    private void textCmndActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textCmndActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textCmndActionPerformed

    private void textNganHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textNganHangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textNganHangActionPerformed

    private void CbChucVuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CbChucVuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CbChucVuActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            Map<String, String> userInfo = new HashMap<>();
            userInfo.put("hoTen", "YourName");
            userInfo.put("chucVu", "YourPosition");

            NhanVien nv = new NhanVien(userInfo);
            nv.setExtendedState(JFrame.MAXIMIZED_BOTH); // Mở toàn màn hình
            nv.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CbCa;
    private javax.swing.JComboBox<String> CbChucVu;
    private javax.swing.JComboBox<String> CbGioiTinh;
    private javax.swing.JComboBox<String> CbPhanLoaiCa;
    private javax.swing.JComboBox<String> CbPhanLoaiChucVu;
    private javax.swing.JComboBox<String> CbTrangThai;
    private javax.swing.JButton btnAccount;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnAvatar;
    private javax.swing.JButton btnCallTable;
    private javax.swing.JButton btnClient;
    private javax.swing.JButton btnConfirm;
    private javax.swing.JButton btnDinnerTable;
    private javax.swing.JButton btnFirst;
    private javax.swing.JButton btnLast;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnOrder;
    private javax.swing.JButton btnOverview;
    private javax.swing.JButton btnPay;
    private javax.swing.JButton btnPhanLoai;
    private javax.swing.JButton btnPre;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnReport;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnStaff;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnUpdate;
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
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelAccount;
    private javax.swing.JLabel labelHouse;
    private javax.swing.JLabel labelLogo;
    private javax.swing.JLabel labelPosition;
    private javax.swing.JLabel labelTongNv;
    private javax.swing.JTable tblDanhSachNV;
    private javax.swing.JTextField textCmnd;
    private javax.swing.JTextField textDiaChi;
    private javax.swing.JTextField textEmail;
    private javax.swing.JTextField textHoTen;
    private javax.swing.JTextField textLuong;
    private javax.swing.JTextField textMa;
    private javax.swing.JTextField textMoTa;
    private javax.swing.JTextField textNganHang;
    private javax.swing.JTextField textNgayDau;
    private javax.swing.JTextField textNgaySinh;
    private javax.swing.JTextField textSdt;
    private javax.swing.JTextField textSoTK;
    private javax.swing.JTextField textTimKiem;
    // End of variables declaration//GEN-END:variables

    void setUserInfo(Map<String, String> userInfo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
