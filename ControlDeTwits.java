/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tuiter;

import java.util.Calendar;

/**
 *
 * @author Elisa Vasquez
 */
public class ControlDeTwits implements Comparable<ControlDeTwits> {
    //Declaracion de Variables 
    String Usuario;
    String Mensajede_Usuario;
    Calendar fecha;

    public ControlDeTwits(String user, String mensaje, Calendar FechaMensaje) {
        Usuario = user;
        Mensajede_Usuario = mensaje;
        this.fecha = FechaMensaje;
        setFecha(FechaMensaje);

    }
    final public String getUsuario() {
        return this.Usuario;
    }
    final public String getMensaje() {
        return this.Mensajede_Usuario;
    }
    
    final public void setFecha(Calendar F) {
       this.fecha = F;
   }
    final public Calendar getFecha() {
        return this.fecha;
    }

    @Override
    public int compareTo(ControlDeTwits e) {
        if (e.getFecha().before(fecha)) {
            return -1;
        } else if (e.getFecha().after(fecha)) {
            return 0;
        } else {
            return 1;
        }

    }

}
