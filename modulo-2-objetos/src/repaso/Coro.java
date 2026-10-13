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
public abstract class Coro {

    private String nombre;
    private Director director;

    public Coro(String nombre, Director director) {
        this.nombre = nombre;
        this.director = director;
    }
    
    public abstract void agregarCorista(Corista c);

    public abstract boolean coroLleno();

    public abstract boolean coroBienFormado();

    @Override
    public String toString() {
        return "Nombre del coro: " + this.nombre + " director: " + this.director.toString();
    }


}
