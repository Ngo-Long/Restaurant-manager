package restaurant.utils;

import java.awt.Dimension;
import java.io.File;
import java.awt.Image;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class XImage {

    public static final String JPG = ".jpg";
    public static final String JPEG = ".jpeg";
    public static final String PNG = ".png";
    public static final String GIF = ".gif";

    /**
     * Opens a file chooser dialog to select an image file from the directory.
     * Sets the selected image as the icon for a JButton.
     *
     * @param frame the parent JFrame for the file chooser dialog
     * @param btnImage the JButton to set the image icon
     * @return the absolute path of the selected image file, or null if no file
     * was selected
     */
    public static String chooseImageFromDirectory(JFrame frame, JButton btnImage) {
        String imgPath = "src/restaurant/img";
        JFileChooser fileChooser = new JFileChooser(imgPath);
        fileChooser.setFileFilter(
                new FileNameExtensionFilter("Image files", "jpg", "jpeg", "png", "gif")
        );

        int result = fileChooser.showOpenDialog(frame);
        if (result == JFileChooser.APPROVE_OPTION) {
            // Get selected file
            File selectedFile = fileChooser.getSelectedFile();

            // Get absolute path of selected image
            String imagePath = selectedFile.getAbsolutePath();

            if (!isImageFile(imagePath)) {
                Dialog.warning(frame, "Đường dẫn không hợp lệ");
                return null;
            }

            try {
                // Định nghĩa đường dẫn tệp đích trong thư mục imgPath
                File targetFile = new File(imgPath, selectedFile.getName());

                // Sao chép tệp đã chọn vào thư mục đích
                Files.copy(Paths.get(imagePath), targetFile.toPath(), StandardCopyOption.REPLACE_EXISTING);

                // Set image icon for the button
                setImageButtonIcon(targetFile.getAbsolutePath(), btnImage);

                return targetFile.getAbsolutePath();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return imagePath;
        }

        return null;
    }

    private static boolean isImageFile(String filePath) {
        String lowerCaseFilePath = filePath.toLowerCase();
        return lowerCaseFilePath.endsWith(JPG)
                || lowerCaseFilePath.endsWith(JPEG)
                || lowerCaseFilePath.endsWith(PNG)
                || lowerCaseFilePath.endsWith(GIF);
    }

    /**
     * Sets the image icon for a JButton, scaled to fit the button's size.
     *
     * @param imagePath the path of the image file
     * @param button the JButton to set the image icon
     */
    public static void setImageButtonIcon(String imagePath, JButton button) {
        int width = button.getWidth();
        int height = button.getHeight();

        // Check if the image path is valid
        if (!isImageFile(imagePath)) {
            Dialog.alert(null, "Đường dẫn không hợp lệ");
            return;
        }

        ImageIcon icon = new ImageIcon(imagePath);
        Image image = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(image);
        button.setIcon(scaledIcon);
    }

    /**
     * Updates the image icon of a JLabel, scaled to fit the label's size.
     *
     * @param imagePath the path of the image file
     * @param labelLogo the JLabel to update with the new image icon
     */
    public static void setImageLabelIcon(String imagePath, JLabel labelLogo) {
        ImageIcon icon = new ImageIcon(imagePath);

        int width = labelLogo.getWidth();
        int height = labelLogo.getHeight();

        Image image = icon.getImage().getScaledInstance(width, height, Image.SCALE_REPLICATE);
        ImageIcon scaledIcon = new ImageIcon(image);
        labelLogo.setIcon(scaledIcon);
    }

    /**
     * Retrieves a scaled ImageIcon based on the specified maximum width and
     * height.
     *
     * @param imageUrl the path of the image file
     * @param maxWidth the maximum width for the scaled image
     * @param maxHeight the maximum height for the scaled image
     * @return a scaled ImageIcon object
     */
    public static ImageIcon getScaledImageIcon(String imageUrl, int maxWidth, int maxHeight) {
        ImageIcon icon = new ImageIcon(imageUrl);
        Image image = icon.getImage();

        // Get size
        int originalWidth = icon.getIconWidth();
        int originalHeight = icon.getIconHeight();

        // Calculate scaled
        double scale = Math.min((double) maxWidth / originalWidth, (double) maxHeight / originalHeight);
        int scaledWidth = (int) (originalWidth * scale);
        int scaledHeight = (int) (originalHeight * scale);

        // Scale the image to the calculated dimensions
        Image scaledImage = image.getScaledInstance(scaledWidth, scaledHeight, Image.SCALE_SMOOTH);

        // Return scaled ImageIcon
        return new ImageIcon(scaledImage);
    }
}
