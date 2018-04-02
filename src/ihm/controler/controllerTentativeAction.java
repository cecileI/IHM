package ihm.controler;

import ihm.view.MenuEleve;
import ihm.view.TentativeEleve;
import ihm.view.VisuTentativeEleve;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This Controller allows us to execute an action when user click on button in TentativeEleve.
 * @author Group 7
 */
public class controllerTentativeAction implements ActionListener{
    
    private VisuTentativeEleve tentativeEleve;
    
    public controllerTentativeAction(VisuTentativeEleve tentativeEleve){
        this.tentativeEleve = tentativeEleve;
    }
    
    @Override
    public void actionPerformed (ActionEvent e) {
        
        //Ne concerne pas les tortues
        if (e.getSource()==tentativeEleve.getRetourMenu()){ //en appuyant sur le bouton menu
            MenuEleve interfaceEleve = new MenuEleve(tentativeEleve.getCurrentEleve());
            tentativeEleve.remove(tentativeEleve.getGeneral());
            tentativeEleve.add(interfaceEleve);
            tentativeEleve.repaint();
            tentativeEleve.validate();
            
        }
        
    }
    
}
