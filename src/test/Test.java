/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import beans.Enseignant;
import beans.Etudiant;
import beans.Evaluation;
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

        // Création d'étudiants
        Etudiant etudiant1 = new Etudiant(1, "Ali", "Ben", "ali@gmail.com");
        Etudiant etudiant2 = new Etudiant(2, "Sara", "Lem", "sara@gmail.com");
        etudiantService.create(etudiant1);
        etudiantService.create(etudiant2);

        // Suppression d'un étudiant
        etudiantService.delete(etudiant1);

        // Vérification de la création
        System.out.println("Étudiants enregistrés : " + etudiantService.findAll());

        // Création d'évaluations
        Evaluation eval1 = new Evaluation(1, 1, 1, 4.5, "Bon cours");
        Evaluation eval2 = new Evaluation(2, 2, 1, 4.0, "Enseignant dynamique");
        evaluationService.create(eval1);
        evaluationService.create(eval2);

        // Suppression d'une évaluation
        evaluationService.delete(eval1);

        // Vérification des évaluations
        System.out.println("Toutes les évaluations : " + evaluationService.findAll());
        System.out.println("Commentaires de l'enseignant 1 : " + evaluationService.consulterCommentaires(1));
    }
}
