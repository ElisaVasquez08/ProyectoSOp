
package pantallas.pantallaPrincipal;

import JtextEditor.pantalla.JFrameEditor;
import audioPlayer.MP3Player;
import cmd.commandConsole;
import cmd.consola_comandos.ConsolaPantalla;
import pantallas.admiinistradorUsuario.UserAdminPane;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import photoViewer.photoHandler.PeticionDeDatos;
import photoViewer.photoHandler.despliegueDeImagenes.ImageDisplay;
import subDirs.pantalla.PantallaDirectorio;
import usuarios.Constants;
import usuarios.login.LogIn;
import usuarios.modelo_datos.Usuario;

public class Windows extends JFrame implements Constants
{
    private Usuario user;
    private final int NUM_BUTTONS = 12;
    private JButton buttonUsers = new JButton();
    private JButton buttonFileManager = new JButton();
    private JButton buttonmiDocsManager = new JButton();
    private JButton buttonTextEditor = new JButton();
    private JButton buttonImageViewer = new JButton();
    private JButton buttonCMD = new JButton();
    private JButton buttonMusicPlayer = new JButton();
    private JButton buttonTweerer = new JButton();
    private JButton logOffButton = new JButton();
    private Image fondo = null;
    
    public Windows(Usuario user) 
    {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.user = user;
        this.setSize(screenSize.width, screenSize.height);
        this.setLocation(0, 0);
        //this.fondo = new ImageIcon("C:\\Users\\smnsl\\OneDrive\\Documentos\\NetBeansProjects\\Proyect2_Progra2\\Sunset_Wallpaper.jpg").getImage();
        
        getContentPane().setLayout(new BorderLayout());
        
        getContentPane().add(buttonMaker(), BorderLayout.WEST);
        /*
        try {
            this.mImagen = ImageIO.read(new File("Sunset_Wallpaper.jpg"));
        } catch (IOException ex) {
            Logger.getLogger(Windows.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try
        {
            
            JPanel panel = (JPanel) this.getContentPane();
            panel.setBorder(mImagen);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }*/
        
        
        this.setTitle("Pantalla Principal");
        repaint();
        revalidate();
    }
    
    private BufferedImage mImagen = null;    
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        if (mImagen != null) {
            g.drawImage(mImagen, 0, 0, width, height, null);
        }
    }

    protected void paintComponent(Graphics g) 
    {
        super.paintComponents(g);
        g.drawImage(fondo, 0, 0, getWidth(), getHeight(), null);
    }
    
    private JPanel buttonMaker()
    {
        JPanel panelButtons = new JPanel(new GridLayout(NUM_BUTTONS , 0));
        
        panelButtons.add(new JLabel());
        panelButtons.add(new JLabel());
        
        

        if (user.getId().trim().equals("Admin"))
        {
            panelButtons.add(userManager());
        }else
        {
            panelButtons.add(new JLabel());

        }
        if (user.getId().trim().equals("Admin")) {
            panelButtons.add(fileManager());
        }else
        {
            panelButtons.add(new JLabel());
        }
        panelButtons.add(miDocsManager());
        panelButtons.add(textEdManager());
        panelButtons.add(ImageViewerManager());
        panelButtons.add(CMDManager());
        panelButtons.add(musicPlayerManager());
        panelButtons.add(tweeterManager());
        panelButtons.add(logOffManager());
        
        
        return panelButtons;
    }
    
    private JButton userManager()
    {
        buttonUsers.setIcon(new ImageIcon("UserImage.jpg"));
        buttonUsers.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent ae)
            {
                UserAdminPane usp = new UserAdminPane();
                usp.setVisible(true);
            }
            });
        return buttonUsers;
    }
    
    private JButton fileManager()
    {
        buttonFileManager.setIcon(new ImageIcon("FileManager.jpg"));
        buttonFileManager.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent ae)
            {
                new PantallaDirectorio(false, user, Windows.this).setVisible(true);                
            }
            });
        return buttonFileManager;
    }
    
    private JButton miDocsManager() {
        buttonmiDocsManager.setIcon(new ImageIcon("MiDocuments.jpg"));
        buttonmiDocsManager.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                new PantallaDirectorio(true, user, Windows.this).setVisible(true);
            }
        });
        return buttonmiDocsManager;
    }
    
    
    private JButton textEdManager()
    {
        buttonTextEditor.setIcon(new ImageIcon("TextEditor.jpg"));
        buttonTextEditor.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent ae)
            {
                new JFrameEditor(drive + "\\" + user.getId().trim() + "\\" + "desktop" + "\\" + "mis_documentos").setVisible(true);
            }
            });
        return buttonTextEditor;
    }
    
    
    private JButton ImageViewerManager()
    {
        buttonImageViewer.setIcon(new ImageIcon("ImageViewer.jpg"));
        buttonImageViewer.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent ae)
            {
                File directory;
                if (user.getId().trim().equals("Admin"))
                {
                    directory = new PeticionDeDatos().pide_path(Windows.this);
                }else
                {
                    directory = new File(drive + "\\" + user.getId().trim() + "\\" + "desktop" + "\\" + "mis_fotos");
                }
                if (directory == null || !directory.exists() || !directory.isDirectory())
                {
                    JOptionPane.showMessageDialog(null, "Directorio " + directory.getAbsolutePath() +" no valido" );
                    return;
                }
  
                new ImageDisplay(directory).setVisible(true);  
            }
            });
        return buttonImageViewer;
    }
    
    
    private JButton CMDManager()
    {
        buttonCMD.setIcon(new ImageIcon("CMDImage.jpg"));
        buttonCMD.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent ae)
            {
                new ConsolaPantalla(drive + "\\" +user.getId().trim()).setVisible(true);
            }
            });
        return buttonCMD;
    }
    
    
    private JButton musicPlayerManager()
    {
        buttonMusicPlayer.setIcon(new ImageIcon("MusicPlayer.jpg"));
        buttonMusicPlayer.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent ae)
            {
                new MP3Player(drive + "\\" +user.getId().trim() + "\\desktop\\musica" );
            }
            });
        return buttonMusicPlayer;
    }
    
    
    private JButton tweeterManager()
    {
        buttonTweerer.setIcon(new ImageIcon("TweeterIcon.jpg"));
        buttonTweerer.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent ae)
            {
                
            }
            });
        return buttonTweerer;
    }
    
    private JButton logOffManager()
    {
        logOffButton.setIcon(new ImageIcon("LogOffIcon.png"));
        logOffButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent ae)
            {
                Windows.this.dispose();
                new LogIn().setVisible(true);
            }
            });
        return logOffButton;
    }
    
    
}
