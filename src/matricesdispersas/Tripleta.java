
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
    
    /*public void SumarFila(){
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
    }*/
    
    /*public void SumarColumna(){
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
    }*/
    
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
    
    public void RedimensionarG(){
        int i, k=0;
        Tripleta T = new Tripleta(A[0][2]+1);

        for (i=0; i<=A[0][2]; i++)
        {
            T.A[k][0] = this.A[i][0];
            T.A[k][1] = this.A[i][1];
            T.A[k][2] = this.A[i][2];
            k++;
        }
    }
    
    public void Insertar(int d){
        boolean b;
        int f, c, k, i;
        
        b = true;
        f = Integer.parseInt(JOptionPane.showInputDialog("Ingrese fila a colocar dato: "));
        c = Integer.parseInt(JOptionPane.showInputDialog("Ingrese columna a colocar dato: "));
        A[f][c] = d;
        
        for (k=1; k<=A[0][2] && b; k++)
        {
            if(A[k][0] == f)
            {
                if(A[k][1] == c)
                {
                    A[k][2] = d;
                    b = false;
                }
                else
                {
                    if(A[k][1]<c && A[k+1][1]>c)
                    {
                        RedimensionarG();
                        
                        for(i=A[0][2]; i>k; i--)
                        {
                            A[i+1][0] = A[i][0];
                            A[i+1][1] = A[i][1];
                            A[i+1][2] = A[i][2];
                        }
                        
                        A[k+1][0] = f;
                        A[k+1][1] = c;
                        A[k+1][2] = d;
                        b = false;
                        A[0][1] += 1;
                        A[0][2] += 1;
                    }
                    else
                    {
                        if (k+1 > A[0][2])
                        {
                            RedimensionarG();
                            
                            A[k+1][0] = f;
                            A[k+1][1] = c;
                            A[k+1][2] = d;
                            b = false;
                            A[0][1] += 1;
                            A[0][2] += 1;
                        }
                    }
                }
            }
            else
            {
                if(A[k][0]<f && A[k+1][0]>f)
                {
                    RedimensionarG();
                    
                    for(i=A[0][2]; i>k; i--)
                    {
                        A[i+1][0] = A[i][0];
                        A[i+1][1] = A[i][1];
                        A[i+1][2] = A[i][2];
                    }
                    
                    A[k+1][0] = f;
                    A[k+1][1] = c;
                    A[k+1][2] = d;
                    b = false;
                    A[0][0] += 1;
                    A[0][1] += 1;
                    A[0][2] += 1;
                }
                else
                {
                    if(k+1 > A[0][2])
                    {
                        RedimensionarG();
                        
                        A[k+1][0] = f; //
                        A[k+1][1] = c;
                        A[k+1][2] = d;
                        b = false;
                        A[0][0] += 1;
                        A[0][1] += 1;
                        A[0][2] += 1;
                    }
                    else
                    {
                        if(A[k][0] > f)
                        {
                            RedimensionarG();
                            
                            for(i=A[0][2]; i>k; i--)
                            {
                                A[i+1][0] = A[i][0];
                                A[i+1][1] = A[i][1];
                                A[i+1][2] = A[i][2];
                            }
                            
                            A[k][0] = f;
                            A[k][1] = c;
                            A[k][2] = d;
                            b = false;
                            A[0][0] += 1;
                            A[0][1] += 1;
                            A[0][2] += 1;
                        }
                    }
                }
            }
        }
        
        Mostrar();
    }
    
}
