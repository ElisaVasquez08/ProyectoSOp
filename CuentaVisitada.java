/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tuiter;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author Elisa Vasquez 
 */
 public final class CuentaVisitada extends Cuentas{
     //Declaracion de Variables 
    RandomAccessFile Followers;
    String UsuarioBuscado;
    Boolean SeSigue;
    
    public CuentaVisitada(String Info, Boolean SESIGUE, RandomAccessFile twits, String usuarioBuscado, String Username, RandomAccessFile followers){
        username=Username;
       
        
        Tuits=twits;
        SeSigue= SESIGUE;
        this.UsuarioBuscado= usuarioBuscado;
        Followers=followers;
        
         try {
            File files = new File("src\\Datos del Programa");
            files.mkdirs();

            User = new RandomAccessFile("src\\Datos del Programa\\Usuarios.twc", "rw");
            Follows = new RandomAccessFile("src\\Datos del Programa\\" + Username + "\\following.twc", "rw");

        
        } catch (IOException e) {
            System.out.println("Error ConstructorPerfil");
        }   
}
    @Override
     public ArrayList<ControlDeTwits> MostrarTwits(ArrayList<ControlDeTwits> ListaTemporal, RandomAccessFile Twits) throws IOException {
       //  return super.MostrarTuits(ListaTemporal, Tuits);
        Twits.seek(0);
        while (Twits.getFilePointer() < Twits.length()) {
            Calendar Fecha = Calendar.getInstance();
            String Usuario = Twits.readUTF();
            String Mensaje = Twits.readUTF();
            Long F = Twits.readLong();
            Fecha.setTimeInMillis(F);
            ListaTemporal.add(new ControlDeTwits(Usuario, Mensaje, Fecha));
        }     
        return ListaTemporal;
     }
         
 public final boolean DejardeSeguir(String UsuarioBuscado) throws IOException {
        Follows.seek(0);
        while (Follows.getFilePointer() < Follows.length()) {
            if (Follows.readUTF().equals(UsuarioBuscado)) {

                Follows.writeBoolean(false);
                return true;

            }
            Follows.readBoolean();

        }

        return false;
    }
 
 
     public final boolean DejardeSeguirFollower() throws IOException {
        Followers.seek(0);
        while (Followers.getFilePointer() < Followers.length()) {
            if (Followers.readUTF().equals(username)) {

                Followers.writeBoolean(false);
                return true;

            }
            Followers.readBoolean();

        }

        return false;
    }  
  
    
      @Override
 public String ImprimirTwits(ArrayList<ControlDeTwits> ListaTemporal, String TIMELINE, int i){
     return super.ImprimirTwits(ListaTemporal,  TIMELINE,  i);
 }
    
}
