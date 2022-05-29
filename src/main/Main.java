package main;

import controller.Controlador;

public class Main{
    public static void main(String [] arg) {
        Controlador tablero = new Controlador(3, 3, "nose");
        tablero.registUser("cri");
        System.out.println(tablero.getListaPlayers());
    }
}

