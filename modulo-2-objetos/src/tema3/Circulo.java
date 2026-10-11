package tema3;

public class Circulo {

    private double radio;

    private String colorRelleno;
    private String colorBorde;

    public Circulo(double r, String cr, String cb) {
        this.radio = r;
        this.colorRelleno = cr;
        this.colorBorde = cb;
    }

    public double getRadio() {
        return radio;
    }

    public String getColorRelleno() {
        return colorRelleno;
    }

    public String getColorBorde() {
        return colorBorde;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }

    public void setColorRelleno(String colorRelleno) {
        this.colorRelleno = colorRelleno;
    }

    public void setColorBorde(String colorBorde) {
        this.colorBorde = colorBorde;
    }

    public double calcularPerimetro(){
        return (2 * Math.PI * radio);
    }

    public double calcularArea(){
        return Math.PI * (radio * radio);
    }

}
