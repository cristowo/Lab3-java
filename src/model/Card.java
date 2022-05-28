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

    public Integer TamCard() {
        return carta.size();
    }

    public ArrayList<Integer> EleComun(Card carta2){
        carta.retainAll(carta2.getCarta());
        return carta;
    }


    public void addECarta(int a) {
        carta.add(a);
    }

    public ArrayList<Integer> Vaciar() {
        carta.clear();
        return carta;
    }
    public void CopyCard(Card card2){
        card2.Vaciar();
        for(int i =0; i < carta.size(); i++){
            card2.addECarta(carta.get(i));
        }
    }
    @Override
    public String toString() {
        return carta+"";
    }
}
