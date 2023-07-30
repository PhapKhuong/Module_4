import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConfirmDialog extends JFrame {
    public ConfirmDialog() {
        this.setSize(400, 250);
        setLocation(500, 300);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel label = new JLabel("Message Demo");
        add(label);
        JButton button = new JButton("Hit me");
        add(button, "North", 1);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showConfirmDialog(null, "Are you sure");
            }
        });
    }

    public static void main(String[] args) {
        ConfirmDialog confirmDialog = new ConfirmDialog();
        confirmDialog.setVisible(true);
    }
}
