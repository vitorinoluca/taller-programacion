package repaso;

public class Auto {

	private String nombreDueño;
	private String patente;

	public Auto(String nombreDueño, String patente) {
		this.nombreDueño = nombreDueño;
		this.patente = patente;
	}

	@Override
	public String toString() {
		return "nombre del dueño: " + this.nombreDueño + ", patente: " + this.patente;
	}

	public String getNombreDueño() {
		return nombreDueño;
	}

	public String getPatente() {
		return patente;
	}

	public void setNombreDueño(String nombreDueño) {
		this.nombreDueño = nombreDueño;
	}

	public void setPatente(String patente) {
		this.patente = patente;
	}

}
