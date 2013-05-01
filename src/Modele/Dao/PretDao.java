/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele.Dao;

import Connexion.Connect;
import Modele.modele.Pret;
import com.mysql.jdbc.ResultSetMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author djoum
 */
public class PretDao extends IDao<Pret> {

    private ObjetDao obDao = new ObjetDao();
    private ClientDao clDao = new ClientDao();

    
    @Override
    public boolean create(Pret pret) {
            test = false;


        

            String query = "insert into pret  values (" + pret.getClient().getId_client() + "," +pret.getObjet().getId_objet()+ ",'" + pret.getDate_pret() + "','" + pret.getDate_res() + "'," +pret.getQuantite()+ ",'" + pret.getStatus() + "')";


            try {

                Statement state = Connect.getInstance().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                state.executeUpdate(query);
                state.close();
                new ObjetDao().updateObjetSortir(pret.getObjet().getId_objet(), pret.getQuantite());
                test = true;

            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }

        



        return test;
    }

    
    @Override
    public boolean update(Pret pret) {
        throw new UnsupportedOperationException("Not supported yet.");
    } 

    
    @Override
    public boolean delete(Pret pret) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Object[][] getListPret() {

        Object[][] listPret=null;
        

        String query = " select client.id_client,objet.id_objet,client.nom,objet.description,pret.date_pret,pret.date_res,pret.qte from pret inner join client on pret.id_client=client.id_client inner join objet on pret.id_objet=objet.id_objet where status= 'non restituer'";

        try {
            Statement state = Connect.getInstance().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet res = state.executeQuery(query);
            ResultSetMetaData meta=(ResultSetMetaData) res.getMetaData();
            res.last();
            int rowcount=res.getRow();
            System.out.println(rowcount+" "+meta.getColumnCount());
            listPret=new Object[rowcount][meta.getColumnCount()];
            res.beforeFirst();
            int j=0;
            int t=0;
            String id="";
            while (res.next()) {
                
                for(int i=0;i<meta.getColumnCount();i++){
                    
                 if(i==0) id=res.getInt("id_client")+"-";
                 else if(i==1) { id=id+res.getInt("id_objet")+""; listPret[j][t]=id; t++;  }
                 else if(i==2) {listPret[j][t]=res.getString("nom");t++;}
                 else if(i==3){listPret[j][t]=res.getString("description");t++;}
                 else if(i==4) {listPret[j][t]=this.formatDate(res.getDate("date_pret"));t++;}
                 else if(i==5){listPret[j][t]=this.formatDate(res.getDate("date_res"));t++;}
                 else if(i==6)    {listPret[j][t]=res.getInt("qte");t++;}
                    
                    
                }
                t=0;
                j++;
            }
            res.close();
            state.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listPret;
    }

   public Object[][] gestHistoriques(){
       
        Object[][] listPret=null;
        

        String query = " select client.id_client,objet.id_objet,client.nom,objet.description,pret.date_pret,pret.date_res,pret.qte from pret inner join client on pret.id_client=client.id_client inner join objet on pret.id_objet=objet.id_objet where status= 'restituer'";

        try {
            Statement state = Connect.getInstance().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet res = state.executeQuery(query);
            ResultSetMetaData meta=(ResultSetMetaData) res.getMetaData();
            res.last();
            int rowcount=res.getRow();
            System.out.println(rowcount+" "+meta.getColumnCount());
            listPret=new Object[rowcount][meta.getColumnCount()];
            res.beforeFirst();
            int j=0;
            int t=0,p=0;
            String id="";
            while (res.next()) {
                
                for(int i=0;i<meta.getColumnCount();i++){
                    
                 if(i==0) id=res.getInt("id_client")+"-";
                 else if(i==1) { id=id+res.getInt("id_objet")+""; listPret[j][t]=id; t++;  }
                 else if(i==2) {listPret[j][t]=res.getString("nom");t++;}
                 else if(i==3){listPret[j][t]=res.getString("description");t++;}
                 else if(i==4) {listPret[j][t]=this.formatDate(res.getDate("date_pret"));t++;}
                 else if(i==5){listPret[j][t]=this.formatDate(res.getDate("date_res"));t++;}
                 else if(i==6)    {listPret[j][t]=res.getInt("qte");t++;}
                  
                 
                    
                }
                p=0;
                t=0;
                j++;
            }
            res.close();
            state.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listPret;
       
   }

    public void changeStatus(Pret pr) {

        String query = "update pret set status='restituer',date_res=now() where id_client="+pr.getClient().getId_client()+" and id_objet="+pr.getObjet().getId_objet()+" and date_pret='"+pr.getDate_pret()+"'";

        try {

            Statement state = Connect.getInstance().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            state.executeUpdate(query);
            state.close();
            new ObjetDao().updateObjetEntre(pr.getObjet().getId_objet(), pr.getQuantite());
        } catch (SQLException e) {

            e.printStackTrace();
        }
    }
    
    public Object[][] getAlerte(){
        
        Object[][] listPret=null;
        

        String query = " select objet.id_objet,client.id_client,objet.description,client.nom,pret.date_pret,pret.date_res,pret.qte from pret ";
                query+=" inner join  objet on pret.id_objet=objet.id_objet ";
                query+=" inner join client on pret.id_client=client.id_client "; 
                query+=" where  (( (datediff(pret.date_res , pret.date_pret)-datediff(now(),pret.date_pret))<=0) ";
                query+=" or (datediff(now(),pret.date_pret)>(datediff(pret.date_res,pret.date_pret)*0.1)))";
                query+="   and (status='non restituer')";

        try {
            Statement state = Connect.getInstance().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet res = state.executeQuery(query);
            ResultSetMetaData meta=(ResultSetMetaData) res.getMetaData();
            res.last();
            int rowcount=res.getRow();
            System.out.println(rowcount+" "+meta.getColumnCount());
            listPret=new Object[rowcount][meta.getColumnCount()];
            res.beforeFirst();
            int j=0;
            int t=0;
            String id="";
            while (res.next()) {
                
                for(int i=0;i<meta.getColumnCount();i++){
                    
                 if(i==0) id=res.getInt("id_client")+"-";
                 else if(i==1) { id=id+res.getInt("id_objet")+""; listPret[j][t]=id; t++;  }
                 else if(i==2) {listPret[j][t]=res.getString("nom");t++;}
                 else if(i==3){listPret[j][t]=res.getString("description");t++;}
                 else if(i==4) { listPret[j][t]=this.formatDate(res.getDate("date_pret"));t++;}
                 else if(i==5){listPret[j][t]=formatDate(res.getDate("date_res"));t++;}
                 else if(i==6)    {listPret[j][t]=res.getInt("qte");t++;}
                    
                    
                }
                t=0;
                j++;
            }
            res.close();
            state.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listPret;
       
        
        
    }
    
    private String formatDate(Date dat){
        
        
        String datepret=dat+"-",mois="";
                     int[] date=new int[3];
                     int k=0,p=0;
                     
                     
                     for(int m=0;m<datepret.length();m++){
                
                if(datepret.charAt(m)=='-'){
                  date[p]=Integer.parseInt(datepret.substring(k, m));  
                  k=m+1;
                  p++;
                }
            }
                     switch (date[1]) {
                         
                         case 1 : mois="janvier"; break;
                         case 2 : mois="fevrier"; break; 
                         case 3 : mois="mars"; break;  
                         case 4 : mois="avril"; break;
                         case 5 : mois="mai"; break;
                         case 6 : mois="juin"; break;
                         case 7 : mois="juillet"; break;
                         case 8 : mois="aout";break;
                         case 9 : mois="septembre";break;
                         case 10 : mois="octobre"; break;
                         case 11 : mois="novembre"; break;
                         default : mois="decembre"; break;
                     }
                     
                     datepret=date[2]+" "+mois+" "+date[0];
                     
                     System.out.println(datepret);
                     return datepret;
        
    }
  
    public ArrayList<Pret> getListPret2(){
        
        Pret pret=null;
        ArrayList<Pret> listPret=new ArrayList<>();
        String query = " select client.id_client,objet.id_objet,client.nom,objet.description,pret.date_pret,pret.date_res,pret.qte from pret ";
               query+=" inner join client on pret.id_client=client.id_client ";
               query+=" inner join objet on pret.id_objet=objet.id_objet ";
               query+=" where status= 'non restituer'";
        
               try {
            Statement state = Connect.getInstance().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet res = state.executeQuery(query);
            
            while (res.next()) {
                
                pret=new Pret(new ClientDao().getClientById(res.getInt("id_client")),new ObjetDao().getObjetById(res.getInt("id_objet")),res.getString("date_pret"),res.getString("date_res"),res.getInt("qte"),"non restituer");
                listPret.add(pret);
                      
                }
            
            res.close();
            state.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

               
        return listPret;
    }
    
}
