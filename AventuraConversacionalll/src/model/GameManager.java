package model;

import java.sql.SQLException;

import dao.DaoEnemigo;
import dao.DaoProtagonista;
import model.personajes.*;

public class GameManager {
	
	private Protagonista p1;
	private Enemigo enemy;
	private Combate comb;

	public GameManager() {
		
	}
	
	public void start() throws SQLException {
		p1 = DaoProtagonista.getInstance().generarProtagonista(1);
		enemy = DaoEnemigo.getInstance().generarEnemigo(1);
		comb = new Combate();
		comb.inicioCombate(p1, enemy);
	}
}
