/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hledanimin;

import java.util.Random;

/**
 *
 * @author xminks
 */
public class Tabulka {

    private int miny = 0;
    private int x = 0;
    private int y = 0;
    private int[][] tab;
    int souradniceX = 10;
    int souradniceY = 10;

    public Tabulka(int x, int y, int miny) {
        this.x = x;
        this.y = y;
        this.miny = miny;

        Random rnd = new Random();

        tab = new int[x][y];

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {

                tab[i][j] = 0;

                if (i == 0) {
                    tab[i][j] = souradniceX;
                    souradniceX++;

                }
                if (j == 0) {
                    tab[i][j] = souradniceY;
                    souradniceY++;

                }

            }
        }

        while (miny > 0) {
            for (int i = 1; i < x - 1; i++) {
                for (int j = 1; j < y - 1; j++) {

                    if (tab[i][j] == 0 && rnd.nextInt(50) <= 1) {

                        tab[i][j] = 9;
                        miny--;

                    }

                }
            }
        }

        int cislo = 0;

        for (int i = 1; i < x - 1; i++) {
            for (int j = 1; j < y - 1; j++) {

                if (tab[i][j] == 0) {

                    for (int q = -1; q < 2; q++) {
                        for (int g = -1; g < 2; g++) {

                            if (tab[i + q][j + g] == 9) {
                                cislo++;
                            }
                        }

                    }
                    tab[i][j] = cislo;
                    cislo = 0;
                }

            }

        }

        for (int i = 1; i < x - 1; i++) {
            for (int j = 1; j < y - 1; j++) {

                tab[i][j] = tab[i][j] + 1000;

            }
        }
    }

    public int[][] getTab() {
        return tab;
    }

}
