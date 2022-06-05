package model;

import java.util.Objects;

public class Player{
    // Atributos
    private String name;
    private Integer turno;
    private Integer puntos;

    // Metodo
    /*-------------------------------------------------------------------------------------------
     * Definicion de Player
     * --------------------------------------------------------------------------------------------- */
    public Player(String name){
        this.name = name;
        this.turno=0;
        this.puntos=0;
    }
    //Get and Set
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTurno() {
        return turno;
    }

    public void setTurno(Integer turno) {
        this.turno = turno;
    }

    public Integer getPuntos() {
        return puntos;
    }

    public void setPuntos(Integer puntos) {
        this.puntos = puntos;
    }

    // PLAYER EQUAL
    //------------------------------------------------------------------------------------------------
    public boolean PlayerEqual(Player player){
        if(name.equals(player.getName()) && turno.equals(player.getTurno()) && puntos.equals(player.getPuntos())){
            return true;
        }
        else{
            return false;
        }
    }
    //------------------------------------------------------------------------------------------------------
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(name, player.name) && Objects.equals(turno, player.turno) && Objects.equals(puntos, player.puntos);
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", turno=" + turno +
                ", puntos=" + puntos +
                '}';
    }
}