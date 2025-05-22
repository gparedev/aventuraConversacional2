package dao;

import java.sql.*;
import java.util.Properties;

public class DbConnection {

	public static Connection instance = null;

	public static Connection getConnection() throws SQLException {

		try {

			if (instance == null) {

				String url = "jdbc:mysql://localhost:3306/aventuraconversacionalll";
				String usuario = "root";
				String contrasena = "";

				instance = DriverManager.getConnection(url, usuario, contrasena);

			}

		} catch (SQLException e) {
			System.out.println("No se pudo conectar a la base de datos.");
			e.printStackTrace();
		}
		return instance;

	}

}