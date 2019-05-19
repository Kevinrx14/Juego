package obligatorio1p2;

import java.util.*;

public class Aves {

    private ArrayList<Partida> partidas;
    private ArrayList<Jugador> jugadores;
    private int[] configuracion;

    public Aves() {
        this.setPartidas();
        this.setJugadores();
        this.setDefaultConfig();
        this.setJugador("Kevin", 21, "Kevinrx");
        this.setJugador("Ezequiel", 20, "EzeL");
    }

    public int[] getConfiguracion() {
        return this.configuracion;
    }

    public void setDefaultConfig() {
        this.configuracion = new int[]{2, 45, 5, 25, 3, 10};
    }

    public void setUnaConfiguracion(int i, int configuracion) {
        this.configuracion[i] = configuracion;
    }
    public Partida configurarPart(int cantJug,int cantAves,int cantRot,int cantTab,int tipoTerm,int cantTurnos) {
        Partida p = new Partida(cantJug, cantAves, cantRot, cantTab, tipoTerm, cantTurnos);
        return p;
    }
    public ArrayList<Partida> getPartidas() {
        return this.partidas;
    }

    public void setPartidas() {
        this.partidas = new ArrayList<Partida>();
    }

    /*
    Configuracion segun el indice:
    0 - Cantidad de jugadores
    1 - Aves por jugador
    2 - Rotaciones por Jugador
    3 - Tableta por jugador
    4 - Tipo de terminacion
    5 - Cantidad de turnos
     */
    public void setUnaPartida(ArrayList<Jugador> jugadores) {
        int[] configuracion = this.getConfiguracion();
        this.partidas.add(new Partida(
                configuracion[0],
                configuracion[1],
                configuracion[2],
                configuracion[3],
                configuracion[4],
                configuracion[5],
                jugadores
        ));
    }

    public ArrayList<Jugador> getJugadores() {
        return this.jugadores;
    }

    public void setJugadores() {
        this.jugadores = new ArrayList<Jugador>();
    }

    public void setJugador(String nombre, int edad, String alias) {
        boolean existe = false;

        for (int i = 0; i < getJugadores().size(); i++) {
            if (this.getJugadores().get(i).getAlias().equals(alias)) {
                existe = true;
            }
        }
        if (!existe) {
            this.getJugadores().add(new Jugador(nombre, edad, alias));
        }
    }

    public void setPartidaGanada(String alias, int cantJug) {

    }

    public void getRanking() {
        Collections.sort(this.getJugadores());
        for (int i = 0; i < getJugadores().size(); i++) {
            int tres = 0;
            int dos = 0;
            int uno = 0;
            String imprimo = i + 1 + "- " + getJugadores().get(i).toString();
            for (int j = 0; j < this.getPartidas().size(); j++) {
                for (int o = 0; o < this.getPartidas().get(j).getJugadores().size(); o++) {
                    if (this.getPartidas().get(j).getJugadores().get(0).equals(getJugadores().get(i))) {
                        if (this.getPartidas().get(j).getCantJug() == 4) {
                            tres = tres + 1;
                        }
                        if (this.getPartidas().get(j).getCantJug() == 3) {
                            dos = dos + 1;
                        }
                        if (this.getPartidas().get(j).getCantJug() == 2) {
                            uno = uno + 1;
                        }
                    }
                }
            }
            imprimo = imprimo + " | Partidas contra 3 jugadores: " + tres + " | Partidas contra 2 jugadores: " + dos + " | Partidas contra 1 jugador: " + uno;
            System.out.println(imprimo);
        }
    }

    public void jugar() {
        ArrayList<Jugador> jugPartida = this.getJugadoresPartida();

        if (jugPartida.size() > 0) {
            setUnaPartida(jugPartida);
            int indice = this.getPartidas().size() - 1;
            Partida partida = this.getPartidas().get(indice);

            partida.iniciar();
        }
    }

    public ArrayList<Jugador> getJugadoresPartida() {
        ArrayList<Jugador> jugadores = this.getJugadores();
        ArrayList<Jugador> jugadoresAux = new ArrayList<>();
        int[] configuracion = this.getConfiguracion();
        Interfaz interfaz = new Interfaz();
        int cantJug = configuracion[0];
        int aux = 0;

        for (int i = 0; i < jugadores.size(); i++) {
            String alias = jugadores.get(i).getAlias();
            System.out.println((i + 1) + " - " + alias);
        }
        System.out.println("\n" + "0 - Salir");

        for (int i = 0; i < cantJug; i++) {
            aux = interfaz.ingresarInt("elegirJug") - 1;
            if (aux >= 0) {
                jugadoresAux.add(jugadores.get(aux));
            } else {
                i = cantJug;
            }
        }

        return jugadoresAux;
    }
}
