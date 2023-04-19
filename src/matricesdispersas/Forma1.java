
package matricesdispersas;

import javax.swing.JOptionPane;
import Utilidades.Nodo;

/**
 *

 */public class Forma1 {
    private Nodo Punta;

    public Forma1() 
    {
        Punta= null;
    }
   
    public void Crear (int M[][], int f,int c)
    {
        int Mayor;
        if (f < c)
            Mayor = c;
        else
            Mayor = f;
        Paso1(Mayor,f,c);
        Paso2(M);
        Paso3();
    }
    public void Paso1(int Mayor ,int n, int m) {
       Nodo x, P;
        Punta = new Nodo(0, n, m);
        P = Punta;

        for (int i = 0; i < Mayor; i++) {
            x = new Nodo(0, i, i);
            x.setLf(x);
            x.setLc(x);
            P.setLiga(x);
            P = x;

        }
        P.setLiga(Punta);        
    }
    private void Paso2(int M[][])
    {
       Nodo x, P, Q;
        P = Punta.getLiga();
        Q = P;

        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[i].length; j++) {
                if (M[i][j] != 0) {

                    x = new Nodo(M[i][j], i, j);
                    Q.setLf(x);
                    Q = x;
                }
            }
            Q.setLf(P);
            P = P.getLiga();
            Q = P;
        }
        
    }
    private void Paso3() {
        Nodo P = Punta.getLiga(), RC = P, Q = P.getLf(), A = Q;
        while (RC != Punta)
        {
            while (P != Punta)
            {
                while (Q != P)
                {
                    if (RC.getColumna() == Q.getColumna())
                    {
                        A.setLc(Q);
                        A = Q;
                    }
                    Q = Q.getLf();
                }
                P = P.getLiga();
                Q = P.getLf();
            }
            A.setLc(RC);
            RC = RC.getLiga();
            A = RC;
            P = Punta.getLiga();
            Q = P.getLf();
        }
    }

 
   
    public void MostrarF1() {
        Nodo P, Q;
        String s="["+Punta.getFila()+"][" + Punta.getColumna() +"]\n";
        boolean r=true;
        int i=0;
        P = Punta.getLiga();
        Q = P.getLf();
        while(P!=Punta) {
        
            while (Q != P)
            {
                if (r)
                {
                    s = s + "[" + P.getFila() + "][" + P.getColumna() + "]->" + "[" + Q.getFila() + "][" + Q.getColumna() + "][ " + Q.getDato() + " ]-->";
                    r = false;
                } else
                {
                    s = s + "[" + Q.getFila() + "][" + Q.getColumna() + "][ " + Q.getDato() + " ]-->";
                }
                i++;
                Q = Q.getLf();
            }
            if (i == 0)
            {
                s = s + "[" + P.getFila() + "][" + P.getColumna() + "]<-\n";

            } else
            {
                s = s + "\n";
            }
            i = 0;
            r = true;
            P = P.getLiga();
            Q = P.getLf();

        }
        JOptionPane.showMessageDialog(null, s, "Mostrar Tripleta Forma 1", 3);
    }
    
}

