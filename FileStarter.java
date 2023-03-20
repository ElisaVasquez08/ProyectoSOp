
package usuarios.modelo_datos;

import usuarios.Constants;
import usuarios.modelo_datos.UserManager;
import usuarios.modelo_datos.Usuario;


public class FileStarter implements Constants
{
    
    public static void start()
    {
        Usuario user = new Usuario("Admin", "Administrador", "", "1", "admin123");
        final String PATH = Constants.drive + user.getId().trim();
        UserManager.userStarter(PATH, user);
    }
    
    
    
    
}
