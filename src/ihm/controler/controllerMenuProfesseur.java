package ihm.controler;
import ihm.view.AjoutExerciceProf;
import ihm.view.InterfaceDebut;
import ihm.view.ListeExercicesProf;
import ihm.view.MenuProfesseur;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * ControllerMenuProfesseur contient les ActionEvent des boutons du panel MenuProfesseur
 * Les Boutons du MenuProfesseur sont Créer Exercices, Modifier Exercice et Deconnexion
 * @author Group7
 */
public class controllerMenuProfesseur implements ActionListener {
    private MenuProfesseur monmenu;
    
    public controllerMenuProfesseur(MenuProfesseur menu){
        this.monmenu = menu;
    }
    
    @Override
    public void actionPerformed (ActionEvent e) {
                //ActionEvent pour le bouton Déconnexion: réoriente vers InterfaceDebut
                if (e.getSource() == monmenu.getDeconnexion()) {
                    InterfaceDebut app = new InterfaceDebut();
                }
                //ActionEvent pour le bouton "Créer Exercice" qui 
                //change le panel pour celui de AjoutExerciceProf
                if (e.getSource() == monmenu.getCreerExercice()){
                    monmenu.getPanDroite().remove(monmenu.getpanHaut());
                    monmenu.getPanDroite().remove(monmenu.getpanExercice());
                    monmenu.getPanGeneral().remove(monmenu.getPanDroite());
                    monmenu.getPanDroite().add(monmenu.getPanCreer());
                    monmenu.getPanGeneral().add(monmenu.getPanCreer(),BorderLayout.CENTER);
                    monmenu.repaint();
                    monmenu.validate(); 
                }
                //ActionEvent pour le bouton "Modifier Exercice" qui
                //change le panel pour celui de ListeExercicesProf
                if (e.getSource() == monmenu.getModifierExercice()){                  
                    monmenu.getPanDroite().remove(monmenu.getpanHaut());
                    monmenu.getPanDroite().remove(monmenu.getpanExercice());
                    monmenu.getPanGeneral().remove(monmenu.getPanDroite());
                    monmenu.getPanDroite().add(monmenu.getpanliste());
                    monmenu.getPanGeneral().add(monmenu.getPanDroite(),BorderLayout.CENTER);
                    monmenu.repaint();
                    monmenu.validate();                    
                }
                
    }
}
