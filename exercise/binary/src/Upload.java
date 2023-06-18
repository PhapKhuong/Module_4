import javax.swing.*;
import java.io.*;

public class Upload {
    private static final String FILE_PATH = "C:\\Dropbox\\Codegym\\module4\\exercise\\binary\\src\\song.dat";

    public static void writeObject(Song song) throws IOException {
        FileOutputStream fos = new FileOutputStream(FILE_PATH);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(song);
        oos.close();
    }

    public static Song readObject() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(FILE_PATH);
        ObjectInputStream ois = new ObjectInputStream(fis);
        Song song = (Song) ois.readObject();
        ois.close();
        return song;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        JFileChooser jFileChooser = new JFileChooser();
        jFileChooser.showOpenDialog(null);
        File file = jFileChooser.getSelectedFile();

        Song song = new Song(1,"d", "ds", 1, file);
        writeObject(song);

        System.out.println(readObject());

    }

}
