/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package obligatorio1p2;

import java.util.*;

/**
 *
 * @author alumnoFI
 */
public class Interfaz {

// Metodos de validacion de ingreso de datos
    public static int excepcion() {
        Scanner input = new Scanner(System.in);
        boolean excep = true;
        int retorno = 0;
        int valor = 0;
        do {
            try {
                valor = input.nextInt();
                excep = false;
            } catch (Exception e) {
                System.out.println("Verifique el valor ingresado");
                input.nextLine();
            }
        } while (excep);
        retorno = valor;
        return retorno;

    }

    public static int validar(int min, int max, int valor) {
        boolean valida = false;
        if (valor >= min && valor <= max) {
            valida = true;
        }
        while (!valida) {
            System.out.println("verifique el valor ingresado");
            valor = excepcion();
            if (valor >= min && valor <= max) {
                valida = true;
            }
        }
        return valor;
    }
    //

    public static void menuPrincipal() {
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

    public static void registrarJugador(Aves a) {
        Scanner input = new Scanner(System.in);
        System.out.println("Ingresa tu nombre");
        String nombre = input.nextLine();
        System.out.println("Ingresa tu Edad");
        int edad = excepcion();
        System.out.println("Escribe tu Alias");
        String alias = input.nextLine();
        a.crearJugador(nombre, edad, alias);
        System.out.println("Bienvenido a Aves " + alias);
    }

    public static void menuConfig() {
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

    public void configCantJugadores(Aves a) {
        Scanner input = new Scanner(System.in);
        System.out.println("Ingresa la cantidad de jugadores");
        int cantJug = validar(2, 4, excepcion());
        a.setConfiguracion(0, cantJug);
    }

    public void configAves(Aves a) {
        Scanner input = new Scanner(System.in);
        System.out.println("Ingresa la cantidad de aves por jugador");
        int cantAves = validar(5, 45, excepcion());
        a.setConfiguracion(1, cantAves);
    }

    public void configRot(Aves a) {
        Scanner input = new Scanner(System.in);
        System.out.println("Ingresa la cantidad de rotaciones por jugador");
        int cantRot = validar(0, 5, excepcion());
        a.setConfiguracion(2, cantRot);
    }

    public void configTabs(Aves a) {
        Scanner input = new Scanner(System.in);
        System.out.println("Ingresa la cantidad de tabletas por Jugador");
        int cantTab = validar(5, 25, excepcion());
        a.setConfiguracion(3, cantTab);
    }

    public void configTerm(Aves a) {
        Scanner input = new Scanner(System.in);
        System.out.println("Selecciona el tipo de terminacion");
        System.out.println("=================================");
        System.out.println("1- Completar Tablero");
        System.out.println("");
        System.out.println("2- Terminar aves");
        System.out.println("");
        System.out.println("3- Cantidad de turnos");
        System.out.println("=================================");
        int selBE = validar(1, 3, excepcion());
        switch (selBE) {
            case 1:
                a.setConfiguracion(4, 1);
                break;
            case 2:
                a.setConfiguracion(4, 2);
                break;
            case 3:
                a.setConfiguracion(4, 3);
                System.out.println("Ingrese la cantidad de turnos a definir");
                int cantTurn=input.nextInt();
                a.setConfiguracion(5, cantTurn);
                System.out.println("La partida tendra "+cantTurn+" turnos");
                break;
        }

        System.out.println("Se ha configurado el tipo de terminacion " + selBE);
    }

    public void start() {
        Aves a= new Aves();
        boolean runing = true;
        while (runing) {
            this.menuPrincipal();
            int selPrincipal = validar(1, 6, excepcion());
            switch (selPrincipal) {
                case 1:
                    this.registrarJugador(a);
                    break;
                case 2:
                    boolean inConf = true;
                    while (inConf) {
                        this.menuConfig();
                        int selConfig = validar(1, 6, excepcion());
                        switch (selConfig) {
                            case 1:
                                this.configCantJugadores(a);
                                break;
                            case 2:
                                this.configAves(a);
                                break;
                            case 3:
                                this.configRot(a);
                                break;
                            case 4:
                                this.configTabs(a);
                                break;
                            case 5:
                                this.configTerm(a);
                                break;
                            case 6:
                                inConf = false;
                                break;
                        }
                    }
                    break;
                case 3:
                    //a.empezar();
                    break;
                case 4:
                    a.getRanking();
                    break;
                case 5:
                    runing=false;
                    System.out.println("Gracias por Jugar Aves :D");
                    break;
            }
        }
    }
}
