/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import beans.Enseignant;
import beans.Etudiant;
import beans.Evaluation;
import dao.IDao;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import connexion.Connexion;
import java.sql.ResultSet;

/**
 *
 * @author hp
 */
public class EvaluationService implements IDao<Evaluation>{
    private List<Evaluation> evaluations = new ArrayList<>();
    private Connexion connexion;
    
    private EnseignantService cs;
    private EtudiantService es;

    


    @Override
    public boolean create(Evaluation evaluation) {
        String req = "INSERT INTO Evaluation (enseignant_id, etudiant_id, note, commentaire) VALUES (?, ?, ?, ?)";
    try {
        PreparedStatement ps = connexion.getCn().prepareStatement(req);
        ps.setInt(1, evaluation.getEnseignant_id().getId()); // ID de l'enseignant
        ps.setInt(2, evaluation.getEtudiant_id().getId()); // ID de l'étudiant
        ps.setDouble(3, evaluation.getNote()); // Note
        ps.setString(4, evaluation.getCommentaire()); // Commentaire
        ps.executeUpdate();
        return true;
    } catch (SQLException ex) {
        System.out.println("Erreur lors de l'insertion de l'évaluation : " + ex.getMessage());
    }
        return false;
    }

    @Override
    public Evaluation findById(int id) {
        return null;
    }

    @Override
    public List<Evaluation> findAll() {
        List<Evaluation> evaluations = new ArrayList<>();
    String req = "SELECT * FROM Evaluation";
    try {
        PreparedStatement ps = connexion.getCn().prepareStatement(req);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Enseignant enseignant = cs.findById(rs.getInt("enseignant_id")); // Assurez-vous d'avoir un service pour les enseignants
            Etudiant etudiant = es.findById(rs.getInt("etudiant_id")); // Assurez-vous d'avoir un service pour les étudiants
            double note = rs.getDouble("note");
            String commentaire = rs.getString("commentaire");
            evaluations.add(new Evaluation(enseignant, etudiant, note, commentaire)); // Ajustez le constructeur si nécessaire
        }
    } catch (SQLException ex) {
        System.out.println("Erreur lors de la récupération des évaluations : " + ex.getMessage());
    }
    return evaluations;
    }

    @Override
    public boolean update(Evaluation evaluation) {
         String req = "UPDATE Evaluation SET note = ?, commentaire = ? WHERE enseignant_id = ? AND etudiant_id = ?";
    try {
        PreparedStatement ps = connexion.getCn().prepareStatement(req);
        ps.setDouble(1, evaluation.getNote()); // Met à jour la note
        ps.setString(2, evaluation.getCommentaire()); // Met à jour le commentaire
        ps.setInt(3, evaluation.getEnseignant_id().getId()); // ID de l'enseignant
        ps.setInt(4, evaluation.getEtudiant_id().getId()); // ID de l'étudiant
        ps.executeUpdate();
        return true;
    } catch (SQLException ex) {
        System.out.println("Erreur lors de la mise à jour de l'évaluation : " + ex.getMessage());
    }
    return false;
    }
    
    @Override
    public boolean delete(Evaluation evaluation) {
        String req = "DELETE FROM Evaluation WHERE enseignant_id = ? AND etudiant_id = ?";
    try {
        PreparedStatement ps = connexion.getCn().prepareStatement(req);
        ps.setInt(1, evaluation.getEnseignant_id().getId()); // ID de l'enseignant
        ps.setInt(2, evaluation.getEtudiant_id().getId()); // ID de l'étudiant
        ps.executeUpdate();
        return true;
    } catch (SQLException ex) {
        System.out.println("Erreur lors de la suppression de l'évaluation : " + ex.getMessage());
    }
    return false;
    }

    public List<Evaluation> filtrerParEnseignant(int enseignantId) {
    return evaluations.stream()
            .filter(e -> e.getEnseignant_id().getId() == enseignantId) // Assurez-vous que getId() retourne l'ID de l'enseignant
            .collect(Collectors.toList());
}

    public List<String> consulterCommentaires(int enseignantId) {
        return evaluations.stream()
                .filter(e -> e.getEnseignant_id().getId() == enseignantId)
                .map(Evaluation::getCommentaire)
                .collect(Collectors.toList());
    }
    
}
