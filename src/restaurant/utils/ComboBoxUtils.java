package restaurant.utils;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import restaurant.entity.ProductEntity;

public class ComboBoxUtils {

    /**
     * Populates the specified JComboBox with data extracted from the provided
     * list using the given property extractor.
     *
     * @param comboBox the JComboBox to populate
     * @param dataList the list of ProductEntity objects
     * @param propertyExtractor a function to extract the property value from a
     * ProductEntity
     * @param placeholder the placeholder text to add as the first item in the
     * combo box
     */
    public static void addDataToComboBox(JComboBox comboBox, List<ProductEntity> dataList, Function<ProductEntity, String> propertyExtractor, String placeholder) {
        // Add into combobox 
        DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>();
        Set<String> uniqueValues = new HashSet<>();

        // Extract and collect unique property values
        for (ProductEntity dataItem : dataList) {
            uniqueValues.add(propertyExtractor.apply(dataItem));
        }

        // Add "--Lựa chọn--" to the beginning of the combo box
        comboBoxModel.addElement(placeholder);

        // Add the sorted unique values to the combo box model
        uniqueValues.stream().sorted().forEach(comboBoxModel::addElement);

        // Set the model to the combo box
        comboBox.setModel(comboBoxModel);
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
