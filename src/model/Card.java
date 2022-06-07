package model;

import java.util.ArrayList;
import java.util.Collections;


/*-------------------------------------------------------------------------------------------
 * Definicion de clase
 * --------------------------------------------------------------------------------------------- */
public class Card implements interfases.Card {
    // Atributos
    private ArrayList<Integer> carta;

    // Metodo
    /*-------------------------------------------------------------------------------------------
     * Definicion de Carta
     * --------------------------------------------------------------------------------------------- */
    public Card(){
        this.carta = new ArrayList<Integer>();
    }
    /*-------------------------------------------------------------------------------------------
     * Obtener carta
     * --------------------------------------------------------------------------------------------- */
    public ArrayList<Integer> getCarta() {
        return carta;
    }

    public void setCarta(ArrayList<Integer> carta) {
        this.carta = carta;
    }
    /*-------------------------------------------------------------------------------------------
     * Tamaño Carta
     * --------------------------------------------------------------------------------------------- */
    public Integer TamCard() {
        return carta.size();
    }
    /*-------------------------------------------------------------------------------------------
     * Array con elementos en comun entre 2 cartas
     * --------------------------------------------------------------------------------------------- */
    public ArrayList<Integer> EleComun(Card carta2){
        Card cartaAux = new Card();
        Card cartaAux2 = new Card();
        cartaAux2.setCarta(carta);
        cartaAux2.CopyCard(cartaAux);
        cartaAux.getCarta().retainAll(carta2.getCarta());
        return cartaAux.getCarta();
    }
    /*-------------------------------------------------------------------------------------------
     * Añadir elemento a una carta
     * --------------------------------------------------------------------------------------------- */
    public void addECarta(int a) {
        carta.add(a);
    }
    /*-------------------------------------------------------------------------------------------
     * Borrar todos los elementos de 1 carta
     * --------------------------------------------------------------------------------------------- */
    public ArrayList<Integer> Vaciar() {
        carta.clear();
        return carta;
    }
    /*-------------------------------------------------------------------------------------------
     * Copia los elementos de 1 carta hacia otra
     * --------------------------------------------------------------------------------------------- */
    public void CopyCard(Card card2){
        card2.Vaciar();
        for(int i =0; i < carta.size(); i++){
            card2.addECarta(carta.get(i));
        }
    }
    //---------------------------------------------------------------------------------------------------
    public void cardRandom(){
        Collections.shuffle(carta);
    }
    //---------------------------------------------------------------------------------------------------
    // CARD EQUAL
    //------------------------------------------------------------------------------------------------
    // nota de que pasa si la carta esta desordenanda
    @Override
    public boolean equals(Object o){
        Card card = (Card) o;
        Card card2 = new Card();
        card2.setCarta(carta);
        if(carta.size() == card.TamCard() && card.EleComun(card2).size() == carta.size()){
            return true;
        }
        else{
            return false;
        }
    }
    //---------------------------------------------------------------------------------------------------
    @Override
    public String toString() {
        return carta+"";
    }
}
