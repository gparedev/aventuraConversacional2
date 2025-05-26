package model.escenario;

public class CondicionTerreno {
    private String nombre;
    private int penalizacionAtaque;
    private int penalizacionDefensa;

    public CondicionTerreno(String nombre, int penalizacionAtaque, int penalizacionDefensa) {
        this.nombre = nombre;
        this.penalizacionAtaque = penalizacionAtaque;
        this.penalizacionDefensa = penalizacionDefensa;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPenalizacionAtaque() {
        return penalizacionAtaque;
    }

    public int getPenalizacionDefensa() {
        return penalizacionDefensa;
    }
}
