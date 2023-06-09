
package Utilidades;

public class Matriz {
    private int n, m, M[][];
    public Matriz(){
        //n = (int)(Math.random()*(10-2+1)+2);
        //m = (int)(Math.random()*(10-2+1)+2);
        n = (int)(Math.random()*(4-2+1)+2);
        m = (int)(Math.random()*(4-2+1)+2);
        M = new int [n][m];
    }

    public int getn() {
        return n;
    }

    public void setn(int n) {
        this.n = n;
    }

    public int getm() {
        return m;
    }

    public void setm(int m) {
        this.m = m;
    }

    public int[][] getM() {
        return M;
    }

    public void setM(int[][] M) {
        this.M = M;
    }
    
    public int getM(int i, int j) {
        return M[i][j];
    }

    public void setM(int i, int j, int d) {
        M[i][j] = d;
    }
    
    public int[][] ConstruirRandom(){
        int i, j;
        boolean b;
        
        b = true;
        
        for (int k=0; k<=n*m; k++)
        {
            if (b)
            {
                i = (int)(Math.random()*((n-1)-0+1)+0);
                j = (int)(Math.random()*((m-1)-0+1)+0);
                M[i][j] = (int)(Math.random()*(100-(-100)+1)-100);     
                b = false;
            }
            else
            {
                b = true;
            }
        }
        
        return M;
    }
    
    public int DatosDiferentesDeCero(){
        int i, j, d;
        
        d = 0;
        
        for (i=0; i<M.length; i++) 
        {
            for (j=0; j<M[i].length; j++) 
            {
                if (M[i][j] != 0)
                {
                    d += 1;
                }
            }
        }
        
        return d;
    }
}
