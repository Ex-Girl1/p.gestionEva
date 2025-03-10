/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import beans.Evaluation;
import dao.IDao;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author hp
 */
public class EvaluationService implements IDao<Evaluation>{
    private List<Evaluation> evaluations = new ArrayList<>();
    

    @Override
    public boolean create(Evaluation evaluation) {
        return evaluations.add(evaluation);
    }

    @Override
    public Evaluation findById(int id) {
        return evaluations.stream().filter(e -> e.getId() == id).findFirst().orElse(null);
    }

    @Override
    public List<Evaluation> findAll() {
        return evaluations;
    }

    @Override
    public boolean update(Evaluation evaluation) {
        int index = evaluations.indexOf(findById(evaluation.getId()));
        if (index != -1) {
            evaluations.set(index, evaluation);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Evaluation evaluation) {
        return evaluations.remove(evaluation);
    }

    public List<Evaluation> filtrerParEnseignant(int enseignantId) {
        return evaluations.stream()
                .filter(e -> e.getEnseignant_id() == enseignantId)
                .collect(Collectors.toList());
    }

    public List<String> consulterCommentaires(int enseignantId) {
        return evaluations.stream()
                .filter(e -> e.getEnseignant_id() == enseignantId)
                .map(Evaluation::getCommentaire)
                .collect(Collectors.toList());
    }
    
}
