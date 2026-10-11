package tema4;

public abstract class Empleado {

    private String nombre;
    private double sueldo;
    private int antiguedad;

    public Empleado(String nombre, double sueldo, int antiguedad) {
        this.nombre = nombre;
        this.sueldo = sueldo;
        this.antiguedad = antiguedad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public int getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }

    public abstract double calcularEfectividad();

    // sueldo básico + 10% del básico por cada año de antigüedad
    public double calcularSueldoACobrar() {
        return sueldo + sueldo * 0.10 * antiguedad;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre
                + " Sueldo a cobrar: " + calcularSueldoACobrar()
                + " Efectividad: " + calcularEfectividad();
    }
}
