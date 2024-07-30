import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DigitalClock extends JFrame {
    private JLabel timeLabel;
    private JLabel dateLabel;
    private JComboBox<String> fontComboBox;
    private JComboBox<String> colorComboBox;

    public DigitalClock() {
        setTitle("Digital Clock");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        timeLabel = new JLabel("", JLabel.CENTER);
        timeLabel.setFont(new Font("Arial", Font.BOLD, 30));
        add(timeLabel, BorderLayout.CENTER);

        dateLabel = new JLabel("", JLabel.CENTER);
        dateLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        add(dateLabel, BorderLayout.SOUTH);

        JPanel controlPanel = new JPanel();
        fontComboBox = new JComboBox<>(new String[] { "Arial", "Courier", "Times New Roman" });
        fontComboBox.addActionListener(e -> updateFont());
        controlPanel.add(fontComboBox);

        colorComboBox = new JComboBox<>(new String[] { "Black", "Red", "Blue" });
        colorComboBox.addActionListener(e -> updateColor());
        controlPanel.add(colorComboBox);

        add(controlPanel, BorderLayout.NORTH);

        Timer timer = new Timer(1000, e -> updateTime());
        timer.start();

        setVisible(true);
    }

    private void updateTime() {
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date now = new Date();
        timeLabel.setText(timeFormat.format(now));
        dateLabel.setText(dateFormat.format(now));
    }

    private void updateFont() {
        String selectedFont = (String) fontComboBox.getSelectedItem();
        timeLabel.setFont(new Font(selectedFont, Font.BOLD, 30));
        dateLabel.setFont(new Font(selectedFont, Font.PLAIN, 20));
    }

    private void updateColor() {
        String selectedColor = (String) colorComboBox.getSelectedItem();
        switch (selectedColor) {
            case "Black":
                timeLabel.setForeground(Color.BLACK);
                dateLabel.setForeground(Color.BLACK);
                break;
            case "Red":
                timeLabel.setForeground(Color.RED);
                dateLabel.setForeground(Color.RED);
                break;
            case "Blue":
                timeLabel.setForeground(Color.BLUE);
                dateLabel.setForeground(Color.BLUE);
                break;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(DigitalClock::new);
    }
}
