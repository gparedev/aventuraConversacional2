package dao;

import java.sql.*;
import java.util.Scanner;

public class DaoLogin {

	private final Scanner sc = new Scanner(System.in);
	private final Connection conn;
	private static DaoLogin instance;

	public DaoLogin() throws SQLException {
		conn = DbConnection.getConnection();
	}

	public static DaoLogin getInstance() throws SQLException {
		if (instance == null) {
			instance = new DaoLogin();
		}
		return instance;
	}

	public void inicioDeSesionORegistro() throws SQLException {
		System.out.println("Introduce tu nombre de usuario:");
		String nombre = sc.nextLine().trim(); // trim() borra espacios de inicio y final del string
		if (!nombreDisponible(nombre)) {
			// el usuario existe, hacer login
			login(nombre);
		} else {
			// el usuario no existe, crear cuenta
			System.out.println("Usuario no encontrado.");
			String contrasena = crearContrasena();
			crearUsuario(nombre, contrasena);
		}
	}

	// *** USUARIOS EXISTENTES ***

	// login: verifica contraseña
	private void login(String usuarioIn) throws SQLException {
		String contrasenaExistenteDeUsuario = obtenerContrasena(usuarioIn);

		if (contrasenaExistenteDeUsuario == null) {
			System.out.println("Error: no se encontró el usuario en la base de datos.");
			return;
		}

		System.out.println("Bienvenido, " + usuarioIn + ". Introduce tu contraseña:");
		String contrasenaIn = sc.nextLine();

		while (!contrasenaExistenteDeUsuario.equals(contrasenaIn)) {
			System.out.println("Contraseña incorrecta. Inténtalo de nuevo:");
			contrasenaIn = sc.nextLine();
		}

		System.out.println("¡Bienvenido de nuevo, " + usuarioIn + "!");
	}

	// obtener contraseña de un usuario existente
	private String obtenerContrasena(String usuarioIn) throws SQLException {
		String query = "SELECT contrasena_usuario FROM usuario WHERE nombre_usuario = ?";
		PreparedStatement statement = conn.prepareStatement(query);
		statement.setString(1, usuarioIn);
		ResultSet rSet = statement.executeQuery();

		String contrasena = null;
		if (rSet.next()) {
			contrasena = rSet.getString("contrasena_usuario");
		}

		rSet.close();
		statement.close();
		return contrasena;
	}

	// *** USUARIOS NUEVOS ***

	// comprobar si nombre de usuario está disponible
	public boolean nombreDisponible(String usuarioIn) throws SQLException {
		String query = "SELECT * FROM usuario WHERE nombre_usuario = ? LIMIT 1";
		PreparedStatement statement = conn.prepareStatement(query);
		statement.setString(1, usuarioIn);
		ResultSet rSet = statement.executeQuery();
		boolean disponible = !rSet.next(); // true si no hay resultados
		rSet.close();
		statement.close();
		return disponible;
	}

	// crear nuevo usuario en base de datos
	public void crearUsuario(String usuarioIn, String contrasenaIn) throws SQLException {
		String insertUsuario = "INSERT INTO usuario (nombre_usuario, contrasena_usuario) VALUES (?, ?)";
		PreparedStatement statement = conn.prepareStatement(insertUsuario);
		statement.setString(1, usuarioIn);
		statement.setString(2, contrasenaIn);

		int filas = statement.executeUpdate();

		if (filas > 0) {
			System.out.println("Usuario creado correctamente.");
		} else {
			System.out.println("Error: no se pudo crear el usuario.");
		}

		statement.close();
	}

	// solicitar al usuario que introduzca dos veces su contraseña (solo nuevos
	// usuarios)
	public String crearContrasena() {
		String contrasena, contrasena2;

		do {
			System.out.println("Crea una contraseña:");
			contrasena = sc.nextLine();
			System.out.println("Repite la contraseña:");
			contrasena2 = sc.nextLine();

			if (!contrasena.equals(contrasena2)) {
				System.out.println("Las contraseñas no coinciden. Intenta de nuevo.");
			}
		} while (!contrasena.equals(contrasena2));

		return contrasena;
	}
}
