package view;

import model.DobbleGame;

import java.util.Scanner;

public class Menu {
    private DobbleGame Tablero;

    public void ejecutarMenu() {
        Scanner scan = new Scanner(System.in);
        int Exit = 1;   // 1 = no salir
        while (Exit < 2) {  // 2 = salir y 3 = continuar
            System.out.println("-----Bienvenid@s a THE DOBBLE GAME-----");
            System.out.println("-----Porfavor ingrese una opcion:------");
            System.out.println("----------1. Nueva Partida-------------");
            System.out.println("----------2. Salir---------------------");
            int eleccion = scan.nextInt();
            switch (eleccion) {
                case 1:
                    while (Exit < 2) {
                        System.out.println("-----------THE DOBBLE GAME-------------");
                        System.out.println("--Porfavor seleccione modo de juego:---");
                        System.out.println("----------1. Stack---------------------");
                        System.out.println("----------2. VS_CPU--------------------");
                        System.out.println("----------3. Salir---------------------");
                        int eleccion2 = scan.nextInt();
                        switch (eleccion2) {
                            case 1:
                                System.out.println("-----------THE DOBBLE GAME-------------");
                                System.out.println("------ Ha seleccionado Stack MODE -----");
                                System.out.println("Este modo consiste en que debe ingresar");
                                System.out.println("--el elemento en común entre 2 cartas--");
                                System.out.println("-------para poder ganas puntos.--------");
                                System.out.println("Porfavor toque any tecla para continuar");
                                scan.next();

                                while (Exit < 2) {
                                    System.out.println("-----------THE DOBBLE GAME-------------");
                                    System.out.println("---Ingrese la cantidad de elementos:---");
                                    System.out.println("(Tome en cuenta solo numeros no primos)");
                                    int numElem = scan.nextInt();

                                    System.out.println("-----------THE DOBBLE GAME-------------");
                                    System.out.println("---Ingrese la cantidad de jugadores:---");
                                    int numPlayers = scan.nextInt();

                                    Tablero = new DobbleGame(numPlayers, numElem, "Stack");
                                    if(Tablero.getMazoDobblegame().isDobble() == false){
                                        System.out.println("------Mazo no apto para jugar!!--------");
                                        break;
                                    }
                                    //System.out.println(Tablero.getMazoDobblegame());

                                    String newName = scan.nextLine();
                                    while(0<Tablero.getNumPlayers()){
                                        System.out.println("-----------THE DOBBLE GAME-------------");
                                        System.out.println("--Ingrese el nombre de los jugadores---");
                                        System.out.println("--------Jugadores Restantes "+Tablero.getNumPlayers()+"----------");
                                        newName = scan.nextLine();
                                        Tablero.registUser(newName);
                                    }
                                    Tablero.setEstado("ReadyForPlay");
                                    Exit = 3;
                                    break;
                                }
                                break;
                            case 2:
                                System.out.println("En proceso xd");
                                break;
                            case 3:
                                System.out.println("Hasta luego!!!");
                                Exit = 2;
                                break;
                        }
                    }
                    break;
                case 2:
                    System.out.println("Hasta luego!!!");
                    Exit = 2;
                    break;
            }
            if(Exit == 3){
                System.out.println("-----------THE DOBBLE GAME-------------");
                System.out.println("-----Partida lista que desea hacer-----");
                System.out.println("-------------1. JUGAR!!!---------------");
                System.out.println("-------------2. Salir:c----------------");
                int eleccion3 = scan.nextInt();
                switch (eleccion3) {
                    case 1:
                        int Seleccion = 0;
                        int posicion =0;
                        Tablero.setEstado("En progreso");
                        while(Tablero.getEstado().equals("En progreso")) {
                            if( 2 < Tablero.getMazoDobblegame().getMazo().size() || Tablero.getEstado().equals("Finalizado") ){
                                posicion = Tablero.getPosicionForName(Tablero.whoseTurnIs());
                                System.out.println("-----------THE DOBBLE GAME-------------");
                                System.out.println("----------- Turno de: " + Tablero.whoseTurnIs() + " ------------");
                                System.out.println("----- Puntos: " + Tablero.getPointForName(Tablero.whoseTurnIs()) + " ------ Turno: " + Tablero.getTurnForName(Tablero.whoseTurnIs()) + " -------");
                                System.out.println("---------------------------------------");
                                System.out.println("------ " + Tablero.getMazoDobblegame().getMazo().get(0) + " --- " + Tablero.getMazoDobblegame().getMazo().get(1) + " --------");
                                System.out.println("---------------------------------------");
                                System.out.println("---Escriba 0 si desea pasar su turno---");
                                System.out.println("-Escriba -1 si desea finalizar el game-");
                                System.out.println("---------------------------------------");
                                Seleccion = scan.nextInt();
                                Tablero.play(Seleccion, Tablero.getMazoDobblegame(), posicion);
                            }
                            else{
                                Tablero.setEstado("Finalizado");
                            }

                        }
                        break;

                    case 2:
                        System.out.println("Hasta luego!!!");
                        break;
                }
            }
        }
    }

    @Override
    public String toString() {
        return Tablero +"";
    }
}