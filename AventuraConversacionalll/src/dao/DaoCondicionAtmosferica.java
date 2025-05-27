package dao;

import java.sql.*;

import model.escenario.CondicionAtmosferica;

public class DaoCondicionAtmosferica {
	private Connection conn = null;
	private static DaoCondicionAtmosferica instance = null;

	public DaoCondicionAtmosferica() throws SQLException {

		conn = DbConnection.getConnection();
	}

	// Patrón singleton
	public static DaoCondicionAtmosferica getInstance() throws SQLException {
		if (instance == null) {
			instance = new DaoCondicionAtmosferica();
		}
		return instance;
	}

	public CondicionAtmosferica obtenerAleatorio() throws SQLException {
		// Elige el primer registro de manera aleatoria.
		String query = "SELECT nombre, penalizacion_ataque"
				+ " FROM condiciones_atmosfericas ORDER BY RAND() LIMIT 1";

		PreparedStatement stmntSelect = conn.prepareStatement(query);

		ResultSet resultData = stmntSelect.executeQuery();

		while (resultData.next()) {
			String nombre = resultData.getString("nombre");
			int penalizacionAtaque = resultData.getInt("penalizacion_ataque");

			CondicionAtmosferica ca = new CondicionAtmosferica(nombre, penalizacionAtaque);
			return ca;
		}
		// Por si no encuentra nada.
		return null;
	}

}
