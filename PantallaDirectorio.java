    package subDirs.pantalla;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Comparator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.tree.DefaultMutableTreeNode;
import subDirs.jtree.DirectoryTree;
import usuarios.Constants;
import usuarios.modelo_datos.Usuario;


public final class PantallaDirectorio extends JDialog implements Constants
{
    private String path_inicial=null;
    private DirectoryTree dirTree=null;
    private JButton jButtonCrearDirectorio=new JButton("CreaDir");
    private JButton jButtonRenombrar=new JButton("Renombrar");
    private JButton jButtonCopiar=new JButton("Copiar");
    private JButton jButtonPegar=new JButton("Pegar");
    private JButton jButtonBorrar=new JButton("Borrar");
    private boolean copia_activada=false;
    private DefaultMutableTreeNode nodo_copiado=null;
    private boolean isMyDocs = false;
    private Usuario user;
    
    public boolean isCopia_activada() {
        return copia_activada;
    }
    
    
    public PantallaDirectorio(boolean isMyD, Usuario u, JFrame parent)
    {
        super(parent); // JDialog restringe el uso de otras cosas cuando un "hijo" esta activo
        this.setModal( true ); // Hace que los "hijos" de los "hijos" sigan la misma dinamica
        this.isMyDocs = isMyD;
        this.user = u;
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Directorios JTree");
        this.setSize(1300,900);
        this.setLocation(0,0);
        this.getContentPane().setLayout(new BorderLayout());
        //---------------------N o r t e ---------------------------------------
        JLabel jLabelRotulo=new JLabel("Directorios usando JTree");
        jLabelRotulo.setFont(new Font("Arial", Font.BOLD, 24));
        jLabelRotulo.setHorizontalAlignment(JLabel.CENTER);
        this.getContentPane().add(jLabelRotulo,BorderLayout.NORTH);
        //---------------------O e s t e----------------------------------------
        JPanel panel_west=new JPanel(new GridLayout(9,0));
        panel_west.add(new JLabel());
        panel_west.add(this.jButtonCrearDirectorio);
        panel_west.add(new JLabel());
        panel_west.add(this.jButtonRenombrar);
        panel_west.add(new JLabel());
        panel_west.add(this.jButtonCopiar);
        panel_west.add(new JLabel());
        panel_west.add(this.jButtonPegar);
        panel_west.add(new JLabel());
        panel_west.add(this.jButtonBorrar);
        this.getContentPane().add(panel_west, BorderLayout.WEST);
        //------------------C e n t r o-----------------------------------------
        JPanel panel_dir=new JPanel();
        JScrollPane panel_centro=new JScrollPane(panel_dir);
        this.getContentPane().add(panel_centro,BorderLayout.CENTER);
        //----------------------------------------------------------------------
        if (!isMyDocs){
            pide_path(panel_dir);//invoca a dirTree=new DirectoryTree(this.path_inicial,this);
        }else
        {
            invoca_MisDocs(panel_dir);
        }
        
        //--------------------addListeners--------------------------------------
        //----------------------------------------------------------------------
        this.jButtonCrearDirectorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DefaultMutableTreeNode nodo_seleccionado=
                            (DefaultMutableTreeNode)dirTree
                                            .getTree().getSelectionPath()
                                                        .getLastPathComponent();
                if (nodo_seleccionado!=null){
                    String nombre_nuevo_dir=JOptionPane.showInputDialog(null, 
                            "Nombre Del Nuevo Directorio", "Nuevo Directorio", 
                                                  JOptionPane.QUESTION_MESSAGE);
                    if (nombre_nuevo_dir!=null && nombre_nuevo_dir.length()>0){
                        File fileDir=new File(nodo_seleccionado.getUserObject().toString());
                        if (!fileDir.isDirectory()){
                            JOptionPane.showMessageDialog(null, 
                                      "Elemento Seleccionado No es Directorio");
                            return;
                        }
                        
                        File fileDirNew=new File(
                                       fileDir.getPath()+"//"+nombre_nuevo_dir);
                        try{
                            fileDirNew.mkdir();
                        }catch(Exception e){
                            JOptionPane.showMessageDialog(null, e);
                            return;
                        }
                        
                        DefaultMutableTreeNode nuevo_nodo=
                                   new DefaultMutableTreeNode(
                                                          fileDirNew.getPath());
                        dirTree.getModel()
                                .insertNodeInto(nuevo_nodo, 
                                        nodo_seleccionado, 
                                             nodo_seleccionado.getChildCount());
                       
                    }//if (nombre_nuevo_dir!=null
                }//if (nodo!=null)
            }//actionPerformed
        });
        //----------------------------------------------------------------------
        this.jButtonCopiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DefaultMutableTreeNode nodo_seleccionado=
                            (DefaultMutableTreeNode)dirTree
                                            .getTree().getSelectionPath()
                                                        .getLastPathComponent();
                if (nodo_seleccionado!=null){
                    nodo_copiado=nodo_seleccionado;
                }
                //--------------------------------------------------------------
                copia_activada=true;
                botones_visibles(false);
            }
        });
        //----------------------------------------------------------------------
        this.jButtonPegar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DefaultMutableTreeNode nodo_seleccionado=
                            (DefaultMutableTreeNode)dirTree
                                            .getTree().getSelectionPath()
                                                        .getLastPathComponent();
                if (nodo_seleccionado!=null){
                    File dir_destino=new File(nodo_seleccionado.getUserObject().toString());
                    if (!dir_destino.isDirectory()){
                        JOptionPane.showMessageDialog(null, 
                                         "Nodo Selecccionado No es Directorio");
                        return;
                    }
                    
                    File file_copiado=new File(nodo_copiado.getUserObject().toString());
                    /*if (!file_copiado.exists()){
                        JOptionPane.showMessageDialog(null, 
                                                      "file_copiado no existe");
                        return;
                    }*/
                    
                    File file_destino=new File(
                            nodo_seleccionado.getUserObject().toString()+"\\"
                                                       +file_copiado.getName());
                    
                    try {
                        copyDir(file_copiado.toPath(), file_destino.toPath());
                        dirTree.getModel().insertNodeInto(
                                nodo_copiado, 
                                        nodo_seleccionado, 
                                             nodo_seleccionado.getChildCount());
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(null, ex);
                    }
                    
                    
                }//if (nodo_seleccionado!=null){
                //--------------------------------------------------------------
                copia_activada=false;
                nodo_copiado=null;
                botones_visibles(true);
                boton_pegar_visible(false);
            }//actionPerformed
        });
        //----------------------------------------------------------------------
        this.jButtonBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                
                DefaultMutableTreeNode nodo_seleccionado=
                            (DefaultMutableTreeNode)dirTree
                                            .getTree().getSelectionPath()
                                                        .getLastPathComponent();
                int opcion=JOptionPane.showConfirmDialog(null, 
                            "Borrar "+nodo_seleccionado.getUserObject(), 
                                           "Borrar", JOptionPane.YES_NO_OPTION);
                if (opcion!=0){
                    return;
                }
                
                File file_delete=
                        new File(nodo_seleccionado.getUserObject().toString());
                try {
                    delDir(file_delete.toPath());
                    dirTree.getModel().removeNodeFromParent(nodo_seleccionado);
                } catch (IOException ex) {
                    System.out.println("file_delete / jButtonBorrar.actionPerformed "+ex);
                    return;
                }
                
                if (nodo_seleccionado != null) {
                    
                    try {
                        dirTree.getModel()
                                .removeNodeFromParent(nodo_seleccionado);
                        
                    } catch (Exception e) {
                        System.out.println("dirTree.getModel / jButtonBorrar.actionPerformed " + e);
                    }
                    botones_visibles(false);
                    //if (contenido_nuevo_nodo!=null
                }//if (nodo!=null)
                //--------------------------------------------------------------
                botones_visibles(false);
            }
        });
        //----------------------------------------------------------------------
        copia_activada=false;
        //----------------------------------------------------------------------
        botones_visibles(false);

        // Boton renombrar -----------------------------------------------------
        this.jButtonRenombrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DefaultMutableTreeNode nodo_seleccionado
                        = (DefaultMutableTreeNode) dirTree
                                .getTree().getSelectionPath()
                                .getLastPathComponent();
                if (nodo_seleccionado != null) {
                    File file2rename = new File(nodo_seleccionado.getUserObject().toString());
                    String newName = JOptionPane.showInputDialog(null, "Ingrese un nuevo nombre: "
                            ,nodo_seleccionado.getUserObject().toString(), 
                                                  JOptionPane.QUESTION_MESSAGE);
                    File renamedFile = new File(file2rename.getParent() + "\\" + newName);
                    boolean success = file2rename.renameTo(renamedFile);
                    if (success) {
                        System.out.println("File Rename successfuly");
                    } else {
                        System.out.println("File is not Rename");
                    }
                    if (success) {
                        if (nodo_seleccionado != null) {

                            if (newName != null
                                    && newName.length() > 0) {
                                nodo_seleccionado.setUserObject(newName);
                                dirTree.getModel().nodeChanged(nodo_seleccionado);
                            }//if (nuevo_contenido!=null
                        }//if (nodo!=null)
                    }
                }
                //--------------------------------------------------------------
                
                
            }
        });
        //----------------------------------------------------------------------
    }//constructor PantallaDirectorio()
    
    private void pide_path(JPanel panel_dir){
        JFileChooser chooser=new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        int returnVal = chooser.showOpenDialog(this/*parent*/);
        if(returnVal == JFileChooser.APPROVE_OPTION) {
            File fileChosed=chooser.getSelectedFile();
            System.out.println("You chose to open this file: " +fileChosed.getPath());
            this.path_inicial=fileChosed.getPath();
            dirTree=new DirectoryTree(this.path_inicial,this);
            
            panel_dir.add(dirTree.getTree());
            this.repaint();
            this.revalidate();
        }//if(returnVal == JFileChooser.APPROVE_OPTION) 
        
    }//pide_path()
    
    private void invoca_MisDocs(JPanel panel_dir)
    {
        dirTree = new DirectoryTree(drive + user.getId().trim(), this);
        panel_dir.add(dirTree.getTree());
        this.repaint();
        this.revalidate();

    }
    
    public void botones_visibles(boolean v){
        this.jButtonCrearDirectorio.setVisible(v);
        this.jButtonRenombrar.setVisible(v);
        this.jButtonCopiar.setVisible(v);
        this.jButtonPegar.setVisible(v);
        this.jButtonBorrar.setVisible(v);
    }//botones_visibles
    
    public void boton_crear_directorio_visible(boolean v){
        this.jButtonCrearDirectorio.setVisible(v);
    }//boton_crear_directorio_visible(boolean v)
    
    public void boton_copiar_visible(boolean v){
        this.jButtonCopiar.setVisible(v);
    }//boton_copiar_visible
    
    public void boton_pegar_visible(boolean v){
        this.jButtonPegar.setVisible(v);
    }//boton_pegar_visible
    
    public void copyDir(Path src, Path dest) throws IOException {
        
        Files.walk(src)
                .forEach(source -> {
                    try {
                        Files.copy(source, dest.resolve(src.relativize(source)),
                                        StandardCopyOption.REPLACE_EXISTING);
                        
                    } catch (IOException e) {
                        e.printStackTrace();
                        
                    }
                });
       
    }//copyDir

    public void delDir(Path directory) throws IOException
    {
        //Recorre el directorio borrando archivo por archivo
        Files.walk(directory) 
            .sorted(Comparator.reverseOrder())
            .map(Path::toFile)
            .forEach(File::delete);
        //Al finalizar borra el dir
    }
    
    
    
}//**********************Fin de clase PantallaDirectorio************************
