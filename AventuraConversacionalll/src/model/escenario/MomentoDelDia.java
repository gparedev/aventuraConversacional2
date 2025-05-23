package model.escenario;

public enum MomentoDelDia {
	MANIANA(0, 0),
	TARDE(0, 0),
	NOCHE(1, 2);

	private final int penalizacionAtaque;
	private final int bonusAtaque;

	MomentoDelDia(int penalizacionAtaque, int bonusAtaque) {
		this.penalizacionAtaque = penalizacionAtaque;
		this.bonusAtaque = bonusAtaque;
	}

	public int getPenalizacionAtaque() {
		return penalizacionAtaque;
	}

	public int getBonusAtaque() {
		return bonusAtaque;
	}
	
	
}
