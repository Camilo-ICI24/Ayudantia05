import java.util.ArrayList;

public class Biblioteca {

    private String nombre;
    private ArrayList<Libro> libros;

    public Biblioteca() {
        this.libros = new ArrayList<>();
    }

    public void mostrarLibrosDisponibles() {
        boolean hayLibros = false;
        for (Libro libro : this.libros) {
            if (libro.getDisponible()) {
                System.out.println(libro.mostrarInfo());
                hayLibros = true;
            }
        }
        if (!hayLibros) {
            System.out.println("No hay libros disponibles.");
        }
    }

    public Libro buscarLibroPorTitulo(String titulo) {
        for (Libro libro : this.libros) {
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                return libro;
            }
        }
        return null;
    }

    public ArrayList<Libro> buscarLibroPorAutor(String autor) {
        ArrayList<Libro> librosDelAutor = new ArrayList<>();
        for (Libro libro : this.libros) {
            if (libro.getAutor().equals(autor)) {
                librosDelAutor.add(libro);
            }
        }
        return librosDelAutor;
    }


    public boolean agregarLibro (Libro libro) {
        if (libro.getISBN() != null) {
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

    public boolean prestarLibro(String titulo) {
        Libro libro = buscarLibroPorTitulo(titulo);
        if (libro != null && libro.getDisponible()) {
            libro.prestar();
            return true;
        } else {
            return false;
        }
    }

    public boolean devolverLibro(String titulo) {
        Libro libro = buscarLibroPorTitulo(titulo);
        if (libro != null) {
            libro.devolver();
            return true;
        } else {
            return false;
        }
    }
}