package tema1;

import PaqueteLectura.GeneradorAleatorio;

public class Ej05Restaurante {

    public static void main(String[] args) {
        GeneradorAleatorio.iniciar();

        int[][] entrevista = new int[4][5];
        int i, j;

        for (i = 0; i < 4; i++) {
            for (j = 0; j < 5; j++) {
                entrevista[i][j] = 1 + GeneradorAleatorio.generarInt(10);
            }
        }

        for (i = 0; i < 4; i++) {
            for (j = 0; j < 5; j++) {
                System.out.print(entrevista[i][j] + "\t");
            }
            System.out.println();
        }

        String[] aspectos = {"Atención al cliente", "Calidad de la comida", "Precio", "Ambiente"};

        System.out.println();
        for (i = 0; i < 4; i++) {
            double suma = 0;
            for (j = 0; j < 5; j++) {
                suma += entrevista[i][j];
            }
            double promedio = suma / 5;
            System.out.println("Aspecto (" + i + ") " + aspectos[i] + ": " + promedio);
        }
    }
}