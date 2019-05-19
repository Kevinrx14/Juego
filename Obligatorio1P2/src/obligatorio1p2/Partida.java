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
    private int indiceGanador;

    public Partida(
            int cantJugadores,
            int avesXjug,
            int fichasRotXJug,
            int totalTab,
            int tipoTerm,
            int cantTurnos,
            ArrayList<Jugador> jugadores
    ) {
        this.setCantJug(cantJugadores);
        this.setCantAves(avesXjug);
        this.setCantRot(fichasRotXJug);
        this.setCantTab(totalTab - 2);
        this.setTipoTerm(tipoTerm);
        this.setCantTurnos(cantTurnos);
        this.setTablero();
        this.setJugadores(jugadores);
        this.setConfigJugadores();
    }

    public int getCantTurnos() {
        return this.cantTurnos;
    }

    public void setCantTurnos(int cantTurnos) {
        this.cantTurnos = cantTurnos;
    }

    public ArrayList<Jugador> getJugadores() {
        return this.jugadores;
    }

    public void setJugadores(ArrayList<Jugador> todosJug) {
        this.jugadores = todosJug;
    }

    //Metodo que setea la cantidad de rotaciones, fichas y aves disponibles por jugador
    public void setConfigJugadores() {
        ArrayList<Jugador> jugadores = this.getJugadores();

        for (int i = 0; i < jugadores.size(); i++) {
            jugadores.get(i).setCantAves(this.getCantAves());
            jugadores.get(i).setCatRot(this.getCantRot());
        }
        this.setColorJugadores();
    }

    public String getColorJugador(int indice) {
        return this.getJugadores().get(indice).getColorJugador();
    }

    public void setColorJugadores() {
        Random rand = new Random();
        String aux = "";
        int[] colores = new int[this.getCantJug()];
        int num;
        boolean validador;

        for (int i = 0; i < this.getCantJug(); i++) {
            do {
                validador = true;
                num = rand.nextInt(4);
                num++;
                for (int x = 0; x < i; x++) {
                    if (colores[x] == num) {
                        validador = false;
                    }
                }
            } while (!validador);
            colores[i] = num;
            switch (colores[i]) {
                case 1:
                    aux = "\u001B[41m" + " " + "\033[0m"; //Color rojo
                    break;

                case 2:
                    aux = "\u001B[44m" + " " + "\033[0m"; //Color azul
                    break;

                case 3:
                    aux = "\u001B[43m" + " " + "\033[0m"; //Color amarillo
                    break;

                case 4:
                    aux = "\u001B[42m" + " " + "\033[0m"; //Color verde
                    break;
            }

            this.getJugadores().get(i).setColorJug(aux);
        }
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

    public int getIndiceGanador() {
        return this.indiceGanador;
    }

    public void setIndiceGanador(int indice) {
        this.indiceGanador = indice;
    }

    public String getGanador() {
        ArrayList<Jugador> jugadores = this.getJugadores();
        String alias = "";

        if (this.getIndiceGanador() == -1) {
            alias = jugadores.get(this.getIndiceGanador()).getAlias();
        }

        return alias;
    }

    public void iniciar() {
        switch (this.getTipoTerm()) {
            case 1:
                this.partidaConTerminacionTablero();
                break;

            case 2:
                this.partidaConTerminacionAves();
                break;

            case 3:
                this.partidaConTerminacionTurnos();
                break;
        }
    }

    public void partidaConTerminacionTurnos() {
        Tablero tablero = this.getTablero();
        boolean salidaEmergencia = false;

        for (int turno = 1; turno <= this.getCantTurnos(); turno++) {
            for (int jug = 0; jug < this.getCantJug(); jug++) {
                System.out.println(tablero.toString());
                salidaEmergencia = this.movimiento(jug);
                if (salidaEmergencia) {
                    turno = this.getCantTurnos() + 1;
                    jug = this.getCantJug() + 1;
                }
            }
        }
    }

    public void partidaConTerminacionAves() {
        ArrayList<Jugador> jugadores = this.getJugadores();
        Tablero tablero = this.getTablero();
        boolean salidaEmergencia = false;
        boolean running = true;

        do {
            for (int jug = 0; jug <= this.getCantJug(); jug++) {
                System.out.println(tablero.toString());
                salidaEmergencia = this.movimiento(jug);
                if (salidaEmergencia) {
                    running = false;
                    jug = this.getCantJug() + 1;
                }
                if (jugadores.get(jug).getCantAves() == 0) {
                    running = false;
                    jug = this.getCantJug() + 1;
                }
            }
        } while (running);
    }

    public void partidaConTerminacionTablero() {
        Tablero tablero = this.getTablero();
        int[] coordFilas = tablero.getCoordTablero5por5("filas");
        int[] coordCol = tablero.getCoordTablero5por5("columnas");
        boolean salidaEmergencia;
        boolean running = true;

        //Seteo la cantidad de tabletas en 23, sino el juego no termina.
        this.setCantTab(23);
        do {
            for (int jug = 0; jug <= this.getCantJug(); jug++) {
                System.out.println(tablero.toString());
                salidaEmergencia = this.movimiento(jug);
                if (salidaEmergencia) {
                    running = false;
                    jug = this.getCantJug() + 1;
                }
                if (tablero.validarSiTablero5por5EstaLleno(coordFilas, coordCol)) {
                    running = false;
                    jug = this.getCantJug() + 1;
                }
            }
        } while (running);
    }

    public char[] indColores(String movimiento) {
        char[] ordenados = new char[4];
        for (int i = 0; i < 4; i++) {
            ordenados[i] = movimiento.charAt(i);
        }
        return ordenados;
    }

    public boolean movimiento(int indiceJug) {
        int[] indices;
        Interfaz interfaz = new Interfaz();
        String movimiento;
        String indicacion1 = "";
        String indicacion2 = "";
        char tipoMovimiento;
        boolean salidaEmergencia = false;
        boolean running = true;

        do {
            movimiento = interfaz.ingresarString("jugada");
            tipoMovimiento = movimiento.charAt(0);
            if (tipoMovimiento != 'X') {
                if (tipoMovimiento == 'P') {
                    indicacion1 = movimiento.substring(2);
                } else {
                    indices = interfaz.getIndicesDeIndicacion(1, movimiento);
                    indicacion1 = movimiento.substring(indices[0], indices[1]);
                    indices = interfaz.getIndicesDeIndicacion(2, movimiento);
                    indicacion2 = movimiento.substring(indices[0], indices[1]);
                }
            }
            switch (tipoMovimiento) {
                //Rotar
                case 'R':
                    running = rotar(indicacion1, indicacion2, indiceJug);
                    break;
                //Conectar
                case 'C':
                    running = conectar(indicacion1, indicacion2, indiceJug);
                    break;
                //Poner ficha 
                case 'P':
                    if (movimiento.charAt(1) == 'M') {
                        running = ponerFichaArmada(movimiento);
                    } else {
                        running = ponerFicha(indicacion1);
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

    public boolean rotar(String indicacion1, String indicacion2, int indiceJug) {
        Interfaz interfaz = new Interfaz();
        int rotacionesDisponibles = this.getJugadores().get(indiceJug).getCantRot();
        int[] posicion1 = this.traducirPosicion(indicacion1);
        int rotacion = Integer.parseInt(indicacion2);
        boolean running = true;

        if (rotacionesDisponibles > 0) {
            this.getTablero().rotar(posicion1[0], posicion1[1], rotacion);
            rotacionesDisponibles--;
            this.getJugadores().get(indiceJug).setCatRot(rotacionesDisponibles);
            running = false;
        } else {
            System.out.println("No tiene rotaciones disponibles");
            interfaz.sonidoError();
        }

        return running;
    }

    public boolean ponerFicha(String indicacion1) {
        boolean running = true;
        int[] posicion1 = this.traducirPosicion(indicacion1);
        int cantTabletas = this.getCantTab();
        Interfaz interfaz = new Interfaz();

        if (cantTabletas > 0) {
            if (this.getTablero().sePuedePonerFicha(posicion1[0], posicion1[1])) {
                this.getTablero().setFicha(posicion1[0], posicion1[1]);
                running = false;
                this.setCantTab(cantTabletas - 1);
            }
        } else {
            System.out.println("No hay tabletas disponibles");
            interfaz.sonidoError();
        }

        return running;
    }

    public boolean ponerFichaArmada(String movimiento) {
        Interfaz interfaz = new Interfaz();
        boolean running = true;
        int[] posicion1 = this.traducirPosicion(movimiento.substring(3));
        char[] ordenColores = this.indColores(movimiento.substring(6));
        int cantTabletas = this.getCantTab();

        if (cantTabletas > 0) {
            if (this.getTablero().sePuedePonerFicha(posicion1[0], posicion1[1])) {
                this.getTablero().fichaManual(posicion1[0], posicion1[1], ordenColores);
                running = false;
                this.setCantTab(cantTabletas - 1);
            }
        } else {
            System.out.println("No hay tabletas disponibles");
            interfaz.sonidoError();
        }

        return running;
    }

    public boolean conectar(String indicacion1, String indicacion2, int indiceJug) {
        int[] posicion1 = this.traducirPosicion(indicacion1);
        int[] posicion2 = this.traducirPosicion(indicacion2);
        String colorJug = this.getColorJugador(indiceJug);
        boolean running = false;

        this.getTablero().conectar(posicion1[0], posicion1[1], posicion2[0], posicion2[1], colorJug);

        return running;
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

    public void terminarPartida() {
        ArrayList<Jugador> jugadores = this.getJugadores();
        String alias;
        int aux;
        int mayor = 0;
        int indiceJug = 0;

        for (int i = 0; i < jugadores.size(); i++) {
            aux = jugadores.get(i).getCantAves();
            if (aux > mayor) {
                mayor = aux;
                indiceJug = i;
            }
        }

        this.setIndiceGanador(indiceJug);
        alias = jugadores.get(indiceJug).getAlias();
        System.out.println("El ganador es " + alias + "con " + mayor + " aves");
    }
}
