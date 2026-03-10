package inventario;

import jugador.Personaje;

public class Llave implements Objeto {

    private String nombre;

    public Llave(String nombre) {
        this.nombre = nombre;
    }

    public void usar(Personaje personaje) {
        try {
            personaje.usarLlave();
        } catch (Exception e) {
            System.out.println(" " + e.getMessage());
        }
    }

    public String getNombre() {
        return nombre;
    }
}
