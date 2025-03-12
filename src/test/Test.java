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
        enseignantService.create(new Enseignant(3, "Mohammed", "Ali", "informatique"));
        Enseignant enseignant =enseignantService .findById(1);
        if (enseignant != null) {
            System.out.println("Enseignant trouvée : " + enseignant.getNom());
        }
        enseignant.setMatiere("informatique");
        enseignantService.update(enseignant);
        System.out.println("Matiere d'enseignant  mis à jour : " + enseignantService.findById(1).getMatiere());
        
         List<Enseignant> enseignants = enseignantService.findAll();
        for (Enseignant e : enseignants) {
            System.out.println(e.getNom() + " - " + e.getPrenom() + " - " + e.getMatiere());
        }
        

        // Création d'étudiants
        etudiantService.create(new Etudiant(1, "Ali", "Ben", "ali@gmail.com"));
        etudiantService.create(new Etudiant(2, "Sara", "Lem", "sara@gmail.com"));
        

       Etudiant etudiant = etudiantService.findById(1);
        if (etudiant != null) {
            System.out.println("Étudiant trouvé : " + etudiant.getNom() + " " + etudiant.getPrenom() +" " +etudiant.getEmail());
        }
        etudiant.setEmail("ali.new@example.com");
        etudiantService.update(etudiant);
        System.out.println("Email de l'étudiant mis à jour : " + etudiantService.findById(1).getEmail());
        
        List<Etudiant> etudiants = etudiantService.findAll();
        for (Etudiant et : etudiants) {
            System.out.println(et.getNom() + " " + et.getPrenom() + " - " + et.getEmail());
        }


// Vérification de la création des étudiants
        System.out.println("Étudiants enregistrés : " + etudiantService.findAll());

        // Création d'évaluations
       

        evaluationService.create(new Evaluation(enseignantService.findById(1) ,etudiantService.findById(1), 85.0, "Très bonne performance"));
        evaluationService.create(new Evaluation(enseignantService.findById(2) ,etudiantService.findById(2),90.0, "Excellente participation"));


        // Vérification des évaluations
        List<Evaluation> evaluations = evaluationService.findAll();
        for (Evaluation eva : evaluations) {
            System.out.println("Evaluation : " + eva.getEtudiant_id().getNom() + " est passer l'evaluation par " + eva.getEnseignant_id().getNom());
        }

        Evaluation evaluationToDelete = evaluationService.findAll().get(0);
        evaluationService.delete(evaluationToDelete);
        System.out.println("Evaluation supprimée : " + evaluationToDelete.getEtudiant_id().getNom() + " - " + evaluationToDelete.getEnseignant_id().getNom());

        System.out.println("\nEvaluation restantes :");
        for (Evaluation eva : evaluationService.findAll()) {
            System.out.println(eva.getEnseignant_id().getNom() + "Evaluation  : " + eva.getEtudiant_id().getNom() + " est passer l'evaluation par  ");
        }
    }

}
