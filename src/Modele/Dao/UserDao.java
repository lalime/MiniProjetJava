/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele.Dao;

import Connexion.Connect;
import Modele.modele.User;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author djoum
 */
public class UserDao extends IDao<User> {

    @Override
    public boolean create(User obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean update(User ut) {

        test = false;
        String pass = messageDigest(ut.getMot_pass());


        String query = "update user set nom = '" + ut.getNom() + "', prenom='" + ut.getPrenom() + "',adresse='" + ut.getAdresse() + "',pseudo='" + ut.getPseudo() + "',mot_pass='" + pass + "',tel='" + ut.getTel() + "' where nom = 'borice'";
        if (this.getUserByName("borice") != null) {
            try {

                Statement state = Connect.getInstance().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                state.executeUpdate(query);
                state.close();
                test = true;
            } catch (SQLException e) {
            }
        }
        return test;

    }

    @Override
    public boolean delete(User obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean updatePassword(String oldpass, String newpass) {


        String pass1 = messageDigest(newpass);
        String pass2 = messageDigest(oldpass);


        boolean test = false;
        String query = "update user set mot_pass = '" + pass1 + "' where mot_pass='" + pass2 + "'";

        if (this.getUserByPass(pass2) != null) {
            try {

                Statement state = Connect.getInstance().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                state.executeUpdate(query);
                state.close();
                test = true;
            } catch (SQLException e) {
            }
        }

        return test;
    }

    public boolean authentification(User ut) throws NoSuchAlgorithmException {

         test = false;
        int count = 0;
        String query = "select * from user ";

        String pass = messageDigest(ut.getMot_pass());



        try {
            Statement state = Connect.getInstance().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet res = state.executeQuery(query);

            while (res.next()) {
                if ((res.getString("pseudo").equals(ut.getPseudo())) && (res.getString("mot_pass").equals(pass))) {
                    count++;
                }
            }
            if (count == 1) {
                test = true;
            }

            res.close();
            state.close();


        } catch (SQLException e) {
        }

        return test;
    }

    public boolean updateCompte(User ut, String oldpass) {


        boolean test = false;

        String pass1 = messageDigest(ut.getMot_pass());
         String pass2 = messageDigest(oldpass);

        String query = "update user set pseudo = '" + ut.getPseudo() + "', mot_pass='" + pass1 + "' where mot_pass ='" + pass2 + "'";
        if (this.getUserByPass(pass2) != null) {

            try {

                Statement state = Connect.getInstance().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                state.executeUpdate(query);
                state.close();
                test = true;

            } catch (SQLException e) {

                e.printStackTrace();
            }

        }

        return test;
    }

    private User getUserByPass(String pass) {

        User ut = null;
        String pswd = messageDigest(pass);
        String query = " select * from user where mot_pass='" + pswd + "'";

        try {
            Statement state = Connect.getInstance().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet res = state.executeQuery(query);
            while (res.next()) {
                ut = new User(res.getInt("id_user"), res.getString("nom"), res.getString("prenom"), res.getString("adresse"), res.getString("pseudo"), res.getString("mot_pass"), res.getString("tel"));
            }
            res.close();
            state.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ut;
    }

    private User getUserByName(String nom) {

        User ut = null;
        String query = " select * from user where nom ='" + nom + "'";

        try {
            Statement state = Connect.getInstance().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet res = state.executeQuery(query);
            while (res.next()) {
                ut = new User(res.getInt("id_user"), res.getString("nom"), res.getString("prenom"), res.getString("adresse"), res.getString("pseudo"), res.getString("mot_pass"), res.getString("tel"));
            }
            res.close();
            state.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ut;
    }
    
//    Methode de cryptage de mot de passe

    private String messageDigest(String mes) {
        byte[] defaultBytes = mes.getBytes();
        String pswd = "";
        try {
            MessageDigest algorithm = MessageDigest.getInstance("MD5");
            algorithm.reset();
            algorithm.update(defaultBytes);
            byte messageDigest[] = algorithm.digest();

            for (int i = 0; i < messageDigest.length; i++) {
                pswd += messageDigest[i];
            }
        } catch (NoSuchAlgorithmException nsae) {
            System.out.println("algorithme pas existant!!!" + nsae.getMessage());

        }
        return pswd;
    }
}
