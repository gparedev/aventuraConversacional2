package model.escenario;

public enum CondicionesTerreno {
	LLANO(0, 0),
	ROCOSO(1, 1),
	MONTANIOSO(2, 2);

	private final int penalizacionAtaque;
	private final int penalizacionDefensa;

	CondicionesTerreno(int penalizacionAtaque, int penalizacionDefensa) {
		this.penalizacionAtaque = penalizacionAtaque;
		this.penalizacionDefensa = penalizacionDefensa;
	}

	public int getPenalizacionAtaque() {
		return penalizacionAtaque;
	}

	public int getPenalizacionDefensa() {
		return penalizacionDefensa;
	}
}
