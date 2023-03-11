package com.company;

import java.util.Scanner;

public class Matrica implements Cloneable {
    private int m, n;
    private int[][] mat;

    public Matrica(int m, int n) {
        this.m = m;
        this.n = n;
        mat = new int[this.m][this.n];
    }

    public Matrica(Matrica matrica) {
        m = matrica.m;
        n = matrica.n;
        mat = new int[m][n];
        for(int i = 0; i < mat.length; i++) {
            for(int j = 0; j < mat[i].length; j++) {
                mat[i][j] = matrica.mat[i][j];
            }
        }
    }

    public Matrica clone() {
        try {
            Matrica clone = (Matrica) super.clone();
        } catch(CloneNotSupportedException ex) {
            System.err.println(ex);
        }
        return this;
    }

    public void upisi() {
        Scanner scan = new Scanner(System.in);
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                this.mat[i][j] = scan.nextInt();
            }
        }
    }

    public int[] dohvatiVrstu(int i) {
        return this.mat[i];
    }

    public int[] dohvatiKolonu(int br) {
        int[] kolona = new int[m];
        for(int i = 0; i < kolona.length; i++) {
            kolona[i] = this.mat[i][br];
        }
        return kolona;
    }

    public int[][] saberi(Matrica matrica) throws Greska {
        int[][] rezultat = new int[this.m][this.n];
        if (this.m != matrica.m || this.n != matrica.n) {
            throw new Greska("Dimenzije nisu jednake");
        } else {
            for(int i = 0; i < mat.length; i++) {
                for(int j = 0; j < mat[i].length; j++) {
                    rezultat[i][j] = this.mat[i][j] + matrica.mat[i][j];
                }
            }
        }
        return rezultat;
    }

    public Matrica zbir(Matrica a, Matrica b) throws Greska {
        Matrica c = new Matrica(a.m, b.n);
        if (c.m != a.m || c.n != b.n) {
            throw new Greska("Dimenzije nisu jednake");
        } else {
            for(int i = 0; i < mat.length; i++) {
                for(int j = 0; j < mat[i].length; j++) {
                    c.mat[i][j] = a.mat[i][j] + b.mat[i][j];
                }
            }
            return c;
        }
    }

    public Matrica konkurentniZbir(Matrica a, Matrica b) {
        Matrica c = new Matrica(this);
        Sabirac[] niti = new Sabirac[m];
        for(int i = 0; i < niti.length; i++) {
            niti[i] = new Sabirac(a, b, i);
        }
        for (int i = 0; i < niti.length; i++) {
            try {
                niti[i].join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            c.mat[i] = niti[i].getRezultat();
        }
        return c;
    }

    public static Matrica pomnozi(Matrica a, Matrica b) {
        Matrica c = new Matrica(a.m, b.n);
        for(int i = 0; i < a.m; i++) {
            for(int j = 0; j < b.n; j++) {
                for(int k = 0; k < a.n; k++) {
                    c.mat[i][j] += a.mat[i][k] * b.mat[k][j];
                }
            }
        }
        return c;
    }

    public Matrica konkurentniProizvod(Matrica a, Matrica b) {
        Matrica c = new Matrica(a.m, b.n);
        KlasaMnozenja[][] niti = new KlasaMnozenja[a.m][b.n];
        for(int i = 0; i < niti.length; i++) {
            for(int j = 0; j < niti[i].length; j++) {
                niti[i][j] = new KlasaMnozenja(a, b, i, j);
            }
        }
        for(int i = 0; i < niti.length; i++) {
            for(int j = 0; j < niti[i].length; j++) {
                try {
                    niti[i][j].join();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                c.mat[i][j] = niti[i][j].getRezultat();
            }
        }
        return c;
    }

    @Override
    public String toString() {
        String s = "";
        for(int i = 0; i < mat.length; i++) {
            for(int j = 0; j < mat[i].length; j++) {
                s += this.mat[i][j] + "\t";
            }
            s += "\n";
        }
        return s;
    }
}
