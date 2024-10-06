public class Libro {
    private String titulo;
    private String autor;
    private String genero;
    private String isbn;
    private int cantidadDisponible;
    private boolean disponible;

    public Libro(String titulo, String autor, String genero, String isbn,
                   int cantidadDisponible, boolean disponible) {
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.isbn = isbn;
        this.cantidadDisponible = cantidadDisponible;
        this.disponible = disponible;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getGenero() {
        return genero;
    }

    public String getISBN() {
        return isbn;
    }

    public int getCantidadDisponible() {
        return cantidadDisponible;
    }

    public boolean getDisponible() {
        return disponible;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setISBN(String ISBN) {
        this.isbn = ISBN;
    }

    public void setCantidadDisponible(int cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public void prestar() {
        if (cantidadDisponible > 0) {
            cantidadDisponible--;
            if (cantidadDisponible == 0) {
                disponible = false;
            }
        }
    }

    public void devolver() {
        cantidadDisponible++;
        if (cantidadDisponible > 0) {
            disponible = true;
        }
    }

    public String mostrarInfo(String isbn) {
        if (this.isbn.equals(isbn)) {
            return "Título: "+this.titulo+", Autor: "+this.autor+", Género: "+this.genero+
                    ", ISBN: "+this.isbn+ ", Número disponible: " +this.cantidadDisponible+
                    ", Disponible: " +this.disponible;
        }
        return null;
    }

    @Override
    public String toString() {
        return "Título: "+this.titulo+", Autor: "+this.autor+", Género: "+this.genero+
                ", ISBN: "+this.isbn+ ", Número disponible: " +this.cantidadDisponible+
                ", Disponible: " +this.disponible;
    }
}