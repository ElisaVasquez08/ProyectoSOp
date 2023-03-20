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
import java.util.Calendar;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Elisa Vasquez 
 */
public final class Editar_Perfil extends javax.swing.JFrame {
//Declaracion de Variables 
    RandomAccessFile User;
    RandomAccessFile Follows;
    RandomAccessFile Twits;
    RandomAccessFile Followers;
    String username;
    
    private final String Mensaje= "No has Escrito Nada";
    
    int Click_IngresoUsuario;

    public Editar_Perfil(String Username) {
        setIconImage(new ImageIcon(getClass().getResource("/Imagenes del Programa/iconT.png")).getImage());
        initComponents();
        this.setLocationRelativeTo(null);
          
          
        username = Username;
        
        Image mImagen = new ImageIcon("src\\Datos del Programa\\" + username + "\\" + "Perfil").getImage();
        ImageIcon mIcono=new ImageIcon(mImagen.getScaledInstance(IMAGEN.getWidth(), IMAGEN.getHeight(), Image.SCALE_SMOOTH));
        IMAGEN.setIcon(mIcono);
 
        try {
            File files = new File("src\\Datos del Programa");
            files.mkdirs();

            User = new RandomAccessFile("src\\Datos del Programa\\Usuarios.twc", "rw");
            Follows = new RandomAccessFile("src\\Datos del Programa\\" + Username + "\\following.twc", "rw");

            //remps=new RandomAccessFile("company/empleados.emp", "rw");
        } catch (IOException e) {
            System.out.println("Error");
        }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BUSCARUSUARIO = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        AreadeTexto = new javax.swing.JTextArea();
        IngresarUsuario = new javax.swing.JTextField();
        Entrar_Perfil = new javax.swing.JButton();
        BOTONACTIVAR = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        IMAGEN = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BUSCARUSUARIO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes del Programa/Buscar.png"))); // NOI18N
        BUSCARUSUARIO.setBorder(null);
        BUSCARUSUARIO.setBorderPainted(false);
        BUSCARUSUARIO.setContentAreaFilled(false);
        BUSCARUSUARIO.setFocusPainted(false);
        BUSCARUSUARIO.setFocusable(false);
        BUSCARUSUARIO.setRequestFocusEnabled(false);
        BUSCARUSUARIO.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BUSCARUSUARIOMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BUSCARUSUARIOMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BUSCARUSUARIOMouseExited(evt);
            }
        });
        getContentPane().add(BUSCARUSUARIO, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, 300, 50));

        AreadeTexto.setEditable(false);
        AreadeTexto.setBackground(new java.awt.Color(153, 204, 255));
        AreadeTexto.setColumns(20);
        AreadeTexto.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        AreadeTexto.setForeground(new java.awt.Color(0, 0, 0));
        AreadeTexto.setRows(5);
        AreadeTexto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 51)));
        jScrollPane1.setViewportView(AreadeTexto);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 0, 430, 540));

        IngresarUsuario.setText("Ingrese Usuario");
        IngresarUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                IngresarUsuarioMouseClicked(evt);
            }
        });
        getContentPane().add(IngresarUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, 302, 40));

        Entrar_Perfil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes del Programa/Entrar.png"))); // NOI18N
        Entrar_Perfil.setBorder(null);
        Entrar_Perfil.setBorderPainted(false);
        Entrar_Perfil.setContentAreaFilled(false);
        Entrar_Perfil.setFocusPainted(false);
        Entrar_Perfil.setFocusable(false);
        Entrar_Perfil.setRequestFocusEnabled(false);
        Entrar_Perfil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Entrar_PerfilMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Entrar_PerfilMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Entrar_PerfilMouseExited(evt);
            }
        });
        getContentPane().add(Entrar_Perfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 430, 300, -1));

        BOTONACTIVAR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes del Programa/Activar.png"))); // NOI18N
        BOTONACTIVAR.setBorder(null);
        BOTONACTIVAR.setBorderPainted(false);
        BOTONACTIVAR.setContentAreaFilled(false);
        BOTONACTIVAR.setFocusPainted(false);
        BOTONACTIVAR.setFocusable(false);
        BOTONACTIVAR.setRequestFocusEnabled(false);
        BOTONACTIVAR.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BOTONACTIVARMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BOTONACTIVARMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BOTONACTIVARMouseExited(evt);
            }
        });
        getContentPane().add(BOTONACTIVAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 320, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes del Programa/EDITARPERFIL - copia.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 260, -1));
        getContentPane().add(IMAGEN, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 200, 190));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes del Programa/EDITARPERFIL.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 460, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BUSCARUSUARIOMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BUSCARUSUARIOMouseClicked
        String UsuarioBuscado = IngresarUsuario.getText();
        String MostrarUsuarios = "";

        try {
            User.seek(0);

            String user1;

            while (User.getFilePointer() < User.length()) {

                User.readUTF();
                User.readChar();

                user1 = User.readUTF();

                User.readUTF();

                User.skipBytes(12);
                Boolean UsuarioActivo = User.readBoolean();
                if ((user1.contains(UsuarioBuscado) && UsuarioActivo) && !user1.equals(username)) {

                    if (MeSigueONO(user1)) {
                        
                        MostrarUsuarios += user1 + " - "+EsSeguidor.Lo_Sigues+"\n";
                        
                    } else {
                        MostrarUsuarios += user1 + " - "+EsSeguidor.No_Lo_Sigues+"\n";
                     
                    }
                }

            }
        } catch (IOException E) {
            System.out.println("Error Mostrar Usuarios");
        }
        AreadeTexto.setText(MostrarUsuarios);
    }//GEN-LAST:event_BUSCARUSUARIOMouseClicked

    private void Entrar_PerfilMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Entrar_PerfilMouseClicked
String UsuarioBuscado= JOptionPane.showInputDialog(null, "Ingrese el Nombre de Usuario");
        
try{
if(!UsuarioBuscado.equals("")){
    
     String Info = "";
     
        try {
            Followers = new RandomAccessFile("src\\Datos del Programa\\" + UsuarioBuscado + "\\followers.twc", "rw");
            User.seek(0);
            String Nombre;
            char Genero;

            String user1;
            int Edad;

            while (User.getFilePointer() < User.length()) {

                Nombre = User.readUTF();
                Genero = User.readChar();

                user1 = User.readUTF();

                User.readUTF();
                Calendar FechaUsuario = Calendar.getInstance();

                FechaUsuario.setTimeInMillis(User.readLong());
                Edad = User.readInt();
                Boolean Activo = User.readBoolean();

                if ((!user1.equals(username)) && user1.equals(UsuarioBuscado) && Activo) {
                    Info = "Nombre: " + Nombre + "\n"
                            + "Genero: " + Genero + "\n"
                            + "Edad: " + Edad + "\n"
                            + "Fecha de Ingreso: " + FechaUsuario.getTime() + "\n"
                            + "Cantidad de Seguidores: " + CantidaddeFollowers()+ "\n"
                            + "Cantidad de Personas que sigue: " + CantidaddeFollowings(UsuarioBuscado)+ "\n"
                            + SeSigue(UsuarioBuscado) + "\n";

                }

            }

        } catch (IOException E) {
        
        }

          if (!Info.equals("")) {
                    try {
              
                PerfildeUsuario PU  = new PerfildeUsuario(Info, SeSigue(UsuarioBuscado).equals("Se Sigue al Usuario")
                        , Twits, UsuarioBuscado, username, Followers);
                PU.setVisible(true);
               } catch (IOException E) {
                        System.out.println("Error!");
                    }
          } else {
            JOptionPane.showMessageDialog(null, "El Usuario Ingresado no Existe o Esta Desactivado");
        }
        
}else{
       throw new NullPointerException(Mensaje);
}
}catch(NullPointerException e){
     if (e.getMessage()==null) {
                        JOptionPane.showMessageDialog(null, Mensaje);
                    } else {
                         JOptionPane.showMessageDialog(null, e.getMessage());
                    }
}
       
        
    }//GEN-LAST:event_Entrar_PerfilMouseClicked


  
    private void BOTONACTIVARMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BOTONACTIVARMouseClicked

        try {
            User.seek(0);

            String user1;

            while (User.getFilePointer() < User.length()) {

                User.readUTF();
                User.readChar();

                user1 = User.readUTF();

                User.readUTF();

                User.skipBytes(12);
                Long Puntero = User.getFilePointer();
                Boolean UsuarioActivo = User.readBoolean();
                if (user1.equals(username) && UsuarioActivo) {

                    Object[] opciones = {"SI ", "NO"};
                    int cambio = JOptionPane.showOptionDialog(null, "¿Desea Desactivar su Cuenta?",
                            "", 0,
                            JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
                    switch (cambio) {
                        case 0: {
                            User.seek(Puntero);
                            User.writeBoolean(false);
                            JOptionPane.showMessageDialog(null, "El usuario se Desactivo");

                        }
                        break;
                        default: {
                        }
                        break;
                    }

                    break;
                } else if (user1.equals(username)) {
                    User.seek(Puntero);
                    User.writeBoolean(true);
                    
                    
                    
                    
                    
                    JOptionPane.showMessageDialog(null, "El usuario se Activo");

                    break;
                }

            }
        } catch (IOException E) {
            System.out.println("Error Mostrar Usuarios");
        }


    }//GEN-LAST:event_BOTONACTIVARMouseClicked

    private void BOTONACTIVARMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BOTONACTIVARMouseEntered
    BOTONACTIVAR.setIcon(new ImageIcon("src/Imagenes del Programa/Activar2.png"));
    }//GEN-LAST:event_BOTONACTIVARMouseEntered

    private void BOTONACTIVARMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BOTONACTIVARMouseExited
        BOTONACTIVAR.setIcon(new ImageIcon("src/Imagenes del Programa/Activar.png"));
    }//GEN-LAST:event_BOTONACTIVARMouseExited

    private void BUSCARUSUARIOMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BUSCARUSUARIOMouseEntered
      BUSCARUSUARIO.setIcon(new ImageIcon("src/Imagenes del Programa/Buscar2.png"));
    }//GEN-LAST:event_BUSCARUSUARIOMouseEntered

    private void BUSCARUSUARIOMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BUSCARUSUARIOMouseExited
      BUSCARUSUARIO.setIcon(new ImageIcon("src/Imagenes del Programa/Buscar.png"));
    }//GEN-LAST:event_BUSCARUSUARIOMouseExited

    private void Entrar_PerfilMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Entrar_PerfilMouseEntered
    Entrar_Perfil.setIcon(new ImageIcon("src/Imagenes del Programa/Entrar2.png"));
    }//GEN-LAST:event_Entrar_PerfilMouseEntered

    private void Entrar_PerfilMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Entrar_PerfilMouseExited
        Entrar_Perfil.setIcon(new ImageIcon("src/Imagenes del Programa/Entrar.png"));
    }//GEN-LAST:event_Entrar_PerfilMouseExited

    private void IngresarUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_IngresarUsuarioMouseClicked
        if (Click_IngresoUsuario == 0) {
           IngresarUsuario.setText("");
            Click_IngresoUsuario++;
        }
        
      
    }//GEN-LAST:event_IngresarUsuarioMouseClicked

    public boolean MeSigueONO(String Usuario) throws IOException {
        String MESIGUE;
        Boolean ME;
        Follows.seek(0);
        while (Follows.getFilePointer() < Follows.length()) {

            MESIGUE = Follows.readUTF();
            ME = Follows.readBoolean();
            if (Usuario.contains(MESIGUE)) {
                return ME;
            }

        }

        return false;

    }
    
     public String SeSigue(String UsuarioBuscado) throws IOException {
        Follows.seek(0);

        String usuario;
        Boolean Activo;

        while (Follows.getFilePointer() < Follows.length()) {

            usuario = Follows.readUTF();
            Activo = Follows.readBoolean();

            if (usuario.equals(UsuarioBuscado) && Activo) {
                return "Se Sigue al Usuario";
            }

        }
        return "No se sigue al Usuario";
    }
    
    public int CantidaddeFollowers()throws IOException {
         Followers.seek(0);
int CantidadFollowers=0;
  
        Boolean Activo;

        while (Followers.getFilePointer() < Followers.length()) {

         Followers.readUTF();
            Activo = Followers.readBoolean();
           if(Activo){
                CantidadFollowers++;
           }
           

        }
     return CantidadFollowers;
    }
    
     public int CantidaddeFollowings(String Username)throws IOException {
   RandomAccessFile Followed = new RandomAccessFile("src\\Datos del Programa\\" + Username + "\\following.twc", "rw");
         
         Followed.seek(0);
int CantidadFollowings=0;
        Boolean Activo;

        while (Followed.getFilePointer() < Followed.length()) {

         Followed.readUTF();
            Activo = Followed.readBoolean();
           if(Activo){
                CantidadFollowings++;
           }
           

        }
     return CantidadFollowings;
    }

     
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
            java.util.logging.Logger.getLogger(Editar_Perfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Editar_Perfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Editar_Perfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Editar_Perfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Editar_Perfil(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea AreadeTexto;
    private javax.swing.JButton BOTONACTIVAR;
    private javax.swing.JButton BUSCARUSUARIO;
    private javax.swing.JButton Entrar_Perfil;
    private javax.swing.JLabel IMAGEN;
    private javax.swing.JTextField IngresarUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
