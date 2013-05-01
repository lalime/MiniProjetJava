package Connexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import javax.swing.JOptionPane;

public class Connect{
 
 private static Connection connect;
 private static ResourceBundle resources;
 
 /**
* Méthode qui va retourner notre instance
* et la créer si elle n'existe pas...
* @return
*/
 public static Connection getInstance(){
     
     try{
        
        resources = ResourceBundle.getBundle( "Connexion.info_bd" );
     }catch(MissingResourceException e){
         
         JOptionPane.showMessageDialog(null, e.getMessage(), "RESOURCE INTROUVABLE!!!!!! ", JOptionPane.ERROR_MESSAGE);
         
     }
     
  if(connect == null){
   try {
               
    connect =    DriverManager.getConnection(resources.getString("url"),resources.getString("nomutilisateur") ,resources.getString("motdepasse"));
   } catch (SQLException e) {
    JOptionPane.showMessageDialog(null, e.getMessage(), "ERREUR DE CONNEXION ! ", JOptionPane.ERROR_MESSAGE);
   }
  }  
  return connect; 
 }
 
 
}