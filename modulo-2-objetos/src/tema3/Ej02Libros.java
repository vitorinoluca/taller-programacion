package tema3;

/**
 * Práctica 3 - Ejercicio 2
 *
 * A- Queremos modelar libros y autores. Los libros conocen su título, el primer
 *    autor, editorial, año de edición, ISBN y precio. Del autor se conoce
 *    nombre, biografía y origen.
 *    (i)   Modifique la clase Libro para considerar que el primer autor sea un
 *          objeto de la clase Autor.
 *    (ii)  Implemente la clase Autor, con constructores y métodos que permitan
 *          consultar/modificar sus atributos y obtener una representación
 *          String (formada por nombre, biografía y origen).
 *    (iii) Realice las modificaciones necesarias en la clase Libro (en
 *          constructores y métodos).
 *    (iv)  Incluya al toString de Libro el precio final, calculado adicionando
 *          el 21% de IVA al precio del libro. Para realizar este cálculo,
 *          implemente un método aparte.
 * B- Modifique el programa Demo01Constructores para instanciar los libros con
 *    su autor, considerando las modificaciones realizadas. Informe la
 *    representación String de los libros. A partir de un objeto libro, ¿cómo
 *    obtengo el nombre de su autor? (con getPrimerAutor())
 */
public class Ej02Libros {

    public static void main(String[] args) {
        Autor autor = new Autor("Herbert Schildt", "informático, programador y músico", "USA");
        Libro libro1 = new Libro("Java: A Beginner's Guide", "Mcgraw-Hill", 2014, autor, "978-0071809252", 21.72);
        Libro libro2 = new Libro("Learning Java by Building Android Games", "CreateSpace Independent Publishing", autor, "978-1512108347");

        System.out.println("=== Representacion de libro1 ===");
        System.out.println(libro1);
        System.out.println("=== Representacion de libro2 ===");
        System.out.println(libro2);
        System.out.println("=== Nombre del autor de libro1 ===");
        System.out.println(libro1.getPrimerAutor());
    }
}
