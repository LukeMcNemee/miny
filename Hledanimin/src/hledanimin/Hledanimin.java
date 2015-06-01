package hledanimin;

import java.util.Scanner;

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
        Scanner scanner = new Scanner (System.in);
        
        int x = 4 +2;
        int y = 4 +2;
        int miny = 1;
        
       
        
        
        Tabulka tabulka = new Tabulka(x, y, miny);
          int[][] tab = tabulka.getTab();
        
         
        
        
        
        for(;;){
            
            
            Kolo kolo = new Kolo (tab);
           
            tab = kolo.getTab();
            
            
            
            Vypis vypis = new Vypis(tab,x,y);
       
        
        
        
        Stav stav = new Stav (miny,tab,x,y);
        
          
        
        
        
        }
        }
       
    
      
       
            
            
        
        
        
        
    }


