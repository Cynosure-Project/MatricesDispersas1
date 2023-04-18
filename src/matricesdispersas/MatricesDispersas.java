
package matricesdispersas;

import Utilidades.Matriz;
import javax.swing.JOptionPane;

public class MatricesDispersas {

    public static void main(String[] args) {
        Matriz M = new Matriz();
        int r;
        
        do
        {
            r = Integer.parseInt(JOptionPane.showInputDialog("""
                                                                    Menú Matrices dispersas
                                                                                                                                                                                                           
                                                                    1. Tripleta
                                                                    2. Forma 1
                                                                    3. Forma 2
                                                                    0. Salir
                                                                        """));
            
            switch(r)
            {
                case 1:
                    
            }
        }
        while(r != 0);
        
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
