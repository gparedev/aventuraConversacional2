package model.personajes;

public class Protagonista extends Combatiente {
	
	// Atributos propios como abalorios u otras cosas
	private int monedas;
	private int juegosGanados;
	
    public Protagonista(String nombre, int vidaMaxima, int ataque, int pocionVida, int pocionAtaque) {
        super(nombre, vidaMaxima, ataque, pocionVida, pocionAtaque);
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
		System.out.println("Nombre: " + getNombre() + "\n"
				+ "Vida: " + getVida() + "/" + getVidaMax() + "\n"
				+ "Ataque: " + getAtaque() + "\n"
				+ "Defensa: " + getDefensa() + "\n"
				+ "Poción de vida: " + getPocionVida() + "\n"
				+ "Poción de ataque: " + getPocionVida() + "\n"
				+ "Monedas: " + getMonedas() + "\n"
				+ "Juegos Ganados: " + getJuegosGanados() + "\n");
    }
    
}
