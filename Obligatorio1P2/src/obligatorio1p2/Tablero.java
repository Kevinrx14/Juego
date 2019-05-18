package obligatorio1p2;

public class Tablero {

    private Tableta[][] tablero;

    public Tablero() {
        this.tablero = new Tableta[10][10];
        this.tablero[4][4] = new Tableta();
        this.tablero[4][4].setFicha(new char[]{'R', 'A', 'V', 'M'});
        this.tablero[4][5] = new Tableta();
        this.tablero[4][5].setFicha(new char[]{'V', 'M', 'R', 'A'});
    }

    public void setFicha(int fila, int col) {
        Tableta tableta = new Tableta();
        tableta.setFichaRandom();
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
        Tableta[][] tablero = this.getTablero();
        String devolverTablero = "";
        int fila = tablero.length;
        int filaAux = fila * 3 + 1;
        int col = tablero[0].length;
        int colAux = col * 3 + 1;

        String[][] matAux = crearTablero(filaAux, colAux);
        matAux = rellenarTablero(matAux);
        matAux = ponerIndiceTablero(matAux);
        for (int i = 0; i < filaAux + 1; i++) {
            for (int j = 0; j < colAux + 1; j++) {
                devolverTablero = devolverTablero + matAux[i][j];
            }
            if (i < (filaAux)) {
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

    public String[][] ponerIndiceTablero(String[][] mat) {
        String[][] matAux = new String[mat.length + 1][mat[0].length + 1];
        int[] indicesCol = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        char[] indicesFilas = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};
        int indice = 0;
        int x = 0;

        for (int i = 0; i < matAux[0].length; i++) {
            x++;
            if (x == 3) {
                matAux[0][i] = Integer.toString(indicesCol[indice]);
                x = 0;
                indice++;
            } else {
                matAux[0][i] = " ";
            }
        }

        x = 0;
        indice = 0;
        for (int i = 0; i < matAux.length; i++) {
            x++;
            if (x == 3) {
                matAux[i][0] = Character.toString(indicesFilas[indice]);
                x = 0;
                indice++;
            } else {
                matAux[i][0] = " ";
            }
        }

        for (int i = 1; i < matAux.length; i++) {
            for (int j = 1; j < matAux[0].length; j++) {
                matAux[i][j] = mat[i - 1][j - 1];
            }
        }

        return matAux;
    }

    public String[][] rellenarTablero(String[][] mat) {
        Tableta[][] fichas = this.getTablero();
        int fila = fichas.length;
        int col = fichas[0].length;
        for (int i = 0; i < fila; i++) {
            for (int j = 0; j < col; j++) {
                if (fichas[i][j] != null) {
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
                this.tablero[fila][columna].rotar90();
                break;
            case 180:
                this.tablero[fila][columna].rotar180();
                break;
            case 270:
                this.tablero[fila][columna].rotar270();
                break;
        }

    }

    public boolean canConect(int fila1, int columna1, int fila2, int columna2, String color) {
        boolean alineados = true;
        boolean tieneColor1 = false;
        boolean tieneColor2 = false;
        boolean noHayAves = true;
        boolean enLinea = false;
        // Validamos que esten en la misma fila o columna
        if (fila1 == fila2 || columna1 == columna2) {
            if (fila1 == fila2) {
                for (int i = Math.min(columna1, columna2); i <= Math.max(columna1, columna2); i++) {
                    if (this.getTablero()[fila1][i] == null) {
                        alineados = false;
                    }
                }
            } else {
                for (int i = Math.min(fila1, fila2); i <= Math.max(fila1, fila2); i++) {
                    if (this.getTablero()[i][columna1] == null) {
                        alineados = false;
                    }
                }
            }
        }

        //validamos que esten los colores en las fichas ingresadas y que los colores esten en linea
        int filaf1 = 0;
        int filaf2 = 0;
        int columnaf1 = -1;
        int columnaf2 = -1;
        if (this.getTablero()[fila1][columna1] != null && this.getTablero()[fila2][columna2] != null) {
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    if (color.equals(this.getFicha(fila1, columna1).getFicha()[i][j])) {
                        tieneColor1 = true;
                        filaf1 = i;
                        columnaf1 = j;
                    }
                    if (color.equals(this.getFicha(fila1, columna1).devolverUnColor(i, j))) {
                        tieneColor2 = true;
                        filaf2 = i;
                        columnaf2 = j;
                    }
                    if (columnaf2 == columnaf1 || filaf1 == filaf2) {

                        enLinea = true;
                    }

                }
            }
        }
        // Validamos que no hayan aves en el camino
        if (tieneColor1 && tieneColor2 && alineados && enLinea) {
            for (int i = Math.min(columna1, columna2); i < Math.max(columna1, columna2); i++) {
                for (int k = 0; k < 2; k++) {
                    for (int j = 0; j < 2; j++) {
                        if (fila1 == fila2) {
                            if (this.getFicha(fila1, columna1).devolverUnColor(k, j).equals("x")) {
                                noHayAves = false;
                            }
                        }
                    }
                }
            }
        }

        return (alineados && tieneColor1 && tieneColor2 && noHayAves && enLinea);
    }

    public boolean canExtend(int fila, int columna, String color, char direccion) {
        //direccion: A- arriba B- abajo D-derecha I-izquierda

        boolean hayFichas = true;
        boolean hayExtremo = false;
        boolean enLinea = false;
        boolean tieneColor = false;
        boolean hayLinea = false;
        int filaExt = -1;
        int colExt = -1;
        int filaColor = 0;
        int colColor = 0;
        // valido que el color esté dentro de la ficha selecionada
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                if (color.equals(this.getFicha(fila, columna).getFicha()[i][j])) {
                    tieneColor = true;
                    filaColor = i;
                    colColor = j;
                }
            }
        }
        if (tieneColor) {
            switch (direccion) {
                case 'A':
                    for (int i = fila; i > 0; i--) {
                        for (int j = 0; j < 2; j++) {
                            for (int k = 0; k < 2; k++) {
                                if (color.equals(this.getFicha(i, columna).devolverUnColor(j, k)) && this.getFicha(i, columna).devolverUnColor(j, k).contains("x") && this.getFicha(i - 1, columna).devolverUnColor(j, k).contains("x") && color.equals(this.getFicha(i - 1, columna).devolverUnColor(j, k))) {
                                    hayExtremo = true;
                                    filaExt = j;
                                    colExt = k;
                                    if (k == colColor || j == filaColor) {
                                        enLinea = true;
                                    }
                                }
                            }
                        }
                    }
                    if (hayExtremo && enLinea) {
                        for (int i = fila; i > filaExt; i--) {
                            for (int j = 0; j < 2; j++) {
                                for (int k = 0; k < 2; k++) {
                                    if (this.getFicha(i, columna) == null) {
                                        hayFichas = false;
                                    }
                                }
                            }
                        }
                    }
                    break;
                case 'B':
                    for (int i = fila; i < 10; i++) {
                        for (int j = 0; j < 2; j++) {
                            for (int k = 0; k < 2; k++) {

                                if (color.equals(this.getFicha(i, columna).devolverUnColor(j, k)) && this.getFicha(i, columna).devolverUnColor(j, k).contains("x") && color.equals(this.getFicha(i + 1, columna).devolverUnColor(j, k)) && this.getFicha(i + 1, columna).devolverUnColor(j, k).contains("x")) {
                                    hayExtremo = true;
                                    filaExt = j;
                                    colExt = k;
                                    if (k == colColor || j == filaColor) {
                                        enLinea = true;
                                    }
                                }
                            }
                        }
                    }
                    if (hayExtremo && enLinea) {
                        for (int i = fila; i < filaExt; i++) {
                            for (int j = 0; j < 2; j++) {
                                for (int k = 0; k < 2; k++) {
                                    if (this.getFicha(i, columna) == null) {
                                        hayFichas = false;
                                    }
                                }
                            }
                        }
                    }
                    break;
                case 'D':
                    for (int i = columna; i < 10; i++) {
                        for (int j = 0; j < 2; j++) {
                            for (int k = 0; k < 2; k++) {

                                if (color.equals(this.getFicha(fila, i).devolverUnColor(j, k)) && this.getFicha(fila, i).devolverUnColor(j, k).contains("x") && color.equals(this.getFicha(fila, i + 1).devolverUnColor(j, k)) && this.getFicha(fila, i + 1).devolverUnColor(j, k).contains("x")) {
                                    hayExtremo = true;
                                    filaExt = j;
                                    colExt = k;
                                    if (k == colColor || j == filaColor) {
                                        enLinea = true;
                                    }
                                }
                            }
                        }
                    }
                    if (hayExtremo && enLinea) {
                        for (int i = columna; i < filaExt; i++) {
                            for (int j = 0; j < 2; j++) {
                                for (int k = 0; k < 2; k++) {
                                    if (this.getFicha(fila, i) == null) {
                                        hayFichas = false;
                                    }
                                }
                            }
                        }
                    }
                    break;
                case 'I':
                    for (int i = columna; i > 0; i--) {
                        for (int j = 0; j < 2; j++) {
                            for (int k = 0; k < 2; k++) {

                                if (color.equals(this.getFicha(fila, i).devolverUnColor(j, k)) && this.getFicha(fila, i).devolverUnColor(j, k).contains("x") && color.equals(this.getFicha(fila, i - 1).devolverUnColor(j, k)) && this.getFicha(fila, i - 1).devolverUnColor(j, k).contains("x")) {
                                    hayExtremo = true;
                                    filaExt = j;
                                    colExt = k;
                                    if (k == colColor || j == filaColor) {
                                        enLinea = true;
                                    }
                                }
                            }
                        }
                    }
                    if (hayExtremo && enLinea) {
                        for (int i = columna; i > filaExt; i--) {
                            for (int j = 0; j < 2; j++) {
                                for (int k = 0; k < 2; k++) {
                                    if (this.getFicha(fila, i) == null) {
                                        hayFichas = false;
                                    }
                                }
                            }
                        }
                    }
                    break;
            }
        }
        return (hayFichas && hayExtremo && tieneColor && enLinea);
    }

    public void conectar(int fila1, int columna1, int fila2, int columna2, String color) {
        int columnaColor = -1;
        int filaColor = -1;
        int orientacion = 0;
        if (canConect(fila1, columna1, fila2, columna2, color)) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    if (color.equals(this.getFicha(fila1, columna1).devolverUnColor(j, k))) {
                        filaColor = j;
                        columnaColor = k;
                    }
                }
            }
            if (fila1 == fila2) {
                orientacion = 1;
            }
            if (orientacion == 1) {
                for (int i = Math.min(columna1, columna2); i <= this.getTablero()[Math.max(columna1, columna2)].length - this.getTablero()[Math.min(columna1, columna2)].length; i++) {
                    for (int j = 0; j < 2; j++) {
                        this.getFicha(fila1, i).dibujarAve(filaColor, j, color);
                    }
                }
            } else {
                for (int i = Math.min(fila1, fila2); i <= Math.max(fila1, fila2); i++) {
                    for (int j = 0; j < 2; j++) {
                        this.getFicha(i, columna1).dibujarAve(j, columnaColor, color);
                    }
                }
            }
        }
    }

    public void extender(int fila, int columna, String color, char direccion) {
        int columnaColor = -1;
        int filaColor = -1;
        int orientacion = 0;
        if (direccion == 'A' || direccion == 'B') {
            orientacion = 1;
        }
        boolean crece = true;
        if (direccion == 'A' || direccion == 'I') {
            crece = false;
        }
        boolean pintando = false;
        while (canExtend(fila, columna, color, direccion) && pintando) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    if (color.equals(this.getFicha(fila, columna).devolverUnColor(j, k))) {
                        filaColor = j;
                        columnaColor = k;
                    }
                }
            }
            if (crece) {
                if (orientacion == 1) {
                    for (int i = columna; i <= 10; i++) {
                        for (int j = 0; j < 2; j++) {
                            if (this.getFicha(fila, i).hayAves(filaColor, j)) {
                                pintando = false;
                                j = 2;
                            } else {
                                this.getFicha(fila, i).dibujarAve(filaColor, j, color);
                            }
                        }
                    }
                } else {
                    for (int i = fila; i <= 10; i++) {
                        for (int j = 0; j < 2; j++) {
                            if (this.getFicha(i, columna).hayAves(j, columnaColor)) {
                                pintando = false;
                                j = 2;
                            } else {
                                this.getFicha(i, columna).dibujarAve(j, columnaColor, color);
                            }
                        }
                    }
                }
            } else {
                if (orientacion == 1) {
                    for (int i = columna; i >= 0; i--) {
                        for (int j = 0; j < 2; j++) {
                            if (this.getFicha(fila, i).hayAves(filaColor, j)) {
                                pintando = false;
                                j = 2;
                            } else {
                                this.getFicha(fila, i).dibujarAve(filaColor, j, color);
                            }
                        }
                    }
                } else {
                    for (int i = fila; i >= 0; i--) {
                        for (int j = 0; j < 2; j++) {
                            if (this.getFicha(i, columna).hayAves(j, columnaColor)) {
                                pintando = false;
                                j = 2;
                            } else {
                                this.getFicha(i, columna).dibujarAve(j, columnaColor, color);
                            }
                        }
                    }
                }
            }
        }
    }

    public boolean sePuedePonerFicha(int fila, int col) {
        Tableta[][] tablero = this.getTablero();
        boolean validador = false;

        if (tablero[fila][col] == null) {
            if (hayFichaAlLado(fila, col)) {
                if (!hayCincoFichas(fila, col)) {
                    validador = true;
                } else {
                    System.out.println("Ya hay 5 fichas en esa fila o columna");
                }
            } else {
                System.out.println("No hay ninguna ficha al lado");
            }
        } else {
            System.out.println("Ya hay una ficha en ese lugar");
        }

        return validador;
    }

    public boolean hayFichaAlLado(int fila, int col) {
        Tableta[][] tablero = this.getTablero();
        boolean validador = false;

        if (fila > 0) {
            if (tablero[fila - 1][col] != null) {
                validador = true;
            }
        }

        if (fila < 9) {
            if (tablero[fila + 1][col] != null) {
                validador = true;
            }
        }

        if (col > 0) {
            if (tablero[fila][col - 1] != null) {
                validador = true;
            }
        }

        if (col < 9) {
            if (tablero[fila][col + 1] != null) {
                validador = true;
            }
        }

        return validador;
    }

    public boolean hayCincoFichas(int fila, int col) {
        Tableta[][] tablero = this.getTablero();
        boolean validador = false;
        int contadorFila = 0;
        int contadorCol = 0;

        for (int i = 0; i < tablero.length; i++) {
            if (tablero[i][col] != null) {
                contadorFila++;
            }
        }

        for (int i = 0; i < tablero[0].length; i++) {
            if (tablero[fila][i] != null) {
                contadorCol++;
            }
        }

        if (contadorFila > 4 || contadorCol > 4) {
            validador = true;
        }

        return validador;
    }
}

//    public int[] coordenadasTablero5por5() {
//        int[] coordenadas = new int({-1, -1, -1, -1});
//        Tableta[][] tablero = getTablero();
//        int contadorCol = 0;
//        int contadorFila = 0;
//        int indice = 0;
//
//        for (int i = 0; i < tablero.length; i++) {
//            for (int j = 0; j < tablero[0].length; j++) {
//                if (tablero[i][j] != null) {
//                    contadorCol++;
//                }
//            }
//            if ()
//            if (contadorCol == 5) {
//                
//
//            }
//        }
//
//        return coordenadas;
//    }

