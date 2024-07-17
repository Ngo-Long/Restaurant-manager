package restaurant.utils;

import java.awt.Font;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Component;

import java.util.Set;
import java.util.List;
import java.util.HashSet;
import java.util.function.Function;

import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;

public class XComboBox {

    /**
     * Populates the specified JComboBox with unique values extracted from the
     * provided list using the given property extractor function.
     *
     * @param <T> the type of objects in the dataList
     * @param comboBox the JComboBox to populate
     * @param dataList the list of objects to extract data from
     * @param propertyExtractor a function to extract the property value from
     * each object
     */
    public static <T> void loadDataToComboBox(JComboBox comboBox, List<T> dataList,
            Function<T, String> propertyExtractor) {
        // create combobox model and hash set
        DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>();
        Set<String> uniqueValues = new HashSet<>();

        // extract and collect unique property values
        for (T dataItem : dataList) {
            uniqueValues.add(propertyExtractor.apply(dataItem));
        }

        // add the sorted unique values to the combo box model
        uniqueValues.stream().sorted().forEach(comboBoxModel::addElement);

        // Set the model to the combo box
        comboBox.setModel(comboBoxModel);
    }

    /**
     * Inserts a placeholder as the first item in the combo box model.
     *
     * @param comboBox The JComboBox to which the placeholder will be added.
     * @param placeholder The placeholder text to be added.
     */
    public static void insertPlaceholder(JComboBox<String> comboBox, String placeholder) {
        // Get the combo box's model
        DefaultComboBoxModel<String> comboBoxModel = (DefaultComboBoxModel<String>) comboBox.getModel();

        // Add placeholder to the beginning of the combo box model
        comboBoxModel.insertElementAt(placeholder, 0);

        // Set the selected item to the placeholder
        comboBox.setSelectedIndex(0);
    }

    // set combobox style
    public static void setComboboxStyle(JComboBox<?>... comboBoxes) {
        for (JComboBox<?> cbBox : comboBoxes) {
            cbBox.setBackground(new Color(160, 160, 160));
            cbBox.setForeground(Color.black);
            cbBox.setFont(new Font("Arial", Font.PLAIN, 14));
            cbBox.setBorder(BorderFactory.createEmptyBorder());
            cbBox.setCursor(new Cursor(Cursor.HAND_CURSOR));

            cbBox.setRenderer(new DefaultListCellRenderer() {
                @Override
                public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                    JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                    label.setBackground(Color.white);
                    label.setForeground(Color.black);
                    label.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
                    if (isSelected) {
                        label.setBackground(Color.lightGray);
                        label.setForeground(Color.black);
                    }
                    return label;
                }
            });
        }
    }
}
