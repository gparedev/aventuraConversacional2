package model.personajes;

public class Npc extends Personaje {
	
	private String frase;
	
	public Npc(String nombre, String frase) {
		super(nombre);
		this.frase = frase;
	}
	
	//	GETTERS & SETTERS
	public String getFrase() {
		return frase;
	}

	public void setFrase(String frase) {
		this.frase = frase;
	}
	
	public void hablar() {
		System.out.println(getFrase());
	}
	

 
 
}
