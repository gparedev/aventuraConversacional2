package model;

import java.sql.SQLException;
import java.util.Scanner;

import dao.DaoTienda;
import model.personajes.Protagonista;

public class Tienda {

	Scanner sc = new Scanner(System.in);

	private Protagonista protagonista;

	private String vendedor;
	private String nombre1;
	private int precio1;
	private int mejora1;
	private String nombre2;
	private int precio2;
	private int mejora2;
	private String nombre3;
	private int precio3;
	private int mejora3;

	private boolean comprado1;
	private boolean comprado2;
	private boolean comprado3;

	public Tienda() {
	}

	public Tienda(String vendedor, String nombre1, int precio1, int mejora1, String nombre2, int precio2, int mejora2,
			String nombre3, int precio3, int mejora3) {
		this.vendedor = vendedor;
		this.nombre1 = nombre1;
		this.precio1 = precio1;
		this.mejora1 = mejora1;
		this.nombre2 = nombre2;
		this.precio2 = precio2;
		this.mejora2 = mejora2;
		this.nombre3 = nombre3;
		this.precio3 = precio3;
		this.mejora3 = mejora3;
	}

	public String getVendedor() {
		return vendedor;
	}

	public void setVendedor(String vendedor) {
		this.vendedor = vendedor;
	}

	public String getNombre1() {
		return nombre1;
	}

	public void setNombre1(String nombre1) {
		this.nombre1 = nombre1;
	}

	public int getPrecio1() {
		return precio1;
	}

	public void setPrecio1(int precio1) {
		this.precio1 = precio1;
	}

	public int getMejora1() {
		return mejora1;
	}

	public void setMejora1(int mejora1) {
		this.mejora1 = mejora1;
	}

	public String getNombre2() {
		return nombre2;
	}

	public void setNombre2(String nombre2) {
		this.nombre2 = nombre2;
	}

	public int getPrecio2() {
		return precio2;
	}

	public void setPrecio2(int precio2) {
		this.precio2 = precio2;
	}

	public int getMejora2() {
		return mejora2;
	}

	public void setMejora2(int mejora2) {
		this.mejora2 = mejora2;
	}

	public String getNombre3() {
		return nombre3;
	}

	public void setNombre3(String nombre3) {
		this.nombre3 = nombre3;
	}

	public int getPrecio3() {
		return precio3;
	}

	public void setPrecio3(int precio3) {
		this.precio3 = precio3;
	}

	public int getMejora3() {
		return mejora3;
	}

	public void setMejora3(int mejora3) {
		this.mejora3 = mejora3;
	}

	public Protagonista getProtagonista() {
		return protagonista;
	}

	public void setProtagonista(Protagonista protagonista) {
		this.protagonista = protagonista;
	}

	public void tienda() throws SQLException {
		int comprar = 0;
		do {
			mostrarArticulos();

			do {
				System.out.println("¿Qué artículo deseas comprar?");
				comprar = sc.nextInt();
			} while (comprar > 4 || comprar < 1);
			switch (comprar) {
			case 1:
				if (!comprado1 && precio1 < protagonista.getMonedas()) {
					System.out.println("Has comprado " + nombre1 + " por " + precio1 + " monedas");
					System.out.println("Tu ataque mejorará");
					protagonista.setAtaque(protagonista.getAtaque() + mejora1);
					protagonista.setAtaqueIni(protagonista.getAtaque() + mejora1);
					setNombre1(nombre1 + " (comprado)");
					comprado1 = true;
					protagonista.setMonedas(protagonista.getMonedas() - precio1);
				} else if (!comprado1 && precio1 > protagonista.getMonedas()) {
					System.out.println("No tienes suficiente dinero, probre");
				} else {
					System.out.println("Ya has comprado este artículo");
				}
				;
				break;
			case 2:
				if (!comprado2 && precio2 < protagonista.getMonedas()) {
					System.out.println("Has comprado " + nombre2 + " por " + precio2 + " monedas");
					System.out.println("Tu defensa mejorará");
					protagonista.setDefensa(protagonista.getDefensa() + mejora2);
					protagonista.setDefensaIni(protagonista.getDefensa() + mejora2);
					setNombre2(nombre2 + " (comprado)");
					comprado2 = true;
					protagonista.setMonedas(protagonista.getMonedas() - precio2);
				} else if (!comprado2 && precio2 > protagonista.getMonedas()) {
					System.out.println("No tienes suficiente dinero, probre");
				} else {
					System.out.println("Ya has comprado este artículo");
				}

				break;
			case 3:
				if (!comprado3 && precio3 < protagonista.getMonedas()) {
					System.out.println("Has comprado " + nombre3 + " por " + precio3 + " monedas");
					System.out.println("Tu vida mejorará");
					protagonista.setVidaMax(protagonista.getVidaMax() + mejora3);
					protagonista.setVida(protagonista.getVida() + mejora3);
					setNombre3(nombre3 + " (comprado)");
					comprado3 = true;
					protagonista.setMonedas(protagonista.getMonedas() - precio3);
				} else if (!comprado3 && precio3 > protagonista.getMonedas()) {
					System.out.println("No tienes suficiente dinero, probre");
				} else {
					System.out.println("Ya has comprado este artículo");
				}

				break;

			case 4:
				System.out.println("Saliendo de la tienda...");
				break;

			default:
				break;
			}
		} while (comprar != 4);

	}

	public void mostrarArticulos() {
		System.out.println("Tienes: " + protagonista.getMonedas() + " monedas.");
		System.out.println("╔════════════════════════════════════════════════════════════════════╗");
		System.out.printf("║ Bienvenido a la tienda de: %-36s ║\n", vendedor);
		System.out.println("╠════╦════════════════════════════════╦════════╦════════════════════╣");
		System.out.printf("║ %-3s║ %-32s ║ %-6s ║ %-18s ║\n", "N.º", "Nombre", "Precio", "Mejora");
		System.out.println("╠════╬════════════════════════════════╬════════╬════════════════════╣");
		System.out.printf("║ %-3d║ %-32s ║ %-6d ║ +%-3d Ataque        ║\n", 1, nombre1, precio1, mejora1);
		System.out.printf("║ %-3d║ %-32s ║ %-6d ║ +%-3d Defensa       ║\n", 2, nombre2, precio2, mejora2);
		System.out.printf("║ %-3d║ %-32s ║ %-6d ║ +%-3d Vida          ║\n", 3, nombre3, precio3, mejora3);
		System.out.println("╚════╩════════════════════════════════╩════════╩════════════════════╝");
		System.out.println("║ 4. Salir de la tienda");
		System.out.println("╚════════════════════════════════════════════════════════════════════╝");
	}

}
