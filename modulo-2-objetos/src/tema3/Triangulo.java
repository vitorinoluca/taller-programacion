package tema3;

public class Triangulo {

    private double lado1;
    private double lado2;
    private double lado3;

    private String colorRelleno;
    private String colorBorde;

    public Triangulo(double l1, double l2, double l3, String cr, String cb) {
        this.lado1 = l1;
        this.lado2 = l2;
        this.lado3 = l3;
        this.colorRelleno = cr;
        this.colorBorde = cb;
    }

    public double getLado1() {
        return lado1;
    }

    public double getLado2() {
        return lado2;
    }

    public double getLado3() {
        return lado3;
    }

    public String getColorRelleno() {
        return colorRelleno;
    }

    public String getColorBorde() {
        return colorBorde;
    }

    public void setLado1(double l) {
        lado1 = l;
    }

    public void setLado2(double l) {
        lado2 = l;
    }

    public void setLado3(double l) {
        this.lado3 = l;
    }

    public void setColorRelleno(String colorRelleno) {
        this.colorRelleno = colorRelleno;
    }

    public void setColorBorde(String colorBorde) {
        this.colorBorde = colorBorde;
    }

    public double calcularPerimetro() {
        return lado1 + lado2 + lado3;
    }

    public double calcularArea() {
        double s = calcularPerimetro() / 2;
        return Math.sqrt(s * (s - lado1) * (s - lado2) * (s - lado3));
    }
}
