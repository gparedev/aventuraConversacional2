package model.escenario;

public class CondicionAtmosferica {

	private String nombre;
	private int penalizacionAtaque;

	public CondicionAtmosferica(String nombre, int penalizacionAtaque) {
		this.nombre = nombre;
		this.penalizacionAtaque = penalizacionAtaque;
	}

	public String getNombre() {
		return nombre;
	}

	public int getPenalizacionAtaque() {
		return penalizacionAtaque;
	}
}
