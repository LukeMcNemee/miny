/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Duxo
 */
import java.util.Scanner;

/**
 *
 * @author Duxo
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scanner = new Scanner(System.in);

        //určuje velikost pole ty plus jsou tam protože pole potřebuji větší zdůvodu toho že bych jinak překročil rozhraní pole při sčítání
        int x = 5;
        int y = 5;
        int miny = 5;

        Tabulka tabulka = new Tabulka(x, y, miny);

        tabulka.print2();

        //dokud pocet odkrytych min, neni stejny jako pocet min
        while (tabulka.getMiny() != tabulka.getOdkryteMiny()) {

            System.out.println("Zadejte souradnice X");
            int klikX = scanner.nextInt();
            System.out.println("Zadejte souradnice Y");
            int klikY = scanner.nextInt();
            System.out.println("Chcete Oznacit - O, nebo kliknout - K");
            String akce = scanner.next();

            if (klikX < 1 || klikX > x || klikY < 1 || klikY > y) {
                System.err.println("Spatne zadane souradnice");
                continue;
            }
            
            if(( !(akce.equals("K")) && !(akce.equals("O") ))){
                System.err.println("Spatne zadana akce");
                continue;
            }
            //vse ok
            if (akce.equals("O")) {
                tabulka.oznacitMinu(klikX, klikY);
            } else {
                int vysledek = tabulka.klik(klikX, klikY);

                if (vysledek == 1) {
                    System.out.println("Prohral jsi");
                    tabulka.print2();
                    return;
                } else if (vysledek == -1) {
                    System.out.println("Toto uz jsi oznacil jako minu");
                }
            }

            tabulka.print();
        }
        System.out.println("Vyhral jsi");
        /*
        
        
         for (;;) {

         //volám dokola metody a nekonečný cyklus je tady protože aplikaci ukončuje třída Stav    
         Kolo kolo = new Kolo(tab);
         tab = kolo.getTab();
         Vypis vypis = new Vypis(tab, x, y);
         Stav stav = new Stav(miny, tab, x, y);

         }*/
    }

}
