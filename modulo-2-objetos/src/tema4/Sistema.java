package tema4;

public abstract class Sistema {

    private String partido;
    private String provincia;
    private String fecha;
    private int cantLocalidades;
    private double[][] temperaturas;

    public Sistema(String partido, String provincia, String fecha, int cantLocalidades) {
        this.partido = partido;
        this.provincia = provincia;
        this.fecha = fecha;
        this.cantLocalidades = cantLocalidades;

        this.temperaturas = new double[cantLocalidades][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < cantLocalidades; j++) {
                this.temperaturas[j][i] = 1000;
            }
        }
    }

    public void registrarTemperatura(int localidad, int franja, double temperatura) {
        this.temperaturas[localidad - 1][franja - 1] = temperatura;
    }

    public double getTemperatura(int localidad, int franja) {
        return this.temperaturas[localidad - 1][franja - 1];
    }

    public String getPartido() {
        return partido;
    }

    public void setPartido(String partido) {
        this.partido = partido;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getCantLocalidades() {
        return cantLocalidades;
    }

    public String mayorTemperatura() {
        double mayorTemperatura = -9999;
        int localidad = 0;
        int franja = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < cantLocalidades; j++) {
                if (temperaturas[j][i] > mayorTemperatura) {
                    mayorTemperatura = temperaturas[j][i];
                    localidad = j;
                    franja = i;
                }
            }
        }
        return "La localidad con mayor tempertura " + mayorTemperatura + "° fue la " + (localidad + 1) + " en la franja " + (franja + 1);
    }

    public abstract String calcularPromedios();

    @Override
    public String toString() {
        return partido + " - " + provincia + " - " + fecha + "\n" + calcularPromedios();
    }

}
