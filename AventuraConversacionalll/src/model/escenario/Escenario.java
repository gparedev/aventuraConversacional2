package model.escenario;

import java.util.Random;

public class Escenario {

	private String nombre;
	private CondicionesAtmosfericas conAtmos;
	private MomentoDelDia momentDia;
	private CondicionesTerreno condTerreno;
	
	private Random rand = new Random();
	
	public Escenario() {
		
	}

	public Escenario(String nombre, CondicionesAtmosfericas conAtmos, MomentoDelDia momentDia,
			CondicionesTerreno condTerreno) {
		this.nombre = nombre;
		this.conAtmos = conAtmos;
		this.momentDia = momentDia;
		this.condTerreno = condTerreno;
	}
	// GETTERS & SETTERS
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public CondicionesAtmosfericas getConAtmos() {
		return conAtmos;
	}

	public void setConAtmos(CondicionesAtmosfericas conAtmos) {
		this.conAtmos = conAtmos;
	}

	public MomentoDelDia getMomentDia() {
		return momentDia;
	}

	public void setMomentDia(MomentoDelDia momentDia) {
		this.momentDia = momentDia;
	}

	public CondicionesTerreno getCondTerreno() {
		return condTerreno;
	}

	public void setCondTerreno(CondicionesTerreno condTerreno) {
		this.condTerreno = condTerreno;
	}
	
	// FUNCIONES

	public int getPenalizacionAtaque() {
		return conAtmos.getPenalizacionAtaque() + momentDia.getPenalizacionAtaque()
				+ condTerreno.getPenalizacionAtaque();
	}

	public int getBonusAtaque() {
		return momentDia.getBonusAtaque();
	}

	public int getPenalizacionDefensa() {
		return condTerreno.getPenalizacionDefensa();
	}
	
	public void setRandomAtmos() {
		int numConAtmos = CondicionesAtmosfericas.values().length;
		int index = rand.nextInt(numConAtmos);
		// Asignamos la condicione atmosferica aleatoria a partir del random obtenido.
		setConAtmos(CondicionesAtmosfericas.values()[index]);
	}
}
