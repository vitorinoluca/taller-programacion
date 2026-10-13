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
public class Sistema {

    private String nombrePlataforma;
    private int cantSuscriptores;
    private Estreno[][] agenda;
    private int cantCategorias;

    public Sistema(String nombrePlataforma, int cantSuscriptores, int cantCategorias) {
        this.nombrePlataforma = nombrePlataforma;
        this.cantSuscriptores = cantSuscriptores;
        this.cantCategorias = cantCategorias;

        this.agenda = new Estreno[cantCategorias][12];

        for (int i = 0; i < cantCategorias; i++) {
            for (int j = 0; j < 12; j++) {
                this.agenda[i][j] = null;
            }
        }
    }

    public void agregarEstreno(Estreno e, int cat) {
        int i = 0;
        while (i < 12 && this.agenda[cat - 1][i] != null) {
            i++;
        }
        if (i < 12) {
            this.agenda[cat - 1][i] = e;
        }
    }
    
    public String listarEstrenosCatX(int cat){
        int i = 0;
        String aux = "";
        while (i < 12 && this.agenda[cat - 1][i] != null){
            aux+= "\n" + this.agenda[cat - 1][i].toString();
            i++;
        }
        return aux;
    }
    
    public double calcularGananciaTotal(){
        double montoTotal = 0;
        
        for (int i = 0; i < this.cantCategorias; i++){
            int j = 0;
            while (j < 12 && this.agenda[i][j] != null){
                montoTotal += this.agenda[i][j].calcularGanancia();
                j++;
            }
        }
        return montoTotal;
    }
    
    @Override
    public String toString(){
        String aux = this.nombrePlataforma + ", " + this.cantSuscriptores + " suscriptores \n";
        
        for (int i = 0; i < this.cantCategorias; i++){ // filas
            aux+= "\nCategoria " + (i + 1) + ": listado de estrenos de la categoría " + (i + 1) + "\n"; 
            aux+= this.listarEstrenosCatX(i + 1);
            
        }
        aux+= "\nla ganancia total de estrenos es de $ " + this.calcularGananciaTotal();
        
        return aux;
    }
}
