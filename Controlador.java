
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
        int indicador1=0;
        while(indicador1==0)
        {
            Estudiante nuevoEstudiante=new Estudiante();
            vistaInterna.capturaNombre();
            nuevoEstudiante.setNombre(vistaInterna.getEntradaTextoDeUsuario());
            
            vistaInterna.capturaCarnet();
            nuevoEstudiante.setCarnet(vistaInterna.getEntradaNumericaDeUsuario());
            
            
            int indicador2=0;
            ListaNotas nuevaListaNotas=new ListaNotas();
            while(indicador2==0)
               {
                   vistaInterna.capturaNota();
                   nuevaListaNotas.agregarAlFinal(vistaInterna.getEntradaNumericaDeUsuario());
                   
                vistaInterna.mensajeContinuar2();
            indicador2=vistaInterna.getEntradaNumericaDeUsuario();
            } 
            nuevoEstudiante.setCalificaciones(nuevaListaNotas);
            
            vistaInterna.mensajeContinuar1();
            indicador1=vistaInterna.getEntradaNumericaDeUsuario();
        }
    }
}
