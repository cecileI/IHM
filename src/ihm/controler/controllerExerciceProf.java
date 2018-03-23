/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ihm.controler;

import static ihm.SQLiteJDBCDriverConnection.connect;
import ihm.model.Exercice;
import ihm.view.ListeExercicesProf;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;

/**
 * pour afficher la liste des Exercices et gérer les exercices
 * @author Diane
 */
public class controllerExerciceProf implements ListSelectionListener{
    private JTable jtable;
    private ArrayList<Exercice> exercices;
    private ListeExercicesProf listexo;
    
    /**
     * Constructeur du controller pour la jtable des exercices
     * @param jtable la jtable regroupant les différents exercices
     * @param exercices liste des exercices
     * @param lisexo interface ListeExercicesProf
     */
    public controllerExerciceProf(JTable jtable, ArrayList<Exercice> exercices, ListeExercicesProf listexo) {
	this.jtable = jtable;
	this.exercices = exercices;
        this.listexo = listexo;
	
    }
    
    /**
     * Fonction de gestion des actions sur la jtable : afficher la liste des Exercices dans la BDD
     * @param e action effectuée sur la jtable
     * @param listexo interface du ListeExercicesProf
     */
    public void valueChanged(ListSelectionEvent e) {
        if (e.getValueIsAdjusting()){
            return;
        }
        ListSelectionModel selectmodel = (ListSelectionModel) e.getSource();
          
        if (selectmodel.isSelectionEmpty()){ //si il n'y a rien de sélectionné
            System.out.println("Pas de ligne selectionnée"); 
        }
        else { //si un élément est sélectionné
           int selectligne = selectmodel.getMinSelectionIndex();
           Exercice selectExercice = exercices.get(jtable.convertRowIndexToModel(selectligne));
           System.out.println("La ligne"+ selectExercice.toString()+" est sélectionnée");
           
           listexo.afficheInfo(selectExercice); //effectue les actions voulues, ici, fait apparaitre les boutons faire ou visualiser tentatives
        }
     
    }   
    
    
//    public void addExercice (int idE, String titre, String modele, String consigne, String ModeTortue, ArrayList<Exercice> listeExercice) {
//        Exercice exo = new Exercice(idE, titre, modele, consigne, ModeTortue);
//        Connection recon = connect(); // connexion à la base de données
//        Statement stmt = null;
//        String req ="insert into Exercice(Titre, Modele, Consigne, ModeTortue) values(titre, modele, consigne, ModeTortue)";
//        try{
//        stmt = recon.createStatement();
//        ResultSet rs = stmt.executeQuery(req);
//        listeExercice.add(exo);
//                } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//    }
        
    /**
    *
    * Fonction qui modifie un exercice: A REVOIR!!!
    */
//    public void modifyExercice(Exercice){
//        Connection recon = connect(); // connexion à la base de données
//        Statement stmt = null;
//        //execice = new Exercice
//        
//        //on ne connait pas l'idE
//        //retrouver exercice avec le titre de l'exercice
//        
//        
//        String sql="select Exercice titre, modele, consigne, ModeTortue WHERE titre = 'nouveautitre'";
//        
//        //valeurs que le professeur saisit pour mettre à jour l'exercice avec l'idE=idexamodifier:
//        //nouveautitre - newmodel - newconsigne - newmode
//        
//        try {
//             stmt = recon.createStatement();
//             ResultSet rs = stmt.executeQuery(sql); //stmt.executeUpdate(sql);
//             rs.first();
//             
//            //Modification par le professeur : rs.getString dans des JTextField ! = interface!
//            //rs.getString("titre") 
//            //rs.getString("newmodel"));
//            //rs.getString("newconsigne"));
//            //rs.getString("newmode"));                        
//            
//            //On met à jour les champs
//             rs.updateString("titre","nouveautitre");
//             rs.updateString("modele","newmodel");
//             rs.updateString("consigne","newconsigne");
//             rs.updateString("ModeTortue","newmode");            
//
//            //On valide
//             rs.updateRow();
//             JOptionPane.showMessageDialog(null,"Modification réalisée","ALERTE",JOptionPane.INFORMATION_MESSAGE);
//             
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//    } 
}
