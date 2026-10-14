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
public class Producto {
    private String descripcion;
    private String rubro;
    private Double pesoKG;
    private Double precioKilo;

    public Producto(String descripcion, String rubro, Double pesoKG, Double precioKilo) {
        this.descripcion = descripcion;
        this.rubro = rubro;
        this.pesoKG = pesoKG;
        this.precioKilo = precioKilo;
    }

    public double calcularCosto(){
        return this.pesoKG * this.precioKilo;
    }
    
    @Override
    public String toString() {
        return this.descripcion + " - " + this.pesoKG + "kg $" + this.calcularCosto();
    }
    
    public String getRubro(){
        return this.rubro;
    }
    
    
}
