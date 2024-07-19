package restaurant.utils;

import java.awt.Font;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Insets;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.FontMetrics;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.GridBagConstraints;
import java.util.function.Consumer;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.DefaultCellEditor;
import javax.swing.table.TableColumn;
import javax.swing.AbstractCellEditor;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.DefaultTableCellRenderer;
import static restaurant.utils.Common.createButton;
import static restaurant.utils.XTextField.addCommasToNumber;

public class ColumnTable {

    /**
     * Adds a column with buttons for adjusting quantity to the table.
     *
     * @param table the table to which the quantity button column is added
     * @param columnNumber the column number to which the quantity button column
     * is added
     * @param editableTextField whether the column should be editable
     */
    public static void addQuantityButtonsColumn(JTable table, int columnNumber, boolean editableTextField) {
        TableColumnModel columnModel = table.getColumnModel();
        TableColumn column = columnModel.getColumn(columnNumber);
        column.setCellRenderer(new QuantityButtonRenderer(editableTextField));
        column.setCellEditor(new QuantityButtonEditor(editableTextField));
    }

    private static class QuantityButtonPanel extends JPanel {

        private final JTextField quantityField = new JTextField();
        private final JButton increaseButton = new JButton();
        private final JButton decreaseButton = new JButton();

        public QuantityButtonPanel(boolean editableTextField) {
            setOpaque(true);
            setBackground(Color.white);

            // load icon
            increaseButton.setIcon(new ImageIcon(getClass().getResource("/restaurant/icon/plus.png")));
            decreaseButton.setIcon(new ImageIcon(getClass().getResource("/restaurant/icon/minus.png")));

            // set size button
            increaseButton.setPreferredSize(new Dimension(20, 20));
            decreaseButton.setPreferredSize(new Dimension(20, 20));

            // Set font size for quantityField
            quantityField.setPreferredSize(new Dimension(24, 24));
            quantityField.setHorizontalAlignment(JTextField.CENTER);
            quantityField.setFont(new Font(quantityField.getFont().getName(), Font.PLAIN, 14));
            quantityField.setBorder(editableTextField
                    ? BorderFactory.createMatteBorder(0, 0, 1, 0, Color.red)
                    : BorderFactory.createEmptyBorder()
            );

            // Make the text field non-editable if required
            quantityField.setEditable(editableTextField);

            // set cursor hand for buttons
            increaseButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
            decreaseButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

            // Set layout
            JPanel panel = new JPanel();
            panel.setOpaque(false);

            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.insets = new Insets(0, 0, 0, 0);
            gbc.anchor = GridBagConstraints.CENTER;
            panel.add(decreaseButton, gbc);

            gbc.gridx = 1;
            panel.add(quantityField, gbc);

            gbc.gridx = 2;
            panel.add(increaseButton, gbc);

            add(panel);
        }

        public JTextField getQuantityField() {
            return quantityField;
        }

        public JButton getPlusButton() {
            return increaseButton;
        }

        public JButton getMinusButton() {
            return decreaseButton;
        }
    }

    private static class QuantityButtonRenderer extends DefaultTableCellRenderer {

        private final QuantityButtonPanel panel;

        public QuantityButtonRenderer(boolean editableTextField) {
            super();
            panel = new QuantityButtonPanel(editableTextField);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            panel.setBackground(isSelected ? table.getSelectionBackground() : Color.white);

            if (value == null || value.toString().isEmpty()) {
                panel.getQuantityField().setText("");
                panel.getPlusButton().setEnabled(false);
                panel.getMinusButton().setEnabled(false);
            } else {
                panel.getQuantityField().setText(value.toString());
                panel.getPlusButton().setEnabled(true);
                panel.getMinusButton().setEnabled(true);
            }

            return panel;
        }
    }

    private static class QuantityButtonEditor extends AbstractCellEditor implements TableCellEditor {

        private QuantityButtonPanel panel;
        private static final int MAX_QUANTITY = 99;

        public QuantityButtonEditor(boolean editableTextField) {
            super();
            panel = new QuantityButtonPanel(editableTextField);

            panel.getPlusButton().addActionListener(e -> {
                String text = panel.getQuantityField().getText().trim();
                int number = parseQuantity(text);
                if (number < MAX_QUANTITY) {
                    panel.getQuantityField().setText(String.valueOf(number + 1));
                } else {
                    Dialog.warning(null, "Số lượng không được vượt quá " + MAX_QUANTITY + "!");
                }
                fireEditingStopped();
            });

            panel.getMinusButton().addActionListener(e -> {
                String text = panel.getQuantityField().getText().trim();
                int number = parseQuantity(text);

                if (number > 1) {
                    panel.getQuantityField().setText(String.valueOf(number - 1));
                }
                fireEditingStopped();
            });
        }

        private int parseQuantity(String text) {
            int number = 1;
            if (!text.isEmpty()) {
                try {
                    number = Integer.parseInt(text);
                } catch (NumberFormatException e) {
                    number = 1;
                }
            }
            return number;
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            panel.setBackground(isSelected == true ? table.getSelectionBackground() : Color.white);

            if (value == null || value.toString().isEmpty()) { // Ẩn đi
                panel.getQuantityField().setText("");
                panel.getPlusButton().setEnabled(false);
                panel.getMinusButton().setEnabled(false);
            } else { // Hiển thị
                panel.getQuantityField().setText(value.toString());
                panel.getPlusButton().setEnabled(true);
                panel.getMinusButton().setEnabled(true);
            }

            return panel;
        }

        @Override
        public Object getCellEditorValue() {
            String text = panel.getQuantityField().getText().trim();
            try {
                int number = Integer.parseInt(text);
                if (number < 1 || number > MAX_QUANTITY) {
                    Dialog.warning(null, "Số lượng phải từ 1 đến " + MAX_QUANTITY + "!");
                    return "1"; // Reset to 1 on invalid input
                }
            } catch (NumberFormatException e) {
                Dialog.warning(null, "Vui lòng nhập đúng số nguyên!");
                return "1"; // Reset to 1 on invalid input
            }
            return text;
        }

        @Override
        public boolean stopCellEditing() {
            String text = panel.getQuantityField().getText().trim();
            try {
                int number = Integer.parseInt(text);
                if (number < 1 || number > MAX_QUANTITY) {
                    Dialog.warning(null, "Số lượng phải từ 1 đến " + MAX_QUANTITY + "!");
                    panel.getQuantityField().setText("1"); // Reset to 1 on invalid input
                }
            } catch (NumberFormatException e) {
                Dialog.warning(null, "Vui lòng nhập đúng số nguyên!");
                panel.getQuantityField().setText("1"); // Reset to 1 on invalid input
            }
            fireEditingStopped();
            return super.stopCellEditing();
        }
    }

    /**
     * Adds a buttons to the table.
     *
     * @param btnText text string button
     * @param table the table to which the detail button column is added
     * @param columnNumber the column number to which the detail button column
     * is added
     * @param handleEventClickButton a Consumer that defines the action to be
     * performed when the detail button is clicked
     */
    public static void addButtonColumn(String btnText, int columnNumber,
            JTable table, Consumer<Integer> handleEventClickButton) {
        // get column
        TableColumn column = table.getColumnModel().getColumn(columnNumber);
        // set cell render
        column.setCellRenderer(new ButtonCellRenderer(btnText));
        // set cell editor
        column.setCellEditor(new ButtonCellEditor(table, btnText, handleEventClickButton));
    }

    private static class ButtonCellRenderer extends JPanel implements TableCellRenderer {

        private final JButton button;

        public ButtonCellRenderer(String btnText) {
            setOpaque(true);
            setBackground(Color.white);
            setLayout(new FlowLayout(FlowLayout.CENTER, 5, 2));

            // Create button first
            button = createButton(btnText, new Color(0, 153, 153), new Dimension(0, 0));
            add(button, BorderLayout.CENTER);

            // Now calculate preferred size based on text length
            Dimension preferredSize = calculateButtonSize(button, btnText);
            button.setPreferredSize(preferredSize);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            setBackground(isSelected ? table.getSelectionBackground() : Color.white);
            return this;
        }
    }

    private static class ButtonCellEditor extends DefaultCellEditor {

        private final JPanel panel;
        private final JButton button;

        public ButtonCellEditor(JTable table, String btnText, Consumer<Integer> handleEventClickButton) {
            super(new JTextField());
            setClickCountToStart(1);
            panel = new JPanel();
            panel.setBackground(Color.white);
            panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 2));

            // Create button first
            button = createButton(btnText, new Color(0, 153, 153), new Dimension(0, 0));
            Dimension preferredSize = calculateButtonSize(button, btnText);
            button.setPreferredSize(preferredSize);

            // Attach event click button
            button.addActionListener((ActionEvent e) -> {
                // get row
                int row = table.convertRowIndexToModel(table.getEditingRow());

                // Call the callback function
                handleEventClickButton.accept(row);
                fireEditingStopped();
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

    private static Dimension calculateButtonSize(JButton button, String btnText) {
        // Calculate preferred size based on text length
        FontMetrics metrics = button.getFontMetrics(button.getFont());
        int width = metrics.stringWidth(btnText) + 40; // Add padding
        return new Dimension(width, 36);
    }

    /**
     * Adds a button icon to the table.
     *
     * @param btnIcon text string url icon
     * @param table the table to which the detail button column is added
     * @param columnNumber the column number to which the detail button column
     * is added
     * @param handleClickButtonIcon a Consumer that defines the action to be
     * performed when the button is clicked
     */
    public static void addButtonIconColumn(String btnIcon, int columnNumber,
            JTable table, Consumer<Integer> handleClickButtonIcon) {
        TableColumn column = table.getColumnModel().getColumn(columnNumber);
        column.setCellRenderer(new ButtonIconCellRenderer(btnIcon));
        column.setCellEditor(new ButtonIconCellEditor(table, btnIcon, handleClickButtonIcon));
    }

    private static class ButtonIconCellRenderer extends JPanel implements TableCellRenderer {

        private JButton button;

        public ButtonIconCellRenderer(String btnIcon) {
            setOpaque(true);
            setBackground(Color.white);
            setLayout(new GridBagLayout());

            // Create button 
            button = new JButton(new ImageIcon(btnIcon));
            button.setBackground(Color.white);
            button.setBorder(BorderFactory.createLineBorder(Color.WHITE, 6, true));

            // Set layout constraints for centering
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.weightx = 1.0;
            gbc.weighty = 1.0;
            gbc.anchor = GridBagConstraints.CENTER;
            gbc.fill = GridBagConstraints.NONE;

            add(button, gbc);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            setBackground(isSelected ? table.getSelectionBackground() : Color.white);
            return this;
        }
    }

    private static class ButtonIconCellEditor extends DefaultCellEditor {

        private final JPanel panel;
        private final JButton button;

        public ButtonIconCellEditor(JTable table, String btnIcon, Consumer<Integer> handleClickButtonIcon) {
            super(new JTextField());
            setClickCountToStart(1);
            panel = new JPanel();
            panel.setBackground(Color.white);
            panel.setLayout(new GridBagLayout());

            // Create button 
            button = new JButton(new ImageIcon(btnIcon));
            button.setBackground(Color.white);
            button.setBorder(BorderFactory.createLineBorder(Color.WHITE, 6, true));

            // Attach event click button
            button.addActionListener((ActionEvent e) -> {
                // get row
                int row = table.convertRowIndexToModel(table.getEditingRow());

                // Call the callback function
                handleClickButtonIcon.accept(row);
                fireEditingStopped();
            });

            // Set layout constraints for centering
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.weightx = 1.0;
            gbc.weighty = 1.0;
            gbc.anchor = GridBagConstraints.CENTER;
            gbc.fill = GridBagConstraints.NONE;

            panel.add(button, gbc);
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

    /**
     * Adds a column with non-editable text fields to the table.
     *
     * @param table the table to which the text field column is added
     * @param columnNumber the column number to which the text field column is
     * added
     */
    public static void addTextFieldColumn(JTable table, int columnNumber) {
        TableColumnModel columnModel = table.getColumnModel();
        TableColumn column = columnModel.getColumn(columnNumber);
        column.setCellRenderer(new TextFieldRenderer());
        column.setCellEditor(new TextFieldEditor());
    }

    private static class TextFieldPanel extends JPanel {

        private final JTextField textField = new JTextField();

        public TextFieldPanel() {
            setOpaque(true);
            setBackground(Color.white);

            // Set textField
            textField.setPreferredSize(new Dimension(70, 24));
            textField.setHorizontalAlignment(JTextField.CENTER);
            textField.setFont(new Font(textField.getFont().getName(), Font.PLAIN, 14));
            textField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.red));

            // Set layout
            JPanel panel = new JPanel();
            panel.setOpaque(false);

            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.insets = new Insets(0, 0, 0, 0);
            gbc.anchor = GridBagConstraints.CENTER;
            add(textField, gbc);
        }

        public JTextField getTextField() {
            return textField;
        }

        public void setText(String text) {
            textField.setText(text);
        }

        public String getText() {
            return textField.getText();
        }
    }

    private static class TextFieldRenderer extends DefaultTableCellRenderer {

        private final TextFieldPanel panel = new TextFieldPanel();

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            panel.setBackground(isSelected ? table.getSelectionBackground() : Color.white);
            panel.setText(value == null ? "" : value.toString());
            return panel;
        }
    }

    private static class TextFieldEditor extends AbstractCellEditor implements TableCellEditor {

        private final TextFieldPanel panel = new TextFieldPanel();

        public TextFieldEditor() {
            super();

            String text = panel.getTextField().getText().trim();
            panel.getTextField().setText(addCommasToNumber(text));
            fireEditingStopped();
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            panel.setBackground(isSelected ? table.getSelectionBackground() : Color.white);
            panel.setText(value == null ? "" : value.toString());
            return panel;
        }

        @Override
        public Object getCellEditorValue() {
            return panel.getText();
        }

        @Override
        public boolean stopCellEditing() {
            fireEditingStopped();
            return super.stopCellEditing();
        }

    }

}
