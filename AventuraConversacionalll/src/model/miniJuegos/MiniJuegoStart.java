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
			juego1.juegoStart();
			break;
		case 2:
			Juego2 juego2 = new Juego2();
			juego2.juegoStart();
			break;
		case 3:
			Juego3 juego3 = new Juego3();
			juego3.juegoStart();
			break;
		case 4:
			Juego4 juego4 = new Juego4();
			juego4.juegoStart();
			break;
		case 5:
			Juego5 juego5 = new Juego5();
			juego5.juegoStart();
			break;
		}
	}

}
