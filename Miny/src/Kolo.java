
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Duxo
 */
public class Kolo {

    private int[][] tab;
    private int a;
    private int b;
    private int vyber;

    Scanner scanner = new Scanner(System.in);

    public Kolo(int tab[][]) {

        this.tab = tab;

        System.out.println("1 - odkrýváš políčko  2 - označuješ minu");
        vyber = scanner.nextInt();

        if (vyber == 1) {

            //zadání souřadnic na označení pole
            System.out.println("Zadejte souřadnici X");

            a = scanner.nextInt();

            System.out.println("Zadejte souřadnici Y");

            b = scanner.nextInt();

            //označení souřadnic na odkrytí
            if (tab[b][a] > 500 && tab[b][a] < 5000) {
                tab[b][a] = tab[b][a] - 1000;
            } else {
                System.out.println("Chyba,již použité souřadnice");
            }

        } else {

           //zadávání souřadnic na označení miny
            System.out.println("Zadejte souřadnici X");

            a = scanner.nextInt();

            System.out.println("Zadejte souřadnici Y");

            b = scanner.nextInt();

            //kódování a dekódování označených min
            //ERROR při opětovném dekódování takže při odečítání
            if (tab[b][a] > 5000) {

                tab[b][a] = tab[b][a] - 10000;

            }
            if (tab[b][a] > 500 && tab[b][a] < 5000) {

                tab[b][a] = tab[b][a] + 10000;

            } else {

                System.out.println("Chyba, již odkryté souřadnice");

            }

        }
    }

    public int[][] getTab() {
        return tab;
    }
}
