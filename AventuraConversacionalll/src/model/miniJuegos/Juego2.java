package model.miniJuegos;

import java.util.Scanner;
import model.Printer;

public class Juego2 implements Printer {

	// PREGUNTAS

	// ATRIBUTOS

	int error = 0;
	int[] indexArray;
	String[] preguntas = { "¿Cuánto es 2 + 2?", "Oro parece... platano es ¿Qué es?",
			"¿Cuál es el nombre del incorporeo de Sora?",
			"Habla y no tiene boca, oye y no tiene oído, es chiquito y hace ruido, muchas veces se equivoca.",
			"Soy muy lenta y me gusta nadar, llevo siempre conmigo mi propio hogar ¿quién soy?" };
	String currentNpc = null;

	// CONSTRUCTORES

	public Juego2() {

	}

	// GET Y SET

	public void setCurrentNpc(String currentNpc) {
		this.currentNpc = currentNpc;
	}
	
	// FUNCIONES

	public boolean juegoStart(String npc) {
		this.setCurrentNpc(npc);
		boolean gameWin = false;
		this.indexArray();
		// Trama del juego
		this.tramaJuego();
		// Mensaje final de juego
		gameWin = this.finalJuego();
		return gameWin;
	}

	private String frase(int num) {
		String[] frases = {
				"\n" + currentNpc + ": Hola, responde a las siguientes preguntas, si fallas 2 veces o más pierdes\n",
				currentNpc + ": Has perdido, tontito",
				currentNpc + ": Has ganado el juego, figurín.\nHas ganado 20 monedas", "Correcto!", "Error" };

		String text = frases[num];
		return text;
	}

	private void indexArray() {
		// Hago que el tamño de mi Array sea el mismo que la cantidad de opciones que
		// hay en questionArray, donde se almacenaran las preguntas.
		indexArray = new int[preguntas.length];
		// Inicializo el array de los indices a -1 para que no haya problemas más
		// adelante
		for (int i = 0; i < indexArray.length; i++) {
			indexArray[i] = -1;
		}
		// RELLENAR ARRAY CON INDICES ALEATORIOS SIN QUE ESTOS SE REPITAN
		for (int i = 0; i < indexArray.length; i++) {
			// Creamos un checker para ir comprobando que el numero aleatorio no aparece en
			// ningun elemento de la lista questionArray
			boolean checker = false;
			int numRand = 0;

			// Este while se hace para que cada vez que evaluamos el indice i de nuestra
			// lista compruebe que el numero
			// Aleatorio que se ha sacado no aparece en la misma lista
			// Este comportamiento se establece gracias a un contador
			while (!checker) {
				// Cada vez que entramos al bucle while inicializamos el contador a 0
				int counter = 0;
				// Numero aleatorio del 0 al 4 en este caso concreto
				numRand = (int) (Math.random() * (preguntas.length));
				// Para cada elemento del array [i] lo evaluaremos .length veces, en este caso 5
				for (int j = 0; j < indexArray.length; j++) {
					// Si el numero que obtenemos de manera aleatoria es diferente al indice
					// evaluado se sumara a un contador
					// ESTO SIGNIFICA QUE SI EL NUMERO ALEATORIO ES IGUAL A ALGUNO QUE YA SE
					// ENCUENTRA EN LISTA
					// EL CONTADOR NO LLEGARA A .length VECES Y NUNCA SALDREMOS EL BUCLE
					if (indexArray[j] != numRand) {
						counter++;
					}

				}
				// Cuando el contador sea .length o en este caso 5, SIGNIFICARA QUE EL NUMERO
				// ALEATORIO NO APARECE EN NINGUN ELEMENTO
				// DE LA LISTA POR LO QUE SALDREMOS DEL BUCLE WHILE
				if (counter == indexArray.length) {
					checker = true;
				}

			}
			// UNA VEZ SALIMOS DEL BUCLE WHILE, SIGNIFICARA QUE EL NUMERO RANDOM SACADO NO
			// APARECE AUN EN LA LISTA Y
			// PODEMOS ASIGNAR ESE VALOR AL INDICE EVALUADO
			indexArray[i] = numRand;
		}
	}

	private void tramaJuego() {
		this.print(this.frase(0));
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < preguntas.length; i++) {
			// Vamos recorriendo el Array de indices aleatorios para que las preguntas
			// salgan en orden aleatorio
			int index = indexArray[i];
			// Imprimimos las preguntas a partir del indice aleatorio
			System.out.println(preguntas[index]);
			String answer = "";
			String palabra = null;
			switch (index) {
			// Pregunta 0
			case 0:
				answer = sc.nextLine().toLowerCase();
				palabra = "4";
				this.comprobarRespuesta(answer, palabra);
				break;
			// Pregunta 1
			case 1:
				answer = sc.nextLine().toLowerCase();
				palabra = "platano";
				this.comprobarRespuesta(answer, palabra);
				break;
			// Pregunta 2
			case 2:
				answer = sc.nextLine().toLowerCase();
				palabra = "roxas";
				this.comprobarRespuesta(answer, palabra);
				break;
			// Pregunta 3
			case 3:
				answer = sc.nextLine().toLowerCase();
				palabra = "telefono";
				this.comprobarRespuesta(answer, palabra);
				break;
			// Pregunta 4
			case 4:
				answer = sc.nextLine().toLowerCase();
				palabra = "tortuga";
				this.comprobarRespuesta(answer, palabra);
				break;
			}
		}
	}
	
	private void comprobarRespuesta(String answer, String palabra) {
		if (answer.equals(palabra)) {
			this.print(this.frase(3));
		} else {
			this.print(this.frase(4));
			error++;
		}
	}

	private boolean finalJuego() {
		boolean gamesWin = false;
		if (error >= 2) {
			this.print(this.frase(1));
		} else {
			this.print(this.frase(2));
			gamesWin = true;
		}
		return gamesWin;
	}

}
