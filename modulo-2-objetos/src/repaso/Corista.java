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
public class Corista extends Persona {
    private int tono;

    public Corista(int tono, String nombre, int dni, int edad) {
        super(nombre, dni, edad);
        this.tono = tono;
    }

    
    
    public int getTono() {
        return tono;
    }

    @Override
    public String toString() {
        return super.getNombre() + " dni " + super.getDni() + " y " + super.getEdad() + " años, tono: " + this.tono;
    }
    
    
}
