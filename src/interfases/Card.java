package interfases;

public interface Card {
    /**
     * Obtiene la longitud de una carta (Integer) de una carta (Card)
     * @return Integer longitud de una carta
     */
    public Integer TamCard();

    /**
     * Añade una numero (Integer) a una carta(card)
     * @ param card (ArrayList<Integer>).
     */
    public void addECarta(int a);

    /**
     * Comprueba igualdad entre 2 cartas
     * * @return Boolean
     */
    @Override
    public boolean equals(Object o);
}
