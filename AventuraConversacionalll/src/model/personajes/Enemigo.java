package model.personajes;

public class Enemigo extends Combatiente {
	
	public Enemigo(String nombre, int vidaMaxima, int ataque, int pocionVida, int pocionAtaque) {
        super(nombre, vidaMaxima, ataque, pocionVida, pocionAtaque);
    }
	
    public void imprimirInfo() {
    	System.out.println(getNombre());
    }

}
