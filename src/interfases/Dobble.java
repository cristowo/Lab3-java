package interfases;

import model.Card;

import java.util.ArrayList;

public interface Dobble {
    /**
     * Obetiene la nth carta de 0 hasta n-1
     * @ param Integer numero
     * @return Card carta
     */
    public Card nthCard(Integer n);

    /**
     * Obtiene un true si el mazo es valido o obtiene un false si el mazo es invalido
     * @return Boolean
     */
    public Boolean isDobble();

    /**
     * Obtiene un Interger con la cantidad de cartas
     * @return Integer largo
     */
    public Integer numCards();

    /**
     * Obtiene el total de cartas de 1 carta de muestra
     * @ param Card carta
     * @return Integer total de cartas
     */
    public Integer FindTotalCards(Card carta);

    /**
     * Obtiene el total de elementos requeridos para obtener un mazo, en base de una 1 carta de muestra
     * @return Integer total de elementos
     */
    public Integer ElemReque(Card carta);

    /**
     * Obtiene las cartas faltantes para un mazo incompleto
     * @return Arraylist<Cards> mazo de cartas faltantes
     */
    public ArrayList<Card> missingCards();

    /**
     * Obtiene un true si el ambos mazo son iguales, o un false en caso contrario
     * @return Boolean
     */
    public boolean equals(Object o);
}
