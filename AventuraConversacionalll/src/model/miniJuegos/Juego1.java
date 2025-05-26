package model.miniJuegos;

import java.util.Scanner;
import model.Printer;

public class Juego1 implements Printer {

	// PIEDRA, PAPEL O TIJERA

	// ATRIBUTOS
	int victorias = 0;
	int derrotas = 0;

	// VARIABLES DE PRUEBA
	String currentNpc = "Antonio";

	// CONSTRUCTORES

	public Juego1() {

	}

	// GET Y SET

	// FUNCIONES

	public void juegoStart() {
		// Trama del juego
		this.tramaJuego();
		// Mensaje final de juego
		this.finalJuego();
	}

	private String frase(int num) {
		String[] frases = { "\nVamos a jugar a piedra, papel o tijera",
				"\nGanas el minijuego!\n" + currentNpc + ": Eres bastante máquina tú, campeón.\nHas ganado 20 monedas",
				"\nPierdes el minijuego!" + currentNpc + ": Lo has intentado chaval, prueba la próxima vez.",
				"\nMinijuego finalizado, te despides de " + currentNpc, "\nElige entre las siguientes opciones: ",
				"\nEmpate!", "\nPierdes!", "\nGanas!" };

		String text = frases[num];
		return text;
	}

	private void tramaJuego() {
		this.print(this.frase(0));
		while (this.victorias < 2 && this.derrotas < 2) {
			Scanner sc = new Scanner(System.in);
			int myChoice;
			int enemyChoice;
			// FORZAMOS AL USUARIO A ELEGIR ENTRE 1, 2 O 3
			do {
				// Se reasignan las variables cada vez que el turno se acaba
				myChoice = 0;
				enemyChoice = 0;
				this.print(this.frase(4));
				this.imprimirOpciones();
				myChoice = sc.nextInt();
				sc.nextLine();
			} while (myChoice <= 0 || myChoice >= 4);
			// Obtenemos un numero aleatorio para asignar una eleccion al enemigo
			enemyChoice = eleccionEnemigo();
			// Resolución de ronda
			this.ronda(myChoice, enemyChoice);
		}

	}

	private void imprimirOpciones() {
		String[] opciones = { "Piedra", "Papel", "Tijera" };
		for (int i = 0; i < opciones.length; i++) {
			System.out.println((i + 1) + ".- " + opciones[i]);
		}
	}

	private void imprimirEleccionPersonaje(String opt) {
		String text = "Has elegido " + opt + "\n";
		this.print(text);
	}

	private void imprimirEleccionEnemigo(String opt) {
		String text = currentNpc + "eligió " + opt;
		this.print(text);
	}

	private int eleccionEnemigo() {
		int enemyChoice = (int) (Math.random() * 3) + 1;
		return enemyChoice;
	}

	private void ronda(int myChoice, int enemyChoice) {
		String[] opciones = { "Piedra", "Papel", "Tijera" };
		switch (myChoice) {
		// Si elijo 1.- piedra...
		case 1:
			this.imprimirEleccionPersonaje(opciones[0]);
			if (enemyChoice == 1) {
				this.imprimirEleccionEnemigo(opciones[0]);
				this.print(this.frase(5));
			} else if (enemyChoice == 2) {
				this.imprimirEleccionEnemigo(opciones[1]);
				this.print(this.frase(6));
				derrotas++;
			} else {
				this.imprimirEleccionEnemigo(opciones[2]);
				this.print(this.frase(7));
				victorias++;
			}
			break;
		// Si elijo 2.- papel...
		case 2:
			this.imprimirEleccionPersonaje(opciones[1]);
			if (enemyChoice == 1) {
				this.imprimirEleccionEnemigo(opciones[0]);
				this.print(this.frase(7));
				victorias++;
			} else if (enemyChoice == 2) {
				this.imprimirEleccionEnemigo(opciones[1]);
				this.print(this.frase(5));
			} else {
				this.imprimirEleccionEnemigo(opciones[2]);
				this.print(this.frase(6));
				derrotas++;
			}
			break;
		// Si elijo 3.- Tijera...
		case 3:
			this.imprimirEleccionPersonaje(opciones[2]);
			if (enemyChoice == 1) {
				this.imprimirEleccionEnemigo(opciones[0]);
				this.print(this.frase(6));
				derrotas++;
			} else if (enemyChoice == 2) {
				this.imprimirEleccionEnemigo(opciones[1]);
				this.print(this.frase(7));
				victorias++;
			} else {
				this.imprimirEleccionEnemigo(opciones[2]);
				this.print(this.frase(5));
			}
			break;
		}
	}

	private void finalJuego() {
		if (this.victorias == 2) {
			this.print(this.frase(1));
			// personaje.setGamesWon++;
			// personaje.setCoins += 20;
		} else {
			this.print(this.frase(2));
		}
		this.print(this.frase(3));
	}
}
