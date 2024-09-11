package org.example.Personajes;

import org.example.Personaje;

public class Golem extends Personaje {
    public Golem() {
        super("Golem", 150, 25, 10, 0, 0);
    }

    @Override
    public void habilidadEspecial(Personaje objetivo) {
        System.out.println("El Golem lanza una piedra masiva!");
        // Implementar habilidad especial
    }
}

