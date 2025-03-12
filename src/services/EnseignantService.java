/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import beans.Enseignant;
import dao.IDao;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author hp
 */
public class EnseignantService implements IDao<Enseignant>  {
    private final List<Enseignant> enseignants = new ArrayList<>();

    @Override
    public boolean create(Enseignant enseignant) {
        return enseignants.add(enseignant); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Enseignant findById(int id) {
        return enseignants.stream().filter(e -> e.getId() == id).findFirst().orElse(null);
    }

    @Override
    public List<Enseignant> findAll() {
        return enseignants;
    }

    @Override
    public boolean update(Enseignant enseignant) {
        int index = enseignants.indexOf(findById(enseignant.getId()));
        if (index != -1) {
            enseignants.set(index, enseignant);
            return true;
        }
        return false;
    }

    /**
     *
     * @param id
     * @return
     */
   
    /**
     *
     * @param nom
     * @param id
     * @return
     */
    public List<Enseignant> rechercherEnseignant(String nom) {
        return enseignants.stream()
                .filter(e -> e.getNom().equalsIgnoreCase(nom))
                .collect(Collectors.toList());
    }

    @Override
    public boolean delete(Enseignant enseignant) {
         return enseignants.remove(enseignant); //To change body of generated methods, choose Tools | Templates.
    }


}

    

    
    

