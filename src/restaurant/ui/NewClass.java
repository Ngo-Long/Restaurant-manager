package restaurant.ui;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.DefaultTableCellRenderer;

public class NewClass extends JFrame {

    private JTable table;

    public NewClass() {
        setTitle("Table Example");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 300);

        // Tạo bảng và mô hình dữ liệu
        table = new JTable();
        DefaultTableModel model = new DefaultTableModel(
                new Object[][]{
                    {"Item 1", 10},
                    {"Item 2", 5},
                    {"Item 3", 15}
                },
                new String[]{"Name", "Number"}
        );
        table.setModel(model);

        // Đặt Renderer tùy chỉnh để thay đổi màu hàng
        table.setDefaultRenderer(Object.class, new CustomRenderer());

        // Đổi màu hàng dựa trên số hàng
        setColorForRow(2, Color.lightGray); // Đổi màu hàng thứ 2 (index bắt đầu từ 0)

        JScrollPane scrollPane = new JScrollPane(table);
        getContentPane().add(scrollPane);

        // Đặt kích thước ưu tiên cho bảng
        table.setPreferredScrollableViewportSize(new Dimension(750, 300));
        // Đặt chiều cao hàng
        table.setRowHeight(30);

        // Thêm border cho bảng
        scrollPane.setBorder(BorderFactory.createLineBorder(Color.gray));
        // Thiết lập màu nền và màu chữ cho header
        table.getTableHeader().setBackground(Color.lightGray);
        table.getTableHeader().setForeground(Color.black);
        // Thiết lập font chữ cho header
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));

        // Thiết lập màu nền cho bảng
        table.setBackground(Color.white);

        // Thiết lập màu chữ cho bảng
        table.setForeground(Color.black);

        // Thiết lập font chữ cho nội dung bảng
        table.setFont(new Font("Arial", Font.PLAIN, 12));

        // Thiết lập kiểu nền cho bảng
        table.setSelectionBackground(Color.white);

        // Thiết lập kiểu chọn cho bảng
        table.setSelectionForeground(Color.black);

        setVisible(true);
    }

    // Hàm đổi màu hàng dựa trên số hàng
    private void setColorForRow(int rowIndex, Color color) {
        // Lưu màu vào Renderer tùy chỉnh
        ((CustomRenderer) table.getDefaultRenderer(Object.class)).setColorForRow(rowIndex, color);
        // Gọi repaint để cập nhật hiển thị của bảng
        table.repaint();
    }

    public static void main(String[] args) {
        new NewClass();
    }
}

class CustomRenderer extends DefaultTableCellRenderer {

    private int rowIndex = -1;
    private Color rowColor = Color.white;

    public void setColorForRow(int rowIndex, Color color) {
        this.rowIndex = rowIndex;
        this.rowColor = color;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        if (row == rowIndex) {
            c.setBackground(rowColor);
        } else {
            c.setBackground(Color.white);
        }
        return c;
    }
}
