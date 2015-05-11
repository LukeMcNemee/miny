/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hledanimin;

/**
 *
 * @author xminks
 */
public class Hledanimin {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int x = 5;
        int y = 5;
        int miny = 5;
        tabulka s = new tabulka(x, y, miny);

        int[][] empty = s.getTab();

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                System.out.print(empty[i][j]);
            }
            System.out.println();
        }
    }

}
