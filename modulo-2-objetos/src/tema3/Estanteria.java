package tema3;

public class Estanteria {

    private final Estante inferior = new Estante();
    private final Estante superior = new Estante();

    public void agregarLibro(Libro libro) {
        if (!inferior.estanteLleno()) {
            inferior.agregarLibro(libro);
        } else {
            superior.agregarLibro(libro);
        }
    }

    public int getCantLibros() {
        return inferior.getCantLibros() + superior.getCantLibros();
    }

    public boolean existeLibro(String titulo) {
        return inferior.buscarLibro(titulo) != null || superior.buscarLibro(titulo) != null;
    }
}
