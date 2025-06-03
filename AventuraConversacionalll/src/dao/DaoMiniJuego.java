package dao;

import java.sql.*;
import java.util.Scanner;

public class DaoMiniJuego {

	private final Scanner sc = new Scanner(System.in);
	private final Connection conn;
	private static DaoMiniJuego instance;

	public DaoMiniJuego() throws SQLException {
		conn = DbConnection.getConnection();
	}

	public static DaoMiniJuego getInstance() throws SQLException {
		if (instance == null) {
			instance = new DaoMiniJuego();
		}
		return instance;
	}

	public String getNombreMinijuego(int numJuego) throws SQLException {
		String query = "SELECT nombre FROM minijuegos WHERE id_minijuego = ?";
		PreparedStatement statement = conn.prepareStatement(query);
		statement.setInt(1, numJuego);
		ResultSet rSet = statement.executeQuery();
		String nombre = null;
		if (rSet.next()) {
			nombre = rSet.getString("nombre");
		}

		rSet.close();
		statement.close();
		return nombre;
	}

	public String getDescripcionMinijuego(int numJuego) throws SQLException {
		String query = "SELECT descripcion FROM minijuegos WHERE id_minijuego = ?";
		PreparedStatement statement = conn.prepareStatement(query);
		statement.setInt(1, numJuego);
		ResultSet rSet = statement.executeQuery();
		String descripcion = null;
		if (rSet.next()) {
			descripcion = rSet.getString("descripcion");
		}

		rSet.close();
		statement.close();
		return descripcion;
	}

	public int getPuntosMinijuego(int numJuego) throws SQLException {
		String query = "SELECT puntos FROM minijuegos WHERE id_minijuego = ?";
		PreparedStatement statement = conn.prepareStatement(query);
		statement.setInt(1, numJuego);
		ResultSet rSet = statement.executeQuery();
		int puntos = 0;
		if (rSet.next()) {
			puntos = rSet.getInt("puntos");
		}

		rSet.close();
		statement.close();
		return puntos;
	}

	public String getDatosMinijuego(int numJuego) throws SQLException {
		String datos = null;
		String query = "SELECT nombre, descripcion, puntos FROM minijuegos WHERE id_minijuego = ?";
		PreparedStatement statement = conn.prepareStatement(query);
		statement.setInt(1, numJuego);
		ResultSet rSet = statement.executeQuery();
		String nombre = null;
		String descripcion = null;
		int puntos = 0;
		if (rSet.next()) {
			nombre = rSet.getString("nombre");
			descripcion = rSet.getString("descripcion");
			puntos = rSet.getInt("puntos");

			datos = "Datos de juego\nNombre: " + nombre + "\nDescripción: " + descripcion + "\nPuntos por ganar: "
					+ puntos;
		}

		rSet.close();
		statement.close();
		return datos;
	}
}
