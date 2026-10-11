package tema1;

import PaqueteLectura.GeneradorAleatorio;
import PaqueteLectura.Lector;

/**
 * Práctica 1 - Ejercicio 3
 *
 * Un teatro realizó durante los 7 días de la semana 4 funciones diarias.
 * Escriba un programa que cargue en una estructura la cantidad de espectadores
 * que concurrieron a cada día/función. Una vez cargada, realice recorridos
 * independientes para:
 *  - Dado un día (int) leído de teclado, informar la cantidad de espectadores
 *    que concurrieron a cada función en ese día.
 *  - Dada una función (int) leída de teclado, informar la cantidad de
 *    espectadores que concurrieron en cada día a esa función.
 *  - Informar en qué día y función hubo más espectadores.
 */
public class Ej03Teatro {

    private static final int FUNCIONES = 4;
    private static final int DIAS = 7;

    public static void main(String[] args) {
        GeneradorAleatorio.iniciar();

        int[][] espectadores = new int[FUNCIONES][DIAS];
        for (int f = 0; f < FUNCIONES; f++) {
            for (int d = 0; d < DIAS; d++) {
                espectadores[f][d] = GeneradorAleatorio.generarInt(100);
            }
        }

        for (int f = 0; f < FUNCIONES; f++) {
            for (int d = 0; d < DIAS; d++) {
                System.out.print(" " + espectadores[f][d]);
            }
            System.out.println();
        }

        System.out.println();
        System.out.println("Ingrese un numero de dia 1..7");
        int dia = Lector.leerInt();
        for (int f = 0; f < FUNCIONES; f++) {
            System.out.println("la funcion " + (f + 1) + " tuvo " + espectadores[f][dia - 1] + " espectadores");
        }

        System.out.println();
        System.out.println("ingrese un numero de funcion 1..4");
        int funcion = Lector.leerInt();
        for (int d = 0; d < DIAS; d++) {
            System.out.println("en el dia " + (d + 1) + " en la funcion " + funcion + " hubieron " + espectadores[funcion - 1][d] + " espectadores");
        }

        System.out.println();
        int max = -1;
        int maxDia = -1;
        int maxFuncion = -1;
        for (int f = 0; f < FUNCIONES; f++) {
            for (int d = 0; d < DIAS; d++) {
                if (espectadores[f][d] > max) {
                    max = espectadores[f][d];
                    maxFuncion = f + 1;
                    maxDia = d + 1;
                }
            }
        }
        System.out.println("el dia " + maxDia + " en la funcion " + maxFuncion + " fue donde hubo mas espectadores: " + max);
    }
}
