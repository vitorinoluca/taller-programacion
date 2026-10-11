package tema3;

/**
 * Práctica 3 - Ejercicio 5
 *
 * Representar una estantería hogareña. Esta estantería tiene sólo dos estantes
 * que almacenarán libros (uno será el inferior y otro el superior).
 * (i)   Genere la clase Estantería hogareña. Implemente un constructor que
 *       inicie la estantería con sus dos estantes con capacidad máxima para 20
 *       libros cada uno. Reúse la clase Estante.
 * (ii)  Provea métodos para:
 *       - Agregar un libro a la estantería hogareña. El libro debe agregarse al
 *         estante inferior si no está lleno, caso contrario al superior.
 *       - Obtener la cantidad de libros almacenados en la estantería hogareña
 *         (considerar ambos estantes).
 *       - Dado un título, saber si ese libro está en la estantería hogareña
 *         (ya sea en el estante inferior o en el superior).
 * (iii) Realice un programa que instancie una estantería hogareña, le agregue
 *       libros y compruebe el funcionamiento de los métodos implementados.
 */
public class Ej05Estanteria {

    public static void main(String[] args) {
        Estanteria estanteria = new Estanteria();

        Autor borges = new Autor("Jorge Luis Borges", "Escritor argentino", "Argentina");
        Autor cortazar = new Autor("Julio Cortázar", "Escritor y profesor", "Argentina");

        estanteria.agregarLibro(new Libro("Ficciones", "Sur", 1944, borges, "978-9875666471", 15000.0));
        estanteria.agregarLibro(new Libro("Rayuela", "Sudamericana", 1963, cortazar, "978-8420432224", 18500.0));

        System.out.println(estanteria.getCantLibros());
        System.out.println(estanteria.existeLibro("Ficciones"));
        System.out.println(estanteria.existeLibro("El Aleph"));
    }
}
