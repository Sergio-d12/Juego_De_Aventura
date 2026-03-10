package principal;

import java.util.Scanner;
import jugador.Personaje;
import jugador.Guerrero;
import jugador.Mago;
import inventario.Objeto;
import inventario.Pocion;
import inventario.Llave;
import inventario.Arma;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Scanner digite = new Scanner(System.in);
        Personaje personaje = null;

        System.out.println("----------- VIDEOJUEGO DE CALABOZOS -----------");
        System.out.println("1. Guerrero");
        System.out.println("2. Mago");
        System.out.print("Elige tu personaje (solo puedes elegir entre estos dos tipos): ");
        try {
            String opcion = digite.nextLine();

            if (opcion.equals("guerrero") || opcion.equals("1")) {
                System.out.println("has elegido: Guerrero");
                System.out.print("Ingresa el nombre de tu personaje: ");
                String nombre = digite.nextLine();
                personaje = new Guerrero(nombre, 100, 100);
            } else if (opcion.equals("mago") || opcion.equals("2")) {
                System.out.println("has elegido: Mago");
                System.out.print("Ingresa el nombre de tu personaje: ");
                String nombre = digite.nextLine();
                personaje = new Mago(nombre, 100, 100);
            } else {
                throw new Exception();
            }

        } catch (Exception e) {
            System.out.println("error solo puedes escribir Guerrero o Mago");
    
            return;
        }

        personaje.agregarObjeto(new Pocion("una Pocion de Vida", 1));
        personaje.agregarObjeto(new Pocion("una Pocion de Mana", 2));
        personaje.agregarObjeto(new Llave("una Llave Dorada"));
        personaje.agregarObjeto(new Arma("un Arma"));

        int opcion;

        do {
            System.out.println("------------ Bienvenido a Calabozos -------------");
            System.out.println("1. Atacar");
            System.out.println("2. Ver estado");
            System.out.println("3. Abrir inventario");
            System.out.println("4. Zona Restringida");
            System.out.println("5. Salir");
            System.out.print("Elige una opcion: ");

            if (digite.hasNextInt()) {
                opcion = digite.nextInt();
                digite.nextLine();

                switch (opcion) {
                    case 1:
                        System.out.println("Atacando");
                        if (personaje != null) {
                            try {
                                personaje.realizarAtaque();
                            } catch (Exception e) {
                                System.out.println("Error: " + e.getMessage());
                            }
                        }
                        break;
                    case 2:
                        System.out.println("Estado del personaje");
                        if (personaje != null) {
                            personaje.mostrarEstado();
                        }
                        break;
                    case 3:
                        System.out.println(" Inventario");
                        System.out.println("Elige algo del inventario:");

                        System.out.println("\n--- INVENTARIO ---");
                        ArrayList<Objeto> listaInventario = personaje.getInventario();
                        for (int i = 0; i < listaInventario.size(); i++) {
                            System.out.println((i + 1) + ". " + listaInventario.get(i).getNombre());
                        }
                        System.out.println("0. Volver al menu principal");
                        System.out.print("Elige un objeto: ");

                        int opcionObjeto = digite.nextInt();
                        digite.nextLine();

                        if (opcionObjeto >= 1 && opcionObjeto <= listaInventario.size()) {
                            Objeto objeto = listaInventario.get(opcionObjeto - 1);
                            objeto.usar(personaje);
                        } else if (opcionObjeto == 0) {
                            System.out.println("Volviendo al menu...");
                        } else {
                            System.out.println("Opcion invalida");
                        }
                        break;
                    case 4:
                        System.out.println("----------ZONA RESTRINGIDA ------------");
                        if (personaje.tieneLlave()) {
                            System.out.println("Acceso concedido Tienes la llave");
                            System.out.println("Has entrado a la zona restringida y encontrado un tesoro");
                        } else {
                            System.out.println("no puedes entrar sin la llave , por favor equipala");
                        }
                        break;
                    case 5:
                        System.out.println("hasta pronto");
                        break;
                    default:
                        System.out.println(" intenta de nuevo");
                }
            } else {
                System.out.println("Por favor ingresa otra opcion");
                digite.nextLine();
                opcion = 0;
            }

        } while (opcion != 5);


    }
}







