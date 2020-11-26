/**
 * Clase donde inicia el programa.
 *
 * @author (David Vallejos)
 * @version (25/11/2020)
 */
public class Principal
{

    /**
     * Constructor for objects of class Principal
     */
    public Principal()
    {

    }

    /**
     * Instancia una vista, una ListaEstudiantes, un Grupo  y un Controlador para ejecutar el programa. 
     *
     * @param
     * @return
     */
    public static void main(String args []){
        Vista miVista=new Vista();
        ListaEstudiantes miListaEstudiantes=new ListaEstudiantes();
        Grupo miGrupo=new Grupo();
        Controlador miControlador=new Controlador(miVista,miListaEstudiantes,miGrupo);
        miControlador.iniciar();

    }
}
