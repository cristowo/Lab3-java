package interfases;

import model.Card;

import java.util.ArrayList;

public interface Dobble {
    public Card nthCard(Integer n);
    public Boolean isDobble();
    public Integer numCards();
    public Integer FindTotalCards(Card carta);
    public Integer ElemReque(Card carta);
    public ArrayList<Card> missingCards();
    public boolean equals(Object o);
}
