package jugador;

import inventario.Arma;
import inventario.Objeto;
import java.util.ArrayList;

public abstract class Personaje {

    public String nombre;
    protected int vida;
    protected int mana;
    protected ArrayList<Objeto> inventario = new ArrayList<>();
    protected boolean tieneLlave = false;

    public Personaje(String nombre, int vida, int mana) {
        this.nombre = nombre;
        this.vida = vida;
        this.mana = mana;
    }

    public void usarPocion() throws Exception {
        vida = vida + 25;
        System.out.println("Usas la pocion de vida:  vida actual: " + vida);
    }

    public void usarMana() throws Exception {
        mana = mana + 25;
        System.out.println("Recuperaste tu mana: Mana actual: " + mana);
    }

    public void usarLlave() throws Exception {
        tieneLlave = true;
        throw new Exception("Equipaste la llave ya puedes abrir las zonas restringuidas");
    }

    public void mostrarEstado() {
        System.out.println("Nombre: " + nombre);
        System.out.println("cantidad_De_Vida: " + vida);
        System.out.println("cantidad_De_Mana: " + mana);
        System.out.println("Objetos en inventario: " + inventario.size());
        System.out.println("Tiene Llave: " + (tieneLlave ? "Si" : "No"));
    }

    public void agregarObjeto(Objeto objeto) {
        inventario.add(objeto);
        System.out.println("El personaje " + nombre + " Agrego " + objeto.getNombre() + " al inventario.");
    }

    public void realizarAtaque() throws Exception {
        if (mana < 10) {
            throw new Exception("No tienes suficiente mana para atacar");
        }
        mana = mana - 10;
        int daño = calcularDañoBase();
        for (Objeto obj : inventario) {
            if (obj instanceof Arma) {
                daño += 10;
            }
        }
        System.out.println("El personaje" + nombre + " Ataca causando " + daño + " de daño");
    }

    public ArrayList<Objeto> getInventario() {
        return inventario;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean tieneLlave() {
        return tieneLlave;
    }

    public abstract int calcularDañoBase();
}