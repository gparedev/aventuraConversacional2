package model.miniJuegos;

public class MiniJuegoStart {
	
	// ATRIBUTOS
	
	private int numJuego = 0;

	// CONSTRUCTORES
	
	public MiniJuegoStart () {
	}

	// GET Y SET

	// FUNCIONES
	
	public void start () {
		if (numJuego == 0) {
		numJuego = (int)(Math.random() * 5 +1);
		} else {
		numJuego ++;
		}
		if (numJuego > 5) {
		numJuego = 1;
		}

		this.startJuego(numJuego);
	}
	
	private void startJuego(int numJuego) {
		switch (numJuego){
		case 1:
			Juego1 juego1 = new Juego1();
			juego1.juego1Start();
			break;
		case 2:
			
			break;
		case 3:
			
			break;
		case 4:
			
			break;
		case 5:
			
			break;
		}
	}

}
