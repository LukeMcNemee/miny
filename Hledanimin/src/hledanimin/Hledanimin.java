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
        int x = 10 +2;
        int y = 10 +2;
        int miny = 20;
        int a =2;
        int b =1;
        
        
        tabulka tabulka = new tabulka(x, y, miny);

        int[][] tab = tabulka.getTab();
         
        
        vypis vypis = new vypis(tab,x,y,a,b);
       
       
       
    
      
       
            
            
        
        
        
        
    }

}
