package com.company;

public class Sabirac extends Thread {
    private Matrica a, b;
    private int vrsta;
    private int[] rezultat;

    public Sabirac(Matrica a, Matrica b, int i) {
        this.a = a;
        this.b = b;
        vrsta = i;
        rezultat = new int[a.dohvatiVrstu(i).length];
        start();
    }

    @Override
    public void run() {
        for (int i = 0; i < rezultat.length; i++) {
            rezultat[i] = a.dohvatiVrstu(vrsta)[i] + b.dohvatiVrstu(vrsta)[i];
        }
    }

    public int[] getRezultat() {
        return rezultat;
    }

}
