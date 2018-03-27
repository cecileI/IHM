package ihm.controler;

import ihm.view.*;
import java.awt.BorderLayout;

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
        
        //JButton Menu: ouvre le panel du MenuProfesseur à la place du panel AjoutExerciceProf(retour au Menu)
        if (e.getSource() == monmenu.getMenu()){
            monmenu.getPanelHaut().remove(monmenu.getPanelHaut());
            monmenu.getGauche().remove(monmenu.getGauche());
            monmenu.getCentre().remove(monmenu.getCentre());
            monmenu.getDroite().remove(monmenu.getDroite());
            monmenu.getBas().remove(monmenu.getBas());
            //monmenu.add(monmenu.getPanDroite(),BorderLayout.CENTER);           
            monmenu.repaint();
            monmenu.validate();
        }
        //}else if(e.getSource()==monmenu.getFaireTentative()){
            //getEleve
            //TentativeEleve tent = new TentativeEleve(Eleve);       
    }
}
