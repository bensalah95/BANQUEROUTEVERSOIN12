/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.esic.model;

/**
 *
 * @author Nathan Ghozlan
 */
public class HistoriqueCons {
    
    private int id;
    private String nom;
    private int idUtil;

    public HistoriqueCons() {
    }

    public HistoriqueCons(int id, String nom, int idUtil) {
        this.id = id;
        this.nom = nom;
        this.idUtil = idUtil;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getIdUtil() {
        return idUtil;
    }

    public void setIdUtil(int idUtil) {
        this.idUtil = idUtil;
    }
    
    
    
    
    
}
