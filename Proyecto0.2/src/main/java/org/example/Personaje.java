package org.example;

public abstract class Personaje {
    private String nombre;
    private int salud;
    private int fuerza;
    private int defensa;
    private int mana;
    private int manaMax;
    private int habilidad;

    public Personaje(String nombre, int salud, int fuerza, int defensa, int mana, int habilidad) {
        this.nombre = nombre;
        this.salud = salud;
        this.fuerza = fuerza;
        this.defensa = defensa;
        this.mana = mana;
        this.manaMax = mana;
        this.habilidad = habilidad;
    }

    public String getNombre() {
        return nombre;
    }

    public int getSalud() {
        return salud;
    }

    public int getMana() {
        return mana;
    }

    public void recibirDanio(int danio) {
        this.salud -= danio;
        if (this.salud < 0) this.salud = 0;
    }

    public int atacar(Personaje objetivo) {
        int danio = Math.max(0, this.fuerza - objetivo.defensa);
        objetivo.recibirDanio(danio);
        return danio;
    }

    public boolean usarHabilidadEspecial(Personaje objetivo) {
        if (this.mana >= 10) { // Suponemos que cada habilidad especial cuesta 10 mana
            this.mana -= 10;
            habilidadEspecial(objetivo);
            int danio = Math.max(0, this.habilidad - objetivo.defensa);
            objetivo.recibirDanio(danio);
            return true;
        } else {
            System.out.println("No hay suficiente mana para usar la habilidad especial.");
            return false;
        }
    }

    public abstract void habilidadEspecial(Personaje objetivo);

    public void regenerarMana() {
        this.mana = Math.min(this.mana + 5, this.manaMax); // Regenera 5 mana por turno, máximo hasta manaMax
    }

    @Override
    public String toString() {
        return nombre + " [Salud: " + salud + ", Fuerza: " + fuerza + ", Defensa: " + defensa + ", Mana: " + mana + "]";
    }
}
