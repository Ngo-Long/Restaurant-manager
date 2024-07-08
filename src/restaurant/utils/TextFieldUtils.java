package restaurant.utils;

import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class TextFieldUtils {

    private static final ScheduledExecutorService SCHEDULED_EXECUTOR_SERVICE = Executors.newScheduledThreadPool(1);

    /**
     * Adds a placeholder text to the specified JTextField.
     *
     * @param textField the JTextField to which the placeholder is added
     * @param placeholder the placeholder text to display when the JTextField is
     * empty
     */
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

    /**
     * Retrieves the actual text from the JTextField, ignoring the placeholder.
     *
     * @param textField the JTextField to retrieve the text from
     * @param placeholder the placeholder text to ignore
     * @return the actual text from the JTextField
     */
    public static String getRealText(JTextField textField, String placeholder) {
        String text = textField.getText();
        return text.equals(placeholder) ? "" : text.trim();
    }

    /**
     * Adds a focus border to the specified JComponent, changing its border
     * color when focused or unfocused.
     *
     * @param component the JComponent to which the focus border is added
     * @param focusColor the color of the border when the component is focused
     * @param unfocusColor the color of the border when the component is
     * unfocused
     */
    public static void addFocusBorder(JComponent component, Color focusColor, Color unfocusColor) {
        // Định nghĩa các viền matte
        MatteBorder focusedBorder = BorderFactory.createMatteBorder(0, 0, 2, 0, focusColor);
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

    /**
     * Adds commas to a number string for formatting purposes.
     *
     * @param num the number string to format
     * @return the formatted number string with commas
     */
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

    /**
     * Removes commas from a number string.
     *
     * @param num the number string from which to remove commas
     * @return the number string without commas
     */
    public static String removeCommasFromNumber(String num) {
        num = num.trim();
        if (num.isEmpty()) {
            return num;
        }

        // Use regex to remove all commas
        return num.replaceAll(",", "");
    }

    /**
     * Adds a DocumentListener to the specified JTextField to format the text as
     * a price with commas.
     *
     * @param textField the JTextField to which the DocumentListener is added
     */
    public static void addPriceDocumentListener(JTextField textField) {
        textField.getDocument().addDocumentListener(new DocumentListener() {
            ScheduledFuture<?> scheduledFuture;

            @Override
            public void insertUpdate(DocumentEvent e) {
                schedulePriceUpdate(textField);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                schedulePriceUpdate(textField);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                schedulePriceUpdate(textField);
            }

            private void schedulePriceUpdate(JTextField textField) {
                if (scheduledFuture != null && !scheduledFuture.isDone()) {
                    scheduledFuture.cancel(false);
                }

                scheduledFuture = SCHEDULED_EXECUTOR_SERVICE.schedule(() -> {
                    SwingUtilities.invokeLater(() -> formatPriceField(textField));
                }, 500, TimeUnit.MILLISECONDS);
            }
        });
    }

    private static void formatPriceField(JTextField textFieldPrice) {
        String price = textFieldPrice.getText().trim();
        String removeCommas = removeCommasFromNumber(price);
        String addCommas = addCommasToNumber(removeCommas);
        textFieldPrice.setText(addCommas);
    }
}
