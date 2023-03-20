/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tuiter;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Calendar;
import javax.swing.JOptionPane;

/**
 *
 * @author Elisa Vasquez
 */
public final class Usuario {
    //Declaracion de Variables
    RandomAccessFile User;

    public Usuario(String nombre, char genero, String user, String pass, int edad, boolean estado) {
        try {
            File files = new File("src\\Datos del Programa");
            files.mkdirs();
            User = new RandomAccessFile("src\\Datos del Programa\\Usuarios.twc", "rw");

        } catch (IOException e) {
            System.out.println("Error");
        }
        try {
            this.agregarUsuario(nombre, genero, user, pass, edad, estado);
            this.CrearFolderArchivos(user);
        } catch (IOException e) {

        }

    }

    public void agregarUsuario(String Nombre, char Genero, String Usuario, String Pass, int Edad, boolean activa) throws IOException {
        User.seek(User.length());
        User.writeUTF(Nombre);
        User.writeChar(Genero);
        User.writeUTF(Usuario);
        User.writeUTF(Pass);
        User.writeLong(Calendar.getInstance().getTimeInMillis());
        User.writeInt(Edad);
        User.writeBoolean(activa);

    }

       public void CrearFolderArchivos(String Username) {
        crearFolder(new File("src\\Datos del Programa\\" + Username));

        try {
            crearArchivo(new File("src\\Datos del Programa\\" + Username + "\\" + "following.twc"));
            crearArchivo(new File("src\\Datos del Programa\\" + Username + "\\" + "followers.twc"));
            crearArchivo(new File("src\\Datos del Programa\\" + Username + "\\" + "twits.twc"));
            crearArchivo(new File("src\\Datos del Programa\\" + Username + "\\" + "Perfil"));
        } catch (IOException E) {

        }

    }
    public void crearArchivo(File NuevoUsuario) throws IOException {
        //NO es necesario hacer validaciones porque es una carpeta nueva y su duplicacion ya se verifico desde crear usuario
        NuevoUsuario.createNewFile();
    }

    public void crearFolder(File Usuario) {

        if (Usuario.mkdirs()) {
            JOptionPane.showMessageDialog(null, "Se creo el Usuario con Exito");

        } else {
            JOptionPane.showMessageDialog(null, "El Usuario no ha sido Creado");
        }

    }
}
