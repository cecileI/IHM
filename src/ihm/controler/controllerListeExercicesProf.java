package ihm.controler;

import ihm.view.*;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * ControllerListeExerciceProf permet de gérer les actions sur les boutons de la page des exercices avant modification
 * @author Group 7
 */
public class controllerListeExercicesProf implements ActionListener  {
    private ListeExercicesProf monmenu;     
     
      public controllerListeExercicesProf(ListeExercicesProf menu){
        this.monmenu = menu;
    }

    public void actionPerformed (ActionEvent e) {
        
        //JButton Menu: ouvre le panel du MenuProfesseur à la place du panel AjoutExerciceProf(retour au Menu)
        if (e.getSource() == monmenu.getRetourMenu()){
            MenuProfesseur menuProf = new MenuProfesseur();
            monmenu.remove(monmenu.getPanelDroite());
            monmenu.add(menuProf);      
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