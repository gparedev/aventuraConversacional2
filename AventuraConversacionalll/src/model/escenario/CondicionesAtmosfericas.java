package model.escenario;

public enum CondicionesAtmosfericas {
    DESPEJADO(0),
    NUBOSO(0),
    LLUVIA(1),
    NIEVE(2);

    private final int penalizacionAtaque;

    // Constructor
    CondicionesAtmosfericas(int penalizacionAtaque) {
        this.penalizacionAtaque = penalizacionAtaque;
    }

    // Getter
    public int getPenalizacionAtaque() {
        return penalizacionAtaque;
    }
}