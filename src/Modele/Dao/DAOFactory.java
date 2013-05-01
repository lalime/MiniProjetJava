/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele.Dao;

import Modele.modele.Client;
import Modele.modele.Objet;
import Modele.modele.Pret;

/**
 *
 * @author NANA
 */
public class DAOFactory {
    
   
      /**
* Retourne un objet Classe interagissant avec la BDD
* @return DAO
*/
  public static ClientDao getClientDAO(){
    return new ClientDao();
  }
  /**
* Retourne un objet Professeur interagissant avec la BDD
* @return DAO
*/
  public static PretDao getPretDAO(){
    return new PretDao();
  }
  /**
* Retourne un objet Eleve interagissant avec la BDD
* @return DAO
*/
  public static ObjetDao getObjetDAO(){
    return new ObjetDao();
  }
  public static UserDao getUserDAO(){
    return new UserDao();
  }

    
}
