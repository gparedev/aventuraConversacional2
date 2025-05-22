package model.personajes;

public class Protagonista extends Combatiente {
	
	// Atributos propios como abalorios u otras cosas
	
	
    public Protagonista(String nombre, int vidaMaxima, int ataque, int pocionVida, int pocionAtaque) {
        super(nombre, vidaMaxima, ataque, pocionVida, pocionAtaque);
    }
    
    public void imprimirInfo() {
    	System.out.println(getNombre());
    	System.out.println(getAtaques().get(0).getNombre());
    }
    
    
}
