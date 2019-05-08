//Kevin Rinaldi 240179
package obligatorio1p2;
import java.util.*;

public class Tablero {
    private Tableta[][] tablero = new Tableta[10][10];
   
    public void setTablero(int fila, int col) {
        Tableta tableta = new Tableta();
        tableta.setColores();
        this.tablero[fila][col] = tableta;
    }
    
    public Tableta[][] getTablero() {
        return this.tablero;
    }
    
    @Override
    public String toString(){
        String devolverTablero = "";
        Tableta[][] tablero = this.getTablero();
        int fila = tablero.length;
        int filaAux = fila * 3 + 1;
        int col = tablero[0].length;
        int colAux = col * 3 + 1;
        
        String[][] matAux = crearTablero(filaAux, colAux);
        matAux = rellenarTablero(matAux);
        for(int i = 0; i < filaAux; i++) {
            for(int j = 0; j < colAux; j++) {
                devolverTablero = devolverTablero + matAux[i][j];
            }
            if(i < (filaAux - 1)){
                devolverTablero = devolverTablero + "\n";
            }
        }
        return devolverTablero;
    }
    
    public String[][] crearTablero(int fila, int col) {
        String[][] mat = new String[fila][col];
        int contadorFila = 3;
        int contadorCol = 3;
        
        for(int i = 0; i < fila; i++) {
            for(int j = 0; j < col; j++) {
                if(contadorFila == 3) {
                    if(contadorCol == 3) {
                        mat[i][j] = "+";
                        contadorCol = 0;
                    } else {
                        mat[i][j] = "-";
                    }
                    contadorCol++;
                } else {
                    if(contadorCol == 3) {
                        mat[i][j] = "|";
                        contadorCol = 0;
                    } else {
                        mat[i][j] = " ";
                    }
                    contadorCol++;
                }
                
            }
            if(contadorFila == 3) {
                contadorFila = 0;
            }
            contadorFila++;
            contadorCol = 3;
        }
        
        return mat;
    }
    
    public String[][] rellenarTablero(String[][] mat) {
        Tableta[][] fichas = this.getTablero();
        int fila = fichas.length;
        int col = fichas[0].length;
        for(int i = 0; i < fila; i++) {
            for(int j = 0; j < col; j++) {
                try {
                    mat[i * 3 + 1][j * 3 + 1] = fichas[i][j].devolverUnColor(0,0);
                    mat[i * 3 + 1][j * 3 + 2] = fichas[i][j].devolverUnColor(0,1);
                    mat[i * 3 + 2][j * 3 + 1] = fichas[i][j].devolverUnColor(1,0);
                    mat[i * 3 + 2][j * 3 + 2] = fichas[i][j].devolverUnColor(1,1);
                } catch (NullPointerException e) {
                    mat[i * 3 + 1][j * 3 + 1] = " ";
                    mat[i * 3 + 1][j * 3 + 2] = " ";
                    mat[i * 3 + 2][j * 3 + 1] = " ";
                    mat[i * 3 + 2][j * 3 + 2] = " ";
                }
            }
        }
        
        return mat;
    }
}
