package ihm.controler;

import static ihm.SQLiteJDBCDriverConnection.connect;
import ihm.model.Exercice;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import ihm.controler.InfoBDD;

/**
 *
 * @author Goup7
 */
public class controllerFunction {

    public controllerFunction() {
    }
       
 
    /**
    *
    * Fonction qui ajoute un nouveau exercice
    */
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

    
    
    /**
    *
    * Fonction qui modifie un exercice: modifié titre et contenu
    *   si titre non modifé : juste update de ce qui a été modifié dans l'exercice   
    *   sinon si il a modifié le titre : supprimer et créer nouveau exercice
    */
    
    public void modifyExercice(int idE, String T, String M, String C, String MT, ArrayList<Exercice> listexercice)
    {
        String titre = T;   //Titre = BDD ancien titre |  titre= nouveau titre |
        int idetudiant = idE;
        String modele = M;
        String consigne = C;
        String modetortue = MT;
        
        
        Connection recon = connect(); // connexion à la base de données
        Statement stmt = null;
        
     
        if (titre == Titre){    
        //titre non modifié : update des paramètres
            
        String req ="update Exercice(idE,Modele, Consigne, ModeTortue) values(idetudiant, modele, consigne, ModeTortue)";
            
        try{
        stmt = recon.createStatement();
        ResultSet rs = stmt.executeQuery(req); // applique la requête
            while (rs.next()) { // Parcours de la liste d'exercices 
                int IdExercice = rs.getInt("IdExercice");
                //String Titre = rs.getString("Titre");
                String Modele = rs.getString("Modele");
                String Consigne = rs.getString("Consigne");
                String ModeTortue = rs.getString("ModeTortue");
            }
        
        }
        catch (SQLException e) {
        System.out.println(e.getMessage());}
      
        String sql = "select IdExercice, Titre, Modele, Consigne, ModeTortue form Exercice";
         
        
        else {
        //si titre modifié
        
        //suppression de l'exercice
            
        //Exercice exo = new Exercice(idE, titre, modele, consigne, ModeTortue);
        
        String del ="delete from Exercice where 'Titre'=T)";
              
        
        try{
        stmt = recon.createStatement();
        ResultSet rs = stmt.executeQuery(del);
        
        
        addExercice(int idE, String titre, String modele, String consigne, String ModeTortue, ArrayList<Exercice> listeExercice)
      
       
        }
        catch (SQLException e) {
        System.out.println(e.getMessage());}
              
                  
        }
    }
}               