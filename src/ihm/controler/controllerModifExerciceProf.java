package ihm.controler;

import ihm.view.*;
import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

/**
 * ControllerModifExerciceProf contient les ActionEvent des boutons du panel ModifExerciceProf
 * Les Boutons du ModifExerciceProf sont Valider et Menu
 * @author Group 7
 */
public class controllerModifExerciceProf implements ActionListener  {
    
     private ModifExerciceProf monmenu;     
     
      public controllerModifExerciceProf(ModifExerciceProf menu){
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
