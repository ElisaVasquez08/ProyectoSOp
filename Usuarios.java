/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyect2;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
/**
 *
 * @author Lenovo
 */
public class Usuarios {

    RandomAccessFile users;
    String user;
    String password;

    public File direccion;
    public File carpetaImagenes;
    public File carpetaDocumentos;
    public File carpetaMusica;

    public Usuarios() throws FileNotFoundException {
        users = new RandomAccessFile("usuarios.emp", "rw");
    }

    public long getFinal() throws IOException {
        if (users.length() != 0) {
            users.seek(0);
            while (users.getFilePointer() < users.length()) {
                users.readUTF();
                users.readUTF(); 
            }
        }

        return users.getFilePointer();
    }

    public void almacenar(String user, String password) throws IOException {
        users.seek(getFinal());
        users.writeUTF(user);
        users.writeUTF(password);
    }

    public boolean findUser(String usuario, String contraseña) throws IOException {
        users.seek(0);
        String user, password; 
        while (users.getFilePointer() < users.length()) {
            user = users.readUTF();
            password = users.readUTF();
            if (user.equals(usuario) && password.equals(contraseña)) {
                return true;
            }
        }
        return false;
    }

    public String usuarioFolder(String usuario) {
        return "src/Z/" + usuario;
    }

    public String carpetaImagenes(String usuario) {
        return usuarioFolder(usuario) + "/Mis Imágenes";
    }

    public String carpetaDocumentos(String usuario) {
        return usuarioFolder(usuario) + "/Mis Documentos";
    }

    public String carpetaMusica(String usuario) {
        return usuarioFolder(usuario) + "/Mi Música";
    }

    public void crearEmpleadoFolder(String usuario) throws IOException {
        direccion = new File(usuarioFolder(usuario));
        direccion.mkdir();

        carpetaImagenes = new File(carpetaImagenes(usuario));
        carpetaImagenes.mkdir();

        carpetaDocumentos = new File(carpetaDocumentos(usuario));
        carpetaDocumentos.mkdir();

        carpetaMusica = new File(carpetaMusica(usuario));
        carpetaMusica.mkdir();

    }

}
