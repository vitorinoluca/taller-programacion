package tema3;

/**
 * Práctica 3 - Ejercicio 1
 *
 * A- Definir dos clases independientes: una para representar triángulos (clase
 *    Triangulo) y otra para círculos (clase Circulo).
 *    - Los triángulos tendrán como atributos: el tamaño de sus 3 lados
 *      (double), el color de relleno (String) y el color de línea (String).
 *    - Los círculos tendrán como atributos: el radio (double), el color de
 *      relleno (String) y el color de línea (String).
 *    Provea en cada clase un constructor que reciba todos los datos necesarios
 *    para iniciar el objeto y métodos para:
 *    - Devolver/modificar el valor de cada uno de sus atributos (get y set)
 *    - Calcular el perímetro y devolverlo (calcularPerimetro)
 *    - Calcular el área y devolverla (calcularArea)
 *    Nota: el área del triángulo es raíz(s(s-a)(s-b)(s-c)) con s = (a+b+c)/2.
 *    Para el círculo use la constante Math.PI.
 * B- Realizar un programa que instancie un triángulo y un círculo e informe en
 *    consola el perímetro y el área de cada uno.
 */
public class Ej01Figuras {

    public static void main(String[] args) {
        Circulo circulo = new Circulo(4, "Rojo", "Negro");
        Triangulo triangulo = new Triangulo(3, 4, 5, "Azul", "Blanco");

        System.out.println("el area del circulo es de " + circulo.calcularArea());
        System.out.println("el perimetro del circulo es de " + circulo.calcularPerimetro());

        System.out.println("el area del triangulo es de " + triangulo.calcularArea());
        System.out.println("el perimetro del triangulo es de " + triangulo.calcularPerimetro());
    }
}
