package jugador;

public class Guerrero extends Personaje {
public Guerrero(String nombre, int vida, int mana) {
        super(nombre, vida, mana);
    }

    @Override
    public int calcularDañoBase() {
        return 20;
    }
}
