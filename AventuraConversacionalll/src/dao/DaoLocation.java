package dao;

import java.sql.*;
import java.util.ArrayList;

import model.Location;

public class DaoLocation {

	private Connection conn = null;
	private static DaoLocation instance = null;

	public DaoLocation() throws SQLException {

		conn = DbConnection.getConnection();
	}

	// Patrón singleton
	public static DaoLocation getInstance() throws SQLException {
		if (instance == null) {
			instance = new DaoLocation();
		}
		return instance;
	}

	// Devuelve los ataques del protagonista en función del id.
	public ArrayList<Location> generarLocationsProtagonista(int idProtagonista) throws SQLException {
		// Consulta
		String query = "SELECT nombre_location, descripcion FROM location " + "WHERE id_protagonista = ?";

		// Preparamos la consulta con ? para evitar inyecciones de SQL (Seguridad).
		PreparedStatement stmntSelect = conn.prepareStatement(query);
		// Asignamos el valor real que tiene ?. 1 Hace referencia a la primera columna.
		stmntSelect.setInt(1, idProtagonista);
		// Se ejecuta la consulta
		ResultSet resultData = stmntSelect.executeQuery();

		ArrayList<Location> locations = new ArrayList<>();

		// Mientras haya registros...
		while (resultData.next()) {
			// Relleno los ataques por iteración
			locations.add(new Location(resultData.getString("nombre_location"), resultData.getString("descripcion")));
		}

		stmntSelect.close();

		return locations;

	}
}
