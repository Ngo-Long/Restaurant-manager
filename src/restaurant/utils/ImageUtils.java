package restaurant.utils;

import java.io.File;
import java.awt.Image;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;

public class ImageUtils {

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

        int result = fileChooser.showOpenDialog(frame);
        if (result == JFileChooser.APPROVE_OPTION) {
            // Get selected file
            File selectedFile = fileChooser.getSelectedFile();

            // Get absolute path of selected image
            String imagePath = selectedFile.getAbsolutePath();

            // Set image icon for the button
            setImageButtonIcon(imagePath, btnImage);

            return imagePath;
        }

        return null;
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

        Image image = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
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
