package restaurant.utils;

import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExportFile {

    public static void exportToExcel(JTable table, String title) {
        // Choice file
        JFileChooser jFileChooser = new JFileChooser();
        int userSelection = jFileChooser.showSaveDialog(null);
        if (userSelection != JFileChooser.APPROVE_OPTION) {
            Dialog.error(null, "Bạn chưa chọn file!");
            return;
        }

        File saveFile = jFileChooser.getSelectedFile();
        if (saveFile == null) {
            Dialog.error(null, "Xuất file thất bại!");
            return;
        }

        saveFile = new File(saveFile.toString() + ".xlsx");
        try (Workbook wb = new XSSFWorkbook(); FileOutputStream out = new FileOutputStream(saveFile)) {
            Sheet sheet = wb.createSheet(title);
            createHeaderRow(sheet, table);
            populateDataRows(sheet, table);

            // Auto-size columns
            for (int i = 0; i < table.getColumnCount(); i++) {
                sheet.autoSizeColumn(i);
            }

            wb.write(out);
            openFile(saveFile.toString());
            Dialog.success(null, "Xuất file thành công");
        } catch (FileNotFoundException e) {
            Dialog.error(null, "Không thể tạo file: " + e.getMessage());
        } catch (IOException io) {
            Dialog.error(null, "Lỗi khi ghi vào file: " + io.getMessage());
        }
    }

    static void createHeaderRow(Sheet sheet, JTable table) {
        Row rowCol = sheet.createRow(0);
        for (int i = 0; i < table.getColumnCount(); i++) {
            Cell cell = rowCol.createCell(i);
            cell.setCellValue(table.getColumnName(i));

            // Apply header style
            CellStyle headerStyle = sheet.getWorkbook().createCellStyle();
            Font headerFont = sheet.getWorkbook().createFont();
            headerFont.setBold(true);
            headerStyle.setFont(headerFont);
            headerStyle.setAlignment(HorizontalAlignment.CENTER);
            headerStyle.setVerticalAlignment(VerticalAlignment.CENTER);
            cell.setCellStyle(headerStyle);
        }
    }

    static void populateDataRows(Sheet sheet, JTable table) {
        for (int j = 0; j < table.getRowCount(); j++) {
            Row row = sheet.createRow(j + 1);
            for (int k = 0; k < table.getColumnCount(); k++) {
                Cell cell = row.createCell(k);
                if (table.getValueAt(j, k) != null) {
                    cell.setCellValue(table.getValueAt(j, k).toString());
                }

                // Apply data cell style
                CellStyle dataStyle = sheet.getWorkbook().createCellStyle();
                dataStyle.setAlignment(HorizontalAlignment.LEFT);
                dataStyle.setVerticalAlignment(VerticalAlignment.CENTER);
                cell.setCellStyle(dataStyle);
            }

        }
    }

    static void openFile(String filePath) {
        if (!Desktop.isDesktopSupported()) {
            Dialog.error(null, "Không hỗ trợ mở file tự động trên hệ thống của bạn.");
            return;
        }
        try {
            File file = new File(filePath);
            Desktop.getDesktop().open(file);
        } catch (IOException e) {
            Dialog.error(null, "Không thể mở file: " + e.getMessage());
        }

    }
}
