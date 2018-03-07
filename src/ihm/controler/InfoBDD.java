/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ihm.controler;

import static ihm.SQLiteJDBCDriverConnection.connect;
import ihm.model.Professeur;
import ihm.model.Tentative;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Group7
 */
public class InfoBDD {
    private ArrayList<Tentative> listeTentative;
    private ArrayList<Professeur> listeProfesseur;
    
    //Création de la liste Tentative (tentatives des exercices)
    
    public ArrayList<Tentative> selectionListTentative () {
        
        listeTentative = new ArrayList<Tentative>();
        
        
        Connection recon = connect();
        Statement stmt = null;
        
        
        String sql = "select IdTentative, IdEleve, IdExercice, StatutTentative, IdProf, ModelEleve from Tentative";
        
        
        try{
            stmt = recon.createStatement();

            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int idT = rs.getInt("IdTentative");
                int idEleve = rs.getInt("IdEleve");
                int  idExercice = rs.getInt("IdExercice"); 
                String StatutTentative = rs.getString("StatutTentative");
                int idProf = rs.getInt("IdProf");
                String ModelEleve = rs.getString("ModelEleve");

                Tentative tent = new Tentative(idT,idEleve,idExercice,StatutTentative,idProf,ModelEleve);

                listeTentative.add(tent);                          
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return listeTentative;
          
    }
    
    //Création de la liste Professeur
    public ArrayList<Professeur> selectionListProfesseur () {
        
        listeProfesseur = new ArrayList<Professeur>();
        
        Connection recon = connect();
        Statement stmt = null;            
        String sql = "select IdProf, NomProf, PrenomProf, MdpProf from Professeur";
        
        try{
            stmt = recon.createStatement();

            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int idProf = rs.getInt("IdProf");
                String  nomProf = rs.getString("NomProf"); 
                String  prenomProf = rs.getString("PrenomProf");
                String  mdpProf = rs.getString("MdpProf"); 
                
                Professeur prof = new Professeur(idProf,nomProf,  prenomProf, mdpProf);

                listeProfesseur.add(prof);                          
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return listeProfesseur;
    }
    
    
    
    
}
