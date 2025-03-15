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
public class Evaluation {
    private int id; // Ajout d'un ID unique
    private Enseignant enseignant;
    private Etudiant etudiant;
    private double note;
    private String commentaire;

    // Constructeur avec ID
    public Evaluation(int id, Enseignant enseignant, Etudiant etudiant, double note, String commentaire) {
        this.id = id;
        this.enseignant = enseignant;
        this.etudiant = etudiant;
        this.note = note;
        this.commentaire = commentaire;
    }

    // Constructeur sans ID (pour la création)
    public Evaluation(Enseignant enseignant, Etudiant etudiant, double note, String commentaire) {
        this.enseignant = enseignant;
        this.etudiant = etudiant;
        this.note = note;
        this.commentaire = commentaire;
    }

    // Getters et setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Enseignant getEnseignant() {
        return enseignant;
    }

    public void setEnseignant(Enseignant enseignant) {
        this.enseignant = enseignant;
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }

    public double getNote() {
        return note;
    }

    public void setNote(double note) {
        this.note = note;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }
}