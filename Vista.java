import javax.swing.JOptionPane;

public class Vista
{
    Object[]botones={"Agregar","Completo", "Salir"};
    
   //variable encargada de recolectar la información numérica del usuario
    private int entradaNumericaDeUsuario;

    //variable encargada de recolectar la información de texto del usuario
    private String entradaTextoDeUsuario="vacio";

    /**
     * Permite acceder a la entradaNumericaDeUsuario
     * @return int
     */
    public int getEntradaNumericaDeUsuario(){
        return entradaNumericaDeUsuario;
    }

    
    /**
     * Permite asignar la entradaNumericaDeUsuario
     * @return
     */
    public void setEntradaNumericaDeUsuario(int nuevaEntradaNumerica){
        this.entradaNumericaDeUsuario=nuevaEntradaNumerica;
    }

    /**
     * Permite acceder a la entradaTextoDeUsuario
     * @return String
     */
    public String getEntradaTextoDeUsuario(){
        return entradaTextoDeUsuario;
    }

    /**
     * Permite asignar la entradaTextoDeUsuario
     * @return
     */
    public void setEntradaTextoDeUsuario(String nuevaEntradaTexto){
        this.entradaTextoDeUsuario=nuevaEntradaTexto;
    }
    
    public void capturaCarnet()
    {
    do{
            entradaTextoDeUsuario=JOptionPane.showInputDialog(null, "Ingrese el carnet del Estudiante:");
            
            if(entradaTextoDeUsuario==null){
                confirmacionDeSalida();
                if(entradaNumericaDeUsuario==-2){
                    entradaTextoDeUsuario="vacio";
                }
            }
            entradaNumericaDeUsuario=Integer.valueOf(entradaTextoDeUsuario);
        }while(entradaTextoDeUsuario.equals("vacio"));
    }
    
    public void capturaNota()
    {
    do{
            entradaTextoDeUsuario=JOptionPane.showInputDialog(null, "Ingrese una de las notas del estudiante:");
            
            if(entradaTextoDeUsuario==null){
                confirmacionDeSalida();
                if(entradaNumericaDeUsuario==-2){
                    entradaTextoDeUsuario="vacio";
                }
            }
            entradaNumericaDeUsuario=Integer.valueOf(entradaTextoDeUsuario);
        }while(entradaTextoDeUsuario.equals("vacio"));
        
    }
    
    /**
     * Ventana para indicar el nombre del estudiante
     * Si la entrada no es válida se pregunta si se desea salir del juego. Si no se desea finalizar se pregunta de nuevo por la información
     */
    public void capturaNombre(){

        do{
            entradaTextoDeUsuario=JOptionPane.showInputDialog(null, "Ingrese el nombre del Estudiante:"); 
            if(entradaTextoDeUsuario==null){
                confirmacionDeSalida();
                if(entradaNumericaDeUsuario==-2){
                    entradaTextoDeUsuario="vacio";
                }
            }
        }while(entradaTextoDeUsuario.equals("vacio"));
    }
    
    /**
     * Ventana para confirmar salida del juego
     * Si se confirma la salida la ejecución finaliza
     */
    public void confirmacionDeSalida(){
        entradaNumericaDeUsuario=JOptionPane.showConfirmDialog(null, "Entrada no válida. ¿Desea salir del programa?","",JOptionPane.YES_NO_OPTION);
        if(entradaNumericaDeUsuario==0||entradaNumericaDeUsuario==-1){
            System.exit(0);
        }else{entradaNumericaDeUsuario=-2;}
    }
    
    
    public void mensajeContinuar2()
    {
    entradaNumericaDeUsuario=JOptionPane.showOptionDialog(null, "Indique si desea añadir otra calificación o si el reporte de calificaciones está completo",
            "Menú principal",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.WARNING_MESSAGE,null,botones,botones[0]);    

    }
    
    public void mensajeContinuar1()
    {
    entradaNumericaDeUsuario=JOptionPane.showOptionDialog(null, "Indique si desea añadir otro estudiante o si el la lista está completa",
            "Menú principal",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.WARNING_MESSAGE,null,botones,botones[0]);    

    }

public void retornar(String mensaje)
{
JOptionPane.showMessageDialog(null,mensaje);
}
}
