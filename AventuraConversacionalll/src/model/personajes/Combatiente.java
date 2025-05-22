package model.personajes;

import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public abstract class Combatiente extends Personaje {

	private int vida;
	private int vidaMax;
	private int ataque;
	private int defensa;

	private int pocionAtaque;
	private int pocionVida;
	private boolean pocionAtaqueUsada = false;
	private boolean pocionVidaUsada = false;

	private final int VALOR_POCIONES = 25;

	private ArrayList<Ataque> ataques;

	Scanner sc = new Scanner(System.in);

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

	public int getAtaque() {
		return ataque;
	}

	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}

	public ArrayList<Ataque> getAtaques() {
		return ataques;
	}

	public void setAtaques(ArrayList<Ataque> ataques) {
		this.ataques = ataques;
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
	// Lo mas sencillo creo que va a ser hacer la clase abstracta y que cada clase
	// la implemente.
	public void atacar(Combatiente enemy) {
		int dmg = 0;
		if (enemy.getVida() > 0) {

			// Hacer un switch y una funcion que devuelva un entero en valor del String
			// debil, medio...
			switch (checkTipoAtaque()) {
			case 1:

			}
			dmg = ataque - enemy.getDefensa();
			enemy.setVida(enemy.getVida() - dmg);
		} else {
			System.out.println("El enemigo está debilitado.");
		}

		// Resetear ataque
		ataque = 0;
	}

	// Función que comprueba el tipo de ataque
	public int checkTipoAtaque() {
		for (int i = 0; i < ataques.size(); i++) {
			String tipo = ataques.get(i).getTipo().toLowerCase();
			switch (tipo) {
			case "debil":
				return 1;
			case "medio":
				return 2;
			case "fuerte":
				return 3;
			}
		}
		return 0; // Por si no se encuentra ninguno
	}

	public void turno(Combatiente enemy) {
		int index = 0;
		int seleccion = 0;
		boolean check = false;

		index = OpcionesCombate();

		switch (index) {
		case 1:
			do {

				opcionesAtaque();
				seleccion = sc.nextInt();
				sc.nextLine();
			} while (!check && seleccion < 1 || seleccion > 3);

			break;
		
		case 2:
			System.out.println("Mochila");
			break;
		}
	}

	public int OpcionesCombate() {
		int index = 0;
		do {
			System.out.println("Selecciona una opción");
			System.out.println("1.- Atacar 2.- Mochila");
			index = sc.nextInt();
		} while (index < 1 || index > 2);

		return index;
	}

	public void imprimirOpcionesAtaque() {
		String str = "";
		System.out.println("Selecciona un tipo de ataque");
		for (int i = 0; i < getAtaques().size(); i++) {
			str += i + ".- " + getAtaques().get(i).getNombre() + " ";
		}
		str += " 4.- Atras";
		System.out.println(str);
	}

	public int opcionesAtaque() {
		int index = 0;
		do {
			imprimirOpcionesAtaque();
			index = sc.nextInt();
		} while (index < 1 || index > 4);

		return index;
	}

	public void elegirAccion(Combatiente enemy) {
		int index = opcionesAtaque();
		switch (index) {
		case 1:
			atacar(enemy);
			break;
		case 2:
			break;
		case 3:
			break;
		case 4:
			break;

		}
	}

}
