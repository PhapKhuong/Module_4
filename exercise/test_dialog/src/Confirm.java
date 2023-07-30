import javax.swing.*;

public class Confirm {
    public static void main(String[] args) {
        int option = JOptionPane.showConfirmDialog(null, "Are you sure?",
                "Delete choosed records", JOptionPane.YES_NO_OPTION);
        System.out.println(option);
    }
}
