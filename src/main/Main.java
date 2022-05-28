package main;

import model.Dobble;

public class Main{
    public static void main(String [] arg) {
        Dobble mazo = new Dobble(3, 5, true);
        System.out.println(mazo.getMazo());
    }
}

