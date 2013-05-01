/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele.modele;

import java.util.Objects;

/**
 *
 * @author djoum
 */
public class Objet {
    
    private int id_objet,id_user,qte;
    private String types,description;
    
    public Objet(){}

    public Objet(int id_user, int qte, String types, String description) {
        this.id_user = id_user;
        this.qte = qte;
        this.types = types;
        this.description = description;
    }

    
    
    public Objet(int id_objet, int id_user, int qte, String types, String description) {
        this.id_objet = id_objet;
        this.id_user = id_user;
        this.qte = qte;
        this.types = types;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId_objet() {
        return id_objet;
    }

    public void setId_objet(int id_objet) {
        this.id_objet = id_objet;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getQte() {
        return qte;
    }

    public void setQte(int qte) {
        this.qte = qte;
    }

    public String getTypes() {
        return types;
    }

    public void setTypes(String types) {
        this.types = types;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Objet other = (Objet) obj;
        if (this.id_objet != other.id_objet) {
            return false;
        }
        if (this.id_user != other.id_user) {
            return false;
        }
        if (this.qte != other.qte) {
            return false;
        }
        if (!Objects.equals(this.types, other.types)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Objet{" + "id_objet=" + id_objet + ", id_user=" + id_user + ", qte=" + qte + ", types=" + types + ", description=" + description + '}';
    }

    
}
