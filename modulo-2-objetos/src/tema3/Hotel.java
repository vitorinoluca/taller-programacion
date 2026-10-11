package tema3;

import tema2.Persona;

public class Hotel {

    private final Habitacion[] habitaciones;

    // índice impar (i + 1 par) = frente, índice par = contrafrente, según la consigna
    public Hotel(int cantHabitaciones, double costoFrente, double costoContrafrente) {
        habitaciones = new Habitacion[cantHabitaciones];
        for (int i = 0; i < cantHabitaciones; i++) {
            habitaciones[i] = new Habitacion(i % 2 != 0 ? costoFrente : costoContrafrente);
        }
    }

    public void ingresarCliente(Persona cliente, int nroHabitacion) {
        habitaciones[nroHabitacion - 1].ingresarCliente(cliente);
    }

    public void aumentarPrecio(double monto) {
        for (Habitacion h : habitaciones) {
            h.aumentarPrecio(monto);
        }
    }

    @Override
    public String toString() {
        String aux = "";
        for (int i = 0; i < habitaciones.length; i++) {
            aux += "{Habitación " + (i + 1) + ": " + habitaciones[i] + "}\n";
        }
        return aux;
    }
}
