package ihm.controler;

import ihm.view.AjoutExerciceProf;
import ihm.view.InterfaceDebut;
import ihm.view.MenuProfesseur;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Group7
 */
public class controllerMenuProfesseur implements ActionListener {
    private MenuProfesseur monmenu;
    
    public controllerMenuProfesseur(MenuProfesseur menu){
        this.monmenu = menu;
    }
    
    public void actionPerformed (ActionEvent e) {
                // le bouton déconnexion réoriente vers InterfaceDebut
                if (e.getSource() == monmenu.getDeconnexion()) {
                    InterfaceDebut app = new InterfaceDebut();
                }
                if (e.getSource() == monmenu.getcreerExercice()){
                    AjoutExerciceProf app = new AjoutExerciceProf();
                }
                if (e.getSource() == monmenu.getmodifierExercice()){                  
                    monmenu.getpanDroite().remove(monmenu.getpanHaut());
                    monmenu.getpanDroite().remove(monmenu.getpanExercice());
                    monmenu.getpanGeneral().remove(monmenu.getpanDroite());
                    monmenu.getpanDroite().add(monmenu.getpanliste());
                    monmenu.getpanGeneral().add(monmenu.getpanDroite(),BorderLayout.CENTER);
                    monmenu.repaint();
                    monmenu.validate();                    
                }
    }
}
