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
public class Jugador implements Comparable {
    private String nombre;
    private int edad;
    private String alias;
    private int cantAves;
    private int cantRot;
    private int totalPartidas;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public int getCantAves() {
        return cantAves;
    }

    public void setCantAves(int cantAves) {
        this.cantAves = cantAves;
    }

    public int getCantRot() {
        return cantRot;
    }

    public void setCatRot(int catRot) {
        this.cantRot = catRot;
    }
    
    public int getTotalPartidas(){
        return this.totalPartidas;
    }
    
    public void setTotalPartidas(int unaCant){
        this.totalPartidas=unaCant;
    }

    public Jugador(String nombre, int edad, String alias) {
        this.nombre = nombre;
        this.edad = edad;
        this.alias = alias;
    }
    
    @Override
    public boolean equals(Object o){
        return (this.getNombre()==((Jugador)o).getNombre());
    }
    @Override
    public int compareTo(Object o){
        return this.getTotalPartidas()-((Jugador)o).getTotalPartidas();
    }
    @Override
    public String toString(){
        return this.getNombre();
    }
}
