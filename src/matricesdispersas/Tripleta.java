
package matricesdispersas;

import javax.swing.JOptionPane;

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
    }
    
    public void SumarFila(){
        int V[], k;
        
        V = new int[A[0][0]];
        
        for (k=1; k<=A[0][2]; k++)
        {
            if (A[k][0]==0)
            {
                V[0] += A[k][2];
            }
            else
            {
                if (A[k][0] == 1)
                {
                    V[1] += A[k][2];
                }
                else
                {
                    if (A[k][0] == 2)
                    {
                        V[2] += A[k][2];
                    }
                }
            }
        }
        
        JOptionPane.showMessageDialog(null, "La suma de la primer fila: " + V[0] + "segunda: " + V[1] + " y tercera: " + V[2]);
    }
    
    public void SumarColumna(){
        int V[], k;
        
        V = new int[A[0][0]];
        
        for (k=1; k<=A[0][2]; k++)
        {
            if (A[k][1] == 0)
            {
                V[0] += A[k][2];
            }
            else
            {
                if (A[k][0] == 1)
                {
                    V[1] += A[k][2];
                }
                else
                {
                    if (A[k][0] == 2)
                    {
                        V[2] += A[k][2];
                    }
                }
            }
        }
    }
    
    public void Mostrar() {
        String s = "";
        for (int[] A1 : A)
        {
            for (int j = 0; j < A[0].length; j++)
            {
                s = s + "[ " + String.format("%4d", A1[j]) + " ]";
            }
            s = s + "\n";
        }
        JOptionPane.showMessageDialog(null, s, "Tripleta", 3);
    }
    
    public void Insertar(int[][] T, int d){
        boolean b;
        int f, c, k;
        
        b = true;
        f = Integer.parseInt(JOptionPane.showInputDialog("Ingrese fila a colocar dato: "));
        c = Integer.parseInt(JOptionPane.showInputDialog("Ingrese columna a colocar dato: "));
        
        T[f][c] = d;
        
        for(k=1; k<=T[0][2] && b; k++)
        {
            if(T[k][0] == f)
            {
                if(T[k][1] == c)
                {
                    T[k][2] = d;
                    b = false;
                }
                else
                {
                    if(T[k][1]<c && T[k+1][1]>c)
                    {
                        T = RedimensionarG(T[0][2]+1);
                    }
                }
            }
        }
    }
    
    public int[][] RedimensionarG(int d){
        int i, k=0;
        Tripleta T = new Tripleta(d);

        for (i=0; i<=d; i++)
        {
            T.A[k][0] = this.A[i][0];
            T.A[k][1] = this.A[i][1];
            T.A[k][2] = this.A[i][2];
            k++;
        }
        
        return A;
    }
    
}
