import java.util.ArrayList;

public class Principal {

    public static void main(String[] args) {
        Principal principal = new Principal();
        principal.iniciarBiblioteca();
    }

    public void iniciarBiblioteca() {
        Biblioteca bibliotecaCentral = definirTodo();
        mostrarLibrosDisponibles(bibliotecaCentral);
        prestarLibro(bibliotecaCentral, "Beastars - Vol 2");
        devolverLibro(bibliotecaCentral, "Dr. Stone - Vol 2");
        buscarLibroPorTitulo(bibliotecaCentral, "The Promised Neverland - Vol 18");
        buscarLibrosPorAutor(bibliotecaCentral, "Gosho Aoyama");
        eliminarLibro(bibliotecaCentral, "Beastars - Vol 2");
    }

    public Biblioteca definirTodo() {
        Biblioteca bibliotecaCentral = new Biblioteca();

        agregarLibro(bibliotecaCentral, "Beastars - Vol 2", "Paru Itagaki", "Seinen",
                "978-84-18450-05-1", 4);
        agregarLibro(bibliotecaCentral, "The Promised Neverland - Vol 18", "Kaiu Shirai",
                "Shounen", "978-84-18645-35-8", 15);
        agregarLibro(bibliotecaCentral, "Dr. Stone - Vol 2", "Riichiro Inagaki", "Shounen",
                "978-1-9747-0262-6", 1);
        agregarLibro(bibliotecaCentral, "Yu-Gi-Oh! Vol 2", "Kazuki Takahashi", "Shounen",
                "978-607-568-114-6", 0);
        agregarLibro(bibliotecaCentral, "Detective Conan - Vol 2.2", "Gosho Aoyama", "Shounen",
                "4830826790", 0);
        agregarLibro(bibliotecaCentral, "Detective Conan - Vol 2.1", "Gosho Aoyama", "Shounen",
                "1167882574", 4);
        agregarLibro(bibliotecaCentral, "Detective Conan - Vol 1.2", "Gosho Aoyama", "Shounen",
                "0419352622", 1);
        agregarLibro(bibliotecaCentral, "Detective Conan - Vol 1.1", "Gosho Aoyama", "Shounen",
                "1693607498", 9);

        return bibliotecaCentral;
    }

    public void agregarLibro(Biblioteca biblioteca, String titulo, String autor, String genero, String isbn, int cantidad) {
        Libro libro = new Libro(titulo, autor, genero, isbn, cantidad, cantidad > 0);
        biblioteca.agregarLibro(libro);
    }

    public void mostrarLibrosDisponibles(Biblioteca biblioteca) {
        System.out.println("Libros disponibles:");
        biblioteca.mostrarLibrosDisponibles();
    }

    public void prestarLibro(Biblioteca biblioteca, String titulo) {
        System.out.println("Se ha solicitado '" + titulo + "'...");
        biblioteca.prestarLibro(titulo);
        mostrarLibrosDisponibles(biblioteca);
    }

    public void devolverLibro(Biblioteca biblioteca, String titulo) {
        System.out.println("Se está devolviendo '" + titulo + "'...");
        biblioteca.devolverLibro(titulo);
        mostrarLibrosDisponibles(biblioteca);
    }

    public void buscarLibroPorTitulo(Biblioteca biblioteca, String titulo) {
        System.out.println("Buscando '" + titulo + "'...");
        Libro encontrado = biblioteca.buscarLibroPorTitulo(titulo);
        if (encontrado != null) {
            System.out.println("Libro encontrado: " + encontrado.mostrarInfo());
        } else {
            System.out.println("El libro '" + titulo + "' no fue encontrado.");
        }
    }

    public void buscarLibrosPorAutor(Biblioteca biblioteca, String autor) {
        System.out.println("Buscando libros del autor '" + autor + "'...");
        ArrayList<Libro> librosDelEscritor = biblioteca.buscarLibroPorAutor(autor);
        if (!librosDelEscritor.isEmpty()) {
            for (Libro libro : librosDelEscritor) {
                System.out.println(libro.mostrarInfo());
            }
        } else {
            System.out.println("No se encontraron libros del autor '" + autor + "'.");
        }
    }

    public void eliminarLibro(Biblioteca biblioteca, String titulo) {
        System.out.println("Eliminando '" + titulo + "' de la biblioteca...");
        biblioteca.eliminarLibro(titulo);
        System.out.println("Libro eliminado con éxito");
        System.out.println("Biblioteca actualizada: ");
        mostrarLibrosDisponibles(biblioteca);
    }
}