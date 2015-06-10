/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Duxo
 */
import java.util.Random;

/**
 *
 * @author xminks
 */
public class Tabulka {

    //několik konstatnt, ať se definují čísla, úplně ideální by to bylo udělat pomocí enum třídy (výčet možností)
    public final static int NEODKRYTA_MINA = 10005; //mina, kterou jeste nenasel '#'
    public final static int ODKRYTA_MINA = 10000; //mina, kterou oznacil jako minu '@'
    public final static int ODKRYTE_POLE = 0; //kliknute pole bez miny ' '
    public final static int NEODKRYTE_POLE = 10; //pole bez miny jeste nekliknute '#'
    public final static int OZNACENA_MINA = 20; //pole oznacene, ale bez miny '@'

    private int miny = 0;
    private int odkryteMiny = 0;  //hodilo by se , pamatovat si, kolik je v tabulce min a kolik jich uzivatel nasel 
    private int x = 0;
    private int y = 0;
    private int[][] tab;

    //souradnice nejsou vůbec potřeba, stačí Ti velikost a počet min, odvodvodíš je,
    //nemusíš je mít zapsané v poli, tam by měly být jenom miny 
    /*
     souradniceX a Y jsou proměné které jsou připraveny na výpis souřadnic 0 1 2 3
     ještě nedokončené                                                    1 x x x
     2 x x x
     3 x x x
    
     a přiřazuji tam 10 protože jinak by mi to dělalo bordel při sčítání min kolem pole protože mina by měla stejný 
     ID jako souřadnice a do konečnýho čísla by se připsala i souřadnice
     */
    //int souradniceX = 10;
    //int souradniceY = 10;
    public Tabulka(int x, int y, int miny) {
        this.x = x;
        this.y = y;
        this.miny = miny;
        this.odkryteMiny = miny;

        Random rnd = new Random();

        tab = new int[x+2][y+2]; //zvetsim o dva, tim vytvorim prazdne okraje a muzu mit jednodusi podminky
        
        //plním pole 0 kromě souřadnic viz výše
        for (int i = 0; i < x+1; i++) {
            for (int j = 0; j < y+1; j++) {
                tab[i][j] = NEODKRYTE_POLE;
            }
        }

//náhodně generuji do pole miny
        //funguje, ale napadla mě lepší varianta
        /*
         while (miny > 0) {
         for (int i = 1; i < x - 1; i++) {
         for (int j = 1; j < y - 1; j++) {

         if (tab[i][j] == 0 && rnd.nextInt(50) <= 1) {

         tab[i][j] = NEODKRYTA_MINA;
         miny--;

         }

         }
         }
         }*/
        //dve nahodna cisla, pokud tam neni mina, tak ji tam dam, jinak vygeneruji dalsi
        //funguju dokud nemam nulovy pocet min
        while (odkryteMiny > 0) {
            int testX = rnd.nextInt(x)+1;
            int testY = rnd.nextInt(y)+1;
            if (tab[testX][testY] == NEODKRYTE_POLE) {
                tab[testX][testY] = NEODKRYTA_MINA;
                odkryteMiny--;
            }

        }
        //vse dalsi co tu bylo nema co delat v konstruktoru
    }

    public int getMiny() {
        return miny;
    }

    public int getOdkryteMiny() {
        return odkryteMiny;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int[][] getTab() {
        return tab;
    }

    
    //vypisuje tabulku vcetne prevodu na symboly podle toho, co na tom policku je
    public void print() {
        for (int i = 1; i <= x; i++) {
            for (int j = 1; j <= y; j++) {
                if (tab[i][j] == ODKRYTA_MINA || tab[i][j] == OZNACENA_MINA) {
                    System.out.print('@');
                }
                if (tab[i][j] == ODKRYTE_POLE) {
                    System.out.print(pocetMinVOkoli(i, j));
                }
                if (tab[i][j] == NEODKRYTE_POLE || tab[i][j] == NEODKRYTA_MINA) {
                    System.out.print('#');
                }
            }
            System.out.println("");
        }
    }
    
    //print cele odkryte tabulky, pouze na konci, nebo pro ladeni a hledani chyb
    public void print2(){        
        for (int i = 1; i <= x; i++) {
            for (int j = 1; j <= y; j++) {
                if (tab[i][j] == NEODKRYTA_MINA) {
                    System.out.print('@');
                } else {                
                    System.out.print(pocetMinVOkoli(i, j));
                }
            }
            System.out.println("");
        }
    }
    
    //Vraci 0, pokud klik byl na prazdnou souradnici
    //1, pokud kliknul na minu 
    //-1, pokud kliknul na souradnici, kterou jako minu oznacil
    public int klik(int x, int y){
        switch(tab[x][y]){
            case ODKRYTE_POLE:{
                return 0;
            }
            case NEODKRYTE_POLE: {
                tab[x][y] = ODKRYTE_POLE;
                return 0;
            }
            case NEODKRYTA_MINA: {
                tab[x][y] = ODKRYTA_MINA;
                return 1;
            }
            case OZNACENA_MINA: {
                
                return -1;
            }
            case ODKRYTA_MINA: {
                
                return -1;
            }                
            default : return 0;
        }
        
    }

    //fuknce pro oznaceni miny, rozlisuje jestli tam je mina, nebo neni, uzivatel musi oznacit vsechny miny, aby vyhral
    public void oznacitMinu(int x, int y){
        switch(tab[x][y]){
            case NEODKRYTA_MINA:{
                odkryteMiny++; //nasel minu, tedy pocet nalezenych +1
                tab[x][y] = ODKRYTA_MINA;                
                break;
            }
            case NEODKRYTE_POLE:{
                tab[x][y] = OZNACENA_MINA;
                break;
            }
            case OZNACENA_MINA:{
                tab[x][y] = NEODKRYTE_POLE;
                break;
            }
            case ODKRYTA_MINA:{
                odkryteMiny--; //nalezenou mkinu odznacil, tedy -1
                tab[x][y] = NEODKRYTA_MINA;
                break;
            }
        }
    }
    
    //pomocna funkce pro vypis, spocita miny v okoli
    //miny jsou od 10000, tedy sectu vse a pote vydelim 10000 a zaokorouhlim na cela cisla
    //bude fungovat pro rozumne velke tabulky, ne pro tabulku milion X milion
    private int pocetMinVOkoli(int x, int y){
        int soucet = 0;
        soucet += tab[x-1][y-1];
        soucet += tab[x-1][y];
        soucet += tab[x-1][y+1];
        
        soucet += tab[x][y+1];        
        soucet += tab[x][y-1];
        
        soucet += tab[x+1][y-1];
        soucet += tab[x+1][y];
        soucet += tab[x+1][y+1];
        
        return soucet/10000;
    }
}
