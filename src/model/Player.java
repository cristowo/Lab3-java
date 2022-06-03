package model;

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


    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", turno=" + turno +
                ", puntos=" + puntos +
                '}';
    }
}
