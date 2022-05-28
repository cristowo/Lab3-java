package model;

import java.util.Random;
import java.util.ArrayList;

/*-------------------------------------------------------------------------------------------
* Definicion de clase
* --------------------------------------------------------------------------------------------- */
public class Dobble {
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
    }
    /*-------------------------------------------------------------------------------------------
    * Obtener mazo
    * --------------------------------------------------------------------------------------------- */
    public ArrayList<Card> getMazo() {
        return mazo;
    }

    public void setMazo(ArrayList<Card> mazo) {
        this.mazo = mazo;
    }
    /*-------------------------------------------------------------------------------------------
    * nthCard
    * --------------------------------------------------------------------------------------------- */
    public Card nthCard(Integer n) {
        return mazo.get(n);
    }
    /*-------------------------------------------------------------------------------------------
    * is Dobble
    * --------------------------------------------------------------------------------------------- */
    public Boolean isDobble(){
        if(mazo.size() == 0 || mazo.size() == 1){                                      // Caso mazo vacio
            return false;
        }
        int acum=0;
        for(int i=0; i < mazo.size();i++){
            for(int j=i+1; j <mazo.size();j++){
                if( (mazo.get(i)).TamCard() != (mazo.get(j)).TamCard() ){     //caso cuando hay una carta con mas o menos elementos
                    return false;
                }
            }
        }
        for(int i=0; i < mazo.size();i++){
            if( ((mazo.get(i)).EleComun(mazo.get(i))).size() != (mazo.get(i)).TamCard() ){   //caso cuando una carta tiene 1 o mas elementos repetidos
                return false;
            }
        }
        for(int i=0; i < mazo.size();i++) {
            Card cardAux = new Card();
            for (int j=i+1; j < mazo.size(); j++) {
                (mazo.get(i)).CopyCard(cardAux);
                if( ( cardAux.EleComun(mazo.get(j))).size() != 1 ){     //caso cuando hay 0 o mas de 1 elemento en comun
                    return false;
                }
            }
        }
        return true;
    }
    /*-------------------------------------------------------------------------------------------
     * numCards
     * --------------------------------------------------------------------------------------------- */
    public Integer numCards() {
        int largo = mazo.size();
        return largo;
    }
    /*-------------------------------------------------------------------------------------------
     * FindTotalCards falta probar
     * --------------------------------------------------------------------------------------------- */
    public Integer FindTotalCards(Card carta) {
        int Tcard = ((carta.TamCard()-1)^2 + carta.TamCard() ) ;
        return Tcard;
    }
    /*-------------------------------------------------------------------------------------------
     * ElemReque falta probar
     * --------------------------------------------------------------------------------------------- */
    public Integer ElemReque(Card carta) {
        int EReq = ((carta.TamCard()-1)^2 + carta.TamCard() ) ;
        return EReq;
    }
    /*-------------------------------------------------------------------------------------------
     * missingCards
     * --------------------------------------------------------------------------------------------- */
    public ArrayList<Card> missingCards() {
        int largoT = (mazo.get(0)).TamCard();
        Dobble mazoMissing = new Dobble( largoT ,-1,false);
        Card cardAux = new Card();

        for (int i = 0; i < mazo.size(); i++) {
            for (int j = 0; j < (mazoMissing.numCards()); j++) {
                (mazo.get(i)).CopyCard(cardAux);
                if ((cardAux.EleComun(mazoMissing.getMazo().get(j))).size() == largoT) {                //caso la carta si esta dentro del mazo
                    mazoMissing.getMazo().remove(mazoMissing.getMazo().get(j));
                    j--;
                }
            }
        }
        return mazoMissing.getMazo();
    }
    /*-------------------------------------------------------------------------------------------
     * MazoToString
     * --------------------------------------------------------------------------------------------- */
}
