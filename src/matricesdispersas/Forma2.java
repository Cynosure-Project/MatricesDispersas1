
package matricesdispersas;
import Utilidades.Nodo;
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

    public void Paso1(int Mat[][]) {
        Nodo x, p;
        p = Punta;

        for (int i = 0; i < Mat.length; i++) {
            for (int j = 0; j < Mat[i].length; j++) {
                if (Mat[i][j] != 0) {
                    x = new Nodo(Mat[i][j], i, j);
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
        for (int col = 0; col < Punta.getColumna(); col++) {
            Nodo q = Punta.getLf();
            while (q != Punta) {
                if (q.getColumna()== col) {
                    p.setLc(q);
                    p = q;
                }
                q = q.getLf();
            }
        }
        p.setLc(Punta);
    }

    public void MostrarF2() {
        Nodo P = Punta.getLf();
        String s="["+Punta.getFila()+"][" + Punta.getColumna() +"]->";
        while (P != Punta) {
            s=s +"[" + P.getFila() + "][" + P.getColumna()+ "][ " + P.getDato() +" ]-->";
            P = P.getLf();
        }
        JOptionPane.showMessageDialog(null, s, "Forma 2", 3);
    }
   
        
}

