package dao;

import java.sql.*;

import model.personajes.Protagonista;

public class DaoProtagonista {

	private Connection conn = null;
	private static DaoProtagonista instance = null;

	public DaoProtagonista() throws SQLException {

		conn = DbConnection.getConnection();
	}

	// Patrón singleton
	public static DaoProtagonista getInstance() throws SQLException {
		if (instance == null) {
			instance = new DaoProtagonista();
		}
		return instance;
	}

	// Devuelve los ataques del protagonista en función del id.
	public Protagonista generarProtagonista(int idProtagonista) throws SQLException {
		// Consulta
		String query = "SELECT nombre, vida_maxima, ataque,"
				+ " pocion_vida, pocion_ataque FROM protagonista WHERE id_protagonista = ?";
		
		// Preparamos la consulta con ? para evitar inyecciones de SQL (Seguridad).
		PreparedStatement stmntSelect = conn.prepareStatement(query);
		// Asignamos el valor real que tiene ?. 1 Hace referencia a la primera columna.
		stmntSelect.setInt(1, idProtagonista);
		// Se ejecuta la consulta
		ResultSet resultData = stmntSelect.executeQuery();
		
		Protagonista p1 = null;

		// Mientras haya registros...
		while (resultData.next()) {
			
					p1 = new Protagonista(resultData.getString("nombre"),
					resultData.getInt("vida_maxima"),
					resultData.getInt("ataque"),
					resultData.getInt("pocion_vida"),
					resultData.getInt("pocion_ataque")
					);
		}
		
		
		// Obtenemos los ataques
		p1.setAtaques(DaoAtaque.getInstance().obtenerAtaquesProtagonista(idProtagonista));
			
		stmntSelect.close();
		
		return p1;
		
		
	}
}
