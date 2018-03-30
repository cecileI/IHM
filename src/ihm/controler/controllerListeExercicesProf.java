package ihm.controler;

import ihm.view.*;
import java.awt.BorderLayout;
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

    public void actionPerformed (ActionEvent e) {
        
        //JButton Menu: ouvre le panel du MenuProfesseur à la place du panel AjoutExerciceProf(retour au Menu)
        if (e.getSource() == monmenu.getRetourMenu()){
            //monmenu.remove(monmenu.getPanelDroite());
            monmenu.getPanelDroite().remove(monmenu.getPanelHaut());
            monmenu.getPanelDroite().remove(monmenu.getListeEx());
            //monmenu.getPanelDroite().add(monmenu.getPanmodif());         
            monmenu.repaint();
            monmenu.validate();
                
        }else if(e.getSource()==monmenu.getModifierEx()){                        
            monmenu.getPanelDroite().remove(monmenu.getListeEx());
            monmenu.getPanelDroite().remove(monmenu.getPanelHaut());
            
            //monmenu.remove(monmenu.getPanelDroite());
            //monmenu.add(monmenu.getPanmodif());
            //monmenu.getPanelDroite().add(monmenu.getPanmodif());
            //monmenu.getPanelDroite().remove(monmenu.getPanelHaut());
            //monmenu.getPanelDroite().remove(monmenu.getListeEx());
//            monmenu.getPanelDroite().add(monmenu.getPanmodif());
                     
            monmenu.repaint();
            monmenu.validate();      
        }
    }
}