package tema1;

import PaqueteLectura.GeneradorAleatorio;

/**
 * Práctica 1 - Ejercicio 1
 *
 * Escriba un programa que lea las alturas de los 15 jugadores de un equipo de
 * básquet y las almacene en un vector. Luego informe:
 *  - la altura promedio
 *  - la cantidad de jugadores con altura por encima del promedio
 */
public class Ej01Jugadores {

    private static final int CANTIDAD = 15;

    public static void main(String[] args) {
        GeneradorAleatorio.iniciar();

        double[] alturas = new double[CANTIDAD];
        double suma = 0;
        for (int i = 0; i < CANTIDAD; i++) {
            alturas[i] = 150 + GeneradorAleatorio.generarDouble(70);
            suma += alturas[i];
        }
        double promedio = suma / CANTIDAD;
        System.out.println("el promedio de altura es " + promedio + "cmts");

        int sobrePromedio = 0;
        for (double altura : alturas) {
            if (altura > promedio) sobrePromedio++;
        }
        System.out.println(sobrePromedio + " es la cantidad de jugadores mayor al promedio");
    }
}
