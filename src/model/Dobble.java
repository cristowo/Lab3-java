package model;

import java.util.ArrayList;

public class Dobble {
    private Integer NumE;
    private Integer NumC;
    private ArrayList<Card> mazo;

    public Dobble(Integer Largo){
        ArrayList<Card> AllCards = new ArrayList<Card>();
        Card cartita = new Card();

        for(int i=1; i <= Largo+1; i++) {
            cartita.addECarta(i);
        }
        AllCards.add(cartita);

        for(int j=1; j <=Largo ; j++){
            Card cartita2 = new Card();
            cartita2.addECarta(1);

            for (int k=1; k<=Largo; k++){
                cartita2.addECarta(Largo*j + (k+1));
            }
            AllCards.add(cartita2);
        }
        for (int i= 1; i<=Largo; i++) {
            for (int j=1; j<=Largo; j++) {
                Card cartita3 = new Card();
                cartita3.addECarta(i+1);

                for (int k=1; k<= Largo; k++) {
                    cartita3.addECarta(Largo+2+Largo*(k-1)+(((i-1)*(k-1)+j-1) % Largo));
                }
                AllCards.add(cartita3);
            }
        }
        this.mazo=AllCards;
    }

    public ArrayList<Card> getMazo() {
        return mazo;
    }

    public void setMazo(ArrayList<Card> mazo) {
        this.mazo = mazo;
    }
}
