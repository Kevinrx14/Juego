package obligatorio1p2;

import java.util.*;

public class Interfaz {

    /**
     * @param args the command line arguments
     */
    int[] configuracion = {2, 45, 5, 25, 3, 10};
    public void configurar(Partida p){
        p.setCantJugadores(configuracion[0]);
        p.setAvesXjug(configuracion[1]);
        p.setFichasRotXJug(configuracion[2]);
        p.setTotalTab(configuracion[3]);
        p.setTipoTerm(configuracion[4]);
        p.setCantTurnos(configuracion[5]);
    }
    public static void menuPrincipal() {
        System.out.println("+-!-!-!-!- >|< AVES! 1.0 (Beta) >|< -!-!-!-!- +");
        System.out.println("|><    ><    ><    ><    ><    ><    ><    >< |");
        System.out.println("|   ><    ><    ><    ><    ><    ><    ><    |");
        System.out.println("+--------M E N U    P R I N C I P A L-------- +");
        System.out.println("+---------Ingresa la opcion deseada---------- +");
        System.out.println("|><    ><    ><    ><    ><    ><    ><    >< |");
        System.out.println("|   ><    ><    ><    ><    ><    ><    ><    |");
        System.out.println("|A-           Registrar Jugador               |");
        System.out.println("+---------------------------------------------+");
        System.out.println("|B-             Configuracion                 |");
        System.out.println("+---------------------------------------------+");
        System.out.println("|C-             ><  JUGAR ><                  |");
        System.out.println("+---------------------------------------------+");
        System.out.println("|D-          Ranking de Jugadores             |");
        System.out.println("+---------------------------------------------+");
        System.out.println("|E-                 Salir                     |");
        System.out.println("+---------------------------------------------+");
        System.out.println("+------------By Kevin & Ezequiel--------------+");
    }

    public static void registrarJugador() {
        Scanner input = new Scanner(System.in);
        System.out.println("Ingrese tu nombre");
        String nombre = input.nextLine();
        System.out.println("Ingrese tu Edad");
        int edad = input.nextInt();
        System.out.println("Escribe tu Alias");
        String alias = input.nextLine();
        Jugador j = new Jugador(nombre, edad, alias);
        System.out.println("Bienvenido a Aves " + alias);
    }

    public static void menuConfig() {
        System.out.println("CONFIGURACION DE PARTIDA");
        System.out.println("========================");
        System.out.println("");
        System.out.println("Ingresa la opcion deseada");
        System.out.println("");
        System.out.println("========================");
        System.out.println("A- Cantidad de jugadores");
        System.out.println("");
        System.out.println("B- Aves por jugador");
        System.out.println("");
        System.out.println("C- Rotaciones por jugador");
        System.out.println("");
        System.out.println("D- Tabletas por jugador");
        System.out.println("");
        System.out.println("E- Terminacion");
        System.out.println("");
        System.out.println("F- Volver al menu");
        System.out.println("========================");
    }

    public void configCantJugadores() {
        Scanner input = new Scanner(System.in);
        System.out.println("Ingresa la cantidad de jugadores");
        int cantJug = input.nextInt();
        configuracion[0]=cantJug;
    }

    public void configAves() {
        Scanner input = new Scanner(System.in);
        System.out.println("Ingresa la cantidad de aves por jugador");
        int cantAves = input.nextInt();
        configuracion[1]=cantAves;
    }

    public void configRot() {
        Scanner input = new Scanner(System.in);
        System.out.println("Ingresa la cantidad de rotaciones por jugador");
        int cantRot = input.nextInt();
        configuracion[2]=cantRot;
    }

    public void configTabs() {
        Scanner input = new Scanner(System.in);
        System.out.println("Ingresa la cantidad de tabletas por Jugador");
        int cantTab = input.nextInt();
        configuracion[3]=cantTab;
    }

    public static void configTerm() {
        Scanner input = new Scanner(System.in);
        System.out.println("Selecciona el tipo de terminacion");
        System.out.println("=================================");
        System.out.println("1- Completar Tablero");
        System.out.println("");
        System.out.println("2- Terminar aves");
        System.out.println("");
        System.out.println("3- Cantidad de turnos");
        System.out.println("=================================");
        int selBE = input.nextInt();
        switch (selBE) {
            case 1:

                break;
            case 2:

                break;
            case 3:

                break;
        }
        System.out.println("Se ha configurado el tipo de terminacion " + selBE);
    }

    public static void getRanking(ArrayList<Jugador> Jugadores, ArrayList<Partida> Partidas) {
        Collections.sort(Jugadores);
        for (int i = 0; i < Jugadores.size(); i++) {
            int tres = 0;
            int dos = 0;
            int uno = 0;
            String imprimo = i + 1 + "- " + Jugadores.get(i).toString();
            for (int j = 0; j < Partidas.size(); j++) {
                for (int o = 0; o < Partidas.get(j).getTodosJug().size(); o++) {
                    if (Partidas.get(j).getTodosJug().get(0).equals(Jugadores.get(i))) {
                        if (Partidas.get(j).getCantJugadores() == 4) {
                            tres = tres + 1;
                        }
                        if (Partidas.get(j).getCantJugadores() == 3) {
                            dos = dos + 1;
                        }
                        if (Partidas.get(j).getCantJugadores() == 2) {
                            uno = uno + 1;
                        }
                    }
                }
            }
            imprimo = imprimo + " | Partidas contra 3 jugadores: " + tres + " | Partidas contra 2 jugadores: " + dos + " | Partidas contra 1 jugador: " + uno;
            System.out.println(imprimo);
        }
    }
}