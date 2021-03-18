/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.esic.model;

import java.sql.Date;

public class Historique {

    private int idOperation;
    private String TypeOperations;
    private int montantOperations;
    private Date dateOperations;
    private Person person;
    private Compte compte;

    public Historique() {
    }

    public Historique(String TypeOperations, int montantOperations, Date dateOperations, Person person, Compte compte) {
        this.TypeOperations = TypeOperations;
        this.montantOperations = montantOperations;
        this.dateOperations = dateOperations;
        this.person = person;
        this.compte = compte;
    }

    public int getIdOperation() {
        return idOperation;
    }

    public void setIdOperation(int idOperation) {
        this.idOperation = idOperation;
    }

    public String getTypeOperations() {
        return TypeOperations;
    }

    public void setTypeOperations(String TypeOperations) {
        this.TypeOperations = TypeOperations;
    }

    public int getMontantOperations() {
        return montantOperations;
    }

    public void setMontantOperations(int montantOperations) {
        this.montantOperations = montantOperations;
    }

    public Date getDateOperations() {
        return dateOperations;
    }

    public void setDateOperations(Date dateOperations) {
        this.dateOperations = dateOperations;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
    
    public Compte getCompte() {
        return compte;
    }

    public void setCompte(Compte compte) {
        this.compte = compte;
    }

}
