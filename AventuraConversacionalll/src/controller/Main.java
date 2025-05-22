package controller;

import java.sql.*;
import java.util.Scanner;

import model.*;
import model.miniJuegos.MiniJuegoStart;

public class Main {

	public static void main(String[] args) throws SQLException {

		GameManager gm = new GameManager();
		gm.start();

		// ALTER TABLE usuario AUTO_INCREMENT = 1; para resetear primart key al 1 después de las pruebas
		Login log = new Login();
		log.inicio();
		
	}
}
