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
public abstract class Recital {
	private String banda;
	private int cantTemasMax;
	private int cantTemas;
	private String[] temas;

	public Recital(String banda, int cantTemasMax) {
		this.banda = banda;
		this.cantTemasMax = cantTemasMax;
		
		this.cantTemas = 0;
		this.temas = new String[cantTemasMax];
	}

	public void agregarTema (String tema){
		this.temas[cantTemas] = tema;
		this.cantTemas++;
	}
	
	public abstract double calcularCosto();
	
	public void publicitar(){
		System.out.println("somos " + this.banda + ", tocaremos:");
		for (int i = 0; i  < this.cantTemas; i++){
			System.out.println("- "+ this.temas[i]);
		}
	}
	
}
