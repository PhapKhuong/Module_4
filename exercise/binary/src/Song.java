import java.io.File;
import java.io.Serializable;

public class Song implements Serializable {
    private int sId;
    private String name;
    private String singer;
    private int musicType;
    private File file;

    public Song() {
    }

    public Song(int sId, String name, String singer, int musicType, File file) {
        this.sId = sId;
        this.name = name;
        this.singer = singer;
        this.musicType = musicType;
        this.file = file;
    }

    public int getsId() {
        return sId;
    }

    public void setsId(int sId) {
        this.sId = sId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public int getMusicType() {
        return musicType;
    }

    public void setMusicType(int musicType) {
        this.musicType = musicType;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }
}