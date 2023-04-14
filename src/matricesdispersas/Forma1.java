/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
    //hola
    public void Crear (int M[][])
    {
        Paso1(M.length,M[0].length);
        Paso2(M);
        Paso3();
    }
    public void Paso1(int n, int m) {
        int i = 0, Mayor;
        Nodo x, P;
        if (n < m)
            Mayor = m;
        else
            Mayor = n;
        
        x = new Nodo(0, n, m);
        Punta = x;
        P=Punta;
        while (i < Mayor)
        {
            x = new Nodo(0, i, i);
            x.setLf(x);
            x.setLc(x);
            P.setLiga(x);
            P = x;
            i++;
        }
        P.setLiga(Punta);
        
    }
    private void Paso2(int M[][])
    {
        int i=0,j=0;
        Nodo x,P=Punta.getLiga(),Q=P;
        for(i=0;i<P.getFila();i++)
        {
            for(j=0;j<P.getColumna();j++)
            {
                if(M[i][j]!=0)
                {
                    x=new Nodo(M[i][j],i,j);
                    Q.setLf(x);
                    Q=x;   
                }
            }
            Q.setLf(P);
            P=P.getLiga();
            Q=P;
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
                    if (Q.getColumna() == RC.getColumna())
                    {
                        A.setLc(Q);
                    }
                    Q = Q.getLf();
                }
                P = P.getLiga();
                Q = P.getLf();
            }
            A.setLc(RC);
            RC = RC.getLiga();
            P = Punta.getLiga();
            Q = P.getLf();
            A = RC;
        }
        

    }
    public void Mostrar() {
        Nodo P, Q;
        String s="";
        P = Punta;
        Q = P.getLf();
        do
        {
            
        } while(P!=Punta) ;             
        
        JOptionPane.showMessageDialog(null, s, "Mostrar Tripleta Forma 1", 3);
    }
}

