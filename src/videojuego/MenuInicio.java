/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package videojuego;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;

/**
 *
 * @author Juan
 */
public class MenuInicio extends javax.swing.JFrame implements KeyListener, ActionListener, Runnable {

    /**
     * Creates new form MenuInicio
     */
    
    private Image img;
    public Font letra;
    public int tamaño = 20;
    public static VentanaJuego ventana;
   
   public MenuInicio(){
   initComponents();   
   estilo();
   
   }
   
    public MenuInicio(VentanaJuego ventana) {
        initComponents();
        estilo();   
        this.ventana= ventana;
        setSize(450,337);
    }
    
    public void estilo (){
        
        ImageIcon z = new ImageIcon("fondos/fondoMenus.png");
        img = z.getImage();
        
        try{
        letra = (Font.createFont(Font.TRUETYPE_FONT, new FileInputStream(new File("Font/001.ttf")))).deriveFont(Font.BOLD,tamaño);
        }catch(IOException | FontFormatException e)
        {
            System.out.println("Error al cargar : " + e.toString());
        }   
        
        jugar.setBackground(Color.blue);
        jugar.setBorder(BorderFactory.createLineBorder(Color.white));
        jugar.setForeground(Color.white);
        jugar.setFont(letra);
        
        menuNiveles.setBackground(Color.blue);
        menuNiveles.setBorder(BorderFactory.createLineBorder(Color.white));
        menuNiveles.setForeground(Color.white);
        menuNiveles.setFont(letra);
        
        on.setBackground(Color.blue);
        on.setBorder(BorderFactory.createLineBorder(Color.white));
        on.setForeground(Color.white);
        on.setFont(letra);
        
        off.setBackground(Color.blue);
        off.setBorder(BorderFactory.createLineBorder(Color.white));
        off.setForeground(Color.white);
        off.setFont(letra);
        
        salir.setBackground(Color.blue);
        salir.setBorder(BorderFactory.createLineBorder(Color.white));
        salir.setForeground(Color.white);
        salir.setFont(letra);
        
    }
    
    public void paint(Graphics g)
    {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(img, 0, 0, null);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jugar = new javax.swing.JButton();
        menuNiveles = new javax.swing.JButton();
        on = new javax.swing.JButton();
        salir = new javax.swing.JButton();
        off = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jugar.setText("JUGAR");
        jugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jugarActionPerformed(evt);
            }
        });

        menuNiveles.setText("NIVELES");
        menuNiveles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuNivelesActionPerformed(evt);
            }
        });

        on.setText("SONIDO  ON");
        on.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onActionPerformed(evt);
            }
        });

        salir.setText("SALIR");
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });

        off.setText("SONIDO OFF");
        off.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                offActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jugar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(menuNiveles, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(salir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(on, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(off, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jugar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(menuNiveles, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(on, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                    .addComponent(off, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(salir, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jugarActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        
        ventana.juego.setPausa(false);
        ventana.juego.sound_player.start();
        ventana.setVisible(true);
        ventana.setSize(1024, 768);  
    }//GEN-LAST:event_jugarActionPerformed

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_salirActionPerformed

    private void menuNivelesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuNivelesActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        ventana.niveles.setVisible(true);
        
    }//GEN-LAST:event_menuNivelesActionPerformed

    private void onActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onActionPerformed
        
       
        ventana.juego.sound_player.start();
        
        
    }//GEN-LAST:event_onActionPerformed

    private void offActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_offActionPerformed
     
        ventana.juego.sound_player.stop();
        
    }//GEN-LAST:event_offActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        
        
       
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                
                new MenuInicio().setVisible(true);
                
            }
        });
        
            ventana.setVisible(true);
             while(ventana.isVisible()){
                                ventana.repaint();
                            }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jugar;
    private javax.swing.JButton menuNiveles;
    private javax.swing.JButton off;
    private javax.swing.JButton on;
    private javax.swing.JButton salir;
    // End of variables declaration//GEN-END:variables

    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void keyPressed(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
