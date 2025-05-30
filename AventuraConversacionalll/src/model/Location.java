package model;

public class Location {

	private String nombre;
	private String descripcion;
	private boolean visited = false;

	public Location() {

	}

	public Location(String nombre, String descripcion) {
		this.nombre = nombre;
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	public void imprimirFrase() {
		System.out.println("Coges la nave gumi y aterrizas en " + getNombre() + " " + getDescripcion());
	}
	
	

}
