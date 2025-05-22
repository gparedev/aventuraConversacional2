package dao;

import java.sql.*;

import model.personajes.Enemigo;
import model.personajes.Protagonista;

public class DaoEnemigo {

	private Connection conn = null;
	private static DaoEnemigo instance = null;

	public DaoEnemigo() throws SQLException {

		conn = DbConnection.getConnection();
	}

	// Patrón singleton
	public static DaoEnemigo getInstance() throws SQLException {
		if (instance == null) {
			instance = new DaoEnemigo();
		}
		return instance;
	}

	// Devuelve los ataques del protagonista en función del id.
	public Enemigo generarEnemigo(int idEnemigo) throws SQLException {
		// Consulta
		String query = "SELECT nombre, vida_maxima, ataque,"
				+ " pocion_vida, pocion_ataque FROM enemigo WHERE id_enemigo = ?";
		
		// Preparamos la consulta con ? para evitar inyecciones de SQL (Seguridad).
		PreparedStatement stmntSelect = conn.prepareStatement(query);
		// Asignamos el valor real que tiene ?. 1 Hace referencia a la primera columna.
		stmntSelect.setInt(1, idEnemigo);
		// Se ejecuta la consulta
		ResultSet resultData = stmntSelect.executeQuery();
		
		Enemigo e1 = null;

		// Mientras haya registros...
		while (resultData.next()) {
			
					e1 = new Enemigo(resultData.getString("nombre"),
					resultData.getInt("vida_maxima"),
					resultData.getInt("ataque"),
					resultData.getInt("pocion_vida"),
					resultData.getInt("pocion_ataque")
					);
		}
		
		
		// Obtenemos los ataques
		e1.setAtaques(DaoAtaque.getInstance().obtenerAtaquesEnemigo(idEnemigo));
			
		stmntSelect.close();
		
		return e1;
			
	}
}
