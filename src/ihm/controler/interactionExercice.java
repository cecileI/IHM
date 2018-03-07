/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ihm.controler;

import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import ihm.model.*;
import ihm.view.View;
/**
 *
 * @author Group7
 */
public class interactionExercice /*implements ListSelectionListener*/ { 
  private View view;
  private Exercice exo;

  
  public interactionExercice (View view,  Exercice exercice) {
          this.view = view;
          this.exo = exercice;
  }
    public void CreateExercice (ListSelectionEvent e) {
        
    }
    
   /* public void valueChanged(ListSelectionEvent e) {
        if (e.getValueIsAdjusting())
            return;
        ListSelectionModel selectmodel = (ListSelectionModel) e.getSource();
        if (selectmodel.isSelectionEmpty()){
            System.out.println("Pas de ligne selectionnée"); 
        }
        else {
            int selectligne = selectmodel.getMinSelectionIndex();
           Eleve selecteleve = classe.get(jtable.convertRowIndexToModel(selectligne));
           System.out.println("La ligne"+ selecteleve.toString()+" n'est pas sélectionnée"); 
           view.afficheInfo(selecteleve);
        }
    }*/
}

