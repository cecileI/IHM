package ihm.controler;

import ihm.view.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * ControllerListeExerciesProf contient les ActionEvent des boutons du panel ListeExerciesProf
 * Les Boutons de ListeExerciesProf sont Modifier Exercice et Menu
 * @author Diane
 */
public class controllerListeExercicesProf implements ActionListener  {
    
     private ListeExercicesProf monmenu;     
     
      public controllerListeExercicesProf(ListeExercicesProf menu){
        this.monmenu = menu;
    }

   @Override
    public void actionPerformed (ActionEvent e) {
        
        //if (e.getSource()== monmenu.getDeconnexion()){
            InterfaceDebut interfaceDebut = new InterfaceDebut();            
        //}else if(e.getSource()==monmenu.getFaireTentative()){
            //getEleve
            //TentativeEleve tent = new TentativeEleve(Eleve);       
    }
}
