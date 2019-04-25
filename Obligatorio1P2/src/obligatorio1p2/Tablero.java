//Kevin Rinaldi 240179
package obligatorio1p2;
import java.util.*;

public class Tablero {
    private Tableta[][] tablero = new Tableta[10][10];
   
    public void setTablero(int[] coordenadas, Tableta tableta) {
        this.tablero[coordenadas[0]][coordenadas[1]] = tableta;
    }
    
    public Tableta[][] getTablero(){
        Tableta[][] tableroAux = new Tableta[10][10];
        for(int i = 0; i < this.tablero.length; i++){
            for(int j = 0; j < this.tablero[0].length; j++){
                tableroAux[i][j] = this.tablero[i][j];
            }
        }
        return tableroAux; 
    }

    @Override
    public String toString(){
//        Tableta[][] tableroAux = new Tableta[21][21];
//        for(int i = 0; i < this.tablero.length; i++){
//            for(int j = 0; j < this.tablero[0].length; j++){
//                if(i % 2 == 0 && j % 2 == 0){
//                tableroAux[i][j] = this.tablero[i][j];
//                } else {
//                    if( m)
//                }
//            }
//        }
        return "test";
    }
}
