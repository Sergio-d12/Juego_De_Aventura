package jugador;

public class Mago extends Personaje {

    public Mago(String nombre, int vida, int mana) {
        super(nombre, vida, mana);
    }

    @Override
    public int calcularDañoBase() {
        return 30;
    }
}

