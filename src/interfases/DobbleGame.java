package interfases;

import model.Dobble;

public interface DobbleGame {
    public void registUser (String nombre);
    public String whoseTurnIs();
    public void play(Integer elem, Dobble mazo, Integer posicion);
    public boolean equals(Object o);
}
