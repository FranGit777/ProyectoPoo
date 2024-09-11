package org.example.Personajes;

import org.example.Personaje;

public class Mago extends Personaje {
    public Mago(String nombre) {
        super(nombre, 80, 15, 5, 100, 100); // Mago tiene mana
    }

    @Override
    public void habilidadEspecial(Personaje objetivo) {
        System.out.println(getNombre() + " lanza una bola de fuego!");
        // Implementar habilidad especial
    }
}
