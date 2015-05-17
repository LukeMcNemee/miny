/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hledanimin;

/**
 *
 * @author AMD
 */
public class vypis {

    private int[][] tab;
    private int x;
    private int y;
    private int a;
    private int b;

    public vypis(int tab[][], int x, int y, int a, int b) {

        this.tab = tab;
        this.x = x;
        this.y = y;
        this.a = a;
        this.b = b;

        tab[b][a] = tab[b][a] - 1000;

        for (int i = 1; i < x - 1; i++) {
            for (int j = 1; j < y - 1; j++) {

                if (tab[i][j]  < 500) {
                    if (tab[i][j] == 9) {
                        System.out.print("M ");
                    } else {

                        System.out.print(tab[i][j] + " ");
                    }
                }else{
            System.out.print("X ");
                }
                }
            System.out.println();
        }

    }

    public int[][] getTab() {
        return tab;
    }

}
