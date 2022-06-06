package model;

import java.util.ArrayList;
import java.util.Objects;

public class DobbleGame implements interfases.DobbleGame {
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
            if(ListPlayers.get(i).getTurno() < menor){
                menor = ListPlayers.get(i).getTurno();
                nameMenor = ListPlayers.get(i).getName();
            }
        }
        return nameMenor;
    }

    public Integer getScoreForName(String name){
        int i= 0;
        while(!ListPlayers.get(i).getName().equals(name)) {
            i++;
        }
        return ListPlayers.get(i).getPuntos();
    }

    public Integer getTurnForName(String name){
        int i= 0;
        while(!ListPlayers.get(i).getName().equals(name)) {
            i++;
        }
        return ListPlayers.get(i).getTurno();
    }

    public Integer getPosicionForName(String name){
        for(int i=0 ; i<ListPlayers.size(); i++){
            if(ListPlayers.get(i).getName().equals(name)){
                return i;
            }
        }
        return 0;
    }
    //----------------- Put List --------------------------------------------------

    // ---------------- PLAY -------------------------------------------------------
    public void play(Integer elem, Dobble mazo, Integer posicion) {
        if (modalidad.equals("Stack")) {
            if (elem == 0) {
                ListPlayers.get(posicion).setTurno(ListPlayers.get(posicion).getTurno() + 1);
            }
            else if (elem < 0){
                setEstado("Finalizado");
            }
            else {
                Card cardAux = new Card();
                mazo.getMazo().get(0).CopyCard(cardAux);
                if (elem.equals(cardAux.EleComun(mazo.getMazo().get(1)).get(0))) {
                    ListPlayers.get(posicion).setPuntos(ListPlayers.get(posicion).getPuntos() + 1);
                    mazoDobblegame.EliminarCard();
                }
                ListPlayers.get(posicion).setTurno(ListPlayers.get(posicion).getTurno() + 1);
            }
        }
        else if (modalidad.equals("VSCPU")) {
            if (elem == 0) {
                ListPlayers.get(posicion).setTurno(ListPlayers.get(posicion).getTurno() + 1);
            }
            else if (elem < 0){
                setEstado("Finalizado");
            }
            else {
                Card cardAux = new Card();
                mazo.getMazo().get(0).CopyCard(cardAux);
                if (elem.equals(cardAux.EleComun(mazo.getMazo().get(1)).get(0))) {
                    ListPlayers.get(posicion).setPuntos(ListPlayers.get(posicion).getPuntos() + 1);
                    mazoDobblegame.EliminarCard();
                }
                ListPlayers.get(posicion).setTurno(ListPlayers.get(posicion).getTurno() + 1);
            }
        }
    }

    public void resultado(){
        ArrayList<String> puestos = new ArrayList<String>();
        int mayor = 0;
        for(int i=0; i < ListPlayers.size();i++){
            if(mayor < ListPlayers.get(i).getPuntos()){
                mayor = ListPlayers.get(i).getPuntos();
                puestos.clear();
                puestos.add(ListPlayers.get(i).getName());
            }
            else if(mayor == ListPlayers.get(i).getPuntos()){
                puestos.add(ListPlayers.get(i).getName());
            }
        }
        if(1 < puestos.size()){
            String result = new String(puestos.toString().replace("[",""));
            result = result.replace("]","");
            System.out.println("Ganadores: "+ result);
            System.out.println("Con puntaje de: "+ getScoreForName(puestos.get(0)) +" puntos.");
        }
        else {
            System.out.println("Ganador: "+puestos.get(0));
            System.out.println("Con puntaje de: "+ getScoreForName(puestos.get(0)) +" puntos.");
        }
    }

    //------------------------------------------------------------------------------------------------
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DobbleGame that = (DobbleGame) o;
        return Objects.equals(estado, that.estado) && Objects.equals(mazoDobblegame, that.mazoDobblegame) && Objects.equals(numPlayers, that.numPlayers) && Objects.equals(modalidad, that.modalidad) && Objects.equals(ListPlayers, that.ListPlayers);
    }
    //------------------------------------------------------------------------------------------------
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
