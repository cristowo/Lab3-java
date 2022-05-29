package controller;

import model.DobbleGame;
import model.Player;

import java.util.ArrayList;

public class Controlador {
    public DobbleGame tablero;

    public Controlador(Integer NumPlayers, Integer TamCardSet, String modo){
        tablero = new DobbleGame(NumPlayers, TamCardSet, modo);
    }

    public void registUser (String nombre){
        if(0 < tablero.getNumPlayers()){
            Player jugador = new Player(nombre);
            tablero.addPlayer(jugador);
        }
    }

    public ArrayList<Player> getListaPlayers() {
        return tablero.getListPlayers();
    }
}
