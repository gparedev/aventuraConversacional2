package dao;

import java.sql.*;
import java.util.ArrayList;

import model.personajes.Ataque;

public class DaoAtaque {

	private Connection conn = null;
	private static DaoAtaque instance = null;

	public DaoAtaque() throws SQLException {

		conn = DbConnection.getConnection();
	}

	// Patrón singleton
	public static DaoAtaque getInstance() throws SQLException {
		if (instance == null) {
			instance = new DaoAtaque();
		}
		return instance;
	}

	// Devuelve los ataques del protagonista en función del id.
	public ArrayList<Ataque> obtenerAtaquesProtagonista(int idProtagonista) throws SQLException {
		// Consulta
		String query = "SELECT nombre, damage, tipo, `precision` FROM ataque_protagonista "
				+ "WHERE id_protagonista = ?";
		
		// Preparamos la consulta con ? para evitar inyecciones de SQL (Seguridad).
		PreparedStatement stmntSelect = conn.prepareStatement(query);
		// Asignamos el valor real que tiene ?. 1 Hace referencia a la primera columna.
		stmntSelect.setInt(1, idProtagonista);
		// Se ejecuta la consulta
		ResultSet resultData = stmntSelect.executeQuery();
		
		ArrayList<Ataque> ataques = new ArrayList<>();
		
		// Mientras haya registros...
		while (resultData.next()) {
			// Relleno los ataques por iteración
			ataques.add(new Ataque(resultData.getString("nombre"),
					resultData.getInt("damage"),
					resultData.getString("tipo"),
					resultData.getInt("precision")
					));
		}
		
		stmntSelect.close();
		
		return ataques;
		
		
	}
	
	// Devuelve los ataques del protagonista en función del id.
		public ArrayList<Ataque> obtenerAtaquesEnemigo(int idEnemigo) throws SQLException {
			// Consulta
			String query = "SELECT nombre, damage, tipo, `precision` FROM ataque_enemigo "
					+ "WHERE id_enemigo = ?";
			
			// Preparamos la consulta con ? para evitar inyecciones de SQL (Seguridad).
			PreparedStatement stmntSelect = conn.prepareStatement(query);
			// Asignamos el valor real que tiene ?. 1 Hace referencia a la primera columna.
			stmntSelect.setInt(1, idEnemigo);
			// Se ejecuta la consulta
			ResultSet resultData = stmntSelect.executeQuery();
			
			ArrayList<Ataque> ataques = new ArrayList<>();
			
			// Mientras haya registros...
			while (resultData.next()) {
				// Relleno los ataques por iteración
				ataques.add(new Ataque(resultData.getString("nombre"),
						resultData.getInt("damage"),
						resultData.getString("tipo"),
						resultData.getInt("precision")
						));
			}
			
			stmntSelect.close();
			
			return ataques;
			
			
		}
}
