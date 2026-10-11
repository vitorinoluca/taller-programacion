package repaso;

public class Estacionamiento {

	private String nombre;
	private String direccion;
	private String horaApertura;
	private String horaCierre;
	private int cantPisos;
	private int cantPlazas;

	private Auto[][] estacionamientos;

	public Estacionamiento(String nombre, String direccion) {
		this.nombre = nombre;
		this.direccion = direccion;

		this.horaApertura = "08:00";
		this.horaCierre = "21:00";
		this.cantPisos = 5;
		this.cantPlazas = 10;
		this.estacionamientos = new Auto[cantPlazas][cantPisos];
		for (int i = 0; i < this.cantPlazas; i++) {
			for (int j = 0; j < this.cantPisos; j++) {
				estacionamientos[i][j] = null;
			}
		}
	}

	public Estacionamiento(String nombre, String direccion, String horaApertura, String horaCierre, int cantPisos, int cantPlazas) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.horaApertura = horaApertura;
		this.horaCierre = horaCierre;
		this.cantPisos = cantPisos;
		this.cantPlazas = cantPlazas;

		this.estacionamientos = new Auto[cantPlazas][cantPisos];
		for (int i = 0; i < this.cantPlazas; i++) {
			for (int j = 0; j < this.cantPisos; j++) {
				estacionamientos[i][j] = null;
			}
		}
	}

	public void registarAuto(Auto a, int piso, int plaza) {
		this.estacionamientos[plaza][piso] = a;
	}

	public String buscarAuto(String patente) {
		int piso = 0;
		int plaza = 0;
		boolean encontrado = false;

		while (!encontrado && piso < cantPisos) {
			Auto a = this.estacionamientos[plaza][piso];
			if (a != null && a.getPatente().equals(patente)) {
				encontrado = true;
			} else if (plaza < this.cantPlazas - 1) {
				plaza++;
			} else {
				plaza = 0;
				piso++;
			}
		}
		if (encontrado) {
			return "piso " + (piso + 1) + " plaza " + (plaza + 1);
		} else {
			return "auto inexistente";
		}
	}

	public int getCantAutosEnXPlaza(int plaza) {
		int cant = 0;

		for (int i = 0; i < this.cantPisos; i++) {
			if (this.estacionamientos[plaza][i] != null) {
				cant++;
			}
		}

		return cant;
	}

	@Override
	public String toString() {
		String aux = "";
		for (int j = 0; j < this.cantPisos; j++) {
			for (int i = 0; i < this.cantPlazas; i++) {
				aux += "\n" + "Piso " + (j + 1) + " Plaza " + (i + 1);
				if (this.estacionamientos[i][j] != null) {
					aux += " " + this.estacionamientos[i][j].toString();
				} else {
					aux += " libre";
				}
			}
		}
		return aux;
	}

}
