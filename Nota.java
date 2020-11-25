

/**
 * Clase del nodo Nota.
 *
 * @author (David Vallejos)
 * @version (25/11/2020)
 */

public class Nota
{
    private int valor;
    private Nota notaSiguiente;

    /**
     * Constructor for objects of class Nota
     */
    public Nota()
    {
        valor=0;
        notaSiguiente=null;
    }

    
    public void setValor(int miNota)
    {
        valor=miNota;
    }
    
    public void setNotaSiguiente(Nota siguiente)
    {
        this.notaSiguiente = siguiente;
    }
    
    public int getValor()
    {
        return valor;
    }
    
    public Nota getNotaSiguiente()
    {
        return notaSiguiente;
    }
    
    
}
