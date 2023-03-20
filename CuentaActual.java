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
public final class CuentaActual extends Cuentas{
    ArrayList<String> UsuarioVisitar;
    
public CuentaActual(String Username){
          this.username = Username;
        
        UsuarioVisitar = new ArrayList();
        String Us;
        try {
            User = new RandomAccessFile("src\\Datos del Programa\\Usuarios.twc", "rw");
            User.seek(0);
            while (User.getFilePointer() < User.length()) {
                
                User.readUTF();
                User.readChar();
                
                Us = User.readUTF();
                
                User.readUTF();
                
                User.skipBytes(12);
                if (User.readBoolean()) {
                    
                    UsuarioVisitar.add(Us);
                }
                
            }
            
        } catch (IOException e) {
            System.out.println("Error!");
        }
        
        try {
            File files = new File("src\\Datos del Programa");
            files.mkdirs();
            Tuits = new RandomAccessFile("src\\Datos del Programa\\" + Username + "\\" + "twits.twc", "rw");
            Follows = new RandomAccessFile("src\\Datos del Programa\\" + Username + "\\" + "following.twc", "rw");
            
          
            
        } catch (IOException e) {
            System.out.println("Error RandomAccess Menu Principal");
        }
}
    @Override
     public ArrayList<ControlDeTwits> MostrarTwits(ArrayList<ControlDeTwits> ListaTemporal, RandomAccessFile Twits) throws IOException {
       Twits.seek(0);
        while (Twits.getFilePointer() < Twits.length()) {
            Calendar Fecha = Calendar.getInstance();
            String Usuario = Twits.readUTF();
            String Mensaje = Twits.readUTF();
            Long F = Twits.readLong();
            Fecha.setTimeInMillis(F);
            ListaTemporal.add(new ControlDeTwits(Usuario, Mensaje, Fecha));
        }
      
        Follows.seek(0);
        while (Follows.getFilePointer() < Follows.length()) {
            String Usuario = Follows.readUTF();
            boolean Activo = Follows.readBoolean();
            
            if (Activo && UsuarioActivo(Usuario)) {
                RandomAccessFile UsuarioSeguido = new RandomAccessFile("src\\Datos del Programa\\" + Usuario + "\\" + "twits.twc", "rw");
                
                while (UsuarioSeguido.getFilePointer() < UsuarioSeguido.length()) {
                    Calendar Fecha = Calendar.getInstance();
                    String UsuarioSeguido1 = UsuarioSeguido.readUTF();
                    String MensajeSeguido = UsuarioSeguido.readUTF();
                    Long FechaSeguido = UsuarioSeguido.readLong();
                    Fecha.setTimeInMillis(FechaSeguido);
                    ListaTemporal.add(new ControlDeTwits(UsuarioSeguido1, MensajeSeguido, Fecha));
                    
                }
                
            }
            
        }
        
        
         return ListaTemporal;
         
     }
   
   
   
      public final void HacerTwit(String Username, String Twit) throws IOException {
        Tuits.seek(Tuits.length());
        Tuits.writeUTF(Username);
        Tuits.writeUTF(Twit);
        Tuits.writeLong(Calendar.getInstance().getTimeInMillis());
        
    }
    
        
   
   
    
    
    public final boolean UsuarioActivo(String Usuario)throws IOException{
        User.seek(0);
        
        while(User.getFilePointer() < User.length()){
            User.readUTF();
            User.readChar();
            String UsuarioTemporal = User.readUTF();
            User.readUTF();
            User.skipBytes(12);
           Boolean EstaActivo = User.readBoolean();
           
           if(UsuarioTemporal.equals(Usuario)){
               return EstaActivo;
           }
           
        }
        return false;
    }


    @Override
 public String ImprimirTwits(ArrayList<ControlDeTwits> ListaTemporal, String TIMELINE, int i){
     return super.ImprimirTwits(ListaTemporal,  TIMELINE,  i);
 }





 
}
