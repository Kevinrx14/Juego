package obligatorio1p2;

import java.util.*;

public class Interfaz {

    private Aves aves;

    public Interfaz() {
        this.setAves();
    }

    public void setAves() {
        this.aves = new Aves();
    }

    public Aves getAves() {
        return this.aves;
    }

//  Metodos de validacion de ingreso de datos 
    public int ingresarInt(String tipoDato) {
        Scanner input = new Scanner(System.in);
        boolean validador = false;
        int valor = 0;

        do {
            try {
                valor = input.nextInt();
                input.nextLine();
                validador = this.validarInt(valor, tipoDato);
            } catch (Exception e) {
                System.out.println("Verifique el valor ingresado");
                this.sonidoError();
                input.nextLine();
            }
        } while (!validador);

        return valor;
    }

    /*  Tipo de datos:
    menuPrincipal = valida la opcion del menu principal (1 - 5)
    menuConfig = valida la opcion del menu de configuraciones (1 - 6)
    cantJug = valida la cantidad de jugadores (2 - 4)
    cantAves = valida la cantidad de aves (5 - 45)
    cantRot = valida la cantidad de rotaciones (0 - 5)
    cantTabs = valida la cantidad de Tabletas (5 - 25)
    configTerm = valida la opcion del menu configuracion de terminacion (1 - 3)
    elegirJug = valida que la opcion este entre todos los jugadores disponibles
     */
    public boolean validarInt(int valor, String tipoDato) {
        boolean validador = false;
        boolean noAplica = false;
        int min = 0;
        int max = 0;

        switch (tipoDato) {
            case "menuPrincipal":
                min = 1;
                max = 5;
                break;

            case "menuConfig":
                min = 1;
                max = 6;
                break;

            case "cantJug":
                min = 2;
                max = 4;
                break;

            case "cantAves":
                min = 5;
                max = 45;
                break;

            case "cantRot":
                min = 0;
                max = 5;
                break;

            case "cantTabs":
                min = 5;
                max = 24;
                break;

            case "configTerm":
                min = 1;
                max = 3;
                break;

            case "elegirJug":
                min = 0;
                max = this.getAves().getJugadores().size();
                break;

            //En caso que sea una opcion que no se necesita chequear
            default:
                validador = true;
                noAplica = true;
                break;
        }

        if (!noAplica) {
            if (valor >= min && valor <= max) {
                validador = true;
            } else {
                System.out.println("Eliga una opcion entre " + min + " y " + max);
                this.sonidoError();
            }
        }

        return validador;
    }

    public String ingresarString(String tipoString) {
        Scanner input = new Scanner(System.in);
        String dato = "";
        boolean validador = false;

        do {
            dato = input.nextLine();
            if (!dato.isEmpty()) {
                if (tipoString.equals("jugada")) {
                    dato = dato.toUpperCase();
                }
                if (this.validarString(dato, tipoString)) {
                    validador = true;
                }
            } else {
                System.out.println("No se ingresaron datos");
                this.sonidoError();
            }
        } while (!validador);
        return dato;
    }

    public boolean validarString(String dato, String tipoString) {
        char movimiento;
        boolean validador = false;

        switch (tipoString) {
            case "jugada":
                movimiento = dato.charAt(0);
                if (this.validarJugadaIngresada(dato, movimiento)) {
                    validador = true;
                } else {
                    System.out.println("La jugada ingresada no es correcta");
                    this.sonidoError();
                }
                break;

            case "aliasJug":
                String alias;
                int cantJug = this.getAves().getJugadores().size();

                if (cantJug == 0) {
                    validador = true;
                }

                for (int i = 0; i < cantJug; i++) {
                    alias = this.getAves().getJugadores().get(i).getAlias();
                    alias = alias.toLowerCase();
                    if (dato.toLowerCase().equals(alias)) {
                        validador = false;
                        i = cantJug;
                        System.out.println("Ese alias ya existe");
                        this.sonidoError();
                    } else {
                        validador = true;
                    }
                }

                break;

            default:
                validador = true;
                break;
        }

        return validador;
    }

    public boolean validarJugadaIngresada(String jugada, char movimiento) {
        int[] indices;
        String indicacion1 = "";
        String indicacion2 = "";
        boolean validador = false;

        if (jugada.length() >= 6 && jugada.length() < 10) {
            indices = this.getIndicesDeIndicacion(1, jugada);
            indicacion1 = jugada.substring(indices[0], indices[1]);
            indices = this.getIndicesDeIndicacion(2, jugada);
            indicacion2 = jugada.substring(indices[0], indices[1]);
        } else {
            //Esto aplica para la jugada de prueba PM
            if (jugada.length() >= 6 && jugada.length() <= 10) {
                indices = this.getIndicesDeIndicacion(1, jugada);
                indicacion1 = jugada.substring(indices[0], indices[1] + 1);
                indices = this.getIndicesDeIndicacion(2, jugada);
                indicacion2 = jugada.substring(indices[0] + 1, indices[1]);
            }
        }

        switch (movimiento) {
            //Rotar
            case 'R':
                if (this.validadorDePosicion(indicacion1)) {
                    if (this.validadorDeRotacion(indicacion2)) {
                        validador = true;
                    }
                } else {
                    System.out.println("La posicion indicada no es correcta");
                    this.sonidoError();

                }
                break;
            //Conectar
            case 'C':
                if (this.validadorDePosicion(indicacion1)
                        && this.validadorDePosicion(indicacion2)) {
                    validador = true;
                } else {
                    System.out.println("Una posicion no es correcta");
                    this.sonidoError();
                }

                break;
            //Poner tableta 
            case 'P':
                if (jugada.charAt(1) == 'M') {
                    if (this.validadorDePosicion(indicacion1)) {
                        if (this.validadorDeColoresPM(indicacion2)) {
                            validador = true;
                        }

                    }
                } else {
                    if (jugada.length() > 3 && jugada.length() < 6) {
                        if (this.validadorDePosicion(jugada.substring(2))) {
                            validador = true;
                        }
                    }
                }
                break;
            //Extender 
            case 'E':
                if (this.validadorDeDireccion(indicacion1)) {
                    if (this.validadorDePosicion(indicacion2)) {
                        validador = true;
                    } else {
                        System.out.println("Una posicion no es correcta");
                        this.sonidoError();
                    }
                }
                break;
            //Salir    
            case 'X':
                if (jugada.length() == 1) {
                    validador = true;
                } else {
                    System.out.println("La jugada no fue ingresada correctamente");
                    System.out.println("Para terminar el juego solamente ingrese X");
                    this.sonidoError();
                }
                break;
        }

        return validador;
    }

    public int[] getIndicesDeIndicacion(int indicacion, String jugada) {
        int[] indices = new int[2];
        String aux;
        int inicio;

        inicio = jugada.indexOf(" ") + 1;
        aux = jugada.substring(inicio);

        /* chequeo que indicacion quiero saber
        Ejemplo: C E4 E5
        E4 = Indicacion 1
        E5 = Indicacion 2 */
        if (indicacion == 1) {
            indices[0] = inicio;
            indices[1] = aux.indexOf(" ") + 2;
        } else {
            if (indicacion == 2) {
                indices[0] = aux.indexOf(" ") + 3;
                indices[1] = jugada.length();
            }
        }

        return indices;
    }

    public boolean validadorDePosicion(String posicion) {
        String[] listaPosiciones = new String[100];
        int[] indicesCol = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        char[] indicesFilas = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};
        boolean validador = false;
        int indice = 0;

        for (int i = 0; i < indicesFilas.length; i++) {
            for (int j = 0; j < indicesCol.length; j++) {
                listaPosiciones[indice] = Character.toString(indicesFilas[i]) + Integer.toString(indicesCol[j]);
                indice++;
            }
        }

        for (int i = 0; i < listaPosiciones.length; i++) {
            if (posicion.equals(listaPosiciones[i])) {
                validador = true;
                break;
            }
        }

        return validador;
    }

    public boolean validadorDeRotacion(String rotacion) {
        boolean validador = false;

        switch (rotacion) {
            case "90":
                validador = true;
                break;

            case "180":
                validador = true;
                break;

            case "270":
                validador = true;
                break;

            default:
                System.out.println("No se puede rotar " + rotacion + " grados");
                this.sonidoError();
                break;
        }

        return validador;
    }

    public boolean validadorDeDireccion(String chequear) {
        char[] direcciones = new char[]{'I', 'D', 'A', 'B'};
        char aux;
        boolean validador = false;

        aux = chequear.charAt(0);
        for (int i = 0; i < direcciones.length; i++) {
            if (aux == direcciones[i]) {
                validador = true;
            }
        }

        if (!validador) {
            System.out.println("La direccion ingresada no es valida");
            this.sonidoError();
        }

        return validador;
    }

    //Valida los colores que se ingresa en la jugada PM
    public boolean validadorDeColoresPM(String chequear) {
        char[] colores = new char[]{'A', 'R', 'M', 'V'};
        int contador = 0;
        boolean validador = false;

        for (int i = 0; i < chequear.length(); i++) {
            for (int j = 0; j < colores.length; j++) {
                if (chequear.charAt(i) == colores[j]) {
                    validador = true;
                    contador++;
                }
            }
        }

        if (contador == 4) {
            validador = true;
        } else {
            System.out.println("No todos los colores ingresados son validos");
            this.sonidoError();
        }

        return validador;
    }

    public void menuPrincipalTemplate() {
        System.out.println("+-!-!-!-!-!-! >|< AVES!  1.0 >|< !-!-!-!-!-!- +");
        System.out.println("|><    ><    ><    ><    ><    ><    ><    >< |");
        System.out.println("|   ><    ><    ><    ><    ><    ><    ><    |");
        System.out.println("+--------M E N U    P R I N C I P A L-------- +");
        System.out.println("+---------Ingresa la opcion deseada---------- +");
        System.out.println("|><    ><    ><    ><    ><    ><    ><    >< |");
        System.out.println("|   ><    ><    ><    ><    ><    ><    ><    |");
        System.out.println("|1-           Registrar Jugador               |");
        System.out.println("+---------------------------------------------+");
        System.out.println("|2-             Configuracion                 |");
        System.out.println("+---------------------------------------------+");
        System.out.println("|3-             ><  JUGAR ><                  |");
        System.out.println("+---------------------------------------------+");
        System.out.println("|4-          Ranking de Jugadores             |");
        System.out.println("+---------------------------------------------+");
        System.out.println("|5-                 Salir                     |");
        System.out.println("+---------------------------------------------+");
        System.out.println("+------------By Kevin & Ezequiel--------------+");
    }

    public void registrarJugador() {
        String nombre;
        String alias;
        int edad;

        System.out.println("Ingresa tu nombre");
        nombre = this.ingresarString("nombreJug");
        System.out.println("Ingresa tu Edad");
        edad = this.ingresarInt("edadJug");
        System.out.println("Escribe tu Alias");
        alias = this.ingresarString("aliasJug");

        this.getAves().setJugador(nombre, edad, alias);
        System.out.println("Bienvenido a Aves " + alias);
    }

    public void menuConfigTemplate() {
        System.out.println("CONFIGURACION DE PARTIDA");
        System.out.println("========================");
        System.out.println("");
        System.out.println("Ingresa la opcion deseada");
        System.out.println("");
        System.out.println("========================");
        System.out.println("1- Cantidad de jugadores");
        System.out.println("");
        System.out.println("2- Aves por jugador");
        System.out.println("");
        System.out.println("3- Rotaciones por jugador");
        System.out.println("");
        System.out.println("4- Tabletas por jugador");
        System.out.println("");
        System.out.println("5- Terminacion");
        System.out.println("");
        System.out.println("6- Volver al menu");
        System.out.println("========================");
    }

    public void configCantJugadores() {
        int cantJug;

        System.out.println("Ingresa la cantidad de jugadores");
        cantJug = this.ingresarInt("cantJug");

        this.getAves().setUnaConfiguracion(0, cantJug);
    }

    public void configAves() {
        int cantAves;

        System.out.println("Ingresa la cantidad de aves por jugador");
        cantAves = ingresarInt("cantAves");

        this.getAves().setUnaConfiguracion(1, cantAves);
    }

    public void configRot() {
        int cantRot;

        System.out.println("Ingresa la cantidad de rotaciones por jugador");
        cantRot = ingresarInt("cantRot");

        this.getAves().setUnaConfiguracion(2, cantRot);
    }

    public void configTabs() {
        int cantTab;

        System.out.println("Ingresa la cantidad de tabletas por Jugador");
        cantTab = ingresarInt("cantTabs");

        this.getAves().setUnaConfiguracion(3, cantTab);
    }

    public void menuConfigTermTemplate() {
        System.out.println("Selecciona el tipo de terminacion");
        System.out.println("=================================");
        System.out.println("1- Completar Tablero");
        System.out.println("");
        System.out.println("2- Terminar aves");
        System.out.println("");
        System.out.println("3- Cantidad de turnos");
        System.out.println("=================================");
    }

    public void configTerm() {
        int opcSel;
        int cantTurn;

        this.menuConfigTermTemplate();
        opcSel = ingresarInt("configTerm");
        switch (opcSel) {
            //Completar tablero
            case 1:
                this.getAves().setUnaConfiguracion(4, 1);
                break;
            //Termianr aves
            case 2:
                this.getAves().setUnaConfiguracion(4, 2);
                break;
            //Cantidad de turnos
            case 3:
                this.getAves().setUnaConfiguracion(4, 3);
                System.out.println("Ingrese la cantidad de turnos a definir");
                cantTurn = this.ingresarInt("cantTurn");
                this.getAves().setUnaConfiguracion(5, cantTurn);
                System.out.println("La partida tendra " + cantTurn + " turnos");
                break;
        }

        System.out.println("Se ha configurado el tipo de terminacion " + opcSel);
    }

    public void start() {
        Aves aves = this.getAves();
        int selPrincipal;
        boolean running = true;

        do {
            this.menuPrincipalTemplate();
            selPrincipal = this.ingresarInt("menuPrincipal");
            switch (selPrincipal) {
                //Registar jugador
                case 1:
                    this.registrarJugador();
                    break;

                //Menu configuracion
                case 2:
                    this.menuConfig();
                    break;

                //Jugar
                case 3:
                    if (this.sePuedeJugar()) {
                        aves.jugar(this.mostrarJugadoresPartida());
                    }
                    break;

                //Ranking de jugadores
                case 4:
                    aves.getRanking();
                    break;

                //Salir
                case 5:
                    running = false;
                    System.out.println("Gracias por Jugar Aves :D");
                    break;
            }
        } while (running);
    }

    public void menuConfig() {
        int opcSel;
        boolean running = true;

        do {
            menuConfigTemplate();
            opcSel = ingresarInt("menuConfig");
            switch (opcSel) {
                case 1:
                    this.configCantJugadores();
                    break;
                case 2:
                    this.configAves();
                    break;
                case 3:
                    this.configRot();
                    break;
                case 4:
                    this.configTabs();
                    break;
                case 5:
                    this.configTerm();
                    break;
                case 6:
                    running = false;
                    break;
            }
        } while (running);
    }

    //De momento solo verifica si hay la cantidad suficiente de jugadores
    public boolean sePuedeJugar() {
        int[] configuracion = this.getAves().getConfiguracion();
        int cantTotalJug = this.getAves().getJugadores().size();
        boolean validador = false;

        //configuracion[0] = cantidad de jugadores por partida
        if (cantTotalJug >= configuracion[0]) {
            validador = true;
        } else {
            System.out.println("No hay la cantidad suficiente de jugadores");
            this.sonidoError();
        }

        return validador;
    }

    public void sonidoError() {
        java.awt.Toolkit.getDefaultToolkit().beep();
    }

    public ArrayList<Jugador> mostrarJugadoresPartida() {
        ArrayList<Jugador> jugadores = this.getAves().getJugadores();
        ArrayList<Jugador> jugadoresAux = new ArrayList<>();
        int[] configuracion = this.getAves().getConfiguracion();
        int cantJug = configuracion[0];
        int aux = 0;

        for (int i = 0; i < jugadores.size(); i++) {
            String alias = jugadores.get(i).getAlias();
            System.out.println((i + 1) + " - " + alias);
        }
        System.out.println("\n" + "0 - Salir");

        for (int i = 0; i < cantJug; i++) {
            aux = this.ingresarInt("elegirJug") - 1;
            if (aux >= 0) {
                jugadoresAux.add(jugadores.get(aux));
            } else {
                i = cantJug;
            }
        }

        return jugadoresAux;
    }
}
