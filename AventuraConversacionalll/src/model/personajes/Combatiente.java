package model.personajes;

import dao.DaoCombatiente;

import java.sql.*;

public abstract class Combatiente extends Personaje {

	private int vida;
	private int vidaMax;
	private int ataque;
	private int defensa;
	
	private String attackName = null;

	private int pocionAtaque;
	private int pocionVida;
	private boolean pocionAtaqueUsada = false;
	private boolean pocionVidaUsada = false;

	private final int VALOR_POCIONES = 25;

	public Combatiente(String nombre, int vidaMax, int ataque, int pocionVida, int pocionAtaque) {
		super(nombre);
		this.vidaMax = vidaMax;
		this.vida = vidaMax;
		this.ataque = ataque;
		this.pocionVida = pocionVida;
		this.pocionAtaque = pocionAtaque;
	}

	// GETTERS & SETTERS
	public int getDefensa() {
		return defensa;
	}

	public void setDefensa(int defensa) {
		this.defensa = defensa;
	}

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}
	
	public String getAttackName() {
		return attackName;
	}

	public void setAttackName(String attackName) {
		this.attackName = attackName;
	}

	public int getAtaque() {
		return ataque;
	}

	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}

	// POCIONES
	public void usarPocionVida() {
		int valorCura;
		// Si no he usado la poción y tengo 1 o más...
		if (!pocionVidaUsada && pocionVida > 0) {
			if (vida + VALOR_POCIONES >= vidaMax) {
				valorCura = vidaMax - vida;
				vida = vidaMax;
			} else {
				vida += VALOR_POCIONES;
				valorCura = VALOR_POCIONES;
			}

			imprimirCura(valorCura);
		} else {
			imprimirErrorCura();
		}
	}

	public void imprimirCura(int valorCura) {
		System.out.println(getNombre() + " usó poción de vida y restaura " + valorCura + " puntos de salud!\n"
				+ "Vida actual: " + vida);
	}

	public void imprimirErrorCura() {
		if (pocionVida <= 0) {
			System.out.println("No te quedan Pociones");
		} else {
			System.out.println("Ya has usado una poción, espera al siguiente turno.");
		}
	}
	
	// Select TipoAtaque de las tablas
	// Lo mas sencillo creo que va a ser hacer la clase abstracta y que cada clase la implemente.
	public void atacar(Combatiente enemy) {
		if (enemy.getVida() > 0) {
			// Comprobar qué ataque ha seleccionado...
			comprobarTipoAtaque();
			int dmg = ataque - enemy.getDefensa();
			enemy.setVida(enemy.getVida() - dmg);
		}
		
		// Resetear ataque
		ataque = 0;
	}

	public void comprobarTipoAtaque() {
		// Consulta base de datos de ataque debil
		if (attackName.equalsIgnoreCase("0")) {
			ataque += 5;
		// Ataque Medio
		} else if(attackName.equalsIgnoreCase("1")) {
			
		//Ataque fuerte
		} else {
				
		}
	}
	
	public String imprimirAtaqueDebil () throws SQLException {
		return DaoCombatiente.getInstance().selectAttack();
	}

}
