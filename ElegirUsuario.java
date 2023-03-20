
package pantallas.admiinistradorUsuario.elegirUsuario;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import pantallas.admiinistradorUsuario.crearUsuario.CrearModificarUsuario;
import usuarios.Constants;
import usuarios.modelo_datos.UserManager;
import static usuarios.modelo_datos.UserManager.readUser;
import usuarios.modelo_datos.Usuario;


public class ElegirUsuario extends JFrame implements Constants
{
    private JList userList =  new JList();
    private ArrayList<Usuario> usrs = new ArrayList();
    private boolean borrar = false;
    private JButton delete = new JButton("Borrar");
    private JButton modif = new JButton("Modificar");
    
    public ElegirUsuario(boolean erase)
    {
        this.borrar = erase;
        this.setSize(1000, 400);
        this.setLocation(400, 300);

        getContentPane().setLayout(new BorderLayout());
        JPanel centerPanel = new JPanel(new GridLayout(1, 0));
        getContentPane().add(centerPanel, BorderLayout.CENTER);

        readUsers();
        
        JScrollPane scrollpane = new JScrollPane(userList);
        centerPanel.add(scrollpane);
        userList.setFont(new Font("Courier New", Font.BOLD, 20));
        userList.addListSelectionListener(new ListSelectionListener()
        {
            public void valueChanged(ListSelectionEvent e) 
            {
                if (e.getSource()== userList && !userList.isSelectionEmpty())
                {
                    if (userList.getSelectedValue() != null)
                    {
                        delete.setVisible(true);
                        modif.setVisible(true);
                        if (borrar) 
                        {
                            modif.setVisible(false);
                        } else 
                        {
                            delete.setVisible(false);
                        }
                    }
                }
            }
        });
        
        this.delete.setFont(new Font("Arial", Font.BOLD, 18));
        this.modif.setFont(new Font("Arial", Font.BOLD, 18));
        
        delete.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent ae) 
            {
                Usuario u = usrs.get(userList.getSelectedIndex());
                int option = JOptionPane.showConfirmDialog(null, "Desea borrar el usuario " + u.getId().trim() + "?",
                        "borrar?", JOptionPane.YES_NO_OPTION);
                if (option == 0) 
                {
                    String dpath = drive + "\\" + u.getId().trim() + "\\" + u.getId().trim();
                    boolean deleted = UserManager.deleteUser(dpath, u, ElegirUsuario.this);
                    
                    if (deleted) 
                    {
                        userList.setListData(new Vector());
                        readUsers();
                        JOptionPane.showMessageDialog(null, "Usuario borrado correctamente.");
                    }
                }
            }
        });
        
        modif.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent ae) 
            {
                Usuario u = usrs.get(userList.getSelectedIndex());
                int option = JOptionPane.showConfirmDialog(null, "Desea modificar el usuario " + u.getId() + "?",
                        "modificar?", JOptionPane.YES_NO_OPTION);
                if (option == 0) 
                {
                    CrearModificarUsuario cmu = new CrearModificarUsuario(u,ElegirUsuario.this);
                    cmu.setVisible(true);
                    
                }
            }
        });
        
        
        delete.setVisible(false);
        modif.setVisible(false);
        
        
        JPanel southPane = new JPanel(new GridLayout(0,7));
        southPane.add(new JLabel());
        southPane.add(new JLabel());
        southPane.add(new JLabel());
        southPane.add(delete);
        southPane.add(modif);
        getContentPane().add(southPane,BorderLayout.SOUTH);
        
    }
    
     
    public void readUsers()
    {
        File dirs = new File(drive);
        //JOptionPane.showMessageDialog(null, "Lista de archivos: ");
        System.out.println("Abriendo directorio " + drive);
        if (dirs.isDirectory())
        {
            System.out.println("Confirmando es un directorio.");
            Vector v = new Vector();
            
            File[] dirArray = dirs.listFiles();
            System.out.println("DirArray.length = " + dirArray.length);
            for (int i = 0; i < dirArray.length; i++) 
            {
                File file = dirArray[i];
                //JOptionPane.showMessageDialog(null, "Archivo: " + file.getName());
                //v.add(file.getName());
                if (file.isDirectory())
                {
                    System.out.println(file.getName() + " es directorio.");
                    File[] listFiles = file.listFiles();
                    
                    if (listFiles != null && listFiles.length > 0) 
                    {
                        boolean isArchivo = false;
                        String dirUserPath = null;
                        for (int j = 0; j < listFiles.length; j++)
                        {
                            if (!listFiles[j].isDirectory())
                            {
                                isArchivo = true;
                                dirUserPath = drive + listFiles[j].getName();
                                break;
                            }
                        }
                        if (isArchivo) 
                        {
                            System.out.println("ElegirUsuario.readUsers dirUserPath = " + dirUserPath);
                            System.out.println("Intentara abrir " + dirUserPath);
                            File dirUser = new File(dirUserPath);
                            if (dirUser.exists() && dirUser.isDirectory()) 
                            {
                                System.out.println(dirUser.getName() + " existe y es dir.");
                                System.out.println("Intentara abrir " + dirUser.getPath()+ " el que no es dir.");
                                boolean isFile = false;
                                File fileUser = null;
                                File[] listFilesUserDesktop = dirUser.listFiles();
                                for (int j = 0; listFilesUserDesktop != null && j < listFiles.length; j++) 
                                {
                                    if (!listFilesUserDesktop[j].isDirectory())
                                    {
                                        isFile = true;
                                        fileUser = listFilesUserDesktop[j];
                                        break;
                                    }
                                }
                                if (isFile)
                                {
                                    Usuario u = readUser(fileUser);
                                    StringBuilder sb = new StringBuilder();
                                    sb.append(u.getId().trim());
                                    for (int j = 0; j < SIZE_ID - u.getId().length(); j++) 
                                    {
                                        sb.append(" ");
                                    }

                                    //---------------------------------------------------------------------
                                    sb.append(u.getNombre());
                                    for (int j = 0; j < SIZE_NAME - u.getNombre().length(); j++) 
                                    {
                                        sb.append(" ");
                                    }

                                    //---------------------------------------------------------------------
                                    sb.append(u.getApellido());
                                    for (int j = 0; j < SIZE_LNAME - u.getApellido().length(); j++) 
                                    {
                                        sb.append(" ");
                                    }
                                    v.add("" + (i + 1) + ".- " + sb.toString());
                                    usrs.add(u);
                                    this.userList.setListData(v);
                                } // if (fileUser.exists()) 

                            
                            } // if (dirUser.exists() && dirUser.isDirectory()) 
                        }
                    }// if (listFiles != null && listFiles.length > 0) 
                }else // if (file.isDirectory())
                {
                    System.out.println("No es directorio " + file.getName());
                }
                
            } // for (int i = 0; i < dirArray.length; i++) 
                
            
        }
        
    }
}
