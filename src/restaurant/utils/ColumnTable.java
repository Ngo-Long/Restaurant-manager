package restaurant.utils;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.Arrays;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.ImageIcon;

import javax.swing.table.TableColumn;
import javax.swing.AbstractCellEditor;
import javax.swing.BorderFactory;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.SwingUtilities;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.DefaultTableCellRenderer;

public class ColumnTable {

    /**
     * Add button to the table
     *
     * @param table the table to which the button column is added
     * @param columnNumber the column number to which the button column is added
     */
    public static void setupButtonColumn(JTable table, int columnNumber) {
        TableColumnModel columnModel = table.getColumnModel();
        TableColumn column = columnModel.getColumn(columnNumber);
        column.setCellRenderer(new ButtonRenderer());
        column.setCellEditor(new ButtonEditor());
    }

    private static class ButtonPanel extends JPanel {

        private final JLabel quantityLabel = new JLabel();
        private final JButton plusButton = new JButton();
        private final JButton minusButton = new JButton();

        public ButtonPanel() {
            setOpaque(true);
            setBackground(Color.white);
            setBorder(BorderFactory.createEmptyBorder(0, 6, 0, 6));

            // load icon
            plusButton.setIcon(new ImageIcon(getClass().getResource("/restaurant/icon/plus.png")));
            minusButton.setIcon(new ImageIcon(getClass().getResource("/restaurant/icon/minus.png")));

            // set size button
            plusButton.setPreferredSize(new Dimension(20, 20));
            minusButton.setPreferredSize(new Dimension(20, 20));

            // Set font size for quantityLabel
            Font labelFont = quantityLabel.getFont();
            quantityLabel.setFont(new Font(labelFont.getName(), Font.PLAIN, 14));

            // set cursor hand for buttons
            plusButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
            minusButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

            // Set layout
            JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
            buttonPanel.setOpaque(false);
            buttonPanel.add(minusButton);
            buttonPanel.add(quantityLabel);
            buttonPanel.add(plusButton);

            add(buttonPanel);
        }

        public JLabel getQuantityLabel() {
            return quantityLabel;
        }

        public JButton getPlusButton() {
            return plusButton;
        }

        public JButton getMinusButton() {
            return minusButton;
        }
    }

    private static class ButtonRenderer extends DefaultTableCellRenderer {

        private final ButtonPanel panel = new ButtonPanel();

        public ButtonRenderer() {
            super();
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            if (isSelected) {
                panel.setBackground(table.getSelectionBackground());
            } else {
                panel.setBackground(Color.white);
            }

            if (value == null || value.toString().isEmpty()) {
                panel.getQuantityLabel().setText("");
                panel.getPlusButton().setEnabled(false);
                panel.getMinusButton().setEnabled(false);
            } else {
                panel.getQuantityLabel().setText(value.toString());
                panel.getPlusButton().setEnabled(true);
                panel.getMinusButton().setEnabled(true);
            }

            return panel;
        }
    }

    private static class ButtonEditor extends AbstractCellEditor implements TableCellEditor {

        private ButtonPanel panel = new ButtonPanel();

        public ButtonEditor() {
            super();
            panel.getPlusButton().addActionListener(e -> {
                int number = Integer.parseInt(panel.getQuantityLabel().getText());
                panel.getQuantityLabel().setText(String.valueOf(number + 1));
                fireEditingStopped();
            });

            panel.getMinusButton().addActionListener(e -> {
                int number = Integer.parseInt(panel.getQuantityLabel().getText());

                // Remove row
                if (number <= 1) {
                    JTable table = (JTable) SwingUtilities.getAncestorOfClass(JTable.class, panel.getMinusButton());
                    DefaultTableModel model = (DefaultTableModel) table.getModel();
                    int editingRow = table.getEditingRow();
                    stopCellEditing();
                    model.removeRow(editingRow);
                }

                // minus 1
                if (number > 1) {
                    panel.getQuantityLabel().setText(String.valueOf(number - 1));
                }
                fireEditingStopped();
            });
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            if (isSelected) {
                panel.setBackground(table.getSelectionBackground());
            } else {
                panel.setBackground(Color.white);
            }

            // Ẩn đi
            if (value == null || value.toString().isEmpty()) {
                panel.getQuantityLabel().setText("");
                panel.getPlusButton().setEnabled(false);
                panel.getMinusButton().setEnabled(false);
            } else { // Hiển thị
                panel.getQuantityLabel().setText(value.toString());
                panel.getPlusButton().setEnabled(true);
                panel.getMinusButton().setEnabled(true);
            }

            return panel;
        }

        @Override
        public Object getCellEditorValue() {
            return panel.getQuantityLabel().getText();
        }

        @Override
        public boolean stopCellEditing() {
            fireEditingStopped();
            return super.stopCellEditing();
        }
    }

    /**
     * Add combobox to the table
     *
     * @param table the table to which the button column is added
     * @param columnNumber the column number to which the button column is added
     */
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
