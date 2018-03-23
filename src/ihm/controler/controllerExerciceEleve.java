package ihm.controler;

import ihm.model.Classe;
import ihm.model.Eleve;
import ihm.model.Exercice;
import ihm.view.MenuEleve;
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
public class controllerExerciceEleve implements ListSelectionListener{
    
    private JTable jtable;
    private ArrayList<Exercice> exercices;
    private MenuEleve menuEleve;

    /**
     * Constructeur du controller pour la jtable des exercices dans le menu élève
     * @param jtable la jtable regroupant les différents exercices
     * @param exercices liste des exercices
     * @param menuEleve interface du menu eleve
     */
    public controllerExerciceEleve(JTable jtable, ArrayList<Exercice> exercices, MenuEleve menuEleve) {
	this.jtable = jtable;
	this.exercices = exercices;
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
           Exercice selectExercice = exercices.get(jtable.convertRowIndexToModel(selectligne));
           System.out.println("La ligne"+ selectExercice.toString()+" est sélectionnée");
           menuEleve.afficheInfo(selectExercice); //effectue les actions voulues
        }
     
    }   

}
