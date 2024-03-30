package restaurant.helper;

import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ValidateForm {

    //nếu trống thì trả về true, còn điền thông tin đầy đủ thì trả về false
    public static boolean checkTrong(JTextField txtField, String mgs) {
        String txtValue = txtField.getText().trim();
        if (txtValue.length() == 0) {
            JOptionPane.showMessageDialog(null, mgs);
            txtField.setBackground(Color.red);
            txtField.requestFocus();
            return true;
        }
        txtField.setBackground(Color.white);
        return false;
    }

    //kiểm tra xem có đúng định dạng Email hay không
    public static boolean checkEmail(JTextField txtField, String mgs) {
        String txtValue = txtField.getText().trim();
        String mauEmail = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        //nếu sai định dạng email thì báo lỗi, đúng thì return true
        if (!txtValue.matches(mauEmail)) {
            JOptionPane.showMessageDialog(null, mgs);
            txtField.setBackground(Color.red);
            txtField.requestFocus();
            return false;
        }
        txtField.setBackground(Color.white);
        return true;
    }

    //kiểm tra xem số điện thoại có đúng định dạng hay không
    public static boolean checkSoDienThoai(JTextField txtField, String mgs) {
        String txtValue = txtField.getText().trim();
        String mauSDT = "^0\\d{9}$";
        //nếu sai định dạng số điện thoại thì báo lỗi, đúng thì return true(0945784918)
        if (!txtValue.matches(mauSDT)) {
            JOptionPane.showMessageDialog(null, mgs);
            txtField.setBackground(Color.red);
            txtField.requestFocus();
            return false;
        }
        txtField.setBackground(Color.white);
        return true;
    }

    //kiểm tra định dạng ngày tháng
    public static boolean checkNgay(JTextField txtField, String mgs) {
        String txtValue = txtField.getText().trim();
        String mauDate = "^[0-3][0-9]/[01][0-9]/(19|20)[0-9]{2}$";
        //nếu sai định dạng ngày thì báo lỗi, đúng thì return true(01/01/2000)
        if (!txtValue.matches(mauDate)) {
            JOptionPane.showMessageDialog(null, mgs);
            txtField.setBackground(Color.red);
            txtField.requestFocus();
            return false;
        }
        txtField.setBackground(Color.white);
        return true;
    }
}
