package tema3;

public class Estante {

    private static final int CAPACIDAD = 20;

    private final Libro[] libros = new Libro[CAPACIDAD];
    private int cantLibros = 0;

    public void agregarLibro(Libro libro) {
        libros[cantLibros++] = libro;
    }

    public int getCantLibros() {
        return cantLibros;
    }

    public boolean estanteLleno() {
        return cantLibros == CAPACIDAD;
    }

    public Libro buscarLibro(String titulo) {
        for (int i = 0; i < cantLibros; i++) {
            if (libros[i].getTitulo().equals(titulo)) return libros[i];
        }
        return null;
    }
}
