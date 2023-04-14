package matricesdispersas;

import javax.swing.JOptionPane;
import Utilidades.Matriz;
import Utilidades.Validar;
import Utilidades.Menu;

public class MatricesDispersas {

    public static void main(String[] args) {
        Matriz m = new Matriz();
        Forma1 F1= new Forma1();
        Validar Val = new Validar();
        
        int M[][];
        int op, d;
        Tripleta T;
        M = m.ConstruirRandom();
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
                            case 3 ->
                            {
                                T.SumarColumnas();
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
