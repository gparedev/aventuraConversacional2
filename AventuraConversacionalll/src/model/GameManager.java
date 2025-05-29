package model;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.DaoEnemigo;
import dao.DaoProtagonista;
import model.personajes.*;

public class GameManager {
	
	private Protagonista p1;
	// Puede que no haga ni falta y solo con el ArrayList me valga
	private Enemigo enemy;
	private ArrayList<Enemigo> misEnemigos;
	private Combate comb;
	
	// Juegos
	
	// Localizaciones
	
	// NPCs
	
	// Tienda
	
	// Scanner

	public GameManager() {
		
	}
	
	public void start() throws SQLException {
		p1 = DaoProtagonista.getInstance().generarProtagonista(1);
		enemy = DaoEnemigo.getInstance().generarEnemigo(1);
		comb = new Combate();
		comb.inicioCombate(p1, enemy);
	}
}
