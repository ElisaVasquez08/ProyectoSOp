
package usuarios.modelo_datos;

import usuarios.modelo_datos.Usuario;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import pantallas.admiinistradorUsuario.elegirUsuario.ElegirUsuario;
import usuarios.Constants;

public class UserManager implements Constants
{

    
    public static BufferedWriter modArchivo(String path)
    {
        FileWriter file = null;
        BufferedWriter writer = null;
        try 
        {
            //JOptionPane.showMessageDialog(null, "Path: " + path);
            file = new FileWriter(path);

            writer = new BufferedWriter(file);
            System.out.println("Abriendo archivo " + path + ". ");
 
        } catch (IOException e) 
        {
            System.err.println("No pudo abrir el archivo " + path);
            e.printStackTrace();
        }
        return writer;
    }
    
    public static boolean addUser(BufferedWriter writer, Usuario user)
    {
        // Buffering objects ---------------------------------------------------------------
        
        //Creacion de id

        String idSTR = user.getId().length() > SIZE_ID
                ? user.getId().substring(0,SIZE_ID)
                : user.getId()
                ;
        
        StringBuilder sb = new StringBuilder(idSTR);
        for (int i = 0; i < SIZE_ID - idSTR.length(); i++) 
        {
            sb.append(" ");
        }
        
        // Creacion de nombre

        String nameSTR = user.getNombre().length() > SIZE_NAME
                ? user.getNombre().substring(0, SIZE_NAME)
                : user.getNombre();
        sb.append(nameSTR);
        for (int i = 0; i < SIZE_NAME - nameSTR.length(); i++) 
        {
            sb.append(" ");
        }
        
        // Creacion de apellido
        
        String LnameSTR = user.getApellido().length() > SIZE_LNAME
                ? user.getApellido().substring(0, SIZE_LNAME)
                : user.getApellido();
        sb.append(LnameSTR);
        for (int i = 0; i < SIZE_LNAME - LnameSTR.length(); i++) 
        {
            sb.append(" ");
        }
        
        // Creacion de nivel
        
        String lvlSTR = user.getNivel().length() > SIZE_LVL
                ? user.getNivel().substring(0, SIZE_LVL)
                : user.getNivel();
        sb.append(lvlSTR);
        
        // Creacion de password
        
        String passSTR = user.getPassword().length() > SIZE_PASS
                ? user.getPassword().substring(0, SIZE_PASS)
                : user.getPassword();
        sb.append(passSTR);
        for (int i = 0; i < SIZE_PASS - passSTR.length(); i++)
        {
            sb.append(" ");
        }
        
        
        try
        {
            writer.write(sb.toString());
            writer.flush();
        }catch (IOException e) 
        {
            System.err.println("No pudo agregar usuario " + user.getId());
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
    public static boolean deleteUser(String path, Usuario user, ElegirUsuario eu)
    {
        System.out.println("*****************************************************");
        System.out.println("UserManager.deleteUser");
        System.out.println("*****************************************************");

        File file = new File(path);
        System.out.println("Path = " + path);

        if (!file.exists())
        {
            System.out.println("No existe el archivo en " + path);
            return false;
        }
        file.delete();
        System.out.println("Borro correctamente el archivo e " + path);
        eu.readUsers();
        
        return true;
    }
    
    public static boolean cerrarArchivo(BufferedWriter writer)
    {
        try 
        {
            writer.close();
        } catch (IOException e)
        {
            System.err.println("No pudo cerrar el archivo.");
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
    public static boolean userStarter(String path, Usuario user)
    {
        BufferedWriter writer = modArchivo(path);
        boolean added = addUser(writer, user);
        
        if (added) 
        {
            System.out.println("Agregado correctamente el usuario " + user.getId());
        }else
        {
            System.out.println("No se agrego el usuario " + user.getId());
            return false;
        }
        
        cerrarArchivo(writer);
        return true;
    }
    
    public static boolean addUser(Usuario user)
    {
        final String DIRPATH = drive + user.getId().trim();
        File fl = new File(DIRPATH);
        if (fl.exists())
        {
            boolean delete = fl.delete();
            if (delete)
            {
                System.out.println(DIRPATH + " ya existia, fue borrado.");
            }
        }
        // Crea los directorios con el id de usuario -----------------------------------------------
        boolean mkdirUser = fl.mkdir();
        if (mkdirUser)
        {
            System.out.println("Creo carpeta " + DIRPATH);
            // Crea la carpeta de los desktops ------------------------------------------
            final String DESKTOPPATH = DIRPATH + "\\" + "desktop";
            File fld = new File(DESKTOPPATH);
            boolean mkdirDesktop = fld.mkdir();
            if (mkdirDesktop) 
            {
                System.out.println("Creo la carpeta " + DESKTOPPATH);
                // Crea la carpeta Mis docs ------------------------------------------
                final String DOCPATH = DESKTOPPATH + "\\" + "mis_documentos";
                File fldoc = new File(DOCPATH);
                boolean mkdirMisDocs = fldoc.mkdir();

                System.out.println("Creo la carpeta " + DOCPATH);
                // Crea la carpeta Musica ------------------------------------------
                final String MUSICPATH = DESKTOPPATH + "\\" + "musica";
                File flm = new File(MUSICPATH);
                boolean mkdirMusic = flm.mkdir();
                
                System.out.println("Creo la carpeta " + MUSICPATH);
                // Crea la carpeta Mis Imagenes ------------------------------------------
                final String PHOTOSPATH = DESKTOPPATH + "\\" + "mis_fotos";
                File flp = new File(PHOTOSPATH);
                boolean mkdirPhotos = flp.mkdir();
                
            }
        }
        final String FILEPATH = DIRPATH + "\\" + user.getId().trim();
        return UserManager.userStarter(FILEPATH, user);
    }
    
    public static boolean modifyUser(Usuario user) 
    {
        final String DIRPATH = drive + user.getId().trim();
        File fl = new File(DIRPATH);
        if (fl.exists()) 
        {
            System.out.println("modifyUser");
            System.out.println("DIRPATH = " + DIRPATH);
            final String FILEPATH = DIRPATH + "\\" + user.getId().trim();
            System.out.println("FilePath = " + FILEPATH);
            return UserManager.userStarter(FILEPATH, user);
        }else
        {
            System.out.println("No existe carpeta " + DIRPATH);
            return false;
        }
    }

    
    public static Usuario readUser(File file)
    {
        System.out.println("Usuario.readUser Param_userId = " + file.getName());
        System.out.println(file.getPath());
        FileReader fr;
        Usuario user ;
        try
        {
            fr = new FileReader(file.getPath());
            BufferedReader br = new BufferedReader(fr);
            
            if (br == null)
            {
                System.out.println("Usuario.readUser br = null");
            }
            
            String content;
            while ((content = br.readLine()) != null) 
            {
                System.out.println("Content = " + content);
                int sizeSum = SIZE_ID + SIZE_NAME + SIZE_LNAME + SIZE_LVL + SIZE_PASS;
                
                if (content.length() != sizeSum)
                {
                    System.out.println("Longitud de registro de usuarios diferente a " + sizeSum);
                    return null;
                }else
                {
                    System.out.println("Usuario.readUser content = " + content);
                }
                user = new Usuario(content.substring(0, SIZE_ID), // ID
                                    content.substring(SIZE_ID, SIZE_ID + SIZE_NAME), // Name
                                    content.substring(SIZE_ID + SIZE_NAME, SIZE_ID + SIZE_NAME + SIZE_LNAME), // Last Name
                                    content.substring(SIZE_ID + SIZE_NAME + SIZE_LNAME,SIZE_ID + SIZE_NAME + SIZE_LNAME + SIZE_LVL), // Level
                                    content.substring(SIZE_ID + SIZE_NAME + SIZE_LNAME + SIZE_LVL, SIZE_ID + SIZE_NAME + SIZE_LNAME + SIZE_LVL + SIZE_PASS) ); // Password
                
                System.out.println("Usuario.getUser user: ");
                System.out.println("Id: " + user.getId());
                System.out.println("Nombre: " + user.getNombre());
                System.out.println("Apellido: " + user.getApellido());
                System.out.println("Nivel: " + user.getNivel());
                //System.out.println("Password: " + user.getPassword());
                
                br.close();
                System.out.println("----------------------------------------------------------");
                return user;
            }
            
        } catch (IOException e)
        {
            System.out.println("\nError: " + e.getMessage());
            return null;
        }
        
        /*try 
        {
            fr = new FileReader(userId);
            BufferedReader br = new BufferedReader(fr);
            
            

                // Illustrating readLine() method
                System.out.println(br.readLine());

                // Illustrating read(char c[],int off,int len)
                br.read(c);

                for (int i = 0; i < 20; i++) {
                    System.out.print(c[i]);
                }

                System.out.println();

                // Illustrating reset() method
                br.reset();
                for (int i = 0; i < 8; i++) {

                    // Illustrating read() method
                    System.out.print((char) br.read());
            
        } catch (FileNotFoundException ex)
        {
            Logger.getLogger(UserManager.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        return null;
    }//readUser
    
    
    
}
