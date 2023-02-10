package manager;

/**
 * Clase que representa una canción con sus características.
 */
public class Song {
    /**
     * Representa el título de la canción
     */
    private final String title;
    /**
     * Representa el identificador
     */
    private final int id;
    /**
     * Representa el año de lanzamiento
     */
    private final int year;
    /**
     * Representa la duración en segundos
     */
    private final int duration;
    /**
     * Representa el género musical
     */
    private final String genre;
    /**
     * Representa la caratula
     */
    private final String cover;
    /**
     * Representa información sobre la canción
     */
    private final String description;

    /**
     * Constructor para crear canciones.
     * @param title título
     * @param id identificador
     * @param year año
     * @param duration duración
     * @param genre género
     * @param cover caratula
     * @param description descripción
     */
    public Song(String title, int year, int id, int duration, String genre,
            String cover, String description)
    {
        this.title = title;
        this.id = id;
        this.year = year;
        this.duration = duration;
        this.genre = genre;
        this.cover = cover;
        this.description = description;
    }

    /**
     * Método para mostrar los datos de la canción
     * @return Atributos de la canción
     */
    @Override
    public String toString() {
        return "Canción{" +
                "titulo='" + title + '\'' +
                ", id=" + id +
                ", año=" + year +
                ", duracion='" + duration + '\'' +
                ", genero='" + genre + '\'' +
                ", caratula='" + cover + '\'' +
                ", descripción='" + description + '\'' +
                '}';
    }
}
