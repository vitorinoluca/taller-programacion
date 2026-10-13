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
public class CoroSemicircular extends Coro {

    private Corista[] coristas;
    private int dimf;
    private int diml;

    public CoroSemicircular(String nombre, Director director, int dimf) {
        super(nombre, director);
        this.dimf = dimf;
        
        this.coristas = new Corista[dimf];
        this.diml = 0;
    }

    @Override
    public void agregarCorista(Corista c) {
        this.coristas[this.diml] = c;
        this.diml++;
    }

    @Override
    public boolean coroLleno() {
        return diml == dimf;
    }

    @Override
    public boolean coroBienFormado() {
        int i = 1;
        boolean corte = false;
        int tonoAnterior = this.coristas[0].getTono();
        
        while (i < dimf && corte == false){
            if (tonoAnterior < this.coristas[i].getTono()){
                corte = true;
            }
            else{
                tonoAnterior = this.coristas[i].getTono();
            }
            i++;
        }
        return !corte;
    }

    @Override
    public String toString() {
        String aux = super.toString();
        for (int i = 0; i < this.diml; i++){
            aux+= "\n" + this.coristas[i].toString();
        }
        return aux;
    }
    
    
    

}
