package tema4;

import tema2.Persona;

public class Trabajador extends Persona {

    private String profesion;

    public Trabajador(String profesion, String unNombre, int unDNI, int unaEdad) {
        super(unNombre, unDNI, unaEdad);
        this.profesion = profesion;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    @Override
    public String toString() {
        return super.toString() + " Soy " + profesion + ".";
    }
}
