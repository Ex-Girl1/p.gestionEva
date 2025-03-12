/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestevaense;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author hp
 */
public class GestEvaEnse {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
         String url;
         url = "jdbc:mysql://localhost:3306/gevaluationenes";
        String login = "root";
        String password = "";
        Connection cn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cn = DriverManager.getConnection(url, login, password);
        
            String req;
             req = "INSERT INTO etudiant(nom, prenom, email) VALUES ('Ali', 'Ben', 'ali@gmail.com');";
       
            Statement st = cn.createStatement();
            st.executeUpdate(req);
           
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver introvable");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    }
    

