package matricesdispersas;

import javax.swing.JOptionPane;

public class Tripleta {

    private int A[][];

    public Tripleta(int D /*Datos diferentes de cero*/) {
        A = new int[D + 1][3];
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
    
//Métodos
    public void Construir(int[][] M, int d) {
        int k = 1, i, j;

        A[0][0] = M.length;
        A[0][1] = M[0].length;
        A[0][2] = d;
        for (i = 0; i < M.length; i++)
        {
            for (j = 0; j < M[0].length; j++)
            {
                if (M[i][j] != 0)
                {
                    A[k][0] = i;
                    A[k][1] = j;
                    A[k][2] = M[i][j];
                    k++;
                }
            }
        }
    }

    public void SumarColumnas() {
        int i, k = 1, vc[] = new int[A[0][1]];

        String s = "";
        while (k <= A[0][2])
        {
            vc[A[k][1]] += A[k][2];
            k++;
        }
        for (i = 0; i < vc.length; i++)
        {
            s = s + "Suma de columna " + (i + 1) + ": " + vc[i] + "\n";

        }
        JOptionPane.showMessageDialog(null, s);
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

}
