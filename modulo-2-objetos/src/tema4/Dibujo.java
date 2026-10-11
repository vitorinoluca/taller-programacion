package tema4;

public class Dibujo {

    private static final int CAPACIDAD_MAXIMA = 10;

    private String titulo;
    private Figura[] figuras = new Figura[CAPACIDAD_MAXIMA];
    private int guardadas = 0;

    // inicia el dibujo, sin figuras
    public Dibujo(String titulo) {
        this.titulo = titulo;
    }

    // agrega la figura al dibujo
    public void agregar(Figura f) {
        if (!estaLleno()) {
            figuras[guardadas++] = f;
            System.out.println("la figura " + f + " se ha guardado");
        }
    }

    // suma de las áreas de sus figuras
    public double calcularArea() {
        double suma = 0;
        for (int i = 0; i < guardadas; i++) {
            suma += figuras[i].calcularArea();
        }
        return suma;
    }

    // imprime el título, la representación de cada figura y el área del dibujo
    public void mostrar() {
        System.out.println(titulo);
        for (int i = 0; i < guardadas; i++) {
            System.out.println(figuras[i]);
        }
        System.out.println("el area del dibujo es de " + calcularArea());
    }

    public boolean estaLleno() {
        return guardadas == CAPACIDAD_MAXIMA;
    }
}
