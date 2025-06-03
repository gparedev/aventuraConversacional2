package controller;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.DaoEnemigo;
import dao.DaoProtagonista;
import dao.DaoTienda;
import model.GameManager;
import model.Tienda;
import model.escenario.Escenario;
import model.personajes.*;

public class Main {

	public static void main(String[] args) throws SQLException {

		GameManager gm = new GameManager();
		gm.menuDeInicio();

	}
}
