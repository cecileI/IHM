package ihm.controler;

import static ihm.SQLiteJDBCDriverConnection.connect;
import ihm.model.Classe;
import ihm.model.Eleve;
import ihm.model.Exercice;
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

    private static ArrayList<Tentative> listeTentative;
    private static ArrayList<Tentative> listeTentativeNE;
    private static ArrayList<Professeur> listeProfesseur;
    private static ArrayList<Eleve> listeEleve;
    private static ArrayList<Classe> listeClasse;
    private static ArrayList<Exercice>listeExercice;

    /**
    * Création de la liste Tentative (tentatives des exercices)
    */
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
    
    
     /**
    * Création de la liste des Tentatives NON-EVALUEES : StatutTentative non-evalué
    */
    public ArrayList<Tentative> selectionListTentativeNE () {
        listeTentativeNE = new ArrayList<Tentative>();

        Connection recon = connect();
        Statement stmt = null;
        String sql = "select IdTentative, IdEleve, IdExercice, StatutTentative, IdProf, ModelEleve from Tentative where StatutTentative='Non-Evalue'";
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

                Tentative tentNE = new Tentative(idT,idEleve,idExercice,StatutTentative,idProf,ModelEleve);
                listeTentativeNE.add(tentNE);                          
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return listeTentativeNE;
    }
    
   
    /**
    * Création de la liste des Professeurs
    */
    public static ArrayList<Professeur> selectionListProfesseur () {
        
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
    
    /**
    * Création de la liste des Eleves
    */
    public static ArrayList<Eleve> selectionListEleve () {
        
        listeEleve = new ArrayList<Eleve>();
        
        Connection recon = connect();
        Statement stmt = null;            
        String sql = "select IdEleve, NomEleve, PrenomEleve, Classe from Eleve";
        
        try{
            stmt = recon.createStatement();

            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int idEleve = rs.getInt("IdEleve");
                String  nomEleve = rs.getString("NomEleve"); 
                String  prenomEleve = rs.getString("PrenomEleve");
              //  Classe classe = rs.getString("Classe");
                
                //Eleve eleve = new Eleve(idEleve,nomEleve,  prenomEleve, classe);

                //listeEleve.add(eleve);                          
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return listeEleve;
    }
    
    /**
    * Création de la liste de classe
    */
    public static ArrayList<Classe> selectionListClasse () {
        
        listeClasse = new ArrayList<Classe>();
        
        Connection recon = connect();
        Statement stmt = null;            
        String sql = "select Niveau IdProf from Classe";
        
        try{
            stmt = recon.createStatement(); //permet de faire la connection

            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String  nomClasse = rs.getString("Niveau");
                int prof = rs.getInt("Prof");
                
                Classe classe = new Classe(nomClasse,prof);

                listeClasse.add(classe);                          
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return listeClasse;
    }   

    
    /**
    * Création de la liste des Exercices
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

      
    /**
    * Récupérer la liste des Exercices
    */
        public ArrayList<Exercice> getExercices() {
		return listeExercice;
	}

        
 
}
