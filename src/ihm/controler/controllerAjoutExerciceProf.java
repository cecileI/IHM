package ihm.controler;

import ihm.view.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * ControllerAjoutExerciceProf contient les ActionEvent des boutons du panel AjoutExerciceProf
 * Les Boutons de AjoutExerciceProf sont Valider et Menu
 * @author Diane
 */
public class controllerAjoutExerciceProf implements ActionListener {
    private AjoutExerciceProf monmenu;     
     
      public controllerAjoutExerciceProf(AjoutExerciceProf menu){
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
