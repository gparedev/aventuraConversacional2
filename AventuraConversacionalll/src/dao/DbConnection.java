package dao;

import java.sql.*;
import java.util.Properties;

public class DbConnection {

	public static Connection instance = null;

	public static final String JDB_BDD_URL = "jdbc:mysql://localhost:3306/aventura_conversacional";

	public static Connection getConnection() throws SQLException {

		if (instance == null) {

			Properties props = new Properties();
			// Clave - valor (El valor de user es root y de password cursoSQL...
			// [Valor:Clave])
			props.put("user", "root");
			props.put("password", "cursoSQL");

			instance = DriverManager.getConnection(JDB_BDD_URL, props);
		}

		return instance;
	}
}
