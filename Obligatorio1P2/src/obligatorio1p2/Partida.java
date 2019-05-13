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
        this.tablero = new Tablero();
    }

    public Partida() {
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
            movimiento();
            if (instruccion.equals("x")) {
                running = false;
                System.out.println(running);
            }
        } while (running);
    }

    public void empezarTurno(Jugador j, Tablero t, int accion, int fila, int columna, int grados) {
        boolean turno = true;
        while (turno) {
            switch (accion) {
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
                    t.rotar(fila, columna, grados);
                    break;
                case 5:
                    this.terminarPartida();
                    break;
            }
        }
    }

    public void terminarPartida() {

    }

    public void movimiento() {
        int[] posicion;
        String movimiento;
        String indicacion1;
        String indicacion2;
        char tipoMovimiento;

        movimiento = this.interfaz.ingresarString("movimiento");
        movimiento = movimiento.toUpperCase();
        tipoMovimiento = movimiento.charAt(0);
        indicacion1 = movimiento.substring(2, 4);
        indicacion2 = movimiento.substring(5);

        switch (tipoMovimiento) {
            //Rotar
            case 'R':
                posicion = traducirPosicion(indicacion1);
                switch (indicacion2) {
                    case "90":
                        this.tablero.rotar(posicion[0], posicion[1], 90);
                        break;
                        
                    case "180":
                        this.tablero.rotar(posicion[0], posicion[1], 180);
                        break;
                        
                    case "270":
                        this.tablero.rotar(posicion[0], posicion[1], 270);
                        break;
                }
                
                break;
            //Conectar
            case 'C':

                break;
            //Poner ficha 
            case 'P':

                break;
            //Extender 
            case 'E':

                break;
            //Salir    
            case 'X':

                break;
        }
        System.out.println(tipoMovimiento + " " + indicacion1 + " " + indicacion2);

    }

    public int[] traducirPosicion(String posicion) {
        int[] devolverPosicion = new int[2];
        char fila;

        fila = posicion.charAt(0);
        devolverPosicion[1] = Integer.parseInt(posicion.substring(1));

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
