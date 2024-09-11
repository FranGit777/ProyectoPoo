package org.example.Personajes;

import org.example.Personaje;

public class Goblin extends Personaje {
    public Goblin() {
        super("Goblin", 50, 10, 5, 0, 0);
    }

    @Override
    public void habilidadEspecial(Personaje objetivo) {
        System.out.println("El Goblin realiza un ataque furtivo!");
        // Implementar habilidad especial
    }
}

