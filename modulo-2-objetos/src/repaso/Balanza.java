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
public class Balanza {

    private int numeroCompra;
    private int diml;
    private Producto[] productos;

    public Balanza() {
        this.numeroCompra = 1;
        this.diml = 0;
        this.productos = new Producto[30];
    }

    public void reiniciarBalanza() {
        this.diml = 0;
        this.numeroCompra++;
    }

    public void agregarProducto(Producto p) {
        if (diml < 30) {
            this.productos[diml] = p;
            this.diml++;
        }
    }

    public double calcularMontoTotal() {
        double montoTotal = 0;
        for (int i = 0; i < diml; i++) {
            montoTotal += this.productos[i].calcularCosto();
        }
        return montoTotal;
    }

    public String generarResumen() {
        String aux = "";
        for (int i = 0; i < diml; i++) {
            aux += this.productos[i].toString() + "\n";
        }
        return aux;
    }

    public Ticket finalizarCompra() {
        Ticket t = new Ticket(this.numeroCompra, this.generarResumen(), this.calcularMontoTotal());
        reiniciarBalanza();
        return t;
    }

}
