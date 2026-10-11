package tema3;

import tema2.Persona;

public class Habitacion {
    private double costoNoche;
    private boolean ocupada;
    private Persona cliente;

    public Habitacion(double costoNoche) {
        this.costoNoche = costoNoche;
    }

    public double getCostoNoche() {
        return costoNoche;
    }

    public void setCostoNoche(double costoNoche) {
        this.costoNoche = costoNoche;
    }

    public boolean isOcupada() {
        return ocupada;
    }

    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
    }

    public Persona getCliente() {
        return cliente;
    }

    public void setCliente(Persona cliente) {
        this.cliente = cliente;
    }

    public void ingresarCliente(Persona unCliente) {
        this.cliente = unCliente;
        this.ocupada = true;
    }

    public void aumentarPrecio(double aumento) {
        this.costoNoche += aumento;
    }

    @Override
    public String toString() {
        return "$" + costoNoche + (ocupada ? ", ocupada, " + cliente : ", libre");
    }
}
