package view;

import model.DobbleGame;
import java.util.Scanner;

public class Menu {
    private DobbleGame Tablero;

    public void ejecutarMenu() {
        Scanner scan = new Scanner(System.in);
        boolean Exit = false;
        while(Exit != true){
            System.out.println("-----Bienvenid@s a THE DOBBLE GAME-----");
            System.out.println("-----Porfavor ingrese una opcion:------");
            System.out.println("1. Nueva Partida-----------------------");
            System.out.println("2. Salir-------------------------------");
            int eleccion = scan.nextInt();
            switch (eleccion) {
                case 1:
                    while(Exit != true){
                        DobbleGame tablero = new DobbleGame(0,0,"null");
                        System.out.println("-----------THE DOBBLE GAME-------------");
                        System.out.println("--Porfavor seleccione modo de juego:---");
                        System.out.println("1. Stack-------------------------------");
                        System.out.println("4. Salir-------------------------------");
                        int eleccion = scan.nextInt();
                        switch (eleccion) {
                            case 1:
                                while(Exit != true) {
                                    System.out.println("-----------THE DOBBLE GAME-------------");
                                    System.out.println("---Ingrese la cantidad de jugadores:---");
                                    int numPlayers = scan.nextInt();
                                    Tablero.setNumPlayers(numPlayers);
                                    System.out.println("-----------THE DOBBLE GAME-------------");
                                    System.out.println("---Ingrese la cantidad de jugadores:---");
                                }
                                break;
                            case 4:
                                System.out.println("Hasta luego!!!");
                                Exit = true;
                                break;
                    break;
                case 2:
                    System.out.println("Hasta luego!!!");
                    Exit = true;
                    break;
            }
        }
    }

    @Override
    public String toString() {
        return  Tablero + "";
    }
}
