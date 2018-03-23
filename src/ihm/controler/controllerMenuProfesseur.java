package ihm.controler;

import ihm.view.AjoutExerciceProf;
import ihm.view.InterfaceDebut;
import ihm.view.ListeExercicesProf;
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
    private ListeExercicesProf listexercice;
    
    public controllerMenuProfesseur(MenuProfesseur menu){
        this.monmenu = menu;
    }
    
    public controllerMenuProfesseur(ListeExercicesProf listexercice){
        this.listexercice = listexercice;
    }
    
    public void actionPerformed (ActionEvent e) {
                // le bouton déconnexion réoriente vers InterfaceDebut
                if (e.getSource() == monmenu.getDeconnexion()) {
                    InterfaceDebut app = new InterfaceDebut();
                }
                if (e.getSource() == monmenu.getcreerExercice()){
                    monmenu.getpanDroite().remove(monmenu.getpanHaut());
                    monmenu.getpanDroite().remove(monmenu.getpanExercice());
                    monmenu.getpanGeneral().remove(monmenu.getpanDroite());
                    monmenu.getpanDroite().add(monmenu.getPanCreer());
                    monmenu.getpanGeneral().add(monmenu.getPanCreer(),BorderLayout.CENTER);
                    monmenu.repaint();
                    monmenu.validate(); 
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
    
//    public void modif (ActionEvent e) {
//                if (e.getSource() == listexercice.getModifierEx()){
//                    //listexercice.getPanelHaut().remove(listexercice.getPanelHaut());
//                    //listexercice.getListeEx().remove(listexercice.getListeEx());
//                    listexercice.getPanelHaut().add(listexercice.getPanmodif(),BorderLayout.CENTER);
//                    listexercice.repaint();
//                    listexercice.validate();
//                }
//    }
}
