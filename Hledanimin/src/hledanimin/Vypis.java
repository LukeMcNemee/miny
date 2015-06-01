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
public class Vypis {

    private int[][] tab;
    private int x;
    private int y;
    private final int Kcislo = 10;

    public Vypis(int tab[][], int x, int y) {

        this.tab = tab;
        this.x = x;
        this.y = y;

        for (int i = 1; i < x - 1; i++) {
            for (int j = 1; j < y - 1; j++) {

                if (tab[i][j] < 500) {
                  System.out.print(tab[i][j] + " ");
                 }
                if (tab[i][j] > 500&& tab[i][j] < 5000){  
                  System.out.print("X ");
                 }
                  if (tab[i][j] == 9){  
                  System.out.print("M ");
                  }
                    if (tab[i][j] > 5000){
                    System.out.print("m ");
                    }
                    /*   
                     if (i == 0||j == 0) {
                     System.out.print(tab[i][j] - Kcislo +" ");

                     }
                   
                   
                   
                   
                    
                    
                     if (tab[i][j] == 9) {
                     System.out.print("M ");
                     } else {

                     System.out.print(tab[i][j] + " ");
                     }

                     } else {
                     System.out.print("X ");
                     */ 
            }
            System.out.println();
        }

    }

}
