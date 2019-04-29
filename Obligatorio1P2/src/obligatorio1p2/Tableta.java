
package obligatorio1p2;
import java.util.*;

public class Tableta {
    private String[][] colores = new String[2][2];
    private boolean[][] aves = new boolean[2][2];

    public void setAves(int x, int y){
        this.aves[x][y] = true;
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
                        colores[i][j] = "\u001B[41m" + " "; //Color rojo
                        break;

                    case 2:
                        colores[i][j] = "\u001B[44m" + " "; //Color azul
                        break;

                    case 3:
                        colores[i][j] = "\u001B[43m" + " "; //Color amarillo
                        break;

                    case 4:
                        colores[i][j] = "\u001B[42m" + " "; //Color verde
                        break;
                }
            }
        }
    }
    
    public String[][] getColores(){
        return this.colores;
    }
    
    //rotan a la izquierda pero deberian rotar a la derecha
    public void rotar90(){
        String[][] mat = this.colores;
        int fila = mat.length;
        int col = mat[0].length;
        for (int i = 0; i < fila / 2; i++) {
            for (int j = i; j < col - 1 - i; j++) {
                String temp = mat[j][i];
                mat[j][i] = mat[i][col - j - 1];
                mat[i][col - j - 1] = mat[fila - j - 1][col - i - 1];
                mat[fila - j - 1][col - i - 1] = mat[fila - i - 1][j];
                mat[fila - i - 1][j] = temp;
            }
        }
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
        String devolverTableta = "";
        for(int i = 0; i < this.colores.length; i++) {
            for(int j = 0; j < this.colores[0].length; j++) {
                devolverTableta = devolverTableta + colores[i][j];
            }
            if(i < (this.colores.length - 1)){
                devolverTableta = devolverTableta + "\n";
            }
        }
        return devolverTableta;
    }
    
}
