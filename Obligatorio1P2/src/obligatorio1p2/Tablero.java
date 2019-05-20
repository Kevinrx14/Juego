//Kevin Rinaldi - 240179
//Ezequiel Lopez - 237308
package obligatorio1p2;

public class Tablero {

    private Tableta[][] tablero;

    public Tablero() {
        this.setTablero();
        this.tablero[4][4] = new Tableta();
        this.tablero[4][4].setTableta(new char[]{'R', 'A', 'V', 'M'});
        this.tablero[4][5] = new Tableta();
        this.tablero[4][5].setTableta(new char[]{'V', 'M', 'R', 'A'});
    }

    public void setTableta(int fila, int col) {
        Tableta tableta = new Tableta();
        tableta.setTabletaRandom();
        this.tablero[fila][col] = tableta;
    }

    public void tabletaManual(int fila, int col, char[] colores) {
        Tableta tableta = new Tableta();
        tableta.setTableta(colores);
        this.tablero[fila][col] = tableta;
    }

    public Tableta getTableta(int fila, int col) {
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
        Tableta[][] tabletas = this.getTablero();
        int fila = tabletas.length;
        int col = tabletas[0].length;
        for (int i = 0; i < fila; i++) {
            for (int j = 0; j < col; j++) {
                if (tabletas[i][j] != null) {
                    mat[i * 3 + 1][j * 3 + 1] = tabletas[i][j].devolverUnColor(0, 0);
                    mat[i * 3 + 1][j * 3 + 2] = tabletas[i][j].devolverUnColor(0, 1);
                    mat[i * 3 + 2][j * 3 + 1] = tabletas[i][j].devolverUnColor(1, 0);
                    mat[i * 3 + 2][j * 3 + 2] = tabletas[i][j].devolverUnColor(1, 1);
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
                this.getTableta(fila, columna).rotar90();
                break;
            case 180:
                this.getTableta(fila, columna).rotar180();
                break;
            case 270:
                this.getTableta(fila, columna).rotar270();
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

    public boolean hayAves(int fila1, int columna1, int fila2, int columna2, int filaf1, int columnaf1, int cantAves) {
        int cont = 0;
        boolean hayAves = false;

        if (fila1 == fila2) {
            for (int i = Math.min(columna1, columna2); i < Math.max(columna1, columna2); i++) {
                for (int k = 0; k < 2; k++) {
                    cont++;
                    if (this.getTableta(fila1, i).devolverUnColor(filaf1, k).contains("x")) {
                        hayAves = true;
                    }
                }
            }
        } else {
            for (int i = Math.min(fila1, fila2); i < Math.max(fila1, fila2); i++) {
                for (int k = 0; k < 2; k++) {

                    cont++;
                    if (this.getTableta(i, columna1).devolverUnColor(k, columnaf1).contains("x")) {
                        hayAves = true;
                    }
                }
            }
        }
        if (cont % 2 != 0) {
            cont = ((cont - 1) / 2) + 1;
        } else {
            cont = cont / 2;
        }
        return hayAves || cont > cantAves;
    }

    public boolean canConect(int fila1, int columna1, int fila2, int columna2, String color, int cantAves) {
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
                    if (color.equals(this.getTableta(fila1, columna1).getTableta()[i][j])) {
                        tieneColor1 = true;
                        filaf1 = i;
                        columnaf1 = j;
                    }
                    if (color.equals(this.getTableta(fila2, columna2).devolverUnColor(i, j))) {
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
            noHayAves = !hayAves(fila1, columna1, fila2, columna2, filaf1, columnaf1, cantAves);
        }

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

    public boolean hayTabletas(int fila, int filaExt, int constante, boolean crece) {
        boolean hayTabletas = true;
        if (!crece) {
            for (int i = fila; i > filaExt; i--) {
                if (this.getTableta(constante, i) == null) {
                    hayTabletas = false;
                }
            }
        } else {
            for (int i = fila; i < filaExt; i++) {
                if (this.getTableta(constante, i) == null) {
                    hayTabletas = false;
                }
            }
        }
        return hayTabletas;
    }

    public boolean tieneColor(int fila, int columna, String color) {
        boolean tieneColor = false;

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                if (color.equals(this.getTableta(fila, columna).getTableta()[i][j])) {
                    tieneColor = true;
                }
            }
        }
        return tieneColor;
    }

    public int[] colorTableta(int fila, int columna, String color) {
        int[] colorTableta = {0, 0};
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                if (color.equals(this.getTableta(fila, columna).devolverUnColor(i, j))) {
                    colorTableta[0] = i;
                    colorTableta[1] = j;
                }
            }
        }
        return colorTableta;
    }

    public int[] validarExtension(int constante, int variable, boolean crece, String color) {
        int retorno[] = new int[4];
        if (crece == false) {
            for (int i = variable; i > 0; i--) {
                for (int j = 1; j >= 0; j--) {
                    for (int k = 1; k >= 0; k--) {
                        retorno[3]++;
                        if (this.getTableta(i, constante) != null && this.getTableta(i - 1, constante) != null) {
                            if ((this.getTableta(i, constante).hayAvesYColor(j, k, color) && this.getTableta(i - 1, constante).hayAvesYColor(j, k, color))) {
                                retorno[0] = 1;
                                retorno[1] = i;
                                retorno[2] = constante;
                                i = 0;
                                k = 2;
                                j = 2;
                            }
                        }
                        if (this.getTableta(constante, i) != null && this.getTableta(constante, i + 1) != null) {
                            if (this.getTableta(constante, i).hayAvesYColor(j, k, color) && this.getTableta(constante, i - 1).hayAvesYColor(j, k, color)) {
                                retorno[0] = 1;
                                retorno[1] = constante;
                                retorno[2] = i;
                                i = 0;
                                k = 2;
                                j = 2;
                            }
                        }
                    }
                }
            }
        } else {
            for (int i = variable; i < 0; i++) {
                for (int j = 0; j < 2; j++) {
                    for (int k = 0; k < 2; k++) {
                        retorno[3]++;
                        if (this.getTableta(i, constante) != null && this.getTableta(i + 1, constante) != null) {
                            if ((this.getTableta(i, constante).hayAvesYColor(j, k, color) && this.getTableta(i + 1, constante).hayAvesYColor(j, k, color))) {
                                retorno[0] = 1;
                                retorno[1] = i;
                                retorno[2] = constante;
                                i = 0;
                                k = 2;
                                j = 2;
                            }
                        }
                        if (this.getTableta(constante, i) != null && this.getTableta(constante, i + 1) != null) {
                            if (this.getTableta(constante, i).hayAvesYColor(j, k, color) && this.getTableta(constante, i + 1).hayAvesYColor(j, k, color)) {
                                retorno[0] = 1;
                                retorno[1] = constante;
                                retorno[2] = i;
                                i = 0;
                                k = 2;
                                j = 2;
                            }
                        }
                    }
                }
            }
        }
        if (retorno[3] % 2 != 0) {
            retorno[3] = ((retorno[3] - 1) / 2) + 1;
        } else {
            retorno[3] = retorno[3] / 2;
        }
        return retorno;
    }

    public boolean canExtend(int fila, int columna, String color, char direccion, int cantAves) {
        boolean hayTabletas = true;
        int avesRequeridas = 0;
        int hayExtremo = 0;
        int filaExt = -1;
        int colExt = -1;
        int filaColor = colorTableta(fila, columna, color)[0];
        int colColor = colorTableta(fila, columna, color)[1];
        if (tieneColor(fila, columna, color)) {
            switch (direccion) {
                case 'A':
                    hayExtremo = validarExtension(columna, fila, false, color)[0];
                    filaExt = validarExtension(columna, fila, false, color)[1];
                    colExt = validarExtension(columna, fila, false, color)[2];
                    hayTabletas = hayTabletas(fila, filaExt, columna, false);
                    avesRequeridas = validarExtension(columna, fila, false, color)[3];
                    break;
                case 'B':
                    hayExtremo = validarExtension(columna, fila, true, color)[0];
                    filaExt = validarExtension(columna, fila, true, color)[1];
                    colExt = validarExtension(columna, fila, true, color)[2];
                    hayTabletas = hayTabletas(fila, filaExt, columna, true);
                    avesRequeridas = validarExtension(columna, fila, true, color)[3];
                    break;
                case 'D':
                    hayExtremo = validarExtension(fila, columna, true, color)[0];
                    filaExt = validarExtension(fila, columna, true, color)[1];
                    colExt = validarExtension(fila, columna, true, color)[2];
                    hayTabletas = hayTabletas(columna, colExt, fila, true);
                    avesRequeridas = validarExtension(fila, columna, true, color)[3];
                    break;
                case 'I':
                    hayExtremo = validarExtension(fila, columna, false, color)[0];
                    filaExt = validarExtension(fila, columna, false, color)[1];
                    colExt = validarExtension(fila, columna, false, color)[2];
                    hayTabletas = hayTabletas(columna, colExt, fila, false);
                    avesRequeridas = validarExtension(fila, columna, false, color)[3];
                    break;
            }

        }
        return (avesRequeridas <= cantAves && hayTabletas && hayExtremo == 1 && tieneColor(fila, columna, color) && enLineaF(filaColor, colColor));

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

    public boolean conectar(int fila1, int columna1, int fila2, int columna2, int indiceJugador, Partida p) {
        int contador = p.getJugadores().get(indiceJugador).getCantAves();
        String color = p.getJugadores().get(indiceJugador).getColorJugador();
        Interfaz interfaz = new Interfaz();
        int columnaColor1 = -1;
        int filaColor1 = -1;
        int columnaColor2 = -1;
        int filaColor2 = -1;
        boolean ret = true;
        boolean running = true;
        if (canConect(fila1, columna1, fila2, columna2, color, contador)) {
            filaColor1 = colorTableta(fila1, columna1, color)[0];
            columnaColor1 = colorTableta(fila1, columna1, color)[1];
            filaColor2 = colorTableta(fila2, columna2, color)[0];
            columnaColor2 = colorTableta(fila2, columna2, color)[1];
            if (darOrientacionC(fila1, fila2) == 1) {
                contador = contador - this.pintarHorizontal(fila1, columna1, columna2, filaColor1, columnaColor1, columnaColor2, color);
            } else {
                contador = contador - this.pintarVertical(fila1, fila2, columna1, filaColor1, filaColor2, columnaColor1, color);
            }
            p.getJugadores().get(indiceJugador).setCantAves(contador);
            running = false;
        } else {
            System.out.println("No se puede conectar");
            interfaz.sonidoError();
        }
        return running;
    }

    public int pintarHorizontal(int fila1, int columna1, int columna2, int filaColor1, int columnaColor1, int columnaColor2, String color) {
        int cont = 0;
        int min = Math.min(columna1, columna2);
        int max = Math.max(columna1, columna2);
        boolean crece = false;

        if (columna1 < columna2) {
            crece = true;
        }

        if (crece) {
            for (int i = max; i >= min; i--) {
                Tableta tableta = this.getTableta(fila1, i);
                if (i == min) {
                    if (columnaColor1 == 1) {
                        tableta.dibujarAve(filaColor1, columnaColor1, color);
                        cont++;
                    } else {
                        tableta.dibujarAve(filaColor1, columnaColor1, color);
                        tableta.dibujarAve(filaColor1, columnaColor1 + 1, color);
                        cont += 2;
                    }
                } else {
                    if (i == max) {
                        if (columnaColor1 == 0) {
                            tableta.dibujarAve(filaColor1, columnaColor2, color);
                            cont++;
                        } else {
                            tableta.dibujarAve(filaColor1, columnaColor2 - 1, color);
                            tableta.dibujarAve(filaColor1, columnaColor2, color);
                            cont += 2;
                        }
                    } else {
                        tableta.dibujarAve(filaColor1, 0, color);
                        tableta.dibujarAve(filaColor1, 1, color);
                        cont += 2;
                    }
                }
            }
        } else {
            for (int i = min; i <= max; i++) {
                Tableta tableta = this.getTableta(fila1, i);
                if (i == min) {
                    if (columnaColor1 == 1) {
                        tableta.dibujarAve(filaColor1, columnaColor1, color);
                        cont++;
                    } else {
                        tableta.dibujarAve(filaColor1, columnaColor1, color);
                        tableta.dibujarAve(filaColor1, columnaColor1 + 1, color);
                        cont += 2;
                    }
                } else {
                    if (i == max) {
                        if (columnaColor2 == 0) {
                            tableta.dibujarAve(filaColor1, columnaColor2, color);
                            cont++;
                        } else {
                            tableta.dibujarAve(filaColor1, columnaColor2 - 1, color);
                            tableta.dibujarAve(filaColor1, columnaColor2, color);
                            cont += 2;
                        }
                    } else {
                        tableta.dibujarAve(filaColor1, 0, color);
                        tableta.dibujarAve(filaColor1, 1, color);
                        cont += 2;
                    }
                }
            }

        }
        return cont;
    }

    public int pintarVertical(int fila1, int fila2, int columna1, int filaColor1, int filaColor2, int columnaColor1, String color) {
        int cont = 0;
        int min = Math.min(fila1, fila2);
        int max = Math.max(fila1, fila2);
        boolean crece = false;

        if (fila1 > fila2) {
            crece = true;
        }

        if (crece) {
            for (int i = max; i >= min; i--) {
                Tableta tableta = this.getTableta(i, columna1);
                if (i == min) {
                    if (filaColor1 == 1) {
                        tableta.dibujarAve(filaColor1, columnaColor1, color);
                        cont++;
                    } else {
                        tableta.dibujarAve(filaColor1, columnaColor1, color);
                        tableta.dibujarAve(filaColor1 + 1, columnaColor1, color);
                        cont += 2;
                    }
                } else {
                    if (i == max) {
                        if (filaColor2 == 0) {
                            tableta.dibujarAve(filaColor2, columnaColor1, color);
                            cont++;
                        } else {
                            tableta.dibujarAve(filaColor2 - 1, columnaColor1, color);
                            tableta.dibujarAve(filaColor2, columnaColor1, color);
                            cont += 2;
                        }
                    } else {
                        tableta.dibujarAve(0, columnaColor1, color);
                        tableta.dibujarAve(1, columnaColor1, color);
                        cont += 2;
                    }
                }
            }
        } else {
            for (int i = min; i <= max; i++) {
                Tableta tableta = this.getTableta(i, columna1);
                if (i == min) {
                    if (filaColor1 == 1) {
                        tableta.dibujarAve(filaColor1, columnaColor1, color);
                        cont++;
                    } else {
                        tableta.dibujarAve(filaColor1, columnaColor1, color);
                        tableta.dibujarAve(filaColor1 + 1, columnaColor1, color);
                        cont += 2;
                    }
                } else {
                    if (i == max) {
                        if (filaColor2 == 0) {
                            tableta.dibujarAve(filaColor2, columnaColor1, color);
                            cont++;
                        } else {
                            tableta.dibujarAve(filaColor2 - 1, columnaColor1, color);
                            tableta.dibujarAve(filaColor2, columnaColor1, color);
                            cont += 2;
                        }
                    } else {
                        tableta.dibujarAve(0, columnaColor1, color);
                        tableta.dibujarAve(1, columnaColor1, color);
                        cont += 2;
                    }
                }
            }

        }
        return cont;
    }

    public boolean pintarExtend(int fila, int columna, int filaColor, int columnaColor, char direccion, String color, int filaExt, int colExt) {
        int filaColExt = colorTableta(filaExt, colExt, color)[0];
        int colColExt = colorTableta(filaExt, colExt, color)[1];
        boolean pintando = true;
        if (darOrientacionE(direccion) == 1) {
            this.pintarHorizontal(fila, columna, colExt, filaColor, columnaColor, colColExt, color);
        } else {
            this.pintarVertical(fila, filaExt, columna, filaColor, filaColExt, columnaColor, color);
        }
        return false;
    }

    public boolean extender(int fila, int columna, char direccion, int indiceJugador, Partida p) {
        int contador = p.getJugadores().get(indiceJugador).getCantAves();
        String color = p.getJugadores().get(indiceJugador).getColorJugador();
        Interfaz interfaz = new Interfaz();
        int columnaColor = -1;
        int filaColor = -1;
        boolean crece = true;
        if (direccion == 'A' || direccion == 'I') {
            crece = false;
        }
        boolean pintando = true;
        boolean running = true;

        if (canExtend(fila, columna, color, direccion, contador)) {
            while (canExtend(fila, columna, color, direccion, contador) && pintando) {
                for (int j = 0; j < 2; j++) {
                    for (int k = 0; k < 2; k++) {
                        if (color.equals(this.getTableta(fila, columna).devolverUnColor(j, k))) {
                            filaColor = j;
                            columnaColor = k;
                        }
                    }
                }
                if (direccion == ('A') || direccion == ('B')) {
                    pintando = pintarExtend(fila, columna, filaColor, columnaColor, direccion, color, this.validarExtension(columna, fila, crece, color)[1], this.validarExtension(columna, fila, crece, color)[2]);
                } else {
                    pintando = pintarExtend(fila, columna, filaColor, columnaColor, direccion, color, this.validarExtension(fila, columna, crece, color)[1], this.validarExtension(fila, columna, crece, color)[2]);
                }
            }
            running = false;
        } else {
            System.out.println("No se puede extender");
            interfaz.sonidoError();
        }

        return running;
    }

    public boolean sePuedePonerTableta(int fila, int col) {
        Tableta[][] tablero = this.getTablero();
        Interfaz interfaz = new Interfaz();
        int[] coordFila = this.getCoordTablero5por5("filas");
        int[] coordCol = this.getCoordTablero5por5("columnas");
        boolean validador = false;

        if (tablero[fila][col] == null) {
            if (this.hayTabletaAlLado(fila, col)) {
                if (!this.hayCincoTabletas(fila, col)) {
                    if (this.validarSiPerteneceA5por5(coordFila, coordCol, new int[]{fila, col})) {
                        validador = true;
                    } else {
                        System.out.println("No se encuentra dentro del tablero 5x5");
                        interfaz.sonidoError();
                    }
                } else {
                    System.out.println("Ya hay 5 tabletas en esa fila o columna");
                    interfaz.sonidoError();
                }
            } else {
                System.out.println("No hay ninguna tableta al lado");
                interfaz.sonidoError();
            }
        } else {
            System.out.println("Ya hay una tableta en ese lugar");
            interfaz.sonidoError();
        }

        return validador;
    }

    public boolean hayTabletaAlLado(int fila, int col) {
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

    public boolean hayCincoTabletas(int fila, int col) {
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

    public boolean validarSiPerteneceA5por5(int[] coordFila, int[] coordCol, int[] coordTableta) {
        boolean validador = true;

        /* 
        Chequeo si la fila en la que esta la tableta no se encuentra entre
        la fila que comienza el tablero de 5x5 y la fila en la que termina.
         */
        if (coordFila[0] != coordFila[1]) {
            if (coordTableta[0] < coordFila[0] || coordTableta[0] > coordFila[1]) {
                validador = false;
            }
        }

        /*
        Hago el mismo chequeo que arriba pero para las columnas
         */
        if (coordCol[0] != coordCol[1]) {
            if (coordTableta[1] < coordCol[0] || coordTableta[1] > coordCol[1]) {
                validador = false;
            }
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
