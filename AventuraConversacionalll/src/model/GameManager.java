	package model;
	
	import java.sql.SQLException;
	import java.util.ArrayList;
	import java.util.Scanner;
	
	import dao.DaoEnemigo;
	import dao.DaoLocation;
	import dao.DaoNpc;
	import dao.DaoProtagonista;
	import dao.DaoTienda;
	import model.miniJuegos.Juego;
	import model.miniJuegos.Juego1;
	import model.miniJuegos.Juego2;
	import model.miniJuegos.Juego3;
	import model.miniJuegos.Juego4;
	import model.miniJuegos.Juego5;
	import model.personajes.*;
	import model.Usuario;
	
	public class GameManager {
	
		private String nombre_usuario;
	
		private Protagonista p1;
		private ArrayList<Enemigo> misEnemigos;
		private ArrayList<Npc> misNpcs;
		private Combate comb = new Combate();
		private ArrayList<Location> misLocations;
		private Usuario usuario;
		private boolean gameOver = false;
		private int mundosCompletados;
		private Tienda miTienda;
	
		private ArrayList<Juego> misJuegos = new ArrayList<Juego>();
	
		// Scanner
		Scanner sc = new Scanner(System.in);
	
		// Constante que muestra las opciones extra que hay aparte de los mundos en la
		// navegación
		private final int OPCIONES_EXTRA = 2;
	
		public GameManager() {
	
		}
	
		// Getters & Setters
	
		public String getNombre_usuario() {
			return nombre_usuario;
		}
	
		public void setNombre_usuario(String nombre_usuario) {
			this.nombre_usuario = nombre_usuario;
		}
	
		public Protagonista getP1() {
			return p1;
		}
	
		public void setP1(Protagonista p1) {
			this.p1 = p1;
		}
	
		public ArrayList<Enemigo> getMisEnemigos() {
			return misEnemigos;
		}
	
		public void setMisEnemigos(ArrayList<Enemigo> misEnemigos) {
			this.misEnemigos = misEnemigos;
		}
	
		public ArrayList<Npc> getMisNpcs() {
			return misNpcs;
		}
	
		public void setMisNpcs(ArrayList<Npc> misNpcs) {
			this.misNpcs = misNpcs;
		}
	
		public ArrayList<Location> getMisLocations() {
			return misLocations;
		}
	
		public void setMisLocations(ArrayList<Location> misLocations) {
			this.misLocations = misLocations;
		}
	
		public Usuario getUsuario() {
			return usuario;
		}
	
		public void setUsuario(Usuario usuario) {
			this.usuario = usuario;
		}
	
		public boolean isGameOver() {
			return gameOver;
		}
	
		public void setGameOver(boolean gameOver) {
			this.gameOver = gameOver;
		}
	
		public int getMundosCompletados() {
			return mundosCompletados;
		}
	
		public void setMundosCompletados(int mundosCompletados) {
			this.mundosCompletados = mundosCompletados;
		}
	
		public Tienda getMiTienda() {
			return miTienda;
		}
	
		public void setMiTienda(Tienda miTienda) {
			this.miTienda = miTienda;
		}
	
		public void inicializarJuegos() {
			misJuegos.add(new Juego1());
			misJuegos.add(new Juego2());
			misJuegos.add(new Juego3());
			misJuegos.add(new Juego4());
			misJuegos.add(new Juego5());
		}
	
		// Como el personaje no se genera hasta esta elección no podemos acceder a sus
		// atributos.
		public int seleccionarPersonaje() {
			int index = 0;
			do {
				System.out.println("Selecciona un personaje");
				System.out.println("1.-Sora 2.-Cloud 3.-2A");
				index = sc.nextInt();
				sc.nextLine();
			} while (index < 1 || index > 3);
			return index;
	
		}
	
		public void generarMundo() throws SQLException {
			int index = seleccionarPersonaje();
	
			generarProtagonista(index);
			generarEnemigos(index);
			generarLocations(index);
			generarNpcs(index);
			generarTienda(index);
			inicializarJuegos();
	
		}
	
		public void generarProtagonista(int index) throws SQLException {
			setP1(DaoProtagonista.getInstance().generarProtagonista(index));
		}
	
		public void generarTienda(int index) throws SQLException {
			setMiTienda(DaoTienda.getInstance().obtenerTienda(index));
			miTienda.setProtagonista(getP1());
		}
	
		public void generarEnemigos(int index) throws SQLException {
			setMisEnemigos(DaoEnemigo.getInstance().generarEnemigos(index));
		}
	
		public void generarNpcs(int index) throws SQLException {
			setMisNpcs(DaoNpc.getInstance().generarNpcsProtagonista(index));
		}
	
		public void generarLocations(int index) throws SQLException {
			setMisLocations(DaoLocation.getInstance().generarLocationsProtagonista(index));
		}
	
		public void start() throws SQLException {
			generarMundo();
			elegirItemInicial();
			flujoJuego();
		}
	
		public void logIn() throws SQLException {
			Usuario usuario = new Usuario();
			setUsuario(usuario);
			usuario.setNombre(getUsuario().inicio());
			setNombre_usuario(usuario.getNombre());
		}
	
		public void menuDeInicio() throws SQLException {
			int opcionMenu;
			logIn();
			do {
				System.out.println("BIENVENIDO AL MUNDO DE SQUARE ENIX");
				do {
					System.out.println("1. Empezar a jugar | 2. Ver Top 3 | 3. Ver mejor jugador");
					opcionMenu = sc.nextInt();
				} while (opcionMenu < 1 || opcionMenu > 3);
	
				switch (opcionMenu) {
				case 1:
					start();
					break;
				case 2:
					usuario.mostrarTop3();
					break;
	
				case 3:
					usuario.mostrarTop1();
					break;
	
				default:
					break;
				}
			} while (opcionMenu == 2 || opcionMenu == 3);
	
		}
	
		public void mostrarMundos() {
			String str = "";
			System.out.println("Selecciona a qué mundo quieres viajar");
			for (int i = 0; i < misLocations.size(); i++) {
				str += (i + 1) + ".-" + misLocations.get(i).getNombre() + " ";
			}
			System.out.print(str);
		}
	
		public void mostrarOpcionesNavegacion() {
			mostrarMundos();
			System.out.println("6.-Tienda 7.-Estadísticas");
		}
	
		// Hacer cambios aqui, mostrar la opción de tienda o de estadisticas personaje
		public void flujoJuego() throws SQLException {
	
			int index = 0;
			// Si se cumple una de estas 3 condiciones el juego termina
			while (getP1().getVida() > 0 && !isGameOver() && getMundosCompletados() < 5) {
				do {
					mostrarOpcionesNavegacion();
					index = sc.nextInt();
					sc.nextLine();
				} while (index < 1 || index > misLocations.size() + OPCIONES_EXTRA);
	
				switch (index) {
				case 1, 2, 3, 4, 5:
					explorarMundo(index - 1);
					break;
	
				case 6:
					System.out.println("Visitando la tienda...");
					getMiTienda().tienda();
					break;
	
				case 7:
					getP1().imprimirInfo();
					break;
				}
	
			}
	
			if (getP1().getVida() > 0) {
	
				// Logica de comprobar cuantos juegos has ganado o lo que sea y que pase A B o C
				System.out.println("Has ganado: " + getP1().getJuegosGanados() + "/5 juegos");
	
				if (getP1().getJuegosGanados() < 3) {
					System.out.println("Final malo");
					comb.inicioCombate(getP1(), getMisEnemigos().get(5));
				} else if (getP1().getJuegosGanados() < 5) {
					System.out.println("Final normal");
					comb.inicioCombate(getP1(), getMisEnemigos().get(6));
				} else {
					System.out.println("Final bueno");
					comb.inicioCombate(getP1(), getMisEnemigos().get(7));
				}
			} else {
				System.out.println("Te has muerto, campeón");
			}
	
			System.out.println("Juego terminado máquina");
			System.out.println("Has obtenido: " + usuario.getPuntuacion() + " puntos");
			usuario.agregarPuntuacion(usuario.getPuntuacion(), usuario.getNombre());
	
		}
	
		public void explorarMundo(int index) throws SQLException {
			if (!misLocations.get(index).isVisited()) {
				Location localizacionActual = misLocations.get(index);
				localizacionActual.imprimirFrase();
				localizacionActual.setVisited(true);
				localizacionActual.setNombre(localizacionActual.getNombre() + " (VISITADO)");
	
				// Se comprueba si se ha ganado el juego o no.
				if (misJuegos.get(index).juegoStart(misNpcs.get(index).getNombre())) {
					System.out.println("Ganas el juego, ganas 50 puntos en la clasificación");
					usuario.setPuntuacion(usuario.getPuntuacion() + 50);
					getP1().setMonedas(getP1().getMonedas() + 20);
					getP1().setJuegosGanados(getP1().getJuegosGanados() + 1);
				} else {
					System.out.println("Has peridido, tontito.");
				}
	
				comb.inicioCombate(getP1(), getMisEnemigos().get(index));
	
				// Si ganas el combate...
				if (getP1().getVida() > 0) {
					System.out.println(
							"Saqueas el cadaver de " + misEnemigos.get(index).getNombre() + " y encuentras 20 monedas!");
					System.out.println("Sumas 50 puntos en la clasificación");
					usuario.setPuntuacion(usuario.getPuntuacion() + 50);
					getP1().setMonedas(getP1().getMonedas() + 20);
					setMundosCompletados(getMundosCompletados() + 1);
				}
	
			} else {
				System.out.println("Ya has completado este mundo, tontito.");
			}
		}
	
		// Lo suyo sería hacer una tabla en la BDD de Abalorios y hacer el mismo proceso
		// que hemos hecho
		// con ataques, localizaciones, entornos, personajes, enemigos...
		public void elegirItemInicial() {
			int index = 0;
			do {
				System.out.println("Bienvenido, " + getP1().getNombre()
						+ " antes de comenzar tu aventura elige entre uno de los siguientes objetos:");
				System.out.println("1.-Espada 2.-Escudo 3.-Baston");
				index = sc.nextInt();
			} while (index < 1 || index > 3);
	
			switch (index) {
			case 1:
				System.out.println("Seleccionas la espada que incrementa tu fuerza");
				getP1().setAtaque(getP1().getAtaque() + 10);
				getP1().setAtaqueIni(getP1().getAtaqueIni() + 10);
				break;
	
			case 2:
				System.out.println("Seleccionas el escudo que incrementa tu defensa");
				getP1().setDefensa(getP1().getDefensa() + 10);
				getP1().setDefensaIni(getP1().getDefensaIni() + 10);
				break;
	
			case 3:
				System.out.println("Seleccionas el bastón lo que te llena de sabiduría");
				getP1().setAtaque(getP1().getAtaque() + 5);
				getP1().setAtaqueIni(getP1().getAtaqueIni() + 5);
	
				getP1().setDefensa(getP1().getDefensa() + 5);
				getP1().setDefensaIni(getP1().getDefensaIni() + 5);
			}
	
		}
	
	}
