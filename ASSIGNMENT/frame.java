import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class frame extends JFrame implements ActionListener {
    private JLabel petLabel;
    private Map<String, ImageIcon> petImages;

    private static final Map<String, String> petData = new HashMap<>();
    static {
        petData.put("cat", "/images/cat.jpg");
        petData.put("dog", "/images/dogs.jpg");
        petData.put("rabbit", "/images/rabbit.jpg");

        petData.put("bird", "/images/bird.jpg");
        petData.put("pig", "/images/pig.jpg");
    }

    public frame() {
        setTitle("Pet Display Frame");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        petImages = new HashMap<>();

        for (String pet : petData.keySet()) {
            ImageIcon imageIcon = new ImageIcon(getClass().getResource(petData.get(pet)));
            petImages.put(pet, imageIcon);
        }

        petLabel = new JLabel(" MY PETS ", JLabel.CENTER);

        JPanel radioPanel = new JPanel(new GridLayout(5, 1));
        ButtonGroup group = new ButtonGroup();
        for (String pet : petData.keySet()) {
            JRadioButton radioButton = new JRadioButton(pet);
            radioButton.setActionCommand(pet);
            radioButton.addActionListener(this);
            group.add(radioButton);
            radioPanel.add(radioButton);
        }

        setLayout(new BorderLayout());

        add(petLabel, BorderLayout.CENTER);
        add(radioPanel, BorderLayout.WEST);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String selectedPet = e.getActionCommand();
        ImageIcon imageIcon = petImages.get(selectedPet);
        petLabel.setIcon(imageIcon);
        petLabel.setText(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new frame();
            }
        });
    }
}
