package model;

import java.sql.SQLException;
import dao.DaoLogin;

public class Login {

	private String nombre;
	private String contrasena;

	public Login() {
	}

	public Login(String nombre, String contrasena) {
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

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public void inicio() throws SQLException {
		DaoLogin.getInstance().inicioDeSesionORegistro();
	}
}
