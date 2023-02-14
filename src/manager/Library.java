package manager;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Clase que representa la biblioteca principal de canciones
 */
public class Library {
    /**
     * Lista donde se almacenan las canciones
     */
    private List<Song> songs;

    /**
     * Constructor para crear la biblioteca principal
     * @param songs Canciones
     */
    public Library(List<Song> songs){
        setSongs(songs);
    }

    public List<Song> getSongs() {
        return songs;
    }

    /**
     * Método para almacenar canciones el la lista
     * @param songs Canciones
     */
    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    /**
     * Método para filtrar canciones por año
     * @param year año
     * @return Canciones lanzadas en el año solicitado
     */
    public List<Song> filterYear(int year) {
        List<Song> filterSongs= new ArrayList<>();
        for (Song song : getSongs()) {
            if(song.getYear() == year) {
                filterSongs.add(song);
            }
        }
        return filterSongs;
    }

    /**
     * Método para filtrar canciones por género musical
     * @param genre Género musical
     * @return Lista de canciones con el género solicitado
     */
    public List<Song> filterGenre(String genre) {
        List<Song> filterSongs = new ArrayList<>();
        for(Song song : getSongs()){
            if(song.getGenre().equals(genre)) {
                filterSongs.add(song);
            }
        }
        return filterSongs;
    }

    /**
     * Método para ordenar canciones por duración o año
     * @param option Selección del parametro a ordenar
     */
    public void sortSongs(int option) {
        //Opción para ordenar canciones por año de lanzamiento
        if (option != 1)
            getSongs().sort(Comparator.comparing(Song::getYear));
        else {
            //Opción para ordenar por duración de la canción
            getSongs().sort(Comparator.comparing(Song::getDuration));
        }
    }
    /**
     * Método para mostrar las canciones guardadas
     * @return Canciones guardadas.
     */
    @Override
    public String toString() {
        return "Biblioteca Principal{ " +
                "Canciones=\n " + songs +
                '}';
    }
}
