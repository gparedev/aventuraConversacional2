package model.miniJuegos;

import java.util.Arrays;
import java.util.Scanner;

public class Juego4 {

	// ADIVINA LA PALABRA

	// ATRIBUTOS
	int numPalabra;
	int contador = 15;
	String palabra[] = this.palabra();
	String respuesta[] = this.respuesta(palabra);
	String[] letrasUsadas = new String[31];

	// VARIABLES DE PRUEBA
	String currentNpc = "Antonio";

	// CONSTRUCTORES

	public Juego4() {

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
		String[] frases = { "\nHas ganado, has adivinado la palabra\nHas ganado 20 monedas\n",
				"\nHas perdido, no has adivinado la palabra\nLa palabra era: " + this.palabraCompleta(),
				"\nVamos a jugar a adivinar la palabra, tienes que ir escogiendo letras y yo te diré si se encuentran o no dentro de la palabra",
				"\n¿Qué letra quieres escoger?", "Se ha producido un error, por favor, introduzca solo 1 caracter",
				"Te quedan " + contador + " intentos fallidos\nRespuesta: " };

		String text = frases[num];
		return text;
	}

	private void imprimir(String text) {
		System.out.println(text);
	}

	private void tramaJuego() {
		String letra;
		int cantidad = 1;
		boolean letraTrue = false;
		Scanner sc = new Scanner(System.in);
		this.imprimir(this.frase(2));
		do {
			this.imprimir(this.frase(3));
			letra = sc.nextLine(); // Pregunta del caracter al usuario
			cantidad = letra.length(); // Se comprueba la cantidad de caracteres existentes en la respuesta del usuario
			this.comprobarCaracteres(letra);
			this.respuestaIntentos();

		} while (!Arrays.equals(palabra, respuesta) && contador > 0);

	}

	private void finalJuego() {
		if (Arrays.equals(palabra, respuesta)) { // Si los arrays de la palabra y la respuesta son iguales gana
			this.imprimir(this.frase(0));
//			gamesWon++;
//			coins += 20;
		} else if (contador <= 0) { // Si el contador llega a 0 pierde
			this.imprimir(this.frase(1));
		}
	}

	private String palabraCompleta() {
		String palabra = null;
		switch (numPalabra) {
		case 0:
			palabra = "corazon";
			break;
		case 1:
			palabra = "reino";
			break;
		case 2:
			palabra = "fantasia";
			break;
		case 3:
			palabra = "cuadrado";
			break;
		case 4:
			palabra = "androide";
			break;
		case 5:
			palabra = "planeta";
			break;
		case 6:
			palabra = "cristales";
			break;
		case 7:
			palabra = "disney";
			break;
		case 8:
			palabra = "sincorazon";
			break;
		case 9:
			palabra = "castillo";
			break;
		}

		return palabra;
	}

	private String[] palabra() {
		int palabraRandom = this.palabraRandom(); // Escoge un número aleatorio de entre 10 para elegir la palabra

		switch (palabraRandom) { // Switch con los arrays de las diferentes palabras
		case 0:
			palabra = new String[] { "c", "o", "r", "a", "z", "o", "n" }; // 7 corazon
			break;
		case 1:
			palabra = new String[] { "r", "e", "i", "n", "o" }; // 5 reino
			break;
		case 2:
			palabra = new String[] { "f", "a", "n", "t", "a", "s", "i", "a" }; // 8 fantasia
			break;
		case 3:
			palabra = new String[] { "c", "u", "a", "d", "r", "a", "d", "o" }; // 8 cuadrado
			break;
		case 4:
			palabra = new String[] { "a", "n", "d", "r", "o", "i", "d", "e" }; // 8 androide
			break;
		case 5:
			palabra = new String[] { "p", "l", "a", "n", "e", "t", "a" }; // 7 planeta
			break;
		case 6:
			palabra = new String[] { "c", "r", "i", "s", "t", "a", "l", "e", "s" }; // 9 cristales
			break;
		case 7:
			palabra = new String[] { "d", "i", "s", "n", "e", "y" }; // 6 disney
			break;
		case 8:
			palabra = new String[] { "s", "i", "n", "c", "o", "r", "a", "z", "o", "n" }; // 10 sincorazon
			break;
		case 9:
			palabra = new String[] { "c", "a", "s", "t", "i", "l", "l", "o" }; // 8 castillo
			break;
		}
		return palabra;
	}

	private int palabraRandom() {
		int palabraRandom = (int) (Math.random() * 10);
		return palabraRandom;
	}

	private String[] respuesta(String palabra[]) { // El método coge los datos del array palabra
		String respuesta[] = new String[palabra.length]; // Se crea un array de respuesta al cual se le asigna el mismo
															// número de espacios que al array palabra.
		Arrays.fill(respuesta, "_"); // Se rellena el array respuesta entero con el mismo caracter.

		return respuesta;
	}

	private void comprobarCaracteres(String letra) {
		if (letra.length() == 1) { // solo si la cantidad de caracteres escritos en la respuesta es 1, se inicia el
			// if
			boolean repetida = this.comprobarLetraUsada(letra);

			if (repetida == false) { // Si el caracter insertado no está repetido en una anterior respuesta
				this.usarLetra(letra);
			}

		} else { // Si la respuesta tiene más de 1 caracter
			this.imprimir(this.frase(5));
		}
	}

	private boolean comprobarLetraUsada(String letra) {
		boolean repetida = false;
		for (int i = 0; i < letrasUsadas.length; i++) { // El siguiente if comprueba si la letra escrita ya se
			// ha usado, comprobando si ya existe una letra
			// igual dentro del array de palabras usadas
			if (letra.equalsIgnoreCase(letrasUsadas[i])) { // poniendo el array primero, da error, pero
															// poniendo el string primero funciona
				this.imprimir(this.letraUsada(letra));
				repetida = true; // indica que la letra está repetida, ponindo el valor en true
			}
		}
		return repetida;
	}

	private String letraUsada(String letra) {
		String frase = "La letra " + letra + " ya se ha usado";
		return frase;
	}

	private void usarLetra(String letra) {
		int n = 1;
		boolean letraTrue = false;
		letrasUsadas[n++] = letra; // Se añade el caracter insertado a un array que reune los caracteres
		// usados con anterioridad en la partida y se suma una posición al
		// array, para que la siguiente vez que añada un caracter, se
		// almacene en la siguiente posición
		for (int i = 0; i < palabra.length; i++) {
			if (palabra[i].equalsIgnoreCase(letra)) { // Se comparan las posiciones del array de la palabra
				// con la letra
				respuesta[i] = letra; // Si una letra coincide, se coloca esa letra en el array de la
				// respuesta, en la misma posicion que en la que se encuentra en el
				// array de la palabra
				letraTrue = true; // Indica que se ha encontrado una letra que coincide
			}
		}
		this.compararLetra(letraTrue, letra);
	}

	private void compararLetra(boolean letraTrue, String letra) {
		if (letraTrue == true) { // Si ha coincidido una letra
			System.out.println("La letra " + letra + " se encuentra en la palabra");
		} else { // Si no ha coincidido ninguna letra
			System.out.println("La letra " + letra + " no se encuentra en la palabra");
			contador--; // Se suma un fallo, por lo que resta al contador los fallos que le quedan
		}
	}

	private void respuestaIntentos() {
		this.imprimir(this.frase(5));
		for (int i = 0; i < respuesta.length; i++) {
			System.out.print(respuesta[i]); // Imprime el array de la respuesta
		}
	}

}
