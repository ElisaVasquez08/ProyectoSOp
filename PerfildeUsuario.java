/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tuiter;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Elisa Vasquez
 */
public final class PerfildeUsuario extends javax.swing.JFrame {
    //Declaracion de Variables
    RandomAccessFile Twits;
    String UsuarioBuscado;
    Boolean SeSigue;
    RandomAccessFile User;
    RandomAccessFile Follows;
    RandomAccessFile Followers;
    String username;

    CuentaVisitada UsuarioVisitado;

    public PerfildeUsuario(String Info, Boolean SESIGUE, RandomAccessFile twits, String usuarioBuscado, String Username, RandomAccessFile followers) {

        UsuarioVisitado = new CuentaVisitada(Info, SESIGUE, twits, usuarioBuscado, Username, followers);
        setIconImage(new ImageIcon(getClass().getResource("/Imagenes del Programa/iconT.png")).getImage());
        initComponents();
        Image mImagen = new ImageIcon("src\\Datos del Programa\\" + usuarioBuscado + "\\" + "Perfil").getImage();
        ImageIcon mIcono = new ImageIcon(mImagen.getScaledInstance(ImagPerfil.getWidth(), ImagPerfil.getHeight(), Image.SCALE_SMOOTH));
        ImagPerfil.setIcon(mIcono);
        this.setLocationRelativeTo(null);
        username = Username;
        Informacion.setText(Info);

        Twits = twits;
        SeSigue = SESIGUE;
        this.UsuarioBuscado = usuarioBuscado;
        Followers = followers;

        try {
            File files = new File("src\\Datos del Programa");
            files.mkdirs();

            User = new RandomAccessFile("src\\Datos del Programa\\Usuarios.twc", "rw");
            Follows = new RandomAccessFile("src\\Datos del Programa\\" + Username + "\\following.twc", "rw");

        } catch (IOException e) {
            System.out.println("Error ConstructorPerfil");
        }

        if (SeSigue) {
            SeguirBoton.setIcon(new ImageIcon("src/Imagenes del Programa/DejardeSeguir.png"));
        } else {
            SeguirBoton.setIcon(new ImageIcon("src/Imagenes del Programa/Seguir.png"));
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        SeguirBoton = new javax.swing.JButton();
        VerTuits = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        CuadroDeTexto = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        Informacion = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        ImagPerfil = new javax.swing.JLabel();
        Fondo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        SeguirBoton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes del Programa/Seguir.png"))); // NOI18N
        SeguirBoton.setBorder(null);
        SeguirBoton.setBorderPainted(false);
        SeguirBoton.setContentAreaFilled(false);
        SeguirBoton.setFocusPainted(false);
        SeguirBoton.setFocusable(false);
        SeguirBoton.setRequestFocusEnabled(false);
        SeguirBoton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SeguirBotonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SeguirBotonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                SeguirBotonMouseExited(evt);
            }
        });
        getContentPane().add(SeguirBoton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 140, 50));

        VerTuits.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes del Programa/VerTuits.png"))); // NOI18N
        VerTuits.setBorder(null);
        VerTuits.setBorderPainted(false);
        VerTuits.setContentAreaFilled(false);
        VerTuits.setFocusPainted(false);
        VerTuits.setFocusable(false);
        VerTuits.setRequestFocusEnabled(false);
        VerTuits.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                VerTuitsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                VerTuitsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                VerTuitsMouseExited(evt);
            }
        });
        VerTuits.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VerTuitsActionPerformed(evt);
            }
        });
        getContentPane().add(VerTuits, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 190, 140, 50));

        CuadroDeTexto.setEditable(false);
        CuadroDeTexto.setBackground(new java.awt.Color(153, 204, 255));
        CuadroDeTexto.setColumns(20);
        CuadroDeTexto.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        CuadroDeTexto.setForeground(new java.awt.Color(0, 0, 0));
        CuadroDeTexto.setRows(5);
        CuadroDeTexto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 51)));
        jScrollPane1.setViewportView(CuadroDeTexto);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 240, 440, 310));

        Informacion.setEditable(false);
        Informacion.setBackground(new java.awt.Color(153, 204, 255));
        Informacion.setColumns(20);
        Informacion.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
        Informacion.setForeground(new java.awt.Color(0, 0, 0));
        Informacion.setRows(5);
        Informacion.setAutoscrolls(false);
        Informacion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 51)));
        Informacion.setFocusable(false);
        jScrollPane2.setViewportView(Informacion);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, 440, 170));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes del Programa/ImagenC_PerfilDeUsuario.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 160, 150));
        getContentPane().add(ImagPerfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 140, 130));

        Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes del Programa/OtroUsuario - copia.png"))); // NOI18N
        getContentPane().add(Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 590));

        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 260, 50, 30));

        jLabel3.setText("jLabel3");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 255, -1, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SeguirBotonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SeguirBotonMouseClicked
        try {
            if (SeSigue) {
                if (UsuarioVisitado.DejardeSeguir(UsuarioBuscado) && UsuarioVisitado.DejardeSeguirFollower()) {
                    JOptionPane.showMessageDialog(null, "Se dejo de seguir al Usuario");
                    SeguirBoton.setIcon(new ImageIcon("src/Imagenes del Programa/Seguir.png"));
                    SeSigue = false;
                }
            } else {

                boolean T = true;
                Followers.seek(0);
                Follows.seek(0);

                String usuario;
                Boolean Activo;

                String UsuarioFollower;
                Boolean ActivoFollower;

                while (Follows.getFilePointer() < Follows.length()) {

                    usuario = Follows.readUTF();
                    Long Puntero = Follows.getFilePointer();
                    Activo = Follows.readBoolean();

                    if (usuario.equals(UsuarioBuscado) && (Activo == false)) {
                        Follows.seek(Puntero);
                        Follows.writeBoolean(true);
                        JOptionPane.showMessageDialog(null, "Ahora Sigues a Este Usuario");
                        T = false;
                    }

                }
                while (Followers.getFilePointer() < Followers.length()) {

                    UsuarioFollower = Followers.readUTF();
                    Long Puntero = Followers.getFilePointer();
                    ActivoFollower = Followers.readBoolean();

                    if (UsuarioFollower.equals(username) && ActivoFollower) {

                        T = false;
                    } else if (UsuarioFollower.equals(username) && (ActivoFollower == false)) {
                        Followers.seek(Puntero);
                        Followers.writeBoolean(true);

                        T = false;
                    }

                }

                if (T) {
                    Follows.seek(Follows.length());
                    Follows.writeUTF(UsuarioBuscado);
                    Follows.writeBoolean(true);

                    Followers.seek(Followers.length());
                    Followers.writeUTF(username);
                    Followers.writeBoolean(true);

                    JOptionPane.showMessageDialog(null, "Ahora Sigues a Este Usuario");

                }

                SeguirBoton.setIcon(new ImageIcon("src/Imagenes del Programa/DejardeSeguir.png"));
                SeSigue = true;

            }

        } catch (IOException e) {

        }


    }//GEN-LAST:event_SeguirBotonMouseClicked

    private void VerTuitsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_VerTuitsMouseClicked

        try {
            Twits = new RandomAccessFile("src\\Datos del Programa\\" + UsuarioBuscado + "\\" + "twits.twc", "rw");

      
            ArrayList<ControlDeTwits> ListaTemporal = new ArrayList<>();

            
             Collections.sort( UsuarioVisitado.MostrarTwits(ListaTemporal, Twits));
            
        
            String Twiteado = UsuarioVisitado.ImprimirTwits(ListaTemporal,  "",  0);

            CuadroDeTexto.setText(Twiteado);

        } catch (IOException e) {

        }


    }//GEN-LAST:event_VerTuitsMouseClicked

    private void SeguirBotonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SeguirBotonMouseEntered
        if (SeSigue) {
            SeguirBoton.setIcon(new ImageIcon("src/Imagenes del Programa/DejardeSeguir2.png"));
        } else {
            SeguirBoton.setIcon(new ImageIcon("src/Imagenes del Programa/Seguir2.png"));
        }

    }//GEN-LAST:event_SeguirBotonMouseEntered

    private void SeguirBotonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SeguirBotonMouseExited
        if (SeSigue) {
            SeguirBoton.setIcon(new ImageIcon("src/Imagenes del Programa/DejardeSeguir.png"));
        } else {
            SeguirBoton.setIcon(new ImageIcon("src/Imagenes del Programa/Seguir.png"));
        }

    }//GEN-LAST:event_SeguirBotonMouseExited

    private void VerTuitsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_VerTuitsMouseEntered
        VerTuits.setIcon(new ImageIcon("src/Imagenes del Programa/VerTuits2.png"));
    }//GEN-LAST:event_VerTuitsMouseEntered

    private void VerTuitsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_VerTuitsMouseExited
        VerTuits.setIcon(new ImageIcon("src/Imagenes del Programa/VerTuits.png"));
    }//GEN-LAST:event_VerTuitsMouseExited

    private void VerTuitsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VerTuitsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_VerTuitsActionPerformed

   

    
    
    
    

   

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
            java.util.logging.Logger.getLogger(PerfildeUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PerfildeUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PerfildeUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PerfildeUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PerfildeUsuario(null, null, null, null, null, null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea CuadroDeTexto;
    private javax.swing.JLabel Fondo;
    private javax.swing.JLabel ImagPerfil;
    private javax.swing.JTextArea Informacion;
    private javax.swing.JButton SeguirBoton;
    private javax.swing.JButton VerTuits;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
