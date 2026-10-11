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
public class EventoOcasional extends Recital {

	private String motivo;
	private String nombreContratante;
	private String diaEvento;

	public EventoOcasional(String motivo, String nombreContratante, String diaEvento, String banda, int cantTemasMax) {
		super(banda, cantTemasMax);
		this.motivo = motivo;
		this.nombreContratante = nombreContratante;
		this.diaEvento = diaEvento;
	}

	@Override
	public double calcularCosto() {
		if (!this.motivo.equals("a beneficio")) {
			if (this.motivo.equals("show de TV")) {
				return 50000;
			} else {
				return 150000;
			}
		} else {
			return 0;
		}

	}

	@Override
	public void publicitar() {
		super.publicitar();
		if (!this.motivo.equals("a beneficio")) {
			if (this.motivo.equals("show de TV")) {
				System.out.println("saludos amigos televidentes");
			} else {
				System.out.println("un feliz cumpleaños para " + this.nombreContratante);
			}
		} else {
			System.out.println("recuerden colaborar con " + this.nombreContratante);
		}
	}

}
