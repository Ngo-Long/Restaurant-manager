package restaurant.utils;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
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
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import restaurant.dao.OrderDetailDAO;
import restaurant.dialog.HistoryProductDetailJDialog;
import restaurant.entity.OrderDetailEntity;
import static restaurant.utils.Common.createButton;

public class ColumnTable {

    /**
     * Adds a column with buttons for adjusting quantity to the table.
     *
     * @param table the table to which the quantity button column is added
     * @param columnNumber the column number to which the quantity button column
     * is added
     */
    public static void setupQuantityButtonColumn(JTable table, int columnNumber) {
        TableColumnModel columnModel = table.getColumnModel();
        TableColumn column = columnModel.getColumn(columnNumber);
        column.setCellRenderer(new QuantityButtonRenderer());
        column.setCellEditor(new QuantityButtonEditor());
    }

    private static class QuantityButtonPanel extends JPanel {

        private final JLabel quantityLabel = new JLabel();
        private final JButton increaseButton = new JButton();
        private final JButton decreaseButton = new JButton();

        public QuantityButtonPanel() {
            setOpaque(true);
            setBackground(Color.white);
            setBorder(BorderFactory.createEmptyBorder(0, 6, 0, 6));

            // load icon
            increaseButton.setIcon(new ImageIcon(getClass().getResource("/restaurant/icon/plus.png")));
            decreaseButton.setIcon(new ImageIcon(getClass().getResource("/restaurant/icon/minus.png")));

            // set size button
            increaseButton.setPreferredSize(new Dimension(20, 20));
            decreaseButton.setPreferredSize(new Dimension(20, 20));

            // Set font size for quantityLabel
            Font labelFont = quantityLabel.getFont();
            quantityLabel.setFont(new Font(labelFont.getName(), Font.PLAIN, 14));

            // set cursor hand for buttons
            increaseButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
            decreaseButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

            // Set layout
            JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
            buttonPanel.setOpaque(false);
            buttonPanel.add(decreaseButton);
            buttonPanel.add(quantityLabel);
            buttonPanel.add(increaseButton);

            add(buttonPanel);
        }

        public JLabel getQuantityLabel() {
            return quantityLabel;
        }

        public JButton getPlusButton() {
            return increaseButton;
        }

        public JButton getMinusButton() {
            return decreaseButton;
        }
    }

    private static class QuantityButtonRenderer extends DefaultTableCellRenderer {

        private final QuantityButtonPanel panel = new QuantityButtonPanel();

        public QuantityButtonRenderer() {
            super();
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            panel.setBackground(isSelected ? table.getSelectionBackground() : Color.white);

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

    private static class QuantityButtonEditor extends AbstractCellEditor implements TableCellEditor {

        private QuantityButtonPanel panel = new QuantityButtonPanel();

        public QuantityButtonEditor() {
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
                    // Vẫn phải trừ 1 để lấy số lượng tính tổng
                    panel.getQuantityLabel().setText(String.valueOf(number - 1));

                    // Call table get model 
                    JTable table = (JTable) SwingUtilities.getAncestorOfClass(JTable.class, panel.getMinusButton());
                    DefaultTableModel model = (DefaultTableModel) table.getModel();

                    // Delete row
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
     * Adds a column with "Chi tiết" buttons to the table.
     *
     * @param table the table to which the detail button column is added
     * @param columnNumber the column number to which the detail button column
     * is added
     */
    public static void setupDetailButtonColumn(JTable table, int columnNumber) {
        TableColumn column = table.getColumnModel().getColumn(columnNumber);
        column.setCellRenderer(new DetailButtonRenderer());
        column.setCellEditor(new DetailButtonEditor(table));
    }

    private static class DetailButtonRenderer extends JPanel implements TableCellRenderer {

        public DetailButtonRenderer() {
            setOpaque(true);
            setBackground(Color.white);
            setLayout(new FlowLayout(FlowLayout.CENTER, 5, 2));
            add(createButton("Chi tiết", new Color(0, 153, 153), new Dimension(80, 36)));
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            setBackground(isSelected ? table.getSelectionBackground() : Color.white);
            return this;
        }
    }

    private static class DetailButtonEditor extends DefaultCellEditor {

        private final JPanel panel;
        private final JButton button;

        public DetailButtonEditor(JTable table) {
            super(new JTextField());
            setClickCountToStart(1);
            panel = new JPanel();
            panel.setBackground(Color.white);
            panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 2));

            button = createButton("Chi tiết", new Color(0, 153, 153), new Dimension(80, 36));
            button.addActionListener((ActionEvent e) -> {
                int row = table.getSelectedRow();
                if (row == -1) {
                    return;
                }

                // Get data detail
                int detailID = (int) table.getValueAt(row, 0);
                OrderDetailEntity dataDetail = new OrderDetailDAO().getByID(detailID);

                // Open dialog 
                HistoryProductDetailJDialog dialog = new HistoryProductDetailJDialog(null, true);
                dialog.displayDetailOrder(dataDetail);
                dialog.setVisible(true);
            });
            panel.add(button);
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            return panel;
        }

        @Override
        public Object getCellEditorValue() {
            return "";
        }
    }
    // end --->

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
