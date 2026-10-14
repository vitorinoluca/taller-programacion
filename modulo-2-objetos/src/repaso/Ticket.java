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
public class Ticket {

    private int numeroCompra;
    private String resumen;
    private double montoTotal;

    public Ticket(int numeroCompra, String resumen, double montoTotal) {
        this.numeroCompra = numeroCompra;
        this.resumen = resumen;
        this.montoTotal = montoTotal;
    }

    @Override
    public String toString() {
        return "Compra n° " + this.numeroCompra + "\n"
                + this.resumen
                + "Monto total: $" + this.montoTotal;
    }

}
