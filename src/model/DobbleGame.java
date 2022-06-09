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

    /**
     * Obtiene el estado del game
     * @return String estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Modifica estado de un juego (String)
     * @ param estado (String)
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Obtiene el mazo del juego (Dobble)
     * @return mazo (Dobble)
     */
    public Dobble getMazoDobblegame() {
        return mazoDobblegame;
    }

    /**
     * Modifica el mazo del juego (Dobble)
     * @ param mazo (Dobble)
     */
    public void setMazoDobblegame(Dobble mazoDobblegame) {
        this.mazoDobblegame = mazoDobblegame;
    }

    /**
     * Obtiene el numero de jugadores (Integer)
     * @return numero de players (Innteger)
     */
    public Integer getNumPlayers() {
        return numPlayers;
    }

    /**
     * Modifica el numero de jugadores (Integer)
     * @ param Integer numero
     */
    public void setNumPlayers(Integer numPlayers) {
        this.numPlayers = numPlayers;
    }

    /**
     * Obtiene un String con la modalidad actual del juego
     * @return String modalidad
     */
    public String getModalidad() {
        return modalidad;
    }

    /**
     * Modifica la modalidad (String)
     * @ param modalidad (String)
     */
    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }

    /**
     * Obtiene un Arraylist de los jugadores (Arraylist<Player>)
     * @return Lista de jugadores (Arraylist<Player>)
     */
    public ArrayList<Player> getListPlayers() {
        return ListPlayers;
    }

    /**
     * Modifica la lista de jugadores (Arraylist<Player>)
     * @ param Lista de jugadores (Arraylist<Player>)
     */
    public void setListPlayers(ArrayList<Player> listPlayers) {
        ListPlayers = listPlayers;
    }

    /**
     * Registra a un usuario, en donde si esta repetido no se agrega
     * @ param String nombre
     */
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

    /**
     * Obtiene un String con el nombre del jugador en turno actual
     * @return String name
     */
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

    /**
     * Obtiene un Integer con el puntaje de un jugador segun su nombre
     * @ param String nombre
     * @return Integer puntaje
     */
    public Integer getScoreForName(String name){
        int i= 0;
        while(!ListPlayers.get(i).getName().equals(name)) {
            i++;
        }
        return ListPlayers.get(i).getPuntos();
    }

    /**
     * Obtiene un Integer con el turno de un jugador segun su nombre
     * @ param String nombre
     * @return Integer turno
     */
    public Integer getTurnForName(String name){
        int i= 0;
        while(!ListPlayers.get(i).getName().equals(name)) {
            i++;
        }
        return ListPlayers.get(i).getTurno();
    }

    /**
     * Obtiene la posicion de un jugador en la lista segun su nombre
     * @ param String nombre
     * @return Integer posicion
     */
    public Integer getPosicionForName(String name){
        for(int i=0 ; i<ListPlayers.size(); i++){
            if(ListPlayers.get(i).getName().equals(name)){
                return i;
            }
        }
        return 0;
    }

    /**
     * Modifica el game segun su modalidad
     * @ param Integer Elemento en común, Dobble el mazo en juego, Integer posicion del jugador
     */
    public void play(Integer elem, Dobble mazo, Integer posicion) {
        // Caso para jugadores en Stack Mode
        if (modalidad.equals("Stack")) {
            //Saltar turno
            if (elem == 0) {
                ListPlayers.get(posicion).setTurno(ListPlayers.get(posicion).getTurno() + 1);
            }
            // Terminar juego
            else if (elem < 0){
                setEstado("Finalizado");
            }
            else {
                // Respuesta correcta
                if (elem.equals(mazo.getMazo().get(0).EleComun(mazo.getMazo().get(1)).get(0))) {
                    ListPlayers.get(posicion).setPuntos(ListPlayers.get(posicion).getPuntos() + 1);
                    mazoDobblegame.EliminarCard();
                }
                // Respuesta incorrecta
                ListPlayers.get(posicion).setTurno(ListPlayers.get(posicion).getTurno() + 1);
            }
        }
        // Modalidad Player vs CPU
        else if (modalidad.equals("VSCPU")) {
            // Saltar turno
            if (elem == 0) {
                ListPlayers.get(posicion).setTurno(ListPlayers.get(posicion).getTurno() + 1);
            }
            // Finalizar juego
            else if (elem < 0){
                setEstado("Finalizado");
            }
            else {
                // Respuesta correcta
                if (elem.equals(mazo.getMazo().get(0).EleComun(mazo.getMazo().get(1)).get(0))) {
                    ListPlayers.get(posicion).setPuntos(ListPlayers.get(posicion).getPuntos() + 1);
                    mazoDobblegame.EliminarCard();
                }
                // Respuesta incorrecta
                ListPlayers.get(posicion).setTurno(ListPlayers.get(posicion).getTurno() + 1);
            }
        }
    }

    /**
     * Muestra el resutalado de un juego finalizado
     */
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
        // Caso de empate
        if(1 < puestos.size()){
            String result = new String(puestos.toString().replace("[",""));
            result = result.replace("]","");
            System.out.println("Ganadores: "+ result);
            System.out.println("Con puntaje de: "+ getScoreForName(puestos.get(0)) +" puntos.");
        }
        // Caso de victoria
        else {
            System.out.println("Ganador: "+puestos.get(0));
            System.out.println("Con puntaje de: "+ getScoreForName(puestos.get(0)) +" puntos.");
        }
    }

    /**
     * Obtiene un True si dos games son iguales, contrario a esto obtiene un false
     * @return Boolean
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DobbleGame that = (DobbleGame) o;
        if(Objects.equals(estado, that.estado) && mazoDobblegame.equals(mazoDobblegame) && Objects.equals(numPlayers, that.numPlayers) && Objects.equals(modalidad, that.modalidad)){
            if(ListPlayers.size() != that.ListPlayers.size()){
                return false;
            }
            else{
                int aux = 0;
                for(int i=0; i<ListPlayers.size();i++){
                    for(int j=0; j<that.ListPlayers.size();j++){
                        if(ListPlayers.get(i).equals(ListPlayers.get(j))){
                            aux++;
                        }
                    }
                }
                if(aux == ListPlayers.size()){
                    return true;
                }
                else{
                    return false;
                }
            }
        }
        else{
            return false;
        }
    }
    /**
     * Convierte el contendio de DobbleGame a String
     * @return estado, mazoDobblegame, numPlayers, modalidad, ListPlayers como String
     */
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
