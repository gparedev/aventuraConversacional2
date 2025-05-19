package model;

public abstract class Combatiente extends Personaje {

	private int vida;
	private int vidaMax;
	private int ataque;
	private int defensa;
	
	private int pocionAtaque;
	private int pocionVida;
	private boolean pocionAtaqueUsada = false;
	private boolean pocionVidaUsada = false;
	
	private final int VALOR_POCIONES = 25;
	
	public Combatiente(String nombre, int vidaMax, int ataque, int pocionVida, int pocionAtaque) {
		super(nombre);
		this.vidaMax = vidaMax;
		this.vida = vidaMax;
		this.ataque = ataque;
		this.pocionVida = pocionVida;
		this.pocionAtaque = pocionAtaque;
	}
	
	//	POCIONES
	
	public void usarPocionVida() {
		int valorCura;
		// Si no he usado la poción y tengo 1 o más...
		if(!pocionVidaUsada && pocionVida > 0) {
			if(vida + VALOR_POCIONES >= vidaMax) {
				valorCura = vidaMax - vida;
				vida = vidaMax;
			} else {
				vida += VALOR_POCIONES;
				valorCura = VALOR_POCIONES;
			}
			
			imprimirCura(valorCura);
		} else {
			// Metodos de checkear el error o bien lo ha usado o bien no tiene curas...
		}
	}
	
	public void imprimirCura(int valorCura) {
		System.out.println(getNombre() + " usó poción de vida y restaura " + valorCura + " puntos de salud!\n"
				+ "Vida actual: " + vida);
	}

}
