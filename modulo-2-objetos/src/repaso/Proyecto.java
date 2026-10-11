package repaso;

public class Proyecto {
	private String nombre;
	private int codigo;
	private String nombreDirector;
	private int cantInvestigadores;
	private Investigador[] investigadores;
	
	
	public Proyecto(String nombre, int codigo, String nombreDirector) {
		this.nombre = nombre;
		this.codigo = codigo;
		this.nombreDirector = nombreDirector;
		
		this.cantInvestigadores = 0;
		this.investigadores = new Investigador[50];
	}
	
	public void agregarInvestigador(Investigador investigador){
		if (this.cantInvestigadores < 50){
			this.investigadores[this.cantInvestigadores] = investigador;
			this.cantInvestigadores++;
			System.out.println("investigador agregado");
		}
	}
	
	public double dineroTotalOtorgado(){
		double suma = 0;
		for (int i = 0; i < this.cantInvestigadores; i++){
			suma += this.investigadores[i].dineroTotalOtorgado();
		}
			
		return suma;
	}
	
	public void otorgarTodos(String nombreCompleto){
		int i = 0;
		while (i < this.cantInvestigadores && !nombreCompleto.equals(this.investigadores[i].getNombreCompleto())){
			i++;
		}
		if (i < this.cantInvestigadores){
			this.investigadores[i].otorgarTodos();
		}
	}
	
	@Override
	public String toString(){
		String aux = "Proyecto " + this.nombre + " codigo: " + this.codigo + " director: " + this.nombreDirector + " total otorgado: $" + this.dineroTotalOtorgado();

		for (int i = 0; i < this.cantInvestigadores; i++){
			aux+= "\n" + this.investigadores[i].toString();
		}
		
		return aux;
	}
	
}
