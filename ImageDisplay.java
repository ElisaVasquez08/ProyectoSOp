
package photoViewer.photoHandler.despliegueDeImagenes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import photoViewer.photoHandler.PeticionDeDatos;

public class ImageDisplay extends JFrame
{
    private JButton leftButton = new JButton();
    private JButton rightButton = new JButton();
    private int pointer = -1;
    private File[] listaDeArchivos = null;
    private File selectedFile = null;
    private final String ROTULOINICIAL = "Visor de Imagenes";
    private final int total_slider = 200; //máxima escala del slider
    private JSlider slider = new JSlider(SwingConstants.HORIZONTAL, 0, total_slider, 10);
    private BufferedImage imagen=null;
    private JLabel label_imagen=new JLabel(new ImageIcon());
    //private JLabel image = new JLabel();
    
    public ImageDisplay(File directory)
    {
        listaDeArchivos = directory.listFiles();
        if (listaDeArchivos == null)
        {
            JOptionPane.showMessageDialog(null, "Directorio nulo.");
            return;
        }
        
        if (listaDeArchivos.length == 0)
        {
            JOptionPane.showMessageDialog(null, "Directorio vacio.");
            return;
        }
        
        this.setTitle("PHOTO VIEWER " + directory.getPath());
        inicializaComponentes();
        
    }
    
    
    private void inicializaComponentes()
    {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(1300, 1000);
        this.setLocation(0, 0);
        
        this.getContentPane().setLayout(new BorderLayout());
        // -----------------------N o r t e-------------------------------------
        JPanel panel_norte=new JPanel(new BorderLayout());
        JLabel rotulo = new JLabel(ROTULOINICIAL);
        rotulo.setFont(new Font("Arial", Font.BOLD, 20));
        rotulo.setHorizontalAlignment(JLabel.CENTER);
        panel_norte.add(rotulo,BorderLayout.CENTER);
        //----------------------------------------------------------------------
        panel_norte.add(hacer_slider(),BorderLayout.SOUTH);
        this.getContentPane().add(panel_norte, BorderLayout.NORTH);
        // -----------------------C e n t r o-----------------------------------
        JPanel panelCentro = new JPanel();
        JScrollPane jscroll = new JScrollPane(panelCentro);
        this.getContentPane().add(jscroll, BorderLayout.CENTER);

                
        // ---------------------------------------------------------------------
        
        JPanel panelBotones = new JPanel(new GridLayout(0,7));
        panelBotones.add(new JLabel());
        panelBotones.add(new JLabel());
        panelBotones.add(leftButton);
        panelBotones.add(new JLabel());
        panelBotones.add(rightButton);
        this.getContentPane().add(panelBotones, BorderLayout.SOUTH);
        
        // Boton Izquierdo -----------------------------------------------------

        leftButton.setIcon(new ImageIcon("LeftArrow.jpg"));
        
        leftButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae) 
            {
                if ((pointer-1) < 0 )
                {
                    return;
                }
                pointer = pointer - 1;
                selectedFile = listaDeArchivos[pointer];
                rotulo.setText(ROTULOINICIAL + " " + selectedFile.getPath());
                try {
                    imagen = ImageUtils.loadBufferedImage(selectedFile.getPath());
                    label_imagen.setIcon(new ImageIcon(imagen));
                } catch (Exception e)
                {
                    //System.err.println("no existe "+ruta_default);
                }
                habilita_slider(true);
                inicializa_slider();
                repaint();
                revalidate();
            }
        });
        
        // Boton derecho -------------------------------------------------------
        
        rightButton.setIcon(new ImageIcon("RightArrow.jpg"));
        
        rightButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae) 
            {
                if ((pointer + 1) >= listaDeArchivos.length)
                {
                    return;
                }
                pointer = pointer + 1;
                selectedFile = listaDeArchivos[pointer];
                rotulo.setText(ROTULOINICIAL + " " + selectedFile.getPath());
                try {
                    imagen = ImageUtils.loadBufferedImage(selectedFile.getPath());
                    label_imagen.setIcon(new ImageIcon(imagen));
                } catch (Exception e) 
                {
                    //System.err.println("no existe "+ruta_default);
                }
                habilita_slider(true);
                inicializa_slider();
                repaint();
                revalidate();
            }
        });
        
        // ---------------------------------------------------------------------
        
        
        //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        if (listaDeArchivos.length != 0)
        {
            pointer = listaDeArchivos.length / 2;
            selectedFile = listaDeArchivos[pointer];
        }
        
        panelCentro.add(panel_imagen());//debe ir despues de inicializar selectedFile
        //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        String rotuloIn = ROTULOINICIAL;
        if (selectedFile != null)
        {
            rotuloIn = rotuloIn + " " + selectedFile.getPath();
        }
        
        rotulo.setText(rotuloIn);
        
        if (selectedFile != null)
        {
            label_imagen.setIcon(new ImageIcon(selectedFile.getPath()));
        }
        
        panelCentro.add(label_imagen);
        habilita_slider(true);
        inicializa_slider();
        
        this.repaint();
        this.revalidate();
        // ---------------------------------------------------------------------

    }
    
    private JPanel panel_imagen(){
        JPanel panel_img=new JPanel(new BorderLayout());
        //++++++++++++++++++++++++++++++++++++++++++++++++++++
        //panel_img.add(hacer_slider(),BorderLayout.NORTH);
        //++++++++++++++++++++++++++++++++++++++++++++++++++++
        try{
            imagen=ImageUtils.loadBufferedImage(selectedFile.getPath());
            label_imagen.setIcon(new ImageIcon(imagen));
        }catch(Exception e){
            //System.err.println("no existe "+ruta_default);
        }    
        JScrollPane scroll=new JScrollPane();
        scroll.setViewportView(label_imagen);
        panel_img.add(scroll,BorderLayout.CENTER);
        //++++++++++++++++++++++++++++++++++++++++++++++++++++
        return panel_img;
    }
    
    
    private JPanel hacer_slider()
    {
        JPanel panel = new JPanel();
        slider.setMajorTickSpacing(10);
        slider.setPaintTicks(true);
        slider.setForeground(Color.RED);
        slider.setBackground(Color.BLUE);
        habilita_slider(false);

        slider.addChangeListener(
                new javax.swing.event.ChangeListener() 
                { //clase anónima interna
            public void stateChanged(ChangeEvent e) 
            {
                double escala = (double) (slider.getValue() + 40) / total_slider;
                BufferedImage nueva = ImageUtils.scale(escala, imagen);

                if (nueva != null) 
                {
                    label_imagen.setIcon(new ImageIcon(nueva));
                }
            } //fin de stateChanged
        }//fin de la clase anonima interna
        );//llamada a ChangeListener
        panel.add(slider);
        return panel;
    }
    
    private void inicializa_slider() 
    {
        //BufferedImage buffered_imagen=ImageUtils.loadBufferedImage(ruta_imagen);
        BufferedImage buffered_imagen = ConvierteImagen_a_BufferedImage.toBufferedImage(imagen);
        float porcentaje = 0.2f;
        slider.setValue(Math.round(slider.getMaximum() * porcentaje));
        double escala = (double) (slider.getValue() + 40) / total_slider;
        BufferedImage nueva = ImageUtils.scale(escala, buffered_imagen);
        if (nueva != null) {
            label_imagen.setIcon(new ImageIcon(nueva));
        }
    }
    
    private void habilita_slider(boolean activate) 
    {
        slider.setVisible(activate);
    }
}
