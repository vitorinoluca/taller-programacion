package tema4;

/**
 * Práctica 4 - Ejercicio 4
 *
 * El Servicio Meteorológico necesita un sistema que permita reportar las
 * temperaturas alcanzadas en una fecha y partido determinados. El sistema
 * conoce nombre del partido, provincia donde se ubica, la fecha de las
 * mediciones, y guarda para cada localidad (1..N) del partido y cada franja
 * horaria (1: mañana, 2: tarde, 3: noche) la temperatura alcanzada.
 * Además, nos piden dos tipos de sistema que difieren en la manera de reportar:
 * el Sistema de Reporte Local informará para cada localidad del partido la
 * temperatura promedio alcanzada, mientras que el Sistema de Reporte Global
 * informará para cada franja horaria la temperatura promedio alcanzada en el
 * partido.
 *
 * Implemente las clases, constructores y métodos que considere necesarios para:
 *  a) Crear el sistema de reporte recibiendo partido, provincia, fecha y la
 *     cantidad de localidades (N) del partido. Inicie cada temperatura en un
 *     valor muy alto.
 *  b) Registrar la temperatura de una localidad y franja horaria recibidos por
 *     parámetro. (localidad en 1..N, franja horaria en 1..3)
 *  c) Obtener la temperatura de una localidad y franja horaria recibidos por
 *     parámetro. (localidad en 1..N, franja horaria en 1..3)
 *  d) Devolver un String que concatene el código de localidad y franja horaria
 *     en que se registró la mayor temperatura. (suponga que ya se registraron
 *     las temperaturas de todas las localidades/franjas horarias)
 *  e) Devolver un reporte String con el nombre del partido, provincia, fecha y
 *     las temperaturas promedio según el tipo de sistema:
 *     - Sistema de Reporte Local: temperatura promedio de cada localidad (el
 *       promedio de la localidad X se calcula con sus datos en todas las
 *       franjas horarias).
 *         "La Plata - Buenos Aires - 24/12/2025
 *          Localidad 1: 39,8 ºC;
 *          Localidad 2: 37,7 ºC;
 *          ..."
 *     - Sistema de Reporte Global: temperatura promedio de cada franja horaria
 *       (el promedio de la franja X se calcula con sus datos en todas las
 *       localidades).
 *         "La Plata - Buenos Aires - 24/12/2025
 *          Franja horaria 1: 31,3 ºC;
 *          Franja horaria 2: 38,7 ºC;
 *          Franja horaria 3: 34,7 ºC;"
 *
 *  f) Realice un programa que cree un Sistema de Reporte Local, para el partido
 *     de La Plata - Bs As - 24/12/2025 y 5 localidades. Registre todas las
 *     temperaturas. Luego cree un Sistema de Reporte Global, para el partido de
 *     Berisso - Bs As - 24/12/2025 y 4 localidades. Registre todas las
 *     temperaturas. Para cada sistema creado, imprima la información retornada
 *     por los métodos d y e.
 *
 * Nota: suponga que ya se registraron las temperaturas de todas las
 * localidades/franjas horarias. No violar el encapsulamiento. Las
 * temperaturas se generan aleatoriamente en lugar de leerse.
 */
public class Ej04ServicioMeteorologico {

    private static final int FRANJAS = 3;

    public static void main(String[] args) {
        probar(new SistemaLocal("La Plata", "Buenos Aires", "24/12/2025", 5));
        probar(new SistemaGlobal("Berisso", "Buenos Aires", "24/12/2025", 4));
    }

    private static void probar(Sistema sistema) {
        for (int localidad = 1; localidad <= sistema.getCantLocalidades(); localidad++) {
            for (int franja = 1; franja <= FRANJAS; franja++) {
                sistema.registrarTemperatura(localidad, franja, Math.random() * 40);
            }
        }
        System.out.println(sistema);
        System.out.println(sistema.mayorTemperatura());
    }
}
