package obligatorio1p2;

public class Jugador implements Comparable {

    private String nombre;
    private String alias;
    private String colorJug;
    private int edad;
    private int cantAves;
    private int cantRot;
    private int totalPartidas;

    public Jugador(String nombre, int edad, String alias) {
        this.setNombre(nombre);
        this.setEdad(edad);
        this.setAlias(alias);
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return this.edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getAlias() {
        return this.alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public int getCantAves() {
        return this.cantAves;
    }

    public void setCantAves(int cantAves) {
        this.cantAves = cantAves;
    }

    public int getCantRot() {
        return this.cantRot;
    }

    public void setCatRot(int catRot) {
        this.cantRot = catRot;
    }

    public int getTotalPartidas() {
        return this.totalPartidas;
    }

    public void setTotalPartidas(int unaCant) {
        this.totalPartidas = unaCant;
    }

    public String getColorJugador() {
        return this.colorJug;
    }

    public void setColorJug(String color) {
        this.colorJug = color;
    }

    @Override
    public boolean equals(Object o) {
        return (this.getNombre() == ((Jugador) o).getNombre());
    }

    @Override
    public int compareTo(Object o) {
        return this.getTotalPartidas() - ((Jugador) o).getTotalPartidas();
    }

    @Override
    public String toString() {
        return this.getNombre();
    }
}
