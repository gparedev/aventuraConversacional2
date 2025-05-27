package model.personajes;

import java.sql.SQLException;
import java.util.Random;

import model.escenario.Escenario;

public class Combate {

	private boolean empiezaProta = false;
	private Escenario escenario;
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

	private void setEscenario(Escenario escenario) {
		this.escenario = escenario;
	}

	public void inicioCombate(Combatiente jugador, Combatiente enemigo) throws SQLException {

		asignarEnemigos(jugador, enemigo);
		
		setEscenario(new Escenario("Escenario aleatorio"));
		
		escenario.imprimirInfo();

		asignarQuienEmpieza();
		
		// Esto es una guarrada, habría que cambiarlo
		jugador.setAtaque(jugador.getAtaqueIni() + escenario.getBonusAtaque()
		- escenario.getPenalizacionAtaque());
		enemigo.setAtaque(jugador.getAtaqueIni() + escenario.getBonusAtaque()
		- escenario.getPenalizacionAtaque());
		jugador.setDefensa(jugador.getDefensa() + escenario.getPenalizacionDefensa());
		enemigo.setDefensa(jugador.getDefensa() + escenario.getPenalizacionDefensa());

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

		jugador.resetStatsAfterCombat();

		System.out.println("Fin del combate.");
	}
}
