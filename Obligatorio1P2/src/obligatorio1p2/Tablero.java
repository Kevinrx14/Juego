package obligatorio1p2;

import java.util.*;

public class Tablero {
    private Tableta[][] tablero;

    public Tablero() {
        this.tablero = new Tableta[10][10];
    }
    
    public void setFicha(int fila, int col) {
        Tableta tableta = new Tableta();
        tableta.setFicha();
        this.tablero[fila][col] = tableta;
    }

    public Tableta[][] getTablero() {
        return this.tablero;
    }

    public Tableta getFicha(int fila, int col) {
        return this.tablero[fila][col];
    }

    @Override
    public String toString() {
        String devolverTablero = "";
        Tableta[][] tablero = this.getTablero();
        int fila = tablero.length;
        int filaAux = fila * 3 + 1;
        int col = tablero[0].length;
        int colAux = col * 3 + 1;

        String[][] matAux = crearTablero(filaAux, colAux);
        matAux = rellenarTablero(matAux);
        for (int i = 0; i < filaAux; i++) {
            for (int j = 0; j < colAux; j++) {
                devolverTablero = devolverTablero + matAux[i][j];
            }
            if (i < (filaAux - 1)) {
                devolverTablero = devolverTablero + "\n";
            }
        }
        
        return devolverTablero;
    }

    public String[][] crearTablero(int fila, int col) {
        String[][] mat = new String[fila][col];
        int contadorFila = 3;
        int contadorCol = 3;

        for (int i = 0; i < fila; i++) {
            for (int j = 0; j < col; j++) {
                if (contadorFila == 3) {
                    if (contadorCol == 3) {
                        mat[i][j] = "+";
                        contadorCol = 0;
                    } else {
                        mat[i][j] = "-";
                    }
                    contadorCol++;
                } else {
                    if (contadorCol == 3) {
                        mat[i][j] = "|";
                        contadorCol = 0;
                    } else {
                        mat[i][j] = " ";
                    }
                    contadorCol++;
                }

            }
            if (contadorFila == 3) {
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
        for (int i = 0; i < fila; i++) {
            for (int j = 0; j < col; j++) {
                if(fichas[i][j] != null) {
                    mat[i * 3 + 1][j * 3 + 1] = fichas[i][j].devolverUnColor(0, 0);
                    mat[i * 3 + 1][j * 3 + 2] = fichas[i][j].devolverUnColor(0, 1);
                    mat[i * 3 + 2][j * 3 + 1] = fichas[i][j].devolverUnColor(1, 0);
                    mat[i * 3 + 2][j * 3 + 2] = fichas[i][j].devolverUnColor(1, 1);
                } else {
                    mat[i * 3 + 1][j * 3 + 1] = " ";
                    mat[i * 3 + 1][j * 3 + 2] = " ";
                    mat[i * 3 + 2][j * 3 + 1] = " ";
                    mat[i * 3 + 2][j * 3 + 2] = " ";                    
                }
            }
        }

        return mat;
    }

    public void rotar(int fila, int columna, int grados) {
        switch (grados) {
            case 90:
                this.getTablero()[fila][columna].rotar90();
                break;
            case 180:
                this.getTablero()[fila][columna].rotar180();
                break;
            case 270:
                this.getTablero()[fila][columna].rotar270();
                break;
        }

    }

    public void agregarFicha(int fila, int columna) {
        this.setFicha(fila, columna);
    }

//    public boolean canConect(int fila1, int columna1, int fila2, int columna2, String color) {
//        boolean alineados = true;
//        boolean tieneColor1 = false;
//        boolean tieneColor2 = false;
//        boolean noHayAves = false;
//        boolean enLinea = false;
//        // Validamos que esten en la misma fila y columna
//        if (fila1 == fila2 || columna1 == columna2) {
//            if (fila1 == fila2) {
//                for (int i = Math.min(columna1, columna2); i < this.getTablero()[Math.max(columna1, columna2)].length - this.getTablero()[Math.min(columna1, columna2)].length; i++) {
//                    if (this.getTablero()[fila1][i] == null) {
//                        alineados = false;
//                    }
//                }
//            } else {
//                for (int i = Math.min(fila1, fila2); i < this.getTablero()[Math.max(fila1, fila2)].length - this.getTablero()[Math.min(fila1, fila2)].length; i++) {
//                    if (this.getTablero()[i][columna1] == null) {
//                        alineados = false;
//                    }
//                }
//            }
//        }
//
//        //validamos que esten los colores en las fichas ingresadas y que los colores esten en linea
//        for (int i = 0; i < 2; i++) {
//            for (int j = 0; j < 2; j++) {
//                int filaf1 = 0;
//                int filaf2 = 0;
//                int columnaf1 = -1;
//                int columnaf2 = -1;
//                if (color.equals(this.getFicha(fila1, columna1).getColores()[i][j])) {
//                    tieneColor1 = true;
//                    filaf1 = i;
//                    columnaf1 = j;
//                }
//                if (color.equals(this.getFicha(fila1, columna1).devolverUnColor(i, j))) {
//                    tieneColor2 = true;
//                    filaf2 = i;
//                    columnaf2 = j;
//                }
//                if (columnaf2 == columnaf1 || filaf1 == filaf2) {
//
//                    enLinea = true;
//                }
//
//            }
//        }
//        for (int i =   ) {
//
//        }
//    for (int i = 0; i < 2; i++) {
//            for (int j = 0; j < 2; j++) {
//            if () {
//
//            }
//        }
//    }
//    return (alineados && tieneColor1 && tieneColor2 && noHayAves && enLinea);
//}
//
//else {
//            retorno = false;
//    }
//    return retorno ;
//}
//
//public void conectar() {
//
//    }
}
