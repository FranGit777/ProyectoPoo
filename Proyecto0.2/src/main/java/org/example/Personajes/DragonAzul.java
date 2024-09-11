package org.example.Personajes;

import org.example.Personaje;

public class DragonAzul extends Personaje {
    public DragonAzul() {
        super("Dragón Azul", 200, 35, 30, 0, 0);
    }

    @Override
    public void habilidadEspecial(Personaje objetivo) {
        System.out.println("El Dragón Azul lanza un aliento congelante!");
        // Implementar habilidad especial
    }
}

