package tema4;

public class Jugador extends Empleado {

    private int cantPartidosJugados;
    private int cantGoles;

    public Jugador(int cantPartidosJugados, int cantGoles, String nombre, double sueldo, int antiguedad) {
        super(nombre, sueldo, antiguedad);
        this.cantPartidosJugados = cantPartidosJugados;
        this.cantGoles = cantGoles;
    }

    public int getCantPartidosJugados() {
        return cantPartidosJugados;
    }

    public void setCantPartidosJugados(int cantPartidosJugados) {
        this.cantPartidosJugados = cantPartidosJugados;
    }

    public int getCantGoles() {
        return cantGoles;
    }

    public void setCantGoles(int cantGoles) {
        this.cantGoles = cantGoles;
    }

    // promedio de goles por partido
    @Override
    public double calcularEfectividad() {
        return (double) cantGoles / cantPartidosJugados;
    }

    // plus de un sueldo básico si promedia más de 0,5 goles por partido
    @Override
    public double calcularSueldoACobrar() {
        double sueldo = super.calcularSueldoACobrar();
        if (calcularEfectividad() > 0.5) sueldo += getSueldo();
        return sueldo;
    }
}
