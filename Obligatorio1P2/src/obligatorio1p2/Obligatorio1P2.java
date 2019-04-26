package obligatorio1p2;
import java.util.*;

public class Obligatorio1P2 {
//Partida part=new Partida();
//public static int excepcion() {
//        Scanner input = new Scanner(System.in);
//        boolean excep= true;
//        int retorno = 0;
//        int valor= 0;
//        do {
//            try {
//                valor= input.nextInt();
//                excep= false;
//            } catch (Exception e) {
//                System.out.println("Verifique el valor ingresado");
//                input.nextLine();
//            }
//        } while (excep);
//        retorno = valor;
//        return retorno;
//
//    }
// public static int validar(int min, int max, int valor) {
//        boolean valida= false;
//        if (valor >= min&& valor <= max) {
//            valida= true;
//        }
//        while (!valida) {
//            System.out.println("verifique el valor ingresado");
//            valor = excepcion();
//            if (valor >= min&& valor <= max) {
//                valida= true;
//            }
//        }
//        return valor;
//    }
//
//
        public static final String rojo = "\u001B[41m"; //Color rojo
        public static final String azul = "\u001B[44m"; //Color azul
        public static final String amarillo = "\u001B[43m"; //Color amarillo
        public static final String verde = "\u001B[42m"; //Color verde
        public static void main(String[] args) {
            String[][] colores = new String[2][2];

            Random rand = new Random();
        int num;
        String color = "";
        boolean validador;
        int[][] coloresAux = new int[2][2];
        
        for(int i = 0; i < coloresAux.length; i++){
            for(int j = 0; j < coloresAux[0].length; j++){
                do{
                    validador = true;
                    num = rand.nextInt(4);
                    num++;
                    System.out.println("num" + num + "---------------");
                    for(int x = 0; x < coloresAux.length; x++){
                        for(int y = 0; y < coloresAux[0].length; y++){
                            System.out.println("x" + x + " y" + y);
                            System.out.println("numarray " + coloresAux[x][y] + " num " + num);
                            if(coloresAux[x][y] == num){
                                System.out.println("repetido" + num);
                                validador = false;
                            }
                        }
                    }    
                }while(validador == false);
                coloresAux[i][j] = num;
                switch (coloresAux[i][j]) {
                        case 1:
                            colores[i][j] = "\u001B[41m" + " "; //Color rojo
                            break;

                        case 2:
                            colores[i][j] = "\u001B[44m" + " "; //Color azul
                            break;

                        case 3:
                            colores[i][j] = "\u001B[43m" + " "; //Color amarillo
                            break;

                        case 4:
                            colores[i][j] = "\u001B[42m" + " "; //Color verde
                            break;
                }
            }   
        }
        System.out.print(colores[0][0]);
        System.out.println(colores[0][1]);
        System.out.print(colores[1][0]);
        System.out.println(colores[1][1]);
    }   
}
