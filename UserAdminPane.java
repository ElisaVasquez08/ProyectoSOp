
package pantallas.admiinistradorUsuario;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import pantallas.admiinistradorUsuario.crearUsuario.CrearModificarUsuario;
import pantallas.admiinistradorUsuario.elegirUsuario.ElegirUsuario;

public class UserAdminPane extends JFrame
{
    private final int NUM_BUTTONS = 12;
    private JButton buttonAccounts = new JButton();
    private JButton addButton = new JButton();
    private JButton eraseButton = new JButton();
    private JButton modifButton = new JButton();
    
    public UserAdminPane()
    {
        this.setSize(800, 400);
        this.setLocation(300, 400);
        this.setTitle("Administracion de usuarios.");
        
        getContentPane().setLayout(new BorderLayout());

        getContentPane().add(buttonMaker(), BorderLayout.WEST);
        
        
    }
    
    private JButton accounts()
    {
        buttonAccounts.setIcon(new ImageIcon("FoldersIcon.jpg"));
        buttonAccounts.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent ae)
            {
                
            }
            });
        return buttonAccounts;
    }
        
    private JButton addAccount()
    {
        addButton.setIcon(new ImageIcon("AddUser.jpg"));
        addButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent ae)
            {
                CrearModificarUsuario cmu = new CrearModificarUsuario();
                cmu.setVisible(true);
            }
            });
        return addButton;
    }
        
    private JButton eraseAccounts()
    {
        eraseButton.setIcon(new ImageIcon("DeleteUser.jpg"));
        eraseButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent ae)
            {
                ElegirUsuario eu = new ElegirUsuario(true);
                eu.setVisible(true);
                
            }
            });
        return eraseButton;
    }
    
    private JButton modAccounts()
    {
        modifButton.setIcon(new ImageIcon("EditUser.jpg"));
        modifButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent ae)
            {
                ElegirUsuario eu = new ElegirUsuario(false);
                eu.setVisible(true);
            }
            });
        return modifButton;
    }
    
    private JPanel buttonMaker()
    {
        JPanel panelButtons = new JPanel(new GridLayout(NUM_BUTTONS, 0));

        panelButtons.add(new JLabel());
        panelButtons.add(new JLabel());
        panelButtons.add(new JLabel());

        panelButtons.add(accounts());
        panelButtons.add(addAccount());
        panelButtons.add(eraseAccounts());
        panelButtons.add(modAccounts());
        panelButtons.add(new JLabel());
        panelButtons.add(new JLabel());

        return panelButtons;
    }
    
}
