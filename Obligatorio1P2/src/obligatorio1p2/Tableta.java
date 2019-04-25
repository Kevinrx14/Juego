
package obligatorio1p2;
import java.util.*;

public class Tableta {
    private String[][] colores = new String[2][2];
    private boolean[][] aves = new boolean[2][2];

    public void setAves(int x, int y){
        this.aves[x][y] = true;
    }
    
    public boolean[][] getAves() {
        return this.aves;
    }
    
    public void setColores(){
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
                    for(int x = 0; x < i; x++){
                        for(int y = 0; y < j; y++){
                            if(coloresAux[x][y] == num){
                                validador = false;
                            }
                        }
                    }    
                }while(validador == false);
                coloresAux[i][j] = num;
                switch (num) {
                        case 1:
                            color = "\u001B[41m"; //Color rojo
                            break;

                        case 2:
                            color = "\u001B[44m"; //Color azul
                            break;

                        case 3:
                            color = "\u001B[43m"; //Color amarillo
                            break;

                        case 4:
                            color = "\u001B[42m"; //Color verde
                            break;
                }
                this.colores[i][j] = color;
            }   
        }
    }
    
    public String[][] getColores(){
        return this.colores;
    }
    
    @Override
    public String toString(){
        return "test";
    }
    
}
