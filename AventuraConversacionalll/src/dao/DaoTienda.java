package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import model.Tienda;
import model.personajes.Ataque;

public class DaoTienda {

	Scanner sc = new Scanner(System.in);

	private Connection conn = null;
	private static DaoTienda instance = null;

	public DaoTienda() throws SQLException {
		conn = DbConnection.getConnection();
	}

	// Patrón singleton
	public static DaoTienda getInstance() throws SQLException {
		if (instance == null) {
			instance = new DaoTienda();
		}
		return instance;
	}

	public Tienda obtenerTienda(int idProtagonista) throws SQLException {
		String query = "SELECT vendedor, nombre1, precio1, mejora1, nombre2, precio2, mejora2, nombre3, precio3, mejora3  FROM tienda "
				+ "WHERE id_protagonista = ?";

		PreparedStatement stmntSelect = conn.prepareStatement(query);
		stmntSelect.setInt(1, idProtagonista);
		// Se ejecuta la consulta
		ResultSet resultData = stmntSelect.executeQuery();

		Tienda tienda = null;

		while (resultData.next()) {
			// Relleno los ataques por iteración
			tienda = new Tienda(resultData.getString("vendedor"), resultData.getString("nombre1"),
					resultData.getInt("precio1"), resultData.getInt("mejora1"), resultData.getString("nombre2"),
					resultData.getInt("precio2"), resultData.getInt("mejora2"), resultData.getString("nombre3"),
					resultData.getInt("precio3"), resultData.getInt("mejora3"));
		}

		stmntSelect.close();

		return tienda;

	}

	public void mostrarArticulos() throws SQLException {
		String query = "SELECT * FROM tienda";
		PreparedStatement statement = conn.prepareStatement(query);
		ResultSet rSet = statement.executeQuery();

		System.out.println("\nTIENDA:");
		while (rSet.next()) {
			String articulo1 = rSet.getString("nombre1");
			int precio1 = rSet.getInt("precio1");
			int mejora1 = rSet.getInt("mejora1");
			String articulo2 = rSet.getString("nombre2");
			int precio2 = rSet.getInt("precio2");
			int mejora2 = rSet.getInt("mejora2");
			String articulo3 = rSet.getString("nombre3");
			int precio3 = rSet.getInt("precio3");
			int mejora3 = rSet.getInt("mejora3");

			System.out.println(articulo1 + ". " + precio1 + "monedas, " + mejora1 + " puntos de mejora.");
			System.out.println(articulo2 + ". " + precio2 + "monedas, " + mejora2 + " puntos de mejora.");
			System.out.println(articulo3 + ". " + precio3 + "monedas, " + mejora3 + " puntos de mejora.");
		}

		rSet.close();
		statement.close();
	}

	

}
