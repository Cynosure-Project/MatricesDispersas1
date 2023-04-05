
package matricesdispersas;

import static matricesdispersas.MatricesDispersas.Mostrar;

public class Tripleta {
    private int A[][];

    public Tripleta(int D /*Datos diferentes de cero*/) {
        A = new int[D+1][3];
    }

    public int[][] getA() {
        return A;
    }

    public void setA(int[][] A) {
        this.A = A;
    }
    
    public int getA(int i, int j) {
        return A[i][j];
    }

    public void setA(int i, int j, int d) {
        A[i][j] = d;
    }
    
    public void Construir(int[][] Mat, int CD){
        int k = 1;
        
        A[0][0] = Mat.length; //Número de filas
        A[0][1] = Mat[0].length; //Numero de columnas
        A[0][2] = CD; 
        
        for (int i=0; i<Mat.length; i++)
        {
            for (int j=0; j<Mat[0].length; j++)
            {
                if (Mat[i][j] != 0)
                {
                    A[k][0] = i;
                    A[k][1] = j;
                    A[k][2] = Mat[i][j];
                    
                    k++;
                }
            }
        }
        
        Mostrar(A);
    }
    
    
    
}
