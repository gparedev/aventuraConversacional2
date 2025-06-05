package model.personajes;

public class Protagonista extends Combatiente {

	// Atributos propios como abalorios u otras cosas
	private int monedas;
	private int juegosGanados;
	private final int TOTAL_MINIJUEGOS = 5;

	public Protagonista(String nombre, int vidaMaxima, int ataque, int pocionVida, int pocionAtaque) {
		super(nombre, vidaMaxima, ataque, pocionVida, pocionAtaque);
		monedas = 50;
	}

	// Getters & Setters

	public int getMonedas() {
		return monedas;
	}

	public void setMonedas(int monedas) {
		this.monedas = monedas;
	}

	public int getJuegosGanados() {
		return juegosGanados;
	}

	public void setJuegosGanados(int juegosGanados) {
		this.juegosGanados = juegosGanados;
	}

	@Override
	public void imprimirInfo() {
		System.out.println("===== ESTADO DEL PERSONAJE =====");
		System.out.println("Nombre           : " + getNombre());
		System.out.println("Vida             : " + getVida() + " / " + getVidaMax());
		System.out.println("Ataque           : " + getAtaque());
		System.out.println("Defensa          : " + getDefensa());
		System.out.println("Poción de Vida   : " + getPocionVida());
		System.out.println("Poción de Ataque : " + getPocionAtaque());
		System.out.println("Monedas          : " + getMonedas());
		System.out.println("Juegos Ganados   : " + getJuegosGanados() + "/" + TOTAL_MINIJUEGOS);
		System.out.println("================================");
	}

}
