package tema1;

import PaqueteLectura.GeneradorAleatorio;

/**
 * Práctica 1 - Ejercicio 5
 *
 * El dueño de un restaurante entrevista a cinco clientes y les pide que
 * califiquen (con puntaje de 1 a 10) los siguientes aspectos: (0) Atención al
 * cliente (1) Calidad de la comida (2) Precio (3) Ambiente.
 * Escriba un programa que lea desde teclado las calificaciones de los cinco
 * clientes para cada uno de los aspectos y almacene la información en una
 * estructura. Luego imprima la calificación promedio obtenida por cada aspecto.
 *
 * Nota: las calificaciones se generan aleatoriamente en lugar de leerse.
 */
public class Ej05Restaurante {

    private static final String[] ASPECTOS = {"Atención al cliente", "Calidad de la comida", "Precio", "Ambiente"};
    private static final int CLIENTES = 5;

    public static void main(String[] args) {
        GeneradorAleatorio.iniciar();

        int[][] notas = new int[ASPECTOS.length][CLIENTES];
        for (int a = 0; a < ASPECTOS.length; a++) {
            for (int c = 0; c < CLIENTES; c++) {
                notas[a][c] = 1 + GeneradorAleatorio.generarInt(10);
                System.out.print(notas[a][c] + "\t");
            }
            System.out.println();
        }

        System.out.println();
        for (int a = 0; a < ASPECTOS.length; a++) {
            double suma = 0;
            for (int nota : notas[a]) {
                suma += nota;
            }
            System.out.println("Aspecto (" + a + ") " + ASPECTOS[a] + ": " + suma / CLIENTES);
        }
    }
}
