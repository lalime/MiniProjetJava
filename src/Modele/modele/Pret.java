/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele.modele;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author djoum
 */
public class Pret {

    
    private Client client;
    private Objet objet;
    private int quantite;
    private String date_pret,date_res,status;
    
    public Pret(){}

    public Pret(Client client,Objet obj, String date_pret, String date_res,int qte, String status) {
        this.client = client;
        this.date_pret = date_pret;
        this.date_res = date_res;
        this.objet=obj;
        this.quantite=qte;
        this.status = status;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getDate_pret() {
        return date_pret;
    }

    public void setDate_pretByDate(Date d) {
        
        String format = "yyyy-MM-dd H:mm:ss",date; 
        SimpleDateFormat formater = new SimpleDateFormat( format ); 
        date=formater.format( d);
        this.date_pret = date;
        
    }

    public String getDate_res() {
        return date_res;
    }

    public void setDate_resByDate(Date d) {
        
        String format = "yyyy-MM-dd H:mm:ss",date; 
        SimpleDateFormat formater = new SimpleDateFormat( format ); 
        date=formater.format( d);
        this.date_res = date;
       
    }

    public void setDate_pretByString(String date){
        this.date_pret=date;
    }
    public void setDate_resByString(String date){
        this.date_res=date;
    }
   
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Objet getObjet() {
        return objet;
    }

    public void setObjet(Objet objet) {
        this.objet = objet;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pret other = (Pret) obj;
        if (!this.client.equals( other.client)) {
            return false;
        }
        if (!this.objet.equals( other.objet)) {
            return false;
        }
        if (this.quantite != other.quantite) {
            return false;
        }
        if (!this.date_pret.equals( other.date_pret)) {
            return false;
        }
        if (!this.date_res.equals( other.date_res)) {
            return false;
        }
        if (!this.status.equals( other.status)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + Objects.hashCode(this.client);
        hash = 71 * hash + Objects.hashCode(this.objet);
        hash = 71 * hash + this.quantite;
        hash = 71 * hash + Objects.hashCode(this.date_pret);
        hash = 71 * hash + Objects.hashCode(this.date_res);
        hash = 71 * hash + Objects.hashCode(this.status);
        return hash;
    }

    @Override
    public String toString() {
        return "Pret{" + "client=" + client + ", objet=" + objet + ", quantite=" + quantite + ", date_pret=" + date_pret + ", date_res=" + date_res + ", status=" + status + '}';
    }

   
   
}
 