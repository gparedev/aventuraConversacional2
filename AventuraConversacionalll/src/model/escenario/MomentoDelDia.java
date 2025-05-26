package model.escenario;

public class MomentoDelDia {
    private String nombre;
    private int penalizacionDefensa;
    private int bonusAtaque;
    
    public MomentoDelDia() {
    	
    }

    public MomentoDelDia(String nombre, int penalizacionDefensa, int bonusAtaque) {
        this.nombre = nombre;
        this.penalizacionDefensa = penalizacionDefensa;
        this.bonusAtaque = bonusAtaque;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPenalizacionDefensa() {
        return penalizacionDefensa;
    }

    public int getBonusAtaque() {
        return bonusAtaque;
    }
}
