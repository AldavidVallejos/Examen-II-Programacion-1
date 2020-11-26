/**
 * Clase de lista enlazada de Estudiantes.
 *
 * @author (David Vallejos)
 * @version (25/11/2020)
 */
public class ListaEstudiantes
{

    private Estudiante inicio;
    private int tamanio;

    public Estudiante getInicio()
    {
        return inicio;
    }

    public void ListaEstudiantes()
    {
        inicio = null;
        tamanio = 0;
    }

    public boolean esVacia()
    {
        return inicio == null;
    }

    public int getTamanio()
    {
        return tamanio;
    }

    
    public void agregar(Estudiante miEstudiante)
    {
        Estudiante auxiliar=new Estudiante();
        auxiliar=inicio;
        if(tamanio==0)
        {
            inicio=miEstudiante;
        }else
        {
            while(auxiliar.getEstudianteSiguiente()!=null)
            {
                auxiliar=auxiliar.getEstudianteSiguiente();
            }
            auxiliar.setEstudianteSiguiente(miEstudiante);
        }
    }

    public void agregarAlFinal(String nombre, int carnet, ListaNotas lista)
    {
        Estudiante nuevoEstudiante = new Estudiante();
        nuevoEstudiante.setNombre(nombre);
        nuevoEstudiante.setCarnet(carnet);
        nuevoEstudiante.setCalificaciones(lista);

        if(esVacia())
        {
            inicio = nuevoEstudiante;
        }
        else
        {
            Estudiante auxiliar = inicio;

            while(auxiliar.getEstudianteSiguiente() != null)
            {
                auxiliar = auxiliar.getEstudianteSiguiente();
            }

            auxiliar.setEstudianteSiguiente(nuevoEstudiante);
        }

        tamanio++;
    }

    public void reordenarAlfabeticamente(String nuevoNombre,int nuevoCarnet,ListaNotas nuevaListaNotas)
    {
        if(tamanio==0){
            agregarAlInicio( nuevoNombre, nuevoCarnet , nuevaListaNotas );
        }else
        {
            Estudiante auxiliar=new Estudiante();
            auxiliar=inicio;  
            int contador=0;

            int bandera=0;
            while(nuevoNombre.compareTo(auxiliar.getNombre())>0 && bandera==0)
            {
                contador++;
                if(auxiliar.getEstudianteSiguiente()!=null)
                {
                    auxiliar=auxiliar.getEstudianteSiguiente();

                }else
                {bandera=1;
                }
                
            }
            insertarEnPosicion(nuevoNombre,nuevoCarnet,nuevaListaNotas,contador);
        }
    }

    public void insertarEnPosicion(String nombre, int carnet, ListaNotas lista, int posicion)
    {

        if(posicion >= 0 && posicion <= tamanio)
        {
            if(posicion == 0)
            {
                agregarAlFinal(nombre,carnet,lista);
            }
            else if(posicion == tamanio)
            {
                agregarAlFinal(nombre,carnet,lista);
            }
            else
            {
                Estudiante nuevoEstudiante = new Estudiante();
                nuevoEstudiante.setNombre(nombre);
                nuevoEstudiante.setCarnet(carnet);
                nuevoEstudiante.setCalificaciones(lista);

                Estudiante auxiliar = inicio;

                for(int indice = 0; indice < (posicion - 1); indice++)
                {
                    auxiliar = auxiliar.getEstudianteSiguiente();
                }

                nuevoEstudiante.setEstudianteSiguiente(auxiliar.getEstudianteSiguiente());
                auxiliar.setEstudianteSiguiente(nuevoEstudiante);
                tamanio++;
            }
        }
    }

    public void reordenarPorPromedios(String nuevoNombre,int nuevoCarnet,ListaNotas nuevaListaNotas)
    {
        if(tamanio==0){
            agregarAlInicio( nuevoNombre, nuevoCarnet , nuevaListaNotas );
        }else
        {
            Estudiante elNuevoEstudiante=new Estudiante();
            elNuevoEstudiante.setNombre(nuevoNombre);
            elNuevoEstudiante.setCarnet(nuevoCarnet);
            elNuevoEstudiante.setCalificaciones(nuevaListaNotas);
            
            
            Estudiante auxiliar=new Estudiante();
            auxiliar=inicio;  
            int contador=0;

            int bandera=0;
            while(elNuevoEstudiante.getPromedio(nuevaListaNotas)>auxiliar.getPromedio(auxiliar.getCalificaciones()) && bandera==0)
            {
                contador++;
                if(auxiliar.getEstudianteSiguiente()!=null)
                {
                    auxiliar=auxiliar.getEstudianteSiguiente();

                }else
                {bandera=1;
                }
                
            }
            insertarEnPosicion(nuevoNombre,nuevoCarnet,nuevaListaNotas,contador);
        }
    }

    public String toString()
    {

        Estudiante auxiliar=new Estudiante();
        auxiliar=inicio;

        String cadena=auxiliar.toString();
        while(auxiliar.getEstudianteSiguiente()!=null)
        {
            cadena=cadena+"\n"+auxiliar.getEstudianteSiguiente().toString();
            auxiliar=auxiliar.getEstudianteSiguiente();
        }

        return cadena;
    }

    public void agregarAlInicio(String nombre, int carnet, ListaNotas lista)
    {

        Estudiante nuevoEstudiante = new Estudiante();
        nuevoEstudiante.setNombre(nombre);
        nuevoEstudiante.setCarnet(carnet);
        nuevoEstudiante.setCalificaciones(lista);

        if(esVacia())
        {
            inicio = nuevoEstudiante;
        }
        else
        {
            nuevoEstudiante.setEstudianteSiguiente(inicio);
            inicio = nuevoEstudiante;
        }

        tamanio++;
    }

}
