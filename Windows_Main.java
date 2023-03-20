
package mini_Windows;

import pantallas.pantallaPrincipal.Windows;
import usuarios.login.LogIn;
import usuarios.modelo_datos.FileStarter;
import usuarios.login.checkLogIn;
import usuarios.modelo_datos.UserManager;
import usuarios.modelo_datos.Usuario;


public class Windows_Main 
{

    public static void main(String[] args) 
    {
        //ileStarter.start(); // Crea Admin
        
        //Usuario user = new Usuario("Osman", "Josué", "Solórzano", "2", "ojsa123");
        //checkLogIn.verifyUser("Admin");
        //UserManager.addUser(user);
        //UserManager.readUser(user.getId());
        
        LogIn login = new LogIn();
        login.setVisible(true);
        
        /*Usuario u = new Usuario("Admin", "", "Administrador", "1", "admin123");
        Windows wd = new Windows(u);
        wd.setVisible(true);*/
        
    }
    
}
