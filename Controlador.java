
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
            vistaInterna.capturaNombre();
            String nuevoNombre=vistaInterna.getEntradaTextoDeUsuario();
            
            vistaInterna.capturaCarnet();
            int nuevoCarnet=vistaInterna.getEntradaNumericaDeUsuario();
            

            int indicador2=0;
            ListaNotas nuevaListaNotas=new ListaNotas();
            while(indicador2==0)
            {
                vistaInterna.capturaNota();
                nuevaListaNotas.agregarAlFinal(vistaInterna.getEntradaNumericaDeUsuario());

                vistaInterna.mensajeContinuar2();
                indicador2=vistaInterna.getEntradaNumericaDeUsuario();
            } 
            

            vistaInterna.mensajeContinuar1();
            indicador1=vistaInterna.getEntradaNumericaDeUsuario();
            
            listaEstudiantesInterna.agregarAlFinal(nuevoNombre, nuevoCarnet, nuevaListaNotas);
        }

        vistaInterna.retornar(listaEstudiantesInterna.getInicio().toString());
        vistaInterna.retornar(listaEstudiantesInterna.getInicio().getEstudianteSiguiente().toString());
    }
}
