package tema2;

import PaqueteLectura.GeneradorAleatorio;
import PaqueteLectura.Lector;

/**
 * Práctica 2 - Ejercicio 5
 *
 * Sobre un nuevo programa, modifique el ejercicio anterior para considerar que:
 *  a) Durante el proceso de inscripción se pida a cada persona sus datos
 *     (nombre, DNI, edad) y el día en que se quiere presentar al casting. La
 *     persona debe ser inscripta en ese día, en el siguiente turno disponible.
 *     En caso de no existir un turno en ese día, informe la situación. La
 *     inscripción finaliza al llegar una persona con nombre "ZZZ" o al
 *     cubrirse los 40 cupos de casting.
 *     Una vez finalizada la inscripción:
 *  b) Informar para cada día: la cantidad de inscriptos al casting ese día y
 *     el nombre de la persona a entrevistar en cada turno asignado.
 *
 * Nota: use una estructura auxiliar que para cada día mantenga la cantidad de
 * personas inscriptas, así sabrá cuál es el siguiente turno disponible.
 * DNI y edad se generan aleatoriamente en lugar de leerse.
 */
public class Ej05Casting {

    private static final int DIAS = 5;
    private static final int TURNOS = 8;
    private static final int CUPOS = DIAS * TURNOS;

    public static void main(String[] args) {
        GeneradorAleatorio.iniciar();

        Persona[][] casting = new Persona[DIAS][TURNOS];
        int[] inscriptosPorDia = new int[DIAS];
        int inscriptos = 0;

        System.out.println("Ingrese el nombre de la persona (ZZZ para finalizar):");
        String nombre = Lector.leerString();
        while (!nombre.equals("ZZZ") && inscriptos < CUPOS) {
            System.out.println("Ingrese el día que se quiere presentar (1..5):");
            int dia = Lector.leerInt() - 1;

            if (dia < 0 || dia >= DIAS) {
                System.out.println("-> Día inválido. Debe estar entre 1 y 5.");
            } else if (inscriptosPorDia[dia] == TURNOS) {
                System.out.println("-> Lo siento, no hay turnos disponibles para el Día " + (dia + 1) + ".");
            } else {
                int turno = inscriptosPorDia[dia]++;
                casting[dia][turno] = new Persona(nombre, GeneradorAleatorio.generarInt(10000), GeneradorAleatorio.generarInt(100));
                inscriptos++;
                System.out.println("-> Inscripto con éxito en el Día " + (dia + 1) + ", Turno " + (turno + 1));
            }

            if (inscriptos < CUPOS) {
                System.out.println("\nIngrese el nombre de la persona (ZZZ para finalizar):");
                nombre = Lector.leerString();
            }
        }

        System.out.println("\n========================================");
        System.out.println("     REPORTE FINAL DE INSCRIPCIONES     ");
        System.out.println("========================================");
        for (int d = 0; d < DIAS; d++) {
            System.out.println("Día " + (d + 1) + " (Total inscriptos: " + inscriptosPorDia[d] + ")");
            for (int t = 0; t < inscriptosPorDia[d]; t++) {
                System.out.println("  - Turno " + (t + 1) + ": " + casting[d][t].getNombre() + " (DNI: " + casting[d][t].getDNI() + ")");
            }
            if (inscriptosPorDia[d] == 0) {
                System.out.println("  - Sin inscriptos.");
            }
            System.out.println("----------------------------------------");
        }
    }
}
