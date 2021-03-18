/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.esic.dao;

import fr.esic.model.Compte;
import fr.esic.model.Historique;
import fr.esic.model.Operation;
import fr.esic.model.Person;
import fr.esic.model.User;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author marye
 */
public class HistoriqueDao {

    public static void AjouterOperation(String type, int montantOperation, int idperson) throws SQLException {

        String sql = "insert into historique(typeOperations, montantOperations, person_idperson) values (?,?,?)";
        Connection connexion = AccessBd.getConnection();

        PreparedStatement prepare = connexion.prepareStatement(sql);

        prepare.setString(1, type);
        prepare.setInt(2, montantOperation);
        prepare.setInt(3, idperson);
        prepare.execute();

    }

    public static List<Historique> getAllOperations() throws SQLException {
        List<Historique> ListeOperations = new ArrayList<>();

        String sql = "SELECT  idperson, nom, prenom,typeOperations, dateOperations, montantOperations "
                + "FROM historique h inner join person p"
                + " on h.person_idperson=p.idperson order by dateOperations desc";

        Connection connexion = AccessBd.getConnection();

        Statement st = connexion.createStatement();

        ResultSet rs = st.executeQuery(sql);

        while (rs.next()) {
            Historique h = new Historique();
            h.setTypeOperations(rs.getString("typeOperations"));
            h.setDateOperations(rs.getDate("dateOperations"));
            h.setMontantOperations(rs.getInt("MontantOperations"));

            Person p = new Person();

            p.setId(rs.getInt("idperson"));
            p.setNom(rs.getString("nom"));

            ListeOperations.add(h);

        }
        return ListeOperations;
    }

    public static void AjouterAchat(String type, double montantOperation, int idperson) throws SQLException {

        String sql = "insert into historique('Achat',MontantOperation,person_idperson) values (?,?,?)";
        Connection connexion = AccessBd.getConnection();

        PreparedStatement prepare = connexion.prepareStatement(sql);

        prepare.setString(1, type);
        prepare.setDouble(2, montantOperation);
        prepare.setInt(3, idperson);
        prepare.execute();

    }

    public static void UpdateUser(int id) throws SQLException {
        String sql = "INSERT INTO banqueesic.historique (contenu, person_idperson) VALUES ('Update',?)";
        Connection connexion = AccessBd.getConnection();
        PreparedStatement prepare = connexion.prepareStatement(sql);
        prepare.setInt(1, id);
        prepare.execute();

    }
    
    public static List<Historique> getAllOperationsByCompte(int idcompte) throws SQLException {

        List<Historique> listeOperations = new ArrayList<>();

        String sql = "SELECT typeOperations, dateOperations, montantOperations, idcompte, "
                + " solde, numCp, nom, prenom FROM historique h "
                + " INNER JOIN compte c ON h.compte_idcompte = c.idcompte "
                + " INNER JOIN person p ON h.person_idperson = p.idperson "
                + " WHERE idcompte=? order by dateOperations desc";

        Connection connection = AccessBd.getConnection();
        PreparedStatement prepare = connection.prepareStatement(sql);
        prepare.setInt(1, idcompte);
        ResultSet rs = prepare.executeQuery();

        while (rs.next()) {
            Historique h = new Historique();
            h.setTypeOperations(rs.getString("typeOperations"));
            h.setDateOperations(rs.getDate("dateOperations"));
            h.setMontantOperations(rs.getInt("montantOperations"));

            Person p = new Person();

            p.setNom(rs.getString("nom"));
            p.setPrenom(rs.getString("prenom"));
            h.setPerson(p);
            
            Compte c = new Compte();
            c.setId(rs.getInt("idcompte"));
            c.setSolde(rs.getString("solde"));
            c.setNumcompte(rs.getString("numCp"));
            h.setCompte(c);

            listeOperations.add(h);
        }
        return listeOperations;
    }
}
