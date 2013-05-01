/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele.Dao;

import Connexion.Connect;
import Modele.modele.Client;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author djoum
 */
public class ClientDao  extends IDao<Client> {

    public ClientDao() {
    }

    

    public boolean create(Client cl) {
       test = false;
         String query="insert into client (nom,prenom,adresse,tel,num_cni,email) values ('"+cl.getNom()+"','"+cl.getPrenom()+"','"+cl.getAdresse()+"','"+cl.getTel()+"','"+cl.getNum_cni()+"','"+cl.getEmail()+"')" ;
        
         try{
            
            Statement state =Connect.getInstance().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            state.executeUpdate(query);
            state.close();
            test=true;
	
        }  catch (SQLException e) {
         System.out.println(e.getMessage());  
             }
         
        return test;
        
    }

  
    public boolean update(Client cl) {
        
        
        boolean test= false;
           String query="update client set nom = '"+cl.getNom()+"', prenom='"+cl.getPrenom()+"',adresse='"+cl.getAdresse()+"',tel='"+cl.getTel()+"', num_cni='"+cl.getNum_cni()+"',email='"+cl.getEmail()+"' where id_client = "+cl.getId_client() ;
        if(this.getClientById(cl.getId_client())!=null){
        try{
            
                Statement state =Connect.getInstance().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
                state.executeUpdate(query);
	        state.close();
                test=true;
        }  catch (SQLException e) {
           
            e.printStackTrace();
                }
        }
        return test;
        
    }

    
    public boolean delete(Client cl) {
        
       test=false;
        
        
        try {
            Statement state =Connect.getInstance().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            state.executeUpdate("DELETE FROM client WHERE id_client="+cl.getId_client());
	    test=true;
        } catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage()) ;
			    }
        return test;
        }        
        
        
    
    
    public Client getClientById(int id){
         
        Client cl=null;
        String query=" select * from client where id_client="+id;
        
        try {  
            Statement state = Connect.getInstance().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet res = state.executeQuery(query);
            while(res.next()) cl=new Client(res.getInt("id_client"),res.getString("nom"),res.getString("prenom"),res.getString("adresse"),res.getString("tel"),res.getString("email"),res.getString("num_cni"));
            res.close();
            state.close();
   
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return cl;
    }
    
    public ArrayList<Client> findAllClient(){
        
        ArrayList<Client> listClient=new ArrayList<Client>();
        String query=" select * from client ";
        Client cl=null;
        
        try {  
            Statement state = Connect.getInstance().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet res = state.executeQuery(query);
            while(res.next()) {
                
                cl=new Client(res.getInt("id_client"),res.getString("nom"),res.getString("prenom"),res.getString("adresse"),res.getString("tel"),res.getString("email"),res.getString("num_cni"));
                listClient.add(cl);
            } 
            res.close();
            state.close();
   
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        
        return listClient;
    }
    
    public String[] getClientName(){
        String[] lesNom=null;
        String query="select  id_client,nom,prenom from client order by id_client";
        
        try {  
            Statement state = Connect.getInstance().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet res = state.executeQuery(query);
            
            res.last();
            int rowcount=res.getRow();
            System.out.println(rowcount);
            lesNom=new String[rowcount+1];
            int i=0;
            res.beforeFirst();
            
            while(res.next()) {
             
                lesNom[i]=res.getInt("id_client")+"-->"+res.getString("nom")+" "+res.getString("prenom");  
//                System.out.println(res.getObject("nom"));
                i++;
                
            } 
            lesNom[i]="nouveau client";
            res.close();
            state.close();
   
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return lesNom;
    }
}
