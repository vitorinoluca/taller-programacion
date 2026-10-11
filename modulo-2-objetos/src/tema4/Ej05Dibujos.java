package tema4;

/**
 * Práctica 4 - Ejercicio 5
 *
 * A- Queremos representar dibujos. Un dibujo guarda su título y las figuras que
 *    lo componen (círculos, triángulos, cuadrados, rectángulos, etc).
 *    Piense, con lo visto hasta ahora (no es necesario implementar):
 *    i-   ¿Dónde almacenará las figuras que componen el dibujo? ¿Cuántas
 *         estructuras se necesitarán?
 *    ii-  ¿Cómo agregará las distintas figuras al dibujo? ¿Cuántos métodos
 *         agregar necesita implementar?
 *    iii- ¿Qué problema surge a medida que aumentan las posibles figuras en la
 *         jerarquía?
 * B- Implemente la clase Dibujo usando un array genérico de Figuras. Dicho
 *    array puede guardar objetos creados a partir de cualquier subclase de
 *    Figura. Siga el molde dado (constructor, agregar, calcularArea, mostrar,
 *    estaLleno).
 * C- Analice y ejecute este programa. Responda: ¿Qué imprime? ¿Por qué?
 *    Piense: ¿qué ventaja tiene esta implementación a medida que aumentan las
 *    posibles figuras en la jerarquía? ¿cuál es la ventaja del polimorfismo?
 *    ¿dónde se observa en este ejercicio? (Dibujo trata a todas las figuras
 *    como Figura, y cada una responde con su propio calcularArea/toString)
 */
public class Ej05Dibujos {

    public static void main(String[] args) {
        Dibujo d = new Dibujo("un dibujo");

        d.agregar(new Cuadrado(10, "Violeta", "Rosa"));
        d.agregar(new Rectangulo(20, 10, "Azul", "Celeste"));
        d.agregar(new Cuadrado(30, "Rojo", "Naranja"));

        d.mostrar();
    }
}
