package dao;

import java.sql.*;
import java.util.ArrayList;

import model.personajes.Npc;

public class DaoNpc {

	private Connection conn = null;
	private static DaoNpc instance = null;

	public DaoNpc() throws SQLException {

		conn = DbConnection.getConnection();
	}

	// Patrón singleton
	public static DaoNpc getInstance() throws SQLException {
		if (instance == null) {
			instance = new DaoNpc();
		}
		return instance;
	}

	// Devuelve los ataques del protagonista en función del id.
	public ArrayList<Npc> generarNpcsProtagonista(int idProtagonista) throws SQLException {
		// Consulta
		String query = "SELECT nombre, frase FROM npc " + "WHERE id_protagonista = ?";

		// Preparamos la consulta con ? para evitar inyecciones de SQL (Seguridad).
		PreparedStatement stmntSelect = conn.prepareStatement(query);
		// Asignamos el valor real que tiene ?. 1 Hace referencia a la primera columna.
		stmntSelect.setInt(1, idProtagonista);
		// Se ejecuta la consulta
		ResultSet resultData = stmntSelect.executeQuery();

		ArrayList<Npc> npcs = new ArrayList<>();

		// Mientras haya registros...
		while (resultData.next()) {
			// Relleno los ataques por iteración
			npcs.add(new Npc(resultData.getString("nombre"),
					resultData.getString("frase")));
		}

		stmntSelect.close();

		return npcs;

	}
}
