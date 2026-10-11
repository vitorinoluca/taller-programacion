package tema3;

public class Libro {

    private String titulo;
    private Autor primerAutor;
    private String editorial;
    private int añoEdicion;
    private String ISBN;
    private double precio;

    public Libro(String unTitulo, String unaEditorial, int unAñoEdicion, Autor unPrimerAutor, String unISBN, double unPrecio) {
        titulo = unTitulo;
        editorial = unaEditorial;
        añoEdicion = unAñoEdicion;
        primerAutor = unPrimerAutor;
        ISBN = unISBN;
        precio = unPrecio;
    }

    public Libro(String unTitulo, String unaEditorial, Autor unPrimerAutor, String unISBN) {
        this(unTitulo, unaEditorial, 2015, unPrimerAutor, unISBN, 100);
    }

    public Libro() {
    }

    public String getTitulo() {
        return titulo;
    }

    public String getEditorial() {
        return editorial;
    }

    public int getAñoEdicion() {
        return añoEdicion;
    }

    // devuelve el nombre del primer autor
    public String getPrimerAutor() {
        return primerAutor.getNombre();
    }

    public String getISBN() {
        return ISBN;
    }

    public double getPrecio() {
        return precio;
    }

    public void setTitulo(String unTitulo) {
        titulo = unTitulo;
    }

    public void setEditorial(String unaEditorial) {
        editorial = unaEditorial;
    }

    public void setAñoEdicion(int unAño) {
        añoEdicion = unAño;
    }

    public void setPrimerAutor(Autor unPrimerAutor) {
        primerAutor = unPrimerAutor;
    }

    public void setISBN(String unISBN) {
        ISBN = unISBN;
    }

    public void setPrecio(double unPrecio) {
        precio = unPrecio;
    }

    // precio con 21% de IVA
    public double getPrecioFinal() {
        return precio * 1.21;
    }

    @Override
    public String toString() {
        return titulo + " por " + primerAutor + " - " + añoEdicion + " - " + " ISBN: " + ISBN + " con precio: $" + getPrecioFinal();
    }
}
