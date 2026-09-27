package tema1;

import PaqueteLectura.GeneradorAleatorio;
import PaqueteLectura.Lector;

public class Ej02Matrices {

    public static void main(String[] args) {
        GeneradorAleatorio.iniciar();

        int i;
        int j;
        int[][] matriz = new int[5][5];

        for (i = 0; i < 5; i++) {
            for (j = 0; j < 5; j++) {
                matriz[i][j] = GeneradorAleatorio.generarInt(31);
            }
        }

        for (i = 0; i < 5; i++) {
            for (j = 0; j < 5; j++) {
                System.out.print(" " + matriz[i][j]);
            }
            System.out.println("");
        }

        int suma = 0;
        for (i = 0; i < 5; i++) {
            suma = suma + matriz[1][i];
        }
        System.out.println("La suma de los elementos de la fila 1 es: " + suma);

        int vector[] = new int[5];
        for (i = 0; i < 5; i++) {
            suma = 0;
            for (j = 0; j < 5; j++) {
                suma = suma + matriz[j][i];
            }
            vector[i] = suma;
        }

        System.out.println("Suma por columnas:");
        for (i = 0; i < 5; i++) {
            System.out.println(vector[i]);
        }

        System.out.print("Ingrese un numero a buscar: ");
        int n = Lector.leerInt();
        i = 0;
        boolean encontrado = false;
        int filaEncontrada = -1;
        int colEncontrada = -1;

        while (i < 5 && !encontrado) {
            j = 0;
            while (j < 5 && !encontrado) {
                if (n == matriz[i][j]) {
                    encontrado = true;
                    filaEncontrada = i;
                    colEncontrada = j;
                } else {
                    j++;
                }
            }
            i++;
        }

        if (encontrado) {
            System.out.println("El numero se encuentra en la Fila " + filaEncontrada + ", Columna " + colEncontrada);
        } else {
            System.out.println("No se encontró el elemento");
        }
    }
}