package tema2;

import PaqueteLectura.GeneradorAleatorio;

/**
 * Práctica 2 - Ejercicio 6
 *
 * Implemente un programa que cargue un vector con a lo sumo 20 partidos
 * disputados en el campeonato. La información de cada partido se lee desde
 * teclado hasta ingresar uno con nombre de visitante "ZZZ" o alcanzar los 20
 * partidos. Luego de la carga:
 *  - Para cada partido, armar e informar una representación String del estilo:
 *    {EQUIPO-LOCAL golesLocal VS EQUIPO-VISITANTE golesVisitante }
 *  - Calcular e informar la cantidad de partidos que ganó River.
 *  - Calcular e informar el total de goles que realizó Boca jugando de local.
 *
 * Nota: los datos se generan aleatoriamente en lugar de leerse. Usa la clase
 * Partido.
 */
public class Ej06Partido {

    private static final int MAX = 20;
    private static final String FIN = "ZZZ";
    private static final String[] EQUIPOS = {"river", "boca", "racing", "independiente", "san lorenzo", "estudiantes", "gimnasia"};

    public static void main(String[] args) {
        GeneradorAleatorio.iniciar();

        Partido[] partidos = new Partido[MAX];
        int diml = 0;
        String visitante = equipoAleatorio();
        while (!visitante.equals(FIN) && diml < MAX) {
            String local = equipoAleatorio();
            while (local.equals(visitante) || local.equals(FIN)) {
                local = equipoAleatorio();
            }
            partidos[diml++] = new Partido(local, visitante, GeneradorAleatorio.generarInt(5), GeneradorAleatorio.generarInt(5));
            visitante = equipoAleatorio();
        }

        int riverGanados = 0;
        int golesBocaLocal = 0;
        for (int i = 0; i < diml; i++) {
            Partido p = partidos[i];
            System.out.println(p.getLocal() + " " + p.getGolesLocal() + " VS " + p.getGolesVisitante() + " " + p.getVisitante());
            if (p.getGanador().equals("river")) riverGanados++;
            if (p.getLocal().equals("boca")) golesBocaLocal += p.getGolesLocal();
        }

        System.out.println("La cantidad de partidos que ganó River es de " + riverGanados);
        System.out.println("La cantidad de goles que metió Boca de local es de " + golesBocaLocal);
    }

    // incluye "ZZZ" como posible salida para simular el fin de la carga
    private static String equipoAleatorio() {
        int i = GeneradorAleatorio.generarInt(EQUIPOS.length + 1);
        return i == EQUIPOS.length ? FIN : EQUIPOS[i];
    }
}
