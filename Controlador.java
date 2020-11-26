
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

    ListaEstudiantes listaEstudiantesModificada;
    
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

            listaEstudiantesInterna.reordenarAlfabeticamente(nuevoNombre, nuevoCarnet, nuevaListaNotas);
        }

        vistaInterna.retornar(listaEstudiantesInterna.toString());

        vistaInterna.menu();
        switch(vistaInterna.getEntradaNumericaDeUsuario())
        {case 0:

            ListaEstudiantes listaEstudiantesModificada=new ListaEstudiantes();
            listaEstudiantesModificada.reordenarPorPromedios(listaEstudiantesInterna.getInicio().getNombre(),listaEstudiantesInterna.getInicio().getCarnet(),listaEstudiantesInterna.getInicio().getCalificaciones());
            Estudiante aux=new Estudiante();
            aux=listaEstudiantesInterna.getInicio();
            while(aux.getEstudianteSiguiente()!=null)
            {
                listaEstudiantesModificada.reordenarPorPromedios(aux.getEstudianteSiguiente().getNombre(),aux.getEstudianteSiguiente().getCarnet(),aux.getEstudianteSiguiente().getCalificaciones());

                aux=aux.getEstudianteSiguiente();
            }
            vistaInterna.retornar(listaEstudiantesModificada.toString());
            break;

            case 1:
            break;
        }

    }

}
