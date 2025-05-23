package dao;

import java.sql.*;
import java.util.Scanner;

public class DaoUsuario {

	private final Scanner sc = new Scanner(System.in);
	private final Connection conn;
	private static DaoUsuario instance;

	public DaoUsuario() throws SQLException {
		conn = DbConnection.getConnection();
	}

	public static DaoUsuario getInstance() throws SQLException {
		if (instance == null) {
			instance = new DaoUsuario();
		}
		return instance;
	}

	// login o registro
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
			registro(nombre, contrasena);
		}
	}

	// comprobar si nombre de usuario está disponible
	public boolean nombreDisponible(String nombreIn) throws SQLException {
		String query = "SELECT * FROM usuario WHERE nombre_usuario = ? LIMIT 1";
		PreparedStatement statement = conn.prepareStatement(query);
		statement.setString(1, nombreIn);
		ResultSet rSet = statement.executeQuery();
		boolean disponible = !rSet.next();
		// - rSet.next() devuelve true si hay resultados, false si no
		// - entonces: disponible = !rSet.next()
		// login:
		// - si devuelve filas, hay un usuario con ese nombre: !true = false
		// registro:
		// - si no devuelve filas, no hay un usuario con ese nombre: !false = true
		rSet.close();
		statement.close();
		return disponible;
	}

	// *** USUARIOS EXISTENTES ***

	// login
	private void login(String nombreIn) throws SQLException {
		String contrasenaExistenteDeUsuario = obtenerContrasena(nombreIn);

		if (contrasenaExistenteDeUsuario == null) {
			System.out.println("Error: no se encontró el usuario en la base de datos.");
			return;
		}

		System.out.println("Bienvenido, " + nombreIn + ". Introduce tu contraseña:");
		String contrasenaIn = sc.nextLine();

		while (!contrasenaExistenteDeUsuario.equals(contrasenaIn)) {
			System.out.println("Contraseña incorrecta. Inténtalo de nuevo:");
			contrasenaIn = sc.nextLine();
		}

		System.out.println("¡Bienvenido de nuevo, " + nombreIn + "!");
	}

	// obtener contraseña de un usuario existente que está haciendo login
	private String obtenerContrasena(String nombreIn) throws SQLException {
		String query = "SELECT contrasena_usuario FROM usuario WHERE nombre_usuario = ?";
		PreparedStatement statement = conn.prepareStatement(query);
		statement.setString(1, nombreIn);
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

	// crear nuevo usuario en base de datos
	public void registro(String usuarioIn, String contrasenaIn) throws SQLException {
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

	// *** PUNTUACIONES ***
	// puntuacion de un usuario en concreto
	public void puntuacionJugador(String nombreIn) throws SQLException {
		String nombreUsuario = nombreIn.trim();
		String query = "SELECT puntuacion_total_usuario FROM usuario WHERE nombre_usuario = ?";
		PreparedStatement statement = conn.prepareStatement(query);
		statement.setString(1, nombreUsuario);
		ResultSet rSet = statement.executeQuery();

		int puntuacion = 0;
		if (rSet.next()) {
			puntuacion = rSet.getInt("puntuacion_total_usuario");
		}

		System.out.println("Puntuación de " + nombreIn + ": " + puntuacion);

		rSet.close();
		statement.close();
	}

	// top 3
	public void top3() throws SQLException {
		String query = "SELECT nombre_usuario, puntuacion_total_usuario FROM usuario ORDER BY puntuacion_total_usuario DESC LIMIT 3";
		PreparedStatement statement = conn.prepareStatement(query);
		ResultSet rSet = statement.executeQuery();

		System.out.println("\nTOP 3 HISTÓRICO:");
		int contador = 1;
		while (rSet.next()) {
			String nombre = rSet.getString("nombre_usuario");
			int puntuacion = rSet.getInt("puntuacion_total_usuario");
			System.out.println(contador + ". " + nombre + ": " + puntuacion + " pts");
			contador++;
		}

		rSet.close();
		statement.close();
	}

	// jugador con mayor puntuación

}
