/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repaso;

/*
 * 5- Representar un sistema para gestionar los estrenos de una plataforma de
 * streaming. El sistema conoce el nombre de la plataforma, la cantidad de
 * suscriptores, y mantiene una estructura que representa la agenda de estrenos
 * (1..C, 1..12) que almacenará un estreno por categoría y mes del año. Por cada
 * categoría se registrarán a lo sumo 12 estrenos. De cada estreno se guarda el
 * título, el tipo de contenido (serie o película), recaudación obtenida y la
 * cantidad de visualizaciones.
 *
 * a) Genere las clases necesarias. Provea constructores para iniciar: los
 *    estrenos a partir de la información necesaria; el sistema a partir del
 *    nombre de la plataforma, cantidad de suscriptores y las cantidad de
 *    categorías C de la agenda de estrenos. Inicialmente, la plataforma no
 *    tiene estrenos registrados.
 *
 * b) Implemente los métodos necesarios, en las clases que corresponda, para:
 *    i.   Agregar un estreno en la categoría X. El estreno debe ser registrado
 *         en el primer mes disponible de esa categoría. Asuma que hay espacio.
 *    ii.  Listar los estrenos de la categoría X, devolviendo un String con la
 *         representación de los mismos en el siguiente formato:
 *         "Título, tipo de contenido, recaudación, cantidad de visualizaciones"
 *    iii. Calcular la ganancia total de la plataforma en estrenos. Considere
 *         que la ganancia de un estreno es la mitad de la recaudación.
 *    iv.  Obtener un String que represente el sistema de estrenos siguiendo el
 *         ejemplo:
 *         "Nombre de la Plataforma, Cantidad de Suscriptores
 *          Categoría 1: listado de estrenos de la categoría 1
 *          …
 *          Categoría C: listado de estrenos de la categoría C
 *          Ganancia total en estrenos"
 *
 * c) Realice un programa que instancie una plataforma de streaming. Registre
 *    varios estrenos y compruebe el correcto funcionamiento de los métodos
 *    implementados.
 */
public class Ej05Estrenos {
    public static void main(String[] args) {
        Sistema sistema = new Sistema("netflix", 1000, 4);

        sistema.agregarEstreno(new Estreno("Charly", "pelicula", 1200.00, 2000), 1);
        sistema.agregarEstreno(new Estreno("Dark", "serie", 3000.00, 5000), 1);
        sistema.agregarEstreno(new Estreno("Roma", "pelicula", 800.50, 1500), 1);

        sistema.agregarEstreno(new Estreno("Stranger Things", "serie", 9000.00, 20000), 2);
        sistema.agregarEstreno(new Estreno("Okja", "pelicula", 500.00, 900), 2);

        sistema.agregarEstreno(new Estreno("Narcos", "serie", 4000.00, 8000), 3);
        // categoria 4 queda sin estrenos

        System.out.println("Estrenos categoria 1:" + sistema.listarEstrenosCatX(1));
        System.out.println("Estrenos categoria 4:" + sistema.listarEstrenosCatX(4));
        System.out.println("Ganancia total: $" + sistema.calcularGananciaTotal());
        System.out.println();
        System.out.println(sistema);
    }
}