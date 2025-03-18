/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import beans.Enseignant;
import connexion.Connexion;
import dao.IDao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hp
 */
public class EnseignantService implements IDao<Enseignant> {

    
    private Connexion connexion;

    public EnseignantService() {
        connexion = Connexion.getInstance();
    }

    @Override
    public boolean create(Enseignant enseignant) {
        String req = "INSERT INTO Enseignant (nom, prenom, matiere) VALUES (?, ?, ?)";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setString(1, enseignant.getNom());
            ps.setString(2, enseignant.getPrenom());
            ps.setString(3, enseignant.getMatiere());
            ps.executeUpdate();
            return true;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public Enseignant findById(int id) {
        String req = "SELECT * FROM Enseignant WHERE id = ?";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Enseignant(rs.getInt("id"), rs.getString("nom"), rs.getString("prenom"), rs.getString("matiere"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    @Override
public List<Enseignant> findAll() {
    List<Enseignant> enseignants = new ArrayList<>();
    String req = "SELECT * FROM Enseignant";
    try {
        PreparedStatement ps = connexion.getCn().prepareStatement(req);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            enseignants.add(new Enseignant(
                    rs.getInt("id"),
                    rs.getString("nom"),
                    rs.getString("prenom"),
                    rs.getString("matiere")
            ));
        }
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    }
    return enseignants;
}


    @Override
    public boolean update(Enseignant enseignant) {
        String req = "UPDATE Enseignant SET nom = ?, prenom = ?, matiere = ? WHERE id = ?";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setString(1, enseignant.getNom());
            ps.setString(2, enseignant.getPrenom());
            ps.setString(3, enseignant.getMatiere());
            ps.setInt(4, enseignant.getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
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
    List<Enseignant> result = new ArrayList<>();
    String req = "SELECT * FROM Enseignant WHERE nom LIKE ?";
    try {
        PreparedStatement ps = connexion.getCn().prepareStatement(req);
        ps.setString(1, "%" + nom + "%");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            result.add(new Enseignant(
                    rs.getInt("id"), 
                    rs.getString("nom"), 
                    rs.getString("prenom"), 
                    rs.getString("matiere")
            ));
        }
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    }
    return result;
}



    @Override
    public boolean delete(Enseignant enseignant) {
        String req = "DELETE FROM Enseignant WHERE id = ?";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setInt(1, enseignant.getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false; //To change body of generated methods, choose Tools | Templates.
    }
    

}
