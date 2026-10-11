package tema1;

import PaqueteLectura.GeneradorAleatorio;
import PaqueteLectura.Lector;

/**
 * Práctica 1 - Ejercicio 2
 *
 * Escriba un programa que defina una matriz de enteros de tamaño 5x5.
 * Inicialice la matriz con números aleatorios entre 0 y 30. Luego realice las
 * siguientes operaciones en recorridos independientes:
 *  - Mostrar el contenido de la matriz en consola.
 *  - Calcular e informar la suma de los elementos de la fila 1.
 *  - Generar un vector de 5 posiciones donde cada posición j contiene la suma
 *    de los elementos de la columna j de la matriz. Luego, imprima el vector.
 *  - Leer un valor entero e indicar si se encuentra o no en la matriz. En caso
 *    de encontrarse indique su ubicación (fila y columna), en caso contrario
 *    imprima "No se encontró el elemento".
 */
public class Ej02Matrices {

    private static final int N = 5;

    public static void main(String[] args) {
        GeneradorAleatorio.iniciar();

        int[][] matriz = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                matriz[i][j] = GeneradorAleatorio.generarInt(31);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(" " + matriz[i][j]);
            }
            System.out.println();
        }

        int sumaFila = 0;
        for (int j = 0; j < N; j++) {
            sumaFila += matriz[1][j];
        }
        System.out.println("La suma de los elementos de la fila 1 es: " + sumaFila);

        int[] sumaColumnas = new int[N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sumaColumnas[j] += matriz[i][j];
            }
        }
        System.out.println("Suma por columnas:");
        for (int suma : sumaColumnas) {
            System.out.println(suma);
        }

        System.out.print("Ingrese un numero a buscar: ");
        int buscado = Lector.leerInt();
        int fila = -1;
        int columna = -1;
        for (int i = 0; i < N && fila == -1; i++) {
            for (int j = 0; j < N && fila == -1; j++) {
                if (matriz[i][j] == buscado) {
                    fila = i;
                    columna = j;
                }
            }
        }

        if (fila != -1) {
            System.out.println("El numero se encuentra en la Fila " + fila + ", Columna " + columna);
        } else {
            System.out.println("No se encontró el elemento");
        }
    }
}
