package model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import dao.DaoEnemigo;
import dao.DaoProtagonista;
import model.personajes.*;

public class GameManager {

	private Protagonista p1;
	// Puede que no haga ni falta y solo con el ArrayList me valga
	private Enemigo enemy;
	private ArrayList<Enemigo> misEnemigos;
	private ArrayList<Npc> misNpcs;
	private Combate comb;

	// Juegos

	// Localizaciones

	// NPCs

	// Tienda

	// Scanner
	Scanner sc = new Scanner(System.in);

	public GameManager() {

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
		switch (index) {
		case 1:
			generarProtagonista(index);
			generarEnemigos(index);
			break;
		}
	}

	public void generarProtagonista(int index) throws SQLException {
		setP1(DaoProtagonista.getInstance().generarProtagonista(index));
	}

	public void generarEnemigos(int index) throws SQLException {
		setMisEnemigos(DaoEnemigo.getInstance().generarEnemigos(index));
	}

	public void start() throws SQLException {
		Usuario usuario = new Usuario();
		generarMundo();
		comb = new Combate();
		comb.inicioCombate(getP1(), misEnemigos.get(0));
	}

	public void menuDeInicio() throws SQLException {
		Usuario usuario = new Usuario();
		usuario.inicio();
		System.out.println("BIENVENIDO AL MUNDO DE SQUARE ENIX");
		int opcionMenu;
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
	}
}
