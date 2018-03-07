/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ihm.view;

import ihm.model.*;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author Group7
 */
public class ViewControllerCall {
    private Eleve currentEleve;
    private Classe currentClasse;
    
    
    /*
    * Cette fonction est appelée apres avoir cliqué sur un élément dans le JTree
    * La fenetre est mise a jour en fonction de l'élément choisi (Eleve ou Classe)
    * @param selected Node : l'élément choisi dans l'arbre
    */
    public void controllerJTreeCall(Object selectedNode){
        if (selectedNode instanceof Eleve) { //si l'élément choisi est un élève
            currentEleve = (Eleve)selectedNode; //l'élève courant est celui sélectionné
            currentClasse = (Classe) currentEleve.getClasse(); //la classe courante est celle de l'élève sélectionné
            //update();//mis à jour
            
        }else if(selectedNode instanceof Classe){ //si l'élément choisi est une classe
            currentEleve = null; //il n'y a pas d'élève courant
            currentClasse = (Classe)selectedNode; // la classe courante est celle sélectionnée
            //update(); //mis à jour
            
        }else{
            System.out.println("Erreur");
        }
    }
    
    
    
    
    
    
}
