import manager.Library;
import manager.PlayList;
import manager.Song;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static int option;
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        Library library = new Library(addSongs());
        List<Song> filterSongs;
        List<PlayList> playlists = new ArrayList<>();
        String genre;
        int year;
        do {
            //Mostrar menú y leer número por teclado
            selectionMenu();
            setOption(input.nextInt());
            input.nextLine();
            if (getOption() == 1 || getOption() == 2) {
                //Imprimir canciones con orden especifico.
                library.sortSongs(getOption());
                System.out.println(library);
            } else if (getOption() == 3) {
                //Imprimir las canciones que corresponden al género seleccionado
                genre = selectGenre();
                if (genre != null){
                    filterSongs = library.filterGenre(genre);
                    System.out.println("{" + filterSongs + "}");
                }else {
                    System.out.println("La opción seleccionada no es válida");
                }
            } else if (getOption() == 4) {
                //imprimir canciones lanzadas en el año seleccionado
                year = selectYear();
                if (year != 0){
                    filterSongs = library.filterYear(year);
                    System.out.println("{" + filterSongs + "}");
                }else {
                    System.out.println("La opción seleccionada no es válida");
                }
            } else if (getOption() == 5) {
                if (playlists.isEmpty()){
                    System.out.println("Seleccione la playlist que desea crear.");
                    System.out.println("1.Playlist de canciones de Rock");
                    System.out.println("2.Playlist de canciones Bachata y Pop.");
                    setOption(input.nextInt());
                    input.nextLine();
                    playlists.add(createPlaylist(getOption(), library.getSongs()));
                } else if (playlists.size() < 2) {
                    System.out.println("Seleccione la acción que desea realizar");
                    if(playlists.get(0).getName().equals("Lista de Rock")){
                        System.out.println("1.Crear playlst de canciones Bachata y Pop.");
                        System.out.println("2.Mostrar lista de canciones de Rock");
                        setOption(input.nextInt());
                        input.nextLine();
                        if(getOption() == 1){
                            playlists.add(createPlaylist(2, library.getSongs()));
                        }else {
                            System.out.println(playlists.get(0));
                        }
                    }else {
                        System.out.println("1.Crear playlst de canciones Rock.");
                        System.out.println("2.Mostrar lista de canciones de Bachata y pop.");
                        setOption(input.nextInt());
                        input.nextLine();
                        if(getOption() == 1){
                            playlists.add(createPlaylist(1, library.getSongs()));
                        }else {
                            System.out.println(playlists.get(0));
                        }
                    }
                }else {
                    System.out.println("1.Mostrar playlist de canciones Rock.");
                    System.out.println("2.Mostrar lista de canciones de Bachata y pop.");
                    setOption(input.nextInt());
                    input.nextLine();
                    if(getOption() == 1){
                        if (playlists.get(0).getName().equals("Lista de Rock")) {
                            System.out.println(playlists.get(0));
                        }else {
                            System.out.println(playlists.get(1));
                        }
                    }else {
                        if (playlists.get(0).getName().equals("Lista de Bachata y Pop")) {
                            System.out.println(playlists.get(0));
                        }else {
                            System.out.println(playlists.get(1));
                        }
                    }
                }
            }else {
                if (getOption() == 6) {
                    System.out.println("Ha salido del programa.");
                }else {
                    System.out.println("La opción seleccionada no es válida");
                }
            }
            if (getOption() != 6){
                System.out.println("Oprima enter para continuar");
                input.nextLine();
            }
        }while (option != 6);
    }

    public static int getOption() {
        return option;
    }

    public static void setOption(int option) {
        Main.option = option;
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
        songs.add(new Song("Gorilla",2012, 5, 248, "Pop"
                , "https://www.deezer.com/es/track/72516902?autoplay=true"
                , "Canción de Bruno Mars"));
        songs.add(new Song("I don't want to miss a thing", 1998, 6, 300, "Rock"
                , "https://www.deezer.com/es/track/624823?autoplay=true"
                , "Canción de Aerosmith famosa por la película Armageddon."));
        return songs;
    }

    public static void selectionMenu() {
        System.out.println("Seleccione la operación que desea realizar: ");
        System.out.println("1.Mostrar todas las canciones de la biblioteca ordenadas según la duración");
        System.out.println("2.Mostrar todas las canciones de la biblioteca ordenadas según el año de lanzamiento");
        System.out.println("3.Mostrar canciones aplicando filtro por género musical");
        System.out.println("4.Mostrar canciones aplicando filtro por año de lanzamiento");
        System.out.println("5.Crear o mostrar playlist con canciones determinadas");
        System.out.println("6.Salir del programa");
    }

    public static String selectGenre() {
        String genre;
        System.out.println("Seleccione el género musical para aplicar filtro");
        System.out.println("1.Bachata");
        System.out.println("2.Rock");
        System.out.println("3.Pop");
        setOption(input.nextInt());
        input.nextLine();
        if (getOption() == 1){
            genre = "Bachata";
        } else if (getOption() == 2) {
            genre = "Rock";
        }else if (getOption() == 3) {
            genre = "Pop";
        }else {
            genre = null;
        }
        setOption(0);
        return genre;
    }

    public static int selectYear() {
        int year;
        System.out.println("Seleccione el año de estreno para filtrar las canciones");
        System.out.println("1.1981");
        System.out.println("2.1998");
        System.out.println("3.2005");
        System.out.println("4.2012");
        System.out.println("5.2022");
        setOption(input.nextInt());
        input.nextLine();
        year = switch (getOption()) {
            case 1 -> 1981;
            case 2 -> 1998;
            case 3 -> 2005;
            case 4 -> 2012;
            case 5 -> 2022;
            default -> 0;
        };
        setOption(0);
        return year;
    }
    public static PlayList createPlaylist(int option, List<Song> songs){
        PlayList playlist;
        List<Song> ssongs = new ArrayList<>();
        if(option == 1) {
            for(Song song: songs) {
                if (song.getGenre().equals("Rock"))
                    ssongs.add(song);
            }
            playlist = new PlayList("Lista de Rock", ssongs);
        }else {
            for(Song song: songs) {
                if (!song.getGenre().equals("Rock"))
                    ssongs.add(song);
            }
            playlist = new PlayList("Lista de Bachata y Pop", ssongs);
        }
        System.out.println("Se ha creado la playlist con éxito.");
        return playlist;
    }
}