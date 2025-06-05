package model;

import java.sql.SQLException;
import dao.DaoUsuario;

public class Usuario {

	private String nombre;
	private String contrasena;
	private int puntuacion;

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

	public int getPuntuacion() {
		return puntuacion;
	}

	public void setPuntuacion(int puntuacion) {
		this.puntuacion = puntuacion;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String inicio() throws SQLException {
		String nombre = "";
		nombre = DaoUsuario.getInstance().inicioDeSesionORegistro();
		return nombre;
		
	}

	public void mostrarTop3() throws SQLException {
		DaoUsuario.getInstance().top3();
	}

	public void mostrarTop1() throws SQLException {
		DaoUsuario.getInstance().top1();
	}

	public void agregarPuntuacion(int puntuacionIn, String nombreIn) throws SQLException {
		DaoUsuario.getInstance().agregarPuntuacion(puntuacionIn, nombreIn);
	}

}
