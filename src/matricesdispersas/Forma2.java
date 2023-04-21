
package matricesdispersas;
import Utilidades.Nodo;
import Utilidades.Validar;
import javax.swing.JOptionPane;

public class Forma2 
{
    private Nodo Punta;
   
    public Forma2(int f, int c) {
        Punta = new Nodo(0, f, c);
        Punta.setLf(Punta);
        Punta.setLc(Punta);
    }
    
    public Nodo getPunta() {
        return Punta;
    }

    public void setPunta(Nodo Punta) {
        this.Punta = Punta;
    }

    public void Crear(int[][] A) {
        Paso1(A);
        Paso2();
    }

    public void Paso1(int M[][]) {
        Nodo x, p;
        p = Punta;
        
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[i].length; j++) {
                if (M[i][j] != 0) {
                    x = new Nodo(M[i][j], i, j);
                    x.setLf(x);
                    x.setLc(x);
                    p.setLf(x);
                    p = x;
                }
            }
        }
        
        p.setLf(Punta);
    }

    public void Paso2() {
        Nodo p = Punta;
        
        for (int c = 0; c < Punta.getColumna(); c++) {
            Nodo q = Punta.getLf();
            
            while (q != Punta) {
                if (q.getColumna()== c) {
                    p.setLc(q);
                    p = q;
                }
                
                q = q.getLf();
            }
        }
        
        p.setLc(Punta);
    }
    
    public void SumarFilas() {
        int i = 0, vf[] = new int[Punta.getFila()];
        Nodo P = Punta.getLf();
        String s = "";
        
        while (P != Punta)
        {
                vf[P.getFila()] += P.getDato();
                P = P.getLf();
        }
        
        for (i = 0; i < vf.length; i++)
        {
            s = s + "Suma de fila " + (i + 1) + ": " + vf[i] + "\n";
        }
        
        JOptionPane.showMessageDialog(null, s);
    }
    
    public void SumarColumnas() {
        int i = 0, vc[] = new int[Punta.getColumna()];
        Nodo P = Punta.getLc();
        String s = "";
        
        while (P != Punta)
        {
            vc[P.getColumna()] += P.getDato();
            P = P.getLc();
        }
        
        for (i = 0; i < vc.length; i++)
        {
            s = s + "Suma de columnas " + (i + 1) + ": " + vc[i] + "\n";
        }
        
        JOptionPane.showMessageDialog(null, s);
    }
    
    public void Eliminar( int [][]M) {
        Nodo P, Q, R, x;
        Validar val = new Validar();
        int f,c;
        P = Punta.getLf();
        R = P;
        boolean b = true;
        
        JOptionPane.showMessageDialog(null, "Observa la posición ddel dato que quieres eliminar en la tripleta", "Posición Eliminar F1", 3);
        this.MostrarF2();
        
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
            if(b)
            {
                JOptionPane.showMessageDialog(null, "No existe dato en esta posición", "Dato no encontrado", 2);
            }else
            {
                JOptionPane.showMessageDialog(null, "Se ha eliminado exitosamente", "Dato encontrado", 3);
            }
            
            M[f][c] = 0; 
            
            this.MostrarF2();
        }
    }

    public void MostrarF2() {
        Nodo P = Punta.getLf();
        String s = "[" + Punta.getFila() + "][" + Punta.getColumna() + "]->";
        
        while (P != Punta) {
            s += "[" + P.getFila() + "][" + P.getColumna() + "][ " + P.getDato() + " ]-->";
            P = P.getLf();
        }
        
        JOptionPane.showMessageDialog(null, s, "Forma 2", 3);
    }
   
    public void Sumar(Forma2 F2){
        if(Punta.getFila()==F2.Punta.getFila() && Punta.getColumna()==F2.Punta.getColumna())
        {
            
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Ambas matrices no se pueden sumar por tener dimensiones distintas, genere unas nuevas");
        }
    }    
    
}

