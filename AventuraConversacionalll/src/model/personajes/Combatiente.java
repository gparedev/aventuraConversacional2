package model.personajes;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public abstract class Combatiente extends Personaje {

	private int vida;
	private int vidaMax;
	private int ataque;
	private int ataqueIni;
	private int defensaIni;
	private int defensa;

	private int pocionAtaque;
	private int pocionVida;
	private boolean pocionAtaqueUsada = false;
	private boolean pocionVidaUsada = false;

	private Combatiente enemigo;

	private final int VALOR_POCIONES = 25;

	private ArrayList<Ataque> ataques;

	private Scanner sc = new Scanner(System.in);

	private Random rand = new Random();

	public Combatiente(String nombre, int vidaMax, int ataque, int pocionVida, int pocionAtaque) {
		super(nombre);
		this.vidaMax = vidaMax;
		this.vida = vidaMax;
		this.ataque = ataque;
		this.ataqueIni = ataque;
		this.defensaIni = defensa;
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

	public int getDefensaIni() {
		return defensaIni;
	}

	public void setDefensaIni(int defensaIni) {
		this.defensaIni = defensaIni;
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

	public Combatiente getEnemigo() {
		return enemigo;
	}

	public void setEnemigo(Combatiente enemigo) {
		this.enemigo = enemigo;
	}

	public int getVidaMax() {
		return vidaMax;
	}

	public void setVidaMax(int vidaMax) {
		this.vidaMax = vidaMax;
	}

	public int getAtaqueIni() {
		return ataqueIni;
	}

	public void setAtaqueIni(int ataqueIni) {
		this.ataqueIni = ataqueIni;
	}

	public boolean isPocionAtaqueUsada() {
		return pocionAtaqueUsada;
	}

	public void setPocionAtaqueUsada(boolean pocionAtaqueUsada) {
		this.pocionAtaqueUsada = pocionAtaqueUsada;
	}

	public boolean isPocionVidaUsada() {
		return pocionVidaUsada;
	}

	public void setPocionVidaUsada(boolean pocionVidaUsada) {
		this.pocionVidaUsada = pocionVidaUsada;
	}

	public int getPocionAtaque() {
		return pocionAtaque;
	}

	public void setPocionAtaque(int pocionAtaque) {
		this.pocionAtaque = pocionAtaque;
	}

	public int getPocionVida() {
		return pocionVida;
	}

	public void setPocionVida(int pocionVida) {
		this.pocionVida = pocionVida;
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

			setPocionVidaUsada(true);
			setPocionVida(getPocionVida() - 1);

			imprimirCura(valorCura);
		} else {
			imprimirErrorCura();
		}
	}

	public void usarPocionAtaque() {
		// Si no he usado la poción y tengo 1 o más...
		if (!pocionAtaqueUsada && pocionAtaque > 0) {
			setAtaque(getAtaque() + VALOR_POCIONES);
			imprimirPocionAtaque();
			setPocionAtaqueUsada(true);
			setPocionAtaque(getPocionAtaque() - 1);
		} else {
			imprimirErrorPocionAtaque();
		}
	}

	public void imprimirCura(int valorCura) {
		System.out.println(getNombre() + " usó poción de vida y restaura " + valorCura + " puntos de salud!\n"
				+ "Vida actual: " + getVida() + "/" + getVidaMax());
	}

	public void imprimirErrorCura() {
		if (pocionVida <= 0) {
			System.out.println("No te quedan Pociones");
		} else {
			System.out.println("Ya has usado una poción, espera al siguiente turno.");
		}
	}

	public void imprimirPocionAtaque() {
		System.out.println(getNombre() + " aumenta su daño de ataque en " + VALOR_POCIONES);
		System.out.println("Ataque actual: " + getAtaque());
	}

	public void imprimirErrorPocionAtaque() {
		if (pocionAtaque <= 0) {
			System.out.println("No te quedan Pociones");
		} else {
			System.out.println("Ya has usado una poción de ataque, espera al siguiente turno.");
		}
	}

	// Select TipoAtaque de las tablas
	// Lo mas sencillo creo que va a ser hacer la clase abstracta y que cada clase
	// la implemente.
	public void atacar(Combatiente enemy, Ataque ataque) {
		int dmg = 0;
		if (enemy.getVida() > 0) {
			// Saca numero aleatorio entre 1 y 100.
			int tirada = rand.nextInt(100 + 1);

			// Si Aciertas el ataque...
			if (tirada <= ataque.getPrecision()) {
				dmg = getAtaque() + ataque.getDmg() - enemy.getDefensa();
				// Si el enemigo tiene muchisima defensa (Cosa que dudo)
				if (dmg <= 0) {
					dmg = 1;
				}

				System.out.println(getNombre() + " usó " + ataque.getNombre() + " causando " + dmg + " de daño a "
						+ enemigo.getNombre() + ".");

			} else {
				System.out.println(getNombre() + " falla el ataque, torpe.");
			}

			enemy.setVida(enemy.getVida() - dmg);

			if (enemy.getVida() < 0) {
				enemy.setVida(0);
			}

		} else {
			System.out.println("Error, enemigo derrotado");
		}
	}

	public void turno() {
		if (getVida() > 0) {

			// Mostrar las opciones de Atacar o Mochila
			opcionesCombate();
			// Imprimir información del enemigo despues de terminar el turno.
			imprimirVidaEnemigo();

			resetBooleanPocionesAfterTurn();

			System.out.println("Fin del turno de: " + getNombre());
		} else {
			System.out.println("Has sido derrotado, no puedes jugar tu turno...");
		}

	}

	// Muestra las opciones de Atacar o Mochila
	public void opcionesCombate() {
		int index = 0;
		do {
			System.out.println("Elige una acción: ");
			System.out.println("1.-Atacar 2.-Mochila 3.-Estadísticas 4.-Info Enemigo");
			index = sc.nextInt();
			sc.nextLine();
		} while (index < 1 || index > 4);

		switch (index) {
		// Opciones Atacar
		case 1:
			opcionesAtacar();
			break;
		// Opciones Mochila
		case 2:
			opcionesMochila();
			break;
			
		case 3:
			imprimirInfo();
			opcionesCombate();
			break;
			
		case 4:
			imprimirInfoEnemigo();
			opcionesCombate();
			break;
		}
	}

	public void opcionesAtacar() {
		int index = 0;
		do {
			imprimirAtaquesYAtras();
			index = sc.nextInt();
			sc.nextLine();
		} while (index < 1 || index > 4);

		switch (index) {
		// Ataque debil
		case 1:
			atacar(enemigo, ataques.get(0));
			break;
		// Ataque medio
		case 2:
			atacar(enemigo, ataques.get(1));
			break;
		// Ataque fuerte
		case 3:
			atacar(enemigo, ataques.get(2));
			break;
		// Atras
		case 4:
			opcionesCombate();
			break;
		}
	}

	public void opcionesMochila() {
		int index = 0;
		do {
			System.out.println("Selecciona una acción");
			imprimirOpcionesMochila();
			index = sc.nextInt();
			sc.nextLine();
		} while (index < 1 || index > 3);

		switch (index) {
		// Poción vida
		case 1:
			usarPocionVida();
			opcionesMochila();
			break;
		// Poción ataque
		case 2:
			usarPocionAtaque();
			opcionesMochila();
			break;
		case 3:
			opcionesCombate();
			break;
		}
	}

	public void imprimirAtaquesYAtras() {
	    System.out.println("===== MENÚ DE ATAQUE =====");

	    for (int i = 0; i < ataques.size(); i++) {
	        Ataque ataque = ataques.get(i);
	        System.out.println((i + 1) + ".- " + ataque.getNombre());
	        System.out.println("    Tipo     : " + ataque.getTipo());
	        System.out.println("    Potencia : " + ataque.getDmg());
	        System.out.println("    Precisión: " + ataque.getPrecision() + "%");
	        System.out.println();
	    }

	    System.out.println((ataques.size() + 1) + ".- Atrás");
	}

	public void imprimirOpcionesMochila() {
		System.out.println("1.-Poción de vida 2.-Poción de ataque 3.-Atras");
	}

	public void imprimirVidaEnemigo() {
		System.out.println(enemigo.getNombre() + ": " + enemigo.getVida() + "/" + enemigo.getVidaMax());
	}

	public void resetStatsAfterCombat() {
		// Reseteamos ataque por si se ha bufado previamente...
		setAtaque(getAtaqueIni());
		setDefensa(getDefensaIni());
	}

	public void resetBooleanPocionesAfterTurn() {
		setPocionAtaqueUsada(false);
		setPocionVidaUsada(false);
	}
	
	public void imprimirInfo() {
	    System.out.println("===== ESTADO DEL PERSONAJE =====");
	    System.out.println("Nombre           : " + getNombre());
	    System.out.println("Vida             : " + getVida() + " / " + getVidaMax());
	    System.out.println("Ataque           : " + getAtaque());
	    System.out.println("Poción de Vida   : " + getPocionVida());
	    System.out.println("Poción de Ataque : " + getPocionAtaque());
	    System.out.println("================================");
	}
	
	public void imprimirInfoEnemigo() {
	    System.out.println("===== INFORMACIÓN DEL ENEMIGO =====");
	    System.out.println("Nombre : " + enemigo.getNombre());
	    System.out.println("Vida   : " + enemigo.getVida() + " / " + enemigo.getVidaMax());
	    System.out.println("Ataque : " + enemigo.getAtaque());
	    System.out.println("===================================");
	}

}
