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

        // Modification de l'enseignant Dupont
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
        etudiantService.create(new Etudiant(3, "Mery", "Ham", "mery@gmail.com"));

        // Modification d'un étudiant
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

        // Création de plusieurs évaluations
        Evaluation[] evaluationsArray = {
            new Evaluation(enseignant, etudiant, 85.0, "Très bonne performance"),
            new Evaluation(enseignant, etudiant, 90.0, "Excellente participation"),
            new Evaluation(enseignant, etudiant, 100.0, "Very good")
        };

        for (Evaluation eval : evaluationsArray) {
            if (evaluationService.create(eval)) {
                System.out.println("Évaluation ajoutée avec succès !");
            }
        }

        // Création de nouvelles évaluations pour d'autres enseignants et étudiants
        Enseignant enseignant2 = enseignantService.findById(2);
        Enseignant enseignant3 = enseignantService.findById(3);

        Etudiant etudiant2 = etudiantService.findById(2);
        Etudiant etudiant3 = etudiantService.findById(3);

        Evaluation[] newEvaluations = {
            new Evaluation(enseignant2, etudiant2, 75.0, "Participation satisfaisante"),
            new Evaluation(enseignant3, etudiant3, 92.0, "Très bon niveau en arabe"),
            new Evaluation(enseignant2, etudiant3, 88.0, "Bonne compréhension des concepts"),
            new Evaluation(enseignant3, etudiant2, 81.0, "Participation active en classe")
        };

        for (Evaluation eval : newEvaluations) {
            if (evaluationService.create(eval)) {
                System.out.println("Évaluation ajoutée avec succès !");
            }
        }

        // Affichage de toutes les évaluations
        List<Evaluation> evaluations = evaluationService.findAll();
        System.out.println("\nListe complète des évaluations :");
        for (Evaluation eval : evaluations) {
            System.out.println(eval.getEtudiant().getNom() + " " + eval.getEtudiant().getPrenom() + " a été évalué par " + eval.getEnseignant().getNom()
                    + " (" + eval.getEnseignant().getMatiere() + ") avec la note " + eval.getNote() + " - Commentaire : " + eval.getCommentaire());
        }
    }
}
