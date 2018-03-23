/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ihm.controler;

import static ihm.SQLiteJDBCDriverConnection.connect;
import ihm.model.Exercice;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Diane
 */
public class controllerExerciceProf {
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
    public void modifyExercice(Exercice){
        Connection recon = connect(); // connexion à la base de données
        Statement stmt = null;
        //execice = new Exercice
        
        //on ne connait pas l'idE
        //retrouver exercice avec le titre de l'exercice
        
        
        String sql="select Exercice titre, modele, consigne, ModeTortue WHERE titre = 'nouveautitre'";
        
        //valeurs que le professeur saisit pour mettre à jour l'exercice avec l'idE=idexamodifier:
        //nouveautitre - newmodel - newconsigne - newmode
        
        try {
             stmt = recon.createStatement();
             ResultSet rs = stmt.executeQuery(sql); //stmt.executeUpdate(sql);
             rs.first();
             
            //Modification par le professeur : rs.getString dans des JTextField ! = interface!
            //rs.getString("titre") 
            //rs.getString("newmodel"));
            //rs.getString("newconsigne"));
            //rs.getString("newmode"));                        
            
            //On met à jour les champs
             rs.updateString("titre","nouveautitre");
             rs.updateString("modele","newmodel");
             rs.updateString("consigne","newconsigne");
             rs.updateString("ModeTortue","newmode");            

            //On valide
             rs.updateRow();
             JOptionPane.showMessageDialog(null,"Modification réalisée","ALERTE",JOptionPane.INFORMATION_MESSAGE);
             
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    } 
}
