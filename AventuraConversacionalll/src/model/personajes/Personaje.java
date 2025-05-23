package model.personajes;

public abstract class Personaje {
	private String nombre;

	public Personaje(String nombre) {
		this.nombre = nombre;
	}

	// GETTERS & SETTERS
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
