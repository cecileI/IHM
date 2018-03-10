package ihm.controler;

import static ihm.SQLiteJDBCDriverConnection.connect;
import ihm.model.Exercice;
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
    * Fonction qui modifie un exercice
    */
    public void modifyExercice(int idE, String titre, String modele, String consigne, String ModeTortue, ArrayList<Exercice> listexercice)
    {
        Connection recon = connect(); // connexion à la base de données
        Statement stmt = null;
        
        
//        public void modifier_entreprise(Entreprise entreprise)
//        {
//        String requete = null;
//         
//        try {
//             requete = "UPDATE entreprise SET Nom = '"+entreprise.getNom()+"'"
//             + "WHERE Code = '"+entreprise.getCode()+"'";
//             Statement state = ocon.createStatement();
//             state.executeUpdate(requete);
//             JOptionPane.showMessageDialog(null,"Modification réalisée","ALERTE",JOptionPane.INFORMATION_MESSAGE);
//               
//             
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null,"Modification non effectué","ALERTE",JOptionPane.ERROR_MESSAGE);
//            e.printStackTrace();
//        }

//  ---------------------------------------------------- autre ex avec modif de Joueur:
//public static void main(String[] args) {
// 
//    try {
// 
//      //On va chercher une ligne dans la base de données
//      String query = "SELECT joueur_nom, joueur_num, joueur_poste FROM joueur " + "WHERE joueur_nom = 'test'";         
// 
//      ResultSet res = state.executeQuery(query);
// 
//      res.first();
// 
//      //On affiche ce que l'on trouve
//      System.out.println("NOM : " + res.getString("joueur_nom") + " - numero : " + res.getInt("joueur_poste"));
// 
//      //On met à jour les champs
//      res.updateString("joueur_nom", "test");
//      res.updateInt("joueur_num", "1");
//      res.updateInt("joueur_poste", "11");
// 
//      //On valide
//      res.updateRow();
// 
//      //On affiche les modifications
//      System.out.println("*********************************");
//      System.out.println("APRES MODIFICATION : ");
//      System.out.println("\tNOM : " + res.getString("prof_nom") + " - PRENOM : " + res.getString("prof_prenom") + "\n");
//      System.out.println("NOM : " + res.getString("joueur_nom") + " - numero : " + res.getInt("joueur_poste"));
// 
//      result.close();
// 
//      state.close();
//         
//    }
        
        
        
    }
}
