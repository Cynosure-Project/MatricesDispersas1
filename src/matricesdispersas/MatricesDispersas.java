
package matricesdispersas;

import Utilidades.Matriz;
import javax.swing.JOptionPane;
import Utilidades.Validar;

public class MatricesDispersas {

    public static void main(String[] args) {
        Matriz n = new Matriz(), m = new Matriz(), m2 = new Matriz();
        Forma1 F1= new Forma1();
        Validar Val = new Validar();
        int M[][], N[][], M2[][], op, d, d1, d2;
        Tripleta T, T2, T3;
        
        M = m.ConstruirRandom(0,0);
        JOptionPane.showMessageDialog(null, "Se creará una tripleta a partir de la siguiente matriz", "Crear Tripleta", 3);
        m.Mostrar(M);
        d = m.DatosDiferentesDeCero();
        T = new Tripleta(d);
        T.Construir(M, d);
        N = m.ConstruirRandom(T.getA(0, 0), T.getA(0, 1));
        d1 = m.DatosDiferentesDeCero();
        T2 = new Tripleta(d1);
        T2.Construir(N, d1);
        M2 = m.ConstruirRandom(T.getA(0, 1), 0);
        d2 = m.DatosDiferentesDeCero();
        T3 = new Tripleta(d2);
        T3.Construir(M2, d2);

        do
        {
            op = Val.ValidarInt("""   
                                                Menú Matrices dispersas 
                                                                                                                                   
                                            1. Tripletas.
                                            2. Forma 1.
                                            3. Forma 2.
                                            4. Operaciones entre Formas.
                                            5. Ver matriz inicial.
                                            0. Salir.
                                  """);
            
            switch (op)
            {
                case 1 ->
                {
                    
                    do
                    {

                        op = Val.ValidarInt("""   
                                                Menú Tripletas 
                                                                                                                                                  
                                            1. Mostrar Tripleta
                                            2. Suma de filas.
                                            3. Suma de Columnas.
                                            4. Insertar un dato.
                                            5. Eliminar un dato.
                                            6. Ver matriz inicial
                                            7. Operaciones entre tripletas
                                            0. Volver al menú principal.
                                            """);
                        
                        switch (op)
                        {

                            case 1 ->
                            {
                                T.Mostrar();
                            }
                            case 2->
                            {
                                //T.SumarFilas();
                            }
                            case 3 ->
                            {
                                //T.SumarColumnas();
                            }
                            case 4 ->
                            {
                                d = Integer.parseInt(JOptionPane.showInputDialog("Ingrese dato a insertar: "));
                                
                                T.Insertar(d);
                            }
                            case 5 ->
                            {
                                
                            }
                            case 6 ->
                            {
                                m.Mostrar(M);
                            }
                            case 7 ->
                            {
                                
                                do
                                {
                                    op = Val.ValidarInt("""   
                                                Operaciones entre Tripletas 
                                                                                                                                   
                                            1. Suma.
                                            2. Multiplicación.
                                            3. Mostrar.
                                            4. Salir
                                            
                                            """);
                                    switch (op)
                                    {
                                        case 1 ->
                                        {

                                            JOptionPane.showMessageDialog(null, """  
                                                                                Se realizará la suma con la siguiente tripleta
                                                                                """, "Operaciones con tripletas", 3);
                                            T2.Mostrar();
                                            
                                            JOptionPane.showMessageDialog(null, """  
                                                                                Resultado de la tripleta suma
                                                                                """, "Resultado operaciones con tripletas", 3);
                                            //T.Sumar(T2);
                                        }
                                        case 2 ->
                                        {
                                            JOptionPane.showMessageDialog(null, """  
                                                                                Se realizará la multiplicación con la siguiente tripleta
                                                                                """, "Operaciones con tripletas", 3);
                                            T3.Mostrar();
                                            
                                            JOptionPane.showMessageDialog(null, """  
                                                                                Resultado de la tripleta multiplicación
                                                                                """, "Resultado operaciones con tripletas", 3);
                                            //T.Sumar(T3);
                                        }
                                        case 3 ->
                                        {
                                            JOptionPane.showMessageDialog(null, """  
                                                                                Tripletas utilizadas para la suma.
                                                                                """, "Operaciones con tripletas", 3);
                                            T.Mostrar();
                                            T2.Mostrar();
                                        }
                                        case 4 ->
                                        {}
                                        default->
                                        {
                                            JOptionPane.showMessageDialog(null, "Opción incorrecta", "Escoge otra opción", 2);
                                        }
                                    }

                                } while (op != 4);
                                
                            }
                            case 0 ->
                            {

                            }

                            default ->
                            {

                            }
                        }
                    } while (op != 8);
                }
                case 2 ->
                {
                    //F1.Crear(M);
                    
                    do
                    {

                        op = Val.ValidarInt("""   
                                                Menú Tripletas Forma 1 
                                                                                                                                                  
                                            1. Mostrar Forma 1
                                            2. Suma de filas.
                                            3. Suma de Columnas.
                                            4. Insertar un dato.
                                            5. Eliminar un dato.
                                            6. Ver matriz inicial
                                            7. Operaciones Forma 1
                                            0. Volver al menú principal.
                                            """);
                        switch (op)
                        {

                            case 1 ->
                            {
                                //F1.Mostrar();
                            }
                            case 3 ->
                            {
                                //.SumarColumnas();
                            }
                            case 6 ->
                            {
                                m.Mostrar(M);
                            }
                            case 0 ->
                            {

                            }

                            default ->
                            {

                            }
                        }
                    } while (op != 8);
                }
                case 5 ->
                {
                    m.Mostrar(M);
                }

                case 0 ->
                {

                }
                default ->
                {

                }
            }
        } while (op != 0);
        
    }
    
}
