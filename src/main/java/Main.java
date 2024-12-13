import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.aspose.*;
public class Main {
    private JTextField h1Texto;
    private JComboBox colorH1;
    private JPanel panel;
    private JCheckBox añadirH2;
    private JTextField h2Texto;
    private JComboBox colorH2;
    private JTextArea textoCuerpo;
    private JCheckBox añadirImagen;
    private JLabel imagen;

    public Main(JFrame frame){
        JFileChooser elegirArchivo = new JFileChooser();
        colorH1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (colorH1.getSelectedIndex() == 0){
                    h1Texto.setForeground(Color.black);
                }else if (colorH1.getSelectedIndex() == 1){
                    h1Texto.setForeground(Color.red);
                }else if (colorH1.getSelectedIndex() == 2){
                    h1Texto.setForeground(Color.blue);
                }else if (colorH1.getSelectedIndex() == 3){
                    h1Texto.setForeground(Color.green);
                }
            }
        });
        añadirH2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (añadirH2.isSelected()){
                    h2Texto.setVisible(true);
                    colorH2.setVisible(true);
                }else{
                    h2Texto.setVisible(false);
                    colorH2.setVisible(false);
                }
            }
        });
        colorH2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (colorH2.getSelectedIndex() == 0){
                    h2Texto.setForeground(Color.black);
                }else if (colorH2.getSelectedIndex() == 1){
                    h2Texto.setForeground(Color.red);
                }else if (colorH2.getSelectedIndex() == 2){
                    h2Texto.setForeground(Color.blue);
                }else if (colorH2.getSelectedIndex() == 3){
                    h2Texto.setForeground(Color.green);
                }
            }
        });
        añadirImagen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (añadirImagen.isSelected()){
                    elegirArchivo.showOpenDialog(frame);
                    System.out.println(elegirArchivo.getSelectedFile());
                    String rutaImagen = elegirArchivo.getSelectedFile().getAbsolutePath();
                    Image imagenSeleccionada = new ImageIcon(rutaImagen).getImage();
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("CreadorHTML");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new Main(frame).panel);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setLocation(0,0);
        frame.setSize(600,600);
    }
}