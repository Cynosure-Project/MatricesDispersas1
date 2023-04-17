package matricesdispersas;

import javax.swing.JOptionPane;
import Utilidades.Matriz;
import Utilidades.Validar;
import Utilidades.Menu;

public class MatricesDispersas {

    public static void main(String[] args) {
        Matriz n= new Matriz();
        Matriz m = new Matriz();
        Forma1 F1= new Forma1();
        Validar Val = new Validar();
        int N[][];
        int M[][];
        int op, d, d1;
        Tripleta T, T2;
        M = m.ConstruirRandom(0,0);
        JOptionPane.showMessageDialog(null, "Se creará una tripleta a partir de la siguiente matriz", "Crear Tripleta", 3);
        m.Mostrar(M);
        d = m.DatosDiferentesDeCero();

        do
        {
            op = Val.Validar_int("""   
                                                Menú Matrices dispersas 
                                                                                                                                   
                                            1. Tripletas.
                                            2. Forma 1.
                                            3. Forma 2.
                                            4. Operaciones entre Formas.
                                            5. Ver matriz inicial
                                            0. Salir.
                                            """);
            switch (op)
            {
                case 1 ->
                {
                    T = new Tripleta(d);
                    T.Construir(M, d);
                    do
                    {

                        op = Val.Validar_int("""   
                                                Menú Tripletas 
                                                                                                                                                  
                                            1. Mostrar Tripleta
                                            2. Suma de filas.
                                            3. Suma de Columnas.
                                            4. Insertar un dato.
                                            5. Eliminar un dato.
                                            6. Ver matriz inicial
                                            7. Operaciones entre tripletas
                                            8. Volver al menú principal.
                                            """);
                        switch (op)
                        {

                            case 1 ->
                            {
                                T.Mostrar();
                            }
                            case 2->
                            {
                                T.SumarFilas();
                            }
                            case 3 ->
                            {
                                T.SumarColumnas();
                            }
                            case 6 ->
                            {
                                m.Mostrar(M);
                            }
                            case 7 ->
                            {
                              N=n.ConstruirRandom(T.getA(0, 0),T.getA(0, 1));
                              d1=n.DatosDiferentesDeCero();
                              T2=new Tripleta(d1);
                              T2.Construir(N, d1);
                              JOptionPane.showMessageDialog(null, """  
                                                                                Se creará otra tripleta para realizar
                                                                                operaciones con ésta y la anterior.
                                                                                """, "Operaciones con tripletas",3);         
                              T2.Mostrar();
                                do
                                {
                                    op = Val.Validar_int("""   
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
                                            T.Sumar(T2);
                                        }
                                        case 2 ->
                                        {
                                            
                                        }
                                        case 3 ->
                                        {
                                            T.Mostrar();
                                            T2.Mostrar();
                                        }
                                        case 4->
                                        {}
                                        default->
                                        {
                                            JOptionPane.showMessageDialog(null, "Opción incorrecta", "Escoge otra opción", 2);
                                        }
                                    }

                                } while (op != 4);
                                
                            }
                            case 8 ->
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
                    F1.Crear(M);
                    do
                    {

                        op = Val.Validar_int("""   
                                                Menú Tripletas Forma 1 
                                                                                                                                                  
                                            1. Mostrar Forma 1
                                            2. Suma de filas.
                                            3. Suma de Columnas.
                                            4. Insertar un dato.
                                            5. Eliminar un dato.
                                            6. Ver matriz inicial
                                            7. Operaciones Forma 1
                                            8. Volver al menú principal.
                                            """);
                        switch (op)
                        {

                            case 1 ->
                            {
                                F1.Mostrar();
                            }
                            case 3 ->
                            {
                                //.SumarColumnas();
                            }
                            case 6 ->
                            {
                                m.Mostrar(M);
                            }
                            case 8 ->
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
