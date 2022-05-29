package model;

import java.util.ArrayList;

public class DobbleGame {
    private String estado;
    private Dobble mazoDobblegame;
    private Integer numPlayers;
    private String modalidad;
    private ArrayList<Player> ListPlayers;

    public DobbleGame(Integer NumPlayers, Integer TamCardSet, String modo){
        mazoDobblegame = new Dobble(TamCardSet, -1, true);
        modalidad = modo;
        estado = "Preparacion";
        numPlayers= NumPlayers;
    }
    // Set and Get--------------------------------------------------------

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Dobble getMazoDobblegame() {
        return mazoDobblegame;
    }

    public void setMazoDobblegame(Dobble mazoDobblegame) {
        this.mazoDobblegame = mazoDobblegame;
    }

    public Integer getNumPlayers() {
        return numPlayers;
    }

    public void setNumPlayers(Integer numPlayers) {
        this.numPlayers = numPlayers;
    }

    public String getModalidad() {
        return modalidad;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }

    public ArrayList<Player> getListPlayers() {
        return ListPlayers;
    }

    public void setListPlayers(ArrayList<Player> listPlayers) {
        ListPlayers = listPlayers;
    }

    // -----------------------------------------------------------------------------

    public void addPlayer(Player player) {
        ListPlayers.add(player);
    }

    @Override
    public String toString() {
        return "DobbleGame{}";
    }

}
