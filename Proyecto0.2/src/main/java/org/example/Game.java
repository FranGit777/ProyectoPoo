package org.example;

import org.example.Personajes.*;

import java.util.Scanner;

public class Game {
    public Game() {
        // Crear una instancia del estado del juego
        Scanner scanner = new Scanner(System.in);

        System.out.println("Elige tu clase:");
        System.out.println("1. Guerrero");
        System.out.println("2. Mago");
        System.out.println("3. Paladín");
        int claseElegida = scanner.nextInt();

        Personaje jugador;
        switch (claseElegida) {
            case 1:
                jugador = new Guerrero("Guerrero");
                break;
            case 2:
                jugador = new Mago("Mago");
                break;
            case 3:
                jugador = new Paladin("Paladín");
                break;
            default:
                System.out.println("Elección no válida. Se asignará Guerrero por defecto.");
                jugador = new Guerrero("Guerrero");
                break;
        }

        // Crear el estado del juego y agregar el jugador
        GameState estado = new GameState();
        estado.agregarPersonaje(jugador);

        // Mostrar el estado inicial
        estado.mostrarEstado();

        // Elegir un camino
        System.out.println("Elige un camino:");
        System.out.println("1. Ir al Bosque");
        System.out.println("2. Ir a las Ruinas");
        int caminoElegido = scanner.nextInt();

        // Crear los enemigos y gestionar la pelea según el camino elegido
        switch (caminoElegido) {
            case 1:
                manejarCaminoBosque(estado);
                break;
            case 2:
                manejarCaminoRuinas(estado);
                break;
            default:
                System.out.println("Elección no válida.");
                break;
        }

        // Mostrar el estado final
        estado.mostrarEstado();
        scanner.close();
    }

    private static void manejarCaminoBosque(GameState estado) {
        System.out.println("Te adentras en el bosque y encuentras un Goblin!");

        Personaje goblin = new Goblin();
        estado.agregarPersonaje(goblin);
        combate(estado, goblin);

        System.out.println("Después de derrotar al Goblin, te enfrentas a un Dragón Azul!");

        Personaje dragon = new DragonAzul();
        estado.agregarPersonaje(dragon);
        combate(estado, dragon);
    }

    private static void manejarCaminoRuinas(GameState estado) {
        System.out.println("Te adentras en las ruinas y encuentras un Golem!");

        Personaje golem = new Golem();
        estado.agregarPersonaje(golem);
        combate(estado, golem);

        System.out.println("Después de derrotar al Golem, te enfrentas a un Mago Oscuro!");

        Personaje magoOscuro = new MagoOscuro();
        estado.agregarPersonaje(magoOscuro);
        combate(estado, magoOscuro);
    }

    private static void combate(GameState estado, Personaje enemigo) {
        Scanner scanner = new Scanner(System.in);
        Personaje jugador = estado.getPersonajeActual();

        while (jugador.getSalud() > 0 && enemigo.getSalud() > 0) {
            System.out.println("Es tu turno. Elige una acción:");
            System.out.println("1. Ataque normal");
            System.out.println("2. Habilidad especial");
            int accion = scanner.nextInt();

            if (accion == 1) {
                int danio = jugador.atacar(enemigo);
                System.out.println("Atacaste a " + enemigo.getNombre() + " y causaste " + danio + " de daño.");
            } else if (accion == 2) {
                if (jugador.usarHabilidadEspecial(enemigo)) {
                    System.out.println("Usaste una habilidad especial en " + enemigo.getNombre());
                } else {
                    System.out.println("No pudiste usar la habilidad especial.");
                }
            } else {
                System.out.println("Acción no válida.");
            }

            if (enemigo.getSalud() > 0) {
                int danioRecibido = enemigo.atacar(jugador);
                System.out.println("El enemigo " + enemigo.getNombre() + " te atacó y causó " + danioRecibido + " de daño.");
            }

            jugador.regenerarMana();
            estado.mostrarEstado();
        }

        if (jugador.getSalud() <= 0) {
            System.out.println("Has sido derrotado. Fin del juego.");
        } else {
            System.out.println("Has derrotado a " + enemigo.getNombre() + "!");
            estado.removerPersonaje(enemigo);
        }
    }

}

