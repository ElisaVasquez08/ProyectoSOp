
package pantallas.admiinistradorUsuario.crearUsuario;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import pantallas.admiinistradorUsuario.elegirUsuario.ElegirUsuario;
import usuarios.modelo_datos.UserManager;
import usuarios.modelo_datos.Usuario;

public class CrearModificarUsuario extends JFrame
{
    private Usuario user;
    private JTextField idUser = new JTextField();
    private JTextField password = new JTextField();
    private JTextField nombres = new JTextField();
    private JTextField apellidos = new JTextField();
    private JButton okButton = new JButton("grabar");
    private ElegirUsuario pantallaElegirUsuario = null;
   
    
    public CrearModificarUsuario(Usuario u , ElegirUsuario eu)
    { // Modificacion de usuario
        this.pantallaElegirUsuario = eu;
        this.user = u;
        contructor();
        this.idUser.setText(this.user.getId());
        this.nombres.setText(this.user.getNombre());
        this.apellidos.setText(this.user.getApellido());
        this.idUser.setEditable(false);
        
    }
    
    public CrearModificarUsuario()
    { // Nuevo usuario
        this.pantallaElegirUsuario = null;
        contructor();
        this.user = null;
    }
    
    private void contructor()
    {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(800, 400);
        this.setLocation(300, 400);
        this.setTitle("Creacion o modificacion de usuario");
        
        getContentPane().setLayout(new BorderLayout());
        JPanel centerPanel = new JPanel(new GridLayout(4,2));
        getContentPane().add(centerPanel, BorderLayout.CENTER);
        
        //-------------------------------------------------------------------------
        
        JLabel label_id = new JLabel("Id: ");
        label_id.setHorizontalAlignment(JLabel.RIGHT);
        label_id.setFont(new Font("Arial", Font.BOLD, 20));
        idUser.setColumns(12);
        centerPanel.add(label_id);
        centerPanel.add(idUser);
        
        //-------------------------------------------------------------------------
        
        JLabel label_pass = new JLabel("Password: ");
        label_pass.setHorizontalAlignment(JLabel.RIGHT);
        label_pass.setFont(new Font("Arial", Font.BOLD, 20));
        password.setColumns(22);
        centerPanel.add(label_pass);
        centerPanel.add(password);
        
        //-------------------------------------------------------------------------
        
        JLabel label_nombres = new JLabel("Nombre: ");
        label_nombres.setHorizontalAlignment(JLabel.RIGHT);
        label_nombres.setFont(new Font("Arial", Font.BOLD, 20));
        nombres.setColumns(33);
        centerPanel.add(label_nombres);
        centerPanel.add(nombres);
        
        //-------------------------------------------------------------------------
        
        JLabel label_apellidos = new JLabel("Apellido: ");
        label_apellidos.setHorizontalAlignment(JLabel.RIGHT);
        label_apellidos.setFont(new Font("Arial", Font.BOLD, 20));
        apellidos.setColumns(44);
        centerPanel.add(label_apellidos);
        centerPanel.add(apellidos);
        
        //-------------------------------------------------------------------------
        
        JPanel renglon5 = new JPanel(new GridLayout(0,5));
        okButton.setHorizontalAlignment(JLabel.RIGHT);
        okButton.setFont(new Font("Arial", Font.BOLD, 20));
        renglon5.add(new JLabel());
        renglon5.add(new JLabel());
        renglon5.add(okButton);
        
        //String id, String nombre, String Apellido, String nivel, String password
        
        okButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent ae) 
            {
                if (!verifyInfo())
                {
                    return;
                }
                if (user == null) // New user
                {
                    Usuario u = new Usuario(idUser.getText(), nombres.getText(), apellidos.getText(), "2", password.getText());
                    boolean ok = UserManager.addUser(u);
                    if (ok) 
                    {
                        JOptionPane.showMessageDialog(null, "Usuario agregado correctamente.");
                    } else 
                    {
                        JOptionPane.showMessageDialog(null, "Usuario no se pudo agregar.");
                    }
                    CrearModificarUsuario.this.dispose();
                    
                    
                }else // Modificacion
                {
                    Usuario u = new Usuario(idUser.getText(), nombres.getText(), apellidos.getText(), "2", password.getText());
                    boolean ok = UserManager.modifyUser(u);
                    if (ok)
                    {
                        JOptionPane.showMessageDialog(null, "Usuario modificado correctamente.");
                    } else 
                    {
                        JOptionPane.showMessageDialog(null, "Usuario no se pudo modificar.");
                    }
                    CrearModificarUsuario.this.dispose();
                    // Refresh Lista de Usuarios
                    pantallaElegirUsuario.readUsers();

                }
                    
            }
        });
        
        getContentPane().add(renglon5, BorderLayout.SOUTH);
        
    }
    
    private boolean verifyInfo()
    {
        if (this.idUser.getText().length() == 0 )
        {
            JOptionPane.showMessageDialog(null, "Id de usuario no puede ir en blanco.");
            return false;
        }
        if (this.password.getText().length() == 0 )
        {
            JOptionPane.showMessageDialog(null, "Password de usuario no puede ir en blanco.");
            return false;
        }
        if (this.nombres.getText().length() == 0 )
        {
            JOptionPane.showMessageDialog(null, "Nombre de usuario no puede ir en blanco.");
            return false;
        }
        if (this.apellidos.getText().length() == 0 )
        {
            JOptionPane.showMessageDialog(null, "Apellido de usuario no puede ir en blanco.");
            return false;
        }
        return true;
    }
    
}
