package obligatorio1p2;

import java.util.*;

public class Interfaz {

    private Aves aves = new Aves();

//  Metodos de validacion de ingreso de datos 
    public int ingresarInt(String tipoDato) {
        Scanner input = new Scanner(System.in);
        boolean validador = false;
        int valor = 0;

        do {
            try {
                valor = input.nextInt();
                input.nextLine();
                validador = validarInt(valor, tipoDato);
            } catch (Exception e) {
                System.out.println("Verifique el valor ingresado");
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
     */
    public boolean validarInt(int valor, String tipoDato) {
        boolean validador = false;

        switch (tipoDato) {
            case "menuPrincipal":
                if (valor > 0 && valor < 6) {
                    validador = true;
                }
                break;

            case "menuConfig":
                if (valor > 0 && valor < 7) {
                    validador = true;
                }
                break;

            case "cantJug":
                if (valor > 1 && valor < 5) {
                    validador = true;
                }

            case "cantAves":
                if (valor > 4 && valor < 46) {
                    validador = true;
                }

            case "cantRot":
                if (valor >= 0 && valor < 6) {
                    validador = true;
                }

            case "cantTabs":
                if (valor > 4 && valor < 25) {
                    validador = true;
                }

            case "configTerm":
                if (valor > 0 && valor < 4) {
                    validador = true;
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
            if(!dato.isEmpty()) {
                validador = true;
            }
            if(validarString(dato, tipoString)) {
                
            }
        } while(!validador);

        return dato;
    }
    
    public boolean validarString(String dato, String tipoString) {
        boolean validador = true;
        
        return validador;
    }

    public void menuPrincipalTemplate() {
        System.out.println("+-!-!-!-!- >|< AVES! 1.0 (Beta) >|< -!-!-!-!- +");
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
        nombre = ingresarString("nombreJug");
        System.out.println("Ingresa tu Edad");
        edad = ingresarInt("edadJug");
        System.out.println("Escribe tu Alias");
        alias = ingresarString("aliasJug");

        this.aves.setJugador(nombre, edad, alias);
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
        cantJug = ingresarInt("cantJug");

        this.aves.setConfiguracion(0, cantJug);
    }

    public void configAves() {
        int cantAves;

        System.out.println("Ingresa la cantidad de aves por jugador");
        cantAves = ingresarInt("cantAves");

        this.aves.setConfiguracion(1, cantAves);
    }

    public void configRot() {
        int cantRot;

        System.out.println("Ingresa la cantidad de rotaciones por jugador");
        cantRot = ingresarInt("cantRot");

        this.aves.setConfiguracion(2, cantRot);
    }

    public void configTabs() {
        int cantTab;

        System.out.println("Ingresa la cantidad de tabletas por Jugador");
        cantTab = ingresarInt("cantTabs");

        this.aves.setConfiguracion(3, cantTab);
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

        menuConfigTermTemplate();
        opcSel = ingresarInt("configTerm");
        switch (opcSel) {
            case 1:
                this.aves.setConfiguracion(4, 1);
                break;
            case 2:
                this.aves.setConfiguracion(4, 2);
                break;
            case 3:
                this.aves.setConfiguracion(4, 3);
                System.out.println("Ingrese la cantidad de turnos a definir");
                cantTurn = ingresarInt("cantTurn");
                this.aves.setConfiguracion(5, cantTurn);
                System.out.println("La partida tendra " + cantTurn + " turnos");
                break;
        }

        System.out.println("Se ha configurado el tipo de terminacion " + opcSel);
    }

    public void start() {
        int selPrincipal;
        boolean running = true;

        do {
            this.menuPrincipalTemplate();
            selPrincipal = ingresarInt("menuPrincipal");
            switch (selPrincipal) {
                //Registar jugador
                case 1:
                    registrarJugador();
                    break;

                //Menu configuracion
                case 2:
                    menuConfig();
                    break;

                //Jugar
                case 3:
                    this.aves.jugar();
                    break;

                //Ranking de jugadores
                case 4:
                    this.aves.getRanking();
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

        menuConfigTemplate();
        opcSel = ingresarInt("menuConfig");
        do {
            switch (opcSel) {
                case 1:
                    configCantJugadores();
                    break;
                case 2:
                    configAves();
                    break;
                case 3:
                    configRot();
                    break;
                case 4:
                    configTabs();
                    break;
                case 5:
                    configTerm();
                    break;
                case 6:
                    running = false;
                    break;
            }
        } while (running);
    }
}
