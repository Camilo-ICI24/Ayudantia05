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

    public boolean eliminarLibro(String titulo) {
        Libro libro = this.buscarLibroPorTitulo(titulo);
        if (libro != null) {
            this.libros.remove(libro);
            return true;
        }
        return false;
    }

    public String prestarLibro(String titulo) {
        Libro libro = buscarLibroPorTitulo(titulo);
        if (libro != null && libro.getDisponible()) {
            libro.prestar();
            return "Se ha prestado el libro: " + titulo;
        } else {
            return "El libro no está disponible o no existe.";
        }
    }

    public String devolverLibro(String titulo) {
        Libro libro = buscarLibroPorTitulo(titulo);
        if (libro != null) {
            libro.devolver();
            return "El libro " + titulo + "se ha devuelto exitosamente";
        } else {
            return "El libro no está disponible o no existe.";
        }
    }
}
