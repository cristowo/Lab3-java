package view;

import model.DobbleGame;

import java.util.Random;
import java.util.Scanner;

public class Menu {
    private DobbleGame Tablero;

    public void ejecutarMenu() {
        Scanner scan = new Scanner(System.in);
        int Exit = 1;   // 1 = no salir
        Scanner enter = new Scanner(System.in); // enter to continue
        while (Exit < 2) {  // 2 = salir y 3 = continuar
            System.out.println("---------------------------------------");
            System.out.println("-----Bienvenid@s a THE DOBBLE GAME-----");
            System.out.println("-----Porfavor ingrese una opcion:------");
            System.out.println("----------1. Nueva Partida-------------");
            System.out.println("----------2. Salir---------------------");
            System.out.println("---------------------------------------");
            int eleccion = scan.nextInt();
            switch (eleccion) {
                case 1:
                    while (Exit < 2) {
                        // SELECCIONAR MODO DE JUEGO
                        System.out.println("---------------------------------------");
                        System.out.println("-----------THE DOBBLE GAME-------------");
                        System.out.println("--Porfavor seleccione modo de juego:---");
                        System.out.println("----------1. Stack---------------------");
                        System.out.println("----------2. VS_CPU--------------------");
                        System.out.println("----------3. Salir---------------------");
                        System.out.println("---------------------------------------");
                        int eleccion2 = scan.nextInt();
                        switch (eleccion2) {
                            case 1:
                                // REGLAS GENERALES STACK MODE
                                System.out.println("---------------------------------------");
                                System.out.println("-----------THE DOBBLE GAME-------------");
                                System.out.println("------ Ha seleccionado Stack MODE -----");
                                System.out.println("Este modo consiste en que debe ingresar");
                                System.out.println("--el elemento en común entre 2 cartas--");
                                System.out.println("-------para poder ganas puntos.--------");
                                System.out.println("--Porfavor toca Enter para continuar---");
                                System.out.println("---------------------------------------");
                                enter.nextLine();

                                while (Exit < 2) {
                                    // CANTIDAD DE ELEMENTOS POR CARTA
                                    System.out.println("---------------------------------------");
                                    System.out.println("-----------THE DOBBLE GAME-------------");
                                    System.out.println("---Ingrese la cantidad de elementos:---");
                                    System.out.println("(Tome en cuenta solo numeros no primos)");
                                    System.out.println("---------------------------------------");
                                    int numElem = scan.nextInt();
                                    // CANTIDAD DE JUGADORES A REGISTRAR
                                    System.out.println("---------------------------------------");
                                    System.out.println("-----------THE DOBBLE GAME-------------");
                                    System.out.println("---Ingrese la cantidad de jugadores:---");
                                    System.out.println("---------------------------------------");
                                    int numPlayers = scan.nextInt();
                                    // CASO DE JUGAR SOLO
                                    if(numPlayers <= 1){
                                        System.out.println("---------------------------------------");
                                        System.out.println("--------NO PUEDES JUGAR SOLO!!!--------");
                                        System.out.println("---------------------------------------");
                                        break;
                                    }
                                    // CASO MAZO INVALIDO
                                    Tablero = new DobbleGame(numPlayers, numElem, "Stack");
                                    if(Tablero.getMazoDobblegame().isDobble() == false){
                                        System.out.println("---------------------------------------");
                                        System.out.println("------Mazo no apto para jugar!!--------");
                                        System.out.println("---------------------------------------");
                                        break;
                                    }
                                    //System.out.println(Tablero.getMazoDobblegame());

                                    String newName = scan.nextLine();
                                    // REGISTRAR JUGADORES
                                    while(0<Tablero.getNumPlayers()){
                                        System.out.println("---------------------------------------");
                                        System.out.println("-----------THE DOBBLE GAME-------------");
                                        System.out.println("--Ingrese el nombre de los jugadores---");
                                        System.out.println("--------Jugadores Restantes "+Tablero.getNumPlayers()+"----------");
                                        System.out.println("---------------------------------------");
                                        newName = scan.nextLine();
                                        Tablero.registUser(newName);
                                    }
                                    Tablero.setEstado("ReadyForPlay");
                                    Exit = 3;
                                    break;
                                }
                                break;
                            case 2:
                                // REGLAS GENERALES MODO VS CPU
                                System.out.println("---------------------------------------");
                                System.out.println("-----------THE DOBBLE GAME-------------");
                                System.out.println("-- Ha seleccionado PLAYER VS CPU MODE -");
                                System.out.println("Este modo consiste en que debe ingresar");
                                System.out.println("--el elemento en común entre 2 cartas--");
                                System.out.println("-------para poder ganas puntos---------");
                                System.out.println("---mientras compites contra la CPU.----");
                                System.out.println("--Porfavor toca Enter para continuar---");
                                System.out.println("---------------------------------------");
                                enter.nextLine();

                                while (Exit < 2) {
                                    // CANTIDAD DE ELEMENTOS POR CARTA
                                    System.out.println("---------------------------------------");
                                    System.out.println("-----------THE DOBBLE GAME-------------");
                                    System.out.println("---Ingrese la cantidad de elementos:---");
                                    System.out.println("(Tome en cuenta solo numeros no primos)");
                                    System.out.println("---------------------------------------");
                                    int numElem = scan.nextInt();
                                    // COMPROBAR MAZO VALIDO
                                    Tablero = new DobbleGame(2, numElem, "VSCPU");
                                    if (Tablero.getMazoDobblegame().isDobble() == false) {
                                        System.out.println("---------------------------------------");
                                        System.out.println("------Mazo no apto para jugar!!--------");
                                        System.out.println("---------------------------------------");
                                        break;
                                    }
                                    Tablero.registUser("CPU");
                                    String newName = scan.nextLine();
                                    // REGISTRAR USUARIO HASTA QUE SEA VALIDO
                                    while (0 < Tablero.getNumPlayers()) {
                                        System.out.println("---------------------------------------");
                                        System.out.println("-----------THE DOBBLE GAME-------------");
                                        System.out.println("----------Ingrese su nombre:-----------");
                                        System.out.println("---------------------------------------");
                                        newName = scan.nextLine();
                                        Tablero.registUser(newName);
                                    }
                                    Exit = 3;
                                    break;
                                }
                                break;
                            case 3:
                                // SALIDA
                                System.out.println("Hasta luego!!!");
                                Exit = 2;
                                break;
                        }
                    }
                    break;
                case 2:
                    // SALIDA
                    System.out.println("Hasta luego!!!");
                    Exit = 2;
                    break;
            }
            // INICIO JUEGO
            if(Exit == 3){
                System.out.println("---------------------------------------");
                System.out.println("-----------THE DOBBLE GAME-------------");
                System.out.println("-----Partida lista que desea hacer-----");
                System.out.println("-------------1. JUGAR!!!---------------");
                System.out.println("-------------2. Salir:c----------------");
                System.out.println("---------------------------------------");
                int eleccion3 = scan.nextInt();
                switch (eleccion3) {
                    case 1:
                        int Seleccion = 0;
                        int posicion =0;
                        Tablero.setEstado("En progreso");
                        while(Tablero.getEstado().equals("En progreso")) {
                            // DESARROLLO DEL JUEGO
                            if(  2 < Tablero.getMazoDobblegame().getMazo().size()){
                                posicion = Tablero.getPosicionForName(Tablero.whoseTurnIs());
                                System.out.println("---------------------------------------");
                                System.out.println("-----------THE DOBBLE GAME-------------");
                                System.out.println("----------- Turno de: " + Tablero.whoseTurnIs() + " ------------");
                                System.out.println("----- Puntos: " + Tablero.getScoreForName(Tablero.whoseTurnIs()) + " ------ Turno: " + Tablero.getTurnForName(Tablero.whoseTurnIs()) + " -------");
                                System.out.println("---------------------------------------");
                                System.out.println("---- " + Tablero.getMazoDobblegame().getMazo().get(0) + " --- " + Tablero.getMazoDobblegame().getMazo().get(1) + " ----");
                                System.out.println("---------------------------------------");
                                // PLAYER VS PLAYER
                                if (Tablero.getModalidad().equals("Stack")){
                                    System.out.println("---Escriba 0 si desea pasar su turno---");
                                    System.out.println("-Escriba -1 si desea finalizar el game-");
                                    System.out.println("---------------------------------------");
                                    Seleccion = scan.nextInt();
                                }
                                // VS CPU
                                else if (Tablero.getModalidad().equals("VSCPU")){
                                    Random random = new Random();
                                    // TURNO CPU, SE PIDE TOCAR ENTER
                                    if(Tablero.whoseTurnIs().equals("CPU")){
                                        // PROBABILIDAD DE QUE EL CPU GANE 1 PUNTO = 66,666%
                                        int numRandom = random.nextInt(3);
                                        if(numRandom <= 2){
                                            Seleccion = Tablero.getMazoDobblegame().getMazo().get(0).EleComun(Tablero.getMazoDobblegame().getMazo().get(1)).get(0);
                                        }
                                        else{
                                            Seleccion= Tablero.getMazoDobblegame().getMazo().get(0).getCarta().get(numRandom);
                                        }
                                        System.out.println("-----PRESIONE ENTER PARA CONTINUAR-----");
                                        System.out.println("---------------------------------------");
                                        enter.nextLine();
                                    }
                                    // TURNO PLAYER
                                    else{
                                        System.out.println("---Escriba 0 si desea pasar su turno---");
                                        System.out.println("-Escriba -1 si desea finalizar el game-");
                                        System.out.println("---------------------------------------");
                                        Seleccion = scan.nextInt();
                                    }
                                }
                                Tablero.play(Seleccion, Tablero.getMazoDobblegame(), posicion);
                            }
                            else{
                                Tablero.setEstado("Finalizado");
                            }
                        }
                        // FIN DEL JUEGO
                        System.out.println("---------------------------------------");
                        System.out.println("-----------THE DOBBLE GAME-------------");
                        System.out.println("---------- Juego terminado ------------");
                        System.out.println("---------------------------------------");
                        Tablero.resultado();
                        System.out.println("---------------------------------------");
                        break;
                    case 2:
                        System.out.println("Hasta luego!!!");
                        break;
                }
            }
        }
        enter.nextLine();
    }
}