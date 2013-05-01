/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 *
 * @author djoum
 */
public class window {
    
  private Thread t;
  private JProgressBar bar;
  private JWindow win=new JWindow();  
    
  public static void main(String[] args){
    window wind = new window();
    wind.win.setVisible(true);
   
  }
   
  public window(){ 
      
    win.setSize(500, 300);
    win.setLocationRelativeTo(null); 
    win.setVisible(true);
    bar  = new JProgressBar();
    bar.setMaximum(500);
    bar.setMinimum(0);
    bar.setStringPainted(true);
    bar.setForeground(Color.BLUE); // couleur du chargement
    
    JPanel pan = new JPanel();
    JPanel pan2=new JPanel();
    JLabel label=new JLabel("chargement en cours ......");
    //gestion de l'image au point jar donc le chargement
    BufferedImage image = null;
    try{
        image = ImageIO.read(win.getClass().getResource("/Collines.jpg"));
    }catch (IOException e){
        e.printStackTrace(); //fin gestion image et on le place ds le JLabel ki a la variable img
    }
    JLabel img = new JLabel(new ImageIcon(image)); //on charge l'image ds le JLabel
    img.setVerticalAlignment(JLabel.CENTER);
    img.setHorizontalAlignment(JLabel.CENTER);      
    //pan.setBorder(BorderFactory.createLineBorder(Color.blue));
    pan.add(img);
   // pan2.add(label,BorderLayout.NORTH);
    pan2.add(bar,BorderLayout.SOUTH);
    win.getContentPane().add(pan,BorderLayout.CENTER);
    win.getContentPane().add(bar, BorderLayout.SOUTH);
    
    try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    
     t = new Thread(new Traitement());
        //this.run(); 
     t.start();
  }

   
  
    class Traitement implements Runnable{   
    public void run(){
      AuthentificationVue vue= new AuthentificationVue();
         
      for(int val = 0; val <= 500; val++){
        bar.setValue(val);
        try {
          t.sleep(10);
        } catch (InterruptedException e) {
         
        e.printStackTrace();
        }
        
      }
    
      vue.setVisible(true);
      win.dispose();
      
    
    }   
  }
  
}