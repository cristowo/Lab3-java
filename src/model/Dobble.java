package model;


import java.util.ArrayList;

public class Dobble {
    private Integer Largo; //NumE
    private Integer NumC;
    private ArrayList<Card> mazo;

    public Dobble(Integer Largo) {
        ArrayList<Card> AllCards = new ArrayList<Card>();
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
        this.mazo = AllCards;
    }

    public ArrayList<Card> getMazo() {
        return mazo;
    }

    public void setMazo(ArrayList<Card> mazo) {
        this.mazo = mazo;
    }

    public Card nthCard(Integer n) {
        return mazo.get(n);
    }

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



}
