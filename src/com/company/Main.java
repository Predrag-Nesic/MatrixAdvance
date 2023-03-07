package com.company;

public class Main {
    public static void main(String[] args) throws Greska {
        Matrica matrica = new Matrica(2, 2);
        System.out.println(matrica);
        System.out.println("Upisi vrednosti");
        matrica.upisi();
        System.out.println("Nova Matrica");
        Matrica matrica1 = new Matrica(matrica);
        System.out.println(matrica1);
        System.out.println("Klon Matrica");
        Matrica matrica2 = matrica.clone();
        System.out.println(matrica2);

        System.out.println("Zbir1:");
        Matrica matrica3 = new Matrica(2, 2);
        System.out.println(matrica3.zbir(matrica, matrica1));


        System.out.println("Zbir2:");
        int[][] matrica4 = matrica.saberi(matrica2);
        for(int i = 0; i < matrica4.length; i++) {
            for(int j = 0; j < matrica4[i].length; j++) {
                System.out.print(matrica4[i][j] + "  ");
            }
            System.out.println();
        }

        System.out.println("Konkurentni zbir");
        Matrica c = new Matrica(2, 2);
        System.out.println(c.konkurentniZbir(matrica, matrica1));

        System.out.println("Unesi prvu matricu:");
        Matrica d = new Matrica(2, 4);
        d.upisi();
        System.out.println("Unesi drugu matricu:");
        Matrica e = new Matrica(4, 2);
        e.upisi();

        Matrica f = Matrica.pomnozi(d, e);
        System.out.println(f);

//        System.out.println("Konkurentni proizvod:");
//        Matrica g = new Matrica(2, 2);
//        System.out.println(g.konkurentniProizvod(d, e));

    }
}