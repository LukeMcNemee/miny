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
        
        //určuje velikost pole ty plus jsou tam protože pole potřebuji větší zdůvodu toho že bych jinak překročil rozhraní pole při sčítání
        int x = 1 +2;
        int y = 1 +2;
        int miny = 1;
        
       
        
        
        Tabulka tabulka = new Tabulka(x, y, miny);
          int[][] tab = tabulka.getTab();
        
         
        
        
        
        for(;;){
            
        //volám dokola metody a nekonečný cyklus je tady protože aplikaci ukončuje třída Stav    
            Kolo kolo = new Kolo (tab);
           
            tab = kolo.getTab();
            
            Vypis vypis = new Vypis(tab,x,y);
       
        
        
        
        Stav stav = new Stav (miny,tab,x,y);
        
          
        
        
        
        }
        }
       
    
      
       
            
            
        
        
        
        
    }


