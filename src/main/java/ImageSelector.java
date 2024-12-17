import javax.swing.*;
import java.text.MessageFormat;

public class ImageSelector {
    public static Icon imageSelector(JLabel imagePreview, JLabel imageText) {

        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        chooser.showOpenDialog(null);

        if (checkImageType(chooser)) {
            ImageIcon image = new ImageIcon(chooser.getSelectedFile().getAbsolutePath());
            String[] splitURL = chooser.getSelectedFile().getAbsolutePath().split("\\\\");
            imageText.setText(splitURL[splitURL.length-1]);
            return new ImageIcon(image.getImage().getScaledInstance(imagePreview.getWidth(), imagePreview.getHeight(), 1));
        }else{
            return imageSelector(imagePreview, imageText);
        }
    }
    //Function for check if the image have a correct format
    private static boolean checkImageType(JFileChooser chooser) {
        String[] imageTypes = {"jpg", "jpeg", "png"};
        String errorText = MessageFormat.format("Seleccione una imagen {0}, {1} o {2}", imageTypes[0], imageTypes[1], imageTypes[2]);
        boolean imageTypeFound = false;
        for (String imageType : imageTypes) {
            if (chooser.getSelectedFile().getAbsolutePath().contains(imageType)) {
                imageTypeFound = true;
            }
        }
        if (imageTypeFound) {
            return true;
        }else{
            JOptionPane.showMessageDialog(null, errorText, "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
}
