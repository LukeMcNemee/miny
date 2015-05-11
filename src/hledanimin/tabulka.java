/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hledanimin;

import java.util.List;
import java.util.Random;

/**
 *
 * @author xminks
 */
public class tabulka {

    private int miny = 0;
    private int x = 0;
    private int y = 0;
    private int[][] tab;

    public tabulka(int x, int y, int miny) {
        this.x = x;
        this.y = y;
        this.miny = miny;

        Random rnd = new Random();

        tab = new int[x][y];

        for (int q = 0; q < x; q++) {
            for (int g = 0; g < y; g++) {

                tab[q][g] = 0;

            }
        }
        int pocet = 0;
        while (miny > 0) {
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    pocet++;
                    if (tab[i][j] == 0 && rnd.nextInt(50) <= 5) {

                        tab[i][j] = 1;
                        miny--;

                    }
                    if (miny == 0) {
                        break;
                    }
                }
            }
        }
        System.out.println("pocet = "+ pocet);
    }

    public int[][] getTab() {
        return tab;
    }

}
