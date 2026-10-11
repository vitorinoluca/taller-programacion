package tema2;

import PaqueteLectura.GeneradorAleatorio;
import PaqueteLectura.Lector;

/**
 * Práctica 2 - Ejercicio 3
 *
 * Se realizará un casting para un musical. El casting durará 5 días y en cada
 * día se entrevistarán a 8 personas en distinto turno.
 *  a) Simular el proceso de inscripción de personas al casting. A cada persona
 *     se le pide sus datos (nombre, DNI, edad), el día (1..5) y turno (1..8) en
 *     que se quiere presentar al casting. La persona debe ser inscripta en ese
 *     día y turno si está disponible. En caso contrario, sólo informe la
 *     situación. La inscripción finaliza al llegar una persona con nombre "ZZZ"
 *     o al cubrirse los 40 cupos de casting.
 *     Una vez finalizada la inscripción:
 *  b) Informar para cada día y turno: si está asignado o no y el nombre de la
 *     persona a entrevistar en ese caso de estar asignado.
 *
 * Nota: DNI y edad se generan aleatoriamente en lugar de leerse.
 */
public class Ej03Musical {

    private static final int DIAS = 5;
    private static final int TURNOS = 8;
    private static final int CUPOS = DIAS * TURNOS;

    public static void main(String[] args) {
        GeneradorAleatorio.iniciar();

        Persona[][] casting = new Persona[TURNOS][DIAS];
        int inscriptos = 0;

        System.out.println("Ingrese su nombre: (ZZZ para finalizar)");
        String nombre = Lector.leerString();
        while (!nombre.equals("ZZZ") && inscriptos < CUPOS) {
            Persona p = new Persona(nombre, GeneradorAleatorio.generarInt(10000), GeneradorAleatorio.generarInt(100));
            System.out.println("ingrese un dia a inscribirse: (1..5)");
            int dia = Lector.leerInt() - 1;
            System.out.println("ingrese un turno para inscribirse: (1..8)");
            int turno = Lector.leerInt() - 1;

            if (casting[turno][dia] == null) {
                casting[turno][dia] = p;
                inscriptos++;
            } else {
                System.out.println("turno  ya elegido");
            }

            System.out.println("Ingrese su nombre: (ZZZ para finalizar)");
            nombre = Lector.leerString();
        }

        for (int t = 0; t < TURNOS; t++) {
            for (int d = 0; d < DIAS; d++) {
                System.out.print((casting[t][d] != null ? casting[t][d].getNombre() : "0") + " ");
            }
            System.out.println();
        }
    }
}
