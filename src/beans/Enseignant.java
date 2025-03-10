/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/**
 *
 * @author hp
 */
public class Enseignant {
 
    private int id;
    private String nom;
    private String prenom;
    private String matiere;
    
    public Enseignant(int id, String nom, String prenom, String matiere) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.matiere = matiere;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @param nom the nom to set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * @return the prenom
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * @param prenom the prenom to set
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * @return the matiere
     */
    public String getMatiere() {
        return matiere;
    }

    /**
     * @param matiere the matiere to set
     */
    public void setMatiere(String matiere) {
        this.matiere = matiere;
    }
    
}
