package restaurant.utils;

import java.io.File;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import restaurant.entity.Invoice;

public class Bill {

    public static void billInvoice(Invoice dataInvoice) {
        if (dataInvoice == null) {
            Dialog.warning(null, "Vui lòng chọn bàn đã gọi món!");
            return;
        }

        // get invoice id 
        int invoiceID = dataInvoice.getInvoiceID();

        // Create JFileChooser for file selection
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Chọn nơi lưu hóa đơn");
        fileChooser.setAcceptAllFileFilterUsed(false);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("DOCX files", "docx");
        fileChooser.addChoosableFileFilter(filter);

        // Set default file name
        String defaultFileName = "hoadon" + invoiceID + ".docx";
        fileChooser.setSelectedFile(new File(defaultFileName));

        // Get forrmated time
        Date paymentTime = dataInvoice.getPaymentTime();
        String formattedPaymentTime = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy").format(paymentTime);

        // User cancelled the operation
        int userSelection = fileChooser.showSaveDialog(null);
        if (userSelection != JFileChooser.APPROVE_OPTION) {
            Dialog.success(null, "Thanh toán đơn hàng [ " + invoiceID + " ] thành công!\n\n"
                    + "Vào lúc " + formattedPaymentTime);
            return;
        }

        File fileToSave = fileChooser.getSelectedFile();
        String docxFilePath = fileToSave.getAbsolutePath();

        // Ensure the file has a .docx extension
        if (!docxFilePath.toLowerCase().endsWith(".docx")) {
            docxFilePath += ".docx";
        }

        try {
            // Create map contains the parameters and values ​​of the report
            Hashtable<String, Object> map = new Hashtable<>();
            map.put("ToInvoiceID", dataInvoice.getInvoiceID());

            // Compile files report
            JasperReport report = JasperCompileManager.compileReport("src/restaurant/report/reportInvoice.jrxml");
            JasperPrint jasperPrint = JasperFillManager.fillReport(report, map, XJdbc.getConnection());

            // Export the report to DOCX
            JRDocxExporter exporter = new JRDocxExporter();
            exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
            exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(docxFilePath));
            exporter.exportReport();

            // Hiển thị thông báo lưu thành công
            Dialog.success(null, "Thanh toán đơn hàng [ " + invoiceID + " ] thành công!\n\n"
                    + "Vào lúc " + formattedPaymentTime + "\n\n"
                    + "Hóa đơn đã được lưu tại: " + docxFilePath);
        } catch (SQLException | JRException e) {
            e.printStackTrace();
            Dialog.alert(null, "Không thể tạo hóa đơn!");
        }
    }
}
