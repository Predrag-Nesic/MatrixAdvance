package com.company;

public class KlasaMnozenja extends Thread {
    private Matrica a, b;
    private int vrsta, kolona;
    private int rezultat;

    public KlasaMnozenja(Matrica a, Matrica b, int vrsta, int kolona) {
        this.a = a;
        this.b = b;
        this.vrsta = vrsta;
        this.kolona = kolona;
        start();
    }

    public void run() {
        for(int i = 0; i < a.dohvatiVrstu(vrsta).length; i++) {
            rezultat += a.dohvatiVrstu(vrsta)[i] * b.dohvatiKolonu(kolona)[i];
        }
    }

    public int getRezultat() {
        return rezultat;
    }
}
