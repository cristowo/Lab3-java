package main;

import view.Menu;

public class Main{
    public static void main(String [] arg) {
        /*
        Player p1 = new Player("juan");
        Player p2 = new Player("juan");
        System.out.println(p1.equals(p2));
         */
        /*
        Card c1 = new Card();
        Card c2 = new Card();
        c1.addECarta(2);
        c1.addECarta(3);
        c2.addECarta(3);
        c2.addECarta(2);
        System.out.println(c1.equals(c2));
         */
        /*
        Dobble mazo = new Dobble(9, -1, false);
        //System.out.println(mazo.nthCard(0));
        //System.out.println(mazo);
        System.out.println(mazo.isDobble());
         */
        Menu menu = new Menu();
        menu.ejecutarMenu();
    }
}

