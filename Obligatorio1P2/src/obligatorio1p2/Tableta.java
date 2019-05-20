
package obligatorio1p2;
import java.util.*;

public class Tableta {
    private String[][] tableta = new String[2][2];

    public void setAves(int fila, int col, String color){
        this.tableta[fila][col] = color;
        this.tableta[fila][col] = this.tableta[fila][col].replaceAll(" ", "x");
    }
    
    public boolean hayAves(int fila, int col) {
        boolean validador = false;
        
        if(devolverUnColor(fila, col).indexOf('x') == 5) {
            validador = true;
        }
        
        return validador;
    }
    public void dibujarAve(int fila, int columna, String color){
        switch (color){
            case ("\u001B[41m" + " " + "\033[0m"):
                this.tableta[fila][columna]="\u001B[41m" + "x" + "\033[0m";
                break;
            case ("\u001B[44m" + " " + "\033[0m"):
                this.tableta[fila][columna]="\u001B[44m" + "x" + "\033[0m";
                break;
            case ("\u001B[43m" + " " + "\033[0m"):
                this.tableta[fila][columna]="\u001B[43m" + "x" + "\033[0m";
                break;
            case ("\u001B[42m" + " " + "\033[0m"):
                this.tableta[fila][columna]="\u001B[42m" + "x" + "\033[0m";
                break;
        }        
      
    }
    public void setTableta(char colores[]) {
        int x = 0;
        for (int i = 0; i < this.tableta.length; i++) {
            for (int j = 0; j < this.tableta[0].length; j++) {
                switch (colores[x]) {
                    case 'R':
                        this.tableta[i][j] = "\u001B[41m" + " " + "\033[0m"; //Color rojo
                        break;

                    case 'A':
                        this.tableta[i][j] = "\u001B[44m" + " " + "\033[0m"; //Color azul
                        break;

                    case 'M':
                        this.tableta[i][j] = "\u001B[43m" + " " + "\033[0m"; //Color amarillo
                        break;

                    case 'V':
                        this.tableta[i][j] = "\u001B[42m" + " " + "\033[0m"; //Color verde
                        break;
                }
                x++;
            }
        }
    }
    
    public void setTabletaRandom(){
        Random rand = new Random();
        int[][] tabletaAux = new int[2][2];
        char[] colores = new char[4];
        int num;
        int indice = 0;
        boolean validador;
        
        for (int i = 0; i < tabletaAux.length; i++) {
            for (int j = 0; j < tabletaAux[0].length; j++) {
                do {
                    validador = true;
                    num = rand.nextInt(4);
                    num++;
                    for (int x = 0; x < tabletaAux.length; x++) {
                        for (int y = 0; y < tabletaAux[0].length; y++) {
                            if (tabletaAux[x][y] == num) {
                                validador = false;
                            }
                        }
                    }
                } while (!validador);
                tabletaAux[i][j] = num;
                switch (tabletaAux[i][j]) {
                    case 1:
                        colores[indice] = 'R'; //Color rojo
                        break;

                    case 2:
                        colores[indice] = 'A'; //Color azul
                        break;

                    case 3:
                        colores[indice] = 'M'; //Color amarillo
                        break;

                    case 4:
                        colores[indice] = 'V'; //Color verde
                        break;
                }
                indice++;
            }
        }
        setTableta(colores);
    }
    
    public String[][] getTableta(){
        return this.tableta;
    }
    
    public void rotar90(){
        String[][] mat = this.getTableta();
        String temp = mat[0][0];
        mat[0][0] = mat[1][0];
        mat[1][0] = mat[1][1];
        mat[1][1] = mat[0][1];
        mat[0][1] = temp;
    }
    
    public void rotar180(){
        for(int i = 0; i < 2; i++){
            this.rotar90();
        }
    }
    
    public void rotar270(){
        for(int i = 0; i < 3; i++){
            this.rotar90();
        }
    }
    
    @Override
    public String toString(){
        String[][] tableta = this.getTableta();
        String devolverTableta = "";
        for(int i = 0; i < tableta.length; i++) {
            for(int j = 0; j < tableta[0].length; j++) {
                devolverTableta = devolverTableta + tableta[i][j];
            }
            if(i < (tableta.length - 1)){
                devolverTableta = devolverTableta + "\n";
            }
        }
        return devolverTableta;
    }
    
    public String devolverUnColor(int fila, int col) {
        String[][] tableta = this.getTableta();
        return tableta[fila][col];
    }
}
