
package obligatorio1p2;
import java.util.*;

public class Tableta {
    private String[][] colores = new String[2][2];
    private boolean[][] aves = new boolean[2][2];

    public void setAves(int fila, int col){
        this.aves[fila][col] = true;
    }
    
    public boolean[][] getAves() {
        return this.aves;
    }
    
    public void setColores(){
        Random rand = new Random();
        int[][] coloresAux = new int[2][2];
        int num;
        boolean validador;
        
        for (int i = 0; i < coloresAux.length; i++) {
            for (int j = 0; j < coloresAux[0].length; j++) {
                do {
                    validador = true;
                    num = rand.nextInt(4);
                    num++;
                    for (int x = 0; x < coloresAux.length; x++) {
                        for (int y = 0; y < coloresAux[0].length; y++) {
                            if (coloresAux[x][y] == num) {
                                validador = false;
                            }
                        }
                    }
                } while (validador == false);
                coloresAux[i][j] = num;
                switch (coloresAux[i][j]) {
                    case 1:
                        colores[i][j] = "\u001B[41m" + " " + "\033[0m"; //Color rojo
                        break;

                    case 2:
                        colores[i][j] = "\u001B[44m" + " " + "\033[0m"; //Color azul
                        break;

                    case 3:
                        colores[i][j] = "\u001B[43m" + " " + "\033[0m"; //Color amarillo
                        break;

                    case 4:
                        colores[i][j] = "\u001B[42m" + " " + "\033[0m"; //Color verde
                        break;
                }
            }
        }
    }
    
    public String[][] getColores(){
        return this.colores;
    }
    
    public void rotar90(){
        String[][] mat = this.colores;
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
        String[][] colores = this.getColores();
        boolean[][] aves = this.getAves();
        String[][] tableta = new String[colores.length][colores[0].length];
        String devolverTableta = "";
        for(int i = 0; i < tableta.length; i++) {
            for(int j = 0; j < tableta[0].length; j++) {
                if(aves[i][j]){
                    tableta[i][j] = colores[i][j].replaceAll(" ", "x");
                } else {
                    tableta[i][j] = colores[i][j];
                }
            }
        }
        for(int i = 0; i < tableta.length; i++) {
            for(int j = 0; j < tableta[0].length; j++) {
                devolverTableta = devolverTableta + tableta[i][j];
            }
            if(i < (this.colores.length - 1)){
                devolverTableta = devolverTableta + "\n";
            }
        }
        return devolverTableta;
    }
    
    public String devolverUnColor(int fila, int col) {
        String[][] colores = this.getColores();
        return colores[fila][col];
    }
}
