package inventario;

import jugador.Personaje;

public class Pocion implements Objeto {
    private String nombre;
    private int tipo;

    public Pocion(String nombre, int tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
    }

public void usar(Personaje personaje) {
    if (tipo == 1) {
        try {
            personaje.usarPocion();
        } catch (Exception ex) {
            System.out.println("Error al usar la poción: " + ex.getMessage());
        }
    } else if (tipo == 2) {
        try {
            personaje.usarMana();
        } catch (Exception ex) {
            System.out.println("Error al usar el mana: " + ex.getMessage());
        }
    }
    }

    @Override
    public String getNombre() {
        return nombre;
    }
}


