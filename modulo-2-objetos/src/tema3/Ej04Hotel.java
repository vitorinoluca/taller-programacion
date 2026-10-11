package tema3;

import tema2.Persona;

/**
 * Práctica 3 - Ejercicio 4
 *
 * A- Un hotel posee N habitaciones. De cada habitación conoce costo por noche,
 *    si está ocupada y, en caso de estarlo, guarda el cliente que la reservó
 *    (nombre, DNI y edad).
 *    (i)   Genere las clases necesarias. Para cada una provea métodos
 *          getters/setters adecuados.
 *    (ii)  Implemente los constructores. Los clientes inician a partir de
 *          nombre, DNI y edad. El hotel inicia recibiendo la cantidad de
 *          habitaciones (N) y dos valores, que representan el costo por noche
 *          de las habitaciones frente (índice impar) y contrafrente (índice
 *          par), y debe iniciar sus N habitaciones desocupadas y con el costo
 *          correspondiente.
 *    (iii) Implemente en las clases que corresponda todos los métodos
 *          necesarios para:
 *          - Ingresar un cliente C en la habitación número X del hotel. Asuma
 *            que X está en rango 1..N y que la habitación está libre.
 *          - Aumentar el precio de todas las habitaciones del hotel en un
 *            monto recibido.
 *          - Obtener la representación String del hotel, siguiendo el formato:
 *            {Habitación 1: costo, libre u ocupada, información del cliente si está ocupada}
 *            ...
 *            {Habitación N: costo, libre u ocupada, información del cliente si está ocupada}
 * B- Realice un programa que instancie un hotel, ingrese clientes en distintas
 *    habitaciones, muestre el hotel, aumente el precio de las habitaciones y
 *    vuelva a mostrar el hotel.
 *
 * Nota: reúse la clase Persona. Para cada método solicitado piense a qué clase
 * debe delegar la responsabilidad de la operación.
 */
public class Ej04Hotel {

    public static void main(String[] args) {
        Hotel hotel = new Hotel(5, 8000.0, 6000.0);

        hotel.ingresarCliente(new Persona("Luca", 43215678, 21), 1);
        hotel.ingresarCliente(new Persona("Ana", 38123456, 25), 3);
        hotel.ingresarCliente(new Persona("Carlos", 22345678, 50), 5);

        System.out.println("--- ESTADO INICIAL DEL HOTEL ---");
        System.out.println(hotel);

        hotel.aumentarPrecio(1500.50);

        System.out.println("--- ESTADO DEL HOTEL TRAS AUMENTO DE PRECIOS ---");
        System.out.println(hotel);
    }
}
