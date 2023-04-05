
package matricesdispersas;

import Utilidades.Matriz;
//
public class MatricesDispersas {

    public static void main(String[] args) {
        Matriz M = new Matriz();
        
        M.ConstruirRandom();
        Mostrar(M.getM());
        
        
    }
    
    public static void Mostrar(int[][] M){
        int i, j;
        
        for (i=0; i<M.length; i++)
        {
            for (j=0; j<M[0].length; j++)
            {
                System.out.print("|" + M[i][j] + "|");
            }
            
            System.out.println("");
        }
    }
    
}
