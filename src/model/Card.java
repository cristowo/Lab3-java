package model;

import java.util.ArrayList;

public class Card {
    // Atributos
    private ArrayList<Integer> carta;

    // Metodo
    public Card(){
        this.carta = new ArrayList<Integer>();
    }

    public ArrayList<Integer> getCarta() {
        return carta;
    }

    public void setCarta(ArrayList<Integer> carta) {
        this.carta = carta;
    }

    public void addECarta(int a) {
        carta.add(a);
    }

    @Override
    public String toString() {
        return "Card:"+carta;
    }
}
