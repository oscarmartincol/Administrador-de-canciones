package manager;

import java.util.List;

public class PlayList {

    private String name;
    List<Song> songs;
    public PlayList(String name, List<Song> songs){
        setName(name);
        setSongs(songs);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }
}
