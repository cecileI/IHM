package ihm.controler;
import ihm.view.AjoutExerciceProf;
import ihm.view.InterfaceDebut;
import ihm.view.ListeExercicesProf;
import ihm.view.MenuProfesseur;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

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
                if (e.getSource() == monmenu.getMenu()){
                    monmenu.remove(monmenu.getPanGeneral());
                    monmenu.getpanHaut().remove(monmenu.getMenu());
                    monmenu.getpanHaut().remove(monmenu.getTxtNom());
                    monmenu.getpanHaut().remove(monmenu.getTxtPrenom());
                    monmenu.getpanExercice().remove(monmenu.getTableExEleveProf());
                    
                    JLabel blanc0 = new JLabel("");
                    blanc0.setHorizontalAlignment(SwingConstants.CENTER);
                    JLabel blanc1 = new JLabel("");
                    blanc1.setHorizontalAlignment(SwingConstants.CENTER);
                    JLabel blanc2 = new JLabel("");
                    blanc2.setHorizontalAlignment(SwingConstants.CENTER);
                    JLabel blanc3 = new JLabel("");
                    blanc3.setHorizontalAlignment(SwingConstants.CENTER);
                    JLabel blanc4 = new JLabel("");
                    blanc4.setHorizontalAlignment(SwingConstants.CENTER);
                    JLabel blanc5 = new JLabel("");
                    blanc5.setHorizontalAlignment(SwingConstants.CENTER);
                    JLabel blanc6 = new JLabel("");
                    blanc6.setHorizontalAlignment(SwingConstants.CENTER);  
                    
                    monmenu.getpanHaut().add(blanc0,BorderLayout.CENTER);
                    monmenu.getpanHaut().add(monmenu.getDeconnexion(), BorderLayout.EAST);
                    monmenu.getpanExercice().add(blanc1);
                    monmenu.getpanExercice().add(blanc2);
                    monmenu.getpanExercice().add(monmenu.getCreerExercice());
                    monmenu.getpanExercice().add(monmenu.getModifierExercice());
                    monmenu.getpanExercice().add(blanc3);
                    monmenu.getpanExercice().add(blanc4);
                    monmenu.getpanExercice().add(blanc5);
                    monmenu.getpanExercice().add(blanc6);
                    monmenu.add(monmenu.getPanGeneral());
                    monmenu.repaint();
                    monmenu.validate(); 
                }
                //ActionEvent pour le bouton "Créer Exercice" qui 
                //change le panel pour celui de AjoutExerciceProf
                if (e.getSource() == monmenu.getCreerExercice()){
                    monmenu.remove(monmenu.getPanGeneral());
                    AjoutExerciceProf ajoutExProf = new AjoutExerciceProf();
                    monmenu.add(ajoutExProf);
                    monmenu.repaint();
                    monmenu.validate(); 
                }
                //ActionEvent pour le bouton "Modifier Exercice" qui
                //change le panel pour celui de ListeExercicesProf
                if (e.getSource() == monmenu.getModifierExercice()){                  
                    monmenu.remove(monmenu.getPanGeneral());
                    ListeExercicesProf listExProf = new ListeExercicesProf();
                    monmenu.add(listExProf);
                    monmenu.repaint();
                    monmenu.validate();                    
                }
                
    }
}
