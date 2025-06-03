package model.miniJuegos;

import java.util.Scanner;
import model.Printer;

public class Juego5 implements Printer, Juego {

	// CARA O CRUZ

	// ATRIBUTOS
	int ganadoMoneda = 0; // Contabiliza las veces que el personaje gana
	int perdidoMoneda = 0; // Contabiliza las veces que el personaje pierde
	String currentNpc = null;

	// CONSTRUCTORES

	public Juego5() {

	}

	// GET Y SET

	public void setCurrentNpc(String currentNpc) {
		this.currentNpc = currentNpc;
	}

	// FUNCIONES

	public boolean juegoStart(String npc) {
		this.setCurrentNpc(npc);
		boolean gamesWin = false;
		// Trama del juego
		this.tramaJuego();
		// Mensaje final de juego
		gamesWin = this.finalJuego();
		return gamesWin;
	}

	private String frase(int num) {
		String[] frases = { "\nVamos a jugar a cara o cruz\n", "Esa respuesta no es válida, prueba otra vez",
				"Escoge cara o cruz\n1.- Cara\n2.- Cruz", "Voy a tirar la moneda...", "Ha salido cara",
				"Ha salido cruz", "Has ganado", "Has perdido", "Pero... Ha salido canto, habrá que repetirlo",
				"Me has ganado 3 veces, parece que me has vencido\nHas ganado 20 monedas",
				"Te he ganado 3 veces, has perdido" };

		String text = frases[num];
		return text;
	}

	private void tramaJuego() {
		this.print(this.frase(0));
		boolean salir = false;
		do {
			int ladoMonedaOpt = this.comprobarRespuesta();
			this.turno(ladoMonedaOpt);
			this.print(this.puntuacion());
			salir = comprobarPuntuacion();
		} while (salir == false); // Repite el minijuego mientras la opción de salir se falsa

	}

	private boolean finalJuego() {
		boolean gamesWin = false;
		if (ganadoMoneda == 3) {
			this.print(this.frase(9));
			gamesWin = true;
		} else if (perdidoMoneda == 3) {
			this.print(this.frase(10));
		}
		return gamesWin;
	}

	private int comprobarRespuesta() {
		int ladoMonedaOpt = 1; // Elección de lado de la moneda
		Scanner sc = new Scanner(System.in);
		do {
			this.errorOpt(ladoMonedaOpt);
			this.print(this.frase(2));
			ladoMonedaOpt = sc.nextInt(); // Scanner para escoger el lado de la moneda
			int jugadoMoneda = this.random(5); // Random para escoger la frases
			this.print(this.fraseMoneda(jugadoMoneda, ladoMonedaOpt));

		} while (ladoMonedaOpt < 1 || ladoMonedaOpt > 2); // Si la respuesta no es 1 o 2 la repite

		return ladoMonedaOpt;
	}

	private void errorOpt(int ladoMonedaOpt) {
		if (ladoMonedaOpt < 1 || ladoMonedaOpt > 2) { // Si la respuesta no es 1 o 2 la repite
			this.print(this.frase(1));
		}
	}

	private int random(int numRandom) {
		int num = (int) (Math.random() * numRandom + 1);
		return num;
	}

	private String fraseMoneda(int jugadoMoneda, int ladoMonedaOpt) {
		String frase = null;
		switch (ladoMonedaOpt) {
		case 1:
			frase = this.fraseMoneda1(jugadoMoneda);
			break;
		case 2:
			frase = this.fraseMoneda2(jugadoMoneda);
			break;
		}
		return frase;
	}

	private String fraseMoneda1(int num) {
		String[] frase = { "Entonces yo seré cruz", "Vale, pues yo cruz", "Yo jugaré con el otro lado",
				"Pues yo me pido cruz", "Me toca cruz" };
		return frase[num - 1];
	}

	private String fraseMoneda2(int num) {
		String[] frase = { "Entonces yo seré cara", "Vale, pues yo cara", "Yo jugaré con el otro lado",
				"Pues yo me pido cara", "Me toca cara" };
		return frase[num - 1];
	}

	private void turno(int ladoMonedaOpt) {
		this.print(this.frase(3));
		int ladoMoneda = this.random(2);
		int cantoMoneda = this.random(20);
		if (cantoMoneda < 1 || cantoMoneda > 1) {
			this.resolucionTurno(ladoMoneda, ladoMonedaOpt);
		} else if (cantoMoneda == 1) { // Si ha salido canto
			this.print(this.frase(8));
		}
	}

	private void resolucionTurno(int ladoMoneda, int ladoMonedaOpt) {
		switch (ladoMoneda) {
		case 1: // Cara
			this.print(this.frase(4));
			switch (ladoMonedaOpt) {
			case 1: // Si has escogido cara y sale cara ganas
				this.ganadoTurno();
				break;
			case 2: // Si has escogido cruz y sale cara pierdes
				this.perdidoTurno();
				break;
			}
			break;
		case 2:
			this.print(this.frase(5));
			switch (ladoMonedaOpt) {
			case 1: // Si has escogido cara y sale cruz pierdes
				this.perdidoTurno();
				break;
			case 2: // Si has escogido cruz y sale cruz ganas
				this.ganadoTurno();
				break;
			}
			break;
		}
	}

	private void ganadoTurno() {
		this.print(this.frase(6));
		ganadoMoneda++;
	}

	private void perdidoTurno() {
		this.print(this.frase(7));
		perdidoMoneda++;
	}

	private String puntuacion() {
		String frase = "ganado: " + ganadoMoneda + "\nPerdido: " + perdidoMoneda;
		return frase;
	}

	private boolean comprobarPuntuacion() {
		boolean salir = false;
		if (ganadoMoneda == 3) {
			salir = true; // Si has ganado 3 veces sale del minijuego
		} else if (perdidoMoneda == 3) {
			salir = true; // Si has perdido 3 veces sale del minijuego
		}
		return salir;
	}

}
