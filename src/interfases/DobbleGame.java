package interfases;

import model.Dobble;

public interface DobbleGame {

    /**
     * Registra a un usuario, en donde si esta repetido no se agrega
     * @ param String nombre
     */
    public void registUser (String nombre);

    /**
     * Obtiene un String con el nombre del jugador en turno actual
     * @return String name
     */
    public String whoseTurnIs();

    /**
     * Modifica el game segun su modalidad
     * @ param Integer Elemento en común, Dobble el mazo en juego, Integer posicion del jugador
     */
    public void play(Integer elem, Dobble mazo, Integer posicion);

    /**
     * Obtiene un True si dos games son iguales, contrario a esto obtiene un false
     * @return Boolean
     */
    public boolean equals(Object o);
}
