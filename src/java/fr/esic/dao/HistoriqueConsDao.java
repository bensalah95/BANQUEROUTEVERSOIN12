/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.esic.dao;

import fr.esic.model.HistoriqueCons;
import fr.esic.model.Person;
import fr.esic.model.Role;
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
 * @author Nathan Ghozlan
 */
public class HistoriqueConsDao {

    private static HistoriqueConsDao instance = null;

    private HistoriqueConsDao() {

    }

    public static HistoriqueConsDao getInstance() {
        if (instance == null) {
            instance = new HistoriqueConsDao();
        }
        return instance;
    }

    public void newHistorique(HistoriqueCons c) throws SQLException {
        String sql = "INSERT INTO historiqueconseiller (label, idUtilisateur) VALUES (?, ?)";
        Connection connexion = AccessBd.getConnection();
        PreparedStatement prepare = connexion.prepareStatement(sql);
        prepare.setString(1, c.getNom());
        prepare.setInt(2, c.getIdUtil());
        prepare.execute();
    }

    public static List<HistoriqueCons> getAllHistorique() throws SQLException {

        List<HistoriqueCons> histCons = new ArrayList<>();

        String sql = "SELECT label FROM historiqueconseiller h INNER JOIN utilisateur u ON h.idUtilisateur = u.idutilisateur WHERE idrole=2";

        Connection connexion = AccessBd.getConnection();

        Statement requete = connexion.createStatement();

        ResultSet rs = requete.executeQuery(sql);
        while (rs.next()) {
            HistoriqueCons hist = new HistoriqueCons();
            hist.setNom(rs.getString("label"));
            histCons.add(hist);
            
        }
        return histCons;
    }

}
