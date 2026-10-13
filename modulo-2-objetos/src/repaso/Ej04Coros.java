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
public class Ej04Coros {

    public static void main(String[] args) {

        // ----- Coro semicircular (3 coristas) -----
        Director d1 = new Director(10, "Ana", 11111111, 45);
        Coro semi = new CoroSemicircular("Coro Sol", d1, 3);

        semi.agregarCorista(new Corista(9, "Juan", 22222222, 20));
        semi.agregarCorista(new Corista(7, "Maria", 33333333, 22));
        semi.agregarCorista(new Corista(5, "Pedro", 44444444, 25));

        // ----- Coro por hileras (2 hileras x 3 integrantes) -----
        Director d2 = new Director(15, "Carlos", 55555555, 50);
        Coro hileras = new CoroHilera("Coro Luna", d2, 2, 3);

        hileras.agregarCorista(new Corista(8, "Lucia", 66666666, 19));
        hileras.agregarCorista(new Corista(8, "Tomas", 77777777, 21));
        hileras.agregarCorista(new Corista(8, "Sofia", 88888888, 23));
        hileras.agregarCorista(new Corista(6, "Diego", 99999999, 24));
        hileras.agregarCorista(new Corista(4, "Laura", 12345678, 26)); // distinto -> mal formado
        hileras.agregarCorista(new Corista(6, "Martin", 87654321, 30));

        // ----- Impresión -----
        System.out.println(semi.toString());
        System.out.println("Bien formado: " + semi.coroBienFormado());

        System.out.println(hileras.toString());
        System.out.println("Bien formado: " + hileras.coroBienFormado());
    }
}
