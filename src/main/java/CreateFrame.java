import javax.swing.*;

public class CreateFrame {
    //Function for create the JFrame
    public static JFrame createFrame(String title, JPanel panel, int width, int height) {
        JFrame frame = new JFrame();
        frame.setTitle(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setSize(width, height);
        return frame;
    }
}
