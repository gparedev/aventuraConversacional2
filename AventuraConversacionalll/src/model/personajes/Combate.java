package model.personajes;

import java.util.Random;

public class Combate {

	private boolean empiezaProta = false;
	Random rand = new Random();

	public Combate() {

	}

	private void asignarEnemigos(Combatiente jugador, Combatiente enemigo) {
		jugador.setEnemigo(enemigo);
		enemigo.setEnemigo(jugador);
	}

	private void asignarQuienEmpieza() {
		int numero = rand.nextInt(2) + 1;
		if (numero == 1) {
			empiezaProta = true;
		} else {
			empiezaProta = false;
		}
	}

	public void inicioCombate(Combatiente jugador, Combatiente enemigo) {

		asignarEnemigos(jugador, enemigo);

		asignarQuienEmpieza();

		System.out.println("Comienza el combate entre " + jugador.getNombre() + " y " + enemigo.getNombre());

		while (jugador.getVida() > 0 && enemigo.getVida() > 0) {
			if (empiezaProta) {
				System.out.println("Empieza " + jugador.getNombre());
				jugador.turno();
				enemigo.turno();
			} else {
				System.out.println("Empieza " + enemigo.getNombre());
				enemigo.turno();
				jugador.turno();
			}

		}

		System.out.println("Fin del combate.");
	}
}
