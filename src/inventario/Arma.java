package inventario;

import jugador.Personaje;

public class Arma implements Objeto {
    private String nombre;

    public Arma(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void usar(Personaje personaje) {
        System.out.println("El Jugador " + personaje.getNombre() + " equipo el arma: " + nombre);
    }

    @Override
    public String getNombre() {
        return nombre;
    }
}