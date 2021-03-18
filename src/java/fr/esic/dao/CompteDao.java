/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.esic.dao;

import fr.esic.model.Compte;
import fr.esic.model.Person;
import fr.esic.model.User;
import java.sql.Connection;
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
public class CompteDao {

    public static Compte getAllCompte(Person p) throws SQLException {

        Compte c = null;

        String sql = "    SELECT \n"
                + "    p.idperson,\n"
                + "    nom,\n"
                + "    prenom,\n"
                + "    solde,\n"
                + "    numCp,\n"
                + "    numCarte,\n"
                + "    etat,\n"
                + "    opposition,\n"
                + "    operation,\n"
                + "    dateExpiration,\n"
                + "    typeOperation,\n"
                + "    dateOperation,\n"
                + "    montantDecouvert,\n"
                + "    livretA, \n"
                 + "    montantEpargne \n"
                + "FROM \n"
                + "    compte c\n"
                + "        INNER JOIN\n"
                + "    person p ON c.person_idperson = p.idperson\n"
                + "WHERE\n"
                + "    p.idperson = ?";
        Connection connexion = AccessBd.getConnection();

        PreparedStatement prepare = connexion.prepareStatement(sql);
        prepare.setInt(1, p.getId());

        ResultSet rs = prepare.executeQuery();

        while (rs.next()) {
            c = new Compte();
            c.setSolde(rs.getString("solde"));
            c.setNumcompte(rs.getString("numCp"));
            c.setNumcarte(rs.getString("numCarte"));
            c.setEtatcarte(rs.getBoolean("etat"));
            c.setOpposition(rs.getBoolean("opposition"));
            c.setOperation(rs.getString("operation"));
            c.setDate_expiration(rs.getDate("dateExpiration"));
            c.setDateOperation(rs.getDate("dateOperation"));
            c.setMontantDecouvert(rs.getInt("montantDecouvert"));
            c.setLivretA(rs.getString("livretA"));
            c.setMontantEpargne(rs.getInt("montantEpargne"));

            Person u = new Person();
            u.setId(rs.getInt("idperson"));
            u.setNom(rs.getString("nom"));
            u.setPrenom(rs.getString("prenom"));
            c.setPerson(u);

        }
        return c;
    }
    
        public static Compte getCompte(int idcompte) throws SQLException {

        Compte c = null;
        String sql = "SELECT idcompte, solde, numCp, numcarte, etat, nom, prenom "
                + " FROM compte c INNER JOIN person p ON c.person_idperson = p.idperson WHERE idcompte=?";  
    
        Connection connection = AccessBd.getConnection();
        PreparedStatement prepare = connection.prepareStatement(sql);
        prepare.setInt(1, idcompte);
        ResultSet rs = prepare.executeQuery();
        
        if (rs.next()) {
            c = new Compte();
            c.setId(rs.getInt("idcompte"));
            c.setSolde(rs.getString("solde"));
            c.setNumcompte(rs.getString("numCp"));
            c.setNumcarte(rs.getString("numcarte"));
            c.setEtatcarte(rs.getBoolean("etat"));
            
            Person person = new Person();            
            person.setNom(rs.getString("nom"));
            person.setPrenom(rs.getString("prenom"));
            
            c.setPerson(person); 
        }        
        return c;
    }
    
        public static List<Compte> getAllComptes() throws SQLException {

        List<Compte> comptes = new ArrayList<>();
        String sql = "SELECT idcompte, solde, numCp, numcarte, etat, nom, prenom "
                + " FROM compte c INNER JOIN person p ON c.person_idperson = p.idperson";
        Connection connexion = AccessBd.getConnection();
        Statement requete = connexion.createStatement();
        ResultSet rs = requete.executeQuery(sql);
        
        while (rs.next()) {
            Compte compte = new Compte();
            compte.setId(rs.getInt("idcompte"));
            compte.setSolde(rs.getString("solde"));
            compte.setNumcompte(rs.getString("numCp"));
            compte.setNumcarte(rs.getString("numcarte"));
            compte.setEtatcarte(rs.getBoolean("etat"));
 
            Person person = new Person();            
            
            person.setNom(rs.getString("nom"));
            person.setPrenom(rs.getString("prenom"));        
            compte.setPerson(person);
            
            comptes.add(compte);
        }
        return comptes;
    }
        
    public static void ActiveCarte(int idcompte) throws SQLException {
        String sql = "Update compte set etat=true WHERE idcompte=?";
        Connection connexion = AccessBd.getConnection();
        PreparedStatement prepare = connexion.prepareStatement(sql);
        prepare.setInt(1, idcompte);
        prepare.execute();
    }

    public static void DesactiverCarte(int idcompte) throws SQLException {
        String sql = "Update compte set etat=false WHERE idcompte=?";
        Connection connexion = AccessBd.getConnection();
        PreparedStatement prepare = connexion.prepareStatement(sql);
        prepare.setInt(1, idcompte);
        prepare.execute();
    }
    
    public static void Solde(int solde, String type, int numcarte) throws SQLException {
        String sql = "update compte set solde =? , typeOperation=? where numcarte=?";
        Connection connexion = AccessBd.getConnection();
        PreparedStatement prepare = connexion.prepareStatement(sql);
        prepare.setInt(1, solde);
        prepare.setString(2, type);
        prepare.setInt(3, numcarte);
        prepare.execute();

    }

    public static void OppositionCarte(int numcarte) throws SQLException {
        String sql = "Update compte set opposition=1,etat=0 WHERE numcarte=?";
        Connection connexion = AccessBd.getConnection();
        PreparedStatement prepare = connexion.prepareStatement(sql);
        prepare.setInt(1, numcarte);
        prepare.execute();
    }

    public static void demandedecouvert(int montant, int numcarte) throws SQLException {
        String sql = "Update compte set montantDecouvert=? WHERE numcarte=?";
        Connection connexion = AccessBd.getConnection();
        PreparedStatement prepare = connexion.prepareStatement(sql);
        prepare.setInt(1, montant);
        prepare.setInt(2, numcarte);
        prepare.execute();
    }
    
    
     public static void paiement(int solde) throws SQLException {
      String sql = "update compte set solde =? ";
        Connection connexion = AccessBd.getConnection();
       PreparedStatement prepare = connexion.prepareStatement(sql);
       prepare.setInt(1, solde);
       
       prepare.execute();
      
    }
     
//    public static void paiement())throws SQLException {
//
//     String sql = "select sum(prixproduit)as paiement FROM banque1.achat";
//      Connection con =AccessBd.getConnection();
//       Statement st =con.createStatement();
//        ResultSet rst=st.executeQuery(sql);
//    
//   }
    
     public static void ActiveCompte(int idperson) throws SQLException {
        String sql = "insert into compte set person_idperson=? ";
        Connection connexion = AccessBd.getConnection();
        PreparedStatement prepare = connexion.prepareStatement(sql);
        prepare.setInt(1, idperson);
        prepare.execute();
    }
    
           public static void demandeepargne(int montant, int numcarte) throws SQLException {
        String sql = "Update compte set montantEpargne=? WHERE numcarte=?";
        Connection connexion = AccessBd.getConnection();
        PreparedStatement prepare = connexion.prepareStatement(sql);
        prepare.setInt(1, montant);
        prepare.setInt(2, numcarte);
        prepare.execute();
    }
    
    
    
}
