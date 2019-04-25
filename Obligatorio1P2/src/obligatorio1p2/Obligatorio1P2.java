/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package obligatorio1p2;

/**
 *
 * @author ezequiellopez
 */
import java.util.*;
public class Obligatorio1P2 {
Partida part=new Partida();

public static int excepcion() {
        Scanner input = new Scanner(System.in);
        boolean excep= true;
        int retorno = 0;
        int valor= 0;
        do {
            try {
                valor= input.nextInt();
                excep= false;
            } catch (Exception e) {
                System.out.println("Verifique el valor ingresado");
                input.nextLine();
            }
        } while (excep);
        retorno = valor;
        return retorno;

    }
 public static int validar(int min, int max, int valor) {
        boolean valida= false;
        if (valor >= min&& valor <= max) {
            valida= true;
        }
        while (!valida) {
            System.out.println("verifique el valor ingresado");
            valor = excepcion();
            if (valor >= min&& valor <= max) {
                valida= true;
            }
        }
        return valor;
    }



    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
