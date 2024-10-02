import java.util.ArrayList;

public class Biblioteca {

    private String nombre;
    private ArrayList<Libro> libros;

    public Biblioteca() {
        this.libros = new ArrayList<>();
    }

    public Libro buscarLibroPorTitulo(String titulo) {
        for (Libro libro : this.libros) {
            if (libro.getTitulo().equals(titulo)) {
                return libro;
            }
        }
        return null;
    }

    public Libro buscarLibroPorAutor(String autor) {
        for (Libro libro : this.libros) {
            if (libro.getAutor().equals(autor)) {
                return libro;
            }
        }
        return null;
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
