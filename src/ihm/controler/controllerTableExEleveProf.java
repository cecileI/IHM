package ihm.controler;

import ihm.model.Classe;
import ihm.model.Eleve;
import ihm.model.Exercice;
import ihm.model.Tentative;
import ihm.view.MenuEleve;
import ihm.view.MenuProfesseur;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;

/**
 * Controleur de la jtable des exercices dans le menu eleve
 * Il permet de gérer les actions effectuées sur le jtable
 * @author Clara
 */
public class controllerTableExEleveProf implements ListSelectionListener{
    
    private JTable jtable;
    private ArrayList<Tentative> tentatives;
    private MenuProfesseur menuProf;

    /**
     * Constructeur du controller pour la jtable des exercices dans le menu élève
     * @param jtable la jtable regroupant les différents exercices
     * @param exercices liste des exercices
     * @param menuEleve interface du menu eleve
     */
    public controllerTableExEleveProf(JTable jtable, ArrayList<Tentative> tentatives, MenuProfesseur menuProf) {
	this.jtable = jtable;
	this.tentatives = tentatives;
	this.menuProf = menuProf;
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
           Tentative selectTentatives = tentatives.get(jtable.convertRowIndexToModel(selectligne));
           System.out.println("La ligne"+ selectTentatives.toString()+" est sélectionnée");
           
           menuProf.afficheInfoTentativeProf(selectTentatives); //effectue les actions voulues, ici, fait apparaitre les boutons faire ou visualiser tentatives
        }
     
    }   

}
