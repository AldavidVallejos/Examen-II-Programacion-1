
/**
 * Clase donde se ponen a interactuar la Vista con las otras clases.
 *
 * @author (David Vallejos)
 * @version (25/11/2020)
 */
public class Controlador
{
    Vista vistaInterna;
    ListaEstudiantes listaEstudiantesInterna;
    Grupo grupoInterno;

    /**
     * Constructor for objects of class Controlador
     */
    public Controlador(Vista miVista,ListaEstudiantes miListaEstudiantes,Grupo miGrupo)
    {
        vistaInterna=miVista;
        listaEstudiantesInterna=miListaEstudiantes;
        grupoInterno=miGrupo;
    }

    
    public void iniciar()
    {
       
    }
}
