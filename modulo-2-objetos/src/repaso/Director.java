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
public class Director extends Persona {

    private int antiguedad;

    public Director(int antiguedad, String nombre, int dni, int edad) {
        super(nombre, dni, edad);
        this.antiguedad = antiguedad;
    }

    @Override
    public String toString() {
        return super.getNombre() + " dni " + super.getDni() + " y " + super.getEdad() + " años, antiguedad: " + this.antiguedad;

    }
}
