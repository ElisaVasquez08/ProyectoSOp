
package usuarios.login;

import pantallas.pantallaPrincipal.Windows;
import java.awt.BorderLayout;
import java.awt.Color;
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
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import usuarios.modelo_datos.Usuario;

public class LogIn extends JFrame
{
    private JTextField jTextFieldID = new JTextField();
    private JPasswordField jPasswordField = new JPasswordField();
    private JButton jButtonOK = new JButton("Log In");

    public LogIn() 
    {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(800,600);
        this.setLocation(300, 400);
        this.setTitle("LOGIN");
        
        JLabel rotulo = new JLabel("Welcome to Windows");
        rotulo.setFont(new Font("Arial", Font.BOLD, 20));
        rotulo.setHorizontalAlignment(JLabel.CENTER);
        
        JPanel panelRotulo = new JPanel(new BorderLayout());
        JLabel image = new JLabel();
        image.setIcon(new ImageIcon("WindowsLogIn.jpg"));
        panelRotulo.add(image, BorderLayout.NORTH);
        panelRotulo.add(rotulo, BorderLayout.CENTER);
        
        //------------------------------------------------------
        
        JPanel panelID = new JPanel();
        JLabel labelID = new JLabel("Usuario: ");
        labelID.setFont(new Font("Arial", Font.BOLD, 16));
        jTextFieldID.setColumns(15);
        panelID.add(labelID);
        panelID.add(jTextFieldID);
        
        //------------------------------------------------------
        
        JPanel panelPass = new JPanel();
        JLabel labelPass = new JLabel("Contraseña: ");
        labelPass.setFont(new Font("Arial", Font.BOLD, 16));
        jPasswordField.setColumns(15);
        panelPass.add(labelPass);
        panelPass.add(jPasswordField);
        
        //------------------------------------------------------
        
        jButtonOK.setFont(new Font("Arial", Font.BOLD, 14));
        jButtonOK.setBackground(Color.orange);
        
        jButtonOK.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent ae)
            {
                Usuario u = checkLogIn.verifyUser(jTextFieldID.getText());
                System.out.println("JPassword = " + jPasswordField.getText() );
                if (u == null || u.getId().length() == 0)
                {
                    JOptionPane.showMessageDialog(null, "Usuario no encontrado...");
                    return;
                }
                
                System.out.println("in if JPassword = " + jPasswordField.getText() );
                System.out.println("u.getPass = " + u.getPassword() );
                String pass = jPasswordField.getText();
                if (!u.getPassword().trim().equals(pass))   // <<---- REVISAR password isnt being verified
                {
                    JOptionPane.showMessageDialog(null, "Contraseña no válida.");
                    return;
                }
                
                JOptionPane.showMessageDialog(null, "Bienvenido " + u.getNombre().trim() + " " + u.getApellido().trim());
                LogIn.this.dispose();
                Windows wd = new Windows(u);
                wd.setVisible(true);
            }
        });
        
        //------------------------------------------------------
        
        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.add(panelID, BorderLayout.NORTH);
        centerPanel.add(panelPass, BorderLayout.CENTER);
        
        //------------------------------------------------------
        
        JPanel southPanel = new JPanel(new GridLayout(3,0));
        
        JPanel panelButton=new JPanel(new GridLayout(0,5));
        panelButton.add(new JLabel());
        panelButton.add(new JLabel());
        panelButton.add(jButtonOK);
        
        
        southPanel.add(panelButton);
        southPanel.add(new JLabel());
        southPanel.add(new JLabel());
                
        //------------------------------------------------------
        
        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(panelRotulo,BorderLayout.NORTH);
        this.getContentPane().add(centerPanel, BorderLayout.CENTER);
        this.getContentPane().add(southPanel, BorderLayout.SOUTH);
        
        
        
    }
    
    
    
}
