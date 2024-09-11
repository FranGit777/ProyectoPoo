package org.example.Personajes;

import org.example.Personaje;

public class MagoOscuro extends Personaje {
    public MagoOscuro() {
        super("Mago Oscuro", 70, 25, 10, 0, 0);
    }

    @Override
    public void habilidadEspecial(Personaje objetivo) {
        System.out.println("El Mago Oscuro invoca una tormenta de magia negra!");
        // Implementar habilidad especial
    }
}
