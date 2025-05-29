package model.personajes;

import java.sql.SQLException;
import java.util.Random;

import model.escenario.Escenario;

public class Combate {

	private boolean empiezaProta = false;
	private Escenario escenario;
	private Combatiente jugador;
	private Combatiente enemigo;
	Random rand = new Random();

	public Combate() {

	}

	public Combatiente getJugador() {
		return jugador;
	}

	public void setJugador(Combatiente jugador) {
		this.jugador = jugador;
	}

	public Combatiente getEnemigo() {
		return enemigo;
	}

	public void setEnemigo(Combatiente enemigo) {
		this.enemigo = enemigo;
	}

	// Paso necesario en el que se le asigna un enemigo a cada combatiente, 
	// Si no hacemos esto el jugador o el enemigo atacaria a objetos nulos
	private void asignarCombatientes(Combatiente jugador, Combatiente enemigo) {
		setJugador(jugador);
		getJugador().setEnemigo(enemigo);
		setEnemigo(enemigo);
		getEnemigo().setEnemigo(jugador);
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
	
	private void modificarStatsPorEscenario() {
		// Modificación stats Jugador
		getJugador().setAtaque(jugador.getAtaqueIni() +
				escenario.getBonusAtaque() - escenario.getPenalizacionAtaque());
		getJugador().setDefensa(jugador.getDefensa() + escenario.getPenalizacionDefensa());
		// Modificación stats Enemigo
		getEnemigo().setAtaque(jugador.getAtaqueIni() +
				escenario.getBonusAtaque() - escenario.getPenalizacionAtaque());
		getEnemigo().setDefensa(jugador.getDefensa() + escenario.getPenalizacionDefensa());
	}

	public void inicioCombate(Combatiente jugador, Combatiente enemigo) throws SQLException {

		asignarCombatientes(jugador, enemigo);

		setEscenario(new Escenario("Escenario aleatorio"));

		escenario.imprimirInfo();

		asignarQuienEmpieza();

		modificarStatsPorEscenario();

		System.out.println("Comienza el combate entre " + getJugador().getNombre() +
				" y " + getEnemigo().getNombre());

		while (getJugador().getVida() > 0 && getEnemigo().getVida() > 0) {
			if (empiezaProta) {
				System.out.println("Empieza " + getJugador().getNombre());
				getJugador().turno();
				getEnemigo().turno();
			} else {
				System.out.println("Empieza " + enemigo.getNombre());
				getEnemigo().turno();
				getJugador().turno();
			}

		}
		// Reseteamos las stats que fueron modificadas por el escenario.
		jugador.resetStatsAfterCombat();

		System.out.println("Fin del combate.");
	}
}
