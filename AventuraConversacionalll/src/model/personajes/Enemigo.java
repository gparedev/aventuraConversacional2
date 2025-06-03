package model.personajes;

import java.util.Random;

public class Enemigo extends Combatiente {

	private Random rand = new Random();

	public Enemigo(String nombre, int vidaMaxima, int ataque, int pocionVida, int pocionAtaque) {
		super(nombre, vidaMaxima, ataque, pocionVida, pocionAtaque);
	}

	public void imprimirInfo() {
		System.out.println(getNombre());
	}

	// Por ahora solo ataca, podemos poner que si tiene poca vida se cure...
	@Override
	public void turno() {
		if (getVida() > 0) {
			// Elige un ataque aleatorio
			int index = rand.nextInt(getAtaques().size());
			atacar(getEnemigo(), getAtaques().get(index));
			imprimirVidaEnemigo();
			resetBooleanPocionesAfterTurn();
			System.out.println("Fin del turno de: " + getNombre());
		} else {
			System.out.println(getNombre() + " ha sido derrotado.");
		}
	}

}
