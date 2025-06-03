package model.personajes;

public class Ataque {
	private String nombre;
	private int dmg;
	private String tipo;
	private int precision;

	public Ataque(String nombre, int dmg, String tipo, int precision) {
		this.nombre = nombre;
		this.dmg = dmg;
		this.tipo = tipo;
		this.precision = precision;
	}

	public String getNombre() {
		return nombre;
	}

	public int getDmg() {
		return dmg;
	}

	public String getTipo() {
		return tipo;
	}

	public int getPrecision() {
		return precision;
	}

}
