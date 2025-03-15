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
import connexion.Connexion;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.Statement;

public class EvaluationService implements IDao<Evaluation> {

    private Connexion connexion = Connexion.getInstance();
    private EnseignantService enseignantService = new EnseignantService();
    private EtudiantService etudiantService = new EtudiantService();

    @Override
    public boolean create(Evaluation evaluation) {
        Enseignant enseignant = enseignantService.findById(evaluation.getEnseignant().getId());
        Etudiant etudiant = etudiantService.findById(evaluation.getEtudiant().getId());

        if (enseignant == null || etudiant == null) {
            System.out.println("Impossible de créer l'évaluation: enseignant ou étudiant non trouvé");
            return false;
        }

        String req = "INSERT INTO Evaluation (enseignant, etudiant, note, commentaire) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, evaluation.getEnseignant().getId());
            ps.setInt(2, evaluation.getEtudiant().getId());
            ps.setDouble(3, evaluation.getNote());
            ps.setString(4, evaluation.getCommentaire());
            int affectedRows = ps.executeUpdate();
            
            if (affectedRows == 0) {
                return false;
            }
            
            // Récupérer l'ID généré
            ResultSet generatedKeys = ps.getGeneratedKeys();
            if (generatedKeys.next()) {
                evaluation.setId(generatedKeys.getInt(1));
            }
            return true;
        } catch (SQLException ex) {
            System.out.println("Erreur lors de l'insertion de l'évaluation : " + ex.getMessage());
        }
        return false;
    }

    @Override
    public Evaluation findById(int id) {
        String req = "SELECT * FROM Evaluation WHERE id = ?";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Enseignant enseignant = enseignantService.findById(rs.getInt("enseignant"));
                Etudiant etudiant = etudiantService.findById(rs.getInt("etudiant"));
                double note = rs.getDouble("note");
                String commentaire = rs.getString("commentaire");
                return new Evaluation(id, enseignant, etudiant, note, commentaire);
            }
        } catch (SQLException ex) {
            System.out.println("Erreur lors de la recherche de l'évaluation : " + ex.getMessage());
        }
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
                int id = rs.getInt("id");
                Enseignant enseignant = enseignantService.findById(rs.getInt("enseignant"));
                Etudiant etudiant = etudiantService.findById(rs.getInt("etudiant"));
                double note = rs.getDouble("note");
                String commentaire = rs.getString("commentaire");
                evaluations.add(new Evaluation(id, enseignant, etudiant, note, commentaire));
            }
        } catch (SQLException ex) {
            System.out.println("Erreur lors de la récupération des évaluations : " + ex.getMessage());
        }
        return evaluations;
    }

    @Override
    public boolean update(Evaluation evaluation) {
        String req = "UPDATE Evaluation SET enseignant = ?, etudiant = ?, note = ?, commentaire = ? WHERE id = ?";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setInt(1, evaluation.getEnseignant().getId());
            ps.setInt(2, evaluation.getEtudiant().getId());
            ps.setDouble(3, evaluation.getNote());
            ps.setString(4, evaluation.getCommentaire());
            ps.setInt(5, evaluation.getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Erreur lors de la mise à jour de l'évaluation : " + ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean delete(Evaluation evaluation) {
        String req = "DELETE FROM Evaluation WHERE id = ?";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setInt(1, evaluation.getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Erreur lors de la suppression de l'évaluation : " + ex.getMessage());
        }
        return false;
    }

    public List<Evaluation> filtrerParEnseignant(Enseignant enseignant) {
        List<Evaluation> evaluations = new ArrayList<>();
        String req = "SELECT * FROM Evaluation WHERE enseignant = ?";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setInt(1, enseignant.getId());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                Etudiant etudiant = etudiantService.findById(rs.getInt("etudiant"));
                double note = rs.getDouble("note");
                String commentaire = rs.getString("commentaire");
                evaluations.add(new Evaluation(id, enseignant, etudiant, note, commentaire));
            }
        } catch (SQLException ex) {
            System.out.println("Erreur lors du filtrage des évaluations : " + ex.getMessage());
        }
        return evaluations;
    }

    public List<String> consulterCommentaires(Enseignant enseignant) {
        List<String> commentaires = new ArrayList<>();
        String req = "SELECT commentaire FROM Evaluation WHERE enseignant = ?";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setInt(1, enseignant.getId());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                commentaires.add(rs.getString("commentaire"));
            }
        } catch (SQLException ex) {
            System.out.println("Erreur lors de la consultation des commentaires : " + ex.getMessage());
        }
        return commentaires;
    }
}