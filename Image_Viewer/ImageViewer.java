import javax.swing.*;
import java.io.File;
import javax.swing.filechooser.FileNameExtensionFilter;


public class ImageViewer {
    public static void openImageViewer() {
        // File Chooser to select an image
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Select an Image");
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        // Filter to only show image files
        FileNameExtensionFilter imageFilter = new FileNameExtensionFilter(
                    "Image Files (JPG, PNG, GIF, BMP)", "jpg", "png", "gif", "bmp");
        fileChooser.setFileFilter(imageFilter);
        int result = fileChooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            String filePath = selectedFile.getAbsolutePath();

            // Frame to display the image
            JFrame imageFrame = new JFrame("Image Viewer");
            imageFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            imageFrame.setSize(1000, 600);

            JLabel imageLabel = new JLabel();
            imageLabel.setHorizontalAlignment(SwingConstants.CENTER);

            ImageIcon imageIcon = new ImageIcon(filePath);
            imageLabel.setIcon(imageIcon);

            imageFrame.add(imageLabel);
            imageFrame.setVisible(true);
        }
    }
}
