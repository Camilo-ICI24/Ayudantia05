import java.util.ArrayList;

public class Principal {
    private Biblioteca bibliotecaCentral;

    public static void main(String[] args) {
        Principal principal = new Principal();
        principal.iniciarBiblioteca();
    }

    public void iniciarBiblioteca() {
        definirTodo();
        mostrarLibrosDisponibles();
        prestarLibro("Beastars - Vol 2");
        devolverLibro("Dr. Stone - Vol 2");
        buscarLibroPorTitulo("The Promised Neverland - Vol 18");
        buscarLibrosPorAutor("Gosho Aoyama");
        eliminarLibro("Beastars - Vol 2");
    }

    public void definirTodo() {
        bibliotecaCentral = new Biblioteca();

        agregarLibro("Beastars - Vol 2", "Paru Itagaki", "Seinen",
                "978-84-18450-05-1", 4);
        agregarLibro("The Promised Neverland - Vol 18", "Kaiu Shirai",
                "Shounen", "978-84-18645-35-8", 15);
        agregarLibro("Dr. Stone - Vol 2", "Riichiro Inagaki", "Shounen",
                "978-1-9747-0262-6", 1);
        agregarLibro("Yu-Gi-Oh! Vol 2", "Kazuki Takahashi", "Shounen",
                "978-607-568-114-6", 0);
        agregarLibro("Detective Conan - Vol 2.2", "Gosho Aoyama", "Shounen",
                "4830826790", 0);
        agregarLibro("Detective Conan - Vol 2.1", "Gosho Aoyama", "Shounen",
                "1167882574", 4);
        agregarLibro("Detective Conan - Vol 1.2", "Gosho Aoyama", "Shounen",
                "0419352622", 1);
        agregarLibro("Detective Conan - Vol 1.1", "Gosho Aoyama", "Shounen",
                "1693607498", 9);
    }

    public void agregarLibro(String titulo, String autor, String genero, String isbn, int cantidad) {
        Libro libro = new Libro(titulo, autor, genero, isbn, cantidad, cantidad > 0);
        bibliotecaCentral.agregarLibro(libro);
    }

    public void mostrarLibrosDisponibles() {
        System.out.println("Libros disponibles:");
        bibliotecaCentral.mostrarLibrosDisponibles();
    }

    public void prestarLibro(String titulo) {
        System.out.println("Se ha solicitado '" + titulo + "'...");
        bibliotecaCentral.prestarLibro(titulo);
        mostrarLibrosDisponibles();
    }

    public void devolverLibro(String titulo) {
        System.out.println("Se está devolviendo '" + titulo + "'...");
        bibliotecaCentral.devolverLibro(titulo);
        mostrarLibrosDisponibles();
    }

    public void buscarLibroPorTitulo(String titulo) {
        System.out.println("Buscando '" + titulo + "'...");
        Libro encontrado = bibliotecaCentral.buscarLibroPorTitulo(titulo);
        if (encontrado != null) {
            System.out.println("Libro encontrado: " + encontrado.mostrarInfo());
        } else {
            System.out.println("El libro '" + titulo + "' no fue encontrado.");
        }
    }

    public void buscarLibrosPorAutor(String autor) {
        System.out.println("Buscando...");
        ArrayList<Libro> librosDelEscritor = bibliotecaCentral.buscarLibroPorAutor(autor);
        if (!librosDelEscritor.isEmpty()) {
            for (Libro libro : librosDelEscritor) {
                System.out.println(libro.mostrarInfo());
            }
        } else {
            System.out.println("No se encontraron libros del autor '" + autor + "'.");
        }
    }

    public void eliminarLibro(String titulo) {
        System.out.println("Eliminando '" + titulo + "' de la biblioteca...");
        bibliotecaCentral.eliminarLibro(titulo);
        System.out.println("Libro eliminado con éxito");
        System.out.println("Biblioteca actualizada: ");
        mostrarLibrosDisponibles();
    }
}

