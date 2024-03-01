import javax.swing.*;
import java.awt.*;

public class AnimalGUI extends JFrame {

    public AnimalGUI() {
        setTitle("Animal GUI");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(5, 1));

        addAnimalImage(panel, "images/pig.jpg");
        addAnimalImage(panel, "images/cat.jpg");
        addAnimalImage(panel, "images/dogs.jpg");
        addAnimalImage(panel, "images/rabbit.jpg");
        addAnimalImage(panel, "images/bird.jpg");

        getContentPane().add(panel);
        setVisible(true);
    }

    private void addAnimalImage(JPanel panel, String imagePath) {
        ImageIcon imageIcon = new ImageIcon(imagePath);
        JLabel label = new JLabel(imageIcon);
        panel.add(label);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new AnimalGUI();
            }
        });
    }
}
