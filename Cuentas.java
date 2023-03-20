/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tuiter;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author Elisa Vasquez 
 */
public abstract class Cuentas {
    //Declaracion de VAriables 
    protected  RandomAccessFile Tuits;
    protected  RandomAccessFile User;
    protected RandomAccessFile Follows;
    protected String username;
    
    public abstract ArrayList<ControlDeTwits> MostrarTwits(ArrayList<ControlDeTwits> ListaTemporal, RandomAccessFile twits) throws IOException;

    public String ImprimirTwits(ArrayList<ControlDeTwits> ListaTemporal, String TIMELINE, int i){
        if(i< ListaTemporal.size()){
         return ImprimirTwits( ListaTemporal,  TIMELINE+ ListaTemporal.get(i).getUsuario()+ " Escribio: \n\n"
   + "¨ " + ListaTemporal.get(i).getMensaje() + " ¨" + " el [" + ListaTemporal.get(i).getFecha().getTime() + "]\n\n\n", i+1);
    }  
    return TIMELINE;
    }
 
}
