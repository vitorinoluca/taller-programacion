package tema2;

import PaqueteLectura.GeneradorAleatorio;
import PaqueteLectura.Lector;

/**
 * Práctica 2 - Ejercicio 4
 *
 * Se realizará un casting para un programa de TV. El casting durará 5 días y en
 * cada día se entrevistarán a 8 personas en distinto turno.
 *  a) Simular el proceso de inscripción de personas al casting. A cada persona
 *     se le pide sus datos (nombre, DNI y edad) y se la debe asignar en un día y
 *     turno de la siguiente manera: las personas primero completan el primer
 *     día en turnos sucesivos, luego el segundo día y así siguiendo. La
 *     inscripción finaliza al llegar una persona con nombre "ZZZ" o al
 *     cubrirse los 40 cupos de casting.
 *     Una vez finalizada la inscripción:
 *  b) Informar para cada día y turno asignado, el nombre de la persona a
 *     entrevistar.
 *
 * Piense: ¿Es necesario recorrer toda la estructura en el inciso b?
 * No: alcanza con recorrer hasta la cantidad de inscriptos.
 *
 * Nota: DNI y edad se generan aleatoriamente en lugar de leerse.
 */
public class Ej04ProgramaTV {

    private static final int DIAS = 5;
    private static final int TURNOS = 8;
    private static final int CUPOS = DIAS * TURNOS;

    public static void main(String[] args) {
        GeneradorAleatorio.iniciar();

        Persona[][] casting = new Persona[DIAS][TURNOS];
        int inscriptos = 0;

        System.out.println("Ingrese el nombre de la persona (ZZZ para finalizar):");
        String nombre = Lector.leerString();
        while (!nombre.equals("ZZZ") && inscriptos < CUPOS) {
            casting[inscriptos / TURNOS][inscriptos % TURNOS] =
                    new Persona(nombre, GeneradorAleatorio.generarInt(10000), GeneradorAleatorio.generarInt(100));
            inscriptos++;

            if (inscriptos < CUPOS) {
                System.out.println("Ingrese el nombre de la persona (ZZZ para finalizar):");
                nombre = Lector.leerString();
            }
        }

        System.out.println("\n--- LISTADO DE ENTREVISTAS POR DÍA Y TURNO ---");
        for (int i = 0; i < inscriptos; i++) {
            Persona p = casting[i / TURNOS][i % TURNOS];
            System.out.println("Día " + (i / TURNOS + 1) + ", Turno " + (i % TURNOS + 1) + ": " + p.getNombre() + " (DNI: " + p.getDNI() + ")");
        }
    }
}
