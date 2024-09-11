package org.example.Personajes;

import org.example.Personaje;

public class Guerrero extends Personaje {
    public Guerrero(String nombre) {
        super(nombre, 150, 20, 10, 10, 50); // Guerrero no usa mana
    }

    @Override
    public void habilidadEspecial(Personaje objetivo) {
        System.out.println(getNombre() + " lanza un golpe devastador!");
        // Implementar habilidad especial
    }
}
