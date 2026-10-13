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
public class Estreno {
    private String titulo;
    private String tipoContenido;
    private Double recaudacion;
    private int visualizaciones;

    public Estreno(String titulo, String tipoContenido, Double recaudacion, int visualizaciones) {
        this.titulo = titulo;
        this.tipoContenido = tipoContenido;
        this.recaudacion = recaudacion;
        this.visualizaciones = visualizaciones;
    }

    @Override
    public String toString() {
        return this.titulo + ", " + this.tipoContenido + " $" + this.recaudacion + ", " + this.visualizaciones;
    }
    
    
    public double calcularGanancia(){
        return recaudacion / 2;
    }
    
}
