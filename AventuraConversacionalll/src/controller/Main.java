package controller;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.DaoEnemigo;
import dao.DaoProtagonista;
import model.escenario.Escenario;
import model.personajes.*;

public class Main {

	public static void main(String[] args) throws SQLException {

		Protagonista p1 = DaoProtagonista.getInstance().generarProtagonista(1);

		p1.imprimirInfo();

		Enemigo e1 = DaoEnemigo.getInstance().generarEnemigo(1);

		e1.imprimirInfo();

		Combate comb = new Combate();
		
		ArrayList<Enemigo> misEnemigos = new ArrayList<Enemigo>();
		
		misEnemigos = DaoEnemigo.getInstance().generarEnemigos(1);
		
		for (Enemigo e : misEnemigos) {
			System.out.println(e.getNombre());
		}
		// Combate con el enemigo 5
		comb.inicioCombate(p1, misEnemigos.get(4));
		// Combate con el enemigo 1
		comb.inicioCombate(p1, misEnemigos.get(0));
		
	}
}
