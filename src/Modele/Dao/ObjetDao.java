/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele.Dao;

import Connexion.Connect;
import Modele.modele.Objet;
import com.mysql.jdbc.ResultSetMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author djoum
 */
public class ObjetDao extends IDao<Objet> {

    
    @Override
    public boolean create(Objet ob) {
        test = false;
        
         String query="insert into objet (types,description,qte,id_user) values ('"+ob.getTypes()+"','"+ob.getDescription()+"',"+ob.getQte()+","+ob.getId_user()+")" ;
        
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
    
    
    
    @Override
    public boolean update(Objet ob) {
        
         
        boolean test= false;
           String query="update objet set types = '"+ob.getTypes()+"', description='"+ob.getDescription()+"',qte="+ob.getQte()+",id_user="+ob.getId_user()+" where id_objet = "+ob.getId_objet() ;
        if(this.getObjetById(ob.getId_objet())!=null){
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

    
    public boolean delete(Objet obj) {
        
        test=false;
        
        if(this.getObjetById(obj.getId_objet())!=null){
        try {
            Statement state =Connect.getInstance().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            state.executeUpdate("DELETE FROM objet WHERE id_objet="+obj.getId_objet());
	    test=true;
        } catch(SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
			    }
        }        
        return test;
    }
    
    
    // selectionner l'objet ayant pour id
    public Objet getObjetById(int id){
         
        Objet ob=null;
        String query=" select * from objet where id_objet="+id;
        
        try {  
            Statement state = Connect.getInstance().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet res = state.executeQuery(query);
            while(res.next()) ob=new Objet(res.getInt("id_objet"),res.getInt("id_user"),res.getInt("qte"),res.getString("types"),res.getString("description"));
            res.close();
            state.close();
   
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return ob;
    }
    
    public ArrayList<String> findType(){
        
        ArrayList<String> listType=new ArrayList<>();
        String query ="select  distinct types from objet";
        
        try {  
            Statement state = Connect.getInstance().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet res = state.executeQuery(query);
            while(res.next()) listType.add(res.getString("types")); 
            res.close();
            state.close();
   
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listType;
    }
    
    public ArrayList<Objet> findObjetByType(String type){
        
        Objet ob =null;
        ArrayList<Objet> listObjet= new ArrayList<>();
        String query="select * from objet where types= '"+type+"'";
        
         try {  
            Statement state = Connect.getInstance().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet res = state.executeQuery(query);
            while(res.next()) {
                
                ob=new Objet(res.getInt("id_objet"),res.getInt("id_user"),res.getInt("qte"),res.getString("types"),res.getString("description"));
                listObjet.add(ob);
            } 
            res.close();
            state.close();
   
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return listObjet;
    }
   
    public ArrayList<Objet> findAllObjet(){
        
        ArrayList<Objet> listObjet=new ArrayList<Objet>();
        String query=" select * from objet ";
        Objet ob=null;
        
        try {  
            Statement state = Connect.getInstance().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet res = state.executeQuery(query);
            while(res.next()) {
                
                ob=new Objet(res.getInt("id_objet"),res.getInt("id_user"),res.getInt("qte"),res.getString("types"),res.getString("description"));
                listObjet.add(ob);
            } 
            res.close();
            state.close();
   
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        
        return listObjet;
    }
    
    public boolean updateObjetSortir(int id, int qteSortir){
        
        Objet ob= this.getObjetById(id);
        boolean test= false;
           String query="update objet set qte ="+(ob.getQte()-qteSortir)+" where id_objet = "+id ;
        if(this.getObjetById(id)!=null){
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
    
    public boolean updateObjetEntre(int id,int qteEntre){
        
        Objet ob= this.getObjetById(id);
        boolean test= false;
           String query="update objet set qte ="+(ob.getQte()+qteEntre)+" where id_objet = "+id ;
        if(this.getObjetById(id)!=null){
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
    
     public String[] getObjetName(){
        String[] lesDescription=null;
        String query="select distinct id_objet,description from objet order by id_objet";
        
        try {  
            Statement state = Connect.getInstance().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet res = state.executeQuery(query);
            
            res.last();
            int rowcount=res.getRow();
            System.out.println(rowcount);
            lesDescription=new String[rowcount];
            int i=0;
            res.beforeFirst();
            
            while(res.next()) {
             
                lesDescription[i]=res.getInt("id_objet")+"-->"+res.getString("description");  
//                System.out.println(res.getObject("nom"));
                i++;
                
            } 
            res.close();
            state.close();
   
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return lesDescription;
    }
    
    public Object[][] getListObjet() {

        Object[][] listObjet=null;
        

        String query = "select * from objet order by id_objet";

        try {
            Statement state = Connect.getInstance().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet res = state.executeQuery(query);
            ResultSetMetaData meta=(ResultSetMetaData) res.getMetaData();
            res.last();
            int rowcount=res.getRow();
            System.out.println(rowcount+" "+meta.getColumnCount());
            listObjet=new Object[rowcount][meta.getColumnCount()];
            res.beforeFirst();
            int j=1;
            int t=0;
            String id="";
            while (res.next()) {
                
                for(int i=1;i<=meta.getColumnCount();i++){
                    
//                 if(i==0) id=res.getInt("id_client")+"-";
//                 else if(i==1) { id=id+res.getInt("id_objet")+""; listPret[j][t]=id; t++;  }
//                 else if(i==2) {listPret[j][t]=res.getString("nom");t++;}
//                 else if(i==3){listPret[j][t]=res.getString("description");t++;}
//                 else if(i==4) {listPret[j][t]=res.getString("date_pret");t++;}
//                 else if(i==5){listPret[j][t]=res.getString("date_res");t++;}
//                 else if(i==6)    {listPret[j][t]=res.getInt("qte");t++;}
//                  
                    listObjet[j-1][i-1]=res.getObject(i);
                    
                    
                }
                t=0;
                j++;
            }
            res.close();
            state.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listObjet;
    }
     
}
