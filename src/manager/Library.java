package manager;
import java.util.List;

public class Library {
    private List<Song> songs;
    public Library(List<Song> songs){
        setSongs(songs);
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }
}
