import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    //Declare variables
    public JPanel mainPanel;
    public JPanel containerPanel;
    public JCheckBox checkH2;
    public JComboBox optionColorH1;
    public JTextArea textH2;
    public JComboBox optionColorH2;
    public JComboBox optionColorBody;
    private JButton selectimageButton;
    public JLabel imagePreview;
    private JLabel imageText;
    public JTextArea textBody;
    public JTextArea textH1;
    private JButton createButton;

    //Start point of the APP
    public static void main(String[] args) {
        new Main();
    }
    //Main function of the APP
    public Main() {
        imageText.setVisible(false);
        //Bounds of the frame and title
        int widthFrame = 600;
        int heightFrame = 600;
        String title = "Creador HTML";
        //Call to the frame creator
        CreateFrame.createFrame(title, mainPanel, widthFrame, heightFrame);
        //Check Listener for H2 fields
        checkH2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (checkH2.isSelected()) {
                    textH2.setVisible(true);
                    optionColorH2.setVisible(true);
                } else {
                    textH2.setVisible(false);
                    optionColorH2.setVisible(false);
                }
            }
        });
        //Image selection button listener
        selectimageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    imagePreview.setIcon(ImageSelector.imageSelector(imagePreview, imageText));
                } catch (NullPointerException e1) {
                    imagePreview.setIcon(null);
                }
            }
        });
        //Option list listener for H1
        optionColorH1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SetColor.setColor(optionColorH1,textH1);
            }
        });
        //Option list listener for H2
        optionColorH2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SetColor.setColor(optionColorH2,textH2);
            }
        });
        //Option list listener for Body
        optionColorBody.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SetColor.setColor(optionColorBody,textBody);
            }
        });
        //Create button listener
        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FileCreator.fileCreator(optionColorH2,optionColorH1,optionColorBody,checkH2,textH1,textH2,textBody,imageText);
            }
        });
    }


}
