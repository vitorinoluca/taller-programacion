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
public class CoroHilera extends Coro {

    private Corista[][] coristas;
    private int cantFilasMax;
    private int cantColumnasMax;
    private int ultFila;
    private int ultColumna;

    public CoroHilera(String nombre, Director director, int cantFilas, int cantColumnas) {
        super(nombre, director);
        this.cantFilasMax = cantFilas;
        this.cantColumnasMax = cantColumnas;

        this.coristas = new Corista[cantFilas][cantColumnas];
        this.ultColumna = 0;
        this.ultFila = 0;
    }

    @Override
    public boolean coroLleno() {
        return this.coristas[this.cantFilasMax - 1][this.cantColumnasMax - 1] != null;
    }

    @Override
    public void agregarCorista(Corista c) {
        if (!this.coroLleno()) {
            this.coristas[this.ultFila][this.ultColumna] = c;
            if (this.ultColumna == (this.cantColumnasMax - 1)) {
                this.ultColumna = 0;
                this.ultFila++;
            } else {
                this.ultColumna++;
            }

        } else {
            System.out.println("coro lleno, no se pudo agregar");
        }
    }

    @Override
    public boolean coroBienFormado() {
        int fila = 0;

        while (fila < this.cantFilasMax) {
            int tonoActual = this.coristas[fila][0].getTono();
            int col = 1;
            while (col < this.cantColumnasMax) {
                if (this.coristas[fila][col].getTono() != tonoActual) {
                    return false;
                }
                col++;
            }
            fila++;
        }
        return true;
    }

    @Override
    public String toString() {
        String aux = super.toString();

        for (int i = 0; i < this.cantColumnasMax; i++){
            
            for (int j = 0; j < this.cantFilasMax; j++){
                
            }
        }
        
        return aux;
    }

}
