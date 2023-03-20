
package photoViewer.photoHandler;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PeticionDeDatos 
{
    private String path_inicial = null;
    
    
    public File pide_path(JFrame pantalla) 
    {
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int returnVal = chooser.showOpenDialog(pantalla/*parent*/);
        if (returnVal == JFileChooser.APPROVE_OPTION) 
        {
            File fileChosed = chooser.getSelectedFile();
            System.out.println("You chose to open this file: " + fileChosed.getPath());
            this.path_inicial = fileChosed.getPath();
            
            File dirs = new File(path_inicial);
            
            if (dirs == null || dirs.listFiles().length <= 0) 
            {
                JOptionPane.showMessageDialog(null, "Directorio vacio.");
                return null;
            }
            
            return dirs;
        }//if(returnVal == JFileChooser.APPROVE_OPTION) 
        return null;
    }//pide_path()
}
