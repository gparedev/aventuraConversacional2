package model.miniJuegos;

import java.util.Scanner;

public class Juego3 {

	// PARES O NONES

	// ATRIBUTOS
	int contadorPuntosParesONonesJugador = 0;
	int contadorPuntosParesONonesNPC = 0;

	// VARIABLES DE PRUEBA
	String currentNpc = "Antonio";

	// CONSTRUCTORES

	public Juego3() {

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
		String[] frases = { "\n" + currentNpc + ": Has ganado, maquinita\nHas ganado 20 monedas",
				"\n" + currentNpc + ": Has perdido, eres más tonto que un zapato",
				"\nBienvenido al pares o nones.\n¿Qué papel deseas desempeñar en esta aventura?:\n1.- Pares | 2.- Nones",
				"Has elegido pares\nSi la suma de los números lanzados es par, habrás ganado 1 punto.\n",
				"Has elegido nones\nSi la suma de los números lanzados es impar, habrás ganado 1 punto.",
				"El primero en llegar a 3 puntos habrá ganado, ¡SUERTE!", "\nLanza un número entre el 1 y el 5:" };

		String text = frases[num];
		return text;
	}

	private void imprimir(String text) {
		System.out.println(text);
	}

	private void tramaJuego() {
		int eleccionParesONones = this.eleccionParesONones();
		this.imprimirEleccion(eleccionParesONones);
		this.condicionTrama(eleccionParesONones);
	}

	private void condicionTrama(int eleccion) {
		while (contadorPuntosParesONonesJugador < 3 && contadorPuntosParesONonesNPC < 3) {
			int numeroAleatorio = this.numAleatorio();
			int numeroLanzado = this.numLanzado();
			int sumaDeNumerosSacados = numeroAleatorio + numeroLanzado;
			this.turno(eleccion, sumaDeNumerosSacados, numeroAleatorio, numeroLanzado);
		}
	}

	private void turno(int eleccion, int sumaNums, int numAleatorio, int numLanzado) {
		switch (eleccion) {
		case 1:
			if (sumaNums % 2 == 0) {
				this.imprimir(fraseTurno(numAleatorio, numLanzado, sumaNums));
				this.imprimir(this.ganarTurno());
				this.imprimir(this.marcador());
			} else if (sumaNums % 2 != 0) {
				this.imprimir(fraseTurno(numAleatorio, numLanzado, sumaNums));
				this.imprimir(this.perderTurno());
				this.imprimir(this.marcador());
			}
			break;
		case 2:
			if (sumaNums % 2 != 0) {
				this.imprimir(fraseTurno(numAleatorio, numLanzado, sumaNums));
				this.imprimir(this.ganarTurno());
				this.imprimir(this.marcador());
			} else if (sumaNums % 2 == 0) {
				this.imprimir(fraseTurno(numAleatorio, numLanzado, sumaNums));
				this.imprimir(this.perderTurno());
				this.imprimir(this.marcador());
			}
			break;
		}

	}

	private String fraseTurno(int numAleatorio, int numLanzado, int sumaNums) {
		String text = currentNpc + " ha sacado el número: " + numAleatorio + "\nHas sacado el número " + numLanzado
				+ "\nLa suma de ambos números es: " + sumaNums;

		return text;
	}

	private String ganarTurno() {
		String text = "\nHas ganado una ronda";
		contadorPuntosParesONonesJugador++;
		return text;
	}

	private String perderTurno() {
		String text = "\nHas perdido una ronda";
		contadorPuntosParesONonesNPC++;
		return text;
	}

	private String marcador() {
		String text = "\nMARCADOR:\nTú: " + contadorPuntosParesONonesJugador + " " + currentNpc + ": "
				+ contadorPuntosParesONonesNPC;

		return text;
	}

	private int numLanzado() {
		Scanner sc = new Scanner(System.in);
		int numLanzado = 0;
		while (numLanzado <= 0 || numLanzado >= 6) {
			this.imprimir(this.frase(6));
			numLanzado = sc.nextInt();
		}
		return numLanzado;
	}

	private int numAleatorio() {
		int numeroAleatorio = (int) (Math.random() * 5) + 1;
		return numeroAleatorio;
	}

	private int eleccionParesONones() {
//		this.imprimir(this.frase(2));
		Scanner sc = new Scanner(System.in);
		int eleccionParesONones = 0;
//		eleccionParesONones = sc.nextInt();
		while (eleccionParesONones != 1 && eleccionParesONones != 2) {
			this.imprimir(this.frase(2));
			eleccionParesONones = sc.nextInt();
		}
		return eleccionParesONones;
	}

	private void imprimirEleccion(int eleccion) {
		switch (eleccion) {
		case 1:
			this.imprimir(this.frase(3));
			break;
		case 2:
			this.imprimir(this.frase(4));
			break;
		}
		this.imprimir(this.frase(5));
	}

	private void finalJuego() {
		if (contadorPuntosParesONonesJugador == 3) {
			this.imprimir(this.frase(0));
//			gamesWon++;
//			coins += 20;
		} else if (contadorPuntosParesONonesNPC == 3) {
			this.imprimir(this.frase(1));
		}

	}

}
