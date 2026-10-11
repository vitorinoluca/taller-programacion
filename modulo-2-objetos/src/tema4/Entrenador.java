package tema4;

public class Entrenador extends Empleado {

    private int cantCampeonatosGanados;

    public Entrenador(int cantCampeonatosGanados, String nombre, double sueldo, int antiguedad) {
        super(nombre, sueldo, antiguedad);
        this.cantCampeonatosGanados = cantCampeonatosGanados;
    }

    public int getCantCampeonatosGanados() {
        return cantCampeonatosGanados;
    }

    public void setCantCampeonatosGanados(int cantCampeonatosGanados) {
        this.cantCampeonatosGanados = cantCampeonatosGanados;
    }

    @Override
    public double calcularSueldoACobrar() {
        double sueldo = super.calcularSueldoACobrar();
        if (this.cantCampeonatosGanados > 10) {
            sueldo += 50000;
        } else if (this.cantCampeonatosGanados >= 5) {
            sueldo += 30000;
        } else if (this.cantCampeonatosGanados >= 1) {
            sueldo += 5000;
        }
        return sueldo;
    }

    // promedio de campeonatos ganados por año de antigüedad
    @Override
    public double calcularEfectividad() {
        return (double) cantCampeonatosGanados / getAntiguedad();
    }
}
