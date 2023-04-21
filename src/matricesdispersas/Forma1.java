package matricesdispersas;
import Utilidades.Nodo;
import Utilidades.Validar;
import javax.swing.JOptionPane;

public class Forma1 {

    private Nodo Punta;

    public Forma1() {
        Punta = null;
    }

    public void Crear(int Mat[][], int f, int c) {
        int Mayor;

        if (f > c) {
            Mayor = f;
        } else {
            Mayor = c;
        }

        Paso1(Mayor, f, c);
        Paso2(Mat);
        Paso3();
    }

    public void Paso1(int Mayor, int f, int c) {
        Nodo x, P;
        Punta = new Nodo(0, f, c);
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

    private void Paso2(int M[][]) {
        Nodo x, P, Q;
        P = Punta.getLiga();
        Q = P;

        for (int i = 0; i < M.length; i++)
        {
            for (int j = 0; j < M[i].length; j++)
            {
                if (M[i][j] != 0)
                {

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

    public void Paso3() {
        Nodo RC= Punta.getLiga(), P=RC, Q = P.getLf(),A=RC;

        while (RC != Punta) {
            while (P != Punta) {
                while (Q != P) {
                    if (RC.getColumna() == Q.getColumna()) {
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
    
    public void SumarColumnas() {
        int[] vc = new int[Punta.getColumna()];
        Nodo P = Punta.getLiga();
        Nodo Q = P.getLc();
        String s = "";
        
        while (P != Punta)
        {

            while (Q != P)
            {
                vc[Q.getColumna()] += Q.getDato();
                Q = Q.getLc();
            }
            
            P = P.getLiga();
            Q = P.getLc();
        }
        
        for (int i = 0; i < vc.length; i++)
        {
            s = s + "Suma de columna " + (i + 1) + ": " + vc[i] + "\n";
        }
        
        JOptionPane.showMessageDialog(null, s);
    }
     
    public void Eliminar( int [][]M) {
        Nodo P, Q, R, x;
        Validar val =new Validar();
        int f,c;
        P = Punta.getLiga();
        R = P;
        Q = P.getLf();
        boolean b = true;
        
        JOptionPane.showMessageDialog(null, "Observa la posición ddel dato que quieres eliminar en la tripleta", "Posición Eliminar F1", 3);
        this.MostrarF1();
        
        f = val.ValidarInt("""
                           Ingresa el n\u00famero de fila donde est\u00e1 ubicado el dato
                           (Teniendo en cuenta que la ubicaci\u00f3n inicia en 0)""");
        c = val.ValidarInt("Ingresa el número de columna donde está ubicado el dato");
        
        if(f>=Punta.getFila()||c>=Punta.getColumna())
        {
            JOptionPane.showMessageDialog(null, "Ha ingresado un número mayor, al número de filas o columnas de la matriz", "Dato incorrecto", 0);
        }
        else
        {
        while (P != Punta && b)
        {
            while (Q != P && b)
            {
                if (Q.getFila() == f && Q.getColumna() == c)
                {
                    R.setLf(Q.getLf());
                    b = false;
                }
                
                R = Q;
                Q = Q.getLf();
            }
            
            P = P.getLiga();
            Q = P.getLf();
            R = P;
        }
        
        Paso3();
        
        if(b)
        {
            JOptionPane.showMessageDialog(null, "No existe dato en esta posición", "Dato no encontrado", 2);
        }else
        {
            JOptionPane.showMessageDialog(null, "Se ha eliminado exitosamente", "Dato encontrado", 3);
        }
        
        M[f][c] = 0; 
        this.MostrarF1();
        }
    }
     
    public void SumarFilas() {
        int i = 0, vf[] = new int[Punta.getFila()];
        Nodo P = Punta.getLiga(), Q = P.getLf();
        String s = "";
        
        while (P != Punta)
        {
            while (Q != P)
            {
                vf[i] += Q.getDato();
                Q = Q.getLf();
            }

            i++;
            P = P.getLiga();
            Q = P.getLf();
        }
        
        for (i = 0; i < vf.length; i++)
        {
            s = s + "Suma de fila " + (i + 1) + ": " + vf[i] + "\n";
        }
        
        JOptionPane.showMessageDialog(null, s);
    }
    
    public void MostrarF1() {
        Nodo P=Punta.getLiga(), Q=P.getLf();
        String s = "[" + Punta.getFila() + "][" + Punta.getColumna() + "]\n";
        boolean r = true;
        int i = 0;
        
        while (P != Punta)
        {
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

    public void Insertar(int[][] M){
        int d, f, c;
        
        d = Integer.parseInt(JOptionPane.showInputDialog("Ingrese dato a insertar: "));
                                
        do
        {
            f = Integer.parseInt(JOptionPane.showInputDialog("Ingrese fila a colocar dato: "));
            if(f<Punta.getFila() || f>Punta.getFila())
            JOptionPane.showMessageDialog(null, "Ingrese una fila que este entre las dimensiones de la matriz: ");
        }
        while(f<0 || f>Punta.getFila());

        do
        {
            c = Integer.parseInt(JOptionPane.showInputDialog("Ingrese columna a colocar dato: "));
            if(c<Punta.getColumna() || c>Punta.getColumna())
            JOptionPane.showMessageDialog(null, "Ingrese una columna que este entre las dimensiones de la matriz: ");
        }
        while(c<0 || c>Punta.getColumna());
        
        M[f][c] = d;
        
        
    }
    
}
