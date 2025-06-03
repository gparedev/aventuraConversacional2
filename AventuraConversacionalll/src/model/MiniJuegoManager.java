package model;

import java.sql.*;

import dao.DaoMiniJuego;
import model.miniJuegos.*;

public class MiniJuegoManager implements Printer {
	// ATRIBUTOS

	private int numJuego = 0;
	private String nombre;
	private String descripcion;
	private int puntos;
	private String datos;

	// CONSTRUCTORES

	public MiniJuegoManager() {
	}

	// GET Y SET

	public void getNombre() throws SQLException {
		nombre = DaoMiniJuego.getInstance().getNombreMinijuego(numJuego);
	}

	public void getDescripcion() throws SQLException {
		descripcion = DaoMiniJuego.getInstance().getDescripcionMinijuego(numJuego);
	}

	public void getPuntos() throws SQLException {
		puntos = DaoMiniJuego.getInstance().getPuntosMinijuego(numJuego);
	}

	public void getDatos() throws SQLException {
		datos = DaoMiniJuego.getInstance().getDatosMinijuego(numJuego);
	}

	// FUNCIONES

	public void start(String npc) throws SQLException {
		if (numJuego == 0) {
			numJuego = (int) (Math.random() * 5 + 1);
		} else {
			numJuego++;
		}
		if (numJuego > 5) {
			numJuego = 1;
		}

		this.startJuego(numJuego, npc);
	}

	private boolean startJuego(int numJuego, String npc) throws SQLException {
		this.imprimirDatos();
		boolean gameWin = false;
		switch (numJuego) {
		case 1:
			Juego1 juego1 = new Juego1();
			gameWin = juego1.juegoStart(npc);
			break;
		case 2:
			Juego2 juego2 = new Juego2();
			gameWin = juego2.juegoStart(npc);
			break;
		case 3:
			Juego3 juego3 = new Juego3();
			gameWin = juego3.juegoStart(npc);
			break;
		case 4:
			Juego4 juego4 = new Juego4();
			gameWin = juego4.juegoStart(npc);
			break;
		case 5:
			Juego5 juego5 = new Juego5();
			gameWin = juego5.juegoStart(npc);
			break;
		}
		return gameWin;
	}

	private void imprimirDatos() throws SQLException {
		this.getDatos();
		this.print(datos);
	}

}
