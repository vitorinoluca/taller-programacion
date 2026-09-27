package tema1;

import PaqueteLectura.GeneradorAleatorio;
import PaqueteLectura.Lector;

/**
 *
 * @author luca
 */
public class Ej03Teatro {

	public static void main(String[] args) {
		GeneradorAleatorio.iniciar();
		int semana[][] = new int[4][7];
		int i, j;

		for (i = 0; i < 4; i++) {
			for (j = 0; j < 7; j++) {
				semana[i][j] = GeneradorAleatorio.generarInt(100);
			}
		}

		for (i = 0; i < 4; i++) {
			for (j = 0; j < 7; j++) {
				System.out.print(" " + semana[i][j]);
			}
			System.out.println("");
		}

		System.out.println();
		System.out.println("Ingrese un numero de dia 1..7");
		int dia = Lector.leerInt();
		for (i = 0; i < 4; i++) {
			System.out.println("la funcion " + (i + 1) + " tuvo " + semana[i][dia - 1] + " espectadores");
		}

		System.out.println();
		System.out.println("ingrese un numero de funcion 1..4");
		int funcion = Lector.leerInt();
		for (j = 0; j < 7; j++) {
			System.out.println("en el dia " + (j + 1) + " en la funcion " + funcion + " hubieron " + semana[funcion - 1][j] + " espectadores");
		}

		System.out.println();
		int maxEspectadores = -1;
		int maxDia = -1;
		int maxFuncion = -1;

		for (i = 0; i < 4; i++) {
			for (j = 0; j < 7; j++) {
				if (semana[i][j] > maxEspectadores) {
					maxEspectadores = semana[i][j];
					maxFuncion = i + 1;
					maxDia = j + 1;
				}
			}
		}
		System.out.println("el dia " + maxDia + " en la funcion " + maxFuncion + " fue donde hubo mas espectadores: " + maxEspectadores);
	}
}