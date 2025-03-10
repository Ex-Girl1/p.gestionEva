/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import beans.Etudiant;
import dao.IDao;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hp
 */
public class EtudiantService implements IDao<Etudiant>{
    private final List<Etudiant> etudiants = new ArrayList<>();

    @Override
    public boolean create(Etudiant etudiant) {
        return etudiants.add(etudiant);
    }

    @Override
    public Etudiant findById(int id) {
        return etudiants.stream().filter(e -> e.getId() == id).findFirst().orElse(null);
    }

    @Override
    public List<Etudiant> findAll() {
        return etudiants;
    }

    @Override
    public boolean update(Etudiant etudiant) {
        int index = etudiants.indexOf(findById(etudiant.getId()));
        if (index != -1) {
            etudiants.set(index, etudiant);
            return true;
        }
        return false;
    }

    

    @Override
    public boolean delete(Etudiant etudiant) {
       return etudiants.remove(etudiant);    }
}
    

