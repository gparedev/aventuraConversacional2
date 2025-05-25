package model.miniJuegos;

import java.util.Scanner;
import model.Printer;

public class Juego1 implements Printer{

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
				"\nMinijuego finalizado, te despides de " + currentNpc, "\nElige entre las siguientes opciones: " };

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

	private int eleccionEnemigo() {
		int enemyChoice = (int) (Math.random() * 3) + 1;
		return enemyChoice;
	}

	private void ronda(int myChoice, int enemyChoice) {
		String[] opciones = { "Piedra", "Papel", "Tijera" };
		switch (myChoice) {
		// Si elijo 1.- piedra...
		case 1:
			System.out.println("Has elegido " + opciones[0] + "\n");
			if (enemyChoice == 1) {
				System.out.println(currentNpc + " eligió " + opciones[0]);
				System.out.println("\nEmpate!");
			} else if (enemyChoice == 2) {
				System.out.println(currentNpc + " eligió " + opciones[1]);
				System.out.println("\nPierdes!");
				derrotas++;
			} else {
				System.out.println(currentNpc + " eligió " + opciones[2]);
				System.out.println("\nGanas!");
				victorias++;
			}
			break;
		// Si elijo 2.- papel...
		case 2:
			System.out.println("Has elegido " + opciones[1] + "\n");
			if (enemyChoice == 1) {
				System.out.println(currentNpc + " eligió " + opciones[0]);
				System.out.println("\nGanas!");
				victorias++;
			} else if (enemyChoice == 2) {
				System.out.println(currentNpc + " eligió " + opciones[1]);
				System.out.println("\nEmpate!");
			} else {
				System.out.println(currentNpc + " eligió " + opciones[2]);
				System.out.println("\nPierdes!");
				derrotas++;
			}
			break;
		// Si elijo 3.- Tijera...
		case 3:
			System.out.println("Has elegido " + opciones[2] + "\n");
			if (enemyChoice == 1) {
				System.out.println(currentNpc + " eligió " + opciones[0]);
				System.out.println("\nPierdes!");
				derrotas++;
			} else if (enemyChoice == 2) {
				System.out.println(currentNpc + " eligió " + opciones[1]);
				System.out.println("\nGanas!");
				victorias++;
			} else {
				System.out.println(currentNpc + " eligió " + opciones[2]);
				System.out.println("\nGanas!");
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
