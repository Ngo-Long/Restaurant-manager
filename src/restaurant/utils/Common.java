package restaurant.utils;

import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.*;
import javax.swing.plaf.basic.BasicScrollBarUI;

public class Common {

    // Update clock
    public static void initClock(JLabel labelHouse) {
        Timer timer = new Timer(1000, e -> {
            LocalTime currentTime = LocalTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
            String formattedTime = currentTime.format(formatter);

            labelHouse.setText(formattedTime);
        });
        timer.start();
    }

    // Cài đặt tên trong mọi file
    public static void setAccountMenu(JMenu menu) {
        String fullName = "";
        String position = "";

        // Kiểm tra và gán giá trị cho fullName
        if (Auth.user != null && Auth.user.getFullName() != null) {
            fullName = Auth.user.getFullName();
        }

        // Kiểm tra và gán giá trị cho position
        if (Auth.user != null && Auth.user.getPosition() != null) {
            position = Auth.user.getPosition();
        }

        // Chuyển đổi thành chuỗi và gán vào labelAccount
        menu.setText(fullName + " - " + position.toUpperCase());
    }

    // Hàm chung để tùy chỉnh bảng
    public static void customizeTable(JTable table, int[] columnsNotCentered, int rowHeight) {
        // Setup table
        table.setRowHeight(rowHeight);         // Set row height for the table
        table.setGridColor(Color.WHITE);
        table.setDefaultEditor(Object.class, null);  // Ko sửa nội 
        table.setBorder(new LineBorder(Color.WHITE));
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // Chọn duy nhất một hàng

        // Setup header common
        JTableHeader tableHeader = table.getTableHeader();
        tableHeader.setOpaque(true);
        tableHeader.setReorderingAllowed(false);
        tableHeader.setBackground(new Color(235, 235, 235));
        tableHeader.setFont(new Font("Be Vietnam Pro", Font.PLAIN, 15));

        // Setup header center
        DefaultTableCellRenderer headerRenderer = (DefaultTableCellRenderer) table.getTableHeader().getDefaultRenderer();
        headerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        tableHeader.setDefaultRenderer(headerRenderer);

        // Setup header not center
        DefaultTableCellRenderer notCenterHeader = (DefaultTableCellRenderer) table.getTableHeader().getDefaultRenderer();
        headerRenderer.setHorizontalAlignment(SwingConstants.LEFT);
        tableHeader.setDefaultRenderer(headerRenderer);

        // Setup renderer cho nội dung căn giữa
        DefaultTableCellRenderer contentRenderer = new DefaultTableCellRenderer();
        contentRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        contentRenderer.setBackground(Color.white);

        // Setup renderer cho nội dung không căn giữa và thêm padding
        DefaultTableCellRenderer notContentRenderer = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                // Call super method to set up the component
                super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                // Set padding on the left
                setBorder(BorderFactory.createEmptyBorder(0, 12, 0, 0));

                return this;
            }
        };
        notContentRenderer.setHorizontalAlignment(SwingConstants.LEFT);
        notContentRenderer.setBackground(Color.white);

        // Setup renderer và thuộc tính cho từng cột
        TableColumnModel columnModel = table.getColumnModel();
        for (int i = 0; i < table.getColumnCount(); i++) {
            boolean isNotCentered = false;
            for (int column : columnsNotCentered) {
                if (i == column) {
                    isNotCentered = true;
                    break;
                }
            }

            TableColumn column = columnModel.getColumn(i);
            if (isNotCentered) {
                table.getColumnModel().getColumn(i).setCellRenderer(notCenterHeader);
                table.getColumnModel().getColumn(i).setCellRenderer(notContentRenderer);
            } else {
                table.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
                table.getColumnModel().getColumn(i).setCellRenderer(contentRenderer);
            }

            // Privent size column
            column.setResizable(false);
        }

    }

    // Tính toán thời gian còn lại và định dạng thành HH:mm
    public static String calculateTimeRemaining(Date startTime) {
        long elapsedTimeInMillis = System.currentTimeMillis() - startTime.getTime();
        long hours = TimeUnit.MILLISECONDS.toHours(elapsedTimeInMillis);
        long minutes = TimeUnit.MILLISECONDS.toMinutes(elapsedTimeInMillis) % 60;
        return String.format("%02d:%02d", hours, minutes);
    }

    // Scroll bar
    public static void customizeScrollBar(JScrollPane scrollPane) {
        scrollPane.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
            @Override
            protected void paintTrack(Graphics g, JComponent c, Rectangle trackBounds) {
                g.setColor(Color.WHITE);
                g.fillRect(trackBounds.x, trackBounds.y, trackBounds.width, trackBounds.height);
            }

            @Override
            protected void paintThumb(Graphics g, JComponent c, Rectangle thumbBounds) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(Color.lightGray);
                g2.fillRoundRect(thumbBounds.x, thumbBounds.y, thumbBounds.width, thumbBounds.height, 8, 8);
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

        scrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(4, 0));
        scrollPane.getHorizontalScrollBar().setPreferredSize(new Dimension(0, 0));
    }

    // Add commas to number after 3 number
    public static String addCommasToNumber(String num) {
        // Remove leading and trailing spaces
        num = num.trim();
        if (num.isEmpty()) {
            return num;
        }

        StringBuilder result = new StringBuilder();
        String[] parts = num.split("\\.");

        // Handle integer part
        String integerPart = parts[0];
        String formattedIntegerPart = integerPart.replaceAll("(\\d)(?=(\\d{3})+$)", "$1,");
        result.append(formattedIntegerPart);

        // Handle decimal part if exists
        if (parts.length > 1) {
            result.append(".").append(parts[1]);
        }

        return result.toString();
    }

    // Remove commas from number
    public static String removeCommasFromNumber(String num) {
        num = num.trim();
        if (num.isEmpty()) {
            return num;
        }

        return num.replaceAll(",", "");
    }

    // Hiện border đậm khi click
    public static void setTableButtonBorder(JButton button, boolean isSelected) {
        Color borderColor = isSelected ? new Color(80, 80, 80) : new Color(255, 255, 255);
        button.setBorder(BorderFactory.createLineBorder(borderColor, 5, true));
    }

    // Create new button 
    public static JButton createButton(String text, Color backgroundColor, Dimension size) {
        JButton button = new JButton(text);

        // Style button
        button.setPreferredSize(size);
        button.setFocusPainted(false); // Loại bỏ đường viền khi nút được chọn
        button.setBackground(backgroundColor);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Style font
        button.setForeground(Color.WHITE);
        button.setFont(new Font(button.getFont().getName(), Font.BOLD, 14));

        // Attach event
        button.addMouseListener(new java.awt.event.MouseAdapter() {

            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                // Điều chỉnh màu sáng tối của màu ban đầu của nút
                int r = backgroundColor.getRed();
                int g = backgroundColor.getGreen();
                int b = backgroundColor.getBlue();

                // Giảm một số giá trị để làm cho màu đậm hơn
                r = Math.max(0, r - 15);
                g = Math.max(0, g - 15);
                b = Math.max(0, b - 15);

                button.setBackground(new Color(r, g, b));
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                // Điều chỉnh màu sáng tối của màu ban đầu của nút
                int r = backgroundColor.getRed();
                int g = backgroundColor.getGreen();
                int b = backgroundColor.getBlue();

                // Giảm một số giá trị để làm cho màu đậm hơn
                r = Math.max(0, r - 30);
                g = Math.max(0, g - 30);
                b = Math.max(0, b - 30);

                button.setBackground(new Color(r, g, b));
            }
        });

        return button;
    }

    // Update the row index
    public static void updateSelectRowAfterRemoval(JTable table, int selectedRow) {
        if (table == null || selectedRow < 0) {
            return;
        }

        // Get model
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.removeRow(selectedRow);

        // Chọn selectedRow nếu nó nhỏ hơn tổng hàng
        int newSelectedRow = Math.min(selectedRow, model.getRowCount() - 1);

        // Chọn hàng mới
        table.setRowSelectionInterval(newSelectedRow, newSelectedRow);
    }

    // Đổi màu hàng của table
    public static void setColorForRow(JTable table, int rowIndex, Color color) {
        table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                if (row == rowIndex) {
                    c.setBackground(color);
                } else {
                    c.setBackground(Color.white);
                }
                return c;
            }
        });
        table.repaint();
    }

    // Phương thức để kiểm tra định dạng email
    public static boolean isValidEmail(String email) {
        // Sử dụng biểu thức chính quy để kiểm tra định dạng email
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    // Thêm các button vô 1 nhóm
    public static ButtonGroup createButtonGroup(AbstractButton... buttons) {
        ButtonGroup buttonGroup = new ButtonGroup();
        for (AbstractButton button : buttons) {
            buttonGroup.add(button);
        }
        return buttonGroup;
    }

    // Thêm chú thích input khi không nhập gì hết
    public static void addPlaceholder(JTextField textField, String placeholder) {
        textField.setText(placeholder);
        textField.setForeground(Color.GRAY);

        textField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textField.getText().equals(placeholder)) {
                    textField.setText("");
                    textField.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (textField.getText().isEmpty()) {
                    textField.setText(placeholder);
                    textField.setForeground(Color.GRAY);
                }
            }
        });
    }

    // Lấy dữ liệu thật
    public static String getRealText(JTextField textField, String placeholder) {
        String text = textField.getText();
        return text.equals(placeholder) ? "" : text.trim();
    }

    // Sử dụng hàm để thêm focus listener và đặt viền cho mỗi JTextField trong mảng
    public static void addFocusBorder(JComponent component, Color focusColor, Color unfocusColor) {
        // Định nghĩa các viền matte
        MatteBorder focusedBorder = BorderFactory.createMatteBorder(0, 0, 3, 0, focusColor);
        MatteBorder unfocusedBorder = BorderFactory.createMatteBorder(0, 0, 2, 0, unfocusColor);
        EmptyBorder paddingBorder = (EmptyBorder) BorderFactory.createEmptyBorder(0, 5, 0, 0);

        // Tạo viền kết hợp với khoảng trống
        Border focusedCombinedBorder = BorderFactory.createCompoundBorder(focusedBorder, paddingBorder);
        Border unfocusedCombinedBorder = BorderFactory.createCompoundBorder(unfocusedBorder, paddingBorder);

        // Đặt viền ban đầu
        component.setBorder(unfocusedCombinedBorder);

        // Thêm focus listener để thay đổi viền khi focus hoặc unfocus
        component.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                component.setBorder(focusedCombinedBorder);
            }

            @Override
            public void focusLost(FocusEvent e) {
                component.setBorder(unfocusedCombinedBorder);
            }
        });
    }
}
