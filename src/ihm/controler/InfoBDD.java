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
    private static ArrayList<Tentative> listeTentativeNE; //pour tentatives non-evaluees
    private static ArrayList<Tentative> listeTentativeUnEleve; //pour tentative d'un élève précis
    private static ArrayList<Professeur> listeProfesseur;
    private static ArrayList<Eleve> listeEleve,listeEleveClasse;
    private static ArrayList<Classe> listeClasse;
    private static ArrayList<Exercice>listeExercice;

    /**
    * Création de la liste Tentative (tentatives des exercices)
    */
    public static ArrayList<Tentative> selectionListTentative () {
        
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

                Tentative tent = new Tentative(idT,idEleve,idExercice,StatutTentative,ModelEleve);

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
    public static ArrayList<Tentative> selectionListTentativeNE () {
        listeTentativeNE = new ArrayList<Tentative>();

        Connection recon = connect();
        Statement stmt = null;
        String sql = "select IdTentative, IdEleve, IdExercice, StatutTentative, IdProf, ModelEleve from Tentative where StatutTentative='non-evalue'";
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

                Tentative tentNE = new Tentative(idT,idEleve,idExercice,StatutTentative,ModelEleve);
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
                System.out.println(nomProf);
                System.out.println(prenomProf);
                System.out.println(mdpProf);
                Professeur prof = new Professeur(idProf, nomProf,  prenomProf, mdpProf);

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
        String sql = "select IdEleve, NomEleve, PrenomEleve, Classe, IdProf from Eleve, Classe";       
        try{
            stmt = recon.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String  nomEleve = rs.getString("NomEleve"); 
                String  prenomEleve = rs.getString("PrenomEleve");
                String niveau = rs.getString("Classe");
                     
                
                for (Classe laclasse : selectionListClasse()){
                    if(laclasse.getNiveau().equals(niveau)){
                        Eleve eleve = new Eleve(nomEleve,  prenomEleve, laclasse);
                        listeEleve.add(eleve);
                    }
                }
                                         

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return listeEleve;
    }
    
    /**
    * Création de la liste des élèves d'une classe
    */
    public static ArrayList<Eleve> selectionListEleveClasse (Classe maclasse) {
        
        listeEleveClasse = new ArrayList<Eleve>();
        
        Connection recon = connect();
        Statement stmt = null;
        String niveau = maclasse.getNiveau();
        String sql = "select IdEleve, NomEleve, PrenomEleve, Classe from Eleve where Classe="+'"'+niveau+'"';

        try{
            stmt = recon.createStatement();

            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String  nomEleve = rs.getString("NomEleve"); 
                String  prenomEleve = rs.getString("PrenomEleve");
                
                Eleve eleve = new Eleve(nomEleve,prenomEleve,maclasse);
                listeEleveClasse.add(eleve);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return listeEleveClasse;
    }   
    
    /**
    * Création de la liste des classes
    */
    public static ArrayList<Classe> selectionListClasse () {
        
        listeClasse = new ArrayList<Classe>();
        
        Connection recon = connect();
        Statement stmt = null;            
        String sql = "select niveau,IdProf from Classe";
        
        try{
            stmt = recon.createStatement(); //permet de faire la connection

            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String  nomClasse = rs.getString("niveau");
                int prof = rs.getInt("IdProf");
                
                Classe classe = new Classe(nomClasse);

                listeClasse.add(classe);                          
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return listeClasse;
    }   

    /**
     * Création d'une liste de tentatives avec leurs statuts pour un elève donné 
     */
    public static ArrayList<Tentative> selectionListTentativeUnEleve (Eleve el){
        listeTentativeUnEleve = new ArrayList<Tentative>();
        
        Connection recon = connect();
        Statement stmt = null;
        String Nom = el.getNomEleve();
        System.out.println(Nom);
        String sq = "select IdTentative,Eleve.IdEleve,IdExercice,StatutTentative,IdProf,ModeleEleve from Tentative,Eleve where NomEleve="+'"'+Nom+'"';       
        
        try{
            System.out.println("try");
            stmt = recon.createStatement();
        
            ResultSet rs = stmt.executeQuery(sq); // applique la requête
            System.out.println(rs);
            while (rs.next()) { // Parcours de la liste d'exercices 
                System.out.println("while");
                int idT = rs.getInt("IdTentative");
                String StatutTentative = rs.getString("StatutTentative");
                System.out.println("infobdd :");
                System.out.println(StatutTentative);
                int idE = rs.getInt("IdEleve");
                int idExo = rs.getInt("IdExercice");
                //int idP = rs.getInt("IdProf");
                String ModeleE = rs.getString("ModeleEleve");
                //String NomEleve = rs.getString(Nom);
                Tentative tent = new Tentative(idT,idE,idExo,StatutTentative,ModeleE);
                    
                listeTentativeUnEleve.add(tent); 
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return listeTentativeUnEleve;
              
       }
    
    
    
    /**
    * Création de la liste des Exercices
    */
    public static ArrayList<Exercice> selectionListExercice () {
      
        listeExercice = new ArrayList<Exercice>();
        
        Connection recon = connect(); // connexion à la base de données
        Statement stmt = null;
        
        String sql = "select IdExercice, Titre, Modele, Consigne, ModeTortue from Exercice";
        
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
     * Sauvegarde de la tentative d'un élève
     */
    public static void saveTentEleve(){
        //Tentative(int idTentative, int idEleve, int idExercice, String statutTentative,String modeleEleve)
        
    }

       
 
}
