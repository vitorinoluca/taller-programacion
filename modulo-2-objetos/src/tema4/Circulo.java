package tema4;

public class Circulo extends Figura {

    private double radio;

    public Circulo(double radio, String unCR, String unCL) {
        super(unCR, unCL);
        setRadio(radio);
    }

    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }

    @Override
    public double calcularPerimetro() {
        return (2 * Math.PI * radio);
    }

    @Override
    public double calcularArea() {
        return Math.PI * (radio * radio);
    }

    @Override
    public String toString() {
        String aux = super.toString()
                + " Radio: " + getRadio();

        return aux;
    }
}
