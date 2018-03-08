/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ihm.controler;

import static ihm.SQLiteJDBCDriverConnection.connect;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.*;
import java.util.ArrayList;
import ihm.model.*;
import ihm.view.View;


public class interactionExercice { 
    private ArrayList<Exercice> listeExercice;

  
   /**
 * Création de la liste d'exercice 
 * @author Group7
 */ 
  public ArrayList<Exercice> selectionListExercice () {
      
        listeExercice = new ArrayList<Exercice>();
        
        Connection recon = connect(); // connexion à la base de données
        Statement stmt = null;
        
        String sql = "select IdExercice, Titre, Modele, Consigne, ModeTortue form Exercice";
        
                try{
        stmt = recon.createStatement();
        
        ResultSet rs = stmt.executeQuery(sql); // applique la requête
        while (rs.next()) { // Parcours de la liste d'exercices 
            int idE = rs.getInt("IdExercice");
            String titre = rs.getString("Titre");
            String modele = rs.getString("Modele");
            String consigne = rs.getString("Consigne");
            String ModeTortue = rs.getString("ModeTortue");
            
            Exercice exo = new Exercice(idE, titre, modele, consigne, ModeTortue);
                    
            listeExercice.add(exo); 
                }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return listeExercice;
        
        
    }
  
  public ArrayList<Exercice> getExercices() {
		return listeExercice;
	}
 
    public void addExercice (int idE, String titre, String modele, String consigne, String ModeTortue, ArrayList<Exercice> listeExercice) {
        Exercice exo = new Exercice(idE, titre, modele, consigne, ModeTortue);
        Connection recon = connect(); // connexion à la base de données
        Statement stmt = null;
        String req ="insert into Exercice(Titre, Modele, Consigne, ModeTortue) values(titre, modele, consigne, ModeTortue)";
        try{
        stmt = recon.createStatement();
        ResultSet rs = stmt.executeQuery(req);
        listeExercice.add(exo);
                } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    
       //a mettre dans 
    public void modifyExercice(int idE, String titre, String modele, String consigne, String ModeTortue, ArrayList<Exercice> listexercice)
    {
        Connection recon = connect(); // connexion à la base de données
        Statement stmt = null;
     
        
    }
}

