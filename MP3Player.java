package audioPlayer;




//importing all necessary packages
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
 
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
 
//implementing ActionListener interface
public class MP3Player implements ActionListener
{
    private JFrame frame;
    private JLabel songNameLabel=new JLabel();
    private JButton selectButton=new JButton("DIR");
    private JButton playButton=new JButton("Play");
    private JButton pauseButton=new JButton("Pause");
    private JButton resumeButton=new JButton("Resume");
    private JButton stopButton=new JButton("Stop");
    private JFileChooser fileChooser;
    private FileInputStream fileInputStream;
    private BufferedInputStream bufferedInputStream;
    private File myFile=null;
    private String filename;
    private long totalLength;
    private long pause;
    private Player player;
    private Thread playThread;
    private Thread resumeThread;
    
    
    private JList listaCanciones = new JList();
    private Vector<File> v = new Vector();
    private String rutaDefault = "C:\\Users\\smnsl\\OneDrive\\Documentos\\USUARIOS\\Os\\desktop\\musica\"";
    
    public MP3Player(String ruta)
    {
        
        this.rutaDefault = ruta;
        prepareGUI();
        addActionEvents();
        playThread=new Thread(runnablePlay);
        resumeThread=new Thread(runnableResume);
        songLoader();
        
    }
    public void prepareGUI()
    {
        // *****************************  Panel Principal    ******************************************
        frame=new JFrame();
        frame.setTitle("Music Player");
        frame.getContentPane().setLayout(new BorderLayout());
        frame.getContentPane().setBackground(Color.pink);
        frame.setSize(600,300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        // *****************************  Panel Norte    ******************************************
        JPanel panelNorte = new JPanel(new BorderLayout());
        JLabel rotuloPrincipal = new JLabel("Reproductor de mp3 ");
        rotuloPrincipal.setHorizontalAlignment(JLabel.CENTER);
        rotuloPrincipal.setFont(new Font("Arial", 0, 24));
        
        JLabel rotulo2 = new JLabel("Lista de canciones: ");
        rotulo2.setHorizontalAlignment(JLabel.CENTER);
        rotulo2.setFont(new Font("Arial", 0, 24));
        
        panelNorte.add(rotuloPrincipal, BorderLayout.NORTH);
        panelNorte.add(rotulo2, BorderLayout.CENTER);
        
        frame.getContentPane().add(panelNorte, BorderLayout.NORTH);
        
        // *****************************  Panel Central    ******************************************
        JPanel panelCentro = new JPanel();
        listaCanciones.addListSelectionListener(new ListSelectionListener() 
        {
            @Override
            public void valueChanged(ListSelectionEvent e)
            {
            playButtonVisible(true);
            pauseButtonVisible(false);
            resumeButtonVisible(false);
            stopButtonVisible(false);
            }
        });
        JScrollPane scroll = new JScrollPane(listaCanciones);
        panelCentro.add(scroll);
        frame.getContentPane().add(panelCentro, BorderLayout.CENTER);
        
 
        // *****************************  Panel Botones    ******************************************
        JPanel panelSur = new JPanel(new BorderLayout());
        
        songNameLabel.setBounds(100, 50, 300, 30);
        songNameLabel.setHorizontalAlignment(JLabel.CENTER);
        panelSur.add(songNameLabel,BorderLayout.NORTH);
        
        
        
        JPanel panelBotones = new JPanel(new GridLayout(0,8));
        
        selectButton.setBounds(160, 10, 100, 30);
        selectButton.setBackground(Color.cyan);
        panelBotones.add(selectButton);
        
        panelBotones.add(new JLabel());
        panelBotones.add(new JLabel());

        playButton.setBounds(30, 110, 100, 30);
        panelBotones.add(playButton);

        pauseButton.setBounds(120, 110, 100, 30);
        panelBotones.add(pauseButton);

        resumeButton.setBounds(210, 110, 100, 30);
        panelBotones.add(resumeButton);

        stopButton.setBounds(300, 110, 100, 30);
        panelBotones.add(stopButton);
        
        panelSur.add(panelBotones,BorderLayout.CENTER);
        
        frame.getContentPane().add(panelSur, BorderLayout.SOUTH);
        
        
    }
    
    private void songLoader()
    {
        File dir = new File(rutaDefault);
        if (dir == null || !dir.exists() || !dir.isDirectory()) 
        {
            ArrayList<String> arrMsn = new ArrayList();
            arrMsn.add(rutaDefault);
            arrMsn.add("Directorio no valido...");
            arrMsn.add(dir == null?"dir == null":"");
            arrMsn.add(!dir.exists()?"!dir.exists()":"");
            arrMsn.add(!dir.isDirectory()?"!dir.isDirectory()":"");
            JOptionPane.showMessageDialog(null, arrMsn.toArray());
            return;
        }
        v.clear();
        Vector msg = new Vector();
        File[] arrFiles = dir.listFiles();
        for (int i = 0; i < arrFiles.length; i++) 
        {
            v.add(arrFiles[i]);
            msg.add(arrFiles[i].getName());
            
        }
        listaCanciones.setListData(msg);
        todos_los_botones_visibles(false);
        frame.repaint();
        frame.revalidate();
        System.out.println(msg.size()+" canciones");
    }//songLoader
    
    
    public void addActionEvents(){
        //registering action listener to buttons
        selectButton.addActionListener(this);
        playButton.addActionListener(this);
        pauseButton.addActionListener(this);
        resumeButton.addActionListener(this);
        stopButton.addActionListener(this);
    }
 
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==selectButton){
            //code for selecting our mp3 file from dialog window
            
            fileChooser=new JFileChooser();
            fileChooser.setCurrentDirectory(new File(rutaDefault));
            
            fileChooser.setDialogTitle("Select Mp3 directory");
            fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            
            if(fileChooser.showOpenDialog(selectButton)==JFileChooser.APPROVE_OPTION){
                myFile=fileChooser.getSelectedFile();
                filename=fileChooser.getSelectedFile().getName();
                rutaDefault=fileChooser.getSelectedFile().getPath();
                JOptionPane.showMessageDialog(null, "Dir selected" + rutaDefault);
                songLoader();
            }
            
        }
        if(e.getSource()==playButton){
            //starting play thread
            playThread=new Thread(runnablePlay);
          playThread.start();
          myFile = v.get(listaCanciones.getSelectedIndex());
          filename = myFile.getName();
          songNameLabel.setText("now playing : "+ filename);
            playButtonVisible(false);
            pauseButtonVisible(true);
            resumeButtonVisible(false);
            stopButtonVisible(true);
        }
        if(e.getSource()==pauseButton){
            //code for pause button
                 if(player!=null){
                     playButtonVisible(false);
                     pauseButtonVisible(false);
                     resumeButtonVisible(true);
                     stopButtonVisible(true);
                     try {
                         pause=fileInputStream.available();
                         player.close();
                     } catch (IOException e1) {
                         e1.printStackTrace();
                     }
                 }
        }
 
        if(e.getSource()==resumeButton){
            //starting resume thread
            resumeThread=new Thread(runnableResume);
           resumeThread.start();
            playButtonVisible(false);
            pauseButtonVisible(true);
            resumeButtonVisible(false);
            stopButtonVisible(true);
        }
        if(e.getSource()==stopButton){
            //code for stop button
            playButtonVisible(true);
            pauseButtonVisible(false);
            resumeButtonVisible(false);
            stopButtonVisible(false);
            
            if(player!=null){
                player.close();
                songNameLabel.setText("");
                
                if (playThread != null)
                {
                    playThread.interrupt();
                }
            }
 
        }
 
    }
 
  Runnable runnablePlay=new Runnable() {
      @Override
      public void run() {
          try {
              //code for play button
              if (listaCanciones.getSelectedIndex() < 0 )
              {
                  System.out.println("runnablePlay no hay cancion seleccionada.");
                  return;
              }
              myFile = v.get(listaCanciones.getSelectedIndex());
              fileInputStream=new FileInputStream(myFile);
              bufferedInputStream=new BufferedInputStream(fileInputStream);
              player=new Player(bufferedInputStream);
              totalLength=fileInputStream.available();
              player.play();//starting music
          } catch (FileNotFoundException e) {
              e.printStackTrace();
          } catch (JavaLayerException e) {
              e.printStackTrace();
          } catch (IOException e) {
              e.printStackTrace();
          }
      }
  };
 
    Runnable runnableResume=new Runnable() {
        @Override
        public void run() {
            try {
                //code for resume button
                fileInputStream=new FileInputStream(myFile);
                bufferedInputStream=new BufferedInputStream(fileInputStream);
                player=new Player(bufferedInputStream);
                fileInputStream.skip(totalLength-pause);
                player.play();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (JavaLayerException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    };


private void todos_los_botones_visibles(boolean visible){

    playButtonVisible(visible);
    pauseButtonVisible(visible);
    resumeButtonVisible(visible);
    stopButtonVisible(visible);
}


private void playButtonVisible(boolean visible){
    playButton.setVisible(visible);
}
private void pauseButtonVisible(boolean visible){
    pauseButton.setVisible(visible);
}
private void resumeButtonVisible(boolean visible){
    resumeButton.setVisible(visible);
}
private void stopButtonVisible(boolean visible){
    stopButton.setVisible(visible);
}
}//+++++++++++++++++++++++++++++fin de clase MusicPlayer++++++++++++++++++++++++