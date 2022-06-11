package model;

import java.util.ArrayList;
import java.util.Random;

/**
 * Clase que simula un mazo de cartas, posee 2 Integer(Largo y NumC) y 1 Arraylist<Card> (mazo).
 * @version 11.0.14.1
 * @autor: Cristobal Marchant
 */
public class Dobble implements interfases.Dobble {
    private Integer Largo; //NumE
    private Integer NumC;
    private ArrayList<Card> mazo;

    /*-------------------------------------------------------------------------------------------
    * Definicion de Dooble (mazo)
    * --------------------------------------------------------------------------------------------- */
    public Dobble(Integer Largo, Integer NumC, Boolean Azar) {
        Largo = Largo-1;
        ArrayList<Card> AllCards = new ArrayList<Card>();
        ArrayList<Card> AllCardsRandom = new ArrayList<Card>();
        ArrayList<Card> AllCardsCut = new ArrayList<Card>();
        Card cartita = new Card();

        for (int i = 1; i <= Largo + 1; i++) {
            cartita.addECarta(i);
        }
        AllCards.add(cartita);

        for (int j = 1; j <= Largo; j++) {
            Card cartita2 = new Card();
            cartita2.addECarta(1);

            for (int k = 1; k <= Largo; k++) {
                cartita2.addECarta(Largo * j + (k + 1));
            }
            AllCards.add(cartita2);
        }
        for (int i = 1; i <= Largo; i++) {
            for (int j = 1; j <= Largo; j++) {
                Card cartita3 = new Card();
                cartita3.addECarta(i + 1);

                for (int k = 1; k <= Largo; k++) {
                    cartita3.addECarta(Largo + 2 + Largo * (k - 1) + (((i - 1) * (k - 1) + j - 1) % Largo));
                }
                AllCards.add(cartita3);
            }
        }
        if(Azar == true){
            Random random = new Random();
            int total = AllCards.size();
            for(int i=0;i< total;i++) {
                int numRandom= random.nextInt(AllCards.size());
                AllCardsRandom.add(AllCards.get(numRandom));
                AllCards.remove(AllCards.get(numRandom));
            }
            AllCards = AllCardsRandom;
        }

        if(NumC < 0){
            this.mazo = AllCards;
        }
        if(NumC >= 0){
            for(int i=0; i< NumC; i++) {
                AllCardsCut.add(AllCards.get(i));
            }
            this.mazo = AllCardsCut;
        }
        this.Largo = mazo.size();
    }

    /**
     * Obtiene un ArrayList de cartas
     * @return Arraylist<Card> mazo
     */
    public ArrayList<Card> getMazo() {
        return mazo;
    }

    /**
     * Modifica el mazo con uno nuevo
     * @ param mazo (Arraylist<Card>)
     */
    public void setMazo(ArrayList<Card> mazo) {
        this.mazo = mazo;
    }

    /**
     * Obtiene un Integer con el largo del mazo
     * @return Integer largo
     */
    public Integer getLargo() {
        return Largo;
    }

    /**
     * Modifica el largo de la lista
     * @ param Integer Largo nuevo
     */
    public void setLargo(Integer largo) {
        Largo = largo;
    }


    /**
     * Obetiene la nth carta de 0 hasta n-1
     * @ param Integer numero
     * @return Card carta
     */
    public Card nthCard(Integer n) {
        if (n < mazo.size() && n > 0){
            return mazo.get(n);
        }
        else{
            return null;
        }
    }

    /**
     * Obtiene un true si el mazo es valido o obtiene un false si el mazo es invalido
     * @return Boolean
     */
    public Boolean isDobble(){
        if(mazo.size() == 0 || mazo.size() == 1){                                      // Caso mazo vacio
            return false;
        }
        int acum=0;
        for(int i=0; i < mazo.size();i++){
            for(int j=i+1; j <mazo.size();j++){
                if( (mazo.get(i)).TamCard() != (mazo.get(j)).TamCard() ){     //caso cuando hay una carta con mas o menos elementos
                    System.out.println("---------------------------------------");
                    System.out.println("-----------Mazo No Funcional-----------");
                    System.out.println("---------------------------------------");
                    return false;
                }
            }
        }
        for(int i=0; i < mazo.size();i++){
            if( ((mazo.get(i)).EleComun(mazo.get(i))).size() != (mazo.get(i)).TamCard() ){   //caso cuando una carta tiene 1 o mas elementos repetidos
                System.out.println("---------------------------------------");
                System.out.println("-----------Mazo No Funcional-----------");
                System.out.println("---------------------------------------");
                return false;
            }
        }
        for(int i=0; i < mazo.size();i++) {
            for (int j=i+1; j < mazo.size(); j++) {
                if( ( mazo.get(i).EleComun(mazo.get(j))).size() != 1 ){     //caso cuando hay 0 o mas de 1 elemento en comun
                    System.out.println("---------------------------------------");
                    System.out.println("-----------Mazo No Funcional-----------");
                    System.out.println("---------------------------------------");
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Obtiene un Interger con la cantidad de cartas
     * @return Integer largo
     */
    public Integer numCards() {
        int largo = mazo.size();
        return largo;
    }

    /**
     * Obtiene el total de cartas de 1 carta de muestra
     * @ param Card carta
     * @return Integer total de cartas
     */
    public Integer FindTotalCards(Card carta) {
        int Tcard = ((carta.TamCard()-1)^2 + carta.TamCard() ) ;
        return Tcard;
    }

    /**
     * Obtiene el total de elementos requeridos para obtener un mazo, en base de una 1 carta de muestra
     * @return Integer total de elementos
     */
    public Integer ElemReque(Card carta) {
        int EReq = ((carta.TamCard()-1)^2 + carta.TamCard() ) ;
        return EReq;
    }

    /**
     * Obtiene las cartas faltantes para un mazo incompleto
     * @return Arraylist<Cards> mazo de cartas faltantes
     */
    public ArrayList<Card> missingCards() {
        int largoT = (mazo.get(0)).TamCard();
        Dobble mazoMissing = new Dobble( largoT ,-1,false);
        for (int i = 0; i < mazo.size(); i++) {
            for (int j = 0; j < (mazoMissing.numCards()); j++) {
                if (mazo.get(i).equals(mazoMissing.getMazo().get(j))) {                //caso la carta si esta dentro del mazo
                    mazoMissing.getMazo().remove(mazoMissing.getMazo().get(j));
                    j--;
                }
            }
        }
        return mazoMissing.getMazo();
    }

    /**
     * Agrega cartas a un mazo, procurando que este siga siendo valido
     * @ param Card carta
     */
    public void AddCardMazo(Card card){
        Dobble mazoaux = new Dobble(0,-1,false);
        mazo.add(card);
        mazoaux.setMazo(mazo);
        if(!mazoaux.isDobble()){
            mazo.remove(mazo.size()-1);
        }
    }

    /**
     * elimina las 2 primeras cartas de una mazo
     */
    public void EliminarCard(){
        ArrayList<Card> mazoaux = new ArrayList<Card>();
        for(int i=2; i<mazo.size();i++){
            mazoaux.add(mazo.get(i));
        }
        this.mazo = mazoaux;
    }

    /**
     * Obtiene un true si el ambos mazo son iguales, o un false en caso contrario
     * @return Boolean
     */
    @Override
    public boolean equals(Object o) {
        Dobble mazo2 = (Dobble) o;
        if(mazo.size() != mazo2.getMazo().size()){
            return false;
        }
        else{
            int aux = 0;
            for(int i=0; i<mazo.size();i++){
                for(int j=0; j<mazo2.getMazo().size();j++){
                    if(mazo.get(i).equals(mazo2.getMazo().get(j))){
                        aux++;
                    }
                }
            }
            if(aux == mazo.size()){
                return true;
            }
            else{
                return false;
            }
        }
    }
    /**
     * Convierte el mazo en String
     * @return mazo (String)
     */
    @Override
    public String toString() {
        return mazo+"";
    }
}
