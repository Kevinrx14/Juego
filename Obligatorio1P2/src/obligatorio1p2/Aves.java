package obligatorio1p2;

import java.util.*;

public class Aves {

    private ArrayList<Partida> partidas;
    private ArrayList<Jugador> jugadores;
    private int[] configuracion;

    public Aves() {
        this.partidas = new ArrayList();
        this.jugadores = new ArrayList();
        this.configuracion = new int[]{2, 45, 5, 25, 3, 10};
    }

    public void setConfiguracion(int i, int configuracion) {
        this.configuracion[i] = configuracion;
    }

    public Partida configurarPart(
            int cantJug,
            int cantAves,
            int cantRot,
            int cantTab,
            int tipoTerm,
            int cantTurnos
    ) {
        Partida p = new Partida(cantJug, cantAves, cantRot, cantTab, tipoTerm, cantTurnos);
        return p;
    }

    public ArrayList<Partida> getPartidas() {
        return this.partidas;
    }

    public void setPartida() {
        this.partidas.add(new Partida(
                configuracion[0],
                configuracion[1],
                configuracion[2],
                configuracion[3],
                configuracion[4],
                configuracion[5]
        ));
    }

    public ArrayList<Jugador> getJugadores() {
        return this.jugadores;
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

    public void getRanking() {
        Collections.sort(this.getJugadores());
        for (int i = 0; i < getJugadores().size(); i++) {
            int tres = 0;
            int dos = 0;
            int uno = 0;
            String imprimo = i + 1 + "- " + getJugadores().get(i).toString();
            for (int j = 0; j < this.getPartidas().size(); j++) {
                for (int o = 0; o < this.getPartidas().get(j).getTodosJug().size(); o++) {
                    if (this.getPartidas().get(j).getTodosJug().get(0).equals(getJugadores().get(i))) {
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
        setPartida();
        int indice = this.getPartidas().size() - 1;
        Partida partida = this.getPartidas().get(indice);

        partida.iniciar();
    }
}
