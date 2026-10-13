/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repaso;

/**
 *
 * @author luca
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