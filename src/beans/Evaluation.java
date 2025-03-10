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
    private int id;
    private int enseignant_id;
    private int etudiant_id;
    private double note;
    private String commentaire;
     
   public Evaluation(int id, int enseignant_id, int etudiant_id, double note, String commentaire) {
        this.id = id;
        this.enseignant_id = enseignant_id;
        this.etudiant_id = etudiant_id;
        this.note = note;
        this.commentaire = commentaire;
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
     * @return the enseignant_id
     */
    public int getEnseignant_id() {
        return enseignant_id;
    }

    /**
     * @param enseignant_id the enseignant_id to set
     */
    public void setEnseignant_id(int enseignant_id) {
        this.enseignant_id = enseignant_id;
    }

    /**
     * @return the etudiant_id
     */
    public int getEtudiant_id() {
        return etudiant_id;
    }

    /**
     * @param etudiant_id the etudiant_id to set
     */
    public void setEtudiant_id(int etudiant_id) {
        this.etudiant_id = etudiant_id;
    }

    /**
     * @return the note
     */
    public double getNote() {
        return note;
    }

    /**
     * @param note the note to set
     */
    public void setNote(double note) {
        this.note = note;
    }

    /**
     * @return the commentaire
     */
    public String getCommentaire() {
        return commentaire;
    }

    /**
     * @param commentaire the commentaire to set
     */
    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }
   
}
