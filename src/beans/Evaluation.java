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
    private Enseignant enseignant_id;
    private Etudiant etudiant_id;
    private double note;
    private String commentaire;

    // Constructeur principal
    public Evaluation( Enseignant enseignant_id, Etudiant etudiant_id, double note, String commentaire) {
        this.enseignant_id = enseignant_id;
        this.etudiant_id = etudiant_id;
        this.note = note;
        this.commentaire = commentaire;
    }

    // Getters et Setters
   

    public Enseignant getEnseignant_id() {
        return enseignant_id;
    }

    public void setEnseignant_id(Enseignant enseignant_id) {
        this.enseignant_id = enseignant_id;
    }

    public Etudiant getEtudiant_id() {
        return etudiant_id;
    }

    public void setEtudiant_id(Etudiant etudiant_id) {
        this.etudiant_id = etudiant_id;
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