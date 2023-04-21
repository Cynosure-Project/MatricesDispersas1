package matricesdispersas;

import javax.swing.JOptionPane;
import Utilidades.Matriz;

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
    public void SumarFilas() {
        int vf[] = new int[A[0][0]], k = 1;
        String s= "";
        while (k <= A[0][2]) {
            vf[A[k][0]] += A[k][2];
            k++;
        }
        for (int i = 0; i < vf.length; i++) {
<<<<<<< HEAD
<<<<<<< HEAD
            s = s + "Suma de columna " + (i + 1) + ": " + vf[i] + "\n";
=======
=======
>>>>>>> parent of 8967e73 (Hola)
            s = s + "Suma de fila " + (i + 1) + ": " + vf[i] + "\n";
>>>>>>> parent of 8967e73 (Hola)
        }
        JOptionPane.showMessageDialog(null, s);
    }
    
    
    public void Sumar(Tripleta T)
    {
       Tripleta T1=new Tripleta(A[0][0]*A[0][1]);
       int i=1, j=1, k=1;
       T1.A[0][0]=this.A[0][0];T1.A[0][1]=this.A[0][1];
        while(i<=this.A[0][2]&&j<=T.A[0][2])
        {
            if(this.A[i][0]<T.A[j][0])
            {
                T1.A[k][0]=this.A[i][0];
                T1.A[k][1]=this.A[i][1];
                T1.A[k][2]=this.A[i][2];
                i++;
                k++;
            }else
            {
                if (this.A[i][0] > T.A[j][0])
                {
                    T1.A[k][0] = T.A[j][0];
                    T1.A[k][1] = T.A[j][1];
                    T1.A[k][2] = T.A[j][2];
                    j++;
                    k++;
                }else
                {
                    if(this.A[i][0] == T.A[j][0])
                    {
                        if (this.A[i][1] == T.A[j][1])
                        {
                            T1.A[k][0] = T.A[j][0];
                            T1.A[k][1] = T.A[j][1];
                            T1.A[k][2] = T.A[j][2]+ this.A[i][2];
                            j++;
                            i++;
                            k++;
                        }else
                        {
                            if(this.A[i][1] < T.A[j][1])
                            {
                                T1.A[k][0] = this.A[i][0];
                                T1.A[k][1] = this.A[i][1];
                                T1.A[k][2] = this.A[i][2];
                                i++;
                                k++;
                            }else
                            {
                                T1.A[k][0] = T.A[j][0];
                                T1.A[k][1] = T.A[j][1];
                                T1.A[k][2] = T.A[j][2];
                                j++;
                                k++;
                                
                            }
                        }
                    }
                }
            }
        }
        while(i<=this.A[0][2])
        {
            T1.A[k][0] = this.A[i][0];
            T1.A[k][1] = this.A[i][1];
            T1.A[k][2] = this.A[i][2];
            i++;
            k++;
        }
        while(j<=T.A[0][2])
        {
            T1.A[k][0] = T.A[j][0];
            T1.A[k][1] = T.A[j][1];
            T1.A[k][2] = T.A[j][2];
            j++;
            k++;
        }
        T1.A[0][2]=k-1;
        T1= T1.Redimencionar(k-1);
        T1.Mostrar();
    }
<<<<<<< HEAD
<<<<<<< HEAD
    
    public Tripleta Redimencionar(int d) {
        int i, j, k=0;
        Tripleta T = new Tripleta(d);

        for (j=0; j<=d; j++)
        {
            T.A[k][0] = this.A[j][0];
            T.A[k][1] = this.A[j][1];
            T.A[k][2] = this.A[j][2];
            k++;
        }
=======

public void Multiplicar(Tripleta T) {
    // Obtener las dimensiones de las matrices
    
    int k=1,datos = this.A[0][2] * T.A[0][2]; 
    Tripleta T1 = new Tripleta(datos);
    
    T1.A[0][0] = this.A[0][0];
    T1.A[0][1] = T.A[0][1];
    T1.A[0][2] = datos;
    
    for (int i = 1; i <= this.A[0][0]; i++) {
          
      for (int j = 1; j <= T.A[j][1]; j++) {
              
        int producto = this.A[i][2]* T.A[j][2];
        
        
        if (producto != 0) {
          T1.A[k][0] = this.A[i][0]; 
          T1.A[k][1] = T.A[j][1]; 
          T1.A[k][2] = producto; 
          k++; 
          
      }

    }
    
}
    T1.RedimencionarP(k-1);
    T1.Mostrar();
}
    public void Insertar() {

=======

public void Multiplicar(Tripleta T) {
    // Obtener las dimensiones de las matrices
    
    int k=1,datos = this.A[0][2] * T.A[0][2]; 
    Tripleta T1 = new Tripleta(datos);
    
    T1.A[0][0] = this.A[0][0];
    T1.A[0][1] = T.A[0][1];
    T1.A[0][2] = datos;
    
    for (int i = 1; i <= this.A[0][0]; i++) {
          
      for (int j = 1; j <= T.A[j][1]; j++) {
              
        int producto = this.A[i][2]* T.A[j][2];
        
        
        if (producto != 0) {
          T1.A[k][0] = this.A[i][0]; 
          T1.A[k][1] = T.A[j][1]; 
          T1.A[k][2] = producto; 
          k++; 
          
      }

    }
    
}
    T1.RedimencionarP(k-1);
    T1.Mostrar();
}
    public void Insertar() {

>>>>>>> parent of 8967e73 (Hola)
    }
    
   
    public void Eliminar()
    {
        
        Validar val= new Validar();
        boolean b=true;
        Tripleta T;
        int c,k=0,f;
        f= val.Validar_int("Ingresa el número de fila donde está ubicado el dato");
        c = val.Validar_int("Ingresa el número de columna donde está ubicado el dato");
        if(f>=this.A[0][0]||c>=this.A[0][1])
        {
            JOptionPane.showMessageDialog(null, "Ha ingresado un número mayor, al número de filas o columnas de la matriz", "Dato incorrecto", 0);
        }
        else
        {
            while(k<=this.A[0][2]&&b)
            {
                if(this.A[k][0]==f&& this.A[k][1]==c)
                {
                    b=false;
                    this.A[k][2]=0;
                    this.A[0][2]-=1;
                    this.RedimencionarP(this.A[0][2]);
                }
                k++;
            }
            if(b)
            {
                JOptionPane.showMessageDialog(null, "No existe dato en esta posición", "Dato no encontrado", 2);
            }else
            {
                JOptionPane.showMessageDialog(null, "Se ha eliminado exitosamente", "Dato encontrado", 3);
            }
            
        }
        this.Mostrar();
>>>>>>> parent of 8967e73 (Hola)
        
        return T;
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
