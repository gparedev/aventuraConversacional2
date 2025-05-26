package dao;

import java.sql.*;

import model.escenario.MomentoDelDia;

public class DaoMomentoDelDia {
	private Connection conn = null;
	private static DaoProtagonista instance = null;

	public DaoMomentoDelDia() throws SQLException {

		conn = DbConnection.getConnection();
	}

	// Patrón singleton
	public static DaoProtagonista getInstance() throws SQLException {
		if (instance == null) {
			instance = new DaoProtagonista();
		}
		return instance;
	}

	public MomentoDelDia obtenerAleatorio() throws SQLException {
		// Elige el primer registro de manera aleatoria.
		String query = "SELECT nombre, penalizacion_defensa, bonus_ataque"
				+ " FROM momentos_dia ORDER BY RAND() LIMIT 1";

		PreparedStatement stmntSelect = conn.prepareStatement(query);

		ResultSet resultData = stmntSelect.executeQuery();

		while (resultData.next()) {
			String nombre = resultData.getString("nombre");
			int penalizacionDefensa = resultData.getInt("penalizacion_defensa");
			int bonusAtaque = resultData.getInt("bonus_ataque");

			MomentoDelDia md = new MomentoDelDia(nombre, penalizacionDefensa, bonusAtaque);
			return md;
		}
		// Por si no encuentra nada
		return null;
	}

}
