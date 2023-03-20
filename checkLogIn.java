
package usuarios.login;

import java.io.File;
import usuarios.Constants;
import usuarios.modelo_datos.UserManager;
import usuarios.modelo_datos.Usuario;


public class checkLogIn implements Constants
{
    public static Usuario verifyUser(String id)
    {
        String path = drive + id + "\\" + id;
        System.out.println("checkLogIn.verifyUser path = " + path);
        File file = new File(path);
        Usuario user = UserManager.readUser(file);
        if (user == null)
        {
           System.out.println("checkLogIn.User = null");

        }else
        {
           System.out.println("checkLogIn.User = " + user.getId());

        }
        return user;
    }
}
