package com.company;

public class KlasaMnozenja extends Thread {
    private Matrica a, b;
    private int vrsta;
    private int[] rezultat;

    public KlasaMnozenja(Matrica a, Matrica b, int i) {
        this.a = a;
        this.b = b;
        vrsta = i;
        rezultat = new int[b.dohvatiVrstu(i).length];
        start();
    }

    @Override
    public void run() {
        for(int i = 0; i < a.dohvatiVrstu(vrsta).length; i++) {
            for(int j = 0; j < b.dohvatiKolonu(vrsta).length; j++) {
                rezultat[i] += a.dohvatiVrstu(vrsta)[j] * b.dohvatiKolonu(i)[j];
            }
        }
    }

    public int[] getRezultat() {
        return rezultat;
    }
}
