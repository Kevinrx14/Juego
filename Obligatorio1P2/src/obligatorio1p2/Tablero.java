package obligatorio1p2;

public class Tablero {

    private Tableta[][] tablero;

    public Tablero() {
        this.setTablero();
//        this.tablero[1][4] = new Tableta();
//        this.tablero[1][4].setFicha(new char[]{'V', 'M', 'R', 'A'});
        this.tablero[2][4] = new Tableta();
        this.tablero[2][4].setFicha(new char[]{'V', 'M', 'R', 'A'});
        this.tablero[3][4] = new Tableta();
        this.tablero[3][4].setFicha(new char[]{'V', 'M', 'R', 'A'});
        this.tablero[4][4] = new Tableta();
        this.tablero[4][4].setFicha(new char[]{'R', 'A', 'V', 'M'});
        this.tablero[5][4] = new Tableta();
        this.tablero[5][4].setFicha(new char[]{'V', 'M', 'R', 'A'});
        this.tablero[6][4] = new Tableta();
        this.tablero[6][4].setFicha(new char[]{'V', 'M', 'R', 'A'});
        this.tablero[4][5] = new Tableta();
        this.tablero[4][5].setFicha(new char[]{'V', 'M', 'R', 'A'});
        this.tablero[4][6] = new Tableta();
        this.tablero[4][6].setFicha(new char[]{'V', 'M', 'R', 'A'});
        this.tablero[4][7] = new Tableta();
        this.tablero[4][7].setFicha(new char[]{'V', 'M', 'R', 'A'});
        this.tablero[4][8] = new Tableta();
        this.tablero[4][8].setFicha(new char[]{'V', 'M', 'R', 'A'});
//        this.tablero[4][5] = new Tableta();
//        this.tablero[4][5].setFicha(new char[]{'V', 'M', 'R', 'A'});
    }

    public void setFicha(int fila, int col) {
        Tableta tableta = new Tableta();
        tableta.setFichaRandom();
        this.tablero[fila][col] = tableta;
    }

    public Tableta getFicha(int fila, int col) {
        return this.tablero[fila][col];
    }

    public void setTablero() {
        this.tablero = new Tableta[10][10];
    }

    public Tableta[][] getTablero() {
        return this.tablero;
    }

    @Override
    public String toString() {
        Tableta[][] tablero = this.getTablero();
        String devolverTablero = "";
        int fila = tablero.length;
        int filaAux = fila * 3 + 1;
        int col = tablero[0].length;
        int colAux = col * 3 + 1;

        String[][] matAux = this.crearTablero(filaAux, colAux);
        matAux = this.rellenarTablero(matAux);
        matAux = this.ponerIndiceTablero(matAux);
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
                this.getFicha(fila, columna).rotar90();
                break;
            case 180:
                this.getFicha(fila, columna).rotar180();
                break;
            case 270:
                this.getFicha(fila, columna).rotar270();
                break;
        }

    }

    public boolean alineados(int fila1, int columna1, int fila2, int columna2) {
        boolean alineados = true;
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
        return alineados;
    }

    public boolean hayAves(int fila1, int columna1, int fila2, int columna2) {
        boolean hayAves = false;
        for (int i = Math.min(columna1, columna2); i < Math.max(columna1, columna2); i++) {
            for (int k = 0; k < 2; k++) {
                for (int j = 0; j < 2; j++) {
                    if (fila1 == fila2) {
                        if (this.getFicha(fila1, columna1).devolverUnColor(k, j).contains("x")) {
                            hayAves = true;
                        }
                    }
                }
            }
        }
        return hayAves;
    }

    public boolean canConect(int fila1, int columna1, int fila2, int columna2, String color) {
        boolean tieneColor1 = false;
        boolean tieneColor2 = false;
        boolean noHayAves = true;
        boolean enLinea = false;
        int filaf1 = -98;
        int filaf2 = 0;
        int columnaf1 = -33;
        int columnaf2 = -1;
        if (this.getTablero()[fila1][columna1] != null && this.getTablero()[fila2][columna2] != null) {
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    if (color.equals(this.getFicha(fila1, columna1).getFicha()[i][j])) {
                        tieneColor1 = true;
                        filaf1 = i;
                        columnaf1 = j;
                    }
                    if (color.equals(this.getFicha(fila2, columna2).devolverUnColor(i, j))) {
                        tieneColor2 = true;
                        filaf2 = i;
                        columnaf2 = j;
                    }
                    if (alineados(fila1, columna1, fila2, columna2)) {
                        if (fila1 == fila2) {
                            if (filaf1 == filaf2) {
                                enLinea = true;
                            }
                        } else {
                            if (columnaf2 == columnaf1) {
                                enLinea = true;
                            }
                        }
                    }
                }
            }
        }
        if (tieneColor1 && tieneColor2 && enLinea && alineados(fila1, columna1, fila2, columna2)) {
            noHayAves = !hayAves(fila1, columna1, fila2, columna2);
        }
        System.out.println(alineados(fila1, columna1, fila2, columna2) && tieneColor1 && tieneColor2 && noHayAves && enLinea);
        return (alineados(fila1, columna1, fila2, columna2) && tieneColor1 && tieneColor2 && noHayAves && enLinea);
    }

    public boolean enLineaF(int col, int fila) {
        boolean enLinea = false;
        for (int j = 0; j < 2; j++) {
            for (int k = 0; k < 2; k++) {
                if (k == col || j == fila) {
                    enLinea = true;
                }

            }
        }
        return enLinea;
    }

    public boolean hayFichas(int fila, int filaExt, int constante, boolean crece) {
        boolean hayFichas = true;
        if (!crece) {
            for (int i = fila; i > filaExt; i--) {
                if (this.getFicha(constante, i) == null) {
                    hayFichas = false;
                }
            }
        } else {
            for (int i = fila; i < filaExt; i++) {
                if (this.getFicha(constante, i) == null) {
                    hayFichas = false;
                }
            }
        }
        return hayFichas;
    }

    public boolean tieneColor(int fila, int columna, String color) {
        boolean tieneColor = false;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                if (color.equals(this.getFicha(fila, columna).getFicha()[i][j])) {
                    tieneColor = true;
                }
            }
        }
        return tieneColor;
    }

    public int[] colorFicha(int fila, int columna, String color) {
        int[] colorFicha = new int[2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                if (color.equals(this.getFicha(fila, columna).getFicha()[i][j])) {
                    colorFicha[0] = i;
                    colorFicha[1] = j;
                }
            }
        }
        return colorFicha;
    }

    public int[] validarExtension(int constante, int variable, boolean crece, String color) {
        int retorno[] = new int[3];
        if (!crece) {
            for (int i = variable; i > 0; i--) {
                for (int j = 0; j < 2; j++) {
                    for (int k = 0; k < 2; k++) {
                        if (color.equals(this.getFicha(i, constante).devolverUnColor(j, k)) && this.getFicha(i, constante).devolverUnColor(j, k).contains("x") && this.getFicha(i - 1, constante).devolverUnColor(j, k).contains("x") && color.equals(this.getFicha(i - 1, constante).devolverUnColor(j, k))) {
                            retorno[0] = 1;
                            retorno[1] = j;
                            retorno[2] = k;
                        }
                    }
                }
            }
        } else {
            for (int i = variable; i < 0; i++) {
                for (int j = 0; j < 2; j++) {
                    for (int k = 0; k < 2; k++) {
                        if (color.equals(this.getFicha(i, constante).devolverUnColor(j, k)) && this.getFicha(i, constante).devolverUnColor(j, k).contains("x") && this.getFicha(i - 1, constante).devolverUnColor(j, k).contains("x") && color.equals(this.getFicha(i - 1, constante).devolverUnColor(j, k))) {
                            retorno[0] = 1;
                            retorno[1] = j;
                            retorno[2] = k;
                        }
                    }
                }
            }

        }
        return retorno;
    }

    public boolean canExtend(int fila, int columna, String color, char direccion) {
        boolean hayFichas = true;
        int hayExtremo = 0;
        int filaExt = -1;
        int colExt = -1;
        int filaColor = colorFicha(fila, columna, color)[0];
        int colColor = colorFicha(fila, columna, color)[1];
        if (tieneColor(fila, columna, color)) {
            switch (direccion) {
                case 'A':
                    hayExtremo = validarExtension(columna, fila, false, color)[0];
                    filaExt = validarExtension(columna, fila, false, color)[1];
                    colExt = validarExtension(columna, fila, false, color)[2];
                    hayFichas = hayFichas(fila, filaExt, columna, false);

                    break;
                case 'B':
                    hayExtremo = validarExtension(columna, fila, true, color)[0];
                    filaExt = validarExtension(columna, fila, true, color)[1];
                    colExt = validarExtension(columna, fila, true, color)[2];
                    hayFichas = hayFichas(fila, filaExt, columna, true);
                    break;
                case 'D':
                    hayExtremo = validarExtension(fila, columna, true, color)[0];
                    filaExt = validarExtension(fila, columna, true, color)[1];
                    colExt = validarExtension(fila, columna, true, color)[2];
                    hayFichas = hayFichas(columna, colExt, fila, true);
                    break;
                case 'I':
                    hayExtremo = validarExtension(fila, columna, false, color)[0];
                    filaExt = validarExtension(fila, columna, false, color)[1];
                    colExt = validarExtension(fila, columna, false, color)[2];
                    hayFichas = hayFichas(columna, colExt, fila, false);

                    break;
            }
        }
        return (hayFichas && hayExtremo == 1 && tieneColor(fila, columna, color) && enLineaF(filaColor, colColor));
    }

    public int darOrientacionC(int fila1, int fila2) {
        int orientacion = 0;
        if (fila1 == fila2) {
            orientacion = 1;
        }
        return orientacion;
    }

    public int darOrientacionE(char direccion) {
        int orientacion = 1;
        if (direccion == 'A' || direccion == 'B') {
            orientacion = 0;
        }
        return orientacion;
    }

    public void conectar(int fila1, int columna1, int fila2, int columna2, String color) {
        int columnaColor1 = -1;
        int filaColor1 = -1;
        int columnaColor2 = -1;
        int filaColor2 = -1;
        if (canConect(fila1, columna1, fila2, columna2, color)) {
            filaColor1 = colorFicha(fila1, columna1, color)[0];
            columnaColor1 = colorFicha(fila1, columna1, color)[1];
            filaColor2 = colorFicha(fila2, columna2, color)[0];
            columnaColor2 = colorFicha(fila2, columna2, color)[1];
            if (darOrientacionC(fila1, fila2) == 1) {
                this.pintarHorizontal(fila1, columna1, columna2, filaColor1, columnaColor1, filaColor2, filaColor2, color);
            } else {
                this.pintarVertical(fila1, fila2, columna1, filaColor1, columnaColor1, filaColor2, columnaColor2, color);
            }
        }

    }

    public void pintarHorizontal(int fila1, int columna1, int columna2, int filaColor1, int columnaColor1, int filaColor2, int columnaColor2, String color) {
        for (int i = Math.min(columna1, columna2); i <= Math.max(columna1, columna2); i++) {
            if (i == Math.min(columna1, columna2) || i == Math.max(columna1, columna2) && (columnaColor1 == 1 || columnaColor2 == 0)) {
                if (columnaColor1 == 1) {
                    this.getFicha(fila1, Math.min(columna1, columna2)).dibujarAve(filaColor1, columnaColor1, color);
                } else {
                    for (int j = 0; j < 2; j++) {
                        {
                            this.getFicha(fila1, Math.min(columna1, columna2)).dibujarAve(filaColor1, j, color);
                        }
                    }
                }
                if (columnaColor2 == 0) {
                    this.getFicha(fila1, Math.max(columna1, columna2)).dibujarAve(filaColor2, columnaColor2, color);
                } else {
                    for (int j = 0; j < 2; j++) {
                        {
                            this.getFicha(fila1, Math.max(columna1, columna2)).dibujarAve(filaColor1, j, color);
                        }
                    }
                }
            } else {
                for (int j = 0; j < 2; j++) {
                    {
                        this.getFicha(fila1, i).dibujarAve(filaColor1, j, color);
                    }
                }
            }
        }
    }

    public void pintarVertical(int fila1, int fila2, int columna1, int filaColor1, int columnaColor1, int filaColor2, int columnaColor2, String color) {
        for (int i = Math.min(fila1, fila2); i <= Math.max(fila1, fila2); i++) {
            if (i == Math.min(fila1, fila2) || i == Math.max(fila1, fila2) && (filaColor1 == 1 || filaColor2 == 0)) {
                if (filaColor1 == 1) {
                    this.getFicha(Math.min(fila1, fila2), columna1).dibujarAve(filaColor1, columnaColor1, color);
                } else {
                    for (int j = 0; j < 2; j++) {
                        this.getFicha(Math.min(fila1, fila2), columna1).dibujarAve(j, columnaColor1, color);
                    }
                }
                if (filaColor2 == 0) {
                    this.getFicha(Math.max(fila1, fila2), columna1).dibujarAve(filaColor2, columnaColor2, color);
                } else {
                    for (int j = 0; j < 2; j++) {
                        this.getFicha(Math.max(fila1, fila2), columna1).dibujarAve(j, columnaColor1, color);
                    }
                }
            } else {
                for (int j = 0; j < 2; j++) {
                    this.getFicha(i, columna1).dibujarAve(j, columnaColor1, color);
                }
            }
        }
    }

    public boolean extendCreciente(int fila, int columna, int filaColor, int columnaColor, char direccion, String color) {
        boolean pintando = true;
        if (darOrientacionE(direccion) == 0) {
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
        return pintando;
    }

    public boolean extendDecreciente(int fila, int columna, int filaColor, int columnaColor, char direccion, String color) {
        boolean pintando = true;
        if (darOrientacionE(direccion) == 1) {
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
        return pintando;
    }

    public void extender(int fila, int columna, String color, char direccion) {
        int columnaColor = -1;
        int filaColor = -1;
        boolean crece = true;
        if (direccion == 'A' || direccion == 'I') {
            crece = false;
        }
        boolean pintando = true;
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
                pintando = extendCreciente(fila, columna, filaColor, columnaColor, direccion, color);
            } else {
                pintando = extendDecreciente(fila, columna, filaColor, columnaColor, direccion, color);
            }
        }
    }

    public boolean sePuedePonerFicha(int fila, int col) {
        Tableta[][] tablero = this.getTablero();
        Interfaz interfaz = new Interfaz();
        int[] coordFila = this.getCoordTablero5por5("filas");
        int[] coordCol = this.getCoordTablero5por5("columnas");
        boolean validador = false;

        if (tablero[fila][col] == null) {
            if (this.hayFichaAlLado(fila, col)) {
                if (!this.hayCincoFichas(fila, col)) {
                    if (this.validarSiPerteneceA5por5(coordFila, coordCol, new int[]{fila, col})) {
                        validador = true;
                    } else {
                        System.out.println("No se encuentra dentro del tablero 5x5");
                        interfaz.sonidoError();
                    }
                } else {
                    System.out.println("Ya hay 5 fichas en esa fila o columna");
                    interfaz.sonidoError();
                }
            } else {
                System.out.println("No hay ninguna ficha al lado");
                interfaz.sonidoError();
            }
        } else {
            System.out.println("Ya hay una ficha en ese lugar");
            interfaz.sonidoError();
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

    public int[] getCoordTablero5por5(String posicion) {
        int[] coordenadas = new int[]{-1, -1};
        Tableta[][] tablero = this.getTablero();
        int inicio = 0;
        int fin = 0;
        int contador = 0;
        boolean noEstanTodasLasCoordenadas = false;

        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[0].length; j++) {
                if (posicion.equals("filas")) {
                    if (tablero[j][i] != null) {
                        contador++;
                        if (contador == 1) {
                            inicio = j;
                        }
                        if (contador == 5) {
                            fin = j;
                        }
                    }
                } else {
                    if (posicion.equals("columnas")) {
                        if (tablero[i][j] != null) {
                            contador++;
                            if (contador == 1) {
                                inicio = j;
                            }
                            if (contador == 5) {
                                fin = j;
                            }
                        }
                    }
                }
            }

            if (contador == 5) {
                if (coordenadas[0] == -1 && coordenadas[1] == -1) {
                    coordenadas[0] = inicio;
                    coordenadas[1] = fin;
                }
            }
            contador = 0;
        }

        if (coordenadas[0] == -1 || coordenadas[1] == -1) {
            noEstanTodasLasCoordenadas = true;
        }

        if (noEstanTodasLasCoordenadas) {
            coordenadas[0] = 0;
            coordenadas[1] = 0;
        }

        return coordenadas;
    }

    public boolean validarSiPerteneceA5por5(int[] coordFila, int[] coordCol, int[] coordFicha) {
        boolean validador = true;

        /* 
        Chequeo si la fila en la que esta la ficha no se encuentra entre
        la fila que comienza el tablero de 5x5 y la fila en la que termina.
         */
        if (coordFicha[0] < coordFila[0] || coordFicha[0] > coordFila[1]) {
            System.out.println("fila");
            validador = false;
        }

        /*
        Hago el mismo chequeo que arriba pero para las columnas
         */
        if (coordFicha[1] < coordCol[0] || coordFicha[1] > coordCol[1]) {
            System.out.println("col");
            validador = false;
        }
        
        return validador;
    }

    public boolean validarSiTablero5por5EstaLleno(int[] coordenadasFilas, int[] coordenadasCol) {
        Tableta[][] tablero = getTablero();
        boolean validador = true;

        if (coordenadasFilas[0] == coordenadasFilas[1]) {
            validador = false;
        }

        if (coordenadasCol[0] == coordenadasCol[1]) {
            validador = false;
        }

        if (validador) {
            for (int i = coordenadasFilas[0]; i <= coordenadasFilas[1]; i++) {
                for (int j = coordenadasCol[0]; j <= coordenadasCol[1]; j++) {
                    if (tablero[i][j] == null) {
                        validador = false;
                    }

                }
            }
        }

        return validador;
    }
}
