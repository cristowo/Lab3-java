package model;

import java.util.ArrayList;
/*-------------------------------------------------------------------------------------------
 * Definicion de clase
 * --------------------------------------------------------------------------------------------- */
public class Card {
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
        carta.retainAll(carta2.getCarta());
        return carta;
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
    @Override
    public String toString() {
        return carta+"";
    }
}
