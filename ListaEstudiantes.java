

public class ListaEstudiantes
{
    
    private Estudiante inicio;
    private int tamanio;

    public void Lista()
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
    
    /*
    public void agregarAlInicio(int valor)
    {
        Nodo nuevoNodo = new Nodo();
        nuevoNodo.setValor(valor);
        
        if(esVacia())
        {
            inicio = nuevoNodo;
        }
        else
        {
            nuevoNodo.setSiguiente(inicio);
            inicio = nuevoNodo;
        }
        
        tamanio++;
    }
    
    
    public void imprimirLista()
    {
        if(!esVacia())
        {
            Nodo auxiliar = inicio;
            int posicion = 0;
            
            while(auxiliar.getSiguiente() != null)
            {
                System.out.println("Posicion: " + posicion + " Valor: " + auxiliar.getValor());
                auxiliar = auxiliar.getSiguiente();
                posicion++;
            }
            
            System.out.println("Posicion: " + posicion + " Valor: " + auxiliar.getValor());
        }
    }
    
    public boolean existeElemento(int valorReferencia)
    {
        Nodo auxiliar = inicio;
        boolean encontrado = false;
        
        while(auxiliar != null && !encontrado)
        {
            encontrado = (auxiliar.getValor() == valorReferencia);
            auxiliar = auxiliar.getSiguiente();
        }
        
        return encontrado;
    }
    
    public void insertarDespuesDeValor(int valor, int valorReferencia)
    {
        if(!esVacia())
        {
            if(existeElemento(valorReferencia))
            {
                Nodo nuevoNodo = new Nodo();
                nuevoNodo.setValor(valor);
                
                Nodo auxiliar = inicio;
                
                while(valorReferencia != auxiliar.getValor())
                {
                    auxiliar = auxiliar.getSiguiente();
                }
   
                nuevoNodo.setSiguiente(auxiliar.getSiguiente());
                auxiliar.setSiguiente(nuevoNodo);
                
                tamanio++;
            }
        }
    }
    
    public void insertarEnPosicion(int valor, int posicion)
    {
        if(posicion >= 0 && posicion <= tamanio)
        {
            if(posicion == 0)
            {
                agregarAlInicio(valor);
            }
            else if(posicion == tamanio)
            {
                agregarAlFinal(valor);
            }
            else
            {
                Nodo nuevoNodo = new Nodo();
                nuevoNodo.setValor(valor);
                
                Nodo auxiliar = inicio;
                
                for(int indice = 0; indice < (posicion - 1); indice++)
                {
                    auxiliar = auxiliar.getSiguiente();
                }
                
                nuevoNodo.setSiguiente(auxiliar.getSiguiente());
                auxiliar.setSiguiente(nuevoNodo);
                tamanio++;
            }
        }
    }
    
    public int obtenerPosicion(int valorReferencia)
    {
        int posicion = -1;
        
        if(existeElemento(valorReferencia))
        {
            
            Nodo auxiliar = inicio;
            posicion = 0;
            
            while(valorReferencia != auxiliar.getValor())
            {
                auxiliar = auxiliar.getSiguiente();
                posicion++;
            }
        }
        
        return posicion;
    }
    
    public void eliminarElementoPorValor(int valorReferencia)
    {
        if(existeElemento(valorReferencia))
        {
            Nodo auxiliar = inicio;
            
            if(auxiliar.getValor() == valorReferencia)
            {
                inicio = inicio.getSiguiente();
                auxiliar.setSiguiente(null);
            }
            else
            {
                while(auxiliar.getSiguiente().getValor() != valorReferencia)
                {
                    auxiliar = auxiliar.getSiguiente();
                }
                
                Nodo nodoSiguiente = auxiliar.getSiguiente().getSiguiente();
                auxiliar.getSiguiente().setSiguiente(null);
                auxiliar.setSiguiente(nodoSiguiente);
            }
            
            tamanio--;
        }
    }
    
    public void eliminarElementoPorPosicion(int posicion)
    {
         if(posicion >= 0 && posicion <= tamanio)
        {
            Nodo auxiliar = inicio;
            
            if(posicion == 0)
            {
                inicio = inicio.getSiguiente();
                auxiliar.setSiguiente(null);
            }
            else
            {
                for(int indice = 0; indice < (posicion - 1); indice++)
                {
                    auxiliar = auxiliar.getSiguiente();
                }
                
                Nodo nodoSiguiente = auxiliar.getSiguiente().getSiguiente();
                auxiliar.getSiguiente().setSiguiente(null);
                auxiliar.setSiguiente(nodoSiguiente);
            }
            
            tamanio--;
        }
    }
    
    public String recorridoRecursivo()
    {
        String etiqueta="";
        if(tamanio==1)
        {
            etiqueta=String.valueOf(inicio.getValor());
        return etiqueta;
        } else
        {
            etiqueta=String.valueOf(inicio.getValor());
            eliminarElementoPorPosicion(0);
        return etiqueta+"\n"+recorridoRecursivo();
        }
    /*
     * 
     */
}
