package tema1;

import PaqueteLectura.Lector;

/**
 * Práctica 1 - Ejercicio 4
 *
 * Un edificio de oficinas está conformado por 8 pisos (1..8) y 4 oficinas por
 * piso (1..4). Realice un programa que permita informar la cantidad de personas
 * que concurrieron a cada oficina de cada piso. Para esto, simule la llegada de
 * personas al edificio de la siguiente manera: a cada persona se le pide el nro.
 * de piso y nro. de oficina a la cual quiere concurrir. La llegada de personas
 * finaliza al indicar un nro. de piso 9. Al finalizar la llegada de personas,
 * informe lo pedido.
 */
public class Ej04Oficinas {

    private static final int PISOS = 8;
    private static final int OFICINAS = 4;
    private static final int FIN = 9;

    public static void main(String[] args) {
        int[][] personas = new int[PISOS][OFICINAS];

        System.out.print("Ingrese nro. de piso (1..8, 9 para finalizar): ");
        int piso = Lector.leerInt();
        while (piso != FIN) {
            System.out.print("Ingrese nro. de oficina (1..4): ");
            int oficina = Lector.leerInt();
            personas[piso - 1][oficina - 1]++;

            System.out.print("\nIngrese nro. de piso (1..8, 9 para finalizar): ");
            piso = Lector.leerInt();
        }

        System.out.println("\n--- CANTIDAD DE PERSONAS POR OFICINA ---");
        for (int p = 0; p < PISOS; p++) {
            System.out.print("Piso " + (p + 1) + ": ");
            for (int o = 0; o < OFICINAS; o++) {
                System.out.print("[Ofi " + (o + 1) + ": " + personas[p][o] + "] ");
            }
            System.out.println();
        }
    }
}
