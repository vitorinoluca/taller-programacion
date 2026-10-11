package tema4;

/**
 * Práctica 4 - Ejercicio 1
 *
 * Nos piden una aplicación estilo Paint, para ello necesitamos representar
 * figuras geométricas (cuadrados, rectángulos, círculos, triángulos). Todas las
 * figuras tienen color de relleno y color de línea. Además, los triángulos
 * guardan el valor de sus tres lados, los cuadrados el valor de su lado, los
 * círculos el valor del radio, y los rectángulos el valor de la base y de la
 * altura.
 * Las figuras deben incluir funcionalidad para: crearla a partir de los datos
 * necesarios (constructor), modificar/obtener el valor de los atributos (get y
 * set), calcular el área (calcularArea), calcular el perímetro
 * (calcularPerimetro) y mostrar la representación String de la figura
 * (toString) concatenando toda la información.
 *
 * A- Analice la jerarquía de figuras.
 * B- Incluya la clase Triángulo a la jerarquía de figuras. Triángulo debe
 *    heredar de Figura todo lo que es común y definir su constructor y sus
 *    atributos y métodos propios. Además debe redefinir el método toString para
 *    agregarle la información propia.
 * C- De igual manera, incluya la clase Círculo a la jerarquía de figuras.
 * D- Añada a la representación String el valor del perímetro. Piense ¿qué
 *    método toString debe modificar: el de cada subclase o el de Figura?
 *    (el de Figura)
 * E- Añada el método despintar que establece los colores de la figura a línea
 *    "negra" y relleno "blanco". Piense ¿dónde debe definir el método: en cada
 *    subclase o en Figura? (en Figura)
 * F- Añada el método esGrande que retorne un booleano que indique si el área de
 *    la figura supera el valor 100. Piense ¿dónde debe definir el método: en
 *    cada subclase o en Figura? (en Figura)
 * G- Realizar un programa que instancie un triángulo y un círculo. Muestre en
 *    consola la representación String de cada uno. Pruebe el funcionamiento de
 *    los métodos despintar y esGrande.
 */
public class Ej01Figuras {

    public static void main(String[] args) {
        Triangulo triangulo = new Triangulo(20, 30, 15, "Rojo", "Azul");
        Circulo circulo = new Circulo(5, "Amarillo", "Rosa");

        System.out.println(triangulo);
        System.out.println(circulo);

        System.out.println(triangulo.esGrande());
        triangulo.despintar();

        System.out.println(circulo.esGrande());
        circulo.despintar();

        System.out.println(triangulo);
        System.out.println(circulo);
    }
}
