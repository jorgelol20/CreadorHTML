import javax.swing.*;
import java.text.MessageFormat;

public class ImageSelector {
    public static Icon imageSelector(JLabel imagePreview, JLabel imageText) {
        //Use of the JFileChoose for get the directory where the user wants to save the file
        JFileChooser directoryChooser = new JFileChooser();
        directoryChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        directoryChooser.showOpenDialog(null);

        if (checkImageType(directoryChooser)) {
            ImageIcon image = new ImageIcon(directoryChooser.getSelectedFile().getAbsolutePath());
            //Separe the string for "/" to get the name of the file and print it on the JLabel imageText
            imageText.setText(directoryChooser.getSelectedFile().getAbsolutePath());
            //Return the image like ImageIcon
            return new ImageIcon(image.getImage().getScaledInstance(imagePreview.getWidth(), imagePreview.getHeight(), 1));
        } else {
            return imageSelector(imagePreview, imageText);
        }
    }

    //Function for check if the image have a correct format
    private static boolean checkImageType(JFileChooser chooser) {
        //Array with the correct formats
        String[] imageTypes = {"jpg", "jpeg", "png"};
        String errorText = MessageFormat.format("Solo se permite una imagen {0}, {1} o {2}", imageTypes[0], imageTypes[1], imageTypes[2]);
        boolean imageTypeFound = false;

        for (String imageType : imageTypes) {
            if (chooser.getSelectedFile().getAbsolutePath().contains(imageType)) {
                imageTypeFound = true;
            }
        }
        if (imageTypeFound) {
            return true;
        } else {
            JOptionPane.showMessageDialog(null, errorText, "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
}
