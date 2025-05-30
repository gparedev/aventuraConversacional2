package model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import dao.DaoEnemigo;
import dao.DaoLocation;
import dao.DaoNpc;
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
	private ArrayList<Location> misLocations;

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
			generarLocations(index);
			generarNpcs(index);			
			break;

		}
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
		Usuario usuario = new Usuario();
		usuario.inicio();
		generarMundo();
		misNpcs.get(0).hablar();
		comb = new Combate();
		comb.inicioCombate(getP1(), misEnemigos.get(0));
	}
}
