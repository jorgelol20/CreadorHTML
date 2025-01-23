import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLOutput;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;

public class FileCreator {
    //Selection of the directory where the user wants to create the file
    public static void fileCreator(JComboBox optionColorH2, JComboBox optionColorH1, JComboBox optionColorBody, JCheckBox checkH2, JTextArea textH1, JTextArea textH2, JTextArea textBody, JLabel imageText) {
        JFileChooser directoryChooser = new JFileChooser();
        directoryChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        directoryChooser.showOpenDialog(null);
        if (directoryChooser.getSelectedFile().isDirectory()) {
            createFile(directoryChooser, optionColorH2, optionColorH1, optionColorBody, checkH2, textH1, textH2, textBody, imageText);
        } else {
            JOptionPane.showMessageDialog(null, "El directorio seleccionado no es válido");
        }

    }

    //Creation of the file. First it will be deleted if exist to don't have anyproblem.
    private static void createFile(JFileChooser chooser, JComboBox optionColorH2, JComboBox optionColorH1, JComboBox optionColorBody, JCheckBox checkH2, JTextArea textH1, JTextArea textH2, JTextArea textBody, JLabel imageText) {
        File htmlFile = new File(chooser.getSelectedFile() + "\\index.txt");
        try {
            if (new File(htmlFile.getAbsoluteFile() + ".html").delete()) ;
            if (htmlFile.delete()) ;
            if (htmlFile.createNewFile()) {
                writeFile(htmlFile, chooser, optionColorH2, optionColorH1, optionColorBody, checkH2, textH1, textH2, textBody, imageText);
            } else {
                JOptionPane.showMessageDialog(null, "No se ha podido crear el archivo");
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "No se ha podido crear el archivo");
            System.out.println(e.getMessage());
        }
    }
//Function to write the file and rename it
    private static void writeFile(File htmlFile, JFileChooser chooser, JComboBox optionColorH2, JComboBox optionColorH1, JComboBox optionColorBody, JCheckBox checkH2, JTextArea textH1, JTextArea textH2, JTextArea textBody, JLabel imageText) {
        String basicContent =
                "<!DOCTYPE html>\n" +
                        "<html lang=\"es-ES\">\n" +
                        "  <head>\n" +
                        "    <meta charset=\"UTF-8\" />\n" +
                        "    <title>Document</title>\n" +
                        "    <style>\n" +
                        "      h1 {\n" +
                        "          color: %s;\n" +
                        "      }\n" +
                        "      h2 {\n" +
                        "          color: %s;\n" +
                        "          display: %s;\n" +
                        "      }\n" +
                        "      p {\n" +
                        "          color: %s;\n" +
                        "      }\n" +
                        "    </style>\n" +
                        "  </head>\n" +
                        "  <body>\n" +
                        "    <h1>%s</h1>\n" +
                        "    <h2>%s</h2>\n" +
                        "    <p>%s</p>\n" +
                        "    <img src=\"%s\" alt=\"%s\" />\n" +
                        "  </body>\n" +
                        "</html>";

        String colorH1 =
                switch (String.valueOf(optionColorH1.getSelectedItem())) {
                    case "Azul" -> "blue";
                    case "Verde" -> "#FF0000";
                    case "Rojo" -> "red";
                    case null, default -> "black";
                };
        String colorH2 =
                switch (String.valueOf(optionColorH2.getSelectedItem())) {
                    case "Azul" -> "blue";
                    case "Verde" -> "#FF0000";
                    case "Rojo" -> "red";
                    case null, default -> "black";
                };
        String displayH2 = "none";
        if (checkH2.isSelected()) {
            displayH2 = "";
        }
        String colorP =
                switch (String.valueOf(optionColorBody.getSelectedItem())) {
                    case "Azul" -> "blue";
                    case "Verde" -> "#FF0000";
                    case "Rojo" -> "red";
                    case null, default -> "black";
                };
        String textOfH1 = textH1.getText().replace("\n", "<br>");
        String textOfH2 = textH2.getText().replace("\n", "<br>");
        String textP = textBody.getText().replace("\n", "<br>");
        String imgSource = imageText.getText();
        String alternateImgText = imageText.getText();
        String htmlContent = String.format(basicContent, colorH1, colorH2, displayH2, colorP, textOfH1, textOfH2, textP, imgSource, alternateImgText);
        //Write on it
        try (FileWriter writeFile = new FileWriter(htmlFile.getAbsoluteFile())) {
            writeFile.write(htmlContent);
        } catch (IOException e) {
            if (htmlFile.delete()) {
                JOptionPane.showMessageDialog(null, "No se ha podido crear el archivo");
                System.out.println(e.getMessage());
            }
        }
        //Rename the file
        if (htmlFile.renameTo(new File(htmlFile.getAbsoluteFile() + ".html"))) {
            JOptionPane.showMessageDialog(null, "El archivo se ha creado correctamente");
        } else {
            JOptionPane.showMessageDialog(null, "No se ha podido crear el archivo");
        }
    }
}

