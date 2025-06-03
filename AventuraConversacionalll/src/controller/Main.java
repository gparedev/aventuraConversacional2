package controller;

import java.sql.SQLException;

import model.GameManager;

public class Main {

	public static void main(String[] args) throws SQLException {

		GameManager gm = new GameManager();
		gm.menuDeInicio();

	}
}
