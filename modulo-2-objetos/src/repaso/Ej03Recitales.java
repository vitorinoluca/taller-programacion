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
public class Ej03Recitales {
	public static void main(String[] args) {
		EventoOcasional evento = new EventoOcasional("a beneficio", "juan carlos", "28/09/2004", "soda stereo", 20);
		Gira gira = new Gira("calesita", 20, "soda stereo", 10);
		
		evento.agregarTema("en la ciudad de la furia");
		evento.agregarTema("cuando pase el temblor");
		evento.agregarTema("té para tres");
		gira.agregarTema("de música ligera");
		gira.agregarTema("persiana americana");
		gira.agregarFecha(new Fecha("La Plata", "10/10/2026"));
		gira.agregarFecha(new Fecha("Rosario", "17/10/2026"));

		System.out.println("Costo evento: " + evento.calcularCosto());
		evento.publicitar();

		System.out.println("Costo gira: " + gira.calcularCosto());
		gira.publicitar();
		gira.publicitar();
	}
}
