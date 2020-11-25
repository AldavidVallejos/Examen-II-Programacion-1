
public class Estudiante
{
    String nombre;
    int carnet;
    ListaNotas calificaciones;
    float promedio;
    Estudiante estudianteSiguiente;

    public Estudiante()
    {
        nombre="";
        carnet=0;
        calificaciones=null;
        promedio=0;  
        estudianteSiguiente=null;
    }

    public void setEstudianteSiguiente(Estudiante miEstudiante)
    {
    estudianteSiguiente=miEstudiante;
    }
    
    public Estudiante getEstudianteSiguiente()
    {
    return estudianteSiguiente;
    }
    
    public void setNombre(String miNombre)
    {
        nombre=miNombre;
    }

    public void setCarnet(int miCarnet)
    {
        carnet=miCarnet;
    }

    public void setCalificaciones(ListaNotas misCalificaciones)
    {
        calificaciones=misCalificaciones;
    }

    public String getNombre()
    {
        return nombre;
    }

    public int getCarnet()
    {
        return carnet;
    }

    public ListaNotas getCalificaciones()
    {
        return calificaciones;
    }

    public float getPromedio(ListaNotas miListaInterna)
    {
        int longitudLista=miListaInterna.getTamanio();

        if(longitudLista==1)
        {
            return miListaInterna.getInicio().getValor();
        }else{
            int valorInicio=miListaInterna.getInicio().getValor();
            miListaInterna.eliminarElementoPorPosicion(0);
            return ((longitudLista-1)*getPromedio(miListaInterna)+valorInicio)/longitudLista;
        }

    }

    public String toString()
    {
        if(calificaciones.esVacia()==false){
            return "Nombre del estudiante: "+nombre+". Carnet: "+carnet+". Promedio: "+getPromedio(calificaciones);
        }else
        {
            return "No se encuentra información del estudiante";
        }
    }
}
