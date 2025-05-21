package controller;

import java.sql.SQLException;

import model.*;
import model.personajes.Protagonista;

public class Main {
	
	public static void main(String[] args) throws SQLException {
		
		GameManager gm = new GameManager();
		gm.start();
		
		Protagonista p = new Protagonista("Hola", 2, 2, 2, 2);
		
		System.out.println(p.imprimirAtaqueDebil());
	}
}
