package tema4;

public class SistemaGlobal extends Sistema {

    public SistemaGlobal(String partido, String provincia, String fecha, int cantLocalidades) {
        super(partido, provincia, fecha, cantLocalidades);
    }

    @Override
    public String calcularPromedios() {
        String aux = "";
        for (int i = 1; i <= 3; i++) {
            double suma = 0;
            for (int j = 1; j <= getCantLocalidades(); j++) {
                suma += getTemperatura(j, i);
            }
            aux += "Franja horaria " + i + ": " + (suma / getCantLocalidades()) + " ºC; " + "\n";
        }
        return aux;
    }
}
