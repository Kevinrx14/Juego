/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package obligatorio1p2;
import java.util.*;
/**
 *
 * @author ezequiellopez
 */
public class Partida {
    private ArrayList<Jugador> todosJug;
    private int cantJugadores;
    private int avesXjug;
    private int fichasRotXJug;
    private int totalTab;
    private int tipoTerm;
    private Tablero tablero;
    private int cantTurnos;

    public int getCantTurnos() {
        return cantTurnos;
    }

    public void setCantTurnos(int cantTurnos) {
        this.cantTurnos = cantTurnos;
    }

    public ArrayList<Jugador> getTodosJug() {
        return todosJug;
    }

    public void setTodosJug(ArrayList<Jugador> todosJug) {
        this.todosJug = todosJug;
    }

    public Tablero getTablero() {
        return tablero;
    }

    public void setTablero(Tablero tablero) {
        this.tablero = tablero;
    }

    
    
    public int getCantJugadores() {
        return cantJugadores;
    }

    public void setCantJugadores(int cantJugadores) {
        this.cantJugadores = cantJugadores;
    }

    public int getAvesXjug() {
        return this.avesXjug;
    }

    public void setAvesXjug(int avesVXjug) {
        this.avesXjug = avesVXjug;
    }

    public int getFichasRotXJug() {
        return fichasRotXJug;
    }

    public void setFichasRotXJug(int fichasRotXJug) {
        this.fichasRotXJug = fichasRotXJug;
    }

    public int getTotalTab() {
        return totalTab;
    }

    public void setTotalTab(int totalTab) {
        this.totalTab = totalTab;
    }

    public int getTipoTerm() {
        return tipoTerm;
    }

    public void setTipoTerm(int tipoTerm) {
        this.tipoTerm = tipoTerm;
    }



    public Partida(int cantJugadores, int avesXjug, int fichasRotXJug, int totalTab, int tipoTerm, int cantTurnos) {
        this.cantJugadores = cantJugadores;
        this.avesXjug = avesXjug;
        this.fichasRotXJug = fichasRotXJug;
        this.totalTab = totalTab;
        this.tipoTerm = tipoTerm;
        this.cantTurnos = cantTurnos;
    }
    public Partida(){
        this.setCantJugadores(2);
        this.setAvesXjug(45);
        this.setFichasRotXJug(5);
        this.setTotalTab(25);
        this.setTipoTerm(3);
        this.setCantTurnos(10);
    }
    
    
    
    
    
}
