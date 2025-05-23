package model;

import java.sql.SQLException;

import dao.DaoLogin;
import dao.DaoMiniJuego;
import model.miniJuegos.*;

public class MiniJuegoManager {

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

	public void start() throws SQLException{
		if (numJuego == 0) {
			numJuego = (int) (Math.random() * 5 + 1);
		} else {
			numJuego++;
		}
		if (numJuego > 5) {
			numJuego = 1;
		}

		this.startJuego(numJuego);
	}

	private void startJuego(int numJuego) throws SQLException {
		this.imprimirDatos();
		switch (numJuego) {
		case 1:
			Juego1 juego1 = new Juego1();
			juego1.juegoStart();
			break;
		case 2:
			Juego2 juego2 = new Juego2();
			juego2.juegoStart();
			break;
		case 3:
			Juego3 juego3 = new Juego3();
			juego3.juegoStart();
			break;
		case 4:
			Juego4 juego4 = new Juego4();
			juego4.juegoStart();
			break;
		case 5:
			Juego5 juego5 = new Juego5();
			juego5.juegoStart();
			break;
		}
	}
	
	private void imprimirDatos() throws SQLException {
		this.getDatos();
		System.out.println(datos);
	}

}
