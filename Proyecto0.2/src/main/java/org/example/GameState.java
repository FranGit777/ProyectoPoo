package org.example;

import java.util.ArrayList;
import java.util.List;

public class GameState {
    private List<Personaje> personajes;
    private int turnoActual;

    public GameState() {
        this.personajes = new ArrayList<>();
        this.turnoActual = 0;
    }

    // Método para agregar personajes al juego
    public void agregarPersonaje(Personaje personaje) {
        personajes.add(personaje);
    }

    // Método para obtener el personaje actual (en este caso, el único jugador)
    public Personaje getPersonajeActual() {
        return personajes.get(0);
    }

    // Método para pasar al siguiente turno
    public void siguienteTurno() {
        if (personajes.isEmpty()) {
            System.out.println("No hay personajes en el juego.");
            return;
        }

        // Obtener el personaje cuyo turno es el actual
        Personaje personaje = personajes.get(turnoActual % personajes.size());
        System.out.println("Es el turno de: " + personaje.getNombre());

        // Regenerar mana para todos los personajes
        for (Personaje p : personajes) {
            p.regenerarMana();
        }

        // Pasar al siguiente turno
        turnoActual++;
    }

    // Método para mostrar el estado actual de todos los personajes
    public void mostrarEstado() {
        if (personajes.isEmpty()) {
            System.out.println("No hay personajes en el juego.");
            return;
        }

        System.out.println("Estado actual del juego:");
        for (Personaje p : personajes) {
            System.out.println(p);
        }
    }

    public void removerPersonaje(Personaje personaje) {
        personajes.remove(personaje);
    }

    @Override
    public String toString() {
        return "Estado del juego:\n" + personajes.toString();
    }
}


