package model;

import java.util.Objects;

/**
 * Clase que simula un jugador, el almacena 2 Interger (turnos y puntos) y 1 String (name)
 * @version 11.0.14.1
 * @autor: Cristobal Marchant
 */
public class Player implements interfases.Player{
    // Atributos
    private String name;
    private Integer turno;
    private Integer puntos;

    // Metodo
    public Player(String name){
        this.name = name;
        this.turno=0;
        this.puntos=0;
    }

    /**
     * Obtiene un Stringe con el nombre de un jugador
     * @return String name
     */
    public String getName() {
        return name;
    }

    /**
     * Modifica el nombre (String)
     * @ param name (String)
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Obetiene un Integer con el Turno de un jugador
     * @return Integer Turno
     */
    public Integer getTurno() {
        return turno;
    }

    /**
     * Modifica el turno (Integer)
     * @ param turno (Integer)
     */
    public void setTurno(Integer turno) {
        this.turno = turno;
    }

    /**
     * Obetiene un Integer con los Puntos de un jugador
     * @return Integer Puntos
     */
    public Integer getPuntos() {
        return puntos;
    }

    /**
     * Modifica los puntos (Integer)
     * @ param puntos (Integer)
     */
    public void setPuntos(Integer puntos) {
        this.puntos = puntos;
    }

    /**
     * Comprueba si un jugador (Player) es igual a otro
     * @return Boolean
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(name, player.name) && Objects.equals(turno, player.turno) && Objects.equals(puntos, player.puntos);
    }

    /**
     * Convierte el contendio de Player a String
     * @return name, turno, puntos como String
     */
    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", turno=" + turno +
                ", puntos=" + puntos +
                '}';
    }
}