package tema3;

/**
 * Práctica 3 - Ejercicio 3
 *
 * A- Defina una clase para representar estantes. Un estante almacena a lo
 *    sumo 20 libros. Implemente un constructor que permita iniciar el estante
 *    sin libros. Provea métodos para:
 *    (i)   devolver la cantidad de libros almacenados en el estante
 *    (ii)  devolver si el estante está lleno
 *    (iii) agregar un libro que se recibe al estante
 *    (iv)  dado un título, buscar y devolver el libro con ese título (o null si
 *          no existe).
 * B- Realice un programa que instancie un estante. Cargue varios libros. A
 *    partir del estante, busque e informe el autor del libro "Mujercitas".
 * C- Piense: ¿Qué modificaría en la clase definida para ahora permitir estantes
 *    que almacenen como máximo N libros? ¿Cómo instanciaría el estante?
 *    (recibir N en el constructor, dimensionar el vector con N e instanciar
 *    con new Estante(N))
 */
public class Ej03Estantes {

    public static void main(String[] args) {
        Estante estante = new Estante();
        Autor autor = new Autor("luca vitorino", "estudiante de lic en sistemas", "la plata");
        estante.agregarLibro(new Libro("Mujercitas", "gtrgreg", 2004, autor, "asdasd", 23));
        estante.agregarLibro(new Libro("asdasd", "retwerd", 2005, autor, "asdasd", 45));
        estante.agregarLibro(new Libro("asdasd", "dfgdfg", 2006, autor, "asdasd", 50));

        System.out.println(estante.getCantLibros());
        Libro mujercitas = estante.buscarLibro("Mujercitas");
        if (mujercitas != null) {
            System.out.println("El autor de Mujercitas es " + mujercitas.getPrimerAutor());
        }
    }
}
