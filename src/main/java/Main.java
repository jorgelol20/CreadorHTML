import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    //Declare variables
    public JPanel mainPanel;
    public JPanel containerPanel;
    private JCheckBox checkH2;
    private JComboBox optionColorH1;
    private JTextArea textH2;
    private JComboBox optionColorH2;
    private JComboBox optionColorBody;
    private JButton selectimageButton;
    private JLabel imagePreview;
    private JLabel imageText;
    private JTextArea textBody;
    private JTextArea textH1;
    private JButton createButton;

    //Start point of the APP
    public static void main(String[] args) {
        new Main();
    }
    //Main function of the APP
    public Main() {
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
                
            }
        });
    }


}
