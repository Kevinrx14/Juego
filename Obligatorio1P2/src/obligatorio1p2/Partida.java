package obligatorio1p2;
import java.util.*;

public class Partida {
    private ArrayList<Jugador> jugadores;
    private Tablero tablero;
    private int cantJug;
    private int cantAves;
    private int cantRot;
    private int cantTab;
    private int tipoTerm;
    private int cantTurnos;

    public Partida(int cantJugadores, int avesXjug, int fichasRotXJug, int totalTab, int tipoTerm, int cantTurnos) {
        this.cantJug = cantJugadores;
        this.cantAves = avesXjug;
        this.cantRot = fichasRotXJug;
        this.cantTab = totalTab;
        this.tipoTerm = tipoTerm;
        this.cantTurnos = cantTurnos;
        this.tablero = new Tablero();
    }
    public Partida(){
        this.setCantJug(2);
        this.setCantAves(45);
        this.setCantRot(5);
        this.setCantTab(25);
        this.setTipoTerm(3);
        this.setCantTurnos(10);
        this.tablero = new Tablero();
    }
    
    public int getCantTurnos() {
        return cantTurnos;
    }

    public void setCantTurnos(int cantTurnos) {
        this.cantTurnos = cantTurnos;
    }

    public ArrayList<Jugador> getTodosJug() {
        return jugadores;
    }

    public void setTodosJug(ArrayList<Jugador> todosJug) {
        this.jugadores = todosJug;
    }

    /*public Tablero getTablero() {
        return tablero;
    }*/

   /* public void setTablero(Tablero tablero) {
        this.tablero = tablero;
    }*/

    
    
    public int getCantJug() {
        return cantJug;
    }

    public void setCantJug(int cantJugadores) {
        this.cantJug = cantJugadores;
    }

    public int getCantAves() {
        return cantAves;
    }

    public void setCantAves(int avesVXjug) {
        this.cantAves = avesVXjug;
    }

    public int getCantRot() {
        return cantRot;
    }

    public void setCantRot(int fichasRotXJug) {
        this.cantRot = fichasRotXJug;
    }

    public int getCantTab() {
        return cantTab;
    }

    public void setCantTab(int totalTab) {
        this.cantTab = totalTab;
    }

    public int getTipoTerm() {
        return tipoTerm;
    }

    public void setTipoTerm(int tipoTerm) {
 
        this.tipoTerm = tipoTerm;
    }

    public void iniciar() {
        Scanner input = new Scanner(System.in);
        boolean running = true;
        
        do {
            System.out.println(tablero.toString());
            
            //test
            System.out.println("instruccion");
            String instruccion = input.nextLine();
            if(instruccion.equals("x")) {
                running = false;
                System.out.println(running);
            }
        } while(running);
    }
    
    public void empezarTurno(Jugador j, Tablero t, int accion, int fila, int columna, int grados){
        boolean turno=true;
        while(turno){
            switch(accion){
                case 1:
                    t.agregarFicha(fila, columna);
                    break;
                case 2:
                    //Conectar 2 puntos y poner aves
                    break;
                case 3:
                    //Extender linea de aves
                    break;
                case 4:
                    t.rotar(fila, columna,grados);
                    break;
                case 5:
                    this.terminarPartida();
                    break;
            }
            }
        }
        public void terminarPartida(){
        
        }
    }

