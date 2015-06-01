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
public class Stav {

    private int[][] tab;
    private int x;
    private int y;
    private int miny;
    private int stav;
    private int policka; 
    public Stav(int miny, int tab[][], int x, int y) {

        this.tab = tab;
        this.miny = miny;
        this.x = x;
        this.y = y;
        stav = 0;
        // stav 0 - hra
        // stav 1 - výhra
        // stav 2 - prohra
        
        policka = (x-2)*(y-2)-miny;
        for (int i = 1; i < x - 1; i++) {
            for (int j = 1; j < y - 1; j++) {

            if (tab [i][j]==9){
            stav = 2;
            break;
            }
            
            if (tab [i][j]<500){
            policka--;
            if (policka == 0){
            stav = 1;
            
            }
            }
            }
        }
    
        
        if (stav ==1){
    System.err.print("Vyhrál jsi");
    System.exit(0);
    }

    
    if (stav ==2){
    System.err.print("Prohrál jsi");
    System.exit(0);
    }

    
    
    
    }   
}
