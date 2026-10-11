package tema2;

import PaqueteLectura.GeneradorAleatorio;

/**
 * Práctica 2 - Ejercicio 2
 *
 * Utilizando la clase Persona. Realice un programa que almacene en un vector a
 * lo sumo 15 personas. La información (nombre, DNI, edad) se debe generar
 * aleatoriamente hasta obtener edad 0. Luego de almacenar la información:
 *  - Informe la cantidad de personas mayores de 65 años.
 *  - Muestre la representación de la persona con menor DNI.
 */
public class Ej02Personas {

    private static final int MAX = 15;

    public static void main(String[] args) {
        GeneradorAleatorio.iniciar();

        Persona[] personas = new Persona[MAX];
        int diml = 0;
        int edad = GeneradorAleatorio.generarInt(100);
        while (diml < MAX && edad != 0) {
            personas[diml++] = new Persona(GeneradorAleatorio.generarString(7), GeneradorAleatorio.generarInt(1000), edad);
            edad = GeneradorAleatorio.generarInt(100);
        }

        int mayores65 = 0;
        Persona menorDni = null;
        for (int i = 0; i < diml; i++) {
            if (personas[i].getEdad() > 65) mayores65++;
            if (menorDni == null || personas[i].getDNI() < menorDni.getDNI()) menorDni = personas[i];
        }

        System.out.println("La cantidad de personas mayores a 65 años es de " + mayores65);
        System.out.println("Persona con menor DNI:\n" + menorDni);
    }
}
