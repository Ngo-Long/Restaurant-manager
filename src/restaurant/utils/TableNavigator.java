package restaurant.utils;

import javax.swing.JTable;

public class TableNavigator {

    private static int selectedRowIndex = -1;
    private static JTable targetTable;

    // Constructor to initialize the class with the table reference
    public TableNavigator(JTable table) {
        targetTable = table;
    }

    public static void edit(int rowIndex, JTable table) {
        selectedRowIndex = rowIndex;
        selectTableRow(rowIndex, table);
        navigate(selectedRowIndex, table);
    }

    public static void selectTableRow(int rowIndex, JTable table) {
        if (table != null && rowIndex >= 0 && rowIndex < table.getRowCount()) {
            table.setRowSelectionInterval(rowIndex, rowIndex);
            table.scrollRectToVisible(table.getCellRect(rowIndex, 0, true));
        }
    }

    public static void navigate(int rowIndex, JTable table) {
        boolean editing = (rowIndex >= 0);
        boolean isFirst = (rowIndex == 0);
        boolean isLast = (rowIndex == table.getRowCount() - 1);
    }

    public static void first() {
        selectedRowIndex = 0;
        edit(selectedRowIndex, targetTable);
    }

    public static void prev() {
        if (selectedRowIndex > 0) {
            selectedRowIndex--;
            edit(selectedRowIndex, targetTable);
        }
    }

    public static void next() {
        if (targetTable != null && selectedRowIndex < targetTable.getRowCount() - 1) {
            selectedRowIndex++;
            edit(selectedRowIndex, targetTable);
        }
    }

    public static void last() {
        if (targetTable != null) {
            selectedRowIndex = targetTable.getRowCount() - 1;
            edit(selectedRowIndex, targetTable);
        }
    }
}
