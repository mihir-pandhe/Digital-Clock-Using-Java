import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class DigitalClock extends JFrame {
    private JLabel timeLabel;
    private JLabel dateLabel;
    private JComboBox<String> timeZoneComboBox;

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

        timeZoneComboBox = new JComboBox<>(TimeZone.getAvailableIDs());
        timeZoneComboBox.addActionListener(e -> updateTime());
        add(timeZoneComboBox, BorderLayout.NORTH);

        Timer timer = new Timer(1000, e -> updateTime());
        timer.start();

        setVisible(true);
    }

    private void updateTime() {
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        timeFormat.setTimeZone(TimeZone.getTimeZone((String) timeZoneComboBox.getSelectedItem()));
        dateFormat.setTimeZone(TimeZone.getTimeZone((String) timeZoneComboBox.getSelectedItem()));
        Date now = new Date();
        timeLabel.setText(timeFormat.format(now));
        dateLabel.setText(dateFormat.format(now));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(DigitalClock::new);
    }
}
