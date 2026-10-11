package tema4;

import tema2.Persona;

/**
 * Práctica 4 - Ejercicio 3
 *
 * A- Implemente las clases para el siguiente problema. Una garita de seguridad
 *    quiere identificar los distintos tipos de personas que entran a un barrio
 *    cerrado. Al barrio pueden entrar: personas, que se caracterizan por
 *    nombre, DNI y edad; y trabajadores, estos son personas que se
 *    caracterizan además por la tarea realizada en el predio.
 *    Implemente constructores, getters y setters para las clases. Además tanto
 *    las personas como los trabajadores deben responder al mensaje toString
 *    siguiendo el formato:
 *      Personas:     "Mi nombre es Mauro, mi DNI es 11203737 y tengo 70 años"
 *      Trabajadores: "Mi nombre es Mauro, mi DNI es 11203737 y tengo 70 años.
 *                     Soy jardinero."
 * B- Realice un programa que instancie una persona y un trabajador y muestre la
 *    representación de cada uno en consola.
 *
 * Nota: reutilice la clase Persona (tema2).
 */
public class Ej03Barrio {

    public static void main(String[] args) {
        Persona persona = new Persona("Mauro", 11203737, 70);
        Trabajador trabajador = new Trabajador("jardinero", "Mauro", 11203737, 70);

        System.out.println(persona);
        System.out.println(trabajador);
    }
}
