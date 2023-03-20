package JtextEditor.pantalla;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JTextPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.EditorKit;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;


public class JFrameEditor extends JFrame{
    private JTextPane jtextpane=null;
    private JButton jButtonGrabar=new JButton("Save");
    private JButton jButtonCambiarFont=new JButton("Font");
    private JComboBox jComboBoxFont=new JComboBox();
    private JComboBox jComboBoxStyle=new JComboBox();
    //private String[] stylesArray = new String[]{"Arial", "Courier New", "Verdana"};
    private String[] fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
    private String ruta_archivo=null;
    private String directorio_default = null;
    private JButton loadFileButton = new JButton("Load");
    private JButton saveAsButton = new JButton("Save As");
    private JButton colorChooser = new JButton("Color");
    private Color chosenColor = Color.black;
    private JButton chosenColorButton = new JButton();
    
    public JFrameEditor(String defaultPath)
    {
        this.directorio_default = defaultPath;
        jtextpane=new JTextPane();
        jtextpane.setContentType("text/html");
        jtextpane.setEnabled(true);
        inicializa_componentes();
        //ruta_archivo="C:\\Users\\smnsl\\OneDrive\\Documentos\\NetBeansProjects\\JTextPaneProyect\\estructura_html.html";
        
        //carga_archivoURL("./3 estructura_html.html");
    }//constructor JFrameEditor

    private void inicializa_componentes(){
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(1300,800);
        this.setLocation(0,0);
        this.setTitle("JTextPane");
        this.getContentPane().setLayout(new BorderLayout());
        //--------------------N o r t e-----------------------------------------
        JPanel panel_norte = new JPanel(new BorderLayout());
        JLabel rotulo = new JLabel("Editor de texto");
        rotulo.setForeground(Color.BLACK);
            rotulo.setFont(new Font("Franklin Gothic Heavy", Font.BOLD, 30));
        rotulo.setHorizontalAlignment(JLabel.CENTER);
        panel_norte.add(rotulo, BorderLayout.NORTH);
        //----------------------------------------------------------------------
        JPanel panel_botones=new JPanel(new GridLayout(0,15));
        //----------------------------------------------------------------------
        jButtonGrabar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                int opcion=JOptionPane.showConfirmDialog(null,
                        "Desea Grabar Archivo",
                                            "Grabar",JOptionPane.YES_NO_OPTION);
                if (opcion==0){
                    grabar(true);
                }
            }
        });
        //----------------------------------------------------------------------
        saveAsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                int opcion=JOptionPane.showConfirmDialog(null,
                        "Desea Grabar Archivo",
                                            "Grabar",JOptionPane.YES_NO_OPTION);
                if (opcion==0){
                    SaveFileAs();
                }
            }
        });
        //----------------------------------------------------------------------
        loadFileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) 
            {
                leerArchivo();
            }
        });
        //----------------------------------------------------------------------
        jComboBoxStyle.setFont(new Font("Arial",0,14));
        for (int i = 0; i < fonts.length ; i++) 
        {
            jComboBoxStyle.addItem(fonts[i]);
        }
        
        //----------------------------------------------------------------------
        jComboBoxFont.setFont(new Font("Arial",0,14));
        for (int i = 8; i < 50; i++) 
        {
            jComboBoxFont.addItem(""+i);
            
        }
        
        chosenColorButton.setBackground(chosenColor);
        
        //----------------------------------------------------------------------
        jButtonCambiarFont.setBackground(Color.magenta);
        jButtonCambiarFont.setForeground(Color.yellow);
        jButtonCambiarFont.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cambiarFont();
            }
        });
        
        //----------------------------------------------------------------------
        colorChooser.setBackground(Color.CYAN);
        colorChooser.setForeground(Color.ORANGE);
        colorChooser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chooseColor();
            }
        });
        //----------------------------------------------------------------------        
        panel_botones.add(new JLabel());
        panel_botones.add(loadFileButton);
        panel_botones.add(jButtonGrabar);
        panel_botones.add(saveAsButton);
        panel_botones.add(new JLabel());
        panel_botones.add(chosenColorButton);
        panel_botones.add(colorChooser);
        panel_botones.add(new JLabel());
        panel_botones.add(new JLabel());
        panel_botones.add(jComboBoxStyle);
        panel_botones.add(jComboBoxFont);
        panel_botones.add(jButtonCambiarFont);
        panel_botones.add(new JLabel());
        
        panel_norte.add(panel_botones, BorderLayout.CENTER);
        this.getContentPane().add(panel_norte,BorderLayout.NORTH);
        //-------------------C e n t r o----------------------------------------
        this.getContentPane().add(jtextpane,BorderLayout.CENTER);
    }//inicializa_componentes
    
    private void carga_archivo(File file){
        jtextpane.setContentType("text/html");
        FileReader reader=null;
        try {
            reader = new FileReader(file);
        } catch (FileNotFoundException ex) {
            System.out.println("carga_archivo() "+file.getName()+" No encontrado "+ex);
        }catch (HeadlessException ex) {
            System.out.println("carga_archivo() "+file.getName()+" Sin <HEAD></HEAD> "+ex);
        }
        if (reader==null){
            System.out.println("carga_archivo htmlFilename es null "+ file.getName());
            return;
        }
        BufferedReader br = new BufferedReader(reader);
        EditorKit kit = jtextpane.getUI().getEditorKit(jtextpane);
        Document doc = jtextpane.getDocument();
        try {
            kit.read(br, doc, doc.getLength());
        } catch (IOException ex) {
            System.out.println("IOException kit.read "+ex);
            Logger.getLogger(JFrameEditor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BadLocationException ex) {
            System.out.println("BadLocationException kit.read "+ex);
            Logger.getLogger(JFrameEditor.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            br.close();
        } catch (IOException ex) {
            Logger.getLogger(JFrameEditor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//carga_archivo
    
    private void grabar(boolean firstTime){
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("\n\n\n\n");
        System.out.println("++++++++++++++Contenido de Archivo+++++++++++++++");
        System.out.println("\n\n");
        ByteArrayOutputStream objetoByteArrayOutputStream = new ByteArrayOutputStream();
        HTMLEditorKit kithtml=(HTMLEditorKit)jtextpane.getEditorKit();
        //----------------------------------------------------------------------
        try {//llena objetoByteArrayOutputStream con jtextpane.getDocument() desde 0 hasta el tamaño del Documento
            kithtml.write(objetoByteArrayOutputStream, jtextpane.getDocument(), 0, jtextpane.getDocument().getLength());
        } catch (IOException ex) {
            Logger.getLogger(JFrameEditor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BadLocationException ex) {
            Logger.getLogger(JFrameEditor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
       
        //=======================Crear archivo de Escritura=====================
        OutputStream os;
        Writer writer;
        BufferedWriter outfile=null;
        if (!firstTime)
        {
            File existenteFile = new File(ruta_archivo);
            if (existenteFile != null && existenteFile.exists()) {
                int option = JOptionPane.showConfirmDialog(null,
                        existenteFile.getName() + " ya existe. "
                                + "Desea sobreescribir?", " Sobreesribir?",JOptionPane.YES_NO_OPTION);
                if (option == 1)
                {
                    return;
                }
            }
            
        }
        
        try { 
            os = new BufferedOutputStream(new FileOutputStream(ruta_archivo));
            writer = new OutputStreamWriter(os, "UTF-8");
            outfile= new BufferedWriter(writer); 
        }
        catch (IOException e) { 
            System.out.println("\n\n");
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println("No pudo crear "+ruta_archivo);
            System.out.println(e);
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println("\n\n");
            return;
        }//catch (IOException e) No pudo crear
        
        //objetoByteArrayOutputStream.toByteArray();
        
        System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||");
        String str=objetoByteArrayOutputStream.toString();
        byte[] byte_array=str.getBytes();
        StringBuilder sb=new StringBuilder();
        try {
            //=====================Grabar en archivo de Escritura===================
            for (int i = 0; i < byte_array.length; i++) {
                byte byteChar = byte_array[i];
                Character caracter=(char) byteChar;
                System.out.println(caracter+" "+byteChar);
                sb.append(caracter);
                if (byteChar==10){
                    System.out.println(sb);
                    outfile.write(sb.toString());
                    outfile.newLine();  
                    sb.setLength(0);
                    i++;//salta el caracter 10
                }
            }//for (int i = 0; i < byte_array.length; i++) {
            outfile.write(sb.toString()); //graba el ultimo renglon
            outfile.newLine();
            sb.setLength(0);
            
        } catch (IOException ex) {
            System.out.println("\n\n");
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println("No pudo hacer el write en "+ruta_archivo);
            System.out.println(ex);
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println("\n\n");
            JOptionPane.showMessageDialog(null, ruta_archivo + " No se pudo crear el archivo.");
            return;

        }
        //=======================Cerrar archivo de Escritura=====================
        try{
            outfile.flush();
            outfile.close();
            JOptionPane.showMessageDialog(null, ruta_archivo + " Archivo guardado exitosamente.");
        }catch (IOException e) { 
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println("No pudo cerrar "+ruta_archivo);
            System.out.println(e);
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");
            JOptionPane.showMessageDialog(null, ruta_archivo + " No se pudo guardar el archivo");

            return;
        }//catch (IOException e) No pudo cerrar
    }//grabar
    
    private void cambiarFont(){
        int posicionInicial=jtextpane.getSelectionStart();
        int posicionFinal=jtextpane.getSelectionEnd();
        int fontSize=Integer.parseInt(jComboBoxFont.getSelectedItem().toString());
        System.out.println("posicionInicial="+posicionInicial
                +" posicionFinal="+posicionFinal+" fontSize="+fontSize);
        SimpleAttributeSet atributo = new SimpleAttributeSet();
        StyleConstants.setFontSize(atributo,fontSize);
        StyleConstants.setFontFamily(atributo, fonts[jComboBoxStyle.getSelectedIndex()]);
        StyleConstants.setForeground(atributo, chosenColor);
        
        
        //----------------------------------------------------------------------
        if (posicionInicial==posicionFinal){
            //---------------No me sirve lo cambia al contenido del documento
            //jtextpane.putClientProperty(JTextPane.HONOR_DISPLAY_PROPERTIES, Boolean.TRUE);
            //jtextpane.setFont(new Font("Arial",0,fontSize));
            //---------------No me sirve lo cambia al contenido del documento
            //String bodyRule = "body { font-family: " + "Arial" + "; " +
            //"font-size: " + fontSize + "pt; }";
            //((HTMLDocument)jtextpane.getDocument()).getStyleSheet().addRule(bodyRule);
            
            StyledDocument doc = jtextpane.getStyledDocument();
            try
            {
                final String texto_nuevo_font="New Font";
                doc.insertString(posicionInicial,texto_nuevo_font , null );
                doc.setCharacterAttributes(
                    posicionInicial, texto_nuevo_font.length(),atributo,false);
            }
            catch(Exception e) { System.out.println(e); }
        }else{
            //------------------------------------------------------------------
            jtextpane.getStyledDocument().setCharacterAttributes(
                    posicionInicial,posicionFinal-posicionInicial,atributo,false);
        }
    }//cambiarFont()
    
    private void SaveFileAs()
    {
        
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(directorio_default));
        
        fileChooser.setDialogTitle("Seleccione el directorio donde guardar el archivo");
        
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) 
        {
            String directory = fileChooser.getSelectedFile().getPath();
            //JOptionPane.showMessageDialog(null, "Dir selected" + directorio_default);
            String savedAsName = JOptionPane.showInputDialog(null, "Nombre del Archivo? ");
            
            if (savedAsName != null) {
                ruta_archivo = directory + "\\" + savedAsName;
                grabar(false);
            }
        }
 
    }
    private void leerArchivo()
    {
        
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(directorio_default));

        fileChooser.setDialogTitle("Seleccione archivo a cargar");
        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File myFile = fileChooser.getSelectedFile();
            directorio_default = fileChooser.getSelectedFile().getPath();
            JOptionPane.showMessageDialog(null, "Dir selected" + directorio_default);
            carga_archivo(myFile);
            ruta_archivo = myFile.getPath();
            
        }
 
    }
    
    private void chooseColor()
    {
        
        JColorChooser colorChooser = new JColorChooser();

        chosenColor = colorChooser.showDialog(null, "Choose a color", Color.black);
        chosenColorButton.setBackground(chosenColor);
        repaint();
        revalidate();

    }
}//**********************fin de clase JFrameEditor******************************
