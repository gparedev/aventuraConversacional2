package dao;

import java.sql.*;

public class DaoCombatiente {

	private Connection conn = null;
	private static DaoCombatiente instance = null;

	public DaoCombatiente() throws SQLException {

		conn = DbConnection.getConnection();
	}
	
	// Patrón singleton
	public static DaoCombatiente getInstance() throws SQLException {
		if (instance == null) {
			instance = new DaoCombatiente();
		}
		return instance;
	}

	public String selectAttack() throws SQLException {

		String selectAllData = "SELECT ataque_debil FROM ataques_jugador";

		Statement statementSelect = conn.createStatement();

		ResultSet resultData = statementSelect.executeQuery(selectAllData);
		
		String nombreAtaque = "";

		int countData = 0;

		// Mientras haya algun valor en resultData seguirá iterando
		while (resultData.next()) {

			nombreAtaque = resultData.getString("ataque_debil");

			countData++;
		}
		
		statementSelect.close();
		
		return nombreAtaque;

	}
}
