package model;

import java.sql.SQLException;
import dao.DaoUsuario;

public class Usuario {

	private String nombre;
	private String contrasena;
	private String puntuacion;

	public Usuario() {
	}

	public Usuario(String nombre, String contrasena) {
		this.nombre = nombre;
		this.contrasena = contrasena;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getContrasena() {
		return contrasena;
	}

	public String getPuntuacion() {
		return puntuacion;
	}

	public void setPuntuacion(String puntuacion) {
		this.puntuacion = puntuacion;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public void inicioLogin() throws SQLException {
		DaoUsuario.getInstance().inicioDeSesionORegistro();
	}

	public void puntuacionJugador(String nombre) throws SQLException {
		DaoUsuario.getInstance().puntuacionJugador(nombre);
	}

	public void mostrarTop3() throws SQLException {
		DaoUsuario.getInstance().top3();
	}
	
	public void mostrarTop1() throws SQLException {
		DaoUsuario.getInstance().top1();
	}

}
