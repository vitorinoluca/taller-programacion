package tema4;

public class SistemaLocal extends Sistema {

    public SistemaLocal(String partido, String provincia, String fecha, int cantLocalidades) {
        super(partido, provincia, fecha, cantLocalidades);
    }

    @Override
    public String calcularPromedios() {
        String aux = "";
        for (int i = 1; i <= getCantLocalidades(); i++) {
            double suma = 0;
            for (int j = 1; j <= 3; j++) {
                suma += getTemperatura(i, j);
            }
            aux += "Localidad " + i + ": " + (suma / 3) + " ºC; " + "\n";
        }
        return aux;
    }

}
