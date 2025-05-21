package model.personajes;

public class Ataque {
	private String nombre;
	private int dmg;
	private String tipo;
	
    public Ataque(String nombre, int dmg, String tipo) {
        this.nombre = nombre;
        this.dmg = dmg;
        this.tipo = tipo;
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
    
    
}
