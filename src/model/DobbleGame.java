package model;

import java.util.ArrayList;

public class DobbleGame {
    private String estado;
    private Dobble mazoDobblegame;
    private Integer numPlayers;
    private String modalidad;
    private ArrayList<Player> ListPlayers;

    public DobbleGame(Integer NumPlayers, Integer TamCardSet, String modo){
        ListPlayers = new ArrayList<Player>();
        mazoDobblegame = new Dobble( (TamCardSet), -1, true);
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
    public void registUser (String nombre){
        if(0 < numPlayers){
            boolean repetido = false;
            for(int i=0; i<ListPlayers.size();i++){
                String nameAux = new String(ListPlayers.get(i).getName());
                if(nameAux.equals(nombre)){
                    repetido = true;
                    System.out.println("--------------------------------------");
                    System.out.println("-------Jugador ya registrado!!!-------");
                    System.out.println("--------------------------------------");
                }
            }
            if(repetido == false) {
                Player jugador = new Player(nombre);
                ListPlayers.add(jugador);
                numPlayers = numPlayers - 1;
            }
        }
    }
    // -----------------------------------------------------------------------------
    public String whoseTurnIs(){
        int menor=ListPlayers.get(0).getTurno();
        String nameMenor = new String(ListPlayers.get(0).getName());
        for(int i=1; i < ListPlayers.size();i++){
            if(ListPlayers.get(i).getPuntos() < menor){
                menor = ListPlayers.get(i).getTurno();
                nameMenor = ListPlayers.get(i).getName();
            }
        }
        return nameMenor;
    }

    public Integer getPointForName(String name){
        int i= 0;
        while(!ListPlayers.get(i).getName().equals(name)) {
            System.out.println(ListPlayers.get(i).getName());
            i++;
        }
        return ListPlayers.get(i).getPuntos();
    }

    public Integer getTurnForName(String name){
        int i= 0;
        while(!ListPlayers.get(i).getName().equals(name)) {
            System.out.println(ListPlayers.get(i).getName());
            i++;
        }
        return ListPlayers.get(i).getTurno();
    }

    // -----------------PLAY--------------------------------------------------------





    @Override
    public String toString() {
        return "DobbleGame{" +
                "estado='" + estado + '\'' +
                ", mazoDobblegame=" + mazoDobblegame +
                ", numPlayers=" + numPlayers +
                ", modalidad='" + modalidad + '\'' +
                ", ListPlayers=" + ListPlayers +
                '}';
    }
}
