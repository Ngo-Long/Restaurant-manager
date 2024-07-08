package restaurant.utils;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JTextField;
import javax.swing.AbstractButton;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import com.toedter.calendar.JDateChooser;

public class ComponentUtils {

    /**
     * Adds listeners to a JTextField and other specified JComponents to trigger
     * an action.
     *
     * @param textField The JTextField to monitor for text changes.
     * @param action The action to perform when a change occurs.
     * @param components Additional components to attach the action to.
     */
    public static void addListeners(JTextField textField, Runnable action, JComponent... components) {
        // Attach DocumentListener to the JTextField
        textField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                action.run();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                action.run();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                action.run();
            }
        });

        // Attach ActionListeners to the specified components
        ActionListener actionListener = (ActionEvent e) -> action.run();

        for (JComponent component : components) {
            if (component instanceof AbstractButton) {
                ((AbstractButton) component).addActionListener(actionListener);
            } else if (component instanceof JComboBox) {
                ((JComboBox<?>) component).addActionListener(actionListener);
            }
        }
    }

    /**
     * Adds listeners to JDateChooser components to trigger an action when the
     * date changes.
     *
     * @param startDate The JDateChooser for the start date.
     * @param endDate The JDateChooser for the end date.
     * @param action The action to perform when the date changes.
     */
    public static void addDateListeners(JDateChooser startDate, JDateChooser endDate, Runnable action) {
        // Use PropertyChangeListener for JDateChooser
        PropertyChangeListener dateChangeListener = (PropertyChangeEvent evt) -> {
            if ("date".equals(evt.getPropertyName())) {
                action.run();
            }
        };

        startDate.getDateEditor().addPropertyChangeListener(dateChangeListener);
        endDate.getDateEditor().addPropertyChangeListener(dateChangeListener);
    }
}
