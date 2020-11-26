/**
 * Clase de lista enlazada de Notas.
 *
 * @author (David Vallejos)
 * @version (25/11/2020)
 */
public class ListaNotas
{
    // instance variables - replace the example below with your own
    private Nota inicio;
    private int tamanio;

    public Nota getInicio()
    {
        return inicio;
    }

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

    public void agregarAlFinal(int valor)
    {
        Nota nuevaNota = new Nota();
        nuevaNota.setValor(valor);

        if(esVacia())
        {
            inicio = nuevaNota;
        }
        else
        {
            Nota auxiliar = inicio;

            while(auxiliar.getNotaSiguiente() != null)
            {
                auxiliar = auxiliar.getNotaSiguiente();
            }

            auxiliar.setNotaSiguiente(nuevaNota);
        }

        tamanio++;
    }

    public void agregarAlInicio(int valor)
    {
        Nota nuevaNota = new Nota();
        nuevaNota.setValor(valor);

        if(esVacia())
        {
            inicio = nuevaNota;
        }
        else
        {
            nuevaNota.setNotaSiguiente(inicio);
            inicio = nuevaNota;
        }

        tamanio++;
    }

    /*
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
     */

    public boolean existeElemento(int valorReferencia)
    {
        Nota auxiliar = inicio;
        boolean encontrado = false;

        while(auxiliar != null && !encontrado)
        {
            encontrado = (auxiliar.getValor() == valorReferencia);
            auxiliar = auxiliar.getNotaSiguiente();
        }

        return encontrado;
    }

    /*
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
     */

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
                Nota nuevaNota = new Nota();
                nuevaNota.setValor(valor);

                Nota auxiliar = inicio;

                for(int indice = 0; indice < (posicion - 1); indice++)
                {
                    auxiliar = auxiliar.getNotaSiguiente();
                }

                nuevaNota.setNotaSiguiente(auxiliar.getNotaSiguiente());
                auxiliar.setNotaSiguiente(nuevaNota);
                tamanio++;
            }
        }
    }

    /*
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

     */

    public void eliminarElementoPorPosicion(int posicion)
    {
        if(posicion >= 0 && posicion <= tamanio)
        {
            Nota auxiliar = inicio;

            if(posicion == 0)
            {
                inicio = inicio.getNotaSiguiente();
                auxiliar.setNotaSiguiente(null);
            }
            else
            {
                for(int indice = 0; indice < (posicion - 1); indice++)
                {
                    auxiliar = auxiliar.getNotaSiguiente();
                }

                Nota notaSiguiente = auxiliar.getNotaSiguiente().getNotaSiguiente();
                auxiliar.getNotaSiguiente().setNotaSiguiente(null);
                auxiliar.setNotaSiguiente(notaSiguiente);
            }

            tamanio--;
        }
    }

    /*
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
    }
     */
}
