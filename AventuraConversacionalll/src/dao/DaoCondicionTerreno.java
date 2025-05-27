package dao;

import java.sql.*;

import model.escenario.CondicionTerreno;

public class DaoCondicionTerreno {
	private Connection conn = null;
	private static DaoCondicionTerreno instance = null;

	public DaoCondicionTerreno() throws SQLException {

		conn = DbConnection.getConnection();
	}

	// Patrón singleton
	public static DaoCondicionTerreno getInstance() throws SQLException {
		if (instance == null) {
			instance = new DaoCondicionTerreno();
		}
		return instance;
	}

	public CondicionTerreno obtenerAleatorio() throws SQLException {
		// Elige el primer registro de manera aleatoria.
		String query = "SELECT nombre, penalizacion_ataque, penalizacion_defensa"
				+ " FROM condiciones_terreno ORDER BY RAND() LIMIT 1";

		PreparedStatement stmntSelect = conn.prepareStatement(query);

		ResultSet resultData = stmntSelect.executeQuery();

		while (resultData.next()) {
			String nombre = resultData.getString("nombre");
			int penalizacionAtaque = resultData.getInt("penalizacion_ataque");
			int penalizacionDefensa = resultData.getInt("penalizacion_defensa");

			CondicionTerreno ct = new CondicionTerreno(nombre, penalizacionAtaque, penalizacionDefensa);
			return ct;
		}
		// Por si no encuentra nada.
		return null;
	}

}
