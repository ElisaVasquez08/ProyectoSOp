/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tuiter;

import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Elisa Vasquez 
 */
public final class CrearCuenta extends javax.swing.JFrame {

  //Declaracion de Variables 
    String Usuario_Ingresado;
    String Contraseña_Ingresada;
    int Click_Nombre;
    int Click_Usuario;
    int Click_Contraseña;
    Usuario User;
    
    
    
  //  private File files = null;

    public CrearCuenta() {
        setIconImage(new ImageIcon(getClass().getResource("/Imagenes del Programa/iconT.png")).getImage());
        initComponents();
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Usuario = new javax.swing.JTextField();
        Genero = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        BotonCrear = new javax.swing.JButton();
        NombreCompleto = new javax.swing.JTextField();
        Contraseña = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        Edad = new javax.swing.JSpinner();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Usuario.setBackground(new java.awt.Color(255, 255, 255));
        Usuario.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 18)); // NOI18N
        Usuario.setForeground(new java.awt.Color(102, 102, 102));
        Usuario.setText("Usuario");
        Usuario.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 51)));
        Usuario.setSelectionColor(new java.awt.Color(102, 102, 102));
        Usuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                UsuarioMouseClicked(evt);
            }
        });
        getContentPane().add(Usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 270, 560, 50));

        Genero.setBackground(new java.awt.Color(255, 255, 255));
        Genero.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        Genero.setForeground(new java.awt.Color(0, 0, 0));
        Genero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "M", "F" }));
        Genero.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Genero.setFocusable(false);
        Genero.setOpaque(false);
        Genero.setRequestFocusEnabled(false);
        getContentPane().add(Genero, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 430, 130, 50));

        jLabel2.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 153, 255));
        jLabel2.setText("¿Ya posees una Cuenta? - Iniciar Sesion");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel2MouseExited(evt);
            }
        });
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 580, -1, -1));

        BotonCrear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes del Programa/BotonCrear.png"))); // NOI18N
        BotonCrear.setBorder(null);
        BotonCrear.setBorderPainted(false);
        BotonCrear.setContentAreaFilled(false);
        BotonCrear.setFocusable(false);
        BotonCrear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BotonCrearMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BotonCrearMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BotonCrearMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                BotonCrearMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                BotonCrearMouseReleased(evt);
            }
        });
        BotonCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonCrearActionPerformed(evt);
            }
        });
        getContentPane().add(BotonCrear, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 500, 500, 60));

        NombreCompleto.setBackground(new java.awt.Color(255, 255, 255));
        NombreCompleto.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 18)); // NOI18N
        NombreCompleto.setForeground(new java.awt.Color(102, 102, 102));
        NombreCompleto.setText("Nombre Completo");
        NombreCompleto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 51)));
        NombreCompleto.setSelectionColor(new java.awt.Color(102, 102, 102));
        NombreCompleto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                NombreCompletoMouseClicked(evt);
            }
        });
        NombreCompleto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NombreCompletoActionPerformed(evt);
            }
        });
        getContentPane().add(NombreCompleto, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 190, 560, 50));

        Contraseña.setBackground(new java.awt.Color(255, 255, 255));
        Contraseña.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 18)); // NOI18N
        Contraseña.setForeground(new java.awt.Color(102, 102, 102));
        Contraseña.setText("Contraseña");
        Contraseña.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 51)));
        Contraseña.setSelectionColor(new java.awt.Color(102, 102, 102));
        Contraseña.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ContraseñaMouseClicked(evt);
            }
        });
        getContentPane().add(Contraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 350, 560, 50));

        jLabel3.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Edad");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 440, 50, 30));

        Edad.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 18)); // NOI18N
        Edad.setModel(new javax.swing.SpinnerNumberModel(1, 1, 100, 1));
        Edad.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 51)));
        getContentPane().add(Edad, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 430, 130, 50));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes del Programa/CrearTuCuenta.png"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 720, 750));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseEntered
        jLabel2.setForeground(new java.awt.Color(51, 204, 255));
    }//GEN-LAST:event_jLabel2MouseEntered

    private void jLabel2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseExited
        jLabel2.setForeground(new java.awt.Color(51, 153, 255));
    }//GEN-LAST:event_jLabel2MouseExited

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked

        Login L = new Login();
        L.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLabel2MouseClicked

    private void UsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UsuarioMouseClicked
        if (Click_Usuario == 0) {
            Usuario.setText("");
            Click_Usuario++;
        }
    }//GEN-LAST:event_UsuarioMouseClicked

    private void BotonCrearMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonCrearMouseEntered
        BotonCrear.setIcon(new ImageIcon("src/Imagenes del Programa/BotonCrearSeleccionado.png"));
    }//GEN-LAST:event_BotonCrearMouseEntered

    private void BotonCrearMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonCrearMouseExited
        BotonCrear.setIcon(new ImageIcon("src/Imagenes del Programa/BotonCrear.png"));
    }//GEN-LAST:event_BotonCrearMouseExited

    private void BotonCrearMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonCrearMousePressed
        BotonCrear.setIcon(new ImageIcon("src/Imagenes del Programa/BotonCrear.png"));
    }//GEN-LAST:event_BotonCrearMousePressed

    private void BotonCrearMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonCrearMouseReleased
        BotonCrear.setIcon(new ImageIcon("src/Imagenes del Programa/BotonCrearSeleccionado.png"));
    }//GEN-LAST:event_BotonCrearMouseReleased

    private void NombreCompletoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NombreCompletoMouseClicked
        if (Click_Nombre == 0) {
            NombreCompleto.setText("");
            Click_Nombre++;
        }
    }//GEN-LAST:event_NombreCompletoMouseClicked

    private void ContraseñaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ContraseñaMouseClicked
        if (Click_Contraseña == 0) {
            Contraseña.setText("");
            Click_Contraseña++;
        }
    }//GEN-LAST:event_ContraseñaMouseClicked

    private void BotonCrearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonCrearMouseClicked
        File NuevoUsuario=new File("src\\Datos del Programa\\" + Usuario.getText());
    try{
        if(NombreCompleto.getText().equals("") || Usuario.getText().equals("") || Contraseña.getText().equals("") || NombreCompleto.getText().equals("Nombre Completo") || Usuario.getText().equals("Usuario") || Contraseña.getText().equals("Contraseña") ){
             throw new NullPointerException("Favor Llenar Todos los Campos de Forma Valida");
            
         
        }else{
            //Valida que la carpeta no exista para que no se creen 2 usuarios iguales ni 2 carpetas iguales
        if(!NuevoUsuario.exists()){
        //RegistroUsuarios.add(new Usuario(NombreCompleto.getText(), Genero.toString().charAt(0), Usuario.getText(), Contraseña.getText(), (int) Edad.getValue(), true));
            System.out.println(Genero.getSelectedItem().toString());
       
            User = new Usuario(NombreCompleto.getText(), Genero.getSelectedItem().toString().charAt(0),Usuario.getText(),Contraseña.getText(), (int) Edad.getValue(), true);
        
            
             Object[] opciones1 = {"Si", "Mas Tarde"};
            int cambio1 = JOptionPane.showOptionDialog(null, "¿Desea Agregar una Imagen Ahora?",
                    "Imagen de Perfil", 0,
                    JOptionPane.QUESTION_MESSAGE, null, opciones1, opciones1[0]);
            switch (cambio1) {
                case 0: {
                   JFileChooser JF = new JFileChooser();
        FileNameExtensionFilter filtrado = new FileNameExtensionFilter("JGP, PNG & GIF", "jpg", "png", "gif");

         JF.setFileFilter(filtrado);
        JF.setMultiSelectionEnabled(false);
        
        if (JF.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            
            rsdragdropfiles.RSDragDropFiles.setCopiar(JF.getSelectedFile().toString(), "src\\Datos del Programa\\" + Usuario.getText() + "\\" + "Perfil");
        }
        }
                break;
                default: {
                }
                break;
            }
            
           
        
        
        
         Object[] opciones = {"SI", "NO"};
            int cambio = JOptionPane.showOptionDialog(null, "¿Desea regresar a Iniciar Sesion?",
                    "Registro", 0,
                    JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
            switch (cambio) {
                case 0: {//VOLVER A INICIO SESION
                     Login L = new Login();
                    L.setVisible(true);
                    this.setVisible(false);
                }
                break;
                default: {//SEGUIR EN CREAR CUENTA
                }
                break;
            }
        
        }else{
            JOptionPane.showMessageDialog(null, "No se Creo el Usuario, ya existe en los Registros del Sistema");
        }
        NombreCompleto.setText("Nombre Completo");
        Usuario.setText("Usuario");
        Contraseña.setText("Contraseña");
        Edad.setValue(1);
        Click_Nombre = 0;
        Click_Contraseña = 0;
        Click_Usuario = 0;

        
 
        }
    }catch(NullPointerException e){
        JOptionPane.showMessageDialog(null, e.getMessage());
    }
    }//GEN-LAST:event_BotonCrearMouseClicked

    private void BotonCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonCrearActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BotonCrearActionPerformed

    private void NombreCompletoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NombreCompletoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NombreCompletoActionPerformed
      
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CrearCuenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CrearCuenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CrearCuenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CrearCuenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CrearCuenta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonCrear;
    private javax.swing.JTextField Contraseña;
    private javax.swing.JSpinner Edad;
    private javax.swing.JComboBox<String> Genero;
    private javax.swing.JTextField NombreCompleto;
    private javax.swing.JTextField Usuario;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}
