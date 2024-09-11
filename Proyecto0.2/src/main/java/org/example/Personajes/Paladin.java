package org.example.Personajes;

import org.example.Personaje;

public class Paladin extends Personaje {
    public Paladin(String nombre) {
        super(nombre, 120, 18, 15, 30, 25); // Paladín tiene mana
    }

    @Override
    public void habilidadEspecial(Personaje objetivo) {
        System.out.println(getNombre() + " invoca una bendición!");
        // Implementar habilidad especial
    }
}

