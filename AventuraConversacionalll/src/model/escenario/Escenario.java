package model.escenario;

import java.sql.SQLException;

import dao.DaoCondicionAtmosferica;
import dao.DaoCondicionTerreno;
import dao.DaoMomentoDelDia;

public class Escenario {
	private String nombre;
	private CondicionAtmosferica ca;
	private CondicionTerreno ct;
	private MomentoDelDia md;

	private int penalizacionAtaque;
	private int penalizacionDefensa;
	private int bonusAtaque;

	// Cuando queramos crear un escenario solo tenemos que darle un nombre.
	public Escenario(String nombre) throws SQLException {
		this.nombre = nombre;
		setCa(DaoCondicionAtmosferica.getInstance().obtenerAleatorio());
		setCt(DaoCondicionTerreno.getInstance().obtenerAleatorio());
		setMd(DaoMomentoDelDia.getInstance().obtenerAleatorio());
		
		setPenalizacionAtaque(ca.getPenalizacionAtaque() + ct.getPenalizacionAtaque());
		setPenalizacionDefensa(ct.getPenalizacionDefensa() + md.getPenalizacionDefensa());
		setBonusAtaque(md.getBonusAtaque());
		
	}

	public Escenario(String nombre, CondicionAtmosferica ca, CondicionTerreno ct, MomentoDelDia md) {
		this.nombre = nombre;
		this.ca = ca;
		this.ct = ct;
		this.md = md;
	}

	public int getPenalizacionAtaque() {
		return penalizacionAtaque;
	}

	public int getPenalizacionDefensa() {
		return penalizacionDefensa;
	}

	public int getBonusAtaque() {
		return bonusAtaque;
	}

	public void setPenalizacionAtaque(int penalizacionAtaque) {
		this.penalizacionAtaque = penalizacionAtaque;
	}

	public void setPenalizacionDefensa(int penalizacionDefensa) {
		this.penalizacionDefensa = penalizacionDefensa;
	}

	public void setBonusAtaque(int bonusAtaque) {
		this.bonusAtaque = bonusAtaque;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public CondicionAtmosferica getCa() {
		return ca;
	}

	public void setCa(CondicionAtmosferica ca) {
		this.ca = ca;
	}

	public CondicionTerreno getCt() {
		return ct;
	}

	public void setCt(CondicionTerreno ct) {
		this.ct = ct;
	}

	public MomentoDelDia getMd() {
		return md;
	}

	public void setMd(MomentoDelDia md) {
		this.md = md;
	}
	
	public void imprimirCondiciones() {
		System.out.println("Momento del dia: " + md.getNombre() + "\n"
				+ "Condición atmosférica: " + ca.getNombre() + "\n"
				+ "Terreno: " + ct.getNombre() + "\n");
	}
	
	public void imprimirInfo() {
		imprimirCondiciones();
		
		System.out.println("Nombre: " + getNombre() + "\n"
				+ "Penalización Ataque: " + getPenalizacionAtaque() + "\n"
				+ "Penalización Defensa: " + getPenalizacionDefensa() + "\n"
				+ "Penalización Bonus Ataque: " + getBonusAtaque() + "\n");
	}

}
