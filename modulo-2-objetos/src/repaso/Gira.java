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
public class Gira extends Recital {

	private String nombreGira;
	private int cantMaxFechas;
	private Fecha[] fechas;
	private int diml;
	private int actual;

	public Gira(String nombreGira, int cantMaxFechas, String banda, int cantTemasMax) {
		super(banda, cantTemasMax);
		this.nombreGira = nombreGira;
		this.cantMaxFechas = cantMaxFechas;

		this.diml = 0;
		this.actual = 0;
		this.fechas = new Fecha[cantMaxFechas];
	}

	public void agregarFecha(Fecha f) {
		this.fechas[diml] = f;
		this.diml++;
	}

	@Override
	public double calcularCosto() {
		return this.diml * 30000;
	}

	@Override
	public void publicitar() {
		super.publicitar();
		if (this.actual < this.diml) {
			System.out.println("los esperamos en: " + this.fechas[this.actual].getCiudad());
			this.actual++;
		}
	}

}
