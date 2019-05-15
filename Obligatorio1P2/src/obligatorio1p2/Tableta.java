
package obligatorio1p2;
import java.util.*;

public class Tableta {
    private String[][] ficha = new String[2][2];

    public void setAves(int fila, int col, String color){
        this.ficha[fila][col] = color;
        this.ficha[fila][col] = this.ficha[fila][col].replaceAll(" ", "x");
    }
    
    public boolean hayAves(int fila, int col) {
        boolean validador = false;
        
        if(devolverUnColor(fila, col).indexOf('x') == 5) {
            validador = true;
        }
        
        return validador;
    }
    
    public void setFicha(char colores[]) {
        int x = 0;
        for (int i = 0; i < this.ficha.length; i++) {
            for (int j = 0; j < this.ficha[0].length; j++) {
                switch (colores[x]) {
                    case 'R':
                        this.ficha[i][j] = "\u001B[41m" + " " + "\033[0m"; //Color rojo
                        break;

                    case 'A':
                        this.ficha[i][j] = "\u001B[44m" + " " + "\033[0m"; //Color azul
                        break;

                    case 'M':
                        this.ficha[i][j] = "\u001B[43m" + " " + "\033[0m"; //Color amarillo
                        break;

                    case 'V':
                        this.ficha[i][j] = "\u001B[42m" + " " + "\033[0m"; //Color verde
                        break;
                }
                x++;
            }
        }
    }
    
    public void setFichaRandom(){
        Random rand = new Random();
        int[][] fichaAux = new int[2][2];
        char[] colores = new char[4];
        int num;
        int indice = 0;
        boolean validador;
        
        for (int i = 0; i < fichaAux.length; i++) {
            for (int j = 0; j < fichaAux[0].length; j++) {
                do {
                    validador = true;
                    num = rand.nextInt(4);
                    num++;
                    for (int x = 0; x < fichaAux.length; x++) {
                        for (int y = 0; y < fichaAux[0].length; y++) {
                            if (fichaAux[x][y] == num) {
                                validador = false;
                            }
                        }
                    }
                } while (validador == false);
                fichaAux[i][j] = num;
                switch (fichaAux[i][j]) {
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
        setFicha(colores);
    }
    
    public String[][] getFicha(){
        return this.ficha;
    }
    
    public void rotar90(){
        String[][] mat = this.ficha;
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
        String[][] ficha = this.getFicha();
        String devolverTableta = "";
        for(int i = 0; i < ficha.length; i++) {
            for(int j = 0; j < ficha[0].length; j++) {
                devolverTableta = devolverTableta + ficha[i][j];
            }
            if(i < (ficha.length - 1)){
                devolverTableta = devolverTableta + "\n";
            }
        }
        return devolverTableta;
    }
    
    public String devolverUnColor(int fila, int col) {
        String[][] ficha = this.getFicha();
        return ficha[fila][col];
    }
}
