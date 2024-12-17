import javax.swing.*;
import java.awt.*;

public class SetColor {
    public static void setColor(JComboBox colorOption, JTextArea textArea) {
        if (colorOption.getSelectedIndex() == 0) {
            textArea.setForeground(Color.black);
        } else if (colorOption.getSelectedIndex() == 1) {
            textArea.setForeground(Color.red);
        }else if (colorOption.getSelectedIndex() == 2) {
            textArea.setForeground(Color.blue);
        }else if (colorOption.getSelectedIndex() == 3) {
            textArea.setForeground(Color.green);
        }
    }
}
