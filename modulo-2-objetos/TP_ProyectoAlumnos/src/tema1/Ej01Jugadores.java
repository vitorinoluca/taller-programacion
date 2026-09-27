
package tema1;
import PaqueteLectura.GeneradorAleatorio;



public class Ej01Jugadores {

  
    public static void main(String[] args) {
        GeneradorAleatorio.iniciar();
        double[] jugadores = new double[15];
        int i;
        double suma = 0;
        for (i = 0; i < 15; i++){
            jugadores[i] = 150 + GeneradorAleatorio.generarDouble(70);
            suma= suma + jugadores[i];
        }
        double promedio = suma / 15;
        System.out.println("el promedio de altura es " + promedio + "cmts");
        
        int contador = 0;
        for (i = 0; i < 15; i++){
            if (jugadores[i] > promedio) contador++;
        }
        System.out.println(contador + " es la cantidad de jugadores mayor al promedio");
    }
    
}
