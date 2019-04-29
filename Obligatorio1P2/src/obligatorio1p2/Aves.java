/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package obligatorio1p2;

/**
 *
 * @author Ezequiel
 */
import java.util.*;

public class Aves {

    private static ArrayList<Partida> partidas;
    private static ArrayList<Jugador> jugadores;

    public static ArrayList<Partida> getPartidas() {
        return partidas;
    }

    public void setPartidas(ArrayList<Partida> partidas) {
        this.setPartidas(partidas);
    }

    public static ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(ArrayList<Jugador> jugadores) {
        this.setJugadores(jugadores);
    }

    public void agregarJugador(Jugador j) {
        boolean noEsta = true;
        for (int i = 0; i < getJugadores().size(); i++) {
            if (getJugadores().get(i).equals(j)) {
                noEsta = false;
            }
        }
        if (noEsta) {
            getJugadores().add(j);
        }
    }

    public static void agregarPartida(Partida p) {
        boolean noEsta = true;
        for (int i = 0; i < getPartidas().size(); i++) {
            if (getPartidas().get(i).equals(p)) {
                noEsta = false;
            }
        }
        if (noEsta) {
            getPartidas().add(p);
        }
    }

    // metodos de validacion de tipo primitivos
    public static int excepcion() {
        Scanner input = new Scanner(System.in);
        boolean excep = true;
        int retorno = 0;
        int valor = 0;
        do {
            try {
                valor = input.nextInt();
                excep = false;
            } catch (Exception e) {
                System.out.println("Verifique el valor ingresado");
                input.nextLine();
            }
        } while (excep);
        retorno = valor;
        return retorno;

    }

    public static int validar(int min, int max, int valor) {
        boolean valida = false;
        if (valor >= min && valor <= max) {
            valida = true;
        }
        while (!valida) {
            System.out.println("verifique el valor ingresado");
            valor = excepcion();
            if (valor >= min && valor <= max) {
                valida = true;
            }
        }
        return valor;
    }
}
