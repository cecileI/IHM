package ihm.controler;

import static ihm.SQLiteJDBCDriverConnection.connect;
import ihm.model.Eleve;
import ihm.model.Exercice;
import ihm.model.Professeur;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Goup7
 */
public class controllerFunction {

 
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
    * Fonction qui modifie un exercice
    */
    public void modifyExercice(int idE, String titre, String modele, String consigne, String ModeTortue, ArrayList<Exercice> listexercice)
    {
        Connection recon = connect(); // connexion à la base de données
        Statement stmt = null;     
        
        
    }

    
}
