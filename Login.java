/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tuiter;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Elisa Vasquez 
 */
public final class Login extends javax.swing.JFrame {

    //Declaracion de Variables 
    String Usuario_Ingresado;
    String Contraseña_Ingresada;
    int Click_Usuario;
    int Click_Contraseña;
    private File files;
    RandomAccessFile User;
    
    public Login() {
        
        try {
            files = new File("src\\Datos del Programa");
            files.mkdirs();

            User = new RandomAccessFile("src\\Datos del Programa\\Usuarios.twc", "rw");

        } catch (IOException e) {
            System.out.println("Error");
        }

        setIconImage(new ImageIcon(getClass().getResource("/Imagenes del Programa/iconT.png")).getImage());
        initComponents();
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Usuario = new javax.swing.JTextField();
        Contraseña = new javax.swing.JPasswordField();
        BotonLogin = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

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
        Usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UsuarioActionPerformed(evt);
            }
        });
        getContentPane().add(Usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 210, 420, 50));

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
        Contraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ContraseñaActionPerformed(evt);
            }
        });
        getContentPane().add(Contraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 290, 420, 50));

        BotonLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes del Programa/BotonLogin.png"))); // NOI18N
        BotonLogin.setBorderPainted(false);
        BotonLogin.setContentAreaFilled(false);
        BotonLogin.setFocusPainted(false);
        BotonLogin.setFocusable(false);
        BotonLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BotonLoginMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BotonLoginMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BotonLoginMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                BotonLoginMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                BotonLoginMouseReleased(evt);
            }
        });
        BotonLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonLoginActionPerformed(evt);
            }
        });
        getContentPane().add(BotonLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 390, -1, -1));

        jLabel2.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 153, 255));
        jLabel2.setText("¿No tienes una Cuenta? - Regístrate en Twitter");
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
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 470, 350, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes del Programa/2023-03-19-18-15-17.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-50, -10, 760, 690));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ContraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ContraseñaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ContraseñaActionPerformed

    private void BotonLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonLoginActionPerformed

    }//GEN-LAST:event_BotonLoginActionPerformed

    private void BotonLoginMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonLoginMouseEntered
        BotonLogin.setIcon(new ImageIcon("src/Imagenes del Programa/BotonSeleccionado.png"));
    }//GEN-LAST:event_BotonLoginMouseEntered

    private void BotonLoginMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonLoginMouseExited
        BotonLogin.setIcon(new ImageIcon("src/Imagenes del Programa/BotonLogin.png"));
    }//GEN-LAST:event_BotonLoginMouseExited

    private void BotonLoginMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonLoginMousePressed
        BotonLogin.setIcon(new ImageIcon("src/Imagenes del Programa/BotonLogin.png"));
    }//GEN-LAST:event_BotonLoginMousePressed

    private void BotonLoginMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonLoginMouseReleased
        BotonLogin.setIcon(new ImageIcon("src/Imagenes del Programa/BotonSeleccionado.png"));
    }//GEN-LAST:event_BotonLoginMouseReleased

    private void jLabel2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseEntered
        jLabel2.setForeground(new java.awt.Color(51, 204, 255));
    }//GEN-LAST:event_jLabel2MouseEntered

    private void jLabel2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseExited
        jLabel2.setForeground(new java.awt.Color(51, 153, 255));
    }//GEN-LAST:event_jLabel2MouseExited

    private void UsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UsuarioMouseClicked
        if (Click_Usuario == 0) {
            Usuario.setText("");
            Click_Usuario++;
        }
    }//GEN-LAST:event_UsuarioMouseClicked

    private void ContraseñaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ContraseñaMouseClicked
        if (Click_Contraseña == 0) {
            Contraseña.setText("");
            Click_Contraseña++;
        }
    }//GEN-LAST:event_ContraseñaMouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        CrearCuenta R = new CrearCuenta();
        R.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLabel2MouseClicked

    private void BotonLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonLoginMouseClicked
        Usuario_Ingresado = Usuario.getText();
        Contraseña_Ingresada = Contraseña.getText();
        Usuario.setText(Usuario_Ingresado);
        Contraseña.setText(Contraseña_Ingresada);
        try {
            if (IniciarSesion(Usuario_Ingresado, Contraseña_Ingresada)) {

                MenuPrincipal MP = new MenuPrincipal(Usuario_Ingresado);
                MP.setVisible(true);
                this.setVisible(false);

            } else {
                Object[] opciones = {"REPETIR LOGIN", "CREAR CUENTA"};
                int cambio = JOptionPane.showOptionDialog(null, "¿Que accion desea realizar?",
                        "Los Valores Ingresados no son Validos", 0,
                        JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
                switch (cambio) {
                    case 0: {//Repetir
                        this.setVisible(false);
                        Login L = new Login();
                        L.setVisible(true);

                    }
                    break;
                    default: {//Crear
                        CrearCuenta R = new CrearCuenta();
                        R.setVisible(true);
                        this.setVisible(false);

                    }
                    break;

                }

            }
        } catch (IOException e) {

            System.out.println("ERROR!");
            System.out.println(e);
        }
    }//GEN-LAST:event_BotonLoginMouseClicked

    private void UsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UsuarioActionPerformed
 
    public boolean IniciarSesion(String user, String pass) throws IOException {
       

        User.seek(0);
        String user1, password1;
        while (User.getFilePointer() < User.length()) {

            User.readUTF();
            User.readChar();

            user1 = User.readUTF();
            password1 = User.readUTF();
            
            User.getFilePointer();
            if (user1.equals(user) && password1.equals(pass)) {

                return true;

            }
            User.skipBytes(13);

        }

        return false;

    }

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonLogin;
    private javax.swing.JPasswordField Contraseña;
    private javax.swing.JTextField Usuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables

}
