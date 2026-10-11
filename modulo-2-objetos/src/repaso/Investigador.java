package repaso;

public class Investigador {
	private String nombreCompleto;
	private int categoria;
	private String especialidad;
	private Subsidio[] subsidios;
	private int cantSubsidios;

	public Investigador(String nombreCompleto, int categoria, String especialidad) {
		this.nombreCompleto = nombreCompleto;
		this.categoria = categoria;
		this.especialidad = especialidad;
		
		this.subsidios = new Subsidio[5];
		this.cantSubsidios = 0;
	}
	
	public void agregarSubsidio(Subsidio s){
		if (this.cantSubsidios < 5) {
			this.subsidios[this.cantSubsidios] = s;
			this.cantSubsidios++;
			
		}
	}
	
	public double dineroTotalOtorgado(){
		double suma = 0;
		
		for (int i = 0; i < this.cantSubsidios; i++){
			if (this.subsidios[i].isOtorgado() == true) {
				suma += this.subsidios[i].getMonto();
			}
		}
		
		return suma;
	}
	
	
	public void otorgarTodos(){
		for (int i = 0; i < this.cantSubsidios; i++){
			if (this.subsidios[i].isOtorgado() == false){
				this.subsidios[i].otorgarSubsidio();
			}
		}
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}
	
	@Override
	public String toString(){
		String aux = "Nombre: ";
		aux+= this.nombreCompleto + " categoria: " + this.categoria + " especialidad: " + this.especialidad + " monto total subsidios: $" + this.dineroTotalOtorgado() ;
		return aux;
	}
}
