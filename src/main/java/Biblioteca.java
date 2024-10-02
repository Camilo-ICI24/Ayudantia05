import java.util.ArrayList;

public class Biblioteca {

    private String nombre;
    private ArrayList<Libro> libros;

    public Biblioteca() {
        this.libros = new ArrayList<>();
    }

    public boolean agregarLibro (Libro libro) {
        if (libro.getISBN() == null) {
            this.libros.add(libro);
            return true;
        }
        else {
            return false;
        }
    }

}
