package restaurant.utils;

import java.awt.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.plaf.basic.BasicScrollBarUI;

public class Common {

    // Get info user
    private static Map<String, String> userInfo;

    public static Map<String, String> getUserInfo() {
        if (userInfo == null) {
            userInfo = new HashMap<>();
        }
        return userInfo;
    }

    // Set info user
    public static void setUserInfo(Map<String, String> newUserInfo) {
        userInfo = newUserInfo;
    }

    // Display user info on bar
    public static void displayUserInfoBar(Map<String, String> userInfo, JLabel labelAccount, JLabel labelPosition) {
        if (userInfo != null && userInfo.containsKey("hoTen") && userInfo.containsKey("chucVu")) {
            String hoTen = userInfo.get("hoTen");
            String chucVu = userInfo.get("chucVu");

            labelAccount.setText("Tài khoản: " + hoTen);
            labelPosition.setText("Chức vụ: " + chucVu);
        }
    }

    // Display user name
    public static void displayUserName(Map<String, String> userInfo, JLabel name) {
        if (userInfo != null && userInfo.containsKey("hoTen") && userInfo.containsKey("chucVu")) {
            String hoTen = userInfo.get("hoTen");
            name.setText(hoTen);
        }
    }

    // Hàm chung để tùy chỉnh bảng
    public static void customizeTable(JTable table, int[] columnsNotCentered) {
        // Thiết lập Renderer cho tiêu đề
        DefaultTableCellRenderer headerRenderer = (DefaultTableCellRenderer) table.getTableHeader().getDefaultRenderer();
        headerRenderer.setHorizontalAlignment(SwingConstants.CENTER); // Căn giữa tiêu đề
        headerRenderer.setBackground(Color.LIGHT_GRAY); // Màu nền cho tiêu đề
        headerRenderer.setForeground(Color.BLACK); // Màu chữ cho tiêu đề

        // Thiết lập cỡ chữ cho tiêu đề bảng
        Font font = new Font("Be Vietnam Pro", Font.PLAIN, 14);
        table.getTableHeader().setFont(font);

        // Thiết lập Renderer cho nội dung các cột (trừ cột số 2)
        DefaultTableCellRenderer contentRenderer = new DefaultTableCellRenderer();
        contentRenderer.setHorizontalAlignment(SwingConstants.CENTER); // Căn giữa nội dung
        for (int i = 0; i < table.getColumnCount(); i++) {
            boolean isCentered = true;
            for (int column : columnsNotCentered) {
                if (i == column) {
                    isCentered = false;
                    break;
                }
            }
            if (isCentered) {
                table.getColumnModel().getColumn(i).setCellRenderer(contentRenderer);
            }
        }
    }

    // Update clock
    public static void initClock(JLabel labelHouse) {
        Timer timer = new Timer(1000, e -> updateClock(labelHouse));
        timer.start();
    }

    private static void updateClock(JLabel labelHouse) {
        LocalTime currentTime = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String formattedTime = currentTime.format(formatter);

        labelHouse.setText(formattedTime);
    }

    // Set img
    public static void setImage(String imagePath, JLabel labelLogo) {
        ImageIcon icon = new ImageIcon(imagePath);

        int width = labelLogo.getWidth();
        int height = labelLogo.getHeight();

        Image image = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(image);
        labelLogo.setIcon(scaledIcon);
    }

    // Full screen
    public static void openFullScreenWindow(JFrame window) {
        window.setExtendedState(JFrame.MAXIMIZED_BOTH);
        window.setVisible(true);
        window.dispose();
    }

    // Scroll bar
    public static void customizeScrollBar(JScrollPane scrollPane, Color trackColor) {
        scrollPane.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
            @Override
            protected void paintTrack(Graphics g, JComponent c, Rectangle trackBounds) {
                g.setColor(trackColor);
                g.fillRect(trackBounds.x, trackBounds.y, trackBounds.width, trackBounds.height);
            }

            @Override
            protected void paintThumb(Graphics g, JComponent c, Rectangle thumbBounds) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(Color.GRAY);
                g2.fillRoundRect(thumbBounds.x, thumbBounds.y, thumbBounds.width, thumbBounds.height, 10, 10);
                g2.dispose();
            }

            @Override
            protected JButton createDecreaseButton(int orientation) {
                return createZeroButton();
            }

            @Override
            protected JButton createIncreaseButton(int orientation) {
                return createZeroButton();
            }

            private JButton createZeroButton() {
                JButton button = new JButton();
                button.setPreferredSize(new Dimension(0, 0));
                button.setMinimumSize(new Dimension(0, 0));
                button.setMaximumSize(new Dimension(0, 0));
                return button;
            }
        });

        scrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(5, 0));
    }

    // Add commas to number after 3 number
    public static String addCommasToNumber(String num) {
        String regex = "(\\d)(?=(\\d{3})+$)";
        String[] split = num.split("\\.");

        if (split.length == 2) {
            return split[0].replaceAll(regex, "$1,") + "." + split[1];
        } else {
            return num.replaceAll(regex, "$1,");
        }
    }

    // Remove commas from number
    public static String removeCommasFromNumber(String num) {
        return num.replaceAll(",", "");
    }

    // Set imgage
    public void resetImagePath(String path, JButton button) {
        int width = button.getWidth();
        int height = button.getHeight();

        ImageIcon icon = new ImageIcon(path);
        Image image = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(image);
        button.setIcon(scaledIcon);
    }

    // Init 2 button "+" and "-"
    public static void setupButtonColumn(JTable table, int columnNumber) {
        TableColumnModel columnModel = table.getColumnModel();
        TableColumn column = columnModel.getColumn(columnNumber);
        column.setCellRenderer(new ButtonRenderer());
        column.setCellEditor(new ButtonEditor());
    }

    private static class ButtonRenderer extends DefaultTableCellRenderer {

        private final JPanel panel = new JPanel();
        private final JButton plusButton = new JButton("➕");
        private final JButton minusButton = new JButton("➖");
        private final JTextField textField = new JTextField();

        public ButtonRenderer() {
            // Đặt kích thước chữ cho JTextField
            Font textFont = new Font(textField.getFont().getName(), Font.PLAIN, 16);
            textField.setFont(textFont);

            panel.setLayout(new BorderLayout());
            panel.add(plusButton, BorderLayout.WEST);
            panel.add(textField, BorderLayout.CENTER);
            panel.add(minusButton, BorderLayout.EAST);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            boolean isEmpty = value == null || value.toString().isEmpty();
            plusButton.setVisible(!isEmpty);
            minusButton.setVisible(!isEmpty);

            if (isEmpty) {
                // Nếu ô là rỗng, không hiển thị giá trị nào
                textField.setText("");
                plusButton.setEnabled(false); // Vô hiệu hóa nút "+"
                minusButton.setEnabled(false); // Vô hiệu hóa nút "-"
            } else {
                // Nếu không, hiển thị giá trị của ô
                textField.setText(value.toString());
                plusButton.setEnabled(true); // Kích hoạt nút "+"
                minusButton.setEnabled(true); // Kích hoạt nút "-"
            }

            return panel;
        }
    }

    private static class ButtonEditor extends AbstractCellEditor implements TableCellEditor {

        private final JPanel panel = new JPanel();
        private final JButton plusButton = new JButton("➕");
        private final JButton minusButton = new JButton("➖");
        private final JTextField textField = new JTextField();

        public ButtonEditor() {
            panel.setLayout(new BorderLayout());

            Font textFieldFont = new Font(textField.getFont().getName(), Font.BOLD, 17);
            textField.setFont(textFieldFont);

            plusButton.addActionListener(e -> {
                int number = Integer.parseInt(textField.getText());
                textField.setText(String.valueOf(number + 1));
                fireEditingStopped();
            });

            minusButton.addActionListener(e -> {
                int number = Integer.parseInt(textField.getText());

                if (number <= 1) {
                    // Remove row
                    JTable table = (JTable) SwingUtilities.getAncestorOfClass(JTable.class, minusButton);
                    DefaultTableModel model = (DefaultTableModel) table.getModel();
                    int editingRow = table.getEditingRow();
                    stopCellEditing();
                    model.removeRow(editingRow);
                } else {
                    // Decrease by 1
                    textField.setText(String.valueOf(number - 1));
                }

                fireEditingStopped();
            });

            panel.add(plusButton, BorderLayout.WEST);
            panel.add(textField, BorderLayout.CENTER);
            panel.add(minusButton, BorderLayout.EAST);
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            boolean isEmpty = value == null || value.toString().isEmpty();
            plusButton.setVisible(!isEmpty);
            minusButton.setVisible(!isEmpty);

            if (isEmpty) {
                // Nếu ô là rỗng, không hiển thị giá trị nào
                textField.setText("");
                plusButton.setEnabled(false); // Vô hiệu hóa nút "+"
                minusButton.setEnabled(false); // Vô hiệu hóa nút "-"
            } else {
                // Nếu không, hiển thị giá trị của ô
                textField.setText(value.toString());
                plusButton.setEnabled(true); // Kích hoạt nút "+"
                minusButton.setEnabled(true); // Kích hoạt nút "-"
            }

            return panel;
        }

        @Override
        public Object getCellEditorValue() {
            return textField.getText();
        }

        @Override
        public boolean stopCellEditing() {
            fireEditingStopped();
            return super.stopCellEditing();
        }
    }

    // Khởi tạo ComboBox cho cột với chỉ số columnIndex trong bảng table
    public static void setupComboBoxColumn(JTable table, int columnIndex) {
        TableColumnModel columnModel = table.getColumnModel();
        TableColumn column = columnModel.getColumn(columnIndex);
        column.setCellEditor(new CustomComboBoxCellEditor(createOccupationComboBox()));
    }

    public static JComboBox<String> createOccupationComboBox() {
        // Tạo ComboBox với danh sách các mục đã được định nghĩa sẵn
        JComboBox<String> comboBox = new JComboBox<>();
        List<String> items = Arrays.asList("", "Cấp 0", "Cấp 1", "Cấp 2", "Cấp 3", "Cấp 4", "Cấp 5", "Cấp 6", "Cấp 7");
        items.forEach(comboBox::addItem);
        return comboBox;
    }

    private static class CustomComboBoxCellEditor extends DefaultCellEditor {
        // Editor tùy chỉnh để ẩn ComboBox cho các hàng chưa có sản phẩm

        public CustomComboBoxCellEditor(JComboBox comboBox) {
            super(comboBox);
        }

        @Override
        public java.awt.Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            JComboBox<String> comboBox = (JComboBox<String>) super.getTableCellEditorComponent(table, value, isSelected, row, column);

            // Kích hoạt hoặc vô hiệu hóa ComboBox dựa trên sự hiện diện của sản phẩm
            comboBox.setEnabled(table.getValueAt(row, 0) != null); // Kiểm tra giá trị ở cột 0, nếu không rỗng thì kích hoạt ComboBox
            return comboBox;
        }
    }
}
