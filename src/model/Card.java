package model;

import java.util.ArrayList;
import java.util.Collections;


/**
 * Clase que simula una carta, el cual es una lista de enteros
 * @version 11.0.14.1
 * @autor: Cristobal Marchant
 */
public class Card implements interfases.Card {
    // Atributos
    private ArrayList<Integer> carta;

    // Metodo
    public Card(){
        this.carta = new ArrayList<Integer>();
    }

    /**
     * Obtiene la lista de enteros (ArrayList<Integer>) de una carta (Card)
     * @return ArrayList<Integer> lista de enteros
     */
    public ArrayList<Integer> getCarta() {
        return carta;
    }

    /**
     * Modifica la lista de enteros (ArrayList<Integer>) de una carta (Card)
     * @param carta (ArrayList<Integer>). La carta
     */
    public void setCarta(ArrayList<Integer> carta) {
        this.carta = carta;
    }

    /**
     * Obtiene la longitud de una carta (Integer) de una carta (Card)
     * @return Integer longitud de una carta
     */
    public Integer TamCard() {
        return carta.size();
    }

    /**
     * Obtiene una lista con los numeros en comun entre 2 cartas
     * @return ArrayList<Integer> lista de enteros
     */
    public ArrayList<Integer> EleComun(Card carta2){
        Card cartaAux = new Card();
        Card cartaAux2 = new Card();
        cartaAux2.setCarta(carta);
        cartaAux2.CopyCard(cartaAux);
        cartaAux.getCarta().retainAll(carta2.getCarta());
        return cartaAux.getCarta();
    }

    /**
     * Añade una numero (Integer) a una carta(card)
     * @ param card (ArrayList<Integer>).
     */
    public void addECarta(int a) {
        carta.add(a);
    }

    /**
     * Elimina todos los numeros de una carta(Card)
     * @return carta
     */
    public ArrayList<Integer> Vaciar() {
        carta.clear();
        return carta;
    }

    /**
     * Vacia una carta y copia los elemntos de otra
     * @ param carta (Card)
     */
    public void CopyCard(Card card2){
        card2.Vaciar();
        for(int i =0; i < carta.size(); i++){
            card2.addECarta(carta.get(i));
        }
    }

    /**
     * Desordena los numeros de una carta (Card)
     * @ param carta (Card).
     */
    public void cardRandom(){
        Collections.shuffle(carta);
    }

    /**
     * Comprueba igualdad entre 2 cartas
     * * @return Boolean
     */
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

    /**
     * convierte carta a String
     * * @return carta String
     */
    @Override
    public String toString() {
        return carta+"";
    }
}
