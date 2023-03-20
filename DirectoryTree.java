package subDirs.jtree;

import java.io.File;
import javax.swing.JOptionPane;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import subDirs.pantalla.PantallaDirectorio;



public class DirectoryTree
{
    private String path_inicial=null;
    private DefaultMutableTreeNode root;
    private DefaultTreeModel model;
    private JTree dirTree;
    private PantallaDirectorio screenDir=null;
   
    
    public DirectoryTree(String path, PantallaDirectorio s){//constructor
        this.path_inicial=path;
        this.screenDir=s;
        inicializa_jtree();
    }//constructor DirectoryTree()

    public DefaultTreeModel getModel() {
        return model;
    }

    
    
    private void inicializa_jtree(){
        System.out.println("inicializa_jtree()");
        this.root=new DefaultMutableTreeNode(this.path_inicial);
        this.model=new DefaultTreeModel(root);
        addDirectorios(path_inicial,root);
        this.dirTree=new JTree(model);
        this.dirTree.addTreeSelectionListener(new Evento());
        System.out.println("-------------------------------------------------");
    }//inicializa_jtree

    private void addDirectorios(String path, DefaultMutableTreeNode nodoRaiz){
        File file=new File(path);
        File[] fileList=file.listFiles();
        for (int i = 0; fileList!=null && i < fileList.length; i++) {
            File fileCiclo = fileList[i];
            if (fileCiclo.isHidden()){
                continue;
            }
            if (fileCiclo.isDirectory()){
                System.out.println(fileCiclo.getName()+"<SUBDIR>");
                DefaultMutableTreeNode nodoCiclo = new DefaultMutableTreeNode(fileCiclo.getPath());
                addDirectorios(fileCiclo.getPath(), nodoCiclo);
                //nodoRaiz.add(nodoCiclo);
                //--------------------------------------------------------------
                model.insertNodeInto(nodoCiclo, 
                                                nodoRaiz, 
                                                      nodoRaiz.getChildCount());
            }else{
                System.out.println(fileCiclo.getName());
                DefaultMutableTreeNode nodoCiclo=
                                    new DefaultMutableTreeNode(fileCiclo.getPath());
                //nodoRaiz.add(nodoCiclo);
                model.insertNodeInto(nodoCiclo, 
                                                nodoRaiz, 
                                                      nodoRaiz.getChildCount());
            }
        }//for (int i = 0; i < fileList.length; i++) 
    }//addDirectoriosOriginal
        
    /* Devuelve el JTree para poder pasarlo como un JComponent */
    public JTree getTree(){
        return this.dirTree;
    }//getTree   
    

    private class Evento implements TreeSelectionListener
    {
        private Evento()
        {
            
        }
        
        @Override
        public void valueChanged(TreeSelectionEvent e) 
        {
            if (e.getSource() == dirTree && e.getNewLeadSelectionPath() !=null ) {

            DefaultMutableTreeNode nodo_seleccionado = 
                    (DefaultMutableTreeNode)e.getNewLeadSelectionPath()
                                                        .getLastPathComponent();
            File file_seleccionado=new File(nodo_seleccionado
                                                   .getUserObject().toString());
            if (file_seleccionado==null){
                JOptionPane.showMessageDialog(null,"file_seleccionado es null");
                return;
            }
            screenDir.botones_visibles(true);
            if (screenDir.isCopia_activada()){
                screenDir.botones_visibles(false);
                if (file_seleccionado.isDirectory()){
                    screenDir.boton_pegar_visible(true);
                }
            }else{//copia NO activada
                screenDir.boton_pegar_visible(false);
            }
            File file=new File(nodo_seleccionado.getUserObject().toString());
            if (!file.isDirectory()){
                screenDir.boton_crear_directorio_visible(false);
            }
            
            }
        }//public void valueChanged(TreeSelectionEvent e) 
        
    }//*************************fin de la clase Evento**************************

}//**************************fin de clase DirectoryTree*************************
