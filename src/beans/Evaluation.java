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
    
    private Enseignant enseignant;
    private Etudiant etudiant;
    private double note;
    private String commentaire;

    public Evaluation( Enseignant enseignant, Etudiant etudiant, double note, String commentaire) {
      
        this.enseignant = enseignant;
        this.etudiant = etudiant;
        this.note = note;
        this.commentaire = commentaire;
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

    @Override
    public String toString() {
        return "Evaluation{" + "enseignant=" + enseignant + ", etudiant=" + etudiant + ", note=" + note + ", commentaire=" + commentaire + '}';
    }
    
}