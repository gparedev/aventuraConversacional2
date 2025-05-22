package controller;

import java.sql.SQLException;

import dao.DaoProtagonista;
import model.personajes.*;

public class Main {
	
	public static void main(String[] args) throws SQLException {
		
		
		Protagonista p1 = DaoProtagonista.getInstance().generarProtagonista(1);
		
		p1.imprimirInfo();
		
	}
}
