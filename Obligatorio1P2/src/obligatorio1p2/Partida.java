/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package obligatorio1p2;

/**
 *
 * @author ezequiellopez
 */
public class Partida {
    private int cantJugadores;
    private int avesRXjug;
    private int avesAXjug;
    private int avesMXjug;
    private int avesVXjug;
    private int fichasRotXJug;
    private int totalTab;
    private int tipoTerm;

    public int getCantJugadores() {
        return cantJugadores;
    }

    public void setCantJugadores(int cantJugadores) {
        this.cantJugadores = cantJugadores;
    }

    public int getAvesRXjug() {
        return avesRXjug;
    }

    public void setAvesRXjug(int avesRXjug) {
        this.avesRXjug = avesRXjug;
    }

    public int getAvesAXjug() {
        return avesAXjug;
    }

    public void setAvesAXjug(int avesAXjug) {
        this.avesAXjug = avesAXjug;
    }

    public int getAvesMXjug() {
        return avesMXjug;
    }

    public void setAvesMXjug(int avesMXjug) {
        this.avesMXjug = avesMXjug;
    }

    public int getAvesVXjug() {
        return avesVXjug;
    }

    public void setAvesVXjug(int avesVXjug) {
        this.avesVXjug = avesVXjug;
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



    public Partida(int cantJugadores, int avesRXjug, int avesAXjug, int avesMXjug, int avesVXjug, int fichasRotXJug, int totalTab, int tipoTerm) {
        this.cantJugadores = cantJugadores;
        this.avesRXjug = avesRXjug;
        this.avesAXjug = avesAXjug;
        this.avesMXjug = avesMXjug;
        this.avesVXjug = avesVXjug;
        this.fichasRotXJug = fichasRotXJug;
        this.totalTab = totalTab;
        this.tipoTerm = tipoTerm;
    }
    public Partida(){
        this.setCantJugadores(2);
        this.setAvesRXjug(45);
        this.setAvesAXjug(45);
        this.setAvesMXjug(45);
        this.setAvesVXjug(45);
        this.setFichasRotXJug(5);
        this.setTotalTab(25);
        this.setTipoTerm(3);
    }
    
    
    
}
