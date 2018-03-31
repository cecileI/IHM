package ihm.controler;

import ihm.model.Classe;
import ihm.model.Eleve;
import ihm.model.Exercice;
import ihm.model.Tentative;
import ihm.view.MenuEleve;
import ihm.view.VisuTentativeEleve;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;

/**
 * Controlleur de la jtable des tentatives d'un élève donné
 * Il permet de gérer les actions effectuées sur la jtable
 * @author Group 7
 */
public class controllerTentative implements ListSelectionListener{
    
    private JTable jtable;
    private ArrayList<Tentative> tentative;
    private MenuEleve menuEleve;

    /**
     * Constructeur du controller pour la jtable des exercices dans le menu élève
     * @param jtable la jtable regroupant les différents exercices
     * @param tentatives liste des tentatives
     * @param menuEleve interface du menu eleve
     */
    public controllerTentative(JTable jtable, ArrayList<Tentative> tentative, MenuEleve menuEleve) {
	this.jtable = jtable;
	this.tentative = tentative;
	this.menuEleve = menuEleve;
    }
    
    /**
     * Fonction de gestion des actions sur la jtable
     * @param e action effectuée sur la jtable
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
           Tentative selectTentative = tentative.get(jtable.convertRowIndexToModel(selectligne));
           System.out.println("La ligne"+ selectTentative.toString()+" est sélectionnée");
           menuEleve.afficheInfoTentative(selectTentative); //effectue les actions voulues
        }
     
    }  
    
}

