package model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import dao.DaoEnemigo;
import dao.DaoLocation;
import dao.DaoNpc;
import dao.DaoProtagonista;
import model.miniJuegos.Juego;
import model.miniJuegos.Juego1;
import model.miniJuegos.Juego2;
import model.miniJuegos.Juego3;
import model.miniJuegos.Juego4;
import model.miniJuegos.Juego5;
import model.personajes.*;

public class GameManager {

	private Protagonista p1;
	private ArrayList<Enemigo> misEnemigos;
	private ArrayList<Npc> misNpcs;
	private Combate comb = new Combate();
	private ArrayList<Location> misLocations;
	private Usuario usuario;
	private boolean gameOver = false;
	private int mundosCompletados;

	private ArrayList<Juego> misJuegos = new ArrayList<Juego>();

	// Scanner
	Scanner sc = new Scanner(System.in);

	public GameManager() {

	}

	// Getters & Setters

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
		inicializarJuegos();

	}

	public void generarProtagonista(int index) throws SQLException {
		setP1(DaoProtagonista.getInstance().generarProtagonista(index));
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
		elegirMundo();
	}

	public void logIn() throws SQLException {
		Usuario usuario = new Usuario();
		setUsuario(usuario);
		getUsuario().inicio();
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
				start();
				break;

			case 3:
				usuario.mostrarTop1();
				start();
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
		System.out.println(str);
	}

	public void elegirMundo() throws SQLException {

		int index = 0;
		// Si se cumple una de estas 3 condiciones el juego termina
		while (getP1().getVida() > 0 && !isGameOver() && getMundosCompletados() < 5) {
			do {
				mostrarMundos();
				index = sc.nextInt();
				sc.nextLine();
			} while (index < 1 || index > misLocations.size());

			if (getMundosCompletados() < 5) {
				explorarMundo(index - 1);
			} else {
				System.out.println("Has completado 5 mundos!");
				setGameOver(true);
			}

		}

		System.out.println("Juego terminado máquina");

	}

	public void explorarMundo(int index) throws SQLException {
		if (!misLocations.get(index).isVisited()) {
			Location localizacionActual = misLocations.get(index);
			localizacionActual.imprimirFrase();
			localizacionActual.setVisited(true);
			localizacionActual.setNombre(localizacionActual.getNombre() + " (VISITADO)");
			if (misJuegos.get(index).juegoStart(misNpcs.get(index).getNombre())) {
				System.out.println("Ganas el juego");
				getP1().setJuegosGanados(getP1().getJuegosGanados() + 1);
			} else {
				System.out.println("Has peridido, tontito.");
			}

			comb.inicioCombate(getP1(), getMisEnemigos().get(index));
			setMundosCompletados(getMundosCompletados() + 1);
		} else {
			System.out.println("Ya has completado este mundo, tontito.");
		}
	}
}
