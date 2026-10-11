package repaso;

public class Ej01Proyectos {
	public static void main(String[] args) {
		Proyecto proyecto = new Proyecto("Rocas lunares", 22, "Patrick Jane");
		
		Investigador i1 = new Investigador("Luca Vitorino", 1, "Programador");
		Investigador i2 = new Investigador("Joaquin Lopez", 2, "Medico");
		Investigador i3 = new Investigador("Ramiro Gonzalez", 3, "Biologo");
		
		proyecto.agregarInvestigador(i1);
		proyecto.agregarInvestigador(i2);
		proyecto.agregarInvestigador(i3);
		
		Subsidio s1 = new Subsidio(10000, "Costos");
		Subsidio s2 = new Subsidio(8000, "Transporte");
		Subsidio s3 = new Subsidio(10000, "Costos");
		Subsidio s4 = new Subsidio(8000, "Transporte");
		Subsidio s5 = new Subsidio(10000, "Costos");
		Subsidio s6 = new Subsidio(8000, "Transporte");
		
		i1.agregarSubsidio(s1);
		i1.agregarSubsidio(s2);
		
		i2.agregarSubsidio(s3);
		i2.agregarSubsidio(s4);
		
		i3.agregarSubsidio(s5);
		i3.agregarSubsidio(s6);
		
		i1.otorgarTodos();
		
		System.out.println(proyecto.toString());
	}
}
