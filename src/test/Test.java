/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;
import beans.Enseignant;
import beans.Etudiant;
import beans.Evaluation;
import java.util.List;
import services.EnseignantService;
import services.EtudiantService;
import services.EvaluationService;
/**
 *
 * @author hp
 */

public class Test {
    public static void main(String[] args) {
        EnseignantService enseignantService = new EnseignantService();
        EtudiantService etudiantService = new EtudiantService();
        EvaluationService evaluationService = new EvaluationService();

        // Création d'enseignants
        enseignantService.create(new Enseignant(1, "Dupont", "Jean", "Mathématiques"));
        enseignantService.create(new Enseignant(2, "Martin", "Alice", "Physique"));
        enseignantService.create(new Enseignant(3, "Mohammed", "Ali", "Arabe"));

        // Récupération d'un enseignant pour modification
        Enseignant enseignant = enseignantService.findById(1);
        if (enseignant != null) {
            System.out.println("Enseignant trouvé : " + enseignant.getNom());
            enseignant.setMatiere("informatique");
            enseignantService.update(enseignant);
            System.out.println("Matière d'enseignant mise à jour : " + enseignantService.findById(1).getMatiere());
        }

        // Affichage des enseignants
        List<Enseignant> enseignants = enseignantService.findAll();
        for (Enseignant e : enseignants) {
            System.out.println(e.getNom() + " - " + e.getPrenom() + " - " + e.getMatiere());
        }

        // Création d'étudiants
        etudiantService.create(new Etudiant(1, "Ali", "Ben", "ali@gmail.com"));
        etudiantService.create(new Etudiant(2, "Sara", "Lem", "sara@gmail.com"));

        // Récupération d'un étudiant pour modification
        Etudiant etudiant = etudiantService.findById(1);
        if (etudiant != null) {
            System.out.println("Étudiant trouvé : " + etudiant.getNom() + " " + etudiant.getPrenom() + " " + etudiant.getEmail());
            etudiant.setEmail("ali.new@example.com");
            etudiantService.update(etudiant);
            System.out.println("Email de l'étudiant mis à jour : " + etudiantService.findById(1).getEmail());
        }

        // Affichage des étudiants
        List<Etudiant> etudiants = etudiantService.findAll();
        for (Etudiant et : etudiants) {
            System.out.println(et.getNom() + " " + et.getPrenom() + " - " + et.getEmail());
        }

        // Création d'évaluations
        boolean eval1 = evaluationService.create(new Evaluation(enseignant, etudiant, 85.0, "Très bonne performance"));
        boolean eval2 = evaluationService.create(new Evaluation(enseignant, etudiant, 90.0, "Excellente participation"));
        
        if (eval1) System.out.println("Évaluation 1 ajoutée avec succès !");
        if (eval2) System.out.println("Évaluation 2 ajoutée avec succès !");

        // Vérification des évaluations
        List<Evaluation> evaluations = evaluationService.findAll();
        for (Evaluation eva : evaluations) {
            System.out.println("Évaluation " + eva.getId() + " : " + eva.getEtudiant().getNom() + " a été évalué par " + eva.getEnseignant().getNom());
        }

        // Suppression d'une évaluation
        if (!evaluations.isEmpty()) {
            Evaluation evaluationToDelete = evaluations.get(0);
            evaluationService.delete(evaluationToDelete);
            System.out.println("Évaluation supprimée : " + evaluationToDelete.getEtudiant().getNom() + " - " + evaluationToDelete.getEnseignant().getNom());
        }

        // Affichage des évaluations restantes
        System.out.println("\nÉvaluations restantes :");
        evaluations = evaluationService.findAll();
        for (Evaluation eva : evaluations) {
            System.out.println("Évaluation " + eva.getId() + " : " + eva.getEnseignant().getNom() + " a évalué " + eva.getEtudiant().getNom());
        }
    }
}