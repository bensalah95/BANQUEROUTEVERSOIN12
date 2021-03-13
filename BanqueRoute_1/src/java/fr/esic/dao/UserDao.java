package fr.esic.dao;

import fr.esic.model.Person;
import fr.esic.model.Role;
import fr.esic.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    
    public static User getByLoginAndPassword(String log, String mdp) throws SQLException {
        User u = null;
        String sql = "SELECT * FROM utilisateur u INNER JOIN person p ON p.idperson = u.idperson WHERE login=? AND mdp=?";
        Connection connexion = AccessBd.getConnection();
        
        PreparedStatement prepare = connexion.prepareStatement(sql);
        prepare.setString(1, log);
        prepare.setString(2, mdp);
        
        ResultSet rs = prepare.executeQuery();
        
        if (rs.next()) {
            u = new User();
            u.setId(rs.getInt("idutilisateur"));
            u.setLogin(rs.getString("login"));
            u.setMdp(rs.getString("mdp"));
            
            Person p = new Person();
            p.setId(rs.getInt("idperson"));
            p.setNom(rs.getString("nom"));
            u.setPerson(p);
            
            Role r = new Role();
            r.setId(rs.getInt("idrole"));
            u.setRole(r);
        }
        
        return u;
    }
    
    public static User getUserById(String id) throws SQLException {

        User p = null;
        String sql = "select * from utilisateur where idperson=?";
        Connection conn = AccessBd.getConnection();

        PreparedStatement prepare = conn.prepareStatement(sql);
        prepare.setString(1, id);
        ResultSet rs = prepare.executeQuery();

        if (rs.next()) {
            p = new User();

            p.setId(rs.getInt("idperson"));
            p.setLogin(rs.getString("login"));
            p.setMdp(rs.getString("mdp"));
            
        }
        return p;
    }

    /* public static int insertPerson(User u) throws SQLException {
        String sql = "INSERT INTO person (nom, prenom, telephone, sexe, dateNaissance, eMail, adresse) VALUES (?,?,?,?,?,?,?)";
        Connection connexion = AccessBd.getConnection();
        PreparedStatement prepare = connexion.prepareStatement(sql);
        prepare.setString(1, u.getNom());
        prepare.setString(2, u.getPrenom());
        prepare.setString(3, u.getTelephone());
        prepare.setString(4, u.getSexe());
        prepare.setString(5, u.getDateNaissance());
        prepare.setString(6, u.getMail());
        prepare.setString(7, u.getAdresse());
        prepare.execute();
        
        ResultSet RSid = prepare.getGeneratedKeys();
        RSid.next();
        return RSid.getInt(1);
    }*/
 
    public static List<User> getAll() throws SQLException {

        List<User> users = new ArrayList<>();

        String sql = "SELECT * FROM utilisateur";

        Connection connexion = AccessBd.getConnection();

        Statement requete = connexion.createStatement();

        ResultSet rs = requete.executeQuery(sql);
        while (rs.next()) {
            User u = new User();

            u.setId(rs.getInt("idperson"));
            u.setLogin(rs.getString("login"));
            u.setMdp(rs.getString("mdp"));
            
            users.add(u);
        }
        return users;
    }

     
}
