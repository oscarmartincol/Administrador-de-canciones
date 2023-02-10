import manager.Library;
import manager.Song;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Library library = new Library(addSongs());

    }

    public static List<Song> addSongs(){
        List<Song> songs = new ArrayList<>();
        songs.add(new Song("Bebo", 2022, 1, 236, "Bachata"
                , "https://www.deezer.com/es/album/351762697"
                , "Tema para cuando se es engañado y se quiere beber."));
        songs.add(new Song("Sus Huellas", 2022, 2, 215, "Bachata"
                , "https://www.deezer.com/es/album/351762697"
                , "Tema para comenzar una nueva relación después de una decepción."));
        songs.add(new Song("Ella y yo", 2005, 3, 268, "Bachata"
                , "https://www.deezer.com/es/album/6353736"
                , "Canción de Aventura con Don Omar."));
        songs.add(new Song("Under Pressure", 1981, 4, 240, "Rock"
                , "https://www.deezer.com/es/album/303413"
                ,"Canción de Queen con David Bowie."));
        return songs;
    }
}