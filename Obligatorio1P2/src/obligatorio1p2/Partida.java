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
    private Interfaz interfaz = new Interfaz();

    public Partida(int cantJugadores, int avesXjug, int fichasRotXJug, int totalTab, int tipoTerm, int cantTurnos) {
        this.cantJug = cantJugadores;
        this.cantAves = avesXjug;
        this.cantRot = fichasRotXJug;
        this.cantTab = totalTab;
        this.tipoTerm = tipoTerm;
        this.cantTurnos = cantTurnos;
        this.setTablero();
    }

    public Partida() {
        this.setCantJug(2);
        this.setCantAves(45);
        this.setCantRot(5);
        this.setCantTab(25);
        this.setTipoTerm(3);
        this.setCantTurnos(10);
        this.setTablero();
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

    public Tablero getTablero() {
        return this.tablero;
    }

    public void setTablero() {
        this.tablero = new Tablero();
    }

    public int getCantJug() {
        return this.cantJug;
    }

    public void setCantJug(int cantJugadores) {
        this.cantJug = cantJugadores;
    }

    public int getCantAves() {
        return this.cantAves;
    }

    public void setCantAves(int avesVXjug) {
        this.cantAves = avesVXjug;
    }

    public int getCantRot() {
        return this.cantRot;
    }

    public void setCantRot(int fichasRotXJug) {
        this.cantRot = fichasRotXJug;
    }

    public int getCantTab() {
        return this.cantTab;
    }

    public void setCantTab(int totalTab) {
        this.cantTab = totalTab;
    }

    public int getTipoTerm() {
        return this.tipoTerm;
    }

    public void setTipoTerm(int tipoTerm) {
        this.tipoTerm = tipoTerm;
    }

    public void iniciar() {
        switch (getTipoTerm()) {
            case 1:
                partidaConTerminacionTablero();
                break;

            case 2:
                partidaConTerminacionAves();
                break;

            case 3:
                partidaConTerminacionTurnos();
                break;
        }
    }

    public void partidaConTerminacionTurnos() {
        boolean salidaEmergencia = false;

        for (int turno = 1; turno <= cantTurnos; turno++) {
            for (int jug = 1; jug <= cantJug; jug++) {
                System.out.println(tablero.toString());
                salidaEmergencia = movimiento();
                if (salidaEmergencia) {
                    turno = this.cantTurnos + 1;
                    jug = this.cantJug + 1;
                }
            }
        }
    }

    public void partidaConTerminacionAves() {
        ArrayList<Jugador> jugadores = getTodosJug();
        boolean salidaEmergencia = false;
        boolean running = true;

        do {
            for (int jug = 1; jug <= cantJug; jug++) {
                System.out.println(tablero.toString());
                salidaEmergencia = movimiento();
                if (salidaEmergencia) {
                    running = false;
                    jug = this.cantJug + 1;
                }
                if (jugadores.get(jug).getCantAves() == 0) {
                    running = false;
                    jug = this.cantJug + 1;
                }
            }
        } while (running);
    }

    public void partidaConTerminacionTablero() {

    }

    public boolean movimiento() {
        int[] indices;
        int[] posicion1;
        int[] posicion2;
        String movimiento;
        String indicacion1 = "";
        String indicacion2 = "";
        int rotacion;
        char tipoMovimiento;
        boolean salidaEmergencia = false;
        boolean running = true;

        do {
            movimiento = this.interfaz.ingresarString("jugada");
            tipoMovimiento = movimiento.charAt(0);
            if (tipoMovimiento != 'X') {
                if (tipoMovimiento == 'P') {
                    indicacion1 = movimiento.substring(2);
                } else {
                    indices = this.interfaz.getIndicesDeIndicacion(1, movimiento);
                    indicacion1 = movimiento.substring(indices[0], indices[1]);
                    indices = this.interfaz.getIndicesDeIndicacion(2, movimiento);
                    indicacion2 = movimiento.substring(indices[0], indices[1]);
                }
            }
            switch (tipoMovimiento) {
                //Rotar
                case 'R':
                    posicion1 = traducirPosicion(indicacion1);
                    rotacion = Integer.parseInt(indicacion2);
                    this.tablero.rotar(posicion1[0], posicion1[1], rotacion);
                    running = false;
                    break;
                //Conectar
                case 'C':
                    posicion1 = traducirPosicion(indicacion1);
                    posicion2 = traducirPosicion(indicacion2);
                    this.tablero.conectar(posicion1[0], posicion1[1], posicion2[0], posicion2[1], ("\u001B[44m" + " " + "\033[0m"));
                    running = false;
                    break;
                //Poner ficha 
                case 'P':
                    posicion1 = traducirPosicion(indicacion1);
                    if (this.tablero.sePuedePonerFicha(posicion1[0], posicion1[1])) {
                        this.tablero.setFicha(posicion1[0], posicion1[1]);
                        running = false;
                    }
                    break;
                //Extender 
                case 'E':
                    
                    break;
                //Salir    
                case 'X':
                    salidaEmergencia = true;
                    running = false;
                    break;

            }
        } while (running);
        return salidaEmergencia;
    }

    public int[] traducirPosicion(String posicion) {
        int[] devolverPosicion = new int[2];
        char fila;

        fila = posicion.charAt(0);
        devolverPosicion[1] = Integer.parseInt(posicion.substring(1)) - 1;

        switch (fila) {
            case 'A':
                devolverPosicion[0] = 0;
                break;

            case 'B':
                devolverPosicion[0] = 1;
                break;

            case 'C':
                devolverPosicion[0] = 2;
                break;

            case 'D':
                devolverPosicion[0] = 3;
                break;

            case 'E':
                devolverPosicion[0] = 4;
                break;

            case 'F':
                devolverPosicion[0] = 5;
                break;

            case 'G':
                devolverPosicion[0] = 6;
                break;

            case 'H':
                devolverPosicion[0] = 7;
                break;

            case 'I':
                devolverPosicion[0] = 8;
                break;

            case 'J':
                devolverPosicion[0] = 9;
                break;
        }

        return devolverPosicion;
    }
}
