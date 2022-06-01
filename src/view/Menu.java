package view;

import model.DobbleGame;
import java.util.Scanner;

public class Menu {
    private DobbleGame Tablero;

    public void ejecutarMenu() {
        Scanner scan = new Scanner(System.in);
        boolean Exit = false;
        while (Exit != true) {
            System.out.println("-----Bienvenid@s a THE DOBBLE GAME-----");
            System.out.println("-----Porfavor ingrese una opcion:------");
            System.out.println("1. Nueva Partida-----------------------");
            System.out.println("2. Salir-------------------------------");
            int eleccion = scan.nextInt();
            switch (eleccion) {
                case 1:
                    while (Exit != true) {
                        System.out.println("-----------THE DOBBLE GAME-------------");
                        System.out.println("--Porfavor seleccione modo de juego:---");
                        System.out.println("1. Stack-------------------------------");
                        System.out.println("2. VS_CPU------------------------------");
                        System.out.println("3. Salir-------------------------------");
                        int eleccion2 = scan.nextInt();
                        switch (eleccion2) {
                            case 1:
                                while (Exit != true) {
                                    System.out.println("-----------THE DOBBLE GAME-------------");
                                    System.out.println("---Ingrese la cantidad de jugadores:---");
                                    int numPlayers = scan.nextInt();

                                    System.out.println("-----------THE DOBBLE GAME-------------");
                                    System.out.println("---Ingrese la cantidad de elementos:---");
                                    int numElem = scan.nextInt();
                                    DobbleGame Tablero = new DobbleGame(numPlayers, numElem, "Stack");
                                    if(Tablero.getMazoDobblegame().isDobble() == false){
                                        break;
                                    }
                                    System.out.println(Tablero.getMazoDobblegame());

                                    String newName = scan.nextLine();
                                    while(0<Tablero.getNumPlayers()){
                                        System.out.println("-----------THE DOBBLE GAME-------------");
                                        System.out.println("--Ingrese el nombre de los jugadores---");
                                        System.out.println("--------Jugadores Restantes "+Tablero.getNumPlayers()+"----------");
                                        newName = scan.nextLine();
                                        Tablero.registUser(newName);
                                    }
                                    Tablero.setEstado("ReadyForPlay");
                                    Exit = true;
                                }
                                break;
                            case 2:
                                System.out.println("En proceso xd");
                                break;
                            case 3:
                                System.out.println("Hasta luego!!!");
                                Exit = true;
                                break;
                        }
                    }
                case 2:
                    System.out.println("Hasta luego!!!");
                    Exit = true;
                    break;

            }
        }
    }

    @Override
    public String toString() {
        return "Menu{" +
                "Tablero=" + Tablero +
                '}';
    }
}