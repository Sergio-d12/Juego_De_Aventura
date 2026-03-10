package inventario;

import jugador.Personaje;

public interface Objeto {

    void usar(Personaje personaje);

    String getNombre();
}
