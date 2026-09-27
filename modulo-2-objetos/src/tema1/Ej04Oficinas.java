package tema1;

import PaqueteLectura.Lector;

public class Ej04Oficinas {

    public static void main(String[] args) {
        int[][] edificio = new int[8][4];
        int i, j;

        System.out.print("Ingrese nro. de piso (1..8, 9 para finalizar): ");
        int piso = Lector.leerInt();

        while (piso != 9) {
            System.out.print("Ingrese nro. de oficina (1..4): ");
            int ofi = Lector.leerInt();

            edificio[piso - 1][ofi - 1]++;

            System.out.print("\nIngrese nro. de piso (1..8, 9 para finalizar): ");
            piso = Lector.leerInt();
        }

        System.out.println("\n--- CANTIDAD DE PERSONAS POR OFICINA ---");
        for (i = 0; i < 8; i++) {
            System.out.print("Piso " + (i + 1) + ": ");
            for (j = 0; j < 4; j++) {
                System.out.print("[Ofi " + (j + 1) + ": " + edificio[i][j] + "] ");
            }
            System.out.println();
        }
    }
}