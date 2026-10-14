/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repaso;

/**
 *
 * @author luca
 */
public class BalanzaAvanzada extends Balanza {

    private int cantFrutas;
    private int cantVerduras;

    public BalanzaAvanzada() {
        this.cantFrutas = 0;
        this.cantVerduras = 0;
    }

    @Override
    public void reiniciarBalanza() {
        super.reiniciarBalanza();
        this.cantFrutas = 0;
        this.cantVerduras = 0;
    }

    @Override
    public void agregarProducto(Producto p) {
        super.agregarProducto(p);
        if (p.getRubro().equals("verdura")) {
            this.cantVerduras++;
        } else {
            this.cantFrutas++;
        }
    }

    @Override
    public String generarResumen() {
        return super.generarResumen()
                + "Verduras: " + this.cantVerduras + "\n"
                + "Frutas: " + this.cantFrutas + "\n";
    }

}
