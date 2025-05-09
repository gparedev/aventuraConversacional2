package model;

	import java.util.Arrays;
	import java.util.Random;
	import java.util.Scanner;

	public class AventuraConversacionalOriginal {
		// VARIABLES GLOBALES
		static final int NUMBER_OF_GAMES = 5;
		static int gamesWon = 0;
		static String heroName = "";
		static String gen;
		static String universe;
		static String[] locations;
		static String[] descLocation;
		static String[] npcs;
		static String[] npcPhrase;
		static String currentNpc = "";
		static int[] randomListToGames;
		static String contrasena = "";
		static int heroHp = 100;
		static int heroHpMax = 100;
		static int enemyHp;
		static int enemyHpMax;
		static String[] heroAttacks = { "", "" };
		static String[] enemyAttacks = { "", "" };
		static int heroDamage[] = new int[] { 10, 20 };
		static int enemyDamage[] = new int[] { 8, 16 };
		static String enemyName = "";
		static String[] enemyNames = { "", "", "", "", "", "" };
		static String backpackObjets[] = new String[] { "poción de vida", "poción de ataque" }; // Nombres de pociones que
																								// tienes
		static int backpackNum[] = new int[] { 2, 2 }; // numero de pociones que tiene el personaje en la mochila
		static boolean abalorioBoolean;

		// Variables para el combate
		static boolean heroAttackUpgrade = false;
		static boolean enemyAttackUpgrade = false;
		static int heroDefenseAttack = 0;
		static int enemyDefenseAttack = 0;
		static int damageCaused = 0;
		static boolean attack;
		static boolean usedPotion = false;
		static boolean huir = false;
		static boolean gameOver = false;
		static boolean explorar = false;

		// Booleano para el combate final dificil
		static boolean dificil = false;

		// Variables para la tienda
		static String[] itemsTienda = { "" };
		static String vendedor = "";
		static int coins = 100;

		public static void main(String[] args) {

			// Estadisticas personaje
			String[] abalorios = { "", "", "" };

			String[] heros = { "2A", "Sora", "Cloud" };
			// En vez de hacer visited1 visited2 visited3... es más interesante hacer un
			// array de visited.boolean
			boolean[] visited = { false, false, false, false, false };
			int completedWorlds = 0;

			int index = 0;

			Scanner sc = new Scanner(System.in);

			// ---------------------------------------------------------------------------------------------------------------------//

			// CARTEL DE BIENVENIDA
			bienvenida();

			// CONTRASEÑA
			contrasena(contrasena);

			// Aparte de desplegar el menu, esta función nos devuelve un entero que podemos
			// utilizar para asignar las variables
			// De nuestra aventura, el segundo argumento es para especificar que hay en
			// nuestro menu
			index = displayMenu(heros, "(Personajes)");

			randomArray();

			// Tenemos que restar a nuestro indice 1 para colocarnos en el indice del array
			// deseado ya que este empieza por 0
			// Esta se resta se va a haber constantemente durante el codigo.
			// Esta linea de codigo es redundante ya que volvemos a asignar el valor más
			// adelante en la parte de asignación
			// heroName = heros[index - 1];

			// System.out.println("El nombre de tu heroe es: " + heroName);

			// ASIGNACION DE PERSONAJE
			switch (index) {

			case 1:

				System.out.println("Hola 2A, la resistencia YorHa está contigo");
				heroName = "2A";
				gen = "a";
				universe = "NieR: Automata";
				heroAttacks = new String[] { "Ataque ligero", "Ataque pesado" };
				enemyAttacks = new String[] { "Ataque androide", "Ataque androide cibernetico" };
				enemyNames = new String[] { "R2D2", "Goliath", "Stubby", "Flyer", "Kamikaze", "Amalgama Robótica",
						"Sincorazon" };
				abalorios = new String[] { "Espada YorHa", "Baston YorHa", "Escudo Alienígena" };
				npcs = new String[] { "2B", "9S", "Pascal", "Emil", "Eva", "Mickey" };
				locations = new String[] { "El parque de atracciones", "El páramo", "La Ciudad Inundada",
						"La Residencia de Emil", "El bosque profundo" };

				itemsTienda = new String[] { "Anillo de Poder de ataque (50)", "Armadura Robótica (75)",
						"Poción de vida (25)", "Poción de ataque (25)", "Salir" };
				vendedor = "Pod 042";

				descLocation = new String[] {
						"Coges la nave gumi y aterrizas en " + locations[0] + " una zona llena de vida y diversion,"
								+ "donde te encuentras a " + npcs[0] + " ...",

						"Coges la nave gumi y aterrizas en " + locations[1] + " una zona desertica y asolada,"
								+ "donde te encuentras a " + npcs[1] + " ...",

						"Coges la nave gumi y aterrizas en " + locations[2] + " un lugar confuso lleno de agua,"
								+ "donde te encuentras a " + npcs[2] + " ...",

						"Coges la nave gumi y aterrizas en " + locations[3] + " un sitio acogedor,"
								+ "donde te encuentras a " + npcs[3] + " ...",

						"Coges la nave gumi y aterrizas en " + locations[4] + " respieras el aire puro y la tranquilidad, "
								+ "sigues mas adelante y te cruzas con " + npcs[4] + " ..." };

				npcPhrase = new String[] { "\n" + npcs[0] + ": Hola, soy 2B, te reto a un juego",
						npcs[1] + ": Hola, soy 9S, prueba a derrotarme",
						npcs[2] + ": Hola, soy Pascal, eres incapaz de ganar a una máquina intelectualmente",
						npcs[3] + ": Bienvenido a mi residencia . . .",
						npcs[4] + ": Hola, llevo un rato derrotando robots. Vamos a jugar a un juego" };
				break;

			case 2:

				System.out.println("Hola Sora, el poder de la Llave Espada está contigo.");
				heroName = "Sora";
				gen = "o";
				universe = "Kingdom Hearts";
				heroAttacks = new String[] { "Ataque ligero", "Ataque pesado" };
				enemyAttacks = new String[] { "Ataque Disney", "Ataque Sin Corazón" };
				enemyNames = new String[] { "Tío Gilito", "Baymax", "Hamm", "Boo", "Santa Claus", "Amalgama de juguetes",
						"Sincorazon" };
				abalorios = new String[] { "Llave Espada", "Bastón Magia Plus", "Escudo Fantasma" };
				npcs = new String[] { "Buzz Lightyear", "Sulley", "Zeus", "Jack Sparrow", "Remy", "Rompe Ralph" };
				locations = new String[] { "Toy Story", "El País de las Maravillas", "La Ciudad de la Navidad",
						"El Bosque de los enanitos", "La Casa de Mickey Mouse" };

				itemsTienda = new String[] { "Fuerza Plus de ataque (50)", "Armadura de titanio (75)",
						"Poción de vida (25)", "Poción de ataque (25)", "Salir" };
				vendedor = "Moguri";

				descLocation = new String[] {
						"Coges la nave gumi y aterrizas en " + locations[0] + " una zona llena de juguetes y diversion,"
								+ "donde te encuentras a " + npcs[0] + " ...",

						"Coges la nave gumi y aterrizas en " + locations[1] + " una zona fantástica y surrealista,"
								+ "donde te encuentras a " + npcs[1] + " ...",

						"Coges la nave gumi y aterrizas en " + locations[2] + " un lugar lleno de nieve y muy frío,"
								+ "donde te encuentras a " + npcs[2] + " ...",

						"Coges la nave gumi y aterrizas en " + locations[3] + " un lugar muy boscoso,"
								+ "donde te encuentras a " + npcs[3] + " ...",

						"Coges la nave gumi y aterrizas en " + locations[4] + ", se contempla el juego y la amistad,"
								+ "sigues mas adelante y te cruzas con " + npcs[4] + " ..." };

				npcPhrase = new String[] { "\n" + npcs[0] + ": Hola, soy Buzz Lightyear, hasta el infinito... ¡y más allá!",
						npcs[1] + ": Hola, soy Sulley, prueba a asustarme",
						npcs[2] + ": Hola, soy Zeus, hasta los confines del Olimpo, nadie podrá vencernos",
						npcs[3] + ": El mar es mi casa",
						npcs[4] + ": Hola, llevo un rato cocinando. Vamos a jugar a un juego" };
				break;

			case 3:
				System.out.println("Hola Cloud, el destino de Midgard está en tus manos");
				heroName = "Cloud";
				gen = "o";
				universe = "Final Fantasy";
				heroAttacks = new String[] { "Ataque ligero", "Ataque pesado" };
				enemyAttacks = new String[] { "Pyro +", "Pyro ++" };
				enemyNames = new String[] { "Garra Mortal", "Máquina de muerte", "Granadero", "Antidisturbios",
						"Eructador Cornudo", "Amalgama de Sephiroth", "Sincorazon" };
				abalorios = new String[] { "Shuriken", "Molinillo", "Escudo Oritsuru" };
				npcs = new String[] { "Barret", "Tifa", "Aerith", "Sephiroth", "Cait Sith", "Cid Highwind" };
				locations = new String[] { "Midgard", "Kalm", "Granja de Chocobos", "Minas de Mitrillo", "Fuerte Cóndor" };

				itemsTienda = new String[] { "Fuerza Plus de ataque (50)", "Armadura de titanio (75)",
						"Poción de vida (25)", "Poción de ataque (25)", "Salir" };
				vendedor = "Moguri";

				descLocation = new String[] {
						"Coges la nave gumi y aterrizas en " + locations[0] + " una zona tecnologicamente avanzada,"
								+ "donde te encuentras a " + npcs[0] + " ...",

						"Coges la nave gumi y aterrizas en " + locations[1] + " una zona devastada,"
								+ "donde te encuentras a " + npcs[1] + " ...",

						"Coges la nave gumi y aterrizas en " + locations[2] + " un lugar lleno de nieve y muy frío,"
								+ "donde te encuentras a " + npcs[2] + " ...",

						"Coges la nave gumi y aterrizas en " + locations[3] + " un lugar muy boscoso,"
								+ "donde te encuentras a " + npcs[3] + " ...",

						"Coges la nave gumi y aterrizas en " + locations[4] + ", un lugar tremendamente caluroso,"
								+ "sigues mas adelante y te cruzas con " + npcs[4] + " ..." };

				npcPhrase = new String[] { "\n" + npcs[0] + ": Yo soy Barret, líder de AVALANCHE! Juguemos a un juego",
						npcs[1] + ": Soy Tifa. Lucho por proteger lo que importa... Te reto a un juego",
						npcs[2] + ": Hola, soy Aerith. Tal vez parezca delicada, pero nunca subestimes el poder de una flor, juguemos",
						npcs[3] + ": Yo soy Sephiroth... el destino mismo hecho carne. Te desafío",
						npcs[4] + ": ¡Cait Sith a tu servicio! Juguemos" };
				break;
			default:
				System.out.println("Error");

			}
			// ---------------------------------------------------------------------------------------------------------------------//
			// ASIGNACION DE ABALORIO
			System.out.println("Bienvenido al hall de selección, donde escogeras el abalorio que te acompañara durante el "
					+ "resto de tu aventura");

			index = displayMenu(abalorios, "(Abalorios)");
			esperar(5);
			switch (index) {

			case 1:

				System.out.println("Te acercas a la " + abalorios[index - 1] + " y la coges, notas como la ira recorre"
						+ " tus venas... (Se incrementa tu daño de ataque)\n");
				// Esto tambien se podría hacer con un for...
				heroDamage[0] *= 2;
				heroDamage[1] *= 2;
				break;

			case 2:

				System.out.println("Te acercas a el " + abalorios[index - 1] + " y lo coges, notas como una magia te rodea,"
						+ " haciendote mucho más agil (Se incrementa tu probabilidad de esquiva)\n");
				abalorioBoolean = true;
				// Booleana para la agilidad?
				break;

			case 3:

				System.out.println("Te acercas a el " + abalorios[index - 1] + " y lo coges, notas como tu vitalidad crece,"
						+ " haciendote mucho más robusto (Se incrementa tu vida)\n");
				heroHp += 25;
				break;

			default:
				System.out.println("Error");

			}

			// ---------------------------------------------------------------------------------------------------------------------//
			// TUTORIAL DE COMBATE
			tutorial();
			// ---------------------------------------------------------------------------------------------------------------------//
			// INICIO DEL ESTADO DE JUEGO - NAVEGACION
			explorar = true;
			while (!gameOver && explorar) {

				// Aqui habria que meter otro gran while que sea para la zona de exploracion
				// Cuando completedWorlds = 5 podemos entrar al estado combate final
				index = displayMenu(locations, "(Localizaciones)");

				// NAVEGACION POR LOS MUNDOS
				switch (index) {

				case 1:
					// Todo esto se puede hacer un metodo ya que vamos a repetirlo
					if (!visited[index - 1]) {

						System.out.println("Viajas al mundo de: " + locations[index - 1]);
						// Esta variable de currentNpc es un parche para solucionar un problema en el
						// que al ser todos los juegos
						// Aleatorios, no puedo saber a que NPC está asignado para configurar los
						// dialogos
						currentNpc = npcs[index - 1];
						tienda();
						introMundo(index - 1);
						miniGames(randomListToGames[index - 1]);
						enemySet(index - 1);
						System.out.println("Oh, oh, parece que nos estaban acechando...");
						combate();
						// Despedida teniendo en cuenta el resultado del juego
						visited[index - 1] = true;
						completedWorlds++;

					} else {
						System.out.println("Ya has visitado este mundo");
					}
					break;

				case 2:

					if (!visited[index - 1]) {

						System.out.println("Viajas al mundo " + locations[index - 1]);
						currentNpc = npcs[index - 1];
						tienda();
						introMundo(index - 1);
						miniGames(randomListToGames[index - 1]);
						enemySet(index - 1);
						System.out.println("Parece que no estábamos solos; alguien nos vigilaba.");
						combate();
						// Despedida teniendo en cuenta el resultado del juego
						visited[index - 1] = true;
						completedWorlds++;

					} else {
						System.out.println("Ya has visitado este mundo");
					}
					break;

				case 3:

					if (!visited[index - 1]) {

						System.out.println("Viajas al mundo " + locations[index - 1]);
						currentNpc = npcs[index - 1];
						tienda();
						introMundo(index - 1);
						miniGames(randomListToGames[index - 1]);
						enemySet(index - 1);
						System.out.println("¡Atención, un enemigo nos ha sorprendido!");
						combate();
						// Despedida teniendo en cuenta el resultado del juego
						visited[index - 1] = true;
						completedWorlds++;

					} else {
						System.out.println("Ya has visitado este mundo");
					}
					break;

				case 4:

					if (!visited[index - 1]) {

						System.out.println("Viajas al mundo " + locations[index - 1]);
						currentNpc = npcs[index - 1];
						tienda();
						introMundo(index - 1);
						miniGames(randomListToGames[index - 1]);
						enemySet(index - 1);
						System.out.println("¡Parece que alguien quiere pelear con nosotros!");
						combate();
						// Despedida teniendo en cuenta el resultado del juego
						visited[index - 1] = true;
						completedWorlds++;

						if (completedWorlds >= 2) {
							opcionHuir();
						}

					} else {
						System.out.println("Ya has visitado este mundo");
					}
					break;

				case 5:

					if (!visited[index - 1]) {

						System.out.println("Viajas al mundo " + locations[index - 1]);
						currentNpc = npcs[index - 1];
						tienda();
						introMundo(index - 1);
						miniGames(randomListToGames[index - 1]);
						enemySet(index - 1);
						System.out.println("La calma en el aire es inquietante.");
						combate();
						// Despedida teniendo en cuenta el resultado del juego
						visited[index - 1] = true;
						completedWorlds++;

					} else {
						System.out.println("Ya has visitado este mundo");
					}
					break;

				default:
					System.out.println("Error");
				}

				// Comprobamos si hemos completado los 5 mundos para salir del bucle exploracion
				if (completedWorlds == 5) {

					explorar = false;
				}

			}
			// FASE FINAL DE RAMIFICACIONES

			// Si no hemos decicido huir... y estamos vivos (gameOver = false)
			if (!huir && !gameOver) {
				System.out.println("Has ganado " + gamesWon + " juegos...");
				System.out.println("Esto será decisivo para el devenir de tu aventura");
				if (gamesWon == 5 && !huir) {
					// Final bueno
					finals(1);
				} else if (gamesWon >= 3 && !huir) {
					// Final Meh ...
					finals(2);
				} else if (gamesWon < 3 && !huir) {
					// Final malo
					finals(3);
				}
			}

			System.out.println("Final de tu aventura");
		}

		// ---------------------------------------------------------------------------------------------------------------------//

		// FUNCIONES

		// DESPLIEGUE DE MENU QUE DEVUELVE EL ÍNDICE SELECCIONADO
		// Añadi el Keyword como segundo parámetro porque era necesario aclarar al
		// usuario de qué era la lista
		// y de este modo hacerlo todo más procedural

		public static void bienvenida() {
			System.out.println(
					"                                                                                                                          ");
			esperar(4);
			System.out.println(
					"                                                                                                                          ");
			System.out.println(
					"  ████           ██                                                                                                       ");
			esperar(1);
			System.out.println(
					"  █████          ██                                                                                           ████████    ");
			esperar(1);
			System.out.println(
					"  ██████         ██     ███████████  ███        ███  ██         ██     ███████            ██          ██    ███     ████  ");
			esperar(1);
			System.out.println(
					"  ███ ████       ██     ██            ███      ███   ██         ██   ███     ███          ██          ██    ██       ███  ");
			esperar(1);
			System.out.println(
					"  ███   ███      ██     ██             ███    ███    ██         ██   ██       ███         ██          ██             ███  ");
			esperar(1);
			System.out.println(
					"  ███    ███     ██     ██               ██  ██      ██         ██   ███                  ██          ██        ██████    ");
			esperar(1);
			System.out.println(
					"  ███     ███    ██     ██████████        ████       ██         ██     ██████             ██████████████         ██████   ");
			esperar(1);
			System.out.println(
					"  ███      ███   ██     ██                ████       ██         ██         █████          ██          ██              ██  ");
			esperar(1);
			System.out.println(
					"  ███       ███  ██     ██               ██  ██      ██         ██            ███         ██          ██              ███ ");
			esperar(1);
			System.out.println(
					"  ███        ██████     ██             ███    ███    ██         ██  ███        ██         ██          ██   ███        ██  ");
			esperar(1);
			System.out.println(
					"  ███          ████     ██            ███      ███   ████     ████   ███      ██          ██          ██    ███     ████  ");
			esperar(1);
			System.out.println(
					"  ███           ███     ███████████  ███        ███    █████████      █████████           ██          ██      ████████    ");
			esperar(1);
			System.out.println(
					"                                                                                                                          ");
			esperar(3);
			System.out.println(
					"                                                                                                                          ");
			System.out.println(
					"                                                                                                                          ");
			System.out.println(
					"                                                                                                                          ");
			System.out.println(
					"                                                                                                                          ");
			System.out.println(
					"       ███████   ████████████  ██      ██     ███     ████████   ████████       ████████  ███     ██   ██  ██    ██       ");
			esperar(1);
			System.out.println(
					"      ██     ██  ██        ██  ██      ██    ██ ██    ██     ██  ██             ██        ████    ██   ██   ██  ██        ");
			esperar(1);
			System.out.println(
					"       ████      ██        ██  ██      ██   ██   ██   ██     ██  ██             ██        ██ ██   ██   ██    ████         ");
			esperar(1);
			System.out.println(
					"          ████   ██        ██  ██      ██   ███████   ████████   ██  ███        ██  ███   ██  ██  ██   ██    ████         ");
			esperar(1);
			System.out.println(
					"             ██  ██        ██  ██      ██  ██     ██  ██  ███    ██             ██        ██   █████   ██   ██  ██        ");
			esperar(1);
			System.out.println(
					"      ███    ██  ██   ██   ██   ██    ███ ██      ██  ██    ██   ██             ██        ██     ███   ██  ██    ██       ");
			esperar(1);
			System.out.println(
					"        ██████   ████████████    ██████   ██       ██ ██     ██  ████████       ████████  ██     ███   ██ ██      ██      ");
			esperar(1);
			System.out.println(
					"                      ██                                                                                                  ");
			esperar(5);
			System.out.println("\n\n" + "          Grupo 14");
			esperar(5);
			System.out.println("\n" + "          Integrantes:");
			esperar(5);
			System.out.println("\n" + "          Gustavo Paredes");
			esperar(5);
			System.out.println("\n" + "          Luis Rodriguez");
			esperar(5);
			System.out.println("\n" + "          Alejandro del Blanco");
		}

		public static void contrasena(String contrasena) {
			Scanner sc = new Scanner(System.in);
			esperar(5);
			System.out.println("\n\n\nDebes introducir la contraseña para continuar:");
			contrasena = sc.nextLine();
			esperar(5);
			if (contrasena.equals("jugones")) {
				System.out.println("La contraseña es correcta, bienvenido al universo Nexus H3");
			} else {
				while (!contrasena.equals("jugones")) {
					System.out.println("Contraseña incorrecta");
					esperar(5);
					System.out.println("");
					System.out.println("⠀⠀⠀⠀⠀⠀⠀⠈⠀⠀⠀⠀⠀⠀⠀⠈⠈⠉⠉⠈⠈⠈⠉⠉⠉⠉⠉⠉⠉⠉⠙⠻⣄⠉⠉⠉⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
							+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠓⣄⠀⠀⢀⠀⢀⣀⣤⠄⠀⠀⠀⠀⠀⠀⠀\r\n"
							+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⢷⣉⣩⣤⠴⠶⠶⠒⠛⠛⠀⠀⠀⠀⠀\r\n"
							+ "⠀⠀⠀⠀⠀⠀⠀⠀⣴⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⣧⠤⠶⠒⠚⠋⠉⠀⠀⠀⠀⠀⠀⠀\r\n"
							+ "⠀⠀⠀⠀⠀⠀⢀⣾⡍⠀⠀⠀⠀⠀⠀⠀⠀⢠⣾⣫⣭⣷⠶⢶⣤⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠸⣆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
							+ "⠶⠶⠖⠚⠛⠛⣹⠏⠀⠀⠀⠀⠀⠀⠀⠀⠴⠛⠛⠉⡁⠀⠀⠙⠻⣿⣷⣄⡀⠀⠀⠀⠀⠀⠀⠀⠀⢹⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
							+ "⠀⠀⠀⠀⠀⢠⡏⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣴⣿⣿⡷⠷⢿⣦⣤⣈⡙⢿⣿⢆⣴⣤⡄⠀⠀⠀⠀⢸⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
							+ "⠀⠀⣠⣤⡀⣸⡄⠀⠀⠀⠀⠀⠀⠀⢀⣤⣿⣿⣟⣩⣤⣴⣤⣌⣿⣿⣿⣦⣹⣿⢁⣿⣿⣄⣀⡀⠀⢸⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
							+ "⠀⢠⣿⠋⠻⢿⡁⠀⠀⠀⠀⠀⠀⠀⠀⢸⡿⠿⠛⢦⣽⣿⣿⢻⣿⣿⣿⣿⠋⠁⠘⣿⣿⣿⣿⣿⣿⣼⣧⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
							+ "⠀⢸⣿⠁⠀⠀⠙⠆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠒⠿⣿⣯⣼⣿⡿⠟⠃⠀⠀⠀⣿⣿⣿⣿⣿⡛⣿⡟⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
							+ "⠀⢸⣧⣴⣿⡟⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣺⠟⠃⠀⠀⠀⠀⠀⠀⠙⣿⣿⣿⣿⣿⣿⢁⣀⣀⣀⣀⣀⣠⣀⣀⢀⢀⢀\r\n"
							+ "⠀⠀⢿⠿⣿⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⡆⠙⠛⠛⠙⢻⣶⣶⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿\r\n"
							+ "⣿⣿⡇⠀⠘⠃⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⡞⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\r\n"
							+ "⡟⢿⣿⣆⠀⣸⠇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢄⡼⠁⢀⣀⡀⠀⠀⠀⣦⣄⠀⣠⡄⣸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\r\n"
							+ "⣷⣬⢻⣿⡿⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠘⣧⣰⣿⡿⠿⠦⢤⣴⣿⣿⣷⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\r\n"
							+ "⣿⣿⣸⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠛⠛⠛⠒⣿⣿⣿⡿⠟⠹⣼⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\r\n"
							+ "⣿⠸⣿⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⣿⡖⠀⢠⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\r\n"
							+ "⡿⣾⣿⣸⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣴⣆⣀⣀⣤⣴⣶⣶⣾⣿⣷⣦⣴⣼⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\r\n"
							+ "⡇⣿⣿⡛⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⢾⡟⠛⠛⠻⠛⠛⠛⠿⠿⠿⠿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\r\n"
							+ "⠓⢁⣬⣿⠇⠀⠀⠀⠀⠀⢠⡀⠀⠀⠀⠀⠀⢰⡿⣻⠇⠀⠀⠀⠀⠀⣠⣶⣶⣶⣶⣿⣿⡿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\r\n"
							+ "⢐⣯⠞⠁⠀⠀⠀⠀⠀⠀⣄⠱⣄⠀⠀⠀⠀⠸⡧⠟⠆⠀⠀⠀⠀⠘⠿⢿⠿⠿⣿⡿⣿⠃⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\r\n"
							+ "⡾⠃⠀⠀⠀⠀⠀⠀⠀⠀⠘⢦⡈⠂⠀⠑⢄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⢠⣿⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\r\n"
							+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠒⡄⠀⠀⠑⠄⠀⠀⠀⠀⠀⠀⠀⢀⣠⣤⣦⣦⣼⡏⠳⣜⢿⠻⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\r\n"
							+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠁⠀⠀⠀⢠⣷⣦⣤⣀⣀⣀⣴⣿⣿⣿⣿⣿⡿⠻⠆⠸⣎⣧⠀⠈⠙⠿⣿⣿⣿⣿⣿⣿⣿⣿⣿\r\n"
							+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣄⠀⠀⠀⣸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠁⣠⡄⠀⣿⢹⡇⢸⡀⠀⠈⠻⢿⣿⣿⣿⣿⣿⣿");
					System.out.println("");
					esperar(5);
					System.out.println("Debes introducir la contraseña correcta:");
					contrasena = sc.nextLine();
				}
			}

		}

		public static int displayMenu(String[] inputArray, String keyWord) {

			int index = 0;

			Scanner sc = new Scanner(System.in);
			esperar(5);
			do {
				System.out.println("\nSelecciona entre las siguientes opciones " + keyWord + ": ");
				esperar(3);
				for (int i = 0; i < inputArray.length; i++) {
					System.out.println((i + 1) + ".- " + inputArray[i]);
				}

				index = sc.nextInt();
				sc.nextLine();

			} while (index <= 0 || index > inputArray.length);
			esperar(5);
			System.out.println("Has seleccionado la opción: " + inputArray[index - 1] + "\n");
			return index;
		}

		// Funcion pensada donde se podrian asignar todas las variables que dependen de
		// la seleccion principal

		public static void asignVariables(int index) {

		}

		// DESPLIEGUE DE MENU QUE DEVUELVE EL ÍNDICE SELECCIONADO

		public static void introMundo(int index) {
			cargandoMundo();
			// Te encuentras en EL PARQUE DE ATRACCIONES + ", " DESCRIPCCION UNA ZONA LLENA
			System.out.println(descLocation[index]);
			System.out.println(npcPhrase[index]);
			// DE VIDA Y ATRACCIONES... en la que
			// te encuentras a NOMBRE NPC que te reta a un minijuego...
		}

		public static void opcionHuir() {

			Scanner sc = new Scanner(System.in);

			System.out.println(
					"Tras tu aventura en " + locations[3] + " te cuestionas si realmente merece la pena seguir luchando "
							+ "por salvar el mundo o abandonar tu aventura para vivir una vida sin complicaciones");
			esperar(5);
			System.out.println("¿Qué decides?");
			int index = 0;
			esperar(3);
			do {
				System.out.println("1.- Continurar 2.- Abandonar");
				index = sc.nextInt();

			} while (index < 1 || index > 2);
			esperar(5);
			switch (index) {

			case 1:
				System.out.println("Has decicido continuar");
				huir = false;
				break;

			case 2:
				System.out.println("Has decicido Abandonar como una rata cobarde");
				huir = true;
				explorar = false;
				break;

			default:
				System.out.println("Error");

			}

		}

		public static void randomArray() {

			// Hago que el tamño de mi Array sea el mismo que la cantidad de opciones que
			// hay en questionArray, donde se almacenaran las preguntas.
			randomListToGames = new int[NUMBER_OF_GAMES];

			// Inicializo el array de los indices a -1 para que no haya problemas más
			// adelante
			for (int i = 0; i < randomListToGames.length; i++) {
				randomListToGames[i] = -1;
			}

			// ---------------------------------------------------------------------------------------------------------------------//

			// RELLENAR ARRAY CON INDICES ALEATORIOS SIN QUE ESTOS SE REPITAN
			for (int i = 0; i < randomListToGames.length; i++) {
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
					numRand = (int) (Math.random() * (NUMBER_OF_GAMES));
					// Para cada elemento del array [i] lo evaluaremos .length veces, en este caso 5
					for (int j = 0; j < randomListToGames.length; j++) {
						// Si el numero que obtenemos de manera aleatoria es diferente al indice
						// evaluado se sumara a un contador
						// ESTO SIGNIFICA QUE SI EL NUMERO ALEATORIO ES IGUAL A ALGUNO QUE YA SE
						// ENCUENTRA EN LISTA
						// EL CONTADOR NO LLEGARA A .length VECES Y NUNCA SALDREMOS EL BUCLE
						if (randomListToGames[j] != numRand) {
							counter++;
						}

					}
					// Cuando el contador sea .length o en este caso 5, SIGNIFICARA QUE EL NUMERO
					// ALEATORIO NO APARECE EN NINGUN ELEMENTO
					// DE LA LISTA POR LO QUE SALDREMOS DEL BUCLE WHILE
					if (counter == randomListToGames.length) {
						checker = true;
					}

				}
				// UNA VEZ SALIMOS DEL BUCLE WHILE, SIGNIFICARA QUE EL NUMERO RANDOM SACADO NO
				// APARECE AUN EN LA LISTA Y
				// PODEMOS ASIGNAR ESE VALOR AL INDICE EVALUADO
				randomListToGames[i] = numRand;

				// Debug para ver el resultado de la lista aleatoria
				// System.out.println(randomListToGames[i]);

			}
		}

		// MINIJUEGO PIEDRA PAPEL TIJERA (Por terminar de ajustar variables y personaje)

		public static void piedraPapelTijera() {
			Scanner sc = new Scanner(System.in);
			String[] opcionesPPT = { "Piedra", "Papel", "Tijera" };
			int victorias = 0;
			int derrotas = 0;
			int miChoice;
			int enemyChoice;
			// El juego se hara al mejor de tres

			System.out.println("\nVamos a jugar a piedra, papel o tijera");
			esperar(5);
			while (victorias < 2 && derrotas < 2) {

				// FORZAMOS AL USUARIO A ELEGIR ENTRE 1, 2 O 3
				do {
					esperar(5);
					// Voy reasignando las variables cada vez que el turno se acaba
					miChoice = 0;
					enemyChoice = 0;
					System.out.println("\nElige entre las siguientes opciones: ");
					esperar(3);
					for (int i = 0; i < opcionesPPT.length; i++) {
						System.out.println((i + 1) + ".- " + opcionesPPT[i]);
					}

					miChoice = sc.nextInt();
					sc.nextLine();
					esperar(3);

				} while (miChoice <= 0 || miChoice >= 4);

				// Obtenemos un numero aleatorio para asignar una eleccion al enemigo
				enemyChoice = (int) (Math.random() * 3) + 1;
				// System.out.println(enemyChoice);

				// EN FUNCION DE MI ELECCION SE DARÁN LAS SIGUIENTES POSIBILIDADES
				switch (miChoice) {
				// Si elijo 1.- piedra...
				case 1:
					System.out.println("Has elegido " + opcionesPPT[0] + "\n");
					esperar(5);
					if (enemyChoice == 1) {
						System.out.println(currentNpc + " eligió " + opcionesPPT[0]);
						System.out.println("\nEmpate!");
					} else if (enemyChoice == 2) {
						System.out.println(currentNpc + " eligió " + opcionesPPT[1]);
						System.out.println("\nPierdes!");
						derrotas++;
					} else {
						System.out.println(currentNpc + " eligió " + opcionesPPT[2]);
						System.out.println("\nGanas!");
						victorias++;
					}
					break;
				// Si elijo 2.- papel...
				case 2:
					System.out.println("Has elegido " + opcionesPPT[1] + "\n");
					esperar(5);
					if (enemyChoice == 1) {
						System.out.println(currentNpc + " eligió " + opcionesPPT[0]);
						System.out.println("\nGanas!");
						victorias++;
					} else if (enemyChoice == 2) {
						System.out.println(currentNpc + " eligió " + opcionesPPT[1]);
						System.out.println("\nEmpate!");
					} else {
						System.out.println(currentNpc + " eligió " + opcionesPPT[2]);
						System.out.println("\nPierdes!");
						derrotas++;
					}
					break;
				// Si elijo 3.- Tijera...
				case 3:
					System.out.println("Has elegido " + opcionesPPT[2] + "\n");
					esperar(5);
					if (enemyChoice == 1) {
						System.out.println(currentNpc + " eligió " + opcionesPPT[0]);
						System.out.println("\nPierdes!");
						derrotas++;
					} else if (enemyChoice == 2) {
						System.out.println(currentNpc + " eligió " + opcionesPPT[1]);
						System.out.println("\nGanas!");
						victorias++;
					} else {
						System.out.println(currentNpc + " eligió " + opcionesPPT[2]);
						System.out.println("\nGanas!");
					}
					break;
				}
				esperar(3);
				System.out.println("\nTUS VICTORIAS SON: " + victorias);
				System.out.println("TUS DERROTAS SON: " + derrotas);
			}
			esperar(5);
			// Salgo de bucle while e imprimo si he ganado o perdido
			if (victorias == 2) {
				System.out.println("\nGanas el minijuego!");
				System.out.println(currentNpc + ": " + "Eres bastante máquina tú, campeón.");
				gamesWon++;
				System.out.println("\nHas ganado 20 monedas");
				coins += 20;
			} else {
				System.out.println("\nPierdes el minijuego!");
				System.out.println(currentNpc + ": " + "Lo has intentado chaval, prueba la próxima vez.");
			}
			esperar(3);
			System.out.println("|nMinijuego finalizado te despides de " + currentNpc);
		}

		public static void preguntas() {
			Scanner sc = new Scanner(System.in);

			String[] questionArray = { "¿Cuánto es 2 + 2?", "Oro parece... platano es ¿Qué es?",
					"¿Cuál es el nombre del incorporeo de Sora?",
					"Habla y no tiene boca, oye y no tiene oído, es chiquito y hace ruido, muchas veces se equivoca.",
					"Soy muy lenta y me gusta nadar, llevo siempre conmigo mi propio hogar ¿quién soy?" };
			int[] indexArray;

			// Hago que el tamño de mi Array sea el mismo que la cantidad de opciones que
			// hay en questionArray, donde se almacenaran las preguntas.
			indexArray = new int[questionArray.length];

			// Inicializo el array de los indices a -1 para que no haya problemas más
			// adelante
			for (int i = 0; i < indexArray.length; i++) {
				indexArray[i] = -1;
			}

			// ---------------------------------------------------------------------------------------------------------------------//

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
					numRand = (int) (Math.random() * (questionArray.length));
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

				// Debug para ver el resultado de la lista aleatoria
				// System.out.println(indexArray[i]);

			}

			// ---------------------------------------------------------------------------------------------------------------------//

			// FUNCIONALIDAD PREGUNTAS - RESPUESTAS ALEATORIAS
			System.out.println(
					"\n" + currentNpc + ": Hola, responde a las siguientes preguntas, si fallas 2 veces o más pierdes\n");
			int error = 0;
			for (int i = 0; i < questionArray.length; i++) {
				// Vamos recorriendo el Array de indices aleatorios para que las preguntas
				// salgan en orden aleatorio
				int index = indexArray[i];
				// Imprimimos las preguntas a partir del indice aleatorio
				System.out.println(questionArray[index]);
				String answer = "";

				switch (index) {
				// Pregunta 0
				case 0:
					answer = sc.nextLine().toLowerCase();
					if (answer.equals("4")) {
						System.out.println("Correcto!");
					} else {
						System.out.println("Error");
						error++;
					}
					break;
				// Pregunta 1
				case 1:
					answer = sc.nextLine().toLowerCase();
					if (answer.equals("platano")) {
						System.out.println("Correcto!");

					} else {
						System.out.println("Error");
						error++;
					}
					break;
				// Pregunta 2
				case 2:
					answer = sc.nextLine().toLowerCase();
					if (answer.equals("roxas")) {
						System.out.println("Correcto!");

					} else {
						System.out.println("Error");
						error++;
					}
					break;
				// Pregunta 3
				case 3:
					answer = sc.nextLine().toLowerCase();
					if (answer.equals("telefono")) {
						System.out.println("Correcto!");
					} else {
						System.out.println("Error");
						error++;
					}
					break;
				// Pregunta 4
				case 4:

					answer = sc.nextLine().toLowerCase();
					if (answer.equals("tortuga")) {
						System.out.println("Correcto!");
					} else {
						System.out.println("Error");
						error++;
					}
					break;
				}
			}

			// Si fallas dos preguntas pierdes
			if (error >= 2) {
				System.out.println(currentNpc + ": Has perdido, tontito");
			} else {
				System.out.println(currentNpc + ": Has ganado el juego, figurín.");
				gamesWon++;
				System.out.println("\nHas ganado 20 monedas");
				coins += 20;
			}
		}

		public static void paresONones() {

			Scanner sc = new Scanner(System.in);
			int eleccionParesONones;
			int numeroLanzado;
			int contadorPuntosParesONonesJugador = 0;
			int contadorPuntosParesONonesNPC = 0;

			System.out.println("\nBienvenido al pares o nones.");
			esperar(5);
			System.out.println("\n¿Qué papel deseas desempeñar en esta aventura?:");
			esperar(3);
			System.out.println("1.- Pares | 2.- Nones");
			eleccionParesONones = sc.nextInt();
			while (eleccionParesONones != 1 && eleccionParesONones != 2) {
				System.out.println("\nBienvenido al pares o nones.");
				esperar(5);
				System.out.println("\n¿Qué papel deseas desempeñar en esta aventura?:");
				esperar(3);
				System.out.println("1.- Pares | 2.- Nones|n");
				eleccionParesONones = sc.nextInt();
			}
			esperar(5);
			switch (eleccionParesONones) {
			case 1:
				System.out.println("Has elegido pares\n");
				esperar(2);
				System.out.println("Si la suma de los números lanzados es par, habrás ganado 1 punto.");
				System.out.println("El primero en llegar a 3 puntos habrá ganado, ¡SUERTE!");
				break;
			case 2:
				System.out.println("Has elegido nones\n");
				esperar(3);
				System.out.println("Si la suma de los números lanzados es impar, habrás ganado 1 punto.");
				System.out.println("El primero en llegar a 3 puntos habrá ganado, ¡SUERTE!");
				break;
			}
			esperar(3);
			while (contadorPuntosParesONonesJugador < 3 && contadorPuntosParesONonesNPC < 3) {
				int numeroAleatorio = (int) (Math.random() * 5) + 1;
				System.out.println("");
				System.out.println("Lanza un número entre el 1 y el 5:");
				numeroLanzado = sc.nextInt();
				while (numeroLanzado <= 0 || numeroLanzado >= 6) {
					System.out.println("");
					System.out.println("Lanza un número entre el 1 y el 5:");
					numeroLanzado = sc.nextInt();
				}

				int sumaDeNumerosSacados = numeroAleatorio + numeroLanzado;
				esperar(5);
				if (eleccionParesONones == 1) {
					if (sumaDeNumerosSacados % 2 == 0) {
						System.out.println(currentNpc + " ha sacado el número: " + numeroAleatorio);
						esperar(3);
						System.out.println("Has sacado el número " + numeroLanzado);
						esperar(3);
						System.out.println("\nLa suma de ambos números es: " + sumaDeNumerosSacados);
						esperar(5);
						System.out.println("\nHas ganado una ronda");
						contadorPuntosParesONonesJugador++;
						esperar(3);
						System.out.println("\nMARCADOR: ");
						System.out.println("Tú: " + contadorPuntosParesONonesJugador + " " + currentNpc + ": "
								+ contadorPuntosParesONonesNPC);
					} else if (sumaDeNumerosSacados % 2 != 0) {
						System.out.println(currentNpc + " ha sacado el número: " + numeroAleatorio);
						esperar(3);
						System.out.println("Has sacado el número " + numeroLanzado);
						esperar(3);
						System.out.println("\nLa suma de ambos números es: " + sumaDeNumerosSacados);
						esperar(5);
						System.out.println("\nHas perdido una ronda");
						contadorPuntosParesONonesNPC++;
						esperar(3);
						System.out.println("\nMARCADOR: ");
						System.out.println("Tú: " + contadorPuntosParesONonesJugador + " " + currentNpc + ": "
								+ contadorPuntosParesONonesNPC);
					}
				}
				if (eleccionParesONones == 2) {
					if (sumaDeNumerosSacados % 2 != 0) {
						System.out.println(currentNpc + " ha sacado el número: " + numeroAleatorio);
						esperar(3);
						System.out.println("Has sacado el número " + numeroLanzado);
						esperar(3);
						System.out.println("\nLa suma de ambos números es: " + sumaDeNumerosSacados);
						esperar(5);
						System.out.println("\nHas ganado una ronda");
						contadorPuntosParesONonesJugador++;
						esperar(3);
						System.out.println("MARCADOR: ");
						System.out.println("Tú: " + contadorPuntosParesONonesJugador + " " + currentNpc + ": "
								+ contadorPuntosParesONonesNPC);
					} else if (sumaDeNumerosSacados % 2 == 0) {
						System.out.println(currentNpc + " ha sacado el número: " + numeroAleatorio);
						esperar(3);
						System.out.println("Has sacado el número " + numeroLanzado);
						esperar(3);
						System.out.println("\nLa suma de ambos números es: " + sumaDeNumerosSacados);
						esperar(5);
						System.out.println("\nHas perdido una ronda");
						contadorPuntosParesONonesNPC++;
						esperar(3);
						System.out.println("MARCADOR: ");
						System.out.println("Tú: " + contadorPuntosParesONonesJugador + " " + currentNpc + ": "
								+ contadorPuntosParesONonesNPC);
					}
				}
			}
			if (contadorPuntosParesONonesJugador == 3) {
				System.out.println("\n" + currentNpc + ": Has ganado, maquinita");
				gamesWon++;
				System.out.println("\nHas ganado 20 monedas");
				coins += 20;
			} else if (contadorPuntosParesONonesNPC == 3) {
				System.out.println("\n" + currentNpc + ": Has perdido, eres más tonto que un zapato");
			}

		}

		public static String[] palabra() {

			String palabra[] = null;
			int palabraRandom = (int) (Math.random() * 10); // Escoge un número aleatorio de entre 10 para elegir la palabra

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
			return palabra; // Devuelve el array escogido en el switch
		}

		public static String[] respuesta(String palabra[]) { // El método coge los datos del array palabra

			String respuesta[] = new String[palabra.length]; // Se crea un array de respuesta al cual se le asigna el mismo
																// número de espacios que al array palabra.

			Arrays.fill(respuesta, "_"); // Se rellena el array respuesta entero con el mismo caracter.

			return respuesta;
		}

		public static void adivinaPalabra() {
			// Minijuego adivina la palabra
			// El minijuego trata de adivinar una palabra por medio de probar caracteres
			// para ver si se encuentran en dicha palabra, al usuario se le realiza una
			// pregunta, en la cual deberá insertar un solo caracter de tipo letra, sin
			// imnportar si es mayúscula o minúscula y no deberá contener símbolos.
			// Cada intento fallido restará 1 intento al contador, si se acierta una letra
			// no se restará al contador, al igual que si se pone un caracter que ya ha sido
			// insertado en una anterior respuesta y tampoco restará intento si se escribe
			// más de un caracter.
			// El juego se gana al completar la palabra entera.
			// El juego se pierde si los intentos llegan a 0.

			Scanner sc = new Scanner(System.in);

			String letra;
			int contador = 15;
			boolean letraTrue = false;
			boolean repetida = false;
			int cantidad = 1;
			int n = 1;
			String[] palabra = palabra(); // Array que contiene la palabra a predecir
			String[] respuesta = respuesta(palabra); // Array que recoge las letras que se van acertando
			// y las coloca en su posición correspondiente
			String[] letrasUsadas = new String[31]; // Array que recoge los caracteres que ya se han introducido en
													// anteriores mensajes

			System.out.println(
					"Vamos a jugar a adivinar la palabra, tienes que ir escogiendo letras y yo te diré si se encuentran o no dentro de la palabra");
			esperar(10);
			do {
				System.out.println("¿Qué letra quieres escoger?");
				letra = sc.nextLine(); // Pregunta del caracter al usuario

				cantidad = letra.length(); // Se comprueba la cantidad de caracteres existentes en la respuesta del usuario

				letraTrue = false; // Reinicio de variable
				repetida = false;

				if (cantidad == 1) { // solo si la cantidad de caracteres escritos en la respuesta es 1, se inicia el
										// if

					for (int i = 0; i < letrasUsadas.length; i++) { // El siguiente if comprueba si la letra escrita ya se
																	// ha usado, comprobando si ya existe una letra
																	// igual dentro del array de palabras usadas
						if (letra.equalsIgnoreCase(letrasUsadas[i])) { // poniendo el array primero, da error, pero
																		// poniendo el string primero funciona
							System.out.println("La letra " + letra + " ya se ha usado");
							repetida = true; // indica que la letra está repetida, ponindo el valor en true
						}
					}

					if (repetida == false) { // Si el caracter insertado no está repetido en una anterior respuesta
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
						if (letraTrue == true) { // Si ha coincidido una letra
							System.out.println("La letra " + letra + " se encuentra en la palabra");
						} else { // Si no ha coincidido ninguna letra
							System.out.println("La letra " + letra + " no se encuentra en la palabra");
							contador--; // Se suma un fallo, por lo que resta al contador los fallos que le quedan
						}
					}

				} else { // Si la respuesta tiene más de 1 caracter
					System.out.println("Se ha producido un error, por favor, introduzca solo 1 caracter");
				}

				System.out.println("Te quedan " + contador + " intentos fallidos");
				System.out.println("Palabra:");
				for (int i = 0; i < respuesta.length; i++) {
					System.out.print(respuesta[i]); // Imprime el array de la respuesta
				}

				System.out.println("\n");

			} while (!Arrays.equals(palabra, respuesta) && contador > 0); // Repite el bucle mientras los arrays de la
																			// palabra y la respuesta sean diferentes o
																			// mientras el contador no llegue a 0

			if (Arrays.equals(palabra, respuesta)) { // Si los arrays de la palabra y la respuesta son iguales gana
				System.out.println("Has ganado, has adivinado la palabra");
				gamesWon++;
				System.out.println("\nHas ganado 20 monedas\n");
				coins += 20;
			} else if (contador <= 0) { // Si el contador llega a 0 pierde
				System.out.println("Has perdido, no has adivinado la palabra");
				System.out.print("la palabra era: ");
				for (int i = 0; i < palabra.length; i++) {
					System.out.print(palabra[i]); // Imprime el array de la palabra, para que el jugador puedo saber cual
													// era la palabra que tenía que adivinar
				}
				System.out.println("\n");
			}
			esperar(5);
		}

		public static void caraCruz() {
			// Minijuego cara o cruz

			Scanner sc = new Scanner(System.in);

			int ladoMonedaOpt = 1; // Elección de lado de la moneda
			int jugadoMoneda = 1; // Frases de juego
			int ladoMoneda = 1; // Escoge el lado de la moneda que gana
			int ganadoMoneda = 0; // Contabiliza las veces que el personaje gana
			int perdidoMoneda = 0; // Contabiliza las veces que el personaje pierde
			boolean salir = false; // Variable para terminar el juego
			int cantoMoneda = 0; // Opción de que salga canto en el lanzamiento de la moneda

			System.out.println("\nVamos a jugar a cara o cruz\n");

			do {
				do {
					if (ladoMonedaOpt < 1 || ladoMonedaOpt > 2) { // Si la respuesta no es 1 o 2 la repite
						System.out.println("Esa respuesta no es válida, prueba otra vez");
						esperar(5);
					}
					System.out.println("Escoge cara o cruz");
					esperar(3);
					System.out.println("1.- Cara");
					System.out.println("2.- Cruz");
					ladoMonedaOpt = scannerNum(); // Scanner para escoger el lado de la moneda
					jugadoMoneda = (int) (Math.random() * 5 + 1); // Random para escoger la frases
					esperar(5);
					switch (ladoMonedaOpt) {
					case 1:
						switch (jugadoMoneda) { // Lado cruz enemigo
						case 1:
							System.out.println("Entonces yo seré cruz");
							break;
						case 2:
							System.out.println("Vale, pues yo cruz");
							break;
						case 3:
							System.out.println("Yo jugaré con el otro lado");
							break;
						case 4:
							System.out.println("Pues yo me pido cruz");
							break;
						case 5:
							System.out.println("Me toca cruz");
							break;
						}
						break;
					case 2:
						switch (jugadoMoneda) { // Lado cara Enemigo
						case 1:
							System.out.println("Entonces yo seré cara");
							break;
						case 2:
							System.out.println("Vale, pues yo cara");
							break;
						case 3:
							System.out.println("Yo jugaré con el otro lado");
							break;
						case 4:
							System.out.println("Pues yo me pido cara");
							break;
						case 5:
							System.out.println("Me toca cara");
							break;
						}
						break;
					}
				} while (ladoMonedaOpt < 1 || ladoMonedaOpt > 2); // Si la respuesta no es 1 o 2 la repite
				esperar(5);
				System.out.print("Voy a tirar la moneda");
				esperar(5);
				System.out.print(".");
				esperar(5);
				System.out.print(".");
				esperar(5);
				System.out.println(".");
				ladoMoneda = (int) (Math.random() * 2 + 1); // Random para escoger el lado ganador de la moneda
				cantoMoneda = (int) (Math.random() * 20 + 1); // Random para opción de que salga canto en el lanzamiento
				esperar(5);
				if (cantoMoneda < 1 || cantoMoneda > 1) { // Si no ha salido canto
					switch (ladoMoneda) {
					case 1: // Cara
						System.out.println("Ha salido cara");
						esperar(5);
						switch (ladoMonedaOpt) {
						case 1: // Si has escogido cara y sale cara ganas
							System.out.println("Has ganado");
							ganadoMoneda++; // Suma 1 a las veces que has ganado
							break;
						case 2: // Si has escogido cruz y sale cara pierdes
							System.out.println("has perdido");
							perdidoMoneda++; // Suma 1 a las veces que has perdido
							break;
						}
						break;
					case 2:
						System.out.println("Ha salido cruz");
						esperar(5);
						switch (ladoMonedaOpt) {
						case 1: // Si has escogido cara y sale cruz pierdes
							System.out.println("Has perdido");
							perdidoMoneda++;
							break;
						case 2: // Si has escogido cruz y sale cruz ganas
							System.out.println("Has ganado");
							ganadoMoneda++;
							break;
						}
						break;
					}
				} else if (cantoMoneda == 1) { // Si ha salido canto
					System.out.print("Pero...");
					esperar(10);
					System.out.print(" Ha salido canto");
					esperar(10);
					System.out.println(", habrá que repetirlo");
				}
				esperar(5);
				System.out.println("ganado: " + ganadoMoneda); // Imprime las veces que has ganado y perdido
				System.out.println("perdido: " + perdidoMoneda);
				if (ganadoMoneda == 3) {
					salir = true; // Si has ganado 3 veces sale del minijuego
				} else if (perdidoMoneda == 3) {
					salir = true; // Si has perdido 3 veces sale del minijuego
				}
			} while (salir == false); // Repite el minijuego mientras la opción de salir se falsa

			esperar(5);
			if (ganadoMoneda == 3) {
				System.out.println("Me has ganado 3 veces, parece que me has vencido");
				gamesWon++;
				System.out.println("\nHas ganado 20 monedas");
				coins += 20;
			} else if (perdidoMoneda == 3) {
				System.out.println("Te he ganado 3 veces, has perdido");
			}

		}

		// METODO DONDE SE ALMACENAN TODOS LOS MINIJUEGOS, EN FUNCION DEL INDICE QUE LE
		// PASEMOS SE EJECUTARA UN METODO DISTINTO
		public static void miniGames(int index) {
			// Este switch especificamente empieza en 0 porque estamos leyendo la lista
			// random, que empieza en 0
			switch (index) {

			case 0:
				piedraPapelTijera();
				break;

			case 1:
				preguntas();
				break;

			case 2:
				paresONones();
				break;

			case 3:
				adivinaPalabra();
				break;

			case 4:
				caraCruz();
				break;

			default:
				System.out.println("Error");
			}

		}
		// ----------------------------------------------------------------------------------------------------------------------------//

		// FUNCIONES COMABTE

		public static void combate() {

			Random random = new Random();
			boolean turn = true; // BOOLEANO PARA ESCOGER PRIMER TURNO
			int combatResponse; // VARIABLE LOCAL DE RESPUESTA DEL COMBATE

			System.out.println("");
			System.out.println("Te encuentras a " + enemyName);
			System.out.println("-------------" + enemyHp + "/" + enemyHpMax);

			turn = random.nextBoolean(); // EL PRIMER TURNO SE GENERA CON UN RANDOM

			if (turn) { // SI EL TURN ES TRUE EMPIEZA EL HEROE ATACANDO
				System.out.println("Empiezas atacando");
			} else if (!turn) { // SI EL TURN ES FALSE EMPIEZA EL ENEMIGO ATACANDO
				System.out.println("Empieza " + enemyName + " atacando");
			}
			esperar(5);

			do {
				if (turn == true) { // Empieza personaje atacando
					attack = false; // DA UN VALOR FALSO POR DEFECTO
					do { // SE MUESTRA EL MENÚ DE COMBATE
						System.out.println("¿Qué vas a hacer?:");
						esperar(3);
						System.out.println("1.- Atacar");
						System.out.println("2.- Mochila");
						System.out.println("3.- Huir");
						combatResponse = scannerNum(); // RECOGE LA RESPUESTA DEL MENÚ DE COMBATE
						esperar(5);
						switch (combatResponse) {
						case 1: // Atacar

							attackHero(); // SI DECIDE ATACAR SE MUESTRA OTRO MENÚ CON LAS OPCIONES EN LA FUNCIÓN
											// ATTACKHERO
							break;
						case 2: // Mochila

							backpack(); // SI DECIDE IR A LA MOCHILA, SE MUESTRA OTRO MENÚ CON LAS OPCIONES EN LA
										// FUNCIÓN BACKPACK
							break;
						case 3: // Huir

							escape(); // SI DECIDE HUIR, LE MOSTRARÁ UNA RESPUESTA ALMACENADA EN LA FUNCIÓN ESCAPE (NO
										// SE PUEDE HUIR)
							break;
						}
					} while (!attack == true || combatResponse > 3); // REPITE ESTE MENÚ MIENTRAS ATTACK SEA FALSO O LA
																		// RESPUESTA SEA MAYOR A 3
					if (enemyHp < 0) {
						enemyHp = 0; // SE ASEGURA DE QUE NO IMPRIMA LA VIDA DEL ENEMIGO EN NEGATIVO
					}
					esperar(5);
					System.out.println(enemyName + " tiene " + enemyHp + " puntos de vida"); // IMPRIME LA VIDA DEL ENEMIGO
					turn = false; // EL TURNO PASA A FALSE PARA PODER ENTRAR EN EL ATAQUE ENEMIGO
				} else { // Ataque Enemigo
					attack = false; // DA UN VALOR FALSO POR DEFECTO
					esperar(5);
					do {

						attackEnemy(); // FUNCIÓN DEL ATAQUE ENEMIGO

					} while (!attack == true); // MIENTRAS EL ATAQUE SEA FALSE REPITE EL ATTACKENEMY
					if (heroHp < 0) {
						heroHp = 0; // SE ASEGURA DE QUE NO IMPRIMA LA VIDA DEL HEROE EN NEGATIVO
					}
					esperar(5);
					System.out.println(heroName + " tiene " + heroHp + " puntos de vida"); // IMPRIME LA VIDA DEL HEROE
					turn = true; // EL TURNO PASA A TRUE PARA PODER ENTRAR EN EL ATAQUE DEL HEROE
				}
			} while (enemyHp > 0 && heroHp > 0); // REPITE ESTOS DOS MENÚS DE ATAQUE MIENTRAS LA VIDA DE LOS DOS SEA MAYOR
													// QUE 0, MOMENTO EN EL CUAL UNO DE LOS DOS HABRÁ MUERTO, CON LO QUE
													// FINALIZA EL COMBATE
			esperar(5);
			if (enemyHp == 0) { // SI LA VIDA DEL ENEMIGO ES 0, EL HEROE DERROTA AL ENEMIGO Y RECIBE 30 MONEDAS
				System.out.println("Has derrotado a " + enemyName);
				System.out.println("\nHas ganado 30 monedas");
				coins += 30;
			} else if (heroHp == 0) { // SI LA VIDA DEL HEROE ES 0, ESTE MUERE Y SE ACABA EL JUEGO
				System.out.println("Te ha derrotado " + enemyName);
				gameOver = true;
			}

		}

		public static int scannerNum() { // FUNCION QUE SE USA PARA RECOGER LA RESPUESTA DE INT SIN QUE ROMPA EL
											// PROGRAMA AL INSERTAR UNA LETRA EN VEZ DE UN NÚMERO
			Scanner sc = new Scanner(System.in);
			int response = 0;
			boolean exception = false;

			while (!exception) {
				try {
					response = sc.nextInt();
					exception = true; // Si la entrada es válida, salimos del bucle
				} catch (Exception e) {
					System.out.println("Entrada no válida. Por favor, ingresa un número.");
					sc.next(); // Evita un bucle infinito
				}
			}

			return response;
		}

		public static void attackHero() { // FUNCIÓN DE ATAQUE DEL HEROE

			int combatResponse;

			do { // IMPRIME EL MENÚ DE ATAQUE
				System.out.println("Menú de ataque:");
				esperar(3);
				System.out.println("1.- " + heroAttacks[0]);
				System.out.println("2.- " + heroAttacks[1]);
				System.out.println("3.- Cubrirse");
				System.out.println("4.- Esquiva");
				System.out.println("5.- Mejora de ataque");
				System.out.println("6.- Volver");
				combatResponse = scannerNum();
				switch (combatResponse) {
				// Si pulsamos 1 al no haber un break irá al siguiente caso, pero si se
				// almacenara la variable
				// combatResponse
				case 1: // Ataque ligero y ataque pesado
				case 2:
					esperar(5);
					attackVariables1(combatResponse); // LLAMA A LA FUNCION DONDE SE HACEN LOS ATAQUES
					break;
				case 3: // Cubrirse
					esperar(5);
					System.out.println(heroName + " se cubre del siguiente ataque del enemigo");
					heroDefenseAttack = 1; // ACTUALIZA LA VARIABLE DE DEFENSA A 1
					break;
				case 4: // Esquivar
					esperar(5);
					System.out.println(heroName + " esquiva el siguiente ataque del enemigo");
					heroDefenseAttack = 2; // ACTUALIZA LA VARIABLE DE DEFENSA A 2
					break;
				case 5: // Cargar mejora de ataque
					esperar(5);
					if (heroAttackUpgrade == true) { // SI LA MEJORA DE ATAQUE DEL HEROE ESTA ACTIVADA NO DEJA APLICAR DOS
														// MEJORAS DE ATAQUE
						System.out.println("No puedes aplicar dos mejoras de ataque en la misma ronda");
						// Lo ponemos a 7 para que se repita el bucle
						combatResponse = 7;
					} else { // CARGA UNA MEJORA DE ATAQUE EN EL HEROE, ACTUALIZANDO LA VARIABLE A TRUE
						System.out.println(heroName + " carga una mejora en su próximo ataque");
						heroAttackUpgrade = true;
					}
					break;
				}
			} while (combatResponse > 6); // SE REPITE MIENTRAS LA RESPUESTA SEA MAYOR A 6
			if (combatResponse > 0 && combatResponse < 6) { // SI LA RESPUESTA HA SIDO VALIDA
				enemyHp = enemyHp - damageCaused; // ACTUALIZA LA VIDA DEL ENEMIGO CON EL DAÑO CAUSADO
				damageCaused = 0; // DEVUELVE LA VARIABLE DAMAGE CAUSED A 0 PARA VOLVER A USARLA
				attack = true; // EL ATTACK LO PASA A TRUE PARA QUE SALGA DEL PRIMER BUCLE WHILE DE COMBAT
				usedPotion = false; // DEVUELVE EL USO DE POCIÓN A 0 PARA VOLVER A USARLO
			}

		}

		public static void attackVariables1(int respuestaCombate) {

			String nameAttack = "";
			int i = 0;
			int randomStrongAttack = 0;

			switch (respuestaCombate) { // DEPENDIENDO DELA RESPUESTA DE COMBATE SE LE DA NOMBRE AL ATAQUE, ES ALGO
										// IRRELEVANTE EL CAMBIO DE NOMBRE
			case 1: // Ataque debil
				nameAttack = heroAttacks[0];
				i = 0;
				break;
			case 2: // Ataque fuerte
				nameAttack = heroAttacks[1];
				i = 1;
				break;
			}
			esperar(5);
			System.out.print(heroName + " ataca a " + enemyName + " con " + nameAttack);
			damageCaused = heroDamage[i]; // ACTUALIZA EL DAÑO DEL ATAQUE AL DAÑO DEL ATAQUE ELEGIDO CON EL i
			if (heroAttackUpgrade == true) { // SI EL HEROE TIENE UNA MEJORA DE DAÑO
				damageCaused = damageCaused * 2; // EL DAÑO CAUSADO SE ACTUALIZA AL DOBLE
				heroAttackUpgrade = false; // ACTUALIZA LA VARIABLE A FALSE PARA VOLVER A USARLA EN EL PRÓXIMO TURNO
			}

			if (i == 0) { // SI ES EL ATAQUE LIGERO

				attackVariables2(); // ENTRA DIRECTAMENTE EN LA FUNCIÓN

			} else if (i == 1) { // El ataque fuerte tiene probabilidades de fallo . . .

				randomStrongAttack = (int) (Math.random() * 10 + 1); // HACE UN RANDOM PARA DECIDIR SI ACIERTA EL ATAQUE
				if (randomStrongAttack < 8) { // SI LA OPCIÓN ES MENOR QUE 8, ACIERTA EL ATAQUE

					attackVariables2(); // Y ENTRA EN LA FUNCIÓN

				} else {
					damageCaused = 0; // SI LA OPCIÓN ES 8 O MAYOR, FALLA EL ATAQUE Y EL DAÑO PASA A SER 0
					System.out.println(", pero falla el ataque");
				}
			}
			enemyDefenseAttack = 0; // TRAS REALIZAR LOS ATAQUES SE ACTUALIZA LA DEFENSA DEL ENEMIGO A 0

		}

		public static void attackVariables2() {

			int randomDodge = 0;
			// Si el enemigo se cubre
			if (enemyDefenseAttack == 1) { // 1 SIGNIFICA QUE EL ENEMIGO SE CUBRE
				damageCaused = damageCaused / 2; // EL DAÑO SE REDUCE A LA MITAD
				System.out.println(", pero " + enemyName + " se cubre, recibiendo " + damageCaused + " de daño");
			} else if (enemyDefenseAttack == 2) { // 2 SIGNIFICA QUE EL ENEMIGO ESQUIVA

				randomDodge = (int) (Math.random() * 10 + 1); // RANDOM DE ESQUIVA

				// Probabilidad de esquivar en función del número random obtenido
				if (randomDodge < 7) { // SI ES MENOR QUE 7 ESQUIVA EL ATAQUE
					damageCaused = 0;
					System.out.println(", pero " + enemyName + " lo esquiva");
				} else {
					// Reinicializamos la variable para el siguiente turno 1 = Defensa 2 = Esquiva
					enemyDefenseAttack = 0;
					System.out.print(", lo intenta esquivar, pero no lo consigue");
				}
			}
			if (enemyDefenseAttack == 0) { // SI NO TIENE NINGÚN TIPO DE DEFENSA LE CAUSA EL DAÑO
				System.out.println(" y le causa " + damageCaused + " de daño.");
			}

		}

		public static void backpack() {

			int combatResponse;
			int cure;

			do { // IMPRIME UN MENÚ DE MOCHILA
				System.out.println("Menú de mochila");
				esperar(3);
				System.out.println("1.- " + backpackObjets[0] + " - " + backpackNum[0] + " uds");
				System.out.println("2.- " + backpackObjets[1] + " - " + backpackNum[1] + " uds");
				System.out.println("3.- " + "Volver");
				combatResponse = scannerNum();
				esperar(5);
				for (int i = 0; i < backpackNum.length; i++) { // HACE UN FOR CON LA LA CANTIDAD DE OBJETOS QUE TIENE EN LA
																// MOCHILA
					if (combatResponse == (i + 1) && backpackNum[i] == 0) { // SI PARA EL OBJETO i LA CANTIDAD ES 0, TE
																			// MUESTRA QUE NO TE QUEDA NINGUNA POCIÓN MÁS
						System.out.println("No te queda ninguna " + backpackObjets[i]);
						combatResponse = 100; // ACTUALIZA LA RESPUESTA FUERA DE VALORES PARA QUE SE REPITA EL MENÚ
					} else if (combatResponse == (i + 1) && backpackNum[i] > 0 && usedPotion == false) { // SI PARA EL
						// OBJETO i LA CANTIDAD ES 1 O MÁS Y LA CONDICIÓN DE HABER USADO
						// UNA POCIÓN ES FALSE, TE USA LA POCIÓN ESCOGIDA
						System.out.println("has usado " + backpackObjets[i]);
						usedPotion = true; // ACTUALIZA LA VARIABLE DE POCIONES USADAS A TRUE
						switch (combatResponse) {
						case 1:
							cure = 25; // LA CURA POR DEFECTO DE UNA POCIÓN ES 25
							if (heroHp < heroHpMax) { // SI LA VIDA ACTUAL DEL HEROE ES MENOR QUE LA VIDA MÁXIMA

								if (heroHp + 25 > heroHpMax) { // SI LA VIDA ACTUAL MÁS LOS 25 DE LA CURA VA A SER MAYOR QUE
																// LA VIDA MÁXIMA
									cure = (heroHpMax - heroHp) - 25; // ACUTALIZA LA VARIABLE DE CURA A LA DIFERENCIA ENTRE
																		// LA VIDA MÁXIMA Y LA ACTUAL
									heroHp = heroHpMax; // ACTUALIZA LA VIDA A LA MISMA QUE LA MÁXIMA
								} else { // SI NO SE CUMPLE NINGUNA DE LAS ANTERIORES, SIGNIFICA QUE AL HEROE LE CABEN 25
											// O MÁS PUNTOS DE VIDA
									heroHp = heroHp + cure; // CURA 25 PUNTOS AL HEROE
								}
								System.out.println(heroName + " se ha curado " + cure + " de vida");
								backpackNum[0]--; // RESTA UNA POCIÓN EN LA MOCHILA
								usedPotion = true; // ACTUALIZA LA VARIABLE DE POCIÓN USADA A TRUE
							} else { // SI LA VIDA ES IGUAL A LA VIDA MÁXIMA, NO TE PUEDES CURAR
								System.out.println("No puedes curarte, tu salud ya está al máximo");
							}
							break;
						case 2: // SI ESCOGE LA OPCIÓN 2, USA UNA POCIÓN DE MEJORA DE ATAQUE
							System.out.println(heroName + " ha mejorado su ataque");
							backpackNum[1]--; // GASTA UN POCIÓN
							heroAttackUpgrade = true; // ACTUALIZA LA MEJORA DE ATAQUE
							usedPotion = true; // ACTUALIZA LA VARIABLE DE POCIÓN USADA
							break;
						}
					}
				}
				if (usedPotion == true) { // SI YA HA USADO UNA POCIÓN EN ESTE TURNO, NO DEJA USAR MÁS
					System.out.println("Recuerda, no puedes usar más de una poción por turno");
				}
			} while (combatResponse > 3); // REPITE EL BUCLE MIENTRAS LA OPCIÓN NO SEA VÁLIDA

		}

		public static void escape() { // FUNCIÓN QUE IMPRIME UN MENSAJE CUANDO EL USUARIO INTENTA ESCAPAR DE UN
										// COMBATE

			int escape = 0;

			escape++;
			esperar(5);
			if (escape == 1) {
				System.out.println("No puedes huir de este combate");
			} else {
				System.out.println("¿No sabes leer? Te he dicho que no puedes huir de este combate");
			}
		}

		public static void attackEnemy() {

			int combatOption1;
			int combatOption2;

			combatOption1 = (int) (Math.random() * 6 + 1);
			esperar(5);
			if (combatOption1 < 6) { // Menu de ataque
				do {
					combatOption2 = (int) (Math.random() * 10 + 1);
					if (combatOption2 >= 1 && combatOption2 <= 6) {

						attackVariablesEnemy1(combatOption2);
						// Lo que hay por aquí debajo nunca va a entrar
					} else if (combatOption2 == 7) { // Cubrirse
						System.out.println(enemyName + " se cubre del siguiente ataque del enemigo");
						enemyDefenseAttack = 1;
					} else if (combatOption2 == 8) { // Esquivar
						System.out.println(enemyName + " esquiva el siguiente ataque del enemigo");
						enemyDefenseAttack = 2;
					} else if (combatOption2 == 9) { // Mejora ataque
						if (enemyAttackUpgrade == true) {
							combatOption2 = 10;
						} else if (enemyAttackUpgrade == false) {
							System.out.println(enemyName + " carga una mejora en su próximo ataque");
							enemyAttackUpgrade = true;
						}
					}
				} while (combatOption2 > 9);
				if (combatOption2 < 10) {
					heroHp = heroHp - damageCaused;
					damageCaused = 0;
					attack = true;
					usedPotion = false;
				}
			} else { // Menu de mochila

				enemyBackpack();

			}

		}

		public static void attackVariablesEnemy1(int opcionCombateEnemigo) {

			int randomStrongAttack;

			String nameAttack = "";
			int i = 0;
			// 50% Probabilidades de que haga un ataque u otro
			if (opcionCombateEnemigo >= 1 && opcionCombateEnemigo <= 3) {
				nameAttack = enemyAttacks[0];
				i = 0;
			} else if (opcionCombateEnemigo >= 4 && opcionCombateEnemigo <= 6) {
				nameAttack = enemyAttacks[1];
				i = 1;
			}
			esperar(5);
			System.out.print(enemyName + " ataca a " + heroName + " con " + nameAttack);
			damageCaused = enemyDamage[i];
			if (enemyAttackUpgrade == true) {
				damageCaused = damageCaused * 2;
				enemyAttackUpgrade = false;
			}

			if (i == 0) {

				attackVariablesEnemy2();

			} else if (i == 1) {

				randomStrongAttack = (int) (Math.random() * 10 + 1);
				if (randomStrongAttack < 8) {

					attackVariablesEnemy2();

				} else {
					damageCaused = 0;
					System.out.println(", pero falla el ataque");
				}
			}
			heroDefenseAttack = 0;

		}

		public static void attackVariablesEnemy2() {

			int randomDodge;

			if (heroDefenseAttack == 1) {
				damageCaused = damageCaused / 2;
				System.out.println(", pero " + heroName + " se cubre, recibiendo " + damageCaused + " de daño");
			} else if (heroDefenseAttack == 2) {
				if (abalorioBoolean) { // SI CUENTA CON EL ABALORIO DE MEJORA DE ESQUIVA
					randomDodge = (int) (Math.random() * 8 + 1); // LAS PROBABILIDADES DE ESQUIVAR SERÁN MAYORES
				} else {
					randomDodge = (int) (Math.random() * 10 + 1);
				} // SI NO CUENTA CON EL ABALORIO, LAS PROBABILIDADES SERÁN ESTANDAR

				if (randomDodge < 7) { // SI ES MENOR A 7, ESQUIVA, EL DAÑO CAUSADO ES 0
					damageCaused = 0;
					System.out.println(", pero " + heroName + " lo esquiva");
				} else { // SI ES MAYOR A 7 NO LO ESQUIVA
					enemyDefenseAttack = 0;
					System.out.print(", lo intenta esquivar, pero no lo consigue");
				}
			}
			if (heroDefenseAttack == 0) { // SI NO TIENE NINGÚN TIPO DE DEFENSA LE CAUSA EL DAÑO
				System.out.println(" y le causa " + damageCaused + " de daño.");
			}

		}

		public static void enemyBackpack() {

			int combatOption;
			int cure;

			if (usedPotion == false) {
				combatOption = (int) (Math.random() * 2 + 1);
				switch (combatOption) {
				case 1:
					cure = 25;
					if (enemyHp < enemyHpMax) {
						if (enemyHp + 25 > enemyHpMax) {
							cure = (enemyHpMax - enemyHp) - 25;
							enemyHp = enemyHpMax;
						} else {
							enemyHp = enemyHp + cure;
						}
						System.out.println(enemyName + " se ha curado " + cure + " de vida");
						usedPotion = true;
					}
					break;
				case 2:
					System.out.println(enemyName + " ha mejorado su ataque");
					enemyAttackUpgrade = true;
					break;
				}
			} else if (usedPotion == true) {

			}

		}

		public static void tutorial() {

			int combatResponse;

			currentNpc = npcs[5];
			enemySet(6);

			esperar(15);
			System.out.println("\n" + currentNpc + ": Bienvenid" + gen + " " + heroName
					+ ", me han comunicado que te encuentras en el universo " + universe + " y quieres salir de él.");
			esperar(15);
			System.out.print("\n" + currentNpc + ": Te voy a enseñar a controlar tus nuevas habilidades");
			esperar(10);
			System.out.print(".");
			esperar(5);
			System.out.print(".");
			esperar(5);
			System.out.println(".");
			esperar(5);
			System.out.println("\n*PUFF*\n");
			esperar(10);
			System.out.println("                                               \r\n"
					+ "          ..                                   \r\n"
					+ "          .==.        .        ..-.            \r\n"
					+ "           .*+.      ..       ...              \r\n"
					+ "            .#-.     ...    .::     :-.        \r\n"
					+ "            ..+-     .:-:...-:.   .:.          \r\n"
					+ "              .=-.   .=-.:=*:   .:=.           \r\n"
					+ "         .:..  .+#+-..=-=#*. ..:*=.            \r\n"
					+ "          ..=:-@@@@@@@@@@%*.:===.              \r\n"
					+ "            ..:%@@@@@@@@@@@@#+=.    ..::.      \r\n"
					+ "  ..        .:@@@@@@@@@@@@@@@#:...:--:.        \r\n"
					+ "  ..::::...--.+%@@@@@@@@@@@@@@%+=-..       .   \r\n"
					+ "          ..:-#@@@@@@@@@@%@@@@@%#+==--:::----:.\r\n"
					+ "         .-=.:+@%@@@@@%%%%@@@%%%*==---::.......\r\n"
					+ "       .......:%@++@@@@@%@@@@%%%=.             \r\n"
					+ "          ..-#==+*+#@@@@##%%%#+=*=:::.        .\r\n"
					+ "        ..-+:. ....-*%%*-=%#**#-..-=:        ..\r\n"
					+ "       .::..   .-=-..:*:.....-*#*:.   ..:::::--\r\n"
					+ "   ..:..      ..:..  :+:..    ..-*+....    .:--\r\n"
					+ " .:-..         .     .=          .:=-..        \r\n"
					+ " ..                  :-             ...        \r\n"
					+ "                     :-                        \r\n"
					+ "                     ::       .                ");
			esperar(10);
			System.out.println("\n*Aparece un sincorazon*\n");
			esperar(10);
			System.out.println("                            *:               \r\n"
					+ "                           @+                \r\n"
					+ ".:                        *-                 \r\n"
					+ " :+.                     .@                  \r\n"
					+ "   .%**=                 .*                  \r\n"
					+ "        *.               %+                  \r\n"
					+ "         =%              @=                  \r\n"
					+ "          .@@           -@:                  \r\n"
					+ "           .@@.         #@.                  \r\n"
					+ "             @@- #@@@@@@@@                   \r\n"
					+ "             :@@@@@@@@@@@@@=                 \r\n"
					+ "             .@@@@@@@@@@@@@@*                \r\n"
					+ "             -#@@@@%:.-%@@@@%                \r\n"
					+ "             .-@@@@#-:-%@@@@@                \r\n"
					+ "             :%@@@@@@@@@@@@@*                \r\n"
					+ "              #@@@@@@@@@@@@@.                \r\n"
					+ "          =**#%@@@@@@@@@@@@@@@@:             \r\n"
					+ "      :#@@@%%@@@@@@@@@@@@@@@@@@@@@+          \r\n"
					+ "   *@@@@@@+         @@@@@@@= :+@@@@@@-       \r\n"
					+ "  -. %= #-          @@@@@@@@-      @@@%      \r\n"
					+ "     #=            %@@@@@@@@%      @@@@@:    \r\n"
					+ "      -      ..-==*@@@@@@@@@@:    -@@@@@@#   \r\n"
					+ "           *@@@@@@@@@@@@@@@@@=   :@*    +@@= \r\n"
					+ "            @@@@@@@@@@@@@@@@@*   :=       .# \r\n"
					+ "             #@@++%**@@@@@@@@@               \r\n"
					+ "               %@@@@    #@@@@@               \r\n"
					+ "               .@@@@     @@@@@-              \r\n"
					+ "               @@@@:     .@@@@.              \r\n"
					+ "            -@@@@@#       +@@@               \r\n"
					+ "           @@@@@@@.       -@@*               \r\n"
					+ "          @@@@@@%        @@@.                \r\n"
					+ "        :@@@+.           @@@@.               \r\n"
					+ "        -                #@@@@-              \r\n"
					+ "                         +@@@@@=             \r\n"
					+ "                         +@@@@@@-            \r\n"
					+ "                          +@@@@@:            \r\n"
					+ "                           -@@@@             \r\n"
					+ "                            -@@*             \r\n"
					+ "                             .@=             ");

			esperar(15);
			System.out.println("\n" + currentNpc
					+ ": Este es un 'Sincorazon', es un enemigo simple, pero nos ayudará para enseñarte los conceptos de combate.");
			esperar(20);
			System.out.println(currentNpc + ": La primera habilidad que quiero que uses es '" + heroAttacks[0]
					+ "', es un ataque normal, pero que resulta muy efectivo.\n");
			esperar(20);
			do {
				System.out.println("Menú de ataque:");
				esperar(3);
				System.out.println("1.- " + heroAttacks[0]);
				System.out.println("2.- " + heroAttacks[1] + " - NO DISPONIBLE");
				System.out.println("3.- Cubrirse - NO DISPONIBLE");
				System.out.println("4.- Esquiva - NO DISPONIBLE");
				System.out.println("5.- Mejora de ataque - NO DISPONIBLE");
				System.out.println("6.- Volver - NO DISPONIBLE");
				combatResponse = scannerNum();
				esperar(5);
				if (combatResponse <= 0 || combatResponse >= 2) {
					System.out.println("\nPor favor, introduce el número 1\n");
					esperar(3);
				}
			} while (combatResponse <= 0 || combatResponse >= 2);

			System.out.print(heroName + " ataca a " + enemyName + " con " + heroAttacks[0] + " y le causa " + heroDamage[1]
					+ " de daño.");
			esperar(10);
			System.out.println("\n" + currentNpc + ": Bien hecho, ahora vamos a probar un ataque más potente, usa "
					+ heroAttacks[1] + ".\n");
			esperar(20);

			do {
				System.out.println("Menú de ataque:");
				esperar(3);
				System.out.println("1.- " + heroAttacks[0] + " - NO DISPONIBLE");
				System.out.println("2.- " + heroAttacks[1]);
				System.out.println("3.- Cubrirse - NO DISPONIBLE");
				System.out.println("4.- Esquiva - NO DISPONIBLE");
				System.out.println("5.- Mejora de ataque - NO DISPONIBLE");
				System.out.println("6.- Volver - NO DISPONIBLE");
				combatResponse = scannerNum();
				esperar(5);
				if (combatResponse <= 1 || combatResponse >= 3) {
					System.out.println("\nPor favor, introduce el número 2\n");
					esperar(3);
				}
			} while (combatResponse <= 1 || combatResponse >= 3);

			System.out.println(heroName + " ataca a " + enemyName + " con " + heroAttacks[1] + ", pero falla el ataque");
			esperar(20);
			System.out.println("\n" + currentNpc + ": el ataque " + heroAttacks[1]
					+ " es más potente, pero puedes fallarlo, como en esta ocasión.");
			esperar(20);
			System.out.println(currentNpc + ": Prueba a cubrirte del próximo ataque del enemigo.\n");
			esperar(20);

			do {
				System.out.println("Menú de ataque:");
				esperar(3);
				System.out.println("1.- " + heroAttacks[0] + " - NO DISPONIBLE");
				System.out.println("2.- " + heroAttacks[1] + " - NO DISPONIBLE");
				System.out.println("3.- Cubrirse");
				System.out.println("4.- Esquiva - NO DISPONIBLE");
				System.out.println("5.- Mejora de ataque - NO DISPONIBLE");
				System.out.println("6.- Volver - NO DISPONIBLE");
				combatResponse = scannerNum();
				esperar(5);
				if (combatResponse <= 2 || combatResponse >= 4) {
					System.out.println("\nPor favor, introduce el número 3\n");
					esperar(3);
				}
			} while (combatResponse <= 2 || combatResponse >= 4);

			System.out.println(enemyName + " ataca a " + heroName + " con Ataque oscuro, pero " + heroName
					+ " se cubre, recibiendo " + 3 + " de daño");
			esperar(20);
			System.out.println("\n" + currentNpc
					+ ": Como puedes ver te ha hecho muy poco daño, al cubrirte del ataque enemigo, reduces considerablemente el daño que recibes.");
			esperar(20);
			System.out.println(currentNpc + ": Ahora intenta esquivar el próximo ataque.\n");
			esperar(20);

			do {
				System.out.println("Menú de ataque:");
				esperar(3);
				System.out.println("1.- " + heroAttacks[0] + " - NO DISPONIBLE");
				System.out.println("2.- " + heroAttacks[1] + " - NO DISPONIBLE");
				System.out.println("3.- Cubrirse - NO DISPONIBLE");
				System.out.println("4.- Esquiva");
				System.out.println("5.- Mejora de ataque - NO DISPONIBLE");
				System.out.println("6.- Volver - NO DISPONIBLE");
				combatResponse = scannerNum();
				esperar(5);
				if (combatResponse <= 3 || combatResponse >= 5) {
					System.out.println("\nPor favor, introduce el número 4\n");
					esperar(3);
				}
			} while (combatResponse <= 3 || combatResponse >= 5);

			System.out.println(enemyName + " ataca a " + heroName + " con Ataque oscuro, pero " + heroName + " lo esquiva");
			esperar(20);
			System.out.println("\n" + currentNpc
					+ ": Con la esquiva el ataque enemigo no te ha dado, pero no siempre vas a ser tan rápido como para esquivar el ataque de tu oponente.");
			esperar(20);
			System.out.println(currentNpc
					+ ": Prueba a cargar una mejora de ataque, esta te proporcionará una mejora en el daño de tu próximo ataque.\n");
			esperar(20);

			do {
				System.out.println("Menú de ataque:");
				esperar(3);
				System.out.println("1.- " + heroAttacks[0] + " - NO DISPONIBLE");
				System.out.println("2.- " + heroAttacks[1] + " - NO DISPONIBLE");
				System.out.println("3.- Cubrirse - NO DISPONIBLE");
				System.out.println("4.- Esquiva - NO DISPONIBLE");
				System.out.println("5.- Mejora de ataque");
				System.out.println("6.- Volver - NO DISPONIBLE");
				combatResponse = scannerNum();
				esperar(5);
				if (combatResponse <= 4 || combatResponse >= 6) {
					System.out.println("\nPor favor, introduce el número 5\n");
					esperar(3);
				}
			} while (combatResponse <= 4 || combatResponse >= 6);

			System.out.println(
					currentNpc + ": Acabas de mejorar tu ataque, ahora ataca al enemigo con tu ataque más potente.\n");
			esperar(20);

			do {
				System.out.println("Menú de ataque:");
				esperar(3);
				System.out.println("1.- " + heroAttacks[0] + " - NO DISPONIBLE");
				System.out.println("2.- " + heroAttacks[1]);
				System.out.println("3.- Cubrirse - NO DISPONIBLE");
				System.out.println("4.- Esquiva - NO DISPONIBLE");
				System.out.println("5.- Mejora de ataque - NO DISPONIBLE");
				System.out.println("6.- Volver - NO DISPONIBLE");
				combatResponse = scannerNum();
				esperar(5);
				if (combatResponse <= 1 || combatResponse >= 3) {
					System.out.println("\nPor favor, introduce el número 2\n");
					esperar(3);
				}
			} while (combatResponse <= 1 || combatResponse >= 3);

			System.out.println(heroName + " ataca a " + enemyName + " con " + heroAttacks[1] + " y le causa "
					+ (heroDamage[1] * 2) + " de daño.");
			esperar(50);
			System.out.println(currentNpc
					+ ": ¡Esta vez si que le has dado, y encima le has hecho mucho daño con la mejora de tu ataque!");
			esperar(20);
			System.out.println(
					currentNpc + ": Espero que hayas aprendido a combatir, ahora lo podrás aplicar ahí fuera, adios.");
			esperar(60);
			System.out.println(".");
			esperar(5);
			System.out.println(".");
			esperar(5);
			System.out.println(".");
			esperar(5);
			System.out.print(currentNpc + ": Perdona, se me olvidaba darte esto");
			esperar(10);
			System.out.println(", toma, 2 pociones de vida y una de ataque.");
			esperar(20);
			System.out.println("+ 2 pociones de vida");
			System.out.println("+ 1 poción de ataque");
			esperar(20);
			System.out.println("\n" + currentNpc
					+ ": Esto te ayudará en los combates, puedes usarlas desde la mochila, también puedes visitar a mi amigo "
					+ vendedor + " al principio de cada mundo,\n tiene buenos suministros.");
			esperar(30);
			System.out.println(currentNpc + ": ¡Buena suerte ahí fuera!\n");
			esperar(30);

		}

		public static void esperar(int segundos) {
			try {
				Thread.sleep(segundos * 100);
			} catch (Exception e) {
				System.out.println(e);
			}
		}

		public static void cargandoMundo() {
			System.out.println("");
			esperar(5);
			System.out.print("Cargando mundo");
			esperar(5);
			System.out.print(".");
			esperar(5);
			System.out.print("");
			System.out.print(".");
			esperar(5);
			System.out.print("");
			System.out.print(".");
			esperar(5);
			System.out.println("");
			System.out.println("");
		}

		public static void hasMuerto() {
			System.out.println("HAS MUERTO");
			esperar(5);
			System.out.println("");
			System.out.println("███████████████████████████\r\n" + "███████▀▀▀░░░░░░░▀▀▀███████\r\n"
					+ "████▀░░░░░░░░░░░░░░░░░▀████\r\n" + "███│░░░░░░░░░░░░░░░░░░░│███\r\n"
					+ "██▌│░░░░░░░░░░░░░░░░░░░│▐██\r\n" + "██░└┐░░░░░░░░░░░░░░░░░┌┘░██\r\n"
					+ "██░░└┐░░░░░░░░░░░░░░░┌┘░░██\r\n" + "██░░┌┘▄▄▄▄▄░░░░░▄▄▄▄▄└┐░░██\r\n"
					+ "██▌░│██████▌░░░▐██████│░▐██\r\n" + "███░│▐███▀▀░░▄░░▀▀███▌│░███\r\n"
					+ "██▀─┘░░░░░░░▐█▌░░░░░░░└─▀██\r\n" + "██▄░░░▄▄▄▓░░▀█▀░░▓▄▄▄░░░▄██\r\n"
					+ "████▄─┘██▌░░░░░░░▐██└─▄████\r\n" + "█████░░▐█─┬┬┬┬┬┬┬─█▌░░█████\r\n"
					+ "████▌░░░▀┬┼┼┼┼┼┼┼┬▀░░░▐████\r\n" + "█████▄░░░└┴┴┴┴┴┴┴┘░░░▄█████\r\n"
					+ "███████▄░░░░░░░░░░░▄███████\r\n" + "██████████▄▄▄▄▄▄▄██████████\r\n"
					+ "███████████████████████████");

		}

		public static void tienda() {

			Scanner sc = new Scanner(System.in);
			int seleccion = 0;
			// Booleana Especificamente para entrar a la tienda o no
			boolean exitShop = false;
			esperar(5);
			System.out.println("\nPero antes tienes la opción de visitar tu tienda favorita, la de " + vendedor);
			esperar(3);
			do {
				System.out.println("¿Visitar tienda de " + vendedor + "?");
				System.out.println("1.- Sí 2.- No");
				seleccion = sc.nextInt();
				sc.nextLine();

				switch (seleccion) {
				case 1:
					System.out.println(vendedor + ": Bienvenido a mi hermosa tienda");
					// Cojo el numero de items que hay, le resto 1 porque una opcion es la de salir
					int numItems = itemsTienda.length - 1;
					// Genero un array de booleanas para asegurarme de que una vez se compra no se
					// pueda volver a comprar
					boolean[] itemBought = new boolean[numItems];
					int[] precios = new int[] { 50, 75, 25, 25 };
					boolean check = false;
					while (!check) {
						esperar(5);
						System.out.println("Tienes " + coins + " monedas, ¿Qué deseas hacer?");
						esperar(3);
						int index = displayMenu(itemsTienda, "(Items) | Salir");
						esperar(5);
						switch (index) {
						case 1:
							do {

								System.out.println("¿Seguro que quieres comprar este objeto?: " + itemsTienda[index - 1]);
								esperar(3);
								System.out.println("1.- Sí 2.- No");
								seleccion = sc.nextInt();
							} while (seleccion <= 0 || seleccion >= 3);

							if (seleccion == 1 && !itemBought[index - 1] && coins > precios[index - 1]) {
								System.out.println("Has comprado" + itemsTienda[index - 1]);

								for (int i = 0; i < heroDamage.length; i++) {
									heroDamage[i] += 5;
								}
								coins -= precios[index - 1];
								System.out.println("Notas como tu fuerza aumenta 5 puntos. . .");
								itemBought[index - 1] = true;
							} else if (coins < precios[index - 1]) {
								System.out.println("No puedes comprar este objeto (Dinero insuficiente)");
							} else if (itemBought[index - 1]) {
								System.out.println("No puedes comprar este objeto (Existencias agotadas)");
							}
							break;

						case 2:
							do {

								System.out.println("¿Seguro que quieres comprar este objeto?: " + itemsTienda[index - 1]);
								esperar(3);
								System.out.println("1.- Sí 2.- No");
								seleccion = sc.nextInt();
							} while (seleccion <= 0 || seleccion >= 3);

							if (seleccion == 1 && !itemBought[index - 1] && coins > precios[index - 1]) {
								System.out.println("Has comprado" + itemsTienda[index - 1]);
								heroHpMax += 15;
								heroHp = heroHpMax;
								coins -= precios[index - 1];
								itemBought[index - 1] = true;
							} else if (coins < precios[index - 1]) {
								System.out.println("No puedes comprar este objeto (Dinero insuficiente)");
							} else if (itemBought[index - 1]) {
								System.out.println("No puedes comprar este objeto (Existencias agotadas)");
							}
							break;

						case 3:
							do {
								System.out.println("¿Seguro que quieres comprar este objeto?: " + itemsTienda[index - 1]);
								esperar(3);
								System.out.println("1.- Sí 2.- No");
								seleccion = sc.nextInt();
							} while (seleccion <= 0 || seleccion >= 3);

							if (seleccion == 1 && !itemBought[index - 1] && coins > precios[index - 1]) {
								System.out.println("Has comprado" + itemsTienda[index - 1]);
								backpackNum[0]++;
								coins -= precios[index - 1];
								itemBought[index - 1] = true;
							} else if (coins < precios[index - 1]) {
								System.out.println("No puedes comprar este objeto (Dinero insuficiente)");
							} else if (itemBought[index - 1]) {
								System.out.println("No puedes comprar este objeto (Existencias agotadas)");
							}
							break;

						case 4:
							do {
								System.out.println("¿Seguro que quieres comprar este objeto?: " + itemsTienda[index - 1]);
								esperar(3);
								System.out.println("1.- Sí 2.- No");
								seleccion = sc.nextInt();
							} while (seleccion <= 0 || seleccion >= 3);

							if (seleccion == 1 && !itemBought[index - 1] && coins > precios[index - 1]) {
								System.out.println("Has comprado" + itemsTienda[index - 1]);
								backpackNum[1]++;
								coins -= precios[index - 1];
								itemBought[index - 1] = true;
							} else if (coins < precios[index - 1]) {
								System.out.println("No puedes comprar este objeto (Dinero insuficiente)");
							} else if (itemBought[index - 1]) {
								System.out.println("No puedes comprar este objeto (Existencias agotadas)");
							}
							break;

						case 5:
							do {

								System.out.println("¿Seguro que quieres salir de la tienda?");
								esperar(3);
								System.out.println("1.- Sí 2.- No");
								seleccion = sc.nextInt();
							} while (seleccion <= 0 || seleccion >= 3);

							if (seleccion == 1) {
								check = true;
								System.out.println("Sales de la tienda");
								esperar(3);
								System.out.println(vendedor + ": Adios!\n");
							}
							exitShop = true;
							break;
						}

					}
					break;

				case 2:
					System.out.println("Decides no comprar en la tienda");
					exitShop = true;
					break;
				default:
					System.out.println("Error");
				}
			} while (!exitShop);
		}

		public static void finals(int index) {

			switch (index) {
			case 1:
				// Esta funcion saca un parrafo de texto, donde podemos poner una anotació,
				// comprobar la función para entender
				// el por qué del parámetro de entrada
				introFinal("Increíble");

				System.out.println("De repente, aparecen todos tus compañeros: ");
				esperar(3);

				for (int i = 0; i < npcs.length; i++) {
					System.out.println(npcs[i] + "\n");
					esperar(3);
				}

				System.out.println(
						"Que prestan su energía formando un rayo intelectual destructor, digno de altos rangos masones");
				esperar(3);
				System.out.println(enemyNames[5] + ": Imposible... demasiado intelecto");
				esperar(3);
				System.out.println(
						enemyNames[5] + " explota por los aires, sus restos caen en la arena todos os mirais esbozando una"
								+ " sonrisa, sabiendo que todo el universo está a salvo.");
				break;

			case 2:

				introFinal("No está mal");

				System.out.println("Es la hora de saber que destino tendrá el universo de Nexus H3");
				// COMBATE FINAL PONER STATS
				enemyName = enemyNames[5];
				enemySet(5);
				combate();
				System.out.println(
						enemyNames[5] + " explota por los aires, sus restos caen en la arena todos os mirais esbozando una"
								+ " sonrisa, sabiendo que todo el universo está a salvo.");

				break;

			case 3:
				introFinal("Realmente penoso");

				System.out.println("De repente, aparecen todos tus compañeros: ");
				esperar(3);

				for (int i = 0; i < npcs.length; i++) {
					System.out.println(npcs[i] + "\n");
					esperar(3);
				}

				System.out.println("Que apoyan a " + enemyNames[5] + " por tu pobre desempeño en los juegos");
				System.out.println("Este apoyo potencia la fuerza de " + enemyNames[5]);
				esperar(3);
				// COMBATE FINAL PONER STATS
				enemySet(5);
				dificil = true;
				combate();
				System.out.println(enemyNames[5]
						+ " explota por los aires, sus restos caen en la arena te encuentras solo, esbozas"
						+ " una sonrisa agridulce, sabiendo que todo el universo está a salvo pero tú estas solo ;(.");
				break;

			default:
				System.out.println("Error");
			}

		}

		public static void introFinal(String anotacion) {
			System.out.println("Has ganado " + gamesWon + " . . . " + anotacion);
			esperar(3);
			System.out.println("Tras completar todos los mundos te encuentras con " + enemyNames[5]
					+ ", una amalgama grotesca " + "que reune lo peor de todos los universos pertenecientes a Nexus H3");
			esperar(3);
			System.out.println(enemyNames[5] + ": Necesito tú corazon para completarme...");
			esperar(3);
		}

		public static void enemySet(int enemyNum) { // Función para colocar valores del enemigo

			switch (enemyNum) {
			case 0:
				enemyName = enemyNames[0];
				enemyHp = 80;
				enemyHpMax = 80;
				break;
			case 1:
				enemyName = enemyNames[1];
				enemyHp = 70;
				enemyHpMax = 70;
				break;
			case 2:
				enemyName = enemyNames[1];
				enemyHp = 65;
				enemyHpMax = 65;
				break;
			case 3:
				enemyName = enemyNames[1];
				enemyHp = 70;
				enemyHpMax = 70;
				break;
			case 4:
				enemyName = enemyNames[4];
				enemyHp = 75;
				enemyHpMax = 75;
				break;
			case 5:
				enemyName = enemyNames[5];
				enemyHp = 120;
				enemyHpMax = 120;
				enemyDamage[0] = 12;
				enemyDamage[1] = 25;

				if (dificil) {
					enemyHp += 50;
					enemyHpMax += 50;
					enemyDamage[0] = 14;
					enemyDamage[1] = 27;
				}
				break;
			case 6:
				enemyName = enemyNames[6];
				enemyDamage[0] = 3;
				enemyDamage[1] = 5;
			}

		}

	}